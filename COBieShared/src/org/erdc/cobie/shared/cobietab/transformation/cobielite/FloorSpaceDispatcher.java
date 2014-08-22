package org.erdc.cobie.shared.cobietab.transformation.cobielite;


import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.FloorType;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.SpaceDocument;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.SpaceType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.SpaceCollectionType;
import org.erdc.cobie.shared.cobietab.IndexedCOBie;

public class FloorSpaceDispatcher extends TypicalParserDispatcher<org.erdc.cobie.sheetxmldata.SpaceType, SpaceCollectionType, SpaceType, FloorType>
{

    public FloorSpaceDispatcher(Iterable<org.erdc.cobie.sheetxmldata.SpaceType> childSourceElements, FloorType targetParent, IndexedCOBie indexedCOBie)
    {
        super(childSourceElements, targetParent, indexedCOBie);
    }

    @Override
    protected COBieTabTransformer<org.erdc.cobie.sheetxmldata.SpaceType, SpaceType> createNewParser(
            org.erdc.cobie.sheetxmldata.SpaceType sourceElement,
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
