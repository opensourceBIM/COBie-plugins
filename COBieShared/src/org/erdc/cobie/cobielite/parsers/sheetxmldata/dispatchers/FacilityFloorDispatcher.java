package org.erdc.cobie.cobielite.parsers.sheetxmldata.dispatchers;

import org.erdc.cobie.cobielite.FacilityType;
import org.erdc.cobie.cobielite.FloorCollectionType;
import org.erdc.cobie.cobielite.FloorType;
import org.erdc.cobie.cobielite.parsers.TypicalParserDispatcher;
import org.erdc.cobie.cobielite.parsers.sheetxmldata.COBieLiteSheetXMLDataParser;
import org.erdc.cobie.cobielite.parsers.sheetxmldata.FloorParser;
import org.erdc.cobie.shared.cobiesheetxmldata.indices.IndexedCOBie;

public class FacilityFloorDispatcher extends TypicalParserDispatcher<org.erdc.cobie.sheetxmldata.FloorType, FloorCollectionType, FloorType, FacilityType>
{

    public FacilityFloorDispatcher(Iterable<org.erdc.cobie.sheetxmldata.FloorType> childSourceElements, FacilityType targetParent,
            IndexedCOBie indexedCOBie)
    {
        super(childSourceElements, targetParent, indexedCOBie);
    }

    @Override
    protected COBieLiteSheetXMLDataParser<org.erdc.cobie.sheetxmldata.FloorType, FloorType> createNewParser(
            org.erdc.cobie.sheetxmldata.FloorType sourceElement,
            FloorType newTargetElement)
    {
        return new FloorParser(sourceElement, newTargetElement, indexedCOBie);
    }

    @Override
    protected FloorType createNewTargetElement()
    {
        return targetCollection.addNewFloor();
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
