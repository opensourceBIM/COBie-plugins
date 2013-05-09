package org.erdc.cobie.plugins.serializers;
import org.bimserver.models.store.ObjectDefinition;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.objectidms.ObjectIDMException;
import org.bimserver.plugins.serializers.AbstractSerializerPlugin;
import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.Serializer;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.erdc.cobie.shared.enums.COBieSerializerPluginInfo;

public class COBieSheetXMLDataSerializerPlugin extends AbstractSerializerPlugin{
	private boolean initialized = false;
	//private File configurationFile;
	
	@Override
	public String getDescription() {
		return COBieSerializerPluginInfo.SHEET_XMLDATA.getDescription();
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
		initialized = true;	
	}
	
	public EmfSerializer createSerializer() {
		return (EmfSerializer) this.createSerializer(null);
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
		return COBieSerializerPluginInfo.SHEET_XMLDATA.getFileExtension();
	}
 /////////////////////////////////////////////////
	@Override
	public boolean isInitialized() {
		return initialized;
	}

@Override
public String getDefaultName()
{
	return COBieSerializerPluginInfo.SHEET_XMLDATA.toString();
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
	return true;
}

@Override
public Serializer createSerializer(PluginConfiguration plugin)
{
	return new COBieSheetXMLDataSerializer();
}
}