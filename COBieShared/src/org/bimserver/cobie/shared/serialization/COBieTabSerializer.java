package org.bimserver.cobie.shared.serialization;

import org.bimserver.cobie.shared.LoggerUser;
import org.bimserver.cobie.shared.serialization.util.IfcBuildingFacilitySerializer;
import org.bimserver.cobie.shared.serialization.util.IfcBuildingStoreyFloorSerializer;
import org.bimserver.cobie.shared.serialization.util.IfcConstructionEquipmentResourceSerializer;
import org.bimserver.cobie.shared.serialization.util.IfcConstructionProductResourceSpareSerializer;
import org.bimserver.cobie.shared.serialization.util.IfcDocumentInformationDocumentSerializer;
import org.bimserver.cobie.shared.serialization.util.IfcPersonOrganizationContactsSerializer;
import org.bimserver.cobie.shared.serialization.util.IfcProductToComponentsSerializer;
import org.bimserver.cobie.shared.serialization.util.IfcRelConnectsSerializer;
import org.bimserver.cobie.shared.serialization.util.IfcRootAttributeSerializer;
import org.bimserver.cobie.shared.serialization.util.IfcSpaceSerializer;
import org.bimserver.cobie.shared.serialization.util.IfcSystemSerializer;
import org.bimserver.cobie.shared.serialization.util.IfcTaskJobSerializer;
import org.bimserver.cobie.shared.serialization.util.IfcToAssembly;
import org.bimserver.cobie.shared.serialization.util.IfcToZone;
import org.bimserver.cobie.shared.serialization.util.IfcTypeToCOBieTypeSerializer;
import org.bimserver.emf.IfcModelInterface;
import org.nibs.cobie.tab.COBIEDocument;
import org.nibs.cobie.tab.COBIEType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.prairiesky.transform.cobieifc.settings.SettingsType;

public class COBieTabSerializer implements LoggerUser
{
	private final SettingsType settings;
    private static final String BEGIN_MESSAGE = "Transforming IFC to COBie.";
    private static final String END_MESSAGE = "Transform Complete.";
    private COBIEDocument cobieDocument;
    ///TODO: Create settings for serializer plugin so that user can pick export
    Logger LOGGER = LoggerFactory.getLogger(COBieTabSerializer.class);
    
    public COBieTabSerializer(SettingsType settings)
    {
        newDocument();
        this.settings = settings;
    }

    private void newDocument()
    {
        cobieDocument = COBIEDocument.Factory.newInstance();
    }

    public COBIEDocument parse(IfcModelInterface model)
    {
        newDocument();
        ifcToCOBie(model);
        return cobieDocument;
    }
    
    private void ifcToCOBie(IfcModelInterface model)
    {
        getLogger().info(BEGIN_MESSAGE);
        
        this.writeContacts(model);
        this.writeFacilities(model);
        this.writeFloors(model);
        this.writeSpaces(model);
        this.writeZones(model);
        this.writeTypes(model);
        this.writeComponents(model);
        this.writeSystems(model);
        this.writeAssemblies(model);
        this.writeSpares(model);
        this.writeResources(model);
        this.writeJobs(model);
        this.writeConnections(model);
        this.writeDocuments(model);
        this.writeAttributes(model);
        //this.writeSpaceCoordinates(model);
       // this.writeFloorCoordinates(model);
        
        getLogger().info(END_MESSAGE);
    }
    private void writeFacilities(IfcModelInterface model)
    {
        COBIEType cType = this.GetCobie();
        COBIEType.Facilities facilities =
        		cType.getFacilities();
        if(facilities == null)
        {
        	facilities = cType.addNewFacilities();
        }
        IfcBuildingFacilitySerializer serializer =
        		new IfcBuildingFacilitySerializer(facilities, model, getSettings());
        serializer.serializeIfc();
    }
    
    /**
     * Parses IFC model and populates COBie Contacts
     */
    private void writeContacts(IfcModelInterface model)
    {
        
        COBIEType cType = this.GetCobie();      
        COBIEType.Contacts contacts =
                cType.getContacts();
        if(contacts==null)
            contacts = cType.addNewContacts();
        IfcPersonOrganizationContactsSerializer contactSerializer =
                new IfcPersonOrganizationContactsSerializer(contacts, model, getSettings());
        contactSerializer.serializeIfc();
    }
    
    
    private COBIEType GetCobie()
    {
        if(cobieDocument.getCOBIE()==null)
            cobieDocument.addNewCOBIE();
        return cobieDocument.getCOBIE();
    }

    /**
     * Parses IFC model and populates COBie Floors
     */
    private void writeFloors(IfcModelInterface model)
    {
    	COBIEType cobie = GetCobie();
    	COBIEType.Floors floors =
    			cobie.getFloors();
    	if(floors == null)
    	{
    		floors = cobie.addNewFloors();
    	}
    	IfcBuildingStoreyFloorSerializer serializer =
    			new IfcBuildingStoreyFloorSerializer(floors, model, getSettings());
       serializer.serializeIfc();
    }
    
    /**
     * Parses IFC model and populates COBie Spaces
     */
    private void writeSpaces(IfcModelInterface model)
    { 
    	COBIEType.Spaces spaces =
    			GetCobie().getSpaces();
    	if(spaces == null)
    	{
    		spaces = GetCobie().addNewSpaces();
    	}
    	IfcSpaceSerializer serializer =
    			new IfcSpaceSerializer(spaces, model, getSettings());
    	serializer.serializeIfc();
    }
    
    /**
     * Parses IFC model and populates COBie Zones
     */
    private void writeZones(IfcModelInterface model)
    {
        IfcToZone.writeZonesToCOBie(this.GetCobie(), model);
    }
    
    /**
     * Parses IFC model and populates COBie Types
     */
    private void writeTypes(IfcModelInterface model)
    {
        IfcTypeToCOBieTypeSerializer typeSerializer =
                new IfcTypeToCOBieTypeSerializer(this.GetCobie().addNewTypes(), model,  getSettings());
        typeSerializer.serializeIfc();
    }
    
    /**
     * Parses IFC model and populates COBie Components
     */
    private void writeComponents(IfcModelInterface model)
    {
        COBIEType.Components components =
                this.GetCobie().getComponents();
        if(components==null)
            components = this.GetCobie().addNewComponents();
        IfcProductToComponentsSerializer componentSerializer =
                new IfcProductToComponentsSerializer(this.GetCobie().getComponents(), model, getSettings());
        componentSerializer.serializeIfc();
    }
    
    /**
     * Parses IFC model and populates COBie Systems
     */
    private void writeSystems(IfcModelInterface model)
    {
        COBIEType.Systems systems =
        		GetCobie().getSystems();
        if(systems == null)
        {
        	systems = GetCobie().addNewSystems();
        }
        IfcSystemSerializer serializer =
        		new IfcSystemSerializer(systems, model, getSettings());
        serializer.serializeIfc();
    }
    
    /**
     * Parses IFC model and populates COBie Assemblies
     */
    private void writeAssemblies(IfcModelInterface model)
    {
        IfcToAssembly.writeAssembliesToCOBie(this.GetCobie(), model, getSettings());
    }
    
    /**
     * Parses IFC model and populates COBie Connections
     */
    private void writeConnections(IfcModelInterface model)
    {
    	COBIEType.Connections connections =
    			GetCobie().getConnections();
    	if(connections == null)
    	{
    		connections = GetCobie().addNewConnections();
    	}
    	IfcRelConnectsSerializer serializer =
    			new IfcRelConnectsSerializer(connections, model, getSettings());
    	serializer.serializeIfc();
    }
    
    /**
     * Parses IFC model and populates COBie Documents
     */
    private void writeDocuments(IfcModelInterface model)
    {
    	COBIEType.Documents documents =
    			GetCobie().getDocuments();
    	if(documents == null)
    	{
    		documents = GetCobie().addNewDocuments();
    	}
    	IfcDocumentInformationDocumentSerializer serializer =
    			new IfcDocumentInformationDocumentSerializer(documents, model, getSettings());
       serializer.serializeIfc();
    }
    
    /**
     * Parses IFC model and populates COBie Attributes
     */
    private void writeAttributes(IfcModelInterface model)
    {
    	IfcRootAttributeSerializer attributeSerializer =
    			new IfcRootAttributeSerializer(this.GetCobie().addNewAttributes(), model, this.GetCobie(), getSettings());
    	attributeSerializer.serializeIfc();
     //   IfcToAttribute.writeAttributes(this.GetCobie(), model);
    }
    
    /**
     * Parses IFC model and populates COBie Spares
     */
    private void writeSpares(IfcModelInterface model)
    {
        COBIEType.Spares spares =
        		GetCobie().getSpares();
        if(spares == null)
        {
        	spares = GetCobie().addNewSpares();
        }
        IfcConstructionProductResourceSpareSerializer serializer =
        		new IfcConstructionProductResourceSpareSerializer(spares, model, getSettings());
        serializer.serializeIfc();
    }
    
    /**
     * Parses IFC model and populates COBie Resources
     */
    private void writeResources(IfcModelInterface model)
    {
    	COBIEType.Resources resources =
    			GetCobie().getResources();
    	if(resources == null)
    	{
    		resources = GetCobie().addNewResources();
    	}
        IfcConstructionEquipmentResourceSerializer serializer =
        		new IfcConstructionEquipmentResourceSerializer(resources, model, getSettings());
        serializer.serializeIfc();
    }
    
    /**
     * Parses IFC model and populates COBie Jobs
     */
    private void writeJobs(IfcModelInterface model)
    {
        COBIEType.Jobs jobs = GetCobie().getJobs();
        if(jobs == null)
        {
        	jobs = GetCobie().addNewJobs();
        }
        IfcTaskJobSerializer serializer =
        		new IfcTaskJobSerializer(jobs, model, getSettings());
        serializer.serializeIfc();
    }
    
//    private void writeSpaceCoordinates(IfcModelInterface model)
//    {
//        COBIEType.Coordinates coordinates;
//        if(this.GetCobie().getCoordinates()==null)
//        {
//            coordinates = this.GetCobie().addNewCoordinates();
//        }
//        else
//            coordinates = this.GetCobie().getCoordinates();
//        IfcToSpaceCoordinatesSerializer spaceSerializer =
//                new IfcToSpaceCoordinatesSerializer(coordinates, model);
//        spaceSerializer.serializeIfc();
//    }
//    
//    private void writeFloorCoordinates(IfcModelInterface model)
//    {
//        COBIEType.Coordinates coordinates;
//        if(this.GetCobie().getCoordinates()==null)
//        {
//            coordinates = this.GetCobie().addNewCoordinates();
//        }
//        else
//            coordinates = this.GetCobie().getCoordinates();
//        IfcToFloorCoordinatesSerializer floorCoordinateSerializer =
//                new IfcToFloorCoordinatesSerializer(coordinates, model);
//        floorCoordinateSerializer.serializeIfc();
//    }

    @Override
    public Logger getLogger()
    {
        return LOGGER;
    }

	public SettingsType getSettings() {
		return settings;
	}
    
}
