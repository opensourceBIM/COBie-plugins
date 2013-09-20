package org.erdc.cobie.shared.sqlite.serializers.attribute;

import java.sql.Connection;

import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.entities.relationships.FloorAttribute;

public class FloorAttributeSerializer extends AttributeSerializer<FloorAttribute> 
{
	public FloorAttributeSerializer(Connection connection,
										Class<FloorAttribute> relationshipClass) throws CobieSQLiteException 
	{
		super(connection, relationshipClass);
	}

	protected void insertRelationship(FloorAttribute floorAttribute, int floorID) throws CobieSQLiteException
	{
		getExecutor().insertValidKey(floorAttribute, FloorAttribute.ColumnName.RefAttribute.toString(), getKey().get());
		getExecutor().insertValidKey(floorAttribute, FloorAttribute.ColumnName.RefFloor.toString(), floorID);
	}
}
