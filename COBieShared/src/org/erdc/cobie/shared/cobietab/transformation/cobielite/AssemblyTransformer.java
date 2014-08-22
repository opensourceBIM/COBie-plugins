package org.erdc.cobie.shared.cobietab.transformation.cobielite;


import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.AssemblyType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.AttributeCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.DocumentCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.IssueCollectionType;
import org.erdc.cobie.shared.cobietab.IndexedCOBie;

public class AssemblyTransformer extends ChildTransformer<org.erdc.cobie.sheetxmldata.AssemblyType, AssemblyType>
{

    public AssemblyTransformer(org.erdc.cobie.sheetxmldata.AssemblyType cobieSheetXMLData, AssemblyType cobieLiteRowData, IndexedCOBie indexedCOBie)
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
