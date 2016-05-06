package org.bimserver.cobie.shared.serialization.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.bimserver.cobie.shared.serialization.IfcCobieSerializer;
import org.bimserver.cobie.shared.utility.COBieIfcUtility;
import org.bimserver.cobie.shared.utility.COBieUtility;
import org.bimserver.cobie.shared.utility.GuidCompressor;
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
import org.nibs.cobie.tab.COBIEType.Facilities;
import org.nibs.cobie.tab.FacilityType;

import com.prairiesky.transform.cobieifc.settings.SettingsType;

public class IfcBuildingFacilitySerializer extends
		IfcCobieSerializer<FacilityType, COBIEType.Facilities, IfcBuilding> 
{
	private static final String GSAAreaReplaceString = "GSA";
	public IfcBuildingFacilitySerializer(Facilities cobieSection,
			IfcModelInterface model, SettingsType settings) 
	{
		super(cobieSection, model, settings);
	}

	@Override
	protected List<IfcBuilding> getTopLevelModelObjects() 
	{
		return model.getAll(IfcBuilding.class);
	}

	@Override
	protected List<FacilityType> serializeModelObject(IfcBuilding modelObject) 
	{
		List<FacilityType> facilities = new ArrayList<>();
		String name = "";
        String createdBy = "";
        String category = "";
        String projectName = "";
        String siteName = "";
        String linearUnits = "";
        String areaUnits = "";
        String volumeUnits = "";
        String currencyUnits = getDefaultCurrencyUnits();
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
        try
        {
            IfcSite bldgSite = null;
            try
            {
                bldgSite = IfcBuildingFacilitySerializer.getBuildingSite(modelObject);
            } catch (Exception e)
            {

            }
            IfcProject bldgProj = null;
            try
            {
                bldgProj = IfcBuildingFacilitySerializer.getSiteProject(bldgSite);
            } catch (Exception e)
            {
                bldgProj = IfcBuildingFacilitySerializer.getBuildingProject(modelObject);
            }
            IfcOwnerHistory ownerHistory = modelObject.getOwnerHistory();

            name = IfcBuildingFacilitySerializer.nameFromBuildingProjectSite(modelObject, bldgProj, bldgSite);

            createdBy = COBieIfcUtility.getEmailFromOwnerHistory(ownerHistory);
            Calendar cal = IfcToContact.getCreatedOn(ownerHistory.getCreationDate());
            category = COBieIfcUtility.getObjectClassificationCategoryString(modelObject);
            projectName = getProjectName(bldgProj);
            siteName = getSiteName(bldgSite);
            linearUnits = IfcBuildingFacilitySerializer.getProjectLinearUnits(bldgProj);
            areaUnits = IfcBuildingFacilitySerializer.getProjectAreaUnits(bldgProj);
            volumeUnits = IfcBuildingFacilitySerializer.volumeUnitsFromProject(bldgProj);
            currencyUnits = IfcBuildingFacilitySerializer.currencyUnitsFromProject(bldgProj);
            areaMeasurement = IfcBuildingFacilitySerializer.areaMeasurementFromObject(modelObject);
            extSystem = COBieIfcUtility.getApplicationName(ownerHistory);
            extProjectObject = IfcProject.class.getSimpleName();
            if (bldgProj != null)
            {
                extProjectIdentifier = COBieIfcUtility.extIdFromRoot(bldgProj);
            } else
            {
                extProjectIdentifier = GuidCompressor.getNewIfcGloballyUniqueId();
            }
            extSiteObject = IfcSite.class.getSimpleName();
            if (bldgSite != null)
            {
                extSiteIdentifier = COBieIfcUtility.extIdFromRoot(bldgSite);
            } else
            {
                extSiteIdentifier = GuidCompressor.getNewIfcGloballyUniqueId();
            }
            extFacilityObject = IfcBuilding.class.getSimpleName();
            extFacilityIdentifier = COBieIfcUtility.extIdFromRoot(modelObject);
            description = IfcBuildingFacilitySerializer.descriptionFromSpatialStructureElement(modelObject);
            projectDescription = IfcBuildingFacilitySerializer.descriptionFromProject(bldgProj);
            siteDescription = IfcBuildingFacilitySerializer.descriptionFromSpatialStructureElement(bldgSite);
            phase = IfcBuildingFacilitySerializer.phaseFromProject(bldgProj);

            if (areaMeasurement.startsWith(GSAAreaReplaceString) && (extSystem != null) && (extSystem.length() > 0))
            {
                areaMeasurement = areaMeasurement.replaceFirst(GSAAreaReplaceString, extSystem);
            }

            FacilityType tmpFacility = getCobieSection().addNewFacility();
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
            facilities.add(tmpFacility);
        } 
        catch (Exception ex)
        {

        }
		return facilities;
	}
	
    private String getDefaultCurrencyUnits() 
    {
		return COBieUtility.COBieNA;
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
    
    static IfcProject getBuildingProject(IfcBuilding ifcBldg)
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

    private String getProjectName(IfcProject proj)
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
            projectName = getDefaultProjectName();
        }
        return COBieUtility.getCOBieString(projectName);

    }

	private String getDefaultProjectName() 
	{
		String projectName = "";
		if(getSettings() != null && getSettings().getFacilitySettings() != null &&
				getSettings().getFacilitySettings().getFacilityDefaultProjectName() != null)
		{
			projectName = getSettings().getFacilitySettings().getFacilityDefaultProjectName();
		}
		return projectName;
	}
	
    protected String getSiteName(IfcSite site)
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
            siteName = getDefaultSiteName();
        }
        return COBieUtility.getCOBieString(siteName);

    }
    
    private String getDefaultSiteName() 
    {
    	String defaultSiteName = "";
    	if(getSettings() != null && getSettings().getFacilitySettings() != null &&
    			getSettings().getFacilitySettings().getFacilitySiteDefaultName() != null)
    	{
    		defaultSiteName = getSettings().getFacilitySettings().getFacilitySiteDefaultName();
    	}
    	return defaultSiteName;
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
    static protected String phaseFromProject(IfcProject proj)
    {
        String phase = "";
        if (proj != null)
        {
            phase = proj.getPhase();
        }

        return COBieUtility.getCOBieString(phase);
    }
    
    static public String nameFromBuilding(IfcBuilding bldg)
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
}
