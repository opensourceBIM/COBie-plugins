package org.erdc.cobie.sheetxmldata.parsers.spreadsheetml;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import nl.fountain.xelem.excel.Row;
import nl.fountain.xelem.excel.Workbook;
import nl.fountain.xelem.excel.Worksheet;

import org.erdc.cobie.shared.COBieTokenUtility;
import org.erdc.cobie.shared.COBieTokenUtility.DocumentColumnNameLiterals;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.sheetxmldata.COBIEType;
import org.erdc.cobie.sheetxmldata.DocumentType;
import org.erdc.cobie.utils.stringwriters.COBieStringHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DocumentParser extends Parser
{

    public DocumentParser(COBIEType cobie, Workbook workbook, COBieStringHandler cobieStringWriter)
    {
        super(cobie, workbook, cobieStringWriter);
    }

    public DocumentParser(COBIEType cobie, Workbook workbook)
    {
        super(cobie, workbook);
    }

    @Override
    protected List<String> getColumnNames()
    {
        return COBieTokenUtility.DocumentColumnNames;
    }

    @Override
    protected Logger getLogger()
    {
        return LoggerFactory.getLogger(DocumentParser.class);
    }

    @Override
    protected String getWorksheetName()
    {
        return COBieUtility.CobieSheetName.Document.name();
    }

    @Override
    protected void write()
    {
        COBIEType.Documents documents = getCobie().addNewDocuments();
        Worksheet sheet = getWorksheet();
        Map<String, Integer> columnDictionary = getColumnDictionary();
        String documentName = "";
        String documentCreatedBy = "";
        Calendar documentCreatedOn;
        String documentCreatedOnString = "";
        String documentCategory = "";
        String documentApprovalBy = "";
        String documentStage = "";
        String documentSheetName = "";
        String documentRowName = "";
        String documentDirectory = "";
        String documentFile = "";
        String documentExtSystem = "";
        String documentExtObject = "";
        String documentExtIdentifier = "";
        String documentDescription = "";
        String documentReference = "";
        int idxName;
        int idxCreatedBy;
        int idxCreatedOn;
        int idxCategory;
        int idxApprovalBy;
        int idxStage;
        int idxSheetName;
        int idxRowName;
        int idxDirectory;
        int idxFile;
        int idxExtSystem;
        int idxExtObject;
        int idxExtIdentifier;
        int idxDescription;
        int idxReference;
        idxName = columnDictionary.get(DocumentColumnNameLiterals.Name.toString());
        idxCreatedBy = columnDictionary.get(DocumentColumnNameLiterals.CreatedBy.toString());
        idxCreatedOn = columnDictionary.get(DocumentColumnNameLiterals.CreatedOn.toString());
        idxCategory = columnDictionary.get(DocumentColumnNameLiterals.Category.toString());
        idxApprovalBy = columnDictionary.get(DocumentColumnNameLiterals.ApprovalBy.toString());
        idxStage = columnDictionary.get(DocumentColumnNameLiterals.Stage.toString());
        idxSheetName = columnDictionary.get(DocumentColumnNameLiterals.SheetName.toString());
        idxRowName = columnDictionary.get(DocumentColumnNameLiterals.RowName.toString());
        idxDirectory = columnDictionary.get(DocumentColumnNameLiterals.Directory.toString());
        idxFile = columnDictionary.get(DocumentColumnNameLiterals.File.toString());
        idxExtSystem = columnDictionary.get(DocumentColumnNameLiterals.ExtSystem.toString());
        idxExtObject = columnDictionary.get(DocumentColumnNameLiterals.ExtObject.toString());
        idxExtIdentifier = columnDictionary.get(DocumentColumnNameLiterals.ExtIdentifier.toString());
        idxDescription = columnDictionary.get(DocumentColumnNameLiterals.Description.toString());
        idxReference = columnDictionary.get(DocumentColumnNameLiterals.Reference.toString());
        int rowIdx;
        int firstRowIdx = Worksheet.firstRow;
        for (Row rowData : sheet.getRows())
        {
            rowIdx = rowData.getIndex();
            if ((rowIdx > firstRowIdx) && COBieSpreadSheet.isRowPopulated(rowData, 1, 100))
            {
                DocumentType tmpDocument = documents.addNewDocument();
                if (idxName > -1)
                {
                    documentName = rowData.getCellAt(idxName).getData$();
                }
                if (idxCreatedBy > -1)
                {
                    documentCreatedBy = rowData.getCellAt(idxCreatedBy).getData$();
                }
                if (idxCreatedOn > -1)
                {
                    documentCreatedOnString = rowData.getCellAt(idxCreatedOn).getData$();
                }
                if (idxCategory > -1)
                {
                    documentCategory = rowData.getCellAt(idxCategory).getData$();
                }
                if (idxApprovalBy > -1)
                {
                    documentApprovalBy = rowData.getCellAt(idxApprovalBy).getData$();
                }
                if (idxStage > -1)
                {
                    documentStage = rowData.getCellAt(idxStage).getData$();
                }
                if (idxSheetName > -1)
                {
                    documentSheetName = rowData.getCellAt(idxSheetName).getData$();
                }
                if (idxRowName > -1)
                {
                    documentRowName = rowData.getCellAt(idxRowName).getData$();
                }
                if (idxDirectory > -1)
                {
                    documentDirectory = rowData.getCellAt(idxDirectory).getData$();
                }
                if (idxFile > -1)
                {
                    documentFile = rowData.getCellAt(idxFile).getData$();
                }
                if (idxExtSystem > -1)
                {
                    documentExtSystem = rowData.getCellAt(idxExtSystem).getData$();
                }
                if (idxExtObject > -1)
                {
                    documentExtObject = rowData.getCellAt(idxExtObject).getData$();
                }
                if (idxExtIdentifier > -1)
                {
                    documentExtIdentifier = rowData.getCellAt(idxExtIdentifier).getData$();
                }
                if (idxDescription > -1)
                {
                    documentDescription = rowData.getCellAt(idxDescription).getData$();
                }
                if (idxReference > -1)
                {
                    documentReference = rowData.getCellAt(idxReference).getData$();
                }

                documentCreatedOn = getCobieStringHandler().calendarFromString(documentCreatedOnString);
                tmpDocument.setName(cobieStringHandler.getCOBieString(documentName));
                tmpDocument.setCreatedBy(cobieStringHandler.getCOBieString(documentCreatedBy));
                tmpDocument.setCreatedOn(documentCreatedOn);
                tmpDocument.setCategory(cobieStringHandler.getCOBieString(documentCategory));
                tmpDocument.setApprovalBy(cobieStringHandler.getCOBieString(documentApprovalBy));
                tmpDocument.setStage(cobieStringHandler.getCOBieString(documentStage));
                tmpDocument.setSheetName(cobieStringHandler.getCOBieString(documentSheetName));
                tmpDocument.setRowName(cobieStringHandler.getCOBieString(documentRowName));
                tmpDocument.setDirectory(cobieStringHandler.getCOBieString(documentDirectory));
                tmpDocument.setFile(cobieStringHandler.getCOBieString(documentFile));
                tmpDocument.setExtSystem(cobieStringHandler.getCOBieString(documentExtSystem));
                tmpDocument.setExtObject(cobieStringHandler.getCOBieString(documentExtObject));
                tmpDocument.setExtIdentifier(cobieStringHandler.getCOBieString(documentExtIdentifier));
                tmpDocument.setDescription(cobieStringHandler.getCOBieString(documentDescription));
                tmpDocument.setReference(cobieStringHandler.getCOBieString(documentReference));
            }
        }
    }

}
