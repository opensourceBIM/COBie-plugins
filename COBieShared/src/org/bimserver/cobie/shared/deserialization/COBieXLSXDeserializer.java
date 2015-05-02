package org.bimserver.cobie.shared.deserialization;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;

import nl.fountain.xelem.excel.Workbook;

import org.bimserver.cobie.shared.transform.xslx.spreadsheetml.XLSXToSpreadsheetMLMapper;
import org.bimserver.cobie.shared.utility.POIUtils;
import org.bimserver.cobie.shared.utility.StreamUtils;
import org.bimserver.plugins.deserializers.DeserializeException;

public class COBieXLSXDeserializer extends COBieDeserializer 
{

	public COBieXLSXDeserializer(File configurationFile) 
	{
		super(configurationFile);

	}

	@Override
	protected Workbook getWorkBookFromInputStream(InputStream in) throws DeserializeException 
	{
		XLSXToSpreadsheetMLMapper mapper = new XLSXToSpreadsheetMLMapper(POIUtils.getWorkbook(in));
		try 
		{
			mapper.run();
			ByteArrayOutputStream outputStream =  mapper.getOutputStream();
			
			return super.getWorkBookFromInputStream(StreamUtils.getInputStream(outputStream));
		} 
		catch (Exception e) 
		{
			throw new DeserializeException(e);
		}
		
		
	}
	
	

}
