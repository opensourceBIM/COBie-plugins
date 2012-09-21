package org.bimserver.cobie.plugins;

import java.io.File;
import java.util.ArrayList;

import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.objectidms.ObjectIDM;
import org.bimserver.plugins.objectidms.ObjectIDMPlugin;
import org.bimserver.utils.CollectionUtils;

public class BPieIDMPlugin implements ObjectIDMPlugin
{

	private static final String FILE_BASED_OBJECT_IDM_PLUGIN_NAME = "FileBasedObjectIDMPlugin";
	private boolean initialized;
	private COBieIDM cobieObjectIDM;
	private String ignoreFilePath="lib/BPieIgnore.xml";
	private File ignoreFile;
	@Override
	public void init(PluginManager pluginManager) throws PluginException
	{
		// TODO Auto-generated method stub
		ignoreFile = ConfigUtil.prepareSerializerConfigFile(pluginManager, "BPieIDM", this,ignoreFilePath);
		ObjectIDMPlugin fbPlugin = null;
		ArrayList<ObjectIDMPlugin> idmplugins = (ArrayList<ObjectIDMPlugin>) pluginManager.getAllObjectIDMPlugins(true);
		for(ObjectIDMPlugin plugin: idmplugins)
		{
			if (plugin.getDefaultObjectIDMName()==FILE_BASED_OBJECT_IDM_PLUGIN_NAME)
				fbPlugin = plugin;
		}
		cobieObjectIDM = new COBieIDM(ignoreFile,CollectionUtils.singleSet(Ifc2x3tc1Package.eINSTANCE), pluginManager.getPluginContext(this),fbPlugin);
		initialized = true;
		
	}

	@Override
	public String getDescription()
	{
		// TODO Auto-generated method stub
		return "Ignores entities based on a list of Ifc entity types for BPie.";
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

	@Override
	public String getDefaultObjectIDMName()
	{
		// TODO Auto-generated method stub
		return "BPieIDMPlugin";
	}

}
