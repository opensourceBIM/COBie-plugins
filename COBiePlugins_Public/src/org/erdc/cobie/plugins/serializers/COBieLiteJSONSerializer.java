package org.erdc.cobie.plugins.serializers;

import java.io.IOException;

import org.erdc.cobie.cobielite.FacilityFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class COBieLiteJSONSerializer extends COBieLiteSerializer
{
	private static final Logger LOGGER = LoggerFactory.getLogger(COBieLiteJSONSerializer.class);

	@Override
	protected void writeCOBieLite()
	{
		super.modelToCOBie();
		LOGGER.info(getLoggerMessageBegin());
		FacilityFactory factory = new FacilityFactory();
		try
		{
			facilityDocument = factory.parse(getCOBieDocument());
		}
		catch(Exception ex)
		{
			LOGGER.error("Error parsing COBieSheetXMLData..." + ex.getMessage());
			ex.printStackTrace();
		}
		LOGGER.info(getLoggerMessageDone());

		System.gc();
		Runtime.getRuntime().gc();
		
		try 
		{
			facilityDocument.save(printWriter, org.erdc.cobie.cobielite.Settings.XML_Beans_Settings.getSaveSettings());


		} 
		catch (IOException e)
		{
			LOGGER.error("Error writing to output stream..." + e.getMessage());
			e.printStackTrace();
		} 
	}

}
