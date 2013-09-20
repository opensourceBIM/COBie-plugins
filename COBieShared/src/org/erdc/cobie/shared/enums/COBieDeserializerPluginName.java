package org.erdc.cobie.shared.enums;

public enum COBieDeserializerPluginName
{
    COBIE_SPREADHSEET("COBieDeserializer"),
    COBIE_SHEETXMLDATA("COBieSheetXMLDataDeserializer");
    private String pluginName;

    private COBieDeserializerPluginName(String pluginName)
    {
        this.pluginName = pluginName;
    }

    @Override
    public String toString()
    {
        return pluginName;
    }
}
