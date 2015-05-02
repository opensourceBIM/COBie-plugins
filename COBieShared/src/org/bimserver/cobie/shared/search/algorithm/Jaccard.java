package org.bimserver.cobie.shared.search.algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Accumulate Jaccard Similarity
 * 
 * @author hattori_tsukasa
 * 
 */
public class Jaccard
{

    /**
     * 
     * @param a
     * @param b
     * @return
     */
    public static double calc(Object[] a, Object[] b)
    {
        int alen = a.length;
        int blen = b.length;
        Set<Object> set = new HashSet<Object>(alen + blen);
        set.addAll(Arrays.asList(a));
        set.addAll(Arrays.asList(b));

        return innerCalc(alen, blen, set.size());
    }

//    private static <K extends Comparable<K>> double calcByMerge(K[] a, int offsetA, K[] b, int offsetB)
//    {
//
//        int aLen = a.length - offsetA;
//        int bLen = b.length - offsetB;
//
//        int overlap = 0;
//        int i = offsetA;
//        int j = offsetB;
//        while ((i < a.length) && (j < b.length))
//        {
//            if (a[i].equals(b[j]))
//            {
//                overlap++;
//                i++;
//                j++;
//            } else if (a[i].compareTo(b[j]) < 0)
//            {
//                i++;
//            } else
//            {
//                j++;
//            }
//        }
//        return overlap / (double)((aLen + bLen) - overlap);
//
//    }

    /**
     * 
     * @param alen
     * @param blen
     * @param union
     * @return
     */
    private static double innerCalc(int alen, int blen, int union)
    {
        double overlap = (alen + blen) - union;
        if (overlap <= 0)
        {
            return 0.0;
        }
        return overlap / union;
    }

    public Jaccard()
    {
        super();
    }
}
