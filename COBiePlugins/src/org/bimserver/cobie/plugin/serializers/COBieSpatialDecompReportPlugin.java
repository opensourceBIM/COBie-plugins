package org.bimserver.cobie.plugin.serializers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.bimserver.cobie.shared.serialization.COBieSerializerPluginInfo;
import org.bimserver.cobie.shared.utility.PluginRuntimeFileHelper;
import org.bimserver.emf.Schema;
//import org.bimserver.emf.Schema;
import org.bimserver.plugins.Plugin;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.schema.SchemaPlugin;
import org.bimserver.plugins.serializers.AbstractSerializerPlugin;
import org.bimserver.plugins.serializers.Serializer;

public class COBieSpatialDecompReportPlugin extends AbstractSerializerPlugin 
{
private boolean initialized = false;
private static final String SPACE_REPORT_CSS_PATH =
"lib/SpaceReport.css";
private static final String SPACE_REPORT_XSLT_PATH="lib/SpatialDecompReport.xslt";
private ArrayList<String> configFilePaths;
private HashMap<String, File> configFiles = new HashMap<>();
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
	//	pluginManager.requireSchemaDefinition(Schema.IFC2X3TC1.name().toString());
		try 
		{
			configFiles = PluginRuntimeFileHelper.prepareSerializerConfigFiles(pluginManager, getClass().getSimpleName(), this, configFilePaths);
		} 
		catch (IOException e) 
		{
			throw new PluginException(e);
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
		return new org.bimserver.cobie.shared.serialization.COBieHTMLReportSerializer(this.configFiles.get(SPACE_REPORT_XSLT_PATH).getAbsolutePath(),
				this.configFiles.get(SPACE_REPORT_CSS_PATH).getAbsolutePath());
	}


	@Override
	public Set<Schema> getSupportedSchemas() 
	{
		return Schema.IFC2X3TC1.toSet();
	}

}
