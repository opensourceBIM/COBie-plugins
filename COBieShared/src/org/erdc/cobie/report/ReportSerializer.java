package org.erdc.cobie.report;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;

import javax.xml.transform.Templates;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;

import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReportSerializer
{
    private static final String TRANSFORMER_FACTORY_CLASS = "net.sf.saxon.TransformerFactoryImpl";
    private static final String LOGGER_MESSAGE_RESPONSE_DONE = "Done writing result to response stream.";
    private static final String LOGGER_MESSAGE_RESPONSE_BEGIN = "Begin Writing result to response stream.";
    private static final String LOGGER_MESSAGE_DONE = "Done transforming COBie model to HTML.";
    private static final String LOGGER_MESSAGE_IOEXCEPTION_PREFIX = "An IOException occured while preparing to perform the XSL transform:  ";
    private static final String LOGGER_MESSAGE_JDOMEXCEPTION_PREFIX = "A JDOM exception occured while preparing to perform the XSL transformation:  ";
    private static final String LOGGER_MESSAGE_SUFFIX_BEGIN = "Begin XSL Transformation from COBieSheetXMLData to HTML.";
    private static final Logger LOGGER = LoggerFactory.getLogger(ReportSerializer.class);

    public static void exexuteSaxonXSLT(OutputStream outputStream, byte[] sourceDocument, String reportPath) throws IOException
    {

        LOGGER.info(getBeginLoggerMessage());
        Templates templates2 = null;
        TransformerFactory tfactory = TransformerFactory.newInstance(TRANSFORMER_FACTORY_CLASS, ReportSerializer.class.getClassLoader());
        SAXBuilder builder = new SAXBuilder();

        try
        {
            builder.build(new File(reportPath));

        } catch (JDOMException e1)
        {
            // TODO Auto-generated catch block
            LOGGER.error(getJDOMExceptionLoggerMessage(e1));
            e1.printStackTrace();
        } catch (IOException e1)
        {
            // TODO Auto-generated catch block
            LOGGER.error(getIOExceptionLoggerMessage(e1));
            e1.printStackTrace();
        }
        File xsltFile = new File(reportPath);

        ByteArrayInputStream targetDocStream = new ByteArrayInputStream(sourceDocument);
        StringWriter xsltBuffer = XSLUtils.transformInputSourceToStringWriter(templates2, new StreamSource(targetDocStream), new StreamSource(
                xsltFile), tfactory);
        LOGGER.info(LOGGER_MESSAGE_DONE);
        LOGGER.info(LOGGER_MESSAGE_RESPONSE_BEGIN);
        String result = xsltBuffer.toString();
        /*
         * try { result = HtmlUtils.injectCSS(new File(this.cssPath),result); }
         * catch (BadLocationException e) { // TODO Auto-generated catch block
         * e.printStackTrace(); }
         */
        OutputStreamWriter wrt = new OutputStreamWriter(outputStream);
        wrt.write(result);
        wrt.flush();
        LOGGER.info(LOGGER_MESSAGE_RESPONSE_DONE);

    }

    private static String getBeginLoggerMessage()
    {
        return LOGGER_MESSAGE_SUFFIX_BEGIN;
    }

    private static String getIOExceptionLoggerMessage(IOException e1)
    {
        return LOGGER_MESSAGE_IOEXCEPTION_PREFIX + e1.getMessage();
    }

    private static String getJDOMExceptionLoggerMessage(JDOMException e1)
    {
        return LOGGER_MESSAGE_JDOMEXCEPTION_PREFIX + e1.getMessage();
    }

    public ReportSerializer(String reportXSLTPath)
    {
    }

    public ReportSerializer(String reportXSLTPath, String cssPath)
    {
    }

}
