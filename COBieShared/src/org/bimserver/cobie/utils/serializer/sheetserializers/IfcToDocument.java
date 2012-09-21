package org.bimserver.cobie.utils.serializer.sheetserializers;
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

import org.bimserver.cobie.cobielite.COBIEType;
import org.bimserver.cobie.cobielite.DocumentType;
import org.bimserver.cobie.utils.deserializer.TypeDeserializer;
import org.bimserver.cobie.utils.deserializer.modelhandlers.ClassificationHandler;
import org.bimserver.models.ifc2x3tc1.IfcBuilding;
import org.bimserver.models.ifc2x3tc1.IfcBuildingStorey;
import org.bimserver.models.ifc2x3tc1.IfcClassificationReference;
import org.bimserver.models.ifc2x3tc1.IfcDistributionElement;
import org.bimserver.models.ifc2x3tc1.IfcDocumentInformation;
import org.bimserver.models.ifc2x3tc1.IfcDocumentSelect;
import org.bimserver.models.ifc2x3tc1.IfcOwnerHistory;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.models.ifc2x3tc1.IfcRelAggregates;
import org.bimserver.models.ifc2x3tc1.IfcRelAssociates;
import org.bimserver.models.ifc2x3tc1.IfcRelAssociatesClassification;
import org.bimserver.models.ifc2x3tc1.IfcRelAssociatesDocument;
import org.bimserver.models.ifc2x3tc1.IfcRelDecomposes;
import org.bimserver.models.ifc2x3tc1.IfcRelDefinesByType;
import org.bimserver.models.ifc2x3tc1.IfcRoot;
import org.bimserver.models.ifc2x3tc1.IfcSpace;
import org.bimserver.models.ifc2x3tc1.IfcTypeObject;
import org.bimserver.models.ifc2x3tc1.IfcZone;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.shared.cobie.COBieUtility;
import org.bimserver.shared.cobie.COBieUtility.CobieSheetName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class IfcToDocument 
{
	private static final String BAMIE_CATEGORY = "BAMie: Addressing";
	private static final String ApprovalBy = "Information Only";
	private static final String Directory = COBieUtility.COBieNA;
	private static final String DocumentInfoRowName = COBieUtility.COBieNA;
	private static final String DocumentInfoSheetName = COBieUtility.COBieNA;
	private static final String File = COBieUtility.COBieNA;
	private static final Logger LOGGER = LoggerFactory.getLogger(IfcToDocument.class);
	private static final String Reference = COBieUtility.COBieNA;
	private static final CobieSheetName sheetName = CobieSheetName.Document;
	private static final String Stage = "Requirement";
	private static final String TypeNameSuffix = " Product Data";
	private static final String TypeSheetName = "Type";
	
	protected static String approvalByFromDocumentInformation(IfcDocumentInformation documentInformation)
	{
		String approvalBy =
				documentInformation.getIntendedUse();
		if(COBieUtility.isNA(approvalBy))
			approvalBy = IfcToDocument.ApprovalBy;
		return COBieUtility.getCOBieString(approvalBy);
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

	protected static String descriptionFromDocumentInformation(IfcDocumentInformation documentInformation)
	{
		String documentation = documentInformation.getDescription();
		return COBieUtility.getCOBieString(documentation);
	}
	
	protected static String descriptionFromTypeObject(IfcTypeObject type)
	{
		return IfcToType.descriptionFromTypeObject(type);
	}
	
	protected static String directoryFromDocumentInformation(IfcDocumentInformation documentInformation)
	{
		String directoryName = "";
		if(documentInformation!=null && documentInformation.getDocumentReferences()!=null && documentInformation.getDocumentReferences().size()>0)
		{
			directoryName = documentInformation.getDocumentReferences().get(0).getLocation();
		}
		if(COBieUtility.isNA(directoryName))
			directoryName = IfcToDocument.Directory;
		return directoryName;
	}
	
	private static void exportDocumentInformationObjects(
			IfcModelInterface model, LogHandler loggerHandler,
			ArrayList<String> documentNames, COBIEType.Documents documents)
	{
		String name;
		String createdBy;
		Calendar createdOn;
		String category;
		String approvalBy;
		String stage;
		String sheetName;
		String rowName;
		String directory;
		String file;
		String extSystem;
		String extObject;
		String extIdentifier;
		String description;
		String reference;
		IfcOwnerHistory oh;
		DocumentType tempDocument;
		for(IfcRelAssociatesDocument relAssociatesDocument:model.getAll(IfcRelAssociatesDocument.class))
		{
				IfcDocumentSelect docInfoSelect =
						relAssociatesDocument.getRelatingDocument();
				if(docInfoSelect instanceof IfcDocumentInformation)
				{
					IfcDocumentInformation docInfo =
							(IfcDocumentInformation) docInfoSelect;
					try
					{
									
						name = IfcToDocument.nameFromDocumentInformation(docInfo);
						oh = relAssociatesDocument.getOwnerHistory();
						createdBy = COBieUtility.getEmailFromOwnerHistory(oh);
						createdOn =  IfcToContact.getCreatedOn(oh.getCreationDate());
						category = IfcToDocument.categoryFromDocumentInformation(docInfo);
						approvalBy = IfcToDocument.approvalByFromDocumentInformation(docInfo);
						stage = IfcToDocument.stageFromDocumentInformation(docInfo);
						sheetName = IfcToDocument.sheetNameFromRelAssociatesDocument(relAssociatesDocument);
						rowName = IfcToDocument.rowNameFromRelAssociatesDocument(relAssociatesDocument);
						directory = IfcToDocument.directoryFromDocumentInformation(docInfo);
						file = IfcToDocument.fileFromDocumentInformation(docInfo);
						extSystem = COBieUtility.getApplicationName(oh);
						extObject = IfcToDocument.extObjectFromRelAssociatesDocument(relAssociatesDocument);
						extIdentifier = IfcToDocument.extIdFromRelAssociatesDocument(relAssociatesDocument);
						description = IfcToDocument.descriptionFromDocumentInformation(docInfo);
						reference = IfcToDocument.referenceFromDocumentInformation(docInfo);
						
						tempDocument = documents.addNewDocument();
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
						documentNames.add(name);
						loggerHandler.rowWritten();
					}
					catch(Exception ex)
					{
						loggerHandler.error(ex);
					}
				}
				
		}
	}
	
	private static void exportTypeInformation(IfcModelInterface model,
			LogHandler loggerHandler, ArrayList<String> typeNames,
			ArrayList<String> documentNames, COBIEType.Documents documents)
	{
		String name;
		String createdBy;
		Calendar createdOn;
		String category;
		String approvalBy;
		String stage;
		String sheetName;
		String rowName;
		String directory;
		String file;
		String extSystem;
		String extObject;
		String extIdentifier;
		String description;
		String reference;
		IfcOwnerHistory oh;
		DocumentType tempDocument;
		if (documentNames.size()==0)
		{
			for (IfcRelDefinesByType defByType : model.getAll(IfcRelDefinesByType.class))
			{
				try
				{
					IfcTypeObject type = defByType.getRelatingType();
					if (type !=null)
					{
						name = IfcToDocument.nameFromTypeObject(type);
						if (!typeNames.contains(name))
						{
	
							oh = COBieUtility.firstOwnerHistoryFromModel(model);
							createdBy = COBieUtility.getEmailFromOwnerHistory(oh);
							createdOn = IfcToContact.getCreatedOn(oh.getCreationDate());
							category = IfcToDocument.categoryFromTypeObject(type);
							approvalBy = IfcToDocument.ApprovalBy;
							stage = IfcToDocument.Stage;
							sheetName = IfcToDocument.TypeSheetName;
							rowName = IfcToType.nameFromTypeObject(type);
							directory = IfcToDocument.Directory;
							file = IfcToDocument.File;
							extSystem = COBieUtility.getApplicationName(oh);
							extObject = IfcToType.extObjectFromTypeObject(type);
							extIdentifier = type.getGlobalId().getWrappedValue();
							description = IfcToDocument.descriptionFromTypeObject(type);
							reference = IfcToDocument.Reference;
							
							tempDocument = documents.addNewDocument();				
							typeNames.add(name);
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
				}
				catch(Exception ex)
				{
					loggerHandler.error(ex);
				}

			}
		}
	}
	
	private static void exportBAMieClassificationReferences(IfcModelInterface model,
			LogHandler loggerHandler,
			ArrayList<String> documentNames, COBIEType.Documents documents)
	{
		String name;
		String createdBy;
		Calendar createdOn;
		String category;
		String approvalBy;
		String stage;
		String sheetName;
		String rowName;
		String directory;
		String file;
		String extSystem;
		String extObject;
		String extIdentifier;
		String description;
		String reference;
		IfcOwnerHistory oh;
		DocumentType tempDocument;
		for(IfcDistributionElement element:model.getAllWithSubTypes(IfcDistributionElement.class))
		{
			try
			{
				for(IfcRelAssociates relAssociates:element.getHasAssociations())
				{
					if(relAssociates instanceof IfcRelAssociatesClassification)
					{
						category = COBieUtility.getObjectClassificationCategoryString(element);
						if(ClassificationHandler.isBAMieRelAssociatesClassification((IfcRelAssociatesClassification)relAssociates))
						{
							name = COBieUtility.getCOBieString(element.getName());
							oh = element.getOwnerHistory();
							createdBy = COBieUtility.getEmailFromOwnerHistory(oh);
							createdOn = IfcToContact.getCreatedOn(oh.getCreationDate());
							category = IfcToDocument.BAMIE_CATEGORY;
							approvalBy = IfcToDocument.ApprovalBy;
							stage = IfcToDocument.Stage;
							sheetName =COBieUtility.CobieSheetName.Component.name();
							rowName = IfcToDocument.bamieRowNameFromDistributionElement(element);
							extSystem = COBieUtility.getApplicationName(oh);
							extObject = IfcToComponent.extObjectFromProduct(element);
							extIdentifier = element.getGlobalId().getWrappedValue();
							description = COBieUtility.getCOBieString(element.getName());
							reference = IfcToDocument.Reference;
								
							IfcClassificationReference classificationReference =
									COBieUtility.getObjectClassificationReference(element);
							directory = COBieUtility.getCOBieString(classificationReference.getLocation());
							
							tempDocument = documents.addNewDocument();
							tempDocument.setName(name);
							tempDocument.setCreatedBy(createdBy);
							tempDocument.setCreatedOn(createdOn);
							tempDocument.setCategory(category);
							tempDocument.setApprovalBy(approvalBy);
							tempDocument.setStage(stage);
							tempDocument.setSheetName(sheetName);
							tempDocument.setRowName(rowName);
							tempDocument.setDirectory(directory);
							tempDocument.setFile(COBieUtility.COBieNA);
							tempDocument.setExtSystem(extSystem);
							tempDocument.setExtObject(extObject);
							tempDocument.setExtIdentifier(extIdentifier);
							tempDocument.setDescription(description);
							tempDocument.setReference(reference);
							loggerHandler.rowWritten();
						}
					}
				}
			}
			catch(Exception ex)
			{
				
			}
			
		}
	}
	
	protected static String bamieRowNameFromDistributionElement(IfcDistributionElement distributionElement)
	{
		String rowName = "";
		for(IfcRelDecomposes decomposeRelation:distributionElement.getIsDecomposedBy())
		{
			if(decomposeRelation instanceof IfcRelAggregates && COBieUtility.isNA(rowName))
			{
				IfcRelAggregates aggregates = (IfcRelAggregates) decomposeRelation;
				rowName = aggregates.getRelatingObject().getName();
			}
		}
		return COBieUtility.getCOBieString(rowName);
	}
	
	protected static String extIdFromRelAssociatesDocument(IfcRelAssociatesDocument relAssociatesDocument)
	{
		String extId = "";
		if(relAssociatesDocument.getRelatedObjects()!=null && relAssociatesDocument.getRelatedObjects().size()>0)
			extId = 
					relAssociatesDocument.getRelatedObjects().get(0).getGlobalId().getWrappedValue();
		return COBieUtility.getCOBieString(extId);
	}
	
	protected static String extObjectFromRelAssociatesDocument(IfcRelAssociatesDocument relAssociatesDocument)
	{
		String extObject = "";
		if(relAssociatesDocument.getRelatedObjects()!=null && relAssociatesDocument.getRelatedObjects().size()>0)
			extObject = 
					relAssociatesDocument.getRelatedObjects().get(0).getClass().getSimpleName();
		extObject = COBieUtility.trimImplFromClassNameString(extObject);
		return COBieUtility.getCOBieString(extObject);
	}
	
	protected static String fileFromDocumentInformation(IfcDocumentInformation documentInformation)
	{
		String fileName = "";
		if(documentInformation!=null && documentInformation.getDocumentReferences()!=null && documentInformation.getDocumentReferences().size()>0)
		{
			fileName = documentInformation.getDocumentReferences().get(0).getItemReference();
		}
		if(COBieUtility.isNA(fileName))
			fileName = IfcToDocument.File;
		return fileName;
	}
	

	private static ArrayList<String> getExistingTypes(COBIEType.Documents documents)
	{
		ArrayList<String> existingTypes =
				new ArrayList<String>();
		for(DocumentType document:documents.getDocumentArray())
		{
			if(document.getSheetName().equalsIgnoreCase(COBieUtility.CobieSheetName.Type.name())&&
					!COBieUtility.isNA(document.getName()))
			{
				existingTypes.add(document.getName());
			}
		}
		return existingTypes;
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
	
	protected static String referenceFromDocumentInformation(IfcDocumentInformation documentInformation)
	{
		String referenceString =
				"";
		if(!COBieUtility.isNA(documentInformation.getDescription()))
			referenceString = documentInformation.getDescription();
		else
			referenceString = documentInformation.getName();
		return COBieUtility.getCOBieString(referenceString);
	}
	
	
	protected static String rowNameFromRelAssociatesDocument(IfcRelAssociatesDocument relAssociatesDocument)
	{
		String rowName = "";
		if(relAssociatesDocument.getRelatedObjects()!=null && relAssociatesDocument.getRelatedObjects().size()>0)
			rowName = relAssociatesDocument.getRelatedObjects().get(0).getName();
		return COBieUtility.getCOBieString(rowName);
	}
	
	protected static String rowNameFromTypeObject(IfcTypeObject type)
	{
		return IfcToDocument.nameFromTypeObject(type);
	}
	
	protected static String sheetNameFromRelAssociatesDocument(IfcRelAssociatesDocument relAssociatesDocument)
	{
		String sheetName = "";
		if(relAssociatesDocument.getRelatedObjects()!=null && relAssociatesDocument.getRelatedObjects().size()>0)
			sheetName = sheetNameFromRoot(relAssociatesDocument.getRelatedObjects().get(0));
		return COBieUtility.getCOBieString(sheetName);
	}
	
	protected static String sheetNameFromRoot(IfcRoot root)
	{
		String worksheetName = "";
		
		if (root instanceof IfcBuilding)
			worksheetName = IfcToAttribute.facilitySheetName;
		else if (root instanceof IfcBuildingStorey)
			worksheetName = IfcToAttribute.floorSheetName;
		else if (root instanceof IfcSpace)
			worksheetName = IfcToAttribute.spaceSheetName;
		else if (root instanceof IfcZone)
			worksheetName = COBieUtility.CobieSheetName.Zone.name();
		else if (root instanceof IfcTypeObject)
			worksheetName = COBieUtility.CobieSheetName.Type.name();
		else if (root instanceof IfcProduct)
			worksheetName = IfcToAttribute.componentSheetName;
		return worksheetName;
	}
	
	protected static String stageFromDocumentInformation(IfcDocumentInformation documentInformation)
	{
		String stage =
				documentInformation.getScope();
		if(COBieUtility.isNA(stage))
			stage = IfcToDocument.Stage;
		return COBieUtility.getCOBieString(stage);
	}
	
	public static void writeDocument(COBIEType cType, IfcModelInterface model)
	{
		LogHandler loggerHandler = new LogHandler(sheetName,LOGGER);
		loggerHandler.sheetWriteBegin();
		ArrayList<String> typeNames = new ArrayList<String>();
		ArrayList<String> documentNames = new ArrayList<String>();
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
		exportDocumentInformationObjects(model, loggerHandler, documentNames,
				documents);
		typeNames = getExistingTypes(documents);
		exportTypeInformation(model, loggerHandler, typeNames, documentNames,
				documents);
		exportBAMieClassificationReferences(model, loggerHandler, documentNames, documents);
		loggerHandler.sheetWritten();
	}
	
}
