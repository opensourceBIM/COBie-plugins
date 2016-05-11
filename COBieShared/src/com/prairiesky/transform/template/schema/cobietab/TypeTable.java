package com.prairiesky.transform.template.schema.cobietab;

import java.util.function.Supplier;

import org.nibs.cobie.tab.COBIEDocument;
import org.nibs.cobie.tab.TypeType;

import com.prairiesky.transform.template.schema.SpreadsheetTemplateTable;

public class TypeTable extends SpreadsheetTemplateTable<TypeRow>
{

	@Override
	public Supplier<TypeRow> getRowSupplier()
	{
		return TypeRow::new;
	}

	@Override
	public void populateFromCobie(COBIEDocument cobieDocument)
	{
		if(cobieDocument != null && cobieDocument.getCOBIE() != null &&
				cobieDocument.getCOBIE().getTypes() != null &&
				cobieDocument.getCOBIE().getTypes().getTypeList() != null)
		{
			for(TypeType type : cobieDocument.getCOBIE().getTypes().getTypeList())
			{
				TypeRow newRow = newRow();
				newRow.populateFromTypeRow(type);
				insertRow(newRow);
			}
		}
	}

}
