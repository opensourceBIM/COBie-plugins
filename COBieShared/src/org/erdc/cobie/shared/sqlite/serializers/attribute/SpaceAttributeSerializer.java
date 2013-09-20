package org.erdc.cobie.shared.sqlite.serializers.attribute;

import java.sql.Connection;

import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.entities.relationships.SpaceAttribute;

public class SpaceAttributeSerializer extends AttributeSerializer<SpaceAttribute> 
{
	public SpaceAttributeSerializer(Connection connection,
										Class<SpaceAttribute> relationshipClass) throws CobieSQLiteException 
	{
		super(connection, relationshipClass);
	}

	protected void insertRelationship(SpaceAttribute spaceAttribute, int spaceID) throws CobieSQLiteException
	{
		getExecutor().insertValidKey(spaceAttribute, SpaceAttribute.ColumnName.RefAttribute.toString(), getKey().get());
		getExecutor().insertValidKey(spaceAttribute, SpaceAttribute.ColumnName.RefSpace.toString(), spaceID);
	}
}
