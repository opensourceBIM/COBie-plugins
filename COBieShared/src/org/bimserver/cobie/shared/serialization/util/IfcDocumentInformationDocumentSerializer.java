package org.bimserver.cobie.shared.serialization.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.bimserver.cobie.shared.serialization.IfcCobieSerializer;
import org.bimserver.cobie.shared.utility.COBieIfcUtility;
import org.bimserver.cobie.shared.utility.COBieUtility;
import org.bimserver.cobie.shared.utility.COBieUtility.CobieSheetName;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.ifc2x3tc1.IfcBuilding;
import org.bimserver.models.ifc2x3tc1.IfcBuildingStorey;
import org.bimserver.models.ifc2x3tc1.IfcConstructionEquipmentResource;
import org.bimserver.models.ifc2x3tc1.IfcConstructionProductResource;
import org.bimserver.models.ifc2x3tc1.IfcDocumentInformation;
import org.bimserver.models.ifc2x3tc1.IfcDocumentReference;
import org.bimserver.models.ifc2x3tc1.IfcDocumentSelect;
import org.bimserver.models.ifc2x3tc1.IfcOwnerHistory;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.models.ifc2x3tc1.IfcRelAssociates;
import org.bimserver.models.ifc2x3tc1.IfcRelAssociatesDocument;
import org.bimserver.models.ifc2x3tc1.IfcRelNests;
import org.bimserver.models.ifc2x3tc1.IfcRoot;
import org.bimserver.models.ifc2x3tc1.IfcSpace;
import org.bimserver.models.ifc2x3tc1.IfcSystem;
import org.bimserver.models.ifc2x3tc1.IfcTask;
import org.bimserver.models.ifc2x3tc1.IfcTypeObject;
import org.bimserver.models.ifc2x3tc1.IfcZone;
import org.nibs.cobie.tab.COBIEType;
import org.nibs.cobie.tab.COBIEType.Documents;
import org.nibs.cobie.tab.DocumentType;

import com.prairiesky.transform.cobieifc.settings.SettingsType;

public class IfcDocumentInformationDocumentSerializer extends
		IfcCobieSerializer<DocumentType, COBIEType.Documents, IfcDocumentInformation> 
{
	private static final String TypeNameSuffix = " Product Data";
	private static final String Stage = "Requirement";
	private static final String ApprovalBy = "Information Only";
	private List<String> documentNames = new ArrayList<>();
	public IfcDocumentInformationDocumentSerializer(Documents cobieSection,
			IfcModelInterface model, SettingsType settings) 
	{
		super(cobieSection, model, settings);
	}

	@Override
	protected List<IfcDocumentInformation> getTopLevelModelObjects() 
	{
		List<IfcDocumentInformation> documents =
				new ArrayList<>();
		 for (IfcRelAssociatesDocument relAssociatesDocument : model.getAll(IfcRelAssociatesDocument.class))
	        {
	            IfcDocumentSelect docInfoSelect = relAssociatesDocument.getRelatingDocument();
	            if (docInfoSelect instanceof IfcDocumentInformation)
	            {
	                IfcDocumentInformation docInfo = (IfcDocumentInformation)docInfoSelect;
	                documents.add(docInfo);
	            }
	        }
		return documents;
	}

	@Override
	protected List<DocumentType> serializeModelObject(
			IfcDocumentInformation modelObject) 
	{
		List<DocumentType> documents = new ArrayList<>();
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
        
        for (IfcRelAssociatesDocument relAssociatesDocument : model.getAll(IfcRelAssociatesDocument.class))
        {
            IfcDocumentSelect docInfoSelect = relAssociatesDocument.getRelatingDocument();
            if (docInfoSelect instanceof IfcDocumentInformation)
            {
                IfcDocumentInformation docInfo = (IfcDocumentInformation)docInfoSelect;
                try
                {

                    name = IfcDocumentInformationDocumentSerializer.nameFromDocumentInformation(docInfo);
                    oh = relAssociatesDocument.getOwnerHistory();
                    createdBy = COBieIfcUtility.getEmailFromOwnerHistory(oh);
                    createdOn = IfcToContact.getCreatedOn(oh.getCreationDate());
                    category = IfcDocumentInformationDocumentSerializer.categoryFromDocumentInformation(docInfo);
                    approvalBy = IfcDocumentInformationDocumentSerializer.approvalByFromDocumentInformation(docInfo);
                    stage = IfcDocumentInformationDocumentSerializer.stageFromDocumentInformation(docInfo);
                    sheetName = IfcDocumentInformationDocumentSerializer.sheetNameFromRelAssociatesDocument(relAssociatesDocument);
                    rowName = IfcDocumentInformationDocumentSerializer.rowNameFromRelAssociatesDocument(relAssociatesDocument);
                    directory = IfcDocumentInformationDocumentSerializer.directoryFromDocumentInformation(docInfo);
                    file = IfcDocumentInformationDocumentSerializer.fileFromDocumentInformation(docInfo);
                    extSystem = COBieIfcUtility.getApplicationName(oh);
                    extObject = IfcDocumentInformationDocumentSerializer.extObjectFromRelAssociatesDocument(relAssociatesDocument);
                    extIdentifier = IfcDocumentInformationDocumentSerializer.extIdFromRelAssociatesDocument(relAssociatesDocument);
                    description = IfcDocumentInformationDocumentSerializer.descriptionFromDocumentInformation(docInfo);
                    reference = IfcDocumentInformationDocumentSerializer.referenceFromDocumentInformation(docInfo);

                    tempDocument = getCobieSection().addNewDocument();
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
                    documents.add(tempDocument);
                } 
                catch (Exception ex)
                {
                }
            }
        }
		return documents;
	}

    protected static String nameFromDocumentInformation(IfcDocumentInformation documentInformation)
    {
        String name = documentInformation.getName();
        return COBieUtility.getCOBieString(name);
    }
    
    protected static String categoryFromDocumentInformation(IfcDocumentInformation documentInformation)
    {
        String category = "";
        category = documentInformation.getPurpose();
        return COBieUtility.getCOBieString(category);
    }
    
    protected static String approvalByFromDocumentInformation(IfcDocumentInformation documentInformation)
    {
        String approvalBy = documentInformation.getIntendedUse();
        if (COBieUtility.isNA(approvalBy))
        {
            approvalBy = IfcDocumentInformationDocumentSerializer.ApprovalBy;
        }
        return COBieUtility.getCOBieString(approvalBy);
    }
    
    protected static String stageFromDocumentInformation(IfcDocumentInformation documentInformation)
    {
        String stage = documentInformation.getScope();
        if (COBieUtility.isNA(stage))
        {
            stage = IfcDocumentInformationDocumentSerializer.Stage;
        }
        return COBieUtility.getCOBieString(stage);
    }
    
    protected static String sheetNameFromRelAssociatesDocument(IfcRelAssociatesDocument relAssociatesDocument)
    {
        String sheetName = "";
        if ((relAssociatesDocument.getRelatedObjects() != null) && (relAssociatesDocument.getRelatedObjects().size() > 0))
        {
            sheetName = sheetNameFromRoot(relAssociatesDocument.getRelatedObjects().get(0));
        }
        return COBieUtility.getCOBieString(sheetName);
    }
    
    protected static String sheetNameFromRoot(IfcRoot root)
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
        } else if (root instanceof IfcZone)
        {
            worksheetName = CobieSheetName.Zone.toString();
        } else if (root instanceof IfcTypeObject)
        {
            worksheetName = CobieSheetName.Type.toString();
        } else if (root instanceof IfcProduct)
        {
            worksheetName = CobieSheetName.Component.toString();
        } else if (root instanceof IfcTask)
        {
            worksheetName = CobieSheetName.Job.toString();
        } else if (root instanceof IfcSystem)
        {
            worksheetName = CobieSheetName.System.toString();
        } else if ((root instanceof IfcRelNests) || (root instanceof IfcRelAssociates))
        {
            worksheetName = CobieSheetName.Assembly.toString();
        } else if (root instanceof IfcConstructionProductResource)
        {
            worksheetName = CobieSheetName.Spare.toString();
        } else if (root instanceof IfcConstructionEquipmentResource)
        {
            worksheetName = CobieSheetName.Resource.toString();
        }
        return worksheetName;
    }

    protected static String rowNameFromRelAssociatesDocument(IfcRelAssociatesDocument relAssociatesDocument)
    {
        String rowName = "";
        if ((relAssociatesDocument.getRelatedObjects() != null) && (relAssociatesDocument.getRelatedObjects().size() > 0))
        {
            rowName = relAssociatesDocument.getRelatedObjects().get(0).getName();
        }
        return COBieUtility.getCOBieString(rowName);
    }
    
    protected static String directoryFromDocumentInformation(IfcDocumentInformation documentInformation)
    {
        String directoryName = "";
        if ((documentInformation != null) && (documentInformation.getDocumentReferences() != null)
                && (documentInformation.getDocumentReferences().size() > 0))
        {
            directoryName = documentInformation.getDocumentReferences().get(0).getLocation();
        }
        if (COBieUtility.isNA(directoryName))
        {
            directoryName = COBieUtility.COBieNA;
        }
        return directoryName;
    }
    
    protected static String fileFromDocumentInformation(IfcDocumentInformation documentInformation)
    {
        String fileName = "";
        try
        {
            if ((documentInformation != null) && (documentInformation.getDocumentReferences() != null)
                    && (documentInformation.getDocumentReferences().size() > 0))
            {
                IfcDocumentReference firstReference = documentInformation.getDocumentReferences().get(0);
                String itemReference = "";
                String name = "";
                if (firstReference.isSetItemReference())
                {
                    itemReference = firstReference.getItemReference();
                }
                if (firstReference.isSetName())
                {
                    name = firstReference.getName();
                }
                if (!COBieUtility.isNA(name) && !documentInformation.getName().equals(name))
                {
                    fileName = name;
                } else if (!COBieUtility.isNA(itemReference))
                {
                    fileName = itemReference;
                }
                fileName = documentInformation.getDocumentReferences().get(0).getItemReference();

            }
            if (COBieUtility.isNA(fileName))
            {
                fileName = COBieUtility.COBieNA;
            }
        } catch (Exception ex)
        {

        }

        return fileName;
    }
    
    protected static String extObjectFromRelAssociatesDocument(IfcRelAssociatesDocument relAssociatesDocument)
    {
        String extObject = "";
        if ((relAssociatesDocument.getRelatedObjects() != null) && (relAssociatesDocument.getRelatedObjects().size() > 0))
        {
            extObject = relAssociatesDocument.getRelatedObjects().get(0).getClass().getSimpleName();
        }
        extObject = COBieUtility.trimImplFromClassNameString(extObject);
        return COBieUtility.getCOBieString(extObject);
    }
    
    protected static String extIdFromRelAssociatesDocument(IfcRelAssociatesDocument relAssociatesDocument)
    {
        String extId = "";
        if ((relAssociatesDocument.getRelatedObjects() != null) && (relAssociatesDocument.getRelatedObjects().size() > 0))
        {
            extId = COBieIfcUtility.extIdFromRoot(relAssociatesDocument.getRelatedObjects().get(0));
        }
        return COBieUtility.getCOBieString(extId);
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
    
    protected static String referenceFromDocumentInformation(IfcDocumentInformation documentInformation)
    {
        String referenceString = "";
        if (!COBieUtility.isNA(documentInformation.getDescription()))
        {
            referenceString = documentInformation.getDescription();
        } else
        {
            referenceString = documentInformation.getName();
        }
        return COBieUtility.getCOBieString(referenceString);
    }
	
}
