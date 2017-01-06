package com.prairiesky.transform.template.schema.cobietab;

import java.util.function.Supplier;

import org.nibs.cobie.tab.COBIEDocument;
import org.nibs.cobie.tab.CoordinateType;

import com.prairiesky.transform.template.schema.SpreadsheetTemplateTable;

public class CoordinateTable extends SpreadsheetTemplateTable<CoordinateRow>
{

	@Override
	public Supplier<CoordinateRow> getRowSupplier()
	{
		return CoordinateRow::new;
	}

	@Override
	public void populateFromCobie(COBIEDocument cobie)
	{
		if(cobie != null && cobie.getCOBIE() != null &&
				cobie.getCOBIE().getCoordinates() != null &&
				cobie.getCOBIE().getCoordinates().getCoordinateList() != null)
		{
			for(CoordinateType coordinate : cobie.getCOBIE().getCoordinates().getCoordinateList())
			{
				CoordinateRow row = newRow();
				row.populateFromCobieCoordinate(coordinate);
				insertRow(row);
			}
		}
	}

}
