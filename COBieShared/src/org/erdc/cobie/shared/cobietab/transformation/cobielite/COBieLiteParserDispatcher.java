package org.erdc.cobie.shared.cobietab.transformation.cobielite;


import org.buildingsmartalliance.docs.nbims03.cobie.core.CobieBaseType;
import org.erdc.cobie.shared.cobietab.IndexedCOBie;
import org.erdc.cobie.shared.transformation.TransformerDispatcher;

public abstract class COBieLiteParserDispatcher<SOURCE_TYPE extends org.apache.xmlbeans.XmlObject, TARGET_COLLECTION_TYPE, TARGET_TYPE extends CobieBaseType, TARGET_PARENT_TYPE> 
extends TransformerDispatcher<SOURCE_TYPE, TARGET_COLLECTION_TYPE, TARGET_TYPE, TARGET_PARENT_TYPE>
{
    protected Iterable<SOURCE_TYPE> sourceCollection;
    protected TARGET_COLLECTION_TYPE targetCollection;
    protected TARGET_PARENT_TYPE targetParent;
    protected final IndexedCOBie indexedCOBie;

    public COBieLiteParserDispatcher(Iterable<SOURCE_TYPE> childSourceElements, TARGET_PARENT_TYPE targetParent, IndexedCOBie indexedCOBie)
    {
        super(childSourceElements, targetParent);
        this.indexedCOBie = indexedCOBie;
        this.sourceCollection = childSourceElements;
        this.targetParent = targetParent;
        initializeParsers();
    }

    protected abstract void initializeParsers();

    protected abstract COBieTabTransformer<SOURCE_TYPE, TARGET_TYPE> createNewParser(SOURCE_TYPE sourceElement, TARGET_TYPE newTargetElement);

    @Override
    protected void parseFailure(Exception exception)
    {
        // TODO Handle parser exceptions
        
    }

    
}
