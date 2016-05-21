package org.bimserver.cobie.shared.serialization;

import java.io.File;
import java.io.OutputStream;
import java.nio.file.Path;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bimserver.plugins.serializers.SerializerException;

import com.prairiesky.transform.cobieifc.settings.SettingsType;
import com.prairiesky.transform.template.CobieTabToCobieXLSXTransformer;

public class COBieXLSXSerializer extends COBieTabXMLSerializer 
{
	private final File xlsxTemplate;
	public COBieXLSXSerializer(File xlsxTemplate, File exportSettingsFile, SettingsType settings)
	{
		super(settings);
		this.xlsxTemplate = xlsxTemplate;
	}
	
	public COBieXLSXSerializer( Path xlsxTemplate, Path exportSettingsFile, SettingsType settings)
	{
		this(xlsxTemplate.toFile(), exportSettingsFile.toFile(), settings);
	}
	
	public File getXlsxTemplate() 
	{
		return xlsxTemplate;
	}

	@Override
	protected void writeCOBIE(OutputStream outputStream)
			throws SerializerException 
	{
		try 
		{
			CobieTabToCobieXLSXTransformer transformer =
					new CobieTabToCobieXLSXTransformer(getCOBieDocument(), new XSSFWorkbook(), WorkbookFactory.create(getXlsxTemplate()));
			Workbook result = transformer.transform();
			result.write(outputStream);
		} 
		catch (Exception e) 
		{
			throw new SerializerException(e);
		}
	}
	
	

}
