package org.bimserver.cobie.plugin.idm;

import org.bimserver.cobie.shared.idm.COBieIDMPluginName;

public class COBieIDMWithoutProxyObjectsPlugin extends IDMPlugin
{
	private static final String DESCRIPTION = "Ignores entities based on a list of Ifc entity types for COBie/FM Handover MVD and also ignores IfcBuildingElementProxy and IfcBuildingElementProxyType entities.";
	private static final String DEFAULT_NAME = COBieIDMPluginName.COBieIDMNoProxyObjects
			.toString();

	@Override
	public String getDefaultName()
	{
		return DEFAULT_NAME;
	}

	@Override
	public String getDescription()
	{
		return DESCRIPTION;
	}

	@Override
	public String getIgnoreFilePath()
	{
		return "lib/COBieIgnorePlusProxyObjects.xml";
	}

}
