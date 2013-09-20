package org.erdc.cobie.sqlite;

import java.util.List;

import org.erdc.cobie.sqlite.entities.CRUDEntity;

public class Query
{    
	private static final String COLUMNS = "{columns}";
	private static final String TABLE = "{table}";
    private static final String VALUES = "{values}";
	private static final String WHERE = "{where}";

	private static final String DELETE_TEMPLATE = "DELETE FROM " + TABLE + WHERE + ";";
	private static final String INSERT_TEMPLATE = "INSERT INTO " + TABLE + " (" + COLUMNS + ") VALUES (" + VALUES + ");";
	private static final String SELECT_TEMPLATE = "SELECT " + COLUMNS + " FROM " + TABLE + " " + WHERE + ";";
	
	private static String addQuotesIfNeeded(Object value)
	{
	    String valueString = "";
	    
        if ((value == null) || (value == ""))
        {
            valueString = null;
        }
	       
        else if (value instanceof String)
	    {
	        valueString = "'" + value + "'";
	    }
	    
	    else if (!(value instanceof Number))
        {
            valueString = "'" + value.toString() + "'";
        }
        
	    else
	    {
	        valueString = value.toString();
	    }
        
        return valueString;
	}
	
	private static String getColumnListing(final Columns columns)
	{
		final List<String> columnsNames = columns.getNames();
		String columnListing = "";
		
		columnListing = columnsNames.get(0);
		int numNames = columnsNames.size();
		
		if (numNames > 1)
		{
			for (int i = 1; i < numNames; i++)
			{
				columnListing += ", " + columnsNames.get(i);
			}
		}
		
		return columnListing;
	}

	private static String getValueListing(final Columns columns)
	{
        final List<Object> columnValues = columns.getValues();
        String valueListing = "";
        
        valueListing = addQuotesIfNeeded(columnValues.get(0));
        int numValues = columnValues.size();
        
        if (numValues > 1)
        {
            for (int i = 1; i < numValues; i++)
            {
                Object value = columnValues.get(i);
                String valueString = (value != null) ? addQuotesIfNeeded(value) : null;
                
                valueListing += ", " + valueString;
            }
        }
        
        return valueListing;
	}
	
	private static String getValueArgumentListing(final Columns columns)
	{
        final List<Object> columnValues = columns.getValues();
        String valueListing = "";
        
        valueListing = "?";
        int numValues = columnValues.size();
        
        if (numValues > 1)
        {
            for (int i = 1; i < numValues; i++)
            {
                valueListing += ", " + "?";
            }
        }
        
        return valueListing;
	}
	
	private static Object[] getValues(final Columns columns)
	{
        final List<Object> columnValues = columns.getValues();
        Object[] values = new Object[columnValues.size()];
        
        for (int i = 1; i < values.length; i++)
        {
            values[i] = columnValues.get(i);
        }
        
        return values;
	}
	
	public static String getWhereKeysMatch(final CRUDEntity entity)
	{
		final List<Column<?>> keyColumns = entity.getColumns().getKeyColumns().toList();

		final Column<?> firstColumn = keyColumns.get(0);
		String whereClause = "WHERE " + firstColumn.getName() + " = " + firstColumn.getValue();

		for (int i = 1; i < keyColumns.size(); i++)
		{
			Column<?> keyColumn = keyColumns.get(i);
			whereClause += " AND " + keyColumn.getName() + " = " + keyColumn.getValue();
		}

		return whereClause;
	}

	private final CRUDEntity entity;
	private String query;

	public Query(final CRUDEntity entity)
	{
		this.entity = entity;
	}
	
	public void delete()
	{
	    delete("");
	}
	
	public void delete(final String where)
	{
	    query = DELETE_TEMPLATE;
        query = query.replace(TABLE, entity.getTableName());
        query = query.replace(WHERE, where);
	}
	
	public void deleteWhereKeysMatch()
	{
	    delete(getWhereKeysMatch(entity));
	}
	
	public void insert()
	{
	    insert(entity.getColumns().getStaleColumns());
	}
	
	public void insert(final Columns columns)
	{
	    query = INSERT_TEMPLATE;
	    query = query.replace(TABLE, entity.getTableName());
	    query = query.replace(COLUMNS, getColumnListing(columns));
	    query = query.replace(VALUES, getValueListing(columns));
	}
	
	public void select(final Columns columns, final String where)
	{
		selectAll(columns);
		query = query.replace(WHERE, where);
	}

	public void select(final String where)
	{
		select(entity.getColumns(), where);
	}

	public void selectAll()
	{
		selectAll(entity.getColumns());
	}

	public void selectAll(final Columns columns)
	{
		query = SELECT_TEMPLATE;
		query = query.replace(COLUMNS, getColumnListing(columns));
		query = query.replace(TABLE, entity.getTableName());
	}

	public void selectByKeys()
	{
		selectByKeys(entity.getColumns());
	}

	public void selectByKeys(final Columns columns)
	{
		select(columns, getWhereKeysMatch(entity));
	}

	@Override
    public String toString()
    {
        return query;
    }
}
