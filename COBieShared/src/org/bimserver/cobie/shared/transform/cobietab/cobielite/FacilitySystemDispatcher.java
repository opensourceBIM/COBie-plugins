package org.bimserver.cobie.shared.transform.cobietab.cobielite;


import org.bimserver.cobie.shared.cobietab.IndexedCOBie;
import org.bimserver.cobie.shared.utility.COBieUtility;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.FacilityType;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.SystemDocument;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.SystemType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.SystemCollectionType;

public class FacilitySystemDispatcher extends
        IgnoreDuplicatesParserDispatcher
        <org.nibs.cobie.tab.SystemType, SystemCollectionType, SystemType, FacilityType>
{

    public FacilitySystemDispatcher(Iterable<org.nibs.cobie.tab.SystemType> childSourceElements, FacilityType targetParent,
            IndexedCOBie indexedCOBie)
    {
        super(childSourceElements, targetParent, indexedCOBie);
    }

    @Override
    protected COBieTabTransformer<org.nibs.cobie.tab.SystemType, SystemType> createNewParser(
            org.nibs.cobie.tab.SystemType sourceElement,
            SystemType newTargetElement)
    {
        return new SystemTransformer(sourceElement, newTargetElement, indexedCOBie);
    }

    @Override
    protected SystemType createNewTargetElement()
    {
        return (SystemType)targetCollection.addNewSystem().substitute(SystemDocument.type.getDocumentElementName(), SystemType.type);
    }

    @Override
    protected SystemCollectionType getTargetCollection()
    {
        SystemCollectionType systems = targetParent.getSystems();
        if (systems == null)
        {
            systems = targetParent.addNewSystems();
        }
        return systems;
    }

    @Override
    protected String getSourceElementKeyExpression(org.nibs.cobie.tab.SystemType sourceElement)
    {
        return sourceElement.getName()+COBieUtility.getCOBieDelim()+sourceElement.getCategory();
    }

}
