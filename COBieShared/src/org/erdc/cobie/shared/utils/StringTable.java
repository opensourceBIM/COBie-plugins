package org.erdc.cobie.shared.utils;

public interface StringTable
{
	public String format(Object... args);
	public String prefix(String s);
	public String postfix(String s);
}
