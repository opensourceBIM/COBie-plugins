package org.erdc.cobie.cobielite.parsers.sheetxmldata.dispatchers;


import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.FacilityType;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.ZoneDocument;
import org.buildingsmartalliance.docs.nbims03.cobie.core.ZoneCollectionType;
import org.erdc.cobie.cobielite.parsers.TypicalParserDispatcher;
import org.erdc.cobie.cobielite.parsers.sheetxmldata.COBieLiteSheetXMLDataParser;
import org.erdc.cobie.cobielite.parsers.sheetxmldata.ZoneParser;
import org.erdc.cobie.shared.cobiesheetxmldata.indices.IndexedCOBie;
import org.erdc.cobie.sheetxmldata.ZoneType;

public class FacilityZoneDispatcher extends TypicalParserDispatcher<ZoneType, ZoneCollectionType, org.buildingsmartalliance.docs.nbims03.cobie.cobielite.ZoneType, FacilityType>
{

    public FacilityZoneDispatcher(Iterable<ZoneType> childSourceElements, FacilityType targetParent, IndexedCOBie indexedCOBie)
    {
        super(childSourceElements, targetParent, indexedCOBie);
    }

    @Override
    protected COBieLiteSheetXMLDataParser<ZoneType,  org.buildingsmartalliance.docs.nbims03.cobie.cobielite.ZoneType> createNewParser(
            ZoneType sourceElement,
            org.buildingsmartalliance.docs.nbims03.cobie.cobielite.ZoneType newTargetElement)
    {
        return new ZoneParser(sourceElement, newTargetElement, indexedCOBie);
    }

    @Override
    protected  org.buildingsmartalliance.docs.nbims03.cobie.cobielite.ZoneType createNewTargetElement()
    {
        return ( org.buildingsmartalliance.docs.nbims03.cobie.cobielite.ZoneType)targetCollection.addNewZone().substitute(ZoneDocument.type.getDocumentElementName(), org.buildingsmartalliance.docs.nbims03.cobie.cobielite.ZoneType.type);
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
