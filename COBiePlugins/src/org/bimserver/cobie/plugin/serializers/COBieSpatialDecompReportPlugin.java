package org.bimserver.cobie.plugin.serializers;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import org.bimserver.cobie.shared.serialization.COBieSerializerPluginInfo;
import org.bimserver.emf.Schema;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginContext;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.serializers.AbstractSerializerPlugin;
import org.bimserver.plugins.serializers.Serializer;

public class COBieSpatialDecompReportPlugin extends AbstractSerializerPlugin 
{
private boolean initialized = false;
private static final String SPACE_REPORT_CSS_PATH = "lib/SpaceReport.css";
private static final String SPACE_REPORT_XSLT_PATH="lib/SpatialDecompReport.xslt";
private HashMap<String,Path> configFiles;
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
		PluginContext pluginContext = pluginManager.getPluginContext(this);
		
		configFiles = new HashMap<String, Path>();
		
		configFiles.put(SPACE_REPORT_XSLT_PATH, pluginContext.getRootPath().resolve(SPACE_REPORT_XSLT_PATH));
		configFiles.put(SPACE_REPORT_CSS_PATH, pluginContext.getRootPath().resolve(SPACE_REPORT_CSS_PATH));

		initialized = true;
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
		return new org.bimserver.cobie.shared.serialization.COBieHTMLReportSerializer(this.configFiles.get(SPACE_REPORT_XSLT_PATH).toString(),
				this.configFiles.get(SPACE_REPORT_CSS_PATH).toString());
	}


	@Override
	public Set<Schema> getSupportedSchemas() 
	{
		return Schema.IFC2X3TC1.toSet();
	}

}
