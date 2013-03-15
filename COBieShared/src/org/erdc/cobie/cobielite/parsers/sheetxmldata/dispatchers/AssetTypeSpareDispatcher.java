package org.erdc.cobie.cobielite.parsers.sheetxmldata.dispatchers;

import org.erdc.cobie.cobielite.AssetTypeInfoType;
import org.erdc.cobie.cobielite.SpareCollectionType;
import org.erdc.cobie.cobielite.SpareType;
import org.erdc.cobie.cobielite.parsers.TypicalParserDispatcher;
import org.erdc.cobie.cobielite.parsers.sheetxmldata.COBieLiteSheetXMLDataParser;
import org.erdc.cobie.cobielite.parsers.sheetxmldata.SpareParser;
import org.erdc.cobie.shared.cobiesheetxmldata.indices.IndexedCOBie;

public class AssetTypeSpareDispatcher extends
        TypicalParserDispatcher<org.erdc.cobie.sheetxmldata.SpareType, SpareCollectionType, SpareType, AssetTypeInfoType>
{

    public AssetTypeSpareDispatcher(Iterable<org.erdc.cobie.sheetxmldata.SpareType> childSourceElements, AssetTypeInfoType targetParent,
            IndexedCOBie indexedCOBie)
    {
        super(childSourceElements, targetParent, indexedCOBie);
    }

    @Override
    protected COBieLiteSheetXMLDataParser<org.erdc.cobie.sheetxmldata.SpareType, SpareType> createNewParser(
            org.erdc.cobie.sheetxmldata.SpareType sourceElement,
            SpareType newTargetElement)
    {
        return new SpareParser(sourceElement, newTargetElement, indexedCOBie);
    }

    @Override
    protected SpareType createNewTargetElement()
    {
        return targetCollection.addNewSpare();
    }

    @Override
    protected SpareCollectionType getTargetCollection()
    {
        SpareCollectionType spares = targetParent.getSpares();
        if (spares == null)
        {
            spares = targetParent.addNewSpares();
        }
        return spares;
    }

}
