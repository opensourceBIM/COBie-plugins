package org.erdc.cobie.sqlite.service.document;

import java.sql.Connection;

import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.entity.relationship.AssetDocument;
import org.erdc.cobie.sqlite.service.DatabaseKey;

public class AssetDocumentService extends DocumentService<AssetDocument> 
{
	public AssetDocumentService(Connection connection, 
									Class<AssetDocument> relationshipClass) throws CobieSQLiteException 
	{
		super(connection, relationshipClass);
	}

	@Override
	protected void insertRelationship(AssetDocument assetDocument, DatabaseKey assetKey) throws CobieSQLiteException
	{
		getExecutor().insertValidKey(assetDocument, AssetDocument.ColumnName.RefAsset.toString(), assetKey.get());
		getExecutor().insertValidKey(assetDocument, AssetDocument.ColumnName.RefDocument.toString(), getKey().get());
		
		super.insertRelationship(assetDocument, assetKey);
	}
}