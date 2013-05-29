package org.erdc.cobie.plugins.serializers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import org.bimserver.plugins.serializers.SerializerException;
import org.erdc.cobie.report.ReportSerializer;
import org.erdc.cobie.shared.COBieSheetXMLDataTransformable;
import org.erdc.cobie.sheetxmldata.COBIEDocument;
import org.slf4j.LoggerFactory;

public class COBieHTMLReportSerializer extends COBieSheetXMLDataSerializer
		implements COBieSheetXMLDataTransformable
{

	private static final String DEFAULT_ENCODING = "UTF-8";

	private static final String LOGGER_MESSAGE_SUFFIX_BEGIN = "Begin XSL Transformation from COBieSheetXMLData to HTML.";
	private String reportXSLTPath;
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
			throws UnsupportedEncodingException, IOException
	{

		getLogger().info(getBeginLoggerMessage());
		ReportSerializer.executeSaxonXSLT(outputStream, getCOBieDocument()
				.toString().getBytes(DEFAULT_ENCODING), reportXSLTPath);

	}

	private String getBeginLoggerMessage()
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

	}

}
