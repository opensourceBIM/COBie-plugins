package org.bimserver.cobie.plugin.serializers;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.bimserver.cobie.shared.serialization.COBieSerializerPluginInfo;
import org.bimserver.plugins.Plugin;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.schema.SchemaPlugin;
import org.bimserver.plugins.serializers.Serializer;

public class SystemReportPlugin extends AbstractCOBieSerializerPlugin
{
	private static final String SYSTEM_REPORT_CSS_PATH =
	"lib/SpaceReport.css";
	private static final String SYSTEM_REPORT_XSLT_PATH="lib/SystemReport.xslt";
	private ArrayList<String> configFilePaths;
	private HashMap<String,Path> configFiles = new HashMap<>();

		public String getName() {
			return getClass().getName();
		}


		public Set<Class<? extends Plugin>> getRequiredPlugins() 
		{
			Set<Class<? extends Plugin>> set = new HashSet<Class<? extends Plugin>>();
			set.add(SchemaPlugin.class);
			return set;
		}


	@Override
	public boolean needsGeometry()
	{
		return false;
	}


	@Override
	public Serializer createSerializer(PluginConfiguration plugin)
	{
		return new org.bimserver.cobie.shared.serialization.COBieHTMLReportSerializer(this.configFiles.get(SYSTEM_REPORT_XSLT_PATH).toString(),
				this.configFiles.get(SYSTEM_REPORT_CSS_PATH).toString(), getTransformSettings());
	}


	@Override
	protected COBieSerializerPluginInfo getCOBieSerializerInfo()
	{
		return COBieSerializerPluginInfo.REPORT_SYSTEM;
	}


	@Override
	protected void onInit(PluginManager pluginManager) throws Exception 
	{
		configFilePaths = new ArrayList<String>();

		configFilePaths.add(SYSTEM_REPORT_XSLT_PATH);
		configFilePaths.add(SYSTEM_REPORT_CSS_PATH);
		//pluginManager.requireSchemaDefinition(Schema.IFC2X3TC1.name().toLowerCase());
		for(String path : configFilePaths)
		{
			configFiles.put(path, pluginManager.getPluginContext(this).getRootPath().resolve(path));
		}
		
	}

}
