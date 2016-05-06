package org.bimserver.cobie.plugin.serializers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.bimserver.cobie.shared.serialization.COBieSerializerPluginInfo;
import org.bimserver.cobie.shared.utility.PluginRuntimeFileHelper;
import org.bimserver.cobie.shared.utility.PluginRuntimeFileHelper.Persistence;
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
	private static final String SPACE_REPORT_CSS_PATH = "lib/SpaceReport.css";
	private static final String SPACE_REPORT_XSLT_PATH = "lib/SpaceReport.xslt";
	private ArrayList<String> configFilePaths;
	private HashMap<String, File> configFiles = new HashMap<>();


	@Override
	public Serializer createSerializer(PluginConfiguration plugin)
	{
		return new org.bimserver.cobie.shared.serialization.COBieHTMLReportSerializer(
				configFiles.get(SPACE_REPORT_XSLT_PATH).getAbsolutePath(),
				configFiles.get(SPACE_REPORT_CSS_PATH).getAbsolutePath(), getTransformSettings());
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
	public boolean needsGeometry()
	{
		return false;
	}


	@Override
	protected COBieSerializerPluginInfo getCOBieSerializerInfo()
	{
		return COBieSerializerPluginInfo.REPORT_ROOM_DATASHEET;
	}


	@Override
	protected void onInit(PluginManager pluginManager) throws Exception 
	{
		configFilePaths = new ArrayList<String>();

		configFilePaths.add(SPACE_REPORT_XSLT_PATH);
		configFilePaths.add(SPACE_REPORT_CSS_PATH);
		//pluginManager.requireSchemaDefinition(Schema.IFC2X3TC1.name().toLowerCase());
		try 
		{
			configFiles = PluginRuntimeFileHelper.prepareSerializerResource(pluginManager, getClass().getSimpleName(), this, configFilePaths,Persistence.TEMP);
		} catch (IOException e) 
		{
			throw new PluginException(e);
		}
		
	}
}
