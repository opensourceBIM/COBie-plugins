package org.erdc.cobie.sqlite;

import org.erdc.cobie.shared.exceptions.CobieException;

public class CobieSQLiteException extends CobieException 
{
	private static final long serialVersionUID = 1L;

	public CobieSQLiteException(Class<?> throwerClass)
	{
		super(throwerClass);
	}
	
	public CobieSQLiteException(Class<?> throwerClass, String message)
	{
		super(throwerClass, message);
	}
	
	public CobieSQLiteException(Class<?> throwerClass, Throwable e)
	{
		super(throwerClass, e);
	}
	
	public CobieSQLiteException(Class<?> throwerClass, String message, Throwable e)
	{
		super(throwerClass, message, e);
	}
}
