package org.erdc.cobie.sqlite.service.attribute;

import java.sql.Connection;

import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.entity.relationship.FloorAttribute;
import org.erdc.cobie.sqlite.service.DatabaseKey;

public class FloorAttributeService extends AttributeService<FloorAttribute> 
{
	public FloorAttributeService(Connection connection,
									Class<FloorAttribute> relationshipClass) throws CobieSQLiteException 
	{
		super(connection, relationshipClass);
	}

	@Override
	protected void insertRelationship(FloorAttribute floorAttribute, DatabaseKey floorKey) throws CobieSQLiteException
	{
		getExecutor().insertValidKey(floorAttribute, FloorAttribute.ColumnName.RefAttribute.toString(), getKey().get());
		getExecutor().insertValidKey(floorAttribute, FloorAttribute.ColumnName.RefFloor.toString(), floorKey.get());
		
		super.insertRelationship(floorAttribute, floorKey);
	}
}
