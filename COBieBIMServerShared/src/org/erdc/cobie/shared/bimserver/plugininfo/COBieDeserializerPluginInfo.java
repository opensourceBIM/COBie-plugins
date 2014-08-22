package org.erdc.cobie.shared.bimserver.plugininfo;

public class COBieDeserializerPluginInfo extends COBiePluginInfo
{

    private String extension;

    public COBieDeserializerPluginInfo(String defaultName, String description, String version, String extension)
    {
        super(defaultName, description, version);
        setExtension(extension);
    }

    public String getExtension()
    {
        return extension;
    }

    public void setExtension(String extension)
    {
        this.extension = extension;
    }

}
