package org.bimserver.cobie.shared.transform.spreadsheetml;

import java.util.ArrayList;


public abstract class TransformerDispatcher<TSource, TTargetCollection, TTarget, TTargetParent>
{
    protected Iterable<TSource> sourceCollection;
    protected TTargetCollection targetCollection;
    protected TTargetParent targetParent;
    protected ArrayList<Transformer<TSource, TTarget>> parsers;

    public TransformerDispatcher(Iterable<TSource> childSourceElements, TTargetParent targetParent)
    {
        this.parsers = new ArrayList<Transformer<TSource, TTarget>>();
        this.sourceCollection = childSourceElements;
        this.targetParent = targetParent;
    }

    protected abstract Transformer<TSource, TTarget> createNewParser(TSource sourceElement, TTarget newTargetElement);

    protected abstract TTarget createNewTargetElement();

    public final void dispatchParsers()
    {
        for (Transformer<TSource, TTarget> parser : parsers)
        {
            try
            {
                parser.transform();
            } catch (Exception ex)
            {
                parseFailure(ex);
            }
        }
    }

    protected final Iterable<TSource> getSourceCollection()
    {
        return sourceCollection;
    }

    protected abstract void parseFailure(Exception exception);
    
    protected abstract TTargetCollection getTargetCollection();
}
