package org.erdc.cobie.shared.altova.mapping;

import org.apache.poi.ss.usermodel.Workbook;
import org.erdc.cobie.cobieserver.generated.mappings.cobielite.COBieLiteMapToWarranties_ProductTypes;
import org.erdc.cobie.shared.utility.WorkbookCopierOptions;

import com.altova.io.Input;
import com.altova.io.Output;

public class ProductTypeWarrantyTemplateMapper extends COBieLiteTemplateMapper
{

	public ProductTypeWarrantyTemplateMapper(Workbook templateFile)
	{
		super(templateFile);
	}

	public ProductTypeWarrantyTemplateMapper(Workbook templateFile, WorkbookCopierOptions copierOptions)
	{
		super(templateFile, copierOptions);
	}

	@Override
	protected void mapCOBieLiteToWorkbook(Input input, Output output) throws Exception
	{
		
		COBieLiteMapToWarranties_ProductTypes mapper = new COBieLiteMapToWarranties_ProductTypes();
		mapper.run(input, output);

	}

}
