package org.erdc.cobie.plugins.serializers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.bimserver.models.store.ObjectDefinition;
import org.bimserver.plugins.Plugin;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.schema.SchemaPlugin;
import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.erdc.cobie.plugins.utils.ConfigUtil;
import org.erdc.cobie.shared.enums.COBieSerializerPluginName;

public class COBieSpaceTypeComponentReportPlugin implements SerializerPlugin 
{
private boolean initialized = false;
private static final String SPACE_REPORT_CSS_PATH =
"lib/SpaceReport.css";
private static final String SPACE_REPORT_XSLT_PATH="lib/SpaceReport.xslt";
private ArrayList<String> configFilePaths;
private HashMap<String,File> configFiles;
	@Override
	public String getDescription() {
		return "Produces a report of coponents by Space and then by type.";
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
			this.configFiles = ConfigUtil.prepareSerializerConfigFiles(pluginManager, getDefaultName(), this, configFilePaths);
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

	@Override
	public EmfSerializer createSerializer() {
		return new org.erdc.cobie.plugins.serializers.COBieHTMLReportSerializer(this.configFiles.get(SPACE_REPORT_XSLT_PATH).getAbsolutePath(),
				this.configFiles.get(SPACE_REPORT_CSS_PATH).getAbsolutePath());

	}
	
	@Override
	public String getDefaultName() {
		//return "COBIE";
		return COBieSerializerPluginName.COBIE_ROOM_DATASHEET_REPORT.toString();
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


@Override
public ObjectDefinition getSettingsDefinition()
{
	// TODO Auto-generated method stub
	return null;
}


@Override
public boolean needsGeometry()
{
	// TODO Auto-generated method stub
	return false;
}
}
