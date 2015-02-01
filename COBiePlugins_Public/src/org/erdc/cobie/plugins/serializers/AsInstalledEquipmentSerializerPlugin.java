package org.erdc.cobie.plugins.serializers;

import java.util.Set;

import org.apache.poi.ss.usermodel.Workbook;
import org.bimserver.emf.Schema;
import org.erdc.cobie.shared.altova.mapping.AsInstalledEquipmentTemplateMapper;
import org.erdc.cobie.shared.altova.mapping.COBieLiteTemplateMapper;
import org.erdc.cobie.shared.bimserver.cobietab.serialization.COBieSerializerPluginInfo;

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

	@Override
	public Set<Schema> getSupportedSchemas() 
	{
		return Schema.IFC2X3TC1.toSet();
	}


}
