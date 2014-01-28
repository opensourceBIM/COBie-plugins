package org.erdc.cobie.sqlite.service.attribute;

import java.sql.Connection;

import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.AttributeType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.AttributeCollectionType;
import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.entity.Attribute;
import org.erdc.cobie.sqlite.entity.relationship.Relationship;
import org.erdc.cobie.sqlite.service.CobieCollectionService;
import org.erdc.cobie.sqlite.service.DatabaseKey;

public abstract class AttributeService<TRelationship extends Relationship> extends 
	CobieCollectionService<AttributeCollectionType, AttributeType, Attribute, TRelationship>
{
	protected AttributeService(Connection connection, Class<TRelationship> relationshipClass) throws CobieSQLiteException 
	{
		super(connection, Attribute.class, relationshipClass);
	}
	
	// TODO Finish this!
	@Override
	protected void insertEntity(AttributeType attributeType, Attribute attribute, DatabaseKey parentKey) throws CobieSQLiteException
    {					
		getExecutor().insertValidKey(attribute, Attribute.ColumnName.RefValue.toString(), getExecutor().insertValue(attributeType.getAttributeValue()));
					
		getExecutor().insertValidEntity(attribute, Attribute.ColumnName.AttributeCategory.toString(), attributeType.getAttributeCategory());
		getExecutor().insertValidEntity(attribute, Attribute.ColumnName.AttributeDescription.toString(), attributeType.getAttributeDescription());
		getExecutor().insertValidEntity(attribute, Attribute.ColumnName.AttributeName.toString(), attributeType.getAttributeName());
		getExecutor().insertValidEntity(attribute, Attribute.ColumnName.propertySetExternalIdentifier.toString(), attributeType.getPropertySetExternalIdentifier());
		getExecutor().insertValidEntity(attribute, Attribute.ColumnName.propertySetName.toString(), attributeType.getPropertySetName());
		
		super.insertEntity(attributeType, attribute, parentKey);
    }
}
