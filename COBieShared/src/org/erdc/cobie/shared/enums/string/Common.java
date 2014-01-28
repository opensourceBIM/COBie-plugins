package org.erdc.cobie.shared.enums.string;

import org.erdc.cobie.shared.utils.StringTable;
import org.erdc.cobie.shared.utils.StringUtils;

public enum Common implements StringTable
{
	EMPTY_STRING(""),
	TEXT_SEPARATOR(" "),
	NULL("null"),
	FILE_EXTENSION_PREFIX("."),
	BACKSLASH("\\"),
	COMMA(","),
	COMMA_TEXT(COMMA.toString() + TEXT_SEPARATOR.toString()),
	EQUALS("="),
	NOT_EQUALS("!="),
	PATH_SEPARATOR("/"),
	PERCENT("%"),
	QUESTION_MARK("?"),
	QUESTION_MARK_TEXT(QUESTION_MARK.toString() + TEXT_SEPARATOR.toString()),
	QUOTE_DOUBLE("\""),
	QUOTE_SINGLE("'");

	private final String string;

	private Common(String s)
	{
		string = s;
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
