package org.erdc.cobie.sqlite.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.buildingsmartalliance.docs.nbims03.cobie.core.CobieBaseType;
import org.erdc.cobie.shared.LoggerUser;
import org.erdc.cobie.shared.utils.CollectionUtils;
import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.ColumnSet;
import org.erdc.cobie.sqlite.Query;
import org.erdc.cobie.sqlite.QueryResultType;
import org.erdc.cobie.sqlite.Row;
import org.erdc.cobie.sqlite.entity.AllowedString;
import org.erdc.cobie.sqlite.entity.CobieEntity;
import org.erdc.cobie.sqlite.entity.Entity;
import org.erdc.cobie.sqlite.entity.RealRange;
import org.erdc.cobie.sqlite.entity.Unit;
import org.erdc.cobie.sqlite.entity.Value;
import org.erdc.cobie.sqlite.entity.relationship.NoRelationship;
import org.erdc.cobie.sqlite.entity.relationship.Relationship;
import org.erdc.cobie.sqlite.string.Default;
import org.erdc.cobie.sqlite.string.Error;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Service<TSource extends CobieBaseType,
								TEntity extends CobieEntity, 
								TRelationship extends Relationship> implements LoggerUser
{			
	private static final Logger LOGGER = LoggerFactory.getLogger(Service.class);	
	public static final DatabaseKey EMPTY_KEY = new DatabaseKey();
	
	private DatabaseKey key = EMPTY_KEY;
	private DatabaseKey relationshipKey = EMPTY_KEY;
	
	private final TEntity entity;
    private TRelationship relationship;
    
    private final Executor executor;

    protected Service(Connection connection, 
						Class<TEntity> entityClass, 
						Class<TRelationship> relationshipClass) throws CobieSQLiteException
    {   	
    	executor = new Executor(connection);    	
    	this.entity = createEntity(entityClass);			
    	
    	if (relationshipClass != NoRelationship.class)
    	{
    		this.relationship = createRelationship(relationshipClass);
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
    
    private void clearRelationship()
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
    
    private TEntity createEntity(Class<TEntity> entityClass) throws CobieSQLiteException
    {
    	TEntity newEntity;
    	
    	try
    	{
    		newEntity = entityClass.newInstance();
    	}
    
    	catch (Exception e)
    	{
    		throw new CobieSQLiteException(this.getClass(), Error.ENTITY_INIT_FAILURE.format(entityClass.getName()), e);
    	}
    	
    	return newEntity;
    }
    
    private TRelationship createRelationship(Class<TRelationship> relationshipClass) throws CobieSQLiteException
    {
    	TRelationship newRelationship;
    	
    	try
    	{
    		newRelationship = relationshipClass.newInstance();
    	}
    	
    	catch (Exception e)
    	{
    		throw new CobieSQLiteException(this.getClass(), Error.RELATIONSHIP_INIT_FAILURE.format(relationshipClass.getName()), e);
    	}
    	
    	return newRelationship;
    }
        
    public TEntity getByKey(DatabaseKey key) throws CobieSQLiteException
    {
    	TEntity matchingEntity = getEntity();
    	matchingEntity.setKey(key.get());
    	
    	ColumnSet keySet = new ColumnSet(matchingEntity.getColumn(CobieEntity.ColumnName.ID.toString()));
    	return getWhereEquals(keySet);
    }
    
    public TEntity getByQuery(Query query) throws CobieSQLiteException
    {
    	TEntity matchingEntity = getEntity();
    	CobieSQLiteException exception = new CobieSQLiteException(this.getClass(), Error.SELECT_UNIQUE_REQUIRED.toString());
    	
    	if (query.getResultType() == QueryResultType.NO_RESULT)
    	{
    		throw exception;
    	}
    	
    	getExecutor().execute(query);
    	
    	try
    	{
	    	List<Row> rows = Row.makeRows(matchingEntity, getExecutor().getLastResult());
	    	matchingEntity.addRow(CollectionUtils.getSingle(rows));
    	}
    	
    	catch (CobieSQLiteException e)
    	{
    		throw exception;
    	}
    	
    	return matchingEntity;
    }
    
    public List<Entity> getChildren()
    {
    	List<Entity> children = new ArrayList<>();
    	
    	
    	
    	return children;
    }
    
    public TEntity getWhereEquals(ColumnSet columns) throws CobieSQLiteException
    {
    	TEntity matchingEntity = getEntity();
    	
		Query query = new Query(matchingEntity);
		query.selectByMatchingValues(columns);		
		getExecutor().execute(query);
			
		List<Row> rows = Row.makeRows(matchingEntity, getExecutor().getLastResult());
		matchingEntity.addRow(CollectionUtils.getSingle(rows));
		
		return matchingEntity;	
    }
    
    protected final TEntity getEntity()
    {
    	return entity;
    }
    
    protected final Executor getExecutor()
    {
    	return executor;
    }
    
    protected final DatabaseKey getKey() throws CobieSQLiteException
    {
    	if (key == EMPTY_KEY)
    	{
    		throw new CobieSQLiteException(this.getClass(), Error.ENTITY_KEY_NOT_SET.format(this.getEntity().getTableName()));
    	}
    	
    	return key;
    }
    
    public final long getLastInsertID() throws CobieSQLiteException
    {
    	return getExecutor().getLastInsertID();
    }
    
    @Override
	public final Logger getLogger()
    {
    	return LOGGER;
    }
    
    protected final TRelationship getRelationship()
    {
    	return relationship;
    }
    
    protected final DatabaseKey getRelationshipKey() throws CobieSQLiteException
    {
    	if (relationshipKey == EMPTY_KEY)
    	{
    		throw new CobieSQLiteException(
    				this.getClass(), Error.ENTITY_KEY_NOT_SET.format(this.getRelationship().getTableName()));
    	}
    	
    	return relationshipKey;
    }
	
    // TODO These methods and insert() should be restructured somehow. As it stands, overriding this
    // method is necessary, but can break the class's functionality.
    protected void insertEntity(TSource dataSource, TEntity entity, DatabaseKey parentKey) throws CobieSQLiteException
    {    	
        Query query = new Query(entity);
        query.insert();        		
        
        getExecutor().execute(query);
        entity.reset();
        
        key = new DatabaseKey((int)getExecutor().getLastInsertID());        
    }
    
    // TODO These methods and insert() should be restructured somehow. As it stands, overriding this
    // method is necessary, but can break the class's functionality.
    protected void insertRelationship(TRelationship relationship, DatabaseKey parentKey) throws CobieSQLiteException
    {
        Query query = new Query(relationship);
        query.insert();        		
        
        getExecutor().execute(query);
        relationship.reset();
        
        relationshipKey = new DatabaseKey((int)getExecutor().getLastInsertID());
    }
    
    public final void updateWhereEquals(ColumnSet columns, ColumnSet matches) throws CobieSQLiteException
    {
    	TEntity matchingEntity = getEntity();
    	
    	Query query = new Query(matchingEntity);
    	query.updateWhere(columns, matches);
    	getExecutor().execute(query);    	
    }
    
    protected void writeInsertMessage()
    {
    	getLogger().info(Default.INSERTING_RECORD_MESSAGE.format(this.getClass().getName()));
    }
}
