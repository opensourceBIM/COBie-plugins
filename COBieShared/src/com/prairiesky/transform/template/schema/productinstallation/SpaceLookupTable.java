package com.prairiesky.transform.template.schema.productinstallation;

import java.util.function.Supplier;

import org.nibs.cobie.tab.COBIEDocument;
import org.nibs.cobie.tab.SpaceType;

import com.prairiesky.transform.template.schema.SpreadsheetTemplateTable;

public class SpaceLookupTable extends SpreadsheetTemplateTable<SpaceLookupRow>
{

	@Override
	public Supplier<SpaceLookupRow> getRowSupplier()
	{
		return SpaceLookupRow::new;
	}

	@Override
	public void populateFromCobie(COBIEDocument cobieDocument)
	{
		if(cobieDocument.getCOBIE() != null && cobieDocument.getCOBIE().getSpaces() != null && cobieDocument.getCOBIE().getSpaces().getSpaceList() != null)
		{
			for(SpaceType space : cobieDocument.getCOBIE().getSpaces().getSpaceList())
			{
				SpaceLookupRow row = newRow();
				row.populateFromCobieSpace(space);
				insertRow(row);
			}
		}
		
	}

}
