package org.bimserver.cobie.shared.transform.cobietab.cobielite;


import org.bimserver.cobie.shared.cobietab.IndexedCOBie;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.AssemblyType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.AttributeCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.DocumentCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.IssueCollectionType;

public class AssemblyTransformer extends ChildTransformer<org.nibs.cobie.tab.AssemblyType, AssemblyType>
{

    public AssemblyTransformer(org.nibs.cobie.tab.AssemblyType cobieSheetXMLData, AssemblyType cobieLiteRowData, IndexedCOBie indexedCOBie)
    {
        super(cobieSheetXMLData, cobieLiteRowData, indexedCOBie);
    }

    @Override
    public AttributeCollectionType getNewAttributes()
    {
        return target.addNewAssemblyAttributes();
    }

    @Override
    public DocumentCollectionType getNewDocuments()
    {
        return target.addNewAssemblyDocuments();
    }

    @Override
    public IssueCollectionType getNewIssues()
    {
        return target.addNewAssemblyIssues();
    }

    @Override
    protected void parseComplexElements()
    {
        // Nothing to do
    }

    @Override
    protected void parseSimpleElements()
    {        
        target.setAssemblyCategory(source.getAssemblyType());
        target.setAssemblyDescription(source.getDescription());
        target.setAssemblyName(source.getName());
        target.setAssemblyParentName(source.getParentName());
        target.setExternalEntityName(source.getExtObject());
        target.setExternalID(source.getExtIdentifier());
        target.setExternalSystemName(source.getExtSystem());
    }

}
