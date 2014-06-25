package org.erdc.cobie.plugins.serializers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Workbook;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.serializers.Serializer;
import org.erdc.cobie.plugins.utils.PluginRuntimeFileHelper;
import org.erdc.cobie.serializers.COBieTemplateSerializer;
import org.erdc.cobie.shared.mapping.COBieLiteTemplateMapper;
import org.erdc.cobie.shared.utils.POIUtils;

public abstract class COBieTemplateSerializerPlugin extends AbstractCOBieSerializerPlugin
{
	private boolean isInitialized = false;
	protected File templateFile = null;
	private static final String CONFIGURATION_FILE_ERROR = "Could not find configuration files";
	
	@Override
	public Serializer createSerializer(PluginConfiguration plugin)
	{
		COBieLiteTemplateMapper mapper;
		COBieTemplateSerializer serializer = null;
		try
		{
			mapper = getMapper(getTemplateWorkbook());
			serializer = new COBieTemplateSerializer(mapper);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return serializer;
	}

	@Override
	public boolean needsGeometry()
	{
		return false;
	}

	@Override
	public boolean isInitialized()
	{
		return isInitialized;
	}

	public COBieTemplateSerializerPlugin()
	{
		super();
	}

	@Override
	public void init(PluginManager pluginManager) throws PluginException
	{
		isInitialized = true;
		initializeTemplateFile(pluginManager);
	}

	public void initializeTemplateFile(PluginManager pluginManager) throws PluginException
	{
		try
		{
			HashMap<String, File> configFiles;
			configFiles = PluginRuntimeFileHelper.prepareSerializerConfigFiles(
				pluginManager, getCOBieSerializerInfo().getPluginName(), this, getConfigFilePaths());
			templateFile = configFiles.get(getTemplateFilePath());
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
			throw new PluginException(CONFIGURATION_FILE_ERROR);
		}
	}
	
	private ArrayList<String> getConfigFilePaths()
	{
		ArrayList<String> configFilePaths = new ArrayList<String>();
		configFilePaths.add(getTemplateFilePath());
		return configFilePaths;
	}
	
	public abstract String getTemplateFilePath();
	
	private Workbook getTemplateWorkbook()
	{
		return POIUtils.getWorkbook(templateFile);
	}
	public abstract COBieLiteTemplateMapper getMapper(Workbook workbook) throws FileNotFoundException, IOException;

	protected File getTemplateFile()
	{
		return templateFile;
	}
}
