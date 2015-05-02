package org.bimserver.cobie.shared.transform.cobietab.cobielite;


import org.bimserver.cobie.shared.cobietab.IndexedCOBie;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.ConnectionDocument;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.ConnectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.FacilityType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.ConnectionCollectionType;

public class FacilityConnectionDispatcher extends
        TypicalParserDispatcher<org.nibs.cobie.tab.ConnectionType, ConnectionCollectionType, ConnectionType, FacilityType>
{

    public FacilityConnectionDispatcher(Iterable<org.nibs.cobie.tab.ConnectionType> childSourceElements, FacilityType targetParent,
            IndexedCOBie indexedCOBie)
    {
        super(childSourceElements, targetParent, indexedCOBie);
    }

    @Override
    protected COBieTabTransformer<org.nibs.cobie.tab.ConnectionType, ConnectionType> createNewParser(
            org.nibs.cobie.tab.ConnectionType sourceElement,
            ConnectionType newTargetElement)
    {
        return new ConnectionTransformer(sourceElement, newTargetElement, indexedCOBie);
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
