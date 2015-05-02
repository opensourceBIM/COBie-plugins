package org.bimserver.cobie.shared.transform.cobietab.cobielite;


import org.bimserver.cobie.shared.cobietab.IndexedCOBie;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.AssetTypeInfoType;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.SpareDocument;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.SpareType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.SpareCollectionType;

public class AssetTypeSpareDispatcher extends
        TypicalParserDispatcher<org.nibs.cobie.tab.SpareType, SpareCollectionType, SpareType, AssetTypeInfoType>
{

    public AssetTypeSpareDispatcher(Iterable<org.nibs.cobie.tab.SpareType> childSourceElements, AssetTypeInfoType targetParent,
            IndexedCOBie indexedCOBie)
    {
        super(childSourceElements, targetParent, indexedCOBie);
    }

    @Override
    protected COBieTabTransformer<org.nibs.cobie.tab.SpareType, SpareType> createNewParser(
            org.nibs.cobie.tab.SpareType sourceElement,
            SpareType newTargetElement)
    {
        return new SpareTransformer(sourceElement, newTargetElement, indexedCOBie);
    }

    @Override
    protected SpareType createNewTargetElement()
    {
        return (SpareType)targetCollection.addNewSpare().substitute(SpareDocument.type.getDocumentElementName(), SpareType.type);
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
