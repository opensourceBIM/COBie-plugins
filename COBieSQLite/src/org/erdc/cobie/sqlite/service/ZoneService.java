package org.erdc.cobie.sqlite.service;

import java.sql.Connection;

import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.ZoneType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.ZoneCollectionType;
import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.entity.Zone;
import org.erdc.cobie.sqlite.entity.relationship.FacilityZone;
import org.erdc.cobie.sqlite.entity.relationship.ZoneAttribute;
import org.erdc.cobie.sqlite.service.attribute.ZoneAttributeService;

public final class ZoneService extends CobieCollectionService<ZoneCollectionType, ZoneType, Zone, FacilityZone> 
{	
	private final ZoneAttributeService zoneAttributeService;
	
	public ZoneService(Connection connection,	
							Class<Zone> entityClass,
							Class<FacilityZone> relationshipClass) throws CobieSQLiteException 
	{
		super(connection, entityClass, relationshipClass);
		zoneAttributeService = new ZoneAttributeService(connection, ZoneAttribute.class);
	}

	@Override
	public void clear() throws CobieSQLiteException
	{
		super.clear();
		zoneAttributeService.clear();
	}
	
	@Override
	protected void insertEntity(ZoneType zoneType, Zone zone, DatabaseKey facilityKey) throws CobieSQLiteException 
	{		
		getExecutor().insertValidEntity(zone, Zone.ColumnName.ZoneCategory.toString(), zoneType.getZoneCategory());
		getExecutor().insertValidEntity(zone, Zone.ColumnName.ZoneDescription.toString(), zoneType.getZoneDescription());
		getExecutor().insertValidEntity(zone, Zone.ColumnName.ZoneName.toString(), zoneType.getZoneName());
	
		super.insertEntity(zoneType, zone, facilityKey);		
		zoneAttributeService.insert(zoneType.getZoneAttributes(), getKey());
	}
	
	@Override
    protected void insertRelationship(FacilityZone facilityZone, DatabaseKey facilityKey) throws CobieSQLiteException
    {    	
		getExecutor().insertValidKey(facilityZone, FacilityZone.ColumnName.RefFacility.toString(), facilityKey.get());
		getExecutor().insertValidKey(facilityZone, FacilityZone.ColumnName.RefZone.toString(), getKey().get());
		
		super.insertRelationship(facilityZone, facilityKey);
    }
}
