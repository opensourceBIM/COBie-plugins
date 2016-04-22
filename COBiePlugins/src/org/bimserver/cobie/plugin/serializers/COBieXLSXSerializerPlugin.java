package org.bimserver.cobie.plugin.serializers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.bimserver.cobie.shared.serialization.COBieSerializerPluginInfo;
import org.bimserver.cobie.shared.serialization.COBieXLSXSerializer;
import org.bimserver.cobie.shared.utility.PluginRuntimeFileHelper;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.serializers.Serializer;

public class COBieXLSXSerializerPlugin extends AbstractCOBieSerializerPlugin 
{
	private boolean initialized = false;
	private File spreadSheetTemplate, settingsFile, spreadSheetXLSXTemplate;
	public static final String COBIE_EXPORT_SETTINGS_PATH = "lib/COBieExportSettings.xml";
	private static final String COBIE_SPREADSHEET_TEMPLATE_PATH = "lib/COBieExcelTemplate.xml";
	private static final String COBIE_SPREADSHEET_XLSX_TEMPLATE_PATH ="lib/COBieExcelTemplate.xlsx";
	private HashMap<String, File> configFiles = new HashMap<>();
	@Override
	public Serializer createSerializer(PluginConfiguration plugin)
	{
		return new COBieXLSXSerializer(spreadSheetTemplate, 
				spreadSheetXLSXTemplate, 
				settingsFile);
	}

	private ArrayList<String> getConfigFilePaths()
	{
		ArrayList<String> configFilePaths = new ArrayList<String>();
		configFilePaths.add(COBIE_EXPORT_SETTINGS_PATH);
		configFilePaths.add(COBIE_SPREADSHEET_TEMPLATE_PATH);
		configFilePaths.add(COBIE_SPREADSHEET_XLSX_TEMPLATE_PATH);
		return configFilePaths;
	}

	@Override
	public void init(PluginManager pluginManager) throws PluginException
	{
		try 
		{
			configFiles = PluginRuntimeFileHelper.prepareSerializerConfigFiles(pluginManager, getClass().getSimpleName(), this, getConfigFilePaths());
		} 
		catch (IOException e) 
		{
			throw new PluginException(e);
		}
		spreadSheetTemplate = configFiles.get(COBIE_SPREADSHEET_TEMPLATE_PATH);
		settingsFile = configFiles.get(COBIE_EXPORT_SETTINGS_PATH);
		spreadSheetXLSXTemplate = configFiles.get(COBIE_SPREADSHEET_XLSX_TEMPLATE_PATH);
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
		return COBieSerializerPluginInfo.SPREADSHEET_XLSX;
	}

}
