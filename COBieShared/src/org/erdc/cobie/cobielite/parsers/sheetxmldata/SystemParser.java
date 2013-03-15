package org.erdc.cobie.cobielite.parsers.sheetxmldata;

import org.erdc.cobie.cobielite.AttributeCollectionType;
import org.erdc.cobie.cobielite.DocumentCollectionType;
import org.erdc.cobie.cobielite.IssueCollectionType;
import org.erdc.cobie.cobielite.SystemType;
import org.erdc.cobie.shared.cobiesheetxmldata.indices.IndexedCOBie;

public class SystemParser extends TypicalParser<org.erdc.cobie.sheetxmldata.SystemType, SystemType>
{

    public SystemParser(org.erdc.cobie.sheetxmldata.SystemType cobieSheetXMLData, SystemType cobieLiteRowData, IndexedCOBie indexedCOBie)
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
        targetCOBie.setExternalEntityName(sourceCOBie.getExtObject());
        targetCOBie.setExternalID(sourceCOBie.getExtIdentifier());
        targetCOBie.setExternalSystemName(sourceCOBie.getExtSystem());
        targetCOBie.setSystemCategory(sourceCOBie.getCategory());
        targetCOBie.setSystemDescription(sourceCOBie.getDescription());
        targetCOBie.setSystemName(sourceCOBie.getName());

    }

}
