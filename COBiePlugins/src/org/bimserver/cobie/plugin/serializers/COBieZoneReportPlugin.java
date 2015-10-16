package org.bimserver.cobie.plugin.serializers;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

import org.bimserver.cobie.shared.serialization.COBieSerializerPluginInfo;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginContext;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.serializers.Serializer;

public class COBieZoneReportPlugin extends AbstractCOBieSerializerPlugin
{
	private boolean initialized = false;
	private static final String ZONE_REPORT_CSS_PATH = "lib/SpaceReport.css";
	private static final String ZONE_REPORT_XSLT_PATH = "lib/ZoneReport.xslt";
	private HashMap<String, Path> configFiles;

	@Override
	public Serializer createSerializer(PluginConfiguration plugin)
	{

		return new org.bimserver.cobie.shared.serialization.COBieHTMLReportSerializer(

				configFiles.get(ZONE_REPORT_XSLT_PATH).toString(),
				configFiles.get(ZONE_REPORT_CSS_PATH).toString());
	}

	@Override
	public void init(PluginManager pluginManager) throws PluginException
	{
		PluginContext pluginContext = pluginManager.getPluginContext(this);
		
		configFiles = new HashMap<String, Path>();
		
		configFiles.put(ZONE_REPORT_XSLT_PATH, pluginContext.getRootPath().resolve(ZONE_REPORT_XSLT_PATH));
		configFiles.put(ZONE_REPORT_CSS_PATH, pluginContext.getRootPath().resolve(ZONE_REPORT_CSS_PATH));

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
		return COBieSerializerPluginInfo.REPORT_ZONE;
	}
	
}
