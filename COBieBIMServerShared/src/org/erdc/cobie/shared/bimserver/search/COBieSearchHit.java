package org.erdc.cobie.shared.bimserver.search;

public class COBieSearchHit<K, T> implements Comparable<COBieSearchHit<K, T>>
{
    private double distance;
    private T searchHit;
    private K searchTerm;

    public COBieSearchHit(K searchTerm, T searchHit, double distance)
    {
        setSearchTerm(searchTerm);
        setSearchHit(searchHit);
        setDistance(distance);
    }

    @Override
    public int compareTo(COBieSearchHit<K, T> o)
    {
        if (distance >= 0)
        {
            return 1;
        } else
        {
            return 0;
        }
    }

    public double getDistance()
    {
        return distance;
    }

    public T getSearchHit()
    {
        return searchHit;
    }

    public K getSearchTerm()
    {
        return searchTerm;
    }

    private final void setDistance(double distance)
    {
        this.distance = distance;
    }

    private final void setSearchHit(T searchHit)
    {
        this.searchHit = searchHit;
    }

    private final void setSearchTerm(K searchTerm)
    {
        this.searchTerm = searchTerm;
    }

}
