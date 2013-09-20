package org.erdc.cobie.sqlite.entities;

import org.erdc.cobie.sqlite.Column;
import org.erdc.cobie.sqlite.Columns;

public abstract class CobieAttributesEntity extends CobieEntity
{
	public enum ColumnName
	{	
		ExternalEntityName("externalEntityName"),
		ExternalID("externalID"),
		ExternalSystemName("externalSystemName");

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
	
	protected CobieAttributesEntity()
	{
		super();
		
		Columns columns = new Columns(
			new Column<String>(ColumnName.ExternalEntityName.toString(), null),
			new Column<String>(ColumnName.ExternalID.toString(), null),
			new Column<String>(ColumnName.ExternalSystemName.toString(), null));
		
		addColumns(columns);
	}
}
