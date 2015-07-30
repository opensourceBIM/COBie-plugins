package org.bimserver.cobie.shared.transform.cobietab.cobielite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bimserver.cobie.shared.cobietab.IndexedCOBie;
import org.bimserver.cobie.shared.unit.CobieLiteUnitMatcher;
import org.bimserver.cobie.shared.unit.Unit;
import org.bimserver.cobie.shared.unit.UnitMatcher;
import org.bimserver.cobie.shared.unit.VolumeUnit;
import org.bimserver.cobie.shared.utility.COBieUtility;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.FacilityType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.AreaUnitSimpleType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.AttributeCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.CurrencyUnitSimpleType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.DocumentCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.IssueCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.LinearUnitSimpleType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.ProjectType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.SiteType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.VolumeUnitSimpleType;
import org.nibs.cobie.tab.COBIEType;
import org.nibs.cobie.tab.ZoneType;

public class FacilityTransformer extends ParentTransformer<org.nibs.cobie.tab.FacilityType, FacilityType>
{
    private final COBIEType cobieSheetXMLAll;

    public FacilityTransformer(org.nibs.cobie.tab.FacilityType cobieSheetXMLDataFacility, FacilityType cobieLiteFacility,
            IndexedCOBie indexedCOBie)
    {
        super(cobieSheetXMLDataFacility, cobieLiteFacility, indexedCOBie);
        cobieSheetXMLAll = indexedCOBie.getCobie();
    }

    @SuppressWarnings("rawtypes")
    @Override
    protected ArrayList<COBieLiteParserDispatcher> getChildParsingDispatchers()
    {
        ArrayList<COBieLiteParserDispatcher> dispatchers = new ArrayList<COBieLiteParserDispatcher>();
        dispatchers.add(initializeFacilityContactDispatcher());
        dispatchers.add(initializeFacilityFloorsDispatcher());
        dispatchers.add(initializeFacilityZonesDispatcher());
        dispatchers.add(initializeAssetTypeDispatcher());
        dispatchers.add(initializeFacilitySystemsDispatcher());
        dispatchers.add(initializeFacilityConnectionsDispatcher());
        return dispatchers;
    }

    @Override
    public AttributeCollectionType getNewAttributes()
    {
        return target.addNewFacilityAttributes();
    }

    @Override
    public DocumentCollectionType getNewDocuments()
    {
        return target.addNewFacilityDocuments();
    }

    @Override
    public IssueCollectionType getNewIssues()
    {
        return target.addNewFacilityIssues();
    }

    @SuppressWarnings("deprecation")
	private FacilityAssetTypeDispatcher initializeAssetTypeDispatcher()
    {
        return new FacilityAssetTypeDispatcher(Arrays.asList(indexedCOBie.getCobie().getTypes().getTypeArray()), target, indexedCOBie);
    }

    @SuppressWarnings("deprecation")
	private FacilityConnectionDispatcher initializeFacilityConnectionsDispatcher()
    {
        return new FacilityConnectionDispatcher(Arrays.asList(cobieSheetXMLAll.getConnections().getConnectionArray()), target, indexedCOBie);

    }

    private FacilityContactDispatcher initializeFacilityContactDispatcher()
    {
        COBIEType.Contacts sheetXMLDataContacts = cobieSheetXMLAll.getContacts();
        @SuppressWarnings("deprecation")
		FacilityContactDispatcher contactDispatcher = new FacilityContactDispatcher(Arrays.asList(sheetXMLDataContacts.getContactArray()),
                target, indexedCOBie);
        return contactDispatcher;
    }

    private FacilityFloorDispatcher initializeFacilityFloorsDispatcher()
    {
        @SuppressWarnings("deprecation")
		FacilityFloorDispatcher facilityFloorDispatcher = new FacilityFloorDispatcher(Arrays.asList(cobieSheetXMLAll.getFloors().getFloorArray()),
                target, indexedCOBie);
        return facilityFloorDispatcher;

    }

    private void initializeFacilityProjectAssignment()
    {
        ProjectType project = target.addNewProjectAssignment();
        project.setExternalEntityName(source.getExternalProjectObject());
        project.setExternalID(source.getExternalProjectIdentifier());
        project.setExternalSystemName(source.getExternalSystem());
        project.setProjectName(source.getProjectName());
        project.setProjectDescription(source.getProjectDescription());
    }

    private void initializeFacilitySiteAssignment()
    {
        SiteType site = target.addNewSiteAssignment();
        site.setExternalEntityName(source.getExternalSiteObject());
        site.setExternalID(source.getExternalSiteIdentifier());
        site.setExternalSystemName(source.getExternalSystem());
        site.setSiteDescription(source.getSiteDescription());
        site.setSiteName(source.getName());
    }

    @SuppressWarnings("deprecation")
	private FacilitySystemDispatcher initializeFacilitySystemsDispatcher()
    {
        return new FacilitySystemDispatcher(Arrays.asList(cobieSheetXMLAll.getSystems().getSystemArray()), target, indexedCOBie);

    }

    private FacilityZoneDispatcher initializeFacilityZonesDispatcher()
    {
        FacilityZoneDispatcher facilityZoneDispatcher = new FacilityZoneDispatcher(getUniqueZones(),
                target, indexedCOBie);
        return facilityZoneDispatcher;
    }
    
    @SuppressWarnings("deprecation")
	private Iterable<ZoneType> getUniqueZones()
    {
        ArrayList<ZoneType> zones = new ArrayList<ZoneType>();
        List<String> zoneTokens = new ArrayList<String>();
        for(ZoneType zone : cobieSheetXMLAll.getZones().getZoneArray())
        {
            String key = getZoneKey(zone);
            if(!zoneTokens.contains(key))
            {
                zones.add(zone);
                zoneTokens.add(key);
            }
        }
        return zones;
    }

    private String getZoneKey(ZoneType zone)
    {
        return zone.getName() + COBieUtility.getCOBieDelim() + zone.getCategory();
    }

    @Override
    protected void parseChildLeaves()
    {
        initializeFacilityProjectAssignment();
        initializeFacilitySiteAssignment();    
        initializeFacilityUnits();
    }

    private void initializeFacilityUnits()
    {        
        try
        {
            initializeLinearUnits();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            
        }
        try
        {
            initializeAreaUnits();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        try
        {
            initializeVolumeUnits();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        try
        {
            initializeCurrencyUnits();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }   
    }

    private void initializeCurrencyUnits()
    {

        CobieLiteUnitMatcher cobieLiteMatcher = makeCobieLiteUnitMatcher(source.getCurrencyUnit());
        CurrencyUnitSimpleType.Enum currency = cobieLiteMatcher.matchCurrencyUnit();
        if(currency != null)
            target.addNewFacilityDefaultCurrencyUnit().setStringValue(currency.toString());
        
    }

    private void initializeVolumeUnits()
    {
        VolumeUnitSimpleType.Enum volumeUnit = null;
        String sourceVolumeUnits = source.getVolumeUnits();
        CobieLiteUnitMatcher cobieLiteMatcher = makeCobieLiteUnitMatcher(sourceVolumeUnits);
        volumeUnit = cobieLiteMatcher.matchVolumeUnit();
        if(volumeUnit != null)
            target.addNewFacilityDefaultVolumeUnit().setStringValue(volumeUnit.toString());
        
    }

	private CobieLiteUnitMatcher makeCobieLiteUnitMatcher(String sourceVolumeUnits)
	{
		UnitMatcher matcher = new UnitMatcher(sourceVolumeUnits, VolumeUnit.values());
        Unit matchedUnit = matcher.match();
        CobieLiteUnitMatcher cobieLiteMatcher = new CobieLiteUnitMatcher(matchedUnit);
		return cobieLiteMatcher;
	}

    private void initializeAreaUnits()
    {
        AreaUnitSimpleType.Enum areaUnit = null;
        String sourceAreaUnits = source.getAreaUnits();
        CobieLiteUnitMatcher cobieLiteMatcher = makeCobieLiteUnitMatcher(sourceAreaUnits);
        areaUnit = cobieLiteMatcher.matchAreaUnit();
        if(areaUnit != null)
            target.addNewFacilityDefaultAreaUnit().setStringValue(areaUnit.toString());
        
    }

    private void initializeLinearUnits()
    {        
        LinearUnitSimpleType.Enum linearUnit = null;
        String sourceLinearUnits = source.getLinearUnits();
        CobieLiteUnitMatcher cobieLiteMatcher = makeCobieLiteUnitMatcher(sourceLinearUnits);
        linearUnit = cobieLiteMatcher.matchLinearUnit();
        if(linearUnit != null)
            target.addNewFacilityDefaultLinearUnit().setStringValue(linearUnit.toString());
    }

    @Override
    protected void parseSimpleElements()
    {
        target.setExternalEntityName(source.getExternalFacilityObject());
        target.setExternalID(source.getExternalFacilityIdentifier());
        target.setExternalSystemName(source.getExternalSystem());
        target.setFacilityCategory(source.getCategory());
        target.setFacilityDefaultMeasurementStandard(source.getAreaMeasurement());
        target.setFacilityDeliverablePhaseName(source.getPhase());
        target.setFacilityDescription(source.getDescription());
        target.setFacilityName(source.getName());
    }

}
