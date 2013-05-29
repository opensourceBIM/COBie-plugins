package org.erdc.cobie.shared.deserializer.sheetxmldata;

import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterfaceException;
import org.erdc.cobie.shared.deserializer.sheetxmldata.modelhandlers.IfcCommonHandler;

public abstract class ComplexDeserializer<T_COBIE_SHEET extends org.apache.xmlbeans.XmlObject, T_COBIE_ROW extends org.apache.xmlbeans.XmlObject, T_IFC extends IdEObject> 
                        extends Deserializer<T_COBIE_SHEET, T_COBIE_ROW, T_IFC>
{

    public ComplexDeserializer(IfcCommonHandler ifcCommonHandler, COBieIfcModel model, T_COBIE_SHEET cobieSheetXMLDataSection)
    {
        super(ifcCommonHandler, model, cobieSheetXMLDataSection);
    }
    
    protected abstract void writeClassifications(T_IFC ifcObject, T_COBIE_ROW cobieSheetXMLDataElement) throws DeserializerException;
    
    /**
     * Instantiate IfcPropertySets and adds them to the model
     */
    protected  abstract void writePropertySets(T_IFC ifcObject, T_COBIE_ROW cobieSheetXMLDataElement) throws DeserializerException;
   
    @Override
    protected final void write(T_IFC ifcObject, T_COBIE_ROW cobie) throws IfcModelInterfaceException, DeserializerException
    {
        writePropertySets(ifcObject, cobie);
        writeIfcObject(ifcObject, cobie);
        writeClassifications(ifcObject, cobie);
        writeRelationships(ifcObject, cobie);
    }
    /**
     * Relates Ifc entities and adds them to a model in t
     * @throws IfcModelInterfaceException 
     */
    
}
