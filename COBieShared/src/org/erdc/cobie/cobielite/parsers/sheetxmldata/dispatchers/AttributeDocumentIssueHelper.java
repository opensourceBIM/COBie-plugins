package org.erdc.cobie.cobielite.parsers.sheetxmldata.dispatchers;


import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.AttributeDocument;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.DocumentDocument;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.IssueDocument;
import org.buildingsmartalliance.docs.nbims03.cobie.core.AttributeCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.DocumentCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.IssueCollectionType;
import org.erdc.cobie.cobielite.parsers.sheetxmldata.AttributeParser;
import org.erdc.cobie.cobielite.parsers.sheetxmldata.DocumentParser;
import org.erdc.cobie.cobielite.parsers.sheetxmldata.IssueParser;
import org.erdc.cobie.shared.cobiesheetxmldata.indices.AttributesDocumentsIssues;
import org.erdc.cobie.shared.cobiesheetxmldata.indices.IndexedCOBie;
import org.erdc.cobie.sheetxmldata.AttributeType;
import org.erdc.cobie.sheetxmldata.DocumentType;
import org.erdc.cobie.sheetxmldata.IssueType;

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
                AttributeParser attributeParser = new AttributeParser(sheetXMLAttribute, cobieLiteAttribute, indexedCOBie);
                attributeParser.parse();
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
                DocumentParser documentParser = new DocumentParser(sheetXMLDocument, cobieLiteDocument, indexedCOBie);
                documentParser.parse();
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
            IssueParser issueParser = new IssueParser(sheetXMLIssue, cobieLiteIssue, indexedCOBie);
            issueParser.parse();
        }

    }
}
