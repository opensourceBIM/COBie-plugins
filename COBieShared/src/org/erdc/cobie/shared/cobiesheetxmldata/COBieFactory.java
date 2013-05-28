package org.erdc.cobie.shared.cobiesheetxmldata;

import org.bimserver.emf.IfcModelInterface;
import org.erdc.cobie.shared.LoggerUser;
import org.erdc.cobie.sheetxmldata.COBIEDocument;
import org.erdc.cobie.sheetxmldata.COBIEType;
import org.erdc.cobie.utils.serializer.sheetserializers.IfcPersonOrganizationContactsSerializer;
import org.erdc.cobie.utils.serializer.sheetserializers.IfcProductToComponentsSerializer;
import org.erdc.cobie.utils.serializer.sheetserializers.IfcToAssembly;
import org.erdc.cobie.utils.serializer.sheetserializers.IfcToAttribute;
import org.erdc.cobie.utils.serializer.sheetserializers.IfcToConnection;
import org.erdc.cobie.utils.serializer.sheetserializers.IfcToDocument;
import org.erdc.cobie.utils.serializer.sheetserializers.IfcToFacility;
import org.erdc.cobie.utils.serializer.sheetserializers.IfcToFloor;
import org.erdc.cobie.utils.serializer.sheetserializers.IfcToFloorCoordinatesSerializer;
import org.erdc.cobie.utils.serializer.sheetserializers.IfcToJob;
import org.erdc.cobie.utils.serializer.sheetserializers.IfcToResource;
import org.erdc.cobie.utils.serializer.sheetserializers.IfcToSpace;
import org.erdc.cobie.utils.serializer.sheetserializers.IfcToSpaceCoordinatesSerializer;
import org.erdc.cobie.utils.serializer.sheetserializers.IfcToSpare;
import org.erdc.cobie.utils.serializer.sheetserializers.IfcToSystem;
import org.erdc.cobie.utils.serializer.sheetserializers.IfcToZone;
import org.erdc.cobie.utils.serializer.sheetserializers.IfcTypeToCOBieTypeSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class COBieFactory implements LoggerUser
{
    private static final String BEGIN_MESSAGE = "Transforming IFC to COBie.";
    private static final String END_MESSAGE = "Transform Complete.";
    private COBIEDocument cobieDocument;
    Logger LOGGER = LoggerFactory.getLogger(COBieFactory.class);
    
    public COBieFactory()
    {
        newDocument();
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
        this.writeSpaceCoordinates(model);
        this.writeFloorCoordinates(model);
        
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
                new IfcTypeToCOBieTypeSerializer(this.GetCobie().addNewTypes(), model);
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
                new IfcProductToComponentsSerializer(this.GetCobie().getComponents(), model);
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
    
    private void writeSpaceCoordinates(IfcModelInterface model)
    {
        COBIEType.Coordinates coordinates;
        if(this.GetCobie().getCoordinates()==null)
        {
            coordinates = this.GetCobie().addNewCoordinates();
        }
        else
            coordinates = this.GetCobie().getCoordinates();
        IfcToSpaceCoordinatesSerializer spaceSerializer =
                new IfcToSpaceCoordinatesSerializer(coordinates, model);
        spaceSerializer.serializeIfc();
    }
    
    private void writeFloorCoordinates(IfcModelInterface model)
    {
        COBIEType.Coordinates coordinates;
        if(this.GetCobie().getCoordinates()==null)
        {
            coordinates = this.GetCobie().addNewCoordinates();
        }
        else
            coordinates = this.GetCobie().getCoordinates();
        IfcToFloorCoordinatesSerializer floorCoordinateSerializer =
                new IfcToFloorCoordinatesSerializer(coordinates, model);
        floorCoordinateSerializer.serializeIfc();
    }

    @Override
    public Logger getLogger()
    {
        return LOGGER;
    }
    
}
