package org.erdc.cobie.sqlite;

import java.util.ArrayList;
import java.util.List;

import org.erdc.cobie.sqlite.string.Error;

/**
 * {@code ColumnSet} represents an immutable set of {@code Column}s.
 * 
 * It is intended as a lightweight way to encapsulate {@code Column} sets for building queries,
 * pairing column names with their associated values, etc.
 * 
 * @author RDITLNBM
 * 
 */
public class ColumnSet
{
	private List<Column<?>> columns = new ArrayList<>();
	
	public ColumnSet(Column<?>... columns)
	{
		for (Column<?> column : columns)
		{
			getColumns().add(column);
		}
	}
	
	public ColumnSet(List<Column<?>> columns)
	{
		this.columns = columns;
	}
	
	public final List<Column<?>> getColumns()
	{
		return columns;
	}
	
	public Column<?> getColumn(String name) throws CobieSQLiteException
	{
		Column<?> matchingColumn = null;

		for (Column<?> column : getColumns())
		{
			if (column.getName().equals(name))
			{
				matchingColumn = column;
				break;
			}
		}
		
		if (matchingColumn == null)
		{
			throw new CobieSQLiteException(this.getClass(), Error.COLUMN_DOES_NOT_EXIST.format(name));
		}

		return matchingColumn;
	}
	
	public ColumnSet getKeyColumns()
	{
		List<Column<?>> keys = new ArrayList<>();
		
		for (Column<?> column : getColumns())
		{
			if (column.isKey())
			{
				keys.add(column);
			}
		}
		
		return new ColumnSet(keys);
	}
	
	public List<String> getNames()
	{
		List<String> names = new ArrayList<>();
		
		for (Column<?> column : getColumns())
		{
			names.add(column.getName());
		}
		
		return names;
	}
	
	public ColumnSet getStaleColumns()
	{
		List<Column<?>> staleColumns = new ArrayList<>();
		
		for (Column<?> column : getColumns())
		{
			if (!column.isFresh())
			{
				staleColumns.add(column);
			}
		}
		
		return new ColumnSet(staleColumns);
	}
	
	public List<Object> getValues()
	{
		List<Object> values = new ArrayList<>();
		
		for (Column<?> column : getColumns())
		{
			values.add(column.getValue());
		}
		
		return values;
	}
	
	public int size()
	{
		return getColumns().size();
	}
}
