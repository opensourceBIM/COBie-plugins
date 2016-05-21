package org.bimserver.cobie.plugin.serializers;

import org.bimserver.cobie.shared.serialization.COBieSerializerPluginInfo;

public class COBieDesignXLSXSerializerPlugin extends COBieXLSXSerializerPlugin 
{
	
	private static final String COBIE_SPREADSHEET_XLSX_TEMPLATE_PATH ="lib/COBieDesignTemplate.xlsx";
	
	@Override
	protected COBieSerializerPluginInfo getCOBieSerializerInfo()
	{
		return COBieSerializerPluginInfo.SPREADSHEET_XLSX_DESIGN;
	}

	@Override
	protected String getXLSXTemplatePath()
	{
		return COBIE_SPREADSHEET_XLSX_TEMPLATE_PATH;
	}

}
