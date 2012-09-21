package org.bimserver.shared.cobie.keyedcobielite;

import org.apache.xmlbeans.XmlObject;
import org.bimserver.shared.cobie.COBIERowDictionary;
import org.bimserver.shared.cobie.COBIESheetDictionary;

public abstract class KeyedCOBieLiteElement<T extends XmlObject> 
{
	private static final int HASH_OFFSET = 219;
	private static final String XML_BEANS_AUTO_SUFFIX = "TypeImpl";
	private T cobieLiteElement;
	private COBIERowDictionary rowDictionary;
	public  KeyedCOBieLiteElement(T cobieLiteElement)
	{
		setCobieLiteElement(cobieLiteElement);
		rowDictionary = 
				COBIESheetDictionary.cobieRowColumnNameValuesFromXMLObject
				(sheetNameFromXmlObjectClass(cobieLiteElement),cobieLiteElement);
	}
	@Override
	public boolean equals(Object o)
	{
		boolean equals = false;
		if (o==this)
			equals = true;
		if(o.getClass().equals(this.getClass()))
		{
			KeyedCOBieLiteElement<T> castObject =
					(KeyedCOBieLiteElement<T>) o;
			COBIERowDictionary oRowDictionary = COBIESheetDictionary.cobieRowColumnNameValuesFromXMLObject
					(sheetNameFromXmlObjectClass(castObject.getCobieLiteElement()),
					castObject.getCobieLiteElement());
			if(oRowDictionary.getCOBieRowIdString().equals(rowDictionary.getCOBieRowIdString()))
					equals = true;
			
		}
		return equals;
	}
	
	public String getCOBieLiteKey()
	{
		return rowDictionary.getCOBieRowIdString();
	}
	
	private final String sheetNameFromXmlObjectClass(T xmlObject)
	{
		String sheetName = "";
		String simpleClassName = xmlObject.getClass().getSimpleName();
		if(simpleClassName.endsWith(XML_BEANS_AUTO_SUFFIX))
			simpleClassName = simpleClassName.substring(0,simpleClassName.length()-XML_BEANS_AUTO_SUFFIX.length());
		sheetName = simpleClassName;
		return sheetName;
	}
	
	@Override
	public final int hashCode()
	{
		String key = rowDictionary.getCOBieRowIdString();
		return HASH_OFFSET+(key==null ? 0: key.hashCode());
	}
	
	
	public final T getCobieLiteElement()
	{
		return cobieLiteElement;
	}
	private final void setCobieLiteElement(T cobieLiteElement)
	{
		this.cobieLiteElement = cobieLiteElement;
	}
	
}
