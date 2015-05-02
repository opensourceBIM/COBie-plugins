package org.bimserver.cobie.shared.transform.cobietab.cobielite;


import org.bimserver.cobie.shared.cobietab.IndexedCOBie;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.AssetDocument;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.AssetInfoType;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.AssetTypeInfoType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.AssetCollectionType;
import org.nibs.cobie.tab.ComponentType;

public class AssetTypeAssetDispatcher extends
        TypicalParserDispatcher<org.nibs.cobie.tab.ComponentType, AssetCollectionType, AssetInfoType, AssetTypeInfoType>
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
