package com.prairiesky.transform.template.schema.cobietab;

import java.util.function.Supplier;

import org.nibs.cobie.tab.COBIEDocument;
import org.nibs.cobie.tab.ZoneType;

import com.prairiesky.transform.template.schema.SpreadsheetTemplateTable;

public class ZoneTable extends SpreadsheetTemplateTable<ZoneRow>
{

	@Override
	public Supplier<ZoneRow> getRowSupplier()
	{
		return ZoneRow::new;
	}

	@Override
	public void populateFromCobie(COBIEDocument cobieDocument)
	{
		if(cobieDocument != null && cobieDocument.getCOBIE() != null &&
				cobieDocument.getCOBIE().getZones() != null &&
				cobieDocument.getCOBIE().getZones().getZoneList() != null)
		{
			for(ZoneType zone : cobieDocument.getCOBIE().getZones().getZoneList())
			{
				ZoneRow newRow = newRow();
				newRow.populateFromCobieZone(zone);
				insertRow(newRow);
			}
		}
		
	}

}
