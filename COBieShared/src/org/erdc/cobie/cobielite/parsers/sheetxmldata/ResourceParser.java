package org.erdc.cobie.cobielite.parsers.sheetxmldata;


import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.ResourceType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.AttributeCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.DocumentCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.IssueCollectionType;
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
        return targetCOBie.addNewResourceAttributes();
    }

    @Override
    public DocumentCollectionType getNewDocuments()
    {
        return targetCOBie.addNewResourceDocuments();
    }

    @Override
    public IssueCollectionType getNewIssues()
    {
        return targetCOBie.addNewResourceIssues();
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
