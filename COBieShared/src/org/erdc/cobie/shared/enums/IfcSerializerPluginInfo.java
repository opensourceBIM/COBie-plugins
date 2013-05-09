package org.erdc.cobie.shared.enums;

public enum IfcSerializerPluginInfo implements PluginInfo
{
    IFC("","",""),
    IFC_XXM("","","");
    
    private IfcSerializerPluginInfo(String name, String description, String extension)
    {
        this.pluginName = name;
        this.description = description;
        this.extension =  extension;
    }
    private String pluginName;
    private  String description;
    private String extension;
    @Override
    public String getPluginName()
    {
        return pluginName;
    }

    @Override
    public String getDescription()
    {
        return description;
    }

    @Override
    public String getFileExtension()
    {
        return extension;
    }

}
