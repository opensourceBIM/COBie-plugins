package org.erdc.cobie.shared.cobiesheetxmldata.indices;

import java.util.HashMap;

public class AttributesDocumentsIssuesRowNameIndex extends HashMap<String, AttributesDocumentsIssues>
{

    @Override
    public AttributesDocumentsIssues get(Object key)
    {
        AttributesDocumentsIssues descriptiveRows = null;
        if (key instanceof String)
        {
            if (containsKey(key))
            {
                descriptiveRows = super.get(key);
            } else
            {
                descriptiveRows = new AttributesDocumentsIssues();
            }
        }
        return descriptiveRows;
    }

    public AttributesDocumentsIssues getDescriptiveDataRowsByForeignRowName(String rowName)
    {
        return get(rowName);
    }

}
