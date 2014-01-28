package org.erdc.cobie.sqlite;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.erdc.cobie.sqlite.entity.Entity;
import org.erdc.cobie.sqlite.string.Error;

/**
 * {@code Row} represents a {@code ColumnSet} that defines the columns in a database row (or the
 * {@code Column}s in an {@code Entity}.
 * 
 * Unlike a simple {@code ColumnSet}, a {@code Row} must have unique {@code Column}s.
 * 
 * @author RDITLNBM
 *
 */
public class Row extends ColumnSet
{
	@SuppressWarnings("boxing")
	public static List<Row> makeRows(Entity entity, ResultSet results) throws CobieSQLiteException
	{
		List<Row> rows = new ArrayList<>();

		try
		{
			ResultSetMetaData metaData = results.getMetaData();
			int numColumns = metaData.getColumnCount();

			while (results.next())
			{
				Row row = new Row();

				for (int i = 1; i <= numColumns; i++)
				{
					String columnName = metaData.getColumnLabel(i);
					Column<?> column = entity.getColumn(columnName);
					Class<?> valueClass = column.getValueClass();

					if (valueClass.isAssignableFrom(Integer.class))
					{
						column.update(results.getInt(i));
					}

					else if (valueClass.isAssignableFrom(Long.class))
					{
						column.update(results.getLong(i));
					}

					else if (valueClass.isAssignableFrom(Short.class))
					{
						column.update(results.getShort(i));
					}

					else if (valueClass.isAssignableFrom(Float.class))
					{
						column.update(results.getFloat(i));
					}

					else if (valueClass.isAssignableFrom(Double.class))
					{
						column.update(results.getDouble(i));
					}

					else if (valueClass.isAssignableFrom(String.class))
					{
						column.update(results.getString(i));
					}

					else
					{
						throw new CobieSQLiteException(Row.class, Error.INVALID_COLUMN_TYPE.format(valueClass.getName()));
					}

					row.add(column);
				}

				rows.add(row);
			}
		}

		catch (SQLException e)
		{
			throw new CobieSQLiteException(Row.class, Error.ROW_INSTANTIATION_FAILURE.toString(), e);
		}

		return rows;
	}
	
	public Row(Column<?>... columns) throws CobieSQLiteException
	{
		add(columns);
	}
	
	public Row(ColumnSet columns) throws CobieSQLiteException
	{
		add(columns);
	}

	/**
	 * Adds the supplied {@code Column} to this {@code Row}.
	 * 
	 * If the supplied {@code Column} is already a member of this {@code Row}, the {@code Column} is updated.
	 * 
	 * @param column The {@code Column} to add.
	 * @throws CobieSQLiteException
	 */
	public void add(Column<?> column) throws CobieSQLiteException
	{
		String columnName = column.getName();

		if (!doesColumnExist(column))
		{
			getColumns().add(column);
		}

		else
		{
			getColumn(columnName).update(column.getValue());
		}
	}

	public void add(Column<?>... columns) throws CobieSQLiteException
	{
		for (Column<?> column : columns)
		{
			add(column);
		}
	}

	public void add(ColumnSet columns) throws CobieSQLiteException
	{
		add(columns.getColumns());
	}

	public void add(List<Column<?>> columns) throws CobieSQLiteException
	{
		for (Column<?> column : columns)
		{
			add(column);
		}
	}

	private boolean doesColumnExist(Column<?> column)
	{
		boolean columnExists = false;
		
		try
		{
			getColumn(column.getName());			
		}
		
		catch (CobieSQLiteException e)
		{
			// No code needed; This failed b/c there is no matching column.
		}
		
		return columnExists;
	}
}
