package org.erdc.cobie.plugins.serializers;

import org.bimserver.plugins.serializers.AbstractSerializerPlugin;
import org.bimserver.plugins.serializers.Serializer;

public abstract class AbstractCOBieSerializerPlugin extends
		AbstractSerializerPlugin
{

	public AbstractCOBieSerializerPlugin()
	{
		super();
	}

	public final Serializer createSerializer()
	{
		return createSerializer(null);
	
	}
	
	@Override
	public final String getVersion()
	{
		return "1.0";
	}


}