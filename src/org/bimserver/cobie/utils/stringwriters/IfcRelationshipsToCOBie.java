package org.bimserver.cobie.utils.stringwriters;
/******************************************************************************
 * Copyright (C) 2011  ERDC
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.bimserver.models.ifc2x3.IfcComplexProperty;
import org.bimserver.models.ifc2x3.IfcElementQuantity;
import org.bimserver.models.ifc2x3.IfcObject;
import org.bimserver.models.ifc2x3.IfcObjectDefinition;
import org.bimserver.models.ifc2x3.IfcPhysicalComplexQuantity;
import org.bimserver.models.ifc2x3.IfcPhysicalQuantity;
import org.bimserver.models.ifc2x3.IfcPhysicalSimpleQuantity;
import org.bimserver.models.ifc2x3.IfcProperty;
import org.bimserver.models.ifc2x3.IfcPropertyEnumeratedValue;
import org.bimserver.models.ifc2x3.IfcPropertySet;
import org.bimserver.models.ifc2x3.IfcPropertySetDefinition;
import org.bimserver.models.ifc2x3.IfcPropertySingleValue;
import org.bimserver.models.ifc2x3.IfcRelAssigns;
import org.bimserver.models.ifc2x3.IfcRelAssociates;
import org.bimserver.models.ifc2x3.IfcRelDefines;
import org.bimserver.models.ifc2x3.IfcRelDefinesByProperties;
import org.bimserver.models.ifc2x3.IfcRelDefinesByType;
import org.bimserver.models.ifc2x3.IfcRelationship;
import org.bimserver.models.ifc2x3.IfcRoot;
import org.bimserver.models.ifc2x3.IfcSimpleProperty;
import org.bimserver.models.ifc2x3.IfcTypeObject;
import org.eclipse.emf.common.util.EList;

public class IfcRelationshipsToCOBie 
{
	private static enum ComparisonType{StartsWith,EndsWith,Contains,Equals};
	static protected ComparisonType getComparisonTypeFromPropertySearchString(String searchString)
	{
		ComparisonType compareType = ComparisonType.Contains;
		if (searchString.startsWith(" ") && searchString.endsWith(" "))
			compareType = ComparisonType.Contains;
		else if (searchString.startsWith(" "))
			compareType = ComparisonType.EndsWith;
		else if (searchString.endsWith(" "))
			compareType = ComparisonType.StartsWith;
		else
			compareType = ComparisonType.Equals;
		return compareType;
	}
	
	static protected boolean isPropertySearchStringAHit(String searchString, String compareString)
	{
		boolean hit = false;
		String searchStringLower = searchString.toLowerCase().trim();
		String compareStringLower = compareString.toLowerCase();
		ComparisonType compareType = getComparisonTypeFromPropertySearchString(searchString);
		switch(compareType)
		{
			case StartsWith:
				if (compareStringLower.startsWith(searchStringLower))
					hit = true;
				break;
			case EndsWith:
				if (compareStringLower.endsWith(searchStringLower))
					hit = true;
				break;
			case Contains:
				if (compareStringLower.contains(searchStringLower))
					hit = true;
				break;
			case Equals:
				if (compareStringLower.equalsIgnoreCase(searchStringLower))
					hit = true;
				break;
			default:
				hit = false;
				break;
		}
		return hit;
	}
	
	static public Map<String,String> propertyStringsFromRelDefines(IfcRelDefines relDefines,
			ArrayList<String> propertyNames)
	{

			Map<String,String> propertyMap = new HashMap<String,String>();
			if (IfcRelDefinesByProperties.class.isInstance(relDefines))
				propertyMap = propertyStringsFromRelDefinesByProperties
				((IfcRelDefinesByProperties)relDefines,propertyNames);
			else if (IfcRelDefinesByType.class.isInstance(relDefines))
				propertyMap = propertyStringsFromRelDefinesByType
				((IfcRelDefinesByType)relDefines,propertyNames);					
		return propertyMap;
	}
	
	static public Map<String,String> propertyStringsFromRelDefines(IfcRelDefines relDefines,
			ArrayList<String> propertyNames,boolean exclusive)
	{

			Map<String,String> propertyMap = new HashMap<String,String>();
			if (IfcRelDefinesByProperties.class.isInstance(relDefines))
				propertyMap = propertyStringsFromRelDefinesByProperties
				((IfcRelDefinesByProperties)relDefines,propertyNames,exclusive);
			else if (IfcRelDefinesByType.class.isInstance(relDefines))
				propertyMap = propertyStringsFromRelDefinesByType
				((IfcRelDefinesByType)relDefines,propertyNames,exclusive);					
		return propertyMap;
	}
	
	static public Map<String,IfcPropertyToCOBieString> psetStringsFromRelDefines(IfcRelDefines relDefines,
			ArrayList<String> propertyNames,boolean exclusive)
	{

			Map<String,IfcPropertyToCOBieString> propertyMap = new HashMap<String,IfcPropertyToCOBieString>();
			if (IfcRelDefinesByProperties.class.isInstance(relDefines))
				propertyMap = psetStringsFromRelDefinesByProperties
				((IfcRelDefinesByProperties)relDefines,propertyNames,exclusive);
			else if (IfcRelDefinesByType.class.isInstance(relDefines))
				propertyMap = psetStringsFromRelDefinesByType
				((IfcRelDefinesByType)relDefines,propertyNames,exclusive);					
		return propertyMap;
	}
	
	static private Map<String,String> propertyStringsFromRelDefinesByProperties
	(IfcRelDefinesByProperties relDefinesByProperties,
			ArrayList<String> propertyNames)
	{
		Map<String,String> propertyMap = new HashMap<String,String>();
		Map<String,String> tmpPropertyMap = new HashMap<String,String>();
		ArrayList<String> copyPNames = (ArrayList<String>) propertyNames.clone();
		IfcPropertySetDefinition pSetDef = relDefinesByProperties.getRelatingPropertyDefinition();
		if (IfcPropertySet.class.
				isInstance(pSetDef))
		{
			IfcPropertySet pSet = (IfcPropertySet) pSetDef;
			for(IfcProperty property : pSet.getHasProperties())
			{
				tmpPropertyMap = propertyStringsFromProperty(property,copyPNames);
				propertyMap = IfcRelationshipsToCOBie.mergePropertyStrings(tmpPropertyMap, propertyMap);
				copyPNames = IfcRelationshipsToCOBie.removeFoundPropertyStrings(copyPNames, propertyMap);
				
			}
		}
		else if (pSetDef instanceof IfcElementQuantity)
		{
			IfcElementQuantity elQ = (IfcElementQuantity) pSetDef;
			for(IfcPhysicalQuantity quantity : elQ.getQuantities())
			{
				tmpPropertyMap = propertyStringsFromPhysicalQuantity(quantity, copyPNames);
				propertyMap = IfcRelationshipsToCOBie.mergePropertyStrings(tmpPropertyMap, propertyMap);
				copyPNames = IfcRelationshipsToCOBie.removeFoundPropertyStrings(copyPNames, propertyMap);
			}
			
			
		}
		
		return propertyMap;
	}
	
	static private Map<String,String> propertyStringsFromRelDefinesByProperties
	(IfcRelDefinesByProperties relDefinesByProperties,
			ArrayList<String> propertyNames,boolean exclusive)
	{
		Map<String,String> propertyMap = new HashMap<String,String>();
		Map<String,String> tmpPropertyMap = new HashMap<String,String>();
		ArrayList<String> copyPNames = (ArrayList<String>) propertyNames.clone();
		IfcPropertySetDefinition pSetDef = relDefinesByProperties.getRelatingPropertyDefinition();
		if (IfcPropertySet.class.
				isInstance(pSetDef))
		{
			IfcPropertySet pSet = (IfcPropertySet) pSetDef;
			for(IfcProperty property : pSet.getHasProperties())
			{
				tmpPropertyMap = propertyStringsFromProperty(property,copyPNames,exclusive);
				propertyMap = IfcRelationshipsToCOBie.mergePropertyStrings(tmpPropertyMap, propertyMap);
				
			}
		}
		else if (pSetDef instanceof IfcElementQuantity)
		{
			IfcElementQuantity elQ = (IfcElementQuantity) pSetDef;
			for(IfcPhysicalQuantity quantity : elQ.getQuantities())
			{
				tmpPropertyMap = propertyStringsFromPhysicalQuantity(quantity, copyPNames,exclusive);
				propertyMap = IfcRelationshipsToCOBie.mergePropertyStrings(tmpPropertyMap, propertyMap);
			}
			
			
		}
		
		return propertyMap;
	}
	
	static private Map<String,IfcPropertyToCOBieString> psetStringsFromRelDefinesByProperties
	(IfcRelDefinesByProperties relDefinesByProperties,
			ArrayList<String> propertyNames,boolean exclusive)
	{
		Map<String,IfcPropertyToCOBieString> propertyMap = new HashMap<String,IfcPropertyToCOBieString>();
		Map<String,IfcPropertyToCOBieString> tmpPropertyMap = new HashMap<String,IfcPropertyToCOBieString>();
		ArrayList<String> copyPNames = (ArrayList<String>) propertyNames.clone();
		IfcPropertySetDefinition pSetDef = relDefinesByProperties.getRelatingPropertyDefinition();
		if (IfcPropertySet.class.
				isInstance(pSetDef))
		{
			IfcPropertySet pSet = (IfcPropertySet) pSetDef;
			for(IfcProperty property : pSet.getHasProperties())
			{
				tmpPropertyMap = psetStringsFromProperty(property,copyPNames,exclusive);
				propertyMap = IfcRelationshipsToCOBie.mergePsetStrings(tmpPropertyMap, propertyMap);			
			}
		}
		else if (pSetDef instanceof IfcElementQuantity)
		{
			IfcElementQuantity elQ = (IfcElementQuantity) pSetDef;
			for(IfcPhysicalQuantity quantity : elQ.getQuantities())
			{
				tmpPropertyMap = psetStringsFromPhysicalQuantity(quantity, copyPNames,exclusive);
				propertyMap = IfcRelationshipsToCOBie.mergePsetStrings(tmpPropertyMap, propertyMap);
			}
			
			
		}
		if (propertyMap.size()>0)
			propertyMap = IfcRelationshipsToCOBie.setPropertySetDataToPset(propertyMap, pSetDef);
		return propertyMap;
	}
	
	static private Map<String,String> propertyStringsFromPropertySetDefinition
	(IfcPropertySetDefinition pSetDef,
			ArrayList<String> propertyNames)
	{
		Map<String,String> propertyMap = new HashMap<String,String>();
		Map<String,String> tmpPropertyMap = new HashMap<String,String>();
		ArrayList<String> copyPNames = (ArrayList<String>) propertyNames.clone();
		if (pSetDef instanceof IfcPropertySet)
		{
			IfcPropertySet pSet = (IfcPropertySet) pSetDef;
			for(IfcProperty property : pSet.getHasProperties())
			{
				tmpPropertyMap = propertyStringsFromProperty(property,copyPNames);
				propertyMap = IfcRelationshipsToCOBie.mergePropertyStrings(tmpPropertyMap, propertyMap);
				copyPNames = IfcRelationshipsToCOBie.removeFoundPropertyStrings(copyPNames, propertyMap);
				
			}
		}
		else if (pSetDef instanceof IfcElementQuantity)
		{
			IfcElementQuantity elQ = (IfcElementQuantity) pSetDef;
			for(IfcPhysicalQuantity quantity : elQ.getQuantities())
			{
				tmpPropertyMap = propertyStringsFromPhysicalQuantity(quantity, copyPNames);
				propertyMap = IfcRelationshipsToCOBie.mergePropertyStrings(tmpPropertyMap, propertyMap);
				copyPNames = IfcRelationshipsToCOBie.removeFoundPropertyStrings(copyPNames, propertyMap);
			}
			
			
		}
		
		return propertyMap;
	}
	
	static private Map<String,String> propertyStringsFromPropertySetDefinition
	(IfcPropertySetDefinition pSetDef,
			ArrayList<String> propertyNames,boolean exclusive)
	{
		Map<String,String> propertyMap = new HashMap<String,String>();
		Map<String,String> tmpPropertyMap = new HashMap<String,String>();
		ArrayList<String> copyPNames = (ArrayList<String>) propertyNames.clone();
		if (IfcPropertySet.class.
				isInstance(pSetDef))
		{
			IfcPropertySet pSet = (IfcPropertySet) pSetDef;
			for(IfcProperty property : pSet.getHasProperties())
			{
				tmpPropertyMap = propertyStringsFromProperty(property,copyPNames,exclusive);
				propertyMap = IfcRelationshipsToCOBie.mergePropertyStrings(tmpPropertyMap, propertyMap);
				
			}
		}
		else if (pSetDef instanceof IfcElementQuantity)
		{
			IfcElementQuantity elQ = (IfcElementQuantity) pSetDef;
			for(IfcPhysicalQuantity quantity : elQ.getQuantities())
			{
				tmpPropertyMap = propertyStringsFromPhysicalQuantity(quantity, copyPNames,exclusive);
				propertyMap = IfcRelationshipsToCOBie.mergePropertyStrings(tmpPropertyMap, propertyMap);
			}
			
			
		}
		
		return propertyMap;
	}
	
	static private Map<String,IfcPropertyToCOBieString> psetStringsFromPropertySetDefinition
	(IfcPropertySetDefinition pSetDef,
			ArrayList<String> propertyNames,boolean exclusive)
	{
		Map<String,IfcPropertyToCOBieString> propertyMap = new HashMap<String,IfcPropertyToCOBieString>();
		Map<String,IfcPropertyToCOBieString> tmpPropertyMap = new HashMap<String,IfcPropertyToCOBieString>();
		ArrayList<String> copyPNames = (ArrayList<String>) propertyNames.clone();
		if (IfcPropertySet.class.
				isInstance(pSetDef))
		{
			IfcPropertySet pSet = (IfcPropertySet) pSetDef;
			for(IfcProperty property : pSet.getHasProperties())
			{
				tmpPropertyMap = psetStringsFromProperty(property,copyPNames,exclusive);
				propertyMap = IfcRelationshipsToCOBie.mergePsetStrings(tmpPropertyMap, propertyMap);
				
			}
		}
		else if (pSetDef instanceof IfcElementQuantity)
		{
			IfcElementQuantity elQ = (IfcElementQuantity) pSetDef;
			for(IfcPhysicalQuantity quantity : elQ.getQuantities())
			{
				tmpPropertyMap = psetStringsFromPhysicalQuantity(quantity, copyPNames,exclusive);
				propertyMap = IfcRelationshipsToCOBie.mergePsetStrings(tmpPropertyMap, propertyMap);
			}
			
			
		}
		propertyMap = setPropertySetDataToPset(propertyMap,pSetDef);
		return propertyMap;
	}
	
	static protected Map<String,IfcPropertyToCOBieString> setPropertySetDataToPset(Map<String,IfcPropertyToCOBieString> psetStrings, IfcPropertySetDefinition pSetDef)
	{
		Map<String,IfcPropertyToCOBieString> clonePsetStrings = IfcRelationshipsToCOBie.clonePsetStringMap(psetStrings);
		String pSetName = pSetDef.getName();
		String guid = pSetDef.getGlobalId().getWrappedValue();
		for(String key : clonePsetStrings.keySet())
		{
			IfcPropertyToCOBieString tmpPsetStr = clonePsetStrings.get(key);
			tmpPsetStr.setPropertySetString(pSetName);
			tmpPsetStr.setPropertySetGlobalIDString(guid);
			clonePsetStrings.put(key, tmpPsetStr);
		}
		return clonePsetStrings;
	}
	
	static public Map<String,String> propertyStringsFromPhysicalQuantity
	(IfcPhysicalQuantity quantity, ArrayList<String> propertyNames)
	{
		Map<String,String> propertyVals = new HashMap<String,String>();
		ArrayList<String> copyPropertyNames = (ArrayList<String>) propertyNames.clone();
		IfcPhysicalSimpleQuantity psq;
		IfcPhysicalComplexQuantity pcq;
		if (quantity instanceof IfcPhysicalComplexQuantity)
		{
			pcq = (IfcPhysicalComplexQuantity) quantity;
			for(IfcPhysicalQuantity pq : pcq.getHasQuantities())
			{
				propertyVals = propertyStringsFromPhysicalQuantity(pq,propertyNames);
			}
		}
		else if (quantity instanceof IfcPhysicalSimpleQuantity)
		{
			 psq = (IfcPhysicalSimpleQuantity) quantity;
			 psq.getClass();
			 String spName = psq.getName();
			 String keyMatchStr = "";
			 ArrayList<String> keyMatchStrings = new ArrayList<String>();
			 String valStr = "";
			 for(String searchP : copyPropertyNames)
			 {
				 if (spName.toLowerCase().contains(searchP.toLowerCase()))
				 {
					 keyMatchStr = searchP;
					 keyMatchStrings.add(keyMatchStr);
				 }
			 }		

			for (String ki : keyMatchStrings) 
			{
				valStr = stringFromIfcPhysicalSimpleQuantity(psq);
				propertyVals.put(ki, valStr);
				copyPropertyNames.remove(ki);
			}
			
		}
		return propertyVals;
	}
	
	static public Map<String,String> propertyStringsFromPhysicalQuantity
	(IfcPhysicalQuantity quantity, ArrayList<String> propertyNames,boolean exclusive)
	{
		boolean testProperty = false;
		Map<String,String> propertyVals = new HashMap<String,String>();
		ArrayList<String> copyPropertyNames = (ArrayList<String>) propertyNames.clone();
		IfcPhysicalSimpleQuantity psq;
		IfcPhysicalComplexQuantity pcq;
		if (quantity instanceof IfcPhysicalComplexQuantity)
		{
			pcq = (IfcPhysicalComplexQuantity) quantity;
			for(IfcPhysicalQuantity pq : pcq.getHasQuantities())
			{
				propertyVals = propertyStringsFromPhysicalQuantity(pq,propertyNames,exclusive);
			}
		}
		else if (quantity instanceof IfcPhysicalSimpleQuantity)
		{
			 psq = (IfcPhysicalSimpleQuantity) quantity;
			 psq.getClass();
			 String spName = psq.getName();
			 String keyMatchStr = "";
			 ArrayList<String> keyMatchStrings = new ArrayList<String>();
			 String valStr = "";
			 if (exclusive)
			 {
				 testProperty=true;
				 for(String searchP : copyPropertyNames)
				 {
					if(spName.toLowerCase().contains(searchP.toLowerCase()))
						testProperty=false;
				 }
				 if (testProperty)
					 keyMatchStrings.add(spName);
			 }
			 else
			 {
				 for(String searchP : copyPropertyNames)
				 {

					 testProperty = spName.toLowerCase().contains(searchP.toLowerCase());
					 keyMatchStr = searchP;
					 if (testProperty)
					 {
						 keyMatchStrings.add(keyMatchStr);
					 }
				 }		
			 }	

			for (String ki : keyMatchStrings) 
			{
				valStr = stringFromIfcPhysicalSimpleQuantity(psq);
				propertyVals.put(ki, valStr);
				copyPropertyNames.remove(ki);
			}
			
		}
		return propertyVals;
	}
	
	static public Map<String,String> propertyStringsFromFirstRelatedObject(IfcRelationship rel,ArrayList<String> propertyNames)
	{
		Map<String,String> propertyMap = new HashMap<String,String>();
		ArrayList<String> propertyNamesClone =
				(ArrayList<String>) propertyNames.clone();
		Map<String,String> tmpPropertyMap = new HashMap<String,String>();
		IfcObject firstInstance = firstRelatedObjectFromRelationship(rel);

		if (firstInstance != null) 
		{
			for (IfcRelDefines def : firstInstance.getIsDefinedBy()) {
				if (!(def instanceof IfcRelDefinesByType) && !(def==rel)) 
				{
					tmpPropertyMap = IfcRelationshipsToCOBie
							.propertyStringsFromRelDefines(def,
									propertyNamesClone);
					propertyMap = IfcRelationshipsToCOBie.mergePropertyStrings(
							tmpPropertyMap, propertyMap);
				}
			}
		}
		return propertyMap;
	}
	
	static public Map<String,IfcPropertyToCOBieString> psetStringsFromPhysicalQuantity
	(IfcPhysicalQuantity quantity, ArrayList<String> propertyNames,boolean exclusive)
	{
		boolean testProperty = false;
		Map<String,IfcPropertyToCOBieString> propertyVals = new HashMap<String,IfcPropertyToCOBieString>();
		ArrayList<String> copyPropertyNames = (ArrayList<String>) propertyNames.clone();
		IfcPhysicalSimpleQuantity psq;
		IfcPhysicalComplexQuantity pcq;
		if (quantity instanceof IfcPhysicalComplexQuantity)
		{
			pcq = (IfcPhysicalComplexQuantity) quantity;
			for(IfcPhysicalQuantity pq : pcq.getHasQuantities())
			{
				propertyVals = psetStringsFromPhysicalQuantity(pq,propertyNames,exclusive);
			}
		}
		else if (quantity instanceof IfcPhysicalSimpleQuantity)
		{
			 psq = (IfcPhysicalSimpleQuantity) quantity;
			 psq.getClass();
			 String spName = psq.getName();
			 String keyMatchStr = "";
			 ArrayList<String> keyMatchStrings = new ArrayList<String>();
			 IfcPhysicalQuantityToCOBieString valStr;
			 if (exclusive)
			 {
				 testProperty=true;
				 for(String searchP : copyPropertyNames)
				 {
					//if(spName.toLowerCase().contains(searchP.toLowerCase()))
					 if (isPropertySearchStringAHit(searchP,spName))
						testProperty=false;
				 }
				 if (testProperty)
					 keyMatchStrings.add(spName);
			 }
			 else
			 {
				 for(String searchP : copyPropertyNames)
				 {

					// testProperty = spName.toLowerCase().contains(searchP.toLowerCase());
					 testProperty = isPropertySearchStringAHit(searchP,spName);
					 keyMatchStr = searchP;
					 if (testProperty)
					 {
						 keyMatchStrings.add(keyMatchStr);
					 }
				 }		
			 }	

			for (String ki : keyMatchStrings) 
			{
				valStr = physicalQuantityStringFromIfcPhysicalSimpleQuantity(psq);
				propertyVals.put(ki, valStr);
				copyPropertyNames.remove(ki);
			}
			
		}
		return propertyVals;
	}
	

	
	static public Map<String,String> propertyStringsFromFirstRelatedObject
	(IfcRelationship rel,ArrayList<String> propertyNames,boolean exclusive)
	{
		Map<String,String> propertyMap = new HashMap<String,String>();
		ArrayList<String> propertyNamesClone =
				(ArrayList<String>) propertyNames.clone();
		Map<String,String> tmpPropertyMap = new HashMap<String,String>();
		IfcObject firstInstance = firstRelatedObjectFromRelationship(rel);

		if (firstInstance != null) 
		{
			for (IfcRelDefines def : firstInstance.getIsDefinedBy()) {
				if (!(def==rel)) 
				{
					tmpPropertyMap = IfcRelationshipsToCOBie
							.propertyStringsFromRelDefines(def,
									propertyNamesClone,exclusive);
					propertyMap = IfcRelationshipsToCOBie.mergePropertyStrings(
							tmpPropertyMap, propertyMap);
				}
			}
		}
		return propertyMap;
	}
	
	static public Map<String,IfcPropertyToCOBieString> psetStringsFromFirstRelatedObject
	(IfcRelationship rel,ArrayList<String> propertyNames,boolean exclusive)
	{
		Map<String,IfcPropertyToCOBieString> propertyMap = new HashMap<String,IfcPropertyToCOBieString>();
		ArrayList<String> propertyNamesClone =
				(ArrayList<String>) propertyNames.clone();
		Map<String,IfcPropertyToCOBieString> tmpPropertyMap = new HashMap<String,IfcPropertyToCOBieString>();
		IfcObject firstInstance = firstRelatedObjectFromRelationship(rel);

		if (firstInstance != null) 
		{
			for (IfcRelDefines def : firstInstance.getIsDefinedBy()) {
				if (!(def==rel)) 
				{
					tmpPropertyMap = IfcRelationshipsToCOBie
							.psetStringsFromRelDefines(def,
									propertyNamesClone,exclusive);
					propertyMap = IfcRelationshipsToCOBie.mergePsetStrings(
							tmpPropertyMap, propertyMap);
				}
			}
		}
		return propertyMap;
	}
	
	static public IfcObject firstRelatedObjectFromRelationship(IfcRelationship rel)
	{
		EList<IfcRoot> relatedRoots;
		EList<IfcObject> relatedObjects;
		EList<IfcObjectDefinition> relatedObjDef;
		IfcObject firstObject = null;
		if (rel instanceof IfcRelAssociates)
		{
			IfcRelAssociates relAssoc = (IfcRelAssociates) rel;
			relatedRoots = relAssoc.getRelatedObjects();
			for(IfcRoot root : relatedRoots)
			{
				if (root instanceof IfcObject && firstObject==null)
				{
					firstObject = (IfcObject) root;
				}
			}
			
		}
		else if (rel instanceof IfcRelDefines)
		{
			IfcRelDefines relDef = (IfcRelDefines) rel;
			relatedObjects = relDef.getRelatedObjects();
			for (IfcObject obj : relatedObjects)
				if (firstObject==null)
					firstObject = obj;
		}
		else if (rel instanceof IfcRelAssigns)
		{
			IfcRelAssigns relAssigns = (IfcRelAssigns) rel;
			relatedObjDef = relAssigns.getRelatedObjects();
			for (IfcObjectDefinition objDef : relatedObjDef)
				if (objDef instanceof IfcObject && firstObject==null)
					firstObject = (IfcObject) objDef;
		}
		
		return firstObject;
	}
	
	
	static private Map<String,String> propertyStringsFromRelDefinesByType
	(IfcRelDefinesByType relDefinesByType,
			ArrayList<String> propertyNames)
	{
		ArrayList<String> propertyNamesClone =
				(ArrayList<String>) propertyNames.clone();
		Map<String,String> propertyMap = new HashMap<String,String>();
		Map<String,String> tmpPropertyMap = new HashMap<String,String>();
		IfcTypeObject rType = relDefinesByType.getRelatingType();
		rType.getHasPropertySets();
		
		for(IfcPropertySetDefinition pSet : rType.getHasPropertySets())
		{
			tmpPropertyMap =
					propertyStringsFromPropertySetDefinition(pSet,propertyNamesClone);
			propertyMap = IfcRelationshipsToCOBie.mergePropertyStrings(tmpPropertyMap, propertyMap);
			propertyNamesClone = IfcRelationshipsToCOBie.removeFoundPropertyStrings(propertyNamesClone, propertyMap);
		}
		if (!propertyNamesClone.isEmpty())
		{
			
			tmpPropertyMap = IfcRelationshipsToCOBie.propertyStringsFromFirstRelatedObject(relDefinesByType, propertyNamesClone);
			propertyMap = IfcRelationshipsToCOBie.mergePropertyStrings(tmpPropertyMap, propertyMap);
//			if (firstInstance != null) {
//				for (IfcRelDefines def : firstInstance.getIsDefinedBy()) {
//					if (!(def instanceof IfcRelDefinesByType)) {
//						tmpPropertyMap = IfcRelationshipsToCOBie
//								.propertyStringsFromRelDefines(def,
//										propertyNamesClone);
//						propertyMap = IfcRelationshipsToCOBie.mergePropertyStrings(
//								tmpPropertyMap, propertyMap);
//						propertyNamesClone = IfcRelationshipsToCOBie
//								.removeFoundPropertyStrings(propertyNamesClone,
//										propertyMap);
//					}
//				}
//			}
		}
		
		return propertyMap;
	}
	
	static private Map<String,String> propertyStringsFromRelDefinesByType
	(IfcRelDefinesByType relDefinesByType,
			ArrayList<String> propertyNames,boolean exclusive)
	{
		ArrayList<String> propertyNamesClone =
				(ArrayList<String>) propertyNames.clone();
		Map<String,String> propertyMap = new HashMap<String,String>();
		Map<String,String> tmpPropertyMap = new HashMap<String,String>();
		IfcTypeObject rType = relDefinesByType.getRelatingType();
		EList<IfcPropertySetDefinition> pSets =
				rType.getHasPropertySets();
		for(IfcPropertySetDefinition pSet : pSets)
		{
			tmpPropertyMap =
					propertyStringsFromPropertySetDefinition(pSet,propertyNamesClone,exclusive);
			propertyMap = IfcRelationshipsToCOBie.mergePropertyStrings(tmpPropertyMap, propertyMap);
		}
		if (!propertyNamesClone.isEmpty())
		{
			
			//tmpPropertyMap = IfcRelationshipsToCOBie.propertyStringsFromFirstRelatedObject(relDefinesByType, propertyNamesClone,exclusive);
			propertyMap = IfcRelationshipsToCOBie.mergePropertyStrings(tmpPropertyMap, propertyMap);
//			if (firstInstance != null) {
//				for (IfcRelDefines def : firstInstance.getIsDefinedBy()) {
//					if (!(def instanceof IfcRelDefinesByType)) {
//						tmpPropertyMap = IfcRelationshipsToCOBie
//								.propertyStringsFromRelDefines(def,
//										propertyNamesClone);
//						propertyMap = IfcRelationshipsToCOBie.mergePropertyStrings(
//								tmpPropertyMap, propertyMap);
//						propertyNamesClone = IfcRelationshipsToCOBie
//								.removeFoundPropertyStrings(propertyNamesClone,
//										propertyMap);
//					}
//				}
//			}
		}
		
		return propertyMap;
	}
	
	static private Map<String,IfcPropertyToCOBieString> psetStringsFromRelDefinesByType
	(IfcRelDefinesByType relDefinesByType,
			ArrayList<String> propertyNames,boolean exclusive)
	{
		ArrayList<String> propertyNamesClone =
				(ArrayList<String>) propertyNames.clone();
		Map<String,IfcPropertyToCOBieString> propertyMap = new HashMap<String,IfcPropertyToCOBieString>();
		Map<String,IfcPropertyToCOBieString> tmpPropertyMap = new HashMap<String,IfcPropertyToCOBieString>();
		IfcTypeObject rType = relDefinesByType.getRelatingType();
		EList<IfcPropertySetDefinition> pSets =
				rType.getHasPropertySets();
		for(IfcPropertySetDefinition pSet : pSets)
		{
			try
			{
				tmpPropertyMap =
						psetStringsFromPropertySetDefinition(pSet,propertyNamesClone,exclusive);
				propertyMap = IfcRelationshipsToCOBie.mergePsetStrings(tmpPropertyMap, propertyMap);
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		if (!propertyNamesClone.isEmpty())
		{
			
			//tmpPropertyMap = IfcRelationshipsToCOBie.psetStringsFromFirstRelatedObject(relDefinesByType, propertyNamesClone,exclusive);
			propertyMap = IfcRelationshipsToCOBie.mergePsetStrings(tmpPropertyMap, propertyMap);
//			if (firstInstance != null) {
//				for (IfcRelDefines def : firstInstance.getIsDefinedBy()) {
//					if (!(def instanceof IfcRelDefinesByType)) {
//						tmpPropertyMap = IfcRelationshipsToCOBie
//								.propertyStringsFromRelDefines(def,
//										propertyNamesClone);
//						propertyMap = IfcRelationshipsToCOBie.mergePropertyStrings(
//								tmpPropertyMap, propertyMap);
//						propertyNamesClone = IfcRelationshipsToCOBie
//								.removeFoundPropertyStrings(propertyNamesClone,
//										propertyMap);
//					}
//				}
//			}
		}
		
		return propertyMap;
	}
	
	static public Map<String,String> propertyStringsFromTypeObject(IfcTypeObject rType, ArrayList<String> propertyNames)
	{
		
		ArrayList<String> propertyNamesClone =
				(ArrayList<String>) propertyNames.clone();
		Map<String,String> propertyMap = new HashMap<String,String>();
		Map<String,String> tmpPropertyMap = new HashMap<String,String>();
		EList<IfcPropertySetDefinition> pSets =
				rType.getHasPropertySets();
		EList<IfcRelDefinesByType> defByTypes =
				rType.getObjectTypeOf();
		if (!defByTypes.isEmpty())
		{
			IfcRelDefinesByType firstAssociation =
					defByTypes.get(0);
			propertyMap = IfcRelationshipsToCOBie.propertyStringsFromRelDefines(firstAssociation, propertyNamesClone);
		}
		else
		{
			for (IfcPropertySetDefinition pSet : pSets) {
				tmpPropertyMap = propertyStringsFromPropertySetDefinition(pSet,
						propertyNamesClone);
				propertyMap = IfcRelationshipsToCOBie.mergePropertyStrings(tmpPropertyMap,
						propertyMap);
				propertyNamesClone = IfcRelationshipsToCOBie.removeFoundPropertyStrings(
						propertyNamesClone, propertyMap);
			}
		}
		return propertyMap;
	}
	
	static public Map<String,String> propertyStringsFromTypeObject
	(IfcTypeObject rType, ArrayList<String> propertyNames,boolean exclusive)
	{
		ArrayList<String> propertyNamesClone =
				(ArrayList<String>) propertyNames.clone();
		Map<String,String> propertyMap = new HashMap<String,String>();
		Map<String,String> tmpPropertyMap = new HashMap<String,String>();
		EList<IfcPropertySetDefinition> pSets =
				rType.getHasPropertySets();
		EList<IfcRelDefinesByType> defByTypes =
				rType.getObjectTypeOf();
		if (!defByTypes.isEmpty())
		{
			IfcRelDefinesByType firstAssociation =
					defByTypes.get(0);
			propertyMap = IfcRelationshipsToCOBie.propertyStringsFromRelDefines(firstAssociation, propertyNamesClone,exclusive);
		}
		else
		{
			for (IfcPropertySetDefinition pSet : pSets) {
				tmpPropertyMap = propertyStringsFromPropertySetDefinition(pSet,
						propertyNamesClone,exclusive);
				propertyMap = IfcRelationshipsToCOBie.mergePropertyStrings(tmpPropertyMap,
						propertyMap);
			}
		}
		return propertyMap;
	}
	
	static public Map<String,IfcPropertyToCOBieString> psetStringsFromTypeObject
	(IfcTypeObject rType, ArrayList<String> propertyNames,boolean exclusive)
	{
		ArrayList<String> propertyNamesClone =
				(ArrayList<String>) propertyNames.clone();
		Map<String,IfcPropertyToCOBieString> propertyMap = new HashMap<String,IfcPropertyToCOBieString>();
		Map<String,IfcPropertyToCOBieString> tmpPropertyMap = new HashMap<String,IfcPropertyToCOBieString>();
		EList<IfcPropertySetDefinition> pSets =
				rType.getHasPropertySets();
		EList<IfcRelDefinesByType> defByTypes =
				rType.getObjectTypeOf();
		if (!defByTypes.isEmpty())
		{
			IfcRelDefinesByType firstAssociation =
					defByTypes.get(0);
			propertyMap = IfcRelationshipsToCOBie.psetStringsFromRelDefines(firstAssociation, propertyNamesClone,exclusive);
		}
		else
		{
			for (IfcPropertySetDefinition pSet : pSets) {
				tmpPropertyMap = psetStringsFromPropertySetDefinition(pSet,
						propertyNamesClone,exclusive);
				propertyMap = IfcRelationshipsToCOBie.mergePsetStrings(tmpPropertyMap,
						propertyMap);
			}
		}
		return propertyMap;
	}
	
	static private Map<String,String> propertyStringsFromProperty(IfcProperty property, 
			ArrayList<String> propertyNames)
	{
		Map<String,String> propertyVals = new HashMap<String,String>();
		ArrayList<String> copyPropertyNames = (ArrayList<String>) propertyNames.clone();
		IfcComplexProperty cProperty;
		IfcSimpleProperty sProperty;		
		if (IfcComplexProperty.class.isInstance(property))
		{
			cProperty = (IfcComplexProperty) property;
			for(IfcProperty cProp : cProperty.getHasProperties())
			{
				propertyVals = propertyStringsFromProperty(cProp,propertyNames);
			}
		}
		else if (IfcSimpleProperty.class.isInstance(property))
		{
			 sProperty = (IfcSimpleProperty) property;
			 sProperty.getClass();
			 String spName = sProperty.getName();
			 String keyMatchStr = "";
			 ArrayList<String> keyMatchStrings = new ArrayList<String>();
			 String valStr = "";
			 for(String searchP : copyPropertyNames)
			 {
				// if (spName.toLowerCase().contains(searchP.toLowerCase()))
				 if (isPropertySearchStringAHit(searchP,spName))
				 {
					 keyMatchStr = searchP;
					 keyMatchStrings.add(keyMatchStr);
				 }
			 }		

			for (String ki : keyMatchStrings) 
			{
				if (sProperty instanceof IfcPropertySingleValue) 
				{
					valStr = stringFromPropertySingleValue((IfcPropertySingleValue) sProperty);
					propertyVals.put(ki, valStr);
					copyPropertyNames.remove(ki);
				}
				if (sProperty instanceof IfcPropertyEnumeratedValue)
				{
					valStr = IfcRelationshipsToCOBie.stringFromPropertyEnumeratedValue
							((IfcPropertyEnumeratedValue)sProperty);
					propertyVals.put(ki, valStr);
					copyPropertyNames.remove(ki);
					
				}
			}
			
		}
		return propertyVals;
	}
	
	static private Map<String,String> propertyStringsFromProperty(IfcProperty property, 
			ArrayList<String> propertyNames,boolean exclusive)
	{
		boolean testProperty = false;
		Map<String,String> propertyVals = new HashMap<String,String>();
		ArrayList<String> copyPropertyNames = (ArrayList<String>) propertyNames.clone();
		IfcComplexProperty cProperty;
		IfcSimpleProperty sProperty;
		if (IfcComplexProperty.class.isInstance(property))
		{
			cProperty = (IfcComplexProperty) property;
			for(IfcProperty cProp : cProperty.getHasProperties())
			{
				propertyVals = propertyStringsFromProperty(cProp,propertyNames,exclusive);
			}
		}
		else if (IfcSimpleProperty.class.isInstance(property))
		{
			 sProperty = (IfcSimpleProperty) property;
			 sProperty.getClass();
			 String spName = sProperty.getName();
			 String keyMatchStr = "";
			 ArrayList<String> keyMatchStrings = new ArrayList<String>();
			 String valStr = "";
			 if (exclusive)
			 {
				 testProperty=true;
				 for(String searchP : copyPropertyNames)
				 {
						//if(spName.toLowerCase().contains(searchP.toLowerCase()))
					if (isPropertySearchStringAHit(searchP,spName))
						testProperty=false;
				 }
				 if (testProperty)
					 keyMatchStrings.add(spName);
			 }
			 else
			 {
				 for(String searchP : copyPropertyNames)
				 {

				//	 testProperty = spName.toLowerCase().contains(searchP.toLowerCase());
					 testProperty = isPropertySearchStringAHit(searchP,spName);
					 keyMatchStr = searchP;
					 if (testProperty)
					 {
						 keyMatchStrings.add(keyMatchStr);
					 }
				 }		
			 }
			 

			for (String ki : keyMatchStrings) 
			{
				if (IfcPropertySingleValue.class.isInstance(sProperty)) 
				{
					valStr = stringFromPropertySingleValue((IfcPropertySingleValue) sProperty);
					propertyVals.put(ki, valStr);
					copyPropertyNames.remove(ki);
				}
				if (sProperty instanceof IfcPropertyEnumeratedValue)
				{
					valStr = IfcRelationshipsToCOBie.stringFromPropertyEnumeratedValue
							((IfcPropertyEnumeratedValue)sProperty);
					propertyVals.put(ki, valStr);
					copyPropertyNames.remove(ki);
				}
			}
			
		}
		return propertyVals;
	}
	
	static private Map<String,IfcPropertyToCOBieString> psetStringsFromProperty(IfcProperty property, 
			ArrayList<String> propertyNames,boolean exclusive)
	{
		boolean testProperty = false;
		Map<String,IfcPropertyToCOBieString> propertyVals = new HashMap<String,IfcPropertyToCOBieString>();
		ArrayList<String> copyPropertyNames = (ArrayList<String>) propertyNames.clone();
		IfcComplexProperty cProperty;
		IfcSimpleProperty sProperty;
		if (IfcComplexProperty.class.isInstance(property))
		{
			cProperty = (IfcComplexProperty) property;
			for(IfcProperty cProp : cProperty.getHasProperties())
			{
				propertyVals = psetStringsFromProperty(cProp,propertyNames,exclusive);
			}
		}
		else if (IfcSimpleProperty.class.isInstance(property))
		{
			 sProperty = (IfcSimpleProperty) property;
			 sProperty.getClass();
			 String spName = sProperty.getName();
			 String keyMatchStr = "";
			 ArrayList<String> keyMatchStrings = new ArrayList<String>();
			 if (exclusive)
			 {
				 testProperty=true;
				 for(String searchP : copyPropertyNames)
				 {
					//if(spName.toLowerCase().contains(searchP.toLowerCase()))
					 if (isPropertySearchStringAHit(searchP,spName))
						testProperty=false;
				 }
				 if (testProperty)
					 keyMatchStrings.add(spName);
			 }
			 else
			 {
				 for(String searchP : copyPropertyNames)
				 {

					// testProperty = spName.toLowerCase().contains(searchP.toLowerCase());
					 testProperty = isPropertySearchStringAHit(searchP,spName);
					 keyMatchStr = searchP;
					 if (testProperty)
					 {
						 keyMatchStrings.add(keyMatchStr);
					 }
				 }		
			 }
			 

			for (String ki : keyMatchStrings) 
			{
				if (IfcPropertySingleValue.class.isInstance(sProperty)) 
				{
					IfcSingleValueToCOBieString svStr =
							IfcRelationshipsToCOBie.psetSingleValueStringFromPropertySingleValue((IfcPropertySingleValue)sProperty);
					propertyVals.put(ki, svStr);
					copyPropertyNames.remove(ki);
				}
				if (sProperty instanceof IfcPropertyEnumeratedValue)
				{
					IfcEnumeratedValueToCOBieString enStr =
							IfcRelationshipsToCOBie.psetEnumeratedValueStringFromEnumeratedValue((IfcPropertyEnumeratedValue)sProperty);
					
					propertyVals.put(ki, enStr);
					copyPropertyNames.remove(ki);
				}
			}
			
		}
		return propertyVals;
	}

	static private String stringFromIfcPhysicalSimpleQuantity(IfcPhysicalSimpleQuantity simpleQ)
	{
		IfcPhysicalQuantityToCOBieString pStr =
				new IfcPhysicalQuantityToCOBieString(simpleQ);
		return pStr.getValueString();
	}
	
	static private IfcPhysicalQuantityToCOBieString physicalQuantityStringFromIfcPhysicalSimpleQuantity(IfcPhysicalSimpleQuantity simpleQ)
	{
		IfcPhysicalQuantityToCOBieString pStr =
				new IfcPhysicalQuantityToCOBieString(simpleQ);
		return pStr;
	}
	
	static private String stringFromPropertySingleValue(IfcPropertySingleValue singleValue)
	{
		IfcSingleValueToCOBieString sValStr =
				new IfcSingleValueToCOBieString(singleValue);
		return sValStr.getValueString();
	}
	
	static private IfcSingleValueToCOBieString psetSingleValueStringFromPropertySingleValue(IfcPropertySingleValue singleValue)
	{
		IfcSingleValueToCOBieString sValStr =
				new IfcSingleValueToCOBieString(singleValue);
		return sValStr;
	}
	
	static private String stringFromPropertyEnumeratedValue(IfcPropertyEnumeratedValue enumVal)
	{
		IfcEnumeratedValueToCOBieString enumStr =
				IfcRelationshipsToCOBie.psetEnumeratedValueStringFromEnumeratedValue(enumVal);
		return enumStr.getValueString();
	}
	static private IfcEnumeratedValueToCOBieString psetEnumeratedValueStringFromEnumeratedValue(IfcPropertyEnumeratedValue enumVal)
	{
		IfcEnumeratedValueToCOBieString enumStr =
				new IfcEnumeratedValueToCOBieString(enumVal);
		return enumStr;
	}
	
	static public Map<String,String> mergePropertyStrings(Map<String,String> tmpPropertyMap, Map<String,String> propertyMap)
	{
		Map<String,String> clonePMap = clonePropertyMap(propertyMap);
		String tmpVal1="";
		String tmpVal2="";
		if (!tmpPropertyMap.isEmpty())
		{
			for(String key : tmpPropertyMap.keySet())
			{
				tmpVal1 = tmpPropertyMap.get(key);
				if (tmpVal1 != null && !tmpVal1.isEmpty())
				{
					if (tmpVal1.equalsIgnoreCase(key))
						tmpVal1 = "";
					if (clonePMap.keySet().contains(key))
					{
						tmpVal2 = clonePMap.get(key);
						if (!tmpVal2.equalsIgnoreCase(tmpVal1))
							clonePMap.put(key,tmpVal2+","+tmpVal1);
					}
					else
						clonePMap.put(key, tmpVal1);
				}
			}
		}
		return clonePMap;
	}
	
	static public Map<String,IfcPropertyToCOBieString> mergePsetStrings(Map<String,IfcPropertyToCOBieString> tmpPropertyMap, Map<String,IfcPropertyToCOBieString> propertyMap)
	{
		Map<String,IfcPropertyToCOBieString> clonePMap = clonePsetStringMap(propertyMap);
		IfcPropertyToCOBieString tmpVal1;
		IfcPropertyToCOBieString tmpVal2;
		int idx = 2;
		if (!tmpPropertyMap.isEmpty())
		{
			for(String key : tmpPropertyMap.keySet())
			{
				tmpVal1 = tmpPropertyMap.get(key);
				if (tmpVal1 != null && !tmpVal1.getValueString().isEmpty())
				{
					if (clonePMap.keySet().contains(key))
					{
						tmpVal2 = clonePMap.get(key);
						String tmpKey = key + String.valueOf(idx);
						idx++;
						clonePMap.put(tmpKey,tmpVal2);
					}
					else
						clonePMap.put(key, tmpVal1);
				}
			}
		}
		return clonePMap;
	}
	
	static private ArrayList<String> removeFoundPropertyStrings(ArrayList<String> propertyStrings, Map<String,String> propertyMap)
	{
		ArrayList<String> propertyNamesClone = (ArrayList<String>) propertyStrings.clone();
		/*for(String key : propertyMap.keySet())
		{

				propertyNamesClone.remove(key);
		}*/
		return propertyNamesClone;		
	}
	
	static private Map<String,String> clonePropertyMap(Map<String,String> propertyMap)
	{
		Map<String,String> clone = new HashMap<String,String>();
		for(String key : propertyMap.keySet())
			clone.put(key, propertyMap.get(key));
		return clone;
	}
	
	static private Map<String,IfcPropertyToCOBieString> clonePsetStringMap(Map<String,IfcPropertyToCOBieString> propertyMap)
	{
		Map<String,IfcPropertyToCOBieString> clone = new HashMap<String,IfcPropertyToCOBieString>();
		for(String key : propertyMap.keySet())
			clone.put(key, propertyMap.get(key));
		return clone;
	}

}
