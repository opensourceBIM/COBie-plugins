package org.erdc.cobie.cobielite.parsers.sheetxmldata;

import org.erdc.cobie.cobielite.parsers.COBieLiteParsable;
import org.erdc.cobie.shared.COBieUtility.CobieSheetName;
import org.erdc.cobie.shared.cobiesheetxmldata.indices.AttributesDocumentsIssues;
import org.erdc.cobie.shared.cobiesheetxmldata.indices.IndexedCOBie;
import org.erdc.cobie.shared.parsers.Parser;
import org.erdc.cobie.sheetxmldata.AssemblyType;
import org.erdc.cobie.sheetxmldata.AttributeType;
import org.erdc.cobie.sheetxmldata.ComponentType;
import org.erdc.cobie.sheetxmldata.ConnectionType;
import org.erdc.cobie.sheetxmldata.ContactType;
import org.erdc.cobie.sheetxmldata.CoordinateType;
import org.erdc.cobie.sheetxmldata.DocumentType;
import org.erdc.cobie.sheetxmldata.FacilityType;
import org.erdc.cobie.sheetxmldata.FloorType;
import org.erdc.cobie.sheetxmldata.ImpactType;
import org.erdc.cobie.sheetxmldata.IssueType;
import org.erdc.cobie.sheetxmldata.JobType;
import org.erdc.cobie.sheetxmldata.ResourceType;
import org.erdc.cobie.sheetxmldata.SpaceType;
import org.erdc.cobie.sheetxmldata.SpareType;
import org.erdc.cobie.sheetxmldata.SystemType;
import org.erdc.cobie.sheetxmldata.TypeType;
import org.erdc.cobie.sheetxmldata.ZoneType;

public abstract class COBieLiteSheetXMLDataParser<COBIE_SHEET_XML_DATA_TYPE extends org.apache.xmlbeans.XmlObject, COBIE_LITE_DATA_TYPE extends org.erdc.cobie.cobielite.CobieBaseType> 
extends Parser<COBIE_SHEET_XML_DATA_TYPE, COBIE_LITE_DATA_TYPE> implements
        COBieLiteParsable 
{

    protected CobieSheetName cobieSpreadsheetName;
    protected final AttributesDocumentsIssues descriptiveData;
    protected final IndexedCOBie indexedCOBie;

    public COBieLiteSheetXMLDataParser(COBIE_SHEET_XML_DATA_TYPE cobieSheetXMLData, COBIE_LITE_DATA_TYPE cobieLiteRowData, IndexedCOBie indexedCOBie)
    {
        super(cobieSheetXMLData, cobieLiteRowData);
        this.indexedCOBie = indexedCOBie;
        initializeCobieSpreadsheetName();
        descriptiveData = findDescriptiveDataRows();
    }

    protected abstract AttributesDocumentsIssues findDescriptiveDataRows();

    public COBIE_LITE_DATA_TYPE getCobieRowData()
    {
        return targetCOBie;
    }


    public CobieSheetName getCobieSpreadsheetName()
    {
        return cobieSpreadsheetName;
    }

    public IndexedCOBie getIndexedCOBie()
    {
        return indexedCOBie;
    }

    private void initializeCobieSpreadsheetName()
    {
        // TODO: change this to abstract and make the assignment in derived
        // classes
        if (sourceCOBie instanceof ContactType)
        {
            setCobieSpreadsheetName(CobieSheetName.Contact);
        } else if (sourceCOBie instanceof FacilityType)
        {
            setCobieSpreadsheetName(CobieSheetName.Facility);
        } else if (sourceCOBie instanceof FloorType)
        {
            setCobieSpreadsheetName(CobieSheetName.Floor);
        } else if (sourceCOBie instanceof SpaceType)
        {
            setCobieSpreadsheetName(CobieSheetName.Space);
        } else if (sourceCOBie instanceof ZoneType)
        {
            setCobieSpreadsheetName(CobieSheetName.Zone);
        } else if (sourceCOBie instanceof TypeType)
        {
            setCobieSpreadsheetName(CobieSheetName.Type);
        } else if (sourceCOBie instanceof ComponentType)
        {
            setCobieSpreadsheetName(CobieSheetName.Component);
        } else if (sourceCOBie instanceof SystemType)
        {
            setCobieSpreadsheetName(CobieSheetName.System);
        } else if (sourceCOBie instanceof AssemblyType)
        {
            setCobieSpreadsheetName(CobieSheetName.Assembly);
        } else if (sourceCOBie instanceof ConnectionType)
        {
            setCobieSpreadsheetName(CobieSheetName.Connection);
        } else if (sourceCOBie instanceof SpareType)
        {
            setCobieSpreadsheetName(CobieSheetName.Spare);
        } else if (sourceCOBie instanceof ResourceType)
        {
            setCobieSpreadsheetName(CobieSheetName.Resource);
        } else if (sourceCOBie instanceof JobType)
        {
            setCobieSpreadsheetName(CobieSheetName.Job);
        } else if (sourceCOBie instanceof ImpactType)
        {
            setCobieSpreadsheetName(CobieSheetName.Impact);
        } else if (sourceCOBie instanceof DocumentType)
        {
            setCobieSpreadsheetName(CobieSheetName.Document);
        } else if (sourceCOBie instanceof AttributeType)
        {
            setCobieSpreadsheetName(CobieSheetName.Attribute);
        } else if (sourceCOBie instanceof CoordinateType)
        {
            setCobieSpreadsheetName(CobieSheetName.Coordinate);
        } else if (sourceCOBie instanceof IssueType)
        {
            setCobieSpreadsheetName(CobieSheetName.Issue);
        }

    }

    @Override
    public COBIE_LITE_DATA_TYPE parse()
    {
        try
        {
            parseSimpleElements();
        } catch (Exception ex)
        {
            // TODO: log mapping errors
        }
        try
        {
            parseDescriptiveElements();
        } catch (Exception ex)
        {
            // TODO: log mapping errors
        }

        try
        {
            parseComplexElements();
        } catch (Exception ex)
        {
            // TODO: log mapping errors
        }
        return targetCOBie;
    }

    protected abstract void parseAttributes() throws Exception;



    protected void parseDescriptiveElements()
    {
        try
        {
            parseAttributes();
        } catch (Exception ex)
        {
            // TODO: log mapping errors
        }

        try
        {
            parseDocuments();
        } catch (Exception ex)
        {
            // TODO: log mapping errors
        }
        try
        {
            parseIssues();
        } catch (Exception ex)
        {
            // TODO: log mapping errors
        }

    }

    protected abstract void parseDocuments() throws Exception;

    protected abstract void parseIssues() throws Exception;

    private void setCobieSpreadsheetName(CobieSheetName cobieSpreadsheetName)
    {
        this.cobieSpreadsheetName = cobieSpreadsheetName;
    }

}
