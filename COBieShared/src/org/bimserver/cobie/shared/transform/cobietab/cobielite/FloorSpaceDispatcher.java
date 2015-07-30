package org.bimserver.cobie.shared.transform.cobietab.cobielite;


import org.bimserver.cobie.shared.cobietab.IndexedCOBie;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.FloorType;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.SpaceDocument;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.SpaceType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.SpaceCollectionType;

public class FloorSpaceDispatcher extends TypicalParserDispatcher<org.nibs.cobie.tab.SpaceType, SpaceCollectionType, SpaceType, FloorType>
{

    public FloorSpaceDispatcher(Iterable<org.nibs.cobie.tab.SpaceType> childSourceElements, FloorType targetParent, IndexedCOBie indexedCOBie)
    {
        super(childSourceElements, targetParent, indexedCOBie);
    }

    @Override
    protected COBieTabTransformer<org.nibs.cobie.tab.SpaceType, SpaceType> createNewParser(
            org.nibs.cobie.tab.SpaceType sourceElement,
            SpaceType newTargetElement)
    {
        return new SpaceTransformer(sourceElement, newTargetElement, indexedCOBie);
    }

    @Override
    protected SpaceType createNewTargetElement()
    {
        return (SpaceType)targetCollection.addNewSpace().substitute(SpaceDocument.type.getDocumentElementName(), SpaceType.type);
    }

    @Override
    protected SpaceCollectionType getTargetCollection()
    {
        SpaceCollectionType spaces = targetParent.getSpaces();
        if (spaces == null)
        {
            spaces = targetParent.addNewSpaces();
        }
        return spaces;
    }

}
