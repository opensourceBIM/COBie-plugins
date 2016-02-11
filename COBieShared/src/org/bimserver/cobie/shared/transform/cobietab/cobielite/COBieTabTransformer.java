package org.bimserver.cobie.shared.transform.cobietab.cobielite;

import org.bimserver.cobie.shared.cobietab.AttributesDocumentsIssues;
import org.bimserver.cobie.shared.cobietab.IndexedCOBie;
import org.bimserver.cobie.shared.transform.Transformer;
import org.bimserver.cobie.shared.utility.COBieUtility.CobieSheetName;
import org.buildingsmartalliance.docs.nbims03.cobie.core.CobieBaseType;
import org.nibs.cobie.tab.AssemblyType;
import org.nibs.cobie.tab.AttributeType;
import org.nibs.cobie.tab.ComponentType;
import org.nibs.cobie.tab.ConnectionType;
import org.nibs.cobie.tab.ContactType;
import org.nibs.cobie.tab.CoordinateType;
import org.nibs.cobie.tab.DocumentType;
import org.nibs.cobie.tab.FacilityType;
import org.nibs.cobie.tab.FloorType;
import org.nibs.cobie.tab.ImpactType;
import org.nibs.cobie.tab.IssueType;
import org.nibs.cobie.tab.JobType;
import org.nibs.cobie.tab.ResourceType;
import org.nibs.cobie.tab.SpaceType;
import org.nibs.cobie.tab.SpareType;
import org.nibs.cobie.tab.SystemType;
import org.nibs.cobie.tab.TypeType;
import org.nibs.cobie.tab.ZoneType;

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
