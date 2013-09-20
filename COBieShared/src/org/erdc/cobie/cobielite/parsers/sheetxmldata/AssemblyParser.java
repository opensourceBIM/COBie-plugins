package org.erdc.cobie.cobielite.parsers.sheetxmldata;


import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.AssemblyType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.AttributeCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.DocumentCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.IssueCollectionType;
import org.erdc.cobie.shared.cobiesheetxmldata.indices.IndexedCOBie;

public class AssemblyParser extends TypicalParser<org.erdc.cobie.sheetxmldata.AssemblyType, AssemblyType>
{

    public AssemblyParser(org.erdc.cobie.sheetxmldata.AssemblyType cobieSheetXMLData, AssemblyType cobieLiteRowData, IndexedCOBie indexedCOBie)
    {
        super(cobieSheetXMLData, cobieLiteRowData, indexedCOBie);
    }

    @Override
    public AttributeCollectionType getNewAttributes()
    {
        return targetCOBie.addNewAssemblyAttributes();
    }

    @Override
    public DocumentCollectionType getNewDocuments()
    {
        return targetCOBie.addNewAssemblyDocuments();
    }

    @Override
    public IssueCollectionType getNewIssues()
    {
        return targetCOBie.addNewAssemblyIssues();
    }

    @Override
    protected void parseComplexElements()
    {
        // Nothing to do
    }

    @Override
    protected void parseSimpleElements()
    {        
        targetCOBie.setAssemblyCategory(sourceCOBie.getAssemblyType());
        targetCOBie.setAssemblyDescription(sourceCOBie.getDescription());
        targetCOBie.setAssemblyName(sourceCOBie.getName());
        targetCOBie.setAssemblyParentName(sourceCOBie.getParentName());
        targetCOBie.setExternalEntityName(sourceCOBie.getExtObject());
        targetCOBie.setExternalID(sourceCOBie.getExtIdentifier());
        targetCOBie.setExternalSystemName(sourceCOBie.getExtSystem());
    }

}
