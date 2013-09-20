package org.erdc.cobie.shared.sqlite.serializers;

import java.sql.Connection;

import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.ZoneType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.ZoneCollectionType;
import org.erdc.cobie.shared.sqlite.serializers.attribute.ZoneAttributeSerializer;
import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.entities.Zone;
import org.erdc.cobie.sqlite.entities.relationships.FacilityZone;
import org.erdc.cobie.sqlite.entities.relationships.ZoneAttribute;

public final class ZoneSerializer extends CobieCollectionSerializer<ZoneCollectionType, ZoneType, Zone, FacilityZone> 
{
	private static IntegerKey key = new IntegerKey();
	
	private final ZoneAttributeSerializer zoneAttributeSerializer;
	
	public ZoneSerializer(Connection connection,	
							Class<Zone> entityClass,
							Class<FacilityZone> relationshipClass) throws CobieSQLiteException 
	{
		super(connection, entityClass, relationshipClass);
		zoneAttributeSerializer = new ZoneAttributeSerializer(connection, ZoneAttribute.class);
	}

	@Override
	public void clear() throws CobieSQLiteException
	{
		super.clear();
		zoneAttributeSerializer.clear();
	}
	
	@Override
	protected IntegerKey getKey() 
	{
		return key;
	}
	
	@Override
	protected void insertEntity(ZoneType zoneType, Zone zone, int spaceID) throws CobieSQLiteException 
	{
		super.insertEntity(zoneType, zone, spaceID);
		
		getExecutor().insertValidEntity(zone, Zone.ColumnName.ZoneCategory.toString(), zoneType.getZoneCategory());
		getExecutor().insertValidEntity(zone, Zone.ColumnName.ZoneDescription.toString(), zoneType.getZoneDescription());
		getExecutor().insertValidEntity(zone, Zone.ColumnName.ZoneName.toString(), zoneType.getZoneName());
		
		zoneAttributeSerializer.insert(zoneType.getZoneAttributes(), getKey().get());
	}
	
	@Override
    protected void insertRelationship(FacilityZone facilityZone, int facilityID) throws CobieSQLiteException
    {    	
		getExecutor().insertValidKey(facilityZone, FacilityZone.ColumnName.RefFacility.toString(), facilityID);
		getExecutor().insertValidKey(facilityZone, FacilityZone.ColumnName.RefZone.toString(), getKey().get());
    }
}
