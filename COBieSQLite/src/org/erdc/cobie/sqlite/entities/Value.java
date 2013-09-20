package org.erdc.cobie.sqlite.entities;

import org.erdc.cobie.sqlite.Column;
import org.erdc.cobie.sqlite.Columns;

public class Value extends CobieEntity
{
    public enum ColumnName
    {
        BooleanValue("BooleanValue"),
        DateTimeValue("DateTimeValue"),
        DateValue("DateValue"),
        DecimalValue("DecimalValue"),
        IntegerValue("IntegerValue"),
        MonetaryValue("MonetaryValue"),
        RefAllowedString("RefAllowedString"),
        RefIntegerRange("RefIntegerRange"),
        RefRealRange("RefRealRange"),
        RefUnit("RefUnit"),
        StringValue("StringValue"),
        TimeValue("TimeValue");        

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
    
    public Value()
    {
        super();
        
        Columns columns = new Columns(
                new Column<String>(ColumnName.BooleanValue.toString(), null),
                new Column<String>(ColumnName.DateTimeValue.toString(), null),
                new Column<String>(ColumnName.DateValue.toString(), null),
                new Column<Float>(ColumnName.DecimalValue.toString(), null),
                new Column<Integer>(ColumnName.IntegerValue.toString(), null),
                new Column<Float>(ColumnName.MonetaryValue.toString(), null),
                new Column<Integer>(ColumnName.RefAllowedString.toString(), null),
                new Column<Integer>(ColumnName.RefIntegerRange.toString(), null),
                new Column<Integer>(ColumnName.RefRealRange.toString(), null),
                new Column<Integer>(ColumnName.RefUnit.toString(), null),
                new Column<String>(ColumnName.StringValue.toString(), null),
                new Column<String>(ColumnName.TimeValue.toString(), null));
        
        addColumns(columns);
    }
    
    @Override
    public String getName()
    {
    	return "Some value";
    }
    
    @Override
    public String getTableName()
    {
        return "Value";
    }
}
