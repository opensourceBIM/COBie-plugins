package org.bimserver.shared.cobie.search;

public interface COBieSearchHitEvaluatable<T,K>
{
	 boolean acceptMatch(COBieSearchHit<T,K> searchHit);
}
