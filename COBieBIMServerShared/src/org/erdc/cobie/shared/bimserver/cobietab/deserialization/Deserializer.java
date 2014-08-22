package org.erdc.cobie.shared.bimserver.cobietab.deserialization;

import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterfaceException;
import org.erdc.cobie.shared.LoggerUser;
import org.erdc.cobie.shared.bimserver.cobietab.deserialization.modelhandlers.IfcCommonHandler;
import org.slf4j.Logger;

public abstract class Deserializer<T_COBIE_SHEET extends org.apache.xmlbeans.XmlObject, T_COBIE_ROW extends org.apache.xmlbeans.XmlObject, T_IFC extends IdEObject>
        implements LoggerUser
{
    private IfcCommonHandler ifcCommonHandler;
    private COBieIfcModel model;
    private T_COBIE_SHEET cobieSheetXMLDataSection;
    private int deserializedElementCount;
    private int deserializedElementErrorCount;
    private Iterable<T_COBIE_ROW> cobieSheetXMLDataElementIterable;
    protected static Logger LOGGER;

    public Deserializer(IfcCommonHandler ifcCommonHandler, COBieIfcModel model, T_COBIE_SHEET cobieSheetXMLDataSection)
    {
        this.ifcCommonHandler = ifcCommonHandler;
        this.model = model;
        this.cobieSheetXMLDataSection = cobieSheetXMLDataSection;
        cobieSheetXMLDataElementIterable = cobieSheetXMLDataSectionIterableFromCOBieSheetXMLDataSection(cobieSheetXMLDataSection);
    }

    protected abstract long writeIfcObject(T_IFC ifcObject, T_COBIE_ROW cobieSheetXMLDataElement) throws IfcModelInterfaceException,
            DeserializerException;

    /**
     * returns true if element exists in model, false otherwise
     */
    protected abstract boolean cobieSheetXMLDataElementIsInModel(T_COBIE_ROW cobieSheetXMLDataElement);

    protected abstract Iterable<T_COBIE_ROW> cobieSheetXMLDataSectionIterableFromCOBieSheetXMLDataSection(T_COBIE_SHEET cobieSheetXMLDataSection);

    /**
     * Deserialize COBie to Ifc
     */
    protected final void deserialize()
    {
        if (cobieSheetXMLDataElementIterable != null)
        {
            for (T_COBIE_ROW cobieSheetXMLDataElement : cobieSheetXMLDataElementIterable)
            {
                if (!cobieSheetXMLDataElementIsInModel(cobieSheetXMLDataElement))
                {
                    try
                    {
                        T_IFC ifcObject = initializeIfcFromCOBieSheetXMLData(cobieSheetXMLDataElement);
                        if (ifcObject != null)
                        {
                            write(ifcObject, cobieSheetXMLDataElement);
                        }
                    } catch (Exception ex)
                    {
                        getLogger().warn(ex.getMessage());
                    }
                }
            }
        }
    }

    public Iterable<T_COBIE_ROW> getCobieSheetXMLDataElementIterable()
    {
        return cobieSheetXMLDataElementIterable;
    }

    public T_COBIE_SHEET getCobieSheetXMLDataSection()
    {
        return cobieSheetXMLDataSection;
    }

    public int getDeserializedElementCount()
    {
        return deserializedElementCount;
    }

    public int getDeserializedElementErrorCount()
    {
        return deserializedElementErrorCount;
    }

    public IfcCommonHandler getIfcCommonHandler()
    {
        return ifcCommonHandler;
    }

    /**
     * Instantiate IfcClassificatoin objects.
     * 
     * @param ifcObject
     *            the ifc object
     * @param cobieSheetXMLDataElement
     *            the cobie lite element
     * @throws Exception
     *             the exception
     */

    @Override
    public Logger getLogger()
    {
        return LOGGER;
    }

    public COBieIfcModel getModel()
    {
        return model;
    }

    /**
     * Initialize K from X
     * 
     * @param single
     *            COBieSheetXMLData element (e.g. ContactType, ComponentType,
     *            etc)
     * @return Instantiated Ifc object
     */
    protected abstract T_IFC initializeIfcFromCOBieSheetXMLData(T_COBIE_ROW cobieElement) throws DeserializerException;

    public void setDeserializedElementCount(int deserializedElementCount)
    {
        this.deserializedElementCount = deserializedElementCount;
    }

    protected abstract void write(T_IFC ifcObject, T_COBIE_ROW cobie) throws IfcModelInterfaceException, DeserializerException;
    
    protected abstract void writeRelationships(T_IFC ifcObject, T_COBIE_ROW cobieSheetXMLDataElement) throws DeserializerException;

}
