package org.erdc.cobie.shared.spreadsheetml.transformation.cobietab;

import java.util.Calendar;
import java.util.List;

import nl.fountain.xelem.excel.Row;
import nl.fountain.xelem.excel.Workbook;
import nl.fountain.xelem.excel.Worksheet;

import org.erdc.cobie.shared.COBieTokenUtility;
import org.erdc.cobie.shared.COBieTokenUtility.AttributeColumnNameLiterals;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.shared.utility.COBieStringHandler;
import org.erdc.cobie.sheetxmldata.AttributeType;
import org.erdc.cobie.sheetxmldata.COBIEType;

public class AttributeTransformer extends SpreadsheetMLTransformer
{

    public AttributeTransformer(COBIEType cobie, Workbook workbook, COBieStringHandler cobieStringWriter)
    {
        super(workbook, cobie, cobieStringWriter);
        // TODO Auto-generated constructor stub
    }

    public AttributeTransformer(COBIEType cobie, Workbook workbook)
    {
        super(cobie, workbook);
    }

    @Override
    protected List<String> getColumnNames()
    {
        return COBieTokenUtility.AttributeColumnNames;
    }

    @Override
    protected String getWorksheetName()
    {
        return COBieUtility.CobieSheetName.Attribute.toString();

    }

    @Override
    protected void write()
    {
        COBIEType.Attributes attributes = getTarget().addNewAttributes();

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
                attributeCreatedOn = getCobieStringHandler().calendarFromString(attributeCreatedOnString);
                tmpAttribute.setName(cobieStringHandler.getCOBieString(attributeName));
                tmpAttribute.setCreatedBy(cobieStringHandler.getCOBieString(attributeCreatedBy));
                tmpAttribute.setCreatedOn(attributeCreatedOn);
                tmpAttribute.setCategory(cobieStringHandler.getCOBieString(attributeCategory));
                tmpAttribute.setSheetName(cobieStringHandler.getCOBieString(attributeSheetName));
                tmpAttribute.setRowName(cobieStringHandler.getCOBieString(attributeRowName));
                tmpAttribute.setValue(cobieStringHandler.getCOBieString(attributeValue));
                tmpAttribute.setUnit(cobieStringHandler.getCOBieString(attributeUnit));
                tmpAttribute.setExtSystem(cobieStringHandler.getCOBieString(attributeExtSystem));
                tmpAttribute.setExtObject(cobieStringHandler.getCOBieString(attributeExtObject));
                tmpAttribute.setExtIdentifier(cobieStringHandler.getCOBieString(attributeExtIdentifier));
                tmpAttribute.setDescription(cobieStringHandler.getCOBieString(attributeDescription));
                tmpAttribute.setAllowedValues(cobieStringHandler.getCOBieString(attributeAllowedValues));
            }
        }
    }

}
