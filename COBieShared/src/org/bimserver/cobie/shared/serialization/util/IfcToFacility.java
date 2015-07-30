package org.bimserver.cobie.shared.serialization.util;

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

import org.bimserver.cobie.shared.utility.COBieIfcUtility;
import org.bimserver.cobie.shared.utility.COBieUtility;
import org.bimserver.cobie.shared.utility.GuidCompressor;
import org.bimserver.cobie.shared.utility.COBieUtility.CobieSheetName;
import org.bimserver.cobie.shared.utility.ifc.IfcUnitToCOBieString;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.ifc2x3tc1.IfcBuilding;
import org.bimserver.models.ifc2x3tc1.IfcElementQuantity;
import org.bimserver.models.ifc2x3tc1.IfcMonetaryUnit;
import org.bimserver.models.ifc2x3tc1.IfcNamedUnit;
import org.bimserver.models.ifc2x3tc1.IfcObject;
import org.bimserver.models.ifc2x3tc1.IfcObjectDefinition;
import org.bimserver.models.ifc2x3tc1.IfcOwnerHistory;
import org.bimserver.models.ifc2x3tc1.IfcProject;
import org.bimserver.models.ifc2x3tc1.IfcPropertySetDefinition;
import org.bimserver.models.ifc2x3tc1.IfcRelAggregates;
import org.bimserver.models.ifc2x3tc1.IfcRelDecomposes;
import org.bimserver.models.ifc2x3tc1.IfcRelDefines;
import org.bimserver.models.ifc2x3tc1.IfcRelDefinesByProperties;
import org.bimserver.models.ifc2x3tc1.IfcSite;
import org.bimserver.models.ifc2x3tc1.IfcSpatialStructureElement;
import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.bimserver.models.ifc2x3tc1.IfcUnitAssignment;
import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;
import org.bimserver.models.ifc2x3tc1.impl.IfcElementQuantityImpl;
import org.eclipse.emf.common.util.EList;
import org.nibs.cobie.tab.COBIEType;
import org.nibs.cobie.tab.FacilityType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IfcToFacility
{
    private static final String GSAAreaReplaceString = "GSA";
    private static final Logger LOGGER = LoggerFactory.getLogger(IfcToFacility.class);
    private static final CobieSheetName sheetName = CobieSheetName.Facility;
    static protected final String ExtProjectObject = IfcProject.class.getSimpleName();
    static protected final String ExtSiteObject = IfcSite.class.getSimpleName();
    static protected final String ExtFacilityObject = IfcBuilding.class.getSimpleName();
    static protected final String currencyUnit = "n/a";
    static protected final String DEFAULT_PROJECT_NAME = "Default Project";
    static protected final String DEFAULT_SITE_NAME = "Default Site";

    static protected String areaMeasurementFromObject(IfcObject obj)
    {
        String areaMeas = "";

        EList<IfcRelDefines> isDefinedBy = obj.getIsDefinedBy();
        for (IfcRelDefines def : isDefinedBy)
        {
            if (IfcRelDefinesByProperties.class.isInstance(def))
            {
                IfcRelDefinesByProperties defProp = (IfcRelDefinesByProperties)def;
                IfcPropertySetDefinition pSet = defProp.getRelatingPropertyDefinition();
                if (IfcElementQuantityImpl.class.isInstance(pSet))
                {
                    IfcElementQuantity eQ = (IfcElementQuantity)pSet;
                    if (eQ.getMethodOfMeasurement() != null)
                    {
                        areaMeas = eQ.getMethodOfMeasurement();
                    }
                }
            }
        }
        if ((areaMeas == null) || (areaMeas.length() == 0) || (areaMeas == COBieUtility.COBieNA))
        {
            for (IfcRelDecomposes relDec : obj.getIsDecomposedBy())
            {
                for (IfcObjectDefinition ifcObjDef : relDec.getRelatedObjects())
                {
                    if ((areaMeas == null) || (areaMeas.length() == 0) || (areaMeas == COBieUtility.COBieNA))
                    {
                        IfcObject tmpObj = (IfcObject)ifcObjDef;
                        areaMeas = areaMeasurementFromObject(tmpObj);
                    }
                }
            }
        }

        return COBieUtility.getCOBieString(areaMeas);
    }

    public static String currencyUnitFromIfcMonetaryUnit(IfcMonetaryUnit monetaryUnit)
    {
        String currencyString = "";
        currencyString = IfcUnitToCOBieString.stringFromMonetaryUnit(monetaryUnit);
        return COBieUtility.getCOBieString(currencyString);
    }

    static protected String currencyUnitsFromProject(IfcProject proj)
    {
        String units = "";
        IfcUnitAssignment ifcUnits = proj.getUnitsInContext();
        for (IfcUnit unit : ifcUnits.getUnits())
        {
            if (unit instanceof IfcMonetaryUnit)
            {
                units = IfcUnitToCOBieString.stringFromMonetaryUnit((IfcMonetaryUnit)unit);
            }
        }
        return COBieUtility.getCOBieString(units);
    }

    static protected String descriptionFromProject(IfcProject proj)
    {
        String desc = "";
        if (proj != null)
        {
            desc = proj.getDescription();
            if (COBieUtility.isNA(desc))
            {
                // look for long name
                desc = proj.getLongName();
                if (COBieUtility.isNA(desc))
                {
                    desc = proj.getName();
                }
            }
        }

        return COBieUtility.getCOBieString(desc);
    }

    static protected String descriptionFromSpatialStructureElement(IfcSpatialStructureElement element)
    {
        String desc = "";
        if (element != null)
        {
            desc = element.getDescription();
            if (COBieUtility.isNA(desc))
            {
                // look for long name
                desc = element.getLongName();
                if (COBieUtility.isNA(desc))
                {
                    desc = element.getName();
                }
            }
        }

        return COBieUtility.getCOBieString(desc);
    }

    static protected String getBuildingClassification(IfcBuilding ifcBldg)
    {
        return COBieIfcUtility.getObjectClassificationCategoryString(ifcBldg);
    }

    private static IfcProject getBuildingProject(IfcBuilding ifcBldg)
    {
        IfcProject ifcProj = null;
        for (IfcRelDecomposes relDecomp : ifcBldg.getDecomposes())
        {
            if (relDecomp instanceof IfcRelAggregates)
            {
                if (relDecomp.getRelatingObject() instanceof IfcProject)
                {
                    ifcProj = (IfcProject)relDecomp.getRelatingObject();
                }
            }

        }
        return ifcProj;
    }

    static protected IfcSite getBuildingSite(IfcBuilding ifcBldg)
    {
        IfcSite site = null;

        for (IfcRelDecomposes obj : ifcBldg.getDecomposes())
        {
            if (obj instanceof IfcRelAggregates)
            {
                IfcRelAggregates relAgg = (IfcRelAggregates)obj;
                if ((relAgg.getRelatingObject() != null) && (relAgg.getRelatingObject() instanceof IfcSite))
                {
                    site = (IfcSite)relAgg.getRelatingObject();
                }
            }
        }
        return site;

    }

    public static String getDefaultCurrencyUnits()
    {
        return currencyUnit;
    }

    static protected String getProjectAreaUnits(IfcProject proj)
    {
        String units = "";
        IfcUnitAssignment ifcUnits = proj.getUnitsInContext();
        for (IfcUnit unit : ifcUnits.getUnits())
        {
            if (IfcNamedUnit.class.isInstance(unit))
            {
                IfcNamedUnit nUnit = (IfcNamedUnit)unit;
                if (nUnit.getUnitType().getLiteral() == IfcUnitEnum.AREAUNIT.getLiteral())
                {
                    units = IfcUnitToCOBieString.getAreaUnitString(nUnit);
                }
            }
        }
        return COBieUtility.getCOBieString(units.toLowerCase());
    }

    static protected String getProjectLinearUnits(IfcProject proj)
    {
        String units = "";
        IfcUnitAssignment ifcUnits = proj.getUnitsInContext();
        for (IfcUnit unit : ifcUnits.getUnits())
        {

            if (IfcNamedUnit.class.isInstance(unit))
            {
                IfcNamedUnit nUnit = (IfcNamedUnit)unit;
                if (nUnit.getUnitType() == IfcUnitEnum.LENGTHUNIT)
                {
                    units = IfcUnitToCOBieString.linearUnitString(nUnit);
                }
            }
        }
        return COBieUtility.getCOBieString(units.toLowerCase());
    }

    static protected String getProjectName(IfcProject proj)
    {
        String projectName = "";
        if (proj != null)
        {
            if ((proj.getName() != null) && (proj.getName().length() > 0))
            {
                projectName = proj.getName();
            } else if ((proj.getLongName() != null) && (proj.getLongName().length() > 0))
            {
                projectName = proj.getLongName();
            } else
            {
                projectName = COBieUtility.getCOBieString(proj.getGlobalId());
            }
        } else
        {
            projectName = DEFAULT_PROJECT_NAME;
        }
        return COBieUtility.getCOBieString(projectName);

    }

    static protected String getSiteName(IfcSite site)
    {
        String siteName = "";
        if (site != null)
        {
            if (!COBieUtility.isNA(site.getName()))
            {
                siteName = site.getName();
            } else if (!COBieUtility.isNA(site.getLongName()))
            {
                siteName = site.getLongName();
            } else
            {
                siteName = COBieUtility.getCOBieString(site.getGlobalId());
            }
        } else
        {
            siteName = DEFAULT_SITE_NAME;
        }
        return COBieUtility.getCOBieString(siteName);

    }

    static protected IfcProject getSiteProject(IfcSite site)
    {
        IfcProject proj = null;

        for (IfcRelDecomposes obj : site.getDecomposes())
        {
            if (IfcRelAggregates.class.isInstance(obj))
            {
                IfcRelAggregates relAgg = (IfcRelAggregates)obj;
                if (IfcProject.class.isInstance(relAgg.getRelatingObject()))
                {
                    proj = (IfcProject)relAgg.getRelatingObject();
                }
            }

        }
        return proj;
    }

    static public String nameFromBuildign(IfcBuilding bldg)
    {
        return COBieUtility.getCOBieString(bldg.getName());
    }

    static protected String nameFromBuildingProjectSite(IfcBuilding bldg, IfcProject proj, IfcSite site)
    {
        String name = "";
        if (bldg != null)
        {
            name = bldg.getName();
            if (COBieUtility.isNA(name))
            {
                name = bldg.getLongName();
            }
        } else if (proj != null)
        {
            if (COBieUtility.isNA(name))
            {
                name = proj.getName();
            }
            if (COBieUtility.isNA(name))
            {
                name = proj.getLongName();
            }
        } else if (site != null)
        {
            if (COBieUtility.isNA(name))
            {
                name = site.getName();
            }
            if (COBieUtility.isNA(name))
            {
                name = site.getLongName();
            }
            if (COBieUtility.isNA(name))
            {
                name = COBieUtility.COBieNA;
            }
        }

        return COBieUtility.getCOBieString(name);
    }

    static protected String phaseFromProject(IfcProject proj)
    {
        String phase = "";
        if (proj != null)
        {
            phase = proj.getPhase();
        }

        return COBieUtility.getCOBieString(phase);
    }

    static protected String volumeUnitsFromProject(IfcProject proj)
    {
        String units = "";
        IfcUnitAssignment ifcUnits = proj.getUnitsInContext();
        for (IfcUnit unit : ifcUnits.getUnits())
        {

            if (IfcNamedUnit.class.isInstance(unit))
            {
                IfcNamedUnit nUnit = (IfcNamedUnit)unit;
                if (nUnit.getUnitType().getLiteral() == IfcUnitEnum.VOLUMEUNIT.getLiteral())
                {
                    units = IfcUnitToCOBieString.getVolumeUnitString(nUnit);
                }
            }
        }
        return COBieUtility.getCOBieString(units.toLowerCase());
    }

    public static COBIEType writeFacilitiesToCOBie(COBIEType cType, IfcModelInterface model)
    {
        LogHandler loggerHandler = new LogHandler(sheetName, LOGGER);
        loggerHandler.sheetWriteBegin();
        COBIEType.Facilities facilities = cType.addNewFacilities();
        String name = "";
        String createdBy = "";
        String category = "";
        String projectName = "";
        String siteName = "";
        String linearUnits = "";
        String areaUnits = "";
        String volumeUnits = "";
        String currencyUnits = IfcToFacility.getDefaultCurrencyUnits();
        String areaMeasurement = "";
        String extSystem = "";
        String extProjectObject = "";
        String extProjectIdentifier = "";
        String extSiteObject = "";
        String extSiteIdentifier = "";
        String extFacilityObject = "";
        String extFacilityIdentifier = "";
        String description = "";
        String projectDescription = "";
        String siteDescription = "";
        String phase = "";
        for (IfcBuilding ifcBldg : model.getAll(IfcBuilding.class))
        {
            try
            {
                IfcSite bldgSite = null;
                try
                {
                    bldgSite = IfcToFacility.getBuildingSite(ifcBldg);
                } catch (Exception e)
                {

                }
                IfcProject bldgProj = null;
                try
                {
                    bldgProj = IfcToFacility.getSiteProject(bldgSite);
                } catch (Exception e)
                {
                    bldgProj = IfcToFacility.getBuildingProject(ifcBldg);
                }
                IfcOwnerHistory ownerHistory = ifcBldg.getOwnerHistory();

                name = IfcToFacility.nameFromBuildingProjectSite(ifcBldg, bldgProj, bldgSite);

                createdBy = COBieIfcUtility.getEmailFromOwnerHistory(ownerHistory);
                Calendar cal = IfcToContact.getCreatedOn(ownerHistory.getCreationDate());
                category = COBieIfcUtility.getObjectClassificationCategoryString(ifcBldg);
                projectName = IfcToFacility.getProjectName(bldgProj);
                siteName = IfcToFacility.getSiteName(bldgSite);
                linearUnits = IfcToFacility.getProjectLinearUnits(bldgProj);
                areaUnits = IfcToFacility.getProjectAreaUnits(bldgProj);
                volumeUnits = IfcToFacility.volumeUnitsFromProject(bldgProj);
                currencyUnits = IfcToFacility.currencyUnitsFromProject(bldgProj);
                areaMeasurement = IfcToFacility.areaMeasurementFromObject(ifcBldg);
                extSystem = COBieIfcUtility.getApplicationName(ownerHistory);
                extProjectObject = IfcToFacility.ExtProjectObject;
                if (bldgProj != null)
                {
                    extProjectIdentifier = COBieIfcUtility.extIdFromRoot(bldgProj);
                } else
                {
                    extProjectIdentifier = GuidCompressor.getNewIfcGloballyUniqueId();
                }
                extSiteObject = IfcToFacility.ExtSiteObject;
                if (bldgSite != null)
                {
                    extSiteIdentifier = COBieIfcUtility.extIdFromRoot(bldgSite);
                } else
                {
                    extSiteIdentifier = GuidCompressor.getNewIfcGloballyUniqueId();
                }
                extFacilityObject = IfcToFacility.ExtFacilityObject;
                extFacilityIdentifier = COBieIfcUtility.extIdFromRoot(ifcBldg);
                description = IfcToFacility.descriptionFromSpatialStructureElement(ifcBldg);
                projectDescription = IfcToFacility.descriptionFromProject(bldgProj);
                siteDescription = IfcToFacility.descriptionFromSpatialStructureElement(bldgSite);
                phase = IfcToFacility.phaseFromProject(bldgProj);

                if (areaMeasurement.startsWith(GSAAreaReplaceString) && (extSystem != null) && (extSystem.length() > 0))
                {
                    areaMeasurement = areaMeasurement.replaceFirst(GSAAreaReplaceString, extSystem);
                }

                FacilityType tmpFacility = facilities.addNewFacility();
                tmpFacility.setName(name);
                tmpFacility.setCreatedBy(createdBy);
                tmpFacility.setCreatedOn(cal);
                tmpFacility.setCategory(category);
                tmpFacility.setProjectName(projectName);
                tmpFacility.setSiteName(siteName);
                tmpFacility.setLinearUnits(linearUnits);
                tmpFacility.setAreaUnits(areaUnits);
                tmpFacility.setVolumeUnits(volumeUnits);
                tmpFacility.setCurrencyUnit(currencyUnits);
                tmpFacility.setAreaMeasurement(areaMeasurement);
                tmpFacility.setExternalSystem(extSystem);
                tmpFacility.setExternalProjectObject(extProjectObject);
                tmpFacility.setExternalProjectIdentifier(extProjectIdentifier);
                tmpFacility.setExternalSiteObject(extSiteObject);
                tmpFacility.setExternalSiteIdentifier(extSiteIdentifier);
                tmpFacility.setExternalFacilityObject(extFacilityObject);
                tmpFacility.setExternalFacilityIdentifier(extFacilityIdentifier);
                tmpFacility.setDescription(description);
                tmpFacility.setProjectDescription(projectDescription);
                tmpFacility.setSiteDescription(siteDescription);
                tmpFacility.setPhase(phase);
                loggerHandler.rowWritten();
            } catch (Exception ex)
            {
                loggerHandler.error(ex);
            }

        }
        loggerHandler.sheetWritten();
        return cType;
    }
}
