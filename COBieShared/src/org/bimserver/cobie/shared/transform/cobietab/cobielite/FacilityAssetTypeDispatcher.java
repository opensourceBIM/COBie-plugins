package org.bimserver.cobie.shared.transform.cobietab.cobielite;


import org.bimserver.cobie.shared.cobietab.IndexedCOBie;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.AssetTypeDocument;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.AssetTypeInfoType;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.FacilityType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.AssetTypeCollectionType;
import org.nibs.cobie.tab.TypeType;

public class FacilityAssetTypeDispatcher extends
        TypicalParserDispatcher<org.nibs.cobie.tab.TypeType, AssetTypeCollectionType, AssetTypeInfoType, FacilityType>
{

    public FacilityAssetTypeDispatcher(Iterable<TypeType> childSourceElements, FacilityType targetParent, IndexedCOBie indexedCOBie)
    {
        super(childSourceElements, targetParent, indexedCOBie);
    }

    @Override
    protected COBieTabTransformer<TypeType, AssetTypeInfoType> createNewParser(TypeType sourceElement, AssetTypeInfoType newTargetElement)
    {
        return new TypeTransformer(sourceElement, newTargetElement, indexedCOBie);
    }

    @Override
    protected AssetTypeInfoType createNewTargetElement()
    {
        return (AssetTypeInfoType)targetCollection.addNewAssetType().substitute(AssetTypeDocument.type.getDocumentElementName(), AssetTypeInfoType.type);        
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
