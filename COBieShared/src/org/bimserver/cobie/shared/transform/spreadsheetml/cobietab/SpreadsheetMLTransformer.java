package org.bimserver.cobie.shared.transform.spreadsheetml.cobietab;

import java.util.List;
import java.util.Map;

import nl.fountain.xelem.excel.Workbook;
import nl.fountain.xelem.excel.Worksheet;

import org.bimserver.cobie.shared.transform.spreadsheetml.Transformer;
import org.bimserver.cobie.shared.utility.COBieStringHandler;
import org.nibs.cobie.tab.COBIEType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class SpreadsheetMLTransformer extends Transformer<Workbook, COBIEType>
{

    private static final String ERROR_PREFIX = "Error converting spreadsheetml to cobie...";
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
    
    public SpreadsheetMLTransformer(Workbook workbook, COBIEType cobie, COBieStringHandler cobieStringHandler)
    {
    	super(workbook, cobie);
        this.cobieStringHandler = cobieStringHandler;
        init();
    }
    
    public SpreadsheetMLTransformer(COBIEType cobie, Workbook workbook)
    {
        this(workbook, cobie, new COBieStringHandler());
    }

    private void init()
    {
        try
        {
            worksheet = getSource().getWorksheet(getWorksheetName());
            columnDictionary = COBieSpreadSheet.getWorksheetColumnDictionary(worksheet, getColumnNames());
        }

        catch (Exception e)
        {
            logFailure(e);
        }
    }

    private void logFailure(Exception e)
    {
        getLogger().error(ERROR_PREFIX + e.getMessage());
    }

    public Map<String, Integer> getColumnDictionary()
    {
        return columnDictionary;
    }

    protected abstract List<String> getColumnNames();

    protected final Logger getLogger()
    {
    	return LoggerFactory.getLogger(getClass());
    }

    public Worksheet getWorksheet()
    {
        return worksheet;
    }

    protected abstract String getWorksheetName();

    public final COBIEType transform()
    {
        try
        {
            write();
                 
        } 
        catch (Exception e)
        {
            logFailure(e);
        }
        return getTarget();
    }

    protected abstract void write();
    
}
