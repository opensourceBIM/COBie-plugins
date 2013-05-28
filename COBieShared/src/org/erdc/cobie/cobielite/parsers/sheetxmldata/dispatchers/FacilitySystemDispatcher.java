package org.erdc.cobie.cobielite.parsers.sheetxmldata.dispatchers;

import org.erdc.cobie.cobielite.FacilityType;
import org.erdc.cobie.cobielite.SystemCollectionType;
import org.erdc.cobie.cobielite.SystemType;
import org.erdc.cobie.cobielite.parsers.sheetxmldata.COBieLiteSheetXMLDataParser;
import org.erdc.cobie.cobielite.parsers.sheetxmldata.SystemParser;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.shared.cobiesheetxmldata.indices.IndexedCOBie;

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
    protected COBieLiteSheetXMLDataParser<org.erdc.cobie.sheetxmldata.SystemType, SystemType> createNewParser(
            org.erdc.cobie.sheetxmldata.SystemType sourceElement,
            SystemType newTargetElement)
    {
        return new SystemParser(sourceElement, newTargetElement, indexedCOBie);
    }

    @Override
    protected SystemType createNewTargetElement()
    {
        return targetCollection.addNewSystem();
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
