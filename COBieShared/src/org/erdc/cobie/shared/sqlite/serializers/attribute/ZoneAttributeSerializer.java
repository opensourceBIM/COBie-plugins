package org.erdc.cobie.shared.sqlite.serializers.attribute;

import java.sql.Connection;

import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.entities.relationships.ZoneAttribute;

public class ZoneAttributeSerializer extends AttributeSerializer<ZoneAttribute> 
{
	public ZoneAttributeSerializer(Connection connection,
										Class<ZoneAttribute> relationshipClass) throws CobieSQLiteException 
	{
		super(connection, relationshipClass);
	}

	protected void insertRelationship(ZoneAttribute zoneAttribute, int zoneID) throws CobieSQLiteException
	{
		getExecutor().insertValidKey(zoneAttribute, ZoneAttribute.ColumnName.RefAttribute.toString(), getKey().get());
		getExecutor().insertValidKey(zoneAttribute, ZoneAttribute.ColumnName.RefZone.toString(), zoneID);
	}
}
