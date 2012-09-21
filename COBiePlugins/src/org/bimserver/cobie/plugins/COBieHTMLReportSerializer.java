package org.bimserver.cobie.plugins;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;

import javax.xml.transform.Templates;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;

import org.bimserver.cobie.cobielite.COBIEDocument;
import org.bimserver.cobie.report.ReportSerializer;
import org.bimserver.cobie.report.XSLUtils;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.plugins.serializers.ProjectInfo;
import org.bimserver.plugins.serializers.SerializerException;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class COBieHTMLReportSerializer
extends COBieLiteSerializer
{

	@Override
	public void init(PluginManager pluginManager, COBIEDocument cobie)
			throws SerializerException
	{
		super.init(pluginManager, cobie);
	}





	private static final String DEFAULT_ENCODING = "UTF-8";
	private static final String LOGGER_MESSAGE_RESPONSE_DONE = "Done writing result to response stream.";
	private static final String LOGGER_MESSAGE_RESPONSE_BEGIN = "Begin Writing result to response stream.";
	private static final String LOGGER_MESSAGE_DONE = "Done transforming COBie model to HTML.";
	private static final String LOGGER_MESSAGE_IOEXCEPTION_PREFIX = "An IOException occured while preparing to perform the XSL transform:  ";
	private static final String LOGGER_MESSAGE_JDOMEXCEPTION_PREFIX = "A JDOM exception occured while preparing to perform the XSL transformation:  ";
	private static final String LOGGER_MESSAGE_SUFFIX_BEGIN = "Begin XSL Transformation from COBieLite to HTML.";
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
	@Override
	protected void reset() {
		super.reset();
		
	}
	
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
			return true;
		}
		else if (getMode()==Mode.FINISHED)
			return false;
		return false;
		
		// TODO Auto-generated method stub
	}
}
