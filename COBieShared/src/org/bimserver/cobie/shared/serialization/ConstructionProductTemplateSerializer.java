package org.bimserver.cobie.shared.serialization;

import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bimserver.plugins.serializers.SerializerException;
import org.slf4j.LoggerFactory;

import com.prairiesky.transform.template.CobieToGeneralProductXLSXTransform;

public class ConstructionProductTemplateSerializer extends
		COBieTabXMLSerializer
{
	public ConstructionProductTemplateSerializer(Workbook blankTemplate)
	{
		this.blankTemplate = blankTemplate;
	}
	
	private static final String LOGGER_MESSAGE_END_SUFFIX = "End Serializing XLSX Template";

	private static final String LOGGER_MESSAGE_BEGIN_SUFFIX = "Begin Serializing XLSX Template";
	{logger = LoggerFactory
			.getLogger(getClass());}

	private Workbook workbook = new XSSFWorkbook();
	private final Workbook blankTemplate;
	@Override
	protected void writeCOBIE(OutputStream outputStream)
			throws SerializerException
	{
		logger.info(LOGGER_MESSAGE_BEGIN_SUFFIX);
		CobieToGeneralProductXLSXTransform transformer =
				new CobieToGeneralProductXLSXTransform(getCOBieDocument(), workbook, getBlankTemplate());
		Workbook workbook = transformer.transform();
		try
		{
			workbook.write(outputStream);
		}
		catch (IOException e)
		{
			throw new SerializerException(e);
		}
		logger.info(LOGGER_MESSAGE_END_SUFFIX);
	}
	public Workbook getBlankTemplate()
	{
		return blankTemplate;
	}

	
	
}
