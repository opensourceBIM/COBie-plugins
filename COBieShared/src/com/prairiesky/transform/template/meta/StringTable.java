package com.prairiesky.transform.template.meta;

public enum StringTable
{
	DEFAULT_FACILITY_NAME("Unknown"),
	INSTRUCTION_SHEETNAME("Instruction");
	private final String text;
	private StringTable(String text)
	{
		this.text = text;
	}
	
	public String toString()
	{
		return text;
	}
}
