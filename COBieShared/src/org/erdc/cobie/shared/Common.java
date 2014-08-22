package org.erdc.cobie.shared;

import org.erdc.cobie.shared.utility.StringTable;
import org.erdc.cobie.shared.utility.StringUtils;


public enum Common implements StringTable
{	
	TEXT_SEPARATOR(" "),
	
	BACKSLASH("\\"),
	COMMA(","),
	COMMA_TEXT(COMMA.toString() + TEXT_SEPARATOR.toString()),
	CONTENT_TYPE_PREFIX("application/" ),
	EMPTY_STRING(""),
	ENCODING_UTF8("UTF-8"),
	EQUALS("="),
	
	EXCEPTION_CAUSE_SECTION("---------------------------ROOT-CAUSE-------------------------------\n"),
	EXCEPTION_END_EXCEPTION("\n====================================================================\n"),
	EXCEPTION_END_SECTION("\n--------------------------------------------------------------------\n"),
	EXCEPTION_MESSAGE_SECTION("\n============================EXCEPTION===============================\n"),
	EXCEPTION_REASON_SECTION    ("-----------------------------REASON---------------------------------\n"),
	EXCEPTION_SOURCE_SECTION("-----------------------------SOURCE---------------------------------\n"),
	EXCEPTION_TRACE_SECTION("---------------------------STACK-TRACE------------------------------\n"),
	EXCEPTION_MESSAGE(EXCEPTION_MESSAGE_SECTION + "%s" + EXCEPTION_END_SECTION +
						EXCEPTION_SOURCE_SECTION + "%s" + EXCEPTION_END_SECTION +
						EXCEPTION_REASON_SECTION + "%s" + EXCEPTION_END_SECTION +
						EXCEPTION_CAUSE_SECTION + "%s" + EXCEPTION_END_SECTION +
						EXCEPTION_TRACE_SECTION + "%s" +
						EXCEPTION_END_EXCEPTION),
	
	EXCEPTION_NO_STACK_TRACE("Stack trace output is disabled or not available."),
	
	FILE_EXTENSION_PREFIX("."),
	FILE_NAME_DELIMITER("_"),
	NONE("none"),
	NOT_AVAILABLE("n/a"),
	NOT_EQUALS("!="),
	NULL("null"),
	OBJECT_FIELD_DELIMITER("."),
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
