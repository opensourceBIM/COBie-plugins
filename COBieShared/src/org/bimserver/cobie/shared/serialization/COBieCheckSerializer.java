package org.bimserver.cobie.shared.serialization;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.xmlbeans.XmlException;
import org.bimserver.cobie.shared.cobietab.COBieTabTransformable;
import org.bimserver.cobie.shared.reporting.COBieSchematronChecker;
import org.bimserver.cobie.shared.reporting.COBieSchematronCheckerSettings;
import org.bimserver.plugins.serializers.SerializerException;
import org.nibs.cobie.tab.COBIEDocument;
import org.slf4j.LoggerFactory;

public class COBieCheckSerializer extends COBieTabXMLSerializer implements
		COBieTabTransformable
{
	private static final String LOGGER_MESSAGE_END_COMPLIANCE_REPORT = "COBie Compliance report done.";
	private static final String LOGGER_MSG_BEGIN_COMPLIANCE_REPORT = "Begin generating COBie compliance report.";

	{
		logger = LoggerFactory.getLogger(COBieCheckSerializer.class);
	}

	private COBieSchematronChecker checker;

	public COBieCheckSerializer(COBieSchematronCheckerSettings settings)
	{
		checker = new COBieSchematronChecker(settings);
	}

	public void init(InputStream cobieSheetXMLData) throws SerializerException,
			XmlException, IOException
	{
		init(COBIEDocument.Factory.parse(cobieSheetXMLData));
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
		    getLogger().info(LOGGER_MSG_BEGIN_COMPLIANCE_REPORT);
	        checker.setCOBie(getCOBieDocument());
	        checker.writeResult(outputStream);
	        getLogger().info(LOGGER_MESSAGE_END_COMPLIANCE_REPORT);

		}
		catch (Exception e)
		{
			throw new SerializerException(e);
		}
	}

}