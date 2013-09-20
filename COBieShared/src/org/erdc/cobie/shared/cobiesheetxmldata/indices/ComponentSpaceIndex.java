package org.erdc.cobie.shared.cobiesheetxmldata.indices;

import org.erdc.cobie.sheetxmldata.ComponentType;

public class ComponentSpaceIndex extends NameIndex<ComponentType>
{
    /**
     * 
     */
    private static final long serialVersionUID = 8617332490182212362L;

    public ComponentSpaceIndex(ComponentType[] sourceCollection)
    {
        super(sourceCollection);
    }

    @Override
    protected String getEntryKeyField(ComponentType sourceEntry)
    {
        return sourceEntry.getSpace();
    }

}
