package org.bimserver.shared.cobie.searchalgorithms;

public class StringDistanceCalculator
{
	public enum EditDistanceAlgorithmEnum {Levenshtein,Jaccard,OccurenceBased,Composite};
	
	public static double getEditDistance(String searchString,String targetKeyword,
			EditDistanceAlgorithmEnum distanceAlgorithm)
	{
		int intDistance = Integer.MAX_VALUE;
		double doubleDistance = Double.MAX_VALUE;
		switch(distanceAlgorithm)
		{
		case Levenshtein:
			intDistance = 
				LevenshteinDistance.computeLevenshteinDistance(searchString, targetKeyword);
			if(targetKeyword.length()>0)
				doubleDistance = (double)intDistance/(double)targetKeyword.length();
			break;
		case OccurenceBased:
			intDistance = 
				SimpleDistance.occurenceBasedDistance(searchString, targetKeyword);
			if(targetKeyword.length()>0)
			doubleDistance = intDistance/targetKeyword.length();
			break;
		case Jaccard:
			doubleDistance = 
						Jaccard.calc(searchString.split(" "),targetKeyword.split(" "));
		
		}
		return doubleDistance;
	}
	
}
