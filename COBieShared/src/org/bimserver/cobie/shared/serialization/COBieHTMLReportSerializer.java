package org.bimserver.cobie.shared.serialization;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.xml.transform.TransformerException;

import org.apache.xmlbeans.XmlException;
import org.bimserver.cobie.shared.Common;
import org.bimserver.cobie.shared.cobietab.COBieTabTransformable;
import org.bimserver.cobie.shared.reporting.SaxonTransformer;
import org.bimserver.plugins.serializers.SerializerException;
import org.nibs.cobie.tab.COBIEDocument;
import org.slf4j.LoggerFactory;

public class COBieHTMLReportSerializer extends COBieTabXMLSerializer
		implements COBieTabTransformable
{
	private static final String LOGGER_MESSAGE_SUFFIX_BEGIN = "Begin XSL Transformation from COBieSheetXMLData to HTML.";
	private String reportXSLTPath;
	public String getReportXSLTPath()
    {
        return reportXSLTPath;
    }

    public void setReportXSLTPath(String reportXSLTPath)
    {
        this.reportXSLTPath = reportXSLTPath;
    }

    {
		logger = LoggerFactory.getLogger(COBieHTMLReportSerializer.class);
	}
	private SaxonTransformer reportSerializer;

	public COBieHTMLReportSerializer(String reportXSLTPath)
	{
		setReportSerializer(new SaxonTransformer(reportXSLTPath));
		this.reportXSLTPath = reportXSLTPath;
	}

	public COBieHTMLReportSerializer(String reportXSLTPath, String cssPath)
	{
		setReportSerializer(new SaxonTransformer(reportXSLTPath, cssPath));
		this.reportXSLTPath = reportXSLTPath;
	}

	protected void executeTransform(OutputStream outputStream)
			throws UnsupportedEncodingException, IOException, TransformerException, XmlException
	{

		getLogger().info(getBeginLoggerMessage());
		SaxonTransformer.executeSaxonXSLT(outputStream, getCOBieDocument()
				.toString().getBytes(Common.ENCODING_UTF8.toString()), reportXSLTPath);

	}

	protected String getBeginLoggerMessage()
	{
		return LOGGER_MESSAGE_SUFFIX_BEGIN;
	}

	public SaxonTransformer getReportSerializer()
	{
		return reportSerializer;
	}

	public void setReportSerializer(SaxonTransformer reportSerializer)
	{
		this.reportSerializer = reportSerializer;
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
