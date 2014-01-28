package org.erdc.cobie.sqlite.entity;

import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.Column;
import org.erdc.cobie.sqlite.Row;

public final class Document extends CobieAttributesEntity
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

	public Document() throws CobieSQLiteException
	{
		super();
	}
	
	public Document(Row row) throws CobieSQLiteException
	{
		super(row);
	}
	
	public final String getDocumentCategory() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.DocumentCategory.toString()).getValue();
	}

	public final String getDocumentDescription() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.DocumentDescription.toString()).getValue();
	}

	public final String getDocumentName() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.DocumentName.toString()).getValue();
	}

	public final String getDocumentReferenceURI() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.DocumentReferenceURI.toString()).getValue();
	}

	public final String getDocumentURI() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.DocumentURI.toString()).getValue();
	}

	@Override
	public String getTableName()
	{
		return "Document";
	}

	@Override
	protected Row makeRow() throws CobieSQLiteException
	{
    	Row row = new Row(
					new Column<>(String.class, ColumnName.DocumentCategory.toString(), null), 
					new Column<>(String.class, ColumnName.DocumentDescription.toString(), null), 
					new Column<>(String.class, ColumnName.DocumentName.toString(), null), 
					new Column<>(String.class, ColumnName.DocumentReferenceURI.toString(), null), 
					new Column<>(String.class, ColumnName.DocumentURI.toString(), null));
    	
    	row.add(super.makeRow().getColumns());
    	
    	return row;
	}
	
	public final void setDocumentCategory(String documentCategory) throws CobieSQLiteException
	{
		getColumn(ColumnName.DocumentCategory.toString()).update(documentCategory);
	}

	public final void setDocumentDescription(String documentDescription) throws CobieSQLiteException
	{
		getColumn(ColumnName.DocumentDescription.toString()).update(documentDescription);
	}

	public final void setDocumentName(String documentName) throws CobieSQLiteException
	{
		getColumn(ColumnName.DocumentName.toString()).update(documentName);
	}

	public final void setDocumentReferenceURI(String documentReferenceURI) throws CobieSQLiteException
	{
		getColumn(ColumnName.DocumentReferenceURI.toString()).update(documentReferenceURI);
	}

	public final void setDocumentURI(String documentURI) throws CobieSQLiteException
	{
		getColumn(ColumnName.DocumentURI.toString()).update(documentURI);
	}
}
