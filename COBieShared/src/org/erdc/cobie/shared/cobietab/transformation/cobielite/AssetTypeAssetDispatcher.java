package org.erdc.cobie.shared.cobietab.transformation.cobielite;


import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.AssetDocument;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.AssetInfoType;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.AssetTypeInfoType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.AssetCollectionType;
import org.erdc.cobie.shared.cobietab.IndexedCOBie;
import org.erdc.cobie.sheetxmldata.ComponentType;

public class AssetTypeAssetDispatcher extends
        TypicalParserDispatcher<org.erdc.cobie.sheetxmldata.ComponentType, AssetCollectionType, AssetInfoType, AssetTypeInfoType>
{

    public AssetTypeAssetDispatcher(Iterable<ComponentType> childSourceElements, AssetTypeInfoType targetParent, IndexedCOBie indexedCOBie)
    {
        super(childSourceElements, targetParent, indexedCOBie);
    }

    @Override
    protected COBieTabTransformer<ComponentType, AssetInfoType> createNewParser(ComponentType sourceElement, AssetInfoType newTargetElement)
    {
        return new ComponentTransformer(sourceElement, newTargetElement, indexedCOBie);
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
