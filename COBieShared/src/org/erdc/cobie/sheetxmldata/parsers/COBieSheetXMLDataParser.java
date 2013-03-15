package org.erdc.cobie.sheetxmldata.parsers;

import org.erdc.cobie.shared.COBieUtility.CobieSheetName;
import org.erdc.cobie.shared.parsers.Parser;
import org.erdc.cobie.sheetxmldata.COBIEBaseType;

public abstract class COBieSheetXMLDataParser<SOURCE, TARGET extends  org.apache.xmlbeans.XmlObject> extends Parser<SOURCE, TARGET>
{
    protected CobieSheetName cobieSpreadSheetName;
    public COBieSheetXMLDataParser(SOURCE sourceCOBie, TARGET targetCOBie)
    {
        super(sourceCOBie, targetCOBie);
        initializeCobieSpreadsheetName();
    }
    
    protected abstract void initializeCobieSpreadsheetName();
    
    public CobieSheetName getCobieSpreadSheetName()
    {
        return cobieSpreadSheetName;
    }
    public void setCobieSpreadSheetName(CobieSheetName cobieSpreadSheetName)
    {
        this.cobieSpreadSheetName = cobieSpreadSheetName;
    }
      

}
