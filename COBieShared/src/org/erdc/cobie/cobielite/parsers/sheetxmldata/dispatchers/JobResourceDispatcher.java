package org.erdc.cobie.cobielite.parsers.sheetxmldata.dispatchers;

import org.erdc.cobie.cobielite.JobType;
import org.erdc.cobie.cobielite.ResourceCollectionType;
import org.erdc.cobie.cobielite.ResourceType;
import org.erdc.cobie.cobielite.parsers.TypicalParserDispatcher;
import org.erdc.cobie.cobielite.parsers.sheetxmldata.COBieLiteSheetXMLDataParser;
import org.erdc.cobie.cobielite.parsers.sheetxmldata.ResourceParser;
import org.erdc.cobie.shared.cobiesheetxmldata.indices.IndexedCOBie;

public class JobResourceDispatcher extends TypicalParserDispatcher<org.erdc.cobie.sheetxmldata.ResourceType, ResourceCollectionType, ResourceType, JobType>
{

    public JobResourceDispatcher(Iterable<org.erdc.cobie.sheetxmldata.ResourceType> childSourceElements, JobType targetParent,
            IndexedCOBie indexedCOBie)
    {
        super(childSourceElements, targetParent, indexedCOBie);
    }

    @Override
    protected COBieLiteSheetXMLDataParser<org.erdc.cobie.sheetxmldata.ResourceType, ResourceType> createNewParser(
            org.erdc.cobie.sheetxmldata.ResourceType sourceElement,
            ResourceType newTargetElement)
    {
        return new ResourceParser(sourceElement, newTargetElement, indexedCOBie);
    }

    @Override
    protected ResourceType createNewTargetElement()
    {
        return targetCollection.addNewResource();
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
