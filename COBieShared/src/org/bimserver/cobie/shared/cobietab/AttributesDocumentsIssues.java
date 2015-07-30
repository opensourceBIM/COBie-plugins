package org.bimserver.cobie.shared.cobietab;

import java.util.ArrayList;
import java.util.List;

import org.nibs.cobie.tab.AttributeType;
import org.nibs.cobie.tab.DocumentType;
import org.nibs.cobie.tab.IssueType;

public class AttributesDocumentsIssues
{
    private List<DocumentType> documents;
    private List<AttributeType> attributes;
    private List<IssueType> issues;

    public AttributesDocumentsIssues()
    {
        setDocuments(new ArrayList<DocumentType>());
        setAttributes(new ArrayList<AttributeType>());
        setIssues(new ArrayList<IssueType>());
    }

    public List<AttributeType> getAttributes()
    {
        return attributes;
    }

    public List<DocumentType> getDocuments()
    {
        return documents;
    }

    public List<IssueType> getIssues()
    {
        return issues;
    }

    public void setAttributes(List<AttributeType> attributes)
    {
        this.attributes = attributes;
    }

    public void setDocuments(List<DocumentType> documents)
    {
        this.documents = documents;
    }

    public void setIssues(List<IssueType> issues)
    {
        this.issues = issues;
    }
}
