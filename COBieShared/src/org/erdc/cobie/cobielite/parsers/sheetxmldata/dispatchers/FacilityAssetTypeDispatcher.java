package org.erdc.cobie.cobielite.parsers.sheetxmldata.dispatchers;

import org.erdc.cobie.cobielite.AssetTypeCollectionType;
import org.erdc.cobie.cobielite.AssetTypeInfoType;
import org.erdc.cobie.cobielite.FacilityType;
import org.erdc.cobie.cobielite.parsers.TypicalParserDispatcher;
import org.erdc.cobie.cobielite.parsers.sheetxmldata.AssetTypeParser;
import org.erdc.cobie.cobielite.parsers.sheetxmldata.COBieLiteSheetXMLDataParser;
import org.erdc.cobie.shared.cobiesheetxmldata.indices.IndexedCOBie;
import org.erdc.cobie.sheetxmldata.TypeType;

public class FacilityAssetTypeDispatcher extends
        TypicalParserDispatcher<org.erdc.cobie.sheetxmldata.TypeType, AssetTypeCollectionType, AssetTypeInfoType, FacilityType>
{

    public FacilityAssetTypeDispatcher(Iterable<TypeType> childSourceElements, FacilityType targetParent, IndexedCOBie indexedCOBie)
    {
        super(childSourceElements, targetParent, indexedCOBie);
    }

    @Override
    protected COBieLiteSheetXMLDataParser<TypeType, AssetTypeInfoType> createNewParser(TypeType sourceElement, AssetTypeInfoType newTargetElement)
    {
        return new AssetTypeParser(sourceElement, newTargetElement, indexedCOBie);
    }

    @Override
    protected AssetTypeInfoType createNewTargetElement()
    {
        return targetCollection.addNewAssetType();
    }

    @Override
    protected AssetTypeCollectionType getTargetCollection()
    {
        AssetTypeCollectionType assetTypes = targetParent.getAssetTypes();
        if (assetTypes == null)
        {
            assetTypes = targetParent.addNewAssetTypes();
        }
        return assetTypes;
    }

}
