package org.bimserver.cobie.shared.cobietab;

import java.util.List;

import org.bimserver.cobie.shared.utility.COBieUtility;
import org.nibs.cobie.tab.SpaceType;

public class FloorSpacesIndex extends NameIndex<SpaceType>
{
    private static final long serialVersionUID = 5839415144692838492L;

    public FloorSpacesIndex(SpaceType[] sourceCollection)
    {
        super(sourceCollection);
    }

    @Override
    protected String getEntryKeyField(SpaceType sourceEntry)
    {
        return sourceEntry.getFloorName();
    }

    public String getSpaceFloorName(String spaceName)
    {
        String floorName = COBieUtility.COBieNA;
        for (String key : keySet())
        {
            List<SpaceType> spaces = get(key);
            for (SpaceType space : spaces)
            {
                if (space.getName().equalsIgnoreCase(spaceName))
                {
                    floorName = key;
                    break;
                }
            }
        }
        return floorName;
    }

}
