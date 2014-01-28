package org.erdc.cobie.sqlite.service.document;

import java.sql.Connection;

import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.DocumentType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.DocumentCollectionType;
import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.entity.Document;
import org.erdc.cobie.sqlite.entity.relationship.Relationship;
import org.erdc.cobie.sqlite.service.CobieCollectionService;
import org.erdc.cobie.sqlite.service.DatabaseKey;

public abstract class DocumentService<TRelationship extends Relationship> extends 
	CobieCollectionService<DocumentCollectionType, DocumentType, Document, TRelationship> 
{	
	protected DocumentService(Connection connection,
								Class<TRelationship> relationshipClass)	throws CobieSQLiteException 
	{
		super(connection, Document.class, relationshipClass);
	}
	
	@Override
	protected void insertEntity(DocumentType documentType, Document document, DatabaseKey parentKey) throws CobieSQLiteException
    {			
		getExecutor().insertValidEntity(document, Document.ColumnName.DocumentCategory.toString(), documentType.getDocumentCategory());
		getExecutor().insertValidEntity(document, Document.ColumnName.DocumentDescription.toString(), documentType.getDocumentDescription());
		getExecutor().insertValidEntity(document, Document.ColumnName.DocumentName.toString(), documentType.getDocumentName());
		getExecutor().insertValidEntity(document, Document.ColumnName.DocumentReferenceURI.toString(), documentType.getDocumentReferenceURI());
		getExecutor().insertValidEntity(document, Document.ColumnName.DocumentURI.toString(), documentType.getDocumentURI());
		
		super.insertEntity(documentType, document, parentKey);	
    }
}