package org.erdc.cobie.toolkit;

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
import java.util.List;
import java.util.Map;

import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.bimserver.plugins.Plugin;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.Deserializer;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.objectidms.ObjectIDM;
import org.bimserver.plugins.objectidms.ObjectIDMPlugin;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.bimserver.shared.cobie.generated.merge.COBieMergeIDMDocument;
import org.bimserver.shared.interfaces.NotificationInterface;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.shared.enums.COBieIDMPluginName;
import org.erdc.cobie.shared.enums.COBieSerializerPluginInfo;
import org.erdc.cobie.shared.idm.COBieFilterable;
import org.erdc.cobie.utils.serializer.BIMServerCOBieSheetXMLDataSerializer;
import org.erdc.cobie.utils.stringwriters.COBieStringHandler;
import org.erdc.cobie.utils.stringwriters.COBieStringHandlerSettings;
import org.erdc.cobie.utils.stringwriters.COBieStringHandlerSettings.EmptyStringMode;
import org.erdc.cobie.utils.stringwriters.COBieStringHandlerSettings.InvalidDateTimeStringMode;
import org.erdc.cobie.utils.stringwriters.COBieStringHandlerSettings.SpecialCharacterMode;
import org.erdc.cobie.utils.stringwriters.COBieStringHandlerSettings.TrailingDelimiterMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CobieToolkit
{

    // private NotificationsManager notificationsManager;
    // private ServerInfoManager serverInfoManager;
    // private PublicInterfaceFactory serviceFactory;
    private static final String COBIE_XMLDATA_SERIALIZER_NAME = COBieSerializerPluginInfo.SHEET_XMLDATA.toString();;
    private static final String TMPDIRECTORY_COBIESERIALIZER = "/COBieSerializer/";
    private static final String COBIE_EXPORT_SETTINGS_FILENAME = "COBieExportSettings.xml";
    private static final String IFC_STEP_DESERIALIZER_NAME = "IfcStepDeserializer";
    private static final String IFC_XML_DESERIALIZER_NAME = "IfcXmlDeserializer";
    private static final String COBIE_PLUGINS_PATH = "../COBiePlugins_Public";
    private static final String IFC_PLUGINS_PATH = "../IfcPlugins";
    private static final String BUILDING_SMART_PLUGIN_PATH = "../buildingSMARTLibrary";
    private static final String PLUGINS_DIRECTORY_NAME = "plugins";
    private static final String TEMP_DIRECTORY_NAME = "tmp";
    private COBieStringHandlerSettings cobieStringHandlerSettings = new COBieStringHandlerSettings(EmptyStringMode.ALLOW, SpecialCharacterMode.REMOVE, TrailingDelimiterMode.ALLOW, InvalidDateTimeStringMode.SET_TO_NULL);
    private COBieStringHandler cobieStringHandler;
    public static boolean isBaseCOBieXMLPlugin(SerializerPlugin serializerPlugin)
    {
        return serializerPlugin.getDefaultName().equals(COBIE_XMLDATA_SERIALIZER_NAME);
    }

    private File cobieExportOptionsFile;
    private PluginManager pluginManager;
    // private BimServerClient bimServerClient;
    // private BimServerClient bimServerWorkerClient;
    // private BimServerClient bimServerGuiClient;
    private Deserializer ifcStepDeserializer;
    private Deserializer ifcXMLDeserializer;
    private ObjectIDMPlugin selectedIDMPlugin;
    private ObjectIDM objectIDM;
    private ControlTextItem selectedControlTextItem;
    private Map<ControlTextItem, ObjectIDMPlugin> controlTextItemToIDMPlugin;
    private File lastDirectoryAccessed;
    private Logger LOGGER = LoggerFactory.getLogger(CobieToolkit.class);

    private BIMServerCOBieSheetXMLDataSerializer cobieSheetXMLDataSerializer;
    private HashMap<ControlTextItem, COBieMergeIDMDocument> mergeRules;

    public CobieToolkit()
    {
        setCobieStringHandler(new COBieStringHandler(cobieStringHandlerSettings));
        initializePluginManager();
        try
        {
            LOGGER.info("Attempting to load plugins from Ecliplse Project Folders...");
            loadPluginsFromEclipseProjects();

        } catch (Exception e)
        {
            LOGGER.info("Eclipse Project Folder not found so plugins are loaded from plugins/jar files");
            try
            {
                initializePluginManager();
                loadJarPlugins();
            } catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }

        try
        {
            initializeAllPlugins();
            setIfcStepDeserializer(createIfcStepDeserializer());
            setIfcXMLDeserializer(createIfcXMLDeserialzier());
            setCOBieSheetXMLDataSerializer(createCOBieSheetXMLDataSerialzier());
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }

        try
        {
            initializeControlTextItemToActiveIDMPlugins();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        try
        {
            setIDMToCOBieIDM();
        } catch (Exception ex)
        {

        }
        setCobieExportOptionsFile(new File(TEMP_DIRECTORY_NAME + TMPDIRECTORY_COBIESERIALIZER + COBIE_EXPORT_SETTINGS_FILENAME));
    }

    private void addMergeRuleDocument(File mergeRuleFile) throws XmlException, IOException
    {
        XmlOptions xmlOptions = new XmlOptions();
        xmlOptions.setLoadLineNumbers(XmlOptions.LOAD_LINE_NUMBERS_END_ELEMENT);
        COBieMergeIDMDocument ruleDocument = COBieMergeIDMDocument.Factory.parse(mergeRuleFile, xmlOptions);
        ControlTextItem controlTextItem = controlTextItemFromCOBieMergeIDMDocument(ruleDocument);
        mergeRules.put(controlTextItem, ruleDocument);
    }

    private ControlTextItem controlTextItemFromCOBieMergeIDMDocument(COBieMergeIDMDocument mergeRulesDocument)
    {
        String key = mergeRulesDocument.getCOBieMergeIDM().getIDMRulesetName();
        String display = mergeRulesDocument.getCOBieMergeIDM().getIDMRulesetDisplayName();
        String toolTip = mergeRulesDocument.getCOBieMergeIDM().getLifeCycleMetadata().getDescription();
        return new ControlTextItem(key, display, toolTip, toolTip);
    }

    private ControlTextItem controlTextItemFromObjectIDMPlugin(ObjectIDMPlugin idmPlugin)
    {
        String key = idmPlugin.getDefaultName();
        String display = idmPlugin.getDefaultName();
        String toolTip = idmPlugin.getDescription();
        String longDescription = getLongDescriptionFromIdmPlugin(idmPlugin);
        return new ControlTextItem(key, display, toolTip, longDescription);
    }

    public ControlTextItem controlTextItemWithKey(String key)
    {
        ControlTextItem txtItem = null;
        for (ControlTextItem controlTextItem : controlTextItemToIDMPlugin.keySet())
        {
            if (controlTextItem.getKey().equals(key))
            {
                txtItem = controlTextItem;
            }
        }
        return txtItem;
    }

    private BIMServerCOBieSheetXMLDataSerializer createCOBieSheetXMLDataSerialzier() throws PluginException
    {
        BIMServerCOBieSheetXMLDataSerializer cobieSheetXMLDataSerializer = null;
        for (SerializerPlugin serializerPlugin : pluginManager.getAllSerializerPlugins(true))
        {
            if (serializerPlugin.getDefaultName().equals(COBIE_XMLDATA_SERIALIZER_NAME))
            {
                if (!serializerPlugin.isInitialized())
                {
                    serializerPlugin.init(pluginManager);
                }
                cobieSheetXMLDataSerializer = (BIMServerCOBieSheetXMLDataSerializer)serializerPlugin.createSerializer(null);

            }
        }
        return cobieSheetXMLDataSerializer;
    }

    private Deserializer createIfcStepDeserializer() throws PluginException
    {
        return initializeDeserializerByName(IFC_STEP_DESERIALIZER_NAME);
    }

    private Deserializer createIfcXMLDeserialzier() throws PluginException
    {
        return initializeDeserializerByName(IFC_XML_DESERIALIZER_NAME);
    }

    public void disconnect(NotificationInterface... notificationInterfaces)
    {

        // bimServerClient.disconnect();
        // bimServerGuiClient.disconnect();
        // bimServerWorkerClient.disconnect();
    }

    /*
     * public BimServerClient getBimServerClient() { return bimServerClient; }
     */

    public File getCobieExportOptionsFile()
    {
        return cobieExportOptionsFile;
    }

    public BIMServerCOBieSheetXMLDataSerializer getCOBieSheetXMLDataSerializer()
    {
        return cobieSheetXMLDataSerializer;
    }

    public Map<ControlTextItem, ObjectIDMPlugin> getControlTextItemToIDMPlugin()
    {
        return controlTextItemToIDMPlugin;
    }

    public List<ObjectIDMPlugin> getIDMPlugins()
    {
        ArrayList<ObjectIDMPlugin> idmPlugins = new ArrayList<ObjectIDMPlugin>();
        idmPlugins = new ArrayList<ObjectIDMPlugin>(pluginManager.getAllObjectIDMPlugins(true));
        return idmPlugins;
    }

    public Deserializer getIfcStepDeserializer() throws PluginException
    {
        ifcStepDeserializer.init(pluginManager.requireSchemaDefinition());
        return ifcStepDeserializer;
    }

    public Deserializer getIfcXMLDeserializer()
    {
        return ifcXMLDeserializer;
    }

    /*
     * public BimServerClient getBimServerWorkerClient() { return
     * bimServerWorkerClient; }
     * 
     * public BimServerClient getBimServerGuiClient() { return
     * bimServerGuiClient; }
     */

    /*
     * public boolean allServicesConnected() throws ServerException,
     * UserException { boolean connected = false; try { connected =
     * (bimServerClient.getServiceInterface().isLoggedIn() &&
     * bimServerWorkerClient.getServiceInterface().isLoggedIn() &&
     * bimServerGuiClient.getServiceInterface().isLoggedIn()); } catch(Exception
     * ex) {
     * 
     * } return connected; }
     */

    public File getLastDirectoryAccessed()
    {
        return lastDirectoryAccessed;
    }

    private String getLongDescriptionFromIdmPlugin(ObjectIDMPlugin idmPlugin)
    {
        String longDescription = idmPlugin.getDescription();
        if (idmPlugin.getObjectIDM(null) instanceof COBieFilterable)
        {

            List<String> ignoredClassNames = ((COBieFilterable)idmPlugin.getObjectIDM(null)).getIgnoreClassNames();
            if (ignoredClassNames.size() > 0)
            {
                longDescription = COBieUtility.delimittedStringSpacedFromArrayList(ignoredClassNames);
            }
        }
        return COBieUtility.getCOBieString(longDescription);
    }

    public HashMap<ControlTextItem, COBieMergeIDMDocument> getMergeRules()
    {
        return mergeRules;
    }

    public ObjectIDM getObjectIDM()
    {
        return objectIDM;
    }

    public PluginManager getPluginManager()
    {
        return pluginManager;
    }

    public ControlTextItem getSelectedControlTextItem()
    {
        return selectedControlTextItem;
    }

    public ObjectIDMPlugin getSelectedIDMPlugin()
    {
        return selectedIDMPlugin;
    }

    private void initializeAllPlugins()
    {
        LOGGER.info("Attempting to intialize all plugins...");
        try
        {
            for (Plugin plugin : pluginManager.getAllPlugins(false))
            {
                try
                {
                    if (!pluginManager.isEnabled(plugin.getClass().getCanonicalName()))
                    {
                        pluginManager.enablePlugin(plugin.getDefaultName());
                    }
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
                System.out.println("Plugin Context:  " + pluginManager.getPluginContext(plugin).getLocation());
                LOGGER.info("Initializing " + plugin.getDefaultName());
                String pluginDescription = plugin.getDescription() + " " + plugin.getClass().getSimpleName();
                if (!plugin.isInitialized())
                {
                    try
                    {

                        System.out.println("Attempting to initialize plugin:  " + pluginDescription);
                        plugin.init(pluginManager);
                        System.out.println("Plugin initialized:  " + pluginDescription);
                    } catch (Exception ex)
                    {
                        String serializerName = "";
                        if (plugin instanceof SerializerPlugin)
                        {
                            serializerName = ((SerializerPlugin)plugin).getDefaultName();
                            System.out.println("Error loading plugin:  " + serializerName);
                            ex.printStackTrace();
                        } else if (plugin instanceof DeserializerPlugin)
                        {
                            serializerName = ((DeserializerPlugin)plugin).getDefaultName();
                            System.out.println("Error loading plugin:  " + serializerName);
                            ex.printStackTrace();
                        }

                        else if (plugin instanceof ObjectIDMPlugin)
                        {
                            serializerName = ((ObjectIDMPlugin)plugin).getDefaultName();
                            System.out.println("Error loading plugin:  " + serializerName);
                            ex.printStackTrace();
                        }
                        if (serializerName.length() > 0)
                        {
                            pluginManager.disablePlugin(serializerName);
                        }
                    }
                } else
                {
                    System.out.println("Plugin already loaded: " + pluginDescription);
                }
            }
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    private void initializeControlTextItemToActiveIDMPlugins()
    {
        controlTextItemToIDMPlugin = new HashMap<ControlTextItem, ObjectIDMPlugin>();
        for (ObjectIDMPlugin idmPlugin : pluginManager.getAllObjectIDMPlugins(true))
        {
            controlTextItemToIDMPlugin.put(controlTextItemFromObjectIDMPlugin(idmPlugin), idmPlugin);
        }
    }

    private Deserializer initializeDeserializerByName(String name) throws PluginException
    {
        Deserializer deserializer = null;
        for (DeserializerPlugin deserializerPlugin : pluginManager.getAllDeserializerPlugins(true))
        {
            if (deserializerPlugin.getDefaultName().equals(name))
            {
                DeserializerPlugin plugin = deserializerPlugin;
                if (!plugin.isInitialized())
                {
                    plugin.init(pluginManager);
                }
                deserializer = plugin.createDeserializer(null);
            }
        }
        return deserializer;
    }

    private void initializePluginManager()
    {
        System.setProperty("org.apache.cxf.Logger", "org.apache.cxf.common.logging.Log4jLogger");
        System.out.println(System.getProperty("java.class.path"));
        // serverInfoManager = new ServerInfoManager();
        // notificationsManager = new NotificationsManager(null, null);
        // serviceFactory = new PublicInterfaceFactory(null);
        pluginManager = new PluginManager(new File(TEMP_DIRECTORY_NAME), System.getProperty("java.class.path"), null, null, null);
        // pluginManager = new PluginManager(tempDir, baseClassPath,
        // serviceFactory, notificationsManagerInterface, servicesMap)
        // pluginManager = new PluginManager(new
        // File(TEMP_DIRECTORY_NAME),null);
        System.out.println(new File(TEMP_DIRECTORY_NAME).getAbsolutePath());
        System.out.println(new File(PLUGINS_DIRECTORY_NAME).getAbsolutePath());
    }

    private void loadJarPlugins()
    {
        try
        {
            pluginManager.loadAllPluginsFromDirectoryOfJars(new File(PLUGINS_DIRECTORY_NAME));
            // pluginManager.loadPlugin(ObjectIDMPlugin.class, "Internal",
            // "Internal", new SchemaFieldObjectIDMPlugin(),
            // getClass().getClassLoader(), PluginType.INTERNAL);
        } catch (PluginException e)
        {
            e.printStackTrace();
        }
    }

    public void loadMergeRules(File mergeRuleDirectory)
    {
        mergeRules = new HashMap<ControlTextItem, COBieMergeIDMDocument>();
        if (mergeRuleDirectory.exists() && mergeRuleDirectory.isDirectory())
        {
            for (File dirChild : mergeRuleDirectory.listFiles())
            {
                if (dirChild.exists() && dirChild.isDirectory())
                {
                    loadMergeRules(dirChild);
                } else if (dirChild.exists() && dirChild.isFile())
                {
                    try
                    {
                        addMergeRuleDocument(dirChild);
                    } catch (XmlException e)
                    {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (IOException e)
                    {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private void loadPluginsFromEclipseProjects() throws PluginException
    {
        pluginManager.loadPluginsFromEclipseProject(new File(BUILDING_SMART_PLUGIN_PATH));
        pluginManager.loadPluginsFromEclipseProject(new File(IFC_PLUGINS_PATH));
        pluginManager.loadPluginsFromEclipseProject(new File(COBIE_PLUGINS_PATH));
    }

    public void selectIDM(ObjectIDMPlugin idmPlugin)
    {
        if (idmPlugin != null)
        {
            setSelectedIDMPlugin(idmPlugin);
            setSelectedControlTextItem(controlTextItemWithKey(idmPlugin.getDefaultName()));
            setObjectIDM(idmPlugin.getObjectIDM(null));
        } else
        {
            setNoIDM();
        }
    }

    public void setCobieExportOptionsFile(File cobieExportOptionsFile)
    {
        this.cobieExportOptionsFile = cobieExportOptionsFile;
    }

    private void setCOBieSheetXMLDataSerializer(BIMServerCOBieSheetXMLDataSerializer cobieSheetXMLDataSerializer)
    {
        this.cobieSheetXMLDataSerializer = cobieSheetXMLDataSerializer;
    }

    private void setIDMToCOBieIDM()
    {
        for (ObjectIDMPlugin idmPlugin : pluginManager.getAllObjectIDMPlugins(true))
        {
            if (idmPlugin.getDefaultName().equals(COBieIDMPluginName.COBieIDMPluginName.toString()))
            {
                selectIDM(idmPlugin);
            }
        }
    }

    private void setIfcStepDeserializer(Deserializer ifcStepDeserializer)
    {
        this.ifcStepDeserializer = ifcStepDeserializer;
    }

    public void setIfcXMLDeserializer(Deserializer ifcXMLDeserializer)
    {
        this.ifcXMLDeserializer = ifcXMLDeserializer;
    }

    public void setLastDirectoryAccessed(File lastDirectoryAccessed)
    {
        this.lastDirectoryAccessed = lastDirectoryAccessed;
    }

    private void setNoIDM()
    {
        setSelectedIDMPlugin(null);
        setSelectedControlTextItem(null);
        setObjectIDM(null);
    }

    public void setObjectIDM(ObjectIDM objectIDM)
    {
        this.objectIDM = objectIDM;
    }

    public void setSelectedControlTextItem(ControlTextItem selectedControlTextItem)
    {
        this.selectedControlTextItem = selectedControlTextItem;
    }

    private void setSelectedIDMPlugin(ObjectIDMPlugin selectedIDMPlugin)
    {
        this.selectedIDMPlugin = selectedIDMPlugin;
    }

    public COBieStringHandlerSettings getCobieStringWriterSettings()
    {
        return cobieStringHandlerSettings;
    }

    public void setCobieStringWriterSettings(COBieStringHandlerSettings cobieStringHandlerSettings)
    {
        this.cobieStringHandlerSettings = cobieStringHandlerSettings;
        setCobieStringHandler(new COBieStringHandler(cobieStringHandlerSettings));
    }

    public COBieStringHandler getCobieStringHandler()
    {
        return cobieStringHandler;
    }

    public void setCobieStringHandler(COBieStringHandler cobieStringWriter)
    {
        this.cobieStringHandler = cobieStringWriter;
    }

}