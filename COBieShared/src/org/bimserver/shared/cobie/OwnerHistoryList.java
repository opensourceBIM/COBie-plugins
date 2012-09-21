package org.bimserver.shared.cobie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.bimserver.models.ifc2x3tc1.IfcOwnerHistory;

public class OwnerHistoryList extends ArrayList<IfcOwnerHistory>
	implements Comparator<IfcOwnerHistory>
{
	private static final long serialVersionUID = 1L;
	@Override
	public int compare(IfcOwnerHistory o1, IfcOwnerHistory o2)
	{
		return o1.getCreationDate()-o2.getCreationDate();
	}
	
	public void sort()
	{
		Collections.sort((ArrayList<IfcOwnerHistory>)this,this);
	}
	
	public OwnerHistoryList(List<IfcOwnerHistory> ownerHistoryList)
	{
		super();
		for(IfcOwnerHistory ownerHistory:ownerHistoryList)
			add(ownerHistory);
	}
}
