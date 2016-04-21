package com.prairiesky.transform.template.schema;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.apache.poi.ss.usermodel.Workbook;
import org.nibs.cobie.tab.COBIEDocument;

public abstract class ConstructionTemplateTable<T_ROW extends ConstructionTemplateRow>
{
	private List<T_ROW> rows = new ArrayList<>();
	
	public final T_ROW newRow()
	{
		return getRowSupplier().get();
	}
	
	public final void insertRow(T_ROW row)
	{
		rows.add(row);
	}
	
	public final List<T_ROW> getRows()
	{
		return rows;
	}
	
	public abstract Supplier<T_ROW> getRowSupplier();

	
	public abstract void populateFromCobie(COBIEDocument cobieDocument);
	
}
