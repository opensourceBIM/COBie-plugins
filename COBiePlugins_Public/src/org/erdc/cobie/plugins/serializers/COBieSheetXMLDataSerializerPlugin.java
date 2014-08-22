package org.erdc.cobie.plugins.serializers;

import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.objectidms.ObjectIDMException;
import org.bimserver.plugins.serializers.Serializer;
import org.erdc.cobie.shared.bimserver.cobietab.serialization.COBieSerializerPluginInfo;
import org.erdc.cobie.shared.bimserver.cobietab.serialization.COBieTabXMLSerializer;

public class COBieSheetXMLDataSerializerPlugin extends
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
		return COBieSerializerPluginInfo.SHEET_XMLDATA;
	}
}