package org.erdc.cobie.cobielite.parsers.sheetxmldata.dispatchers;

import org.erdc.cobie.cobielite.AttributeCollectionType;
import org.erdc.cobie.cobielite.DocumentCollectionType;
import org.erdc.cobie.cobielite.IssueCollectionType;
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
                org.erdc.cobie.cobielite.AttributeType cobieLiteAttribute = null;
                try
                {
                    cobieLiteAttribute = cobieLiteAttributes.addNewAttribute();
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
                org.erdc.cobie.cobielite.DocumentType cobieLiteDocument = null;
                try
                {
                    cobieLiteDocument = cobieLiteDocuments.addNewDocument();
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

            org.erdc.cobie.cobielite.IssueType cobieLiteIssue = null;
            try
            {
                cobieLiteIssue = cobieLiteIssues.addNewIssue();
            } catch (Exception ex)
            {
                throw ex;
            }
            IssueParser issueParser = new IssueParser(sheetXMLIssue, cobieLiteIssue, indexedCOBie);
            issueParser.parse();
        }

    }
}
