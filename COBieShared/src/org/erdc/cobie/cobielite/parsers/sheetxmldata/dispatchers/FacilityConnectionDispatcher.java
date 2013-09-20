package org.erdc.cobie.cobielite.parsers.sheetxmldata.dispatchers;


import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.ConnectionDocument;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.ConnectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.FacilityType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.ConnectionCollectionType;
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
        return (ConnectionType)targetCollection.addNewConnection().substitute(ConnectionDocument.type.getDocumentElementName(), ConnectionType.type);
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
