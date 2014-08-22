package org.erdc.cobie.shared.cobietab.transformation.cobielite;


import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.FacilityType;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.SystemDocument;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.SystemType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.SystemCollectionType;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.shared.cobietab.IndexedCOBie;

public class FacilitySystemDispatcher extends
        IgnoreDuplicatesParserDispatcher
        <org.erdc.cobie.sheetxmldata.SystemType, SystemCollectionType, SystemType, FacilityType>
{

    public FacilitySystemDispatcher(Iterable<org.erdc.cobie.sheetxmldata.SystemType> childSourceElements, FacilityType targetParent,
            IndexedCOBie indexedCOBie)
    {
        super(childSourceElements, targetParent, indexedCOBie);
    }

    @Override
    protected COBieTabTransformer<org.erdc.cobie.sheetxmldata.SystemType, SystemType> createNewParser(
            org.erdc.cobie.sheetxmldata.SystemType sourceElement,
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
    protected String getSourceElementKeyExpression(org.erdc.cobie.sheetxmldata.SystemType sourceElement)
    {
        return sourceElement.getName()+COBieUtility.getCOBieDelim()+sourceElement.getCategory();
    }

}
