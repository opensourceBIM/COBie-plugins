package org.erdc.cobie.sqlite;

import org.erdc.cobie.sqlite.string.Error;

public class Column<T>
{
	private final String name;
	private T value;
	private final Class<T> valueClass;
	private boolean key;
	private boolean fresh;

	public Column(Class<T> valueClass, String name, T value)
	{
		this(valueClass, name, value, false);
	}

	public Column(Class<T> valueClass, String name, T value, boolean key)
	{
		this.valueClass = valueClass;			
		this.name = name;
		this.value = value;
		this.key = key;
		this.fresh = true;
	}

	public void clear()
	{
		value = null;
		fresh = true;
	}

	public final String getName()
	{
		return name;
	}

	public final T getValue()
	{
		return value;
	}
	
	public final Class<T> getValueClass()
	{
		return valueClass;
	}

	public final boolean isFresh()
	{
		return fresh;
	}

	public final boolean isKey()
	{
		return key;
	}

	public void reset()
	{
		fresh = true;
	}

	@SuppressWarnings("unchecked")
	// This parameter cannot be type "T" b/c Java generics are crap.
	public void update(Object newValue)
	{
		T lastValue;
		
		try
		{
			lastValue = value;
			value = (T)newValue;
		}

		catch (final Exception e)
		{
			throw new ClassCastException(Error.INVALID_COLUMN_VALUE.format(newValue.toString(), value.getClass()));
		}
		
		fresh = (lastValue != null) ? lastValue.equals(value) : true;
	}
}
