package org.bimserver.cobie.plugin.deserializers;

import org.bimserver.cobie.shared.deserialization.COBieDeserializerPluginName;
import org.bimserver.cobie.shared.deserialization.COBieTabDeserializer;
import org.bimserver.models.store.ObjectDefinition;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.Deserializer;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.schema.SchemaException;

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
		return new COBieTabDeserializer();
	}

	@Override
	public String getDefaultName()
	{
		return COBieDeserializerPluginName.COBie_TAB.toString();
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
