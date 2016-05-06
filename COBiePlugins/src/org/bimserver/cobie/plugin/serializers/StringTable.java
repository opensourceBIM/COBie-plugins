package org.bimserver.cobie.plugin.serializers;

public enum StringTable 
{
	SETTINGS_DIRNAME("CobiePlugins/config"),
	SETTINGS_PACKAGE("com.prairiesky.transform.cobieifc.settings");
	
	private final String string;
	
	private StringTable(String string)
	{
		this.string = string;
	}
	
	@Override
	public String toString()
	{
		return string;
	}
}
