package org.erdc.cobie.cobielite.parsers.sheetxmldata.dispatchers;


import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.DocumentDocument;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.DocumentType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.CobieBaseType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.DocumentCollectionType;
import org.erdc.cobie.cobielite.parsers.TypicalParserDispatcher;
import org.erdc.cobie.cobielite.parsers.sheetxmldata.COBieLiteSheetXMLDataParser;
import org.erdc.cobie.cobielite.parsers.sheetxmldata.DocumentParser;
import org.erdc.cobie.shared.cobiesheetxmldata.indices.IndexedCOBie;

public class DocumentDispatcher extends
        TypicalParserDispatcher<org.erdc.cobie.sheetxmldata.DocumentType, DocumentCollectionType, DocumentType, CobieBaseType>
{
    private DocumentCollectionType documentCollection;

    public DocumentDispatcher(Iterable<org.erdc.cobie.sheetxmldata.DocumentType> childSourceElements, CobieBaseType targetParent,
            IndexedCOBie indexedCOBie, DocumentCollectionType documentCollection)
    {
        super(childSourceElements, targetParent, indexedCOBie);
        this.documentCollection = documentCollection;
    }

    @Override
    protected COBieLiteSheetXMLDataParser<org.erdc.cobie.sheetxmldata.DocumentType, DocumentType> createNewParser(
            org.erdc.cobie.sheetxmldata.DocumentType sourceElement,
            DocumentType newTargetElement)
    {
        return new DocumentParser(sourceElement, newTargetElement, indexedCOBie);
    }

    @Override
    protected DocumentType createNewTargetElement()
    {
        return (DocumentType)targetCollection.addNewDocument().substitute(DocumentDocument.type.getDocumentElementName(), DocumentType.type);
    }

    @Override
    protected DocumentCollectionType getTargetCollection()
    {
        return documentCollection;
    }

}
