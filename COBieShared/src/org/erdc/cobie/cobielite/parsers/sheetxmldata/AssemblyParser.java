package org.erdc.cobie.cobielite.parsers.sheetxmldata;

import org.erdc.cobie.cobielite.AssemblyType;
import org.erdc.cobie.cobielite.AttributeCollectionType;
import org.erdc.cobie.cobielite.DocumentCollectionType;
import org.erdc.cobie.cobielite.IssueCollectionType;
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
