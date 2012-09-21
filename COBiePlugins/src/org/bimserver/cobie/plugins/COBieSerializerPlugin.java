package org.bimserver.cobie.plugins;
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
import java.util.ArrayList;
import java.util.HashMap;

import org.bimserver.cobie.cobieserializersettings.COBieExportOptionsDocument;
import org.bimserver.plugins.ObjectIDMException;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.SerializerPlugin;

public class COBieSerializerPlugin implements SerializerPlugin {

	private static final String REPORT_FILES_TMP_DIRECTORY_NAME = "COBieReportFiles";
	private static final String TMP_FOLDER_NAME = "COBieSerializer";
	private boolean initialized = false;
	private File spreadSheetTemplate,settingsFile;
	public static final String COBIE_EXPORT_SETTINGS_PATH = "lib/COBieExportSettings.xml";
	private static final String COBIE_SPREADSHEET_TEMPLATE_PATH = "lib/COBieExcelTemplate.xml";		
	private static final String COBIE_COMPARE_XSLT_PATH = "lib/CompareReport.xslt";
	@Override
	public String getDescription() {
		return "Construction Operators Building information exchange spreadsheetML format.";
	}
	
	@Override
	public String getVersion() {
		return "1.0";
	}

	@Override
	public void init(PluginManager pluginManager) throws PluginException {
		pluginManager.requireSchemaDefinition();
		try
		{
			pluginManager.requireObjectIDM();
			
		}
		catch (ObjectIDMException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		HashMap<String,File> configFiles = ConfigUtil.prepareSerializerConfigFiles(pluginManager, TMP_FOLDER_NAME,this,getConfigFilePaths());
		spreadSheetTemplate = configFiles.get(COBIE_SPREADSHEET_TEMPLATE_PATH);
		settingsFile = configFiles.get(COBIE_EXPORT_SETTINGS_PATH);
		ConfigUtil.prepareSerializerConfigFile(pluginManager, REPORT_FILES_TMP_DIRECTORY_NAME, this,COBIE_COMPARE_XSLT_PATH);	
		initialized = true;
	}
	
	private ArrayList<String> getConfigFilePaths()
	{
		ArrayList<String> configFilePaths = new ArrayList<String>();
		configFilePaths.add(COBIE_EXPORT_SETTINGS_PATH);
		configFilePaths.add(COBIE_SPREADSHEET_TEMPLATE_PATH);
		return configFilePaths;
	}
	
	@Override
	public EmfSerializer createSerializer() {
		return new COBieSerializer(spreadSheetTemplate,settingsFile);
	}
	
	@Override
	public String getDefaultSerializerName() {
		//return "COBIE";
		return "COBie";
	}

	///////////////////////////////
	///need to fix these content and extension functions.
	///had to use html to get it to work
	@Override
	public String getDefaultContentType() {
		//return "appliction/COBIE";
		return "application/COBIE";
	}

	@Override
	public String getDefaultExtension() {
		//return "xml";//Change this to proper extension
		return "xml";
	}
 /////////////////////////////////////////////////
	@Override
	public boolean isInitialized() {
		return initialized;
	}
}