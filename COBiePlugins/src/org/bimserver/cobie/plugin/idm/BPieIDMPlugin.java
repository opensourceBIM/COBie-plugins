package org.bimserver.cobie.plugin.idm;

import org.bimserver.cobie.shared.idm.COBieIDMPluginName;

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
