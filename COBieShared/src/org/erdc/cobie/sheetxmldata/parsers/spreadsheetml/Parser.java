package org.erdc.cobie.sheetxmldata.parsers.spreadsheetml;

import java.util.List;
import java.util.Map;

import nl.fountain.xelem.excel.Workbook;
import nl.fountain.xelem.excel.Worksheet;

import org.erdc.cobie.sheetxmldata.COBIEType;
import org.erdc.cobie.utils.stringwriters.COBieStringHandler;
import org.slf4j.Logger;

public abstract class Parser
{

    private static final String ERROR_PREFIX = "Error converting spreadsheetml to cobie...";
    private final COBIEType cobie;
    private final Workbook workbook;
    private Worksheet worksheet;
    private Map<String, Integer> columnDictionary;
    public COBieStringHandler getCobieStringHandler()
    {
        return cobieStringHandler;
    }

    public void setCobieStringHandler(COBieStringHandler cobieStringHandler)
    {
        this.cobieStringHandler = cobieStringHandler;
    }

    public void setWorksheet(Worksheet worksheet)
    {
        this.worksheet = worksheet;
    }

    public void setColumnDictionary(Map<String, Integer> columnDictionary)
    {
        this.columnDictionary = columnDictionary;
    }

    protected COBieStringHandler cobieStringHandler;
    
    public Parser(COBIEType cobie, Workbook workbook, COBieStringHandler cobieStringHandler)
    {
        this.cobie = cobie;
        this.workbook = workbook;
        this.cobieStringHandler = cobieStringHandler;
        init();
    }
    
    public Parser(COBIEType cobie, Workbook workbook)
    {
        this(cobie, workbook, new COBieStringHandler());
    }

    private void init()
    {
        try
        {
            worksheet = getWorkbook().getWorksheet(getWorksheetName());
            columnDictionary = COBieSpreadSheet.getWorksheetColumnDictionary(worksheet, getColumnNames());
        }

        catch (Exception e)
        {
            fail(e);
        }
    }

    private void fail(Exception e)
    {
        getLogger().error(ERROR_PREFIX + e.getMessage());
    }

    public final COBIEType getCobie()
    {
        return cobie;
    }

    public Map<String, Integer> getColumnDictionary()
    {
        return columnDictionary;
    }

    protected abstract List<String> getColumnNames();

    protected abstract Logger getLogger();

    public final Workbook getWorkbook()
    {
        return workbook;
    }

    public Worksheet getWorksheet()
    {
        return worksheet;
    }

    protected abstract String getWorksheetName();

    public final void parse()
    {
        try
        {
            write();
        } catch (Exception e)
        {
            fail(e);
        }
    }

    protected abstract void write();
    
}
