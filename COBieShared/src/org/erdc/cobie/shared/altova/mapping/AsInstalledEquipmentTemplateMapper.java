package org.erdc.cobie.shared.altova.mapping;

import org.apache.poi.ss.usermodel.Workbook;
import org.erdc.cobie.cobieserver.generated.mappings.cobielite.CobieLiteMapToAsInstalledEquipment;
import org.erdc.cobie.shared.utility.WorkbookCopierOptions;

import com.altova.io.Input;
import com.altova.io.Output;

public class AsInstalledEquipmentTemplateMapper extends COBieLiteTemplateMapper
{

	public AsInstalledEquipmentTemplateMapper(Workbook templateFile)
	{
		super(templateFile);
	}

	public AsInstalledEquipmentTemplateMapper(Workbook templateFile, WorkbookCopierOptions copierOptions)
	{
		super(templateFile, copierOptions);
	}

	@Override
	protected void mapCOBieLiteToWorkbook(Input input, Output output) throws Exception
	{
		CobieLiteMapToAsInstalledEquipment map = new CobieLiteMapToAsInstalledEquipment();
		map.run(input, output);
	}

}
