package org.bimserver.cobie.shared.transform.cobietab.cobielite;


import org.bimserver.cobie.shared.cobietab.IndexedCOBie;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.AttributeDocument;
import org.buildingsmartalliance.docs.nbims03.cobie.core.AttributeCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.CobieBaseType;
import org.nibs.cobie.tab.AttributeType;

public class AttributeDispatcher extends
        TypicalParserDispatcher<AttributeType, AttributeCollectionType, org.buildingsmartalliance.docs.nbims03.cobie.cobielite.AttributeType, CobieBaseType>
{

    private AttributeCollectionType attributeCollection;

    public AttributeDispatcher(Iterable<AttributeType> childSourceElements, CobieBaseType targetParent, IndexedCOBie indexedCOBie,
            AttributeCollectionType attributeCollection)
    {
        super(childSourceElements, targetParent, indexedCOBie);
        this.attributeCollection = attributeCollection;
    }

    @Override
    protected COBieTabTransformer<AttributeType, org.buildingsmartalliance.docs.nbims03.cobie.cobielite.AttributeType> createNewParser(
            AttributeType sourceElement,
            org.buildingsmartalliance.docs.nbims03.cobie.cobielite.AttributeType newTargetElement)
    {
        return new AttributeTransformer(sourceElement, newTargetElement, indexedCOBie);
    }

    @Override
    protected org.buildingsmartalliance.docs.nbims03.cobie.cobielite.AttributeType createNewTargetElement()
    {
        return (org.buildingsmartalliance.docs.nbims03.cobie.cobielite.AttributeType)targetCollection.addNewAttribute().substitute(AttributeDocument.type.getAttributeTypeAttributeName(), org.buildingsmartalliance.docs.nbims03.cobie.cobielite.AttributeType.type);
    }

    @Override
    protected AttributeCollectionType getTargetCollection()
    {
        return attributeCollection;
    }

}
