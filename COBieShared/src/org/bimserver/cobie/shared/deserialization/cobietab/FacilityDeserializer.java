package org.bimserver.cobie.shared.deserialization.cobietab;

/******************************************************************************

 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/
import java.util.Calendar;
import java.util.List;

import org.bimserver.cobie.shared.deserialization.DeserializerStaticStrings;
import org.bimserver.cobie.shared.deserialization.cobietab.modelhandlers.ClassificationHandler;
import org.bimserver.cobie.shared.deserialization.cobietab.modelhandlers.IfcCommonHandler;
import org.bimserver.cobie.shared.deserialization.cobietab.modelhandlers.IfcGuidHandler;
import org.bimserver.cobie.shared.deserialization.cobietab.modelhandlers.OwnerHistoryHandler;
import org.bimserver.cobie.shared.deserialization.cobietab.modelhandlers.PropertySetHandler;
import org.bimserver.cobie.shared.unit.area.AreaUnitSearch;
import org.bimserver.cobie.shared.unit.length.LengthUnitSearch;
import org.bimserver.cobie.shared.unit.monetary.MonetaryTextMatcher;
import org.bimserver.cobie.shared.unit.volume.VolumeUnitSearch;
import org.bimserver.cobie.shared.utility.COBieIfcUtility;
import org.bimserver.cobie.shared.utility.COBieUtility;
import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.emf.OidProvider;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.IfcAxis2Placement3D;
import org.bimserver.models.ifc2x3tc1.IfcBuilding;
import org.bimserver.models.ifc2x3tc1.IfcCartesianPoint;
import org.bimserver.models.ifc2x3tc1.IfcClassification;
import org.bimserver.models.ifc2x3tc1.IfcClassificationReference;
import org.bimserver.models.ifc2x3tc1.IfcCurrencyEnum;
import org.bimserver.models.ifc2x3tc1.IfcDirection;
import org.bimserver.models.ifc2x3tc1.IfcGeometricRepresentationContext;
import org.bimserver.models.ifc2x3tc1.IfcGloballyUniqueId;
import org.bimserver.models.ifc2x3tc1.IfcLocalPlacement;
import org.bimserver.models.ifc2x3tc1.IfcMonetaryUnit;
import org.bimserver.models.ifc2x3tc1.IfcOwnerHistory;
import org.bimserver.models.ifc2x3tc1.IfcProject;
import org.bimserver.models.ifc2x3tc1.IfcRelAggregates;
import org.bimserver.models.ifc2x3tc1.IfcSIPrefix;
import org.bimserver.models.ifc2x3tc1.IfcSIUnit;
import org.bimserver.models.ifc2x3tc1.IfcSIUnitName;
import org.bimserver.models.ifc2x3tc1.IfcSite;
import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.bimserver.models.ifc2x3tc1.IfcUnitAssignment;
import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;
import org.nibs.cobie.tab.COBIEType;
import org.nibs.cobie.tab.FacilityType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FacilityDeserializer
{
    private static final String ERROR_PREFIX_LOCAL_PLACEMENT = "An error occured while attempting to initialize the local placement of facility ";

    protected static IfcClassification classificationFromFacility(FacilityType facility)
    {
        IfcClassification classification = Ifc2x3tc1Factory.eINSTANCE.createIfcClassification();
        String category = facility.getCategory();
        if (!COBieUtility.isNA(category))
        {
            classification.setName(category);
            return classification;
        } else
        {
            return null;
        }
    }

    public static IfcSIUnit getDefaultAreaUnits()
    {
        IfcSIUnit siUnit = Ifc2x3tc1Factory.eINSTANCE.createIfcSIUnit();
        siUnit.setName(IfcSIUnitName.SQUARE_METRE);
        siUnit.setUnitType(IfcUnitEnum.AREAUNIT);
        return siUnit;
    }

    public static IfcSIUnit getDefaultLinearUnits()
    {
        IfcSIUnit siUnit = Ifc2x3tc1Factory.eINSTANCE.createIfcSIUnit();
        siUnit.setName(IfcSIUnitName.METRE);
        siUnit.setPrefix(IfcSIPrefix.MILLI);
        siUnit.setUnitType(IfcUnitEnum.LENGTHUNIT);
        return siUnit;
    }

    private static IfcCurrencyEnum getDefaultMonetaryUnits()
    {
        return defaultCurrency;
    }

    private static IfcUnit getDefaultVolumeUnits()
    {
        IfcSIUnit siUnit = Ifc2x3tc1Factory.eINSTANCE.createIfcSIUnit();
        siUnit.setName(IfcSIUnitName.CUBIC_METRE);
        siUnit.setUnitType(IfcUnitEnum.VOLUMEUNIT);
        return siUnit;
    }

    protected static IfcUnit monetaryUnitFromFacility(FacilityType facility)
    {
        IfcMonetaryUnit monetaryUnit = Ifc2x3tc1Factory.eINSTANCE.createIfcMonetaryUnit();
        String facilityMonetary = facility.getCurrencyUnit();
        try
        {
            IfcCurrencyEnum currency = IfcCurrencyEnum.getByName(facilityMonetary);
            if (currency == null)
            {
                monetaryUnit.setCurrency(monetaryUnitFromString(facilityMonetary));
            } else
            {
                monetaryUnit.setCurrency(currency);
            }
        } catch (Exception e)
        {
            monetaryUnit.setCurrency(getDefaultMonetaryUnits());
        }
        return monetaryUnit;
    }

    private static IfcCurrencyEnum monetaryUnitFromString(String monetaryUnitString)
    {
        IfcCurrencyEnum currency;
        try
        {
            MonetaryTextMatcher monetarySearch = new MonetaryTextMatcher(monetaryUnitString);
            currency = monetarySearch.getMatchingCurrency();
        } catch (Exception ex)
        {
            currency = getDefaultMonetaryUnits();
        }
        return currency;
    }

    private Logger LOGGER = LoggerFactory.getLogger(FacilityDeserializer.class);
    private IfcCommonHandler ifcCommonHandler;
    private COBieIfcModel model;
    private IfcGuidHandler guidProvider;
    private OidProvider<Long> cobieOidProvider;

    private OwnerHistoryHandler ownerHistoryProvider;

    private PropertySetHandler propertySetProvider;

    private ClassificationHandler classificationHandler;

    private COBIEType.Facilities facilities;

    private IfcLocalPlacement siteLocalPlacement;

    private static final IfcCurrencyEnum defaultCurrency = IfcCurrencyEnum.USD;

    public FacilityDeserializer(COBieIfcModel cobieIfcModel, IfcCommonHandler ifcCommonHandler, COBIEType.Facilities facilities)
    {
        model = cobieIfcModel;
        guidProvider = ifcCommonHandler.getGuidHandler();
        cobieOidProvider = ifcCommonHandler.getOidProvider();
        ownerHistoryProvider = ifcCommonHandler.getOwnerHistoryHandler();
        classificationHandler = ifcCommonHandler.getClassificationHandler();
        this.ifcCommonHandler = ifcCommonHandler;
        propertySetProvider = ifcCommonHandler.getPropertySetHandler();
        this.facilities = facilities;
    }

    protected IfcUnit areaUnitsFromFacility(FacilityType facility)
    {
        IfcUnit areaUnit = getDefaultAreaUnits();
        if (!COBieUtility.isNA(facility.getAreaUnits()))
        {
            AreaUnitSearch areaSearch = new AreaUnitSearch(facility.getAreaUnits());
            areaUnit = areaSearch.getMatchedUnit();
        }
        return areaUnit;
    }

    protected IfcBuilding buildingFromFacility(FacilityType facility)
    {
        IfcBuilding building = Ifc2x3tc1Factory.eINSTANCE.createIfcBuilding();
        building.setName(facility.getName());
        building.setDescription(facility.getDescription());
        setFacilityLocalPlacement(facility, building);
        return building;
    }

    protected List<IfcClassificationReference> classificationReferencesFromFacility(FacilityType facility) throws IfcModelInterfaceException
    {
        return classificationHandler.classificationReferencesFromString(facility.getCategory());
    }

    @SuppressWarnings("deprecation")
	public void deserializeFacilities()
    {
        long tmpOid;
        String name;
        String createdBy;
        String projectExternalId;
        String siteExternalId;
        String buildingExternalId;
        Calendar createdOn;
        String category;
        try
        {
            if (facilities != null)
            {
                for (FacilityType facility : facilities.getFacilityArray())
                {
                    name = facility.getName();
                    if (!model.containsFacility(name))
                    {
                        category = facility.getCategory();
                        createdBy = facility.getCreatedBy();
                        projectExternalId = facility.getExternalProjectIdentifier();
                        siteExternalId = facility.getExternalSiteIdentifier();
                        buildingExternalId = facility.getExternalFacilityIdentifier();
                        createdOn = facility.getCreatedOn();
                        IfcOwnerHistory ownerHistory = ownerHistoryProvider.ownerHistoryFromEmailTimestampAndApplication(createdBy, createdOn,
                                facility.getExternalSystem());

                        IfcUnit linearUnit = linearUnitsFromFacility(facility);
                        tmpOid = propertySetProvider.addUnitToModel(linearUnit);
                        linearUnit = (IfcUnit)model.get(tmpOid);
                        // model.add(linearUnit,this.CobieOidProvider);
                        IfcUnit areaUnit = areaUnitsFromFacility(facility);
                        tmpOid = propertySetProvider.addUnitToModel(areaUnit);
                        areaUnit = (IfcUnit)model.get(tmpOid);
                        // model.add(areaUnit, CobieOidProvider);
                        IfcUnit volumeUnit = volumeUnitsFromFacility(facility);
                        tmpOid = propertySetProvider.addUnitToModel(volumeUnit);
                        volumeUnit = (IfcUnit)model.get(tmpOid);
                        // model.add(volumeUnit, CobieOidProvider);
                        IfcUnit monetaryUnit = FacilityDeserializer.monetaryUnitFromFacility(facility);
                        tmpOid = propertySetProvider.addUnitToModel(monetaryUnit);
                        monetaryUnit = (IfcUnit)model.get(tmpOid);
                        // model.add(monetaryUnit, CobieOidProvider);

                        IfcUnitAssignment unitAssignment = Ifc2x3tc1Factory.eINSTANCE.createIfcUnitAssignment();
                        unitAssignment.getUnits().add(linearUnit);
                        unitAssignment.getUnits().add(areaUnit);
                        unitAssignment.getUnits().add(volumeUnit);
                        unitAssignment.getUnits().add(monetaryUnit);
                        model.add(unitAssignment, cobieOidProvider);

                        IfcGloballyUniqueId projGuid = guidProvider.guidFromExternalIdentifier(projectExternalId);
                        IfcGloballyUniqueId siteGuid = guidProvider.guidFromExternalIdentifier(siteExternalId);
                        IfcGloballyUniqueId buildingGuid = guidProvider.guidFromExternalIdentifier(buildingExternalId);
                        String objectType = ClassificationHandler.objectTypeFromCategoryString(category);

                        IfcProject project = projectFromFacility(facility);
                        project.setGlobalId(projGuid.getWrappedValue());
                        project.setUnitsInContext(unitAssignment);
                        project.setOwnerHistory(ownerHistory);

                        if (!COBieUtility.isNA(objectType))
                        {
                            project.setObjectType(objectType);
                        }
                        model.add(project, cobieOidProvider);

                        IfcSite site = siteFromFacility(facility);
                        site.setGlobalId(siteGuid.getWrappedValue());
                        site.setOwnerHistory(ownerHistory);
                        if (!COBieUtility.isNA(objectType))
                        {
                            site.setObjectType(objectType);
                        }
                        model.add(site, cobieOidProvider);

                        IfcBuilding bldg = buildingFromFacility(facility);
                        bldg.setGlobalId(buildingGuid.getWrappedValue());
                        bldg.setOwnerHistory(ownerHistory);
                        if (!COBieUtility.isNA(objectType))
                        {
                            bldg.setObjectType(objectType);
                        }
                        List<IfcClassificationReference> classifications = classificationReferencesFromFacility(facility);

                        tmpOid = model.add(bldg, cobieOidProvider);
                        setFacilityAggregates(project, site, bldg);
                        for (IfcClassificationReference classification : classifications)
                        {
                            classificationHandler.addClassificationReferenceToObject(classification, bldg);
                        }

                    }

                }
            }

        } catch (Exception e)
        {
        }

    }

    private IfcGeometricRepresentationContext getDefaultRepresentationContext() throws IfcModelInterfaceException
    {
        IfcGeometricRepresentationContext repContext = COBieIfcUtility.ifcFactory.createIfcGeometricRepresentationContext();

        repContext.setContextIdentifier("GeometricRepresentationContext_Global");
        repContext.setContextType("Design");
        repContext.setCoordinateSpaceDimension(3);
        repContext.setPrecision(1.000000000E-5);
        IfcAxis2Placement3D coordSystem = COBieIfcUtility.ifcFactory.createIfcAxis2Placement3D();
        IfcCartesianPoint origin = COBieIfcUtility.ifcFactory.createIfcCartesianPoint();
        origin.getCoordinates().add((double)0);
        origin.getCoordinates().add((double)0);
        origin.getCoordinates().add((double)0);
        model.add(origin, cobieOidProvider);

        coordSystem.setLocation(origin);
        IfcDirection direction = COBieIfcUtility.ifcFactory.createIfcDirection();
        direction.getDirectionRatios().add((double)0);
        direction.getDirectionRatios().add((double)0);
        direction.getDirectionRatios().add((double)1);
        model.add(direction, cobieOidProvider);

        coordSystem.setAxis(direction);
        IfcDirection refDirection = COBieIfcUtility.ifcFactory.createIfcDirection();
        refDirection.getDirectionRatios().add((double)1);
        refDirection.getDirectionRatios().add((double)0);
        refDirection.getDirectionRatios().add((double)0);
        model.add(refDirection, cobieOidProvider);

        coordSystem.setRefDirection(refDirection);
        model.add(coordSystem, cobieOidProvider);

        repContext.setWorldCoordinateSystem(coordSystem);

        IfcDirection north = COBieIfcUtility.ifcFactory.createIfcDirection();
        north.getDirectionRatios().add((double)0);
        north.getDirectionRatios().add((double)1);
        north.getDirectionRatios().add((double)0);
        model.add(north, cobieOidProvider);

        repContext.setTrueNorth(north);
        model.add(repContext, cobieOidProvider);

        return repContext;
    }

    public IfcLocalPlacement getSiteLocalPlacement()
    {
        return siteLocalPlacement;
    }

    protected IfcUnit linearUnitsFromFacility(FacilityType facility)
    {

        IfcUnit unit = getDefaultLinearUnits();
        if (!COBieUtility.isNA(facility.getLinearUnits()))
        {
            LengthUnitSearch lengthMatcher = new LengthUnitSearch(facility.getLinearUnits());
            unit = lengthMatcher.getMatchedUnit();
        }

        return unit;
    }

    protected IfcProject projectFromFacility(FacilityType facility) throws IfcModelInterfaceException
    {
        IfcProject project = Ifc2x3tc1Factory.eINSTANCE.createIfcProject();
        project.setName(facility.getProjectName());
        project.setDescription(facility.getProjectDescription());
        project.setPhase(facility.getPhase());
        project.getRepresentationContexts().add(getDefaultRepresentationContext());
        return project;
    }

    private void setFacilityAggregates(IfcProject project, IfcSite site, IfcBuilding building) throws IfcModelInterfaceException
    {
        IfcRelAggregates aggregatesProj = Ifc2x3tc1Factory.eINSTANCE.createIfcRelAggregates();
        aggregatesProj.setGlobalId(guidProvider.newGuid().getWrappedValue());
        aggregatesProj.setOwnerHistory(ownerHistoryProvider.DefaultOwnerHistory());
        aggregatesProj.setName(DeserializerStaticStrings.getProjectRelAggregatesName());
        aggregatesProj.setDescription(DeserializerStaticStrings.getProjectRelAggregatesDescription());
        aggregatesProj.setRelatingObject(project);
        aggregatesProj.getRelatedObjects().add(site);
        model.add(aggregatesProj, cobieOidProvider);

        IfcRelAggregates aggregatesSite = Ifc2x3tc1Factory.eINSTANCE.createIfcRelAggregates();
        aggregatesSite.setGlobalId(guidProvider.newGuid().getWrappedValue());
        aggregatesSite.setOwnerHistory(ownerHistoryProvider.DefaultOwnerHistory());
        aggregatesSite.setName(DeserializerStaticStrings.getSiteRelAggregatesName());
        aggregatesSite.setDescription(DeserializerStaticStrings.getSiteRelAggregatesDescription());
        aggregatesSite.setRelatingObject(site);
        aggregatesSite.getRelatedObjects().add(building);
        model.add(aggregatesSite, cobieOidProvider);
    }

    private void setFacilityLocalPlacement(FacilityType facility, IfcBuilding building)
    {
        try
        {
            building.setObjectPlacement(ifcCommonHandler.getGeometryHandler().newDefaultLocalPlacement(getSiteLocalPlacement()));
        } catch (Exception ex)
        {
            LOGGER.error(ERROR_PREFIX_LOCAL_PLACEMENT + facility.getName());
        }
    }

    private void setSiteLocalPlacement(IfcLocalPlacement siteLocalPlacement)
    {
        this.siteLocalPlacement = siteLocalPlacement;
    }

    protected IfcSite siteFromFacility(FacilityType facility) throws IfcModelInterfaceException
    {
        IfcSite site = Ifc2x3tc1Factory.eINSTANCE.createIfcSite();
        site.setName(facility.getSiteName());
        site.setDescription(facility.getDescription());
        IfcLocalPlacement sitePlacement = ifcCommonHandler.getGeometryHandler().newDefaultLocalPlacement(null);
        site.setObjectPlacement(sitePlacement);
        setSiteLocalPlacement(sitePlacement);
        return site;
    }

    protected IfcUnit volumeUnitsFromFacility(FacilityType facility)
    {
        IfcUnit volumeUnit = getDefaultVolumeUnits();
        if (!COBieUtility.isNA(facility.getVolumeUnits()))
        {
            VolumeUnitSearch volumeSearch = new VolumeUnitSearch(facility.getVolumeUnits());
            volumeUnit = volumeSearch.getMatchedUnit();
        }
        return volumeUnit;
    }

}
