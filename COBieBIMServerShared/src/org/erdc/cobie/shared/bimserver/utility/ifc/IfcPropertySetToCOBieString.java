package org.erdc.cobie.shared.bimserver.utility.ifc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.bimserver.models.ifc2x3tc1.IfcElementQuantity;
import org.bimserver.models.ifc2x3tc1.IfcPhysicalQuantity;
import org.bimserver.models.ifc2x3tc1.IfcProperty;
import org.bimserver.models.ifc2x3tc1.IfcPropertySet;
import org.bimserver.models.ifc2x3tc1.IfcPropertySetDefinition;
import org.erdc.cobie.shared.bimserver.ifc.serialization.cobietab.IfcPropertyToCOBieString;

public class IfcPropertySetToCOBieString
{

    static private Map<String, IfcPropertyToCOBieString> clonePsetStringMap(Map<String, IfcPropertyToCOBieString> propertyMap)
    {
        Map<String, IfcPropertyToCOBieString> clone = new HashMap<String, IfcPropertyToCOBieString>();
        for (String key : propertyMap.keySet())
        {
            clone.put(key, propertyMap.get(key));
        }
        return clone;
    }

    static public Map<String, IfcPropertyToCOBieString> mergePsetStrings(
            Map<String, IfcPropertyToCOBieString> tmpPropertyMap,
            Map<String, IfcPropertyToCOBieString> propertyMap)
    {
        Map<String, IfcPropertyToCOBieString> clonePMap = clonePsetStringMap(propertyMap);
        IfcPropertyToCOBieString tmpVal1;
        IfcPropertyToCOBieString tmpVal2;
        int idx = 2;
        if (!tmpPropertyMap.isEmpty())
        {
            for (String key : tmpPropertyMap.keySet())
            {
                tmpVal1 = tmpPropertyMap.get(key);
                if (tmpVal1 != null)
                {
                    if (clonePMap.keySet().contains(key))
                    {
                        tmpVal2 = clonePMap.get(key);
                        String tmpKey = key + String.valueOf(idx);
                        idx++;
                        clonePMap.put(tmpKey, tmpVal2);
                    } else
                    {
                        clonePMap.put(key, tmpVal1);
                    }
                }
            }
        }
        return clonePMap;
    }

    static public Map<String, IfcPropertyToCOBieString> mergePsetStringsAllowNA(
            Map<String, IfcPropertyToCOBieString> tmpPropertyMap,
            Map<String, IfcPropertyToCOBieString> propertyMap)
    {
        Map<String, IfcPropertyToCOBieString> clonePMap = clonePsetStringMap(propertyMap);
        IfcPropertyToCOBieString tmpVal1;
        IfcPropertyToCOBieString tmpVal2;
        int idx = 2;
        if (!tmpPropertyMap.isEmpty())
        {
            for (String key : tmpPropertyMap.keySet())
            {
                tmpVal1 = tmpPropertyMap.get(key);

                if (clonePMap.keySet().contains(key))
                {
                    tmpVal2 = clonePMap.get(key);
                    String tmpKey = key + String.valueOf(idx);
                    idx++;
                    clonePMap.put(tmpKey, tmpVal2);
                } else
                {
                    clonePMap.put(key, tmpVal1);
                }

            }
        }
        return clonePMap;
    }

    static Map<String, String> propertyStringsFromPropertySetDefinition(IfcPropertySetDefinition pSetDef, ArrayList<String> propertyNames)
    {
        Map<String, String> propertyMap = new HashMap<String, String>();
        Map<String, String> tmpPropertyMap = new HashMap<String, String>();
        @SuppressWarnings("unchecked")
        ArrayList<String> copyPNames = (ArrayList<String>)propertyNames.clone();
        if (pSetDef instanceof IfcPropertySet)
        {
            IfcPropertySet pSet = (IfcPropertySet)pSetDef;
            for (IfcProperty property : pSet.getHasProperties())
            {
                tmpPropertyMap = IfcPropertyToCOBieString.propertyStringsFromProperty(property, copyPNames);
                propertyMap = IfcPropertyToCOBieString.mergePropertyStrings(tmpPropertyMap, propertyMap);

            }
        } else if (pSetDef instanceof IfcElementQuantity)
        {
            IfcElementQuantity elQ = (IfcElementQuantity)pSetDef;
            for (IfcPhysicalQuantity quantity : elQ.getQuantities())
            {
                tmpPropertyMap = IfcPropertyToCOBieString.propertyStringsFromPhysicalQuantity(quantity, copyPNames);
                propertyMap = IfcPropertyToCOBieString.mergePropertyStrings(tmpPropertyMap, propertyMap);
            }

        }

        return propertyMap;
    }

    static Map<String, String> propertyStringsFromPropertySetDefinition(
            IfcPropertySetDefinition pSetDef,
            ArrayList<String> propertyNames,
            boolean exclusive)
    {
        Map<String, String> propertyMap = new HashMap<String, String>();
        Map<String, String> tmpPropertyMap = new HashMap<String, String>();
        @SuppressWarnings("unchecked")
        ArrayList<String> copyPNames = (ArrayList<String>)propertyNames.clone();
        if (IfcPropertySet.class.isInstance(pSetDef))
        {
            IfcPropertySet pSet = (IfcPropertySet)pSetDef;
            for (IfcProperty property : pSet.getHasProperties())
            {
                tmpPropertyMap = IfcPropertyToCOBieString.propertyStringsFromProperty(property, copyPNames, exclusive);
                propertyMap = IfcPropertyToCOBieString.mergePropertyStrings(tmpPropertyMap, propertyMap);

            }
        } else if (pSetDef instanceof IfcElementQuantity)
        {
            IfcElementQuantity elQ = (IfcElementQuantity)pSetDef;
            for (IfcPhysicalQuantity quantity : elQ.getQuantities())
            {
                tmpPropertyMap = IfcPropertyToCOBieString.propertyStringsFromPhysicalQuantity(quantity, copyPNames, exclusive);
                propertyMap = IfcPropertyToCOBieString.mergePropertyStrings(tmpPropertyMap, propertyMap);
            }

        }

        return propertyMap;
    }

    static Map<String, IfcPropertyToCOBieString> psetStringsFromPropertySetDefinition(
            IfcPropertySetDefinition pSetDef,
            ArrayList<String> propertyNames,
            boolean exclusive)
    {
        Map<String, IfcPropertyToCOBieString> propertyMap = new HashMap<String, IfcPropertyToCOBieString>();
        Map<String, IfcPropertyToCOBieString> tmpPropertyMap = new HashMap<String, IfcPropertyToCOBieString>();
        @SuppressWarnings("unchecked")
        ArrayList<String> copyPNames = (ArrayList<String>)propertyNames.clone();
        if (IfcPropertySet.class.isInstance(pSetDef))
        {
            IfcPropertySet pSet = (IfcPropertySet)pSetDef;
            for (IfcProperty property : pSet.getHasProperties())
            {
                tmpPropertyMap = IfcPropertyToCOBieString.psetStringsFromProperty(property, copyPNames, exclusive);
                propertyMap = IfcPropertySetToCOBieString.mergePsetStrings(tmpPropertyMap, propertyMap);

            }
        } else if (pSetDef instanceof IfcElementQuantity)
        {
            IfcElementQuantity elQ = (IfcElementQuantity)pSetDef;
            for (IfcPhysicalQuantity quantity : elQ.getQuantities())
            {
                tmpPropertyMap = IfcPropertyToCOBieString.psetStringsFromPhysicalQuantity(quantity, copyPNames, exclusive);
                propertyMap = IfcPropertySetToCOBieString.mergePsetStrings(tmpPropertyMap, propertyMap);
            }

        }
        propertyMap = setPropertySetDataToPset(propertyMap, pSetDef);
        return propertyMap;
    }

    static protected Map<String, IfcPropertyToCOBieString> setPropertySetDataToPset(
            Map<String, IfcPropertyToCOBieString> psetStrings,
            IfcPropertySetDefinition pSetDef)
    {
        Map<String, IfcPropertyToCOBieString> clonePsetStrings = IfcPropertySetToCOBieString.clonePsetStringMap(psetStrings);
        String pSetName = pSetDef.getName();
        String guid = pSetDef.getGlobalId();
        for (String key : clonePsetStrings.keySet())
        {
            IfcPropertyToCOBieString tmpPsetStr = clonePsetStrings.get(key);
            tmpPsetStr.setPropertySetString(pSetName);
            tmpPsetStr.setPropertySetGlobalIDString(guid);
            tmpPsetStr.setAttachedOwnerHistory(pSetDef.getOwnerHistory());
            if (pSetDef instanceof IfcPropertySet)
            {
                tmpPsetStr.setPropertySet((IfcPropertySet)pSetDef);
            }
            clonePsetStrings.put(key, tmpPsetStr);
        }
        return clonePsetStrings;
    }

}
