package org.erdc.cobie.utils.deserializer;

import org.bimserver.emf.IdEObject;
import org.erdc.cobie.utils.deserializer.modelhandlers.IfcCommonHandler;

public abstract class COBieSheetXMLDataSectionDeserializer<T, X, K extends IdEObject>
{
    protected IfcCommonHandler ifcCommonHandler;
    protected COBieIfcModel model;
    protected T cobieSheetXMLDataSection;
    protected int deserializedElementCount;
    protected int deserializedElementErrorCount;
    protected Iterable<X> cobieSheetXMLDataElementIterable;

    public COBieSheetXMLDataSectionDeserializer(IfcCommonHandler ifcCommonHandler, COBieIfcModel model, T cobieSheetXMLDataSection)
    {
        this.ifcCommonHandler = ifcCommonHandler;
        this.model = model;
        this.cobieSheetXMLDataSection = cobieSheetXMLDataSection;
        cobieSheetXMLDataElementIterable = cobieSheetXMLDataSectionIterableFromCOBieSheetXMLDataSection(cobieSheetXMLDataSection);
    }

    protected abstract long addObjectToModel(K ifcObject, X cobieSheetXMLDataElement);

    /**
     * returns true if element exists in model, false otherwise
     */
    protected abstract boolean cobieSheetXMLDataElementIsInModel(X cobieSheetXMLDataElement);

    protected abstract Iterable cobieSheetXMLDataSectionIterableFromCOBieSheetXMLDataSection(T cobieSheetXMLDataSection);

    /**
     * Deserialize COBie to Ifc
     */
    protected void deserialize()
    {
        if (cobieSheetXMLDataElementIterable != null)
        {
            for (X cobieSheetXMLDataElement : cobieSheetXMLDataElementIterable)
            {
                if (!cobieSheetXMLDataElementIsInModel(cobieSheetXMLDataElement))
                {
                    try
                    {
                        K ifcObject = initializeIfcFromCOBieSheetXMLData(cobieSheetXMLDataElement);
                        if (ifcObject != null)
                        {
                            initializeAndAddPropertySetsToModel(ifcObject, cobieSheetXMLDataElement);
                            addObjectToModel(ifcObject, cobieSheetXMLDataElement);
                            initializeAndAddClassificationsToModel(ifcObject, cobieSheetXMLDataElement);
                            intializeAndAddRelationshipsToModel(ifcObject, cobieSheetXMLDataElement);
                        }
                    } catch (Exception ex)
                    {
                        ex.printStackTrace();
                    }
                }
            }
        }
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
    protected abstract void initializeAndAddClassificationsToModel(K ifcObject, X cobieSheetXMLDataElement) throws Exception;

    /**
     * Instantiate IfcPropertySets and adds them to the model
     */
    protected abstract void initializeAndAddPropertySetsToModel(K ifcObject, X cobieSheetXMLDataElement) throws Exception;

    /**
     * Initialize K from X
     * 
     * @param single
     *            COBieSheetXMLData element (e.g. ContactType, ComponentType,
     *            etc)
     * @return Instantiated Ifc object
     */
    protected abstract K initializeIfcFromCOBieSheetXMLData(X cobieElement) throws Exception;

    /**
     * Relates Ifc entities and adds them to a model in t
     */
    protected abstract void intializeAndAddRelationshipsToModel(K ifcObject, X cobieSheetXMLDataElement) throws Exception;

}
