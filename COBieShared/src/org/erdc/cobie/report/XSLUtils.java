package org.erdc.cobie.report;

import java.io.StringWriter;

import javax.xml.transform.Result;
import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import net.sf.saxon.TransformerFactoryImpl;

public class XSLUtils
{

    public static StringWriter transformInputSourceToStringWriter(
            Templates templates1,
            StreamSource targetFile,
            StreamSource xslFile,
            TransformerFactory tfactory)
    {
        TransformerFactoryImpl sTfac = (TransformerFactoryImpl)tfactory;
        sTfac.getConfiguration();

        // DocumentWrapper docw =
        // new DocumentWrapper((Node) doc.getRootElement(),
        // schemaTronRulePath2,config);

        // Document d1 = DocumentHelper.createDocument();

        try
        {
            templates1 = sTfac.newTemplates(xslFile);

        } catch (TransformerConfigurationException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        /*
         * try { th1 = stf.newTransformerHandler(templates1); } catch
         * (TransformerConfigurationException e) { // TODO Auto-generated catch
         * block e.printStackTrace(); }
         * 
         * t = th1.getTransformer();
         */
        Transformer transformer1 = null;
        try
        {
            transformer1 = templates1.newTransformer();
        } catch (TransformerConfigurationException e1)
        {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        // OutputFormat format = OutputFormat.createPrettyPrint();
        StringWriter buffer = new StringWriter();

        // XMLResult result = new XMLResult(buffer, format);
        Result gResult = new StreamResult(buffer);

        try
        {
            transformer1.transform(targetFile, gResult);
        } catch (TransformerException e1)
        {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        return buffer;
    }

}
