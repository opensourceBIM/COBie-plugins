package org.bimserver.cobie.shared.utility;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.bimserver.plugins.Plugin;
import org.bimserver.plugins.PluginContext;
import org.bimserver.plugins.PluginManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PluginRuntimeFileHelper
{
	private static final Logger LOGGER = LoggerFactory
			.getLogger(PluginRuntimeFileHelper.class);


    public static File prepareSerializerConfigFile(PluginManager pluginManager,
            String name, Plugin plugin, String configPath) throws IOException
    {
        PluginContext pluginContext = pluginManager.getPluginContext(plugin);
        Path config = pluginContext.getRootPath().resolve(configPath);
        InputStream inputStream = Files.newInputStream(config);
        String tempFileName = config.getFileName().toString();
        File configurationFile=null;
        if (inputStream != null)
        {
            // File tmpFolder = new
            // File(pluginManager.getTempDir(),TEMP_DIRECTORY_NAME);
        	
            File tmpFolder = new File(pluginManager.getTempDir().toString());
            File tempChildFolder = new File(tmpFolder, name);
            try
            {
                if (tempChildFolder.exists())
                {
                    FileUtils.forceDelete(tempChildFolder);
                }
                FileUtils.forceMkdir(tempChildFolder);
                configurationFile = new File(tempChildFolder, tempFileName);
                IOUtils.copy(inputStream, new FileOutputStream(
                        configurationFile));
            }
            catch (IOException e)
            {
                LOGGER.error("", e);
            }
        }
        return configurationFile;
    }

    public static HashMap<String, File> prepareSerializerConfigFiles(
            PluginManager pluginManager, String name, Plugin plugin,
            ArrayList<String> configPaths) throws IOException
    {
        PluginContext pluginContext = pluginManager.getPluginContext(plugin);
        // File tmpFolder = new File(pluginManager.getTempDir(),
        // TEMP_DIRECTORY_NAME);
        File tmpFolder = new File(pluginManager.getTempDir().toString());
        File tempChildFolder = new File(tmpFolder, name);
        HashMap<String, File> configFiles = new HashMap<String, File>();
        try
        {
            if (tempChildFolder.exists())
            {
                FileUtils.forceDelete(tempChildFolder);
            }
            FileUtils.forceMkdir(tempChildFolder);
        }
        catch (IOException e)
        {
            LOGGER.error("", e);
        }

        for (String configPath : configPaths)
        {
        	Path config = pluginContext
                    .getRootPath().resolve(configPath);
            InputStream inputStream = Files.newInputStream(config);

            String tempFileName = config.getFileName().toString();
            File configurationFile = new File(tempChildFolder, tempFileName);

            try
            {
                if (inputStream != null)
                {

                    IOUtils.copy(inputStream, new FileOutputStream(
                            configurationFile));
                    configFiles.put(configPath, configurationFile);
                }
                else
                    configFiles.put(configPath, null);
            }
            catch (IOException e)
            {
                LOGGER.error("", e);
            }
        }

        return configFiles;
    }

}
