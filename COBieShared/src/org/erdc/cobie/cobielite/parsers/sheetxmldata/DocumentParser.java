package org.erdc.cobie.cobielite.parsers.sheetxmldata;

import java.io.File;

import org.erdc.cobie.cobielite.parsers.sheetxmldata.dispatchers.AttributeDocumentIssueHelper;
import org.erdc.cobie.cobielite.parsers.sheetxmldata.exceptions.NonExistingDescriptiveElementException;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.shared.cobiesheetxmldata.indices.IndexedCOBie;
import org.erdc.cobie.sheetxmldata.DocumentType;

public class DocumentParser extends COBieLiteCOBIEBaseTypeParser<DocumentType, org.erdc.cobie.cobielite.DocumentType>
{

    private static final String PATHSEPARATOR = "/";

    public DocumentParser(DocumentType cobieSheetXMLData, org.erdc.cobie.cobielite.DocumentType cobieLiteRowData, IndexedCOBie indexedCOBie)
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
        AttributeDocumentIssueHelper.parseAttributes(targetCOBie.addNewAttributes(), descriptiveData, indexedCOBie);
    }

    @Override
    protected void parseComplexElements()
    {
        // nothing to do...base class handles issues and attributes
    }

    @Override
    protected void parseDocuments() throws NonExistingDescriptiveElementException
    {
        throw new NonExistingDescriptiveElementException();
    }

    @Override
    protected void parseIssues() throws Exception
    {
        AttributeDocumentIssueHelper.parseIssues(targetCOBie.addNewIssues(), descriptiveData, indexedCOBie);

    }

    @Override
    protected void parseSimpleElements()
    {
        targetCOBie.setDocumentCategory(sourceCOBie.getCategory());
        targetCOBie.setDocumentDescription(sourceCOBie.getDescription());
        targetCOBie.setDocumentName(sourceCOBie.getName());
        targetCOBie.setDocumentReferenceURI(sourceCOBie.getReference());
        targetCOBie.setDocumentURI(deriveDocumentURI());
        targetCOBie.setExternalEntityName(sourceCOBie.getExtObject());
        targetCOBie.setExternalID(sourceCOBie.getExtIdentifier());
        targetCOBie.setExternalSystemName(sourceCOBie.getExtSystem());

    }
}
