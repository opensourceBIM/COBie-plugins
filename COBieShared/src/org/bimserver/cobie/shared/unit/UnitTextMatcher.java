package org.bimserver.cobie.shared.unit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

import org.bimserver.cobie.shared.search.algorithm.StringDistanceCalculator;
import org.bimserver.cobie.shared.search.algorithm.StringDistanceCalculator.EditDistanceAlgorithmEnum;
import org.bimserver.models.ifc2x3tc1.IfcUnit;

public abstract class UnitTextMatcher implements Comparable<UnitTextMatcher>
{
    private static final double ROUNDING_FACTOR = 100;
    private EditDistanceAlgorithmEnum searchAlgorithm = EditDistanceAlgorithmEnum.Levenshtein;
    private EditDistanceAlgorithmEnum secondarySearchAlgorithm = EditDistanceAlgorithmEnum.Jaccard;
    protected String searchString;
    protected ArrayList<String> targetStrings;

    protected HashMap<String, Double> targetStringDistances;
    protected double searchRank;
    protected double secondarySearchRank;

    public UnitTextMatcher(String searchString)
    {
        targetStrings = new ArrayList<String>();
        targetStringDistances = new HashMap<String, Double>();
        this.searchString = searchString;
        initializeTargetStrings();
        calculateSearchRank();
    }

    protected final void calculateSearchRank()
    {
        double minimumDistance = Double.MAX_VALUE;
        double tmpDistance;
        double contenderSecondaryDistance = Double.MAX_VALUE, championSecondaryDistance = Double.MAX_VALUE;
        String bestMatch = "";
        for (String targetString : targetStrings)
        {
            tmpDistance = StringDistanceCalculator.getEditDistance(searchString.toLowerCase(), targetString.toLowerCase(), searchAlgorithm);
            targetStringDistances.put(targetString, tmpDistance);
            if (tmpDistance < minimumDistance)
            {
                minimumDistance = tmpDistance;
                bestMatch = targetString;
                championSecondaryDistance = StringDistanceCalculator.getEditDistance(searchString.toLowerCase(), bestMatch.toLowerCase(),
                        secondarySearchAlgorithm);
            }
            if (tmpDistance == minimumDistance)
            {
                contenderSecondaryDistance = StringDistanceCalculator.getEditDistance(searchString.toLowerCase(), targetString.toLowerCase(),
                        secondarySearchAlgorithm);
                if (contenderSecondaryDistance < championSecondaryDistance)
                {
                    minimumDistance = tmpDistance;
                    bestMatch = targetString;
                    championSecondaryDistance = StringDistanceCalculator.getEditDistance(searchString.toLowerCase(), bestMatch.toLowerCase(),
                            secondarySearchAlgorithm);
                }

            }
        }
        secondarySearchRank = championSecondaryDistance;
        searchRank = minimumDistance;
    }

    @Override
    public final int compareTo(UnitTextMatcher o)
    {
        if (searchRank == o.getMatchDistance())
        {
            return distanceToRank(secondarySearchRank) - distanceToRank(o.secondarySearchRank);
        } else
        {
            return distanceToRank(searchRank) - distanceToRank(o.getMatchDistance());
        }
    }

    private int distanceToRank(double distance)
    {
        int roundedDistance = Integer.MAX_VALUE;
        double tmpDouble = distance;
        tmpDouble = tmpDouble * ROUNDING_FACTOR;
        tmpDouble = Math.ceil(tmpDouble);
        if (tmpDouble < Integer.MAX_VALUE)
        {
            roundedDistance = (int)tmpDouble;
        }
        return roundedDistance;
    }

    public final String getBestStringMatch()
    {
        ArrayList<Double> orderedDistances = new ArrayList<Double>(targetStringDistances.values());
        Collections.sort(orderedDistances);
        String keyReturn = null;
        double minRank = orderedDistances.get(0);
        for (String key : targetStringDistances.keySet())
        {
            if ((targetStringDistances.get(key) == minRank) && (keyReturn == null))
            {
                keyReturn = key;
            }
        }
        return keyReturn;
    }

    public double getMatchDistance()
    {
        return searchRank;
    }

    public String getSearchString()
    {
        return searchString;
    }

    protected abstract String[] getTargetStringArray();

    public HashMap<String, Double> getTargetStringDistances()
    {
        return targetStringDistances;
    }

    public ArrayList<String> getTargetStrings()
    {
        return targetStrings;
    }

    public abstract IfcUnit getTargetUnit();

    protected final void initializeTargetStrings()
    {
        targetStrings = new ArrayList<String>(Arrays.asList(getTargetStringArray()));
    }

}
