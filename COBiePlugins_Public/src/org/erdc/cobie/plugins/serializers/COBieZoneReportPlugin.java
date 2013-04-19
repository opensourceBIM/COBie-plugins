package org.erdc.cobie.plugins.serializers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

import org.bimserver.models.store.ObjectDefinition;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.erdc.cobie.plugins.utils.ConfigUtil;
import org.erdc.cobie.shared.enums.COBieSerializerPluginName;

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
		try
		{
			this.configFiles = ConfigUtil.prepareSerializerConfigFiles(pluginManager, getDefaultName(), this, configFilePaths);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
			throw new PluginException("Could not find configuration files");
		}
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
		return new org.erdc.cobie.plugins.serializers.COBieHTMLReportSerializer(this.configFiles.get(ZONE_REPORT_XSLT_PATH).getAbsolutePath(),
				this.configFiles.get(ZONE_REPORT_CSS_PATH).getAbsolutePath());
	}

	@Override
	public String getDefaultName()
	{
		return COBieSerializerPluginName.COBIE_ZONE_REPORT.toString();
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

	@Override
	public ObjectDefinition getSettingsDefinition()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean needsGeometry()
	{
		// TODO Auto-generated method stub
		return false;
	}

}
