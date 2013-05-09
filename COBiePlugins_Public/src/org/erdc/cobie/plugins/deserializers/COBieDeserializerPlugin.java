package org.erdc.cobie.plugins.deserializers;

/******************************************************************************
 * Copyright (C) 2011  ERDC
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/
import java.io.File;
import java.io.FileNotFoundException;

import org.bimserver.models.store.ObjectDefinition;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.Deserializer;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.deserializers.EmfDeserializer;
import org.bimserver.plugins.schema.SchemaException;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.erdc.cobie.plugins.serializers.COBieCheckSerializerPlugin;
import org.erdc.cobie.plugins.utils.PluginRuntimeFileHelper;
import org.erdc.cobie.shared.enums.COBieDeserializerPluginName;

public class COBieDeserializerPlugin implements DeserializerPlugin {
	private static String localConfigFilePath = "lib/COBieExcelTemplate.xml";	
	private static String COBIE_PREIMPORT_CHECK_DIRECTORY_NAME = "COBiePreImportComplianceReports";
	private boolean initialized = false;
	private File configurationFile;
	private File preImportFileDirectory;
	private COBieCheckSerializerPlugin checkSerializer;
	
	
	public Deserializer createDeserializer() {
		return this.createDeserializer(null);
	}

	@Override
	public String getDescription() {
		return "Deserializes COBie spreadsheetML into the model server.";
	}

	@Override
	public String getVersion() {
		return "1.0";
	}

	@Override
	public void init(PluginManager pluginManager) throws SchemaException, PluginException {
		checkSerializer = null;
		for(SerializerPlugin plugin: pluginManager.getAllSerializerPlugins(true))
		{
			if (plugin instanceof COBieCheckSerializerPlugin)
				this.checkSerializer = (COBieCheckSerializerPlugin) plugin;
		}
		try
		{
			configurationFile = PluginRuntimeFileHelper.prepareSerializerConfigFile(pluginManager, "COBieDeserializer", this,localConfigFilePath);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
			throw new PluginException("Could not find configuration files");
		}
		preImportFileDirectory = PluginRuntimeFileHelper.getDirectory(pluginManager, COBIE_PREIMPORT_CHECK_DIRECTORY_NAME);
		initialized = true;
	}
	
	@Override
	public boolean canHandleExtension(String extension) {
		return extension.equalsIgnoreCase("xml");
	}

	@Override
	public boolean isInitialized() {
		return initialized;
	}



	@Override
	public String getDefaultName()
	{
		return COBieDeserializerPluginName.COBIE_SPREADHSEET.toString();
	}

	@Override
	public ObjectDefinition getSettingsDefinition()
	{
		return null;
	}

	@Override
	public Deserializer createDeserializer(
			PluginConfiguration pluginConfiguration)
	{
		return new COBieDeserializer(configurationFile,preImportFileDirectory,checkSerializer);
	}
}