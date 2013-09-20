package org.erdc.cobie.sqlite.entities;

import org.erdc.cobie.sqlite.Column;
import org.erdc.cobie.sqlite.Columns;

public class Document extends CobieAttributesEntity 
{
	public enum ColumnName
	{	
		DocumentCategory("DocumentCategory"),
		DocumentDescription("DocumentDescription"),		
		DocumentName("DocumentName"),
		DocumentReferenceURI("DocumentReferenceURI"),
		DocumentURI("DocumentURI");

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

	public Document()
	{
		super();
		
		Columns columns = new Columns(
				new Column<String>(ColumnName.DocumentCategory.toString(), null),
				new Column<String>(ColumnName.DocumentDescription.toString(), null),
				new Column<String>(ColumnName.DocumentName.toString(), null),
				new Column<String>(ColumnName.DocumentReferenceURI.toString(), null),
				new Column<String>(ColumnName.DocumentURI.toString(), null));
				
		addColumns(columns);
	}
	
	@Override
	public String getName()
	{
		return (String)getColumn(ColumnName.DocumentName.toString()).getValue();
	}
	
	@Override
	public String getTableName() 
	{
		return "Document";
	}
}
