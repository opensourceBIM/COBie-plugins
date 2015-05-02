package org.bimserver.cobie.shared.cobietab;

import org.nibs.cobie.tab.ZoneType;

public class SpaceZonesIndex extends NameIndex<ZoneType>
{

    /**
     * 
     */
    private static final long serialVersionUID = -5748362683047675101L;

    public SpaceZonesIndex(ZoneType[] sourceCollection)
    {
        super(sourceCollection);
    }

    @Override
    protected String getEntryKeyField(ZoneType sourceEntry)
    {
        return sourceEntry.getSpaceNames();
    }

}
