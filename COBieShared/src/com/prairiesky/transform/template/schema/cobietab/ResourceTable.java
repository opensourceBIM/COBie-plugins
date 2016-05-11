package com.prairiesky.transform.template.schema.cobietab;

import java.util.function.Supplier;

import org.nibs.cobie.tab.COBIEDocument;
import org.nibs.cobie.tab.ResourceType;

import com.prairiesky.transform.template.schema.SpreadsheetTemplateTable;

public class ResourceTable extends SpreadsheetTemplateTable<ResourceRow>
{

	@Override
	public Supplier<ResourceRow> getRowSupplier()
	{
		return ResourceRow::new;
	}

	@Override
	public void populateFromCobie(COBIEDocument cobieDocument)
	{
		if(cobieDocument != null && cobieDocument.getCOBIE() != null && cobieDocument.getCOBIE().getResources() != null &&
				cobieDocument.getCOBIE().getResources().getResourceList() != null)
		{
			for(ResourceType resource : cobieDocument.getCOBIE().getResources().getResourceList())
			{
				ResourceRow newRow = newRow();
				newRow.populateFromCobieResource(resource);
				insertRow(newRow);
			}
		}
	}

}
