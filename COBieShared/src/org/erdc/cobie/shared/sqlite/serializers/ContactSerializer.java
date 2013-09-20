package org.erdc.cobie.shared.sqlite.serializers;

import java.sql.Connection;

import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.ContactType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.ContactCollectionType;
import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.entities.Contact;
import org.erdc.cobie.sqlite.entities.relationships.FacilityContact;

public class ContactSerializer extends CobieCollectionSerializer<ContactCollectionType, 
																	ContactType, 
																	Contact, 
																	FacilityContact> 
{
	private static IntegerKey key = new IntegerKey();
	
	public ContactSerializer(Connection connection,
									Class<Contact> entityClass,
									Class<FacilityContact> relationshipClass) throws CobieSQLiteException 
	{
		super(connection, entityClass, relationshipClass);
	}

	@Override
	protected IntegerKey getKey() 
	{
		return key;
	}

	@Override
	protected void insertEntity(ContactType contactType, Contact contact,  int parentID) throws CobieSQLiteException 
	{
		super.insertEntity(contactType, contact, parentID);
		
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
	}
	
	@Override
    protected void insertRelationship(FacilityContact facilityContact, int facilityID) throws CobieSQLiteException
    {   	
		getExecutor().insertValidKey(facilityContact, FacilityContact.ColumnName.RefContact.toString(), getKey().get());
		getExecutor().insertValidKey(facilityContact, FacilityContact.ColumnName.RefFacility.toString(), facilityID);
    }
}
