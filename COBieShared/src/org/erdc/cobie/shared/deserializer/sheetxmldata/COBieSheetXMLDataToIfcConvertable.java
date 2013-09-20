package org.erdc.cobie.shared.deserializer.sheetxmldata;


// TODO: Auto-generated Javadoc
/**
 * The Interface COBieSheetXMLDataToIfcConvertable.
 * 
 * @param <T>
 *            One of the COBIEType interfaces that represent COBie worksheets
 *            (e.g. COBIEType.Contacts, COBIEType.Components,...)
 * @param <K>
 *            The base Ifc type that will store data from each element in T
 */
public interface COBieSheetXMLDataToIfcConvertable<T, K>
{

    /**
     * returns true if element exists in model, false otherwise
     */
    boolean cobieSheetXMLDataElementIsInModel(K cobieSheetXMLDataElement, COBieIfcModel model);

    /**
     * Deserialize COBie to Ifc
     */
    void deserialize();

    /**
     * Instantiate IfcPropertySets and adds them to the model
     */
    void initializeAndAddPropertySetsToModel(K ifcObject, T cobieSheetXMLDataElement, COBieIfcModel model) throws Exception;

    /**
     * Initialize K from T
     * 
     * @param single
     *            COBieSheetXMLData element (e.g. ContactType, ComponentType,
     *            etc)
     * @return Instantiated Ifc object
     */
    K initializeIfcFromCOBieSheetXMLData(T cobieSheetXMLDataElement) throws Exception;

    /**
     * Instantiate IfcClassificatoin objects
     */
    void instantiateClassifications(K ifcObject, T cobieSheetXMLDataElement) throws Exception;

    /**
     * Instantiate IfcRelationship objects
     */
    void instantiateRelationships(K ifcObject, T cobieSheetXMLDataElement) throws Exception;

    /**
     * Relates Ifc entities and adds them to a model in t
     */
    void relateObjectsAndAddToModel(K ifcObject, T cobieSheetXMLDataElement, COBieIfcModel model) throws Exception;
}
