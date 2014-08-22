package org.erdc.cobie.shared.cobietab.transformation.cobielite;


import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.FacilityType;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.FloorDocument;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.FloorType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.FloorCollectionType;
import org.erdc.cobie.shared.cobietab.IndexedCOBie;

public class FacilityFloorDispatcher extends TypicalParserDispatcher<org.erdc.cobie.sheetxmldata.FloorType, FloorCollectionType, FloorType, FacilityType>
{

    public FacilityFloorDispatcher(Iterable<org.erdc.cobie.sheetxmldata.FloorType> childSourceElements, FacilityType targetParent,
            IndexedCOBie indexedCOBie)
    {
        super(childSourceElements, targetParent, indexedCOBie);
    }

    @Override
    protected COBieTabTransformer<org.erdc.cobie.sheetxmldata.FloorType, FloorType> createNewParser(
            org.erdc.cobie.sheetxmldata.FloorType sourceElement,
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
