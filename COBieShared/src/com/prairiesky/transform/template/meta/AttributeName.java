package com.prairiesky.transform.template.meta;

public enum AttributeName 
{
	CRITICAL("Critical"),
	INSTALLED_MODEL_NUMBER("Installed Model Number"),
	INSTALLED_SERIAL_NUMBER("Installed Serial Number"),
	SPEC_SECTION("Spec Section"),
	STARTED_ON("Started On"),
	SUPPLIER("Supplier");
	private final String string;
	
	private AttributeName(String string)
	{
		this.string = string;
	}
	
	@Override
	public String toString()
	{
		return string;
	}
}
