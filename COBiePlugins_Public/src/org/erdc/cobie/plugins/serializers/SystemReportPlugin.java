package org.erdc.cobie.plugins.serializers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.bimserver.plugins.Plugin;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.schema.SchemaPlugin;
import org.bimserver.plugins.serializers.Serializer;
import org.erdc.cobie.plugins.utils.PluginRuntimeFileHelper;
import org.erdc.cobie.shared.enums.COBieSerializerPluginInfo;

public class SystemReportPlugin extends AbstractCOBieSerializerPlugin
{
	private boolean initialized = false;
	private static final String SYSTEM_REPORT_CSS_PATH =
	"lib/SpaceReport.css";
	private static final String SYSTEM_REPORT_XSLT_PATH="lib/SystemReport.xslt";
	private ArrayList<String> configFilePaths;
	private HashMap<String,File> configFiles;

		public String getName() {
			return getClass().getName();
		}


		@Override
		public void init(PluginManager pluginManager) throws PluginException {
			configFilePaths = new ArrayList<String>();

			configFilePaths.add(SYSTEM_REPORT_XSLT_PATH);
			configFilePaths.add(SYSTEM_REPORT_CSS_PATH);
			pluginManager.requireSchemaDefinition();
			try
			{
				this.configFiles = PluginRuntimeFileHelper.prepareSerializerConfigFiles(pluginManager, getDefaultName(), this, configFilePaths);
			}
			catch (FileNotFoundException e)
			{
				e.printStackTrace();
				throw new PluginException("Could not find configuration files");
			}
			initialized = true;
		}

		
		//i am unsure of what this function does 
		public Set<Class<? extends Plugin>> getRequiredPlugins() {
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
		return new org.erdc.cobie.serializers.COBieHTMLReportSerializer(this.configFiles.get(SYSTEM_REPORT_XSLT_PATH).getAbsolutePath(),
				this.configFiles.get(SYSTEM_REPORT_CSS_PATH).getAbsolutePath());
	}


	@Override
	protected COBieSerializerPluginInfo getCOBieSerializerInfo()
	{
		return COBieSerializerPluginInfo.REPORT_SYSTEM;
	}

}
