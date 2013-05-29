package org.erdc.cobie.cobielite.parsers.sheetxmldata.dispatchers;

import org.erdc.cobie.cobielite.AttributeCollectionType;
import org.erdc.cobie.cobielite.CobieBaseType;
import org.erdc.cobie.cobielite.parsers.TypicalParserDispatcher;
import org.erdc.cobie.cobielite.parsers.sheetxmldata.AttributeParser;
import org.erdc.cobie.cobielite.parsers.sheetxmldata.COBieLiteSheetXMLDataParser;
import org.erdc.cobie.shared.cobiesheetxmldata.indices.IndexedCOBie;
import org.erdc.cobie.sheetxmldata.AttributeType;

public class AttributeDispatcher extends
        TypicalParserDispatcher<AttributeType, AttributeCollectionType, org.erdc.cobie.cobielite.AttributeType, CobieBaseType>
{

    private AttributeCollectionType attributeCollection;

    public AttributeDispatcher(Iterable<AttributeType> childSourceElements, CobieBaseType targetParent, IndexedCOBie indexedCOBie,
            AttributeCollectionType attributeCollection)
    {
        super(childSourceElements, targetParent, indexedCOBie);
        this.attributeCollection = attributeCollection;
    }

    @Override
    protected COBieLiteSheetXMLDataParser<AttributeType, org.erdc.cobie.cobielite.AttributeType> createNewParser(
            AttributeType sourceElement,
            org.erdc.cobie.cobielite.AttributeType newTargetElement)
    {
        return new AttributeParser(sourceElement, newTargetElement, indexedCOBie);
    }

    @Override
    protected org.erdc.cobie.cobielite.AttributeType createNewTargetElement()
    {
        return targetCollection.addNewAttribute();
    }

    @Override
    protected AttributeCollectionType getTargetCollection()
    {
        return attributeCollection;
    }

}
