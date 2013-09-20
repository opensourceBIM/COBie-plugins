package org.erdc.cobie.cobielite.parsers.sheetxmldata;


import org.buildingsmartalliance.docs.nbims03.cobie.core.AttributeCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.DocumentCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.IssueCollectionType;
import org.erdc.cobie.shared.cobiesheetxmldata.indices.IndexedCOBie;
import org.erdc.cobie.sheetxmldata.ZoneType;

public class ZoneParser extends TypicalParser<ZoneType, org.buildingsmartalliance.docs.nbims03.cobie.cobielite.ZoneType>
{

    public ZoneParser(ZoneType cobieSheetXMLData, org.buildingsmartalliance.docs.nbims03.cobie.cobielite.ZoneType cobieLiteRowData, IndexedCOBie indexedCOBie)
    {
        super(cobieSheetXMLData, cobieLiteRowData, indexedCOBie);
    }

    @Override
    public AttributeCollectionType getNewAttributes()
    {
        return targetCOBie.addNewZoneAttributes();
    }

    @Override
    public DocumentCollectionType getNewDocuments()
    {
        return targetCOBie.addNewZoneDocuments();
    }

    @Override
    public IssueCollectionType getNewIssues()
    {
        return targetCOBie.addNewZoneIssues();
    }

    @Override
    protected void parseComplexElements()
    {
        // No complex elements to parse
    }

    @Override
    protected void parseSimpleElements()
    {
        targetCOBie.setExternalEntityName(sourceCOBie.getExtObject());
        targetCOBie.setExternalID(sourceCOBie.getExtIdentifier());
        targetCOBie.setExternalSystemName(sourceCOBie.getExtSystem());
        targetCOBie.setZoneCategory(sourceCOBie.getCategory());
        targetCOBie.setZoneDescription(sourceCOBie.getDescription());
        targetCOBie.setZoneName(sourceCOBie.getName());

    }

}
