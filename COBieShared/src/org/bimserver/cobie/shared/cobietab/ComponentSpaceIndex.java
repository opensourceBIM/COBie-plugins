package org.bimserver.cobie.shared.cobietab;

import org.nibs.cobie.tab.ComponentType;

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
