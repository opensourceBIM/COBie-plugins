package org.erdc.cobie.plugins.serializers;

import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.serializers.Serializer;
import org.erdc.cobie.serializers.COBieLiteSerializer;
import org.erdc.cobie.shared.enums.COBieSerializerPluginInfo;

public class COBieLiteSerializerPlugin extends AbstractCOBieSerializerPlugin
{
	protected static final String DESCRIPTION = COBieSerializerPluginInfo.COBIE_LITE
			.getDescription();
	protected static final String VERSION = "1.1";
	protected static final boolean NEEDS_GEOMETRY = false;
	protected static final String EXTENSION = COBieSerializerPluginInfo.COBIE_LITE
			.getFileExtension();
	protected static final String CONTENT_TYPE = "text/xml";
	private boolean isInitialized;



	@Override
	public Serializer createSerializer(PluginConfiguration plugin)
	{
		return new COBieLiteSerializer();
	}

	@Override
	public String getDefaultContentType()
	{
		return CONTENT_TYPE;
	}

	@Override
	public String getDefaultExtension()
	{
		return EXTENSION;
	}

	@Override
	public String getDefaultName()
	{
		return COBieSerializerPluginInfo.COBIE_LITE.toString();
	}

	@Override
	public String getDescription()
	{
		return DESCRIPTION;
	}

	@Override
	public void init(PluginManager pluginManager) throws PluginException
	{
		isInitialized = true;
	}

	@Override
	public boolean isInitialized()
	{
		return isInitialized;
	}

	@Override
	public boolean needsGeometry()
	{
		return NEEDS_GEOMETRY;
	}

}
