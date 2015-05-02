package org.bimserver.cobie.shared.transform.cobietab.cobielite;


import org.bimserver.cobie.shared.cobietab.IndexedCOBie;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.JobType;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.ResourceDocument;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.ResourceType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.ResourceCollectionType;

public class JobResourceDispatcher extends TypicalParserDispatcher<org.nibs.cobie.tab.ResourceType, ResourceCollectionType, ResourceType, JobType>
{

    public JobResourceDispatcher(Iterable<org.nibs.cobie.tab.ResourceType> childSourceElements, JobType targetParent,
            IndexedCOBie indexedCOBie)
    {
        super(childSourceElements, targetParent, indexedCOBie);
    }

    @Override
    protected COBieTabTransformer<org.nibs.cobie.tab.ResourceType, ResourceType> createNewParser(
            org.nibs.cobie.tab.ResourceType sourceElement,
            ResourceType newTargetElement)
    {
        return new ResourceTransformer(sourceElement, newTargetElement, indexedCOBie);
    }

    @Override
    protected ResourceType createNewTargetElement()
    {
        return (ResourceType)targetCollection.addNewResource().substitute(ResourceDocument.type.getDocumentElementName(), ResourceType.type);
    }

    @Override
    protected ResourceCollectionType getTargetCollection()
    {
        ResourceCollectionType resources = targetParent.getResources();
        if (resources == null)
        {
            resources = targetParent.addNewResources();
        }
        return resources;
    }

}
