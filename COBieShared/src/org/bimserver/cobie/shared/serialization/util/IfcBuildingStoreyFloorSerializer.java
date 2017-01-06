package org.bimserver.cobie.shared.serialization.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bimserver.cobie.shared.serialization.IfcCobieSerializer;
import org.bimserver.cobie.shared.utility.COBieIfcUtility;
import org.bimserver.cobie.shared.utility.COBieUtility;
import org.bimserver.cobie.shared.utility.ifc.IfcRelationshipUtility;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.ifc2x3tc1.IfcBuilding;
import org.bimserver.models.ifc2x3tc1.IfcBuildingStorey;
import org.bimserver.models.ifc2x3tc1.IfcObjectDefinition;
import org.bimserver.models.ifc2x3tc1.IfcOwnerHistory;
import org.bimserver.models.ifc2x3tc1.IfcRelDecomposes;
import org.bimserver.models.ifc2x3tc1.IfcRelDefines;
import org.bimserver.models.ifc2x3tc1.impl.IfcBuildingStoreyImpl;
import org.nibs.cobie.tab.COBIEType.Floors;
import org.nibs.cobie.tab.FloorType;

import com.prairiesky.transform.cobieifc.settings.SettingsType;

public class IfcBuildingStoreyFloorSerializer extends
		IfcCobieSerializer<FloorType, Floors, IfcBuildingStorey> 
{

    protected String elevationFromStorey(IfcBuildingStorey storey)
    {
        float elevation = (float)storey.getElevation();
        String elevationStr = storey.getElevationAsString();
        if (COBieUtility.isNA(elevationStr))
        {
            elevationStr = String.valueOf(elevation);
        }
        return elevationStr;
    }
	
    private static final String SITE = "Site";
    private static final String IFC_SITE = "IfcSite";
    
	public IfcBuildingStoreyFloorSerializer(Floors cobieSection,
			IfcModelInterface model, SettingsType settings) 
	{
		super(cobieSection, model, settings);
	}

	@Override
	protected List<IfcBuildingStorey> getTopLevelModelObjects() 
	{
		List<IfcBuildingStorey> storeys = new ArrayList<>();
		for(IfcBuilding bldg : model.getAll(IfcBuilding.class))
		{
			storeys.addAll(IfcBuildingStoreyFloorSerializer.floorsFromBuilding(bldg));
		}
		return storeys;
	}

    protected static ArrayList<IfcBuildingStorey> floorsFromBuilding(IfcBuilding bldg)
    {
        ArrayList<IfcBuildingStorey> floors = new ArrayList<IfcBuildingStorey>();
        ArrayList<String> floorGuids = new ArrayList<String>();
        for (IfcRelDecomposes relDec : bldg.getIsDecomposedBy())
        {
            for (IfcObjectDefinition objDef : relDec.getRelatedObjects())
            {
                if (objDef.getClass() == IfcBuildingStoreyImpl.class)
                {
                    IfcBuildingStorey storey = (IfcBuildingStorey)objDef;
                    String guid = storey.getGlobalId();
                    if (!floorGuids.contains(guid))
                    {
                        floors.add(storey);
                        floorGuids.add(guid);
                    }
                }
            }
        }
        return floors;
    }
	
	@Override
	protected List<FloorType> serializeModelObject(IfcBuildingStorey modelObject) 
	{
		List<FloorType> floors = new ArrayList<>();
        String name = "";
        String createdBy = "";
        Calendar createdOn;
        String category = "";
        String extSystem = "";
        String extObject = "";
        String extIdentifier = "";
        String description = "";
        String elevation;
        String height = "";
        
        try
        {

            IfcOwnerHistory ownerHistory = modelObject.getOwnerHistory();
            name = IfcBuildingStoreyFloorSerializer.nameFromBuildingStorey(modelObject);
            createdBy = COBieIfcUtility.getEmailFromOwnerHistory(ownerHistory);
            createdOn = IfcToContact.getCreatedOn(ownerHistory.getCreationDate());
            category = COBieIfcUtility.getObjectClassificationCategoryString(modelObject);
            extSystem = COBieIfcUtility.getApplicationName(ownerHistory);
            extObject = extObjectFromBuildingStorey(modelObject);
            extIdentifier = COBieIfcUtility.extIdFromRoot(modelObject);
            description = IfcBuildingFacilitySerializer.descriptionFromSpatialStructureElement(modelObject);
            elevation = COBieUtility.getCOBieString(elevationFromStorey(modelObject));
            height = heightFromStorey(modelObject);

            FloorType tmpFloor = getCobieSection().addNewFloor();
            tmpFloor.setName(name);
            tmpFloor.setCreatedBy(createdBy);
            tmpFloor.setCreatedOn(createdOn);
            tmpFloor.setCategory(category);
            tmpFloor.setExtSystem(extSystem);
            tmpFloor.setExtObject(extObject);
            tmpFloor.setExtIdentifier(extIdentifier);
            tmpFloor.setDescription(description);
            tmpFloor.setElevation(elevation);
            tmpFloor.setHeight(height);
            floors.add(tmpFloor);
        } catch (Exception ex)
        {
          
        }
        return floors;
	}
	
    protected String heightFromStorey(IfcBuildingStorey storey)
    {
        String height = COBieUtility.COBieNA;
        Map<String, String> properties = new HashMap<String, String>();
        ArrayList<String> names = getHeightPropertyNameMatches();
        for (IfcRelDefines def : storey.getIsDefinedBy())
        {
            properties = IfcRelationshipUtility.propertyStringsFromRelDefines(def, names);
        }
        for (String key : properties.keySet())
        {
            if (COBieUtility.isNA(height))
            {
                height = properties.get(key);
            }
        }
        return height;
    }
	
    private ArrayList<String> getHeightPropertyNameMatches() 
    {
    	ArrayList<String> names = new ArrayList<>();
    	if(getSettings() != null && getSettings().getFloorSettings() != null &&
    			getSettings().getFloorSettings().getFloorHeightPropertyNames() != null &&
    			getSettings().getFloorSettings().getFloorHeightPropertyNames().getName() != null)
    	{
    		names.addAll(getSettings().getFloorSettings().getFloorHeightPropertyNames().getName());
    	}
    	return names;
	}

	public static String nameFromBuildingStorey(IfcBuildingStorey storey)
    {
        return COBieUtility.getCOBieString(storey.getName());
    }
	
    public static String extObjectFromBuildingStorey(IfcBuildingStorey storey)
    {
        String extObject = IfcBuildingStorey.class.getSimpleName();
        if (!COBieUtility.isNA(storey.getObjectType()))
        {
            String objectType = storey.getObjectType();
            if (objectType.equalsIgnoreCase(SITE) || objectType.equalsIgnoreCase(IFC_SITE))
            {
                extObject = IFC_SITE;
            }

        }
        return extObject;
    }

}
