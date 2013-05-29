package org.erdc.cobie.cobielite.parsers.sheetxmldata.dispatchers;

import org.erdc.cobie.cobielite.ConnectionCollectionType;
import org.erdc.cobie.cobielite.ConnectionType;
import org.erdc.cobie.cobielite.FacilityType;
import org.erdc.cobie.cobielite.parsers.TypicalParserDispatcher;
import org.erdc.cobie.cobielite.parsers.sheetxmldata.COBieLiteSheetXMLDataParser;
import org.erdc.cobie.cobielite.parsers.sheetxmldata.ConnectionParser;
import org.erdc.cobie.shared.cobiesheetxmldata.indices.IndexedCOBie;

public class FacilityConnectionDispatcher extends
        TypicalParserDispatcher<org.erdc.cobie.sheetxmldata.ConnectionType, ConnectionCollectionType, ConnectionType, FacilityType>
{

    public FacilityConnectionDispatcher(Iterable<org.erdc.cobie.sheetxmldata.ConnectionType> childSourceElements, FacilityType targetParent,
            IndexedCOBie indexedCOBie)
    {
        super(childSourceElements, targetParent, indexedCOBie);
    }

    @Override
    protected COBieLiteSheetXMLDataParser<org.erdc.cobie.sheetxmldata.ConnectionType, ConnectionType> createNewParser(
            org.erdc.cobie.sheetxmldata.ConnectionType sourceElement,
            ConnectionType newTargetElement)
    {
        return new ConnectionParser(sourceElement, newTargetElement, indexedCOBie);
    }

    @Override
    protected ConnectionType createNewTargetElement()
    {
        return targetCollection.addNewConnection();
    }

    @Override
    protected ConnectionCollectionType getTargetCollection()
    {
        ConnectionCollectionType connections = targetParent.getConnections();
        if (connections == null)
        {
            connections = targetParent.addNewConnections();
        }
        return connections;
    }

}
