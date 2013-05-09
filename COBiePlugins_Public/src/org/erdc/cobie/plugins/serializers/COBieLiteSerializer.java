package org.erdc.cobie.plugins.serializers;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.xml.transform.TransformerFactoryConfigurationError;

import org.bimserver.cobie.cobieserializersettings.COBieExportOptionsDocument;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.serializers.ProjectInfo;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.utils.UTF8PrintWriter;
import org.erdc.cobie.cobielite.FacilityDocument;
import org.erdc.cobie.cobielite.FacilityFactory;
import org.erdc.cobie.plugins.utils.spreadsheetml.COBieSpreadSheet;
import org.erdc.cobie.shared.COBieSheetXMLDataTransformable;
import org.erdc.cobie.sheetxmldata.COBIEDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class COBieLiteSerializer extends COBieSheetXMLDataSerializer implements COBieSheetXMLDataTransformable
{
	private static final String LOGGER_MESSAGE_RESPONSE_DONE_SUFFIX = "Done writing COBieLite to response stream.";
	private static final String LOGGER_MESSAGE_RESPONSE_BEGIN_SUFFIX = "Begin writing COBieLite to response stream.";
	private static final String LOGGER_MESSAGE_END_SUFFIX = "End Serializing COBieLite";
	private static final String LOGGER_MESSAGE_BEGIN_SUFFIX = "Begin Serializing COBieLite";
	private static final Logger LOGGER = LoggerFactory.getLogger(COBieLiteSerializer.class);
	protected PrintWriter printWriter;
	protected FacilityDocument facilityDocument;
	
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
	@Override
	public void init(IfcModelInterface model, ProjectInfo projectInfo, PluginManager pluginManager) throws SerializerException 
	{
		super.init(model, projectInfo, pluginManager);
		setFacilityDocument(FacilityDocument.Factory.newInstance());
	}

	@Override
	public void init(PluginManager pluginManager, COBIEDocument cobie)
			throws SerializerException
	{
		super.init(pluginManager, cobie);
		setFacilityDocument(FacilityDocument.Factory.newInstance());
	}
//	@Override
//	public void init(IfcModelInterface model, ProjectInfo projectInfo,
//			PluginManager pluginManager, IfcEnginePlugin ifcEnginePlugin,
//			boolean normalizeOids) throws SerializerException
//	{
//		super.init(model, projectInfo, pluginManager, ifcEnginePlugin, normalizeOids);
//		setFacilityDocument(FacilityDocument.Factory.newInstance());
//	}
	
	@Override
	public void transformCOBieSheetXMLData(COBIEDocument cobieDocument, File out)
			throws Exception
	{
		
		
	}
	@Override
	public boolean write(OutputStream outputStream) throws SerializerException {
		if (printWriter == null) 
		{
			this.printWriter = new UTF8PrintWriter(outputStream);
		}
		
		if (getMode() == Mode.BODY) 
		{
			//this.out = new UTFPrintWriter(out);
			try
			{
				writeCOBieLite();
				this.printWriter.flush();
				setMode(Mode.FINISHED);
				return true;
			}
			catch (Exception e)
			{
				this.printWriter.flush();
				setMode(Mode.FINISHED);
				LOGGER.error(getLoggerPrefix()+e.getMessage());
				return false;
			}



		} 
		else if (getMode() == Mode.FINISHED) 
		{
			return false;
		}
		return false;
		
	}
	
	private String getResponseDoneMessage() {
		return getLoggerPrefix()+LOGGER_MESSAGE_RESPONSE_DONE_SUFFIX;
	}
	private String getResponseBeginMessage() {
		return getLoggerPrefix()+LOGGER_MESSAGE_RESPONSE_BEGIN_SUFFIX;
	}
	protected String getLoggerMessageDone() {
		return getLoggerPrefix()+LOGGER_MESSAGE_END_SUFFIX;
	}
	protected String getLoggerMessageBegin() {
		return getLoggerPrefix()+LOGGER_MESSAGE_BEGIN_SUFFIX;
	}

	public void reset() {
		super.reset();
	}
	public FacilityDocument getFacilityDocument()
	{
		return facilityDocument;
	}
	public void setFacilityDocument(FacilityDocument facilityDocument)
	{
		this.facilityDocument = facilityDocument;
	}
}
