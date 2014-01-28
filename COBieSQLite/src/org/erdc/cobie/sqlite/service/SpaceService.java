package org.erdc.cobie.sqlite.service;

import java.sql.Connection;

import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.SpaceType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.SpaceCollectionType;
import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.entity.Space;
import org.erdc.cobie.sqlite.entity.relationship.FloorSpace;
import org.erdc.cobie.sqlite.entity.relationship.SpaceAttribute;
import org.erdc.cobie.sqlite.service.attribute.SpaceAttributeService;

public final class SpaceService extends CobieCollectionService<SpaceCollectionType, SpaceType, Space, FloorSpace> 
{		
	private final SpaceAttributeService spaceAttributeService;
	
	public SpaceService(Connection connection, 
							Class<Space> entityClass, 
							Class<FloorSpace> relationshipClass) throws CobieSQLiteException 
	{
		super(connection, entityClass, relationshipClass);		
		spaceAttributeService = new SpaceAttributeService(connection, SpaceAttribute.class);
	}

	@Override
	public void clear() throws CobieSQLiteException
	{
		super.clear();
		spaceAttributeService.clear();
	}
	
	@Override
	protected void insertEntity(SpaceType spaceType, Space space, DatabaseKey floorKey) throws CobieSQLiteException 
	{		
		getExecutor().insertValidKey(space, Space.ColumnName.RefSpaceGrossAreaValue.toString(), getExecutor().insertValue(spaceType.getSpaceGrossAreaValue()));
		getExecutor().insertValidKey(space, Space.ColumnName.RefSpaceNetAreaValue.toString(), getExecutor().insertValue(spaceType.getSpaceNetAreaValue()));
		getExecutor().insertValidKey(space, Space.ColumnName.RefSpaceUsableHeightValue.toString(), getExecutor().insertValue(spaceType.getSpaceUsableHeightValue()));
		
		getExecutor().insertValidEntity(space, Space.ColumnName.SpaceCategory.toString(), spaceType.getSpaceCategory());
		getExecutor().insertValidEntity(space, Space.ColumnName.SpaceDescription.toString(), spaceType.getSpaceDescription());
		getExecutor().insertValidEntity(space, Space.ColumnName.SpaceName.toString(), spaceType.getSpaceName());
		getExecutor().insertValidEntity(space, Space.ColumnName.SpaceSignageName.toString(), spaceType.getSpaceSignageName());
	
		super.insertEntity(spaceType, space, floorKey);		
		spaceAttributeService.insert(spaceType.getSpaceAttributes(), getKey());
	}
	
	@Override
    protected void insertRelationship(FloorSpace floorSpace, DatabaseKey floorKey) throws CobieSQLiteException
    {    	
		getExecutor().insertValidKey(floorSpace, FloorSpace.ColumnName.RefFloor.toString(), floorKey.get());
		getExecutor().insertValidKey(floorSpace, FloorSpace.ColumnName.RefSpace.toString(), getKey().get());
		
		super.insertRelationship(floorSpace, floorKey);
    }
}
