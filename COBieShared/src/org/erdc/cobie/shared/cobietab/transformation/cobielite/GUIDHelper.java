package org.erdc.cobie.shared.cobietab.transformation.cobielite;

import java.util.UUID;

import org.apache.commons.collections.map.CaseInsensitiveMap;
import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlObject;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.FacilityDocument;
import org.buildingsmartalliance.docs.nbims03.cobie.core.AreaUnitComplexObjectType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.CobieComplexObjectType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.CurrencyUnitComplexObjectType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.LinearUnitComplexObjectType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.UnitNameComplexObjectType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.ValueBaseType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.VolumeUnitComplexObjectType;

public class GUIDHelper
{
	private FacilityDocument facilityDocument;
	private CaseInsensitiveMap unitMap = new CaseInsensitiveMap();
	public GUIDHelper(FacilityDocument facilityDocument)
	{
		setFacilityDocument(facilityDocument);
	}
	public FacilityDocument getFacilityDocument()
	{
		return facilityDocument;
	}
	public void setFacilityDocument(FacilityDocument facilityDocument)
	{
		this.facilityDocument = facilityDocument;
	}
	
	public void generateGUIDs()
	{
		generateGUIDs(facilityDocument);
	}
	
	public void generateGUIDs(XmlObject xmlObject)
	{
		//look for an existing GUID attribute...if one exists, set it to a new guid, if not, and the schema type
		//includes a GUID attribute then create a new instance and set its value

		if (xmlObject instanceof UnitNameComplexObjectType)
		{
			((UnitNameComplexObjectType)xmlObject).setGUID(newUnitGUID(((XmlAnySimpleType)xmlObject).getStringValue()));
		}
		else if(xmlObject instanceof AreaUnitComplexObjectType)
		{
			((AreaUnitComplexObjectType)xmlObject).setGUID(newUnitGUID(((XmlAnySimpleType)xmlObject).getStringValue()));
		}
		else if(xmlObject instanceof ValueBaseType)
		{
			((ValueBaseType)xmlObject).setGUID(newGUID());
		}
		else if(xmlObject instanceof LinearUnitComplexObjectType)
		{
			((LinearUnitComplexObjectType)xmlObject).setGUID(newUnitGUID(((XmlAnySimpleType)xmlObject).getStringValue()));
		}
		else if(xmlObject instanceof VolumeUnitComplexObjectType)
		{
			((VolumeUnitComplexObjectType)xmlObject).setGUID(newUnitGUID(((XmlAnySimpleType)xmlObject).getStringValue()));
		}
		else if(xmlObject instanceof CurrencyUnitComplexObjectType)
		{
			((CurrencyUnitComplexObjectType)xmlObject).setGUID(newUnitGUID(((XmlAnySimpleType)xmlObject).getStringValue()));
		}
		else if(xmlObject instanceof CobieComplexObjectType)
		{
			((CobieComplexObjectType)xmlObject).setGUID(newGUID());
		}
		
		SchemaType schemaType = xmlObject.schemaType();
		SchemaGlobalElement[] globalElements = schemaType.getTypeSystem().globalElements();
		for(SchemaGlobalElement globalElement : globalElements)
		{
			XmlObject[] children = xmlObject.selectChildren(globalElement.getName());
			for(XmlObject child : children)
			{
				generateGUIDs(child);
			}
		}

		
	}
	private String newGUID()
	{
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	private String newUnitGUID(String unitName)
	{
		String guid;
		if(this.getUnitMap().containsKey(unitName))
		{
			guid = (String)getUnitMap().get(unitName);
		}
		else
		{
			guid = newGUID();
			getUnitMap().put(unitName, guid);
		}
		return guid;
	}
	public CaseInsensitiveMap getUnitMap()
	{
		return unitMap;
	}
	public void setUnitMap(CaseInsensitiveMap unitMap)
	{
		this.unitMap = unitMap;
	}

}
