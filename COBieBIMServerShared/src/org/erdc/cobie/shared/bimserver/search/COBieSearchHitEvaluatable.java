package org.erdc.cobie.shared.bimserver.search;

public interface COBieSearchHitEvaluatable<T, K>
{
    boolean acceptMatch(COBieSearchHit<T, K> searchHit);
}
