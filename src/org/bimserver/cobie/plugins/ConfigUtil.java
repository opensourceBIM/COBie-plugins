package org.bimserver.cobie.plugins;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.bimserver.plugins.Plugin;
import org.bimserver.plugins.PluginContext;
import org.bimserver.plugins.PluginManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger(ConfigUtil.class);
	private static final String TEMP_DIRECTORY_NAME = "tmp";
	public static File prepareSerializerConfigFile(PluginManager pluginManager, String name, Plugin plugin,String configPath) {
		PluginContext pluginContext = pluginManager.getPluginContext(plugin);
		InputStream inputStream = pluginContext.getResourceAsInputStream(configPath);
		URL url = pluginContext.getResourceAsUrl(configPath);
		String urlStr = url.toString();
		String tempFileName = urlStr.substring( urlStr.lastIndexOf('/')+1, urlStr.length() );

		if (inputStream != null) {
			File tmpFolder = new File(pluginManager.getTempDir(),TEMP_DIRECTORY_NAME);
			File tempChildFolder = new File(tmpFolder, name);
			try {
				if (tempChildFolder.exists()) {
					FileUtils.forceDelete(tempChildFolder);
				}
				FileUtils.forceMkdir(tempChildFolder);
				File configurationFile = new File(tempChildFolder, tempFileName);
				IOUtils.copy(inputStream, new FileOutputStream(configurationFile));
				return configurationFile;
			} catch (IOException e) {
				LOGGER.error("", e);
			}
		}
		return null;
	}

	public static HashMap<String, File> prepareSerializerConfigFiles(
			PluginManager pluginManager, String name, Plugin plugin,
			ArrayList<String> configPaths) {
		PluginContext pluginContext = pluginManager.getPluginContext(plugin);
		File tmpFolder = new File(pluginManager.getTempDir(),
				TEMP_DIRECTORY_NAME);
		File tempChildFolder = new File(tmpFolder, name);
		HashMap<String, File> configFiles = new HashMap<String, File>();
		try {
			if (tempChildFolder.exists()) {
				FileUtils.forceDelete(tempChildFolder);
			}
			FileUtils.forceMkdir(tempChildFolder);
		} catch (IOException e) {
			LOGGER.error("", e);
		}

		for (String configPath : configPaths) {
			InputStream inputStream = pluginContext
					.getResourceAsInputStream(configPath);
			URL url = pluginContext.getResourceAsUrl(configPath);
			String urlStr = url.toString();
			String tempFileName = urlStr.substring(urlStr.lastIndexOf('/') + 1,
					urlStr.length());
			File configurationFile = new File(tempChildFolder,
					tempFileName);

			try {
				if (inputStream != null) {

					IOUtils.copy(inputStream, new FileOutputStream(
							configurationFile));
					configFiles.put(configPath, configurationFile);
				}
				else
					configFiles.put(configPath, null);
			} catch (IOException e) {
				LOGGER.error("", e);
			}
		}

		return configFiles;
	}
	
}
