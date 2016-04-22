package org.bimserver.cobie.shared.serialization;

import java.io.File;
import java.io.OutputStream;
import java.nio.file.Path;

import org.bimserver.cobie.shared.transform.spreadsheetml.cobietab.COBieSpreadSheet;
import org.bimserver.cobie.shared.transform.spreadsheetml.xlsx.SpreadsheetMLToXLSXMapper;
import org.bimserver.cobie.shared.utility.POIUtils;
import org.bimserver.plugins.serializers.SerializerException;

public class COBieXLSXSerializer extends COBieSpreadsheetMLSerializer 
{
	private final File xlsxTemplate;
	public COBieXLSXSerializer(File spreadsheetMLTemplate, File xlsxTemplate, File exportSettingsFile)
	{
		super(spreadsheetMLTemplate, exportSettingsFile);
		this.xlsxTemplate = xlsxTemplate;
	}
	
	public COBieXLSXSerializer(Path spreadsheetMLTemplate, Path xlsxTemplate, Path exportSettingsFile)
	{
		this(spreadsheetMLTemplate.toFile(), xlsxTemplate.toFile(), exportSettingsFile.toFile());
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
			cobieSpreadsheet = new COBieSpreadSheet(getConfigurationFile(),
					exportOptions);
			cobieSpreadsheet.loadCOBie(getCOBieDocument());
			SpreadsheetMLToXLSXMapper mapper = 
					new SpreadsheetMLToXLSXMapper(cobieSpreadsheet, POIUtils.getWorkbook(getXlsxTemplate()));
			mapper.run();
			mapper.getOutput().write(outputStream);
		} 
		catch (Exception e) 
		{
			throw new SerializerException(e);
		}
	}
	
	

}
