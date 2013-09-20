package org.erdc.cobie.serializers;

import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;

import javax.xml.transform.TransformerException;

import org.bimserver.plugins.serializers.SerializerException;

import org.erdc.cobie.cobielite.FacilityFactory;
import org.erdc.cobie.report.ReportSerializer;
import org.erdc.cobie.sheetxmldata.COBIEDocument;

public class COBieLiteHTMLReportSerializer extends COBieHTMLReportSerializer
{

    public COBieLiteHTMLReportSerializer(String reportXSLTPath)
    {
        super(reportXSLTPath);
    }

    @Override
    protected void executeTransform(OutputStream outputStream) throws UnsupportedEncodingException, IOException, TransformerException
    {
        getLogger().info(getBeginLoggerMessage());
        ReportSerializer.executeSaxonXSLT(outputStream, toCOBieLite(getCOBieDocument())
                .toString().getBytes(DEFAULT_ENCODING), getReportXSLTPath());
    }

    private String toCOBieLite(COBIEDocument coBieDocument) throws IOException
    {
        FacilityFactory factory = new FacilityFactory();
        StringWriter wrt = new StringWriter();
        factory.parse(coBieDocument).save(wrt, org.erdc.cobie.cobielite.Settings.XML_Beans_Settings
                .getSaveSettings()); 
        wrt.flush();
        wrt.close();
        return wrt.toString();
    }
    
    @Override
    protected void writeCOBIE(OutputStream outputStream)
            throws SerializerException
    {
        try
        {
            executeTransform(outputStream);
        }
        catch (Exception e)
        {
            throw new SerializerException(e);
        }
        finally
        {
            try
            {
                outputStream.flush();
            } catch (IOException e)
            {

            }
            try
            {
                outputStream.close();
            } catch (IOException e)
            {

            }
        }

    }

}
