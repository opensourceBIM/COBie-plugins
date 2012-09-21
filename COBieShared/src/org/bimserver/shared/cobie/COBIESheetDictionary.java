package org.bimserver.shared.cobie;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.apache.xalan.xsltc.compiler.util.NodeType;
import org.apache.xmlbeans.SchemaLocalAttribute;
import org.apache.xmlbeans.XmlCalendar;
import org.apache.xmlbeans.XmlDateTime;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.bimserver.cobie.cobielite.AssemblyType;
import org.bimserver.cobie.cobielite.AttributeType;
import org.bimserver.cobie.cobielite.COBIEDocument;
import org.bimserver.cobie.cobielite.COBIEType;
import org.bimserver.cobie.cobielite.COBIEType.Components;
import org.bimserver.cobie.cobielite.ComponentType;
import org.bimserver.cobie.cobielite.ConnectionType;
import org.bimserver.cobie.cobielite.ContactType;
import org.bimserver.cobie.cobielite.CoordinateType;
import org.bimserver.cobie.cobielite.DocumentType;
import org.bimserver.cobie.cobielite.FacilityType;
import org.bimserver.cobie.cobielite.FloorType;
import org.bimserver.cobie.cobielite.ImpactType;
import org.bimserver.cobie.cobielite.IssueType;
import org.bimserver.cobie.cobielite.JobType;
import org.bimserver.cobie.cobielite.ResourceType;
import org.bimserver.cobie.cobielite.SpaceType;
import org.bimserver.cobie.cobielite.SpareType;
import org.bimserver.cobie.cobielite.SystemType;
import org.bimserver.cobie.cobielite.TypeType;
import org.bimserver.cobie.cobielite.ZoneType;
import org.dom4j.dom.DOMNodeHelper;
import org.eclipse.emf.ecore.EObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.Node;



public class COBIESheetDictionary extends
		HashMap<String, COBIESheetCollection>
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final String COBIE_DATE_FORMATSTRING = "%1$tY-%1$tm-%1$teT%1$tH:%1$tM:%1$tS";
	protected static final Logger LOGGER = LoggerFactory.getLogger(COBIESheetDictionary.class);
	
	
	
	
	static public COBIERowDictionary cobieRowColumnNameValuesFromXMLObject(String sheetName, XmlObject xml)
	{	
		COBIERowDictionary elementMap = new COBIERowDictionary(sheetName);
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
						keyVal = stringFromXmlDateTime(xml, keyName);
						
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
						keyVal = stringFromXmlDateTime(xml, keyName);
						
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
				String formattedDateTime = String.format(COBIE_DATE_FORMATSTRING, xDateTime.getCalendarValue());
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
				formattedDate = String.format(COBIE_DATE_FORMATSTRING, xDateTime.getCalendarValue());
			}
		}
		return formattedDate;
	}
	
	private HashMap<String,String> guidToSheetName;

	public COBIESheetDictionary(COBIEDocument cobieDocument)
	{
		this.setSheetNameColumnValMap(cobieDocument);
		guidToSheetName = new HashMap<String,String>();
	}
	
	public COBIEDocument asCOBie() throws Exception
	{
		COBIEDocument cobieDocument =
				COBIEDocument.Factory.newInstance();
		COBIEType cobie = cobieDocument.addNewCOBIE();
		//Components is an XMLObject
		for(String sheetName:this.keySet())
		{
			XmlObject xmlCOBieSheet =
					getCOBieSheetXMLObject(cobie,sheetName);
			if(xmlCOBieSheet!=null)
			{
				COBIESheetCollection cobieSheetCollection =
						get(sheetName);
				for(COBIERowDictionary cobieRow:cobieSheetCollection)
				{
					try
					{
						XmlObject rowXmlObject =
								getNewSheetRowXMLObject(xmlCOBieSheet);
						setXMLObjectValuesFromRowDictionary(rowXmlObject,cobieRow);
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
					}
					
				}
			}
		}
		return cobieDocument;
	}
	
	public void deleteRow(String sheetName,String rowKey)
	{
		if (keySet().contains(sheetName))
		{
			COBIESheetCollection targetSheet =
					get(sheetName);
			COBIERowDictionary targetRow =
					targetSheet.getByCOBieRowIdString(rowKey);
			targetSheet.remove(targetRow);
		}
	}
	
	private XmlObject getCOBieSheetXMLObject(COBIEType cobie,String sheetName)
	{
		COBieUtility.CobieSheetName cobieSheetName =
				COBieUtility.CobieSheetName.valueOf(sheetName);
		XmlObject xmlObject = null;
		switch(cobieSheetName)
		{
		case Assembly:
			xmlObject = cobie.addNewAssemblies();
			break;
		case Attribute:
			xmlObject = cobie.addNewAttributes();
			break;
		case Component:
			xmlObject = cobie.addNewComponents();
			break;
		case Connection:
			xmlObject = cobie.addNewConnections();
			break;
		case Contact:
			xmlObject = cobie.addNewContacts();
			break;
		case Coordinate:
			xmlObject = cobie.addNewCoordinates();
			break;
		case Document:
			xmlObject = cobie.addNewDocuments();
			break;
		case Facility:
			xmlObject = cobie.addNewFacilities();
			break;
		case Floor:
			xmlObject = cobie.addNewFloors();
			break;
		case Impact:
			xmlObject = cobie.addNewImpacts();
			break;
		case Issue:
			xmlObject = cobie.addNewIssues();
			break;
		case Job:
			xmlObject = cobie.addNewJobs();
			break;
		case Resource:
			xmlObject = cobie.addNewResources();
			break;
		case Space:
			xmlObject = cobie.addNewSpaces();
			break;
		case Spare:
			xmlObject = cobie.addNewSpares();
			break;
		case System:
			xmlObject = cobie.addNewSystems();
			break;
		case Type:
			xmlObject = cobie.addNewTypes();
			break;
		case Zone:
			xmlObject = cobie.addNewZones();
			break;
		
		}
		return xmlObject;
	}	
	
	public static HashMap<String,Node> getColumnNameNodeMap(COBIERowDictionary rowData,Node rowNode)
	{
		HashMap<String,Node> columnNameToXMLNode =
				new HashMap<String,Node>();
		Node domNode = rowNode;
		for(String columnName:rowData.keySet())
		{
			boolean foundNodeMatch = false;
			if (domNode.getAttributes()!=null)
			{
				for(int i=0; i < domNode.getAttributes().getLength();i++)
				{
					Node attributeNode = domNode.getAttributes().item(i);
					if (!foundNodeMatch)
					{
						if(attributeNode.getLocalName().toString().equalsIgnoreCase(columnName))
						{
							foundNodeMatch = true;
							columnNameToXMLNode.put(columnName, attributeNode);
						}
					}
				}
			}
			
			if(domNode.getChildNodes()!=null)
			{
				for(int i=0; i < domNode.getChildNodes().getLength();i++)
				{
					if(!foundNodeMatch)
					{
						Node elementNode =
								domNode.getChildNodes().item(i);
						if(elementNode.getLocalName().equalsIgnoreCase(columnName))
						{
							foundNodeMatch = true;
							columnNameToXMLNode.put(columnName, elementNode);
						}
					}
				}
			}
			
			
		}
		
		return columnNameToXMLNode;
	}	
	
	private XmlObject getNewSheetRowXMLObject(XmlObject xmlSheetObject) throws Exception
	{
		return COBieNAFactory.initializeCOBieElementToNA(xmlSheetObject);
	}


	public String getSheetNameFromGuid(String guid)
	{
		if (hasGuid(guid))
			return guidToSheetName.get(guid);
		else
			return null;
	}	
	private void handleAddNewCOBieRow(String tempMasterKey,
			COBIESheetCollection tmpArray,
			COBIERowDictionary tmpElementMap)
	{
		tmpElementMap.setSheetName(tempMasterKey);
		tmpArray.add(tmpElementMap);
		if(!tmpElementMap.isGuidEmpty())
			this.guidToSheetName.put(tmpElementMap.getGuid(), tempMasterKey);
	}
	
	public boolean hasGuid(String guid)
	{
		return guidToSheetName.containsKey(guid);
	}
	
	private void setSheetNameColumnValMap(COBIEDocument cobieDocument) throws NullPointerException
	{
		 //if there is no data available then the try catch will handle the NullPointer exception 
		 //and will return a null value to the caller
		try {
			
			COBIEType cType = cobieDocument.getCOBIE();
			COBIEType.Contacts contacts = cType.getContacts();
			COBIEType.Facilities facilities = cType.getFacilities();
			COBIEType.Spaces spaces = cType.getSpaces();
			COBIEType.Zones zones = cType.getZones();
			COBIEType.Types types = cType.getTypes();
			COBIEType.Floors floors = cType.getFloors();
			COBIEType.Components components = cType.getComponents();
			COBIEType.Systems systems = cType.getSystems();
			COBIEType.Assemblies assemblies = cType.getAssemblies();
			COBIEType.Spares spares = cType.getSpares();
			COBIEType.Resources resources = cType.getResources();
			COBIEType.Jobs jobs = cType.getJobs();
			COBIEType.Connections connections = cType.getConnections();
			COBIEType.Documents documents = cType.getDocuments();
			COBIEType.Attributes attributes = cType.getAttributes();
			COBIEType.Coordinates coordinates = cType.getCoordinates();
			COBIEType.Issues issues = cType.getIssues();
			COBIEType.Impacts impacts = cType.getImpacts();
			String tempMasterKey = "Contact";
			COBIESheetCollection tmpArray = new COBIESheetCollection();
			COBIERowDictionary tmpElementMap = new COBIERowDictionary();
			int rowCounter;
			if (contacts != null && !contacts.isNil()) {
				tmpArray = new COBIESheetCollection(tempMasterKey);
				rowCounter=0;
				for (ContactType contact : contacts.getContactArray()) {
					tmpElementMap = cobieRowColumnNameValuesFromXMLObject(tempMasterKey,contact);
					rowCounter++;
					tmpElementMap.setCobieDocumentRowNumber(rowCounter);
					handleAddNewCOBieRow(tempMasterKey, tmpArray, tmpElementMap);
				}
				this.put(tempMasterKey, (COBIESheetCollection) tmpArray.clone());
			}
			if (facilities !=null && !facilities.isNil())
			{
				tempMasterKey = "Facility";
				tmpArray = new COBIESheetCollection(tempMasterKey);
				rowCounter = 0;
				for (FacilityType facility : facilities.getFacilityArray()) {
					tmpElementMap = cobieRowColumnNameValuesFromXMLObject(tempMasterKey,facility);
					rowCounter++;
					tmpElementMap.setCobieDocumentRowNumber(rowCounter);
					handleAddNewCOBieRow(tempMasterKey, tmpArray, tmpElementMap);
				}
				this.put(tempMasterKey, (COBIESheetCollection) tmpArray.clone());
			}

			if (floors != null && !floors.isNil()) {
				tempMasterKey = "Floor";
				tmpArray = new COBIESheetCollection(tempMasterKey);
				rowCounter = 0;
				for (FloorType floor : floors.getFloorArray()) {
					
					tmpElementMap = cobieRowColumnNameValuesFromXMLObject(tempMasterKey,floor);
					rowCounter++;
					tmpElementMap.setCobieDocumentRowNumber(rowCounter);
					handleAddNewCOBieRow(tempMasterKey, tmpArray, tmpElementMap);
				}
				this.put(tempMasterKey, (COBIESheetCollection) tmpArray.clone());
			}

			if (spaces != null && !spaces.isNil()) {
				tempMasterKey = "Space";
				rowCounter = 0;
				tmpArray = new COBIESheetCollection(tempMasterKey);
				for (SpaceType space : spaces.getSpaceArray()) {
					tmpElementMap = cobieRowColumnNameValuesFromXMLObject(tempMasterKey,space);
					rowCounter++;
					tmpElementMap.setCobieDocumentRowNumber(rowCounter);
					handleAddNewCOBieRow(tempMasterKey, tmpArray, tmpElementMap);
				}
				this.put(tempMasterKey, (COBIESheetCollection) tmpArray.clone());
			}

			if (zones != null && !zones.isNil()) {
				tempMasterKey = "Zone";
				tmpArray = new COBIESheetCollection(tempMasterKey);
				rowCounter = 0;
				for (ZoneType zone : zones.getZoneArray()) {
					tmpElementMap = cobieRowColumnNameValuesFromXMLObject(tempMasterKey,zone);
					rowCounter++;
					tmpElementMap.setCobieDocumentRowNumber(rowCounter);
					handleAddNewCOBieRow(tempMasterKey, tmpArray, tmpElementMap);
				}
				this.put(tempMasterKey, (COBIESheetCollection) tmpArray.clone());
			}

			if (types != null && !types.isNil()) {
				tempMasterKey = "Type";
				rowCounter = 0;
				tmpArray = new COBIESheetCollection(tempMasterKey);
				for (TypeType type : types.getTypeArray()) {
					tmpElementMap = cobieRowColumnNameValuesFromXMLObject(tempMasterKey,type);
					rowCounter++;
					tmpElementMap.setCobieDocumentRowNumber(rowCounter);
					handleAddNewCOBieRow(tempMasterKey, tmpArray, tmpElementMap);
				}
				this.put(tempMasterKey, (COBIESheetCollection) tmpArray.clone());
			}
			
			if (components != null && !components.isNil()) {
				tempMasterKey = "Component";
				tmpArray = new COBIESheetCollection(tempMasterKey);
				rowCounter = 0;
				for (ComponentType component : components.getComponentArray()) {
					tmpElementMap = cobieRowColumnNameValuesFromXMLObject(tempMasterKey,component);
					rowCounter++;
					tmpElementMap.setCobieDocumentRowNumber(rowCounter);
					handleAddNewCOBieRow(tempMasterKey, tmpArray, tmpElementMap);
				}
				this.put(tempMasterKey, (COBIESheetCollection) tmpArray.clone());
			}
			
			if (systems != null && !systems.isNil()) {
				tempMasterKey = "System";
				tmpArray = new COBIESheetCollection(tempMasterKey);
				rowCounter = 0;
				for (SystemType system : systems.getSystemArray()) {
					tmpElementMap = cobieRowColumnNameValuesFromXMLObject(tempMasterKey,system);
					rowCounter++;
					tmpElementMap.setCobieDocumentRowNumber(rowCounter);
					handleAddNewCOBieRow(tempMasterKey, tmpArray, tmpElementMap);
				}
				this.put(tempMasterKey, (COBIESheetCollection) tmpArray.clone());
			}
			if (assemblies !=null && !assemblies.isNil())
			{
				tempMasterKey = "Assembly";
				tmpArray = new COBIESheetCollection(tempMasterKey);
				rowCounter = 0;
				for (AssemblyType assembly: assemblies.getAssemblyArray()) {
					tmpElementMap = cobieRowColumnNameValuesFromXMLObject(tempMasterKey,assembly);
					rowCounter++;
					tmpElementMap.setCobieDocumentRowNumber(rowCounter);
					handleAddNewCOBieRow(tempMasterKey, tmpArray, tmpElementMap);
				}
				this.put(tempMasterKey, (COBIESheetCollection) tmpArray.clone());
				
			}
			
			if (spares !=null && !spares.isNil())
			{
				tempMasterKey = "Spare";
				tmpArray = new COBIESheetCollection(tempMasterKey);
				rowCounter = 0;
				for (SpareType spare : spares.getSpareArray()) {
					tmpElementMap = cobieRowColumnNameValuesFromXMLObject(tempMasterKey,spare);
					rowCounter++;
					tmpElementMap.setCobieDocumentRowNumber(rowCounter);
					handleAddNewCOBieRow(tempMasterKey, tmpArray, tmpElementMap);
				}
				this.put(tempMasterKey, (COBIESheetCollection) tmpArray.clone());
			}
			
			if (resources !=null && !resources.isNil())
			{
				tempMasterKey = "Resource";
				rowCounter = 0;
				tmpArray = new COBIESheetCollection(tempMasterKey);
				for (ResourceType resource : resources.getResourceArray()) {
					tmpElementMap = cobieRowColumnNameValuesFromXMLObject(tempMasterKey,resource);
					rowCounter++;
					tmpElementMap.setCobieDocumentRowNumber(rowCounter);
					handleAddNewCOBieRow(tempMasterKey, tmpArray, tmpElementMap);
				}
				this.put(tempMasterKey, (COBIESheetCollection) tmpArray.clone());
			}
			
			if (jobs !=null && !jobs.isNil())
			{
				tempMasterKey = "Job";
				tmpArray = new COBIESheetCollection(tempMasterKey);
				rowCounter = 0;
				for (JobType job : jobs.getJobArray()) {
					tmpElementMap = cobieRowColumnNameValuesFromXMLObject(tempMasterKey,job);
					rowCounter++;
					tmpElementMap.setCobieDocumentRowNumber(rowCounter);
					handleAddNewCOBieRow(tempMasterKey, tmpArray, tmpElementMap);
				}
				this.put(tempMasterKey, (COBIESheetCollection) tmpArray.clone());
			}
			
			if (connections !=null && !connections.isNil())
			{
				tempMasterKey = "Connection";
				tmpArray = new COBIESheetCollection(tempMasterKey);
				rowCounter = 0;
				for (ConnectionType connection : connections.getConnectionArray()) {
					tmpElementMap = cobieRowColumnNameValuesFromXMLObject(tempMasterKey,connection);
					rowCounter++;
					tmpElementMap.setCobieDocumentRowNumber(rowCounter);
					handleAddNewCOBieRow(tempMasterKey, tmpArray, tmpElementMap);
				}
				this.put(tempMasterKey, (COBIESheetCollection) tmpArray.clone());
			}
			
			if (documents !=null && !documents.isNil())
			{
				tempMasterKey = "Document";
				tmpArray = new COBIESheetCollection(tempMasterKey);
				rowCounter = 0;
				for (DocumentType document : documents.getDocumentArray()) {
					tmpElementMap = cobieRowColumnNameValuesFromXMLObject(tempMasterKey,document);
					rowCounter++;
					tmpElementMap.setCobieDocumentRowNumber(rowCounter);
					handleAddNewCOBieRow(tempMasterKey, tmpArray, tmpElementMap);
				}
				this.put(tempMasterKey, (COBIESheetCollection) tmpArray.clone());
			}
			
			if (attributes !=null && !attributes.isNil())
			{
				tmpArray.clear();
				tempMasterKey = "Attribute";
				tmpArray = new COBIESheetCollection(tempMasterKey);
				rowCounter = 0;
				for (AttributeType attribute : attributes.getAttributeArray()) {
					tmpElementMap = cobieRowColumnNameValuesFromXMLObject(tempMasterKey,attribute);
					rowCounter++;
					tmpElementMap.setCobieDocumentRowNumber(rowCounter);
					handleAddNewCOBieRow(tempMasterKey, tmpArray, tmpElementMap);
				}
				this.put(tempMasterKey, (COBIESheetCollection) tmpArray.clone());	
			}
			
			if (coordinates !=null && !coordinates.isNil())
			{
				tmpArray.clear();
				tempMasterKey = "Coordinate";
				tmpArray = new COBIESheetCollection(tempMasterKey);
				rowCounter = 0;
				for (CoordinateType coordinate : coordinates.getCoordinateArray()) {
					tmpElementMap = cobieRowColumnNameValuesFromXMLObject(tempMasterKey,coordinate);
					rowCounter++;
					tmpElementMap.setCobieDocumentRowNumber(rowCounter);
					handleAddNewCOBieRow(tempMasterKey, tmpArray, tmpElementMap);
				}
				this.put(tempMasterKey, (COBIESheetCollection) tmpArray.clone());	
			}
			if (issues !=null && !issues.isNil())
			{
				tmpArray.clear();
				tempMasterKey = "Issue";
				tmpArray = new COBIESheetCollection(tempMasterKey);
				rowCounter = 0;
				for (IssueType issue : issues.getIssueArray()) {
					tmpElementMap = cobieRowColumnNameValuesFromXMLObject(tempMasterKey,issue);
					rowCounter++;
					tmpElementMap.setCobieDocumentRowNumber(rowCounter);
					handleAddNewCOBieRow(tempMasterKey, tmpArray, tmpElementMap);
				}
				this.put(tempMasterKey, (COBIESheetCollection) tmpArray.clone());	
			}
			if (impacts !=null && !impacts.isNil())
			{
				tmpArray.clear();
				tempMasterKey = "Impact";
				tmpArray = new COBIESheetCollection(tempMasterKey);
				rowCounter = 0;
				for (ImpactType impact : impacts.getImpactArray()) {
					tmpElementMap = cobieRowColumnNameValuesFromXMLObject(tempMasterKey,impact);
					rowCounter++;
					tmpElementMap.setCobieDocumentRowNumber(rowCounter);
					handleAddNewCOBieRow(tempMasterKey, tmpArray, tmpElementMap);
				}
				this.put(tempMasterKey, (COBIESheetCollection) tmpArray.clone());	
			}
			
		}
		catch(NullPointerException e)
		{
			throw e;
		}
	
	}
	
	private void setXMLObjectValuesFromRowDictionary
		(XmlObject rowXmlObject,COBIERowDictionary rowData)
	{
		Node domNode = rowXmlObject.getDomNode();
		HashMap<String,Node> columnNameToXMLNode =
				getColumnNameNodeMap(rowData,domNode);
		for(String columnName:columnNameToXMLNode.keySet())
		{
			try
			{
			String columnValue = rowData.get(columnName);
			Node matchedNode = columnNameToXMLNode.get(columnName);
			if(matchedNode instanceof Element)
			{
				Element elementNode = (Element) matchedNode;
				if (elementNode.getFirstChild()==null)
				{				
					elementNode.setNodeValue(columnValue);
				}		
				else
					elementNode.getFirstChild().setNodeValue(columnValue);
			}
			else if (matchedNode instanceof Attr)
			{
				Attr attributeNode = (Attr) matchedNode;
				attributeNode.setNodeValue(columnValue);
			}
			}
			catch(Exception e)
			{
				String noop="";
			}
			
		}
		/*try
		{
			rowXmlObject.set(XmlObject.Factory.parse(domNode));
		}
		catch (XmlException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
}
