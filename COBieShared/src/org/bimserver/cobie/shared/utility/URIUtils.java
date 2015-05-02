package org.bimserver.cobie.shared.utility;

import java.net.URI;

import org.bimserver.cobie.shared.Common;

public class URIUtils
{    
    public static String fixPath(String path, char[] delimiters, char desiredDelimiter)
    {
        String fixedPath = path;
        
        for (char delimiter : delimiters)
        {
            if (path.contains(Character.toString(delimiter)))
            {
                fixedPath = fixedPath.replace(delimiter, desiredDelimiter);
            }
        }
        
        return fixedPath;
    }
    
    public static String getFileName(URI resource)
    {
        String path = resource.getPath();
        return path.substring(path.lastIndexOf('/') + 1, path.length());
    }
    
    public static boolean isDirectory(URI resource)
    {
    	return !URIUtils.getFileName(resource).contains(Common.FILE_EXTENSION_PREFIX.toString());
    }
    
    public static String makeDOSPath(String uriPath)
    {
        return fixPath(uriPath, new char[] {'/'}, '\\');
    }
    
    public static String makeDOSPath(URI uri)
    {
        return makeDOSPath(uri.getPath());
    }
    
    public static String makeJarPath(String uriPath)
    {
        return fixPath(uriPath, new char[] {'/', '\\'}, '.');
    }
    
    public static String makeJarPath(URI uri)
    {
        return makeJarPath(uri.getPath());
    }
    
    public static String makeStandardPath(String uriPath)
    {
        return fixPath(uriPath, new char[] {'\\'}, '/');
    }
    
    public static String makeStandardPath(URI uri)
    {
        return makeStandardPath(uri.getPath());
    }
}
