package org.erdc.cobie.shared.sqlite.serializers;

import java.sql.Connection;

import org.buildingsmartalliance.docs.nbims03.cobie.core.CobieBaseType;
import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.entities.CobieAttributesEntity;
import org.erdc.cobie.sqlite.entities.CobieEntity;
import org.erdc.cobie.sqlite.entities.relationships.Relationship;

public abstract class CobieSerializer<TSource extends CobieBaseType, 
										TEntity extends CobieEntity,
										TRelationship extends Relationship> 
											extends SQLiteSerializer<TSource, TEntity, TRelationship> 
{
	protected CobieSerializer(Connection connection,
								Class<TEntity> entityClass, 
								Class<TRelationship> relationshipClass)	throws CobieSQLiteException 
	{
		super(connection, entityClass, relationshipClass);
	}
	
	protected void insertEntity(TSource dataSource, TEntity entity, int parentID) throws CobieSQLiteException
	{
		super.insertEntity(dataSource, entity, parentID);
		
		getExecutor().insertValidEntity(entity, CobieAttributesEntity.ColumnName.ExternalEntityName.toString(), dataSource.getExternalEntityName());
	    getExecutor().insertValidEntity(entity, CobieAttributesEntity.ColumnName.ExternalID.toString(), dataSource.getExternalID());
	    getExecutor().insertValidEntity(entity, CobieAttributesEntity.ColumnName.ExternalSystemName.toString(), dataSource.getExternalSystemName());
	}
}
