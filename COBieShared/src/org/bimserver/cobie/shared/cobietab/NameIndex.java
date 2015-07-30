package org.bimserver.cobie.shared.cobietab;

import java.util.ArrayList;
import java.util.HashMap;

import org.bimserver.cobie.shared.utility.COBieUtility;

public abstract class NameIndex<SOURCE_TYPE> extends HashMap<String, ArrayList<SOURCE_TYPE>>
{
    /**
     * 
     */
    private static final long serialVersionUID = -5533611662570465428L;
    private static final boolean DEFAULT_EXCLUDE_NA_KEYS = false;
    private final boolean excludeNAKeys;

    public NameIndex(SOURCE_TYPE[] sourceCollection)
    {
        this.excludeNAKeys = DEFAULT_EXCLUDE_NA_KEYS;
        for (SOURCE_TYPE sourceEntry : sourceCollection)
        {
            ArrayList<String> nameList = getNameList(sourceEntry);
            manageHashMap(nameList, sourceEntry);
        }
    }

    public NameIndex(SOURCE_TYPE[] sourceCollection, boolean excludeNAKeys)
    {
        this.excludeNAKeys = excludeNAKeys;
        for (SOURCE_TYPE sourceEntry : sourceCollection)
        {
            ArrayList<String> nameList = getNameList(sourceEntry);
            manageHashMap(nameList, sourceEntry);
        }
    }

    private void addToListIgnoreDuplicates(String name, ArrayList<String> names)
    {
        if (!names.contains(name))
        {
            names.add(name);
        }

    }

    protected abstract String getEntryKeyField(SOURCE_TYPE sourceEntry);

    protected ArrayList<String> getNameList(SOURCE_TYPE sourceEntry)
    {
        ArrayList<String> nameList = new ArrayList<String>();
        String name;
        name = getEntryKeyField(sourceEntry);
        if (!COBieUtility.isNA(name) || !excludeNAKeys)
        {
            if (isDelimList(name))
            {
                String[] names = name.split(COBieUtility.getCOBieDelim());
                for (String nameEntry : names)
                {
                    addToListIgnoreDuplicates(nameEntry, nameList);
                }
            } else
            {
                addToListIgnoreDuplicates(name, nameList);
            }
        }
        return nameList;
    }

    public boolean isDelimList(String spaceNames)
    {
        boolean isDelim = false;
        if (spaceNames.contains(COBieUtility.getCOBieDelim()))
        {
            isDelim = true;
        }
        return isDelim;
    }

    public boolean isIgnoreNA()
    {
        return excludeNAKeys;
    }

    protected void manageHashMap(ArrayList<String> nameList, SOURCE_TYPE sourceEntry)
    {
        for (String name : nameList)
        {
            ArrayList<SOURCE_TYPE> matchedEntries = new ArrayList<SOURCE_TYPE>();
            if (containsKey(name))
            {
                matchedEntries = get(name);
            }
            if (!matchedEntries.contains(sourceEntry))
            {
                matchedEntries.add(sourceEntry);
            }
            put(name, matchedEntries);
        }
    }

}
