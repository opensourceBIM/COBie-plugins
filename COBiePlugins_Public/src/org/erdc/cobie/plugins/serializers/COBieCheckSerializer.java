package org.erdc.cobie.plugins.serializers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.xmlbeans.XmlException;
import org.bimserver.plugins.serializers.SerializerException;
import org.erdc.cobie.shared.COBieSheetXMLDataTransformable;
import org.erdc.cobie.sheetxmldata.COBIEDocument;
import org.erdc.cobie.utils.serializer.COBieSchematronChecker;
import org.slf4j.LoggerFactory;

public class COBieCheckSerializer extends COBieSheetXMLDataSerializer implements
		COBieSheetXMLDataTransformable
{
	private static final String LOGGER_MESSAGE_END_COMPLIANCE_REPORT = "COBie Compliance report done.";
	private static final String LOGGER_MSG_BEGIN_COMPLIANCE_REPORT = "Begin generating COBie compliance report.";

	{
		logger = LoggerFactory.getLogger(COBieCheckSerializer.class);
	}

	private COBieSchematronChecker checker;

	public COBieCheckSerializer(String schematronRulePath,
			String preProcessorPath, String svrlXSDPath, String svrlHTMLPath,
			String cssPath)
	{
		checker = createChecker(schematronRulePath, preProcessorPath,
				svrlXSDPath, svrlHTMLPath, cssPath);
	}

	public COBieSchematronChecker createChecker(String schematronRulePath,
			String preProcessorPath, String svrlXSDPath, String svrlHTMLPath,
			String cssPath)
	{
		return new COBieSchematronChecker(schematronRulePath, preProcessorPath,
				svrlXSDPath, svrlHTMLPath, cssPath);
	}

	@Override
	protected void finalize()
	{
		super.finalize();
		checker.setCOBie(getCOBieDocument());
	}

	@Override
	public void init(COBIEDocument cobie) throws SerializerException
	{
		super.init(cobie);
		checker.setCOBie(cobie);
	}

	public void init(InputStream cobieSheetXMLData) throws SerializerException,
			XmlException, IOException
	{
		init(COBIEDocument.Factory.parse(cobieSheetXMLData));
		checker.setCOBie(getCOBieDocument());
	}

	public void schematronReportToOutputStream(OutputStream outputStream)
			throws Exception
	{
		getLogger().info(LOGGER_MSG_BEGIN_COMPLIANCE_REPORT);
		checker.writeResult(outputStream);
		getLogger().info(LOGGER_MESSAGE_END_COMPLIANCE_REPORT);

	}

	@Override
	public void transformCOBieSheetXMLData(COBIEDocument cobieSheetXMLData,
			File targetExportFile) throws Exception
	{
		init(cobieSheetXMLData);
		writeCOBIE(new FileOutputStream(targetExportFile));
	}

	@Override
	protected void writeCOBIE(OutputStream outputStream)
			throws SerializerException
	{
		try
		{
			schematronReportToOutputStream(outputStream);
		}
		catch (Exception e)
		{
			throw new SerializerException(e);
		}
	}

}