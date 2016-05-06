package org.bimserver.cobie.shared.serialization.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.bimserver.cobie.shared.serialization.IfcCobieSerializer;
import org.bimserver.cobie.shared.utility.COBieIfcUtility;
import org.bimserver.cobie.shared.utility.COBieUtility;
import org.bimserver.cobie.shared.utility.ifc.IfcRelationshipUtility;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.ifc2x3tc1.IfcConstructionProductResource;
import org.bimserver.models.ifc2x3tc1.IfcOwnerHistory;
import org.bimserver.models.ifc2x3tc1.IfcRelAssignsToResource;
import org.nibs.cobie.tab.COBIEType;
import org.nibs.cobie.tab.COBIEType.Spares;
import org.nibs.cobie.tab.SpareType;

import com.prairiesky.transform.cobieifc.settings.SettingsType;

public class IfcConstructionProductResourceSpareSerializer extends
		IfcCobieSerializer<SpareType, COBIEType.Spares, IfcConstructionProductResource> 
{

	public IfcConstructionProductResourceSpareSerializer(Spares cobieSection,
			IfcModelInterface model, SettingsType settings) 
	{
		super(cobieSection, model, settings);
	}
	
    private static String categoryFromConstructionProductResource(IfcConstructionProductResource resource)
    {
        return COBieIfcUtility.getObjectClassificationCategoryString(resource);
    }

    private static String descriptionFromConstructionProductResource(IfcConstructionProductResource productResource)
    {
        String description = productResource.getDescription();
        if ((description == null) || description.isEmpty())
        {
            description = productResource.getName();
        }
        return COBieUtility.getCOBieString(description);
    }

    public ArrayList<String> getPartNumberPropertyNames()
    {
    	ArrayList<String> propertyNames = new ArrayList<>();
        if(getSettings() != null &&
        		getSettings().getSpareSettings() != null
        		&& getSettings().getSpareSettings().getPartNumberPropertyNames() != null &&
        		getSettings().getSpareSettings().getPartNumberPropertyNames().getName() != null)
        {
        	propertyNames.addAll(getSettings().getSpareSettings().getPartNumberPropertyNames().getName());
        }
        return propertyNames;
    }

    public ArrayList<String> getSetNumberPropertyNames()
    {
    	ArrayList<String> propertyNames = new ArrayList<>();
        if(getSettings() != null &&
        		getSettings().getSpareSettings() != null
        		&& getSettings().getSpareSettings().getSetNumberPropertyNames() != null &&
        		getSettings().getSpareSettings().getSetNumberPropertyNames().getName() != null)
        {
        	propertyNames.addAll(getSettings().getSpareSettings().getSetNumberPropertyNames().getName());
        }
        return propertyNames;
    }

    public ArrayList<String> getSuppliersPropertyNames()
    {
    	ArrayList<String> propertyNames =
    			new ArrayList<>();

        if(getSettings() != null &&
        		getSettings().getSpareSettings() != null
        		&& getSettings().getSpareSettings().getSupplierPropertyNames() != null &&
        		getSettings().getSpareSettings().getSupplierPropertyNames().getName() != null)
        {
        	propertyNames.addAll(getSettings().getSpareSettings().getSupplierPropertyNames().getName());
        }
        return propertyNames;
    }

    private static String nameFromConstructionProductResource(IfcConstructionProductResource resource)
    {
        String name = resource.getName();
        return COBieUtility.getCOBieString(name);
    }

    private String partNumberFromConstructionProductResource(IfcConstructionProductResource productResource)
    {
        String partNumber = productResource.getResourceIdentifier();
        if (COBieUtility.isNA(partNumber))
        {
            partNumber = IfcRelationshipUtility.getHighestRankingPropertyStringFromRelDefinesList(productResource.getIsDefinedBy(),
                    getPartNumberPropertyNames(), false);
        }
        return COBieUtility.getCOBieString(partNumber);
    }

    private String setNumberFromConstructionProductResource(IfcConstructionProductResource productResource)
    {
        ArrayList<String> setNumberPropertyNames = getSetNumberPropertyNames();
        String setNumber = productResource.getResourceGroup();
        if (COBieUtility.isNA(setNumber))
        {
            setNumber = IfcRelationshipUtility.getHighestRankingPropertyStringFromRelDefinesList(productResource.getIsDefinedBy(),
                    setNumberPropertyNames, false);
        }
        return COBieUtility.getCOBieString(setNumber);
    }

    private  String suppliersFromConstructionProductResource(IfcConstructionProductResource productResource)
    {
        String suppliers;
        ArrayList<String> suppliersPropertyNames = getSuppliersPropertyNames();
        suppliers = IfcRelationshipUtility.getHighestRankingPropertyStringFromRelDefinesList(productResource.getIsDefinedBy(),
                suppliersPropertyNames, false);
        return COBieUtility.getCOBieString(suppliers);
    }

    private static String typeNameFromConstructionProductResource(IfcConstructionProductResource resource)
    {
        String typeName = "";
        for (IfcRelAssignsToResource resAssign : resource.getResourceOf())
        {
            if (COBieUtility.isNA(typeName) && (resAssign.getRelatedObjects().size() > 0))
            {
                typeName = resAssign.getRelatedObjects().get(0).getName();
            }
        }

        return COBieUtility.getCOBieString(typeName);
    }

	@Override
	protected List<IfcConstructionProductResource> getTopLevelModelObjects() 
	{
		return model.getAll(IfcConstructionProductResource.class);
	}

	@Override
	protected List<SpareType> serializeModelObject(
			IfcConstructionProductResource productResource) 
	{
		List<SpareType> spares = new ArrayList<>();
        String name;
        String createdBy;
        Calendar createdOn;
        String category;
        String typeName;
        String suppliers;
        String extSystem;
        String extObject;
        String extIdentifier;
        String description;
        String setNumber;
        String partNumber;
        IfcOwnerHistory oh = productResource.getOwnerHistory();
        name = IfcConstructionProductResourceSpareSerializer.nameFromConstructionProductResource(productResource);
        createdBy = COBieIfcUtility.getEmailFromOwnerHistory(oh);
        createdOn = IfcToContact.getCreatedOn(oh.getCreationDate());
        category = IfcConstructionProductResourceSpareSerializer.categoryFromConstructionProductResource(productResource);
        typeName = IfcConstructionProductResourceSpareSerializer.typeNameFromConstructionProductResource(productResource);
        suppliers = suppliersFromConstructionProductResource(productResource);
        extSystem = COBieIfcUtility.getApplicationName(oh);
        extObject = COBieIfcUtility.extObjectFromObjectDef(productResource);
        extIdentifier = COBieIfcUtility.extIdFromRoot(productResource);
        description = IfcConstructionProductResourceSpareSerializer.descriptionFromConstructionProductResource(productResource);
        setNumber = setNumberFromConstructionProductResource(productResource);
        partNumber = partNumberFromConstructionProductResource(productResource);

        SpareType spare = getCobieSection().addNewSpare();
        spare.setName(name);
        spare.setCreatedBy(createdBy);
        spare.setCreatedOn(createdOn);
        spare.setCategory(category);
        spare.setTypeName(typeName);
        spare.setSuppliers(suppliers);
        spare.setExtSystem(extSystem);
        spare.setExtObject(extObject);
        spare.setExtIdentifier(extIdentifier);
        spare.setDescription(description);
        spare.setSetNumber(setNumber);
        spare.setPartNumber(partNumber);
        spares.add(spare);
        return spares;
	}

}
