package org.bimserver.cobie.utils.deserializer;

import java.util.ArrayList;
import java.util.List;

import org.bimserver.cobie.cobielite.AttributeType;
import org.bimserver.cobie.cobielite.COBIEType;
import org.bimserver.cobie.cobielite.ContactType;
import org.bimserver.cobie.cobielite.DocumentType;
import org.bimserver.cobie.utils.deserializer.modelhandlers.IfcCommonHandler;
import org.bimserver.cobie.utils.deserializer.modelhandlers.IfcGuidHandler;
import org.bimserver.cobie.utils.deserializer.modelhandlers.OwnerHistoryHandler;
import org.bimserver.emf.IdEObject;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.IfcDocumentInformation;
import org.bimserver.models.ifc2x3tc1.IfcDocumentReference;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.models.ifc2x3tc1.IfcRelAssociatesDocument;
import org.bimserver.models.ifc2x3tc1.IfcRelDefines;
import org.bimserver.models.ifc2x3tc1.IfcRelDefinesByType;
import org.bimserver.models.ifc2x3tc1.IfcRoot;
import org.bimserver.models.ifc2x3tc1.IfcTypeObject;
import org.bimserver.plugins.serializers.OidProvider;
import org.bimserver.shared.cobie.COBieUtility;
import org.bimserver.shared.cobie.COBieUtility.CobieSheetName;

public class DocumentDeserializer
{
	private String DEFAULT_BAMIE_DOCUMENT_EXTOBJECT="IfcClassificationReference";
	private String BAMIE_CATEGORY_PREFIX="BAMie:";
	private COBIEType.Documents documents;
	private COBieIfcModel model;
	private OidProvider CobieOidProvider;
	private OwnerHistoryHandler ownerHistoryProvider;
	private IfcGuidHandler ifcGuidHandler;
	private List<DocumentType> bamieDocuments;
	public DocumentDeserializer(COBieIfcModel cobieIfcModel, 
			IfcCommonHandler ifcCommonHandler,COBIEType.Documents documents)
	{
		this.documents = documents;
		this.model = cobieIfcModel;
		this.CobieOidProvider = ifcCommonHandler.getOidProvider();
		this.ownerHistoryProvider = ifcCommonHandler.getOwnerHistoryHandler();
		this.ifcGuidHandler = ifcCommonHandler.getGuidHandler();
		bamieDocuments = new ArrayList<DocumentType>();
	}
	
	public List<DocumentType> getBAMieDocuments()
	{
		return bamieDocuments;
	}
	public boolean isDocumentBAMie(DocumentType document)
	{
		boolean isBAMie = false;
		String category = document.getCategory();
		String sheetName = document.getSheetName();
		String rowName = document.getRowName();
		ArrayList<String> bamieCategoryStrings =
				TypeDeserializer.getBAMieValuesFromCategoryDelimitedList(category);
		if(bamieCategoryStrings.size()>0 &&
				(sheetName.equalsIgnoreCase(COBieUtility.CobieSheetName.Component.name()) &&
						model.containsComponent(rowName)))
		{
			IfcProduct product = (IfcProduct) model.get(model.getComponentOid(rowName));
			for(IfcRelDefines definesBy: product.getIsDefinedBy())
			{
				if(definesBy instanceof IfcRelDefinesByType)
				{
					IfcTypeObject relatingType =
							((IfcRelDefinesByType)definesBy).getRelatingType();
					if(TypeDeserializer.isTypeBAMie(relatingType))
						isBAMie=true;
				}
			}
		}
		return isBAMie;
	}
	public void deserializeDocuments()
	{
		if(documents!=null)
		{
			for(DocumentType document:documents.getDocumentArray())
			{
				try
				{
					if(isDocumentBAMie(document))
						handleBAMieDocument(document);
					else
						documentToDocumentInformation(document);
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
		}
	}

	private void handleBAMieDocument(DocumentType document)
	{
		bamieDocuments.add(document);
	}
	
	public void documentToDocumentInformation(DocumentType document) throws Exception
	{
		IfcDocumentInformation documentInformation = 
				initializeDocumentInformationFromCOBieDocument(document);
		attachDocumentReferenceToDocumentInformation(documentInformation,document);
		model.add(documentInformation,this.CobieOidProvider);
		IfcRelAssociatesDocument relAssociatesDocument =
				relAssociatesDocumentFromDocument(document);
		relAssociatesDocument.setRelatingDocument(documentInformation);
		model.add(relAssociatesDocument,CobieOidProvider);
	}
	
	private IfcRelAssociatesDocument relAssociatesDocumentFromDocument(DocumentType document) throws Exception
	{
		long associatedObjectOid =
				objectOidFromDocument(document);
		IdEObject relatedObject = model.get(associatedObjectOid);
		IfcRelAssociatesDocument relAssociatesDocument =
				Ifc2x3tc1Factory.eINSTANCE.createIfcRelAssociatesDocument();
		if(relatedObject instanceof IfcRoot)
			relAssociatesDocument.getRelatedObjects().add((IfcRoot)relatedObject);
		relAssociatesDocument.setGlobalId(ifcGuidHandler.newGuid());
		relAssociatesDocument.setOwnerHistory(ownerHistoryProvider.ownerHistoryFromEmailTimestampAndApplication(document.getCreatedBy(),document.getCreatedOn(), document.getExtSystem()));
		String relAssociatesName =
				"Associates Document "+document.getName()+" to "+document.getSheetName()+" "+document.getRowName();
		relAssociatesDocument.setName(relAssociatesName);
		return relAssociatesDocument;
		
	}

	private IfcDocumentInformation initializeDocumentInformationFromCOBieDocument(
			DocumentType document) throws Exception
	{
		IfcDocumentInformation documentInformation =
				Ifc2x3tc1Factory.eINSTANCE.createIfcDocumentInformation();
		documentInformation.setName(document.getName());
		documentInformation.setDescription(document.getDescription());
		documentInformation.setIntendedUse(document.getApprovalBy());
		documentInformation.setScope(document.getStage());	
		documentInformation.setPurpose(document.getCategory());
		documentInformation.setDocumentId(document.getName());
		return documentInformation;
	}
	
	private void attachDocumentReferenceToDocumentInformation(IfcDocumentInformation documentInformation,DocumentType document)
	{
		IfcDocumentReference docRef =
				documentReferenceFromDocument(document);
		model.add(docRef, CobieOidProvider);
		documentInformation.getDocumentReferences().add(docRef);
	}
	
	private IfcDocumentReference documentReferenceFromDocument(DocumentType document)
	{
		IfcDocumentReference docRef =
				Ifc2x3tc1Factory.eINSTANCE.createIfcDocumentReference();
		docRef.setItemReference(document.getFile());
		docRef.setLocation(document.getDirectory());
		docRef.setName(document.getName());
		return docRef;
	}
	
	private Long objectOidFromDocument(DocumentType document)
			throws Exception
	{
		Long relatedObjOid = (long) -1;
		String sheetName = document.getSheetName();
		String rowName = document.getRowName();

		try
		{
			CobieSheetName enumSheetName = COBieUtility
					.CobieSheetNameEnumFromString(sheetName);

			switch (enumSheetName)
			{
				case Contact:
				{
					relatedObjOid = this.model.getContactOid(rowName);
					break;
				}

				case Facility:
				{
					relatedObjOid = this.model.getFacilityOid(rowName);
					break;
				}

				case Floor:
				{
					relatedObjOid = this.model.getFloorOid(rowName);
					break;
				}

				case Space:
				{
					relatedObjOid = this.model.getSpaceOid(rowName);
					break;
				}

				case Zone:
				{
					relatedObjOid = this.model.getZoneOid(rowName);
					break;
				}

				case Type:
				{
					relatedObjOid = model.getTypeOid(rowName);
					break;
				}

				case Assembly:
				{
					break;
				}

				case Component:
				{
					relatedObjOid = model.getComponentOid(rowName);
					break;
				}

				default:
				{
					relatedObjOid = (long) -1;
					break;
				}

			}
		} catch (Exception e)
		{
			throw e;
		}
		if (relatedObjOid == -1)
			throw new Exception("SheetName-RowName entry not found");
		return relatedObjOid;
	}
}
