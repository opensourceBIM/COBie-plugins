package org.bimserver.cobie.shared.utility;

public interface StringTable
{
	public String format(Object... args);
	public String prefix(String s);
	public String postfix(String s);
}
