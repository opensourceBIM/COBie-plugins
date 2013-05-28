package org.erdc.cobie.plugins.serializers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.utils.UTF8PrintWriter;
import org.erdc.cobie.cobielite.FacilityDocument;
import org.erdc.cobie.cobielite.FacilityFactory;
import org.erdc.cobie.shared.COBieSheetXMLDataTransformable;
import org.erdc.cobie.sheetxmldata.COBIEDocument;
import org.slf4j.LoggerFactory;

public class COBieLiteSerializer extends COBieSheetXMLDataSerializer implements
		COBieSheetXMLDataTransformable
{
	private static final String LOGGER_MESSAGE_END_SUFFIX = "End Serializing COBieLite";

	private static final String LOGGER_MESSAGE_BEGIN_SUFFIX = "Begin Serializing COBieLite";
	{logger = LoggerFactory
			.getLogger(COBieLiteSerializer.class);}

	protected FacilityDocument facilityDocument;

	public FacilityDocument getFacilityDocument()
	{
		return facilityDocument;
	}

	protected String getLoggerMessageBegin()
	{
		return LOGGER_MESSAGE_BEGIN_SUFFIX;
	}

	protected String getLoggerMessageDone()
	{
		return LOGGER_MESSAGE_END_SUFFIX;
	}

	@Override
	protected void finalize()
	{
		super.finalize();
		setFacilityDocument(FacilityDocument.Factory.newInstance());
	}

	public void setFacilityDocument(FacilityDocument facilityDocument)
	{
		this.facilityDocument = facilityDocument;
	}

	@Override
	public void transformCOBieSheetXMLData(COBIEDocument cobieDocument, File out)
			throws Exception
	{
		setCOBie(cobieDocument);
		writeCOBIE(new FileOutputStream(out));
	}


	@Override
	protected void writeCOBIE(OutputStream outputStream)
			throws SerializerException
	{
		getLogger().info(getLoggerMessageBegin());
		FacilityFactory factory = new FacilityFactory();
		try
		{
			facilityDocument = factory.parse(getCOBieDocument());
		}
		catch (Exception ex)
		{
			getLogger().error("Error parsing COBieSheetXMLData..." + ex.getMessage());
			ex.printStackTrace();
		}
		getLogger().info(getLoggerMessageDone());

		try
		{
			facilityDocument.save(new UTF8PrintWriter(outputStream),
					org.erdc.cobie.cobielite.Settings.XML_Beans_Settings
							.getSaveSettings());

		}
		catch (IOException e)
		{
			getLogger().error("Error writing to output stream..." + e.getMessage());
			e.printStackTrace();
		}
	}

}
