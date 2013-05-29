package org.erdc.cobie.utils.serializer;

import org.bimserver.plugins.serializers.SerializerException;
import org.erdc.cobie.shared.LoggerUser;
import org.erdc.cobie.sheetxmldata.COBIEDocument;

//TODO This interface could be eliminated if the COBieToolkit is refactored properly.
public interface COBieSheetXMLDataSerializable extends LoggerUser
{
    public COBIEDocument getCOBieDocument();

    public void init(COBIEDocument cobie) throws SerializerException;

}
