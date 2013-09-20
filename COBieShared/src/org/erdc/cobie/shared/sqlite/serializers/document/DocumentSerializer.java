package org.erdc.cobie.shared.sqlite.serializers.document;

import java.sql.Connection;

import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.DocumentType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.DocumentCollectionType;
import org.erdc.cobie.shared.sqlite.serializers.CobieCollectionSerializer;
import org.erdc.cobie.shared.sqlite.serializers.IntegerKey;
import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.entities.Document;
import org.erdc.cobie.sqlite.entities.relationships.Relationship;

public abstract class DocumentSerializer<TRelationship extends Relationship> extends 
	CobieCollectionSerializer<DocumentCollectionType, DocumentType, Document, TRelationship> 
{
	private static IntegerKey key = new IntegerKey();
	
	protected DocumentSerializer(Connection connection,
									Class<TRelationship> relationshipClass)	throws CobieSQLiteException 
	{
		super(connection, Document.class, relationshipClass);
	}

	@Override
	protected final IntegerKey getKey()
	{
		return key;
	}
	
	protected void insertEntity(DocumentType documentType, Document document, int parentID) throws CobieSQLiteException
    {		
		super.insertEntity(documentType, document, parentID);	
					
		getExecutor().insertValidEntity(document, Document.ColumnName.DocumentCategory.toString(), documentType.getDocumentCategory());
		getExecutor().insertValidEntity(document, Document.ColumnName.DocumentDescription.toString(), documentType.getDocumentDescription());
		getExecutor().insertValidEntity(document, Document.ColumnName.DocumentName.toString(), documentType.getDocumentName());
		getExecutor().insertValidEntity(document, Document.ColumnName.DocumentReferenceURI.toString(), documentType.getDocumentReferenceURI());
		getExecutor().insertValidEntity(document, Document.ColumnName.DocumentURI.toString(), documentType.getDocumentURI());		
    }
}