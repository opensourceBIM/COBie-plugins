package com.prairiesky.transform.template.schema.cobietab;

import java.util.function.Supplier;

import org.nibs.cobie.tab.COBIEDocument;
import org.nibs.cobie.tab.ComponentType;

import com.prairiesky.transform.template.schema.SpreadsheetTemplateTable;

public class ComponentTable extends SpreadsheetTemplateTable<ComponentRow>
{

	@Override
	public Supplier<ComponentRow> getRowSupplier()
	{
		return ComponentRow::new;
	}

	@Override
	public void populateFromCobie(COBIEDocument cobieDocument)
	{
		if(cobieDocument != null && cobieDocument.getCOBIE() != null &&
				cobieDocument.getCOBIE().getComponents() != null &&
				cobieDocument.getCOBIE().getComponents().getComponentList() != null)
		{
			for(ComponentType component : cobieDocument.getCOBIE().getComponents().getComponentList())
			{
				ComponentRow newRow = newRow();
				newRow.populateFromCobieComponent(component);
				insertRow(newRow);
			}
		}
	}

}
