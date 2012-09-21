package org.bimserver.shared.cobie;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class CaseAgnosticStringList extends ArrayList<String>
{
	private HashMap<String,String> caseAgnosticToCaseSensitive;
	@Override
	public String get(int index)
	{
		return caseAgnosticToCaseSensitive.get(super.get(index));
	}

	public CaseAgnosticStringList(ArrayList<String> strings)
	{
		super();
		caseAgnosticToCaseSensitive =
				new HashMap<String,String>();
		for(String aString:strings)
		{
			caseAgnosticToCaseSensitive.put(aString.toLowerCase(),aString);
			add(aString);
		}
	}

	
	public String[] toStringArray()
	{
		// TODO Auto-generated method stub
		return (String[])super.toArray();
	}

	@Override
	public boolean contains(Object o)
	{
		boolean contain;
		if(o instanceof String)
		{
			contain= super.contains(((String) o).toLowerCase());
		}
		else
		{
			contain = false;
		}
		return contain;
		
	}
	@Override
	public boolean add(String e)
	{
		boolean added = super.add(e.toLowerCase());
		caseAgnosticToCaseSensitive.put(e.toLowerCase(),e);
		return added;
	}
	
	public String getOriginalCaseSensitiveValue(String caseAgnosticString)
	{
		String originalString = null;
		if(contains(caseAgnosticString))
		{
			originalString = caseAgnosticToCaseSensitive.get(caseAgnosticString.toLowerCase());
		}
		return originalString;
	}

	
	@Override
	public int indexOf(Object o)
	{
		int index = -1;
		if(o instanceof String)
			index = super.indexOf(((String) o).toLowerCase());
		return index;
	}
	
}
