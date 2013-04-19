package org.erdc.cobie.plugins.idm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.store.ObjectDefinition;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.objectidms.ObjectIDM;
import org.bimserver.plugins.objectidms.ObjectIDMPlugin;
import org.bimserver.utils.CollectionUtils;
import org.erdc.cobie.plugins.utils.ConfigUtil;
import org.erdc.cobie.shared.enums.COBieIDMPluginName;

public class COBieIDMWithoutProxyObjectsPlugin implements ObjectIDMPlugin
{
	private static final String DESCRIPTION = "Ignores entities based on a list of Ifc entity types for COBie/FM Handover MVD and also ignores IfcBuildingElementProxy and IfcBuildingElementProxyType entities.";
	private static final String DEFAULT_NAME = COBieIDMPluginName.COBieIDMNoProxyObjects.toString();
	private static final String FILE_BASED_OBJECT_IDM_PLUGIN_NAME = "FileBasedObjectIDMPlugin";
	private boolean initialized;
	private COBieIDM cobieObjectIDM;
	private String ignoreFilePath="lib/COBieIgnorePlusProxyObjects.xml";
	private File ignoreFile;
	@Override
	public void init(PluginManager pluginManager) throws PluginException
	{
		try
		{
			ignoreFile = ConfigUtil.prepareSerializerConfigFile(pluginManager, DEFAULT_NAME, this,ignoreFilePath);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
			throw new PluginException("Could not find configuration files");
		}
		ObjectIDMPlugin fbPlugin = null;
		ArrayList<ObjectIDMPlugin> idmplugins = (ArrayList<ObjectIDMPlugin>) pluginManager.getAllObjectIDMPlugins(true);
		for(ObjectIDMPlugin plugin: idmplugins)
		{
			if (plugin.getDefaultName()==FILE_BASED_OBJECT_IDM_PLUGIN_NAME)
				fbPlugin = plugin;
		}
		cobieObjectIDM = new COBieIDM(ignoreFile,CollectionUtils.singleSet(Ifc2x3tc1Package.eINSTANCE), pluginManager.getPluginContext(this),fbPlugin);
		initialized = true;
		
	}

	@Override
	public String getDescription()
	{
		// TODO Auto-generated method stub
		return DESCRIPTION;
	}

	@Override
	public String getVersion()
	{
		// TODO Auto-generated method stub
		return "1.0";
	}

	@Override
	public boolean isInitialized()
	{
		// TODO Auto-generated method stub
		return initialized;
	}

	@Override
	public ObjectIDM getObjectIDM()
	{
		// TODO Auto-generated method stub
		return cobieObjectIDM;
	}
	

	public COBieIDM getCobieObjectIDM()
	{
		// TODO Auto-generated method stub
		return cobieObjectIDM;
	}


	@Override
	public String getDefaultName()
	{
		// TODO Auto-generated method stub
		return DEFAULT_NAME;
	}

	@Override
	public ObjectDefinition getSettingsDefinition()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
