package com.prairiesky.transform.template.schema.cobietab;

import java.util.function.Supplier;

import org.nibs.cobie.tab.COBIEDocument;
import org.nibs.cobie.tab.FacilityType;

import com.prairiesky.transform.template.schema.SpreadsheetTemplateTable;

public class FacilityTable extends SpreadsheetTemplateTable<FacilityRow>
{

	@Override
	public Supplier<FacilityRow> getRowSupplier()
	{
		return FacilityRow::new;
	}

	@Override
	public void populateFromCobie(COBIEDocument cobieDocument)
	{
		if(cobieDocument != null && cobieDocument.getCOBIE() != null && 
				cobieDocument.getCOBIE().getFacilities() != null && 
				cobieDocument.getCOBIE().getFacilities().getFacilityList() != null)
		{
			for(FacilityType facility : cobieDocument.getCOBIE().getFacilities().getFacilityList())
			{
				FacilityRow facilityRow = newRow();
				facilityRow.populateFromCobieFacility(facility);
				insertRow(facilityRow);
			}
		}
	}

}
