package org.erdc.cobie.plugins.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.bimserver.plugins.Plugin;
import org.bimserver.plugins.PluginContext;
import org.bimserver.plugins.PluginManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PluginRuntimeFileHelper
{
	private static final char PATH_DELIM = '/';
	private static final Logger LOGGER = LoggerFactory
			.getLogger(PluginRuntimeFileHelper.class);


    public static File prepareSerializerConfigFile(PluginManager pluginManager,
            String name, Plugin plugin, String configPath) throws FileNotFoundException
    {
        PluginContext pluginContext = pluginManager.getPluginContext(plugin);
        InputStream inputStream = pluginContext
                .getResourceAsInputStream(configPath);
        String tempFileName = "";
        tempFileName = getFileName(configPath, pluginContext);
        File configurationFile=null;
        if (inputStream != null)
        {
            // File tmpFolder = new
            // File(pluginManager.getTempDir(),TEMP_DIRECTORY_NAME);
            File tmpFolder = pluginManager.getTempDir();
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

    private static String getFileName(String configPath,
            PluginContext pluginContext)
    {
        String tempFileName;
        try
        {
            URL url = pluginContext.getResourceAsUrl(configPath);
            String urlStr = url.toString();
            tempFileName = urlStr.substring(urlStr.lastIndexOf(PATH_DELIM) + 1,
                    urlStr.length());
        }
        catch(Exception ex)
        {
            tempFileName =
                    configPath.substring(configPath.lastIndexOf(PATH_DELIM) + 1,
                    configPath.length());
        }
        return tempFileName;
    }

    public static File getDirectory(PluginManager pluginManager,
            String directoryName)
    {
        File directory = new File(pluginManager.getTempDir(), directoryName);
        if (!directory.exists())
            try
            {
                FileUtils.forceMkdir(directory);
            }
            catch (IOException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        return directory;
    }

    public static HashMap<String, File> prepareSerializerConfigFiles(
            PluginManager pluginManager, String name, Plugin plugin,
            ArrayList<String> configPaths) throws FileNotFoundException
    {
        PluginContext pluginContext = pluginManager.getPluginContext(plugin);
        // File tmpFolder = new File(pluginManager.getTempDir(),
        // TEMP_DIRECTORY_NAME);
        File tmpFolder = pluginManager.getTempDir();
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
            InputStream inputStream = pluginContext
                    .getResourceAsInputStream(configPath);

            String tempFileName = getFileName(configPath, pluginContext);
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
