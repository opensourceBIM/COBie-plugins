package com.prairiesky.lang;

public class Property<T>
{
	private T value;
	private Class<?> valueType;
	
	public Property(T value)
	{
		this.value = value;
		this.valueType = value.getClass();
	}
	
	public Property(Class<?> valueType)
	{
		this.value = null;
		this.valueType = valueType;
	}
	
	public Class<?> getValueType()
	{
		return valueType;
	}
	
	public final T get()
	{
		return value;
	}
	
	public final void set(T value)
	{
		this.value = value;
	}
}
