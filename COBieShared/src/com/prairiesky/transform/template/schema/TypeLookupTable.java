package com.prairiesky.transform.template.schema;

import java.util.function.Supplier;

import org.nibs.cobie.tab.COBIEDocument;
import org.nibs.cobie.tab.TypeType;

public class TypeLookupTable extends ConstructionTemplateTable<TypeLookupRow>
{

	@Override
	public Supplier<TypeLookupRow> getRowSupplier()
	{
		return TypeLookupRow::new;
	}

	@Override
	public void populateFromCobie(COBIEDocument cobieDocument)
	{
		if(cobieDocument.getCOBIE() != null && cobieDocument.getCOBIE().getTypes() != null && cobieDocument.getCOBIE().getTypes().getTypeList() != null)
		{
			for(TypeType type : cobieDocument.getCOBIE().getTypes().getTypeList())
			{
				TypeLookupRow row = newRow();
				row.populateFromCobieType(type);
				insertRow(row);
			}
		}
		
	}

}
