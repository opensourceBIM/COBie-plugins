package org.bimserver.cobie.shared.transform.cobietab.cobielite;

import java.util.HashMap;
import java.util.Map;

import org.apache.xmlbeans.XmlOptions;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.FacilityDocument;

public class Settings
{

    public static class XML_Beans_Settings
    {
        public static XmlOptions getSaveSettings()
        {
            XmlOptions saveSettings = new XmlOptions();
            saveSettings.setSaveSuggestedPrefixes(getNamespacePrefixes());
            saveSettings.setSaveNamespacesFirst();
            saveSettings.setSavePrettyPrint();
            saveSettings.setSaveAggressiveNamespaces();
            saveSettings.setUseDefaultNamespace();
            saveSettings.setDocumentType(FacilityDocument.type);
            return saveSettings;
        }
        
        public static XmlOptions getNoNamespaceSaveSettings()
        {
            XmlOptions saveSettings = new XmlOptions();
            saveSettings.setSaveSaxNoNSDeclsInAttributes();
            saveSettings.setSaveAggressiveNamespaces();
            saveSettings.setUseDefaultNamespace();
            return saveSettings;
        }

        public static Map<String, String> getNamespacePrefixes()
        {
            HashMap<String, String> suggestedPrefixes = new HashMap<String, String>();
            suggestedPrefixes.put("http://docs.buildingsmartalliance.org/nbims03/cobie/cobielite", "cobielite");
            suggestedPrefixes.put("http://docs.buildingsmartalliance.org/nbims03/cobie/core", "");
            return suggestedPrefixes;
        }
        
        public static Map<String, String> getImplicitNamespaces()
        {
            Map<String,String> map = new HashMap<String, String>();
            Map<String, String> copyMap = getNamespacePrefixes();
            for(String key : copyMap.keySet())
            {
                map.put( copyMap.get(key), key);
            }
                
            return map;
        }
    }
    
    public static Map<String, String> getBlankNamespacePrefixes()
    {
        HashMap<String, String> suggestedPrefixes = new HashMap<String, String>();
        suggestedPrefixes.put("http://docs.buildingsmartalliance.org/nbims03/cobie/cobielite", "");
        suggestedPrefixes.put("http://docs.buildingsmartalliance.org/nbims03/cobie/core", "");
        
        return suggestedPrefixes;
    }
}

