package org.erdc.cobie.plugins.idm;

import org.erdc.cobie.shared.enums.COBieIDMPluginName;

public class COBieIDMPlugin extends IDMPlugin
{

	@Override
	public String getDefaultName()
	{
		return COBieIDMPluginName.COBieIDMPluginName.toString();
	}

	@Override
	public String getDescription()
	{
		return "Ignores entities based on a list of Ifc entity types for COBie/FM Handover MVD.";
	}

	@Override
	public String getIgnoreFilePath()
	{
		return "lib/BPieIgnore.xml";
	}

}
