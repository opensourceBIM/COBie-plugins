package org.bimserver.cobie.shared.plugininfo;

public abstract class COBiePluginInfo
{
    private String defaultName;
    private String description;
    private String version;

    public COBiePluginInfo(String defaultName, String description, String version)
    {
        setDefaultName(defaultName);
        setDescription(description);
        setVersion(version);
    }

    public String getDefaultName()
    {
        return defaultName;
    }

    public String getDescription()
    {
        return description;
    }

    public String getVersion()
    {
        return version;
    }

    public void setDefaultName(String defaultName)
    {
        this.defaultName = defaultName;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void setVersion(String version)
    {
        this.version = version;
    }
}
