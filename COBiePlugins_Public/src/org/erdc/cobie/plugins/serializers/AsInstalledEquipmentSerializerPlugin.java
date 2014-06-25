package org.erdc.cobie.plugins.serializers;

import org.apache.poi.ss.usermodel.Workbook;
import org.erdc.cobie.shared.enums.COBieSerializerPluginInfo;
import org.erdc.cobie.shared.mapping.AsInstalledEquipmentTemplateMapper;
import org.erdc.cobie.shared.mapping.COBieLiteTemplateMapper;

public class AsInstalledEquipmentSerializerPlugin extends COBieTemplateSerializerPlugin
{
	private static final String TEMPLATE_PATH = "lib/COBieTemplates/InstalledEquipment/InstalledProducts-General.xlsx";
//	private static final String TEMPLATE_PATH = "lib/COBieTemplates/A_AsInstalledEquipment.xlsm";
	
	@Override
	public COBieLiteTemplateMapper getMapper(Workbook workbook)
	{
		AsInstalledEquipmentTemplateMapper mapper = null;
		mapper = new AsInstalledEquipmentTemplateMapper(workbook);
		return mapper;
	}

	@Override
	protected COBieSerializerPluginInfo getCOBieSerializerInfo()
	{
		return COBieSerializerPluginInfo.AS_INSTALLED_EQUIPMENT;
	}
	

	@Override
	public String getTemplateFilePath()
	{
		return TEMPLATE_PATH;
	}


}
