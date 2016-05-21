package org.bimserver.cobie.plugin.serializers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.bimserver.cobie.shared.serialization.COBieXLSXSerializer;
import org.bimserver.cobie.shared.utility.PluginRuntimeFileHelper;
import org.bimserver.cobie.shared.utility.PluginRuntimeFileHelper.Persistence;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.serializers.Serializer;

public abstract class COBieXLSXSerializerPlugin extends
		AbstractCOBieSerializerPlugin
{

	protected abstract String getXLSXTemplatePath();
	private File  settingsFile, spreadSheetXLSXTemplate;

	private HashMap<String, File> configFiles = new HashMap<>();
	@Override
	public Serializer createSerializer(PluginConfiguration plugin)
	{
		return new COBieXLSXSerializer(spreadSheetXLSXTemplate, 
				settingsFile, getTransformSettings());
	}

	private ArrayList<String> getConfigFilePaths()
	{
		ArrayList<String> configFilePaths = new ArrayList<String>();
		configFilePaths.add(getXLSXTemplatePath());
		return configFilePaths;
	}

	@Override
	public boolean needsGeometry()
	{
		return false;
	}


	@Override
	protected void onInit(PluginManager pluginManager) throws Exception 
	{
		try 
		{
			configFiles = PluginRuntimeFileHelper.prepareSerializerResource(pluginManager, StringTable.SETTINGS_DIRNAME.toString(), this, getConfigFilePaths(),Persistence.PERMANENT);
		} 
		catch (IOException e) 
		{
			throw new PluginException(e);
		}
		spreadSheetXLSXTemplate = configFiles.get(getXLSXTemplatePath());
		
	}

}
