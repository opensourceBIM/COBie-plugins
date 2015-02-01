package org.erdc.cobie.plugins.serializers;

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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import org.bimserver.emf.Schema;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.objectidms.ObjectIDMException;
import org.bimserver.plugins.serializers.Serializer;
import org.erdc.cobie.shared.bimserver.cobietab.serialization.COBieSerializerPluginInfo;
import org.erdc.cobie.shared.bimserver.cobietab.serialization.COBieSpreadsheetMLSerializer;
import org.erdc.cobie.shared.bimserver.utility.PluginRuntimeFileHelper;

public class COBieSerializerPlugin extends AbstractCOBieSerializerPlugin
{

	private static final String CONFIGURATION_FILE_ERROR = "Could not find configuration files";

	private static final String REPORT_FILES_TMP_DIRECTORY_NAME = "COBieReportFiles";
	private static final String TMP_FOLDER_NAME = "COBieSpreadsheetMLSerializer";
	private boolean initialized = false;
	private File spreadSheetTemplate, settingsFile;
	public static final String COBIE_EXPORT_SETTINGS_PATH = "lib/COBieExportSettings.xml";
	private static final String COBIE_SPREADSHEET_TEMPLATE_PATH = "lib/COBieExcelTemplate.xml";
	private static final String COBIE_COMPARE_XSLT_PATH = "lib/CompareReport.xslt";

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
			configFiles = PluginRuntimeFileHelper.prepareSerializerConfigFiles(
					pluginManager, TMP_FOLDER_NAME, this, getConfigFilePaths());
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
			throw new PluginException(CONFIGURATION_FILE_ERROR);
		}
		spreadSheetTemplate = configFiles.get(COBIE_SPREADSHEET_TEMPLATE_PATH);
		settingsFile = configFiles.get(COBIE_EXPORT_SETTINGS_PATH);
		try
		{
			PluginRuntimeFileHelper.prepareSerializerConfigFile(pluginManager,
					REPORT_FILES_TMP_DIRECTORY_NAME, this,
					COBIE_COMPARE_XSLT_PATH);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
			throw new PluginException(CONFIGURATION_FILE_ERROR);
		}
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

	@Override
	public Set<Schema> getSupportedSchemas() 
	{
		return Schema.IFC2X3TC1.toSet();
	}
}