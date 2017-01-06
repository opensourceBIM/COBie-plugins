package org.bimserver.cobie.shared.utility.ifc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.bimserver.cobie.shared.serialization.util.IfcPropertyStringTransformer;
import org.bimserver.models.ifc2x3tc1.IfcElementQuantity;
import org.bimserver.models.ifc2x3tc1.IfcPhysicalQuantity;
import org.bimserver.models.ifc2x3tc1.IfcProperty;
import org.bimserver.models.ifc2x3tc1.IfcPropertySet;
import org.bimserver.models.ifc2x3tc1.IfcPropertySetDefinition;

public class IfcPropertySetToCOBieString
{

    static private Map<String, IfcPropertyStringTransformer> clonePsetStringMap(Map<String, IfcPropertyStringTransformer> propertyMap)
    {
        Map<String, IfcPropertyStringTransformer> clone = new HashMap<String, IfcPropertyStringTransformer>();
        for (String key : propertyMap.keySet())
        {
            clone.put(key, propertyMap.get(key));
        }
        return clone;
    }

    static public Map<String, IfcPropertyStringTransformer> mergePsetStrings(
            Map<String, IfcPropertyStringTransformer> tmpPropertyMap,
            Map<String, IfcPropertyStringTransformer> propertyMap)
    {
        Map<String, IfcPropertyStringTransformer> clonePMap = clonePsetStringMap(propertyMap);
        IfcPropertyStringTransformer tmpVal1;
        IfcPropertyStringTransformer tmpVal2;
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

    static public Map<String, IfcPropertyStringTransformer> mergePsetStringsAllowNA(
            Map<String, IfcPropertyStringTransformer> tmpPropertyMap,
            Map<String, IfcPropertyStringTransformer> propertyMap)
    {
        Map<String, IfcPropertyStringTransformer> clonePMap = clonePsetStringMap(propertyMap);
        IfcPropertyStringTransformer tmpVal1;
        IfcPropertyStringTransformer tmpVal2;
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
                tmpPropertyMap = IfcPropertyStringTransformer.propertyStringsFromProperty(property, copyPNames);
                propertyMap = IfcPropertyStringTransformer.mergePropertyStrings(tmpPropertyMap, propertyMap);

            }
        } else if (pSetDef instanceof IfcElementQuantity)
        {
            IfcElementQuantity elQ = (IfcElementQuantity)pSetDef;
            for (IfcPhysicalQuantity quantity : elQ.getQuantities())
            {
                tmpPropertyMap = IfcPropertyStringTransformer.propertyStringsFromPhysicalQuantity(quantity, copyPNames);
                propertyMap = IfcPropertyStringTransformer.mergePropertyStrings(tmpPropertyMap, propertyMap);
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
                tmpPropertyMap = IfcPropertyStringTransformer.propertyStringsFromProperty(property, copyPNames, exclusive);
                propertyMap = IfcPropertyStringTransformer.mergePropertyStrings(tmpPropertyMap, propertyMap);

            }
        } else if (pSetDef instanceof IfcElementQuantity)
        {
            IfcElementQuantity elQ = (IfcElementQuantity)pSetDef;
            for (IfcPhysicalQuantity quantity : elQ.getQuantities())
            {
                tmpPropertyMap = IfcPropertyStringTransformer.propertyStringsFromPhysicalQuantity(quantity, copyPNames, exclusive);
                propertyMap = IfcPropertyStringTransformer.mergePropertyStrings(tmpPropertyMap, propertyMap);
            }

        }

        return propertyMap;
    }

    static Map<String, IfcPropertyStringTransformer> psetStringsFromPropertySetDefinition(
            IfcPropertySetDefinition pSetDef,
            ArrayList<String> propertyNames,
            boolean exclusive)
    {
        Map<String, IfcPropertyStringTransformer> propertyMap = new HashMap<String, IfcPropertyStringTransformer>();
        Map<String, IfcPropertyStringTransformer> tmpPropertyMap = new HashMap<String, IfcPropertyStringTransformer>();
        @SuppressWarnings("unchecked")
        ArrayList<String> copyPNames = (ArrayList<String>)propertyNames.clone();
        if (IfcPropertySet.class.isInstance(pSetDef))
        {
            IfcPropertySet pSet = (IfcPropertySet)pSetDef;
            for (IfcProperty property : pSet.getHasProperties())
            {
                tmpPropertyMap = IfcPropertyStringTransformer.psetStringsFromProperty(property, copyPNames, exclusive);
                propertyMap = IfcPropertySetToCOBieString.mergePsetStrings(tmpPropertyMap, propertyMap);

            }
        } else if (pSetDef instanceof IfcElementQuantity)
        {
            IfcElementQuantity elQ = (IfcElementQuantity)pSetDef;
            for (IfcPhysicalQuantity quantity : elQ.getQuantities())
            {
                tmpPropertyMap = IfcPropertyStringTransformer.psetStringsFromPhysicalQuantity(quantity, copyPNames, exclusive);
                propertyMap = IfcPropertySetToCOBieString.mergePsetStrings(tmpPropertyMap, propertyMap);
            }

        }
        propertyMap = setPropertySetDataToPset(propertyMap, pSetDef);
        return propertyMap;
    }

    static protected Map<String, IfcPropertyStringTransformer> setPropertySetDataToPset(
            Map<String, IfcPropertyStringTransformer> psetStrings,
            IfcPropertySetDefinition pSetDef)
    {
        Map<String, IfcPropertyStringTransformer> clonePsetStrings = IfcPropertySetToCOBieString.clonePsetStringMap(psetStrings);
        String pSetName = pSetDef.getName();
        String guid = pSetDef.getGlobalId();
        for (String key : clonePsetStrings.keySet())
        {
            IfcPropertyStringTransformer tmpPsetStr = clonePsetStrings.get(key);
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
