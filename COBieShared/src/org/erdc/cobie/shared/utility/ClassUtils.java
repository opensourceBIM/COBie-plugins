package org.erdc.cobie.shared.utility;

import org.erdc.cobie.shared.Common;

public class ClassUtils
{
	public static String getClassNameSafely(Class<?> clazz)
	{
		return (clazz != null) ? clazz.getName() : Common.EMPTY_STRING.toString();
	}
}
