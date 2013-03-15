package org.erdc.cobie.shared.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CollectionUtils
{
    public static <K, T> List<T> getHashMapValues(HashMap<K, T> hashMap)
    {
        ArrayList<T> values = new ArrayList<T>(hashMap.size());

        for (K key : hashMap.keySet())
        {
            values.add(hashMap.get(key));
        }

        return values;
    }

    /**
     * Instantiates the elements of an array. This is useful because some Java
     * methods set arrays by reference and require the array's elements to be
     * instantiated.
     * 
     * @param elementClass
     *            The class of the array to be instantiated.
     * @param array
     *            The array to be instantiated.
     */
    // *** THIS SHOULD PROBABLY HANDLE EXCEPTIONS IN A MORE ROBUST WAY ***
    public static <T> void instantiateArray(Class<T> elementClass, T[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            try
            {
                array[i] = elementClass.newInstance();
            }

            catch (InstantiationException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            catch (IllegalAccessException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
    public static <T> List<T> makeList(T... items)
    {
		List<T> list = new ArrayList<T>();
	
		for (T item : items)
		{
		    list.add(item);
		}
	
		return list;
    }
    
    public static <T> void appendList(List<T> list, T... items)
    {
		for (T item : items)
		{
		    list.add(item);
		}
    }
}
