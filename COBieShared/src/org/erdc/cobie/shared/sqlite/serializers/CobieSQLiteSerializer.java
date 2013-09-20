package org.erdc.cobie.shared.sqlite.serializers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.commons.io.IOUtils;
import org.bimserver.plugins.serializers.SerializerException;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.FacilityDocument;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.FacilityType;
import org.erdc.cobie.cobielite.FacilityFactory;
import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.utils.serializer.BIMServerCOBieSheetXMLDataSerializer;

public class CobieSQLiteSerializer extends BIMServerCOBieSheetXMLDataSerializer
{         
	private final String databaseTemplatePath;
		
    private FacilityDocument facilityDocument;
    private Connection connection = null;
    
    public CobieSQLiteSerializer(String databaseTemplatePath)
    {
        this.databaseTemplatePath = databaseTemplatePath;
    }
    
    private void initConnection() throws SerializerException
    {
        FacilityFactory factory = new FacilityFactory();
        facilityDocument = factory.parse(getCOBieDocument());
        
        try 
        {
        	Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:" + databaseTemplatePath);
		} 
        
        catch (Exception e) 
		{
        	throw new SerializerException("Could not initialize database connection.", e);
		}	
    }
    
    private void serialize() throws CobieSQLiteException
    {
    	FacilitySerializer facilitySerializer = new FacilitySerializer(connection);
    	facilitySerializer.clear();
    	facilitySerializer.insert((FacilityType)facilityDocument.getFacility(), SQLiteSerializer.ID_NONE);
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
        	throw new SerializerException(CobieSQLiteException.buildFancyDressMessage("Write failed!", e));
        }
        
        catch (Exception e)
        {
        	throw new SerializerException("Write failed!", e);
        }
    }
    
    private void writeDatabase(OutputStream outputStream) throws IOException
    {
    	FileInputStream databaseSource = new FileInputStream(new File(databaseTemplatePath));
    	IOUtils.copy(databaseSource, outputStream);
    }
}
