package org.erdc.cobie.shared.utils;

import java.util.ArrayList;
import java.util.List;

public class CollectionUtils
{
    public static <T> void appendList(List<T> list, T... items)
    {
        for (T item : items)
        {
            list.add(item);
        }
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
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     */
    public static <T> void instantiateArray(Class<T> elementClass, T[] array) throws InstantiationException, IllegalAccessException
    {
        for (int i = 0; i < array.length; i++)
        {
            array[i] = elementClass.newInstance();
        }
    }
    
    public static <T> void addAllIgnoreDuplicates(List<T> collection, List<T> newEntities)
    {
        for(T newEntity : newEntities)
        {
            if(!collection.contains(newEntity))
                collection.add(newEntity);
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
}
