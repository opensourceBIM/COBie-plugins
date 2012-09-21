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
import org.bimserver.shared.cobie.COBieSharedUtilities;

public class COBieCheckDesignSerializerPlugin implements SerializerPlugin
{
	public static final String DEFAULT_SERIALIZER_NAME = COBieSharedUtilities.COBIE_COMPLIANCE_DESIGN_SERIALIZER_DEFAULT_NAME;
	private boolean initialized = false;
	private static final String SCHEMATRON_RULEPATH =
	"lib/COBieRulesDesign.sch";
	private static final String PRE_PROCESSOR_PATH =
	"lib/iso_svrl_for_xslt2.xsl";
	private static final String SVRL_XSD_PATH =
	"lib/SVRL.xsd";
	private static final String SVRL_HTML_XSLT_PATH =
	"lib/SVRL_HTML(Design).xslt";
	private static final String CSS_PATH=
	"lib/SpaceReport.css";
	private static final String SCHEMATRON_SAXON_SKELETON_PATH="lib/iso_schematron_skeleton_for_saxon.xsl";
	private ArrayList<String> configFilePaths;
	private HashMap<String,File> configFiles;
		@Override
		public String getDescription() {
			return "Produces a report of compliance to a COBie ruleset for the Design phase.";
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
			configFilePaths.add(SCHEMATRON_RULEPATH);
			configFilePaths.add(PRE_PROCESSOR_PATH);
			configFilePaths.add(SCHEMATRON_SAXON_SKELETON_PATH);
			configFilePaths.add(SVRL_HTML_XSLT_PATH);
			configFilePaths.add(SVRL_XSD_PATH);
			configFilePaths.add(this.CSS_PATH);
			pluginManager.requireSchemaDefinition();
			this.configFiles = ConfigUtil.prepareSerializerConfigFiles(pluginManager, getDefaultSerializerName(), this, configFilePaths);
			initialized = true;
		}

		public Set<Class<? extends Plugin>> getRequiredPlugins() {
			Set<Class<? extends Plugin>> set = new HashSet<Class<? extends Plugin>>();
			set.add(SchemaPlugin.class);
			return set;
		}

		@Override
		public EmfSerializer createSerializer() {
			return new org.bimserver.cobie.plugins.COBieCheckSerializer
					(this.configFiles.get(SCHEMATRON_RULEPATH).getAbsolutePath(),
							this.configFiles.get(PRE_PROCESSOR_PATH).getAbsolutePath(),
							this.configFiles.get(SVRL_XSD_PATH).getAbsolutePath(),
							this.configFiles.get(SVRL_HTML_XSLT_PATH).getAbsolutePath(),
							this.configFiles.get(CSS_PATH).getAbsolutePath()
							);
		}
		
		@Override
		public String getDefaultSerializerName() {
			return DEFAULT_SERIALIZER_NAME;
		}


		@Override
		public String getDefaultContentType() {
			return "appliction/html";
		}

		@Override
		public String getDefaultExtension() {
			return "html";
		}
	 /////////////////////////////////////////////////
		@Override
		public boolean isInitialized() {
			return initialized;
		}
}
