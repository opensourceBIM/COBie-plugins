package org.erdc.cobie.shared.bimserver.ifc.serialization.cobietab;

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

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.ifc2x3tc1.IfcActorRole;
import org.bimserver.models.ifc2x3tc1.IfcAddress;
import org.bimserver.models.ifc2x3tc1.IfcOrganization;
import org.bimserver.models.ifc2x3tc1.IfcOrganizationRelationship;
import org.bimserver.models.ifc2x3tc1.IfcOwnerHistory;
import org.bimserver.models.ifc2x3tc1.IfcPerson;
import org.bimserver.models.ifc2x3tc1.IfcPersonAndOrganization;
import org.bimserver.models.ifc2x3tc1.IfcPostalAddress;
import org.bimserver.models.ifc2x3tc1.IfcRoleEnum;
import org.bimserver.models.ifc2x3tc1.IfcTelecomAddress;
import org.bimserver.models.ifc2x3tc1.impl.IfcPostalAddressImpl;
import org.bimserver.models.ifc2x3tc1.impl.IfcTelecomAddressImpl;
import org.eclipse.emf.common.util.EList;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.shared.COBieUtility.CobieSheetName;
import org.erdc.cobie.shared.bimserver.COBieIfcUtility;
import org.erdc.cobie.shared.bimserver.OwnerHistoryList;
import org.erdc.cobie.sheetxmldata.COBIEType;
import org.erdc.cobie.sheetxmldata.ContactType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IfcToContact
{
    private static CobieSheetName SheetName = CobieSheetName.Contact;
    private static final Logger LOGGER = LoggerFactory.getLogger(IfcToContact.class);
    static protected final String getExternalObject = IfcPersonAndOrganization.class.getSimpleName();

    static public String categoryFromActorRole(IfcActorRole role)
    {
        String category = "";
        if ((role != null) && (role.getRole() != null))
        {
            if (role.getRole().getLiteral() == IfcRoleEnum.USERDEFINED.getLiteral())
            {
                category = role.getUserDefinedRole();
            } else
            {
                category = role.getRole().toString();
            }
        }
        return COBieUtility.getCOBieString(category);
    }

    static protected String categoryFromPerson(IfcPerson person)
    {
        String contactCategory = "";
        for (IfcActorRole role : person.getRoles())
        {
            if (role.getRole() != null)
            {
                contactCategory += role.getRole().toString() + ",";
            }
        }
        if (contactCategory.endsWith(","))
        {
            contactCategory = contactCategory.substring(0, contactCategory.length() - 2);
        }
        return COBieUtility.getCOBieString(contactCategory);
    }

    static protected String categoryFromPersonAndOrganization(IfcPersonAndOrganization personOrg)
    {
        String contactCategory = "";
        IfcPerson person = personOrg.getThePerson();
        IfcOrganization org = personOrg.getTheOrganization();
        ArrayList<String> roleStrings = new ArrayList<String>();
        setPersonOrganizationRoleStrings(personOrg, roleStrings);
        setPersonRoleStrings(person, roleStrings);
        setOrganizationRoleStrings(org, roleStrings);
        contactCategory = COBieUtility.delimittedStringFromArrayList(roleStrings, false, false);
        return COBieUtility.getCOBieString(contactCategory);
    }

    static protected String companyFromOrganization(IfcOrganization org)
    {
        String orgName = "";
        if ((org != null) && (org.getName() != null))
        {
            orgName = org.getName();
        }
        return COBieUtility.getCOBieString(orgName);
    }

    static protected String countryFromPostalAddress(IfcPostalAddress address)
    {
        String country = "";
        if (address != null)
        {
            country = address.getCountry();
        }
        return COBieUtility.getCOBieString(country);
    }

    static protected String departmentFromPostalAddress(IfcPostalAddress postalAddress)
    {
        String department = "";
        if ((postalAddress != null) && postalAddress.isSetInternalLocation())
        {
            department = postalAddress.getInternalLocation();
        }
        return COBieUtility.getCOBieString(department);
    }

    public static String departmentFromPostalAddressOrOrganization(IfcOrganization theOrganization, IfcPostalAddress postalAddress)
    {
        String department = "";
        if (postalAddress != null)
        {
            if (postalAddress.isSetInternalLocation())
            {
                department = postalAddress.getInternalLocation();
            }
        }
        if (theOrganization.isSetIsRelatedBy())
        {
            for (IfcOrganizationRelationship organizationRelationship : theOrganization.getRelates())
            {
                for (IfcOrganization organization : organizationRelationship.getRelatedOrganizations())
                {
                    department = organization.getName();
                }
            }
        }
        if (COBieUtility.isNA(department) && (theOrganization != null))
        {
            department = theOrganization.getDescription();
        }
        return COBieUtility.getCOBieString(department);
    }

    static protected String familyNameFromPerson(IfcPerson person)
    {
        String familyName = "";
        familyName = person.getFamilyName();
        return COBieUtility.getCOBieString(familyName);
    }

    protected static Calendar getCreatedOn(int ifcTimestamp)
    {
        Calendar cal = new org.apache.xmlbeans.XmlCalendar();
        cal = COBieUtility.ifcTimeStampAsCalendar(ifcTimestamp);
        /*
         * if (ifcTimestamp>0) { cal =
         * COBieUtility.ifcTimeStampAsCalendar(ifcTimestamp); } else cal =
         * COBieUtility.getDefaultCalendar();
         */
        return cal;
    }

    protected static IfcOwnerHistory getLatestOwnerHistory(IfcModelInterface model)
    {
        IfcOwnerHistory firstIfcOwnerHistory = null;
        OwnerHistoryList histories = new OwnerHistoryList(model.getAll(IfcOwnerHistory.class));
        histories.sort();
        if (!histories.isEmpty())
        {
            firstIfcOwnerHistory = histories.get(histories.size() - 1);
        }
        return firstIfcOwnerHistory;
    }

    static protected String givenNameFromPerson(IfcPerson person)
    {
        String givenName = "";
        givenName = person.getGivenName();
        return COBieUtility.getCOBieString(givenName);
    }

    public static String orgCodeFromOrganization(IfcOrganization theOrganization)
    {
        String orgCode = "";
        if (theOrganization != null)
        {
            if (theOrganization.isSetId())
            {
                orgCode = theOrganization.getId();
            }
            if (COBieUtility.isNA(orgCode))
            {
                orgCode = theOrganization.getName();
            }
        }
        return COBieUtility.getCOBieString(orgCode);
    }

    static protected IfcPostalAddress personOrganizationPostalAddress(IfcPersonAndOrganization personOrg)
    {
        IfcPerson person = personOrg.getThePerson();
        IfcOrganization theOrg = personOrg.getTheOrganization();
        EList<IfcAddress> pAddresses = null;
        if (person != null)
        {
            pAddresses = person.getAddresses();
        }
        EList<IfcAddress> oAddresses = null;
        if (theOrg != null)
        {
            oAddresses = theOrg.getAddresses();
        }
        for (IfcAddress address : pAddresses)
        {
            if (address.getClass() == IfcPostalAddressImpl.class)
            {
                return (IfcPostalAddress)address;
            }
        }
        for (IfcAddress address : oAddresses)
        {
            if (address.getClass() == IfcPostalAddressImpl.class)
            {
                return (IfcPostalAddress)address;
            }
        }

        return null;
    }

    static protected String phoneFromPersonAndOrganization(IfcPersonAndOrganization personOrg)
    {
        String phone = "";
        IfcPerson person = personOrg.getThePerson();
        IfcOrganization theOrg = personOrg.getTheOrganization();
        EList<IfcAddress> pAddresses = null;
        if (person != null)
        {
            pAddresses = person.getAddresses();
        }
        EList<IfcAddress> oAddresses = null;
        if (theOrg != null)
        {
            oAddresses = theOrg.getAddresses();
        }
        if ((pAddresses != null) && !pAddresses.isEmpty())
        {
            for (IfcAddress address : pAddresses)
            {
                if ((phone.length() == 0) && (address.getClass() == IfcTelecomAddressImpl.class))
                {
                    IfcTelecomAddress tAddress = (IfcTelecomAddress)address;
                    if (tAddress.getTelephoneNumbers().size() > 0)
                    {
                        phone = tAddress.getTelephoneNumbers().get(0).toString();
                    }
                }
            }
        } else if ((phone.length() == 0) && (oAddresses != null) && !oAddresses.isEmpty())
        {
            for (IfcAddress address : oAddresses)
            {
                if ((phone.length() == 0) && (address.getClass() == IfcTelecomAddressImpl.class))
                {
                    IfcTelecomAddress tAddress = (IfcTelecomAddress)address;
                    if (tAddress.getTelephoneNumbers().size() > 0)
                    {
                        phone = tAddress.getTelephoneNumbers().get(0).toString();
                    }
                }
            }
        }
        return COBieUtility.getCOBieString(phone);
    }

    public static String postalBoxFromPostalAddress(IfcPostalAddress postalAddress)
    {
        String postalBox = "";
        if ((postalAddress != null) && postalAddress.isSetPostalBox())
        {
            postalBox = postalAddress.getPostalBox();
        }
        return COBieUtility.getCOBieString(postalBox);
    }

    static protected String postalCodeFromPostalAddress(IfcPostalAddress address)
    {
        String postalCode = "";
        if (address != null)
        {
            postalCode = address.getPostalCode();
        }
        return COBieUtility.getCOBieString(postalCode);
    }

    private static void setOrganizationRoleStrings(IfcOrganization org, ArrayList<String> roleStrings)
    {
        if ((org != null) && org.isSetRoles())
        {
            for (IfcActorRole role : org.getRoles())
            {
                roleStrings.add(categoryFromActorRole(role));
            }
        }
    }

    private static void setPersonOrganizationRoleStrings(IfcPersonAndOrganization personOrg, ArrayList<String> roleStrings)
    {
        if ((personOrg != null) && personOrg.isSetRoles())
        {
            for (IfcActorRole role : personOrg.getRoles())
            {
                roleStrings.add(categoryFromActorRole(role));
            }
        }
    }

    private static void setPersonRoleStrings(IfcPerson person, ArrayList<String> roleStrings)
    {
        if ((person != null) && person.isSetRoles())
        {
            for (IfcActorRole role : person.getRoles())
            {
                roleStrings.add(categoryFromActorRole(role));
            }
        }
    }

    static protected String stateRegionFromPostalAddress(IfcPostalAddress address)
    {
        String region = "";
        if (address != null)
        {
            region = address.getRegion();
        }
        return COBieUtility.getCOBieString(region);
    }

    static protected String streetFromPostalAddress(IfcPostalAddress address)
    {
        String street = "";
        if (address != null)
        {
            for (String aLine : address.getAddressLines())
            {
                street += aLine + " ";
            }
        }
        return COBieUtility.getCOBieString(street);
    }

    static protected String townFromPostalAddress(IfcPostalAddress address)
    {
        String town = "";
        if (address != null)
        {
            town = address.getTown();
        }
        return COBieUtility.getCOBieString(town);
    }

    public static COBIEType writeContactsToCOBie(COBIEType cobie, IfcModelInterface model)
    {
        return writePersonOrganizationsToCOBie(cobie, model);
    }

    public static COBIEType writeOwnerHistoriesToCOBie(COBIEType cobie, IfcModelInterface model)
    {

        LogHandler loggerStrings = new LogHandler(SheetName, LOGGER);
        loggerStrings.sheetWriteBegin();
        COBIEType.Contacts contacts;
        if ((cobie.getContacts() == null) || cobie.getContacts().isNil())
        {
            contacts = cobie.addNewContacts();
        } else
        {
            contacts = cobie.getContacts();
        }
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
        String contactDepartment;
        String contactPostalCode;
        String contactCountry;
        String contactPhone;
        String contactExternalSystem;
        String contactExternalObject;
        for (IfcOwnerHistory ownerHistory : model.getAll(IfcOwnerHistory.class))
        {
            try
            {
                IfcPersonAndOrganization owningUser = ownerHistory.getOwningUser();
                IfcPerson person = owningUser.getThePerson();
                IfcOrganization org = owningUser.getTheOrganization();
                int creationDate = ownerHistory.getCreationDate();
                IfcPostalAddress postalAddress = IfcToContact.personOrganizationPostalAddress(owningUser);
                contactDepartment = departmentFromPostalAddress(postalAddress);

                Calendar cal = IfcToContact.getCreatedOn(creationDate);
                contactEmail = COBieIfcUtility.getEmailFromPersonAndOrganization(owningUser);
                contactCreatedBy = COBieIfcUtility.getEmailFromOwnerHistory(IfcToContact.getLatestOwnerHistory(model));
                contactCategory = IfcToContact.categoryFromPersonAndOrganization(owningUser);
                contactCompany = IfcToContact.companyFromOrganization(org);
                if (COBieUtility.isNA(contactDepartment))
                {
                    contactDepartment = contactCompany;
                }

                contactPhone = IfcToContact.phoneFromPersonAndOrganization(owningUser);
                contactExternalSystem = COBieIfcUtility.getApplicationName(ownerHistory);
                contactExternalObject = IfcToContact.getExternalObject;
                contactGivenName = IfcToContact.givenNameFromPerson(person);
                contactFamilyName = IfcToContact.familyNameFromPerson(person);
                contactStreet = IfcToContact.streetFromPostalAddress(postalAddress);
                contactPostalBox = COBieUtility.COBieNA;
                contactTown = IfcToContact.townFromPostalAddress(postalAddress);
                contactStateRegion = IfcToContact.stateRegionFromPostalAddress(postalAddress);
                contactPostalCode = IfcToContact.postalCodeFromPostalAddress(postalAddress);
                contactCountry = IfcToContact.countryFromPostalAddress(postalAddress);

                ContactType tmpContact = contacts.addNewContact();
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
                tmpContact.setOrganizationCode(contactCompany);
                tmpContact.setGivenName(contactGivenName);
                tmpContact.setFamilyName(contactFamilyName);
                tmpContact.setStreet(contactStreet);
                tmpContact.setPostalBox(contactPostalBox);
                tmpContact.setTown(contactTown);
                tmpContact.setStateRegion(contactStateRegion);
                tmpContact.setPostalCode(contactPostalCode);
                tmpContact.setCountry(contactCountry);
                contactEmail = "";
                loggerStrings.rowWritten();

            } catch (Exception ex)
            {
                loggerStrings.error(ex);
            }

        }
        loggerStrings.sheetWritten();
        return cobie;
    }

    public static COBIEType writePersonOrganizationsToCOBie(COBIEType cType, IfcModelInterface model)
    {

        LogHandler loggerStrings = new LogHandler(SheetName, LOGGER);
        loggerStrings.sheetWriteBegin();
        COBIEType.Contacts contacts = cType.addNewContacts();
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
        for (IfcPersonAndOrganization personOrg : model.getAll(IfcPersonAndOrganization.class))
        {
            try
            {
                IfcPerson person = personOrg.getThePerson();
                IfcOrganization org = personOrg.getTheOrganization();
                IfcOwnerHistory ownerHistory = IfcToContact.getLatestOwnerHistory(model);
                int creationDate = ownerHistory.getCreationDate();
                IfcPostalAddress postalAddress = IfcToContact.personOrganizationPostalAddress(personOrg);

                Calendar cal = IfcToContact.getCreatedOn(creationDate);
                contactEmail = COBieIfcUtility.getEmailFromPersonAndOrganization(personOrg);
                contactCreatedBy = COBieIfcUtility.getEmailFromOwnerHistory(IfcToContact.getLatestOwnerHistory(model));
                contactCategory = IfcToContact.categoryFromPersonAndOrganization(personOrg);
                contactCompany = IfcToContact.companyFromOrganization(org);
                contactPhone = IfcToContact.phoneFromPersonAndOrganization(personOrg);
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
                contactDepartment = IfcToContact.departmentFromPostalAddress(postalAddress);
                if (COBieUtility.isNA(contactDepartment))
                {
                    contactDepartment = contactCompany;
                }
                contactOrganizationCode = IfcToContact.orgCodeFromOrganization(personOrg.getTheOrganization());

                ContactType tmpContact = contacts.addNewContact();
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
                loggerStrings.rowWritten();
            } catch (Exception ex)
            {
                loggerStrings.error(ex);
            }
        }

        loggerStrings.sheetWritten();
        return cType;
    }
}
