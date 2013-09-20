package org.erdc.cobie.sqlite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Columns
{
	private final Map<String, Column<?>> columns = new HashMap<String, Column<?>>();

	public Columns(final Column<?>... columns)
	{
		add(columns);
	}

	public void add(final Column<?> column)
	{
		columns.put(column.getName(), column);
	}

	public void add(final Column<?>... columns)
	{
		for (final Column<?> updateInfo : columns)
		{
			add(updateInfo);
		}
	}

	public Column<?> getColumn(final String name)
	{
		Column<?> column = columns.get(name);
		
		if (column == null)
		{
			throw new NullPointerException("The specified column [" + name + "] does not exist in this collection.");
		}
		
		return column;
	}

	public Columns getKeyColumns()
	{
		final Columns keyColumns = new Columns();

		for (final String name : columns.keySet())
		{
			final Column<?> column = columns.get(name);

			if (column.isKey())
			{
				keyColumns.add(column);
			}
		}

		return keyColumns;
	}

	public List<String> getNames()
	{
		final List<String> names = new ArrayList<String>();

		for (final String name : columns.keySet())
		{
			final Column<?> column = columns.get(name);
			names.add(column.getName());
		}

		return names;
	}

	public Columns getStaleColumns()
	{
		final Columns staleColumns = new Columns();

		for (final String name : columns.keySet())
		{
			final Column<?> column = columns.get(name);

			if (!column.isFresh())
			{
				staleColumns.add(column);
			}
		}

		return staleColumns;
	}

	public List<Object> getValues()
	{
	    final List<Object> values = new ArrayList<Object>();
	    
	    for (Column<?> column : toList())
	    {
	        values.add(column.getValue());
	    }
	    
	    return values;
	}
	
	public int size()
	{
		return toList().size();
	}

	public List<Column<?>> toList()
	{
		return new ArrayList<Column<?>>(columns.values());
	}
}
