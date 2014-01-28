package org.erdc.cobie.sqlite.service.attribute;

import java.sql.Connection;

import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.entity.relationship.SpaceAttribute;
import org.erdc.cobie.sqlite.service.DatabaseKey;

public class SpaceAttributeService extends AttributeService<SpaceAttribute> 
{
	public SpaceAttributeService(Connection connection,
									Class<SpaceAttribute> relationshipClass) throws CobieSQLiteException 
	{
		super(connection, relationshipClass);
	}

	@Override
	protected void insertRelationship(SpaceAttribute spaceAttribute, DatabaseKey spaceKey) throws CobieSQLiteException
	{
		getExecutor().insertValidKey(spaceAttribute, SpaceAttribute.ColumnName.RefAttribute.toString(), getKey().get());
		getExecutor().insertValidKey(spaceAttribute, SpaceAttribute.ColumnName.RefSpace.toString(), spaceKey.get());
		
		super.insertRelationship(spaceAttribute, spaceKey);
	}
}
