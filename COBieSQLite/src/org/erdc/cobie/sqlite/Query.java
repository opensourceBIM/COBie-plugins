package org.erdc.cobie.sqlite;

import java.util.List;

import org.erdc.cobie.shared.enums.string.Common;
import org.erdc.cobie.shared.utils.StringTable;
import org.erdc.cobie.shared.utils.StringUtils;
import org.erdc.cobie.sqlite.entity.Entity;

public class Query
{    
	private static class TemplateHelper
	{
		public enum ClausePart implements StringTable
		{
			AND("AND %s"),		
			AND_EQUALS(AND + Common.EQUALS.toString() + "%s");
			
			private final String clausePart;
			
			private ClausePart(String clausePart)
			{
				this.clausePart = clausePart;
			}
	
			@Override
			public String format(Object... args)
			{
				return String.format(clausePart, args);
			}
	
			@Override
			public String postfix(String s)
			{
				return StringUtils.concatenate(clausePart, s, Common.TEXT_SEPARATOR.toString());
			}
	
			@Override
			public String prefix(String s)
			{
				return StringUtils.concatenate(s, clausePart, Common.TEXT_SEPARATOR.toString());
			}
			
			@Override
			public final String toString()
			{
				return clausePart;
			}
		}
		
		public enum ClauseTemplate implements StringTable
		{
			ON("ON %"),
			ON_EQUALS(ON + Common.EQUALS.toString() + "%s"),
			WHERE("WHERE %s"),
			WHERE_EQUALS(WHERE + Common.EQUALS.toString() + "%s");
			
			private final String clauseTemplate;
			
			private ClauseTemplate(String clauseTemplate)
			{
				this.clauseTemplate = clauseTemplate;
			}
	
			@Override
			public String format(Object... args)
			{
				return String.format(clauseTemplate, args);
			}
	
			@Override
			public String postfix(String s)
			{
				return StringUtils.concatenate(clauseTemplate, s, Common.TEXT_SEPARATOR.toString());
			}
	
			@Override
			public String prefix(String s)
			{
				return StringUtils.concatenate(s, clauseTemplate, Common.TEXT_SEPARATOR.toString());
			}
			
			@Override
			public final String toString()
			{
				return clauseTemplate;
			}
		}
		
		public enum QueryTemplate implements StringTable
		{
			COUNT("SELECT COUNT(*) FROM %s %s"), 
			DELETE("DELETE FROM %s\n%s"),
			GET_LAST_INSERT_ROWID("SELECT last_insert_rowid()"),
			INSERT("INSERT INTO %s (%s)\nVALUES (%s) %s"),
			JOIN("SELECT %s\nFROM %s\nJOIN %s\n%s"),
			SELECT("SELECT %s\nFROM %s\n%s"),
			UPDATE("UPDATE %s\n%s\n%s");		
		
			private final String queryTemplate;
			
			private QueryTemplate(String queryTemplate)
			{
				this.queryTemplate = queryTemplate;
			}
	
			@Override
			public String format(Object... args)
			{
				return String.format(queryTemplate, args);
			}
	
			@Override
			public String postfix(String s)
			{
				return StringUtils.concatenate(queryTemplate, s, Common.TEXT_SEPARATOR.toString());
			}
	
			@Override
			public String prefix(String s)
			{
				return StringUtils.concatenate(s, queryTemplate, Common.TEXT_SEPARATOR.toString());
			}
			
			@Override
			public final String toString()
			{
				return queryTemplate;
			}
		}
		
		public static final String ON_ANY = Common.EMPTY_STRING.toString();
		public static final String WHERE_ANY = Common.EMPTY_STRING.toString(); 
		
		private static String addQuotesIfNeeded(Object value)
		{
		    String valueString = Common.EMPTY_STRING.toString();
		    
	        if ((value == null) || (value == Common.EMPTY_STRING.toString()))
	        {
	            valueString = null;
	        }
		       
	        else if ((value instanceof String) || !(value instanceof Number))
		    {
		        valueString = StringUtils.quotifySingle(value.toString());
		    }
	        
		    else
		    {
		        valueString = value.toString();
		    }
	        
	        return valueString;
		}
		
		public static String getColumnListing(ColumnSet columns)
		{
			final List<String> columnsNames = columns.getNames();
			String columnListing = "";
			
			columnListing = columnsNames.get(0);
			int numNames = columnsNames.size();
			
			if (numNames > 1)
			{
				for (int i = 1; i < numNames; i++)
				{
					columnListing += Common.COMMA_TEXT.toString() + columnsNames.get(i);
				}
			}
			
			return columnListing;
		}
		
		private static String getClauseForMatchingColumns(ClauseTemplate clauseTemplate, ColumnSet matches)
		{
			List<Column<?>> columns = matches.getColumns();
			Column<?> firstColumn = columns.get(0);
			
			String clause = String.format(
								clauseTemplate.toString(),
								firstColumn.getName(),
								addQuotesIfNeeded(firstColumn.getValue()));
			
			for (int i = 1; i < columns.size(); i++)
			{
				Column<?> keyColumn = columns.get(i);
				
				clause += String.format(
							ClausePart.AND.toString(), 
							keyColumn.getName(), 
							addQuotesIfNeeded(keyColumn.getValue()));
			}
			
			return clause;
		}
		
		public static String getOnMatchingColumns(ColumnSet matches)
		{
			return getClauseForMatchingColumns(ClauseTemplate.ON_EQUALS, matches);
		}
		
		public static String getValueListing(ColumnSet columns)
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
	                
	                valueListing += Common.COMMA_TEXT.toString() + valueString;
	            }
	        }
	        
	        return valueListing;
		}
			
		public static String getWhereKeysMatch(Entity entity)
		{		
			return getWhereColumnsMatch(entity.getRow().getKeyColumns());
		}
		
		/**
		 * Returns a SQL where clause that checks for equality for the supplied {@code ColumnSet}.
		 * 
		 * @param row A {@code ColumnSet} containing the {@code Column}s to match.
		 * @return A SQL where clause that restricts a query to equal supplied {@code ColumnSet}.
		 */
		public static String getWhereColumnsMatch(ColumnSet matches)
		{
			return getClauseForMatchingColumns(ClauseTemplate.WHERE_EQUALS, matches);
		}
	}
	
	private final Entity entity;	
	private String query;
	private QueryResultType resultType;
		
	public Query(Entity entity)
	{
		this.entity = entity;
	}
	
	// Counting ///
	
	public void count()
	{
		count(TemplateHelper.WHERE_ANY);
	}
	
	public void count(String where)
	{
		setResultType(QueryResultType.RESULT);
		query = TemplateHelper.QueryTemplate.COUNT.format(query, getEntity().getTableName(), where);
	}
	
	////////////////
	
	// Deletions ///
	
	public void delete()
	{
	    delete(TemplateHelper.WHERE_ANY);
	}
	
	public void delete(String where)
	{
		setResultType(QueryResultType.NO_RESULT);
	    query = TemplateHelper.QueryTemplate.DELETE.format(query, getEntity().getTableName(), where);
	}
	
	public void deleteWhereKeysMatch()
	{
	    delete(TemplateHelper.getWhereKeysMatch(getEntity()));
	}
	
	////////////////
	
	private Entity getEntity()
	{
		return entity;
	}
	
	// Results /////
	
	public void getLastInsertRowID()
	{
		setResultType(QueryResultType.RESULT);
		query = TemplateHelper.QueryTemplate.GET_LAST_INSERT_ROWID.toString();		
	}
	
	public QueryResultType getResultType()
	{
		return resultType;
	}
	
	////////////////
	
	// Insertions //
	
	public void insert()
	{		
	    insert(getEntity().getRow());
	}
	
	public void insert(ColumnSet columns)
	{
		insert(columns, TemplateHelper.WHERE_ANY);
	}
	
	public void insert(ColumnSet columns, String where)
	{
		setResultType(QueryResultType.INSERT_RESULT);
		
	    query = TemplateHelper.QueryTemplate.INSERT.format(
	    			query, 
	    			getEntity().getTableName(), 
	    			TemplateHelper.getColumnListing(columns), 
	    			TemplateHelper.getValueListing(columns),
	    			where);
	}
	
	////////////////
	
	// Joins ///////
	
	public void join(Entity joinEntity)
	{
		join(this.getEntity().getRow(), joinEntity, TemplateHelper.ON_ANY);
	}
	
	public void join(ColumnSet columns, Entity joinEntity, String on)
	{
		setResultType(QueryResultType.RESULT);
		
		query = TemplateHelper.QueryTemplate.JOIN.format(
					TemplateHelper.getColumnListing(columns), 
					getEntity().getTableName(), 
					joinEntity.getTableName(), 
					on);
	}
	
	/**
	 * Builds a SQL query that selects the supplied {@code ColumnSet} and joins the results with
	 * the supplied {@code Entity} based on the matching {@code ColumnSet}.
	 * 
	 * e.g.
	 * 
	 * {@code columns = { column1, column2, column3 }}
	 * {@code joinEntity = entity2 }
	 * {@code matches = { match1, match2 }}
	 * 
	 * Would result in this query:
	 * 
	 * 	SELECT column1.name, column2.name, column3.name
	 * 	FROM entity (supplied in constructor)
	 * 	JOIN entity2
	 * 	ON match1.name = match2.value AND match2.name = match2.value
	 * 
	 * @param columns A {@code ColumnSet} to select
	 * @param joinEntity An {@code Entity} to join
	 * @param matches A {@code ColumnSet} containing {@code Column} values to match
	 */
	public void joinOnMatchingValues(ColumnSet columns, Entity joinEntity, ColumnSet matches)
	{
		join(columns, joinEntity, TemplateHelper.getOnMatchingColumns(matches));
	}
	
	////////////////
	
	// Selections //
	
	public void select(String where)
	{
		select(getEntity().getRow(), where);
	}
	
	public void select(ColumnSet columns, String where)
	{
		setResultType(QueryResultType.RESULT);
		
		query = TemplateHelper.QueryTemplate.SELECT.format(
				TemplateHelper.getColumnListing(columns), 
				getEntity().getTableName(), 
				where);
	}

	public void selectAll()
	{
		selectAll(getEntity().getRow());
	}

	public void selectAll(ColumnSet columns)
	{
		select(columns, TemplateHelper.WHERE_ANY);
	}

	public void selectByKeys()
	{
		selectByKeys(getEntity().getRow());
	}

	public void selectByKeys(ColumnSet columns)
	{
		select(columns, TemplateHelper.getWhereKeysMatch(getEntity()));
	}
	
	public void selectByMatchingValues(ColumnSet matches)
	{
		selectByMatchingValues(getEntity().getRow(), matches);
	}
	
	/**
	 * Builds a SQL query that selects the supplied {@code ColumnSet} based on the matching {@code ColumnSet}.
	 *  
	 * e.g.
	 * 
	 * {@code columns = { column1, column2, column3 }}
	 * {@code matches = { match1, match2 }}
	 * 
	 * Would result in this query:
	 * 
	 * 	SELECT column1.name, column2.name, column3.name 
	 * 	FROM entity (supplied in constructor)
	 * 	WHERE match1.name = match1.value AND match2.name = match2.value
	 * 
	 * @param columns A {@code ColumnSet} to select
	 * @param matches A {@code ColumnSet} containing {@code Column} values to match
	 */
	public void selectByMatchingValues(ColumnSet columns, ColumnSet matches)
	{
		select(columns, TemplateHelper.getWhereColumnsMatch(matches));
	}
	
	////////////////
	
	private void setResultType(QueryResultType resultType)
	{
		this.resultType = resultType;
	}
	
	@Override
    public String toString()
    {
        return query;
    }
	
	// Updates /////
	
	public void updateWhere(ColumnSet columns, ColumnSet matches)
	{
		setResultType(QueryResultType.NO_RESULT);
		
		query = TemplateHelper.QueryTemplate.UPDATE.format(
					getEntity().getTableName(), 
					TemplateHelper.getColumnListing(columns), 
					TemplateHelper.getWhereColumnsMatch(matches));
	}

	////////////////
}
