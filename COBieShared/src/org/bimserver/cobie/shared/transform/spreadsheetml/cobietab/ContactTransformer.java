package org.bimserver.cobie.shared.transform.spreadsheetml.cobietab;

/******************************************************************************

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
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import nl.fountain.xelem.excel.Row;
import nl.fountain.xelem.excel.Workbook;
import nl.fountain.xelem.excel.Worksheet;

import org.bimserver.cobie.shared.COBieTokenUtility;
import org.bimserver.cobie.shared.COBieTokenUtility.ContactColumnNameLiterals;
import org.bimserver.cobie.shared.utility.COBieStringHandler;
import org.bimserver.cobie.shared.utility.COBieUtility;
import org.nibs.cobie.tab.COBIEType;
import org.nibs.cobie.tab.ContactType;

public class ContactTransformer extends SpreadsheetMLTransformer
{

    public ContactTransformer(COBIEType cobie, Workbook workbook)
    {
        super(cobie, workbook);
    }
    
    public ContactTransformer(COBIEType cobie, Workbook workbook, COBieStringHandler cobieStringWriter)
    {
        super(workbook, cobie, cobieStringWriter);
    }
    

    @Override
    protected List<String> getColumnNames()
    {
        return COBieTokenUtility.ContactColumnNames;
    }

    @Override
    protected String getWorksheetName()
    {
        return COBieUtility.CobieSheetName.Contact.name();
    }

    @Override
    protected void write()
    {

        COBIEType.Contacts contacts = getTarget().addNewContacts();

        Worksheet sheet = getWorksheet();
        Map<String, Integer> columnDictionary = getColumnDictionary();

        String contactEmail = "";
        String contactCreatedBy = "";
        Calendar contactCreatedOn;
        String contactCreatedOnString = "";
        String contactCategory = "";
        String contactCompany = "";
        String contactPhone = "";
        String contactExternalSystem = "";
        String contactExternalObject = "";
        String contactExternalIdentifier = "";
        String contactGivenName = "";
        String contactFamilyName = "";
        String contactStreet = "";
        String contactPostalBox = "";
        String contactTown = "";
        String contactStateRegion = "";
        String contactPostalCode = "";
        String contactCountry = "";
        String contactDepartment = "";
        String contactOrganizationCode = "";

        int idxEmail;
        int idxCreatedBy;
        int idxCreatedOn;
        int idxCategory;
        int idxCompany;
        int idxPhone;
        int idxExternalSystem;
        int idxExternalObject;
        int idxExternalIdentifier;
        int idxDepartment;
        int idxOrganizationCode;
        int idxGivenName;
        int idxFamilyName;
        int idxStreet;
        int idxPostalBox;
        int idxTown;
        int idxStateRegion;
        int idxPostalCode;
        int idxCountry;

        idxEmail = columnDictionary.get(ContactColumnNameLiterals.Email.toString());
        idxCreatedBy = columnDictionary.get(ContactColumnNameLiterals.CreatedBy.toString());
        idxCreatedOn = columnDictionary.get(ContactColumnNameLiterals.CreatedOn.toString());
        idxCategory = columnDictionary.get(ContactColumnNameLiterals.Category.toString());
        idxCompany = columnDictionary.get(ContactColumnNameLiterals.Company.toString());
        idxPhone = columnDictionary.get(ContactColumnNameLiterals.Phone.toString());
        idxExternalSystem = columnDictionary.get(ContactColumnNameLiterals.ExternalSystem.toString());
        idxExternalObject = columnDictionary.get(ContactColumnNameLiterals.ExternalObject.toString());
        idxExternalIdentifier = columnDictionary.get(ContactColumnNameLiterals.ExternalIdentifier.toString());
        idxDepartment = columnDictionary.get(ContactColumnNameLiterals.Department.toString());
        idxOrganizationCode = columnDictionary.get(ContactColumnNameLiterals.OrganizationCode.toString());
        idxGivenName = columnDictionary.get(ContactColumnNameLiterals.GivenName.toString());
        idxFamilyName = columnDictionary.get(ContactColumnNameLiterals.FamilyName.toString());
        idxStreet = columnDictionary.get(ContactColumnNameLiterals.Street.toString());
        idxPostalBox = columnDictionary.get(ContactColumnNameLiterals.PostalBox.toString());
        idxTown = columnDictionary.get(ContactColumnNameLiterals.Town.toString());
        idxStateRegion = columnDictionary.get(ContactColumnNameLiterals.StateRegion.toString());
        idxPostalCode = columnDictionary.get(ContactColumnNameLiterals.PostalCode.toString());
        idxCountry = columnDictionary.get(ContactColumnNameLiterals.Country.toString());

        int rowIdx;
        int firstRowIdx = Worksheet.firstRow;
        for (Row rowData : sheet.getRows())
        {	
            rowIdx = rowData.getIndex();
            if ((rowIdx > firstRowIdx) && COBieSpreadSheet.isRowPopulated(rowData, 1, 100))
            {
                ContactType tmpContact = contacts.addNewContact();
                if (idxEmail > -1)
                {
                    contactEmail = rowData.getCellAt(idxEmail).getData$();
                }
                if (idxCreatedBy > -1)
                {
                    contactCreatedBy = rowData.getCellAt(idxCreatedBy).getData$();
                }
                if (idxCreatedOn > -1)
                {
                    contactCreatedOnString = rowData.getCellAt(idxCreatedOn).getData$();
                }
                if (idxCategory > -1)
                {
                    contactCategory = rowData.getCellAt(idxCategory).getData$();
                }
                if (idxCompany > -1)
                {
                    contactCompany = rowData.getCellAt(idxCompany).getData$();
                }
                if (idxPhone > -1)
                {
                    contactPhone = rowData.getCellAt(idxPhone).getData$();
                }
                if (idxExternalSystem > -1)
                {
                    contactExternalSystem = rowData.getCellAt(idxExternalSystem).getData$();
                }
                if (idxExternalObject > -1)
                {
                    contactExternalObject = rowData.getCellAt(idxExternalObject).getData$();
                }
                if (idxExternalIdentifier > -1)
                {
                    contactExternalIdentifier = rowData.getCellAt(idxExternalIdentifier).getData$();
                }
                if (idxDepartment > -1)
                {
                    contactDepartment = rowData.getCellAt(idxDepartment).getData$();
                }
                if (idxOrganizationCode > -1)
                {
                    contactOrganizationCode = rowData.getCellAt(idxOrganizationCode).getData$();
                }
                if (idxGivenName > -1)
                {
                    contactGivenName = rowData.getCellAt(idxGivenName).getData$();
                }
                if (idxFamilyName > -1)
                {
                    contactFamilyName = rowData.getCellAt(idxFamilyName).getData$();
                }
                if (idxStreet > -1)
                {
                    contactStreet = rowData.getCellAt(idxStreet).getData$();
                }
                if (idxPostalBox > -1)
                {
                    contactPostalBox = rowData.getCellAt(idxPostalBox).getData$();
                }
                if (idxTown > -1)
                {
                    contactTown = rowData.getCellAt(idxTown).getData$();
                }
                if (idxStateRegion > -1)
                {
                    contactStateRegion = rowData.getCellAt(idxStateRegion).getData$();
                }
                if (idxPostalCode > -1)
                {
                    contactPostalCode = rowData.getCellAt(idxPostalCode).getData$();
                }
                if (idxCountry > -1)
                {
                    contactCountry = rowData.getCellAt(idxCountry).getData$();
                }

                contactCreatedOn = getCobieStringHandler().calendarFromString(contactCreatedOnString);
                
                tmpContact.setEmail(cobieStringHandler.getCOBieString(contactEmail));
                tmpContact.setCreatedBy(cobieStringHandler.getCOBieString(contactCreatedBy));                
                tmpContact.setCreatedOn(contactCreatedOn);
               
                tmpContact.setCategory(cobieStringHandler.getCOBieString(contactCategory));
                tmpContact.setCompany(cobieStringHandler.getCOBieString(contactCompany));
                tmpContact.setPhone(cobieStringHandler.getCOBieString(contactPhone));
                tmpContact.setExternalSystem(cobieStringHandler.getCOBieString(contactExternalSystem));
                tmpContact.setExternalObject(cobieStringHandler.getCOBieString(contactExternalObject));
                tmpContact.setExternalIdentifier(cobieStringHandler.getCOBieString(contactExternalIdentifier));
                tmpContact.setDepartment(cobieStringHandler.getCOBieString(contactDepartment));
                tmpContact.setOrganizationCode(cobieStringHandler.getCOBieString(contactOrganizationCode));
                tmpContact.setGivenName(cobieStringHandler.getCOBieString(contactGivenName));
                tmpContact.setFamilyName(cobieStringHandler.getCOBieString(contactFamilyName));
                tmpContact.setStreet(cobieStringHandler.getCOBieString(contactStreet));
                tmpContact.setPostalBox(cobieStringHandler.getCOBieString(contactPostalBox));
                tmpContact.setTown(cobieStringHandler.getCOBieString(contactTown));
                tmpContact.setStateRegion(cobieStringHandler.getCOBieString(contactStateRegion));
                tmpContact.setPostalCode(cobieStringHandler.getCOBieString(contactPostalCode));
                tmpContact.setCountry(cobieStringHandler.getCOBieString(contactCountry));
            }
        }
    }

}
