package org.bimserver.cobie.shared.transform.cobietab.cobielite;


import org.bimserver.cobie.shared.cobietab.IndexedCOBie;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.FacilityType;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.ZoneDocument;
import org.buildingsmartalliance.docs.nbims03.cobie.core.ZoneCollectionType;
import org.nibs.cobie.tab.ZoneType;

public class FacilityZoneDispatcher extends TypicalParserDispatcher<ZoneType, ZoneCollectionType, org.buildingsmartalliance.docs.nbims03.cobie.cobielite.ZoneType, FacilityType>
{

    public FacilityZoneDispatcher(Iterable<ZoneType> childSourceElements, FacilityType targetParent, IndexedCOBie indexedCOBie)
    {
        super(childSourceElements, targetParent, indexedCOBie);
    }

    @Override
    protected COBieTabTransformer<ZoneType,  org.buildingsmartalliance.docs.nbims03.cobie.cobielite.ZoneType> createNewParser(
            ZoneType sourceElement,
            org.buildingsmartalliance.docs.nbims03.cobie.cobielite.ZoneType newTargetElement)
    {
        return new ZoneTransformer(sourceElement, newTargetElement, indexedCOBie);
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
