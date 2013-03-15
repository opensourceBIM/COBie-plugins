package org.erdc.cobie.shared.search.property;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.erdc.cobie.shared.search.COBieSearchHit;

// TODO: Auto-generated Javadoc
/**
 * The Class ModelSearchEngine.
 * 
 * @param <S>
 *            the search target type
 * @param <T>
 *            the search term type
 * @param <K>
 *            the match type
 */
public abstract class ModelSearchEngine<S, T, K>
{

    /** The best match. */
    protected COBieSearchHit<T, K> bestMatch;

    /** The prioritized search terms. */
    protected List<T> prioritizedSearchTerms;

    /** The search hits. */
    protected Map<T, COBieSearchHit<T, K>> searchHits;

    /** The search target. */
    protected S searchTarget;

    /**
     * Instantiates a new search engine
     */
    public ModelSearchEngine(List<T> searchTerms, S searchTarget)
    {
        super();
        setPrioritizedSearchTerms(searchTerms);
        setSearchTarget(searchTarget);
        setSearchHits(new HashMap<T, COBieSearchHit<T, K>>());
        init();
        search();
    }

    /**
     * Gets the best match.
     * 
     * @return the best match
     */
    public final COBieSearchHit<T, K> getBestMatch()
    {
        return bestMatch;
    }

    public List<T> getPrioritizedSearchTerms()
    {
        return prioritizedSearchTerms;
    }

    public Map<T, COBieSearchHit<T, K>> getSearchHits()
    {
        return searchHits;
    }

    public S getSearchTarget()
    {
        return searchTarget;
    }

    protected void init()
    {
        setBestMatch(new COBieSearchHit<T, K>(null, null, Double.MAX_VALUE));
        initializeHashMapsToNullValues();
    }

    private void initializeHashMapsToNullValues()
    {
        setSearchHits(new HashMap<T, COBieSearchHit<T, K>>());
        for (T searchTerm : getPrioritizedSearchTerms())
        {
            searchHits.put(searchTerm, null);
        }
    }

    /**
     * Match mets threshold.
     * 
     * @return true, if successful
     */
    public abstract boolean matchMetsThreshold();

    protected abstract void search();

    /**
     * Sets the best match.
     * 
     * @param bestMatch
     *            the best match
     */
    protected final void setBestMatch(COBieSearchHit<T, K> bestMatch)
    {
        this.bestMatch = bestMatch;
    }

    protected void setNewKeywordBestMatch(T searchString, K property, double distance)
    {
        COBieSearchHit<T, K> searchHit = new COBieSearchHit<T, K>(searchString, property, distance);
        searchHits.put(searchString, searchHit);
        if (searchHit.getDistance() < getBestMatch().getDistance())
        {
            setBestMatch(searchHit);
        }
    }

    public void setPrioritizedSearchTerms(List<T> prioritizedSearchTerms)
    {
        this.prioritizedSearchTerms = prioritizedSearchTerms;
    }

    protected void setSearchHits(Map<T, COBieSearchHit<T, K>> searchHits)
    {
        this.searchHits = searchHits;
    }

    protected void setSearchTarget(S searchTarget)
    {
        this.searchTarget = searchTarget;
    }

}