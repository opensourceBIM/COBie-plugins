package org.bimserver.cobie.shared.utility;

import org.bimserver.cobie.shared.Common;


public class StringUtils
{
	public static String EOL = System.getProperty("line.separator");

	public static String concatenate(String s, String t, String separator)
	{
		return s + separator + t;
	}

	@Deprecated // Use Apachii commons.
	public static boolean isNullOrEmpty(String s)
	{
		return ((s == null) || s.isEmpty());
	}
	
	private static String quotify(String s, String quote)
	{
		return quote + s + quote;
	}
	
	public static String quotifyDouble(String s)
	{
		return quotify(s, Common.QUOTE_DOUBLE.toString());
	}
	
	public static String quotifySingle(String s)
	{
		return quotify(s, Common.QUOTE_SINGLE.toString());
	}
}
