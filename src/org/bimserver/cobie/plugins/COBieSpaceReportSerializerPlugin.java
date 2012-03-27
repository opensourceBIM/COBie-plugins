package org.bimserver.cobie.plugins;

import java.io.File;

import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.SerializerPlugin;

public class COBieSpaceReportSerializerPlugin implements SerializerPlugin{
	private boolean initialized = false;
	//private File configurationFile;
	@Override
	public String getDescription() {
		return "Produces an html report of the space decomposition of the building.";
	}
	
	@Override
	public String getVersion() {
		return "1.0";
	}

	@Override
	public void init(PluginManager pluginManager) throws PluginException {
		pluginManager.requireSchemaDefinition();
		initialized = true;
	}
	
	@Override
	public EmfSerializer createSerializer() {
		return new COBieSpaceReportSerializer();
	}
	
	@Override
	public String getDefaultSerializerName() {
		//return "COBIE";
		return "COBieSpaceReport(html)";
	}

	///////////////////////////////
	///need to fix these content and extension functions.
	///had to use html to get it to work
	@Override
	public String getDefaultContentType() {
		//return "appliction/COBIE";
		return "application/html";
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
