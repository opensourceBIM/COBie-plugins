package org.bimserver.cobie.shared;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;

public class COBieException extends Exception 
{
	private static final boolean SHOW_STACK_TRACE = false;
	
	private static final long serialVersionUID = 1L;	
	private final Class<?> throwerClass;
	
    public static String buildFancyDressMessage(String message, COBieException e)
    {
    	return buildFancyDressMessage(message, e, SHOW_STACK_TRACE);
    }
    
    // Locally show/now show stack regardless of default setting.
    public static String buildFancyDressMessage(String message, COBieException e, boolean showStackTrace)
    {
    	String source = Common.NONE.toString();
    	String reason = Common.NONE.toString();
    	String rootCause = Common.NONE.toString();
    	
    	if (e != null)
    	{
    		source = e.getThrower().getName().trim();
    		source = StringUtils.isBlank(source) ? Common.NONE.toString() : source;
    		
    		reason = e.getMessage().trim();
    		reason = StringUtils.isBlank(reason) ? Common.NONE.toString() : reason;
    		
    		rootCause = ExceptionUtils.getRootCauseMessage(e).trim();
    		rootCause = StringUtils.isBlank(rootCause) ? Common.NONE.toString() : rootCause;
    	}
    	
    	return Common.EXCEPTION_MESSAGE.format(message, source, reason, rootCause, getStackTraceMessage(e, showStackTrace));
    }
    
    private static String getStackTraceMessage(COBieException e, boolean showStackTrace)
    {
    	String stackTrace = Common.EMPTY_STRING.toString();
		
    	if ((e != null) && showStackTrace)
    	{
	    	StackTraceElement[] stackTraceElements = e.getStackTrace();
			
			for (StackTraceElement stackTraceElement : stackTraceElements)
			{
				stackTrace += stackTraceElement + org.bimserver.cobie.shared.utility.StringUtils.EOL;
			}
			
			stackTrace = stackTrace.trim();
    	}
    	
    	else
    	{
    		stackTrace = Common.EXCEPTION_NO_STACK_TRACE.toString();
    	}
    	
		return stackTrace;
    }
    
    // A CobieException cannot be instantiated via default constructor, but it is available to sub-classes.
    protected COBieException()
    {
    	super();
    	throwerClass = null;
    }
    
	public COBieException(Class<?> throwerClass)
	{
		super();
		this.throwerClass = throwerClass;
	}
	
	public COBieException(Class<?> throwerClass, String message)
	{
		super(message);
		this.throwerClass = throwerClass;
	}
	
	public COBieException(Class<?> throwerClass, Throwable e)
	{
		super(e);
		this.throwerClass = throwerClass;
	}
	
	public COBieException(Class<?> throwerClass, String message, Throwable e)
	{
		super(message, e);
		this.throwerClass = throwerClass;
	}
	
	public final Class<?> getThrower()
	{
		return throwerClass;
	}
}