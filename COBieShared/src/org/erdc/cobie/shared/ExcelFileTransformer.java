package org.erdc.cobie.shared;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.erdc.cobie.shared.COBieTokenUtility.ContactColumnNameLiterals;
import org.erdc.cobie.sheetxmldata.COBIEDocument;
import org.erdc.cobie.sheetxmldata.COBIEType;
import org.erdc.cobie.sheetxmldata.ContactType;

public class ExcelFileTransformer
{
    public static ArrayList<String> getContactColumns()
    {
        return COBieTokenUtility.ContactColumnNames;
    }

    public static Map<String, Integer> GetWorksheetColumnDictionary(HSSFSheet sheet, ArrayList<String> columnNames)
    {
        ArrayList<String> upperCaseColumnNames = new ArrayList<String>();
        for (int idx = 0; idx < columnNames.size(); idx++)
        {
            upperCaseColumnNames.add(columnNames.get(idx).toUpperCase());
        }
        Map<String, Integer> colMap = new HashMap<String, Integer>();
        int firstRowIndex = sheet.getFirstRowNum();
        Row firstRow = sheet.getRow(firstRowIndex);
        int tmpColIndex;
        String tmpColName;
        Iterator<Cell> cellIterator = firstRow.cellIterator();
        while (cellIterator.hasNext())
        {
            Cell tmpCell = cellIterator.next();
            tmpColIndex = tmpCell.getColumnIndex();
            if ((tmpCell.getStringCellValue() != null) && (tmpCell.getStringCellValue().length() > 0))
            {
                tmpColName = tmpCell.getStringCellValue();
                if (upperCaseColumnNames.contains(tmpColName.toUpperCase()) && !colMap.containsKey(tmpColName))
                {
                    colMap.put(tmpColName, tmpColIndex);
                }
            }
        }
        boolean foundSearch = false;
        for (String searchedColName : columnNames)
        {
            for (String colMapKey : colMap.keySet())
            {
                if (searchedColName.equalsIgnoreCase(colMapKey))
                {
                    // if (searchedColName.equalsIgnoreCase(searchedColName))
                    foundSearch = true;
                }
            }
            if (!foundSearch)
            {
                colMap.put(searchedColName, -1);
            }
            foundSearch = false;
        }
        return colMap;
    }

    public static boolean isRowPopulated(Row rowData, int startColumnIndex, int endColumnIndex)
    {
        boolean isPopulated = false;
        try
        {

            for (int i = startColumnIndex; i <= endColumnIndex; i++)
            {
                if ((rowData.getCell(i).getStringCellValue() != null) && (rowData.getCell(i).getStringCellValue().length() > 0))
                {
                    isPopulated = true;
                }
            }

        } catch (Exception e)
        {

        }
        return isPopulated;
    }

    public static void playWithPOI() throws IOException
    {
        HSSFWorkbook xlsBook = new HSSFWorkbook(new FileInputStream(new File("C:\\test.xls")));
        COBIEDocument cobie = COBIEDocument.Factory.newInstance();
        COBIEType cobieType = cobie.addNewCOBIE();
        writeXLSContactsToCOBie(cobieType, xlsBook);
    }

    private static void setRowAsStringValues(Row rowData)
    {
        Iterator<Cell> cellIterator = rowData.cellIterator();
        while (cellIterator.hasNext())
        {
            Cell cell = cellIterator.next();
            cell.setCellType(Cell.CELL_TYPE_STRING);
        }
    }

    public static void writeXLSContactsToCOBie(COBIEType cType, HSSFWorkbook workbook)
    {

        COBIEType.Contacts contacts = cType.addNewContacts();
        HSSFSheet sheet = workbook.getSheet(COBieUtility.CobieSheetName.Contact.toString());
        Map<String, Integer> columnDictionary = GetWorksheetColumnDictionary(sheet, getContactColumns());

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
        int firstRowIdx = sheet.getFirstRowNum();
        Iterator<Row> rowIterator = sheet.rowIterator();
        while (rowIterator.hasNext())
        {
            Row rowData = rowIterator.next();
            setRowAsStringValues(rowData);
            rowIdx = rowData.getRowNum();
            if ((rowIdx > firstRowIdx) && isRowPopulated(rowData, 1, 100))
            {

                ContactType tmpContact = contacts.addNewContact();
                if (idxEmail > -1)
                {
                    contactEmail = rowData.getCell(idxEmail).getStringCellValue();
                }
                if (idxCreatedBy > -1)
                {
                    contactCreatedBy = rowData.getCell(idxCreatedBy).getStringCellValue();
                }
                if (idxCreatedOn > -1)
                {
                    contactCreatedOnString = rowData.getCell(idxCreatedOn).getStringCellValue();
                }
                if (idxCategory > -1)
                {
                    contactCategory = rowData.getCell(idxCategory).getStringCellValue();
                }
                if (idxCompany > -1)
                {
                    contactCompany = rowData.getCell(idxCompany).getStringCellValue();
                }
                if (idxPhone > -1)
                {
                    contactPhone = rowData.getCell(idxPhone).getStringCellValue();
                }
                if (idxExternalSystem > -1)
                {
                    contactExternalSystem = rowData.getCell(idxExternalSystem).getStringCellValue();
                }
                if (idxExternalObject > -1)
                {
                    contactExternalObject = rowData.getCell(idxExternalObject).getStringCellValue();
                }
                if (idxExternalIdentifier > -1)
                {
                    contactExternalIdentifier = rowData.getCell(idxExternalIdentifier).getStringCellValue();
                }
                if (idxDepartment > -1)
                {
                    contactDepartment = rowData.getCell(idxDepartment).getStringCellValue();
                }
                if (idxOrganizationCode > -1)
                {
                    contactOrganizationCode = rowData.getCell(idxOrganizationCode).getStringCellValue();
                }
                if (idxGivenName > -1)
                {
                    contactGivenName = rowData.getCell(idxGivenName).getStringCellValue();
                }
                if (idxFamilyName > -1)
                {
                    contactFamilyName = rowData.getCell(idxFamilyName).getStringCellValue();
                }
                if (idxStreet > -1)
                {
                    contactStreet = rowData.getCell(idxStreet).getStringCellValue();
                }
                if (idxPostalBox > -1)
                {
                    contactPostalBox = rowData.getCell(idxPostalBox).getStringCellValue();
                }
                if (idxTown > -1)
                {
                    contactTown = rowData.getCell(idxTown).getStringCellValue();
                }
                if (idxStateRegion > -1)
                {
                    contactStateRegion = rowData.getCell(idxStateRegion).getStringCellValue();
                }
                if (idxPostalCode > -1)
                {
                    contactPostalCode = rowData.getCell(idxPostalCode).getStringCellValue();
                }
                if (idxCountry > -1)
                {
                    contactCountry = rowData.getCell(idxCountry).getStringCellValue();
                }

                contactCreatedOn = COBieUtility.calendarFromString(contactCreatedOnString);

                tmpContact.setEmail(COBieUtility.getCOBieString(contactEmail));
                tmpContact.setCreatedBy(COBieUtility.getCOBieString(contactCreatedBy));
                tmpContact.setCreatedOn(contactCreatedOn);
                tmpContact.setCategory(COBieUtility.getCOBieString(contactCategory));
                tmpContact.setCompany(COBieUtility.getCOBieString(contactCompany));
                tmpContact.setPhone(COBieUtility.getCOBieString(contactPhone));
                tmpContact.setExternalSystem(COBieUtility.getCOBieString(contactExternalSystem));
                tmpContact.setExternalObject(COBieUtility.getCOBieString(contactExternalObject));
                tmpContact.setExternalIdentifier(COBieUtility.getCOBieString(contactExternalIdentifier));
                tmpContact.setDepartment(COBieUtility.getCOBieString(contactDepartment));
                tmpContact.setOrganizationCode(COBieUtility.getCOBieString(contactOrganizationCode));
                tmpContact.setGivenName(COBieUtility.getCOBieString(contactGivenName));
                tmpContact.setFamilyName(COBieUtility.getCOBieString(contactFamilyName));
                tmpContact.setStreet(COBieUtility.getCOBieString(contactStreet));
                tmpContact.setPostalBox(COBieUtility.getCOBieString(contactPostalBox));
                tmpContact.setTown(COBieUtility.getCOBieString(contactTown));
                tmpContact.setStateRegion(COBieUtility.getCOBieString(contactStateRegion));
                tmpContact.setPostalCode(COBieUtility.getCOBieString(contactPostalCode));
                tmpContact.setCountry(COBieUtility.getCOBieString(contactCountry));
            }
        }
    }

    public ExcelFileTransformer(File excelFile)
    {
    }
}
