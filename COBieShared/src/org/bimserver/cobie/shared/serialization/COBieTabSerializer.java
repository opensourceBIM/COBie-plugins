package org.bimserver.cobie.shared.serialization;

import org.bimserver.cobie.shared.LoggerUser;
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
import org.bimserver.emf.IfcModelInterface;
import org.nibs.cobie.tab.COBIEDocument;
import org.nibs.cobie.tab.COBIEType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class COBieTabSerializer implements LoggerUser
{
    private static final String BEGIN_MESSAGE = "Transforming IFC to COBie.";
    private static final String END_MESSAGE = "Transform Complete.";
    private COBIEDocument cobieDocument;
    private boolean ignoreNonAssets = false;
    Logger LOGGER = LoggerFactory.getLogger(COBieTabSerializer.class);
    
    public COBieTabSerializer()
    {
        newDocument();
    }
    
    public COBieTabSerializer(boolean ignoreNonAssets)
    {
    	this();
    	this.ignoreNonAssets = ignoreNonAssets;
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
        if(cobieDocument.getCOBIE()==null)
            cobieDocument.addNewCOBIE();
        return cobieDocument.getCOBIE();
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
                new IfcTypeToCOBieTypeSerializer(this.GetCobie().addNewTypes(), model, ignoreNonAssets);
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
                new IfcProductToComponentsSerializer(this.GetCobie().getComponents(), model, ignoreNonAssets);
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
    
}
