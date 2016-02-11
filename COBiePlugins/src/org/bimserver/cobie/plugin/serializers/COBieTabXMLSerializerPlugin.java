package org.bimserver.cobie.plugin.serializers;

import org.bimserver.cobie.shared.serialization.COBieSerializerPluginInfo;
import org.bimserver.cobie.shared.serialization.COBieTabXMLSerializer;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.objectidms.ObjectIDMException;
import org.bimserver.plugins.serializers.Serializer;

public class COBieTabXMLSerializerPlugin extends
		AbstractCOBieSerializerPlugin
{
	private boolean initialized = false;


	@Override
	public Serializer createSerializer(PluginConfiguration plugin)
	{
		return new COBieTabXMLSerializer();
	}

	@Override
	public void init(PluginManager pluginManager) throws PluginException
	{
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

	// ///////////////////////////////////////////////
	@Override
	public boolean isInitialized()
	{
		return initialized;
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
}