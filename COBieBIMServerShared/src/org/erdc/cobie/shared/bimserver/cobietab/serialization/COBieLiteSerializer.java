package org.erdc.cobie.shared.bimserver.cobietab.serialization;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.bimserver.plugins.serializers.SerializerException;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.FacilityDocument;
import org.erdc.cobie.shared.bimserver.COBieSheetXMLDataTransformable;
import org.erdc.cobie.shared.bimserver.utility.XMLUtils;
import org.erdc.cobie.shared.cobietab.transformation.cobielite.FacilityFactory;
import org.erdc.cobie.sheetxmldata.COBIEDocument;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;

public class COBieLiteSerializer extends COBieTabXMLSerializer implements
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
	protected void finalize() throws Throwable
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
		    XMLUtils.removeEmptyChildElements((Element)facilityDocument.getFacility().getDomNode());
			facilityDocument.save(outputStream,
				org.erdc.cobie.shared.cobietab.transformation.cobielite.Settings.XML_Beans_Settings
							.getSaveSettings()
							);

		}
		catch (IOException e)
		{
			getLogger().error("Error writing to output stream..." + e.getMessage());
			e.printStackTrace();
		}
	}

}
