package org.erdc.cobie.shared.cobiesheetxmldata.indices;

import org.erdc.cobie.sheetxmldata.ComponentType;

public class TypeComponentIndex extends NameIndex<ComponentType>
{

    /**
     * 
     */
    private static final long serialVersionUID = -2339552468900783215L;

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
