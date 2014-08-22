package org.erdc.cobie.shared.cobietab.transformation.cobielite;

import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.shared.cobietab.AttributesDocumentsIssues;
import org.erdc.cobie.shared.cobietab.IndexedCOBie;
import org.erdc.cobie.sheetxmldata.ContactType;

public class ContactTransformer extends COBieTabTransformer<ContactType, org.buildingsmartalliance.docs.nbims03.cobie.cobielite.ContactType>
{

    public ContactTransformer(ContactType cobieSheetXMLData, org.buildingsmartalliance.docs.nbims03.cobie.cobielite.ContactType cobieLiteRowData, IndexedCOBie indexedCOBie)
    {
        super(cobieSheetXMLData, cobieLiteRowData, indexedCOBie);
    }

    @Override
    protected AttributesDocumentsIssues findDescriptiveDataRows()
    {
        AttributesDocumentsIssues descriptiveData = indexedCOBie.getDescriptiveElementIndex().getDescriptiveDataBySheetNameRowName(
                cobieSpreadsheetName, source.getEmail());
        return descriptiveData;
    }

    @Override
    protected void parseAttributes() throws Exception
    {
        AttributeDocumentIssueHelper.parseAttributes(target.addNewContactAttributes(), descriptiveData, indexedCOBie);

    }

    @Override
    protected void parseComplexElements()
    {
        // NOTHING TO DO

    }

    @Override
    protected void parseDocuments() throws Exception
    {
        AttributeDocumentIssueHelper.parseDocuments(target.addNewContactDocuments(), descriptiveData, indexedCOBie);

    }

    @Override
    protected void parseIssues() throws Exception
    {
        AttributeDocumentIssueHelper.parseIssues(target.addNewContactIssues(), descriptiveData, indexedCOBie);

    }

    @Override
    protected void parseSimpleElements()
    {
    	if(!COBieUtility.isNA(source.getCompany()))
    		target.setContactCompanyName(source.getCompany());
    	if(!COBieUtility.isNA(source.getCategory()))
    		target.setContactCategory(source.getCategory());
    	if(!COBieUtility.isNA(source.getCountry()))
    		target.setContactCountryName(source.getCountry());
    	if(!COBieUtility.isNA(source.getDepartment()))
    		target.setContactDepartmentName(source.getDepartment());
    	if(!COBieUtility.isNA(source.getEmail()))
    		target.setContactEmail(source.getEmail());
    	if(!COBieUtility.isNA(source.getFamilyName()))
    		target.setContactFamilyName(source.getFamilyName());
    	if(!COBieUtility.isNA(source.getGivenName()))
    		target.setContactGivenName(source.getGivenName());
    	if(!COBieUtility.isNA(source.getPhone()))
    		target.setContactPhoneNumber(source.getPhone());
    	if(!COBieUtility.isNA(source.getPostalBox()))
    		target.setContactPostalBoxNumber(source.getPostalBox());
    	if(!COBieUtility.isNA(source.getPostalCode()))
    		target.setContactPostalCode(source.getPostalCode());
    	if(!COBieUtility.isNA(source.getStateRegion()))
    		target.setContactRegionCode(source.getStateRegion());
    	if(!COBieUtility.isNA(source.getStreet()))
    		target.setContactStreet(source.getStreet());
    	if(!COBieUtility.isNA(source.getStreet()))
    		target.setContactTownName(source.getStreet());
    	if(!COBieUtility.isNA(source.getExternalObject()))
    		target.setExternalEntityName(source.getExternalObject());
    	if(!COBieUtility.isNA(source.getExternalIdentifier()))
    		target.setExternalID(source.getExternalIdentifier());
    	if(!COBieUtility.isNA(source.getExternalSystem()))
    		target.setExternalSystemName(source.getExternalSystem());
    }

}
