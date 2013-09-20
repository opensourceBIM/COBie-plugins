package org.erdc.cobie.shared.sqlite.serializers;

import java.sql.Connection;

import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.SpaceType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.SpaceCollectionType;
import org.erdc.cobie.shared.sqlite.serializers.attribute.SpaceAttributeSerializer;
import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.entities.Space;
import org.erdc.cobie.sqlite.entities.relationships.FloorSpace;
import org.erdc.cobie.sqlite.entities.relationships.SpaceAttribute;

public final class SpaceSerializer extends CobieCollectionSerializer<SpaceCollectionType, SpaceType, Space, FloorSpace> 
{	
	private static IntegerKey key = new IntegerKey();
	
	private final SpaceAttributeSerializer spaceAttributeSerializer;
	
	public SpaceSerializer(Connection connection, 
							Class<Space> entityClass, 
							Class<FloorSpace> relationshipClass) throws CobieSQLiteException 
	{
		super(connection, entityClass, relationshipClass);		
		spaceAttributeSerializer = new SpaceAttributeSerializer(connection, SpaceAttribute.class);
	}

	@Override
	public void clear() throws CobieSQLiteException
	{
		super.clear();
		spaceAttributeSerializer.clear();
	}
	
	@Override
	protected IntegerKey getKey() 
	{
		return key;
	}
	
	@Override
	protected void insertEntity(SpaceType spaceType, Space space, int floorID) throws CobieSQLiteException 
	{
		super.insertEntity(spaceType, space, floorID);
		
		getExecutor().insertValidKey(space, Space.ColumnName.RefSpaceGrossAreaValue.toString(), getExecutor().insertValue(spaceType.getSpaceGrossAreaValue()));
		getExecutor().insertValidKey(space, Space.ColumnName.RefSpaceNetAreaValue.toString(), getExecutor().insertValue(spaceType.getSpaceNetAreaValue()));
		getExecutor().insertValidKey(space, Space.ColumnName.RefSpaceUsableHeightValue.toString(), getExecutor().insertValue(spaceType.getSpaceUsableHeightValue()));
		
		getExecutor().insertValidEntity(space, Space.ColumnName.SpaceCategory.toString(), spaceType.getSpaceCategory());
		getExecutor().insertValidEntity(space, Space.ColumnName.SpaceDescription.toString(), spaceType.getSpaceDescription());
		getExecutor().insertValidEntity(space, Space.ColumnName.SpaceName.toString(), spaceType.getSpaceName());
		getExecutor().insertValidEntity(space, Space.ColumnName.SpaceSignageName.toString(), spaceType.getSpaceSignageName());
		
		spaceAttributeSerializer.insert(spaceType.getSpaceAttributes(), getKey().get());
	}
	
	@Override
    protected void insertRelationship(FloorSpace floorSpace, int floorID) throws CobieSQLiteException
    {    	
		getExecutor().insertValidKey(floorSpace, FloorSpace.ColumnName.RefFloor.toString(), floorID);
		getExecutor().insertValidKey(floorSpace, FloorSpace.ColumnName.RefSpace.toString(), getKey().get());
    }
}
