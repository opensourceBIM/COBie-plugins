package org.bimserver.cobie.plugins;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;

import javax.xml.transform.Templates;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;

import org.bimserver.cobie.utils.XSLUtils;
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

	private static final String LOGGER_MESSAGE_RESPONSE_DONE = "Done writing result to response stream.";
	private static final String LOGGER_MESSAGE_RESPONSE_BEGIN = "Begin Writing result to response stream.";
	private static final String LOGGER_MESSAGE_DONE = "Done transforming COBie model to HTML.";
	private static final String LOGGER_MESSAGE_IOEXCEPTION_PREFIX = "An IOException occured while preparing to perform the XSL transform:  ";
	private static final String LOGGER_MESSAGE_JDOMEXCEPTION_PREFIX = "A JDOM exception occured while preparing to perform the XSL transformation:  ";
	private static final String LOGGER_MESSAGE_SUFFIX_BEGIN = "Begin XSL Transformation from COBieLite to HTML.";
	private String reportXSLTPath;
	private static final Logger LOGGER = LoggerFactory.getLogger(COBieHTMLReportSerializer.class);
	private String cssPath;
	public COBieHTMLReportSerializer(String reportXSLTPath,String cssPath)
	{
		this.reportXSLTPath = reportXSLTPath;
		this.cssPath = cssPath;
	}

    @Override
    public void init(IfcModelInterface model, ProjectInfo projectInfo, PluginManager pluginManager) throws SerializerException 
	{
		try {

			super.init(model, this.getProjectInfo(), this.getPluginManager());
		} catch (SerializerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	protected void reset() {
		super.reset();
		
	}
	
	
	
	protected void saxonWriter(OutputStream outputStream) throws IOException
	{

		LOGGER.info(getBeginLoggerMessage());
		Templates templates2 = null;
		TransformerFactory tfactory = TransformerFactory.newInstance(
				"net.sf.saxon.TransformerFactoryImpl", getClass()
						.getClassLoader());
		SAXBuilder builder = new SAXBuilder();

		try
		{
			builder.build(new File(this.reportXSLTPath));

		}
		catch (JDOMException e1)
		{
			// TODO Auto-generated catch block
			LOGGER.error(getLoggerPrefix()+getJDOMExceptionLoggerMessage(e1));
			e1.printStackTrace();
		}
		catch (IOException e1)
		{
			// TODO Auto-generated catch block
			LOGGER.error(getLoggerPrefix()+getIOExceptionLoggerMessage(e1));
			e1.printStackTrace();
		}
		File xsltFile = new File(this.reportXSLTPath);
		
		ByteArrayInputStream targetDocStream = new ByteArrayInputStream(this.getCOBieDocument().toString().getBytes("UTF-8"));
		StringWriter xsltBuffer = XSLUtils.transformInputSourceToStringWriter(templates2,
				new StreamSource(targetDocStream),
				new StreamSource(xsltFile),
				tfactory);
		LOGGER.info(getLoggerPrefix()+LOGGER_MESSAGE_DONE);
		LOGGER.info(getLoggerPrefix()+LOGGER_MESSAGE_RESPONSE_BEGIN);
		String result = xsltBuffer.toString();
		/*try
		{
			result = HtmlUtils.injectCSS(new File(this.cssPath),result);
		}
		catch (BadLocationException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/		
		OutputStreamWriter wrt = new OutputStreamWriter(outputStream);
		wrt.write(result);
		wrt.flush();
		LOGGER.info(getLoggerPrefix()+LOGGER_MESSAGE_RESPONSE_DONE);
		
	}

	private String getIOExceptionLoggerMessage(IOException e1) {
		return getLoggerPrefix()+LOGGER_MESSAGE_IOEXCEPTION_PREFIX+e1.getMessage();
	}

	private String getJDOMExceptionLoggerMessage(JDOMException e1) {
		return getLoggerPrefix()+LOGGER_MESSAGE_JDOMEXCEPTION_PREFIX+e1.getMessage();
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
				saxonWriter(outputStream);
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
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
