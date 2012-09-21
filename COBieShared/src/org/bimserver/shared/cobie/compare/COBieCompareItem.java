package org.bimserver.shared.cobie.compare;

import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.namespace.QName;

import org.apache.xmlbeans.XmlObject;
import org.bimserver.cobie.cobielite.COBIEDocument;
import org.bimserver.interfaces.objects.SCompareItem;
import org.bimserver.interfaces.objects.SCompareType;
import org.bimserver.interfaces.objects.SObjectAdded;
import org.bimserver.interfaces.objects.SObjectModified;
import org.bimserver.interfaces.objects.SObjectRemoved;
import org.bimserver.shared.cobie.COBIERowDictionary;
import org.bimserver.shared.cobie.COBIESheetCollection;
import org.bimserver.shared.cobie.COBIESheetDictionary;

public class COBieCompareItem
{
	private static final String KEY_ELEMENT_DELIM = ",";

	private static final String COLUMN_NAME_VALUE_DELIM = ":";

	private HashMap<String, String> cobieKeyValues;

	private String rowIDString;
	private String rowHash;
	private HashMap<String,String> keyValuePairs;
	private String sheetName;
	
	public COBieCompareItem(String sheetName, String rowHash, String rowIdString,HashMap<String,String> keyValuePairs)
	{
		setRowIdString(rowHash);
		setSheetName(sheetName);
		this.keyValuePairs = keyValuePairs;
	}
	

	public HashMap<String, String> getCOBieKeyValues()
	{
		return cobieKeyValues;
	}


	public String getRowIdString()
	{
		return rowIDString;
	}

	public String getSheetName()
	{
		return sheetName;
	}

	private void initializeDisplayString()
	{
		String tmpStr = "";
		for (String key : cobieKeyValues.keySet())
			tmpStr += key + COLUMN_NAME_VALUE_DELIM + cobieKeyValues.get(key) + KEY_ELEMENT_DELIM;
		if (tmpStr.endsWith(KEY_ELEMENT_DELIM))
			tmpStr = tmpStr.substring(0, tmpStr.length() - 1);
		setRowIdString(tmpStr);
	}

	public void setCOBieKeyValues(HashMap<String, String> cobieKeyValues)
	{
		this.cobieKeyValues = cobieKeyValues;
		initializeDisplayString();
	}



	public void setRowIdString(String rowIdString)
	{
		this.rowIDString = rowIdString;
	}

	public void setSheetName(String sheetName)
	{
		this.sheetName = sheetName;
	}

}
