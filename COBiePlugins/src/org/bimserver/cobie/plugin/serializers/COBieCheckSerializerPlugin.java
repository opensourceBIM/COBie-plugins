package org.bimserver.cobie.plugin.serializers;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.bimserver.cobie.shared.reporting.COBieQCValidationPhase;
import org.bimserver.cobie.shared.reporting.COBieSchematronCheckerSettings;
import org.bimserver.cobie.shared.serialization.COBieSerializerPluginInfo;
import org.bimserver.emf.Schema;
import org.bimserver.plugins.Plugin;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginContext;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.schema.SchemaPlugin;
import org.bimserver.plugins.serializers.Serializer;

public class COBieCheckSerializerPlugin extends AbstractCOBieSerializerPlugin
{
	private boolean initialized = false;
	private static final String SCHEMATRON_RULEPATH = "lib/COBieRules.sch";
	private static final String SCHEMATRON_FUNCTIONPATH = "lib/COBieRules_Functions.xsl";
	private static final String PRE_PROCESSOR_PATH = "lib/iso_svrl_for_xslt2.xsl";
	private static final String SVRL_HTML_XSLT_PATH = "lib/SVRL_HTML_altLocation.xslt";
	private static final String CSS_PATH = "lib/SpaceReport.css";
	private static final String SCHEMATRON_SAXON_SKELETON_PATH = "lib/iso_schematron_skeleton_for_saxon.xsl";
	private ArrayList<String> configFilePaths;
	private HashMap<String, Path> configFiles;
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
		configFiles = new HashMap<String, Path>();
		PluginContext cntxt = pluginManager.getPluginContext(this);
		configFiles.put(SCHEMATRON_RULEPATH, cntxt.getRootPath().resolve(SCHEMATRON_RULEPATH));
		configFiles.put(PRE_PROCESSOR_PATH, cntxt.getRootPath().resolve(PRE_PROCESSOR_PATH));
		configFiles.put(SCHEMATRON_SAXON_SKELETON_PATH, cntxt.getRootPath().resolve(SCHEMATRON_SAXON_SKELETON_PATH));
		configFiles.put(SVRL_HTML_XSLT_PATH, cntxt.getRootPath().resolve(SVRL_HTML_XSLT_PATH));
		configFiles.put(CSS_PATH, cntxt.getRootPath().resolve(CSS_PATH));
		configFiles.put(SCHEMATRON_FUNCTIONPATH, cntxt.getRootPath().resolve(SCHEMATRON_FUNCTIONPATH));
		
		checkerSettings = new COBieSchematronCheckerSettings(configFiles.get(SCHEMATRON_RULEPATH), 
				configFiles.get(PRE_PROCESSOR_PATH), configFiles
				.get(SVRL_HTML_XSLT_PATH), COBieQCValidationPhase.Construction);
		initialized = true;
	}


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
		return COBieSerializerPluginInfo.REPORT_QC_CONSTRUCTION;
	}

}
