package org.bimserver.cobie.shared.serialization.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.bimserver.cobie.shared.serialization.IfcCobieSerializer;
import org.bimserver.cobie.shared.utility.COBieIfcUtility;
import org.bimserver.cobie.shared.utility.COBieUtility;
import org.bimserver.cobie.shared.utility.COBieUtility.CobieSheetName;
import org.bimserver.cobie.shared.utility.GuidCompressor;
import org.bimserver.cobie.shared.utility.ifc.IfcRelationshipUtility;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.ifc2x3tc1.IfcAreaMeasure;
import org.bimserver.models.ifc2x3tc1.IfcBuilding;
import org.bimserver.models.ifc2x3tc1.IfcBuildingStorey;
import org.bimserver.models.ifc2x3tc1.IfcCountMeasure;
import org.bimserver.models.ifc2x3tc1.IfcLengthMeasure;
import org.bimserver.models.ifc2x3tc1.IfcObject;
import org.bimserver.models.ifc2x3tc1.IfcOwnerHistory;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.models.ifc2x3tc1.IfcProject;
import org.bimserver.models.ifc2x3tc1.IfcPropertySetDefinition;
import org.bimserver.models.ifc2x3tc1.IfcPropertySingleValue;
import org.bimserver.models.ifc2x3tc1.IfcQuantityArea;
import org.bimserver.models.ifc2x3tc1.IfcQuantityCount;
import org.bimserver.models.ifc2x3tc1.IfcQuantityLength;
import org.bimserver.models.ifc2x3tc1.IfcQuantityVolume;
import org.bimserver.models.ifc2x3tc1.IfcRelDefines;
import org.bimserver.models.ifc2x3tc1.IfcRelDefinesByProperties;
import org.bimserver.models.ifc2x3tc1.IfcRelDefinesByType;
import org.bimserver.models.ifc2x3tc1.IfcRoot;
import org.bimserver.models.ifc2x3tc1.IfcSpace;
import org.bimserver.models.ifc2x3tc1.IfcSpaceType;
import org.bimserver.models.ifc2x3tc1.IfcTypeObject;
import org.bimserver.models.ifc2x3tc1.IfcValue;
import org.bimserver.models.ifc2x3tc1.IfcVolumeMeasure;
import org.eclipse.emf.common.util.EList;
import org.nibs.cobie.tab.AttributeType;
import org.nibs.cobie.tab.COBIEType;
import org.nibs.cobie.tab.COBIEType.Attributes;
import org.nibs.cobie.tab.ComponentType;

import com.prairiesky.transform.cobieifc.settings.AttributeSettingsType;
import com.prairiesky.transform.cobieifc.settings.PropertyExclusionType;
import com.prairiesky.transform.cobieifc.settings.PropertyExclusionsType;
import com.prairiesky.transform.cobieifc.settings.SettingsType;

public class IfcRootAttributeSerializer extends
		IfcCobieSerializer<AttributeType, COBIEType.Attributes, IfcRoot> 
{
	private final static String BLANK = " ";
    protected String componentCategory = "Requirement";


	private static final String ATTRIBUTE_SPACE_TYPE = "SpaceType";
    private static final String ATTRIBUTE_SPACE_TYPE_PSET_NAME = "Pset_SpaceCommon";
	protected String typeCategory = "Requirement";
    protected String facilityCategory = "Requirement";
    protected String floorCategory = "Requirement";
    protected String spaceCategory = "Requirement";

	private String countUnit = "each";

	private boolean excludesOnNameValueDependency = false;
	

	protected static final ArrayList<String> nameValueDependencyExceptions = new ArrayList<>();
	
	private final COBIEType cobie;
	
	public COBIEType getCobie() {
		return cobie;
	}

	 public IfcRootAttributeSerializer(Attributes cobieSection,
				IfcModelInterface model, COBIEType cobie, SettingsType settings) 
		 {
			super(cobieSection, model, settings);
			this.cobie = cobie;
			initTransformSettingsFields(settings);
		}

	private void initTransformSettingsFields(SettingsType settings) 
	{
		if(settings != null && settings.getAttributeSettings() != null)
		{
			AttributeSettingsType attributeSettings = settings.getAttributeSettings();
			if(	attributeSettings.getPropertyExclusions() != null)
			{
				setExcludesOnNameValueDependency(settings.getAttributeSettings().getPropertyExclusions().isExcludePropertiesOnNameEqValue());
			}
			
			if(attributeSettings.getComponentAttributeCategory() != null)
			{
				setComponentCategory(attributeSettings.getComponentAttributeCategory());
			}
			
			if(attributeSettings.getFacilityAttributeCategory() != null)
			{
				setFacilityCategory(attributeSettings.getFacilityAttributeCategory());
			}
			
			if(attributeSettings.getFloorAttributeCategory() != null)
			{
				setFloorCategory(attributeSettings.getFloorAttributeCategory());
			}
			
			if(attributeSettings.getSpaceAttributeCategory() != null)
			{
				setSpaceCategory(attributeSettings.getSpaceAttributeCategory());
			}
			
			if(attributeSettings.getTypeAttributeCategory() != null)
			{
				setTypeCategory(attributeSettings.getTypeAttributeCategory());
			}
			
			if(attributeSettings.getAttributeCountDefaultUnit() != null)
			{
				setCountUnit(attributeSettings.getAttributeCountDefaultUnit());
			}
			
			if(attributeSettings.getPropertyExclusions() != null &&
					attributeSettings.getPropertyExclusions().getNameEqValueExceptions() != null &&
					attributeSettings.getPropertyExclusions().getNameEqValueExceptions().getName() != null)
			{
				getNamevaluedependencyexceptions().addAll(attributeSettings.getPropertyExclusions().getNameEqValueExceptions().getName());
			}
		}
	}

	public static ArrayList<String> getNamevaluedependencyexceptions() 
	{
		return nameValueDependencyExceptions;
	}

	@Override
	protected List<IfcRoot> getTopLevelModelObjects() 
	{
		List<IfcRoot> objects = new ArrayList<>();
		objects.addAll(getBuildings());
		objects.addAll(getFloors());
		objects.addAll(getSpaces());
		objects.addAll(getProducts());
		objects.addAll(IfcTypeToCOBieTypeSerializer.getCandidateRelDefinesByTypes(getModel(), getSettings()));
		objects.addAll(getSpaceTypes());
		return objects;
	}
	
	@Override
	protected List<AttributeType> serializeModelObject(IfcRoot modelObject) 
	{
		ArrayList<Map<String,IfcPropertyStringTransformer>> propertyStrings = new ArrayList<>();
		List<AttributeType> attributes = new ArrayList<>();
		if(modelObject instanceof IfcRelDefinesByType && ((IfcRelDefinesByType)modelObject).getRelatingType() instanceof IfcSpaceType)
		{
			IfcRelDefinesByType defByType = (IfcRelDefinesByType) modelObject;
			attributes.addAll(writeSpaceTypeSpaceAttribute(defByType));
		}
		else
		{
			if(modelObject instanceof IfcObject)
			{
				propertyStrings.addAll(toPropertyStrings((IfcObject)modelObject));
			}
			else if(modelObject instanceof IfcRelDefinesByType)
			{
				propertyStrings.addAll(toPropertyStrings((IfcRelDefinesByType)modelObject));
			}
				
	        for (Map<String, IfcPropertyStringTransformer> propertySetStrings : propertyStrings)
	        {
	            processPropertySetStrings(modelObject, attributes, propertySetStrings);
	        }
		}
		
        return attributes;
	}
	
    protected  ArrayList<Map<String, IfcPropertyStringTransformer>> toPropertyStrings(IfcRelDefinesByType defByType)
    {
    		ArrayList<Map<String, IfcPropertyStringTransformer>> typePropertyStrings = new ArrayList<>();
            try
            {
                Map<String, IfcPropertyStringTransformer> propertyStrings = IfcRelationshipUtility.psetStringsFromRelDefines(defByType,
                        getTypeExclusions(), true);
                if (!propertyStrings.isEmpty())
                {
                    typePropertyStrings.add(propertyStrings);
                }
                
            } catch (Exception e)
            {
            }
       
        return typePropertyStrings;
    }

    
    
    protected ArrayList<String> getFacilityExclusions()
    {
        ArrayList<String> facilityExclusionsCopy = new ArrayList<String>();
        facilityExclusionsCopy.addAll(getAllExclusions());
        facilityExclusionsCopy.addAll(getExclusions(CobieSheetName.Facility));
        return facilityExclusionsCopy;
    }
    
    protected ArrayList<String> getFloorExclusions()
    {
        ArrayList<String> floorExclusionsCopy = new ArrayList<String>();
        floorExclusionsCopy.addAll(getAllExclusions());
        floorExclusionsCopy.addAll(getExclusions(CobieSheetName.Floor));
        return floorExclusionsCopy;
    }
    
    protected ArrayList<String> getTypeExclusions()
    {
        ArrayList<String> typeExclusionsCopy = new ArrayList<String>();
        typeExclusionsCopy.addAll(getAllExclusions());
        typeExclusionsCopy.addAll(getExclusions(CobieSheetName.Type));
        return typeExclusionsCopy;
    }

    protected String categoryFromRoot(IfcRoot root)
    {
        String category = "";
        if (root instanceof IfcProduct)
        {
            category = getComponentCategory();
        } else if (root instanceof IfcBuilding)
        {
            category = getFacilityCategory();
        } else if (root instanceof IfcBuildingStorey)
        {
            category = getComponentCategory();
        } else if (root instanceof IfcSpace)
        {
            category = getSpaceCategory();
        } else
        {
            category = spaceCategory;
        }
        return category;
    }
	private void processPropertySetStrings(IfcRoot modelObject,
			List<AttributeType> attributes, Map<String, IfcPropertyStringTransformer> propertySetStrings) 
	{
		IfcProject project = getFirstProject();
        IfcOwnerHistory defaultOwnerHistory = IfcToContact.getLatestOwnerHistory(model);
        String name = "";
        String defaultCreatedBy = COBieIfcUtility.getEmailFromOwnerHistory(defaultOwnerHistory);
        String createdBy = defaultCreatedBy;
        Calendar createdOn = IfcToContact.getCreatedOn(defaultOwnerHistory.getCreationDate());
        String category = categoryFromRoot(modelObject);
        
        String worksheetName = "";
        String rowName = "";
        if(modelObject instanceof IfcObject)
        {
        	worksheetName =	toAttributeSheetName(modelObject);
        	rowName = COBieUtility.getCOBieString(modelObject.getName());
        }
        else if (modelObject instanceof IfcRelDefinesByType)
        {
        	worksheetName = toAttributeSheetName(((IfcRelDefinesByType)modelObject).getRelatingType());
        	rowName = COBieUtility.getCOBieString(((IfcRelDefinesByType)modelObject).getRelatingType().getName());
        }
        
        IfcPropertyStringTransformer pStrvalue;
        String value;
        String unit = "";
        String extSystem = "";
        String extObject = "";
        String extIdentifier = "";
        String description = "";
        String allowedValues = "";
		for (String attributeKey : propertySetStrings.keySet())
		{
		    category = categoryFromRoot(modelObject);
		    name = attributeKey;
		    pStrvalue = propertySetStrings.get(attributeKey);
		    value = pStrvalue.getValueString();
		    if (!isExcludedByNameValue(name, value) && !excludeValue(value))
		    {
		        try
		        {
		            if (pStrvalue.getAttachedOwnerHistory() != null)
		            {
		                createdBy = COBieIfcUtility.getEmailFromOwnerHistory(pStrvalue.getAttachedOwnerHistory());
		                createdOn = IfcToContact.getCreatedOn(pStrvalue.getAttachedOwnerHistory().getCreationDate());
		                extSystem = COBieIfcUtility.getApplicationName(pStrvalue.getAttachedOwnerHistory());
		            } else
		            {
		                createdBy = defaultCreatedBy;
		                createdOn = IfcToContact.getCreatedOn(defaultOwnerHistory.getCreationDate());
		                extSystem = COBieIfcUtility.getApplicationName(defaultOwnerHistory);
		            }
		        } 
		        catch (Exception ohException)
		        {
		            createdBy = defaultCreatedBy;
		            createdOn = IfcToContact.getCreatedOn(defaultOwnerHistory.getCreationDate());
		            extSystem = COBieIfcUtility.getApplicationName(defaultOwnerHistory);
		        }
		        
		        description = pStrvalue.getDescriptionString();
		        extObject = pStrvalue.getPropertySetString();
		        if(!excludePropertySet(worksheetName, extObject))
		        {
		            extIdentifier = pStrvalue.getPropertySetGlobalIDString();

		            allowedValues = setAllowedValues(pStrvalue);
		            unit = getUnit(pStrvalue, project);
		            category = categoryFromPropertyStringValue(category, pStrvalue);

		            attributes.add(addNewAttribute(name, createdBy, createdOn, category, worksheetName, rowName, value, unit, extSystem,
		                    extObject, extIdentifier, description, allowedValues));
		        }
		    } 
		}
	}
	
   private boolean excludeValue(String value) 
   {
		boolean exclude = false;
		if(value != null)
		{
			for(PropertyExclusionType property : getValueExclusions())
			{
				if(exclude)
				{
					break;
				}
				String referenceString = property.getValue().toLowerCase();
				String lcValue = value.toLowerCase();
				if(referenceString != null && property.getComparison() != null)
				{
					switch(property.getComparison())
					{
						case CONTAINS:
							exclude = lcValue.contains(referenceString);
							break;
						case ENDSWITH:
							exclude = lcValue.endsWith(referenceString);
							break;
						case EQUALS:
							exclude = lcValue.equals(referenceString);
							break;
						case STARTSWITH:
							exclude = lcValue.startsWith(referenceString);
							break;
						default:
							break;
					
					}
				}
			}
		}
		
		return exclude;
   }

	private boolean excludePropertySet(String worksheetName, String propertySetName) 
	   {
		   boolean exclude = false;
		   try
		   {
			   CobieSheetName sheetName = CobieSheetName.valueOf(worksheetName);
			   if(sheetName != null && getSettings() != null &&
					   getSettings().getAttributeSettings() != null &&
					   getSettings().getAttributeSettings().getPropertyExclusions() != null)
			   {
				   PropertyExclusionsType exclusions = getSettings().getAttributeSettings().getPropertyExclusions();
				   List<PropertyExclusionType> propertyExclusions = new ArrayList<>();
				   switch(sheetName)
				   {
						case Component:
							if(exclusions.getComponentPropertySetNameExclusions() != null && exclusions.getComponentPropertySetNameExclusions().getExclude() != null)
							{
								propertyExclusions.addAll(exclusions.getComponentPropertySetNameExclusions().getExclude());
							}
						break;
						case Facility:
							if(exclusions.getFacilityPropertySetNameExclusions() != null &&
								exclusions.getFacilityPropertySetNameExclusions().getExclude() != null)
							{
								propertyExclusions.addAll(exclusions.getFacilityPropertySetNameExclusions().getExclude());
							}
						break;
						case Floor:
							if(exclusions.getFloorPropertySetNameExclusions() != null &&
								exclusions.getFloorPropertySetNameExclusions().getExclude() != null)
							{
								propertyExclusions.addAll(exclusions.getFloorPropertySetNameExclusions().getExclude());
							}
						break;
						case Space:
								if(exclusions.getSpacePropertySetNameExclusions() != null &&
									exclusions.getSpacePropertySetNameExclusions().getExclude() != null)
								{
									propertyExclusions.addAll(exclusions.getSpacePropertySetNameExclusions().getExclude());
								}
							break;
						case Type:
								if(exclusions.getTypePropertySetNameExclusions() != null &&
									exclusions.getTypePropertySetNameExclusions().getExclude() != null)
								{
									propertyExclusions.addAll(exclusions.getTypePropertySetNameExclusions().getExclude());
								}
							break;
						default:
							break;
				   }
				   exclude = isExcluded(propertyExclusions, propertySetName);
			   }
			   
		   }
		   catch(Exception e)
		   {
			   
		   }
		   
		   return exclude;
	   }

	private boolean isExcluded(List<PropertyExclusionType> propertyExclusions,
			String propertySetName) 
	{
		boolean excluded = false;
		for(PropertyExclusionType exclusion : propertyExclusions)
		{
			if(excluded)
			{
				break;
			}
			else if(exclusion.getComparison() != null && exclusion.getValue() != null && propertySetName != null)
			{
				String value = exclusion.getValue().trim().toLowerCase();
				String trimmedPsetName = propertySetName.trim().toLowerCase();
				switch(exclusion.getComparison())
				{
					case CONTAINS:
						excluded = trimmedPsetName.contains(value);
						break;
					case ENDSWITH:
						excluded = trimmedPsetName.endsWith(value);
						break;
					case EQUALS:
						excluded = trimmedPsetName.equalsIgnoreCase(value);
						break;
					case STARTSWITH:
						excluded = trimmedPsetName.startsWith(value);
						break;
					default:
						break;
					
				}
			}
		}
		return excluded;
	}

	public static String toAttributeSheetName(IfcRoot root)
	    {
	        String worksheetName = "";

	        if (root instanceof IfcBuilding)
	        {
	            worksheetName = CobieSheetName.Facility.toString();
	        } else if (root instanceof IfcBuildingStorey)
	        {
	            worksheetName = CobieSheetName.Floor.toString();
	        } else if (root instanceof IfcSpace)
	        {
	            worksheetName = CobieSheetName.Space.toString();
	        } else if (root instanceof IfcProduct)
	        {
	            worksheetName = CobieSheetName.Component.toString();
	        }
	        else if (root instanceof IfcTypeObject)
	        {
	        	worksheetName = CobieSheetName.Type.toString();
	        }
	        return worksheetName;
	    }

        
	
    private IfcProject getFirstProject()
    {
        List<IfcProject> projects = getModel().getAll(IfcProject.class);
        IfcProject project = null;
        if (projects.size() > 0)
        {
            project = projects.get(0);
        }
        return project;
    }
	
    protected boolean getExcludesOnNameValueDependency()
    {
        return excludesOnNameValueDependency ;
    }
    
    protected ArrayList<String> getAllExclusions()
    {
        ArrayList<String> compExclusions = new ArrayList<String>();
        if(getSettings() != null && getSettings().getAttributeSettings() != null && getSettings().getAttributeSettings().getPropertyExclusions() != null
        		&& getSettings().getAttributeSettings().getPropertyExclusions().getGlobalPropertyNameExclusions() != null &&
        		getSettings().getAttributeSettings().getPropertyExclusions().getGlobalPropertyNameExclusions().getExclude() != null)
        {
        	compExclusions.addAll(IfcRootAttributeSerializer.toEncodedPropertyComparisonStrings(getSettings().getAttributeSettings().getPropertyExclusions().getGlobalPropertyNameExclusions().getExclude()));
        }
        return compExclusions;
    }
    
    
    
    protected  ArrayList<Map<String, IfcPropertyStringTransformer>> toPropertyStrings(IfcObject object)
    {
        ArrayList<Map<String, IfcPropertyStringTransformer>> productPropertyStrings = new ArrayList<>();
        ArrayList<String> excludeAttributes = new ArrayList<>();
        if (object instanceof IfcBuilding)
        {
            excludeAttributes = getFacilityExclusions();
        } else if (object instanceof IfcBuildingStorey)
        {
            excludeAttributes = getFloorExclusions();
        } else if (object instanceof IfcSpace)
        {
            excludeAttributes = getSpaceExclusions();
        } else if (object instanceof IfcProduct)
        {
            excludeAttributes = getComponentExclusions();
        }
        
        EList<IfcRelDefines> relDefines = object.getIsDefinedBy();

        for (IfcRelDefines relDef : relDefines)
        {
            if (!(relDef instanceof IfcRelDefinesByType))
            {
                Map<String, IfcPropertyStringTransformer> propertyStrings = IfcRelationshipUtility.psetStringsFromRelDefines(relDef,
                        excludeAttributes, true);
                if (!propertyStrings.isEmpty())
                {
                    productPropertyStrings.add(propertyStrings);
                }   
            }
        }
        Map<String, IfcPropertyStringTransformer> directAttributes = COBieIfcUtility.psetStringsFromAttributes(object, getAllExclusions(), true);
        if (!directAttributes.isEmpty())
        {
            productPropertyStrings.add(directAttributes);
        }
        return productPropertyStrings;
    }
    
    protected ArrayList<String> getSpaceExclusions()
    {
        ArrayList<String> spaceExclusionsCopy = new ArrayList<String>();
        spaceExclusionsCopy.addAll(getAllExclusions());
        spaceExclusionsCopy.addAll(getExclusions(CobieSheetName.Space));
        return spaceExclusionsCopy;
    }
    
    protected ArrayList<String> getExclusions(CobieSheetName sheet)
    {
    	ArrayList<String> exclusions = new ArrayList<>();
    	if(getSettings() !=  null && getSettings().getAttributeSettings() != null &&
    			getSettings().getAttributeSettings().getPropertyExclusions() != null)
    	{
    		PropertyExclusionsType propertyExclusionsCollection =
    				getSettings().getAttributeSettings().getPropertyExclusions();
    		List<PropertyExclusionType> propertyExclusions = new ArrayList<>();
    		switch(sheet)
        	{
	    		case Component:
	    			if(propertyExclusionsCollection.getComponentPropertyNameExclusions() != null &&
	    				propertyExclusionsCollection.getComponentPropertyNameExclusions().getExclude() != null)
	    			{
	    				propertyExclusions.addAll(propertyExclusionsCollection.getComponentPropertyNameExclusions().getExclude());
	    			}
	    			break;
	    		case Facility:
	    			if(propertyExclusionsCollection.getFacilityPropertyNameExclusions() != null &&
	    				propertyExclusionsCollection.getFacilityPropertyNameExclusions().getExclude() != null)
	    			{
	    				propertyExclusions.addAll(propertyExclusionsCollection.getFacilityPropertyNameExclusions().getExclude());
	    			}
	    			break;
	    		case Floor:
	    			if(propertyExclusionsCollection.getFloorPropertyNameExclusions() != null &&
	    				propertyExclusionsCollection.getFloorPropertyNameExclusions().getExclude() != null)
	    			{
	    				propertyExclusions.addAll(propertyExclusionsCollection.getFloorPropertyNameExclusions().getExclude());
	    			}
	    			break;
	    		case Space:
	    			if(propertyExclusionsCollection.getSpacePropertyNameExclusions() != null &&
	    				propertyExclusionsCollection.getSpacePropertyNameExclusions().getExclude() != null)
	    			{
	    				propertyExclusions.addAll(propertyExclusionsCollection.getSpacePropertyNameExclusions().getExclude());
	    			}
	    			break;
	    		case Type:
	    			if(propertyExclusionsCollection.getTypePropertyNameExclusions() != null &&
	    				propertyExclusionsCollection.getTypePropertyNameExclusions().getExclude() != null)
	    			{
	    				propertyExclusions.addAll(propertyExclusionsCollection.getTypePropertyNameExclusions().getExclude());
	    			}
	    			break;
	    		default:
	    			break;
        	
        	}
    		exclusions.addAll(toEncodedPropertyComparisonStrings(propertyExclusions));
    	}
    	
    	return exclusions;
    }
    
	
	public AttributeType addNewAttribute(
            String name,
            String createdBy,
            Calendar createdOn,
            String category,
            String worksheetName,
            String rowName,
            String value,
            String unit,
            String extSystem,
            String extObject,
            String extIdentifier,
            String description,
            String allowedValues)
    {
        AttributeType tempAttribute;
        tempAttribute = getCobieSection().addNewAttribute();
        tempAttribute.setName(name);
        tempAttribute.setRowName(rowName);
        tempAttribute.setSheetName(worksheetName);
        tempAttribute.setValue(value);
        tempAttribute.setUnit(unit);
        tempAttribute.setExtSystem(extSystem);
        tempAttribute.setExtIdentifier(extIdentifier);
        tempAttribute.setCreatedBy(createdBy);
        tempAttribute.setCreatedOn(createdOn);
        tempAttribute.setCategory(category);
        tempAttribute.setExtObject(extObject);
        tempAttribute.setDescription(description);
        tempAttribute.setAllowedValues(allowedValues);
        tempAttribute.setExtIdentifier(extIdentifier);
        return tempAttribute;
    }
	
    private String categoryFromPropertyStringValue(String category, IfcPropertyStringTransformer pStrvalue)
    {
        if (pStrvalue.getPropertySet() != null)
        {
            String tmpCategory = COBieIfcUtility.getPropertySetClassification(pStrvalue.getPropertySet(), getModel());
            if (!COBieUtility.isNA(tmpCategory))
            {
                category = tmpCategory;
            }
        }
        return category;
    }
	
    private String getUnit(IfcPropertyStringTransformer pStrvalue, IfcProject ifcProject)
    {
        String unit = "";
        if (pStrvalue instanceof IfcPhysicalQuantityToCOBieString)
        {
            IfcPhysicalQuantityToCOBieString pQStr = (IfcPhysicalQuantityToCOBieString)pStrvalue;
            unit = COBieUtility.getCOBieString(pQStr.getUnitString());
        } else if (pStrvalue instanceof IfcSingleValueToCOBieString)
        {
            IfcSingleValueToCOBieString svStr = (IfcSingleValueToCOBieString)pStrvalue;
            unit = COBieUtility.getCOBieString(svStr.getUnitString());
        } else if (pStrvalue instanceof IfcEnumeratedValueToCOBieString)
        {
            IfcEnumeratedValueToCOBieString enumStr = (IfcEnumeratedValueToCOBieString)pStrvalue;
            unit = COBieUtility.getCOBieString(enumStr.getUnitString());
        }
        if (COBieUtility.isNA(unit))
        {
            unit = assignUnitsBasedOnProjectDefaults(pStrvalue, ifcProject);
        }
        return unit;
    }
    
    private String assignUnitsBasedOnProjectDefaults(IfcPropertyStringTransformer pStrvalue, IfcProject ifcProject)
    {
        String unit = COBieUtility.COBieNA;
        String linearUnits = IfcBuildingFacilitySerializer.getProjectLinearUnits(ifcProject);
        String areaUnits = IfcBuildingFacilitySerializer.getProjectAreaUnits(ifcProject);
        String volumeUnits = IfcBuildingFacilitySerializer.volumeUnitsFromProject(ifcProject);

        if (pStrvalue.getQuantity() instanceof IfcQuantityArea)
        {
            unit = areaUnits;
        } else if (pStrvalue instanceof IfcQuantityCount)
        {
            unit = countUnit;
        } else if (pStrvalue.getQuantity() instanceof IfcQuantityLength)
        {
            unit = linearUnits;
        } else if (pStrvalue.getQuantity() instanceof IfcQuantityVolume)
        {
            unit = volumeUnits;
        } else if (pStrvalue.getProperty() instanceof IfcPropertySingleValue)
        {
            IfcPropertySingleValue propertySingleValue = (IfcPropertySingleValue)pStrvalue.getProperty();
            IfcValue value = propertySingleValue.getNominalValue();
            if (value instanceof IfcVolumeMeasure)
            {
                unit = volumeUnits;
            } else if (value instanceof IfcAreaMeasure)
            {
                unit = areaUnits;
            } else if (value instanceof IfcLengthMeasure)
            {
                unit = linearUnits;
            } else if (value instanceof IfcCountMeasure)
            {
                unit = countUnit;
            }

        }
        return unit;
    }
	
    private static String setAllowedValues(IfcPropertyStringTransformer pStrvalue)
    {
        String allowedValues = "";
        if (pStrvalue instanceof IfcPhysicalQuantityToCOBieString)
        {
            allowedValues = COBieUtility.COBieNA;
        } else if (pStrvalue instanceof IfcSingleValueToCOBieString)
        {
            allowedValues = COBieUtility.COBieNA;
        } else if (pStrvalue instanceof IfcEnumeratedValueToCOBieString)
        {
            IfcEnumeratedValueToCOBieString enumStr = (IfcEnumeratedValueToCOBieString)pStrvalue;
            allowedValues = COBieUtility.getCOBieString(COBieUtility.delimittedStringFromArrayList(enumStr.getEnumerationReferenceStrings()));

        }
        return allowedValues;
    }
	
    ///TODO: FIX THIS, IT ISN'T DOING WHAT IT'S SUPPOSED TO DO...IS ONLY DOINOG A CONTAINS
    // COMPARISON
    protected boolean isExcludedByNameValue(String name, String value)
    {
        List<String> exceptionNames = getExcludesOnNameValueDependencyExceptions();
        if (name.equalsIgnoreCase(value) && !exceptionNames.contains(name) && getExcludesOnNameValueDependency())
        {
            return true;
        } 
        else
        {
            return false;
        }
    }
    
    protected ArrayList<String> getComponentExclusions()
    {
        ArrayList<String> compExclusions = new ArrayList<String>();
        compExclusions.addAll(getAllExclusions());
        compExclusions.addAll(getExclusions(CobieSheetName.Component));
        return compExclusions;
    }
    
    protected List<PropertyExclusionType> getValueExclusions()
    {
    	List<PropertyExclusionType> exclusions = new ArrayList<>();
    	if(getSettings() != null &&
    			getSettings().getAttributeSettings() != null &&
    			getSettings().getAttributeSettings().getPropertyExclusions() != null &&
    			getSettings().getAttributeSettings().getPropertyExclusions().getValueExclusions() != null)
    	{
    		exclusions.addAll(getSettings().getAttributeSettings().getPropertyExclusions().getValueExclusions().getExclude());
    	}
        
        return exclusions;
    }
    
    protected List<String> getExcludesOnNameValueDependencyExceptions()
    {
        return nameValueDependencyExceptions;
    }
	
    protected  ArrayList<IfcObject> getFloors()
    {

        ArrayList<IfcObject> bldgObjs = new ArrayList<IfcObject>();
        for (IfcBuildingStorey bldgStorey : getModel().getAll(IfcBuildingStorey.class))
        {
            bldgObjs.add(bldgStorey);
        }
        return bldgObjs;
    }
    
    protected ArrayList<IfcObject> getSpaces()
    {
        ArrayList<IfcObject> bldgObjs = new ArrayList<IfcObject>();
        for (IfcSpace space : getModel().getAll(IfcSpace.class))
        {
            bldgObjs.add(space);
        }
        return bldgObjs;
    }
    
    protected ArrayList<IfcObject> getBuildings()
    {
        ArrayList<IfcObject> bldgObjs = new ArrayList<IfcObject>();
        for (IfcBuilding bldg : getModel().getAll(IfcBuilding.class))
        {
            bldgObjs.add(bldg);
        }
        return bldgObjs;
    }
    
    protected List<IfcProduct> getProducts()
    {
        List<IfcRelDefinesByType> defByTypes = IfcTypeToCOBieTypeSerializer.getCandidateRelDefinesByTypes(getModel(), getSettings());
        ArrayList<String> componentNamesAdded = new ArrayList<>();
        IfcProduct tempProduct;
        String name;
        ArrayList<IfcProduct> products = new ArrayList<>();
        for (IfcRelDefinesByType defByType : defByTypes)
        {

            for (IfcObject obj : defByType.getRelatedObjects())
            {
            	//Because the BIMServer IDM plugins are no longer supported, filtering of components
            	//and types must occur wherever they are references (until the code is refactored with
            	//a better solution in mind, e.g. adding a IDM-like filtering stage at the beginning of the transform).
            	//https://github.com/opensourceBIM/COBie-plugins/issues/15
                if (obj instanceof IfcProduct && IfcProductToComponentsSerializer.isAssetComponent(obj, getSettings()))
                {
                    tempProduct = (IfcProduct)obj;
                    name = IfcToComponent.nameFromProduct(tempProduct);
                    if (!componentNamesAdded.contains(name) && isComponentInCOBie(tempProduct))
                    {
                        // IfcToComponent.isAssetComponent(tempProduct))
                        products.add(tempProduct);
                    }
                }
            }
        }
       return products;
    }
    
	public  boolean isComponentInCOBie(IfcProduct product)
    {
        boolean isInCOBie = false;
        String componentName = product.getName();
        String guid = "";
        try
        {
            guid = product.getGlobalId();
        } catch (Exception e)
        {

        }
        for (ComponentType component :  cobie.getComponents().getComponentList())
        {
            if (component.getName().equals(componentName) && component.getExtIdentifier().equals(guid))
            {
                isInCOBie = true;
            }
        }
        return isInCOBie;
    }


    public List<IfcRelDefinesByType> getSpaceTypes()
    {
    	List<IfcRelDefinesByType> spaceTypes = new ArrayList<>();
        for (IfcObject objSpace : getSpaces())
        {
            if (objSpace instanceof IfcSpace)
            {
                IfcSpace space = (IfcSpace)objSpace;
                if (space.getIsDefinedBy() != null)
                {
                    for (IfcRelDefines relDefines : space.getIsDefinedBy())
                    {
                        if (relDefines instanceof IfcRelDefinesByType)
                        {
                            IfcRelDefinesByType relDefByType = (IfcRelDefinesByType)relDefines;
                            if (relDefByType.getRelatingType() != null)
                            {
                                IfcTypeObject typeObject = relDefByType.getRelatingType();
                                if (typeObject instanceof IfcSpaceType)
                                {
                                    spaceTypes.add(relDefByType);
                                }
                            }
                        }
                    }
                }
            }
        }
        return spaceTypes;
    }
    
    public static ArrayList<String> toEncodedPropertyComparisonStrings(List<PropertyExclusionType> exclusions)
    {
    	ArrayList<String> excludes = new ArrayList<>();
    	for(PropertyExclusionType exclusion : exclusions)
    	{
    		excludes.add(IfcRootAttributeSerializer.toEncodedPropertyComparisonString(exclusion));
    	}
    	return excludes;
    }
    
    /**
     * This method converts the PropertyExclusionType into the string that is used for comparing
     * property name matches in the older code...
     *   -CONTAINS:  the search string is prefixed and postfixed with a blank space
     *   -EQUALS: the search string is not prefixed or postfixed with a blank space
     *   -STARTSWITH: the search string is postfixed with a blank space
     *   -ENDSWITH the search string is prefixed with a blank space
     *   Eventually this method will be deprecated as the old way of searching for property names
     *   is updated.
     * @param exclusion
     * @return
     */
    public static String toEncodedPropertyComparisonString(PropertyExclusionType exclusion)
    {
    	String comparisonString = "";
    	if(exclusion != null && exclusion.getComparison() != null && exclusion.getValue() != null)
    	{
    		String value = exclusion.getValue().trim();
    		switch(exclusion.getComparison())
    		{
			case CONTAINS:
				comparisonString = BLANK + value + BLANK;
				break;
			case ENDSWITH:
				comparisonString = BLANK + value;
				break;
			case EQUALS:
				comparisonString = value;
				break;
			case STARTSWITH:
				comparisonString = value + BLANK;
				break;
			default:
				break;
    			
    		}
    	}
    	return comparisonString;
    }

    private static String pSetCommonGuidFromSpace(IfcSpace space)
    {
        String guid = "";
        for (IfcRelDefines relDefines : space.getIsDefinedBy())
        {
            if (relDefines instanceof IfcRelDefinesByProperties)
            {
                IfcRelDefinesByProperties relPropDef = (IfcRelDefinesByProperties)relDefines;

                IfcPropertySetDefinition pSetDef = relPropDef.getRelatingPropertyDefinition();
                if (pSetDef.getName().equalsIgnoreCase(ATTRIBUTE_SPACE_TYPE_PSET_NAME))
                {
                    guid = pSetDef.getGlobalId();
                }
            }
        }
        if (COBieUtility.isNA(guid))
        {
            guid = GuidCompressor.getNewIfcGloballyUniqueId();
        }
        return guid;

    }

    private  List<AttributeType> writeSpaceTypeSpaceAttribute(IfcRelDefinesByType defByType)
    {
    	List<AttributeType> attributeList = new ArrayList<>();
		IfcSpaceType spaceType = (IfcSpaceType) defByType.getRelatingType();
		for(IfcObject object : defByType.getRelatedObjects())
		{
			if(object instanceof IfcSpace)
			{
				IfcSpace space = (IfcSpace) object;
				 AttributeType attribute = getCobieSection().addNewAttribute();
		        attribute.setName(ATTRIBUTE_SPACE_TYPE);
		        attribute.setAllowedValues(COBieUtility.COBieNA);
		        attribute.setValue(spaceType.getName());
		        attribute.setSheetName(COBieUtility.CobieSheetName.Space.name());
		        attribute.setRowName(IfcSpaceSerializer.nameFromSpace(space));
		        attribute.setExtObject(ATTRIBUTE_SPACE_TYPE_PSET_NAME);
		        attribute.setDescription(COBieUtility.getCOBieString(spaceType.getDescription()));
		        attribute.setCategory(categoryFromRoot(spaceType));
		        attribute.setCreatedBy(COBieIfcUtility.getEmailFromOwnerHistory(spaceType.getOwnerHistory()));
		        attribute.setCreatedOn(COBieUtility.ifcTimeStampAsCalendar(spaceType.getOwnerHistory().getCreationDate()));
		        attribute.setExtSystem(COBieIfcUtility.getApplicationName(spaceType.getOwnerHistory()));
		        attribute.setUnit(COBieUtility.COBieNA);
		        attribute.setExtIdentifier(pSetCommonGuidFromSpace(space));
		        attributeList.add(attribute);
			}
		}
        return attributeList;
    }
    

    public String getComponentCategory() {
		return componentCategory;
	}

	public void setComponentCategory(String componentCategory) {
		this.componentCategory = componentCategory;
	}

	public String getTypeCategory() {
		return typeCategory;
	}

	public void setTypeCategory(String typeCategory) {
		this.typeCategory = typeCategory;
	}

	public String getFacilityCategory() {
		return facilityCategory;
	}

	public void setFacilityCategory(String facilityCategory) {
		this.facilityCategory = facilityCategory;
	}

	public String getFloorCategory() {
		return floorCategory;
	}

	public void setFloorCategory(String floorCategory) {
		this.floorCategory = floorCategory;
	}

	public String getSpaceCategory() {
		return spaceCategory;
	}

	public void setSpaceCategory(String spaceCategory) {
		this.spaceCategory = spaceCategory;
	}
	
	public String getCountUnit() 
	{
		return countUnit;
	}

	public void setCountUnit(String countUnit) {
		this.countUnit = countUnit;
	}

	public void setExcludesOnNameValueDependency(
			boolean excludesOnNameValueDependency) {
		this.excludesOnNameValueDependency = excludesOnNameValueDependency;
	}
}
