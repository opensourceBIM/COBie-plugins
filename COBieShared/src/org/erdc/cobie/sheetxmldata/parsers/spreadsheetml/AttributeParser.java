package org.erdc.cobie.sheetxmldata.parsers.spreadsheetml;

import java.util.Calendar;
import java.util.List;

import nl.fountain.xelem.excel.Row;
import nl.fountain.xelem.excel.Workbook;
import nl.fountain.xelem.excel.Worksheet;

import org.erdc.cobie.shared.COBieTokenUtility;
import org.erdc.cobie.shared.COBieTokenUtility.AttributeColumnNameLiterals;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.sheetxmldata.AttributeType;
import org.erdc.cobie.sheetxmldata.COBIEType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AttributeParser extends Parser
{

    public AttributeParser(COBIEType cobie, Workbook workbook)
    {
        super(cobie, workbook);
    }

    @Override
    protected List<String> getColumnNames()
    {
        return COBieTokenUtility.AttributeColumnNames;
    }

    @Override
    protected Logger getLogger()
    {
        return LoggerFactory.getLogger(AttributeParser.class);
    }

    @Override
    protected String getWorksheetName()
    {
        return COBieUtility.CobieSheetName.Attribute.toString();

    }

    @Override
    protected void write()
    {
        COBIEType.Attributes attributes = getCobie().addNewAttributes();

        String attributeName = "";
        String attributeCreatedBy = "";
        String attributeCreatedOnString = "";
        Calendar attributeCreatedOn;
        String attributeCategory = "";
        String attributeSheetName = "";
        String attributeRowName = "";
        String attributeValue = "";
        String attributeUnit = "";
        String attributeExtSystem = "";
        String attributeExtObject = "";
        String attributeExtIdentifier = "";
        String attributeDescription = "";
        String attributeAllowedValues = "";
        int idxName;
        int idxCreatedBy;
        int idxCreatedOn;
        int idxCategory;
        int idxSheetName;
        int idxRowName;
        int idxValue;
        int idxUnit;
        int idxExtSystem;
        int idxExtObject;
        int idxExtIdentifier;
        int idxDescription;
        int idxAllowedValues;
        idxName = getColumnDictionary().get(AttributeColumnNameLiterals.Name.toString());
        idxCreatedBy = getColumnDictionary().get(AttributeColumnNameLiterals.CreatedBy.toString());
        idxCreatedOn = getColumnDictionary().get(AttributeColumnNameLiterals.CreatedOn.toString());
        idxCategory = getColumnDictionary().get(AttributeColumnNameLiterals.Category.toString());
        idxSheetName = getColumnDictionary().get(AttributeColumnNameLiterals.SheetName.toString());
        idxRowName = getColumnDictionary().get(AttributeColumnNameLiterals.RowName.toString());
        idxValue = getColumnDictionary().get(AttributeColumnNameLiterals.Value.toString());
        idxUnit = getColumnDictionary().get(AttributeColumnNameLiterals.Unit.toString());
        idxExtSystem = getColumnDictionary().get(AttributeColumnNameLiterals.ExtSystem.toString());
        idxExtObject = getColumnDictionary().get(AttributeColumnNameLiterals.ExtObject.toString());
        idxExtIdentifier = getColumnDictionary().get(AttributeColumnNameLiterals.ExtIdentifier.toString());
        idxDescription = getColumnDictionary().get(AttributeColumnNameLiterals.Description.toString());
        idxAllowedValues = getColumnDictionary().get(AttributeColumnNameLiterals.AllowedValues.toString());
        int rowIdx;
        int firstRowIdx = Worksheet.firstRow;
        for (Row rowData : getWorksheet().getRows())
        {
            rowIdx = rowData.getIndex();
            if ((rowIdx > firstRowIdx) && COBieSpreadSheet.isRowPopulated(rowData, 1, 100))
            {
                AttributeType tmpAttribute = attributes.addNewAttribute();
                if (idxName > -1)
                {
                    attributeName = rowData.getCellAt(idxName).getData$();
                }
                if (idxCreatedBy > -1)
                {
                    attributeCreatedBy = rowData.getCellAt(idxCreatedBy).getData$();
                }
                if (idxCreatedOn > -1)
                {
                    attributeCreatedOnString = rowData.getCellAt(idxCreatedOn).getData$();
                }
                if (idxCategory > -1)
                {
                    attributeCategory = rowData.getCellAt(idxCategory).getData$();
                }
                if (idxSheetName > -1)
                {
                    attributeSheetName = rowData.getCellAt(idxSheetName).getData$();
                }
                if (idxRowName > -1)
                {
                    attributeRowName = rowData.getCellAt(idxRowName).getData$();
                }
                if (idxValue > -1)
                {
                    attributeValue = rowData.getCellAt(idxValue).getData$();
                }
                if (idxUnit > -1)
                {
                    attributeUnit = rowData.getCellAt(idxUnit).getData$();
                }
                if (idxExtSystem > -1)
                {
                    attributeExtSystem = rowData.getCellAt(idxExtSystem).getData$();
                }
                if (idxExtObject > -1)
                {
                    attributeExtObject = rowData.getCellAt(idxExtObject).getData$();
                }
                if (idxExtIdentifier > -1)
                {
                    attributeExtIdentifier = rowData.getCellAt(idxExtIdentifier).getData$();
                }
                if (idxDescription > -1)
                {
                    attributeDescription = rowData.getCellAt(idxDescription).getData$();
                }
                if (idxAllowedValues > -1)
                {
                    attributeAllowedValues = rowData.getCellAt(idxAllowedValues).getData$();
                }
                attributeCreatedOn = COBieUtility.calendarFromString(attributeCreatedOnString);
                tmpAttribute.setName(COBieUtility.getCOBieString(attributeName));
                tmpAttribute.setCreatedBy(COBieUtility.getCOBieString(attributeCreatedBy));
                tmpAttribute.setCreatedOn(attributeCreatedOn);
                tmpAttribute.setCategory(COBieUtility.getCOBieString(attributeCategory));
                tmpAttribute.setSheetName(COBieUtility.getCOBieString(attributeSheetName));
                tmpAttribute.setRowName(COBieUtility.getCOBieString(attributeRowName));
                tmpAttribute.setValue(COBieUtility.getCOBieString(attributeValue));
                tmpAttribute.setUnit(COBieUtility.getCOBieString(attributeUnit));
                tmpAttribute.setExtSystem(COBieUtility.getCOBieString(attributeExtSystem));
                tmpAttribute.setExtObject(COBieUtility.getCOBieString(attributeExtObject));
                tmpAttribute.setExtIdentifier(COBieUtility.getCOBieString(attributeExtIdentifier));
                tmpAttribute.setDescription(COBieUtility.getCOBieString(attributeDescription));
                tmpAttribute.setAllowedValues(COBieUtility.getCOBieString(attributeAllowedValues));
            }
        }
    }

}
