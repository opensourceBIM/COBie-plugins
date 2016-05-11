package com.prairiesky.transform.template.schema.cobietab;

import java.util.function.Supplier;

import org.nibs.cobie.tab.AssemblyType;
import org.nibs.cobie.tab.COBIEDocument;

import com.prairiesky.transform.template.schema.SpreadsheetTemplateTable;

public class AssemblyTable extends SpreadsheetTemplateTable<AssemblyRow>
{

	@Override
	public Supplier<AssemblyRow> getRowSupplier()
	{
		return AssemblyRow::new;
	}

	@Override
	public void populateFromCobie(COBIEDocument cobieDocument)
	{
		if(cobieDocument != null && cobieDocument.getCOBIE() != null 
				&& cobieDocument.getCOBIE().getAssemblies() != null &&
				cobieDocument.getCOBIE().getAssemblies().getAssemblyList() != null)
		{
			for(AssemblyType assembly : cobieDocument.getCOBIE().getAssemblies().getAssemblyList())
			{
				AssemblyRow newRow = newRow();
				newRow.populateFromCobieAssembly(assembly);
				insertRow(newRow);
			}
			
		}
		
	}

}
