package org.erdc.cobie.sqlite.entity;

import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.Column;
import org.erdc.cobie.sqlite.Row;

public abstract class Entity
{
	protected static final String STRING_NOT_NULL = "";
	
	private final Row row;
	
	protected Entity() throws CobieSQLiteException
	{
		row = makeRow();
	}
	
	protected Entity(Row row) throws CobieSQLiteException
	{
		this();
		addRow(row);
	}
	
	/**
	 * Adds a {@code Row} to this {@code Entity}.
	 * 
	 * Be aware that an {@code Entity} can only contain one {@code Row}, but {@code Column}s
	 * can be added to an {@code Entity} in row-form (or partial row-form) for convenience. 
	 * 
	 * {@code Column}s that are already contained by this {@code Entity} will be updated.
	 * @throws CobieSQLiteException 
	 */
	@SuppressWarnings("hiding")
	public final void addRow(Row row) throws CobieSQLiteException
	{
		getRow().add(row);
	}
	
	public final void clear()
	{
		for (final Column<?> column : getRow().getColumns())
		{
			column.clear();
		}
	}

	public final Column<?> getColumn(String name) throws CobieSQLiteException
	{
	    return getRow().getColumn(name);
	}
	
	public final Row getRow()
	{		
		return row;
	}

	/**
	 * Returns the name of a {@code Entity}'s corresponding SQLite database table.
	 * 
	 * @return The name of an {@code Entity}'s corresponding SQLite database table.
	 */
	public abstract String getTableName();
	
	/**
	 * Gets an {@code Entity}'s default {@code Row} with empty {@code Column} values.
	 * 
	 * Implementors of this method should make <strong>ABSOLUTELY SURE</strong> to instantiate 
	 * all of an {@code Entity}'s {@code Column}s so that their types and key status are defined.
	 * 
	 * @throws CobieSQLiteException
	 */
	protected abstract Row makeRow() throws CobieSQLiteException;
	
	/**
	 * This method resets a CRUDEntity to a "fresh" state.
	 *  
	 * This method should be used sparingly, generally only to make sure a {@code Entity}
	 * is fresh after it is first initialized.
	 */
	public final void reset()
	{
		for (final Column<?> column : getRow().getColumns())
		{
			column.reset();
		}
	}
}
