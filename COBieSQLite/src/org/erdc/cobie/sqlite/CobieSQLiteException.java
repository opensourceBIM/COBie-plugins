package org.erdc.cobie.sqlite;

public class CobieSQLiteException extends Exception 
{
	private static final long serialVersionUID = 1L;	
	private final Class<?> throwerClass;
	
    public static String buildFancyDressMessage(String message, CobieSQLiteException e)
    {
    	return "\n***" + message + "***\nSOURCE: " + e.getThrower().getName() + "\nREASON: " + e.getMessage(); 
    }
    
	public CobieSQLiteException(Class<?> throwerClass)
	{
		super();
		this.throwerClass = throwerClass;
	}
	
	public CobieSQLiteException(Class<?> throwerClass, String message)
	{
		super(message);
		this.throwerClass = throwerClass;
	}
	
	public CobieSQLiteException(Class<?> throwerClass, Throwable e)
	{
		super(e);
		this.throwerClass = throwerClass;
	}
	
	public CobieSQLiteException(Class<?> throwerClass, String message, Throwable e)
	{
		super(message, e);
		this.throwerClass = throwerClass;
	}
	
	public final Class<?> getThrower()
	{
		return throwerClass;
	}
}
