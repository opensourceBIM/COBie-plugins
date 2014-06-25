package org.erdc.cobie.cobielite.parsers.sheetxmldata;

import org.buildingsmartalliance.docs.nbims03.cobie.core.AttributeCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.IssueCollectionType;
import org.erdc.cobie.cobielite.parsers.sheetxmldata.dispatchers.AttributeDocumentIssueHelper;
import org.erdc.cobie.cobielite.parsers.sheetxmldata.exceptions.NonExistingDescriptiveElementException;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.shared.cobiesheetxmldata.indices.IndexedCOBie;
import org.erdc.cobie.sheetxmldata.DocumentType;

public class DocumentParser extends COBieLiteCOBIEBaseTypeParser<DocumentType, org.buildingsmartalliance.docs.nbims03.cobie.cobielite.DocumentType>
{

    private static final String PATHSEPARATOR = "/";

    public DocumentParser(DocumentType cobieSheetXMLData, org.buildingsmartalliance.docs.nbims03.cobie.cobielite.DocumentType cobieLiteRowData, IndexedCOBie indexedCOBie)
    {
        super(cobieSheetXMLData, cobieLiteRowData, indexedCOBie);
    }

    private String deriveDocumentURI()
    {
        String documentURI = "";
        String directory = sourceCOBie.getDirectory();
        String fileName = sourceCOBie.getFile();
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
    	AttributeCollectionType attributes = targetCOBie.addNewDocumentAttributes();
        AttributeDocumentIssueHelper.parseAttributes(attributes, descriptiveData, indexedCOBie);
        if(attributes == null || attributes.isNil() || attributes.sizeOfAttributeArray() == 0)
        {
        	targetCOBie.getDomNode().removeChild(attributes.getDomNode());
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
    	IssueCollectionType issues = targetCOBie.addNewDocumentIssues();
        AttributeDocumentIssueHelper.parseIssues(issues, descriptiveData, indexedCOBie);
        if(issues == null || issues.isNil() || issues.sizeOfIssueArray() == 0)
        {
        	targetCOBie.getDomNode().removeChild(issues.getDomNode());
        }
    }

    @Override
    protected void parseSimpleElements()
    {
    	if(!COBieUtility.isNA(sourceCOBie.getCategory()))
    		targetCOBie.setDocumentCategory(sourceCOBie.getCategory());
    	if(!COBieUtility.isNA(sourceCOBie.getDescription()))
    		targetCOBie.setDocumentDescription(sourceCOBie.getDescription());
    	if(!COBieUtility.isNA(sourceCOBie.getName()))
    		targetCOBie.setDocumentName(sourceCOBie.getName());
    	if(!COBieUtility.isNA(sourceCOBie.getReference()))
    		targetCOBie.setDocumentReferenceURI(sourceCOBie.getReference());
    	if(!COBieUtility.isNA(deriveDocumentURI()))
    		targetCOBie.setDocumentURI(deriveDocumentURI());
    	if(!COBieUtility.isNA(sourceCOBie.getExtObject()))
    		targetCOBie.setExternalEntityName(sourceCOBie.getExtObject());
    	if(!COBieUtility.isNA(sourceCOBie.getExtIdentifier()))
    		targetCOBie.setExternalID(sourceCOBie.getExtIdentifier());
    	if(!COBieUtility.isNA(sourceCOBie.getExtIdentifier()))
    		targetCOBie.setExternalSystemName(sourceCOBie.getExtSystem());
    }
}
