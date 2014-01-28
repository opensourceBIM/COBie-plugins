package org.erdc.cobie.cobielite.parsers.sheetxmldata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bimserver.models.ifc2x3tc1.IfcCurrencyEnum;
import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;
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
import org.erdc.cobie.cobielite.parsers.COBieLiteParserDispatcher;
import org.erdc.cobie.cobielite.parsers.sheetxmldata.dispatchers.FacilityAssetTypeDispatcher;
import org.erdc.cobie.cobielite.parsers.sheetxmldata.dispatchers.FacilityConnectionDispatcher;
import org.erdc.cobie.cobielite.parsers.sheetxmldata.dispatchers.FacilityContactDispatcher;
import org.erdc.cobie.cobielite.parsers.sheetxmldata.dispatchers.FacilityFloorDispatcher;
import org.erdc.cobie.cobielite.parsers.sheetxmldata.dispatchers.FacilitySystemDispatcher;
import org.erdc.cobie.cobielite.parsers.sheetxmldata.dispatchers.FacilityZoneDispatcher;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.shared.cobiesheetxmldata.indices.IndexedCOBie;
import org.erdc.cobie.shared.targetunits.IfcUnitSearch;
import org.erdc.cobie.shared.targetunits.IfcUnitSearchDispatcher;
import org.erdc.cobie.shared.targetunits.UnitSearchToCOBieLiteUnits;
import org.erdc.cobie.shared.targetunits.area.AreaUnitSearch;
import org.erdc.cobie.shared.targetunits.length.LengthUnitSearch;
import org.erdc.cobie.shared.targetunits.monetary.MonetaryTextMatcher;
import org.erdc.cobie.shared.targetunits.volume.VolumeUnitSearch;
import org.erdc.cobie.sheetxmldata.COBIEType;
import org.erdc.cobie.sheetxmldata.ZoneType;

public class FacilityParser extends DeepParser<org.erdc.cobie.sheetxmldata.FacilityType, FacilityType>
{
    private final COBIEType cobieSheetXMLAll;

    public FacilityParser(org.erdc.cobie.sheetxmldata.FacilityType cobieSheetXMLDataFacility, FacilityType cobieLiteFacility,
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
        return targetCOBie.addNewFacilityAttributes();
    }

    @Override
    public DocumentCollectionType getNewDocuments()
    {
        return targetCOBie.addNewFacilityDocuments();
    }

    @Override
    public IssueCollectionType getNewIssues()
    {
        return targetCOBie.addNewFacilityIssues();
    }

    private FacilityAssetTypeDispatcher initializeAssetTypeDispatcher()
    {
        return new FacilityAssetTypeDispatcher(Arrays.asList(indexedCOBie.getCobie().getTypes().getTypeArray()), targetCOBie, indexedCOBie);
    }

    private FacilityConnectionDispatcher initializeFacilityConnectionsDispatcher()
    {
        return new FacilityConnectionDispatcher(Arrays.asList(cobieSheetXMLAll.getConnections().getConnectionArray()), targetCOBie, indexedCOBie);

    }

    private FacilityContactDispatcher initializeFacilityContactDispatcher()
    {
        COBIEType.Contacts sheetXMLDataContacts = cobieSheetXMLAll.getContacts();
        FacilityContactDispatcher contactDispatcher = new FacilityContactDispatcher(Arrays.asList(sheetXMLDataContacts.getContactArray()),
                targetCOBie, indexedCOBie);
        return contactDispatcher;
    }

    private FacilityFloorDispatcher initializeFacilityFloorsDispatcher()
    {
        FacilityFloorDispatcher facilityFloorDispatcher = new FacilityFloorDispatcher(Arrays.asList(cobieSheetXMLAll.getFloors().getFloorArray()),
                targetCOBie, indexedCOBie);
        return facilityFloorDispatcher;

    }

    private void initializeFacilityProjectAssignment()
    {
        ProjectType project = targetCOBie.addNewProjectAssignment();
        project.setExternalEntityName(sourceCOBie.getExternalProjectObject());
        project.setExternalID(sourceCOBie.getExternalProjectIdentifier());
        project.setExternalSystemName(sourceCOBie.getExternalSystem());
        project.setProjectName(sourceCOBie.getProjectName());
        project.setProjectDescription(sourceCOBie.getProjectDescription());
    }

    private void initializeFacilitySiteAssignment()
    {
        SiteType site = targetCOBie.addNewSiteAssignment();
        site.setExternalEntityName(sourceCOBie.getExternalSiteObject());
        site.setExternalID(sourceCOBie.getExternalSiteIdentifier());
        site.setExternalSystemName(sourceCOBie.getExternalSystem());
        site.setSiteDescription(sourceCOBie.getSiteDescription());
        site.setSiteName(sourceCOBie.getName());
    }

    private FacilitySystemDispatcher initializeFacilitySystemsDispatcher()
    {
        return new FacilitySystemDispatcher(Arrays.asList(cobieSheetXMLAll.getSystems().getSystemArray()), targetCOBie, indexedCOBie);

    }

    private FacilityZoneDispatcher initializeFacilityZonesDispatcher()
    {
        FacilityZoneDispatcher facilityZoneDispatcher = new FacilityZoneDispatcher(getUniqueZones(),
                targetCOBie, indexedCOBie);
        return facilityZoneDispatcher;
    }
    
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
        MonetaryTextMatcher monetaryMatcher =
                new MonetaryTextMatcher(sourceCOBie.getCurrencyUnit());
        IfcCurrencyEnum ifcCurrency = monetaryMatcher.getMatchingCurrency();
        CurrencyUnitSimpleType.Enum currency = UnitSearchToCOBieLiteUnits.getCurrencyUnit(ifcCurrency);
        if(currency != null)
            targetCOBie.addNewFacilityDefaultCurrencyUnit().setStringValue(currency.toString());
        
    }

    private void initializeVolumeUnits()
    {
        VolumeUnitSimpleType.Enum volumeUnit = null;
        String sourceVolumeUnits = sourceCOBie.getVolumeUnits();
        IfcUnitSearchDispatcher unitDispatcherSearch =
                new IfcUnitSearchDispatcher(IfcUnitEnum.VOLUMEUNIT, sourceVolumeUnits);
        IfcUnitSearch unitSearch = unitDispatcherSearch.getUnitSearch();
        if(unitSearch instanceof VolumeUnitSearch)
           volumeUnit = UnitSearchToCOBieLiteUnits.getVolumeUnit((VolumeUnitSearch) unitSearch);
        if(volumeUnit != null)
            targetCOBie.addNewFacilityDefaultVolumeUnit().setStringValue(volumeUnit.toString());
        
    }

    private void initializeAreaUnits()
    {
        AreaUnitSimpleType.Enum areaUnit = null;
        String sourceAreaUnits = sourceCOBie.getAreaUnits();
        IfcUnitSearchDispatcher unitDispatcherSearch =
                new IfcUnitSearchDispatcher(IfcUnitEnum.AREAUNIT, sourceAreaUnits);
        IfcUnitSearch unitSearch = unitDispatcherSearch.getUnitSearch();
        if(unitSearch instanceof AreaUnitSearch)
           areaUnit = UnitSearchToCOBieLiteUnits.getAreaUnit((AreaUnitSearch) unitSearch);
        if(areaUnit != null)
            targetCOBie.addNewFacilityDefaultAreaUnit().setStringValue(areaUnit.toString());
        
    }

    private void initializeLinearUnits()
    {        
        LinearUnitSimpleType.Enum linearUnit = null;
        String sourceLinearUnits = sourceCOBie.getLinearUnits();
        IfcUnitSearchDispatcher unitDispatcherSearch =
                new IfcUnitSearchDispatcher(IfcUnitEnum.LENGTHUNIT, sourceLinearUnits);
        IfcUnitSearch unitSearch = unitDispatcherSearch.getUnitSearch();
        if(unitSearch instanceof LengthUnitSearch)
           linearUnit = UnitSearchToCOBieLiteUnits.getLengthUnit((LengthUnitSearch) unitSearch);
        if(linearUnit != null)
            targetCOBie.addNewFacilityDefaultLinearUnit().setStringValue(linearUnit.toString());
    }

    @Override
    protected void parseSimpleElements()
    {
        targetCOBie.setExternalEntityName(sourceCOBie.getExternalFacilityObject());
        targetCOBie.setExternalID(sourceCOBie.getExternalFacilityIdentifier());
        targetCOBie.setExternalSystemName(sourceCOBie.getExternalSystem());
        targetCOBie.setFacilityCategory(sourceCOBie.getCategory());
        targetCOBie.setFacilityDefaultMeasurementStandard(sourceCOBie.getAreaMeasurement());
        targetCOBie.setFacilityDeliverablePhaseName(sourceCOBie.getPhase());
        targetCOBie.setFacilityDescription(sourceCOBie.getDescription());
        targetCOBie.setFacilityName(sourceCOBie.getName());
    }

}
