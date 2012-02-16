package org.bimserver.cobie.utils.deserializer;

import java.util.HashMap;
import java.util.Map;

import org.bimserver.cobie.cobielite.COBIEType;
import org.bimserver.cobie.plugins.COBieIfcModel;
import org.bimserver.cobie.plugins.COBieOidProviderImpl;
import org.bimserver.cobie.utils.COBieUtility;
import org.bimserver.cobie.utils.COBieUtility.CobieSheetName;
import org.bimserver.emf.IdEObject;
import org.bimserver.models.ifc2x3.Ifc2x3Factory;
import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class FromCOBieToIfc
{
	private static final Map<String, EClassifier> E_CLASSIFIERS = initClasses();
	private COBieIfcModel model;
	private COBIEType COBie;
	protected COBieOidProviderImpl CobieOidProvider;
	private ContactDeserializer contactDeserializer;
	private FacilityDeserializer facilityDeserializer;
	private FloorDeserializer floorDeserializer;
	private SpaceDeserializer spaceDeserializer;
	private IfcCommonHandler ifcCommonHandler;
	private TypeDeserializer typeDeserializer;
	private ComponentDeserializer componentDeserializer;
	private ConnectionDeserializer connectionDeserializer;
	private SystemDeserializer systemDeserializer;
	private AssemblyDeserializer assemblyDeserializer;
	private ZoneDeserializer zoneDeserializer;
	private static final Logger LOGGER = LoggerFactory.getLogger(FromCOBieToIfc.class);;
	private AttributeDeserializer attributeDeserializer;
	private static final String LOGGER_STATUS_FORMAT_STRING = "Deserializing %s.";
	private static final String LOGGER_STATUS_DONE_FORMAT_STRING = "Deserialized %d %s.";
	private static final String LOGGER_STATUS_XML_IFC_BEGIN_MSG = "Begin Deserializing COBieLite XML to IFC";
	private static final String LOGGER_STATUS_XML_IFC_END_MSG = "Done Deserializing COBieLite XML to IFC";
	public FromCOBieToIfc(COBIEType cobie)
	{
		init(cobie);
	}

	private void init(COBIEType cobie)
	{
		model = new COBieIfcModel();
		COBie = cobie;
		CobieOidProvider = new COBieOidProviderImpl(model);
		ifcCommonHandler = new IfcCommonHandler(model, CobieOidProvider);		
		contactDeserializer = new ContactDeserializer(cobie.getContacts(), model, ifcCommonHandler);
		facilityDeserializer = new FacilityDeserializer(model, ifcCommonHandler, cobie.getFacilities());
		floorDeserializer = new FloorDeserializer(model,cobie.getFloors(),ifcCommonHandler);
		spaceDeserializer = new SpaceDeserializer(model, ifcCommonHandler, cobie.getSpaces());
		typeDeserializer = new TypeDeserializer(model,ifcCommonHandler,cobie.getTypes());
		componentDeserializer = new ComponentDeserializer(model,ifcCommonHandler,cobie.getComponents());
		connectionDeserializer = new ConnectionDeserializer(model,ifcCommonHandler,cobie.getConnections());
		attributeDeserializer = new AttributeDeserializer(model,ifcCommonHandler,cobie.getAttributes());
		zoneDeserializer = new ZoneDeserializer(model,ifcCommonHandler,cobie.getZones());
		systemDeserializer = new SystemDeserializer(model,ifcCommonHandler,cobie.getSystems());
		assemblyDeserializer = new AssemblyDeserializer(model,ifcCommonHandler,cobie.getAssemblies());
	}
	

	private static Map<String, EClassifier> initClasses()
	{
		HashMap<String, EClassifier> classes = new HashMap<String, EClassifier>(
				Ifc2x3Package.eINSTANCE.getEClassifiers().size());
		for (EClassifier classifier : Ifc2x3Package.eINSTANCE.getEClassifiers())
		{
			classes.put(classifier.getName().toUpperCase(), classifier);
		}
		return classes;
	}

	public IfcModelInterface getModel()
	{
		return model;
	}

	public COBIEType getCOBie()
	{
		return COBie;
	}

	public COBieIfcModel getModelFromCOBie()
	{
		LOGGER.info(LOGGER_STATUS_XML_IFC_BEGIN_MSG);
		
		CobieSheetName currentSheetName = CobieSheetName.Contact;
		LOGGER.info(getDeserializerBeginMessage(currentSheetName));
		contactDeserializer.deserializeContacts();
		LOGGER.info(getDeserializerDoneMessage(currentSheetName));
		
		currentSheetName = CobieSheetName.Facility;
		LOGGER.info(getDeserializerBeginMessage(currentSheetName));
		facilityDeserializer.deserializeFacilities();
		LOGGER.info(getDeserializerDoneMessage(currentSheetName));
		
		currentSheetName = CobieSheetName.Floor;
		LOGGER.info(getDeserializerBeginMessage(currentSheetName));
		floorDeserializer.deserializeFloors();
		LOGGER.info(getDeserializerDoneMessage(currentSheetName));
		
		currentSheetName = CobieSheetName.Space;
		LOGGER.info(getDeserializerBeginMessage(currentSheetName));
		spaceDeserializer.deserializeSpaces();
		LOGGER.info(getDeserializerDoneMessage(currentSheetName));
		
		currentSheetName = CobieSheetName.Zone;
		LOGGER.info(getDeserializerBeginMessage(currentSheetName));
		zoneDeserializer.deserializeZones();
		LOGGER.info(getDeserializerDoneMessage(currentSheetName));
		
		currentSheetName = CobieSheetName.Type;
		LOGGER.info(getDeserializerBeginMessage(currentSheetName));
		typeDeserializer.deserializeTypes();
		LOGGER.info(getDeserializerDoneMessage(currentSheetName));
		

		
		currentSheetName = CobieSheetName.Component;
		LOGGER.info(getDeserializerBeginMessage(currentSheetName));
		componentDeserializer.deserializeComponents();
		LOGGER.info(getDeserializerDoneMessage(currentSheetName));
		
		currentSheetName = CobieSheetName.System;
		LOGGER.info(getDeserializerBeginMessage(currentSheetName));
		systemDeserializer.deserializeSystems();
		LOGGER.info(getDeserializerDoneMessage(currentSheetName));
		
		currentSheetName = CobieSheetName.Assembly;
		LOGGER.info(getDeserializerBeginMessage(currentSheetName));
		assemblyDeserializer.deserializeAssemblies();
		LOGGER.info(getDeserializerDoneMessage(currentSheetName));
		
		
		currentSheetName = CobieSheetName.Connection;
		LOGGER.info(getDeserializerBeginMessage(currentSheetName));
		connectionDeserializer.deserializeConnections();
		LOGGER.info(getDeserializerDoneMessage(currentSheetName));
		
		currentSheetName = CobieSheetName.Attribute;
		LOGGER.info(getDeserializerBeginMessage(currentSheetName));
		attributeDeserializer.deserializeAttributes();
		LOGGER.info(getDeserializerDoneMessage(currentSheetName));
		LOGGER.info(LOGGER_STATUS_XML_IFC_END_MSG);
		
		return model;
	}
	
	private String getDeserializerBeginMessage(CobieSheetName sheetName)
	{
		String beginMsg;
		beginMsg = String.format(LOGGER_STATUS_FORMAT_STRING, COBieUtility.pluralCobieSheetName.get(sheetName));
		return beginMsg;
	}
	
	private String getDeserializerDoneMessage(CobieSheetName sheetName)
	{
		String doneMsg;
		int sheetCount = COBieUtility.getCOBieSheetCount(sheetName, getCOBie());
		String sheetStr = COBieUtility.pluralCobieSheetName.get(sheetName);
		doneMsg = String.format(LOGGER_STATUS_DONE_FORMAT_STRING, sheetCount,sheetStr);
		//doneMsg = String.format(format, args)
		return doneMsg;
	}
	
	

	protected static IdEObject newIdEObject(String name)
	{
		IdEObject object = null;
		EClass classifier = (EClass) E_CLASSIFIERS.get(name.toUpperCase());
		if (classifier != null)
			object = (IdEObject) Ifc2x3Factory.eINSTANCE.create(classifier);
		return object;
	}
}
