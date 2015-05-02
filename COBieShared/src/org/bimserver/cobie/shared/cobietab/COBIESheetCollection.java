package org.bimserver.cobie.shared.cobietab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.bimserver.cobie.shared.utility.COBieUtility;

public class COBIESheetCollection extends ArrayList<COBIERowDictionary>
{
    /**
     * 
     */
    private static final long serialVersionUID = 2435268371579118908L;
    private static final ArrayList<String> ASSEMBLY_KEYS = new ArrayList<String>(Arrays.asList("Name", "SheetName", "ParentName", "ChildNames"));
    private static final ArrayList<String> ATTRIBUTE_KEYS = new ArrayList<String>(Arrays.asList("Name", "SheetName", "RowName"));
    private static final ArrayList<String> COMPONENT_KEYS = new ArrayList<String>(Arrays.asList("Name"));
    private static final ArrayList<String> CONNECTION_KEYS = new ArrayList<String>(Arrays.asList("Name", "ConnectionType", "SheetName", "RowName1",
            "RowName2"));
    private static final ArrayList<String> CONTACT_KEYS = new ArrayList<String>(Arrays.asList("Email"));
    private static final ArrayList<String> COORDINATE_KEYS = new ArrayList<String>(Arrays.asList("Name", "Category", "SheetName", "RowName"));
    private static final ArrayList<String> DOCUMENT_KEYS = new ArrayList<String>(Arrays.asList("Name", "Stage", "SheetName", "RowName"));
    private static final ArrayList<String> FACILITY_KEYS = new ArrayList<String>(Arrays.asList("Name"));
    private static final ArrayList<String> FLOOR_KEYS = new ArrayList<String>(Arrays.asList("Name"));
    private static final ArrayList<String> IMPACT_KEYS = new ArrayList<String>(Arrays.asList("Name", "ImpactType", "ImpactStage", "SheetName",
            "RowName"));
    private static final ArrayList<String> ISSUE_KEYS = new ArrayList<String>(Arrays.asList("Name", "SheetName1", "RowName1", "SheetName2",
            "RowName2"));
    private static final ArrayList<String> JOB_KEYS = new ArrayList<String>(Arrays.asList("Name", "TypeName", "TaskNumber"));
    private static final ArrayList<String> RESOURCE_KEYS = new ArrayList<String>(Arrays.asList("Name"));
    private static final ArrayList<String> SPACE_KEYS = new ArrayList<String>(Arrays.asList("Name"));
    private static final ArrayList<String> SPARE_KEYS = new ArrayList<String>(Arrays.asList("Name"));
    private static final ArrayList<String> SYSTEM_KEYS = new ArrayList<String>(Arrays.asList("Name", "Category", "ComponentNames"));
    private static final ArrayList<String> TYPE_KEYS = new ArrayList<String>(Arrays.asList("Name"));
    private static final ArrayList<String> ZONE_KEYS = new ArrayList<String>(Arrays.asList("Name", "Category", "SpaceNames"));

    public static ArrayList<String> getKeyColumnNamesFromSheetName(String sheetName)
    {
        HashMap<String, ArrayList<String>> sheetNameKeyColumnNames = sheetNameToKeyColumnNames();
        if (sheetNameKeyColumnNames.containsKey(sheetName))
        {
            return sheetNameKeyColumnNames.get(sheetName);
        } else
        {
            return null;
        }
    }

    private static HashMap<String, ArrayList<String>> sheetNameToKeyColumnNames()
    {
        HashMap<String, ArrayList<String>> tmpSheetMap = new HashMap<String, ArrayList<String>>();
        tmpSheetMap.put(COBieUtility.CobieSheetName.Contact.name(), CONTACT_KEYS);
        tmpSheetMap.put(COBieUtility.CobieSheetName.Facility.name(), FACILITY_KEYS);
        tmpSheetMap.put(COBieUtility.CobieSheetName.Floor.name(), FLOOR_KEYS);
        tmpSheetMap.put(COBieUtility.CobieSheetName.Space.name(), SPACE_KEYS);
        tmpSheetMap.put(COBieUtility.CobieSheetName.Zone.name(), ZONE_KEYS);
        tmpSheetMap.put(COBieUtility.CobieSheetName.Type.name(), TYPE_KEYS);
        tmpSheetMap.put(COBieUtility.CobieSheetName.Component.name(), COMPONENT_KEYS);
        tmpSheetMap.put(COBieUtility.CobieSheetName.System.name(), SYSTEM_KEYS);
        tmpSheetMap.put(COBieUtility.CobieSheetName.Assembly.name(), ASSEMBLY_KEYS);
        tmpSheetMap.put(COBieUtility.CobieSheetName.Connection.name(), CONNECTION_KEYS);
        tmpSheetMap.put(COBieUtility.CobieSheetName.Spare.name(), SPARE_KEYS);
        tmpSheetMap.put(COBieUtility.CobieSheetName.Resource.name(), RESOURCE_KEYS);
        tmpSheetMap.put(COBieUtility.CobieSheetName.Job.name(), JOB_KEYS);
        tmpSheetMap.put(COBieUtility.CobieSheetName.Impact.name(), IMPACT_KEYS);
        tmpSheetMap.put(COBieUtility.CobieSheetName.Document.name(), DOCUMENT_KEYS);
        tmpSheetMap.put(COBieUtility.CobieSheetName.Attribute.name(), ATTRIBUTE_KEYS);
        tmpSheetMap.put(COBieUtility.CobieSheetName.Coordinate.name(), COORDINATE_KEYS);
        tmpSheetMap.put(COBieUtility.CobieSheetName.Issue.name(), ISSUE_KEYS);

        return tmpSheetMap;
    }

    private HashMap<String, COBIERowDictionary> cobieRowHashIndex;
    private HashMap<String, COBIERowDictionary> cobieRowIdStringIndex;
    private HashMap<String, COBIERowDictionary> guidIndex;

    private ArrayList<String> uniqueIdColumnNames;

    public COBIESheetCollection()
    {
        super();
        guidIndex = new HashMap<String, COBIERowDictionary>();
        cobieRowIdStringIndex = new HashMap<String, COBIERowDictionary>();
        cobieRowHashIndex = new HashMap<String, COBIERowDictionary>();
    }

    public COBIESheetCollection(String ownerSheetName)
    {
        super();
        HashMap<String, ArrayList<String>> sheetNameUniqueIdColumnNames = sheetNameToKeyColumnNames();
        cobieRowIdStringIndex = new HashMap<String, COBIERowDictionary>();
        cobieRowHashIndex = new HashMap<String, COBIERowDictionary>();
        if (sheetNameUniqueIdColumnNames.keySet().contains(ownerSheetName))
        {
            uniqueIdColumnNames = sheetNameUniqueIdColumnNames.get(ownerSheetName);
        }

    }

    @Override
    public boolean add(COBIERowDictionary cobieRowData)
    {
        boolean returnVal = super.add(cobieRowData);
        if (!cobieRowData.isGuidEmpty())
        {
            String guid = cobieRowData.getGuid();
            guidIndex.put(guid, cobieRowData);

        }
        if ((cobieRowData.getCOBieRowIdString() != null) && (cobieRowData.getCOBieRowIdString().length() > 0))
        {
            cobieRowIdStringIndex.put(cobieRowData.getCOBieRowIdString(), cobieRowData);
        }
        if ((cobieRowData.getCOBieRowIdHash() != null) && (cobieRowData.getCOBieRowIdHash().length() > 0))
        {
            cobieRowHashIndex.put(cobieRowData.getCOBieRowIdHash(), cobieRowData);
        }
        return returnVal;
    }

    public boolean containsCOBieRowIdString(String cobieRowIdString)
    {
        return ((cobieRowIdStringIndex != null) && cobieRowIdStringIndex.containsKey(cobieRowIdString));
    }

    public boolean containsRowHash(String rowHash)
    {
        return ((cobieRowHashIndex != null) && cobieRowHashIndex.containsKey(rowHash));
    }

    public COBIERowDictionary getByCOBieRowIdString(String cobieKey)
    {
        if (containsCOBieRowIdString(cobieKey))
        {
            return cobieRowIdStringIndex.get(cobieKey);
        } else
        {
            return null;
        }
    }

    public COBIERowDictionary getByGuid(String guid)
    {
        if (guidExists(guid))
        {
            return guidIndex.get(guid);
        } else
        {
            return null;
        }
    }

    public COBIERowDictionary getByRowHash(String hashValue)
    {
        if (containsRowHash(hashValue))
        {
            return cobieRowHashIndex.get(hashValue);
        } else
        {
            return null;
        }
    }

    public HashMap<String, COBIERowDictionary> getCobieRowHashIndex()
    {
        return cobieRowHashIndex;
    }

    public ArrayList<String> getUniqueIdColumnNames()
    {
        return uniqueIdColumnNames;
    }

    public boolean guidExists(String guid)
    {
        return guidIndex.containsKey(guid);
    }

    @Override
    public boolean remove(Object o)
    {
        boolean returnVal = false;
        if (o instanceof COBIERowDictionary)
        {
            COBIERowDictionary cobieRowData = (COBIERowDictionary)o;
            returnVal = super.remove(cobieRowData);
            if (!cobieRowData.isGuidEmpty())
            {
                String guid = cobieRowData.getGuid();
                if (guidIndex.containsKey(guid))
                {
                    guidIndex.remove(guid);
                }

            }
            if ((cobieRowData.getCOBieRowIdString() != null) && (cobieRowData.getCOBieRowIdString().length() > 0))
            {
                cobieRowIdStringIndex.remove(cobieRowData.getCOBieRowIdString());
            }
            if ((cobieRowData.getCOBieRowIdHash() != null) && (cobieRowData.getCOBieRowIdHash().length() > 0))
            {
                cobieRowHashIndex.remove(cobieRowData.getCOBieRowIdHash());
            }
        }
        return returnVal;
    }

    public boolean removeByCOBieRowIdString(String cobieKey)
    {
        boolean removed = false;
        if (containsCOBieRowIdString(cobieKey))
        {
            remove(getByCOBieRowIdString(cobieKey));
            removed = true;
        }
        return removed;
    }

    public void setCobieRowHashIndex(HashMap<String, COBIERowDictionary> cobieRowHashIndex)
    {
        this.cobieRowHashIndex = cobieRowHashIndex;
    }
}
