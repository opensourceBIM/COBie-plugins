package com.prairiesky.transform.template.schema;

import org.nibs.cobie.tab.TypeType;

import com.prairiesky.lang.Property;
import com.prairiesky.transform.template.meta.ExcelReference;
import com.prairiesky.transform.template.meta.ExcelReference.ColumnAddress;

@ExcelReference(spreadsheetName="Type")
public class TypeLookupRow extends ConstructionTemplateRow
{
//Type Name
	private final Property<String> typeName = new Property<>(String.class);

	@ExcelReference(columnAddress=ColumnAddress.A, columnName="Type Name", isPrimaryKey=true)
	public final Property<String> TypeName()
	{
		return typeName;
	}
	
	public void populateFromCobieType(TypeType type)
	{
		TypeName().set(type.getName());
	}
}
