package org.bimserver.cobie.utils;
/******************************************************************************
 * Copyright (C) 2011  ERDC
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import nl.fountain.xelem.excel.Cell;
import nl.fountain.xelem.excel.Row;
import nl.fountain.xelem.excel.Worksheet;

import org.apache.xmlbeans.SchemaStringEnumEntry;
import org.apache.xmlbeans.XmlCalendar;
import org.apache.xmlbeans.XmlDateTime;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.bimserver.cobie.cobielite.COBIEType;
import org.bimserver.cobie.utils.spreadsheetml.SpreadsheetToContacts;
import org.bimserver.cobie.utils.spreadsheetml.SpreadsheetToFacilities;
import org.bimserver.cobie.utils.spreadsheetml.SpreadsheetToFloors;
import org.bimserver.cobie.utils.spreadsheetml.SpreadsheetToSpaces;
import org.bimserver.cobie.utils.spreadsheetml.SpreadsheetToSystems;
import org.bimserver.cobie.utils.spreadsheetml.SpreadsheetToTypes;
import org.bimserver.cobie.utils.spreadsheetml.SpreadsheetToZones;
import org.bimserver.cobie.utils.stringwriters.IfcPropertyToCOBieString;
import org.bimserver.cobie.utils.stringwriters.IfcRelationshipsToCOBie;
import org.bimserver.cobie.utils.stringwriters.IfcSingleValueToCOBieString;
import org.bimserver.models.ifc2x3tc1.IfcAddress;
import org.bimserver.models.ifc2x3tc1.IfcApplication;
import org.bimserver.models.ifc2x3tc1.IfcClassification;
import org.bimserver.models.ifc2x3tc1.IfcClassificationNotationSelect;
import org.bimserver.models.ifc2x3tc1.IfcClassificationReference;
import org.bimserver.models.ifc2x3tc1.IfcObject;
import org.bimserver.models.ifc2x3tc1.IfcObjectDefinition;
import org.bimserver.models.ifc2x3tc1.IfcOrganization;
import org.bimserver.models.ifc2x3tc1.IfcOwnerHistory;
import org.bimserver.models.ifc2x3tc1.IfcPerson;
import org.bimserver.models.ifc2x3tc1.IfcPersonAndOrganization;
import org.bimserver.models.ifc2x3tc1.IfcPropertySingleValue;
import org.bimserver.models.ifc2x3tc1.IfcRelAssociates;
import org.bimserver.models.ifc2x3tc1.IfcRelAssociatesClassification;
import org.bimserver.models.ifc2x3tc1.IfcRelDefines;
import org.bimserver.models.ifc2x3tc1.IfcRelDefinesByType;
import org.bimserver.models.ifc2x3tc1.IfcRelationship;
import org.bimserver.models.ifc2x3tc1.IfcTelecomAddress;
import org.bimserver.models.ifc2x3tc1.IfcTypeObject;
import org.bimserver.models.ifc2x3tc1.impl.IfcTelecomAddressImpl;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class COBieUtility 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(COBieUtility.class);
	private static final String DefaultEmailAddress = "anonymous@anonymous.com";
	protected static final String ImplementationClassSuffix = "impl";
	protected static final String COBieDateFormatString = "%1$tY-%1$tm-%1$teT%1$tH:%1$tM:%1$tS";
	public static final HashMap<CobieSheetName,ArrayList<String>> sheetNameColumnDictionary = getCobieSheetNameColumnMappings();
	public static HashMap<CobieSheetName,ArrayList<String>> getCobieSheetNameColumnMappings()
	{
		HashMap<CobieSheetName,ArrayList<String>> columnMappings = new HashMap<CobieSheetName,ArrayList<String>>();
		columnMappings.put(CobieSheetName.Contact, SpreadsheetToContacts.ContactColumnNames);
		columnMappings.put(CobieSheetName.Facility, SpreadsheetToFacilities.getFacilityColumns());
		columnMappings.put(CobieSheetName.Floor, SpreadsheetToFloors.getFloorColumns());
		columnMappings.put(CobieSheetName.Space, SpreadsheetToSpaces.getSpaceColumnNames());
		columnMappings.put(CobieSheetName.Zone, SpreadsheetToZones.getZoneColumns());
		columnMappings.put(CobieSheetName.Type, SpreadsheetToTypes.getTypeColumns());
		columnMappings.put(CobieSheetName.System, SpreadsheetToSystems.getSystemColumns());
		return columnMappings;
	}
	public enum CobieSheetName {Assembly, Attribute, Component,
		Connection,Contact,Document,Facility,Floor,Job,Resource,Space,
		Spare,System,Type,Zone,Impact,Coordinate,Issue};
	public static HashMap<CobieSheetName,String> pluralCobieSheetName = createPluralCobieSheetMap();
	protected static enum ClassificationLiterals
	{Assembly_Code,Assembly_Description,OmniClass_Number,OmniClass_Title,
		Uniclass_Code,Uniclass_Description,Category_Code,Category_Description,
		Classification_Code,Classification_Description
	};
	public static final String COBieNA = "n/a";
	protected static final String COBieDelim = ",";
	protected static final String COBieUnkown = "unkown";
	
	private static HashMap<CobieSheetName,String> createPluralCobieSheetMap()
	{
		HashMap<CobieSheetName,String> pluralNameMap =
				new HashMap<CobieSheetName,String>();
		pluralNameMap.put(CobieSheetName.Assembly,"Assemblies");
		pluralNameMap.put(CobieSheetName. Attribute," Attributes");
		pluralNameMap.put(CobieSheetName. Component," Components");
		pluralNameMap.put(CobieSheetName.Connection,"Connections");
		pluralNameMap.put(CobieSheetName.Contact,"Contacts");
		pluralNameMap.put(CobieSheetName.Document,"Documents");
		pluralNameMap.put(CobieSheetName.Facility,"Facilities");
		pluralNameMap.put(CobieSheetName.Floor,"Floors");
		pluralNameMap.put(CobieSheetName.Job,"Jobs");
		pluralNameMap.put(CobieSheetName.Resource,"Resources");
		pluralNameMap.put(CobieSheetName.Space,"Spaces");
		pluralNameMap.put(CobieSheetName.Spare,"Spares");
		pluralNameMap.put(CobieSheetName.System,"Systems");
		pluralNameMap.put(CobieSheetName.Type,"Types");
		pluralNameMap.put(CobieSheetName.Zone,"Zones");
		pluralNameMap.put(CobieSheetName.Impact,"Impacts");
		pluralNameMap.put(CobieSheetName.Coordinate,"Coordinates");
		pluralNameMap.put(CobieSheetName.Issue,"Issues");

		return pluralNameMap;
	}
	
	public static String getEmailFromOwnerHistory(IfcOwnerHistory oh)
	{
		IfcPersonAndOrganization personOrg = oh.getOwningUser();
		return getCOBieString(getEmailFromPersonAndOrganization(personOrg));
	}
	
	static public String getCOBieDelim()
	{
		return COBieDelim;
	}
	
	static public boolean isElementADateTime(XmlObject xml, String elementName)
	{
		boolean isADateTime = false;
		XmlObject[] selectedObjs = xml.selectPath(elementName);
		if (selectedObjs.length==1)
		{
			XmlObject selectedObj = selectedObjs[0];
			if (selectedObj instanceof Calendar || selectedObj instanceof XmlCalendar || selectedObj instanceof XmlDateTime)
			{
				isADateTime=true;
				XmlDateTime xDateTime = (XmlDateTime) selectedObj;
				@SuppressWarnings("unused")
				String formattedDateTime = String.format(COBieDateFormatString, xDateTime.getCalendarValue());
			}
		}
		return isADateTime;
	}
	
	static public String stringFromXmlDateTime(XmlObject xml, String elementName)
	{
		XmlObject[] selectedObjs = xml.selectPath(elementName);
		String formattedDate = "";
		if (selectedObjs.length==1)
		{
			XmlObject selectedObj = selectedObjs[0];
			if (selectedObj instanceof Calendar || selectedObj instanceof XmlCalendar || selectedObj instanceof XmlDateTime)
			{
				XmlDateTime xDateTime = (XmlDateTime) selectedObj;
				formattedDate = String.format(COBieDateFormatString, xDateTime.getCalendarValue());
			}
		}
		return formattedDate;
	}
	
	static public Map<String,String> elementMapFromXMLObject(XmlObject xml)
	{	
		Map<String,String> elementMap = new HashMap<String,String>();
		XMLStreamReader rdr = xml.newXMLStreamReader();
		String keyName = "";
		String keyVal = "";
		boolean lastWasStartElement = false;
		int attCount = 0;
		try {
			
			while(rdr.hasNext())
			{
				try
				{
					attCount = rdr.getAttributeCount();
				}
				catch(Exception ex)
				{
					attCount = 0;
				}
				if (attCount>0)
				{
					for (int i=0; i < attCount; i++)
					{
						keyName = rdr.getAttributeLocalName(i);
						keyVal = rdr.getAttributeValue(i);
						if (!elementMap.containsKey(keyName))
							elementMap.put(keyName, keyVal);
						lastWasStartElement = false;
					}
				}
				if (rdr.isStartElement())
				{
					keyName = rdr.getLocalName();
					lastWasStartElement = true;
					
				}
				else if (rdr.isCharacters() && lastWasStartElement)
				{	
					if (isElementADateTime(xml,keyName))
					{
						keyVal = COBieUtility.stringFromXmlDateTime(xml, keyName);
						
					}
					else
						keyVal = rdr.getText();
					if (!elementMap.containsKey(keyName))
						elementMap.put(keyName, keyVal);
					lastWasStartElement = false;
				}
				else
					lastWasStartElement = false;
				
				rdr.next();
			}
		} catch (XMLStreamException e) {
			LOGGER.error("", e);
		}
		return elementMap;
	}
	
	public static boolean stringContainsOneOf(String testString, ArrayList<String> tokens)
	{
		boolean contains = false;
		for(String tmpTok : tokens)
			if (testString.contains(tmpTok))
				contains = true;
		return contains;
		
	}
	
	public static CobieSheetName CobieSheetNameEnumFromString(String sheetName) throws Exception
	{
		CobieSheetName enumSheetName;
		String casedSheetName = ToCOBieCase(sheetName);
		try
		{
			enumSheetName = CobieSheetName.valueOf(casedSheetName);
		}
		catch (Exception e)
		{
			throw e;
		}
		return enumSheetName;
	}
	
	public static String ToCOBieCase(String string)
	{
		String cobieCaseString = "";
		String charString;
		char[] stringCharArray = string.toCharArray();
		for(int i=0; i < stringCharArray.length; i++)
		{
			charString = String.valueOf(stringCharArray[i]);
			if (i==0)
				cobieCaseString += charString.toUpperCase();
			else
				cobieCaseString += charString.toLowerCase();
		}
		return cobieCaseString;
	}
	
	public static ArrayList<String> arrayListFromDelimString(String delimString)
	{
		ArrayList<String> splitStrings = new ArrayList<String>();
		if (delimString.contains(COBieUtility.getCOBieDelim()))
		{
			String[] splitStrArray = delimString.split(COBieUtility.getCOBieDelim());
			for(String splitStr : splitStrArray)
				splitStrings.add(splitStr.trim());
		}
		else
			splitStrings.add(delimString);
		return splitStrings;
	}
	
	public static String delimittedStringFromArrayList(ArrayList<String> stringList)
	{
		String strChildren = "";
		for(String child : stringList)
		{
			strChildren += child + COBieDelim;
		}
		if (strChildren.endsWith(COBieDelim))
			strChildren = strChildren.substring(0,strChildren.length()-COBieDelim.length());
		return strChildren;
	}
	
	public static String delimittedStringFromArrayList(ArrayList<String> stringList, 
			boolean allowDuplicates, 
			boolean allowNA)
	{

		String strChildren = "";
		ArrayList<String> copyList = new ArrayList<String>();
		for(String entry : stringList)
			if (!copyList.contains(entry))
				copyList.add(entry);
		for(String child : stringList)
		{
			if ( (allowDuplicates || (!allowDuplicates && copyList.contains(child))) &&
					(allowNA || (!allowNA && !isNA(child))))
			{
				strChildren += child +COBieDelim;
				if (!allowDuplicates)
					copyList.remove(child);
			}
					
		}
		if (strChildren.endsWith(COBieDelim))
			strChildren = strChildren.substring(0,strChildren.length()-COBieDelim.length());
		return strChildren;
	}
	
	public static String extObjectFromObjectDef(IfcObjectDefinition obj)
	{
		String className = obj.getClass().getSimpleName();
		if (className.toLowerCase().endsWith(ImplementationClassSuffix))
			className = className.substring(0,className.length()-4);
		return className;
	}
	
	public static String extObjectFromRelationship(IfcRelationship obj)
	{
		String className = obj.getClass().getSimpleName();
		if (className.toLowerCase().endsWith(ImplementationClassSuffix))
			className = className.substring(0,className.length()-4);
		return className;
	}
	
	public static String getEmailFromPersonAndOrganization(IfcPersonAndOrganization personOrg)
	{
		String strEmail = "";
		IfcPerson person = personOrg.getThePerson();
		String givenName = person.getGivenName();
		if (givenName==null || givenName.length()==0)
			givenName = COBieUnkown;
		String familyName = person.getFamilyName();
		if (familyName==null || familyName.length()==0)
			familyName = COBieUnkown;
		IfcOrganization org = personOrg.getTheOrganization();
		String orgName = org.getName();
		if (orgName==null || orgName.length()==0)
			orgName = COBieUnkown;
		EList<IfcAddress> pAddresses = person.getAddresses();
		EList<IfcAddress> oAddresses = org.getAddresses();
		String pEmail = getEmailsFromAddresses(pAddresses);
		String oEmail = getEmailsFromAddresses(oAddresses);
		String pID = person.getId();
		String oID = org.getId();
		if (pEmail!=null && pEmail.length()>0 && pEmail!=COBieNA)
			strEmail = pEmail;
		else if (oEmail !=null && oEmail.length()>0 && oEmail!=COBieNA)
			strEmail = oEmail;
		else if (pID !=null && pID.length()>0)
			strEmail = pID;
		else if (oID!=null && oID.length()>0)
			strEmail = oID;
		else if (givenName!=null && familyName !=null && orgName!=null)
		{
			strEmail = givenName + familyName + "@" + orgName+".com";
		}
		if (strEmail.length()==0)
		{
			strEmail = DefaultEmailAddress;
		}
		return getCOBieString(strEmail);
	}
	static protected String getEmailsFromAddresses(EList<IfcAddress> addresses)
	{
		String emailAddress = "";
		for(IfcAddress address : addresses)
		{
			if (address.getClass()==IfcTelecomAddressImpl.class)
			{
				IfcTelecomAddress tAddress = (IfcTelecomAddress) address;
				EList<String> eAddresses = tAddress.getElectronicMailAddresses();
				if (eAddresses.size()>0)
					emailAddress = eAddresses.get(0);
			}
		}
		return getCOBieString(emailAddress);

	}
	static protected String getCOBieString(String text, String alternative)
	{
		String strReturn = COBieNA;
		if (text!=null && text.length()>0)
			strReturn = text.trim();
		else if (alternative!=null & alternative.length()>0)
			strReturn = alternative.trim();
		return strReturn;
	}
	public static String getCOBieString(String text)
	{
		String strReturn = COBieNA;
		if (text!=null && text.length()>0)
		{
			strReturn = text.trim();
			if (text.endsWith(","))
				strReturn = getCOBieString(text.substring(0, text.length()-1));
		}
		return strReturn;
	}
	public static String getApplicationName(IfcOwnerHistory oh)
	{
		String strApp = "";
		IfcApplication ifcApp =
				oh.getOwningApplication();
		strApp = ifcApp.getApplicationFullName();
		return getCOBieString(strApp);
	}
	public static String getObjectClassification(IfcObjectDefinition ifcObj)
	{
		String classification = "";
		Map<String,String> classificationTuples = getClassificationTuples();
		ArrayList<String> classificationNames = getClassificationPropertyNames();
		EList<IfcRelAssociates> associations = ifcObj.getHasAssociations();
		for(IfcRelAssociates assoc : associations )
		{
			if (assoc instanceof IfcRelAssociatesClassification)
			{
				IfcRelAssociatesClassification relAssoClass =
						(IfcRelAssociatesClassification) assoc;
				IfcClassificationNotationSelect classNot =
						relAssoClass.getRelatingClassification();
				if (classNot instanceof IfcClassification)
				{
					IfcClassification ifcClass = (IfcClassification) classNot;
					classification = ifcClass.getName();
				} 
				else if (classNot instanceof IfcClassificationReference)
				{
					IfcClassificationReference classRef =
							(IfcClassificationReference) classNot;
					classification += classRef.getItemReference() + COBieDelim;
				}
			}
			
		}
		if (ifcObj instanceof IfcObject && (classification==null || classification.length()<=0)) 
		{
			Map<String, String> masterMap = new HashMap<String, String>();

			IfcObject obj = (IfcObject) ifcObj;
			for (IfcRelDefines def : obj.getIsDefinedBy()) 
			{
				Map<String, String> tmpValueMap = IfcRelationshipsToCOBie
						.propertyStringsFromRelDefines(def, classificationNames);
				if (!tmpValueMap.isEmpty()) {
					for (String key : tmpValueMap.keySet()) {
						if (!masterMap.containsKey(key))
							masterMap.put(key, tmpValueMap.get(key));
					}
				}
			}
			classification = COBieUtility.classificationCobieStringFromStringMap(masterMap, classificationTuples);
		}
		else if (IfcTypeObject.class.isInstance(ifcObj) && (classification==null || classification.length()<=0)) 
		{
			Map<String, String> masterMap = new HashMap<String, String>();
			IfcTypeObject obj = (IfcTypeObject) ifcObj;
			masterMap = IfcRelationshipsToCOBie.propertyStringsFromTypeObject(obj,classificationNames);
			classification = COBieUtility.classificationCobieStringFromStringMap(masterMap, classificationTuples);
		}
		return COBieUtility.getCOBieString(classification);
	}
	
	public static String getRelDefinesByTypeClassification(IfcRelDefinesByType relDefType)
	{
		String classification = "";
		Map<String, String> masterMap = new HashMap<String, String>();
		Map<String,String> classificationTuples = getClassificationTuples();
		ArrayList<String> classificationNames = getClassificationPropertyNames();
		
				Map<String, String> tmpValueMap = IfcRelationshipsToCOBie
						.propertyStringsFromRelDefines(relDefType, classificationNames);
				if (!tmpValueMap.isEmpty()) 
				{
					for (String key : tmpValueMap.keySet()) 
					{
						if (!masterMap.containsKey(key))
							masterMap.put(key, tmpValueMap.get(key));
					}
				}

			classification = COBieUtility.classificationCobieStringFromStringMap(masterMap, classificationTuples);
		
		return COBieUtility.getCOBieString(classification);
	}
	
	static private ArrayList<String> getClassificationPropertyNames()
	{
		ArrayList<String> names = new ArrayList<String>();
		names.add(ClassificationLiterals.Assembly_Code.toString().replace("_"," "));
		names.add(ClassificationLiterals.Assembly_Description.toString().replace("_"," "));
		names.add(ClassificationLiterals.Category_Code.toString().replace("_", " "));
		names.add(ClassificationLiterals.Category_Description.toString().replace("_"," "));
		names.add(ClassificationLiterals.Classification_Code.toString().replace("_"," "));
		names.add(ClassificationLiterals.Classification_Description.toString().replace("_"," "));
		names.add(ClassificationLiterals.OmniClass_Number.toString().replace("_"," "));
		names.add(ClassificationLiterals.OmniClass_Title.toString().replace("_", " "));
		names.add(ClassificationLiterals.Uniclass_Code.toString().replace("_"," "));
		names.add(ClassificationLiterals.Uniclass_Description.toString().replace("_"," "));
		return names;
	}
	
	static private Map<String,String> getClassificationTuples()
	{
		String A1 = ClassificationLiterals.Assembly_Code.toString().replace("_"," ");
		String A2 = ClassificationLiterals.Assembly_Description.toString().replace("_"," ");
		String B1 = ClassificationLiterals.Category_Code.toString().replace("_", " ");
		String B2 = ClassificationLiterals.Category_Description.toString().replace("_"," ");
		String C1 = ClassificationLiterals.Classification_Code.toString().replace("_"," ");
		String C2 = ClassificationLiterals.Classification_Description.toString().replace("_"," ");
		String D1 = ClassificationLiterals.OmniClass_Number.toString().replace("_"," ");
		String D2 = ClassificationLiterals.OmniClass_Title.toString().replace("_", " ");
		String E1 = ClassificationLiterals.Uniclass_Code.toString().replace("_"," ");
		String E2 = ClassificationLiterals.Uniclass_Description.toString().replace("_"," ");
		Map<String,String> map = new HashMap<String,String>();
		map.put(A1, A2);
		map.put(B1,B2);
		map.put(C1,C2);
		map.put(D1,D2);
		map.put(E1,E2);
		return map;
	}
	
	public static IfcOwnerHistory firstOwnerHistoryFromModel(IfcModelInterface model)
	{
		IfcOwnerHistory oh = null;
		ArrayList<IfcOwnerHistory>
			histories =  (ArrayList<IfcOwnerHistory>) model.getAll(IfcOwnerHistory.class);
		if (histories.size()>0)
			oh = histories.get(0);
		return oh;
	}
	
	public static Calendar ifcTimeStampAsCalendar(int timestamp)
	{
		long secondsSinceNineteenSeventy = (long) timestamp*1000;
		Date date = new Date(secondsSinceNineteenSeventy);	
		Calendar calTimestamp = new org.apache.xmlbeans.XmlCalendar(date);

		return calTimestamp;	
		
	}
	
	public static Calendar calendarFromString(String dateTimeString)
	{
		Calendar cal = new XmlCalendar();
		try
		{
			cal = new XmlCalendar(dateTimeString);
		}
		catch(Exception e)
		{
			
		}
	/*	String newDateTimeString = dateTimeString.replace("T", " ");
		DateFormat df = DateFormat.getDateTimeInstance();
		//DateFormat.
		try 
		{
			Date newDate = df.parse(newDateTimeString);
			cal = new org.apache.xmlbeans.XmlCalendar(newDate);
		} 
		catch (ParseException e) 
		{
			String noop="";
			LOGGER.error("", e);
		}*/
		
		return cal;
	}
	
	public static Calendar getDefaultCalendar()
	{	
		Calendar cal = Calendar.getInstance();
		Date COBIECreatedOn = cal.getTime();
		Date co = COBIECreatedOn;
		Calendar cal2 = new org.apache.xmlbeans.XmlCalendar(co);
		return cal2;
	}
	
	public static Map<String,Integer> GetWorksheetColumnDictionary(Worksheet sheet,
			ArrayList<String> columnNames)
	{
		ArrayList<String> upperCaseColumnNames = new ArrayList<String>();
		for(int idx=0; idx<columnNames.size();idx++)
			upperCaseColumnNames.add(columnNames.get(idx).toUpperCase());
		Map<String,Integer> colMap = new HashMap<String,Integer>();
		int firstRowIndex = Worksheet.firstRow;
		Row firstRow = sheet.getRowAt(firstRowIndex);
		int tmpColIndex;
		String tmpColName;
		sheet.getTable();
		
		for(Cell tmpCell : firstRow.getCells())
		{
			tmpColIndex = tmpCell.getIndex();
			if (tmpCell.hasData())
			{
				tmpColName = tmpCell.getData$();
				if (upperCaseColumnNames.contains(tmpColName.toUpperCase())
						&&!colMap.containsKey(tmpColName))
					colMap.put(tmpColName, tmpColIndex);
			}
		}
		boolean foundSearch = false;
		for(String searchedColName : columnNames)
		{
			for(String colMapKey : colMap.keySet())
			{
				if (searchedColName.equalsIgnoreCase(colMapKey))
				//if (searchedColName.equalsIgnoreCase(searchedColName))
					foundSearch= true;
			}
			if (!foundSearch)
				colMap.put(searchedColName, -1);
			foundSearch=false;
		}
		return colMap;
	}
	
	public static String identifierFromObject(IfcObject obj)
	{
		String ID = "";
		ID = obj.getGlobalId().getWrappedValue();
		return COBieUtility.getCOBieString(ID);
	}
	public static String identifierFromRelationship(IfcRelationship rel)
	{
		String id = rel.getGlobalId().getWrappedValue();
		return COBieUtility.getCOBieString(id);
	}
	public static String identifierFromObjectDefinition(IfcObjectDefinition objDef)
	{
		String ID = "";
		ID = objDef.getGlobalId().getWrappedValue();
		return COBieUtility.getCOBieString(ID);
	}
	
	public static boolean isNA(String str)
	{
		if (str==null || str.length()==0 || str.equalsIgnoreCase(COBieNA))
			return true;
		else
			return false;
	}
	
	public static String cobieStringFromStringMap(Map<String,String> valMap)
	{
		String cString = "";
		String tmpVal = "";
		ArrayList<String> concattedStrings =
				new ArrayList<String>();
		if (!valMap.isEmpty())
		{
			for(String key : valMap.keySet())
			{
				tmpVal = valMap.get(key);
				if (!concattedStrings.contains(tmpVal) &&
						!isNA(tmpVal))
				{
					cString += tmpVal + COBieUtility.COBieDelim;
					concattedStrings.add(tmpVal);
				}
			}
			if (cString.endsWith(COBieUtility.COBieDelim))
				cString = cString.substring(0, cString.length()-COBieUtility.COBieDelim.length());
		}
		return COBieUtility.getCOBieString(cString);
	}
	
	public static String cobieStringFromStringMap(Map<String,String> valMap,
			ArrayList<String> prioritizedPropertyNames)
	{
		String cString = "";
		String tmpVal = "";
		for (String prioritizedPropertyName : prioritizedPropertyNames)
		{
			if (valMap.keySet().contains(prioritizedPropertyName))
			{
				tmpVal = valMap.get(prioritizedPropertyName);
				if (tmpVal.length()>0 && cString.length()==0)
					cString = tmpVal;
			}
		}
		return COBieUtility.getCOBieString(cString);
	}
	
	static protected String classificationCobieStringFromStringMap(Map<String,String> valMap,Map<String,String> classificationTuples)
	{
		String classification = "";
		String tmpValA = "";
		String tmpValB = "";
		for (String key : classificationTuples.keySet()) {
			tmpValA = "";
			tmpValB = "";
			if (valMap.containsKey(key)) {
				tmpValA = valMap.get(key);
				if (valMap.containsKey(classificationTuples.get(key))) {
					tmpValB = valMap.get(classificationTuples.get(key));
				}
				if (tmpValA.length() > 0 && tmpValB.length() > 0)
					classification += tmpValA + ": " + tmpValB + COBieDelim;
				else if (tmpValA.length() > 0)
					classification += tmpValA + COBieDelim;
			}
		}
		if (classification.endsWith(COBieDelim))
			classification = classification.substring(0,
					classification.length() - COBieDelim.length());
		return classification;
	}
	
	public static String valueOfAttribute(EObject root, String attributeName)
	{
		// from Leon/Reuben
		//EStructuralFeature predifinedTypeField = product.eClass.getEStructuralFeature("PredefinedType");
		//if (predifinedTypeField != null) {
			//Object value = product.eGet(predifinedTypeField); // This will contain the enum
			//} 
		String attributeVal = null;
		EStructuralFeature sf =
				root.eClass().getEStructuralFeature(attributeName);
		attributeVal = cobieStringFromFeature(root,sf);	
		return attributeVal;
	}
	
	static protected String cobieStringFromFeature(EObject root, EStructuralFeature sf)
	{
		String attributeVal = null;
		if (sf !=null)
		{
			Object value = root.eGet(sf);
			if (value instanceof String)
			{
				attributeVal = (String) value;
				
			}
			
			if (value instanceof org.eclipse.emf.common.util.Enumerator)
			{
				Enumerator enumeratorValue =
						(Enumerator) value;
				attributeVal = enumeratorValue.getLiteral();
			}
		}
		
		return attributeVal;
	}
	
	static protected Map<String,String> valuesOfAttributes(EObject root, ArrayList<String> attributeNames,boolean exclusive)
	{
		Map<String,String> attributeVals =
				new HashMap<String,String>();
		String attributeVal = null;
		if (exclusive)
		{
			EList<EStructuralFeature> classFeatures 
			=  root.eClass().getEAllStructuralFeatures();
			for(EStructuralFeature feature : classFeatures)
			{
				String featureName = feature.getName();
				if (!attributeNames.contains(featureName))
				{
					attributeVal = COBieUtility.cobieStringFromFeature(root, feature);
					if (attributeVal!=null && !attributeVals.containsKey(featureName))
						attributeVals.put(featureName, attributeVal);
				}
						
			}
		}
		else
		{
			for(String attributeName : attributeNames)
			{
				attributeVals.put(attributeName,
						COBieUtility.valueOfAttribute(root, attributeName));
			}
		}
		
		return attributeVals;
	}
	
	public static Map<String,IfcPropertyToCOBieString> psetStringsFromAttributes(EObject root, ArrayList<String> attributeNames,boolean exclusive)
	{
		Map<String,IfcPropertyToCOBieString> attributeVals =
				new HashMap<String,IfcPropertyToCOBieString>();
		String attributeVal = null;
		if (exclusive)
		{
			EList<EStructuralFeature> classFeatures 
			=  root.eClass().getEAllStructuralFeatures();
			for(EStructuralFeature feature : classFeatures)
			{
				String featureName = feature.getName();
				if (!attributeNames.contains(featureName))
				{
					attributeVal = COBieUtility.cobieStringFromFeature(root, feature);
					if (attributeVal!=null && !attributeVals.containsKey(featureName))
					{
						if (feature instanceof IfcPropertySingleValue)
						{
							IfcPropertySingleValue sVal =
									(IfcPropertySingleValue) feature;
							IfcSingleValueToCOBieString sValStr =
									new IfcSingleValueToCOBieString(sVal);
							attributeVals.put(featureName, sValStr);
						}
						
					}
				}
						
			}
		}
		else
		{
		//	for(String attributeName : attributeNames)
			//{
				//attributeVals.put(attributeName,
					//	COBieUtility.valueOfAttribute(root, attributeName));
			//}
		}
		
		return attributeVals;
	}
	
	static protected boolean classHasField(Object o,String fieldName)
	{
		
		boolean hasField = false;
		for(java.lang.reflect.Field slot : o.getClass().getFields())
		{
			if (slot.getName().toLowerCase().trim().equals(fieldName.toLowerCase()))
			{
				hasField = true;
			}
		}
		return hasField;
	}

	public static ArrayList<String> getEnumValueList(XmlString xmlString){
	        ArrayList<String> values = new ArrayList<String>();
	        SchemaStringEnumEntry valArr[] = xmlString.schemaType().getStringEnumEntries();
	        for(SchemaStringEnumEntry val : valArr){
	                values.add(val.getString());
	        }
	        return values;
	}
	
	public static int getCOBieSheetCount(CobieSheetName sheetName,COBIEType cobie)
	{
		int count = 0;
		try
		{
			switch (sheetName) {
			case Assembly:
				count = cobie.getAssemblies().sizeOfAssemblyArray();
				break;
			case Attribute:
				count = cobie.getAttributes().sizeOfAttributeArray();
				break;
			case Component:
				count = cobie.getComponents().sizeOfComponentArray();
				break;
			case Connection:
				count = cobie.getConnections().sizeOfConnectionArray();
				break;
			case Contact:
				count = cobie.getContacts().sizeOfContactArray();
				break;
			case Document:
				count = cobie.getDocuments().sizeOfDocumentArray();
				break;
			case Facility:
				count = cobie.getFacilities().sizeOfFacilityArray();
				break;
			case Floor:
				count = cobie.getFloors().sizeOfFloorArray();
				break;
			case Job:
				count = cobie.getJobs().sizeOfJobArray();
				break;
			case Resource:
				count = cobie.getResources().sizeOfResourceArray();
				break;
			case Space:
				count = cobie.getSpaces().sizeOfSpaceArray();
				break;
			case Spare:
				count = cobie.getSpares().sizeOfSpareArray();
				break;
			case System:
				count = cobie.getSystems().sizeOfSystemArray();
				break;
			case Type:
				count = cobie.getTypes().sizeOfTypeArray();
				break;
			case Zone:
				count = cobie.getZones().sizeOfZoneArray();
				break;
			case Impact:
				count = cobie.getImpacts().sizeOfImpactArray();
				break;
			case Coordinate:
				count = cobie.getCoordinates().sizeOfCoordinateArray();
				break;
			case Issue:
				count = cobie.getIssues().sizeOfIssueArray();
				break;
		}
		}
		catch(Exception e)
		{
			
		}
		return count;
	}
	
	
}
