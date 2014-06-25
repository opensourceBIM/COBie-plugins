package org.erdc.cobie.shared.utils;

import org.erdc.cobie.shared.enums.string.Common;

public class ClassUtils
{
	public static String getClassNameSafely(Class<?> clazz)
	{
		return (clazz != null) ? clazz.getName() : Common.EMPTY_STRING.toString();
	}
}
