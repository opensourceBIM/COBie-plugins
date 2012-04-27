package org.bimserver.cobie.utils.deserializer;

import java.util.Calendar;
import java.util.Date;

import org.bimserver.cobie.cobielite.ContactType;
import org.bimserver.cobie.plugins.COBieIfcModel;
import org.bimserver.cobie.utils.stringwriters.DeserializerStaticStrings;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.IfcActorRole;
import org.bimserver.models.ifc2x3tc1.IfcApplication;
import org.bimserver.models.ifc2x3tc1.IfcOrganization;
import org.bimserver.models.ifc2x3tc1.IfcOwnerHistory;
import org.bimserver.models.ifc2x3tc1.IfcPerson;
import org.bimserver.models.ifc2x3tc1.IfcPersonAndOrganization;
import org.bimserver.models.ifc2x3tc1.IfcPostalAddress;
import org.bimserver.models.ifc2x3tc1.IfcTelecomAddress;
import org.bimserver.plugins.serializers.OidProvider;


public class OwnerHistoryHandler
{
	protected static int creationDateFromCalendar(Calendar createdOn)
	{
		long milliSecondsSince1970 = createdOn.getTime().getTime();
		int secondsSince1970 = (int) (milliSecondsSince1970 / 1000);
		return secondsSince1970;
	}
	private long ApplicationOid;
	private OidProvider CobieOidProvider;
	private long DefaultOwnerHistoryOid;
	private COBieIfcModel model;
	private long OrganizationOid;
	private int transformTimestamp;
	
	public OwnerHistoryHandler(COBieIfcModel model,OidProvider cobieOidProvider)
	{
		this.model = model;
		this.CobieOidProvider = cobieOidProvider;
		init();
	}
	
	public IfcOwnerHistory DefaultOwnerHistory()
	{
		return (IfcOwnerHistory) model.get(this.DefaultOwnerHistoryOid);
	}
	
	public int ifcTimestampFromCalendar(Calendar calendar)
	{
		int timeIfc = (int) (calendar.getTimeInMillis() / 1000);
		return timeIfc;
	}
	
	public IfcOwnerHistory ownerHistoryFromEmailAndTimestamp(String email,
			Calendar timestamp)
	{
		int timeIfc = this.transformTimestamp;
		IfcOwnerHistory ownerHistory =
				model.getOwnerHistory(email);
		IfcPersonAndOrganization personOrg = model.getContact(email);
		if (timestamp != null)
		{
			int tmpDerivedTimestamp = ifcTimestampFromCalendar(timestamp);
			if (tmpDerivedTimestamp > 0)
				timeIfc = ifcTimestampFromCalendar(timestamp);
		}

		if (ownerHistory == null)
		{
			if (personOrg ==null)
				ownerHistory = DefaultOwnerHistory();
			else
			{
				ownerHistory = Ifc2x3tc1Factory.eINSTANCE
				.createIfcOwnerHistory();
				ownerHistory.setOwningApplication((IfcApplication) model
						.get(this.ApplicationOid));
				ownerHistory.setCreationDate(timeIfc);;
				ownerHistory.setOwningUser(personOrg);
				model.add(ownerHistory, CobieOidProvider);
			}
		}
		return ownerHistory;
	}
	
	public void contactToPersonOrgAndOwnerHistory(ContactType contact) throws Exception
	{
		String email;
		email = contact.getEmail();
		if (!model.containsContact(email))
		{
			contact.getCreatedBy();
			contact.getCreatedOn();
			IfcPerson person = ContactDeserializer.personFromContact(contact);
			IfcOrganization org = ContactDeserializer
					.organizationFromContact(contact);
			IfcTelecomAddress telecommAddress = ContactDeserializer
					.telecommAddressFromContact(contact);
			org.getAddresses().add(telecommAddress);
			IfcPersonAndOrganization personOrg = Ifc2x3tc1Factory.eINSTANCE
					.createIfcPersonAndOrganization();
			IfcActorRole actorRole = ContactDeserializer
					.actorRoleFromContact(contact);
			org.getRoles().add(actorRole);
			personOrg.setTheOrganization(org);
			personOrg.setThePerson(person);
			model.add(person, CobieOidProvider);
			model.add(telecommAddress, CobieOidProvider);
			model.add(actorRole, CobieOidProvider);
			model.add(org, CobieOidProvider);
			model.add(personOrg, CobieOidProvider);

		}
	}
	
	private String getCOBieOrganizationDescription()
	{
		return DeserializerStaticStrings.getCOBieOrgDescription();
	}
	
	private String getCOBieOrganizationId()
	{
		return DeserializerStaticStrings.getCOBieOrgId();
	}
	
	private String getCOBieOrganizationName()
	{
		return DeserializerStaticStrings.getCOBieOrgName();
	}
	
	private IfcOrganization getDefaultApplicationOrganization()
	{
		IfcOrganization organization = Ifc2x3tc1Factory.eINSTANCE
				.createIfcOrganization();
		organization.setName(getCOBieOrganizationName());
		organization.setId(getCOBieOrganizationId());
		organization.setDescription(getCOBieOrganizationDescription());
		return organization;
	}
	
	private void init()
	{		
		initializeApplicationAndOrganization();
		initializeDefaultOwnerHistory();
		Date tmpDate = new Date();
		long msSince1970 = tmpDate.getTime();
		transformTimestamp = (int) (msSince1970 / 1000);
	}

	private void initializeApplicationAndOrganization()
	{
		IfcApplication application = Ifc2x3tc1Factory.eINSTANCE
				.createIfcApplication();
		application.setApplicationFullName(DeserializerStaticStrings
				.getDefaultApplicationName());
		IfcOrganization tmpOrg = this.getDefaultApplicationOrganization();
		application.setApplicationDeveloper(tmpOrg);
		IfcTelecomAddress emailAndPhone = Ifc2x3tc1Factory.eINSTANCE
				.createIfcTelecomAddress();
		emailAndPhone.getElectronicMailAddresses().add(
				DeserializerStaticStrings.getDefaultEmail());
		emailAndPhone.getTelephoneNumbers().add(
				DeserializerStaticStrings.getDefaultPhone());
		emailAndPhone
				.setWWWHomePageURL(DeserializerStaticStrings.getDefaultWWW());
		model.add(emailAndPhone, CobieOidProvider);
		tmpOrg.getAddresses().add(emailAndPhone);
		IfcPostalAddress postalAddress = Ifc2x3tc1Factory.eINSTANCE
				.createIfcPostalAddress();
		postalAddress
				.setCountry(DeserializerStaticStrings.getDefaultOrgCountry());
		postalAddress.setPostalBox(DeserializerStaticStrings
				.getDefaultOrgPostalBox());
		postalAddress.setRegion(DeserializerStaticStrings.getDefaultState());
		postalAddress.setPostalCode(DeserializerStaticStrings
				.getDefaultPostalCode());
		model.add(postalAddress, CobieOidProvider);
		tmpOrg.getAddresses().add(postalAddress);
		this.OrganizationOid = model.add(tmpOrg, CobieOidProvider);
		this.ApplicationOid = model.add(application, CobieOidProvider);
	}
	
	private void initializeDefaultOwnerHistory()
	{
		long tmpOid;
		IfcOwnerHistory ownerHistory = Ifc2x3tc1Factory.eINSTANCE
				.createIfcOwnerHistory();
		IfcOrganization theOrg = (IfcOrganization) model.get(OrganizationOid);
		IfcApplication theApplication = (IfcApplication) model
				.get(ApplicationOid);
		IfcPersonAndOrganization personOrg = Ifc2x3tc1Factory.eINSTANCE
				.createIfcPersonAndOrganization();
		IfcPerson person = Ifc2x3tc1Factory.eINSTANCE.createIfcPerson();
		person.setFamilyName(theOrg.getName());
		person.setGivenName(theOrg.getName());
		tmpOid = model.add(person, CobieOidProvider);
		personOrg.setTheOrganization(theOrg);
		personOrg.setThePerson((IfcPerson) model.get(tmpOid));
		tmpOid = model.add(personOrg, this.CobieOidProvider);
		ownerHistory.setOwningApplication(theApplication);
		ownerHistory.setOwningUser((IfcPersonAndOrganization) model.get(tmpOid));
		ownerHistory.setCreationDate(transformTimestamp);
		this.DefaultOwnerHistoryOid = model.add(ownerHistory, CobieOidProvider);

	}
	
	
	
	
	
}
