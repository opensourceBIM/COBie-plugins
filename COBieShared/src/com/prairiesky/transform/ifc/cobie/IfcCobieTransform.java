package com.prairiesky.transform.ifc.cobie;

import org.bimserver.cobie.shared.serialization.util.IfcPersonOrganizationContactsSerializer;
import org.bimserver.cobie.shared.serialization.util.IfcProductToComponentsSerializer;
import org.bimserver.cobie.shared.serialization.util.IfcToAssembly;
import org.bimserver.cobie.shared.serialization.util.IfcToAttribute;
import org.bimserver.cobie.shared.serialization.util.IfcToConnection;
import org.bimserver.cobie.shared.serialization.util.IfcToDocument;
import org.bimserver.cobie.shared.serialization.util.IfcToFacility;
import org.bimserver.cobie.shared.serialization.util.IfcToFloor;
import org.bimserver.cobie.shared.serialization.util.IfcToJob;
import org.bimserver.cobie.shared.serialization.util.IfcToResource;
import org.bimserver.cobie.shared.serialization.util.IfcToSpace;
import org.bimserver.cobie.shared.serialization.util.IfcToSpare;
import org.bimserver.cobie.shared.serialization.util.IfcToSystem;
import org.bimserver.cobie.shared.serialization.util.IfcToZone;
import org.bimserver.cobie.shared.serialization.util.IfcTypeToCOBieTypeSerializer;
import org.bimserver.cobie.shared.transform.Transformer;
import org.bimserver.emf.IfcModelInterface;
import org.nibs.cobie.tab.COBIEDocument;
import org.nibs.cobie.tab.COBIEType;

public class IfcCobieTransform extends Transformer<IfcModelInterface, COBIEDocument>
{

	public IfcCobieTransform(IfcModelInterface source, COBIEDocument target)
	{
		super(source, target);
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
        cType = IfcToFacility.writeFacilitiesToCOBie(cType, model);
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
                new IfcPersonOrganizationContactsSerializer(contacts, model);
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
       IfcToFloor.writeFloorsToCOBie(this.GetCobie(), model);
    }
    
    /**
     * Parses IFC model and populates COBie Spaces
     */
    private void writeSpaces(IfcModelInterface model)
    { 
        IfcToSpace.writeSpacesToCOBie(this.GetCobie(), model);
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
                new IfcTypeToCOBieTypeSerializer(this.GetCobie().addNewTypes(), model, true);
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
                new IfcProductToComponentsSerializer(this.GetCobie().getComponents(), model, true);
        componentSerializer.serializeIfc();
    }
    
    /**
     * Parses IFC model and populates COBie Systems
     */
    private void writeSystems(IfcModelInterface model)
    {
        IfcToSystem.writeSystemsToCOBieComponentPerRow(this.GetCobie(), model);
    }
    
    /**
     * Parses IFC model and populates COBie Assemblies
     */
    private void writeAssemblies(IfcModelInterface model)
    {
        IfcToAssembly.writeAssembliesToCOBie(this.GetCobie(), model);
    }
    
    /**
     * Parses IFC model and populates COBie Connections
     */
    private void writeConnections(IfcModelInterface model)
    {
        IfcToConnection.writeConnections(this.GetCobie(), model);
    }
    
    /**
     * Parses IFC model and populates COBie Documents
     */
    private void writeDocuments(IfcModelInterface model)
    {
        IfcToDocument.writeDocument(this.GetCobie(), model);
    }
    
    /**
     * Parses IFC model and populates COBie Attributes
     */
    private void writeAttributes(IfcModelInterface model)
    {
        IfcToAttribute.writeAttributes(this.GetCobie(), model);
    }
    
    /**
     * Parses IFC model and populates COBie Spares
     */
    private void writeSpares(IfcModelInterface model)
    {
        IfcToSpare.writeSpares(this.GetCobie(), model);
    }
    
    /**
     * Parses IFC model and populates COBie Resources
     */
    private void writeResources(IfcModelInterface model)
    {
        IfcToResource.writeResources(this.GetCobie(), model);
    }
    
    /**
     * Parses IFC model and populates COBie Jobs
     */
    private void writeJobs(IfcModelInterface model)
    {
        IfcToJob.writeJobs(this.GetCobie(), model);
    }

}
