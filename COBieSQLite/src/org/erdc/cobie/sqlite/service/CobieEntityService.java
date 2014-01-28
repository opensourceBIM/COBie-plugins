package org.erdc.cobie.sqlite.service;

import java.sql.Connection;

import org.buildingsmartalliance.docs.nbims03.cobie.core.CobieBaseType;
import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.entity.CobieEntity;
import org.erdc.cobie.sqlite.entity.relationship.Relationship;

public abstract class CobieEntityService<TSource extends CobieBaseType, 
											TEntity extends CobieEntity,
											TRelationship extends Relationship> 
												extends CobieService<TSource, TEntity, TRelationship> 
{	
	protected CobieEntityService(Connection connection, 
									Class<TEntity> entityClass, 
									Class<TRelationship> relationshipClass) throws CobieSQLiteException
	{
		super(connection, entityClass, relationshipClass);
	}
	
    public final void insert(TSource dataSource, DatabaseKey parentKey) throws CobieSQLiteException
    {
    	insertEntity(dataSource, getEntity(), parentKey);              
        TRelationship relationship = getRelationship();
        
        if (relationship != null)
        {
        	insertRelationship(relationship, parentKey);
        }
        
        writeInsertMessage();
    }
}
