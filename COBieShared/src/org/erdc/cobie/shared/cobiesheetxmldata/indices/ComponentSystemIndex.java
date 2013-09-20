package org.erdc.cobie.shared.cobiesheetxmldata.indices;

import org.erdc.cobie.sheetxmldata.SystemType;

public class ComponentSystemIndex extends NameIndex<SystemType>
{
    private static final long serialVersionUID = -3976982377899286311L;

    public ComponentSystemIndex(SystemType[] sourceCollection)
    {
        super(sourceCollection);
    }

    @Override
    protected String getEntryKeyField(SystemType sourceEntry)
    {
        return sourceEntry.getComponentNames();
    }

}
