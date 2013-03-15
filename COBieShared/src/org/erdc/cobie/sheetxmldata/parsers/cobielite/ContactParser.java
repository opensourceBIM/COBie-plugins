package org.erdc.cobie.sheetxmldata.parsers.cobielite;

import org.erdc.cobie.sheetxmldata.ContactType;

public class ContactParser extends COBieLiteSourceParser<org.erdc.cobie.cobielite.ContactType, ContactType>
{

    public ContactParser(org.erdc.cobie.cobielite.ContactType sourceCOBie, ContactType targetCOBie)
    {
        super(sourceCOBie, targetCOBie);
    }

    @Override
    protected void handleExternalData()
    {
        targetCOBie.setExternalIdentifier(externalData.externalIdentifier);
        targetCOBie.setExternalObject(externalData.externalObject);
        targetCOBie.setExternalSystem(externalData.externalSystem);
        
    }

    @Override
    protected void handleInnerException(Exception exception)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected void handleOwnerHistory()
    {
        targetCOBie.setCreatedBy(ownerHistory.CreatedBy);
        targetCOBie.setCreatedOn(ownerHistory.CreatedOn);
        
    }

    @Override
    protected void parseComplexElements()
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected void parseSimpleElements()
    {    
        targetCOBie.setCompany(sourceCOBie.getContactCompanyName());
        targetCOBie.setCountry(sourceCOBie.getContactCountryName());
        targetCOBie.setDepartment(sourceCOBie.getContactDepartmentName());
        targetCOBie.setEmail(sourceCOBie.getContactEmail());
        targetCOBie.setFamilyName(sourceCOBie.getContactFamilyName());
        targetCOBie.setGivenName(sourceCOBie.getContactGivenName());
        targetCOBie.setOrganizationCode(sourceCOBie.getContactDepartmentName());
        targetCOBie.setPhone(sourceCOBie.getContactPhoneNumber());
        targetCOBie.setPostalBox(sourceCOBie.getContactPostalBoxNumber());
        targetCOBie.setPostalCode(sourceCOBie.getContactPostalCode());
        targetCOBie.setStateRegion(sourceCOBie.getContactRegionCode());
        targetCOBie.setStreet(sourceCOBie.getContactStreet());
        targetCOBie.setTown(sourceCOBie.getContactTownName());
    }
    
}
