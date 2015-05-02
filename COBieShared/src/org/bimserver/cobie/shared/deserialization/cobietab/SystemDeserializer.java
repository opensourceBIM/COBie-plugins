package org.bimserver.cobie.shared.deserialization.cobietab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bimserver.cobie.shared.deserialization.cobietab.modelhandlers.ClassificationHandler;
import org.bimserver.cobie.shared.deserialization.cobietab.modelhandlers.IfcCommonHandler;
import org.bimserver.cobie.shared.utility.COBieIfcUtility;
import org.bimserver.cobie.shared.utility.COBieUtility;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.IfcClassificationReference;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.models.ifc2x3tc1.IfcRelAssignsToGroup;
import org.bimserver.models.ifc2x3tc1.IfcSystem;
import org.nibs.cobie.tab.COBIEType;
import org.nibs.cobie.tab.SystemType;

public class SystemDeserializer
{
    public static String systemKeyFromNameCategory(String name, String category)
    {
        String nameCopy = name;
        String categoryCopy = category;
        if (nameCopy == null)
        {
            name = "";
        }
        if (categoryCopy == null)
        {
            category = "";
        }
        return name + COBieUtility.getCOBieDelim() + category;
    }

    public static String systemKeyFromSystem(IfcSystem system)
    {
        String name = system.getName();
        String category = COBieIfcUtility.getObjectClassificationCategoryString(system);
        if (COBieUtility.isNA(category))
        {
            category = system.getObjectType();
        }
        return systemKeyFromNameCategory(name, category);
    }

    public static String systemKeyFromSystem(SystemType system)
    {
        String name = system.getName();
        String category = ClassificationHandler.normalizeCategoryString(system.getCategory());
        return systemKeyFromNameCategory(name, category);
    }

    private COBieIfcModel model;
    private IfcCommonHandler ifcCommonHandler;
    private COBIEType.Systems systems;

    private HashMap<String, ArrayList<String>> systemKeyToComponentNames;

    private HashMap<String, Long> systemNameToGroupRelationOid;

    public SystemDeserializer(COBieIfcModel cobieIfcModel, IfcCommonHandler ifcCommonHandler, COBIEType.Systems systems)
    {
        model = cobieIfcModel;
        this.ifcCommonHandler = ifcCommonHandler;
        this.systems = systems;
        systemKeyToComponentNames = new HashMap<String, ArrayList<String>>();
        systemNameToGroupRelationOid = new HashMap<String, Long>();
    }

    private void addNewSystem(SystemType system) throws IfcModelInterfaceException
    {
        String systemKey = systemKeyFromSystem(system);
        IfcSystem ifcSystem = ifcSystemFromCOBieSystem(system);
        ArrayList<String> componentNames = systemKeyToComponentNames.get(systemKey);
        populateSystemComponentRelationships(ifcSystem, componentNames, system);
    }

    private void addToComponentListIgnoreDuplicates(String componentName, ArrayList<String> componentNames)
    {
        if (!componentNames.contains(componentName) && model.containsComponent(componentName))
        {
            componentNames.add(componentName);
        }
    }

    @SuppressWarnings("deprecation")
	public void deserializeSystems()
    {
        if ((systems != null) && (systems.getSystemArray() != null))
        {
            populateSystemNameCategoryComponentNames();
            for (SystemType system : systems.getSystemArray())
            {
                try
                {
                    String systemKey = systemKeyFromSystem(system);
                    if (!model.containsSystem(systemKey) && systemKeyToComponentNames.containsKey(systemKey))
                    {
                        addNewSystem(system);
                    }

                } catch (Exception e)
                {
                }
            }
        }
    }

    private IfcSystem ifcSystemFromCOBieSystem(SystemType system) throws IfcModelInterfaceException
    {
        IfcSystem ifcSystem = Ifc2x3tc1Factory.eINSTANCE.createIfcSystem();
        String externalObject = system.getExtObject();

        try
        {
            if (!COBieUtility.isNA(externalObject))
            {
                IdEObject genericType = FromCOBieToIfc.newIdEObject(externalObject);
                ifcSystem = (IfcSystem)genericType;
            } else
            {
                ifcSystem = COBieIfcUtility.ifcFactory.createIfcSystem();
            }

        } catch (Exception e)
        {
            ifcSystem = Ifc2x3tc1Factory.eINSTANCE.createIfcSystem();
        }
        String Name = COBieUtility.getCOBieString(system.getName());
        String Description = COBieUtility.getCOBieString(system.getDescription());
        ifcSystem.setGlobalId(ifcCommonHandler.getGuidHandler().guidFromExternalIdentifier(system.getExtIdentifier(), false).getWrappedValue());
        ifcSystem.setOwnerHistory(ifcCommonHandler.getOwnerHistoryHandler().ownerHistoryFromEmailTimestampAndApplication(system.getCreatedBy(),
                system.getCreatedOn(), system.getExtSystem()));
        ifcSystem.setName(Name);
        ifcSystem.setDescription(Description);
        String objectType = ClassificationHandler.objectTypeFromCategoryString(system.getCategory());
        if (!COBieUtility.isNA(objectType))
        {
            ifcSystem.setObjectType(objectType);
        }
        if (ifcSystem instanceof IfcSystem)
        {
            model.addSystem(ifcSystem, system, ifcCommonHandler);
        }
        List<IfcClassificationReference> classRefs = ifcCommonHandler.getClassificationHandler().classificationReferencesFromString(
                system.getCategory());
        for (IfcClassificationReference classRef : classRefs)
        {
            ifcCommonHandler.getClassificationHandler().addClassificationReferenceToObject(classRef, ifcSystem);
        }
        return ifcSystem;
    }

    public boolean isComponentNamesDelimList(String componentNames)
    {
        boolean isDelim = false;
        if (componentNames.contains(COBieUtility.getCOBieDelim()))
        {
            isDelim = true;
        }
        return isDelim;
    }

    public void populateSystemComponentRelationships(IfcSystem system, ArrayList<String> componentNames, SystemType cobieSystem)
    {
        for (String componentName : componentNames)
        {
            IfcProduct component = (IfcProduct)model.get(model.getComponentOid(componentName));
            try
            {
                relAssignsToGroupFromSystemAndComponent(system, component, cobieSystem);
            } catch (IfcModelInterfaceException e)
            {
                
            }
        }
    }

    @SuppressWarnings("deprecation")
	private void populateSystemNameCategoryComponentNames()
    {
        String componentNames;
        String systemKey;
        ArrayList<String> componentNameList;
        for (SystemType system : systems.getSystemArray())
        {
            systemKey = systemKeyFromSystem(system);
            if (systemKeyToComponentNames.containsKey(systemKey))
            {
                componentNameList = systemKeyToComponentNames.get(systemKey);
            } else
            {
                componentNameList = new ArrayList<String>();
            }
            try
            {
                componentNames = system.getComponentNames();
                if (isComponentNamesDelimList(componentNames))
                {
                    String[] componentNameArray = componentNames.split(COBieUtility.getCOBieDelim());
                    for (String componentName : componentNameArray)
                    {
                        addToComponentListIgnoreDuplicates(componentName.trim(), componentNameList);
                    }
                } else
                {
                    addToComponentListIgnoreDuplicates(componentNames, componentNameList);
                }
                systemKeyToComponentNames.put(systemKey, componentNameList);
            } catch (Exception e)
            {

            }
        }
    }

    public IfcRelAssignsToGroup relAssignsToGroupFromSystemAndComponent(IfcSystem system, IfcProduct component, SystemType cobieSystem) throws IfcModelInterfaceException
    {
        IfcRelAssignsToGroup groupAssignment;
        String systemKey = SystemDeserializer.systemKeyFromSystem(system);
        if (systemNameToGroupRelationOid.containsKey(systemKey))
        {
            groupAssignment = (IfcRelAssignsToGroup)model.get(systemNameToGroupRelationOid.get(systemKey));
        } else
        {
            groupAssignment = Ifc2x3tc1Factory.eINSTANCE.createIfcRelAssignsToGroup();

            groupAssignment.setGlobalId(ifcCommonHandler.getGuidHandler().newGuid().getWrappedValue());
            groupAssignment.setOwnerHistory(ifcCommonHandler.getOwnerHistoryHandler().ownerHistoryFromEmailTimestampAndApplication(
                    cobieSystem.getCreatedBy(), cobieSystem.getCreatedOn(), cobieSystem.getExtSystem()));
            groupAssignment.setName(system.getName() + " to " + component.getName() + " relation");
            groupAssignment.setRelatingGroup(system);
            long relOid = model.add(groupAssignment, ifcCommonHandler.getOidProvider());
            // system.setIsGroupedBy(groupAssignment);
            systemNameToGroupRelationOid.put(systemKey, relOid);
        }
        groupAssignment.getRelatedObjects().add(component);
        return groupAssignment;
    }

}
