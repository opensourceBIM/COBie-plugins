package com.prairiesky.transform.template.schema.cobietab;

import java.util.function.Supplier;

import org.nibs.cobie.tab.AttributeType;
import org.nibs.cobie.tab.COBIEDocument;

import com.prairiesky.transform.template.schema.SpreadsheetTemplateTable;

public class AttributeTable extends SpreadsheetTemplateTable<AttributeRow>
{

	@Override
	public Supplier<AttributeRow> getRowSupplier()
	{
		return AttributeRow::new;
	}

	@Override
	public void populateFromCobie(COBIEDocument cobie)
	{
		if(cobie != null && cobie.getCOBIE() != null &&
				cobie.getCOBIE().getAttributes() != null &&
				cobie.getCOBIE().getAttributes().getAttributeList() != null)
		{
			for(AttributeType attribute : cobie.getCOBIE().getAttributes().getAttributeList())
			{
				AttributeRow row = newRow();
				row.populateFromCobieAttribute(attribute);
				insertRow(row);
			}
		}
	}

}
