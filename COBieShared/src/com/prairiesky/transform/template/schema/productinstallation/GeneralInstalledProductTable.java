package com.prairiesky.transform.template.schema.productinstallation;

import java.util.function.Supplier;

public class GeneralInstalledProductTable extends ConstructionProductTemplateTable<GeneralInstalledProduct>
{

	@Override
	public Supplier<GeneralInstalledProduct> getRowSupplier()
	{
		return GeneralInstalledProduct::new;
	}

}
