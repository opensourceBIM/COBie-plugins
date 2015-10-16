package org.bimserver.cobie.plugin.deserializers;

import java.nio.file.Path;
import java.util.Set;

import org.bimserver.cobie.shared.deserialization.COBieDeserializer;
import org.bimserver.cobie.shared.deserialization.COBieDeserializerPluginName;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.emf.Schema;
import org.bimserver.models.store.ObjectDefinition;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.Deserializer;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.schema.SchemaException;

public class COBieDeserializerPlugin implements DeserializerPlugin
{
	private static String localConfigFilePath = "lib/COBieExcelTemplate.xml";
	private boolean initialized = false;
	private PackageMetaData packageMetadata;
	protected Path configurationFile;

	@Override
	public boolean canHandleExtension(String extension)
	{
		return extension.equalsIgnoreCase("xml") || 
				extension.equalsIgnoreCase("xlsx");
	}

	@Override
	public Deserializer createDeserializer(
			PluginConfiguration pluginConfiguration)
	{
		return new COBieDeserializer(configurationFile, getPackageMetadata());
	}

	@Override
	public String getDefaultName()
	{
		return COBieDeserializerPluginName.COBIE_SPREADHSEET.toString();
	}

	@Override
	public String getDescription()
	{
		return "Deserializes COBie spreadsheetML into the model server.";
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
		setPackageMetadata(pluginManager.getMetaDataManager().getPackageMetaData(Schema.IFC2X3TC1.name().toLowerCase()));
		initialized = true;
	}

	@Override
	public boolean isInitialized()
	{
		return initialized;
	}

	@Override
	public final Set<Schema> getSupportedSchemas() 
	{
		return Schema.IFC2X3TC1.toSet();
	}

	public PackageMetaData getPackageMetadata() {
		return packageMetadata;
	}

	public void setPackageMetadata(PackageMetaData packageMetadata) {
		this.packageMetadata = packageMetadata;
	}
}