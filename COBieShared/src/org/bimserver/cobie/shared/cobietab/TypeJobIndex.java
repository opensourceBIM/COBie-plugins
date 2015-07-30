package org.bimserver.cobie.shared.cobietab;

import org.nibs.cobie.tab.JobType;

public class TypeJobIndex extends NameIndex<JobType>
{

    /**
     * 
     */
    private static final long serialVersionUID = -5447302505503826119L;

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
