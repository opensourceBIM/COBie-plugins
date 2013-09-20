package org.erdc.cobie.shared.sqlite.serializers;

import java.sql.Connection;

import org.buildingsmartalliance.docs.nbims03.cobie.core.CobieBaseType;
import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.Query;
import org.erdc.cobie.sqlite.entities.CobieEntity;
import org.erdc.cobie.sqlite.entities.relationships.Relationship;

public abstract class CobieEntitySerializer<TSource extends CobieBaseType, 
											TEntity extends CobieEntity,
											TRelationship extends Relationship> 
												extends CobieSerializer<TSource, TEntity, TRelationship> 
{	
	protected CobieEntitySerializer(Connection connection, 
								Class<TEntity> entityClass, 
								Class<TRelationship> relationshipClass) throws CobieSQLiteException
	{
		super(connection, entityClass, relationshipClass);
	}
    	
    public void insert(TSource dataSource, int parentID) throws CobieSQLiteException
    {
    	TEntity entity = getEntity();    	
    	insertEntity(dataSource, entity, parentID);
    	    	
        Query query = new Query(entity);
        query.insert();        		
        
        getExecutor().execute(query);
        entity.reset();
        
        TRelationship relationship = getRelationship();
        
        if (relationship != null)
        {
        	insertRelationship(relationship, parentID);
        	        	
            query = new Query(relationship);
            query.insert();        		
            
            getExecutor().execute(query);
            relationship.reset();
        }
        
        writeInsertMessage();
    }
}
