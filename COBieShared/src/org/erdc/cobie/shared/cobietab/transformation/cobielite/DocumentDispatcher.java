package org.erdc.cobie.shared.cobietab.transformation.cobielite;


import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.DocumentDocument;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.DocumentType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.CobieBaseType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.DocumentCollectionType;
import org.erdc.cobie.shared.cobietab.IndexedCOBie;

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
    protected COBieTabTransformer<org.erdc.cobie.sheetxmldata.DocumentType, DocumentType> createNewParser(
            org.erdc.cobie.sheetxmldata.DocumentType sourceElement,
            DocumentType newTargetElement)
    {
        return new DocumentTransformer(sourceElement, newTargetElement, indexedCOBie);
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
