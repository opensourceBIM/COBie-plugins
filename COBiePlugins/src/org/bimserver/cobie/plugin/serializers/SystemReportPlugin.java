package org.bimserver.cobie.plugin.serializers;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.bimserver.cobie.shared.serialization.COBieSerializerPluginInfo;
import org.bimserver.plugins.Plugin;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginContext;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.schema.SchemaPlugin;
import org.bimserver.plugins.serializers.Serializer;

public class SystemReportPlugin extends AbstractCOBieSerializerPlugin
{
	private boolean initialized = false;
	private static final String SYSTEM_REPORT_CSS_PATH = "lib/SpaceReport.css";
	private static final String SYSTEM_REPORT_XSLT_PATH="lib/SystemReport.xslt";
	private HashMap<String,Path> configFiles;

		public String getName() {
			return getClass().getName();
		}


		@Override
		public void init(PluginManager pluginManager) throws PluginException {
			PluginContext pluginContext = pluginManager.getPluginContext(this);
			
			configFiles = new HashMap<String, Path>();
			
			configFiles.put(SYSTEM_REPORT_XSLT_PATH, pluginContext.getRootPath().resolve(SYSTEM_REPORT_XSLT_PATH));
			configFiles.put(SYSTEM_REPORT_CSS_PATH, pluginContext.getRootPath().resolve(SYSTEM_REPORT_CSS_PATH));

			initialized = true;
		}

		public Set<Class<? extends Plugin>> getRequiredPlugins() 
		{
			Set<Class<? extends Plugin>> set = new HashSet<Class<? extends Plugin>>();
			set.add(SchemaPlugin.class);
			return set;
		}

	 /////////////////////////////////////////////////
		@Override
		public boolean isInitialized() {
			return initialized;
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
				this.configFiles.get(SYSTEM_REPORT_CSS_PATH).toString());
	}


	@Override
	protected COBieSerializerPluginInfo getCOBieSerializerInfo()
	{
		return COBieSerializerPluginInfo.REPORT_SYSTEM;
	}

}
