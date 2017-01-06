package org.bimserver.cobie.shared.serialization.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.bimserver.cobie.shared.serialization.IfcCobieSerializer;
import org.bimserver.cobie.shared.utility.COBieIfcUtility;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.ifc2x3tc1.IfcOrganization;
import org.bimserver.models.ifc2x3tc1.IfcOwnerHistory;
import org.bimserver.models.ifc2x3tc1.IfcPerson;
import org.bimserver.models.ifc2x3tc1.IfcPersonAndOrganization;
import org.bimserver.models.ifc2x3tc1.IfcPostalAddress;
import org.nibs.cobie.tab.COBIEType;
import org.nibs.cobie.tab.COBIEType.Contacts;
import org.nibs.cobie.tab.ContactType;

import com.prairiesky.transform.cobieifc.settings.SettingsType;

public class IfcPersonOrganizationContactsSerializer extends IfcCobieSerializer<ContactType, COBIEType.Contacts, IfcPersonAndOrganization>
{

    public IfcPersonOrganizationContactsSerializer(Contacts cobieSection, IfcModelInterface model, SettingsType settings)
    {
        super(cobieSection, model, settings);
    }

    @Override
    protected List<IfcPersonAndOrganization> getTopLevelModelObjects()
    {
        return model.getAll(IfcPersonAndOrganization.class);
    }

    @Override
    protected List<ContactType> serializeModelObject(IfcPersonAndOrganization modelObject)
    {
        List<ContactType> contacts = new ArrayList<ContactType>();
        String contactEmail = "";
        String contactCreatedBy = "";
        String contactFamilyName;
        String contactGivenName;
        String contactCategory;
        String contactCompany;
        String contactStreet;
        String contactPostalBox;
        String contactTown;
        String contactStateRegion;
        String contactPostalCode;
        String contactCountry;
        String contactPhone;
        String contactExternalSystem;
        String contactExternalObject;
        String contactDepartment;
        String contactOrganizationCode;

        IfcPerson person = modelObject.getThePerson();
        IfcOrganization org = modelObject.getTheOrganization();
        IfcOwnerHistory ownerHistory = IfcToContact.getLatestOwnerHistory(model);
        int creationDate = ownerHistory.getCreationDate();
        IfcPostalAddress postalAddress = IfcToContact.personOrganizationPostalAddress(modelObject);

        Calendar cal = IfcToContact.getCreatedOn(creationDate);
        contactEmail = COBieIfcUtility.getEmailFromPersonAndOrganization(modelObject);
        contactCreatedBy = COBieIfcUtility.getEmailFromOwnerHistory(IfcToContact.getLatestOwnerHistory(model));
        contactCategory = IfcToContact.categoryFromPersonAndOrganization(modelObject);
        contactCompany = IfcToContact.companyFromOrganization(org);
        contactPhone = IfcToContact.phoneFromPersonAndOrganization(modelObject);
        contactExternalSystem = COBieIfcUtility.getApplicationName(ownerHistory);
        contactExternalObject = IfcToContact.getExternalObject;
        contactGivenName = IfcToContact.givenNameFromPerson(person);
        contactFamilyName = IfcToContact.familyNameFromPerson(person);
        contactStreet = IfcToContact.streetFromPostalAddress(postalAddress);
        contactPostalBox = IfcToContact.postalBoxFromPostalAddress(postalAddress);
        contactTown = IfcToContact.townFromPostalAddress(postalAddress);
        contactStateRegion = IfcToContact.stateRegionFromPostalAddress(postalAddress);
        contactPostalCode = IfcToContact.postalCodeFromPostalAddress(postalAddress);
        contactCountry = IfcToContact.countryFromPostalAddress(postalAddress);
        contactDepartment = IfcToContact.departmentFromPostalAddressOrOrganization(modelObject.getTheOrganization(), postalAddress);
        contactOrganizationCode = IfcToContact.orgCodeFromOrganization(modelObject.getTheOrganization());

        ContactType tmpContact = cobieSection.addNewContact();
        tmpContact.setEmail(contactEmail);
        tmpContact.setCreatedBy(contactCreatedBy);
        tmpContact.setCreatedOn(cal);
        tmpContact.setCategory(contactCategory);
        tmpContact.setCompany(contactCompany);
        tmpContact.setPhone(contactPhone);
        tmpContact.setExternalSystem(contactExternalSystem);
        tmpContact.setExternalObject(contactExternalObject);
        tmpContact.setExternalIdentifier(contactEmail);
        tmpContact.setDepartment(contactDepartment);
        tmpContact.setOrganizationCode(contactOrganizationCode);
        tmpContact.setGivenName(contactGivenName);
        tmpContact.setFamilyName(contactFamilyName);
        tmpContact.setStreet(contactStreet);
        tmpContact.setPostalBox(contactPostalBox);
        tmpContact.setTown(contactTown);
        tmpContact.setStateRegion(contactStateRegion);
        tmpContact.setPostalCode(contactPostalCode);
        tmpContact.setCountry(contactCountry);
        contactEmail = "";
        contacts.add(tmpContact);

        return contacts;
    }

}
