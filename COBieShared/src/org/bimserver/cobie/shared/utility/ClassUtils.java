package org.bimserver.cobie.shared.utility;

import org.bimserver.cobie.shared.Common;

public class ClassUtils
{
	public static String getClassNameSafely(Class<?> clazz)
	{
		return (clazz != null) ? clazz.getName() : Common.EMPTY_STRING.toString();
	}
}
