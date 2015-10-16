package org.bimserver.cobie.plugin.serializers;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

import org.bimserver.cobie.shared.serialization.COBieSerializerPluginInfo;
import org.bimserver.cobie.shared.serialization.COBieSpreadsheetMLSerializer;
import org.bimserver.emf.Schema;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginContext;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.objectidms.ObjectIDMException;
import org.bimserver.plugins.serializers.Serializer;

public class COBieSerializerPlugin extends AbstractCOBieSerializerPlugin
{

	private static final String CONFIGURATION_FILE_ERROR = "Could not find configuration files";

	private static final String REPORT_FILES_TMP_DIRECTORY_NAME = "COBieReportFiles";
	private static final String TMP_FOLDER_NAME = "COBieSpreadsheetMLSerializer";
	private boolean initialized = false;
	private Path spreadSheetTemplate, settingsFile;
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

		PluginContext pluginContext = pluginManager.getPluginContext(this);
		
		HashMap<String, Path> configFiles;
		spreadSheetTemplate = pluginContext.getRootPath().resolve(COBIE_SPREADSHEET_TEMPLATE_PATH);
		settingsFile = pluginContext.getRootPath().resolve(COBIE_EXPORT_SETTINGS_PATH);
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