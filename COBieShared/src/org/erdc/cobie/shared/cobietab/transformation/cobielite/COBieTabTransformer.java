package org.erdc.cobie.shared.cobietab.transformation.cobielite;

import org.buildingsmartalliance.docs.nbims03.cobie.core.CobieBaseType;
import org.erdc.cobie.shared.COBieUtility.CobieSheetName;
import org.erdc.cobie.shared.cobietab.AttributesDocumentsIssues;
import org.erdc.cobie.shared.cobietab.IndexedCOBie;
import org.erdc.cobie.shared.transformation.Transformer;
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

public abstract class COBieTabTransformer<TSource extends org.apache.xmlbeans.XmlObject, TTarget extends CobieBaseType> 
extends Transformer<TSource, TTarget>
{

    protected CobieSheetName cobieSpreadsheetName;
    protected final AttributesDocumentsIssues descriptiveData;
    protected final IndexedCOBie indexedCOBie;

    public COBieTabTransformer(TSource cobieSheetXMLData, TTarget cobieLiteRowData, IndexedCOBie indexedCOBie)
    {
        super(cobieSheetXMLData, cobieLiteRowData);
        this.indexedCOBie = indexedCOBie;
        initializeCobieSpreadsheetName();
        descriptiveData = findDescriptiveDataRows();
    }

    protected abstract AttributesDocumentsIssues findDescriptiveDataRows();

    public TTarget getCobieRowData()
    {
        return target;
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
        if (source instanceof ContactType)
        {
            setCobieSpreadsheetName(CobieSheetName.Contact);
        } else if (source instanceof FacilityType)
        {
            setCobieSpreadsheetName(CobieSheetName.Facility);
        } else if (source instanceof FloorType)
        {
            setCobieSpreadsheetName(CobieSheetName.Floor);
        } else if (source instanceof SpaceType)
        {
            setCobieSpreadsheetName(CobieSheetName.Space);
        } else if (source instanceof ZoneType)
        {
            setCobieSpreadsheetName(CobieSheetName.Zone);
        } else if (source instanceof TypeType)
        {
            setCobieSpreadsheetName(CobieSheetName.Type);
        } else if (source instanceof ComponentType)
        {
            setCobieSpreadsheetName(CobieSheetName.Component);
        } else if (source instanceof SystemType)
        {
            setCobieSpreadsheetName(CobieSheetName.System);
        } else if (source instanceof AssemblyType)
        {
            setCobieSpreadsheetName(CobieSheetName.Assembly);
        } else if (source instanceof ConnectionType)
        {
            setCobieSpreadsheetName(CobieSheetName.Connection);
        } else if (source instanceof SpareType)
        {
            setCobieSpreadsheetName(CobieSheetName.Spare);
        } else if (source instanceof ResourceType)
        {
            setCobieSpreadsheetName(CobieSheetName.Resource);
        } else if (source instanceof JobType)
        {
            setCobieSpreadsheetName(CobieSheetName.Job);
        } else if (source instanceof ImpactType)
        {
            setCobieSpreadsheetName(CobieSheetName.Impact);
        } else if (source instanceof DocumentType)
        {
            setCobieSpreadsheetName(CobieSheetName.Document);
        } else if (source instanceof AttributeType)
        {
            setCobieSpreadsheetName(CobieSheetName.Attribute);
        } else if (source instanceof CoordinateType)
        {
            setCobieSpreadsheetName(CobieSheetName.Coordinate);
        } else if (source instanceof IssueType)
        {
            setCobieSpreadsheetName(CobieSheetName.Issue);
        }

    }

    @Override
    public TTarget transform()
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
        return target;
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
    
    protected abstract void parseSimpleElements();
    protected abstract void parseComplexElements();   

}
