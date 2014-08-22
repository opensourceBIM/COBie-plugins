package org.erdc.cobie.shared.bimserver.ifc.serialization.cobietab;

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
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.ifc2x3tc1.IfcGroup;
import org.bimserver.models.ifc2x3tc1.IfcObjectDefinition;
import org.bimserver.models.ifc2x3tc1.IfcOwnerHistory;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.models.ifc2x3tc1.IfcProperty;
import org.bimserver.models.ifc2x3tc1.IfcPropertySet;
import org.bimserver.models.ifc2x3tc1.IfcPropertySetDefinition;
import org.bimserver.models.ifc2x3tc1.IfcPropertySingleValue;
import org.bimserver.models.ifc2x3tc1.IfcRelAssignsToGroup;
import org.bimserver.models.ifc2x3tc1.IfcRelDefines;
import org.bimserver.models.ifc2x3tc1.IfcRelDefinesByProperties;
import org.bimserver.models.ifc2x3tc1.IfcSystem;
import org.eclipse.emf.common.util.EList;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.shared.COBieUtility.CobieSheetName;
import org.erdc.cobie.shared.bimserver.COBieIfcUtility;
import org.erdc.cobie.shared.bimserver.cobietab.deserialization.SystemDeserializer;
import org.erdc.cobie.sheetxmldata.COBIEType;
import org.erdc.cobie.sheetxmldata.SystemType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IfcToSystem
{
    private static final Logger LOGGER = LoggerFactory.getLogger(IfcToSystem.class);
    private static final CobieSheetName sheetName = CobieSheetName.System;
    private static final ArrayList<String> systemIfcClassNames = new ArrayList<String>(Arrays.asList("IfcSystem", "IfcElectricalCircuit", "IfcGroup"));
    private static final String systemCircuitNumber = "Circuit Number";
    private static final String systemTypeProperty = "System Type";
    private static final String systemCircuitCategory = "circuit";
    private static final ArrayList<String> systemIfcPropertySingleValueNames = new ArrayList<String>(
            Arrays.asList(systemCircuitNumber, "System Name"));

    protected static String categoryFromGroup(IfcGroup system)
    {
        return COBieIfcUtility.getObjectClassificationCategoryString(system);
    }

    protected static String categoryFromPropertySingleValue(IfcPropertySingleValue val, EList<IfcProperty> siblingProperties)
    {
        String category = "";
        String name = val.getName();
        String tmpValName;
        IfcPropertySingleValue val2;
        if (name.equals(systemCircuitNumber))
        {
            category = IfcToSystem.systemCircuitCategory;
        } else
        {
            for (IfcProperty property : siblingProperties)
            {
                tmpValName = property.getName();
                if (tmpValName.equals(IfcToSystem.systemTypeProperty) && (property instanceof IfcPropertySingleValue))
                {
                    val2 = (IfcPropertySingleValue)property;
                    IfcSingleValueToCOBieString sValStr = new IfcSingleValueToCOBieString(val2);
                    category = sValStr.getValueString();

                }
            }
        }
        return COBieUtility.getCOBieString(category);
    }

    protected static ArrayList<String> componentArrayFromRelDefinesByProperties(IfcRelDefinesByProperties rel, ArrayList<String> componentNames)
    {
        String name = "";
        ArrayList<String> addedComponents = new ArrayList<String>();
        for (IfcObjectDefinition obj : rel.getRelatedObjects())
        {
            name = obj.getName();
            if (componentNames.contains(name) && !addedComponents.contains(name))
            {
                addedComponents.add(name);
            }
        }

        return addedComponents;
    }

    protected static ArrayList<String> componentNameArrayFromGroup(IfcGroup system, IfcModelInterface model)
    {
        ArrayList<String> components = new ArrayList<String>();
        if (system.isSetIsGroupedBy())
        {
            IfcRelAssignsToGroup relGroup = system.getIsGroupedBy();
            for (IfcObjectDefinition def : relGroup.getRelatedObjects())
            {
                // if(IfcToComponent.isAssetComponent(def))
                // {
                components.add(COBieUtility.getCOBieString(def.getName()));
                // }
            }
        } else
        {
            for (IfcRelAssignsToGroup assignsToGroup : model.getAllWithSubTypes(IfcRelAssignsToGroup.class))
            {
                if (assignsToGroup.getRelatingGroup().getGlobalId().equals(system.getGlobalId()))
                {
                    for (IfcObjectDefinition def : assignsToGroup.getRelatedObjects())
                    {
                        components.add(COBieUtility.getCOBieString(def.getName()));
                    }
                }
            }
        }

        return components;
    }

    protected static HashMap<String, IfcOwnerHistory> componentNameOwnerHistoryFromGroup(IfcGroup system)
    {
        HashMap<String, IfcOwnerHistory> components = new HashMap<String, IfcOwnerHistory>();
        IfcRelAssignsToGroup relGroup = system.getIsGroupedBy();
        for (IfcObjectDefinition def : relGroup.getRelatedObjects())
        {
            if (IfcToComponent.isAssetComponent(def))
            {
                components.put(COBieUtility.getCOBieString(def.getName()), def.getOwnerHistory());
            }
        }
        return components;
    }

    protected static String componentsFromGroup(IfcGroup system, IfcModelInterface model)
    {
        ArrayList<String> components = componentNameArrayFromGroup(system, model);
        return COBieUtility.delimittedStringFromArrayList(components);
    }

    protected static String componentsFromPropertySingleValue(IfcPropertySingleValue val)
    {
        String components = "";
        return COBieUtility.getCOBieString(components);
    }

    protected static String componentsFromRelDefinesByProperties(IfcRelDefinesByProperties rel, ArrayList<String> componentNames)
    {
        ArrayList<String> components = componentArrayFromRelDefinesByProperties(rel, componentNames);
        return COBieUtility.delimittedStringFromArrayList(components);
    }

    protected static String descriptionFromGroup(IfcGroup system)
    {
        String description = system.getDescription();
        if ((description != null) && description.isEmpty())
        {
            description = system.getName();
        }
        return COBieUtility.getCOBieString(description);
    }

    protected static String descriptionFromPropertySingleValue(IfcPropertySingleValue val)
    {
        String description = val.getDescription();
        if ((description != null) && description.isEmpty())
        {
            description = val.getName();
        }
        return COBieUtility.getCOBieString(description);
    }

    protected static String extObjectFromGroup(IfcGroup system)
    {
        return COBieIfcUtility.extObjectFromObjectDef(system);
    }

    protected static String extObjectFromPropertySingleValue(IfcPropertySingleValue val)
    {
        return IfcPropertySingleValue.class.getSimpleName();
    }

    protected static ArrayList<String> getSystemIfcClassNames()
    {
        return systemIfcClassNames;
    }

    protected static ArrayList<String> getSystemIfcPropertySingleValueNames()
    {
        return systemIfcPropertySingleValueNames;
    }

    protected static String nameFromGroup(IfcGroup system)
    {
        String name = system.getName();
        return COBieUtility.getCOBieString(name);
    }

    protected static String nameFromPropertySingleValue(IfcPropertySingleValue val)
    {
        IfcSingleValueToCOBieString sValStr = new IfcSingleValueToCOBieString(val);
        return COBieUtility.getCOBieString(sValStr.getValueString());
    }

    private static COBIEType revitWriteSystemsToCOBieComponentPerRow(COBIEType cType, IfcModelInterface model, LogHandler loggerHandler)
    {
        COBIEType.Systems systems = cType.getSystems();
        String name = "";
        String createdBy = "";
        Calendar createdOn;
        String category = "";
        ArrayList<String> componentNames;
        String extSystem = "";
        String extObject = "";
        String extIdentifier = "";
        String description = "";
        IfcOwnerHistory oh;
        IfcSingleValueToCOBieString vStr;
        String propertyName = "";
        ArrayList<String> existingSystems = new ArrayList<String>();
        ArrayList<IfcProduct> componentProducts = IfcToComponent.getComponentProducts(cType, model);
        ArrayList<String> compProdNames = new ArrayList<String>();
        for (IfcProduct product : componentProducts)
        {
            compProdNames.add(product.getName());
        }
        for (IfcProduct component : componentProducts)
        {
            for (IfcRelDefines relDefines : component.getIsDefinedBy())
            {
                if (relDefines instanceof IfcRelDefinesByProperties)
                {
                    IfcRelDefinesByProperties relDefByProp = (IfcRelDefinesByProperties)relDefines;
                    IfcPropertySetDefinition propertySetDef = relDefByProp.getRelatingPropertyDefinition();
                    if (propertySetDef instanceof IfcPropertySet)
                    {
                        IfcPropertySet pSet = (IfcPropertySet)propertySetDef;
                        for (IfcProperty property : pSet.getHasProperties())
                        {
                            propertyName = property.getName();
                            if ((property instanceof IfcPropertySingleValue)
                                    && IfcToSystem.getSystemIfcPropertySingleValueNames().contains(propertyName))
                            {
                                IfcPropertySingleValue val = (IfcPropertySingleValue)property;
                                vStr = new IfcSingleValueToCOBieString(val);
                                name = vStr.getValueString();
                                category = IfcToSystem.categoryFromPropertySingleValue(val, pSet.getHasProperties());
                                String systemKey = SystemDeserializer.systemKeyFromNameCategory(name, category);
                                if (!existingSystems.contains(systemKey))
                                {

                                    try
                                    {
                                        existingSystems.add(systemKey);
                                        extObject = IfcToSystem.extObjectFromPropertySingleValue(val);
                                        oh = IfcToContact.getLatestOwnerHistory(model);
                                        createdBy = COBieIfcUtility.getEmailFromOwnerHistory(oh);
                                        createdOn = IfcToContact.getCreatedOn(oh.getCreationDate());
                                        componentNames = IfcToSystem.componentArrayFromRelDefinesByProperties(relDefByProp, compProdNames);
                                        extSystem = COBieIfcUtility.getApplicationName(oh);
                                        extIdentifier = COBieUtility.COBieNA;
                                        description = IfcToSystem.descriptionFromPropertySingleValue(val);
                                        for (String componentName : componentNames)
                                        {
                                            SystemType newSystem = systems.addNewSystem();
                                            newSystem.setName(name);
                                            newSystem.setCreatedBy(createdBy);
                                            newSystem.setCreatedOn(createdOn);
                                            newSystem.setCategory(category);
                                            newSystem.setComponentNames(componentName);
                                            newSystem.setExtSystem(extSystem);
                                            newSystem.setExtObject(extObject);
                                            newSystem.setExtIdentifier(extIdentifier);
                                            newSystem.setDescription(description);
                                            loggerHandler.rowWritten();
                                        }
                                    } catch (Exception e)
                                    {
                                        // TODO Auto-generated catch block
                                        loggerHandler.error(e);
                                    }
                                }
                            }
                        }

                    }
                }
            }
        }
        return cType;
    }

    private static COBIEType revitWriteSystemsToCOBieDelimComponents(COBIEType cType, IfcModelInterface model, LogHandler loggerHandler)
    {
        COBIEType.Systems systems = cType.getSystems();
        String name = "";
        String createdBy = "";
        Calendar createdOn;
        String category = "";
        String componentNames = "";
        String extSystem = "";
        String extObject = "";
        String extIdentifier = "";
        String description = "";
        IfcOwnerHistory oh;
        IfcSingleValueToCOBieString vStr;
        String propertyName = "";
        ArrayList<String> existingSystems = new ArrayList<String>();
        ArrayList<IfcProduct> componentProducts = IfcToComponent.getComponentProducts(cType, model);
        ArrayList<String> compProdNames = new ArrayList<String>();
        for (IfcProduct product : componentProducts)
        {
            compProdNames.add(product.getName());
        }
        for (IfcProduct component : componentProducts)
        {
            for (IfcRelDefines relDefines : component.getIsDefinedBy())
            {
                if (relDefines instanceof IfcRelDefinesByProperties)
                {
                    IfcRelDefinesByProperties relDefByProp = (IfcRelDefinesByProperties)relDefines;
                    IfcPropertySetDefinition propertySetDef = relDefByProp.getRelatingPropertyDefinition();
                    if (propertySetDef instanceof IfcPropertySet)
                    {
                        IfcPropertySet pSet = (IfcPropertySet)propertySetDef;
                        for (IfcProperty property : pSet.getHasProperties())
                        {
                            propertyName = property.getName();
                            if ((property instanceof IfcPropertySingleValue)
                                    && IfcToSystem.getSystemIfcPropertySingleValueNames().contains(propertyName))
                            {
                                IfcPropertySingleValue val = (IfcPropertySingleValue)property;
                                vStr = new IfcSingleValueToCOBieString(val);
                                name = vStr.getValueString();
                                if (!existingSystems.contains(name))
                                {

                                    try
                                    {
                                        existingSystems.add(name);
                                        extObject = IfcToSystem.extObjectFromPropertySingleValue(val);
                                        oh = IfcToContact.getLatestOwnerHistory(model);
                                        createdBy = COBieIfcUtility.getEmailFromOwnerHistory(oh);
                                        createdOn = IfcToContact.getCreatedOn(oh.getCreationDate());
                                        category = IfcToSystem.categoryFromPropertySingleValue(val, pSet.getHasProperties());
                                        componentNames = IfcToSystem.componentsFromRelDefinesByProperties(relDefByProp, compProdNames);
                                        extSystem = COBieIfcUtility.getApplicationName(oh);
                                        extIdentifier = COBieUtility.COBieNA;
                                        description = IfcToSystem.descriptionFromPropertySingleValue(val);

                                        SystemType newSystem = systems.addNewSystem();
                                        newSystem.setName(name);
                                        newSystem.setCreatedBy(createdBy);
                                        newSystem.setCreatedOn(createdOn);
                                        newSystem.setCategory(category);
                                        newSystem.setComponentNames(componentNames);
                                        newSystem.setExtSystem(extSystem);
                                        newSystem.setExtObject(extObject);
                                        newSystem.setExtIdentifier(extIdentifier);
                                        newSystem.setDescription(description);
                                        loggerHandler.rowWritten();
                                    } catch (Exception e)
                                    {
                                        // TODO Auto-generated catch block
                                        loggerHandler.error(e);
                                    }
                                }
                            }
                        }

                    }
                }
            }
        }
        return cType;
    }

    private static boolean shouldWriteSystem(String extObject, ArrayList<String> existingSystems, String systemKey)
    {
        // boolean shouldWrite = !existingSystems.contains(systemKey) &&
        // IfcToSystem.getSystemIfcClassNames().contains(extObject);
        boolean shouldWrite = IfcToSystem.getSystemIfcClassNames().contains(extObject);
        return shouldWrite;
    }

    public static COBIEType writeSystemsToCOBieComponentDelimComponents(COBIEType cType, IfcModelInterface model)
    {
        LogHandler loggerHandler = new LogHandler(sheetName, LOGGER);
        loggerHandler.sheetWriteBegin();
        COBIEType.Systems systems = cType.addNewSystems();
        String name = "";
        String createdBy = "";
        Calendar createdOn;
        String category = "";
        String componentNames = "";
        String extSystem = "";
        String extObject = "";
        String extIdentifier = "";
        String description = "";
        IfcOwnerHistory oh;
        ArrayList<String> existingSystems = new ArrayList<String>();
        for (IfcSystem ifcGroup : model.getAllWithSubTypes(IfcSystem.class))
        {
            try
            {
                name = IfcToSystem.nameFromGroup(ifcGroup);
                String systemKey = SystemDeserializer.systemKeyFromSystem(ifcGroup);
                extObject = IfcToSystem.extObjectFromGroup(ifcGroup);
                if (shouldWriteSystem(extObject, existingSystems, systemKey))
                {
                    existingSystems.add(systemKey);
                    oh = ifcGroup.getOwnerHistory();
                    createdBy = COBieIfcUtility.getEmailFromOwnerHistory(oh);
                    createdOn = IfcToContact.getCreatedOn(oh.getCreationDate());
                    category = IfcToSystem.categoryFromGroup(ifcGroup);
                    componentNames = IfcToSystem.componentsFromGroup(ifcGroup, model);

                    extSystem = COBieIfcUtility.getApplicationName(oh);
                    extIdentifier = COBieIfcUtility.identifierFromObjectDefinition(ifcGroup);
                    description = IfcToSystem.descriptionFromGroup(ifcGroup);

                    SystemType newSystem = systems.addNewSystem();
                    newSystem.setName(name);
                    newSystem.setCreatedBy(createdBy);
                    newSystem.setCreatedOn(createdOn);
                    newSystem.setCategory(category);
                    newSystem.setComponentNames(componentNames);
                    newSystem.setExtSystem(extSystem);
                    newSystem.setExtObject(extObject);
                    newSystem.setExtIdentifier(extIdentifier);
                    newSystem.setDescription(description);
                    loggerHandler.rowWritten();

                }
            } catch (Exception ex)
            {
                loggerHandler.error(ex);
            }

        }
        cType = revitWriteSystemsToCOBieDelimComponents(cType, model, loggerHandler);
        loggerHandler.sheetWritten();
        return cType;
    }

    public static COBIEType writeSystemsToCOBieComponentPerRow(COBIEType cType, IfcModelInterface model)
    {
        LogHandler loggerHandler = new LogHandler(sheetName, LOGGER);
        loggerHandler.sheetWriteBegin();
        COBIEType.Systems systems = cType.addNewSystems();
        String name = "";
        String createdBy = "";
        Calendar createdOn;
        String category = "";
        ArrayList<String> componentNames = new ArrayList<String>();
        String extSystem = "";
        String extObject = "";
        String extIdentifier = "";
        String description = "";
        IfcOwnerHistory oh;
        ArrayList<String> existingSystems = new ArrayList<String>();
        for (IfcSystem ifcGroup : model.getAllWithSubTypes(IfcSystem.class))
        {
            try
            {
                name = IfcToSystem.nameFromGroup(ifcGroup);
                String systemKey = SystemDeserializer.systemKeyFromSystem(ifcGroup);
                extObject = IfcToSystem.extObjectFromGroup(ifcGroup);
                if (shouldWriteSystem(extObject, existingSystems, systemKey))
                {
                    existingSystems.add(systemKey);
                    oh = ifcGroup.getOwnerHistory();
                    createdBy = COBieIfcUtility.getEmailFromOwnerHistory(oh);
                    createdOn = IfcToContact.getCreatedOn(oh.getCreationDate());
                    category = IfcToSystem.categoryFromGroup(ifcGroup);
                    componentNames = IfcToSystem.componentNameArrayFromGroup(ifcGroup, model);

                    extSystem = COBieIfcUtility.getApplicationName(oh);
                    extIdentifier = COBieIfcUtility.identifierFromObjectDefinition(ifcGroup);
                    description = IfcToSystem.descriptionFromGroup(ifcGroup);
                    for (String componentName : componentNames)
                    {
                        SystemType newSystem = systems.addNewSystem();
                        newSystem.setName(name);
                        newSystem.setCreatedBy(createdBy);
                        newSystem.setCreatedOn(createdOn);
                        newSystem.setCategory(category);
                        newSystem.setComponentNames(componentName);
                        newSystem.setExtSystem(extSystem);
                        newSystem.setExtObject(extObject);
                        newSystem.setExtIdentifier(extIdentifier);
                        newSystem.setDescription(description);
                        loggerHandler.rowWritten();
                    }
                }
            } catch (Exception ex)
            {
                loggerHandler.error(ex);
            }

        }
        cType = revitWriteSystemsToCOBieComponentPerRow(cType, model, loggerHandler);
        loggerHandler.sheetWritten();
        return cType;
    }

}
