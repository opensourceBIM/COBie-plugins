package org.erdc.cobie.sqlite.entity;

import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.Column;
import org.erdc.cobie.sqlite.Row;

public abstract class Range<T extends Number> extends CobieEntity
{
	public enum ColumnName
	{
		Minimum("Minimum"), 
		Maximum("Maximum");

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

	protected Range() throws CobieSQLiteException
	{
		super();
	}
	
	protected Range(Row row) throws CobieSQLiteException
	{
		super(row);
	}
	
	@SuppressWarnings("unchecked")
	public final T getMaximum() throws CobieSQLiteException
	{
		return (T)getColumn(ColumnName.Maximum.toString()).getValue();
	}

	@SuppressWarnings("unchecked")
	public final T getMinimum() throws CobieSQLiteException
	{
		return (T)getColumn(ColumnName.Minimum.toString()).getValue();
	}

	@Override
	protected Row makeRow() throws CobieSQLiteException
	{
    	Row row = new Row(
					new Column<>(Integer.class, ColumnName.Minimum.toString(), null), 
					new Column<>(Integer.class, ColumnName.Maximum.toString(), null));
    	
    	row.add(super.makeRow().getColumns());
    	
    	return row;
	}
	
	public final void setMaximum(T maximum) throws CobieSQLiteException
	{
		getColumn(ColumnName.Maximum.toString()).update(maximum);
	}

	public final void setMinimum(T minimum) throws CobieSQLiteException
	{
		getColumn(ColumnName.Minimum.toString()).update(minimum);
	}
}
