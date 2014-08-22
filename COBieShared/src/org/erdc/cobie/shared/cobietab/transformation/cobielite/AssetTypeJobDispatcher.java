package org.erdc.cobie.shared.cobietab.transformation.cobielite;


import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.AssetTypeInfoType;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.JobDocument;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.JobType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.JobCollectionType;
import org.erdc.cobie.shared.cobietab.IndexedCOBie;

public class AssetTypeJobDispatcher extends TypicalParserDispatcher<org.erdc.cobie.sheetxmldata.JobType, JobCollectionType, JobType, AssetTypeInfoType>
{

    public AssetTypeJobDispatcher(Iterable<org.erdc.cobie.sheetxmldata.JobType> childSourceElements, AssetTypeInfoType targetParent,
            IndexedCOBie indexedCOBie)
    {
        super(childSourceElements, targetParent, indexedCOBie);
    }

    @Override
    protected COBieTabTransformer<org.erdc.cobie.sheetxmldata.JobType, JobType> createNewParser(
            org.erdc.cobie.sheetxmldata.JobType sourceElement,
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
