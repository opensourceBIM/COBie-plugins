package org.erdc.cobie.cobielite.parsers.sheetxmldata;

import org.erdc.cobie.cobielite.AttributeCollectionType;
import org.erdc.cobie.cobielite.DocumentCollectionType;
import org.erdc.cobie.cobielite.IssueCollectionType;
import org.erdc.cobie.cobielite.parsers.sheetxmldata.dispatchers.AttributeDocumentIssueHelper;
import org.erdc.cobie.shared.cobiesheetxmldata.indices.IndexedCOBie;
import org.erdc.cobie.sheetxmldata.COBIEBaseType;

public abstract class TypicalParser<COBIE_SHEET_XML_DATA_TYPE extends COBIEBaseType, COBIE_LITE_DATA_TYPE extends org.erdc.cobie.cobielite.CobieBaseType>
        extends COBieLiteCOBIEBaseTypeParser<COBIE_SHEET_XML_DATA_TYPE, COBIE_LITE_DATA_TYPE>
{

    public TypicalParser(COBIE_SHEET_XML_DATA_TYPE cobieSheetXMLData, COBIE_LITE_DATA_TYPE cobieLiteRowData, IndexedCOBie indexedCOBie)
    {
        super(cobieSheetXMLData, cobieLiteRowData, indexedCOBie);
        // TODO Auto-generated constructor stub
    }

    public abstract AttributeCollectionType getNewAttributes();

    public abstract DocumentCollectionType getNewDocuments();

    public abstract IssueCollectionType getNewIssues();

    @Override
    protected final void parseAttributes() throws Exception
    {
        AttributeDocumentIssueHelper.parseAttributes(getNewAttributes(), descriptiveData, indexedCOBie);
    }

    @Override
    protected final void parseDocuments() throws Exception
    {
        AttributeDocumentIssueHelper.parseDocuments(getNewDocuments(), descriptiveData, indexedCOBie);

    }

    @Override
    protected final void parseIssues() throws Exception
    {
        AttributeDocumentIssueHelper.parseIssues(getNewIssues(), descriptiveData, indexedCOBie);

    }

}
