package org.erdc.cobie.plugins.serializers;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.erdc.cobie.shared.altova.mapping.COBieLiteTemplateMapper;
import org.erdc.cobie.shared.altova.mapping.ProductTypeWarrantyTemplateMapper;
import org.erdc.cobie.shared.bimserver.cobietab.serialization.COBieSerializerPluginInfo;

public class ProductTypeWarrantySerializerPlugin extends COBieTemplateSerializerPlugin
{
	private static final String TEMPLATE_PATH = "lib/COBieTemplates/Warranties-ProductTypes.xlsx";
	@Override
	public String getTemplateFilePath()
	{
		return TEMPLATE_PATH;
	}

	@Override
	public COBieLiteTemplateMapper getMapper(Workbook workbook) throws FileNotFoundException, IOException
	{
		return new ProductTypeWarrantyTemplateMapper(workbook);
	}

	@Override
	protected COBieSerializerPluginInfo getCOBieSerializerInfo()
	{
		return COBieSerializerPluginInfo.PRODUCT_TYPE_WARRANTY;
	}

}
