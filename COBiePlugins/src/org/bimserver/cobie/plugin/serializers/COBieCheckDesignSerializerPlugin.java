package org.bimserver.cobie.plugin.serializers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.bimserver.cobie.shared.reporting.COBieQCValidationPhase;
import org.bimserver.cobie.shared.reporting.COBieSchematronCheckerSettings;
import org.bimserver.cobie.shared.serialization.COBieSerializerPluginInfo;
import org.bimserver.cobie.shared.utility.PluginRuntimeFileHelper;
import org.bimserver.emf.Schema;
import org.bimserver.plugins.Plugin;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.schema.SchemaPlugin;
import org.bimserver.plugins.serializers.Serializer;

public class COBieCheckDesignSerializerPlugin extends AbstractCOBieSerializerPlugin
{
	private boolean initialized = false;
	private static final String SCHEMATRON_RULEPATH = "lib/COBieRules.sch";
	private static final String SCHEMATRON_FUNCTIONPATH = "lib/COBieRules_Functions.xsl";
	private static final String PRE_PROCESSOR_PATH = "lib/iso_svrl_for_xslt2.xsl";
	private static final String SVRL_HTML_XSLT_PATH = "lib/SVRL_HTML_altLocation.xslt";
	private static final String CSS_PATH = "lib/SpaceReport.css";
	private static final String SCHEMATRON_SAXON_SKELETON_PATH = "lib/iso_schematron_skeleton_for_saxon.xsl";
	private ArrayList<String> configFilePaths;
	private HashMap<String, File> configFiles;
	private COBieSchematronCheckerSettings checkerSettings;
	@Override
	public Serializer createSerializer(PluginConfiguration plugin)
	{
		return new org.bimserver.cobie.shared.serialization.COBieCheckSerializer(checkerSettings);
	}


	public String getName()
	{
		return getClass().getName();
	}

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
		configFilePaths.add(SCHEMATRON_RULEPATH);
		configFilePaths.add(PRE_PROCESSOR_PATH);
		configFilePaths.add(SCHEMATRON_SAXON_SKELETON_PATH);
		configFilePaths.add(SVRL_HTML_XSLT_PATH);
		configFilePaths.add(CSS_PATH);
		configFilePaths.add(SCHEMATRON_FUNCTIONPATH);
		pluginManager.requireSchemaDefinition(Schema.IFC2X3TC1.name());
		try
		{
			configFiles = PluginRuntimeFileHelper.prepareSerializerConfigFiles(
					pluginManager, getDefaultName(), this, configFilePaths);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
			throw new PluginException("Could not find configuration files");
		}
		checkerSettings = new COBieSchematronCheckerSettings(configFiles.get(SCHEMATRON_RULEPATH).getAbsolutePath(), 
				configFiles.get(PRE_PROCESSOR_PATH).getAbsolutePath(), configFiles
				.get(SVRL_HTML_XSLT_PATH).getAbsolutePath(), COBieQCValidationPhase.Design);
		initialized = true;
	}

	// ///////////////////////////////////////////////
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
		return COBieSerializerPluginInfo.REPORT_QC_DESIGN;
	}

}
