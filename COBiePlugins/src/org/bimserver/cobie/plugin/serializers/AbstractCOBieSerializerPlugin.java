package org.bimserver.cobie.plugin.serializers;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.bimserver.cobie.shared.serialization.COBieSerializerPluginInfo;
import org.bimserver.cobie.shared.utility.PluginRuntimeFileHelper;
import org.bimserver.cobie.shared.utility.PluginRuntimeFileHelper.Persistence;
import org.bimserver.emf.Schema;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.serializers.AbstractSerializerPlugin;
import org.bimserver.plugins.serializers.Serializer;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.prairiesky.transform.cobieifc.settings.ObjectFactory;
import com.prairiesky.transform.cobieifc.settings.SettingsType;

public abstract class AbstractCOBieSerializerPlugin extends
		AbstractSerializerPlugin
{
	private SettingsType transformSettings;
	private boolean initialized;
	public AbstractCOBieSerializerPlugin()
	{
		super();
	}

	public final Serializer createSerializer()
	{
		return createSerializer(null);
	
	}
	
	@Override
	public String getVersion()
	{
		return "1.0";
	}
	
	@Override
	public final String getDefaultExtension()
	{
		return getCOBieSerializerInfo().getFileExtension();
	}

	@Override
	public final String getDescription()
	{
		return getCOBieSerializerInfo().getDescription();
	}

	@Override
	public final String getDefaultName()
	{
		return getCOBieSerializerInfo().getPluginName();
	}
	
	protected abstract void onInit(PluginManager pluginManager) throws Exception;

	@Override
	public void init(PluginManager pluginManager) throws PluginException
	{
		try
		{
			initializeSettings(pluginManager);
			onInit(pluginManager);
		}
		catch(Exception e)
		{
			throw new PluginException(e);
		}
		initialized = true;
	}
	
	
	@Override
	public boolean isInitialized()
	{
		return initialized;
	}

	private void initializeSettings(PluginManager pluginManager) throws JAXBException, ParserConfigurationException, SAXException, IOException 
	{
		File settingsFile =
		PluginRuntimeFileHelper.prepareSerializerResource(pluginManager, StringTable.SETTINGS_DIRNAME.toString(),
				this, SerializerResource.LOCAL_IFC_COBIE_TRANSFORM_CONFIG.toString(),Persistence.PERMANENT);
		JAXBContext context =
				JAXBContext.newInstance(ObjectFactory.class);
		Unmarshaller unmarsheller =
				context.createUnmarshaller();
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(settingsFile);
		setTransformSettings(unmarsheller.unmarshal(doc, SettingsType.class).getValue());
		
	}

	@Override
	public final String getDefaultContentType()
	{
		return getCOBieSerializerInfo().getContentType();
	}

	protected abstract COBieSerializerPluginInfo getCOBieSerializerInfo();
	
	@Override
	public final Set<Schema> getSupportedSchemas() 
	{
		return Schema.IFC2X3TC1.toSet();
	}

	public SettingsType getTransformSettings() {
		return transformSettings;
	}

	public void setTransformSettings(SettingsType transformSettings) {
		this.transformSettings = transformSettings;
	}
}