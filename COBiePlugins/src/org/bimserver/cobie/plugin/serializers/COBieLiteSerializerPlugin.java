package org.bimserver.cobie.plugin.serializers;

import org.bimserver.cobie.shared.serialization.COBieLiteSerializer;
import org.bimserver.cobie.shared.serialization.COBieSerializerPluginInfo;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.serializers.Serializer;

public class COBieLiteSerializerPlugin extends AbstractCOBieSerializerPlugin
{

	protected static final String VERSION = "1.1";
	protected static final boolean NEEDS_GEOMETRY = false;

	@Override
	public Serializer createSerializer(PluginConfiguration plugin)
	{
		return new COBieLiteSerializer(getTransformSettings());
	}


	@Override
	public boolean needsGeometry()
	{
		return NEEDS_GEOMETRY;
	}

	@Override
	protected COBieSerializerPluginInfo getCOBieSerializerInfo()
	{
		return COBieSerializerPluginInfo.COBIE_LITE;
	}

	@Override
	protected void onInit(PluginManager pluginManager) throws Exception 
	{
		// NOTHING TO DO
		
	}
}
