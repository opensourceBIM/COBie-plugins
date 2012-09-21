package org.bimserver.cobie.plugins;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;

import javax.xml.transform.Templates;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;


import org.apache.xmlbeans.XmlException;
import org.bimserver.cobie.cobielite.COBIEDocument;
import org.bimserver.cobie.report.XSLUtils;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.plugins.serializers.ProjectInfo;
import org.bimserver.plugins.serializers.SerializerException;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class COBieCheckSerializer extends COBieLiteSerializer
{
	private static final String LOGGER_MESSAGE_RESPONSE_EXCEPTION = "An exception occured while writing COBie Compliance report to response stream:  ";
	private static final String LOGGER_MESSAGE_TRANSFORM3_DONE = "Transformation 3 of 3: Done transforming SVRL report to HTML.";
	private static final String LOGGER_MESSAGE_TRANSFORM3_BEGIN = "Transformation 3 of 3: Begin transforming SVRL report to HTML.";
	private static final String LOGGER_MESSAGE_TRANSFORM2_DONE = "Transformation 2 of 3: Done transforming target COBie model into SVRL report.";
	private static final String LOGGER_MESSAGE_TRANSFORM2_BEGIN = "Transformation 2 of 3:  Begin transforming target model into Schematron Validation Report Language (SVRL) report.";
	private static final String LOGGER_MESSAGE_TOOS_DONE = "Done writing COBie Compliance HTML report to response stream.";
	private static final String LOGGER_MESSAGE_TOOS_BEGIN = "Begin writing COBie Compliance HTML report to outputstream";
	private static final String LOGGER_MESSAGE_TRANSFORM3_ERROR = "Transformation 3 of 3:  An exception occured while transforming SVRL to HTML:  ";
	private static final String LOGGER_MESSAGE_TRANSFORM3_PREPARE_ERROR = "Transformation 3 of 3:  An exception occured while preparing to transform SVRL to HTML:  ";
	private static final String LOGGER_MESSAGE_TRANSFORM2_ERROR = "Transformation 2 of 3:  An exception occured while transforming target COBie model to SVRL XML report:  ";
	private static final String LOGGER_MESSAGE_TRANSFORM1_DONE = "Transformation 1 of 3:  Done transforming COBie Schematron rules to XSLT.";
	private static final String LOGGER_MESSAGE_TRANSFORM1_IO_ERROR = "Transformation 1 of 3:  An IOException occured while transforming COBie Schematron rules to XSLT:  ";
	private static final String LOGGER_MESSAGE_TRANSFORM1_JDOM_ERROR = "Transformation 1 of 3:  A JDOM Exception occured while transforming COBie Schematron rules to XSLT:  ";
	private static final String LOGGER_MESSAGE_TRANSFORM1_BEGIN = "Transformation 1 of 3:  Begin transforming COBie Schematron rules to XSLT.";
	private static final String LOGGER_MESSAGE_END_COMPLIANCE_REPORT = ":  COBie Compliance report done.";
	private static final String LOGGER_MSG_BEGIN_COMPLIANCE_REPORT = ":  Begin generating COBie compliance report.";
	private static final Logger LOGGER = LoggerFactory.getLogger(COBieCheckSerializer.class);
	private String schematronRulePath;
	private String preProcessorPath;
	private String svrlXSDPath;
	@Override
	public void init(PluginManager pluginManager, COBIEDocument cobie)
			throws SerializerException
	{
		super.init(pluginManager, cobie);
	}

	private String svrlHTMLPath;
	private String cssPath;

	public COBieCheckSerializer(String schematronRulePath, String preProcessorPath)
	{
		this.schematronRulePath = schematronRulePath;
		this.preProcessorPath = preProcessorPath;
		this.svrlHTMLPath = "";
		this.svrlXSDPath = "";
		
	}
	
	public COBieCheckSerializer(String schematronRulePath, String preProcessorPath,String svrlXSDPath,String svrlHTMLPath,String cssPath)
	{
		this.schematronRulePath = schematronRulePath;
		this.preProcessorPath = preProcessorPath;
		this.svrlHTMLPath = svrlHTMLPath;
		this.svrlXSDPath = svrlXSDPath;
		this.cssPath = cssPath;
	}
		
	public void init(InputStream cobieLite) throws SerializerException, XmlException, IOException
	{
		init(COBIEDocument.Factory.parse(cobieLite));
	}
	 public void init(COBIEDocument cobie) throws SerializerException 
		{
			try {
			
				super.init(cobie);
			} catch (SerializerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

    @Override
    public void init(IfcModelInterface model, ProjectInfo projectInfo, PluginManager pluginManager) throws SerializerException 
	{
		try {
		
			super.init(model, this.getProjectInfo(),pluginManager);
		} catch (SerializerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	protected void reset() {
		super.reset();
		
	}
	

	
	public void schematronReportToOutputStream(OutputStream outputStream) throws UnsupportedEncodingException
	{
		Templates templates1 = null;
		Templates templates2 = null;
		Templates templates3 = null;
		LOGGER.info(getLoggerPrefix()+LOGGER_MESSAGE_TRANSFORM1_BEGIN);
		File ruleFile = new File(schematronRulePath);
		TransformerFactory tfactory = TransformerFactory.newInstance(
				"net.sf.saxon.TransformerFactoryImpl", getClass()
						.getClassLoader());
		SAXBuilder builder = new SAXBuilder();
		try
		{
			builder.build(new File(preProcessorPath));
		}
		catch (JDOMException e1)
		{
			// TODO Auto-generated catch block
			LOGGER.error(getLoggerPrefix()+LOGGER_MESSAGE_TRANSFORM1_JDOM_ERROR + e1.getMessage());
			e1.printStackTrace();
		}
		catch (IOException e1)
		{
			// TODO Auto-generated catch block
			LOGGER.error(getLoggerPrefix()+LOGGER_MESSAGE_TRANSFORM1_IO_ERROR+e1.getMessage());
			e1.printStackTrace();
		}
		File preProc = new File(preProcessorPath);
	
		StringWriter schematronXSLBuffer = XSLUtils.transformInputSourceToStringWriter(templates1,
				new StreamSource(ruleFile),new StreamSource(preProc),tfactory);
		LOGGER.info(getLoggerPrefix()+LOGGER_MESSAGE_TRANSFORM1_DONE);
		LOGGER.info(getLoggerPrefix()+LOGGER_MESSAGE_TRANSFORM2_BEGIN);
		ByteArrayInputStream targetDocStream = new ByteArrayInputStream(this.getCOBieDocument().toString().getBytes("UTF-8"));
		StringWriter svrlXSLBuffer = new StringWriter();
		try
		{
			svrlXSLBuffer = XSLUtils.transformInputSourceToStringWriter(templates2,
				new StreamSource(targetDocStream),
				new StreamSource(new StringReader(schematronXSLBuffer.toString())),
				tfactory);
			LOGGER.info(getLoggerPrefix()+LOGGER_MESSAGE_TRANSFORM2_DONE);
		}
		catch(Exception e)
		{
			LOGGER.error(getLoggerPrefix()+LOGGER_MESSAGE_TRANSFORM2_ERROR+e.getMessage());
		}
		LOGGER.info(getLoggerPrefix()+LOGGER_MESSAGE_TRANSFORM3_BEGIN);
		File svrlHTMLFile = new File(svrlHTMLPath);
		try
		{
			builder.build(svrlHTMLFile);
		}
		catch (JDOMException e1)
		{
			LOGGER.error(getLoggerPrefix()+LOGGER_MESSAGE_TRANSFORM3_PREPARE_ERROR+e1.getMessage());
			e1.printStackTrace();
		}
		catch (IOException e1)
		{
			LOGGER.error(getLoggerPrefix()+LOGGER_MESSAGE_TRANSFORM3_PREPARE_ERROR+e1.getMessage());
			e1.printStackTrace();
		}
		StringWriter svrlHTMLBuffer = new StringWriter();
		try
		{
			 svrlHTMLBuffer = XSLUtils.transformInputSourceToStringWriter(templates3,
				new StreamSource(new StringReader(svrlXSLBuffer.toString())),
				new StreamSource(svrlHTMLFile),tfactory);
			 LOGGER.info(getLoggerPrefix()+LOGGER_MESSAGE_TRANSFORM3_DONE);
		}
		catch(Exception e)
		{
			LOGGER.info(getLoggerPrefix()+LOGGER_MESSAGE_TRANSFORM3_ERROR+e.getMessage());
		}

		try
		{
			LOGGER.info(getLoggerPrefix()+LOGGER_MESSAGE_TOOS_BEGIN);
			String result = svrlHTMLBuffer.toString();
			OutputStreamWriter wrt = new OutputStreamWriter(outputStream);
			wrt.write(result);
			wrt.flush();
			LOGGER.info(getLoggerPrefix()+LOGGER_MESSAGE_TOOS_DONE);
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			LOGGER.error(getLoggerPrefix()+LOGGER_MESSAGE_RESPONSE_EXCEPTION+e.getMessage());
			e.printStackTrace();
		}

		
	}
	


	@Override
	public boolean write(OutputStream outputStream)
			throws SerializerException 
	{
		if (getMode() == Mode.BODY) {
			super.modelToCOBie();
			LOGGER.info(getBeginMessage());
			try
			{
				schematronReportToOutputStream(outputStream);
			}
			catch (UnsupportedEncodingException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			LOGGER.info(getDoneMessage());
			setMode(Mode.FINISHED);
			return true;
		}
		else if (getMode()==Mode.FINISHED)
			return false;
		return false;
		
		// TODO Auto-generated method stub
	}
	
	public boolean writeModeFree(OutputStream outputStream)
			throws SerializerException 
	{
	 
			LOGGER.info(getBeginMessage());
			try
			{
				schematronReportToOutputStream(outputStream);
			}
			catch (UnsupportedEncodingException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			LOGGER.info(getDoneMessage());
			setMode(Mode.FINISHED);
			return true;	
		
		// TODO Auto-generated method stub
	}

	private String getDoneMessage() {
		return super.projectName+LOGGER_MESSAGE_END_COMPLIANCE_REPORT;
	}

	private String getBeginMessage() {
		return super.projectName+LOGGER_MSG_BEGIN_COMPLIANCE_REPORT;
	}
}