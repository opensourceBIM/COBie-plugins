package org.erdc.cobie.shared.sqlite.serializers;

import java.sql.Connection;

import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.FloorType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.FloorCollectionType;
import org.erdc.cobie.shared.sqlite.serializers.attribute.FloorAttributeSerializer;
import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.entities.Floor;
import org.erdc.cobie.sqlite.entities.Space;
import org.erdc.cobie.sqlite.entities.relationships.FacilityFloor;
import org.erdc.cobie.sqlite.entities.relationships.FloorAttribute;
import org.erdc.cobie.sqlite.entities.relationships.FloorSpace;

public final class FloorSerializer extends CobieCollectionSerializer<FloorCollectionType, FloorType, Floor, FacilityFloor> 
{
	private static IntegerKey key = new IntegerKey();
	
	private final FloorAttributeSerializer floorAttributeSerializer;
	private final SpaceSerializer spaceSerializer;
    
	public FloorSerializer(Connection connection, 
							Class<Floor> floorClass, 
							Class<FacilityFloor> facilityFloorClass) throws CobieSQLiteException 
	{
		super(connection, floorClass, facilityFloorClass);
		
		floorAttributeSerializer = new FloorAttributeSerializer(connection, FloorAttribute.class);
		spaceSerializer = new SpaceSerializer(connection, Space.class, FloorSpace.class);
	}
	
	@Override
	public void clear() throws CobieSQLiteException
	{
		super.clear();
		floorAttributeSerializer.clear();
		spaceSerializer.clear();
	}
	
	@Override
	protected IntegerKey getKey() 
	{
		return key;
	}

	@Override
	protected void insertEntity(FloorType floorType, Floor floor, int facilityID) throws CobieSQLiteException 
	{
		super.insertEntity(floorType, floor, facilityID);
		
		getExecutor().insertValidKey(floor, Floor.ColumnName.RefFloorElevationValue.toString(), getExecutor().insertValue(floorType.getFloorElevationValue()));
		getExecutor().insertValidKey(floor, Floor.ColumnName.RefFloorHeightValue.toString(), getExecutor().insertValue(floorType.getFloorHeightValue()));   
                
		getExecutor().insertValidEntity(floor, Floor.ColumnName.FloorCategory.toString(), floorType.getFloorCategory());
		getExecutor().insertValidEntity(floor, Floor.ColumnName.FloorDescription.toString(), floorType.getFloorDescription());            
		getExecutor().insertValidEntity(floor, Floor.ColumnName.FloorName.toString(), floorType.getFloorName());         
        
        floorAttributeSerializer.insert(floorType.getFloorAttributes(), getKey().get());
        spaceSerializer.insert(floorType.getSpaces(), getKey().get());
	}
	
	@Override
    protected void insertRelationship(FacilityFloor facilityFloor, int facilityID) throws CobieSQLiteException
    {    	    	
		getExecutor().insertValidKey(facilityFloor, FacilityFloor.ColumnName.RefFacility.toString(), facilityID);
		getExecutor().insertValidKey(facilityFloor, FacilityFloor.ColumnName.RefFloor.toString(), getKey().get());
    }
}
