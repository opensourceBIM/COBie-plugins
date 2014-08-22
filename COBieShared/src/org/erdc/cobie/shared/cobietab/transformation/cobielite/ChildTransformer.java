package org.erdc.cobie.shared.cobietab.transformation.cobielite;


import org.buildingsmartalliance.docs.nbims03.cobie.core.AttributeCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.CobieBaseType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.DocumentCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.IssueCollectionType;
import org.erdc.cobie.shared.cobietab.IndexedCOBie;
import org.erdc.cobie.sheetxmldata.COBIEBaseType;

public abstract class ChildTransformer<TSource extends COBIEBaseType, TTarget extends CobieBaseType>
        extends COBieBaseTypeTransformer<TSource, TTarget>
{

    public ChildTransformer(TSource cobieSheetXMLData, TTarget cobieLiteRowData, IndexedCOBie indexedCOBie)
    {
        super(cobieSheetXMLData, cobieLiteRowData, indexedCOBie);
        // TODO Auto-generated constructor stub
    }

    public abstract AttributeCollectionType getNewAttributes();

    public abstract DocumentCollectionType getNewDocuments();

    public abstract IssueCollectionType getNewIssues();

    @Override
    protected final void parseAttributes() throws Exception
    {
    	AttributeCollectionType attributes = getNewAttributes();
        AttributeDocumentIssueHelper.parseAttributes(attributes, descriptiveData, indexedCOBie);
        if(attributes == null || attributes.isNil() || attributes.sizeOfAttributeArray() == 0)
        {
        	target.getDomNode().removeChild(attributes.getDomNode());
        }
        	
    }

    @Override
    protected final void parseDocuments() throws Exception
    {
    	DocumentCollectionType documents = getNewDocuments();
        AttributeDocumentIssueHelper.parseDocuments(documents, descriptiveData, indexedCOBie);
        if(documents == null || documents.isNil() || documents.sizeOfDocumentArray() == 0)
        {
        	target.getDomNode().removeChild(documents.getDomNode());
        }

    }

    @Override
    protected final void parseIssues() throws Exception
    {
    	IssueCollectionType issues = getNewIssues();
        AttributeDocumentIssueHelper.parseIssues(issues, descriptiveData, indexedCOBie);
        if(issues == null || issues.isNil() || issues.sizeOfIssueArray() == 0)
        {
        	target.getDomNode().removeChild(issues.getDomNode());
        }
    }

}
