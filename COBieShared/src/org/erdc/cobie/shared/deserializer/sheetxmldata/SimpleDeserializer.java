package org.erdc.cobie.shared.deserializer.sheetxmldata;

import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterfaceException;
import org.erdc.cobie.shared.deserializer.sheetxmldata.modelhandlers.IfcCommonHandler;

public abstract class SimpleDeserializer<T_COBIE_SHEET extends org.apache.xmlbeans.XmlObject, T_COBIE_ROW extends org.apache.xmlbeans.XmlObject, T_IFC extends IdEObject>
                extends Deserializer<T_COBIE_SHEET, T_COBIE_ROW, T_IFC>
{

    public SimpleDeserializer(IfcCommonHandler ifcCommonHandler, COBieIfcModel model, T_COBIE_SHEET cobieSheetXMLDataSection)
    {
        super(ifcCommonHandler, model, cobieSheetXMLDataSection);

    }
    
    @Override
    protected final void write(T_IFC ifcObject, T_COBIE_ROW cobie) throws IfcModelInterfaceException, DeserializerException
    {
        writeIfcObject(ifcObject, cobie);
        writeRelationships(ifcObject, cobie);
    }

}
