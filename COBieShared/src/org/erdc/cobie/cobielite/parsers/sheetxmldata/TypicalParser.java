package org.erdc.cobie.cobielite.parsers.sheetxmldata;


import org.buildingsmartalliance.docs.nbims03.cobie.core.AttributeCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.CobieBaseType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.DocumentCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.IssueCollectionType;
import org.erdc.cobie.cobielite.parsers.sheetxmldata.dispatchers.AttributeDocumentIssueHelper;
import org.erdc.cobie.shared.cobiesheetxmldata.indices.IndexedCOBie;
import org.erdc.cobie.sheetxmldata.COBIEBaseType;

public abstract class TypicalParser<COBIE_SHEET_XML_DATA_TYPE extends COBIEBaseType, COBIE_LITE_DATA_TYPE extends CobieBaseType>
        extends COBieLiteCOBIEBaseTypeParser<COBIE_SHEET_XML_DATA_TYPE, COBIE_LITE_DATA_TYPE>
{

    public TypicalParser(COBIE_SHEET_XML_DATA_TYPE cobieSheetXMLData, COBIE_LITE_DATA_TYPE cobieLiteRowData, IndexedCOBie indexedCOBie)
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
        	targetCOBie.getDomNode().removeChild(attributes.getDomNode());
        }
        	
    }

    @Override
    protected final void parseDocuments() throws Exception
    {
    	DocumentCollectionType documents = getNewDocuments();
        AttributeDocumentIssueHelper.parseDocuments(documents, descriptiveData, indexedCOBie);
        if(documents == null || documents.isNil() || documents.sizeOfDocumentArray() == 0)
        {
        	targetCOBie.getDomNode().removeChild(documents.getDomNode());
        }

    }

    @Override
    protected final void parseIssues() throws Exception
    {
    	IssueCollectionType issues = getNewIssues();
        AttributeDocumentIssueHelper.parseIssues(issues, descriptiveData, indexedCOBie);
        if(issues == null || issues.isNil() || issues.sizeOfIssueArray() == 0)
        {
        	targetCOBie.getDomNode().removeChild(issues.getDomNode());
        }
    }

}
