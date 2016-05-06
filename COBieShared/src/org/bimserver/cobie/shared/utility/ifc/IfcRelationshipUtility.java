package org.bimserver.cobie.shared.utility.ifc;

/******************************************************************************

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
import java.util.List;
import java.util.Map;

import org.bimserver.cobie.shared.serialization.util.IfcPropertyStringTransformer;
import org.bimserver.cobie.shared.utility.COBieIfcUtility;
import org.bimserver.cobie.shared.utility.COBieUtility;
import org.bimserver.models.ifc2x3tc1.IfcElementQuantity;
import org.bimserver.models.ifc2x3tc1.IfcObject;
import org.bimserver.models.ifc2x3tc1.IfcObjectDefinition;
import org.bimserver.models.ifc2x3tc1.IfcPhysicalQuantity;
import org.bimserver.models.ifc2x3tc1.IfcProperty;
import org.bimserver.models.ifc2x3tc1.IfcPropertySet;
import org.bimserver.models.ifc2x3tc1.IfcPropertySetDefinition;
import org.bimserver.models.ifc2x3tc1.IfcRelAssigns;
import org.bimserver.models.ifc2x3tc1.IfcRelAssociates;
import org.bimserver.models.ifc2x3tc1.IfcRelDefines;
import org.bimserver.models.ifc2x3tc1.IfcRelDefinesByProperties;
import org.bimserver.models.ifc2x3tc1.IfcRelDefinesByType;
import org.bimserver.models.ifc2x3tc1.IfcRelationship;
import org.bimserver.models.ifc2x3tc1.IfcRoot;
import org.bimserver.models.ifc2x3tc1.IfcTypeObject;
import org.eclipse.emf.common.util.EList;

public class IfcRelationshipUtility
{
    public static enum ComparisonType
    {
        Contains, EndsWith, Equals, StartsWith
    }

    private static final String SPACE_DELIM = " ";;

    public static Map<String, String> clonePropertyMap(Map<String, String> propertyMap)
    {
        Map<String, String> clone = new HashMap<String, String>();
        for (String key : propertyMap.keySet())
        {
            clone.put(key, propertyMap.get(key));
        }
        return clone;
    }

    static public IfcObject firstRelatedObjectFromRelationship(IfcRelationship rel)
    {
        EList<IfcRoot> relatedRoots;
        EList<IfcObject> relatedObjects;
        EList<IfcObjectDefinition> relatedObjDef;
        IfcObject firstObject = null;
        if (rel instanceof IfcRelAssociates)
        {
            IfcRelAssociates relAssoc = (IfcRelAssociates)rel;
            relatedRoots = relAssoc.getRelatedObjects();
            for (IfcRoot root : relatedRoots)
            {
                if ((root instanceof IfcObject) && (firstObject == null))
                {
                    firstObject = (IfcObject)root;
                }
            }

        } else if (rel instanceof IfcRelDefines)
        {
            IfcRelDefines relDef = (IfcRelDefines)rel;
            relatedObjects = relDef.getRelatedObjects();
            for (IfcObject obj : relatedObjects)
            {
                if (firstObject == null)
                {
                    firstObject = obj;
                }
            }
        } else if (rel instanceof IfcRelAssigns)
        {
            IfcRelAssigns relAssigns = (IfcRelAssigns)rel;
            relatedObjDef = relAssigns.getRelatedObjects();
            for (IfcObjectDefinition objDef : relatedObjDef)
            {
                if ((objDef instanceof IfcObject) && (firstObject == null))
                {
                    firstObject = (IfcObject)objDef;
                }
            }
        }

        return firstObject;
    }

    static public ComparisonType getComparisonTypeFromPropertySearchString(String searchString)
    {
        ComparisonType compareType = ComparisonType.Contains;
        if (searchString.startsWith(SPACE_DELIM) && searchString.endsWith(SPACE_DELIM))
        {
            compareType = ComparisonType.Contains;
        } else if (searchString.startsWith(SPACE_DELIM))
        {
            compareType = ComparisonType.EndsWith;
        } else if (searchString.endsWith(SPACE_DELIM))
        {
            compareType = ComparisonType.StartsWith;
        } else
        {
            compareType = ComparisonType.Equals;
        }
        return compareType;
    }

    public static String getHighestRankingPropertyStringFromPropertySets(
            EList<IfcPropertySetDefinition> propertySets,
            ArrayList<String> prioritizedSearchStrings)
    {
        String highestRankingSearchHit = "";
        int searchRank = -1;
        for (IfcPropertySetDefinition propertySetDefinition : propertySets)
        {

            Map<String, String> searchHitMap = IfcRelationshipUtility.stringMapFromPropertySetDefinition(prioritizedSearchStrings,
                    propertySetDefinition);
            String tmpHit = COBieUtility.cobieStringFromStringMap(searchHitMap, prioritizedSearchStrings);
            int previousRank = searchRank;
            if (!COBieUtility.isNA(tmpHit))
            {
                searchRank = COBieUtility.cobieStringRankingFromStringMap(searchHitMap, prioritizedSearchStrings);
            }
            if (searchRank > previousRank)
            {
                highestRankingSearchHit = tmpHit;
            }

        }
        return highestRankingSearchHit;
    }

    public static String getHighestRankingPropertyStringFromRelDefinesList(
            EList<IfcRelDefines> relDefinesList,
            ArrayList<String> prioritizedSearchStrings,
            boolean includeRelDefinesByType)
    {
        String highestRankingSearchHit = "";
        int searchRank = -1;
        for (IfcRelDefines def : relDefinesList)
        {
            if (((def instanceof IfcRelDefinesByType) && includeRelDefinesByType) || !(def instanceof IfcRelDefinesByType))
            {
                Map<String, String> searchHitMap = IfcRelationshipUtility.propertyStringsFromRelDefines(def, prioritizedSearchStrings);
                String tmpHit = COBieUtility.cobieStringFromStringMap(searchHitMap, prioritizedSearchStrings);
                int previousRank = searchRank;
                if (!COBieUtility.isNA(tmpHit))
                {
                    searchRank = COBieUtility.cobieStringRankingFromStringMap(searchHitMap, prioritizedSearchStrings);
                }
                if (searchRank > previousRank)
                {
                    highestRankingSearchHit = tmpHit;
                }
            }

        }
        return highestRankingSearchHit;
    }

    public static IfcPropertyStringTransformer getHighestRankingPsetStringFromRelDefinesList(
            EList<IfcRelDefines> relDefinesList,
            ArrayList<String> prioritizedSearchStrings,
            boolean excludeNAValues)
    {
        IfcPropertyStringTransformer highestRankingSearchHit = null;
        int searchRank = -1;
        for (IfcRelDefines def : relDefinesList)
        {
            Map<String, IfcPropertyStringTransformer> searchHitMap = IfcRelationshipUtility.psetStringsFromRelDefines(def, prioritizedSearchStrings,
                    false);
            IfcPropertyStringTransformer tmpHit = COBieIfcUtility.cobiePsetStringFromStringMap(searchHitMap, prioritizedSearchStrings);
            int previousRank = searchRank;
            if (excludeNAValues)
            {
                if (!COBieUtility.isNA(tmpHit.getValueString()))
                {
                    searchRank = COBieIfcUtility.cobiePsetStringRankingFromStringMap(searchHitMap, prioritizedSearchStrings);
                }
            } else
            {
                searchRank = COBieIfcUtility.cobiePsetStringRankingFromStringMap(searchHitMap, prioritizedSearchStrings);
            }

            if (searchRank > previousRank)
            {
                highestRankingSearchHit = tmpHit;
            }
        }
        return highestRankingSearchHit;
    }

    static public Map<String, String> propertyStringsFromFirstRelatedObject(IfcRelationship rel, ArrayList<String> propertyNames)
    {
        Map<String, String> propertyMap = new HashMap<String, String>();
        @SuppressWarnings("unchecked")
        ArrayList<String> propertyNamesClone = (ArrayList<String>)propertyNames.clone();
        Map<String, String> tmpPropertyMap = new HashMap<String, String>();
        IfcObject firstInstance = firstRelatedObjectFromRelationship(rel);

        if (firstInstance != null)
        {
            for (IfcRelDefines def : firstInstance.getIsDefinedBy())
            {
                if (!(def instanceof IfcRelDefinesByType) && !(def == rel))
                {
                    tmpPropertyMap = IfcRelationshipUtility.propertyStringsFromRelDefines(def, propertyNamesClone);
                    propertyMap = IfcPropertyStringTransformer.mergePropertyStrings(tmpPropertyMap, propertyMap);
                }
            }
        }
        return propertyMap;
    }

    static public Map<String, String> propertyStringsFromFirstRelatedObject(IfcRelationship rel, ArrayList<String> propertyNames, boolean exclusive)
    {
        Map<String, String> propertyMap = new HashMap<String, String>();
        @SuppressWarnings("unchecked")
        ArrayList<String> propertyNamesClone = (ArrayList<String>)propertyNames.clone();
        Map<String, String> tmpPropertyMap = new HashMap<String, String>();
        IfcObject firstInstance = firstRelatedObjectFromRelationship(rel);

        if (firstInstance != null)
        {
            for (IfcRelDefines def : firstInstance.getIsDefinedBy())
            {
                if (!(def == rel))
                {
                    tmpPropertyMap = IfcRelationshipUtility.propertyStringsFromRelDefines(def, propertyNamesClone, exclusive);
                    propertyMap = IfcPropertyStringTransformer.mergePropertyStrings(tmpPropertyMap, propertyMap);
                }
            }
        }
        return propertyMap;
    }

    static public Map<String, String> propertyStringsFromRelDefines(IfcRelDefines relDefines, ArrayList<String> propertyNames)
    {

        Map<String, String> propertyMap = new HashMap<String, String>();
        if (IfcRelDefinesByProperties.class.isInstance(relDefines))
        {
            propertyMap = propertyStringsFromRelDefinesByProperties((IfcRelDefinesByProperties)relDefines, propertyNames);
        } else if (IfcRelDefinesByType.class.isInstance(relDefines))
        {
            propertyMap = propertyStringsFromRelDefinesByType((IfcRelDefinesByType)relDefines, propertyNames);
        }
        return propertyMap;
    }

    static public Map<String, String> propertyStringsFromRelDefines(IfcRelDefines relDefines, ArrayList<String> propertyNames, boolean exclusive)
    {

        Map<String, String> propertyMap = new HashMap<String, String>();
        if (IfcRelDefinesByProperties.class.isInstance(relDefines))
        {
            propertyMap = propertyStringsFromRelDefinesByProperties((IfcRelDefinesByProperties)relDefines, propertyNames, exclusive);
        } else if (IfcRelDefinesByType.class.isInstance(relDefines))
        {
            propertyMap = propertyStringsFromRelDefinesByType((IfcRelDefinesByType)relDefines, propertyNames, exclusive);
        }
        return propertyMap;
    }

    static private Map<String, String> propertyStringsFromRelDefinesByProperties(
            IfcRelDefinesByProperties relDefinesByProperties,
            ArrayList<String> propertyNames)
    {
        Map<String, String> propertyMap = new HashMap<String, String>();
        new HashMap<String, String>();
        @SuppressWarnings("unchecked")
        ArrayList<String> copyPNames = (ArrayList<String>)propertyNames.clone();
        IfcPropertySetDefinition pSetDef = relDefinesByProperties.getRelatingPropertyDefinition();
        propertyMap = stringMapFromPropertySetDefinition(copyPNames, pSetDef);

        return propertyMap;
    }

    static private Map<String, String> propertyStringsFromRelDefinesByProperties(
            IfcRelDefinesByProperties relDefinesByProperties,
            ArrayList<String> propertyNames,
            boolean exclusive)
    {
        Map<String, String> propertyMap = new HashMap<String, String>();
        Map<String, String> tmpPropertyMap = new HashMap<String, String>();
        @SuppressWarnings("unchecked")
        ArrayList<String> copyPNames = (ArrayList<String>)propertyNames.clone();
        IfcPropertySetDefinition pSetDef = relDefinesByProperties.getRelatingPropertyDefinition();
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

    static private Map<String, String> propertyStringsFromRelDefinesByType(IfcRelDefinesByType relDefinesByType, ArrayList<String> propertyNames)
    {
        @SuppressWarnings("unchecked")
        ArrayList<String> propertyNamesClone = (ArrayList<String>)propertyNames.clone();
        Map<String, String> propertyMap = new HashMap<String, String>();
        Map<String, String> tmpPropertyMap = new HashMap<String, String>();
        IfcTypeObject rType = relDefinesByType.getRelatingType();
        if (rType != null)
        {
            rType.getHasPropertySets();

            for (IfcPropertySetDefinition pSet : rType.getHasPropertySets())
            {
                tmpPropertyMap = IfcPropertySetToCOBieString.propertyStringsFromPropertySetDefinition(pSet, propertyNamesClone);
                propertyMap = IfcPropertyStringTransformer.mergePropertyStrings(tmpPropertyMap, propertyMap);
            }
            if (!propertyNamesClone.isEmpty())
            {

                tmpPropertyMap = IfcRelationshipUtility.propertyStringsFromFirstRelatedObject(relDefinesByType, propertyNamesClone);
                propertyMap = IfcPropertyStringTransformer.mergePropertyStrings(tmpPropertyMap, propertyMap);
                // if (firstInstance != null) {
                // for (IfcRelDefines def : firstInstance.getIsDefinedBy()) {
                // if (!(def instanceof IfcRelDefinesByType)) {
                // tmpPropertyMap = IfcRelationshipsToCOBie
                // .propertyStringsFromRelDefines(def,
                // propertyNamesClone);
                // propertyMap = IfcRelationshipsToCOBie.mergePropertyStrings(
                // tmpPropertyMap, propertyMap);
                // propertyNamesClone = IfcRelationshipsToCOBie
                // .removeFoundPropertyStrings(propertyNamesClone,
                // propertyMap);
                // }
                // }
                // }
            }
        }

        return propertyMap;
    }

    static private Map<String, String> propertyStringsFromRelDefinesByType(
            IfcRelDefinesByType relDefinesByType,
            ArrayList<String> propertyNames,
            boolean exclusive)
    {
        @SuppressWarnings("unchecked")
        ArrayList<String> propertyNamesClone = (ArrayList<String>)propertyNames.clone();
        Map<String, String> propertyMap = new HashMap<String, String>();
        Map<String, String> tmpPropertyMap = new HashMap<String, String>();
        IfcTypeObject rType = relDefinesByType.getRelatingType();
        EList<IfcPropertySetDefinition> pSets = rType.getHasPropertySets();
        for (IfcPropertySetDefinition pSet : pSets)
        {
            tmpPropertyMap = IfcPropertySetToCOBieString.propertyStringsFromPropertySetDefinition(pSet, propertyNamesClone, exclusive);
            propertyMap = IfcPropertyStringTransformer.mergePropertyStrings(tmpPropertyMap, propertyMap);
        }
        if (!propertyNamesClone.isEmpty())
        {

            // tmpPropertyMap =
            // IfcRelationshipsToCOBie.propertyStringsFromFirstRelatedObject(relDefinesByType,
            // propertyNamesClone,exclusive);
            propertyMap = IfcPropertyStringTransformer.mergePropertyStrings(tmpPropertyMap, propertyMap);
            // if (firstInstance != null) {
            // for (IfcRelDefines def : firstInstance.getIsDefinedBy()) {
            // if (!(def instanceof IfcRelDefinesByType)) {
            // tmpPropertyMap = IfcRelationshipsToCOBie
            // .propertyStringsFromRelDefines(def,
            // propertyNamesClone);
            // propertyMap = IfcRelationshipsToCOBie.mergePropertyStrings(
            // tmpPropertyMap, propertyMap);
            // propertyNamesClone = IfcRelationshipsToCOBie
            // .removeFoundPropertyStrings(propertyNamesClone,
            // propertyMap);
            // }
            // }
            // }
        }

        return propertyMap;
    }

    static public Map<String, String> propertyStringsFromTypeObject(IfcTypeObject rType, ArrayList<String> propertyNames)
    {

        @SuppressWarnings("unchecked")
        ArrayList<String> propertyNamesClone = (ArrayList<String>)propertyNames.clone();
        Map<String, String> propertyMap = new HashMap<String, String>();
        Map<String, String> tmpPropertyMap = new HashMap<String, String>();
        EList<IfcPropertySetDefinition> pSets = rType.getHasPropertySets();
        EList<IfcRelDefinesByType> defByTypes = rType.getObjectTypeOf();
        if (!defByTypes.isEmpty())
        {
            IfcRelDefinesByType firstAssociation = defByTypes.get(0);
            propertyMap = IfcRelationshipUtility.propertyStringsFromRelDefines(firstAssociation, propertyNamesClone);
        } else
        {
            for (IfcPropertySetDefinition pSet : pSets)
            {
                tmpPropertyMap = IfcPropertySetToCOBieString.propertyStringsFromPropertySetDefinition(pSet, propertyNamesClone);
                propertyMap = IfcPropertyStringTransformer.mergePropertyStrings(tmpPropertyMap, propertyMap);

            }
        }
        return propertyMap;
    }

    static public Map<String, String> propertyStringsFromTypeObject(IfcTypeObject rType, ArrayList<String> propertyNames, boolean exclusive)
    {
        @SuppressWarnings("unchecked")
        ArrayList<String> propertyNamesClone = (ArrayList<String>)propertyNames.clone();
        Map<String, String> propertyMap = new HashMap<String, String>();
        Map<String, String> tmpPropertyMap = new HashMap<String, String>();
        EList<IfcPropertySetDefinition> pSets = rType.getHasPropertySets();
        EList<IfcRelDefinesByType> defByTypes = rType.getObjectTypeOf();
        if (!defByTypes.isEmpty())
        {
            IfcRelDefinesByType firstAssociation = defByTypes.get(0);
            propertyMap = IfcRelationshipUtility.propertyStringsFromRelDefines(firstAssociation, propertyNamesClone, exclusive);
        } else
        {
            for (IfcPropertySetDefinition pSet : pSets)
            {
                tmpPropertyMap = IfcPropertySetToCOBieString.propertyStringsFromPropertySetDefinition(pSet, propertyNamesClone, exclusive);
                propertyMap = IfcPropertyStringTransformer.mergePropertyStrings(tmpPropertyMap, propertyMap);
            }
        }
        return propertyMap;
    }

    static public Map<String, IfcPropertyStringTransformer> psetStringsFromFirstRelatedObject(
            IfcRelationship rel,
            ArrayList<String> propertyNames,
            boolean exclusive)
    {
        Map<String, IfcPropertyStringTransformer> propertyMap = new HashMap<String, IfcPropertyStringTransformer>();
        @SuppressWarnings("unchecked")
        ArrayList<String> propertyNamesClone = (ArrayList<String>)propertyNames.clone();
        Map<String, IfcPropertyStringTransformer> tmpPropertyMap = new HashMap<String, IfcPropertyStringTransformer>();
        IfcObject firstInstance = firstRelatedObjectFromRelationship(rel);

        if (firstInstance != null)
        {
            for (IfcRelDefines def : firstInstance.getIsDefinedBy())
            {
                if (!(def == rel))
                {
                    tmpPropertyMap = IfcRelationshipUtility.psetStringsFromRelDefines(def, propertyNamesClone, exclusive);
                    propertyMap = IfcPropertySetToCOBieString.mergePsetStrings(tmpPropertyMap, propertyMap);
                }
            }
        }
        return propertyMap;
    }

    static public Map<String, IfcPropertyStringTransformer> psetStringsFromRelDefines(
            IfcRelDefines relDefines,
            ArrayList<String> propertyNames,
            boolean exclusive)
    {

        Map<String, IfcPropertyStringTransformer> propertyMap = new HashMap<String, IfcPropertyStringTransformer>();
        if (IfcRelDefinesByProperties.class.isInstance(relDefines))
        {
            propertyMap = psetStringsFromRelDefinesByProperties((IfcRelDefinesByProperties)relDefines, propertyNames, exclusive);
        } else if (IfcRelDefinesByType.class.isInstance(relDefines))
        {
            propertyMap = psetStringsFromRelDefinesByType((IfcRelDefinesByType)relDefines, propertyNames, exclusive);
        }
        return propertyMap;
    }

    static private Map<String, IfcPropertyStringTransformer> psetStringsFromRelDefinesByProperties(
            IfcRelDefinesByProperties relDefinesByProperties,
            ArrayList<String> propertyNames,
            boolean exclusive)
    {
        Map<String, IfcPropertyStringTransformer> propertyMap = new HashMap<String, IfcPropertyStringTransformer>();
        Map<String, IfcPropertyStringTransformer> tmpPropertyMap = new HashMap<String, IfcPropertyStringTransformer>();
        @SuppressWarnings("unchecked")
        ArrayList<String> copyPNames = (ArrayList<String>)propertyNames.clone();
        IfcPropertySetDefinition pSetDef = relDefinesByProperties.getRelatingPropertyDefinition();
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
        if (propertyMap.size() > 0)
        {
            propertyMap = IfcPropertySetToCOBieString.setPropertySetDataToPset(propertyMap, pSetDef);
        }
        return propertyMap;
    }

    static private Map<String, IfcPropertyStringTransformer> psetStringsFromRelDefinesByType(
            IfcRelDefinesByType relDefinesByType,
            ArrayList<String> propertyNames,
            boolean exclusive)
    {
        @SuppressWarnings("unchecked")
        ArrayList<String> propertyNamesClone = (ArrayList<String>) propertyNames.clone();
        Map<String, IfcPropertyStringTransformer> propertyMap = new HashMap<String, IfcPropertyStringTransformer>();
        Map<String, IfcPropertyStringTransformer> tmpPropertyMap = new HashMap<String, IfcPropertyStringTransformer>();
        IfcTypeObject rType = relDefinesByType.getRelatingType();
        EList<IfcPropertySetDefinition> pSets = rType.getHasPropertySets();
        for (IfcPropertySetDefinition pSet : pSets)
        {
            try
            {
                tmpPropertyMap = IfcPropertySetToCOBieString.psetStringsFromPropertySetDefinition(pSet, propertyNamesClone, exclusive);
                propertyMap = IfcPropertySetToCOBieString.mergePsetStrings(tmpPropertyMap, propertyMap);
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        // if (!propertyNamesClone.isEmpty())
        // {
        // propertyMap =
        // IfcRelationshipsToCOBie.mergePsetStrings(tmpPropertyMap,
        // propertyMap);

        // }

        return propertyMap;
    }

    static public Map<String, IfcPropertyStringTransformer> psetStringsFromTypeObject(
            IfcTypeObject rType,
            ArrayList<String> propertyNames,
            boolean exclusive)
    {
        @SuppressWarnings("unchecked")
        ArrayList<String> propertyNamesClone = (ArrayList<String>)propertyNames.clone();
        Map<String, IfcPropertyStringTransformer> propertyMap = new HashMap<String, IfcPropertyStringTransformer>();
        Map<String, IfcPropertyStringTransformer> tmpPropertyMap = new HashMap<String, IfcPropertyStringTransformer>();
        EList<IfcPropertySetDefinition> pSets = rType.getHasPropertySets();
        EList<IfcRelDefinesByType> defByTypes = rType.getObjectTypeOf();
        if (!defByTypes.isEmpty())
        {
            IfcRelDefinesByType firstAssociation = defByTypes.get(0);
            propertyMap = IfcRelationshipUtility.psetStringsFromRelDefines(firstAssociation, propertyNamesClone, exclusive);
        } else
        {
            for (IfcPropertySetDefinition pSet : pSets)
            {
                tmpPropertyMap = IfcPropertySetToCOBieString.psetStringsFromPropertySetDefinition(pSet, propertyNamesClone, exclusive);
                propertyMap = IfcPropertySetToCOBieString.mergePsetStrings(tmpPropertyMap, propertyMap);
            }
        }
        return propertyMap;
    }

    public static Map<String, String> stringMapFromPropertySetDefinition(ArrayList<String> copyPNames, IfcPropertySetDefinition pSetDef)
    {
        Map<String, String> propertyMap = new HashMap<String, String>();
        Map<String, String> tmpPropertyMap;
        if (IfcPropertySet.class.isInstance(pSetDef))
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

    static public Map<String, String> UnitStringsFromRelDefines(IfcRelDefines relDefines, ArrayList<String> propertyNames)
    {

        Map<String, String> propertyMap = new HashMap<String, String>();
        if (IfcRelDefinesByProperties.class.isInstance(relDefines))
        {
            propertyMap = propertyStringsFromRelDefinesByProperties((IfcRelDefinesByProperties)relDefines, propertyNames);
        } else if (IfcRelDefinesByType.class.isInstance(relDefines))
        {
            propertyMap = propertyStringsFromRelDefinesByType((IfcRelDefinesByType)relDefines, propertyNames);
        }
        return propertyMap;
    }

}
