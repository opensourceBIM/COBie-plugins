package org.erdc.cobie.plugins.serializers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.serializers.AbstractSerializerPlugin;
import org.bimserver.plugins.serializers.Serializer;
import org.erdc.cobie.plugins.utils.PluginRuntimeFileHelper;
import org.erdc.cobie.sqlite.service.CobieSQLiteSerializer;

public class COBieSQLiteSerializerPlugin extends AbstractSerializerPlugin
{
	private static String COBIELITE_DATABASE = "lib/cobielite.sqlite";
	
	private HashMap<String,File> configFiles;
	private ArrayList<String> configFilePaths;
    private boolean initialized = false;

    @Override
    public Serializer createSerializer(PluginConfiguration plugin)
    {
        return new CobieSQLiteSerializer(configFiles.get(COBIELITE_DATABASE).getAbsolutePath());
    }

    @Override
    public String getDefaultContentType()
    {
        return "database/sqlite";
    }

    @Override
    public String getDefaultExtension()
    {
        return "sqlite";
    }

    @Override
    public String getDefaultName()
    {
        return "COBieSQLiteSerializer";
    }

    @Override
    public String getDescription()
    {
        return "SQLite database representing COBie";
    }

	@Override
	public String getVersion() 
	{
		return "1.0";
	}
	
    @Override
    public void init(PluginManager pluginManager) throws PluginException
    {
    	configFilePaths = new ArrayList<String>();
		configFilePaths.add(COBIELITE_DATABASE);
		pluginManager.requireSchemaDefinition();
		
		try
		{
			configFiles = PluginRuntimeFileHelper.prepareSerializerConfigFiles(pluginManager, getDefaultName(), this, configFilePaths);
		}
		
		catch (FileNotFoundException e)
		{
			throw new PluginException("Could not find configuration files");
		}
		
        this.initialized = true;
    }

    @Override
    public boolean isInitialized()
    {
        return this.initialized;
    }

    @Override
    public boolean needsGeometry()
    {
        return false;
    }
}

