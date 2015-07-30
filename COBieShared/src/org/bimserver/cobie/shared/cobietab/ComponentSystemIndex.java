package org.bimserver.cobie.shared.cobietab;

import org.nibs.cobie.tab.SystemType;

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
