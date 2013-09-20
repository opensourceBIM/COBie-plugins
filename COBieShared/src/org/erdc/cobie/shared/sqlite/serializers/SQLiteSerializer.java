package org.erdc.cobie.shared.sqlite.serializers;

import java.sql.Connection;

import org.buildingsmartalliance.docs.nbims03.cobie.core.CobieBaseType;
import org.erdc.cobie.shared.LoggerUser;
import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.entities.AllowedString;
import org.erdc.cobie.sqlite.entities.CobieEntity;
import org.erdc.cobie.sqlite.entities.RealRange;
import org.erdc.cobie.sqlite.entities.Unit;
import org.erdc.cobie.sqlite.entities.Value;
import org.erdc.cobie.sqlite.entities.relationships.NoRelationship;
import org.erdc.cobie.sqlite.entities.relationships.Relationship;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class SQLiteSerializer<TSource extends CobieBaseType,
										TEntity extends CobieEntity, 
										TRelationship extends Relationship> implements LoggerUser
{		
	private static final Logger LOGGER = LoggerFactory.getLogger(SQLiteSerializer.class);	
	public static final int ID_NONE = -1;
	
	private final TEntity entity;
    private TRelationship relationship;
    
    private final Executor executor; 

    protected SQLiteSerializer(Connection connection, 
    							Class<TEntity> entityClass, 
    							Class<TRelationship> relationshipClass) throws CobieSQLiteException
    {   	
    	executor = new Executor(connection);
    	
    	try 
    	{
			this.entity = createEntity(entityClass);			
		} 
    	
    	catch (InstantiationException e) 
    	{
			throw new CobieSQLiteException(this.getClass(), "Supplied entity (" + 
																entityClass.getName() + 
																") cannot be instantiated.", e);
		} 
    	
    	catch (IllegalAccessException e) 
    	{
			throw new CobieSQLiteException(this.getClass(), e);
		}
    	
    	if (relationshipClass != NoRelationship.class)
    	{
	    	try
	    	{
	    		this.relationship = createRelationship(relationshipClass);
	    	}
	    	
	    	catch (Exception e)
	    	{    		
	    		throw new CobieSQLiteException(this.getClass(), "Supplied relationship (" + 
	    															relationshipClass.getName() + 
	    															") cannot be instantiated.", e);
	    	}
    	}
    }
    
    public void clear() throws CobieSQLiteException
    {
    	clearEntity();
    	clearRelationship();
    	clearValues(); 	
    }
    
    private void clearEntity() throws CobieSQLiteException
    {
        getExecutor().clear(getEntity());    	
    }
    
    private void clearRelationship() throws CobieSQLiteException
    {
    	try
    	{
	        getExecutor().clear(getRelationship());
    	}
    	
    	catch (Exception e)
    	{
    		// There might not be a relationship.
    	}
    }
    
    private void clearValues() throws CobieSQLiteException
    {
    	getExecutor().clear(new AllowedString());
    	getExecutor().clear(new RealRange());
    	getExecutor().clear(new Unit());
    	getExecutor().clear(new Value());
    }
    
    private TEntity createEntity(Class<TEntity> entityClass) throws InstantiationException, IllegalAccessException
    {
    	return entityClass.newInstance();
    }
    
    private TRelationship createRelationship(Class<TRelationship> relationshipClass) throws InstantiationException, IllegalAccessException
    {
    	return relationshipClass.newInstance();
    }
        
    protected final TEntity getEntity()
    {
    	return entity;
    }
    
    protected final Executor getExecutor()
    {
    	return executor;
    }
    
    protected abstract IntegerKey getKey();
    
    public final Logger getLogger()
    {
    	return LOGGER;
    }
    
    protected final TRelationship getRelationship()
    {
    	return relationship;
    }	    
    
    protected void insertEntity(TSource dataSource, TEntity entity, int parentID) throws CobieSQLiteException
    {
    	getExecutor().insertValidKey(entity, CobieEntity.ColumnName.ID.toString(), getKey().next());
    }
    
    protected void insertRelationship(TRelationship relationship, int parentID) throws CobieSQLiteException
    {
    	// Implementation of this method is not required; some serializers do not have relationships.
    }
	
    protected void writeInsertMessage()
    {
    	getLogger().info("Inserting " + this.getClass().getName() + "...");
    }
}
