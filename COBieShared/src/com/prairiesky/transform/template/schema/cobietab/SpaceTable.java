package com.prairiesky.transform.template.schema.cobietab;

import java.util.function.Supplier;

import org.nibs.cobie.tab.COBIEDocument;
import org.nibs.cobie.tab.SpaceType;

import com.prairiesky.transform.template.schema.SpreadsheetTemplateTable;

public class SpaceTable extends SpreadsheetTemplateTable<SpaceRow>
{

	@Override
	public Supplier<SpaceRow> getRowSupplier()
	{
		return SpaceRow::new;
	}

	@Override
	public void populateFromCobie(COBIEDocument cobieDocument)
	{
		if(cobieDocument != null && cobieDocument.getCOBIE() != null &&
				cobieDocument.getCOBIE().getSpaces() != null &&
				cobieDocument.getCOBIE().getSpaces().getSpaceList() != null)
		{
			for(SpaceType space : cobieDocument.getCOBIE().getSpaces().getSpaceList())
			{
				SpaceRow newRow = newRow();
				newRow.populateFromCobieSpace(space);
				insertRow(newRow);
			}
		}
		
	}

}
