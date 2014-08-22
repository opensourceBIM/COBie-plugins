package org.erdc.cobie.shared.cobietab.transformation.cobielite;

import org.buildingsmartalliance.docs.nbims03.cobie.core.AttributeCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.IssueCollectionType;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.shared.cobietab.IndexedCOBie;
import org.erdc.cobie.sheetxmldata.DocumentType;

public class DocumentTransformer extends COBieBaseTypeTransformer<DocumentType, org.buildingsmartalliance.docs.nbims03.cobie.cobielite.DocumentType>
{

    private static final String PATHSEPARATOR = "/";

    public DocumentTransformer(DocumentType cobieSheetXMLData, org.buildingsmartalliance.docs.nbims03.cobie.cobielite.DocumentType cobieLiteRowData, IndexedCOBie indexedCOBie)
    {
        super(cobieSheetXMLData, cobieLiteRowData, indexedCOBie);
    }

    private String deriveDocumentURI()
    {
        String documentURI = "";
        String directory = source.getDirectory();
        String fileName = source.getFile();
        if(!COBieUtility.isNA(directory) && !COBieUtility.isNA(fileName))
        {
            documentURI =  buildURIFromDirectoryFileName(directory, fileName);
        }
        else if(COBieUtility.isNA(directory) && !COBieUtility.isNA(fileName))
            documentURI = fileName;
        else if (!COBieUtility.isNA(directory) && COBieUtility.isNA(fileName))
            documentURI = directory;
        return documentURI;
    }

    private String buildURIFromDirectoryFileName(String directory, String fileName)
    {
        return directory + PATHSEPARATOR + fileName;
    }

    @Override
    protected void parseAttributes() throws Exception
    {
    	AttributeCollectionType attributes = target.addNewDocumentAttributes();
        AttributeDocumentIssueHelper.parseAttributes(attributes, descriptiveData, indexedCOBie);
        if(attributes == null || attributes.isNil() || attributes.sizeOfAttributeArray() == 0)
        {
        	target.getDomNode().removeChild(attributes.getDomNode());
        }
    }

    @Override
    protected void parseComplexElements()
    {
        // nothing to do...base class handles issues and attributes
    }

    @Override
    protected void parseDocuments() throws NonExistingDescriptiveElementException
    {
        //throw new NonExistingDescriptiveElementException();
    }

    @Override
    protected void parseIssues() throws Exception
    {
    	IssueCollectionType issues = target.addNewDocumentIssues();
        AttributeDocumentIssueHelper.parseIssues(issues, descriptiveData, indexedCOBie);
        if(issues == null || issues.isNil() || issues.sizeOfIssueArray() == 0)
        {
        	target.getDomNode().removeChild(issues.getDomNode());
        }
    }

    @Override
    protected void parseSimpleElements()
    {
    	if(!COBieUtility.isNA(source.getCategory()))
    		target.setDocumentCategory(source.getCategory());
    	if(!COBieUtility.isNA(source.getDescription()))
    		target.setDocumentDescription(source.getDescription());
    	if(!COBieUtility.isNA(source.getName()))
    		target.setDocumentName(source.getName());
    	if(!COBieUtility.isNA(source.getReference()))
    		target.setDocumentReferenceURI(source.getReference());
    	if(!COBieUtility.isNA(deriveDocumentURI()))
    		target.setDocumentURI(deriveDocumentURI());
    	if(!COBieUtility.isNA(source.getExtObject()))
    		target.setExternalEntityName(source.getExtObject());
    	if(!COBieUtility.isNA(source.getExtIdentifier()))
    		target.setExternalID(source.getExtIdentifier());
    	if(!COBieUtility.isNA(source.getExtIdentifier()))
    		target.setExternalSystemName(source.getExtSystem());
    }
}
