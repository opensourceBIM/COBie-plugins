package com.prairiesky.transform.template.schema.cobietab;

import java.util.function.Supplier;

import org.nibs.cobie.tab.COBIEDocument;
import org.nibs.cobie.tab.SystemType;

import com.prairiesky.transform.template.schema.SpreadsheetTemplateTable;

public class SystemTable extends SpreadsheetTemplateTable<SystemRow>
{

	@Override
	public Supplier<SystemRow> getRowSupplier()
	{
		return SystemRow::new;
	}

	@Override
	public void populateFromCobie(COBIEDocument cobieDocument)
	{
		if(cobieDocument != null && cobieDocument.getCOBIE() != null &&
				cobieDocument.getCOBIE().getSystems() != null &&
				cobieDocument.getCOBIE().getSystems().getSystemList() != null)
		{
			for(SystemType system : cobieDocument.getCOBIE().getSystems().getSystemList())
			{
				SystemRow newRow = newRow();
				newRow.populateFromCobieSystem(system);
				insertRow(newRow);
			}
		}
		
	}

}
