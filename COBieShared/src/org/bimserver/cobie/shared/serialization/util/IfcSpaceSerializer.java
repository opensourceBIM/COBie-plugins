package org.bimserver.cobie.shared.serialization.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.bimserver.cobie.shared.serialization.IfcCobieSerializer;
import org.bimserver.cobie.shared.utility.COBieIfcUtility;
import org.bimserver.cobie.shared.utility.COBieUtility;
import org.bimserver.cobie.shared.utility.ifc.IfcRelationshipUtility;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.ifc2x3tc1.IfcBuildingStorey;
import org.bimserver.models.ifc2x3tc1.IfcObjectDefinition;
import org.bimserver.models.ifc2x3tc1.IfcOwnerHistory;
import org.bimserver.models.ifc2x3tc1.IfcRelDecomposes;
import org.bimserver.models.ifc2x3tc1.IfcSpace;
import org.nibs.cobie.tab.COBIEType;
import org.nibs.cobie.tab.COBIEType.Spaces;
import org.nibs.cobie.tab.SpaceType;

import com.prairiesky.transform.cobieifc.settings.SettingsType;

public class IfcSpaceSerializer extends
		IfcCobieSerializer<SpaceType, COBIEType.Spaces, IfcSpace> 
{

	protected static enum GrossAreaPropertyName
    {
		
        GrossFloorArea("GrossFloorArea"), GSA("GSA");
        private final String text;
        private GrossAreaPropertyName(String text)
        {
        	this.text = text;
        }
        
        @Override
        public String toString()
        {
        	return text;
        }
    }

    protected static enum NetAreaPropertyName
    {
        NetFloorArea("NetFloorArea"), GSA("GSA");
        private final String text;
        private NetAreaPropertyName(String text)
        {
        	this.text = text;
        }
        
        @Override
        public String toString()
        {
        	return text;
        }
    }

    protected static enum RoomTagPropertyName
    {
        RoomTag("RoomTag"), Tag("Tag"), Room_Tag("Room Tag");
        private final String text;
        private RoomTagPropertyName(String text)
        {
        	this.text = text;
        }
        
        @Override 
        public String toString()
        {
        	return text;
        }
    }

    protected static enum UsableHeightPropertyName
    {
        FinishCeilingHeight("FinishCeilingHeight"), Height("Height"), UsableHeight("UsableHeight");
        private final String text;
        private UsableHeightPropertyName(String text)
        {
        	this.text = text;
        }
        
        @Override
        public String toString()
        {
        	return text;
        }
    };
    
	public IfcSpaceSerializer(Spaces cobieSection, IfcModelInterface model,
			SettingsType settings) 
	{
		super(cobieSection, model, settings);
	}

	@Override
	protected List<IfcSpace> getTopLevelModelObjects() 
	{
		return model.getAll(IfcSpace.class);
	}

	@Override
	protected List<SpaceType> serializeModelObject(IfcSpace modelObject) 
	{
		List<SpaceType> spaces = new ArrayList<>();
		String name = "";
        String createdBy = "";
        Calendar createdOn;
        String category = "";
        String floorName = "";
        String description = "";
        String extSystem = "";
        String extObject = "";
        String extIdentifier = "";
        String roomTag = "";
        String usableHeight = "";
        String grossArea = "";
        String netArea = "";
        try
        {
            IfcOwnerHistory oh = modelObject.getOwnerHistory();
            name = IfcSpaceSerializer.nameFromSpace(modelObject);
            createdBy = COBieIfcUtility.getEmailFromOwnerHistory(oh);
            createdOn = IfcToContact.getCreatedOn(oh.getCreationDate());
            category = COBieIfcUtility.getObjectClassificationCategoryString(modelObject);
            floorName = IfcSpaceSerializer.floorNameFromSpace(modelObject);
            description = IfcSpaceSerializer.descriptionFromSpace(modelObject);
            extSystem = COBieIfcUtility.getApplicationName(oh);
            extObject = IfcSpace.class.getSimpleName();
            extIdentifier = COBieIfcUtility.extIdFromRoot(modelObject);
            roomTag = IfcSpaceSerializer.roomTagFromSpace(modelObject);
            usableHeight = IfcSpaceSerializer.usableHeightFromSpace(modelObject);
            grossArea = IfcSpaceSerializer.grossAreaFromSpace(modelObject);
            netArea = IfcSpaceSerializer.netAreaFromSpace(modelObject);

            SpaceType space = getCobieSection().addNewSpace();
            space.setName(name);
            space.setCreatedBy(createdBy);
            space.setCreatedOn(createdOn);
            space.setCategory(category);
            space.setFloorName(floorName);
            space.setDescription(description);
            space.setExtSystem(extSystem);
            space.setExtObject(extObject);
            space.setExtIdentifier(extIdentifier);
            space.setRoomTag(roomTag);
            space.setUsableHeight(usableHeight);
            space.setGrossArea(grossArea);
            space.setNetArea(netArea);
            spaces.add(space);
        } 
        catch (Exception ex)
        {

        }
		return spaces;
	}
	
    public static IfcBuildingStorey buildingStoreyFromSpace(IfcSpace space)
    {
        String floorName = "";
        IfcBuildingStorey storey = null;
        for (IfcRelDecomposes decomp : space.getDecomposes())
        {
            IfcObjectDefinition relatedObj = decomp.getRelatingObject();
            if ((relatedObj instanceof IfcBuildingStorey) && (floorName.length() == 0))
            {
                storey = (IfcBuildingStorey)relatedObj;
            }
        }
        return storey;
    }

    protected static String descriptionFromSpace(IfcSpace space)
    {
        String desc = "";
        try
        {
            desc = space.getDescription();
        } catch (Exception e)
        {

        }
        if (COBieUtility.isNA(desc))
        {
            try
            {
                desc = space.getLongName();
                if (COBieUtility.isNA(desc))
                {
                    desc = space.getName();
                }
            } catch (Exception e)
            {

            }
        }

        return COBieUtility.getCOBieString(desc);
    }

    public static String floorNameFromSpace(IfcSpace space)
    {
        String floorName = "";
        IfcBuildingStorey storey = buildingStoreyFromSpace(space);
        if (storey != null)
        {
            floorName = storey.getName();
        }
        return COBieUtility.getCOBieString(floorName);
    }

    protected static String grossAreaFromSpace(IfcSpace space)
    {
        String height = "";
        ArrayList<String> names = new ArrayList<String>();
        for (GrossAreaPropertyName h : GrossAreaPropertyName.values())
        {
            names.add(h.toString());
        }
        height = IfcRelationshipUtility.getHighestRankingPropertyStringFromRelDefinesList(space.getIsDefinedBy(), names, false);
        return COBieUtility.getCOBieString(height);
    }

    public static String nameFromSpace(IfcSpace space)
    {
        return COBieUtility.getCOBieString(space.getName());
    }

    protected static String netAreaFromSpace(IfcSpace space)
    {
        String height = "";
        ArrayList<String> names = new ArrayList<String>();
        for (NetAreaPropertyName h : NetAreaPropertyName.values())
        {
            names.add(h.toString());
        }
        height = IfcRelationshipUtility.getHighestRankingPropertyStringFromRelDefinesList(space.getIsDefinedBy(), names, false);
        return COBieUtility.getCOBieString(height);
    }

    protected static String roomTagFromSpace(IfcSpace space)
    {
        String roomTag = "";
        ArrayList<String> names = new ArrayList<String>();
        // /TODO: create a config file with these workaround strings
        for (RoomTagPropertyName r : RoomTagPropertyName.values())
        {
            names.add(r.toString());
        }
        roomTag = IfcRelationshipUtility.getHighestRankingPropertyStringFromRelDefinesList(space.getIsDefinedBy(), names, false);
        return COBieUtility.getCOBieString(roomTag);
    }

    protected static String usableHeightFromSpace(IfcSpace space)
    {
        String height = "";
        ArrayList<String> names = new ArrayList<String>();
        for (UsableHeightPropertyName h : UsableHeightPropertyName.values())
        {
            names.add(h.toString());
        }
        height = IfcRelationshipUtility.getHighestRankingPropertyStringFromRelDefinesList(space.getIsDefinedBy(), names, false);
        return COBieUtility.getCOBieString(height);
    }

}
