package org.erdc.cobie.sqlite.service;

import java.sql.Connection;

import org.buildingsmartalliance.docs.nbims03.cobie.core.CobieBaseType;
import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.entity.CobieAttributesEntity;
import org.erdc.cobie.sqlite.entity.CobieEntity;
import org.erdc.cobie.sqlite.entity.relationship.Relationship;

public abstract class CobieService<TSource extends CobieBaseType, 
									TEntity extends CobieEntity,
									TRelationship extends Relationship> 
										extends Service<TSource, TEntity, TRelationship> 
{
	protected CobieService(Connection connection,
								Class<TEntity> entityClass, 
								Class<TRelationship> relationshipClass)	throws CobieSQLiteException 
	{
		super(connection, entityClass, relationshipClass);
	}
	
	@Override
	protected void insertEntity(TSource dataSource, TEntity entity, DatabaseKey parentKey) throws CobieSQLiteException
	{		
		getExecutor().insertValidEntity(entity, CobieAttributesEntity.ColumnName.ExternalEntityName.toString(), dataSource.getExternalEntityName());
	    getExecutor().insertValidEntity(entity, CobieAttributesEntity.ColumnName.ExternalID.toString(), dataSource.getExternalID());
	    getExecutor().insertValidEntity(entity, CobieAttributesEntity.ColumnName.ExternalSystemName.toString(), dataSource.getExternalSystemName());
	
	    super.insertEntity(dataSource, entity, parentKey);
	}
}
