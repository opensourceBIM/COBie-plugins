package org.bimserver.cobie.shared.deserialization.cobietab;

import java.util.HashMap;
import java.util.Map;

import org.bimserver.cobie.shared.deserialization.cobietab.modelhandlers.COBieOidProvider;
import org.bimserver.cobie.shared.deserialization.cobietab.modelhandlers.IfcCommonHandler;
import org.bimserver.cobie.shared.utility.COBieUtility;
import org.bimserver.cobie.shared.utility.COBieUtility.CobieSheetName;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.nibs.cobie.tab.COBIEType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FromCOBieToIfc
{
    private static final Map<String, EClassifier> E_CLASSIFIERS = initClasses();

    public static int getCOBieSheetCount(CobieSheetName sheetName, COBIEType cobie)
    {
        int count = 0;
        try
        {
            switch (sheetName)
            {
                case Assembly:
                    count = cobie.getAssemblies().sizeOfAssemblyArray();
                    break;
                case Attribute:
                    count = cobie.getAttributes().sizeOfAttributeArray();
                    break;
                case Component:
                    count = cobie.getComponents().sizeOfComponentArray();
                    break;
                case Connection:
                    count = cobie.getConnections().sizeOfConnectionArray();
                    break;
                case Contact:
                    count = cobie.getContacts().sizeOfContactArray();
                    break;
                case Document:
                    count = cobie.getDocuments().sizeOfDocumentArray();
                    break;
                case Facility:
                    count = cobie.getFacilities().sizeOfFacilityArray();
                    break;
                case Floor:
                    count = cobie.getFloors().sizeOfFloorArray();
                    break;
                case Job:
                    count = cobie.getJobs().sizeOfJobArray();
                    break;
                case Resource:
                    count = cobie.getResources().sizeOfResourceArray();
                    break;
                case Space:
                    count = cobie.getSpaces().sizeOfSpaceArray();
                    break;
                case Spare:
                    count = cobie.getSpares().sizeOfSpareArray();
                    break;
                case System:
                    count = cobie.getSystems().sizeOfSystemArray();
                    break;
                case Type:
                    count = cobie.getTypes().sizeOfTypeArray();
                    break;
                case Zone:
                    count = cobie.getZones().sizeOfZoneArray();
                    break;
                case Impact:
                    count = cobie.getImpacts().sizeOfImpactArray();
                    break;
                case Coordinate:
                    count = cobie.getCoordinates().sizeOfCoordinateArray();
                    break;
                case Issue:
                    count = cobie.getIssues().sizeOfIssueArray();
                    break;
            }
        } catch (Exception e)
        {

        }
        return count;
    }

    private static Map<String, EClassifier> initClasses()
    {

        HashMap<String, EClassifier> classes = new HashMap<String, EClassifier>(Ifc2x3tc1Package.eINSTANCE.getEClassifiers().size());

        for (EClassifier classifier : Ifc2x3tc1Package.eINSTANCE.getEClassifiers())
        {
            classes.put(classifier.getName().toUpperCase(), classifier);
        }
        return classes;
    }

    protected static IdEObject newIdEObject(String name)
    {
        IdEObject object = null;
        EClass classifier = (EClass)E_CLASSIFIERS.get(name.toUpperCase());
        if (classifier != null)
        {
            object = (IdEObject)Ifc2x3tc1Factory.eINSTANCE.create(classifier);
        }
        return object;
    }

    private COBieIfcModel model;
    private COBIEType COBie;
    protected COBieOidProvider CobieOidProvider;
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
    private DocumentDeserializer documentDeserializer;
    private SpareDeserializer spareDeserializer;
    private ResourceDeserializer resourceDeserializer;;
    private JobDeserializer jobDeserializer;
  //  private CoordinateDeserializer coordinateDeserializer;
    private static final Logger LOGGER = LoggerFactory.getLogger(FromCOBieToIfc.class);
    private AttributeDeserializer attributeDeserializer;
    private static final String LOGGER_STATUS_FORMAT_STRING = "Deserializing %s.";
    private static final String LOGGER_STATUS_DONE_FORMAT_STRING = "Deserialized %d %s.";
    private static final String LOGGER_STATUS_XML_IFC_BEGIN_MSG = "Begin Deserializing COBieSheetXMLData to IFC";
    private PackageMetaData packageMetadata;
    //   private static final String LOGGER_STATUS_XML_IFC_END_MSG = "Done Deserializing COBieSheetXMLData XML to IFC";

    public FromCOBieToIfc(COBIEType cobie, PackageMetaData packageMetadata) throws IfcModelInterfaceException
    {
    	setPackageMetadata(packageMetadata);
        init(cobie);
        
    }

    public COBIEType getCOBie()
    {
        return COBie;
    }

    private String getDeserializerBeginMessage(CobieSheetName sheetName)
    {
        String beginMsg;
        beginMsg = String.format(LOGGER_STATUS_FORMAT_STRING, COBieUtility.cobieSheetNameToPlural.get(sheetName));
        return beginMsg;
    }

    private String getDeserializerDoneMessage(CobieSheetName sheetName)
    {
        String doneMsg;
        int sheetCount = getCOBieSheetCount(sheetName, getCOBie());
        String sheetStr = COBieUtility.cobieSheetNameToPlural.get(sheetName);
        doneMsg = String.format(LOGGER_STATUS_DONE_FORMAT_STRING, sheetCount, sheetStr);
        // doneMsg = String.format(format, args)
        return doneMsg;
    }

    public IfcModelInterface getModel()
    {
        return model;
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

        currentSheetName = CobieSheetName.Spare;
        LOGGER.info(getDeserializerBeginMessage(currentSheetName));
        spareDeserializer.deserializeSpares();
        LOGGER.info(getDeserializerDoneMessage(currentSheetName));

        currentSheetName = CobieSheetName.Resource;
        LOGGER.info(getDeserializerBeginMessage(currentSheetName));
        resourceDeserializer.deserializeResources();
        LOGGER.info(getDeserializerDoneMessage(currentSheetName));

        currentSheetName = CobieSheetName.Job;
        LOGGER.info(getDeserializerBeginMessage(currentSheetName));
        jobDeserializer.deserialize();
        LOGGER.info(getDeserializerDoneMessage(currentSheetName));

        currentSheetName = CobieSheetName.Document;
        LOGGER.info(getDeserializerBeginMessage(currentSheetName));
        documentDeserializer.deserialize();
        LOGGER.info(getDeserializerDoneMessage(currentSheetName));

        currentSheetName = CobieSheetName.Connection;
        LOGGER.info(getDeserializerBeginMessage(currentSheetName));
        connectionDeserializer.deserializeConnections();
        connectionDeserializer.deserializeBAMieConnections(documentDeserializer.getBAMieDocuments().getDocuments());
        LOGGER.info(getDeserializerDoneMessage(currentSheetName));

        currentSheetName = CobieSheetName.Attribute;
        LOGGER.info(getDeserializerBeginMessage(currentSheetName));
        attributeDeserializer.deserializeAttributes();
        LOGGER.info(getDeserializerDoneMessage(currentSheetName));

       //THIS IS BROKEN IN BIMSERVER 1.3.4
      /*  currentSheetName = CobieSheetName.Coordinate;
        LOGGER.info(getDeserializerBeginMessage(currentSheetName));
        coordinateDeserializer.deserialize();
        LOGGER.info(getDeserializerDoneMessage(currentSheetName));
        LOGGER.info(LOGGER_STATUS_XML_IFC_END_MSG);*/
        return model;

    }

    private void init(COBIEType cobie) throws IfcModelInterfaceException
    {
        model = new COBieIfcModel(getPackageMetadata());
        COBie = cobie;
        CobieOidProvider = new COBieOidProvider(model);
        ifcCommonHandler = new IfcCommonHandler(model, CobieOidProvider);
        contactDeserializer = new ContactDeserializer(cobie.getContacts(), model, ifcCommonHandler);
        facilityDeserializer = new FacilityDeserializer(model, ifcCommonHandler, cobie.getFacilities());
        floorDeserializer = new FloorDeserializer(model, cobie.getFloors(), ifcCommonHandler);
        spaceDeserializer = new SpaceDeserializer(model, ifcCommonHandler, cobie.getSpaces());
        typeDeserializer = new TypeDeserializer(model, ifcCommonHandler, cobie.getTypes());
        componentDeserializer = new ComponentDeserializer(model, ifcCommonHandler, cobie.getComponents());
        connectionDeserializer = new ConnectionDeserializer(model, ifcCommonHandler, cobie.getConnections());
        attributeDeserializer = new AttributeDeserializer(model, ifcCommonHandler, cobie.getAttributes());
        zoneDeserializer = new ZoneDeserializer(model, ifcCommonHandler, cobie.getZones());
        systemDeserializer = new SystemDeserializer(model, ifcCommonHandler, cobie.getSystems());
        assemblyDeserializer = new AssemblyDeserializer(model, ifcCommonHandler, cobie.getAssemblies());
        documentDeserializer = new DocumentDeserializer(ifcCommonHandler, model, cobie.getDocuments());
        spareDeserializer = new SpareDeserializer(model, ifcCommonHandler, cobie.getSpares());
        resourceDeserializer = new ResourceDeserializer(model, ifcCommonHandler, cobie.getResources());
        jobDeserializer = new JobDeserializer(model, ifcCommonHandler, cobie.getJobs());
       // coordinateDeserializer = new CoordinateDeserializer(ifcCommonHandler, model, cobie.getCoordinates());
    }

	public PackageMetaData getPackageMetadata() {
		return packageMetadata;
	}

	public void setPackageMetadata(PackageMetaData packageMetadata) {
		this.packageMetadata = packageMetadata;
	}
}
