package org.erdc.cobie.shared.cobiesheetxmldata.indices;

import org.erdc.cobie.shared.COBieUtility.CobieSheetName;
import org.erdc.cobie.sheetxmldata.AssemblyType;

public class ComponentAssemblyIndex extends NameIndex<AssemblyType>
{
    private static final long serialVersionUID = 1997892507002001982L;
    private static final boolean EXCLUDE_NA_KEYS = true;

    public ComponentAssemblyIndex(AssemblyType[] sourceCollection)
    {
        super(sourceCollection, EXCLUDE_NA_KEYS);
    }

    @Override
    protected String getEntryKeyField(AssemblyType sourceEntry)
    {
        String parentName = null;
        if (sourceEntry.getSheetName().equalsIgnoreCase(CobieSheetName.Component.name()))
        {
            parentName = sourceEntry.getParentName();
        }
        return parentName;
    }

}
