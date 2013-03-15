package org.erdc.cobie.shared.cobiesheetxmldata.indices;

import org.erdc.cobie.sheetxmldata.ComponentType;

public class TypeComponentIndex extends NameIndex<ComponentType>
{

    public TypeComponentIndex(ComponentType[] sourceCollection)
    {
        super(sourceCollection);
    }

    @Override
    protected String getEntryKeyField(ComponentType sourceEntry)
    {
        return sourceEntry.getTypeName();
    }

}
