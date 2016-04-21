package org.bimserver.cobie.plugin.serializers;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.bimserver.cobie.shared.serialization.COBieSerializerPluginInfo;
//import org.bimserver.emf.Schema;
import org.bimserver.plugins.Plugin;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.schema.SchemaPlugin;
import org.bimserver.plugins.serializers.Serializer;

public class COBieSpaceTypeComponentReportPlugin extends
		AbstractCOBieSerializerPlugin
{
	private boolean initialized = false;
	private static final String SPACE_REPORT_CSS_PATH = "lib/SpaceReport.css";
	private static final String SPACE_REPORT_XSLT_PATH = "lib/SpaceReport.xslt";
	private ArrayList<String> configFilePaths;
	private HashMap<String, Path> configFiles = new HashMap<>();


	@Override
	public Serializer createSerializer(PluginConfiguration plugin)
	{
		return new org.bimserver.cobie.shared.serialization.COBieHTMLReportSerializer(
				configFiles.get(SPACE_REPORT_XSLT_PATH).toString(),
				configFiles.get(SPACE_REPORT_CSS_PATH).toString());
	}


	public String getName()
	{
		return getClass().getName();
	}

	// i am unsure of what this function does
	public Set<Class<? extends Plugin>> getRequiredPlugins()
	{
		Set<Class<? extends Plugin>> set = new HashSet<Class<? extends Plugin>>();
		set.add(SchemaPlugin.class);
		return set;
	}


	@Override
	public void init(PluginManager pluginManager) throws PluginException
	{
		configFilePaths = new ArrayList<String>();

		configFilePaths.add(SPACE_REPORT_XSLT_PATH);
		configFilePaths.add(SPACE_REPORT_CSS_PATH);
		//pluginManager.requireSchemaDefinition(Schema.IFC2X3TC1.name().toLowerCase());
		for(String path : configFilePaths)
		{
			configFiles.put(path, pluginManager.getPluginContext(this).getRootPath().resolve(path));
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
		return COBieSerializerPluginInfo.REPORT_ROOM_DATASHEET;
	}
}
