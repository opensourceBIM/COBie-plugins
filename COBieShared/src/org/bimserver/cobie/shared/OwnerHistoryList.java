package org.bimserver.cobie.shared;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.bimserver.models.ifc2x3tc1.IfcOwnerHistory;

public class OwnerHistoryList extends ArrayList<IfcOwnerHistory> implements Comparator<IfcOwnerHistory>
{
    private static final long serialVersionUID = 1L;

    public OwnerHistoryList(List<IfcOwnerHistory> ownerHistoryList)
    {
        super();
        for (IfcOwnerHistory ownerHistory : ownerHistoryList)
        {
            add(ownerHistory);
        }
    }

    @Override
    public int compare(IfcOwnerHistory o1, IfcOwnerHistory o2)
    {
        return o1.getCreationDate() - o2.getCreationDate();
    }

    public void sort()
    {
        Collections.sort(this, this);
    }
}
