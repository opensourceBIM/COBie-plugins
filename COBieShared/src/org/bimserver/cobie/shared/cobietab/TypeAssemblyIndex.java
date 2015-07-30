package org.bimserver.cobie.shared.cobietab;

import org.bimserver.cobie.shared.utility.COBieUtility.CobieSheetName;
import org.nibs.cobie.tab.AssemblyType;

public class TypeAssemblyIndex extends NameIndex<AssemblyType>
{
    private static final long serialVersionUID = 135850275764235746L;
    private static final boolean EXCLUDE_NA_KEYS = true;

    public TypeAssemblyIndex(AssemblyType[] sourceCollection)
    {
        super(sourceCollection, EXCLUDE_NA_KEYS);
    }

    @Override
    protected String getEntryKeyField(AssemblyType sourceEntry)
    {
        String assemblyTypeIndex = null;
        if (sourceEntry.getSheetName().equalsIgnoreCase(CobieSheetName.Type.name()))
        {
            assemblyTypeIndex = sourceEntry.getParentName();
        }
        return assemblyTypeIndex;
    }

}
