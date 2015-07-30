package org.bimserver.cobie.shared.plugininfo;

public class SerializerPluginInfo extends COBiePluginInfo
{
    private String content;
    private String fileExtension;

    public SerializerPluginInfo(String defaultName, String description, String version, String fileExtension, String content)
    {
        super(defaultName, description, version);
        setContent(content);
        setFileExtension(fileExtension);
    }

    public String getContent()
    {
        return content;
    }

    public String getFileExtension()
    {
        return fileExtension;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public void setFileExtension(String fileExtension)
    {
        this.fileExtension = fileExtension;
    }

}
