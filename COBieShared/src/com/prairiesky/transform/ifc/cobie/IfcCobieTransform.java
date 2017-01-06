package com.prairiesky.transform.ifc.cobie;

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
import org.bimserver.cobie.shared.transform.Transformer;
import org.bimserver.emf.IfcModelInterface;
import org.nibs.cobie.tab.COBIEDocument;
import org.nibs.cobie.tab.COBIEType;

import com.prairiesky.transform.cobieifc.settings.SettingsType;

public class IfcCobieTransform extends Transformer<IfcModelInterface, COBIEDocument>
{

	private final SettingsType settings;
	
	public IfcCobieTransform(IfcModelInterface source, COBIEDocument target, SettingsType settings)
	{
		super(source, target);
		this.settings = settings;
	}

	@Override
	public COBIEDocument transform()
	{
        this.writeContacts(getSource());
        this.writeFacilities(getSource());
        this.writeFloors(getSource());
        this.writeSpaces(getSource());
        this.writeZones(getSource());
        this.writeTypes(getSource());
        this.writeComponents(getSource());
        this.writeSystems(getSource());
        this.writeAssemblies(getSource());
        this.writeSpares(getSource());
        this.writeResources(getSource());
        this.writeJobs(getSource());
        this.writeConnections(getSource());
        this.writeDocuments(getSource());
        this.writeAttributes(getSource());
        return getTarget();
	}
	

    private void writeFacilities(IfcModelInterface model)
    {
        COBIEType cType = this.GetCobie();
        COBIEType.Facilities facilities = cType.getFacilities();
        if(facilities == null)
        {
        	facilities = cType.addNewFacilities();
        }
        IfcBuildingFacilitySerializer serializer =
        		new IfcBuildingFacilitySerializer(facilities, getSource(), getSettings());
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
        if(getTarget().getCOBIE()==null)
            getTarget().addNewCOBIE();
        return getTarget().getCOBIE();
    }

    /**
     * Parses IFC model and populates COBie Floors
     */
    private void writeFloors(IfcModelInterface model)
    {
    	COBIEType.Floors floors =
    			GetCobie().getFloors();
    	if(floors == null)
    	{
    		floors = GetCobie().addNewFloors();
    	}
    	IfcBuildingStoreyFloorSerializer serializer =
    			new IfcBuildingStoreyFloorSerializer(floors, getSource(), getSettings());
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
    			new IfcSpaceSerializer(spaces, getSource(), getSettings());
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
                new IfcTypeToCOBieTypeSerializer(this.GetCobie().addNewTypes(), model, getSettings());
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
    			new IfcDocumentInformationDocumentSerializer(documents, getSource(), getSettings());
       serializer.serializeIfc();
    }
    
    /**
     * Parses IFC model and populates COBie Attributes
     */
    private void writeAttributes(IfcModelInterface model)
    {
    	IfcRootAttributeSerializer attributeSerializer =
    			new IfcRootAttributeSerializer(GetCobie().addNewAttributes(), model, GetCobie(), getSettings());
    	attributeSerializer.serializeIfc();
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
        		new IfcConstructionProductResourceSpareSerializer(spares, getSource(), getSettings());
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
        		new IfcConstructionEquipmentResourceSerializer(resources, getSource(), getSettings());
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
        		new IfcTaskJobSerializer(jobs, getSource(), getSettings());
        serializer.serializeIfc();
    }

	public SettingsType getSettings() {
		return settings;
	}

}
