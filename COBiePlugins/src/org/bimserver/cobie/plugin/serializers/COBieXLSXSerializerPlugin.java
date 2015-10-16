package org.bimserver.cobie.plugin.serializers;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

import org.bimserver.cobie.shared.serialization.COBieSerializerPluginInfo;
import org.bimserver.cobie.shared.serialization.COBieXLSXSerializer;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginContext;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.objectidms.ObjectIDMException;
import org.bimserver.plugins.serializers.Serializer;

public class COBieXLSXSerializerPlugin extends AbstractCOBieSerializerPlugin 
{
	private static final String CONFIGURATION_FILE_ERROR = "Could not find configuration files";

	private static final String REPORT_FILES_TMP_DIRECTORY_NAME = "COBieReportFiles";
	private static final String TMP_FOLDER_NAME = "COBieSpreadsheetXLSXSerializer";
	private boolean initialized = false;
	private Path spreadSheetTemplate, settingsFile, spreadSheetXLSXTemplate;
	public static final String COBIE_EXPORT_SETTINGS_PATH = "lib/COBieExportSettings.xml";
	private static final String COBIE_SPREADSHEET_TEMPLATE_PATH = "lib/COBieExcelTemplate.xml";
	private static final String COBIE_COMPARE_XSLT_PATH = "lib/CompareReport.xslt";
	private static final String COBIE_SPREADSHEET_XLSX_TEMPLATE_PATH ="lib/COBieExcelTemplate.xlsx";

	@Override
	public Serializer createSerializer(PluginConfiguration plugin)
	{
		return new COBieXLSXSerializer(spreadSheetTemplate, spreadSheetXLSXTemplate, settingsFile);
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
			pluginManager.requireObjectIDM();

		}
		catch (ObjectIDMException e)
		{
			e.printStackTrace();
		}

		PluginContext pluginContext = pluginManager.getPluginContext(this);
		
		spreadSheetTemplate = pluginContext.getRootPath().resolve(COBIE_SPREADSHEET_TEMPLATE_PATH);
		settingsFile = pluginContext.getRootPath().resolve(COBIE_EXPORT_SETTINGS_PATH);
		spreadSheetXLSXTemplate = pluginContext.getRootPath().resolve(COBIE_SPREADSHEET_XLSX_TEMPLATE_PATH);

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
