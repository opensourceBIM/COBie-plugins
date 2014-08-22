package org.erdc.cobie.plugins.deserializers;

import org.bimserver.models.store.ObjectDefinition;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.Deserializer;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.schema.SchemaException;
import org.erdc.cobie.shared.bimserver.deserialization.COBieDeserializerPluginName;
import org.erdc.cobie.shared.bimserver.deserialization.COBieSheetXMLDataDeserializer;

public class COBieSheetXMLDataDeserializerPlugin implements DeserializerPlugin
{
	private boolean initialized = false;

	@Override
	public boolean canHandleExtension(String extension)
	{
		return extension.equalsIgnoreCase("xml");
	}

	@Override
	public Deserializer createDeserializer(
			PluginConfiguration pluginConfiguration)
	{
		return new COBieSheetXMLDataDeserializer();
	}

	@Override
	public String getDefaultName()
	{
		return COBieDeserializerPluginName.COBIE_SHEETXMLDATA.toString();
	}

	@Override
	public String getDescription()
	{
		return "Deserializes COBie Sheet XML Data into the model server.";
	}

	@Override
	public ObjectDefinition getSettingsDefinition()
	{
		return null;
	}

	@Override
	public String getVersion()
	{
		return "1.0";
	}

	@Override
	public void init(PluginManager pluginManager) throws SchemaException,
			PluginException
	{
		
		initialized = true;
	}

	@Override
	public boolean isInitialized()
	{
		return initialized;
	}
}
