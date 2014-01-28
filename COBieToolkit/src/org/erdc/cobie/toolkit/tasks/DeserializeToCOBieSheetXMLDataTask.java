package org.erdc.cobie.toolkit.tasks;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import nl.fountain.xelem.excel.Workbook;

import org.apache.xmlbeans.XmlException;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.ifc2x3tc1.IfcObjectDefinition;
import org.bimserver.models.ifc2x3tc1.IfcPropertySetDefinition;
import org.bimserver.models.ifc2x3tc1.IfcRelAssociatesClassification;
import org.bimserver.models.ifc2x3tc1.IfcRoot;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.Deserializer;
import org.bimserver.plugins.objectidms.ObjectIDM;
import org.bimserver.plugins.serializers.SerializerException;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.erdc.cobie.shared.COBieTaskProgress;
import org.erdc.cobie.shared.Informable;
import org.erdc.cobie.shared.PluginUtilities.OutgingFileType;
import org.erdc.cobie.shared.cobiesheetxmldata.COBieFactory;
import org.erdc.cobie.sheetxmldata.COBIEDocument;
import org.erdc.cobie.sheetxmldata.COBIEType;
import org.erdc.cobie.toolkit.CobieToolkit;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class DeserializeToCOBieSheetXMLDataTask extends ApplicationTask<COBIEDocument>
{
    private static final String SHEET_STATUS_SUFFIX = " Populated";
    private static final String SPARE_DONE_MESSAGE = "Spares" + SHEET_STATUS_SUFFIX;
    private static final String RESOURCE_DONE_MESSAGE = "Resources" + SHEET_STATUS_SUFFIX;
    private static final String JOB_DONE_MESSAGE = "Jobs" + SHEET_STATUS_SUFFIX;
    private static final String ISSUE_DONE_MESSAGE = "Issues" + SHEET_STATUS_SUFFIX;
    private static final String IMPACT_DONE_MESSAGE = "Impacts" + SHEET_STATUS_SUFFIX;
    private static final String COORDINATE_DONE_MESSAGE = "Coordinates" + SHEET_STATUS_SUFFIX;
    private static final String LOADING_IFC_MESSAGE = "Loading Ifc";
    private static final String DERIVING_COBIE_XML_MESSAGE = "Transforming to COBie";
    private static final String EVERYTHING_DONE_MESSAGE = "Done loading COBie";
    private static final String ATTRIBUTE_DONE_MESSAGE = "Attributes" + SHEET_STATUS_SUFFIX;
    private static final String ZONE_DONE_MESSAGE = "Zones" + SHEET_STATUS_SUFFIX;
    private static final String TYPE_DONE_MESSAGE = "Types" + SHEET_STATUS_SUFFIX;
    private static final String SYSTEM_DONE_MESSAGE = "Systems" + SHEET_STATUS_SUFFIX;
    private static final String SPACE_DONE_MESSAGE = "Spaces" + SHEET_STATUS_SUFFIX;
    private static final String INITIALIZE_DONE_MESSAGE = "parsed spreadsheet XML";
    private static final String FLOOR_DONE_MESSAGE = "Floors";
    private static final String FACILITY_DONE_MESSAGE = "Facilities" + SHEET_STATUS_SUFFIX;
    private static final String DOCUMENT_DONE_MESSAGE = "Documents" + SHEET_STATUS_SUFFIX;
    private static final String CONTACT_DONE_MESSAGE = "Contacts" + SHEET_STATUS_SUFFIX;
    private static final String CONNECTION_DONE_MESSAGE = "Connections" + SHEET_STATUS_SUFFIX;
    private static final String COMPONENT_DONE_MESSAGE = "Components" + SHEET_STATUS_SUFFIX;
    private static final String ASSEMBLIES_DONE_MESSAGE = "Assemblies" + SHEET_STATUS_SUFFIX;
    private static final String TASK_DONE_MESSAGE = "COBieSheetXMLData loaded";
    private static final String OPERATION_CANCELED_MESSAGE = "Operation canceled";
    private static final String COBIE_TO_MEMORY_ERROR_MESSAGE = "An error occured while transforming COBie";

    private static final String PROGRESS_MESSAGE_STARTING = "Starting";
    public static final String PROPERTY_NAME_PROGRESS = "progress";
    private InputStream cobieSheetXMLDataFile;
    private File inputFile;
    private OutgingFileType inputFileType;
    private CobieToolkit cobieToolkit;
    private TaskStep deserializeState;

    private Workbook xlWorkbook = null;;

    public DeserializeToCOBieSheetXMLDataTask(final CobieToolkit cobieToolkit, OutgingFileType fileType, File inputFile, Informable informable,
            boolean requiresRunningBiMServer)
    {
        super(informable, requiresRunningBiMServer);
        this.inputFile = inputFile;
        inputFileType = fileType;
        this.cobieToolkit = cobieToolkit;
    }

    private void applyIDMFilter(IfcModelInterface model)
    {
        try
        {
            ObjectIDM objectIDM = cobieToolkit.getObjectIDM();
            if (objectIDM != null)
            {
                ArrayList<IdEObject> removeTheseObjects = new ArrayList<IdEObject>();
                for (long key : model.getObjects().keySet())
                {
                    IdEObject candidateObject = model.get(key);
                    boolean shouldIncludeObject = objectIDM.shouldIncludeClass(candidateObject.eClass(), candidateObject.eClass());
                    for (EStructuralFeature feature : candidateObject.eClass().getEAllStructuralFeatures())
                    {
                        boolean shouldFollowReference = objectIDM.shouldFollowReference(candidateObject.eClass(), candidateObject.eClass(), feature);
                        if (!shouldFollowReference)
                        {
                            candidateObject.eUnset(feature);
                        }
                    }
                    if (!shouldIncludeObject)
                    {
                        removeTheseObjects.add(candidateObject);
                    }
                }
                for (IdEObject ideObject : removeTheseObjects)
                {
                    model.remove(ideObject);
                }
            }

        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    @Override
    protected COBIEDocument doInBackground() throws Exception
    {
        COBIEDocument cobie = null;
        try
        {

            super.publish(new COBieTaskProgress(PROGRESS_MESSAGE_STARTING));
            super.setProgress(1);
            cobie = getCOBieFromFile(inputFile);
            publish(TaskStep.Done);
            super.sleep();
        } catch (Exception e)
        {
            e.printStackTrace();
            handleExecutionException(new COBieTaskProgress(COBIE_TO_MEMORY_ERROR_MESSAGE));
        }

        return cobie;
    }

    @Override
    protected void done()
    {
        if (isCancelled())
        {
            setProgress(0);
            publish(new COBieTaskProgress(OPERATION_CANCELED_MESSAGE));
        } else
        {
            setProgress(100);
            publish(new COBieTaskProgress(TASK_DONE_MESSAGE));
        }
        super.done();
    }

    private COBIEDocument getCOBieFromFile(File spreadsheetMLCOBieFile) throws ParserConfigurationException, SAXException, IOException, XmlException,
            DeserializeException, SerializerException, PluginException
    {
        COBIEDocument cobieDocument = COBIEDocument.Factory.newInstance();
        switch (inputFileType)
        {
            case COBie:
                cobieDocument = handleSpreadsheetXML();
                break;
            case COBieSheetXMLData:
                cobieDocument = handleCOBieDocument();
                break;
            case Ifc:
                cobieDocument = handleIfcDocument();
                break;
            case IfcXML:
                cobieDocument = handleIfcXMLDocument();
                break;
            default:
                break;

        }

        return cobieDocument;
    }

    public InputStream getCOBieSheetXMLDataFile()
    {
        return cobieSheetXMLDataFile;
    }

    public CobieToolkit getCobieToolkit()
    {
        return cobieToolkit;
    }

    public TaskStep getDeserializeState()
    {
        return deserializeState;
    }

    private COBIEDocument handleCOBieDocument() throws XmlException, IOException
    {
        setProgress(1);
        publish(TaskStep.DerivingCOBieSheetXMLData);
        COBIEDocument cobieDocument = COBIEDocument.Factory.parse(inputFile);
        setProgress(100);
        return cobieDocument;
    }

    private COBIEDocument handleIfcDocument() throws FileNotFoundException, DeserializeException, SerializerException, PluginException
    {
        return handleIfcDocument(cobieToolkit.getIfcStepDeserializer());
    }

    private COBIEDocument handleIfcDocument(Deserializer deserializer) throws FileNotFoundException, DeserializeException, SerializerException
    {
        setProgress(10);
        publish(TaskStep.ReadingIfc);
        IfcModelInterface model = deserializer.read(new FileInputStream(inputFile), inputFile.getName(), inputFile.length());
        applyIDMFilter(model);
        setClassificationInverseSlots(model);
        publish(TaskStep.DerivingCOBieSheetXMLData);
        setProgress(50);
        COBieFactory cobieFactory = new COBieFactory();
        COBIEDocument cobie = cobieFactory.parse(model);
        setProgress(100);
        return cobie;
    }

    private COBIEDocument handleIfcXMLDocument() throws FileNotFoundException, DeserializeException, SerializerException
    {
        return handleIfcDocument(cobieToolkit.getIfcXMLDeserializer());
    }

    private COBIEDocument handleSpreadsheetXML() throws ParserConfigurationException, SAXException, IOException
    {

        initializeXLWorkBook(inputFile);
        publish(TaskStep.InitializeXLWorkbook);
        setProgress(5);
        COBIEDocument cobieDocument = COBIEDocument.Factory.newInstance();
        COBIEType cobie = cobieDocument.addNewCOBIE();
        ThreadedSpreadsheetParser parser = new ThreadedSpreadsheetParser(xlWorkbook, cobie, this.cobieToolkit.getCobieStringHandler(), this);
        parser.parse();
        setProgress(100);
        return cobieDocument;

    }

    private void initializeXLWorkBook(File spreadSheetMLCOBieFile) throws ParserConfigurationException, SAXException, IOException
    {
        InputSource inSrc = new InputSource(new FileInputStream(spreadSheetMLCOBieFile));
        nl.fountain.xelem.lex.ExcelReader rdr = new nl.fountain.xelem.lex.ExcelReader();
        xlWorkbook = rdr.getWorkbook(inSrc);
    }

    protected void publish(TaskStep taskStep)
    {
        switch (taskStep)
        {
            case Assembly:
                setDeserializeState(TaskStep.Assembly);
                publish(new COBieTaskProgress(ASSEMBLIES_DONE_MESSAGE));

                break;
            case Component:
                setDeserializeState(TaskStep.Component);
                publish(new COBieTaskProgress(COMPONENT_DONE_MESSAGE));
                break;
            case Connection:
                setDeserializeState(TaskStep.Connection);
                publish(new COBieTaskProgress(CONNECTION_DONE_MESSAGE));
                break;
            case Contact:
                setDeserializeState(TaskStep.Contact);
                publish(new COBieTaskProgress(CONTACT_DONE_MESSAGE));
                break;
            case Document:
                setDeserializeState(TaskStep.Document);
                publish(new COBieTaskProgress(DOCUMENT_DONE_MESSAGE));
                break;
            case Facility:
                setDeserializeState(TaskStep.Facility);
                publish(new COBieTaskProgress(FACILITY_DONE_MESSAGE));
                break;
            case Floor:
                setDeserializeState(TaskStep.Floor);
                publish(new COBieTaskProgress(FLOOR_DONE_MESSAGE));
                break;
            case InitializeXLWorkbook:
                setDeserializeState(TaskStep.InitializeXLWorkbook);
                publish(new COBieTaskProgress(INITIALIZE_DONE_MESSAGE));
                break;
            case Space:
                setDeserializeState(TaskStep.Space);
                publish(new COBieTaskProgress(SPACE_DONE_MESSAGE));
                break;
            case System:
                setDeserializeState(TaskStep.System);
                publish(new COBieTaskProgress(SYSTEM_DONE_MESSAGE));
                break;
            case Type:
                setDeserializeState(TaskStep.Type);
                publish(new COBieTaskProgress(TYPE_DONE_MESSAGE));
                break;
            case Zone:
                setDeserializeState(TaskStep.Zone);
                publish(new COBieTaskProgress(ZONE_DONE_MESSAGE));
                break;
            case Attribute:
                setDeserializeState(TaskStep.Attribute);
                publish(new COBieTaskProgress(ATTRIBUTE_DONE_MESSAGE));
                break;
            case Done:
                setDeserializeState(TaskStep.Done);
                publish(new COBieTaskProgress(EVERYTHING_DONE_MESSAGE));
                break;
            case DerivingCOBieSheetXMLData:
                setDeserializeState(TaskStep.DerivingCOBieSheetXMLData);
                publish(new COBieTaskProgress(DERIVING_COBIE_XML_MESSAGE));
                break;
            case ReadingIfc:
                setDeserializeState(TaskStep.ReadingIfc);
                publish(new COBieTaskProgress(LOADING_IFC_MESSAGE));
                break;
            case Coordinate:
                setDeserializeState(TaskStep.Coordinate);
                publish(new COBieTaskProgress(COORDINATE_DONE_MESSAGE));
                break;
            case Impact:
                setDeserializeState(TaskStep.Impact);
                publish(new COBieTaskProgress(IMPACT_DONE_MESSAGE));
                break;
            case Issue:
                setDeserializeState(TaskStep.Issue);
                publish(new COBieTaskProgress(ISSUE_DONE_MESSAGE));
                break;
            case Job:
                setDeserializeState(TaskStep.Job);
                publish(new COBieTaskProgress(JOB_DONE_MESSAGE));
                break;
            case Resource:
                setDeserializeState(TaskStep.Resource);
                publish(new COBieTaskProgress(RESOURCE_DONE_MESSAGE));
                break;
            case Spare:
                setDeserializeState(TaskStep.Spare);
                publish(new COBieTaskProgress(SPARE_DONE_MESSAGE));
                break;
        }

        setProgress(Math.min(getProgress() + taskStep.getProgress(), 100));
    }

    private void setClassificationInverseSlots(IfcModelInterface model)
    {

        for (IfcRelAssociatesClassification classificationAssociation : model.getAllWithSubTypes(IfcRelAssociatesClassification.class))
        {
            for (IfcRoot relatedObject : classificationAssociation.getRelatedObjects())
            {
                if (relatedObject instanceof IfcPropertySetDefinition)
                {
                    try
                    {
                        IfcPropertySetDefinition propertySetDefinition = (IfcPropertySetDefinition)relatedObject;
                        if (!propertySetDefinition.getHasAssociations().contains(classificationAssociation))
                        {
                            propertySetDefinition.getHasAssociations().add(classificationAssociation);
                        }
                    } catch (Exception ex)
                    {

                    }
                } else if (relatedObject instanceof IfcObjectDefinition)
                {
                    try
                    {
                        IfcObjectDefinition objectDefinition = (IfcObjectDefinition)relatedObject;
                        if (!objectDefinition.getHasAssociations().contains(classificationAssociation))
                        {
                            ;
                        }
                        objectDefinition.getHasAssociations().add(classificationAssociation);
                    } catch (Exception ex)
                    {

                    }
                }

            }
        }
    }

    public void setCOBieSheetXMLDataFile(InputStream sheetXMLDataFile)
    {
        cobieSheetXMLDataFile = sheetXMLDataFile;
    }

    public void setCobieToolkit(CobieToolkit cobieToolkit)
    {
        this.cobieToolkit = cobieToolkit;

    }

    protected void setDeserializeState(TaskStep deserializeState)
    {
        this.deserializeState = deserializeState;
    }

}
