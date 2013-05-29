package org.erdc.cobie.shared.parsers;

import java.util.ArrayList;


public abstract class ParserDispatcher<SOURCE_TYPE, TARGET_COLLECTION_TYPE, TARGET_TYPE, TARGET_PARENT_TYPE>
{
    protected Iterable<SOURCE_TYPE> sourceCollection;
    protected TARGET_COLLECTION_TYPE targetCollection;
    protected TARGET_PARENT_TYPE targetParent;
    protected ArrayList<Parser<SOURCE_TYPE, TARGET_TYPE>> parsers;

    public ParserDispatcher(Iterable<SOURCE_TYPE> childSourceElements, TARGET_PARENT_TYPE targetParent)
    {
        this.parsers = new ArrayList<Parser<SOURCE_TYPE, TARGET_TYPE>>();
        this.sourceCollection = childSourceElements;
        this.targetParent = targetParent;
    }

    protected abstract Parser<SOURCE_TYPE, TARGET_TYPE> createNewParser(SOURCE_TYPE sourceElement, TARGET_TYPE newTargetElement);

    protected abstract TARGET_TYPE createNewTargetElement();

    public final void dispatchParsers()
    {
        for (Parser<SOURCE_TYPE, TARGET_TYPE> parser : parsers)
        {
            try
            {
                parser.parse();
            } catch (Exception ex)
            {
                parseFailure(ex);
            }
        }
    }

    protected final Iterable<SOURCE_TYPE> getSourceCollection()
    {
        return sourceCollection;
    }

    protected abstract void parseFailure(Exception exception);
    
    protected abstract TARGET_COLLECTION_TYPE getTargetCollection();
}
