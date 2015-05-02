package org.bimserver.cobie.shared.transform.cobietab.cobielite;

import java.util.ArrayList;
















import org.bimserver.cobie.shared.cobietab.IndexedCOBie;
import org.buildingsmartalliance.docs.nbims03.cobie.core.CobieBaseType;

public abstract class IgnoreDuplicatesParserDispatcher<SOURCE_TYPE extends org.apache.xmlbeans.XmlObject, TARGET_COLLECTION_TYPE, TARGET_TYPE extends CobieBaseType, TARGET_PARENT_TYPE> extends COBieLiteParserDispatcher<SOURCE_TYPE, TARGET_COLLECTION_TYPE, TARGET_TYPE, TARGET_PARENT_TYPE>
{

    @Override
    protected void initializeParsers()
    {
        Iterable<SOURCE_TYPE> sourceArray = getSourceCollection();
        ArrayList<String> sourceKeys = new ArrayList<String>();
        if ((sourceArray != null) && sourceArray.iterator().hasNext())
        {
            targetCollection = getTargetCollection();
            for (SOURCE_TYPE sourceElement : sourceArray)
            {
                String key = getSourceElementKeyExpression(sourceElement);
                if(!sourceKeys.contains(key))
                {
                    TARGET_TYPE newTargetElement = createNewTargetElement();
                    COBieTabTransformer<SOURCE_TYPE, TARGET_TYPE> parser = createNewParser(sourceElement, newTargetElement);
                    parsers.add(parser);
                    sourceKeys.add(key);
                }

            }
        }
        
    }
    
    protected abstract String getSourceElementKeyExpression(SOURCE_TYPE sourceElement);

    public IgnoreDuplicatesParserDispatcher(Iterable<SOURCE_TYPE> childSourceElements, TARGET_PARENT_TYPE targetParent, IndexedCOBie indexedCOBie)
    {
        super(childSourceElements, targetParent, indexedCOBie);
    }


}
