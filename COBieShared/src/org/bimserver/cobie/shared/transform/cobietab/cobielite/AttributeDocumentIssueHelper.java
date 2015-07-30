package org.bimserver.cobie.shared.transform.cobietab.cobielite;


import org.bimserver.cobie.shared.cobietab.AttributesDocumentsIssues;
import org.bimserver.cobie.shared.cobietab.IndexedCOBie;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.AttributeDocument;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.DocumentDocument;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.IssueDocument;
import org.buildingsmartalliance.docs.nbims03.cobie.core.AttributeCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.DocumentCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.IssueCollectionType;
import org.nibs.cobie.tab.AttributeType;
import org.nibs.cobie.tab.DocumentType;
import org.nibs.cobie.tab.IssueType;

public class AttributeDocumentIssueHelper
{
    public static void parseAttributes(
            AttributeCollectionType cobieLiteAttributes,
            AttributesDocumentsIssues descriptiveDataRows,
            IndexedCOBie indexedCOBie) throws Exception
    {
        if (cobieLiteAttributes != null)
        {
            for (AttributeType sheetXMLAttribute : descriptiveDataRows.getAttributes())
            {
                org.buildingsmartalliance.docs.nbims03.cobie.cobielite.AttributeType cobieLiteAttribute = null;
                try
                {
                    cobieLiteAttribute = (org.buildingsmartalliance.docs.nbims03.cobie.cobielite.AttributeType)cobieLiteAttributes.addNewAttribute().substitute(AttributeDocument.type.getDocumentElementName(), org.buildingsmartalliance.docs.nbims03.cobie.cobielite.AttributeType.type);
                } catch (Exception ex)
                {
                    throw ex;
                }
                AttributeTransformer attributeParser = new AttributeTransformer(sheetXMLAttribute, cobieLiteAttribute, indexedCOBie);
                attributeParser.transform();
            }
        }
    }

    public static void parseDocuments(
            DocumentCollectionType cobieLiteDocuments,
            AttributesDocumentsIssues descriptiveDataRows,
            IndexedCOBie indexedCOBie) throws Exception
    {
        if (cobieLiteDocuments != null)
        {
            for (DocumentType sheetXMLDocument : descriptiveDataRows.getDocuments())
            {
                org.buildingsmartalliance.docs.nbims03.cobie.cobielite.DocumentType cobieLiteDocument = null;
                try
                {
                    cobieLiteDocument = (org.buildingsmartalliance.docs.nbims03.cobie.cobielite.DocumentType)cobieLiteDocuments.addNewDocument().substitute(DocumentDocument.type.getDocumentElementName(), org.buildingsmartalliance.docs.nbims03.cobie.cobielite.DocumentType.type);
                } catch (Exception ex)
                {
                    throw ex;
                }
                DocumentTransformer documentParser = new DocumentTransformer(sheetXMLDocument, cobieLiteDocument, indexedCOBie);
                documentParser.transform();
            }
        }
    }

    public static void parseIssues(IssueCollectionType cobieLiteIssues, AttributesDocumentsIssues descriptiveDataRows, IndexedCOBie indexedCOBie)
            throws Exception
    {
        for (IssueType sheetXMLIssue : descriptiveDataRows.getIssues())
        {

            org.buildingsmartalliance.docs.nbims03.cobie.cobielite.IssueType cobieLiteIssue = null;
            try
            {
                cobieLiteIssue = (org.buildingsmartalliance.docs.nbims03.cobie.cobielite.IssueType)cobieLiteIssues.addNewIssue().substitute(IssueDocument.type.getDocumentElementName(), org.buildingsmartalliance.docs.nbims03.cobie.cobielite.IssueType.type);
            } catch (Exception ex)
            {
                throw ex;
            }
            IssueTransformer issueParser = new IssueTransformer(sheetXMLIssue, cobieLiteIssue, indexedCOBie);
            issueParser.transform();
        }

    }
}
