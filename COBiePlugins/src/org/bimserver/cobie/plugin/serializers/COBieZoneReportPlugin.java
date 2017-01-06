package org.bimserver.cobie.plugin.serializers;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

import org.bimserver.cobie.shared.serialization.COBieSerializerPluginInfo;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.serializers.Serializer;

public class COBieZoneReportPlugin extends AbstractCOBieSerializerPlugin
{
	private static final String ZONE_REPORT_CSS_PATH = "lib/SpaceReport.css";
	private static final String ZONE_REPORT_XSLT_PATH = "lib/ZoneReport.xslt";
	private ArrayList<String> configFilePaths;
	private HashMap<String, Path> configFiles;

	@Override
	public Serializer createSerializer(PluginConfiguration plugin)
	{

		return new org.bimserver.cobie.shared.serialization.COBieHTMLReportSerializer(

				configFiles.get(ZONE_REPORT_XSLT_PATH).toString(),
				configFiles.get(ZONE_REPORT_CSS_PATH).toString(), getTransformSettings());
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

	@Override
	protected void onInit(PluginManager pluginManager) throws Exception 
	{
		configFilePaths = new ArrayList<String>();

		configFilePaths.add(ZONE_REPORT_XSLT_PATH);
		configFilePaths.add(ZONE_REPORT_CSS_PATH);
		configFiles = new HashMap<>();
		for(String path : configFilePaths)
		{
			configFiles.put(path, pluginManager.getPluginContext(this).getRootPath().resolve(path));
		}
		
	}
	
}
