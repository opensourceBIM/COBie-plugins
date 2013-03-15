package org.erdc.cobie.utils.serializer;

import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.serializers.EmfSerializer;
import org.erdc.cobie.sheetxmldata.COBIEDocument;

public abstract class BIMServerCOBieSheetXMLDataSerializer extends EmfSerializer implements COBieSheetXMLDataSerializable
{
    public BIMServerCOBieSheetXMLDataSerializer()
    {
        super();
    }
    
    public BIMServerCOBieSheetXMLDataSerializer(PluginManager pluginManager, COBIEDocument cobie)
    {
        super();
    }
}
