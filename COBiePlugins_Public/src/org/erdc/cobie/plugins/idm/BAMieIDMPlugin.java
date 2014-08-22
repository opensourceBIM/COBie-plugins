package org.erdc.cobie.plugins.idm;

import org.erdc.cobie.shared.bimserver.idm.COBieIDMPluginName;

public class BAMieIDMPlugin extends IDMPlugin
{

	@Override
	public String getDefaultName()
	{
		return COBieIDMPluginName.BAMieIDMPluginName.toString();
	}

	@Override
	public String getDescription()
	{
		return "Ignores entities based on a list of Ifc entity types for BAMie.";
	}

	@Override
	public String getIgnoreFilePath()
	{
		return "lib/BAMieIgnore.xml";
	}

}
