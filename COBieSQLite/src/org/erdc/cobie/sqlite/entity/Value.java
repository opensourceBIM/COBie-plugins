package org.erdc.cobie.sqlite.entity;

import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.Column;
import org.erdc.cobie.sqlite.Row;

public final class Value extends CobieEntity
{
	public enum ColumnName
	{
		BooleanValue("BooleanValue"), 
		DateTimeValue("DateTimeValue"), 
		DateValue("DateValue"), 
		DecimalValue("DecimalValue"), 
		IntegerValue("IntegerValue"), 
		MonetaryValue("MonetaryValue"), 
		RefAllowedString("RefAllowedString"), 
		RefIntegerRange("RefIntegerRange"), 
		RefRealRange("RefRealRange"), 
		RefUnit("RefUnit"), 
		StringValue("StringValue"), 
		TimeValue("TimeValue");

		private String columName;

		private ColumnName(final String columnName)
		{
			columName = columnName;
		}

		@Override
		public final String toString()
		{
			return columName;
		}
	}

	public Value() throws CobieSQLiteException
	{
		super();
	}
	
	public Value(Row row) throws CobieSQLiteException
	{
		super(row);
	}
	
	public final String getBooleanValue() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.BooleanValue.toString()).getValue();
	}

	public final String getDateTimeValue() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.DateTimeValue.toString()).getValue();
	}

	public final String getDateValue() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.DateValue.toString()).getValue();
	}

	@SuppressWarnings("boxing")
	public final float getDecimalValue() throws CobieSQLiteException
	{
		return (Float)getColumn(ColumnName.DecimalValue.toString()).getValue();
	}

	@SuppressWarnings("boxing")
	public final int getIntegerValue() throws CobieSQLiteException
	{
		return (Integer)getColumn(ColumnName.IntegerValue.toString()).getValue();
	}

	@SuppressWarnings("boxing")
	public final float getMonetaryValue() throws CobieSQLiteException
	{
		return (Float)getColumn(ColumnName.MonetaryValue.toString()).getValue();
	}

	@SuppressWarnings("boxing")
	public final int getRefAllowedString() throws CobieSQLiteException
	{
		return (Integer)getColumn(ColumnName.RefAllowedString.toString()).getValue();
	}

	@SuppressWarnings("boxing")
	public final int getRefIntegerRange() throws CobieSQLiteException
	{
		return (Integer)getColumn(ColumnName.RefIntegerRange.toString()).getValue();
	}

	@SuppressWarnings("boxing")
	public final int getRefRealRange() throws CobieSQLiteException
	{
		return (Integer)getColumn(ColumnName.RefRealRange.toString()).getValue();
	}

	@SuppressWarnings("boxing")
	public final int getRefUnit() throws CobieSQLiteException
	{
		return (Integer)getColumn(ColumnName.RefUnit.toString()).getValue();
	}

	public final String getStringValue() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.StringValue.toString()).getValue();
	}

	@Override
	public String getTableName()
	{
		return "Value";
	}

	public final String getTimeValue() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.TimeValue.toString()).getValue();
	}

	@Override
	protected Row makeRow() throws CobieSQLiteException
	{
		Row row = new Row(
					new Column<>(String.class, ColumnName.BooleanValue.toString(), null), 
					new Column<>(String.class, ColumnName.DateTimeValue.toString(), null), 
					new Column<>(String.class, ColumnName.DateValue.toString(), null), 
					new Column<>(Float.class, ColumnName.DecimalValue.toString(), null), 
					new Column<>(Integer.class, ColumnName.IntegerValue.toString(), null), 
					new Column<>(Float.class, ColumnName.MonetaryValue.toString(), null), 
					new Column<>(Integer.class, ColumnName.RefAllowedString.toString(), null), 
					new Column<>(Integer.class, ColumnName.RefIntegerRange.toString(), null), 
					new Column<>(Integer.class, ColumnName.RefRealRange.toString(), null), 
					new Column<>(Integer.class, ColumnName.RefUnit.toString(), null), 
					new Column<>(String.class, ColumnName.StringValue.toString(), null), 
					new Column<>(String.class, ColumnName.TimeValue.toString(), null));
		
    	row.add(super.makeRow().getColumns());
    	
    	return row;
	}
	
	public final void setBooleanValue(String booleanValue) throws CobieSQLiteException
	{
		getColumn(ColumnName.BooleanValue.toString()).update(booleanValue);
	}

	public final void setDateTimeValue(String dateTimeValue) throws CobieSQLiteException
	{
		getColumn(ColumnName.DateTimeValue.toString()).update(dateTimeValue);
	}

	public final void setDateValue(String dateValue) throws CobieSQLiteException
	{
		getColumn(ColumnName.DateValue.toString()).update(dateValue);
	}

	@SuppressWarnings("boxing")
	public final void setDecimalValue(float decimalValue) throws CobieSQLiteException
	{
		getColumn(ColumnName.DecimalValue.toString()).update(decimalValue);
	}

	@SuppressWarnings("boxing")
	public final void setIntegerValue(int integerValue) throws CobieSQLiteException
	{
		getColumn(ColumnName.IntegerValue.toString()).update(integerValue);
	}

	@SuppressWarnings("boxing")
	public final void setMonetaryValue(float monetaryValue) throws CobieSQLiteException
	{
		getColumn(ColumnName.MonetaryValue.toString()).update(monetaryValue);
	}

	@SuppressWarnings("boxing")
	public final void setRefAllowedString(int refAllowedString) throws CobieSQLiteException
	{
		getColumn(ColumnName.RefAllowedString.toString()).update(refAllowedString);
	}

	@SuppressWarnings("boxing")
	public final void setRefIntegerRange(int refIntegerRange) throws CobieSQLiteException
	{
		getColumn(ColumnName.RefIntegerRange.toString()).update(refIntegerRange);
	}

	@SuppressWarnings("boxing")
	public final void setRefRealRange(int refRealRange) throws CobieSQLiteException
	{
		getColumn(ColumnName.RefRealRange.toString()).update(refRealRange);
	}

	@SuppressWarnings("boxing")
	public final void setRefUnit(int refUnit) throws CobieSQLiteException
	{
		getColumn(ColumnName.RefUnit.toString()).update(refUnit);
	}

	public final void setStringValue(String stringValue) throws CobieSQLiteException
	{
		getColumn(ColumnName.StringValue.toString()).update(stringValue);
	}

	public final void setTimeValue(String timeValue) throws CobieSQLiteException
	{
		getColumn(ColumnName.TimeValue.toString()).update(timeValue);
	}
}
