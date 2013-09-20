package org.erdc.cobie.utils.serializer.sheetserializers;

/******************************************************************************
 * Copyright (C) 2011  ERDC
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.ifc2x3tc1.IfcConstructionProductResource;
import org.bimserver.models.ifc2x3tc1.IfcOwnerHistory;
import org.bimserver.models.ifc2x3tc1.IfcRelAssignsToResource;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.shared.COBieUtility.CobieSheetName;
import org.erdc.cobie.sheetxmldata.COBIEType;
import org.erdc.cobie.sheetxmldata.SpareType;
import org.erdc.cobie.utils.stringwriters.IfcRelationshipsToCOBie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IfcToSpare
{
    private static final Logger LOGGER = LoggerFactory.getLogger(IfcToSpare.class);
    private static final CobieSheetName sheetName = CobieSheetName.Spare;
    private static final ArrayList<String> SETNUMBER_SEARCH_STRINGS = new ArrayList<String>(Arrays.asList("SetNumber"));
    private static final ArrayList<String> SUPPLIERS_SEARCH_STRINGS = new ArrayList<String>(Arrays.asList("Suppliers"));
    private static final ArrayList<String> PARTNUMBER_SEARCH_STRINGS = new ArrayList<String>(Arrays.asList("PartNumber"));

    private static String categoryFromConstructionProductResource(IfcConstructionProductResource resource)
    {
        return COBieUtility.getObjectClassificationCategoryString(resource);
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

    public static ArrayList<String> getPartNumberPropertyNames()
    {
        return PARTNUMBER_SEARCH_STRINGS;
    }

    public static ArrayList<String> getSetNumberPropertyNames()
    {
        return SETNUMBER_SEARCH_STRINGS;
    }

    public static ArrayList<String> getSuppliersPropertyNames()
    {
        return SUPPLIERS_SEARCH_STRINGS;
    }

    private static String nameFromConstructionProductResource(IfcConstructionProductResource resource)
    {
        String name = resource.getName();
        return COBieUtility.getCOBieString(name);
    }

    private static String partNumberFromConstructionProductResource(IfcConstructionProductResource productResource)
    {
        String partNumber = productResource.getResourceIdentifier();
        if (COBieUtility.isNA(partNumber))
        {
            partNumber = IfcRelationshipsToCOBie.getHighestRankingPropertyStringFromRelDefinesList(productResource.getIsDefinedBy(),
                    getPartNumberPropertyNames(), false);
        }
        return COBieUtility.getCOBieString(partNumber);
    }

    private static String setNumberFromConstructionProductResource(IfcConstructionProductResource productResource)
    {
        ArrayList<String> setNumberPropertyNames = getSetNumberPropertyNames();
        String setNumber = productResource.getResourceGroup();
        if (COBieUtility.isNA(setNumber))
        {
            setNumber = IfcRelationshipsToCOBie.getHighestRankingPropertyStringFromRelDefinesList(productResource.getIsDefinedBy(),
                    setNumberPropertyNames, false);
        }
        return COBieUtility.getCOBieString(setNumber);
    }

    private static String suppliersFromConstructionProductResource(IfcConstructionProductResource productResource)
    {
        String suppliers;
        ArrayList<String> suppliersPropertyNames = getSuppliersPropertyNames();
        suppliers = IfcRelationshipsToCOBie.getHighestRankingPropertyStringFromRelDefinesList(productResource.getIsDefinedBy(),
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

    public static void writeSpares(COBIEType cType, IfcModelInterface model)
    {
        LogHandler loggerHandler = new LogHandler(sheetName, LOGGER);
        loggerHandler.sheetWriteBegin();
        IfcOwnerHistory oh;
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
        COBIEType.Spares spares;
        try
        {
            spares = cType.getSpares();
            if (spares == null)
            {
                spares = cType.addNewSpares();
            }
        } catch (Exception ex)
        {
            spares = cType.addNewSpares();
        }

        for (IfcConstructionProductResource productResource : model.getAll(IfcConstructionProductResource.class))
        {
            try
            {
                oh = productResource.getOwnerHistory();
                name = IfcToSpare.nameFromConstructionProductResource(productResource);
                createdBy = COBieUtility.getEmailFromOwnerHistory(oh);
                createdOn = IfcToContact.getCreatedOn(oh.getCreationDate());
                category = IfcToSpare.categoryFromConstructionProductResource(productResource);
                typeName = IfcToSpare.typeNameFromConstructionProductResource(productResource);
                suppliers = IfcToSpare.suppliersFromConstructionProductResource(productResource);
                extSystem = COBieUtility.getApplicationName(oh);
                extObject = COBieUtility.extObjectFromObjectDef(productResource);
                extIdentifier = COBieUtility.extIdFromRoot(productResource);
                description = IfcToSpare.descriptionFromConstructionProductResource(productResource);
                setNumber = IfcToSpare.setNumberFromConstructionProductResource(productResource);
                partNumber = IfcToSpare.partNumberFromConstructionProductResource(productResource);

                SpareType spare = spares.addNewSpare();
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
                loggerHandler.rowWritten();
            } catch (Exception ex)
            {
                loggerHandler.error(ex);
            }

        }
        loggerHandler.sheetWritten();
    }

}
