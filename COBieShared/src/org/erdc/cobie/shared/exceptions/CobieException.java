package org.erdc.cobie.shared.exceptions;

import org.erdc.cobie.shared.enums.string.Common;

public class CobieException extends Exception 
{
	private static final long serialVersionUID = 1L;	
	private final Class<?> throwerClass;
	
    public static String buildFancyDressMessage(String message, CobieException e)
    {
    	String source = Common.NONE.toString();
    	String exception = Common.NONE.toString();
    	String innerException = Common.NONE.toString();
    	
    	if (e != null)
    	{
    		source = e.getThrower().getName();
    		exception = e.getMessage();    		
    		innerException = (e.getCause() != null) ? e.getCause().getMessage() : Common.NONE.toString();
    	}
    	
    	return Common.EXCEPTION_MESSAGE.format(message, source, exception, innerException);
    }
    
    // A CobieException cannot be instantiated via default constructor, but it is available to sub-classes.
    protected CobieException()
    {
    	super();
    	throwerClass = null;
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