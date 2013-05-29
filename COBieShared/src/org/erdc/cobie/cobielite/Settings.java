package org.erdc.cobie.cobielite;

import java.util.HashMap;

import org.apache.xmlbeans.XmlOptions;

public class Settings
{

    public static class XML_Beans_Settings
    {
        public static XmlOptions getSaveSettings()
        {
            XmlOptions saveSettings =
                    new XmlOptions();
           HashMap<String,String> suggestedPrefixes = new HashMap<String,String>();
            suggestedPrefixes.put("cobielite.cobie.erdc.org", "");
            saveSettings.setSaveSuggestedPrefixes(suggestedPrefixes);
            saveSettings.setUseDefaultNamespace();
            saveSettings.setSaveAggressiveNamespaces();
            return saveSettings;
        }
    }

}
