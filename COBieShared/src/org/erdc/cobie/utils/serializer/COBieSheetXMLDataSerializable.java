package org.erdc.cobie.utils.serializer;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.serializers.SerializerException;
import org.erdc.cobie.sheetxmldata.COBIEDocument;

public interface COBieSheetXMLDataSerializable
{
    public void init(IfcModelInterface model, PluginManager pluginManager) throws SerializerException;
    public void init(PluginManager pluginManager, COBIEDocument cobie) throws SerializerException;
    public void modelToCOBie();
    public COBIEDocument getCOBieDocument();
}
