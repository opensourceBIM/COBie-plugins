package org.erdc.cobie.cobielite.parsers.sheetxmldata;

import org.erdc.cobie.cobielite.parsers.sheetxmldata.dispatchers.AttributeDocumentIssueHelper;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.shared.cobiesheetxmldata.indices.AttributesDocumentsIssues;
import org.erdc.cobie.shared.cobiesheetxmldata.indices.IndexedCOBie;
import org.erdc.cobie.sheetxmldata.ContactType;

public class ContactParser extends COBieLiteSheetXMLDataParser<ContactType, org.buildingsmartalliance.docs.nbims03.cobie.cobielite.ContactType>
{

    public ContactParser(ContactType cobieSheetXMLData, org.buildingsmartalliance.docs.nbims03.cobie.cobielite.ContactType cobieLiteRowData, IndexedCOBie indexedCOBie)
    {
        super(cobieSheetXMLData, cobieLiteRowData, indexedCOBie);
    }

    @Override
    protected AttributesDocumentsIssues findDescriptiveDataRows()
    {
        AttributesDocumentsIssues descriptiveData = indexedCOBie.getDescriptiveElementIndex().getDescriptiveDataBySheetNameRowName(
                cobieSpreadsheetName, sourceCOBie.getEmail());
        return descriptiveData;
    }

    @Override
    protected void parseAttributes() throws Exception
    {
        AttributeDocumentIssueHelper.parseAttributes(targetCOBie.addNewContactAttributes(), descriptiveData, indexedCOBie);

    }

    @Override
    protected void parseComplexElements()
    {
        // NOTHING TO DO

    }

    @Override
    protected void parseDocuments() throws Exception
    {
        AttributeDocumentIssueHelper.parseDocuments(targetCOBie.addNewContactDocuments(), descriptiveData, indexedCOBie);

    }

    @Override
    protected void parseIssues() throws Exception
    {
        AttributeDocumentIssueHelper.parseIssues(targetCOBie.addNewContactIssues(), descriptiveData, indexedCOBie);

    }

    @Override
    protected void parseSimpleElements()
    {
    	if(!COBieUtility.isNA(sourceCOBie.getCompany()))
    		targetCOBie.setContactCompanyName(sourceCOBie.getCompany());
    	if(!COBieUtility.isNA(sourceCOBie.getCategory()))
    		targetCOBie.setContactCategory(sourceCOBie.getCategory());
    	if(!COBieUtility.isNA(sourceCOBie.getCountry()))
    		targetCOBie.setContactCountryName(sourceCOBie.getCountry());
    	if(!COBieUtility.isNA(sourceCOBie.getDepartment()))
    		targetCOBie.setContactDepartmentName(sourceCOBie.getDepartment());
    	if(!COBieUtility.isNA(sourceCOBie.getEmail()))
    		targetCOBie.setContactEmail(sourceCOBie.getEmail());
    	if(!COBieUtility.isNA(sourceCOBie.getFamilyName()))
    		targetCOBie.setContactFamilyName(sourceCOBie.getFamilyName());
    	if(!COBieUtility.isNA(sourceCOBie.getGivenName()))
    		targetCOBie.setContactGivenName(sourceCOBie.getGivenName());
    	if(!COBieUtility.isNA(sourceCOBie.getPhone()))
    		targetCOBie.setContactPhoneNumber(sourceCOBie.getPhone());
    	if(!COBieUtility.isNA(sourceCOBie.getPostalBox()))
    		targetCOBie.setContactPostalBoxNumber(sourceCOBie.getPostalBox());
    	if(!COBieUtility.isNA(sourceCOBie.getPostalCode()))
    		targetCOBie.setContactPostalCode(sourceCOBie.getPostalCode());
    	if(!COBieUtility.isNA(sourceCOBie.getStateRegion()))
    		targetCOBie.setContactRegionCode(sourceCOBie.getStateRegion());
    	if(!COBieUtility.isNA(sourceCOBie.getStreet()))
    		targetCOBie.setContactStreet(sourceCOBie.getStreet());
    	if(!COBieUtility.isNA(sourceCOBie.getStreet()))
    		targetCOBie.setContactTownName(sourceCOBie.getStreet());
    	if(!COBieUtility.isNA(sourceCOBie.getExternalObject()))
    		targetCOBie.setExternalEntityName(sourceCOBie.getExternalObject());
    	if(!COBieUtility.isNA(sourceCOBie.getExternalIdentifier()))
    		targetCOBie.setExternalID(sourceCOBie.getExternalIdentifier());
    	if(!COBieUtility.isNA(sourceCOBie.getExternalSystem()))
    		targetCOBie.setExternalSystemName(sourceCOBie.getExternalSystem());
    }

}
