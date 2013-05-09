package org.erdc.cobie.plugins.serializers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.serializers.ProjectInfo;
import org.bimserver.plugins.serializers.SerializerException;
import org.erdc.cobie.report.ReportSerializer;
import org.erdc.cobie.shared.COBieSheetXMLDataTransformable;
import org.erdc.cobie.sheetxmldata.COBIEDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class COBieHTMLReportSerializer
extends COBieSheetXMLDataSerializer implements COBieSheetXMLDataTransformable
{

	@Override
	public void init(PluginManager pluginManager, COBIEDocument cobie)
			throws SerializerException
	{
		super.init(pluginManager, cobie);
	}


	@Override
	public void init(COBIEDocument cobie)
			throws SerializerException
	{
		super.init(cobie);
	}


	private static final String DEFAULT_ENCODING = "UTF-8";
	private static final String LOGGER_MESSAGE_RESPONSE_DONE = "Done writing result to response stream.";
	private static final String LOGGER_MESSAGE_RESPONSE_BEGIN = "Begin Writing result to response stream.";
	private static final String LOGGER_MESSAGE_DONE = "Done transforming COBie model to HTML.";
	private static final String LOGGER_MESSAGE_IOEXCEPTION_PREFIX = "An IOException occured while preparing to perform the XSL transform:  ";
	private static final String LOGGER_MESSAGE_JDOMEXCEPTION_PREFIX = "A JDOM exception occured while preparing to perform the XSL transformation:  ";
	private static final String LOGGER_MESSAGE_SUFFIX_BEGIN = "Begin XSL Transformation from COBieSheetXMLData to HTML.";
	private String reportXSLTPath;
	private static final Logger LOGGER = LoggerFactory.getLogger(COBieHTMLReportSerializer.class);
	private String cssPath;
	private ReportSerializer reportSerializer;
	public COBieHTMLReportSerializer(String reportXSLTPath,String cssPath)
	{
		reportSerializer = new ReportSerializer(reportXSLTPath,cssPath);
		this.reportXSLTPath = reportXSLTPath;
		this.cssPath = cssPath;
	}
	
	public COBieHTMLReportSerializer(String reportXSLTPath)
	{
		reportSerializer = new ReportSerializer(reportXSLTPath);
		this.reportXSLTPath = reportXSLTPath;
		this.cssPath = "";
	}

    @Override
    public void init(IfcModelInterface model, ProjectInfo projectInfo, PluginManager pluginManager) throws SerializerException 
	{
		try {

			super.init(model, this.getProjectInfo(), pluginManager);
		} catch (SerializerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//    @Override
//    public void init(IfcModelInterface model, ProjectInfo projectInfo, PluginManager pluginManager,IfcEnginePlugin ifcEnginePlugin, boolean normalizeOids) throws SerializerException 
//	{
//		try {
//
//			super.init(model, this.getProjectInfo(), pluginManager,ifcEnginePlugin,normalizeOids);
//		} catch (SerializerException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	protected void executeTransform(OutputStream outputStream)
	{
		//this.getCOBieDocument().toString().getBytes("UTF-8")
		try
		{
			LOGGER.info(getBeginLoggerMessage());
			reportSerializer.exexuteSaxonXSLT(outputStream, this.getCOBieDocument().toString().getBytes(DEFAULT_ENCODING),this.reportXSLTPath);
		}
		catch (UnsupportedEncodingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.error(getLoggerPrefix()+e.getMessage());
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.error(getLoggerPrefix()+e.getMessage());
		}
	}
	
	

	private String getBeginLoggerMessage() {
		return getLoggerPrefix()+LOGGER_MESSAGE_SUFFIX_BEGIN;
	}
	




	@Override
	public boolean write(OutputStream outputStream)
			throws SerializerException 
	{
		if (getMode() == Mode.BODY) {

			writeModeIndependent(outputStream);
			return true;
		}
		else if (getMode()==Mode.FINISHED)
			return false;
		return false;
		
		// TODO Auto-generated method stub
	}


	private void writeModeIndependent(OutputStream outputStream)
	{
		super.modelToCOBie();
		try
		{
			executeTransform(outputStream);
		}
		catch(Exception e)
		{
			LOGGER.error(getLoggerPrefix() + e.getMessage());
			e.printStackTrace();
		}
		setMode(Mode.FINISHED);
	}

	@Override
	public void transformCOBieSheetXMLData(COBIEDocument cobieDocument, File out)
			throws Exception
	{
		init(cobieDocument);
		writeModeIndependent(new FileOutputStream(out));
	}
}
