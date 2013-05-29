package org.erdc.cobie.shared.merge;


//merges two subtypes of COBie MergeItem(A,B) 
//where C and D are their respective ruleset types and E is the result type
public abstract class COBieMerger<A extends COBieMergeItem<C>, B extends COBieMergeItem<D>, C, D, E> implements COBieMergable<A, B, C, D, E>
{
    protected A baseMergeItem;
    protected B revisionMergeItem;
    protected E result;
    protected COBieMergeState mergeState;

    public COBieMerger(A baseMergeItem, B revisionMergeItem)
    {
        this.baseMergeItem = baseMergeItem;
        this.revisionMergeItem = revisionMergeItem;
    }

    public E merge() throws Exception
    {
        return merge(baseMergeItem, revisionMergeItem);
    }

    @Override
    public final E merge(A baseMergeItem, B revisionMergeItem) throws Exception
    {
        E resultValue = null;
        prepareBaseMergeItem();
        prepareRevisionMergeItem();
        try
        {
            resultValue = prepareResult();
        } catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw e;
        }
        result = resultValue;
        return resultValue;
    }

    protected abstract void prepareBaseMergeItem();

    protected abstract E prepareResult() throws Exception;

    protected abstract void prepareRevisionMergeItem();

}
