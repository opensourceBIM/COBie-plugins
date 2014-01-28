package org.erdc.cobie.sqlite.service.attribute;

import java.sql.Connection;

import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.entity.relationship.AssetTypeAttribute;
import org.erdc.cobie.sqlite.service.DatabaseKey;

public class AssetTypeAttributeService extends AttributeService<AssetTypeAttribute> 
{
	public AssetTypeAttributeService(Connection connection,
										Class<AssetTypeAttribute> relationshipClass) throws CobieSQLiteException 
	{
		super(connection, relationshipClass);
	}

	@Override
	protected void insertRelationship(AssetTypeAttribute assetTypeAttribute, DatabaseKey assetTypeKey) throws CobieSQLiteException
	{
		getExecutor().insertValidKey(assetTypeAttribute, AssetTypeAttribute.ColumnName.RefAssetType.toString(), assetTypeKey.get());
		getExecutor().insertValidKey(assetTypeAttribute, AssetTypeAttribute.ColumnName.RefAttribute.toString(), getKey().get());
		
		super.insertRelationship(assetTypeAttribute, assetTypeKey);
	}
}
