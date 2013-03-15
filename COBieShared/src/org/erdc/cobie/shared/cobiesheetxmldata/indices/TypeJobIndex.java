package org.erdc.cobie.shared.cobiesheetxmldata.indices;

import org.erdc.cobie.sheetxmldata.JobType;

public class TypeJobIndex extends NameIndex<JobType>
{

    public TypeJobIndex(JobType[] sourceCollection)
    {
        super(sourceCollection);
    }

    @Override
    protected String getEntryKeyField(JobType sourceEntry)
    {
        return sourceEntry.getTypeName();
    }

}
