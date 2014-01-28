package org.erdc.cobie.sqlite.service;

import java.sql.Connection;

import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.ContactType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.ContactCollectionType;
import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.entity.Contact;
import org.erdc.cobie.sqlite.entity.relationship.FacilityContact;

public class ContactService extends CobieCollectionService<ContactCollectionType, 
															ContactType, 
															Contact, 
															FacilityContact> 
{	
	public ContactService(Connection connection,
							Class<Contact> entityClass,
							Class<FacilityContact> relationshipClass) throws CobieSQLiteException 
	{
		super(connection, entityClass, relationshipClass);
	}

	@Override
	protected void insertEntity(ContactType contactType, Contact contact,  DatabaseKey facilityKey) throws CobieSQLiteException 
	{		
		getExecutor().insertValidEntity(contact, Contact.ColumnName.ContactCategory.toString(), contactType.getContactCategory());
		getExecutor().insertValidEntity(contact, Contact.ColumnName.ContactCompanyName.toString(), contactType.getContactCompanyName());
		getExecutor().insertValidEntity(contact, Contact.ColumnName.ContactCountryName.toString(), contactType.getContactCountryName());
		getExecutor().insertValidEntity(contact, Contact.ColumnName.ContactDepartmentName.toString(), contactType.getContactDepartmentName());
		getExecutor().insertValidEntity(contact, Contact.ColumnName.ContactEmail.toString(), contactType.getContactEmail());
		getExecutor().insertValidEntity(contact, Contact.ColumnName.ContactFamilyName.toString(), contactType.getContactFamilyName());
		getExecutor().insertValidEntity(contact, Contact.ColumnName.ContactGivenName.toString(), contactType.getContactGivenName());
		getExecutor().insertValidEntity(contact, Contact.ColumnName.ContactPhoneNumber.toString(), contactType.getContactPhoneNumber());
		getExecutor().insertValidEntity(contact, Contact.ColumnName.ContactPostalBoxNumber.toString(), contactType.getContactPostalBoxNumber());
		getExecutor().insertValidEntity(contact, Contact.ColumnName.ContactPostalCode.toString(), contactType.getContactPostalCode());
		getExecutor().insertValidEntity(contact, Contact.ColumnName.ContactRegionCode.toString(), contactType.getContactRegionCode());
		getExecutor().insertValidEntity(contact, Contact.ColumnName.ContactStreet.toString(), contactType.getContactStreet());
		getExecutor().insertValidEntity(contact, Contact.ColumnName.ContactTownName.toString(), contactType.getContactTownName());
		getExecutor().insertValidEntity(contact, Contact.ColumnName.ContactURL.toString(), contactType.getContactURL());
		
		super.insertEntity(contactType, contact, facilityKey);
	}
	
	@Override
    protected void insertRelationship(FacilityContact facilityContact, DatabaseKey facilityKey) throws CobieSQLiteException
    {   	
		getExecutor().insertValidKey(facilityContact, FacilityContact.ColumnName.RefContact.toString(), getKey().get());
		getExecutor().insertValidKey(facilityContact, FacilityContact.ColumnName.RefFacility.toString(), facilityKey.get());
		
		super.insertRelationship(facilityContact, facilityKey);
    }
}
