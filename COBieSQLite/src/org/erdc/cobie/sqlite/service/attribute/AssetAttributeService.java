package org.erdc.cobie.sqlite.service.attribute;

import java.sql.Connection;

import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.entity.relationship.AssetAttribute;
import org.erdc.cobie.sqlite.service.DatabaseKey;

public class AssetAttributeService extends AttributeService<AssetAttribute> 
{
	public AssetAttributeService(Connection connection, 
									Class<AssetAttribute> relationshipClass) throws CobieSQLiteException 
	{
		super(connection, relationshipClass);
	}

	@Override
	protected void insertRelationship(AssetAttribute assetAttribute, DatabaseKey assetKey) throws CobieSQLiteException
	{
		getExecutor().insertValidKey(assetAttribute, AssetAttribute.ColumnName.RefAsset.toString(), assetKey.get());
		getExecutor().insertValidKey(assetAttribute, AssetAttribute.ColumnName.RefAttribute.toString(), getKey().get());
		
		super.insertRelationship(assetAttribute, assetKey);
	}
}
