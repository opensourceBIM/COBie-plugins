package org.erdc.cobie.cobielite.parsers.sheetxmldata.dispatchers;

import org.erdc.cobie.cobielite.IssueCollectionType;
import org.erdc.cobie.cobielite.IssueType;
import org.erdc.cobie.cobielite.parsers.TypicalParserDispatcher;
import org.erdc.cobie.cobielite.parsers.sheetxmldata.COBieLiteSheetXMLDataParser;
import org.erdc.cobie.shared.cobiesheetxmldata.indices.IndexedCOBie;
import org.erdc.cobie.sheetxmldata.COBIEBaseType;

public class IssueDispatcher extends TypicalParserDispatcher<org.erdc.cobie.sheetxmldata.IssueType, IssueCollectionType, IssueType, COBIEBaseType>
{
    public IssueDispatcher(Iterable<org.erdc.cobie.sheetxmldata.IssueType> childSourceElements, COBIEBaseType targetParent,
            IndexedCOBie indexedCOBie, IssueCollectionType issues)
    {
        super(childSourceElements, targetParent, indexedCOBie);
    }

    @Override
    protected COBieLiteSheetXMLDataParser<org.erdc.cobie.sheetxmldata.IssueType, IssueType> createNewParser(
            org.erdc.cobie.sheetxmldata.IssueType sourceElement,
            IssueType newTargetElement)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected IssueType createNewTargetElement()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected IssueCollectionType getTargetCollection()
    {
        // targetParent.
        // TODO Auto-generated method stub
        return null;
    }

}
