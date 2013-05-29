package org.erdc.cobie.shared.search;

public interface COBieSearchHitEvaluatable<T, K>
{
    boolean acceptMatch(COBieSearchHit<T, K> searchHit);
}
