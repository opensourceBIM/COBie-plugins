package org.erdc.cobie.cobielite.parsers.sheetxmldata;

import java.util.ArrayList;

import org.erdc.cobie.cobielite.parsers.COBieLiteParserDispatcher;
import org.erdc.cobie.shared.cobiesheetxmldata.indices.IndexedCOBie;
import org.erdc.cobie.sheetxmldata.COBIEBaseType;

public abstract class DeepParser<COBIE_SHEET_XML_DATA_TYPE extends COBIEBaseType, COBIE_LITE_DATA_TYPE extends org.erdc.cobie.cobielite.CobieBaseType>
        extends TypicalParser<COBIE_SHEET_XML_DATA_TYPE, COBIE_LITE_DATA_TYPE>
{
    public DeepParser(COBIE_SHEET_XML_DATA_TYPE cobieSheetXMLData, COBIE_LITE_DATA_TYPE cobieLiteRowData, IndexedCOBie indexedCOBie)
    {
        super(cobieSheetXMLData, cobieLiteRowData, indexedCOBie);
    }

    @SuppressWarnings("rawtypes")
    protected abstract ArrayList<COBieLiteParserDispatcher> getChildParsingDispatchers();

    protected abstract void parseChildLeaves();

    @Override
    protected void parseComplexElements()
    {
        parseChildLeaves();
        @SuppressWarnings("rawtypes")
        ArrayList<COBieLiteParserDispatcher> dispatchers = getChildParsingDispatchers();
        for (@SuppressWarnings("rawtypes") COBieLiteParserDispatcher dispatcher : dispatchers)
        {
            dispatcher.dispatchParsers();
        }
    }

}
