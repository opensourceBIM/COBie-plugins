//
// RuntimeContext.java
//
// This file was generated by MapForce 2014r2.
//
// YOU SHOULD NOT MODIFY THIS FILE, BECAUSE IT WILL BE
// OVERWRITTEN WHEN YOU RE-RUN CODE GENERATION.
//
// Refer to the MapForce Documentation for further details.
// http://www.altova.com/mapforce
//


package com.altova.functions;

import java.util.HashMap;

public class RuntimeContext 
{
	protected static class AutoNumberStateEntry
	{
		public long current;
		public String restartOnChange;
		public AutoNumberStateEntry(long current, String restartOnChange) 
		{ 
			this.current = current; 
			this.restartOnChange=restartOnChange;
		}
	}
	
	private HashMap<String, AutoNumberStateEntry> autoNumberStateMap = null;
	public HashMap<String, AutoNumberStateEntry> getAutoNumberStateMap()
	{ 
		if (autoNumberStateMap == null) 
			autoNumberStateMap = new HashMap<String, AutoNumberStateEntry>(); 
		return autoNumberStateMap; 
	}
	
	public static void dispose(com.altova.functions.RuntimeContext context) 
	{ 
		if (context.autoNumberStateMap != null) 
			context.autoNumberStateMap.clear(); 
	}
	
    public static com.altova.functions.RuntimeContext construct() 
	{ 
		return new com.altova.functions.RuntimeContext(); 
	}
	
    private RuntimeContext() {}
}
