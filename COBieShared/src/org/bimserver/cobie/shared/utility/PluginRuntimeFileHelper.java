package org.bimserver.cobie.shared.utility;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
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

	public enum Persistence { PERMANENT, TEMP}
	

    public static File prepareSerializerResource(PluginManager pluginManager,
            String name, Plugin plugin, String configPath, Persistence persistence) throws IOException
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
        	File folder = getParentFolder(pluginManager, plugin, persistence);
            File tempChildFolder = new File(folder, name);
            try
            {
                if (tempChildFolder.exists() && persistence == Persistence.TEMP)
                {
                    FileUtils.forceDelete(tempChildFolder);
                    
                }
                if(!tempChildFolder.exists())
                {
                	FileUtils.forceMkdir(tempChildFolder);
                }
                
                configurationFile = new File(tempChildFolder, tempFileName);
                if(!configurationFile.exists() || persistence == Persistence.TEMP)
                {
                    IOUtils.copy(inputStream, new FileOutputStream(
                            configurationFile));
                }
                else if (configurationFile.exists())
                {
                	//keep the newest file
                	FileTime fileToCopy = Files.getLastModifiedTime(config);
                	if(fileToCopy.toMillis() > configurationFile.lastModified())
                	{
                        IOUtils.copy(inputStream, new FileOutputStream(
                                configurationFile));
                	}
                }

            }
            catch (IOException e)
            {
                LOGGER.error("", e);
            }
        }
        return configurationFile;
    }

	private static File getParentFolder(PluginManager pluginManager,
			Plugin plugin, Persistence persistence) 
	{
		File folder;
		switch(persistence)
		{
			case PERMANENT:
				folder = new File(pluginManager.getTempDir().getParent().toString());
				break;
			case TEMP:
				folder = new File(pluginManager.getTempDir().toString());
				break;
			default:
				folder = new File(pluginManager.getTempDir().toString());
				break;
		}
		return folder;
	}

    public static HashMap<String, File> prepareSerializerResource(
            PluginManager pluginManager, String name, Plugin plugin,
            ArrayList<String> configPaths, Persistence persistence) throws IOException
    {
        PluginContext pluginContext = pluginManager.getPluginContext(plugin);
        // File tmpFolder = new File(pluginManager.getTempDir(),
        // TEMP_DIRECTORY_NAME);
        File folder = getParentFolder(pluginManager, plugin, persistence);
        File tempChildFolder = new File(folder, name);
        HashMap<String, File> configFiles = new HashMap<String, File>();
        try
        {
            if (tempChildFolder.exists() && persistence == Persistence.TEMP)
            {
                FileUtils.forceDelete(tempChildFolder);
            }
            if (!tempChildFolder.exists())
            {
            	FileUtils.forceMkdir(tempChildFolder);
            }
            
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
                	if(!configurationFile.exists() || persistence == Persistence.TEMP)
                	{
                        IOUtils.copy(inputStream, new FileOutputStream(
                                configurationFile));
                	}
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
