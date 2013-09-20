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
import org.bimserver.plugins.serializers.AbstractSerializerPlugin;
import org.bimserver.plugins.serializers.Serializer;
import org.erdc.cobie.plugins.utils.PluginRuntimeFileHelper;
import org.erdc.cobie.shared.enums.COBieSerializerPluginInfo;

public class COBieSpatialDecompReportPlugin extends AbstractSerializerPlugin 
{
private boolean initialized = false;
private static final String SPACE_REPORT_CSS_PATH =
"lib/SpaceReport.css";
private static final String SPACE_REPORT_XSLT_PATH="lib/SpatialDecompReport.xslt";
private ArrayList<String> configFilePaths;
private HashMap<String,File> configFiles;
	@Override
	public String getDescription() {
		return COBieSerializerPluginInfo.REPORT_SPATIAL_DECOMPOSITION.getDescription();
	}

	
	public String getName() {
		return getClass().getName();
	}

	@Override
	public String getVersion() {
		return "1.0";
	}

	@Override
	public void init(PluginManager pluginManager) throws PluginException {
		configFilePaths = new ArrayList<String>();

		configFilePaths.add(SPACE_REPORT_XSLT_PATH);
		configFilePaths.add(SPACE_REPORT_CSS_PATH);
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

	public Serializer createSerializer() {
		return createSerializer(null);

	}
	
	@Override
	public String getDefaultName() {
		return COBieSerializerPluginInfo.REPORT_SPATIAL_DECOMPOSITION.toString();
	}

	///////////////////////////////
	///need to fix these content and extension functions.
	///had to use html to get it to work
	@Override
	public String getDefaultContentType() {
		return "appliction/html";
	}

	@Override
	public String getDefaultExtension() {
		//return "xml";//Change this to proper extension
		return COBieSerializerPluginInfo.REPORT_SPATIAL_DECOMPOSITION.getFileExtension();
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
		return new org.erdc.cobie.serializers.COBieHTMLReportSerializer(this.configFiles.get(SPACE_REPORT_XSLT_PATH).getAbsolutePath(),
				this.configFiles.get(SPACE_REPORT_CSS_PATH).getAbsolutePath());
	}
}
