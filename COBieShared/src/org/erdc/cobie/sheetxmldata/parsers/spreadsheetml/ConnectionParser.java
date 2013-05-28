package org.erdc.cobie.sheetxmldata.parsers.spreadsheetml;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import nl.fountain.xelem.excel.Row;
import nl.fountain.xelem.excel.Workbook;
import nl.fountain.xelem.excel.Worksheet;

import org.erdc.cobie.shared.COBieTokenUtility;
import org.erdc.cobie.shared.COBieTokenUtility.ConnectionColumnNameLiterals;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.sheetxmldata.COBIEType;
import org.erdc.cobie.sheetxmldata.ConnectionType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectionParser extends Parser
{

    public ConnectionParser(COBIEType cobie, Workbook workbook)
    {
        super(cobie, workbook);
    }

    @Override
    protected List<String> getColumnNames()
    {
        return COBieTokenUtility.ConnectionColumnNames;
    }

    @Override
    protected Logger getLogger()
    {
        return LoggerFactory.getLogger(ConnectionParser.class);
    }

    @Override
    protected String getWorksheetName()
    {
        return COBieUtility.CobieSheetName.Connection.name();
    }

    @Override
    protected void write()
    {
        COBIEType.Connections connections = getCobie().addNewConnections();
        Worksheet sheet = getWorksheet();
        Map<String, Integer> columnDictionary = getColumnDictionary();
        String connectionName = "";
        String connectionCreatedBy = "";
        String connectionCreatedOnString = "";
        Calendar connectionCreatedOn;
        String connectionConnectionType = "";
        String connectionSheetName = "";
        String connectionRowName1 = "";
        String connectionRowName2 = "";
        String connectionPortName1 = "";
        String connectionPortName2 = "";
        String connectionExtSystem = "";
        String connectionExtObject = "";
        String connectionExtIdentifier = "";
        String connectionDescription = "";
        String connectionRealizingElement = "";
        int idxName;
        int idxCreatedBy;
        int idxCreatedOn;
        int idxConnectionType;
        int idxSheetName;
        int idxRowName1;
        int idxRowName2;
        int idxRealizingElement;
        int idxPortName1;
        int idxPortName2;
        int idxExtSystem;
        int idxExtObject;
        int idxExtIdentifier;
        int idxDescription;
        idxName = columnDictionary.get(ConnectionColumnNameLiterals.Name.toString());
        idxCreatedBy = columnDictionary.get(ConnectionColumnNameLiterals.CreatedBy.toString());
        idxCreatedOn = columnDictionary.get(ConnectionColumnNameLiterals.CreatedOn.toString());
        idxConnectionType = columnDictionary.get(ConnectionColumnNameLiterals.ConnectionType.toString());
        idxSheetName = columnDictionary.get(ConnectionColumnNameLiterals.SheetName.toString());
        idxRowName1 = columnDictionary.get(ConnectionColumnNameLiterals.RowName1.toString());
        idxRowName2 = columnDictionary.get(ConnectionColumnNameLiterals.RowName2.toString());
        idxRealizingElement = columnDictionary.get(ConnectionColumnNameLiterals.RealizingElement.toString());
        idxPortName1 = columnDictionary.get(ConnectionColumnNameLiterals.PortName1.toString());
        idxPortName2 = columnDictionary.get(ConnectionColumnNameLiterals.PortName2.toString());
        idxExtSystem = columnDictionary.get(ConnectionColumnNameLiterals.ExtSystem.toString());
        idxExtObject = columnDictionary.get(ConnectionColumnNameLiterals.ExtObject.toString());
        idxExtIdentifier = columnDictionary.get(ConnectionColumnNameLiterals.ExtIdentifier.toString());
        idxDescription = columnDictionary.get(ConnectionColumnNameLiterals.Description.toString());
        int rowIdx;
        int firstRowIdx = Worksheet.firstRow;
        for (Row rowData : sheet.getRows())
        {
            rowIdx = rowData.getIndex();
            if ((rowIdx > firstRowIdx) && COBieSpreadSheet.isRowPopulated(rowData, 1, 100))
            {
                ConnectionType tmpConnection = connections.addNewConnection();
                if (idxName > -1)
                {
                    connectionName = rowData.getCellAt(idxName).getData$();
                }
                if (idxCreatedBy > -1)
                {
                    connectionCreatedBy = rowData.getCellAt(idxCreatedBy).getData$();
                }
                if (idxCreatedOn > -1)
                {
                    connectionCreatedOnString = rowData.getCellAt(idxCreatedOn).getData$();
                }
                if (idxConnectionType > -1)
                {
                    connectionConnectionType = rowData.getCellAt(idxConnectionType).getData$();
                }
                if (idxSheetName > -1)
                {
                    connectionSheetName = rowData.getCellAt(idxSheetName).getData$();
                }
                if (idxRowName1 > -1)
                {
                    connectionRowName1 = rowData.getCellAt(idxRowName1).getData$();
                }
                if (idxRowName2 > -1)
                {
                    connectionRowName2 = rowData.getCellAt(idxRowName2).getData$();
                }
                if (idxRealizingElement > -1)
                {
                    connectionRealizingElement = rowData.getCellAt(idxRealizingElement).getData$();
                }
                if (idxPortName1 > -1)
                {
                    connectionPortName1 = rowData.getCellAt(idxPortName1).getData$();
                }
                if (idxPortName2 > -1)
                {
                    connectionPortName2 = rowData.getCellAt(idxPortName2).getData$();
                }
                if (idxExtSystem > -1)
                {
                    connectionExtSystem = rowData.getCellAt(idxExtSystem).getData$();
                }
                if (idxExtObject > -1)
                {
                    connectionExtObject = rowData.getCellAt(idxExtObject).getData$();
                }
                if (idxExtIdentifier > -1)
                {
                    connectionExtIdentifier = rowData.getCellAt(idxExtIdentifier).getData$();
                }
                if (idxDescription > -1)
                {
                    connectionDescription = rowData.getCellAt(idxDescription).getData$();
                }
                connectionCreatedOn = COBieUtility.calendarFromString(connectionCreatedOnString);
                tmpConnection.setName(COBieUtility.getCOBieString(connectionName));
                tmpConnection.setCreatedBy(COBieUtility.getCOBieString(connectionCreatedBy));
                tmpConnection.setCreatedOn(connectionCreatedOn);
                tmpConnection.setConnectionType(COBieUtility.getCOBieString(connectionConnectionType));
                tmpConnection.setSheetName(COBieUtility.getCOBieString(connectionSheetName));
                tmpConnection.setRowName1(COBieUtility.getCOBieString(connectionRowName1));
                tmpConnection.setRowName2(COBieUtility.getCOBieString(connectionRowName2));
                tmpConnection.setRealizingElement(COBieUtility.getCOBieString(connectionRealizingElement));
                tmpConnection.setPortName1(COBieUtility.getCOBieString(connectionPortName1));
                tmpConnection.setPortName2(COBieUtility.getCOBieString(connectionPortName2));
                tmpConnection.setExtSystem(COBieUtility.getCOBieString(connectionExtSystem));
                tmpConnection.setExtObject(COBieUtility.getCOBieString(connectionExtObject));
                tmpConnection.setExtIdentifier(COBieUtility.getCOBieString(connectionExtIdentifier));
                tmpConnection.setDescription(COBieUtility.getCOBieString(connectionDescription));
            }
        }
    }

}
