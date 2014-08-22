package org.erdc.cobie.shared.bimserver.cobietab.key;

import org.apache.xmlbeans.XmlObject;
import org.erdc.cobie.shared.bimserver.COBIERowDictionary;
import org.erdc.cobie.shared.bimserver.COBIESheetDictionary;

public abstract class KeyedCOBieSheetXMLDataElement<T extends XmlObject>
{
    private static final int HASH_OFFSET = 219;
    private static final String XML_BEANS_AUTO_SUFFIX = "TypeImpl";
    private T cobieSheetXMLDataElement;
    private COBIERowDictionary rowDictionary;

    public KeyedCOBieSheetXMLDataElement(T cobieSheetXMLDataElement)
    {
        setCOBieSheetXMLDataElement(cobieSheetXMLDataElement);
        rowDictionary = COBIESheetDictionary.cobieRowColumnNameValuesFromXMLObject(sheetNameFromXmlObjectClass(cobieSheetXMLDataElement),
                cobieSheetXMLDataElement);
    }

    @Override
    public boolean equals(Object o)
    {
        boolean equals = false;
        if(o instanceof KeyedCOBieSheetXMLDataElement<?>)
        {
            if (o == this)
            {
                equals = true;
            }
            if (o.getClass().equals(this.getClass()))
            {
                @SuppressWarnings("unchecked")
                KeyedCOBieSheetXMLDataElement<T> castObject = (KeyedCOBieSheetXMLDataElement<T>) o;
                COBIERowDictionary oRowDictionary = COBIESheetDictionary.cobieRowColumnNameValuesFromXMLObject(
                        sheetNameFromXmlObjectClass(castObject.getCOBieSheetXMLDataElement()), castObject.getCOBieSheetXMLDataElement());
                if (oRowDictionary.getCOBieRowIdString().equals(rowDictionary.getCOBieRowIdString()))
                {
                    equals = true;
                }

            }
            
        }
        return equals;
    }

    public final T getCOBieSheetXMLDataElement()
    {
        return cobieSheetXMLDataElement;
    }

    public String getCOBieSheetXMLDataElementKey()
    {
        return rowDictionary.getCOBieRowIdString();
    }

    @Override
    public final int hashCode()
    {
        String key = rowDictionary.getCOBieRowIdString();
        return HASH_OFFSET + (key == null ? 0 : key.hashCode());
    }

    private final void setCOBieSheetXMLDataElement(T cobieSheetXMLDataElement)
    {
        this.cobieSheetXMLDataElement = cobieSheetXMLDataElement;
    }

    private final String sheetNameFromXmlObjectClass(T xmlObject)
    {
        String sheetName = "";
        String simpleClassName = xmlObject.getClass().getSimpleName();
        if (simpleClassName.endsWith(XML_BEANS_AUTO_SUFFIX))
        {
            simpleClassName = simpleClassName.substring(0, simpleClassName.length() - XML_BEANS_AUTO_SUFFIX.length());
        }
        sheetName = simpleClassName;
        return sheetName;
    }

}
