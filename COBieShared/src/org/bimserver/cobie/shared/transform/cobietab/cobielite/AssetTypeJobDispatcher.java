package org.bimserver.cobie.shared.transform.cobietab.cobielite;


import org.bimserver.cobie.shared.cobietab.IndexedCOBie;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.AssetTypeInfoType;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.JobDocument;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.JobType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.JobCollectionType;

public class AssetTypeJobDispatcher extends TypicalParserDispatcher<org.nibs.cobie.tab.JobType, JobCollectionType, JobType, AssetTypeInfoType>
{

    public AssetTypeJobDispatcher(Iterable<org.nibs.cobie.tab.JobType> childSourceElements, AssetTypeInfoType targetParent,
            IndexedCOBie indexedCOBie)
    {
        super(childSourceElements, targetParent, indexedCOBie);
    }

    @Override
    protected COBieTabTransformer<org.nibs.cobie.tab.JobType, JobType> createNewParser(
            org.nibs.cobie.tab.JobType sourceElement,
            JobType newTargetElement)
    {
        return new JobTransformer(sourceElement, newTargetElement, indexedCOBie);
    }

    @Override
    protected JobType createNewTargetElement()
    {
        return (JobType)targetCollection.addNewJob().substitute(JobDocument.type.getDocumentElementName(), JobType.type);
    }

    @Override
    protected JobCollectionType getTargetCollection()
    {
        JobCollectionType jobs = targetParent.getJobs();
        if (jobs == null)
        {
            jobs = targetParent.addNewJobs();
        }
        return jobs;
    }

}
