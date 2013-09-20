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
        targetCOBie.setContactCompanyName(sourceCOBie.getCompany());
        targetCOBie.setContactCategory(sourceCOBie.getCategory());
        targetCOBie.setContactCountryName(sourceCOBie.getCountry());
        targetCOBie.setContactDepartmentName(sourceCOBie.getDepartment());
        targetCOBie.setContactEmail(sourceCOBie.getEmail());
        targetCOBie.setContactFamilyName(sourceCOBie.getFamilyName());
        targetCOBie.setContactGivenName(sourceCOBie.getGivenName());
        targetCOBie.setContactPhoneNumber(sourceCOBie.getPhone());
        targetCOBie.setContactPostalBoxNumber(sourceCOBie.getPostalBox());
        targetCOBie.setContactPostalCode(sourceCOBie.getPostalCode());
        targetCOBie.setContactRegionCode(sourceCOBie.getStateRegion());
        targetCOBie.setContactStreet(sourceCOBie.getStreet());
        targetCOBie.setContactTownName(sourceCOBie.getStreet());
        targetCOBie.setContactURL(COBieUtility.COBieNA);
        targetCOBie.setExternalEntityName(sourceCOBie.getExternalObject());
        targetCOBie.setExternalID(sourceCOBie.getExternalIdentifier());
        targetCOBie.setExternalSystemName(sourceCOBie.getExternalSystem());
    }

}
