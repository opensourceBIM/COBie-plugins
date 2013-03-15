package org.erdc.cobie.shared.cobiesheetxmldata.indices;

import org.erdc.cobie.sheetxmldata.ComponentType;

public class ComponentSpaceIndex extends NameIndex<ComponentType>
{
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
