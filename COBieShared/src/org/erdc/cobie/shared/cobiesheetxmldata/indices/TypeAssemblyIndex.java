package org.erdc.cobie.shared.cobiesheetxmldata.indices;

import org.erdc.cobie.shared.COBieUtility.CobieSheetName;
import org.erdc.cobie.sheetxmldata.AssemblyType;

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
