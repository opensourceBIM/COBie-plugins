package com.prairiesky.transform.template.schema.cobietab;

import java.util.function.Supplier;

import org.nibs.cobie.tab.COBIEDocument;
import org.nibs.cobie.tab.ImpactType;

import com.prairiesky.transform.template.schema.SpreadsheetTemplateTable;

public class ImpactTable extends SpreadsheetTemplateTable<ImpactRow>
{

	@Override
	public Supplier<ImpactRow> getRowSupplier()
	{
		return ImpactRow::new;
	}

	@Override
	public void populateFromCobie(COBIEDocument cobieDocument)
	{
		if(cobieDocument != null && cobieDocument.getCOBIE() != null &&
				cobieDocument.getCOBIE().getImpacts() != null &&
				cobieDocument.getCOBIE().getImpacts().getImpactList() != null)
		{
			for (ImpactType impact : cobieDocument.getCOBIE().getImpacts().getImpactList())
			{
				ImpactRow newRow = newRow();
				newRow.populateFromCobieImpact(impact);
				insertRow(newRow);
			}
		}
	}

}
