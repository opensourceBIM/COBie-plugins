package org.erdc.cobie.shared.exceptions;

public class CobieException extends Exception 
{
	private static final long serialVersionUID = 1L;	
	private final Class<?> throwerClass;
	
    public static String buildFancyDressMessage(String message, CobieException e)
    {
    	return "\n***" + message + "***\nSOURCE: " + e.getThrower().getName() + "\nREASON: " + e.getMessage(); 
    }
    
	public CobieException(Class<?> throwerClass)
	{
		super();
		this.throwerClass = throwerClass;
	}
	
	public CobieException(Class<?> throwerClass, String message)
	{
		super(message);
		this.throwerClass = throwerClass;
	}
	
	public CobieException(Class<?> throwerClass, Throwable e)
	{
		super(e);
		this.throwerClass = throwerClass;
	}
	
	public CobieException(Class<?> throwerClass, String message, Throwable e)
	{
		super(message, e);
		this.throwerClass = throwerClass;
	}
	
	public final Class<?> getThrower()
	{
		return throwerClass;
	}
}