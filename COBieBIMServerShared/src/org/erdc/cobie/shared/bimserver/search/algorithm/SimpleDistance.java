package org.erdc.cobie.shared.bimserver.search.algorithm;

public class SimpleDistance
{
    protected static int occurenceBasedDistance(String searchString, String targetString)
    {
        String[] splitSearchString = searchString.split(" ");
        int hits = 0;
        for (String subString : splitSearchString)
        {
            hits = (hits + targetString.split(subString).length) - 1;
        }
        int distance = targetString.replace(" ", "").length() - (hits * searchString.replace(" ", "").length());
        return distance;
    }
}
