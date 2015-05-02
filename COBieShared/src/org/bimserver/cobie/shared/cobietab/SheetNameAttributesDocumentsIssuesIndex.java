package org.bimserver.cobie.shared.cobietab;

import java.util.HashMap;

import org.bimserver.cobie.shared.utility.COBieUtility;
import org.bimserver.cobie.shared.utility.COBieUtility.CobieSheetName;
import org.nibs.cobie.tab.AttributeType;
import org.nibs.cobie.tab.COBIEType;
import org.nibs.cobie.tab.DocumentType;
import org.nibs.cobie.tab.IssueType;

public class SheetNameAttributesDocumentsIssuesIndex extends HashMap<CobieSheetName, AttributesDocumentsIssuesRowNameIndex>
{
    private final COBIEType cobieSheetXMLData;

    private static final long serialVersionUID = -5733220959541885991L;

    public SheetNameAttributesDocumentsIssuesIndex(COBIEType cobieSheetXMLData)
    {
        this.cobieSheetXMLData = cobieSheetXMLData;
        initializeSheetNameIndexes();
        indexDescriptiveElements();
    }

    private boolean canHaveDescriptiveElements(CobieSheetName cobieSheetName)
    {
        return true;
    }

    public COBIEType getCobieSheetXMLData()
    {
        return cobieSheetXMLData;
    }

    public AttributesDocumentsIssues getDescriptiveDataBySheetNameRowName(CobieSheetName sheetName, String rowName)
    {
        return getDescriptiveElementsIndexByCobieSheetName(sheetName).getDescriptiveDataRowsByForeignRowName(rowName);
    }

    public AttributesDocumentsIssuesRowNameIndex getDescriptiveElementsIndexByCobieSheetName(CobieSheetName sheetName)
    {
        return get(sheetName);
    }

    @SuppressWarnings("deprecation")
	private void indexAttributes()
    {
        COBIEType.Attributes attributes = cobieSheetXMLData.getAttributes();
        if(attributes!=null)
        {
            for (AttributeType attribute : attributes.getAttributeArray())
            {
                try
                {

                    CobieSheetName cobieSheetName = COBieUtility.CobieSheetNameEnumFromString(attribute.getSheetName());
                    AttributesDocumentsIssuesRowNameIndex keyedDescriptiveData = get(cobieSheetName);
                    String rowName = attribute.getRowName();
                    AttributesDocumentsIssues descriptiveData = keyedDescriptiveData.get(attribute.getRowName());
                    descriptiveData.getAttributes().add(attribute);
                    keyedDescriptiveData.put(rowName, descriptiveData);

                } catch (NullPointerException ex)
                {
                    ex.printStackTrace();
                    // TODO: handle exception
                } catch (Exception e)
                {
                    e.printStackTrace();
                    // TODO: handle document indexing exception
                }
            }
        }
       
    }

    private void indexDescriptiveElements()
    {
        indexDocuments();
        indexAttributes();
        indexIssues();
    }

    @SuppressWarnings("deprecation")
	private void indexDocuments()
    {
        COBIEType.Documents documents = cobieSheetXMLData.getDocuments();
        if (documents!=null)
        {
           
                for (DocumentType document : documents.getDocumentArray())
                {
                    try
                    {
                    CobieSheetName cobieSheetName = COBieUtility.CobieSheetNameEnumFromString(document.getSheetName());
                    AttributesDocumentsIssuesRowNameIndex keyedDescriptiveData = get(cobieSheetName);
                    String rowName = document.getRowName();
                    AttributesDocumentsIssues descriptiveData = keyedDescriptiveData.get(rowName);
                    descriptiveData.getDocuments().add(document);
                    keyedDescriptiveData.put(rowName, descriptiveData);
                } catch (NullPointerException ex)
                {
                    ex.printStackTrace();
                    // TODO: handle exception
                } catch (Exception e)
                {
                    e.printStackTrace();
                    // TODO: handle document indexing exception
                }
                }
           
        }
        

    }

    @SuppressWarnings("deprecation")
	private void indexIssues()
    {
        COBIEType.Issues issues = cobieSheetXMLData.getIssues();
        if (issues != null)
        {
            for (IssueType issue : issues.getIssueArray())
            {
                try
                {
                    CobieSheetName cobieSheetName = COBieUtility.CobieSheetNameEnumFromString(issue.getSheetName1());
                    AttributesDocumentsIssuesRowNameIndex keyedDescriptiveData = get(cobieSheetName);
                    String rowName = issue.getRowName1();
                    AttributesDocumentsIssues descriptiveData = keyedDescriptiveData.get(rowName);
                    descriptiveData.getIssues().add(issue);
                    keyedDescriptiveData.put(rowName, descriptiveData);

                    CobieSheetName cobieSheetName2 = COBieUtility.CobieSheetNameEnumFromString(issue.getSheetName2());
                    get(cobieSheetName2);
                    String rowName2 = issue.getRowName2();
                    AttributesDocumentsIssues descriptiveData2 = keyedDescriptiveData.get(rowName2);
                    descriptiveData.getIssues().add(issue);
                    keyedDescriptiveData.put(rowName2, descriptiveData2);
                } catch (NullPointerException ex)
                {
                    ex.printStackTrace();
                    // TODO: handle exception
                } catch (Exception e)
                {
                    e.printStackTrace();
                    // TODO: handle document indexing exception
                }

            }
        }

    }

    private void initializeSheetNameIndexes()
    {
        for (CobieSheetName cobieSheetName : CobieSheetName.values())
        {
            if (canHaveDescriptiveElements(cobieSheetName))
            {
                put(cobieSheetName, new AttributesDocumentsIssuesRowNameIndex());
            }
        }
    }
}
