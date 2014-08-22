package org.erdc.cobie.shared.bimserver.ifc.serialization;

import org.bimserver.interfaces.objects.SObjectType;
import org.bimserver.interfaces.objects.SParameter;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.interfaces.objects.SStringType;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.PluginInterface;

public class SerializerInfo
{
    private final PluginInterface pluginInterface;
    private final SSerializerPluginConfiguration serializerPluginConfiguration;
    private final SObjectType settings;
    private String extension, contentType;

    public SerializerInfo(PluginInterface pluginInterface, SSerializerPluginConfiguration serializerPluginConfiguration) throws ServerException,
            UserException
    {
        this.pluginInterface = pluginInterface;
        this.serializerPluginConfiguration = serializerPluginConfiguration;
        long settingsID = serializerPluginConfiguration.getOid();
        settings = pluginInterface.getPluginSettings(settingsID);
        init();
    }

    public String getContentType()
    {
        return contentType;
    }

    public String getExtension()
    {
        return extension;
    }

    public PluginInterface getPluginInterface()
    {
        return pluginInterface;
    }

    public SSerializerPluginConfiguration getSerializerPluginConfiguration()
    {
        return serializerPluginConfiguration;
    }

    public SObjectType getSettings()
    {
        return settings;
    }

    private void init()
    {
        for (SParameter parameter : settings.getParameters())
        {
            if (parameter.getName().equals(SerializerPlugin.EXTENSION))
            {
                extension = ((SStringType)parameter.getValue()).getValue();
            }

            if (parameter.getName().equals(SerializerPlugin.CONTENT_TYPE))
            {
                contentType = ((SStringType)parameter.getValue()).getValue();
            }
        }

    }

    public void setContentType(String contentType)
    {
        this.contentType = contentType;
    }

    public void setExtension(String extension)
    {
        this.extension = extension;
    }
}
