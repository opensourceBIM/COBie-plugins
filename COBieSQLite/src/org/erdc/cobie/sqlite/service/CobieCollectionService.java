package org.erdc.cobie.sqlite.service;

import java.sql.Connection;

import org.buildingsmartalliance.docs.nbims03.cobie.core.AssetCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.AssetTypeCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.AttributeCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.CobieBaseType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.CobieWorksheetType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.ContactCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.DocumentCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.FloorCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.SpaceCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.ZoneCollectionType;
import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.Query;
import org.erdc.cobie.sqlite.entity.CobieEntity;
import org.erdc.cobie.sqlite.entity.relationship.Relationship;
import org.erdc.cobie.sqlite.string.Error;

public abstract class CobieCollectionService<TSourceCollection extends CobieWorksheetType,
												TSource extends CobieBaseType, 
												TEntity extends CobieEntity,
												TRelationship extends Relationship> 
													extends CobieService<TSource, TEntity, TRelationship>
{	
	protected CobieCollectionService(Connection connection, 
										Class<TEntity> entityClass,
										Class<TRelationship> relationshipClass) throws CobieSQLiteException
	{
		super(connection, entityClass, relationshipClass);
	}
	
    @SuppressWarnings("unchecked") // This cast is safe. See getCobieTypeArray() for more info.
	public final void insert(TSourceCollection dataSourceCollection, DatabaseKey parentKey) throws CobieSQLiteException
    {
    	TEntity entity = getEntity(); 
    	TRelationship relationship = getRelationship();
    	
    	if (dataSourceCollection != null)
    	{    		
	    	for (Object type : getCobieTypeArray(dataSourceCollection))
	    	{	        	
	        	insertEntity((TSource)type, entity, parentKey);
	            
	            if (relationship != null)
	            {	            	
	            	insertRelationship(relationship, parentKey);
	            }	    		
	    	}
    	}
    	
    	writeInsertMessage();
    }

    @Override
	protected void insertEntity(TSource dataSource, TEntity entity, DatabaseKey parentKey) throws CobieSQLiteException
    {
    	super.insertEntity(dataSource, entity, parentKey);
    	    	
        Query query = new Query(entity);
        query.insert();        		
        
        getExecutor().execute(query);
        entity.reset();
    }
    
    @Override
	protected void insertRelationship(TRelationship relationship, DatabaseKey parentKey) throws CobieSQLiteException
    {
    	super.insertRelationship(relationship, parentKey);
    	
    }
    
    @Deprecated // *** THIS IS VERY NAUGHTY AND HORRIBLE! ***
    			// It is only necessary b/c CobieWorksheetType does not define a way to access any data. 
    			// It relies on its sub-classes to define unique "to...Array()" methods for some reason. 
    protected Object[] getCobieTypeArray(TSourceCollection typeCollection) throws CobieSQLiteException
    {
    	Object[] types = null;
    	
    	if (typeCollection instanceof AssetCollectionType)
    	{
    		types = ((AssetCollectionType)typeCollection).getAssetArray();   	
    	}
    	
    	else if (typeCollection instanceof AssetTypeCollectionType)
    	{
    		types = ((AssetTypeCollectionType)typeCollection).getAssetTypeArray();
    	}
    	
    	else if (typeCollection instanceof AttributeCollectionType)
    	{
    		types = ((AttributeCollectionType)typeCollection).getAttributeArray();
    	}
    	
    	else if (typeCollection instanceof ContactCollectionType)
    	{
    		types = ((ContactCollectionType)typeCollection).getContactArray();
    	}
    	
    	else if (typeCollection instanceof DocumentCollectionType)
    	{
    		types = ((DocumentCollectionType)typeCollection).getDocumentArray();
    	}
    	
    	else if (typeCollection instanceof FloorCollectionType)
    	{
    		types = ((FloorCollectionType)typeCollection).getFloorArray();
    	}
    	
    	else if (typeCollection instanceof SpaceCollectionType)
    	{
    		types = ((SpaceCollectionType)typeCollection).getSpaceArray();
    	}
    	
    	else if (typeCollection instanceof ZoneCollectionType)
    	{
    		types = ((ZoneCollectionType)typeCollection).getZoneArray();
    	}
    	
    	else
    	{
    		throw new CobieSQLiteException(
    				this.getClass(), Error.COLLECTION_TYPE_NOT_SUPPORTED.format(typeCollection.getClass()));
    	}
    	
    	return types;
    }
}
