package org.erdc.cobie.cobielite.parsers.sheetxmldata;

import org.erdc.cobie.cobielite.AttributeCollectionType;
import org.erdc.cobie.cobielite.DocumentCollectionType;
import org.erdc.cobie.cobielite.IssueCollectionType;
import org.erdc.cobie.cobielite.ResourceType;
import org.erdc.cobie.shared.cobiesheetxmldata.indices.IndexedCOBie;

public class ResourceParser extends TypicalParser<org.erdc.cobie.sheetxmldata.ResourceType, ResourceType>
{

    public ResourceParser(org.erdc.cobie.sheetxmldata.ResourceType cobieSheetXMLData, ResourceType cobieLiteRowData, IndexedCOBie indexedCOBie)
    {
        super(cobieSheetXMLData, cobieLiteRowData, indexedCOBie);
    }

    @Override
    public AttributeCollectionType getNewAttributes()
    {
        return targetCOBie.addNewAttributes();
    }

    @Override
    public DocumentCollectionType getNewDocuments()
    {
        return targetCOBie.addNewDocuments();
    }

    @Override
    public IssueCollectionType getNewIssues()
    {
        return targetCOBie.addNewIssues();
    }

    @Override
    protected void parseComplexElements()
    {
        // nothing to do

    }

    @Override
    protected void parseSimpleElements()
    {
        targetCOBie.setExternalEntityName(sourceCOBie.getExtObject());
        targetCOBie.setExternalID(sourceCOBie.getExtIdentifier());
        targetCOBie.setExternalSystemName(sourceCOBie.getExtSystem());
        targetCOBie.setResourceCategory(sourceCOBie.getCategory());
        targetCOBie.setResourceDescription(sourceCOBie.getDescription());
        targetCOBie.setResourceName(sourceCOBie.getName());

    }

}
