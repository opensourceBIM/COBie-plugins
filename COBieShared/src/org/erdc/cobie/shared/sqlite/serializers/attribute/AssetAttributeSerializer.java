package org.erdc.cobie.shared.sqlite.serializers.attribute;

import java.sql.Connection;

import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.entities.relationships.AssetAttribute;

public class AssetAttributeSerializer extends AttributeSerializer<AssetAttribute> 
{
	public AssetAttributeSerializer(Connection connection, 
										Class<AssetAttribute> relationshipClass) throws CobieSQLiteException 
	{
		super(connection, relationshipClass);
	}

	protected void insertRelationship(AssetAttribute assetAttribute, int assetID) throws CobieSQLiteException
	{
		getExecutor().insertValidKey(assetAttribute, AssetAttribute.ColumnName.RefAsset.toString(), assetID);
		getExecutor().insertValidKey(assetAttribute, AssetAttribute.ColumnName.RefAttribute.toString(), getKey().get());
	}
}
