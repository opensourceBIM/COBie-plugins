package org.erdc.cobie.serializers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.xml.transform.TransformerException;

import org.bimserver.plugins.serializers.SerializerException;
import org.erdc.cobie.report.ReportSerializer;
import org.erdc.cobie.shared.COBieSheetXMLDataTransformable;
import org.erdc.cobie.sheetxmldata.COBIEDocument;
import org.slf4j.LoggerFactory;

public class COBieHTMLReportSerializer extends COBieSheetXMLDataSerializer
		implements COBieSheetXMLDataTransformable
{

	protected static final String DEFAULT_ENCODING = "UTF-8";

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
	private ReportSerializer reportSerializer;

	public COBieHTMLReportSerializer(String reportXSLTPath)
	{
		setReportSerializer(new ReportSerializer(reportXSLTPath));
		this.reportXSLTPath = reportXSLTPath;
	}

	public COBieHTMLReportSerializer(String reportXSLTPath, String cssPath)
	{
		setReportSerializer(new ReportSerializer(reportXSLTPath, cssPath));
		this.reportXSLTPath = reportXSLTPath;
	}

	protected void executeTransform(OutputStream outputStream)
			throws UnsupportedEncodingException, IOException, TransformerException
	{

		getLogger().info(getBeginLoggerMessage());
		ReportSerializer.executeSaxonXSLT(outputStream, getCOBieDocument()
				.toString().getBytes(DEFAULT_ENCODING), reportXSLTPath);

	}

	protected String getBeginLoggerMessage()
	{
		return LOGGER_MESSAGE_SUFFIX_BEGIN;
	}

	public ReportSerializer getReportSerializer()
	{
		return reportSerializer;
	}

	public void setReportSerializer(ReportSerializer reportSerializer)
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
