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
import org.erdc.cobie.plugins.utils.spreadsheetml.SpreadSheetToComponents;
import org.erdc.cobie.plugins.utils.spreadsheetml.SpreadSheetToSpares;
import org.erdc.cobie.plugins.utils.spreadsheetml.SpreadsheetToAssemblies;
import org.erdc.cobie.plugins.utils.spreadsheetml.SpreadsheetToAttributes;
import org.erdc.cobie.plugins.utils.spreadsheetml.SpreadsheetToConnections;
import org.erdc.cobie.plugins.utils.spreadsheetml.SpreadsheetToContacts;
import org.erdc.cobie.plugins.utils.spreadsheetml.SpreadsheetToCoordinates;
import org.erdc.cobie.plugins.utils.spreadsheetml.SpreadsheetToDocuments;
import org.erdc.cobie.plugins.utils.spreadsheetml.SpreadsheetToFacilities;
import org.erdc.cobie.plugins.utils.spreadsheetml.SpreadsheetToFloors;
import org.erdc.cobie.plugins.utils.spreadsheetml.SpreadsheetToImpacts;
import org.erdc.cobie.plugins.utils.spreadsheetml.SpreadsheetToIssues;
import org.erdc.cobie.plugins.utils.spreadsheetml.SpreadsheetToJobs;
import org.erdc.cobie.plugins.utils.spreadsheetml.SpreadsheetToResources;
import org.erdc.cobie.plugins.utils.spreadsheetml.SpreadsheetToSpaces;
import org.erdc.cobie.plugins.utils.spreadsheetml.SpreadsheetToSystems;
import org.erdc.cobie.plugins.utils.spreadsheetml.SpreadsheetToTypes;
import org.erdc.cobie.plugins.utils.spreadsheetml.SpreadsheetToZones;
import org.erdc.cobie.shared.COBieSharedUtilities.COBIE_FILE_TYPE;
import org.erdc.cobie.sheetxmldata.COBIEDocument;
import org.erdc.cobie.sheetxmldata.COBIEType;
import org.erdc.cobie.toolkit.CobieToolkit;
import org.erdc.cobie.utils.serializer.BIMServerCOBieSheetXMLDataSerializer;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class DeserializeToCOBieSheetXMLDataTask extends ApplicationTask<COBIEDocument> 
{
	private static final String SHEET_STATUS_SUFFIX = " Populated";
	private static final String SPARE_DONE_MESSAGE = "Spares"+SHEET_STATUS_SUFFIX;
	private static final String RESOURCE_DONE_MESSAGE = "Resources"+SHEET_STATUS_SUFFIX;
	private static final String JOB_DONE_MESSAGE = "Jobs"+SHEET_STATUS_SUFFIX;
	private static final String ISSUE_DONE_MESSAGE = "Issues"+SHEET_STATUS_SUFFIX;
	private static final String IMPACT_DONE_MESSAGE = "Impacts"+SHEET_STATUS_SUFFIX;
	private static final String COORDINATE_DONE_MESSAGE = "Coordinates"+SHEET_STATUS_SUFFIX;
	private static final String LOADING_IFC_MESSAGE = "Loading Ifc";
	private static final String DERIVING_COBIE_XML_MESSAGE = "Transforming to COBie";
	private static final String EVERYTHING_DONE_MESSAGE = "Done loading COBie";
	private static final String ATTRIBUTE_DONE_MESSAGE = "Attributes"+SHEET_STATUS_SUFFIX;
	private static final String ZONE_DONE_MESSAGE = "Zones"+SHEET_STATUS_SUFFIX;
	private static final String TYPE_DONE_MESSAGE = "Types"+SHEET_STATUS_SUFFIX;
	private static final String SYSTEM_DONE_MESSAGE = "Systems"+SHEET_STATUS_SUFFIX;
	private static final String SPACE_DONE_MESSAGE = "Spaces"+SHEET_STATUS_SUFFIX;
	private static final String INITIALIZE_DONE_MESSAGE = "parsed spreadsheet XML";
	private static final String FLOOR_DONE_MESSAGE = "Floors";
	private static final String FACILITY_DONE_MESSAGE = "Facilities"+SHEET_STATUS_SUFFIX;
	private static final String DOCUMENT_DONE_MESSAGE = "Documents"+SHEET_STATUS_SUFFIX;
	private static final String CONTACT_DONE_MESSAGE = "Contacts"+SHEET_STATUS_SUFFIX;
	private static final String CONNECTION_DONE_MESSAGE = "Connections"+SHEET_STATUS_SUFFIX;
	private static final String COMPONENT_DONE_MESSAGE = "Components"+SHEET_STATUS_SUFFIX;
	private static final String ASSEMBLIES_DONE_MESSAGE = "Assemblies"+SHEET_STATUS_SUFFIX;
	private static final String TASK_DONE_MESSAGE = "COBieSheetXMLData loaded";
	private static final String OPERATION_CANCELED_MESSAGE = "Operation canceled";
	private static final String COBIE_TO_MEMORY_ERROR_MESSAGE = "An error occured while transforming COBie";
	private static final String PROGRESS_MESSAGE_STARTING = "Starting";


	public enum TaskStep {Assembly,Attribute,Component,Connection,
		Contact,DerivingCOBieSheetXMLData,Document,Done,Job,Coordinate,Spare,Resource,
		Facility,Floor,InitializeXLWorkbook,ReadingIfc,Impact,Issue,
		Space,System,Type,Zone}
	public static final String PROPERTY_NAME_PROGRESS="progress";
	private COBIEDocument cobieDocument;
	private InputStream cobieSheetXMLDataFile;
	private File inputFile;
	private COBIE_FILE_TYPE inputFileType;
	private CobieToolkit cobieToolkit;
	private TaskStep deserializeState;
	
	private Workbook xlWorkbook = null;;
	
		
		public DeserializeToCOBieSheetXMLDataTask(final CobieToolkit cobieToolkit,COBIE_FILE_TYPE fileType,File inputFile,
				Informable informable,boolean requiresRunningBiMServer)
	{
		super(informable,requiresRunningBiMServer);
		this.inputFile = inputFile;
		inputFileType = fileType;
		this.cobieToolkit = cobieToolkit;
	}

	
	@Override
	protected COBIEDocument doInBackground() throws Exception
	{
		COBIEDocument cobie = null;
		try
		{
			
			super.publish(new COBieTaskProgress(PROGRESS_MESSAGE_STARTING));
			super.setProgress(1);
			cobie = getCOBieFromFile(this.inputFile);
		 	publish(TaskStep.Done);
		 	super.sleep();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			handleExecutionException(new COBieTaskProgress(COBIE_TO_MEMORY_ERROR_MESSAGE));
		}


	 	return cobie;
	}
	

    @Override
	protected void done()
	{
    	if(isCancelled())
    	{
    		this.setProgress(0);
    		publish(new COBieTaskProgress(OPERATION_CANCELED_MESSAGE));
    	}
    	else
    	{
    		this.setProgress(100);
    		publish(new COBieTaskProgress(TASK_DONE_MESSAGE));
    	}
    	super.done();
	}



	private COBIEDocument getCOBieFromFile(File spreadsheetMLCOBieFile) throws ParserConfigurationException, 
	SAXException, IOException, XmlException, DeserializeException, SerializerException, PluginException
	{
		COBIEDocument cobieDocument = COBIEDocument.Factory.newInstance();
		switch(inputFileType)
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

	private COBIEDocument handleCOBieDocument() throws XmlException, IOException
	{
		this.setProgress(1);
		publish(TaskStep.DerivingCOBieSheetXMLData);
		COBIEDocument cobieDocument =
				COBIEDocument.Factory.parse(inputFile);
		publish(TaskStep.Done);
		this.setProgress(100);
		return cobieDocument;
	}

	private COBIEDocument handleIfcDocument() throws FileNotFoundException, DeserializeException, SerializerException, PluginException
	{	
	    return handleIfcDocument(cobieToolkit.getIfcStepDeserializer());
	}
	
	private COBIEDocument handleIfcDocument(Deserializer deserializer) throws FileNotFoundException, DeserializeException, SerializerException
	{
	    this.setProgress(10);
        publish(TaskStep.ReadingIfc);
        IfcModelInterface model =
                deserializer.read(new FileInputStream(inputFile), inputFile.getName(), inputFile.length());
        applyIDMFilter(model);
        setClassificationInverseSlots(model);
        publish(TaskStep.DerivingCOBieSheetXMLData);
        this.setProgress(50);
        BIMServerCOBieSheetXMLDataSerializer cobieSheetXMLDataSerializer =
                cobieToolkit.getCOBieSheetXMLDataSerializer();
        cobieSheetXMLDataSerializer.init(model, cobieToolkit.getPluginManager());
        cobieSheetXMLDataSerializer.modelToCOBie();
        this.setProgress(100);
        publish(TaskStep.Done);
        return cobieSheetXMLDataSerializer.getCOBieDocument();
	}
	
	   private COBIEDocument handleIfcXMLDocument() throws FileNotFoundException, DeserializeException, SerializerException
	    {
	       return handleIfcDocument(cobieToolkit.getIfcXMLDeserializer());
	    }

	
	private void setClassificationInverseSlots(IfcModelInterface model)
	{
		
		for(IfcRelAssociatesClassification classificationAssociation:model.getAllWithSubTypes(IfcRelAssociatesClassification.class))
		{
			for(IfcRoot relatedObject:classificationAssociation.getRelatedObjects())
			{
				if(relatedObject instanceof IfcPropertySetDefinition)
				{
					try
					{
					    IfcPropertySetDefinition propertySetDefinition = (IfcPropertySetDefinition) relatedObject;
					    if(!propertySetDefinition.getHasAssociations().contains(classificationAssociation))
					        propertySetDefinition.getHasAssociations().add(classificationAssociation);
					}
					catch(Exception ex)
					{
						
					}
				}
				else if(relatedObject instanceof IfcObjectDefinition)
				{
				    try
				    {
				        IfcObjectDefinition objectDefinition = (IfcObjectDefinition) relatedObject;
				        if(!objectDefinition.getHasAssociations().contains(classificationAssociation));
				            objectDefinition.getHasAssociations().add(classificationAssociation);
				    }
				    catch(Exception ex)
				    {
				        
				    }
				}

			}
		}
	}
	
	private void applyIDMFilter(IfcModelInterface model)
	{
		try
		{
			ObjectIDM objectIDM = cobieToolkit.getObjectIDM();
			if(objectIDM!=null)
			{
				ArrayList<IdEObject> removeTheseObjects = new ArrayList<IdEObject>();
				for(long key:model.getObjects().keySet())
				{
					IdEObject candidateObject = model.get(key);
					boolean shouldIncludeObject = objectIDM.shouldIncludeClass(candidateObject.eClass(),candidateObject.eClass());
					for(EStructuralFeature feature:candidateObject.eClass().getEAllStructuralFeatures())
					{
						boolean shouldFollowReference =
								objectIDM.shouldFollowReference(candidateObject.eClass(),candidateObject.eClass(),feature);
						if(!shouldFollowReference)
							candidateObject.eUnset(feature);
					}
					if(!shouldIncludeObject)
						removeTheseObjects.add(candidateObject);
				}
				for(IdEObject ideObject:removeTheseObjects)
					model.remove(ideObject);
			}
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	private COBIEDocument handleSpreadsheetXML() throws ParserConfigurationException, SAXException, IOException
	{
		
		initializeXLWorkBook(inputFile);
		publish(TaskStep.InitializeXLWorkbook);
		this.setProgress(5);
		COBIEDocument cobieDocument = COBIEDocument.Factory.newInstance();
		COBIEType cobie = cobieDocument.addNewCOBIE();
		SpreadsheetToContacts.writeContactsToCOBie(cobie, this.xlWorkbook);
		publish(TaskStep.Contact);
		this.setProgress(10);
	 	SpreadsheetToFacilities.writeFacilitiesToCOBie(cobie,this.xlWorkbook);
	 	publish(TaskStep.Facility);
	 	this.setProgress(15);
	 	SpreadsheetToFloors.writeFloorsToCOBie(cobie,this.xlWorkbook);
	 	publish(TaskStep.Floor);
	 	this.setProgress(20);
	 	SpreadsheetToSpaces.writeSpacesToCOBie(cobie,this.xlWorkbook);
	 	publish(TaskStep.Space);
	 	this.setProgress(25);
	 	SpreadsheetToZones.writeZonesToCOBie(cobie, this.xlWorkbook);
	 	publish(TaskStep.Zone);
	 	this.setProgress(30);
	 	SpreadsheetToTypes.writeTypesToCOBie(cobie, this.xlWorkbook);
	 	publish(TaskStep.Type);
	 	this.setProgress(35);
	 	SpreadSheetToComponents.writeComponentsToCOBie
	 		(cobie, this.xlWorkbook);
	 	publish(TaskStep.Component);
	 	this.setProgress(40);
	 	SpreadsheetToSystems.writeSystemsToCOBie(cobie, this.xlWorkbook);
	 	publish(TaskStep.System);
	 	this.setProgress(45);
	 	SpreadsheetToAssemblies.writeAssembliesToCOBie(cobie,this.xlWorkbook);
	 	publish(TaskStep.Assembly);
	 	this.setProgress(50);
	 	SpreadsheetToConnections.writeConnectionsToCOBie(cobie, this.xlWorkbook);
	 	publish(TaskStep.Connection);
	 	this.setProgress(55);
	 	SpreadSheetToSpares.writeSparesToCOBie(cobie, xlWorkbook);
	 	publish(TaskStep.Spare);
	 	this.setProgress(60);
	 	SpreadsheetToResources.writeResourcesToCOBie(cobie, xlWorkbook);
	 	publish(TaskStep.Resource);
	 	this.setProgress(65);
	 	SpreadsheetToJobs.writeJobsToCOBie(cobie, xlWorkbook);
	 	publish(TaskStep.Job);
	 	this.setProgress(70);
	 	SpreadsheetToImpacts.writeImpactsToCOBie(cobie, xlWorkbook);
	 	this.setProgress(75);
	 	publish(TaskStep.Impact);
	 	this.setProgress(80);
	 	SpreadsheetToDocuments.writeDocumentsToCOBie(cobie, this.xlWorkbook);
	 	publish(TaskStep.Document);
	 	this.setProgress(85);
	 	SpreadsheetToAttributes.writeAttributesToCOBie(cobie, this.xlWorkbook);
	 	publish(TaskStep.Attribute);
	 	this.setProgress(90);
	 	SpreadsheetToCoordinates.writeCoordinatesToCOBie(cobie, xlWorkbook);
	 	publish(TaskStep.Coordinate);
	 	this.setProgress(95);
	 	SpreadsheetToIssues.writeIssuesToCOBie(cobie, xlWorkbook);
	 	publish(TaskStep.Issue);
	 	this.setProgress(100);	
	 	return cobieDocument;
		
	}

	private void initializeXLWorkBook(File spreadSheetMLCOBieFile) throws ParserConfigurationException, SAXException, IOException
	{
		InputSource inSrc = new InputSource(new FileInputStream(spreadSheetMLCOBieFile));
		nl.fountain.xelem.lex.ExcelReader rdr =
				new nl.fountain.xelem.lex.ExcelReader();
		xlWorkbook = rdr.getWorkbook(inSrc);
	}
	
	protected void publish(TaskStep taskStep)
	{
		switch(taskStep)
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
			publish (new COBieTaskProgress(COORDINATE_DONE_MESSAGE));
			break;
		case Impact:
			setDeserializeState(TaskStep.Impact);
			publish (new COBieTaskProgress(IMPACT_DONE_MESSAGE));
			break;
		case Issue:
			setDeserializeState(TaskStep.Issue);
			publish (new COBieTaskProgress(ISSUE_DONE_MESSAGE));
			break;
		case Job:
			setDeserializeState(TaskStep.Job);
			publish (new COBieTaskProgress(JOB_DONE_MESSAGE));
			break;
		case Resource:
			setDeserializeState(TaskStep.Resource);
			publish (new COBieTaskProgress(RESOURCE_DONE_MESSAGE));
			break;
		case Spare:
			setDeserializeState(TaskStep.Spare);
			publish (new COBieTaskProgress(SPARE_DONE_MESSAGE));
			break;
		}
	}

	public void setCOBieSheetXMLDataFile(InputStream sheetXMLDataFile)
	{
		this.cobieSheetXMLDataFile = sheetXMLDataFile;
	}


	public void setCobieToolkit(CobieToolkit cobieToolkit)
	{
		this.cobieToolkit = cobieToolkit;
		
	}


	public TaskStep getDeserializeState()
	{
		return deserializeState;
	}


	protected void setDeserializeState(TaskStep deserializeState)
	{
		this.deserializeState = deserializeState;
	}

}
