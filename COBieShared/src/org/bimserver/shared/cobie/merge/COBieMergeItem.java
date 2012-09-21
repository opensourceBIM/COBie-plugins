package org.bimserver.shared.cobie.merge;

import java.util.List;

import org.bimserver.cobie.cobielite.COBIEDocument;
import org.bimserver.shared.cobie.COBIESheetDictionary;
import org.bimserver.shared.cobie.idm.COBieIDMFilterable;
//merges based on merge rules of type T 
public abstract class COBieMergeItem<T> 
	implements Comparable<COBieMergeItem<T>>

{

	protected COBIEDocument cobie;
	protected COBIESheetDictionary cobieSheetDictionary;
	protected T mergeRules;

	public COBieMergeItem(COBIEDocument cobie, T mergeRules)
	{
		this.cobie = cobie;
		this.mergeRules = mergeRules;
		init();
	}

	public final COBIEDocument getCobie()
	{
		return cobie;
	}

	public final COBIESheetDictionary getCobieSheetDictionary()
	{
		return cobieSheetDictionary;
	}
	public final T getMergeRules()
	{
		return mergeRules;
	}
	
	private void init()
	{
		 cobieSheetDictionary =
				new COBIESheetDictionary(cobie);
	}
		
}
