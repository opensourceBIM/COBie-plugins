package org.erdc.cobie.sqlite.service.attribute;

import java.sql.Connection;

import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.entity.relationship.FacilityAttribute;
import org.erdc.cobie.sqlite.service.DatabaseKey;

public class FacilityAttributeService extends AttributeService<FacilityAttribute> 
{
	public FacilityAttributeService(Connection connection,
										Class<FacilityAttribute> relationshipClass) throws CobieSQLiteException 
	{
		super(connection, relationshipClass);
	}

	@Override
	protected void insertRelationship(FacilityAttribute facilityAttribute, DatabaseKey facilityKey) throws CobieSQLiteException
	{
		getExecutor().insertValidKey(facilityAttribute, FacilityAttribute.ColumnName.RefAttribute.toString(), getKey().get());
		getExecutor().insertValidKey(facilityAttribute, FacilityAttribute.ColumnName.RefFacility.toString(), facilityKey.get());
		
		super.insertRelationship(facilityAttribute, facilityKey);
	}
}
