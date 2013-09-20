package org.erdc.cobie.shared.sqlite.serializers.attribute;

import java.sql.Connection;

import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.entities.relationships.AssetTypeAttribute;

public class AssetTypeAttributeSerializer extends AttributeSerializer<AssetTypeAttribute> 
{
	public AssetTypeAttributeSerializer(Connection connection,
											Class<AssetTypeAttribute> relationshipClass) throws CobieSQLiteException 
	{
		super(connection, relationshipClass);
	}

	protected void insertRelationship(AssetTypeAttribute assetTypeAttribute, int assetTypeID) throws CobieSQLiteException
	{
		getExecutor().insertValidKey(assetTypeAttribute, AssetTypeAttribute.ColumnName.RefAssetType.toString(), assetTypeID);
		getExecutor().insertValidKey(assetTypeAttribute, AssetTypeAttribute.ColumnName.RefAttribute.toString(), getKey().get());
	}
}
