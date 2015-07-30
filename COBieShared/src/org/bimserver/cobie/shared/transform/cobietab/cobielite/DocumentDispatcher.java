package org.bimserver.cobie.shared.transform.cobietab.cobielite;


import org.bimserver.cobie.shared.cobietab.IndexedCOBie;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.DocumentDocument;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.DocumentType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.CobieBaseType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.DocumentCollectionType;

public class DocumentDispatcher extends
        TypicalParserDispatcher<org.nibs.cobie.tab.DocumentType, DocumentCollectionType, DocumentType, CobieBaseType>
{
    private DocumentCollectionType documentCollection;

    public DocumentDispatcher(Iterable<org.nibs.cobie.tab.DocumentType> childSourceElements, CobieBaseType targetParent,
            IndexedCOBie indexedCOBie, DocumentCollectionType documentCollection)
    {
        super(childSourceElements, targetParent, indexedCOBie);
        this.documentCollection = documentCollection;
    }

    @Override
    protected COBieTabTransformer<org.nibs.cobie.tab.DocumentType, DocumentType> createNewParser(
            org.nibs.cobie.tab.DocumentType sourceElement,
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
