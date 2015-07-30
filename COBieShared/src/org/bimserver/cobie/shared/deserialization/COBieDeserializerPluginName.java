package org.bimserver.cobie.shared.deserialization;

public enum COBieDeserializerPluginName
{
    COBIE_SPREADHSEET("COBieDeserializer"),
    COBie_TAB("COBieTabDeserializer"),
    COBie_XLSX("COBieXLSXDeserializer");
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
