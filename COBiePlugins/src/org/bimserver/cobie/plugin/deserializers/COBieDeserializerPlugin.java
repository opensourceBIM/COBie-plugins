package org.bimserver.cobie.plugin.deserializers;

/******************************************************************************
 * 
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Set;

import org.bimserver.cobie.shared.deserialization.COBieDeserializer;
import org.bimserver.cobie.shared.deserialization.COBieDeserializerPluginName;
import org.bimserver.cobie.shared.utility.PluginRuntimeFileHelper;
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
	protected File configurationFile;

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
		try
		{
			configurationFile = PluginRuntimeFileHelper
					.prepareSerializerConfigFile(pluginManager,
							"COBieDeserializer", this, localConfigFilePath);
			setPackageMetadata(pluginManager.getMetaDataManager().getPackageMetaData(Schema.IFC2X3TC1.name().toLowerCase()));
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
			throw new PluginException("Could not find configuration files");
		}
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