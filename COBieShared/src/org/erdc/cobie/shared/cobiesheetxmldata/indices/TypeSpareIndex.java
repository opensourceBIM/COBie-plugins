package org.erdc.cobie.shared.cobiesheetxmldata.indices;

import org.erdc.cobie.sheetxmldata.SpareType;

public class TypeSpareIndex extends NameIndex<SpareType>
{

    /**
     * 
     */
    private static final long serialVersionUID = -3296718204382349746L;

    public TypeSpareIndex(SpareType[] sourceCollection)
    {
        super(sourceCollection);
    }

    @Override
    protected String getEntryKeyField(SpareType sourceEntry)
    {
        return sourceEntry.getTypeName();
    }

}
