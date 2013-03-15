package org.erdc.cobie.cobielite.parsers.sheetxmldata;

import org.erdc.cobie.cobielite.AttributeCollectionType;
import org.erdc.cobie.cobielite.ConnectionType;
import org.erdc.cobie.cobielite.DocumentCollectionType;
import org.erdc.cobie.cobielite.IssueCollectionType;
import org.erdc.cobie.shared.COBieUtility.CobieSheetName;
import org.erdc.cobie.shared.cobiesheetxmldata.indices.IndexedCOBie;

public class ConnectionParser extends TypicalParser<org.erdc.cobie.sheetxmldata.ConnectionType, ConnectionType>
{

    public ConnectionParser(org.erdc.cobie.sheetxmldata.ConnectionType cobieSheetXMLData, ConnectionType cobieLiteRowData, IndexedCOBie indexedCOBie)
    {
        super(cobieSheetXMLData, cobieLiteRowData, indexedCOBie);
    }

    @Override
    public AttributeCollectionType getNewAttributes()
    {
        return targetCOBie.addNewAttributes();
    }

    @Override
    public DocumentCollectionType getNewDocuments()
    {
        return targetCOBie.addNewDocuments();
    }

    @Override
    public IssueCollectionType getNewIssues()
    {
        return targetCOBie.addNewIssues();
    }

    @Override
    protected void parseComplexElements()
    {
        // Does nothing

    }

    @Override
    protected void parseSimpleElements()
    {
        if (sourceCOBie.getSheetName().equalsIgnoreCase(CobieSheetName.Component.name()))
        {
            targetCOBie.setConnectionAsset1Name(sourceCOBie.getRowName1());
            targetCOBie.setConnectionAsset2Name(sourceCOBie.getRowName2());
            targetCOBie.setConnectionAsset2PortName(sourceCOBie.getPortName2());
            targetCOBie.setConnectionAsset1PortName(sourceCOBie.getPortName1());
            targetCOBie.setConnectionCategory(sourceCOBie.getConnectionType());
            targetCOBie.setConnectionDescription(sourceCOBie.getDescription());
            targetCOBie.setConnectionName(sourceCOBie.getName());
            targetCOBie.setExternalEntityName(sourceCOBie.getExtObject());
            targetCOBie.setExternalID(sourceCOBie.getExtIdentifier());
            targetCOBie.setExternalSystemName(sourceCOBie.getExtSystem());
        }

    }

}
