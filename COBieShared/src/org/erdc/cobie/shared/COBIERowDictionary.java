package org.erdc.cobie.shared;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;

import org.erdc.cobie.shared.COBieUtility.CobieSheetName;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class COBIERowDictionary extends HashMap<String, String>
{
    private static final int HASH_OFFSET = 220;
    private static final String KEY_COMPONENT_DELIM = ",";

    private static final String COLUMN_NAME_VALUE_DELIM = ":";

    private static String sheetNameFromNode(Node xmlNode)
    {
        return xmlNode.getNodeName();
    }

    // TODO Refactor this IDM Action variable to an extended class...it's here
    // temporarily bc no other extended functionality is required at this time
    private int cobieDocumentRowNumber;

    private HashMap<String, String> cobieKeyValues;
    /***
     * An MD5 hash of the cobieRowIdString
     */
    private String cobieRowHash;
    /**
     * A comma delimmited list of strings in format KeyColumnName:KeyColumnValue
     */
    private String cobieRowIdString;
    private final String EXTERNALID_COL_NAME = "Extlindentifier";
    private String guid;
    private String sheetName;

    private ArrayList<String> uniqueIdColumnNames;

    public COBIERowDictionary()
    {
        super();
        uniqueIdColumnNames = new ArrayList<String>();
        cobieKeyValues = new HashMap<String, String>();
    }

    public COBIERowDictionary(Node cobieXmlInnerElementNode)
    {
        super();
        uniqueIdColumnNames = new ArrayList<String>();
        cobieKeyValues = new HashMap<String, String>();
        setSheetName(sheetNameFromNode(cobieXmlInnerElementNode));
        processNodeChildren(cobieXmlInnerElementNode);
    }

    public COBIERowDictionary(String ownerSheetName)
    {
        super();
        uniqueIdColumnNames = new ArrayList<String>();
        cobieKeyValues = new HashMap<String, String>();
        setSheetName(ownerSheetName);
    }

    public COBIERowDictionary(String ownerSheetName, ArrayList<String> uniqueIdColumnNames)
    {
        super();
        cobieKeyValues = new HashMap<String, String>();
        setSheetName(ownerSheetName);
        this.uniqueIdColumnNames = uniqueIdColumnNames;
    }

    private boolean allKeyColumnsInitialized()
    {
        boolean hasAllKeys = true;
        for (String key : uniqueIdColumnNames)
        {
            if (!cobieKeyValues.containsKey(key))
            {
                hasAllKeys = false;
            }
        }
        return hasAllKeys;
    }

    private String computeRowValuesHash() throws NoSuchAlgorithmException
    {
        String rowValuesHash = "";
        for (String key : keySet())
        {
            String colValStr = key + COLUMN_NAME_VALUE_DELIM + get(key) + KEY_COMPONENT_DELIM;
            rowValuesHash += colValStr;
        }
        if (rowValuesHash.endsWith(KEY_COMPONENT_DELIM))
        {
            rowValuesHash = rowValuesHash.substring(0, rowValuesHash.length() - 1);
        }
        rowValuesHash = COBieUtility.hashFromString(rowValuesHash);
        return rowValuesHash;

    }

    @Override
    public boolean equals(Object o)
    {
        boolean equals = false;
        if (o.getClass().equals(this.getClass()))
        {
            COBIERowDictionary oRowDictionary = (COBIERowDictionary)o;
            if (oRowDictionary.getCOBieRowIdString().equals(getCOBieRowIdString()))
            {
                equals = true;
            }

        }
        return equals;
    }

    public int getCobieDocumentRowNumber()
    {
        return cobieDocumentRowNumber;
    }

    public String getCOBieRowIdHash()
    {
        return cobieRowHash;
    }

    public String getCOBieRowIdString()
    {

        if ((cobieRowIdString == null) || (cobieRowIdString.length() == 0))
        {
            return getConcatenatedRowIdString();
        } else
        {
            return cobieRowIdString;
        }
    }

    public HashMap<String, String> getCOBieUniqueIds()
    {

        if (allKeyColumnsInitialized())
        {
            return cobieKeyValues;
        } else
        {
            return null;
        }
    }

    private String getConcatenatedRowIdString()
    {
        String concatenatedKey = "";
        for (String key : cobieKeyValues.keySet())
        {
            concatenatedKey += key + COLUMN_NAME_VALUE_DELIM + cobieKeyValues.get(key) + KEY_COMPONENT_DELIM;
        }
        if (concatenatedKey.endsWith(KEY_COMPONENT_DELIM))
        {
            concatenatedKey = concatenatedKey.substring(0, concatenatedKey.length() - 1);
        }
        return concatenatedKey;
    }

    public String getGuid()
    {
        return guid;
    }

    public String getRowValuesHash()
    {
        String rowValuesHash = "";
        try
        {
            rowValuesHash = computeRowValuesHash();
        } catch (NoSuchAlgorithmException e)
        {

        }
        return rowValuesHash;
    }

    public String getSheetName()
    {
        return sheetName;
    }

    @Override
    public final int hashCode()
    {
        String key = getCOBieRowIdString();
        return HASH_OFFSET + (key == null ? 0 : key.hashCode());
    }

    public boolean isGuidEmpty()
    {
        boolean isEmpty = ((guid == null) || (guid.length() > 0) || guid.equalsIgnoreCase("n/a"));
        return isEmpty;
    }

    private void processNodeChildren(Node cobieXmlInnerElementNode)
    {
        try
        {
            CobieSheetName sheetNameLiteral = COBieUtility.CobieSheetName.valueOf(sheetName);
            HashMap<CobieSheetName, ArrayList<String>> sheetsToColumnNames = COBieTokenUtility.getCobieSheetNameColumnMappings();
            if (sheetsToColumnNames.containsKey(sheetNameLiteral))
            {
                ArrayList<String> columnNames = sheetsToColumnNames.get(sheetNameLiteral);
                for (int i = 0; i < cobieXmlInnerElementNode.getChildNodes().getLength(); i++)
                {

                    Node childNode = cobieXmlInnerElementNode.getChildNodes().item(i);
                    String nodeName = childNode.getNodeName();
                    if (columnNames.contains(nodeName))
                    {
                        if (childNode instanceof Element)
                        {
                            if (childNode.getFirstChild() == null)
                            {
                                put(nodeName, childNode.getNodeValue());
                            } else
                            {
                                put(nodeName, childNode.getFirstChild().getNodeValue());
                            }
                        } else if (childNode instanceof Attr)
                        {
                            put(nodeName, childNode.getNodeValue());
                        }
                    }
                }
            }

        } catch (Exception ex)
        {

        }

    }

    @Override
    public String put(String key, String value)
    {
        String returnVal = super.put(key, value);
        if (key.equals(EXTERNALID_COL_NAME))
        {
            guid = value;
        }
        if (uniqueIdColumnNames.contains(key))
        {
            cobieKeyValues.put(key, value);
        }
        if (((cobieRowIdString == null) || (cobieRowIdString.length() == 0)) && allKeyColumnsInitialized())
        {
            cobieRowIdString = getConcatenatedRowIdString();
        }
        try
        {

            cobieRowHash = COBieUtility.hashFromString(getConcatenatedRowIdString());
        } catch (NoSuchAlgorithmException e)
        {

        }
        return returnVal;
    }

    public void setCobieDocumentRowNumber(int cobieDocumentRowNumber)
    {
        this.cobieDocumentRowNumber = cobieDocumentRowNumber;
    }

    public void setSheetName(String sheetName)
    {
        this.sheetName = sheetName;
        uniqueIdColumnNames = COBIESheetCollection.getKeyColumnNamesFromSheetName(sheetName);
    }

}
