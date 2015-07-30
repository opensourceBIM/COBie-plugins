package org.bimserver.cobie.shared.transform.cobietab.cobielite;


import org.bimserver.cobie.shared.cobietab.IndexedCOBie;
import org.bimserver.cobie.shared.utility.COBieUtility.CobieSheetName;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.ConnectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.AttributeCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.DocumentCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.IssueCollectionType;

public class ConnectionTransformer extends ChildTransformer<org.nibs.cobie.tab.ConnectionType, ConnectionType>
{

    public ConnectionTransformer(org.nibs.cobie.tab.ConnectionType cobieSheetXMLData, ConnectionType cobieLiteRowData, IndexedCOBie indexedCOBie)
    {
        super(cobieSheetXMLData, cobieLiteRowData, indexedCOBie);
    }

    @Override
    public AttributeCollectionType getNewAttributes()
    {
        return target.addNewConnectionAttributes();
    }

    @Override
    public DocumentCollectionType getNewDocuments()
    {
        return target.addNewConnectionDocuments();
    }

    @Override
    public IssueCollectionType getNewIssues()
    {
        return target.addNewConnectionIssues();
    }

    @Override
    protected void parseComplexElements()
    {
        // Does nothing

    }

    @Override
    protected void parseSimpleElements()
    {
        if (source.getSheetName().equalsIgnoreCase(CobieSheetName.Component.name()))
        {
            target.setConnectionAsset1Name(source.getRowName1());
            target.setConnectionAsset2Name(source.getRowName2());
            target.setConnectionAsset2PortName(source.getPortName2());
            target.setConnectionAsset1PortName(source.getPortName1());
            target.setConnectionCategory(source.getConnectionType());
            target.setConnectionDescription(source.getDescription());
            target.setConnectionName(source.getName());
            target.setExternalEntityName(source.getExtObject());
            target.setExternalID(source.getExtIdentifier());
            target.setExternalSystemName(source.getExtSystem());
        }

    }

}
