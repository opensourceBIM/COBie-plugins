package org.erdc.cobie.sheetxmldata.parsers.cobielite;

import java.util.Calendar;

import org.buildingsmartalliance.docs.nbims03.cobie.core.AssemblyType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.AssetInfoType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.AssetTypeInfoType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.AttributeType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.CobieBaseType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.ConnectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.ContactType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.DocumentType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.FacilityType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.FloorType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.IssueType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.ResourceType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.SpaceType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.SpareType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.SystemType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.ZoneType;
import org.erdc.cobie.shared.COBieNAFactory;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.shared.COBieUtility.CobieSheetName;
import org.erdc.cobie.sheetxmldata.parsers.COBieSheetXMLDataParser;
import org.erdc.cobie.sheetxmldata.parsers.DefaultContact;

public abstract class COBieLiteSourceParser<SOURCE extends CobieBaseType, TARGET extends org.apache.xmlbeans.XmlObject> extends
        COBieSheetXMLDataParser<SOURCE, TARGET>
{
    public class ExternalData
    {
        public String externalSystem;
        public String externalObject;
        public String externalIdentifier;

        public ExternalData()
        {
            externalSystem = DEFAULT_EXT_SYSTEM;
            externalObject = COBieUtility.COBieNA;
            externalIdentifier = COBieUtility.COBieNA;
        }
    }

    public class OwnerHistory
    {
        public String CreatedBy;
        public Calendar CreatedOn;
    }

    public static final String DEFAULT_CREATED_BY = DefaultContact.EMAIL;

    public static final String DEFAULT_EXT_SYSTEM = DefaultContact.EXTERNAL_SYSTEM;

    protected OwnerHistory ownerHistory;
    protected ExternalData externalData;

    public COBieLiteSourceParser(SOURCE sourceCOBie, TARGET targetCOBie)
    {
        super(sourceCOBie, targetCOBie);
        initializeExternalData();
        initializeOwnerHistory();
        COBieNAFactory.setXmlObjectToNA(targetCOBie);
    }

    public ExternalData getExternalData()
    {
        return externalData;
    }

    public OwnerHistory getOwnerHistory()
    {
        return ownerHistory;
    }

    protected abstract void handleExternalData();

    protected abstract void handleInnerException(Exception exception);

    protected abstract void handleOwnerHistory();

    @Override
    protected void initializeCobieSpreadsheetName()
    {
        CobieSheetName sheetName = null;
        if (sourceCOBie instanceof FacilityType)
        {
            sheetName = CobieSheetName.Facility;
        } else if (sourceCOBie instanceof ContactType)
        {
            sheetName = CobieSheetName.Contact;
        } else if (sourceCOBie instanceof FloorType)
        {
            sheetName = CobieSheetName.Floor;
        } else if (sourceCOBie instanceof SpaceType)
        {
            sheetName = CobieSheetName.Space;
        } else if (sourceCOBie instanceof ZoneType)
        {
            sheetName = CobieSheetName.Zone;
        } else if (sourceCOBie instanceof SystemType)
        {
            sheetName = CobieSheetName.System;
        } else if (sourceCOBie instanceof AssetTypeInfoType)
        {
            sheetName = CobieSheetName.Type;
        } else if (sourceCOBie instanceof AssetInfoType)
        {
            sheetName = CobieSheetName.Component;
        } else if (sourceCOBie instanceof AttributeType)
        {
            sheetName = CobieSheetName.Attribute;
        } else if (sourceCOBie instanceof AssemblyType)
        {
            sheetName = CobieSheetName.Assembly;
        } else if (sourceCOBie instanceof ConnectionType)
        {
            sheetName = CobieSheetName.Connection;
        } else if (sourceCOBie instanceof DocumentType)
        {
            sheetName = CobieSheetName.Document;
        } else if (sourceCOBie instanceof IssueType)
        {
            sheetName = CobieSheetName.Issue;
        } else if (sourceCOBie instanceof SpareType)
        {
            sheetName = CobieSheetName.Spare;
        } else if (sourceCOBie instanceof ResourceType)
        {
            sheetName = CobieSheetName.Resource;
        } 
        setCobieSpreadSheetName(sheetName);

    }

    private void initializeExternalData()
    {
        ExternalData externalData = new ExternalData();

        if (sourceCOBie.getExternalEntityName() != null)
        {
            externalData.externalObject = sourceCOBie.getExternalEntityName();
        }
        if (sourceCOBie.getExternalID() != null)
        {
            externalData.externalIdentifier = sourceCOBie.getExternalID();
        }
        if (sourceCOBie.getExternalSystemName() != null)
        {
            externalData.externalSystem = sourceCOBie.getExternalSystemName();
        }

    }

    private void initializeOwnerHistory()
    {
        OwnerHistory ownerHistory = new OwnerHistory();
        ownerHistory.CreatedBy = DEFAULT_CREATED_BY;
        ownerHistory.CreatedOn = Calendar.getInstance();
    }

    @Override
    public TARGET parse()
    {
        try
        {
            parseOwnerHistoryAndExternalData();
        }
        catch(Exception exception)
        {
            handleInnerException(exception);
        }
        try
        {
            parseSimpleElements();
        } catch (Exception exception)
        {
            handleInnerException(exception);
        }

        try
        {
            parseComplexElements();
        } catch (Exception exception)
        {
            handleInnerException(exception);
        }
        return targetCOBie;
    }


    protected void parseOwnerHistoryAndExternalData()
    {
        handleExternalData();
        handleOwnerHistory();
    }

    public void setExternalData(ExternalData externalData)
    {
        this.externalData = externalData;
    }

    public void setOwnerHistory(OwnerHistory ownerHistory)
    {
        this.ownerHistory = ownerHistory;
    }

}
