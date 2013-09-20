package org.erdc.cobie.sqlite;

public class Column<T>
{
	private final String name;
	private T value;
	private boolean key;
	private boolean fresh;

	public Column(final String name, final T value)
	{
		this(name, value, false);
	}

	public Column(final String name, final T value, final boolean key)
	{
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
		return this.value;
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

	// Thank you Java, for sucking.
	// public void update(final T newValue)
	// {
	// value = newValue;
	// fresh = false;
	// }

	@SuppressWarnings("unchecked")
	public void update(final Object newValue)
	{
		try
		{
			value = (T) newValue;
		}

		catch (final Exception e)
		{
			throw new ClassCastException("The supplied parameter does not match the type stored in this column.");
		}

		fresh = false;
	}
}
