package org.bimserver.cobie.plugin.serializers;

/******************************************************************************
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
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.bimserver.cobie.shared.serialization.COBieSerializerPluginInfo;
import org.bimserver.cobie.shared.serialization.COBieSpreadsheetMLSerializer;
import org.bimserver.cobie.shared.utility.PluginRuntimeFileHelper;
import org.bimserver.emf.Schema;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.objectidms.ObjectIDMException;
import org.bimserver.plugins.serializers.Serializer;

public class COBieSerializerPlugin extends AbstractCOBieSerializerPlugin
{
	private boolean initialized = false;
	private File spreadSheetTemplate, settingsFile;
	public static final String COBIE_EXPORT_SETTINGS_PATH = "lib/COBieExportSettings.xml";
	private static final String COBIE_SPREADSHEET_TEMPLATE_PATH = "lib/COBieExcelTemplate.xml";

	@Override
	public Serializer createSerializer(PluginConfiguration plugin)
	{
		return new COBieSpreadsheetMLSerializer(spreadSheetTemplate, settingsFile);
	}

	private ArrayList<String> getConfigFilePaths()
	{
		ArrayList<String> configFilePaths = new ArrayList<String>();
		configFilePaths.add(COBIE_EXPORT_SETTINGS_PATH);
		configFilePaths.add(COBIE_SPREADSHEET_TEMPLATE_PATH);
		return configFilePaths;
	}

	@Override
	public void init(PluginManager pluginManager) throws PluginException
	{
		pluginManager.requireSchemaDefinition(Schema.IFC2X3TC1.name().toLowerCase());
		try
		{
			pluginManager.requireObjectIDM();

		}
		catch (ObjectIDMException e)
		{
			e.printStackTrace();
		}

		HashMap<String, File> configFiles;
		try 
		{
			configFiles = PluginRuntimeFileHelper.prepareSerializerConfigFiles(pluginManager, getClass().getSimpleName(), this, getConfigFilePaths());
		} catch (IOException e) 
		{
			throw new PluginException(e);
		}
		spreadSheetTemplate = configFiles.get(COBIE_SPREADSHEET_TEMPLATE_PATH);
		settingsFile = configFiles.get(COBIE_EXPORT_SETTINGS_PATH);
		initialized = true;
	}

	@Override
	public boolean isInitialized()
	{
		return initialized;
	}

	@Override
	public boolean needsGeometry()
	{
		return false;
	}

	@Override
	protected COBieSerializerPluginInfo getCOBieSerializerInfo()
	{
		return COBieSerializerPluginInfo.SPREADSHEET;
	}

}