package org.erdc.cobie.plugins.idm;

import org.erdc.cobie.shared.enums.COBieIDMPluginName;

public class BPieIDMPlugin extends IDMPlugin
{

	@Override
	public String getDefaultName()
	{
		return COBieIDMPluginName.BPieIDMPluginName.toString();
	}

	@Override
	public String getDescription()
	{
		return "Ignores entities based on a list of Ifc entity types for BPie.";
	}

	@Override
	public String getIgnoreFilePath()
	{
		return "lib/BPieIgnore.xml";
	}

}
