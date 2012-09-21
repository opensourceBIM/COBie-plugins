package org.bimserver.cobie.satellite.tasks;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JProgressBar;
import javax.xml.parsers.ParserConfigurationException;

import nl.fountain.xelem.excel.Workbook;

import org.apache.xmlbeans.XmlException;
import org.bimserver.cobie.cobielite.COBIEDocument;
import org.bimserver.cobie.cobielite.COBIEType;
import org.bimserver.cobie.plugins.COBieLiteSerializer;
import org.bimserver.cobie.satellite.CobieSatelliteServer;
import org.bimserver.cobie.utils.spreadsheetml.SpreadSheetToComponents;
import org.bimserver.cobie.utils.spreadsheetml.SpreadSheetToSpares;
import org.bimserver.cobie.utils.spreadsheetml.SpreadsheetToAssemblies;
import org.bimserver.cobie.utils.spreadsheetml.SpreadsheetToAttributes;
import org.bimserver.cobie.utils.spreadsheetml.SpreadsheetToConnections;
import org.bimserver.cobie.utils.spreadsheetml.SpreadsheetToContacts;
import org.bimserver.cobie.utils.spreadsheetml.SpreadsheetToCoordinates;
import org.bimserver.cobie.utils.spreadsheetml.SpreadsheetToDocuments;
import org.bimserver.cobie.utils.spreadsheetml.SpreadsheetToFacilities;
import org.bimserver.cobie.utils.spreadsheetml.SpreadsheetToFloors;
import org.bimserver.cobie.utils.spreadsheetml.SpreadsheetToImpacts;
import org.bimserver.cobie.utils.spreadsheetml.SpreadsheetToIssues;
import org.bimserver.cobie.utils.spreadsheetml.SpreadsheetToJobs;
import org.bimserver.cobie.utils.spreadsheetml.SpreadsheetToResources;
import org.bimserver.cobie.utils.spreadsheetml.SpreadsheetToSpaces;
import org.bimserver.cobie.utils.spreadsheetml.SpreadsheetToSystems;
import org.bimserver.cobie.utils.spreadsheetml.SpreadsheetToTypes;
import org.bimserver.cobie.utils.spreadsheetml.SpreadsheetToZones;
import org.bimserver.emf.IdEObject;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.step.deserializer.IfcStepDeserializer;
import org.bimserver.models.ifc2x3tc1.IfcPropertySet;
import org.bimserver.models.ifc2x3tc1.IfcRelAssociatesClassification;
import org.bimserver.models.ifc2x3tc1.IfcRoot;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.objectidms.ObjectIDM;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.shared.cobie.COBieSharedUtilities.COBIE_FILE_TYPE;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class DeserializeToCOBieLiteTask extends ApplicationTask<COBIEDocument> 
{
	private static final String PROGRESS_MESSAGE_STARTING = "Starting";


	public enum TaskStep {Assembly,Attribute,Component,Connection,
		Contact,DerivingCOBieLite,Document,Done,Job,Coordinate,Spare,Resource,
		Facility,Floor,InitializeXLWorkbook,ReadingIfc,Impact,Issue,
		Space,System,Type,Zone}
	public static final String PROPERTY_NAME_PROGRESS="progress";
	private COBIEDocument cobieDocument;
	private InputStream cobieLiteFile;
	private File inputFile;
	private COBIE_FILE_TYPE inputFileType;
	private CobieSatelliteServer satelliteServer;
	private TaskStep deserializeState;
	
	private Workbook xlWorkbook = null;;
	
		
		public DeserializeToCOBieLiteTask(final CobieSatelliteServer satelliteServer,COBIE_FILE_TYPE fileType,File inputFile,
				Informable informable,boolean requiresRunningBiMServer)
	{
		super(informable,requiresRunningBiMServer);
		this.inputFile = inputFile;
		inputFileType = fileType;
		this.satelliteServer = satelliteServer;
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
			handleExecutionException(new COBieTaskProgress("An error occured while transforming COBie to COBieLite"));
		}


	 	return cobie;
	}
	

    @Override
	protected void done()
	{
    	if(isCancelled())
    	{
    		this.setProgress(0);
    		publish(new COBieTaskProgress("Operation canceled"));
    	}
    	else
    	{
    		this.setProgress(100);
    		publish(new COBieTaskProgress("COBieLite loaded"));
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
		case COBieLite:
			cobieDocument = handleCOBieDocument();
			break;
		case Ifc:
			cobieDocument = handleIfcDocument();
			break;
		
		}

	 	return cobieDocument;
	}

	public InputStream getCobieLiteFile()
	{
		return cobieLiteFile;
	}


	public CobieSatelliteServer getSatelliteServer()
	{
		return satelliteServer;
	}

	private COBIEDocument handleCOBieDocument() throws XmlException, IOException
	{
		this.setProgress(1);
		publish(TaskStep.DerivingCOBieLite);
		COBIEDocument cobieDocument =
				COBIEDocument.Factory.parse(inputFile);
		publish(TaskStep.Done);
		this.setProgress(100);
		return cobieDocument;
	}

	private COBIEDocument handleIfcDocument() throws FileNotFoundException, DeserializeException, SerializerException, PluginException
	{
		//IfcStepDeserializer stepDeserializer =
				//satelliteServer.get

		
		this.setProgress(10);
		publish(TaskStep.ReadingIfc);
		IfcModelInterface model =
				satelliteServer.getIfcStepDeserializer().read(new FileInputStream(inputFile), inputFile.getName(), false, inputFile.length());
		
		applyIDMFilter(model);
		setClassificationPropertySetInverseSlots(model);
		publish(TaskStep.DerivingCOBieLite);
		this.setProgress(50);
		COBieLiteSerializer cobieLiteSerializer =
				satelliteServer.getCobieLiteSerializer();
		cobieLiteSerializer.init(model, satelliteServer.getPluginManager());
		cobieLiteSerializer.modelToCOBie();
		this.setProgress(100);
		publish(TaskStep.Done);
		return cobieLiteSerializer.getCOBieDocument();
	}
	
	private void setClassificationPropertySetInverseSlots(IfcModelInterface model)
	{
		
		for(IfcRelAssociatesClassification classificationAssociation:model.getAllWithSubTypes(IfcRelAssociatesClassification.class))
		{
			for(IfcRoot relatedObject:classificationAssociation.getRelatedObjects())
			{
				if(relatedObject instanceof IfcPropertySet)
				{
					try
					{
						((IfcPropertySet)relatedObject).getHasAssociations().add(classificationAssociation);
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
			ObjectIDM objectIDM = satelliteServer.getObjectIDM();
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
				publish(new COBieTaskProgress("populated COBieLite Assemblies"));
				break;
			case Component:
				setDeserializeState(TaskStep.Component);
				publish(new COBieTaskProgress("populated COBieLite Components"));
				break;
			case Connection:
				setDeserializeState(TaskStep.Connection);
				publish(new COBieTaskProgress("populated COBieLite Connections"));
				break;
			case Contact:
				setDeserializeState(TaskStep.Contact);
				publish(new COBieTaskProgress("populated COBieLite Contacts"));
				break;
			case Document:
				setDeserializeState(TaskStep.Document);
				publish(new COBieTaskProgress("populated COBieLite Documents"));
				break;
			case Facility:
				setDeserializeState(TaskStep.Facility);
				publish(new COBieTaskProgress("populated COBieLite Facilities"));
				break;
			case Floor:
				setDeserializeState(TaskStep.Floor);
				publish(new COBieTaskProgress("populated COBieLite Floors"));
				break;
			case InitializeXLWorkbook:
				setDeserializeState(TaskStep.InitializeXLWorkbook);
				publish(new COBieTaskProgress("parsed spreadsheet xml"));
				break;
			case Space:
				setDeserializeState(TaskStep.Space);
				publish(new COBieTaskProgress("populated COBieLite Spaces"));
				break;
			case System:
				setDeserializeState(TaskStep.System);
				publish(new COBieTaskProgress("populated COBieLite Systems"));
				break;
			case Type:
				setDeserializeState(TaskStep.Type);
				publish(new COBieTaskProgress("populated COBieLite Types"));
				break;
			case Zone:
				setDeserializeState(TaskStep.Zone);
				publish(new COBieTaskProgress("populated COBieLite Zones"));
				break;
			case Attribute:
				setDeserializeState(TaskStep.Attribute);
				publish(new COBieTaskProgress("populated COBieLite Attributes"));
				break;
			case Done:
				setDeserializeState(TaskStep.Done);
				publish(new COBieTaskProgress("Done importing COBie document"));
				break;
			case DerivingCOBieLite:
				setDeserializeState(TaskStep.DerivingCOBieLite);
				publish(new COBieTaskProgress("Parsing data into COBieLite Document"));
				break;
			case ReadingIfc:
				setDeserializeState(TaskStep.ReadingIfc);
				publish(new COBieTaskProgress("Loading Ifc into memory"));
				break;
		case Coordinate:
			setDeserializeState(TaskStep.Coordinate);
			publish (new COBieTaskProgress("populated COBieLite Coordinates"));
			break;
		case Impact:
			setDeserializeState(TaskStep.Impact);
			publish (new COBieTaskProgress("populated COBieLite Impacts"));
			break;
		case Issue:
			setDeserializeState(TaskStep.Issue);
			publish (new COBieTaskProgress("populated COBieLite Issues"));
			break;
		case Job:
			setDeserializeState(TaskStep.Job);
			publish (new COBieTaskProgress("populated COBieLite Jobs"));
			break;
		case Resource:
			setDeserializeState(TaskStep.Resource);
			publish (new COBieTaskProgress("populated COBieLite Resources"));
			break;
		case Spare:
			setDeserializeState(TaskStep.Spare);
			publish (new COBieTaskProgress("populated COBieLite Spares"));
			break;
		}
	}

	public void setCobieLiteFile(InputStream cobieLiteFile)
	{
		this.cobieLiteFile = cobieLiteFile;
	}


	public void setSatelliteServer(CobieSatelliteServer satelliteServer)
	{
		this.satelliteServer = satelliteServer;
		
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
