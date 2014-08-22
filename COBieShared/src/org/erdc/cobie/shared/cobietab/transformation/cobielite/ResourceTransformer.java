package org.erdc.cobie.shared.cobietab.transformation.cobielite;


import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.ResourceType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.AttributeCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.DocumentCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.IssueCollectionType;
import org.erdc.cobie.shared.cobietab.IndexedCOBie;

public class ResourceTransformer extends ChildTransformer<org.erdc.cobie.sheetxmldata.ResourceType, ResourceType>
{

    public ResourceTransformer(org.erdc.cobie.sheetxmldata.ResourceType cobieSheetXMLData, ResourceType cobieLiteRowData, IndexedCOBie indexedCOBie)
    {
        super(cobieSheetXMLData, cobieLiteRowData, indexedCOBie);
    }

    @Override
    public AttributeCollectionType getNewAttributes()
    {
        return target.addNewResourceAttributes();
    }

    @Override
    public DocumentCollectionType getNewDocuments()
    {
        return target.addNewResourceDocuments();
    }

    @Override
    public IssueCollectionType getNewIssues()
    {
        return target.addNewResourceIssues();
    }

    @Override
    protected void parseComplexElements()
    {
        // nothing to do

    }

    @Override
    protected void parseSimpleElements()
    {
        target.setExternalEntityName(source.getExtObject());
        target.setExternalID(source.getExtIdentifier());
        target.setExternalSystemName(source.getExtSystem());
        target.setResourceCategory(source.getCategory());
        target.setResourceDescription(source.getDescription());
        target.setResourceName(source.getName());

    }

}
