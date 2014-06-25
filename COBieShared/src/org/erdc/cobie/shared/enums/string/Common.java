package org.erdc.cobie.shared.enums.string;

import org.erdc.cobie.shared.utils.StringTable;
import org.erdc.cobie.shared.utils.StringUtils;

public enum Common implements StringTable
{	
	TEXT_SEPARATOR(" "),
	
	BACKSLASH("\\"),
	COMMA(","),
	COMMA_TEXT(COMMA.toString() + TEXT_SEPARATOR.toString()),
	CONTENT_TYPE_PREFIX("application/" ),
	EMPTY_STRING(""),
	EQUALS("="),
	EXCEPTION_MESSAGE("***%s***\nSOURCE: %s\nREASON: %s\nINNER EXCEPTION: %s"),
	FILE_EXTENSION_PREFIX("."),
	FILE_NAME_DELIMITER("_"),
	NONE("none"),
	NOT_AVAILABLE("n/a"),
	NOT_EQUALS("!="),
	NULL("null"),
	PATH_PARENT("../"),
	PATH_SEPARATOR("/"),
	PERCENT("%"),
	PICKLIST_SHEETNAME("Picklists"),
	SYSTEM_TEMP_DIRECTORY_PROPERTY("java.io.tmpdir"),
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
