package org.erdc.cobie.plugins.serializers;

import org.bimserver.models.store.ObjectDefinition;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.serializers.Serializer;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.erdc.cobie.shared.enums.COBieSerializerPluginName;

public class COBieLiteSerializerPlugin implements SerializerPlugin
{
	protected static final String DESCRIPTION = "COBie Lite XML Release Candidate 4";
	protected static final String VERSION = "1.0";
	protected static final boolean NEEDS_GEOMETRY = false;
	protected static final String EXTENSION = "xml";
	protected static final String CONTENT_TYPE = "text/xml";
	private boolean isInitialized;
	@Override
	public void init(PluginManager pluginManager) throws PluginException
	{
		isInitialized = false;
		isInitialized = true;		
	}

	@Override
	public String getDescription()
	{
		return DESCRIPTION;
	}

	@Override
	public String getDefaultName()
	{
		return COBieSerializerPluginName.COBIE_LITE.toString();
	}

	@Override
	public String getVersion()
	{
		return VERSION;
	}

	@Override
	public ObjectDefinition getSettingsDefinition()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isInitialized()
	{
		return isInitialized;
	}

	@Override
	public Serializer createSerializer()
	{
		return new COBieLiteSerializer();
	}

	@Override
	public boolean needsGeometry()
	{
		return NEEDS_GEOMETRY;
	}

	@Override
	public String getDefaultExtension()
	{
		return EXTENSION;
	}

	@Override
	public String getDefaultContentType()
	{
		return CONTENT_TYPE;
	}

}
