package com.prairiesky.transform.template.schema.cobietab;

import java.util.function.Supplier;

import org.nibs.cobie.tab.COBIEDocument;
import org.nibs.cobie.tab.FloorType;

import com.prairiesky.transform.template.schema.SpreadsheetTemplateTable;

public class FloorTable extends SpreadsheetTemplateTable<FloorRow>
{

	@Override
	public Supplier<FloorRow> getRowSupplier()
	{
		return FloorRow::new;
	}

	@Override
	public void populateFromCobie(COBIEDocument cobieDocument)
	{
		if(cobieDocument != null && cobieDocument.getCOBIE() != null && 
				cobieDocument.getCOBIE().getFloors() != null && 
				cobieDocument.getCOBIE().getFloors().getFloorList() != null)
		{
			for(FloorType floor : cobieDocument.getCOBIE().getFloors().getFloorList())
			{
				FloorRow floorRow = newRow();
				floorRow.populateFromCobieFloor(floor);
				insertRow(floorRow);
			}
		}
		
	}

}
