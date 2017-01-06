package org.bimserver.cobie.plugin.serializers;

import org.bimserver.cobie.shared.serialization.COBieSerializerPluginInfo;
import org.bimserver.cobie.shared.serialization.COBieTabXMLSerializer;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.serializers.Serializer;

public class COBieTabXMLSerializerPlugin extends
		AbstractCOBieSerializerPlugin
{

	@Override
	public Serializer createSerializer(PluginConfiguration plugin)
	{
		return new COBieTabXMLSerializer(getTransformSettings());
	}

	@Override
	public boolean needsGeometry()
	{
		return false;
	}

	@Override
	protected COBieSerializerPluginInfo getCOBieSerializerInfo()
	{
		return COBieSerializerPluginInfo.COBieTabXML;
	}

	@Override
	protected void onInit(PluginManager pluginManager) throws Exception 
	{
		//Nothing to do
		
	}
}