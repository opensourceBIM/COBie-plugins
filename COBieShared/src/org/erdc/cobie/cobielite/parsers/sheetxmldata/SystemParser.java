package org.erdc.cobie.cobielite.parsers.sheetxmldata;


import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.SystemType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.AttributeCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.DocumentCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.IssueCollectionType;
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
        return targetCOBie.addNewSystemAttributes();
    }

    @Override
    public DocumentCollectionType getNewDocuments()
    {
        return targetCOBie.addNewSystemDocuments();
    }

    @Override
    public IssueCollectionType getNewIssues()
    {
        return targetCOBie.addNewSystemIssues();
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
