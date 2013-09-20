package org.erdc.cobie.cobielite.parsers.sheetxmldata.dispatchers;


import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.AssetDocument;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.AssetInfoType;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.AssetTypeInfoType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.AssetCollectionType;
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
        return (AssetInfoType)targetCollection.addNewAsset().substitute(AssetDocument.type.getDocumentElementName(), AssetInfoType.type);
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
