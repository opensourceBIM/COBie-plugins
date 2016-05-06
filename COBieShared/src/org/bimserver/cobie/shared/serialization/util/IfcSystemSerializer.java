package org.bimserver.cobie.shared.serialization.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import org.bimserver.cobie.shared.deserialization.cobietab.SystemDeserializer;
import org.bimserver.cobie.shared.serialization.IfcCobieSerializer;
import org.bimserver.cobie.shared.utility.COBieIfcUtility;
import org.bimserver.cobie.shared.utility.COBieUtility;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.ifc2x3tc1.IfcGroup;
import org.bimserver.models.ifc2x3tc1.IfcObjectDefinition;
import org.bimserver.models.ifc2x3tc1.IfcOwnerHistory;
import org.bimserver.models.ifc2x3tc1.IfcProperty;
import org.bimserver.models.ifc2x3tc1.IfcPropertySingleValue;
import org.bimserver.models.ifc2x3tc1.IfcRelAssignsToGroup;
import org.bimserver.models.ifc2x3tc1.IfcRelDefinesByProperties;
import org.bimserver.models.ifc2x3tc1.IfcSystem;
import org.eclipse.emf.common.util.EList;
import org.nibs.cobie.tab.COBIEType;
import org.nibs.cobie.tab.COBIEType.Systems;
import org.nibs.cobie.tab.SystemType;

import com.prairiesky.transform.cobieifc.settings.SettingsType;

public class IfcSystemSerializer extends
		IfcCobieSerializer<SystemType, COBIEType.Systems, IfcSystem> 
{

	private ArrayList<String> existingSystems = new ArrayList<String>();
	public ArrayList<String> getExistingSystems() {
		return existingSystems;
	}

	public void setExistingSystems(ArrayList<String> existingSystems) {
		this.existingSystems = existingSystems;
	}

	public IfcSystemSerializer(Systems cobieSection, IfcModelInterface model,
			SettingsType settings) 
	{
		super(cobieSection, model, settings);
	}

	@Override
	protected List<IfcSystem> getTopLevelModelObjects() 
	{
		return model.getAllWithSubTypes(IfcSystem.class);
	}

	@Override
	protected List<SystemType> serializeModelObject(IfcSystem ifcGroup) 
	{
		List<SystemType> systems = new ArrayList<>();
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
               
        try
        {
            name = IfcSystemSerializer.nameFromGroup(ifcGroup);
            String systemKey = SystemDeserializer.systemKeyFromSystem(ifcGroup);
            extObject = IfcSystemSerializer.extObjectFromGroup(ifcGroup);
            if (shouldWriteSystem(extObject, existingSystems, systemKey))
            {
                getExistingSystems().add(systemKey);
                oh = ifcGroup.getOwnerHistory();
                createdBy = COBieIfcUtility.getEmailFromOwnerHistory(oh);
                createdOn = IfcToContact.getCreatedOn(oh.getCreationDate());
                category = IfcSystemSerializer.categoryFromGroup(ifcGroup);
                componentNames = IfcSystemSerializer.componentNameArrayFromGroup(ifcGroup, model);

                extSystem = COBieIfcUtility.getApplicationName(oh);
                extIdentifier = COBieIfcUtility.identifierFromObjectDefinition(ifcGroup);
                description = IfcSystemSerializer.descriptionFromGroup(ifcGroup);
                for (String componentName : componentNames)
                {
                    SystemType newSystem = getCobieSection().addNewSystem();
                    newSystem.setName(name);
                    newSystem.setCreatedBy(createdBy);
                    newSystem.setCreatedOn(createdOn);
                    newSystem.setCategory(category);
                    newSystem.setComponentNames(componentName);
                    newSystem.setExtSystem(extSystem);
                    newSystem.setExtObject(extObject);
                    newSystem.setExtIdentifier(extIdentifier);
                    newSystem.setDescription(description);
                    systems.add(newSystem);
                }
            }
        } catch (Exception ex)
        {
            
        }
        return systems;
	}
	
    private static boolean shouldWriteSystem(String extObject, ArrayList<String> existingSystems, String systemKey)
    {
        // boolean shouldWrite = !existingSystems.contains(systemKey) &&
        // IfcToSystem.getSystemIfcClassNames().contains(extObject);
        boolean shouldWrite = IfcSystemSerializer.getSystemIfcClassNames().contains(extObject);
        return shouldWrite;
    }
    
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
            category = IfcSystemSerializer.systemCircuitCategory;
        } else
        {
            for (IfcProperty property : siblingProperties)
            {
                tmpValName = property.getName();
                if (tmpValName.equals(IfcSystemSerializer.systemTypeProperty) && (property instanceof IfcPropertySingleValue))
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

    protected static HashMap<String, IfcOwnerHistory> componentNameOwnerHistoryFromGroup(IfcGroup system, SettingsType settings)
    {
        HashMap<String, IfcOwnerHistory> components = new HashMap<String, IfcOwnerHistory>();
        IfcRelAssignsToGroup relGroup = system.getIsGroupedBy();
        for (IfcObjectDefinition def : relGroup.getRelatedObjects())
        {
            if (IfcProductToComponentsSerializer.isAssetComponent(def, settings))
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

}
