package org.bimserver.cobie.plugins;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.SerializerPlugin;

public class COBieZoneReportPlugin implements SerializerPlugin
{
	private boolean initialized = false;
	private static final String ZONE_REPORT_CSS_PATH =
	"lib/SpaceReport.css";
	private static final String ZONE_REPORT_XSLT_PATH="lib/ZoneReport.xslt";
	private ArrayList<String> configFilePaths;
	private HashMap<String,File> configFiles;
	@Override
	public void init(PluginManager pluginManager) throws PluginException
	{
		configFilePaths = new ArrayList<String>();

		configFilePaths.add(ZONE_REPORT_XSLT_PATH);
		configFilePaths.add(ZONE_REPORT_CSS_PATH);
		pluginManager.requireSchemaDefinition();
		this.configFiles = ConfigUtil.prepareSerializerConfigFiles(pluginManager, getDefaultSerializerName(), this, configFilePaths);
		initialized = true;

	}

	@Override
	public String getDescription()
	{
		return "A report listing Zones, Spaces in Zones, and Zone COBie fields.";
	}

	@Override
	public String getVersion()
	{
		return "1.0";
	}

	@Override
	public boolean isInitialized()
	{
		return initialized;
	}

	@Override
	public EmfSerializer createSerializer()
	{
		return new org.bimserver.cobie.plugins.COBieHTMLReportSerializer(this.configFiles.get(ZONE_REPORT_XSLT_PATH).getAbsolutePath(),
				this.configFiles.get(ZONE_REPORT_CSS_PATH).getAbsolutePath());
	}

	@Override
	public String getDefaultSerializerName()
	{
		return "COBieZoneReport";
	}

	@Override
	public String getDefaultExtension()
	{
		return "html";
	}

	@Override
	public String getDefaultContentType()
	{
		return "appliction/html";
	}

}
