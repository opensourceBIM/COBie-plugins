package org.erdc.cobie.sqlite.service;

import java.sql.Connection;
import java.sql.ResultSet;
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
import org.erdc.cobie.sqlite.entity.AllowedString;
import org.erdc.cobie.sqlite.entity.CobieEntity;
import org.erdc.cobie.sqlite.entity.Entity;
import org.erdc.cobie.sqlite.entity.IntegerRange;
import org.erdc.cobie.sqlite.entity.RealRange;
import org.erdc.cobie.sqlite.entity.Unit;
import org.erdc.cobie.sqlite.entity.Value;
import org.erdc.cobie.sqlite.string.Error;

// TODO The value insertions are getting hacky, but doing them the conventional way 
// (i.e. with a ValueSerializer) is problematic...
// Value probably needs to be redesigned with separate relationship tables b/c
// AllowedString is 1-to-many (also for consistency).
public final class Executor
{
	private static final int DEFAULT_RESULT_SET_INDEX = 1;

	public static final int ID_NONE = -1;
	
	private static DatabaseKey allowedStringKey = new DatabaseKey();
	private static DatabaseKey integerRangeKey = new DatabaseKey();
	private static DatabaseKey realRangeKey = new DatabaseKey();
    private static DatabaseKey unitKey = new DatabaseKey();
    private static DatabaseKey valueKey = new DatabaseKey();
        
    private final Connection connection;
    private ResultSet lastResult;
    
    public Executor(Connection connection)
    {
    	this.connection = connection;
    }
    
    public void clear(Entity entity) throws CobieSQLiteException
    {    	
    	Query query = new Query(entity);
        query.delete();      
        execute(query); 
    }
    
    // The statement will close automatically eventually. Closing the statement manually 
    // can throw it's own exception and complicates retrieving query results.
    @SuppressWarnings("resource")
	protected void execute(Query query) throws CobieSQLiteException
    {
        Statement statement;
        
		try 
		{
			statement = connection.createStatement();
			
			switch (query.getResultType())
			{
				case INSERT_RESULT:					
				case NO_RESULT:
					
					statement.executeUpdate(query.toString());					
					break;
					
				case RESULT:					
				default:
					
					lastResult = statement.executeQuery(query.toString());	
					break;				
			}
		} 
		
		catch (SQLException e) 
		{
			throw new CobieSQLiteException(
					this.getClass(), Error.QUERY_EXECUTION_FAILED.format(query.toString(), e.getMessage()));
		}
    }
    
    protected Connection getConnection()
    {
    	return connection;
    }
    
    public long getLastInsertID() throws CobieSQLiteException
    {
    	long id = ID_NONE;
    	
    	Query query = new Query(null);
    	query.getLastInsertRowID();
    	execute(query);
    	
    	try
		{
			id = lastResult.getLong(DEFAULT_RESULT_SET_INDEX);
		}
    	
		catch (SQLException e)
		{
			throw new CobieSQLiteException(this.getClass(), Error.LAST_INSERT_ROWID_FAILED.toString(), e);
		}
    	
    	return id;
    }
    
    public final ResultSet getLastResult()
    {
    	return lastResult;
    }
    
    private long insertAttributeValue(AttributeValueType attributeValueType) throws CobieSQLiteException
    {
    	Object valueType = null;
    	long allowedStringID = Service.EMPTY_KEY.get();
    	long integerRangeID = Service.EMPTY_KEY.get();
    	long realRangeID = Service.EMPTY_KEY.get();
    	
    	if (attributeValueType != null)
    	{
    		List<Object> valueTypes = new ArrayList<>();
	    	
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
        
    @SuppressWarnings("boxing")
	private long insertObjectValue(Object valueType, long allowedStringID, long integerRangeID, long realRangeID) throws CobieSQLiteException
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
    			unit = decimalValue.getUnitName().getStringValue();
    			value = decimalValue.getDecimalValue();
    		}
    		
    		else if (valueType instanceof IntegerValueType)
    		{
    			column = Value.ColumnName.IntegerValue.toString();
    			
    			IntegerValueType integerValue = (IntegerValueType)valueType;
    			unit = integerValue.getUnitName().getStringValue();
    			value = integerValue.getIntegerValue();	    			
    		}
    		
    		else if (valueType instanceof StringValueType)
    		{
    			column = Value.ColumnName.StringValue.toString();
    			
    			StringValueType stringValue = (StringValueType)valueType;
    			unit = stringValue.getUnitName().getStringValue();
    			value = stringValue.getStringValue1();
    		}
    		
	    	else
	    	{
	    		throw new CobieSQLiteException(
	    				this.getClass(), Error.VALUE_TYPE_NOT_SUPPORTED.format(valueType.getClass().getName()));
	    	}
    	}
    	
    	catch (NullPointerException e)
    	{
    		return Service.EMPTY_KEY.get();
    		//throw new SQLiteSerializerException("The supplied value is null.", e);
    	}
    	
    	return insertValue(valueEntity, column, value, unit, allowedStringID, integerRangeID, realRangeID);
    }
    
    @SuppressWarnings("boxing")
	protected long insertUnit(String unitName) throws CobieSQLiteException
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
    
    // These don't need to be static mostly for consistency.
    @SuppressWarnings("static-method")
	public void insertValidEntity(Entity entity, String columnName, Object value) throws CobieSQLiteException
    {
    	if (value != null)
    	{
    		entity.getColumn(columnName).update(value);
    	}
    }
    
    // These don't need to be static mostly for consistency. 
	@SuppressWarnings({ "boxing", "static-method" })
	public void insertValidKey(Entity entity, String columnName, long key) throws CobieSQLiteException
	{
		if (key != Service.EMPTY_KEY.get())
		{
			entity.getColumn(columnName).update(key);
		}
	}
    
    public long insertValue(CobieComplexObjectType valueType) throws CobieSQLiteException
    {    		   
    	long key;
    	
		if (valueType instanceof AttributeValueType)
		{
			key = insertAttributeValue((AttributeValueType)valueType);
		}
		
		else 
		{
			key = insertObjectValue(
					valueType, 
					Service.EMPTY_KEY.get(), 
					Service.EMPTY_KEY.get(), 
					Service.EMPTY_KEY.get());
		}
		
		return key;
    }
    
    private void insertAllowedStrings(AllowedString allowedString, String[] allowedStrings) throws CobieSQLiteException
    {
    	for (String a : allowedStrings)
    	{
	    	insertValidKey(allowedString, CobieEntity.ColumnName.ID.toString(), allowedStringKey.next());
	    	insertValidKey(allowedString, AllowedString.ColumnName.RefValue.toString(), valueKey.get());
	    	insertValidEntity(allowedString, AllowedString.ColumnName.StringValue.toString(), a);
    	}
    }
    
    @SuppressWarnings("boxing")
	private long insertIntegerRange(IntegerRange integerRange, long min, long max) throws CobieSQLiteException
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
    
    @SuppressWarnings("boxing")
	private long insertRealRange(RealRange realRange, double min, double max) throws CobieSQLiteException
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
    
    @SuppressWarnings("boxing")
	private long insertValue(Value value, 
    						String columnName, 
    						Object rawValue, 
    						String unit,
							long allowedStringID,
							long integerRangeID,
							long realRangeID) throws CobieSQLiteException
    {
    	insertValidKey(value, CobieEntity.ColumnName.ID.toString(), valueKey.next());
    	insertValidEntity(value, columnName, rawValue);
    	
    	if ((unit != null) && (unit != ""))
    	{
    		insertValidEntity(value, Value.ColumnName.RefUnit.toString(), insertUnit(unit));
    		
    		if (allowedStringID != Service.EMPTY_KEY.get())
    		{
    			insertValidKey(value, Value.ColumnName.RefAllowedString.toString(), allowedStringID);
    		}
    		
    		else if (integerRangeID != Service.EMPTY_KEY.get())
    		{
    			insertValidKey(value, Value.ColumnName.RefIntegerRange.toString(), integerRangeID);
    		}
    		
    		else if (realRangeID != Service.EMPTY_KEY.get())
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