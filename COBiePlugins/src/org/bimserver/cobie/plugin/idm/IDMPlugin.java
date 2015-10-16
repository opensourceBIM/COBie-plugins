package org.bimserver.cobie.plugin.idm;

import java.nio.file.Path;
import java.util.ArrayList;

import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.store.ObjectDefinition;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginContext;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.objectidms.ObjectIDM;
import org.bimserver.plugins.objectidms.ObjectIDMPlugin;
import org.bimserver.utils.CollectionUtils;

public abstract class IDMPlugin implements ObjectIDMPlugin
{
	protected boolean initialized;
	protected COBieIDM cobieObjectIDM;
	protected Path ignoreFile;
	private static final String FILE_BASED_OBJECT_IDM_PLUGIN_NAME = "FileBasedObjectIDMPlugin";

	public abstract String getIgnoreFilePath();

	@Override
	public ObjectIDM getObjectIDM(PluginConfiguration pluginConfiguration)
	{
		return cobieObjectIDM;
	}

	@Override
	public final ObjectDefinition getSettingsDefinition()
	{
		return null;
	}

	@Override
	public final String getVersion()
	{
		return "1.0";
	}

	@Override
	public void init(PluginManager pluginManager) throws PluginException
	{
		PluginContext pluginContext = pluginManager.getPluginContext(this);
		ignoreFile = pluginContext.getRootPath().resolve(getIgnoreFilePath());
		
		ObjectIDMPlugin idmPlugin = null;
		ArrayList<ObjectIDMPlugin> idmplugins = (ArrayList<ObjectIDMPlugin>) pluginManager
				.getAllObjectIDMPlugins(true);
		for (ObjectIDMPlugin plugin : idmplugins)
		{
			if (plugin.getDefaultName().equals(FILE_BASED_OBJECT_IDM_PLUGIN_NAME))
			{
				idmPlugin = plugin;
			}
		}
		
		cobieObjectIDM = new COBieIDM(ignoreFile,
				CollectionUtils.singleSet(Ifc2x3tc1Package.eINSTANCE),
				pluginManager.getPluginContext(this), idmPlugin);
		initialized = true;

	}

	@Override
	public boolean isInitialized()
	{
		return initialized;
	}
}
