package org.bimserver.cobie.shared.serialization;

import org.bimserver.cobie.shared.LoggerUser;
import org.bimserver.plugins.serializers.SerializerException;
import org.nibs.cobie.tab.COBIEDocument;

//TODO This interface could be eliminated if the COBieToolkit is refactored properly.
public interface COBieSheetXMLDataSerializable extends LoggerUser
{
    public COBIEDocument getCOBieDocument();

    public void init(COBIEDocument cobie) throws SerializerException;

}
