package org.erdc.cobie.shared.sqlite.serializers.document;

import java.sql.Connection;

import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.entities.relationships.AssetDocument;

public class AssetDocumentSerializer extends DocumentSerializer<AssetDocument> 
{
	public AssetDocumentSerializer(Connection connection, 
										Class<AssetDocument> relationshipClass) throws CobieSQLiteException 
	{
		super(connection, relationshipClass);
	}

	protected void insertRelationship(AssetDocument assetDocument, int assetID) throws CobieSQLiteException
	{
		getExecutor().insertValidKey(assetDocument, AssetDocument.ColumnName.RefAsset.toString(), assetID);
		getExecutor().insertValidKey(assetDocument, AssetDocument.ColumnName.RefDocument.toString(), getKey().get());
	}
}