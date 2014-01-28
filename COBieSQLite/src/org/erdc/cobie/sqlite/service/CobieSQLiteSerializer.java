package org.erdc.cobie.sqlite.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;
import org.bimserver.plugins.serializers.SerializerException;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.FacilityDocument;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.FacilityType;
import org.erdc.cobie.cobielite.FacilityFactory;
import org.erdc.cobie.shared.exceptions.CobieException;
import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.Connector;
import org.erdc.cobie.utils.serializer.BIMServerCOBieSheetXMLDataSerializer;

public class CobieSQLiteSerializer extends BIMServerCOBieSheetXMLDataSerializer
{         
	private final String databaseTemplatePath;
		
    private FacilityDocument facilityDocument;
    private Connector connector;
    
    public CobieSQLiteSerializer(String databaseTemplatePath)
    {
        this.databaseTemplatePath = databaseTemplatePath;
    }
    
    private void initConnection()
    {
        FacilityFactory factory = new FacilityFactory();
        facilityDocument = factory.parse(getCOBieDocument());
        
        connector = new Connector("jdbc:sqlite:" + databaseTemplatePath, "org.sqlite.JDBC");	
    }
    
    private void serialize() throws CobieSQLiteException
    {
    	FacilityService facilitySerializer = new FacilityService(connector.getConnection());
    	facilitySerializer.clear();
    	facilitySerializer.insert((FacilityType)facilityDocument.getFacility(), Service.EMPTY_KEY);
    }
    
    @Override
    protected void writeCOBIE(OutputStream outputStream) throws SerializerException
    {        
        try
        {
        	initConnection();        	
        	serialize();
        	writeDatabase(outputStream);
        }
        
        catch (CobieSQLiteException e)
        {
        	throw new SerializerException(CobieException.buildFancyDressMessage("Write failed!", e));
        }
        
        catch (Exception e)
        {
        	throw new SerializerException("Write failed!", e);
        }
    }
    
    private void writeDatabase(OutputStream outputStream) throws IOException
    {
    	try (FileInputStream databaseSource = new FileInputStream(new File(databaseTemplatePath)))
    	{
    		IOUtils.copy(databaseSource, outputStream);
    	}
    }
}
