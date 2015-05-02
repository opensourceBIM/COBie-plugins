package org.bimserver.cobie.shared.transform.cobietab.cobielite;


import org.bimserver.cobie.shared.cobietab.IndexedCOBie;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.FacilityType;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.FloorDocument;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.FloorType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.FloorCollectionType;

public class FacilityFloorDispatcher extends TypicalParserDispatcher<org.nibs.cobie.tab.FloorType, FloorCollectionType, FloorType, FacilityType>
{

    public FacilityFloorDispatcher(Iterable<org.nibs.cobie.tab.FloorType> childSourceElements, FacilityType targetParent,
            IndexedCOBie indexedCOBie)
    {
        super(childSourceElements, targetParent, indexedCOBie);
    }

    @Override
    protected COBieTabTransformer<org.nibs.cobie.tab.FloorType, FloorType> createNewParser(
            org.nibs.cobie.tab.FloorType sourceElement,
            FloorType newTargetElement)
    {
        return new FloorTransformer(sourceElement, newTargetElement, indexedCOBie);
    }

    @Override
    protected FloorType createNewTargetElement()
    { 
        return (FloorType) targetCollection.addNewFloor().substitute(FloorDocument.type.getDocumentElementName(), FloorType.type);
    }

    @Override
    protected FloorCollectionType getTargetCollection()
    {
        FloorCollectionType floors = targetParent.getFloors();
        if (targetParent.getFloors() == null)
        {
            floors = targetParent.addNewFloors();
        }
        return floors;
    }

}
