package org.bimserver.cobie.plugins;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.bimserver.plugins.Plugin;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.schema.SchemaPlugin;
import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.SerializerPlugin;

public class COBieSpatialDecompReportPlugin implements SerializerPlugin 
{
private boolean initialized = false;
private static final String SPACE_REPORT_CSS_PATH =
"lib/SpaceReport.css";
private static final String SPACE_REPORT_XSLT_PATH="lib/SpatialDecompReport.xslt";
private ArrayList<String> configFilePaths;
private HashMap<String,File> configFiles;
	@Override
	public String getDescription() {
		return "Produces a report of spaces by floors.";
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
		this.configFiles = ConfigUtil.prepareSerializerConfigFiles(pluginManager, getDefaultSerializerName(), this, configFilePaths);
		initialized = true;
	}

	
	//i am unsure of what this function does 
	public Set<Class<? extends Plugin>> getRequiredPlugins() {
		Set<Class<? extends Plugin>> set = new HashSet<Class<? extends Plugin>>();
		set.add(SchemaPlugin.class);
		return set;
	}

	@Override
	public EmfSerializer createSerializer() {
		return new org.bimserver.cobie.plugins.COBieHTMLReportSerializer(this.configFiles.get(SPACE_REPORT_XSLT_PATH).getAbsolutePath(),
				this.configFiles.get(SPACE_REPORT_CSS_PATH).getAbsolutePath());

	}
	
	@Override
	public String getDefaultSerializerName() {
		//return "COBIE";
		return "COBieSpatialDecompositionReport";
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
		return "html";
	}
 /////////////////////////////////////////////////
	@Override
	public boolean isInitialized() {
		return initialized;
	}
}
