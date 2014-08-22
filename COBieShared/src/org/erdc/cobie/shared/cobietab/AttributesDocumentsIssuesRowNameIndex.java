package org.erdc.cobie.shared.cobietab;

import java.util.HashMap;

public class AttributesDocumentsIssuesRowNameIndex extends HashMap<String, AttributesDocumentsIssues>
{

    /**
     * 
     */
    private static final long serialVersionUID = 5976885996260546814L;

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
