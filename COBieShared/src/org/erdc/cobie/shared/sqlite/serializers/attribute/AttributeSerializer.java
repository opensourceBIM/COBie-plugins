package org.erdc.cobie.shared.sqlite.serializers.attribute;

import java.sql.Connection;

import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.AttributeType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.AttributeCollectionType;
import org.erdc.cobie.shared.sqlite.serializers.CobieCollectionSerializer;
import org.erdc.cobie.shared.sqlite.serializers.IntegerKey;
import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.entities.Attribute;
import org.erdc.cobie.sqlite.entities.relationships.Relationship;

public abstract class AttributeSerializer<TRelationship extends Relationship> extends 
	CobieCollectionSerializer<AttributeCollectionType, AttributeType, Attribute, TRelationship>
{
	private static IntegerKey key = new IntegerKey();
	
	protected AttributeSerializer(Connection connection, Class<TRelationship> relationshipClass) throws CobieSQLiteException 
	{
		super(connection, Attribute.class, relationshipClass);
	}

	@Override
	protected final IntegerKey getKey()
	{
		return key;
	}
	
	// TODO Finish this!
	protected void insertEntity(AttributeType attributeType, Attribute attribute, int parentID) throws CobieSQLiteException
    {		
		super.insertEntity(attributeType, attribute, parentID);
				
		getExecutor().insertValidKey(attribute, Attribute.ColumnName.RefValue.toString(), getExecutor().insertValue(attributeType.getAttributeValue()));
					
		getExecutor().insertValidEntity(attribute, Attribute.ColumnName.AttributeCategory.toString(), attributeType.getAttributeCategory());
		getExecutor().insertValidEntity(attribute, Attribute.ColumnName.AttributeDescription.toString(), attributeType.getAttributeDescription());
		getExecutor().insertValidEntity(attribute, Attribute.ColumnName.AttributeName.toString(), attributeType.getAttributeName());
		getExecutor().insertValidEntity(attribute, Attribute.ColumnName.propertySetExternalIdentifier.toString(), attributeType.getPropertySetExternalIdentifier());
		getExecutor().insertValidEntity(attribute, Attribute.ColumnName.propertySetName.toString(), attributeType.getPropertySetName());		
    }
}
