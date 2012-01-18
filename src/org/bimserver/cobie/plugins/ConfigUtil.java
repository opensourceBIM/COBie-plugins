package org.bimserver.cobie.plugins;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.bimserver.plugins.Plugin;
import org.bimserver.plugins.PluginContext;
import org.bimserver.plugins.PluginManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger(ConfigUtil.class);
	private static final String tempDirectoryName = "tmp";
	private static final String tempFileNameSuffix = "ExcelTemplate.xml";

	public static File prepareXelemConfigFile(PluginManager pluginManager, String name, Plugin plugin,String configPath) {
		// We copy the cobie configuration file to tmp because xelem can only read from a file
		PluginContext pluginContext = pluginManager.getPluginContext(plugin);
		InputStream inputStream = pluginContext.getResourceAsInputStream(configPath);
		String tempFileName = name+ "_"+ tempFileNameSuffix;
		if (inputStream != null) {
			File tmpFolder = new File(pluginManager.getTempDir(), tempDirectoryName);
			File cobie = new File(tmpFolder, name);
			try {
				if (cobie.exists()) {
					FileUtils.forceDelete(cobie);
				}
				FileUtils.forceMkdir(cobie);
				File configurationFile = new File(cobie, tempFileName);
				IOUtils.copy(inputStream, new FileOutputStream(configurationFile));
				return configurationFile;
			} catch (IOException e) {
				LOGGER.error("", e);
			}
		}
		return null;
	}
}
