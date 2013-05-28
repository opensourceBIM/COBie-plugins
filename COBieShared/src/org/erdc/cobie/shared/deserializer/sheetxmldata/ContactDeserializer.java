package org.erdc.cobie.shared.deserializer.sheetxmldata;

/******************************************************************************
 * Copyright (C) 2011  ERDC
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.bimserver.emf.OidProvider;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.IfcActorRole;
import org.bimserver.models.ifc2x3tc1.IfcOrganization;
import org.bimserver.models.ifc2x3tc1.IfcPerson;
import org.bimserver.models.ifc2x3tc1.IfcPersonAndOrganization;
import org.bimserver.models.ifc2x3tc1.IfcPostalAddress;
import org.bimserver.models.ifc2x3tc1.IfcRoleEnum;
import org.bimserver.models.ifc2x3tc1.IfcTelecomAddress;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.shared.deserializer.sheetxmldata.modelhandlers.IfcCommonHandler;
import org.erdc.cobie.shared.deserializer.sheetxmldata.modelhandlers.OwnerHistoryHandler;
import org.erdc.cobie.sheetxmldata.COBIEType;
import org.erdc.cobie.sheetxmldata.ContactType;

public class ContactDeserializer
{
    public static IfcActorRole actorRoleFromContact(ContactType contact)
    {
        IfcActorRole role = Ifc2x3tc1Factory.eINSTANCE.createIfcActorRole();
        role.setRole(IfcRoleEnum.USERDEFINED);
        role.setUserDefinedRole(contact.getCategory());
        return role;
    }

    public static List<IfcActorRole> actorRolesFromContact(ContactType contact)
    {

        List<IfcActorRole> roles = new ArrayList<IfcActorRole>();
        ArrayList<String> roleStrings = COBieUtility.arrayListFromDelimString(contact.getCategory());
        for (String roleString : roleStrings)
        {
            IfcActorRole role = Ifc2x3tc1Factory.eINSTANCE.createIfcActorRole();
            role.setRole(IfcRoleEnum.USERDEFINED);
            role.setUserDefinedRole(roleString);
            roles.add(role);
        }
        return roles;
    }

    public static IfcOrganization organizationFromContact(ContactType contact)
    {
        IfcOrganization tmpOrg = Ifc2x3tc1Factory.eINSTANCE.createIfcOrganization();
        String Company = contact.getCompany();
        String Department = contact.getDepartment();
        String OrganizationCode = contact.getOrganizationCode();
        tmpOrg.setName(Company);
        tmpOrg.setId(OrganizationCode);
        tmpOrg.setDescription(Department);
        return tmpOrg;
    }

    public static IfcPerson personFromContact(ContactType contact)
    {
        IfcPerson tmpPerson = Ifc2x3tc1Factory.eINSTANCE.createIfcPerson();
        String GivenName = contact.getGivenName();
        String FamilyName = contact.getFamilyName();
        tmpPerson.setFamilyName(FamilyName);
        tmpPerson.setGivenName(GivenName);
        tmpPerson.setId(contact.getExternalIdentifier());
        return tmpPerson;
    }

    public static IfcPostalAddress postalAddressFromContact(ContactType contact)
    {
        IfcPostalAddress postalAddress = Ifc2x3tc1Factory.eINSTANCE.createIfcPostalAddress();
        postalAddress.getAddressLines().add(contact.getStreet());
        postalAddress.setPostalBox(contact.getPostalBox());
        postalAddress.setTown(contact.getTown());
        postalAddress.setRegion(contact.getStateRegion());
        postalAddress.setPostalCode(contact.getPostalCode());
        postalAddress.setCountry(contact.getCountry());
        postalAddress.setInternalLocation(contact.getDepartment());
        return postalAddress;

    }

    public static IfcTelecomAddress telecommAddressFromContact(ContactType contact)
    {
        IfcTelecomAddress telecommAddress = Ifc2x3tc1Factory.eINSTANCE.createIfcTelecomAddress();
        telecommAddress.getElectronicMailAddresses().add(contact.getEmail());
        telecommAddress.getTelephoneNumbers().add(contact.getPhone());
        return telecommAddress;
    }

    private COBIEType.Contacts contacts;

    private COBieIfcModel model;

    private OidProvider<Long> oidProvider;

    private OwnerHistoryHandler ownerHistoryProvider;

    public ContactDeserializer(COBIEType.Contacts contacts, COBieIfcModel cobieIfcModel, IfcCommonHandler ifcCommonHandler)
    {
        this.contacts = contacts;
        model = cobieIfcModel;
        ifcCommonHandler.getGuidHandler();
        oidProvider = ifcCommonHandler.getOidProvider();
        ownerHistoryProvider = ifcCommonHandler.getOwnerHistoryHandler();
    }

    public void contactToPersonOrgAndOwnerHistory(ContactType contact) throws Exception
    {
        String email;
        String createdBy;
        Calendar createdOn;
        email = contact.getEmail();
        if (!model.containsContact(email))
        {
            createdBy = contact.getCreatedBy();
            createdOn = contact.getCreatedOn();
            IfcPerson person = ContactDeserializer.personFromContact(contact);
            IfcOrganization org = ContactDeserializer.organizationFromContact(contact);
            IfcTelecomAddress telecommAddress = ContactDeserializer.telecommAddressFromContact(contact);
            org.getAddresses().add(telecommAddress);
            IfcPersonAndOrganization personOrg = Ifc2x3tc1Factory.eINSTANCE.createIfcPersonAndOrganization();
            IfcPostalAddress postalAddress = postalAddressFromContact(contact);
            List<IfcActorRole> actorRoles = ContactDeserializer.actorRolesFromContact(contact);
            personOrg.setTheOrganization(org);
            personOrg.setThePerson(person);
            model.add(telecommAddress, oidProvider);
            model.add(postalAddress, oidProvider);
            for (IfcActorRole actorRole : actorRoles)
            {
                model.add(actorRole, oidProvider);
            }
            for (IfcActorRole actorRole : actorRoles)
            {
                person.getRoles().add(actorRole);
            }
            person.getAddresses().add(telecommAddress);
            person.getAddresses().add(postalAddress);
            model.add(person, oidProvider);
            for (IfcActorRole actorRole : actorRoles)
            {
                org.getRoles().add(actorRole);
            }
            org.getAddresses().add(telecommAddress);
            org.getAddresses().add(postalAddress);
            model.add(org, oidProvider);
            for (IfcActorRole actorRole : actorRoles)
            {
                personOrg.getRoles().add(actorRole);
            }
            model.add(personOrg, oidProvider);
            if (model.containsContact(createdBy) && !model.containsCreatedBy(createdBy))
            {
                ownerHistoryProvider.ownerHistoryFromEmailTimestampAndApplication(createdBy, createdOn, contact.getExternalSystem());
            }

        }
    }

    public void deserializeContacts()
    {
        try
        {
            if ((contacts != null) && (contacts.getContactArray() != null))
            {
                for (ContactType contact : contacts.getContactArray())
                {
                    contactToPersonOrgAndOwnerHistory(contact);
                }
            }
        } catch (Exception ex)
        {
        }
    }

}
