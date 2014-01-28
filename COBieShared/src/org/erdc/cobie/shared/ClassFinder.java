package org.erdc.cobie.shared;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

public class ClassFinder
{

	  private final static char DOT = '.';
	    private final static char SLASH = '/';
	    private final static String CLASS_SUFFIX = ".class";
	    private final static String BAD_PACKAGE_ERROR = "Unable to get resources from path '%s'. Are you sure the given '%s' package exists?";

	    public final static List<Class<?>> find(final String scannedPackage) {
	        final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
	        final String scannedPath = scannedPackage.replace(DOT, SLASH);
	        final Enumeration<URL> resources;
	        try {
	            resources = classLoader.getResources(scannedPath);
	        } catch (IOException e) {
	            throw new IllegalArgumentException(String.format(BAD_PACKAGE_ERROR, scannedPath, scannedPackage), e);
	        }
	        final List<Class<?>> classes = new LinkedList<Class<?>>();
	        while (resources.hasMoreElements()) {
	            final File file = new File(resources.nextElement().getFile());
	            classes.addAll(find(file, new String()));
	        }
	        return classes;
	    }

	    private final static List<Class<?>> find(final File file, final String scannedPackage) {
	        final List<Class<?>> classes = new LinkedList<Class<?>>();
	        final String resource = scannedPackage + DOT + file.getName();
	        if (file.isDirectory()) {
	            for (File nestedFile : file.listFiles()) {
	                classes.addAll(find(nestedFile, resource));
	            }
	        } else if (resource.endsWith(CLASS_SUFFIX)) {
	            final int beginIndex = 1;
	            final int endIndex = resource.length() - CLASS_SUFFIX.length();
	            final String className = resource.substring(beginIndex, endIndex);
	            try {
	                classes.add(Class.forName(className));
	            } catch (ClassNotFoundException ignore) {
	            }
	        }
	        return classes;
	    }

}
