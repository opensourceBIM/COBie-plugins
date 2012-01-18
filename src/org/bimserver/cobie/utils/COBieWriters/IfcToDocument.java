package org.bimserver.cobie.utils.COBieWriters;
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
import java.util.Calendar;

import org.bimserver.cobie.utils.COBieUtility;
import org.bimserver.cobie.utils.COBieUtility.CobieSheetName;
import org.bimserver.models.ifc2x3.IfcDocumentInformation;
import org.bimserver.models.ifc2x3.IfcOwnerHistory;
import org.bimserver.models.ifc2x3.IfcRelDefinesByType;
import org.bimserver.models.ifc2x3.IfcTypeObject;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cobieLite.COBIEType;
import cobieLite.DocumentType;

public class IfcToDocument 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(IfcToDocument.class);
	private static final CobieSheetName sheetName = CobieSheetName.Document;
	private static final String TypeNameSuffix = " Product Data";
	private static final String ApprovalBy = "Information Only";
	private static final String Stage = "Requirement";
	private static final String TypeSheetName = "Type";
	private static final String DocumentInfoSheetName = COBieUtility.COBieNA;
	private static final String DocumentInfoRowName = COBieUtility.COBieNA;
	private static final String Directory = COBieUtility.COBieNA;
	private static final String File = COBieUtility.COBieNA;
	private static final String Reference = COBieUtility.COBieNA;
	
	public static void writeDocument(COBIEType cType, IfcModelInterface model)
	{
		LogHandler loggerHandler = new LogHandler(sheetName,LOGGER);
		loggerHandler.sheetWriteBegin();
		String name = "";
		String createdBy = "";
		Calendar createdOn;
		String category = "";
		String approvalBy = "";
		String stage = "";
		String sheetName = "";
		String rowName = "";
		String directory = "";
		String file = "";
		String extSystem = "";
		String extObject = "";
		String extIdentifier = "";
		String description = "";
		String reference = "";
		IfcOwnerHistory oh;
		ArrayList<String> typeNames = new ArrayList<String>();
		ArrayList<String> documentNames = new ArrayList<String>();
		DocumentType tempDocument;
		COBIEType.Documents documents;
		
		try
		{
			documents = cType.getDocuments();
			if (documents==null || documents.isNil())
				documents = cType.addNewDocuments();
		}
		catch(Exception ex)
		{
			documents = cType.addNewDocuments();
		}
		
		for(IfcDocumentInformation docInfo : model.getAll(IfcDocumentInformation.class))
		{
			try
			{
				tempDocument = documents.addNewDocument();			
				name = IfcToDocument.nameFromDocumentInformation(docInfo);
				documentNames.add(name);
				oh = COBieUtility.firstOwnerHistoryFromModel(model);
				createdBy = COBieUtility.getEmailFromOwnerHistory(oh);
				createdOn =  IfcToContact.getCreatedOn(oh.getCreationDate());
				category = IfcToDocument.categoryFromDocumentInformation(docInfo);
				approvalBy = IfcToDocument.ApprovalBy;
				stage = IfcToDocument.Stage;
				sheetName = IfcToDocument.DocumentInfoSheetName;
				rowName = IfcToDocument.DocumentInfoRowName;
				directory = IfcToDocument.Directory;
				file = IfcToDocument.File;
				extSystem = COBieUtility.getApplicationName(oh);
				extObject = IfcDocumentInformation.class.getSimpleName();
				extIdentifier = docInfo.getName();
				description = IfcToDocument.descriptionFromDocumentInformation(docInfo);
				reference = IfcToDocument.Reference;
				
				tempDocument.setName(name);
				tempDocument.setCreatedBy(createdBy);
				tempDocument.setCreatedOn(createdOn);
				tempDocument.setCategory(category);
				tempDocument.setApprovalBy(approvalBy);
				tempDocument.setStage(stage);
				tempDocument.setSheetName(sheetName);
				tempDocument.setRowName(rowName);
				tempDocument.setDirectory(directory);
				tempDocument.setFile(file);
				tempDocument.setExtSystem(extSystem);
				tempDocument.setExtIdentifier(extIdentifier);
				tempDocument.setExtObject(extObject);
				tempDocument.setDescription(description);
				tempDocument.setReference(reference);
				loggerHandler.sheetWritten();
			}
			catch(Exception ex)
			{
				loggerHandler.error(ex);
			}
			
		}
		
		if (documentNames.size()==0)
		{
			for (IfcRelDefinesByType defByType : model.getAll(IfcRelDefinesByType.class))
			{
				try
				{
					IfcTypeObject type = defByType.getRelatingType();
					name = IfcToDocument.nameFromTypeObject(type);
					if (IfcToType.isAsset(type) && !typeNames.contains(name))
					{
						tempDocument = documents.addNewDocument();				
						typeNames.add(name);
						oh = COBieUtility.firstOwnerHistoryFromModel(model);
						createdBy = COBieUtility.getEmailFromOwnerHistory(oh);
						createdOn = IfcToContact.getCreatedOn(oh.getCreationDate());
						category = IfcToDocument.categoryFromTypeObject(type);
						approvalBy = IfcToDocument.ApprovalBy;
						stage = IfcToDocument.Stage;
						sheetName = IfcToDocument.TypeSheetName;
						rowName = IfcToDocument.rowNameFromTypeObject(type);
						directory = IfcToDocument.Directory;
						file = IfcToDocument.File;
						extSystem = COBieUtility.getApplicationName(oh);
						extObject = IfcToType.extObjectFromTypeObject(type);
						extIdentifier = type.getGlobalId().getWrappedValue();
						description = IfcToDocument.descriptionFromTypeObject(type);
						reference = IfcToDocument.Reference;
						
						tempDocument.setName(name);
						tempDocument.setCreatedBy(createdBy);
						tempDocument.setCreatedOn(createdOn);
						tempDocument.setCategory(category);
						tempDocument.setApprovalBy(approvalBy);
						tempDocument.setStage(stage);
						tempDocument.setSheetName(sheetName);
						tempDocument.setRowName(rowName);
						tempDocument.setDirectory(directory);
						tempDocument.setFile(file);
						tempDocument.setExtSystem(extSystem);
						tempDocument.setExtObject(extObject);
						tempDocument.setExtIdentifier(extIdentifier);
						tempDocument.setDescription(description);
						tempDocument.setReference(reference);
						loggerHandler.rowWritten();
					}
				}
				catch(Exception ex)
				{
					loggerHandler.error(ex);
				}

			}
		}
		loggerHandler.sheetWritten();
	}
	
	protected static String nameFromDocumentInformation(IfcDocumentInformation documentInformation)
	{
		String name = documentInformation.getName();
		return COBieUtility.getCOBieString(name);
	}
	
	protected static String nameFromTypeObject(IfcTypeObject type)
	{
		String name =
		 IfcToType.nameFromTypeObject(type) + TypeNameSuffix;
		return name;
	}
	
	protected static String categoryFromDocumentInformation(IfcDocumentInformation documentInformation)
	{
		String category = "";
		category = documentInformation.getPurpose();
		return COBieUtility.getCOBieString(category);
	}
	
	protected static String categoryFromTypeObject(IfcTypeObject type)
	{
		String category = TypeNameSuffix.trim();
		return category;
	}
	
	protected static String rowNameFromTypeObject(IfcTypeObject type)
	{
		return IfcToDocument.nameFromTypeObject(type);
	}
	
	protected static String descriptionFromDocumentInformation(IfcDocumentInformation documentInformation)
	{
		String documentation = documentInformation.getDescription();
		return COBieUtility.getCOBieString(documentation);
	}
	
	protected static String descriptionFromTypeObject(IfcTypeObject type)
	{
		return IfcToType.descriptionFromTypeObject(type);
	}
	
}
