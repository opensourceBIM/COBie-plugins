package org.bimserver.cobie.utils.cobiewriters;
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
import java.util.Calendar;

import org.bimserver.cobie.cobielite.COBIEType;
import org.bimserver.cobie.cobielite.SpareType;
import org.bimserver.cobie.utils.COBieUtility;
import org.bimserver.cobie.utils.COBieUtility.CobieSheetName;
import org.bimserver.models.ifc2x3.IfcConstructionProductResource;
import org.bimserver.models.ifc2x3.IfcOwnerHistory;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class IfcToSpare 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(IfcToSpare.class);
	private static final CobieSheetName sheetName = CobieSheetName.Spare;
	private static final String spareCategory = "SpareSet";
	public static void writeSpares(COBIEType cType, IfcModelInterface model)
	{
		LogHandler loggerHandler = new LogHandler(sheetName,LOGGER);
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
				spares = cType.addNewSpares();
		}
		catch(Exception ex)
		{
			spares = cType.addNewSpares();
		}
		
		for(IfcConstructionProductResource productResource : model.getAll(IfcConstructionProductResource.class))
		{
			try
			{
				SpareType spare = spares.addNewSpare();
				
				oh = productResource.getOwnerHistory();
				name = IfcToSpare.nameFromConstructionProductResource(productResource);
				createdBy = COBieUtility.getEmailFromOwnerHistory(oh);
				createdOn = IfcToContact.getCreatedOn(oh.getCreationDate());
				category = IfcToSpare.categoryFromConstructionProductResource(productResource);
				typeName = IfcToSpare.typeNameFromConstructionProductResource(productResource);
				suppliers = IfcToSpare.suppliersFromConstructionProductResource(productResource);
				extSystem = COBieUtility.getApplicationName(oh);
				extObject = COBieUtility.extObjectFromObjectDef(productResource);
				extIdentifier = productResource.getGlobalId().getWrappedValue();
				description = IfcToSpare.descriptionFromConstructionProductResource(productResource);
				setNumber = IfcToSpare.setNumberFromConstructionProductResource(productResource);
				partNumber = IfcToSpare.partNumberFromConstructionProductResource(productResource);
				
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
			}
			catch(Exception ex)
			{
				loggerHandler.error(ex);
			}
			
		}
		loggerHandler.sheetWritten();
	}
	
	private static String nameFromConstructionProductResource(IfcConstructionProductResource resource)
	{
		String name = resource.getName();
		return COBieUtility.getCOBieString(name);
	}
	
	private static String categoryFromConstructionProductResource(IfcConstructionProductResource resource)
	{
		return COBieUtility.getCOBieString(spareCategory);
	}
	
	private static String typeNameFromConstructionProductResource(IfcConstructionProductResource resource)
	{
		String typeName = "";
		//for(IfcRelAssignsToResource resAssign : resource.getResourceOf())
		//{
		//	IfcResource relResource = resAssign.getRelatingResource();
		//	relResource.get
		//}
		
		
		return COBieUtility.getCOBieString(typeName);
	}
	
	private static String suppliersFromConstructionProductResource(IfcConstructionProductResource productResource)
	{
		String suppliers = "";
		return COBieUtility.getCOBieString(suppliers);
	}
	
	private static String descriptionFromConstructionProductResource(IfcConstructionProductResource productResource)
	{
		String description = productResource.getDescription();
		if (description==null || description.isEmpty())
			description = productResource.getName();
		return COBieUtility.getCOBieString(description);
	}
	
	private static String setNumberFromConstructionProductResource(IfcConstructionProductResource productResource)
	{
		return COBieUtility.COBieNA;
	}
	
	private static String partNumberFromConstructionProductResource(IfcConstructionProductResource productResource)
	{
		return COBieUtility.COBieNA;
	}
	
}
