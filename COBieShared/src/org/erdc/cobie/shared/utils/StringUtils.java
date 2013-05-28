package org.erdc.cobie.shared.utils;

public class StringUtils
{
    public static String EOL = System.getProperty("line.separator");
    
    public static boolean isNullOrEmpty(String s)
    {
        return ((s == null) || s.isEmpty());
    }
}
