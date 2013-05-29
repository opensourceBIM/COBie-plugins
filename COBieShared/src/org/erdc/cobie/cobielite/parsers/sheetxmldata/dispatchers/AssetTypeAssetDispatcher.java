package org.erdc.cobie.cobielite.parsers.sheetxmldata.dispatchers;

import org.erdc.cobie.cobielite.AssetCollectionType;
import org.erdc.cobie.cobielite.AssetInfoType;
import org.erdc.cobie.cobielite.AssetTypeInfoType;
import org.erdc.cobie.cobielite.parsers.TypicalParserDispatcher;
import org.erdc.cobie.cobielite.parsers.sheetxmldata.AssetParser;
import org.erdc.cobie.cobielite.parsers.sheetxmldata.COBieLiteSheetXMLDataParser;
import org.erdc.cobie.shared.cobiesheetxmldata.indices.IndexedCOBie;
import org.erdc.cobie.sheetxmldata.ComponentType;

public class AssetTypeAssetDispatcher extends
        TypicalParserDispatcher<org.erdc.cobie.sheetxmldata.ComponentType, AssetCollectionType, AssetInfoType, AssetTypeInfoType>
{

    public AssetTypeAssetDispatcher(Iterable<ComponentType> childSourceElements, AssetTypeInfoType targetParent, IndexedCOBie indexedCOBie)
    {
        super(childSourceElements, targetParent, indexedCOBie);
    }

    @Override
    protected COBieLiteSheetXMLDataParser<ComponentType, AssetInfoType> createNewParser(ComponentType sourceElement, AssetInfoType newTargetElement)
    {
        return new AssetParser(sourceElement, newTargetElement, indexedCOBie);
    }

    @Override
    protected AssetInfoType createNewTargetElement()
    {
        return targetCollection.addNewAsset();
    }

    @Override
    protected AssetCollectionType getTargetCollection()
    {
        AssetCollectionType assets = targetParent.getAssets();
        if (assets == null)
        {
            assets = targetParent.addNewAssets();
        }
        return assets;
    }

}
