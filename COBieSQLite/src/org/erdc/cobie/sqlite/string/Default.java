package org.erdc.cobie.sqlite.string;

import org.erdc.cobie.shared.utils.StringTable;
import org.erdc.cobie.shared.utils.StringUtils;

public enum Default implements StringTable
{
	INSERTING_RECORD_MESSAGE("Inserting %s..."),
	RANGE("[%s, %s]"),
	RELATIONSHIP_NONE("NoRelationship"),
	TEXT_SEPARATOR(" ");
	
	private final String string;
	
	private Default(String string)
	{
		this.string = string;
	}

	@Override
	public String format(Object... args)
	{
		return String.format(string, args);
	}

	@Override
	public String postfix(String s)
	{
		return StringUtils.concatenate(string, s, TEXT_SEPARATOR.toString());
	}

	@Override
	public String prefix(String s)
	{
		return StringUtils.concatenate(s, string, TEXT_SEPARATOR.toString());
	}

	@Override
	public String toString()
	{
		return string;
	}
}
