package com.prairiesky.transform.template.schema.cobietab;

import java.util.function.Supplier;

import org.nibs.cobie.tab.COBIEDocument;
import org.nibs.cobie.tab.SpareType;

import com.prairiesky.transform.template.schema.SpreadsheetTemplateTable;

public class SpareTable extends SpreadsheetTemplateTable<SpareRow>
{

	@Override
	public Supplier<SpareRow> getRowSupplier()
	{
		return SpareRow::new;
	}

	@Override
	public void populateFromCobie(COBIEDocument cobieDocument)
	{
		if(cobieDocument != null && cobieDocument.getCOBIE() != null
				&& cobieDocument.getCOBIE().getSpares() != null &&
				cobieDocument.getCOBIE().getSpares().getSpareList() != null)
		{
			for(SpareType spare : cobieDocument.getCOBIE().getSpares().getSpareList())
			{
				SpareRow newRow = newRow();
				newRow.populateFromCobieSpare(spare);
				insertRow(newRow);
			}
		}
		
	}

}
