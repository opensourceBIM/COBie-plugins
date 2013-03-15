package org.erdc.cobie.cobielite.parsers.sheetxmldata.dispatchers;

import org.erdc.cobie.cobielite.FacilityType;
import org.erdc.cobie.cobielite.ZoneCollectionType;
import org.erdc.cobie.cobielite.parsers.TypicalParserDispatcher;
import org.erdc.cobie.cobielite.parsers.sheetxmldata.COBieLiteSheetXMLDataParser;
import org.erdc.cobie.cobielite.parsers.sheetxmldata.ZoneParser;
import org.erdc.cobie.shared.cobiesheetxmldata.indices.IndexedCOBie;
import org.erdc.cobie.sheetxmldata.ZoneType;

public class FacilityZoneDispatcher extends TypicalParserDispatcher<ZoneType, ZoneCollectionType, org.erdc.cobie.cobielite.ZoneType, FacilityType>
{

    public FacilityZoneDispatcher(Iterable<ZoneType> childSourceElements, FacilityType targetParent, IndexedCOBie indexedCOBie)
    {
        super(childSourceElements, targetParent, indexedCOBie);
    }

    @Override
    protected COBieLiteSheetXMLDataParser<ZoneType, org.erdc.cobie.cobielite.ZoneType> createNewParser(
            ZoneType sourceElement,
            org.erdc.cobie.cobielite.ZoneType newTargetElement)
    {
        return new ZoneParser(sourceElement, newTargetElement, indexedCOBie);
    }

    @Override
    protected org.erdc.cobie.cobielite.ZoneType createNewTargetElement()
    {
        return targetCollection.addNewZone();
    }

    @Override
    protected ZoneCollectionType getTargetCollection()
    {
        ZoneCollectionType zones = targetParent.getZones();
        if (zones == null)
        {
            zones = targetParent.addNewZones();
        }
        return zones;
    }

}
