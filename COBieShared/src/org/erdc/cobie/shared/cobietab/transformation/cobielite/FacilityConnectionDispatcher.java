package org.erdc.cobie.shared.cobietab.transformation.cobielite;


import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.ConnectionDocument;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.ConnectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.FacilityType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.ConnectionCollectionType;
import org.erdc.cobie.shared.cobietab.IndexedCOBie;

public class FacilityConnectionDispatcher extends
        TypicalParserDispatcher<org.erdc.cobie.sheetxmldata.ConnectionType, ConnectionCollectionType, ConnectionType, FacilityType>
{

    public FacilityConnectionDispatcher(Iterable<org.erdc.cobie.sheetxmldata.ConnectionType> childSourceElements, FacilityType targetParent,
            IndexedCOBie indexedCOBie)
    {
        super(childSourceElements, targetParent, indexedCOBie);
    }

    @Override
    protected COBieTabTransformer<org.erdc.cobie.sheetxmldata.ConnectionType, ConnectionType> createNewParser(
            org.erdc.cobie.sheetxmldata.ConnectionType sourceElement,
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
