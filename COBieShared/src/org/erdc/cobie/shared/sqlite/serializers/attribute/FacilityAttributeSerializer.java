package org.erdc.cobie.shared.sqlite.serializers.attribute;

import java.sql.Connection;

import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.entities.relationships.FacilityAttribute;

public class FacilityAttributeSerializer extends AttributeSerializer<FacilityAttribute> 
{
	public FacilityAttributeSerializer(Connection connection,
											Class<FacilityAttribute> relationshipClass) throws CobieSQLiteException 
	{
		super(connection, relationshipClass);
	}

	protected void insertRelationship(FacilityAttribute facilityAttribute, int facilityID) throws CobieSQLiteException
	{
		getExecutor().insertValidKey(facilityAttribute, FacilityAttribute.ColumnName.RefAttribute.toString(), getKey().get());
		getExecutor().insertValidKey(facilityAttribute, FacilityAttribute.ColumnName.RefFacility.toString(), facilityID);
	}
}
