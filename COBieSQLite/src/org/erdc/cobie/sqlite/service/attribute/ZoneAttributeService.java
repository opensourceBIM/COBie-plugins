package org.erdc.cobie.sqlite.service.attribute;

import java.sql.Connection;

import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.entity.relationship.ZoneAttribute;
import org.erdc.cobie.sqlite.service.DatabaseKey;

public class ZoneAttributeService extends AttributeService<ZoneAttribute> 
{
	public ZoneAttributeService(Connection connection,
										Class<ZoneAttribute> relationshipClass) throws CobieSQLiteException 
	{
		super(connection, relationshipClass);
	}

	@Override
	protected void insertRelationship(ZoneAttribute zoneAttribute, DatabaseKey zoneKey) throws CobieSQLiteException
	{
		getExecutor().insertValidKey(zoneAttribute, ZoneAttribute.ColumnName.RefAttribute.toString(), getKey().get());
		getExecutor().insertValidKey(zoneAttribute, ZoneAttribute.ColumnName.RefZone.toString(), zoneKey.get());
		
		super.insertRelationship(zoneAttribute, zoneKey);
	}
}
