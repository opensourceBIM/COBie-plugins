package org.erdc.cobie.shared.sqlite.serializers;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.buildingsmartalliance.docs.nbims03.cobie.core.AttributeDecimalValueType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.AttributeIntegerValueType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.AttributeMonetaryValueType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.AttributeStringValueType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.AttributeValueType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.BooleanValueType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.CobieComplexObjectType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.DecimalValueType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.IntegerValueType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.StringValueType;
import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.Query;
import org.erdc.cobie.sqlite.entities.AllowedString;
import org.erdc.cobie.sqlite.entities.CRUDEntity;
import org.erdc.cobie.sqlite.entities.CobieEntity;
import org.erdc.cobie.sqlite.entities.IntegerRange;
import org.erdc.cobie.sqlite.entities.RealRange;
import org.erdc.cobie.sqlite.entities.Unit;
import org.erdc.cobie.sqlite.entities.Value;

@Deprecated // The value insertions are getting hacky, but doing them the conventional way 
			// (i.e. with a ValueSerializer) is problematic...
			// Value probably needs to be redesigned with separate relationship tables b/c
			// AllowedString is 1-to-many (also for consistency).
public class Executor
{
	private static IntegerKey allowedStringKey = new IntegerKey();
	private static IntegerKey integerRangeKey = new IntegerKey();
	private static IntegerKey realRangeKey = new IntegerKey();
    private static IntegerKey unitKey = new IntegerKey();
    private static IntegerKey valueKey = new IntegerKey();
    
    private final Connection connection;
    
    public Executor(Connection connection)
    {
    	this.connection = connection;
    }
    
    public void clear(CRUDEntity entity) throws CobieSQLiteException
    {    	
    	Query query = new Query(entity);
        query.delete();      
        execute(query); 
    }
    
    protected void execute(Query query) throws CobieSQLiteException
    {
        Statement statement;
        
		try 
		{
			statement = connection.createStatement();
	        statement.executeUpdate(query.toString());
	        statement.close();
		} 
		
		catch (SQLException e) 
		{
			throw new CobieSQLiteException(this.getClass(), 
											"The following query could not be executed: '" + 
											query.toString() + 
											"' (" + e.getMessage() + 
											")");
		}
    }
    
    protected Connection getConnection()
    {
    	return connection;
    }
    
    private int insertAttributeValue(AttributeValueType attributeValueType) throws CobieSQLiteException
    {
    	Object valueType = null;
    	int allowedStringID = SQLiteSerializer.ID_NONE;
    	int integerRangeID = SQLiteSerializer.ID_NONE;
    	int realRangeID = SQLiteSerializer.ID_NONE;
    	
    	if (attributeValueType != null)
    	{
    		List<Object> valueTypes = new ArrayList<Object>();
	    	
	    	valueTypes.add(attributeValueType.getAttributeBooleanValue());
	    	valueTypes.add(attributeValueType.getAttributeDateTimeValue());
	    	valueTypes.add(attributeValueType.getAttributeDateValue());
	    	valueTypes.add(attributeValueType.getAttributeDecimalValue());
	    	valueTypes.add(attributeValueType.getAttributeIntegerValue());
	    	valueTypes.add(attributeValueType.getAttributeMonetaryValue());
	    	valueTypes.add(attributeValueType.getAttributeStringValue());
	    	valueTypes.add(attributeValueType.getAttributeTimeValue());
    	
    		for (Object v : valueTypes)
    		{
    			if (v != null)
    			{
    				if (v instanceof AttributeIntegerValueType)
    				{
    					try
    					{
	    					AttributeIntegerValueType attributeInteger = (AttributeIntegerValueType)v;
	    					
	    					long minValue = attributeInteger.getMinValueInteger().intValue();
	    					long maxValue = attributeInteger.getMaxValueInteger().intValue();
    					
	    					insertIntegerRange(new IntegerRange(), minValue, maxValue);
    					}
    					
    					catch (NullPointerException e)
    					{
    						// There might not be a min/max.
    					}
    				}
    				
    				else if (v instanceof AttributeDecimalValueType)
    				{
    					try
    					{
	    					AttributeDecimalValueType attributeDecimal = (AttributeDecimalValueType)v;
	    					
	    					double minValue = attributeDecimal.getMinValueDecimal();
	    					double maxValue = attributeDecimal.getMaxValueDecimal();
	    					
	    					insertRealRange(new RealRange(), minValue, maxValue);    					
    					}
    					
    					catch (NullPointerException e)
    					{
    						// There might not be a min/max.
    					}
    				}    					
    				
    				else if (v instanceof AttributeStringValueType)
    				{
    					try
    					{
    						String[] allowedStrings = ((AttributeStringValueType)v).getAllowedValues().getAttributeAllowedValueArray();
    						insertAllowedStrings(new AllowedString(), allowedStrings);
    						
    					}
    					
    					catch (NullPointerException e)
    					{
    						// There might not be any allowed values.
    					}   					
    				}
    				
    				valueType = v;
    				break;
    			}
    		}
    	}
    	
    	return insertObjectValue(valueType, allowedStringID, integerRangeID, realRangeID);
    }
        
    private int insertObjectValue(Object valueType, int allowedStringID, int integerRangeID, int realRangeID) throws CobieSQLiteException
    {
    	Value valueEntity = new Value();
    	String column = "";
    	Object value = null;
    	String unit = null;
    	
    	try
    	{	    	
    		if (valueType instanceof AttributeMonetaryValueType)
    		{
    			column = Value.ColumnName.MonetaryValue.toString();
    			
    			AttributeMonetaryValueType monetaryValue = (AttributeMonetaryValueType)valueType;    			
    			unit = monetaryValue.getMonetaryUnit().toString();
    			value = monetaryValue.getMonetaryValue();
    		}
    		
    		else if (valueType instanceof BooleanValueType)
    		{
    			column = Value.ColumnName.BooleanValue.toString();
    			
    			BooleanValueType booleanValue = (BooleanValueType)valueType;
    			unit = booleanValue.getUnitName();
    			value = booleanValue.getBooleanValue1();
    		}
    		
    		else if (valueType instanceof Calendar)
    		{
    			column = Value.ColumnName.DateTimeValue.toString();	    			
    			value = ((Calendar)valueType).getTime();
    		}    		
    		
    		else if (valueType instanceof DecimalValueType)
    		{
    			column = Value.ColumnName.DecimalValue.toString();
    			
    			DecimalValueType decimalValue = (DecimalValueType)valueType;
    			unit = decimalValue.getUnitName();
    			value = decimalValue.getDecimalValue();
    		}
    		
    		else if (valueType instanceof IntegerValueType)
    		{
    			column = Value.ColumnName.IntegerValue.toString();
    			
    			IntegerValueType integerValue = (IntegerValueType)valueType;
    			unit = integerValue.getUnitName();
    			value = integerValue.getIntegerValue();	    			
    		}
    		
    		else if (valueType instanceof StringValueType)
    		{
    			column = Value.ColumnName.StringValue.toString();
    			
    			StringValueType stringValue = (StringValueType)valueType;
    			unit = stringValue.getUnitName();
    			value = stringValue.getStringValue1();
    		}
    		
	    	else
	    	{
	    		throw new CobieSQLiteException(this.getClass(), "The supplied value type (" + valueType.getClass().getName() + ") is not currently supported.");
	    	}
    	}
    	
    	catch (NullPointerException e)
    	{
    		return SQLiteSerializer.ID_NONE;
    		//throw new SQLiteSerializerException("The supplied value is null.", e);
    	}
    	
    	return insertValue(valueEntity, column, value, unit, allowedStringID, integerRangeID, realRangeID);
    }
    
    protected int insertUnit(String unitName) throws CobieSQLiteException
    {
    	if (unitName != null)
    	{
    		Unit unit = new Unit();
    		unit.getColumn(CobieEntity.ColumnName.ID.toString()).update(unitKey.next());
    		unit.getColumn(Unit.ColumnName.UnitName.toString()).update(unitName);
    		    		
    		Query query = new Query(unit);
    		query.insert();
    		
    		execute(query);    		
    		unit.reset();
    	}
    	
    	return unitKey.get();
    }
    
    public void insertValidEntity(CRUDEntity entity, String columnName, Object value)
    {
    	if (value != null)
    	{
    		entity.getColumn(columnName).update(value);
    	}
    }
    
	public void insertValidKey(CRUDEntity entity, String columnName, int key)
	{
		if (key != SQLiteSerializer.ID_NONE)
		{
			entity.getColumn(columnName).update(key);
		}
	}
    
    public int insertValue(CobieComplexObjectType valueType) throws CobieSQLiteException
    {    		   
    	int key;
    	
		if (valueType instanceof AttributeValueType)
		{
			key = insertAttributeValue((AttributeValueType)valueType);
		}
		
		else 
		{
			key = insertObjectValue(valueType, SQLiteSerializer.ID_NONE, SQLiteSerializer.ID_NONE, SQLiteSerializer.ID_NONE);
		}
		
		return key;
    }
    
    private void insertAllowedStrings(AllowedString allowedString, String[] allowedStrings)
    {
    	for (String a : allowedStrings)
    	{
	    	insertValidKey(allowedString, CobieEntity.ColumnName.ID.toString(), allowedStringKey.next());
	    	insertValidKey(allowedString, AllowedString.ColumnName.RefValue.toString(), valueKey.get());
	    	insertValidEntity(allowedString, AllowedString.ColumnName.StringValue.toString(), a);
    	}
    }
    
    private int insertIntegerRange(IntegerRange integerRange, long min, long max) throws CobieSQLiteException
    {
    	if ((min != 0) && (max != 0))
    	{
	    	insertValidKey(integerRange, CobieEntity.ColumnName.ID.toString(), integerRangeKey.next());
	    	insertValidEntity(integerRange, IntegerRange.ColumnName.Minimum.toString(), min);
	    	insertValidEntity(integerRange, IntegerRange.ColumnName.Maximum.toString(), max);
	    	
	    	Query query = new Query(integerRange);
	    	query.insert();
	    	
	    	execute(query);
	    	integerRange.reset();
    	}
    	
    	return integerRangeKey.get();
    }
    
    private int insertRealRange(RealRange realRange, double min, double max) throws CobieSQLiteException
    {
    	if ((min != 0.0) && (max != 0.0))
    	{
	    	insertValidKey(realRange, CobieEntity.ColumnName.ID.toString(), realRangeKey.next());
	    	insertValidEntity(realRange, RealRange.ColumnName.Minimum.toString(), min);
	    	insertValidEntity(realRange, RealRange.ColumnName.Maximum.toString(), max);
	    	
	    	Query query = new Query(realRange);
	    	query.insert();
	    	
	    	execute(query);
	    	realRange.reset();
    	}
    	
    	return realRangeKey.get();
    }
    
    private int insertValue(Value value, 
    						String columnName, 
    						Object rawValue, 
    						String unit,
							int allowedStringID,
							int integerRangeID,
							int realRangeID) throws CobieSQLiteException
    {
    	insertValidKey(value, CobieEntity.ColumnName.ID.toString(), valueKey.next());
    	insertValidEntity(value, columnName, rawValue);
    	
    	if ((unit != null) && (unit != ""))
    	{
    		insertValidEntity(value, Value.ColumnName.RefUnit.toString(), insertUnit(unit));
    		
    		if (allowedStringID != SQLiteSerializer.ID_NONE)
    		{
    			insertValidKey(value, Value.ColumnName.RefAllowedString.toString(), allowedStringID);
    		}
    		
    		else if (integerRangeID != SQLiteSerializer.ID_NONE)
    		{
    			insertValidKey(value, Value.ColumnName.RefIntegerRange.toString(), integerRangeID);
    		}
    		
    		else if (realRangeID != SQLiteSerializer.ID_NONE)
    		{
    			insertValidKey(value, Value.ColumnName.RefRealRange.toString(), realRangeID);
    		}
    	}
    	
        Query query = new Query(value);
        query.insert();
        
        execute(query);            
        value.reset();  
        
        return valueKey.get();
    }
}