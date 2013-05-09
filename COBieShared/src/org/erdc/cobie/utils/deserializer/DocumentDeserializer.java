package org.erdc.cobie.utils.deserializer;

import java.util.ArrayList;
import java.util.List;

import org.bimserver.emf.IdEObject;
import org.bimserver.emf.OidProvider;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.IfcDocumentInformation;
import org.bimserver.models.ifc2x3tc1.IfcDocumentReference;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.models.ifc2x3tc1.IfcRelAssociatesDocument;
import org.bimserver.models.ifc2x3tc1.IfcRelDefines;
import org.bimserver.models.ifc2x3tc1.IfcRelDefinesByType;
import org.bimserver.models.ifc2x3tc1.IfcRoot;
import org.bimserver.models.ifc2x3tc1.IfcTypeObject;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.shared.COBieUtility.CobieSheetName;
import org.erdc.cobie.sheetxmldata.COBIEType;
import org.erdc.cobie.sheetxmldata.DocumentType;
import org.erdc.cobie.utils.deserializer.modelhandlers.IfcCommonHandler;
import org.erdc.cobie.utils.deserializer.modelhandlers.IfcGuidHandler;
import org.erdc.cobie.utils.deserializer.modelhandlers.OwnerHistoryHandler;

public class DocumentDeserializer
{
    private static final String IMPACT_DOCUMENT_ERRORMESSAGE = "Impact worksheet not yet supported.";
    private static final String WHITESPACE = " ";
    private static final String DOCUMENT_ASSOCIATION_SEPARATOR = " to ";
    private static final String DOCUMENT_ASSOCIATION_PREFIX = "Associates Document ";
    private COBIEType.Documents documents;
    private COBieIfcModel model;
    private OidProvider CobieOidProvider;
    private OwnerHistoryHandler ownerHistoryProvider;
    private IfcGuidHandler ifcGuidHandler;
    private List<DocumentType> bamieDocuments;

    public DocumentDeserializer(COBieIfcModel cobieIfcModel, IfcCommonHandler ifcCommonHandler, COBIEType.Documents documents)
    {
        this.documents = documents;
        model = cobieIfcModel;
        CobieOidProvider = ifcCommonHandler.getOidProvider();
        ownerHistoryProvider = ifcCommonHandler.getOwnerHistoryHandler();
        ifcGuidHandler = ifcCommonHandler.getGuidHandler();
        bamieDocuments = new ArrayList<DocumentType>();
    }

    private void attachDocumentReferenceToDocumentInformation(IfcDocumentInformation documentInformation, DocumentType document)
    {
        IfcDocumentReference docRef = documentReferenceFromDocument(document);
        model.add(docRef, CobieOidProvider);
        documentInformation.getDocumentReferences().add(docRef);
    }

    public void deserializeDocuments()
    {
        if (documents != null)
        {
            for (DocumentType document : documents.getDocumentArray())
            {
                try
                {
                    if (isDocumentBAMie(document))
                    {
                        handleBAMieDocument(document);
                    } else
                    {
                        documentToDocumentInformation(document);
                    }
                } catch (Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        }
    }

    private IfcDocumentReference documentReferenceFromDocument(DocumentType document)
    {
        IfcDocumentReference docRef = Ifc2x3tc1Factory.eINSTANCE.createIfcDocumentReference();
        docRef.setItemReference(document.getFile());
        docRef.setLocation(document.getDirectory());
        docRef.setName(document.getFile());
        return docRef;
    }

    public void documentToDocumentInformation(DocumentType document) throws Exception
    {
        IfcDocumentInformation documentInformation = initializeDocumentInformationFromCOBieDocument(document);
        attachDocumentReferenceToDocumentInformation(documentInformation, document);
        model.add(documentInformation, CobieOidProvider);
        IfcRelAssociatesDocument relAssociatesDocument = relAssociatesDocumentFromDocument(document);
        relAssociatesDocument.setRelatingDocument(documentInformation);
        model.add(relAssociatesDocument, CobieOidProvider);
    }

    public List<DocumentType> getBAMieDocuments()
    {
        return bamieDocuments;
    }

    private String getDocumentAssociationName(DocumentType document)
    {
        return DOCUMENT_ASSOCIATION_PREFIX + document.getName() + DOCUMENT_ASSOCIATION_SEPARATOR + document.getSheetName() + WHITESPACE
                + document.getRowName();
    }

    private void handleBAMieDocument(DocumentType document)
    {
        bamieDocuments.add(document);
    }

    private IfcDocumentInformation initializeDocumentInformationFromCOBieDocument(DocumentType document) throws Exception
    {
        IfcDocumentInformation documentInformation = Ifc2x3tc1Factory.eINSTANCE.createIfcDocumentInformation();
        documentInformation.setName(document.getName());
        documentInformation.setDescription(document.getDescription());
        documentInformation.setIntendedUse(document.getApprovalBy());
        documentInformation.setScope(document.getStage());
        documentInformation.setPurpose(document.getCategory());
        documentInformation.setDocumentId(document.getName());
        return documentInformation;
    }

    public boolean isDocumentBAMie(DocumentType document)
    {
        boolean isBAMie = false;
        String category = document.getCategory();
        String sheetName = document.getSheetName();
        String rowName = document.getRowName();
        ArrayList<String> bamieCategoryStrings = TypeDeserializer.getBAMieValuesFromCategoryDelimitedList(category);
        if ((bamieCategoryStrings.size() > 0)
                && (sheetName.equalsIgnoreCase(COBieUtility.CobieSheetName.Component.name()) && model.containsComponent(rowName)))
        {
            IfcProduct product = (IfcProduct)model.get(model.getComponentOid(rowName));
            for (IfcRelDefines definesBy : product.getIsDefinedBy())
            {
                if (definesBy instanceof IfcRelDefinesByType)
                {
                    IfcTypeObject relatingType = ((IfcRelDefinesByType)definesBy).getRelatingType();
                    if (TypeDeserializer.isTypeBAMie(relatingType))
                    {
                        isBAMie = true;
                    }
                }
            }
        }
        return isBAMie;
    }

    private Long objectOidFromDocument(DocumentType document) throws Exception
    {
        Long relatedObjOid = (long)-1;
        String sheetName = document.getSheetName();
        String rowName = document.getRowName();

        try
        {
            CobieSheetName enumSheetName = COBieUtility.CobieSheetNameEnumFromString(sheetName);

            switch (enumSheetName)
            {
                case Contact:
                {
                    relatedObjOid = model.getContactOid(rowName);
                    break;
                }

                case Facility:
                {
                    relatedObjOid = model.getFacilityOid(rowName);
                    break;
                }

                case Floor:
                {
                    relatedObjOid = model.getFloorOid(rowName);
                    break;
                }

                case Space:
                {
                    relatedObjOid = model.getSpaceOid(rowName);
                    break;
                }

                case Zone:
                {
                    relatedObjOid = model.getZoneOid(rowName);
                    break;
                }

                case Type:
                {
                    relatedObjOid = model.getTypeOid(rowName);
                    break;
                }

                case Assembly:
                {
                    relatedObjOid = model.getAssemblyOidByName(rowName);
                    break;
                }

                case Component:
                {
                    relatedObjOid = model.getComponentOid(rowName);
                    break;
                }
                case Impact:
                {
                    throw new Exception(IMPACT_DOCUMENT_ERRORMESSAGE);
                }
                case Job:
                {
                    relatedObjOid = model.getFirstMatchingJobNameOid(rowName);
                    break;
                }
                case Resource:
                {
                    relatedObjOid = model.getResourceOid(rowName);
                    break;
                }
                case Spare:
                {
                    relatedObjOid = model.getSpareNameToOid().get(rowName);
                    break;
                }
                case System:
                {
                    relatedObjOid = model.getFirstMatchingSystemOidByName(rowName);
                    break;
                }
                default:
                {
                    relatedObjOid = (long)-1;
                    break;
                }

            }
        } catch (Exception e)
        {
            throw e;
        }
        if (relatedObjOid == -1)
        {
            throw new Exception("SheetName-RowName entry not found");
        }
        return relatedObjOid;
    }

    private IfcRelAssociatesDocument relAssociatesDocumentFromDocument(DocumentType document) throws Exception
    {
        long associatedObjectOid = objectOidFromDocument(document);
        IdEObject relatedObject = model.get(associatedObjectOid);
        IfcRelAssociatesDocument relAssociatesDocument = Ifc2x3tc1Factory.eINSTANCE.createIfcRelAssociatesDocument();
        if (relatedObject instanceof IfcRoot)
        {
            relAssociatesDocument.getRelatedObjects().add((IfcRoot)relatedObject);
        }
        relAssociatesDocument.setGlobalId(ifcGuidHandler.newGuid().getWrappedValue());
        relAssociatesDocument.setOwnerHistory(ownerHistoryProvider.ownerHistoryFromEmailTimestampAndApplication(document.getCreatedBy(),
                document.getCreatedOn(), document.getExtSystem()));
        String relAssociatesName = getDocumentAssociationName(document);
        relAssociatesDocument.setName(relAssociatesName);
        return relAssociatesDocument;

    }
}
