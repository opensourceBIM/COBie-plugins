package org.bimserver.cobie.shared.transform.cobietab.cobielite;


import org.bimserver.cobie.shared.cobietab.IndexedCOBie;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.ResourceType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.AttributeCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.DocumentCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.IssueCollectionType;

public class ResourceTransformer extends ChildTransformer<org.nibs.cobie.tab.ResourceType, ResourceType>
{

    public ResourceTransformer(org.nibs.cobie.tab.ResourceType cobieSheetXMLData, ResourceType cobieLiteRowData, IndexedCOBie indexedCOBie)
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
