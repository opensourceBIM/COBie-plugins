package org.erdc.cobie.shared.cobietab.transformation.cobielite;


import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.JobType;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.ResourceDocument;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.ResourceType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.ResourceCollectionType;
import org.erdc.cobie.shared.cobietab.IndexedCOBie;

public class JobResourceDispatcher extends TypicalParserDispatcher<org.erdc.cobie.sheetxmldata.ResourceType, ResourceCollectionType, ResourceType, JobType>
{

    public JobResourceDispatcher(Iterable<org.erdc.cobie.sheetxmldata.ResourceType> childSourceElements, JobType targetParent,
            IndexedCOBie indexedCOBie)
    {
        super(childSourceElements, targetParent, indexedCOBie);
    }

    @Override
    protected COBieTabTransformer<org.erdc.cobie.sheetxmldata.ResourceType, ResourceType> createNewParser(
            org.erdc.cobie.sheetxmldata.ResourceType sourceElement,
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
