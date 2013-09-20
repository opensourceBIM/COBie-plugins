package org.erdc.cobie.sqlite.entities;

import org.erdc.cobie.sqlite.Column;
import org.erdc.cobie.sqlite.Columns;

public class Zone extends CobieAttributesEntity
{
    public enum ColumnName
    {
        ZoneCategory("ZoneCategory"),
        ZoneDescription("ZoneDescription"),
        ZoneName("ZoneName");

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

    public Zone()
    {
    	super();
    	
    	Columns columns = new Columns(
    			new Column<String>(ColumnName.ZoneCategory.toString(), null),
    			new Column<String>(ColumnName.ZoneDescription.toString(), null),
    			new Column<String>(ColumnName.ZoneName.toString(), CobieEntity.STRING_NOT_NULL));
    	
    	addColumns(columns);
    }
    
    @Override
    public String getName()
    {
    	return (String)getColumn(ColumnName.ZoneName.toString()).getValue();
    }
    
	@Override
	public String getTableName() 
	{
		return "Zone";
	}
}
