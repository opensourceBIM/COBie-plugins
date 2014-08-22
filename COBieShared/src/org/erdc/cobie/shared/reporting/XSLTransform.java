package org.erdc.cobie.shared.reporting;

import java.io.OutputStream;
import java.io.StringWriter;
import java.util.Properties;
import java.util.logging.Level;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import net.sf.saxon.Controller;
import net.sf.saxon.TransformerFactoryImpl;
import net.sf.saxon.serialize.MessageEmitter;
import net.sf.saxon.trans.XPathException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XSLTransform
{
    private Logger LOGGER = LoggerFactory.getLogger(XSLTransform.class);
    private TransformerFactoryImpl factory;
    private Transformer transformer;
    private StreamSource xslFile;
    private StreamSource targetFile;
    private Templates templates;
    public XSLTransform(StreamSource targetFile,
            StreamSource xslFile,
            TransformerFactory tfactory) throws TransformerConfigurationException, XPathException
    {
        

        factory = (TransformerFactoryImpl) tfactory;
        factory.setErrorListener(new ErrorListenerLogger(LOGGER));
        this.templates = factory.newTemplates(xslFile);
        this.transformer = templates.newTransformer();
        this.transformer.setErrorListener(new ErrorListenerLogger(LOGGER));
        if (transformer instanceof Controller)
        {
            Controller saxonController = (Controller) transformer;
            MessageEmitter emitter = new MessageEmitter();
            saxonController.setMessageEmitter(emitter);
           
            Properties properties = new Properties();
            properties.setProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            emitter.setOutputProperties(properties);
            emitter.setOutputStream(new LogOutputStream(LOGGER, Level.INFO));
            
        }
        this.targetFile = targetFile;
        this.setXslFile(xslFile);
      
    }
    
  

    public  StringWriter transform() throws TransformerException
    {    
        StringWriter buffer = new StringWriter();
        Result gResult = new StreamResult(buffer);
        transformer.transform(targetFile, gResult);
        return buffer;
    }

    public void transform(OutputStream outputStream) throws TransformerException
    {
        Result result = new StreamResult(outputStream);
        transformer.transform(targetFile, result);        
    }


    public TransformerFactoryImpl getFactory()
    {
        return factory;
    }



    public void setFactory(TransformerFactoryImpl factory)
    {
        this.factory = factory;
    }



    public Transformer getTransformer()
    {
        return transformer;
    }



    public void setTransformer(Transformer transformer)
    {
        this.transformer = transformer;
    }



    public StreamSource getXslFile()
    {
        return xslFile;
    }



    public void setXslFile(StreamSource xslFile)
    {
        this.xslFile = xslFile;
    }



    public StreamSource getTargetFile()
    {
        return targetFile;
    }



    public void setTargetFile(StreamSource targetFile)
    {
        this.targetFile = targetFile;
    }



    public Templates getTemplates()
    {
        return templates;
    }



    public void setTemplates(Templates templates)
    {
        this.templates = templates;
    }

}
