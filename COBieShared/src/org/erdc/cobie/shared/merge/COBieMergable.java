package org.erdc.cobie.shared.merge;

//Operations required to perform a merge between two subtypes of COBie MergeItem(A,B) 
//and C and D are their respective ruleset types and E is the result type

public interface COBieMergable<A extends COBieMergeItem<C>, B extends COBieMergeItem<D>, C, D, E>
{
    public E merge(A baseMergeItem, B revisionMergeItem) throws Exception;

}
