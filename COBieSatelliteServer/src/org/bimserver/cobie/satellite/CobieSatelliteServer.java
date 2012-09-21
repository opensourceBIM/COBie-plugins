package org.bimserver.cobie.satellite;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.bimserver.client.BimServerClient;
import org.bimserver.client.ConnectionException;
import org.bimserver.client.factories.AuthenticationInfo;
import org.bimserver.client.factories.UsernamePasswordAuthenticationInfo;
import org.bimserver.cobie.cobieserializersettings.COBieExportOptionsDocument;
import org.bimserver.cobie.plugins.COBieCheckSerializer;
import org.bimserver.cobie.plugins.COBieCheckSerializerPlugin;
import org.bimserver.cobie.plugins.COBieIDM;
import org.bimserver.cobie.plugins.COBieIDMPlugin;
import org.bimserver.cobie.plugins.COBieLiteSerializer;
import org.bimserver.cobie.plugins.COBieLiteSerializerPlugin;
import org.bimserver.plugins.Plugin;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.ifcengine.IfcEnginePlugin;
import org.bimserver.plugins.objectidms.ObjectIDM;
import org.bimserver.plugins.objectidms.ObjectIDMPlugin;
import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.bimserver.cobie.satellite.activities.Activity;
import org.bimserver.ifc.step.deserializer.IfcStepDeserializer;
import org.bimserver.ifc.step.deserializer.IfcStepDeserializerPlugin;
import org.bimserver.shared.NotificationInterface;
import org.bimserver.shared.cobie.COBieSharedUtilities.COBIE_FILE_TYPE;
import org.bimserver.shared.cobie.COBieUtility;
import org.bimserver.shared.cobie.generated.merge.COBieMergeIDMDocument;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

import com.google.common.collect.BiMap;

public class CobieSatelliteServer {
	private static final String COBIE_LITE_SERIALIZER_DEFAULT_NAME = "COBieLite(xml)";
	private static final String TMPDIRECTORY_COBIESERIALIZER = "/COBieSerializer/";
	private static final String COBIE_EXPORT_SETTINGS_FILENAME = "COBieExportSettings.xml";
	private static final String IFC_STEP_DESERIALIZER_NAME = "IfcStepDeserializer";
	private static final String COBIE_PLUGINS_PATH = "../COBiePlugins";
	private static final String IFC_PLUGINS_PATH = "../IfcPlugins";
	private static final String BUILDING_SMART_PLUGIN_PATH = "../buildingSMARTLibrary";
	private static final String PLUGINS_DIRECTORY_NAME = "plugins";
	private static final String TEMP_DIRECTORY_NAME = "tmp";
	private File cobieExportOptionsFile;
	private PluginManager pluginManager;
	private BimServerClient bimServerClient;
	private BimServerClient bimServerWorkerClient;
	private BimServerClient bimServerGuiClient;
	private IfcStepDeserializer ifcStepDeserializer;
	private ObjectIDMPlugin selectedIDMPlugin;
	private ObjectIDM objectIDM;
	private ControlTextItem selectedControlTextItem;
	private Map<ControlTextItem,ObjectIDMPlugin> controlTextItemToIDMPlugin;
	private void setIfcStepDeserializer(IfcStepDeserializer ifcStepDeserializer)
	{
		this.ifcStepDeserializer = ifcStepDeserializer;
	}

	private COBieLiteSerializer cobieLiteSerializer;
	private final Set<Activity> activities = new HashSet<Activity>();
	private HashMap<ControlTextItem,COBieMergeIDMDocument> mergeRules;
	public CobieSatelliteServer() 
	{
		initializePluginManager();
		try 
		{
			loadPluginsFromEclipseProjects();
		} catch (PluginException e) 
		{
			e.printStackTrace();
		}
		try
		{
			loadJarPlugins();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		try
		{
			initializeAllPlugins();
			setIfcStepDeserializer(createIfcStepDeserializer());
			setCobieLiteSerializer(createCobieLiteSerializer());
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		try
		{
			initializeBiMServerClients();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		
		try
		{
			initializeControlTextItemToActiveIDMPlugins();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		try
		{
			setIDMToCOBieIDM();
		}
		catch(Exception ex)
		{
			
		}
		setCobieExportOptionsFile(new File(this.TEMP_DIRECTORY_NAME+TMPDIRECTORY_COBIESERIALIZER+COBIE_EXPORT_SETTINGS_FILENAME));
	}

	
	public Map<ControlTextItem, ObjectIDMPlugin> getControlTextItemToIDMPlugin()
	{
		return controlTextItemToIDMPlugin;
	}


	private void initializeControlTextItemToActiveIDMPlugins()
	{
		controlTextItemToIDMPlugin = new HashMap<ControlTextItem,ObjectIDMPlugin>();
		for(ObjectIDMPlugin idmPlugin:pluginManager.getAllObjectIDMPlugins(true))
			controlTextItemToIDMPlugin.put(controlTextItemFromObjectIDMPlugin(idmPlugin), idmPlugin);
	}

	public PluginManager getPluginManager()
	{
		return pluginManager;
	}
	private void initializePluginManager()
	{
		System.setProperty("org.apache.cxf.Logger", "org.apache.cxf.common.logging.Log4jLogger");
		System.out.println(System.getProperty("java.class.path"));
		pluginManager = new PluginManager(new File(TEMP_DIRECTORY_NAME), System.getProperty("java.class.path"));
		//pluginManager = new PluginManager(new File(TEMP_DIRECTORY_NAME),null);
		System.out.println(new File(TEMP_DIRECTORY_NAME).getAbsolutePath());
		System.out.println(new File(PLUGINS_DIRECTORY_NAME).getAbsolutePath());
	}

	private void loadJarPlugins()
	{
		try 
		{
			pluginManager.loadAllPluginsFromDirectoryOfJars(new File(PLUGINS_DIRECTORY_NAME));
		} catch (PluginException e) 
		{
			e.printStackTrace();
		}
	}

	private void initializeBiMServerClients()
	{
		bimServerClient = new BimServerClient(pluginManager);
		bimServerWorkerClient = new BimServerClient(pluginManager);
		bimServerGuiClient = new BimServerClient(pluginManager);
	}

	private void loadPluginsFromEclipseProjects() throws PluginException
	{
		pluginManager.loadPluginsFromEclipseProject(new File(BUILDING_SMART_PLUGIN_PATH));
		pluginManager.loadPluginsFromEclipseProject(new File(IFC_PLUGINS_PATH));
		pluginManager.loadPluginsFromEclipseProject(new File(COBIE_PLUGINS_PATH));
	}
	
	private void initializeAllPlugins()
	{
		for(Plugin plugin:pluginManager.getAllPlugins(true))
		{
			String pluginDescription = plugin.getDescription()+" "+plugin.getClass().getSimpleName();
			if(!plugin.isInitialized())
			{
				try
				{
					
					System.out.println("Attempting to initialize plugin:  "+pluginDescription);
					plugin.init(pluginManager);
					System.out.println("Plugin initialized:  " + pluginDescription);
				}
				catch(Exception ex)
				{
					String serializerName = "";
					if(plugin instanceof SerializerPlugin)
					{
						serializerName = ((SerializerPlugin)plugin).getDefaultSerializerName();
						System.out.println("Error loading plugin:  "+serializerName);
						ex.printStackTrace();
					}
					else if (plugin instanceof DeserializerPlugin)
					{
						serializerName = ((DeserializerPlugin)plugin).getDefaultDeserializerName();
						System.out.println("Error loading plugin:  "+serializerName);
						ex.printStackTrace();
					}
					else if (plugin instanceof IfcEnginePlugin)
					{
						serializerName = ((IfcEnginePlugin)plugin).getDefaultIfcEngineName();
						System.out.println("Error loading plugin:  "+serializerName);
						ex.printStackTrace();
					}
					else if (plugin instanceof ObjectIDMPlugin)
					{
						serializerName = ((ObjectIDMPlugin)plugin).getDefaultObjectIDMName();
						System.out.println("Error loading plugin:  "+serializerName);
						ex.printStackTrace();
					}
					if(serializerName.length()>0)
						pluginManager.disablePlugin(serializerName);
				}
			}
			else
				System.out.println("Plugin already loaded: "+pluginDescription);
		}
	}


	public void connect(CobieSatelliteServerSettings settings, NotificationInterface... notificationInterfaces) throws ConnectionException {

		AuthenticationInfo authenticationInfo = new UsernamePasswordAuthenticationInfo(settings.getUsername(), settings.getPassword());
		initializeBimServerClient(bimServerClient,settings, authenticationInfo);
		initializeBimServerClient(bimServerWorkerClient,settings,authenticationInfo);
		initializeBimServerClient(bimServerGuiClient,settings,authenticationInfo);
		for (NotificationInterface notificationInterface : notificationInterfaces) {
			bimServerClient.registerNotificationListener(notificationInterface);
		}
	}

	public static void initializeBimServerClient(BimServerClient bimServerClient,
			CobieSatelliteServerSettings settings,
			AuthenticationInfo authenticationInfo) throws ConnectionException
	{
		bimServerClient.setAuthentication(authenticationInfo);
		bimServerClient.connectProtocolBuffers(settings.getAddress(), settings.getPort());
	}


	public BimServerClient getBimServerClient() {
		return bimServerClient;
	}

	public void disconnect(NotificationInterface... notificationInterfaces) 
	{

		bimServerClient.disconnect();
		bimServerGuiClient.disconnect();
		bimServerWorkerClient.disconnect();
	}
	
	public COBieCheckSerializer getCOBieCheckSerializer() throws PluginException
	{
		COBieCheckSerializer checkSerializer = null;
		
		for(SerializerPlugin serializerPlugin:pluginManager.getAllSerializerPlugins(true))
		{
			if(serializerPlugin.getDefaultSerializerName().equals(COBIE_FILE_TYPE.COBieCompliance.name()))
			{
				COBieCheckSerializerPlugin checkSerializerPlugin =
						(COBieCheckSerializerPlugin) serializerPlugin;
				if(!checkSerializerPlugin.isInitialized())
					checkSerializerPlugin.init(pluginManager);
				EmfSerializer serializer = checkSerializerPlugin.createSerializer();
				if (serializer instanceof COBieCheckSerializer)
					checkSerializer = (COBieCheckSerializer) checkSerializer;
			}
		}
		return checkSerializer;
	}
	
	public IfcStepDeserializer getIfcStepDeserializer() throws PluginException
	{
		ifcStepDeserializer.init(pluginManager.requireSchemaDefinition());
		return ifcStepDeserializer;
	}
	
	private IfcStepDeserializer createIfcStepDeserializer() throws PluginException
	{
		IfcStepDeserializer stepDeserializer = null;
		for(DeserializerPlugin deserializerPlugin:pluginManager.getAllDeserializerPlugins(true))
		{
			if(deserializerPlugin.getDefaultDeserializerName().
					equals(IFC_STEP_DESERIALIZER_NAME))
			{
				IfcStepDeserializerPlugin stepDeserializerPlugin =
						(IfcStepDeserializerPlugin)deserializerPlugin;
				if(!stepDeserializerPlugin.isInitialized())
					stepDeserializerPlugin.init(pluginManager);
				stepDeserializer =(IfcStepDeserializer) stepDeserializerPlugin.createDeserializer();	
			}
		}
		return stepDeserializer;
	}
	
	private COBieLiteSerializer createCobieLiteSerializer() throws PluginException
	{
		COBieLiteSerializer cobieLiteSerializer = null;
		for(SerializerPlugin serializerPlugin:pluginManager.getAllSerializerPlugins(true))
		{
			if(serializerPlugin.getDefaultSerializerName().
					equals(COBIE_LITE_SERIALIZER_DEFAULT_NAME))
			{
				COBieLiteSerializerPlugin cobieLiteSerializerPlugin =
						(COBieLiteSerializerPlugin)serializerPlugin;
				if(!serializerPlugin.isInitialized())
					serializerPlugin.init(pluginManager);
				cobieLiteSerializer = (COBieLiteSerializer)
						cobieLiteSerializerPlugin.createSerializer();
				
			}
		}
		return cobieLiteSerializer;
	}

	public void registerActivity(Activity activity) {
		activities.add(activity);
		activity.activate(this);
	}
	public Set<Activity> getActivities() {
		return activities;
	}

	public BimServerClient getBimServerWorkerClient()
	{
		return bimServerWorkerClient;
	}

	public BimServerClient getBimServerGuiClient()
	{
		return bimServerGuiClient;
	}
	
	public boolean allServicesConnected() throws ServerException, UserException
	{
		boolean connected = false;
		try
		{
			connected = (bimServerClient.getServiceInterface().isLoggedIn() && bimServerWorkerClient.getServiceInterface().isLoggedIn() &&
					bimServerGuiClient.getServiceInterface().isLoggedIn());
		}
		catch(Exception ex)
		{
			
		}
		return connected;
	}

	public HashMap<ControlTextItem, COBieMergeIDMDocument> getMergeRules()
	{
		return mergeRules;
	}

	private void setMergeRules(HashMap<ControlTextItem, COBieMergeIDMDocument> mergeRules)
	{
		this.mergeRules = mergeRules;
	}
	
	public void loadMergeRules(File mergeRuleDirectory)
	{
		mergeRules = new HashMap<ControlTextItem,COBieMergeIDMDocument>();
		if(mergeRuleDirectory.exists() && mergeRuleDirectory.isDirectory())
		{
			for(File dirChild:mergeRuleDirectory.listFiles())
			{
				if(dirChild.exists() && dirChild.isDirectory())
					loadMergeRules(dirChild);
				else if (dirChild.exists() && dirChild.isFile())
				{
					try
					{
						addMergeRuleDocument(dirChild);
					}
					catch (XmlException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					catch (IOException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	private void addMergeRuleDocument(File mergeRuleFile) throws XmlException, IOException
	{
		XmlOptions xmlOptions =
				new XmlOptions();
		xmlOptions.setLoadLineNumbers(XmlOptions.LOAD_LINE_NUMBERS_END_ELEMENT);
		COBieMergeIDMDocument ruleDocument =
				COBieMergeIDMDocument.Factory.parse(mergeRuleFile, xmlOptions);
		ControlTextItem controlTextItem =
				controlTextItemFromCOBieMergeIDMDocument(ruleDocument);
		mergeRules.put(controlTextItem, ruleDocument);
	}
	
	private ControlTextItem controlTextItemFromCOBieMergeIDMDocument(COBieMergeIDMDocument mergeRulesDocument)
	{
		String key = mergeRulesDocument.getCOBieMergeIDM().getIDMRulesetName();
		String display = mergeRulesDocument.getCOBieMergeIDM().getIDMRulesetDisplayName();
		String toolTip = mergeRulesDocument.getCOBieMergeIDM().getLifeCycleMetadata().getDescription();
		return new ControlTextItem(key, display, toolTip,toolTip);
	}
	
	private ControlTextItem controlTextItemFromObjectIDMPlugin(ObjectIDMPlugin idmPlugin)
	{
		String key = idmPlugin.getDefaultObjectIDMName();
		String display = idmPlugin.getDefaultObjectIDMName();
		String toolTip = idmPlugin.getDescription();
		String longDescription = getLongDescriptionFromIdmPlugin(idmPlugin);
		return new ControlTextItem(key,display,toolTip,longDescription);
	}
	
	

	private String getLongDescriptionFromIdmPlugin(ObjectIDMPlugin idmPlugin)
	{
		String longDescription = idmPlugin.getDescription();
		if(idmPlugin.getObjectIDM() instanceof COBieIDM)
		{
			
			List<String> ignoredClassNames = 
					((COBieIDM)idmPlugin.getObjectIDM()).getIgnoreClassNames();
			if(ignoredClassNames.size()>0)
			{
				longDescription = COBieUtility.delimittedStringSpacedFromArrayList(ignoredClassNames);
			}
		}
		return COBieUtility.getCOBieString(longDescription);
	}


	public COBieLiteSerializer getCobieLiteSerializer()
	{
		return cobieLiteSerializer;
	}

	private void setCobieLiteSerializer(COBieLiteSerializer cobieLiteSerializer)
	{
		this.cobieLiteSerializer = cobieLiteSerializer;
	}

	public ObjectIDM getObjectIDM()
	{
		return objectIDM;
	}

	public void setObjectIDM(ObjectIDM objectIDM)
	{
		this.objectIDM = objectIDM;
	}	
	
	private void setIDMToCOBieIDM()
	{
		for(ObjectIDMPlugin idmPlugin:pluginManager.getAllObjectIDMPlugins(true))
			if(idmPlugin instanceof COBieIDMPlugin)
				this.selectIDM(idmPlugin);
	}
	
	public void selectIDM(ObjectIDMPlugin idmPlugin)
	{
		if(idmPlugin!=null)
		{
			setSelectedIDMPlugin(idmPlugin);
			setSelectedControlTextItem(controlTextItemWithKey(idmPlugin.getDefaultObjectIDMName()));
			this.setObjectIDM(idmPlugin.getObjectIDM());
		}
		else
			setNoIDM();
	}
	
	private void setNoIDM()
	{
		setSelectedIDMPlugin(null);
		setSelectedControlTextItem(null);
		setObjectIDM(null);
	}


	public ControlTextItem controlTextItemWithKey(String key)
	{
		ControlTextItem txtItem = null;
		for(ControlTextItem controlTextItem:controlTextItemToIDMPlugin.keySet())
		{
			if(controlTextItem.getKey().equals(key))
				txtItem = controlTextItem;
		}
		return txtItem;
	}
	
	public List<ObjectIDMPlugin> getIDMPlugins()
	{
		ArrayList<ObjectIDMPlugin> idmPlugins = new ArrayList<ObjectIDMPlugin>();
		idmPlugins = new ArrayList<ObjectIDMPlugin>(pluginManager.getAllObjectIDMPlugins(true));
		return idmPlugins;
	}


	public ObjectIDMPlugin getSelectedIDMPlugin()
	{
		return selectedIDMPlugin;
	}


	private void setSelectedIDMPlugin(ObjectIDMPlugin selectedIDMPlugin)
	{
		this.selectedIDMPlugin = selectedIDMPlugin;
	}


	public ControlTextItem getSelectedControlTextItem()
	{
		return selectedControlTextItem;
	}


	public void setSelectedControlTextItem(ControlTextItem selectedControlTextItem)
	{
		this.selectedControlTextItem = selectedControlTextItem;
	}


	public File getCobieExportOptionsFile()
	{
		return cobieExportOptionsFile;
	}


	public void setCobieExportOptionsFile(File cobieExportOptionsFile)
	{
		this.cobieExportOptionsFile = cobieExportOptionsFile;
	}

}