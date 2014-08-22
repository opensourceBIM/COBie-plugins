package org.erdc.cobie.shared.cobietab.transformation.cobielite;


import org.buildingsmartalliance.docs.nbims03.cobie.core.CobieBaseType;
import org.erdc.cobie.shared.cobietab.IndexedCOBie;

public abstract class TypicalParserDispatcher<SOURCE_TYPE extends org.apache.xmlbeans.XmlObject, TARGET_COLLECTION_TYPE, TARGET_TYPE extends CobieBaseType, TARGET_PARENT_TYPE> extends
    COBieLiteParserDispatcher<SOURCE_TYPE, TARGET_COLLECTION_TYPE, TARGET_TYPE, TARGET_PARENT_TYPE>
{
    public TypicalParserDispatcher(Iterable<SOURCE_TYPE> childSourceElements, TARGET_PARENT_TYPE targetParent, IndexedCOBie indexedCOBie)
    {
        super(childSourceElements, targetParent, indexedCOBie);
    }

    
    @Override
    protected void initializeParsers()
    {
        Iterable<SOURCE_TYPE> sourceArray = getSourceCollection();
        if ((sourceArray != null) && sourceArray.iterator().hasNext())
        {
            targetCollection = getTargetCollection();
            for (SOURCE_TYPE sourceElement : sourceArray)
            {
                TARGET_TYPE newTargetElement = createNewTargetElement();
                COBieTabTransformer<SOURCE_TYPE, TARGET_TYPE> parser = createNewParser(sourceElement, newTargetElement);
                parsers.add(parser);
            }
        }
        
    }
}
