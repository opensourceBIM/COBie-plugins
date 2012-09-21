package org.bimserver.cobie.plugins;
import org.bimserver.plugins.ObjectIDMException;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.SerializerPlugin;

public class COBieLiteSerializerPlugin implements SerializerPlugin{
	private boolean initialized = false;
	//private File configurationFile;
	
	@Override
	public String getDescription() {
		return "XML based on a schema derived from the COBie spreadsheet columns.";
	}
	
	@Override
	public String getVersion() {
		return "1.0";
	}

	@Override
	public void init(PluginManager pluginManager) throws PluginException {
		pluginManager.requireSchemaDefinition();
		try
		{
			pluginManager.requireObjectIDM();
		}
		catch (ObjectIDMException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	configurationFile = ConfigUtil.prepareConfigFile(pluginManager, "COBieLiteSerializer", this);
		initialized = true;	
	}
	
	@Override
	public EmfSerializer createSerializer() {
		return new COBieLiteSerializer();
	}
	
	@Override
	public String getDefaultSerializerName() {
		//return "COBIE";
		return "COBieLite(xml)";
	}

	///////////////////////////////
	///need to fix these content and extension functions.
	///had to use html to get it to work
	@Override
	public String getDefaultContentType() {
		//return "appliction/COBIE";
		return "application/XML";
	}

	@Override
	public String getDefaultExtension() {
		//return "xml";//Change this to proper extension
		return "xml";
	}
 /////////////////////////////////////////////////
	@Override
	public boolean isInitialized() {
		return initialized;
	}
}