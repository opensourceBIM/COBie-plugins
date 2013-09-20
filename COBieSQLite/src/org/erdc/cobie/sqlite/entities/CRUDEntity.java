package org.erdc.cobie.sqlite.entities;

import org.erdc.cobie.sqlite.Column;
import org.erdc.cobie.sqlite.Columns;

public abstract class CRUDEntity
{
	protected static final String STRING_NOT_NULL = "";
	
	private Columns columns = new Columns();
	
	protected final void addColumns(Columns columns)
	{
		for (Column<?> column : columns.toList())
		{
			getColumns().add(column);
		}
	}
	
	public final void clear()
	{
		for (final Column<?> column : getColumns().toList())
		{
			column.clear();
		}
	}

	public final Column<?> getColumn(String name)
	{
	    return columns.getColumn(name);
	}
	
	public final Columns getColumns()
	{
		return columns;
	}

	/**
	 * Returns the name of a {@code CRUDEntity}'s corresponding SQLite database table.
	 * 
	 * @return 
	 */
	public abstract String getTableName();

	/**
	 * This method resets a CRUDEntity to a "fresh" state. 
	 * This method should be used sparingly, generally only to make sure a CRUDEntity is fresh after it is first initialized.
	 */
	public final void reset()
	{
		for (final Column<?> column : getColumns().toList())
		{
			column.reset();
		}
	}
}
