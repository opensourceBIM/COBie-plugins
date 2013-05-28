package org.erdc.cobie.shared;

import java.util.ArrayList;
import java.util.HashMap;

public class CaseAgnosticStringList extends ArrayList<String>
{
    /**
     * 
     */
    private static final long serialVersionUID = -2618371365309788986L;
    private HashMap<String, String> caseAgnosticToCaseSensitive;

    public CaseAgnosticStringList(ArrayList<String> strings)
    {
        super();
        caseAgnosticToCaseSensitive = new HashMap<String, String>();
        for (String aString : strings)
        {
            caseAgnosticToCaseSensitive.put(aString.toLowerCase(), aString);
            add(aString);
        }
    }

    @Override
    public boolean add(String e)
    {
        boolean added = super.add(e.toLowerCase());
        caseAgnosticToCaseSensitive.put(e.toLowerCase(), e);
        return added;
    }

    @Override
    public boolean contains(Object o)
    {
        boolean contain;
        if (o instanceof String)
        {
            contain = super.contains(((String)o).toLowerCase());
        } else
        {
            contain = false;
        }
        return contain;

    }

    @Override
    public String get(int index)
    {
        return caseAgnosticToCaseSensitive.get(super.get(index));
    }

    public String getOriginalCaseSensitiveValue(String caseAgnosticString)
    {
        String originalString = null;
        if (contains(caseAgnosticString))
        {
            originalString = caseAgnosticToCaseSensitive.get(caseAgnosticString.toLowerCase());
        }
        return originalString;
    }

    @Override
    public int indexOf(Object o)
    {
        int index = -1;
        if (o instanceof String)
        {
            index = super.indexOf(((String)o).toLowerCase());
        }
        return index;
    }

    public String[] toStringArray()
    {
        // TODO Auto-generated method stub
        return (String[])super.toArray();
    }

}
