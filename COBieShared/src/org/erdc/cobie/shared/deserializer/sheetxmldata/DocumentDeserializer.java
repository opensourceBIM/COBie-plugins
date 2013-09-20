package org.erdc.cobie.shared.deserializer.sheetxmldata;

import java.util.ArrayList;
import java.util.Arrays;

import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.IfcDocumentInformation;
import org.bimserver.models.ifc2x3tc1.IfcDocumentReference;
import org.bimserver.models.ifc2x3tc1.IfcRelAssociatesDocument;
import org.bimserver.models.ifc2x3tc1.IfcRoot;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.shared.COBieUtility.CobieSheetName;
import org.erdc.cobie.shared.deserializer.sheetxmldata.modelhandlers.IfcCommonHandler;
import org.erdc.cobie.sheetxmldata.COBIEType;
import org.erdc.cobie.sheetxmldata.COBIEType.Documents;
import org.erdc.cobie.sheetxmldata.DocumentType;
import org.slf4j.LoggerFactory;

public class DocumentDeserializer extends SimpleDeserializer<COBIEType.Documents, DocumentType, IfcDocumentInformation>
{

    private static final long NULL_OBJECT_OID = -1;
    private static final String IMPACT_DOCUMENT_ERRORMESSAGE = "Impact worksheet not yet supported.";
    private static final String WHITESPACE = " ";
    private static final String DOCUMENT_ASSOCIATION_SEPARATOR = " to ";
    private static final String DOCUMENT_ASSOCIATION_PREFIX = "Associates Document ";

    private BAMieDocuments bamieDocuments;

    { LOGGER = LoggerFactory.getLogger(DocumentDeserializer.class); }

    public DocumentDeserializer(IfcCommonHandler ifcCommonHandler, COBieIfcModel model, Documents cobieSheetXMLDataSection)
    {
        super(ifcCommonHandler, model, cobieSheetXMLDataSection);
        setBamieDocuments(new BAMieDocuments(cobieSheetXMLDataSection, getModel()));
    }

    private void attachDocumentReferenceToDocumentInformation(IfcDocumentInformation documentInformation, DocumentType document)
            throws IfcModelInterfaceException
    {
        IfcDocumentReference docRef = documentReferenceFromDocument(document);
        getModel().add(docRef, getIfcCommonHandler().getOidProvider());
        documentInformation.getDocumentReferences().add(docRef);
    }

    @Override
    protected boolean cobieSheetXMLDataElementIsInModel(DocumentType document)
    {
        return getModel().containsDocument(document);
    }

    @Override
    protected Iterable<DocumentType> cobieSheetXMLDataSectionIterableFromCOBieSheetXMLDataSection(Documents cobieSheetXMLDataSection)
    {
        return new ArrayList<DocumentType>(Arrays.asList(cobieSheetXMLDataSection.getDocumentArray()));
    }

    private IfcDocumentReference documentReferenceFromDocument(DocumentType document)
    {
        IfcDocumentReference docRef = Ifc2x3tc1Factory.eINSTANCE.createIfcDocumentReference();
        docRef.setItemReference(document.getFile());
        docRef.setLocation(document.getDirectory());
        docRef.setName(document.getFile());
        return docRef;
    }

    public BAMieDocuments getBAMieDocuments()
    {
        return bamieDocuments;
    }

    private String getDocumentAssociationName(DocumentType document)
    {
        return DOCUMENT_ASSOCIATION_PREFIX + document.getName() + DOCUMENT_ASSOCIATION_SEPARATOR + document.getSheetName() + WHITESPACE
                + document.getRowName();
    }

    @Override
    protected IfcDocumentInformation initializeIfcFromCOBieSheetXMLData(DocumentType document) throws DeserializerException
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

    private Long objectOidFromDocument(DocumentType document) throws Exception
    {
        Long relatedObjOid = NULL_OBJECT_OID;
        String sheetName = document.getSheetName();
        String rowName = document.getRowName();
        COBieIfcModel model = getModel();
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
                    relatedObjOid = (long)NULL_OBJECT_OID;
                    break;
                }

            }
        } catch (Exception e)
        {
            throw e;
        }
        if (relatedObjOid == NULL_OBJECT_OID)
        {
            throw new Exception("SheetName-RowName entry not found");
        }
        return relatedObjOid;
    }

    private IfcRelAssociatesDocument relAssociatesDocumentFromDocument(DocumentType document) throws Exception
    {
        long associatedObjectOid = objectOidFromDocument(document);
        IdEObject relatedObject = getModel().get(associatedObjectOid);
        IfcRelAssociatesDocument relAssociatesDocument = Ifc2x3tc1Factory.eINSTANCE.createIfcRelAssociatesDocument();
        if (relatedObject instanceof IfcRoot)
        {
            relAssociatesDocument.getRelatedObjects().add((IfcRoot)relatedObject);
        }
        relAssociatesDocument.setGlobalId(getIfcCommonHandler().getGuidHandler().newGuid().getWrappedValue());
        relAssociatesDocument.setOwnerHistory(getIfcCommonHandler().getOwnerHistoryHandler().ownerHistoryFromEmailTimestampAndApplication(
                document.getCreatedBy(), document.getCreatedOn(), document.getExtSystem()));
        String relAssociatesName = getDocumentAssociationName(document);
        relAssociatesDocument.setName(relAssociatesName);
        return relAssociatesDocument;

    }

    private void setBamieDocuments(BAMieDocuments bamieDocuments)
    {
        this.bamieDocuments = bamieDocuments;
    }

    @Override
    protected long writeIfcObject(IfcDocumentInformation ifcObject, DocumentType cobieSheetXMLDataElement) throws IfcModelInterfaceException,
            DeserializerException
    {
        return getModel().addDocument(ifcObject, cobieSheetXMLDataElement, getIfcCommonHandler());
    }

    @Override
    protected void writeRelationships(IfcDocumentInformation documentInformation, DocumentType document) throws DeserializerException
    {
        try
        {
            attachDocumentReferenceToDocumentInformation(documentInformation, document);
            IfcRelAssociatesDocument relAssociatesDocument = relAssociatesDocumentFromDocument(document);
            relAssociatesDocument.setRelatingDocument(documentInformation);
            getModel().add(relAssociatesDocument, getIfcCommonHandler().getOidProvider());
        } catch (Exception e)
        {
            throw new DeserializerException(e);
        }
    }
}
