package org.erdc.cobie.sqlite.service;

import java.sql.Connection;

import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.FloorType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.FloorCollectionType;
import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.entity.Floor;
import org.erdc.cobie.sqlite.entity.Space;
import org.erdc.cobie.sqlite.entity.relationship.FacilityFloor;
import org.erdc.cobie.sqlite.entity.relationship.FloorAttribute;
import org.erdc.cobie.sqlite.entity.relationship.FloorSpace;
import org.erdc.cobie.sqlite.service.attribute.FloorAttributeService;

public final class FloorService extends CobieCollectionService<FloorCollectionType, FloorType, Floor, FacilityFloor> 
{	
	private final FloorAttributeService floorAttributeService;
	private final SpaceService spaceService;
    
	public FloorService(Connection connection, 
							Class<Floor> floorClass, 
							Class<FacilityFloor> facilityFloorClass) throws CobieSQLiteException 
	{
		super(connection, floorClass, facilityFloorClass);
		
		floorAttributeService = new FloorAttributeService(connection, FloorAttribute.class);
		spaceService = new SpaceService(connection, Space.class, FloorSpace.class);
	}
	
	@Override
	public void clear() throws CobieSQLiteException
	{
		super.clear();
		floorAttributeService.clear();
		spaceService.clear();
	}

	@Override
	protected void insertEntity(FloorType floorType, Floor floor, DatabaseKey facilityKey) throws CobieSQLiteException 
	{		
		getExecutor().insertValidKey(floor, Floor.ColumnName.RefFloorElevationValue.toString(), getExecutor().insertValue(floorType.getFloorElevationValue()));
		getExecutor().insertValidKey(floor, Floor.ColumnName.RefFloorHeightValue.toString(), getExecutor().insertValue(floorType.getFloorHeightValue()));                  
		
		getExecutor().insertValidEntity(floor, Floor.ColumnName.FloorCategory.toString(), floorType.getFloorCategory());
		getExecutor().insertValidEntity(floor, Floor.ColumnName.FloorDescription.toString(), floorType.getFloorDescription());            
		getExecutor().insertValidEntity(floor, Floor.ColumnName.FloorName.toString(), floorType.getFloorName());         
        
		super.insertEntity(floorType, floor, facilityKey);
		
        floorAttributeService.insert(floorType.getFloorAttributes(), getKey());
        spaceService.insert(floorType.getSpaces(), getKey());
	}
	
	@Override
    protected void insertRelationship(FacilityFloor facilityFloor, DatabaseKey facilityKey) throws CobieSQLiteException
    {    	    	
		getExecutor().insertValidKey(facilityFloor, FacilityFloor.ColumnName.RefFacility.toString(), facilityKey.get());
		getExecutor().insertValidKey(facilityFloor, FacilityFloor.ColumnName.RefFloor.toString(), getKey().get());
		
		super.insertRelationship(facilityFloor, facilityKey);
    }
}
