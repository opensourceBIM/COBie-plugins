//COBie spreadsheet creation and data population tools

package org.erdc.cobie.plugins.utils.spreadsheetml;
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
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import nl.fountain.xelem.XFactory;
import nl.fountain.xelem.XSerializer;
import nl.fountain.xelem.XelemException;
import nl.fountain.xelem.excel.Cell;
import nl.fountain.xelem.excel.Row;
import nl.fountain.xelem.excel.Workbook;
import nl.fountain.xelem.excel.Worksheet;
import nl.fountain.xelem.excel.WorksheetOptions;
import nl.fountain.xelem.excel.ss.SSRow;
import nl.fountain.xelem.lex.ExcelReader;


import org.erdc.cobie.shared.COBieQuery;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.shared.COBieUtility.CobieSheetName;
import org.erdc.cobie.sheetxmldata.AssemblyType;
import org.erdc.cobie.sheetxmldata.AttributeType;
import org.erdc.cobie.sheetxmldata.COBIEDocument;
import org.erdc.cobie.sheetxmldata.COBIEType;
import org.erdc.cobie.sheetxmldata.ComponentType;
import org.erdc.cobie.sheetxmldata.ConnectionType;
import org.erdc.cobie.sheetxmldata.ContactType;
import org.erdc.cobie.sheetxmldata.CoordinateType;
import org.erdc.cobie.sheetxmldata.DocumentType;
import org.erdc.cobie.sheetxmldata.FacilityType;
import org.erdc.cobie.sheetxmldata.FloorType;
import org.erdc.cobie.sheetxmldata.JobType;
import org.erdc.cobie.sheetxmldata.ResourceType;
import org.erdc.cobie.sheetxmldata.SpaceType;
import org.erdc.cobie.sheetxmldata.SpareType;
import org.erdc.cobie.sheetxmldata.SystemType;
import org.erdc.cobie.sheetxmldata.TypeType;
import org.erdc.cobie.sheetxmldata.ZoneType;
import org.bimserver.cobie.cobieserializersettings.COBieExportOptionsDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class COBieSpreadSheet {
	private static final String CLASSIFICATION_FIELD_NAME ="Category";
	private static final Logger LOGGER = LoggerFactory.getLogger(COBieSpreadSheet.class);
	// required class declarations
	// public Contact contact = new Contact();
	// public Facility facility = new Facility();
	// public Floor floor = new Floor();
	// public Space space = new Space();
	private static final String PICK_LIST_SHEET_NAME = "PickLists";
	private static final int DEFAULT_SHEET_ROW_LIMIT = 64000;
	public static final HashMap<CobieSheetName,ArrayList<String>> sheetNameColumnDictionary = getCategorizedCobieSheetNameToColumnNames();

	// public GenericSheetTool gsTool;// = new GenericSheetTool();

	private static void clearDataAtColumn(Worksheet sheet, int columnIndex)
	{
		for(Row sheetRow : sheet.getRows())
		{
			if (sheetRow.getIndex()>Worksheet.firstRow)
			{
				sheetRow.getCellAt(columnIndex).setData("");
			}
		}
	}
	
	private static Map <String,ArrayList<Map<String,String>>> cobieDocumentToStringMap(COBIEDocument cobie)
	{
		 //if there is no data available then the try catch will handle the NullPointer exception 
		 //and will return a null value to the caller
		try {
			Map<String, ArrayList<Map<String, String>>> cobieDocMap = 
					new HashMap<String, ArrayList<Map<String, String>>>();
			COBIEType cType = cobie.getCOBIE();
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
			String tempMasterKey = COBieUtility.CobieSheetName.Contact.name();
			ArrayList<Map<String, String>> tmpArray = new ArrayList<Map<String, String>>();
			Map<String, String> tmpElementMap = new HashMap<String, String>();
			if (contacts != null && !contacts.isNil()) {
				for (ContactType contact : contacts.getContactArray()) {
					tmpElementMap = COBieUtility.elementMapFromXMLObject(contact);
					tmpArray.add(tmpElementMap);
				}
				cobieDocMap.put(tempMasterKey, (ArrayList<Map<String, String>>) tmpArray.clone());
			}
			if (facilities !=null && !facilities.isNil())
			{
				tmpArray.clear();
				tempMasterKey = COBieUtility.CobieSheetName.Facility.name();
				for (FacilityType facility : facilities.getFacilityArray()) {
					tmpElementMap = COBieUtility.elementMapFromXMLObject(facility);
					tmpArray.add(tmpElementMap);
				}
				cobieDocMap.put(tempMasterKey, (ArrayList<Map<String, String>>) tmpArray.clone());
			}

			if (floors != null && !floors.isNil()) {
				tmpArray.clear();
				tempMasterKey = COBieUtility.CobieSheetName.Floor.name();
				for (FloorType floor : floors.getFloorArray()) {
					tmpElementMap = COBieUtility.elementMapFromXMLObject(floor);
					tmpArray.add(tmpElementMap);
				}
				cobieDocMap.put(tempMasterKey, (ArrayList<Map<String, String>>) tmpArray.clone());
			}

			if (spaces != null && !spaces.isNil()) {
				tmpArray.clear();
				tempMasterKey = COBieUtility.CobieSheetName.Space.name();
				for (SpaceType space : spaces.getSpaceArray()) {
					tmpElementMap = COBieUtility.elementMapFromXMLObject(space);
					tmpArray.add(tmpElementMap);
				}
				cobieDocMap.put(tempMasterKey, (ArrayList<Map<String, String>>) tmpArray.clone());
			}

			if (zones != null && !zones.isNil()) {
				tmpArray.clear();
				tempMasterKey = COBieUtility.CobieSheetName.Zone.name();
				for (ZoneType zone : zones.getZoneArray()) {
					tmpElementMap = COBieUtility.elementMapFromXMLObject(zone);
					tmpArray.add(tmpElementMap);
				}
				cobieDocMap.put(tempMasterKey, (ArrayList<Map<String, String>>) tmpArray.clone());
			}

			if (types != null && !types.isNil()) {
				tmpArray.clear();
				tempMasterKey = COBieUtility.CobieSheetName.Type.name();
				for (TypeType type : types.getTypeArray()) {
					tmpElementMap = COBieUtility.elementMapFromXMLObject(type);
					tmpArray.add(tmpElementMap);
				}
				cobieDocMap.put(tempMasterKey, (ArrayList<Map<String, String>>) tmpArray.clone());
			}
			
			if (components != null && !components.isNil()) {
				tmpArray.clear();
				tempMasterKey = COBieUtility.CobieSheetName.Component.name();
				for (ComponentType component : components.getComponentArray()) {
					tmpElementMap = COBieUtility.elementMapFromXMLObject(component);
					tmpArray.add(tmpElementMap);
				}
				cobieDocMap.put(tempMasterKey, (ArrayList<Map<String, String>>) tmpArray.clone());
			}
			
			if (systems != null && !systems.isNil()) {
				tmpArray.clear();
				tempMasterKey = COBieUtility.CobieSheetName.System.name();
				for (SystemType system : systems.getSystemArray()) {
					tmpElementMap = COBieUtility.elementMapFromXMLObject(system);
					tmpArray.add(tmpElementMap);
				}
				cobieDocMap.put(tempMasterKey, (ArrayList<Map<String, String>>) tmpArray.clone());
			}
			if (assemblies !=null && !assemblies.isNil())
			{
				tmpArray.clear();
				tempMasterKey = COBieUtility.CobieSheetName.Assembly.name();
				for (AssemblyType assembly : assemblies.getAssemblyArray()) {
					tmpElementMap = COBieUtility.elementMapFromXMLObject(assembly);
					tmpArray.add(tmpElementMap);
				}
				cobieDocMap.put(tempMasterKey, (ArrayList<Map<String, String>>) tmpArray.clone());
				
			}
			
			if (spares !=null && !spares.isNil())
			{
				tmpArray.clear();
				tempMasterKey = COBieUtility.CobieSheetName.Spare.name();
				for(SpareType spare : spares.getSpareArray())
				{
					tmpElementMap = COBieUtility.elementMapFromXMLObject(spare);
					tmpArray.add(tmpElementMap);
				}
				cobieDocMap.put(tempMasterKey, (ArrayList<Map<String,String>>) tmpArray.clone());
			}
			
			if (resources !=null && !resources.isNil())
			{
				tmpArray.clear();
				tempMasterKey = COBieUtility.CobieSheetName.Resource.name();
				for(ResourceType resource : resources.getResourceArray())
				{
					tmpElementMap = COBieUtility.elementMapFromXMLObject(resource);
					tmpArray.add(tmpElementMap);
				}
				cobieDocMap.put(tempMasterKey, (ArrayList<Map<String,String>>) tmpArray.clone());
			}
			
			if (jobs !=null && !jobs.isNil())
			{
				tmpArray.clear();
				tempMasterKey = COBieUtility.CobieSheetName.Job.name();
				for(JobType job : jobs.getJobArray())
				{
					tmpElementMap = COBieUtility.elementMapFromXMLObject(job);
					tmpArray.add(tmpElementMap);
				}
				cobieDocMap.put(tempMasterKey, (ArrayList<Map<String,String>>) tmpArray.clone());
			}
			
			if (connections !=null && !connections.isNil())
			{
				tmpArray.clear();
				tempMasterKey = COBieUtility.CobieSheetName.Connection.name();
				for (ConnectionType connection: connections.getConnectionArray()) {
					tmpElementMap = COBieUtility.elementMapFromXMLObject(connection);
					tmpArray.add(tmpElementMap);
				}
				cobieDocMap.put(tempMasterKey, (ArrayList<Map<String, String>>) tmpArray.clone());		
			}
			
			if (documents !=null && !documents.isNil())
			{
				tmpArray.clear();
				tempMasterKey = COBieUtility.CobieSheetName.Document.name();
				for (DocumentType document: documents.getDocumentArray()) {
					tmpElementMap = COBieUtility.elementMapFromXMLObject(document);
					tmpArray.add(tmpElementMap);
				}
				cobieDocMap.put(tempMasterKey, (ArrayList<Map<String, String>>) tmpArray.clone());		
			}
			
			if (attributes !=null && !attributes.isNil())
			{
				tmpArray.clear();
				tempMasterKey = COBieUtility.CobieSheetName.Attribute.name();
				for (AttributeType attribute: attributes.getAttributeArray()) {
					tmpElementMap = COBieUtility.elementMapFromXMLObject(attribute);
					tmpArray.add(tmpElementMap);
				}
				cobieDocMap.put(tempMasterKey, (ArrayList<Map<String, String>>) tmpArray.clone());		
			}
			
			if (coordinates !=null && !coordinates.isNil())
			{
				tmpArray.clear();
				tempMasterKey = COBieUtility.CobieSheetName.Coordinate.name();
				for (CoordinateType coordinate:coordinates.getCoordinateArray()) {
					tmpElementMap = COBieUtility.elementMapFromXMLObject(coordinate);
					tmpArray.add(tmpElementMap);
				}
				cobieDocMap.put(tempMasterKey, (ArrayList<Map<String, String>>) tmpArray.clone());		
			}
			
			
			return cobieDocMap;
		}
		catch(NullPointerException e){
			return null;
		}
	
	}
	public static HashMap<CobieSheetName,ArrayList<String>> getCategorizedCobieSheetNameToColumnNames()
	{
		HashMap<CobieSheetName,ArrayList<String>> columnMappings = new HashMap<CobieSheetName,ArrayList<String>>();
		columnMappings.put(CobieSheetName.Contact, SpreadsheetToContacts.getContactColumns());
		columnMappings.put(CobieSheetName.Facility, SpreadsheetToFacilities.getFacilityColumns());
		columnMappings.put(CobieSheetName.Floor, SpreadsheetToFloors.getFloorColumns());
		columnMappings.put(CobieSheetName.Space, SpreadsheetToSpaces.getSpaceColumnNames());
		columnMappings.put(CobieSheetName.Zone, SpreadsheetToZones.getZoneColumns());
		columnMappings.put(CobieSheetName.Type, SpreadsheetToTypes.getTypeColumns());
		columnMappings.put(CobieSheetName.System, SpreadsheetToSystems.getSystemColumns());
		return columnMappings;
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

	public static boolean isRowPopulated(Row rowData, int startColumnIndex,int endColumnIndex)
	{
		boolean isPopulated = false;
		try
		{
			Map<Integer,Cell> cellMap = rowData.getCellMap();

			for(int i=startColumnIndex; i<=endColumnIndex;i++)
			{
				if (cellMap.containsKey(i))
				{
					if (cellMap.get(i).getData$()!=null && cellMap.get(i).getData$().length()>0)
						isPopulated=true;
				}
			}
			
		}
		catch(Exception e)
		{
			
		}
		return isPopulated;
	}
	private COBieExportOptionsDocument exportSettings;
	// filename for the new file to be created
	private String fileName = "cobie.xml";
	private long sheetRowLimit;
	// asdfasfv
	// private COBIEDocument cobieDoc;

	Document spreadsheetMLDocument;
	// create the required tools in order to read the template file
	ExcelReader reader = null;

	// put all sheet data into one monster object,
	// data will be modified by the genericsheetTool function
	public Map<String, ArrayList<Map<String, String>>> sheetData;
	// Default path to the xml template file
	private String templateFilePath;
	  // map will contain all sheet tab names mapped to string array containing
	// column headings
	public HashMap<String, String[]> templateMap = new HashMap<String, String[]>();
	 
	   Workbook xlWorkbook = null;
	  
	  //Begin constructors 
	 //user does not provide new file name or name of template file path to be used
	public COBieSpreadSheet(File configurationFile) { 
		
		exportSettings = null;
		this.sheetRowLimit = getSheetRowLimit();
	  	try {
	  		templateFilePath = configurationFile.getAbsolutePath();
		  	init(); 
	  	} 
		catch (IOException e) {
			LOGGER.error("", e);
		} 
	  }
	  
	   public COBieSpreadSheet(File configurationFile,COBieExportOptionsDocument exportSettings) 
	  { 
			this.exportSettings = exportSettings;
			this.sheetRowLimit = getSheetRowLimit();
		  	try 
		  	{
		  		templateFilePath = configurationFile.getAbsolutePath();
			  	init(); 
		  	} 
			catch (IOException e) 
			{
				LOGGER.error("", e);
			} 
		  }

	//User specifies path of template file
	  public COBieSpreadSheet(String templatePath) {
		  
		  exportSettings = null;
		  this.sheetRowLimit = getSheetRowLimit();
		  try {
			  templateFilePath = templatePath;
			  	init(); 
		  	} 
			catch (IOException e) {
				LOGGER.error("", e);
			} 
	  
	  }
	  
	  // User specifies path of template file
	public COBieSpreadSheet(String templatePath,
			COBieExportOptionsDocument exportSettings)
	{	
		this.exportSettings = exportSettings;
		this.sheetRowLimit = getSheetRowLimit();
		try
		{
			templateFilePath = templatePath;
			init();
		}
		catch (IOException e)
		{
			LOGGER.error("", e);
		}

	}

	private void clearAllRows()
	{
		for(Worksheet sheet:xlWorkbook.getWorksheets())
		{
			try
			{
				CobieSheetName sheetName =
						COBieUtility.CobieSheetName.valueOf(sheet.getName());
				ArrayList<Integer> rowsToDelete = new ArrayList<Integer>();
				for(int i=0; i < sheet.getRows().size();i++)
				{
					if(i>0)
					{
						if(sheet.hasRowAt(i))
							rowsToDelete.add(i);
					}
				}
				
				for(int rowIndex:rowsToDelete)
					sheet.removeRowAt(rowIndex);
			}
			catch(Exception e)
			{
				
			}
		}
	}
	
	// create the new COBie file and populate the data for each sheet
	 // if the user does not provide a filename for the new cobie.xml file
	public void createFile() {
		try {
			populateSheetData();
			//this.sheetData.clear();
			// output stream for creating the new file
			OutputStream out = new BufferedOutputStream(new FileOutputStream(
					fileName));
			spreadsheetMLDocument = xlWorkbook.createDocument();
			new XSerializer().serialize(spreadsheetMLDocument, out);
			out.close();
		} catch (IOException e) {
			LOGGER.error("", e);
		} catch (ParserConfigurationException e) {
			LOGGER.error("", e);
		} catch (XelemException e) {
			LOGGER.error("", e);
		}
	}

	// end constructors


	public void createFile(String myFileName){ 
		try {
			setFileName(myFileName);
			populateSheetData();
			// output stream for creating the new file
			OutputStream out = new BufferedOutputStream(new FileOutputStream(
					fileName));
			spreadsheetMLDocument = xlWorkbook.createDocument();
			new XSerializer().serialize(spreadsheetMLDocument, out);
			out.close();
		} catch (IOException e) {
			LOGGER.error("", e);
		} catch (ParserConfigurationException e) {
			LOGGER.error("", e);
		} catch (XelemException e) {
			LOGGER.error("", e);
		}		
	}

	public void createFile(String myFileName, String templateFileName){ 
		try {
			setFileName(myFileName);
			setConfigurationFile(templateFileName);
			populateSheetData();
			// output stream for creating the new file
			OutputStream out = new BufferedOutputStream(new FileOutputStream(
					fileName));
			spreadsheetMLDocument = xlWorkbook.createDocument();
			new XSerializer().serialize(spreadsheetMLDocument, out);
			out.close();
		} catch (IOException e) {
			LOGGER.error("", e);
		} catch (ParserConfigurationException e) {
			LOGGER.error("", e);
		} catch (XelemException e) {
			LOGGER.error("", e);
		}		
	}	
	/////////End file creation functions

	 private ArrayList<String> distinctCategoryValuesFromSheetName(CobieSheetName sheetName)
	{
		
		ArrayList<String> distinctCategories = new ArrayList<String>();
		Worksheet targetSheet = worksheetFromCobieSheetName(sheetName);
		try
		{
			ArrayList<String> sheetColNames = getCategorizedCobieSheetNameToColumnNames().get(sheetName);
			Map<String,Integer> dictionaryMap = GetWorksheetColumnDictionary(targetSheet, sheetColNames);
			int categoryIndex = dictionaryMap.get(COBieSpreadSheet.CLASSIFICATION_FIELD_NAME);
			if (categoryIndex>-1)
			{
				for(Row row : targetSheet.getRows())
				{

						String categoryValue = row.getCellAt(categoryIndex).getData$();
						if (!categoryValue.equals(CLASSIFICATION_FIELD_NAME)&&!distinctCategories.contains(categoryValue) && categoryValue.length()>0)
						{
							distinctCategories.add(categoryValue);
						}
					
				}
			}
			else
				throw new Exception("No category field found");
		}
		catch(Exception e)
		{
			
		}
		return distinctCategories;
	}

	 public void gc()
	  {
		  this.spreadsheetMLDocument = null;
		  this.sheetData.clear();
	  }

	// end getters and setters for private functions

	// start file creation functions

	 private int getClassificationColumnIndex(ArrayList<String> sheetColNames)
	{
		int categoryIndex = sheetColNames.indexOf(CLASSIFICATION_FIELD_NAME);
		return categoryIndex;
	}
	
	public String getConfigurationFileName() {
		return templateFilePath;
	}
	
	
	// get the fileName for the new COBie File
	public String getFileName() {
		return fileName;
	}
	
	//get the XML text for the template file
	public String getXMLText() throws TransformerFactoryConfigurationError, TransformerException
	{
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");

		//initialize StreamResult with File object to save to file		
		String xml = "";
		try
		{
			spreadsheetMLDocument = xlWorkbook.createDocument();
			
		}
		catch (ParserConfigurationException e) {
			LOGGER.error("", e);
		} 
		StreamResult result = new StreamResult(new StringWriter());
		DOMSource source = new DOMSource(spreadsheetMLDocument);
		transformer.transform(source, result);
		xml = result.getWriter().toString();
		return xml;
	}
	
	
	private void inactiveSheet(Worksheet sheet)
	{
		WorksheetOptions tmpSheetOptions;
		tmpSheetOptions =
				sheet.getWorksheetOptions();
		tmpSheetOptions.setTabColorIndex(23);
		
		sheet.setWorksheetOptions(tmpSheetOptions);
	}
	
	// general initialize function that any of the constructors will call
	public void init() throws IOException 
	{
		
		XFactory.setConfigurationFileName(templateFilePath);

		try {
			reader = new ExcelReader();
			xlWorkbook = reader.getWorkbook(templateFilePath);
			clearAllRows();
			
		} catch (ParserConfigurationException e) {
			LOGGER.error("", e);
		} catch (SAXException e) {
			LOGGER.error("", e);
		}

		// get the sheetNames and column headings from the template file and
		// store them in the global map
		populateMap();
	}
	
	public void loadCOBie(COBIEDocument cobie)
	{
		setCobieDocumentToStringMap(cobieDocumentToStringMap(cobie));
		populateSheetData();
	}
	
	

	   public void nodeToStream(Node node,PrintWriter out)
	   {
		   String workSheetName="";
		   boolean canonical = false;
	      // is there anything to do?
	      if (node == null)
	      {
	         return;
	      }

	      int type = node.getNodeType();
	      switch (type)
	      {
	         // print document
	         case Node.DOCUMENT_NODE:
	            {
	               if (!canonical)
	               {
	                  out.println("<?xml version=\"1.0\"?>");
	               }
	               //print(((Document)node).getDocumentElement());
	                
	               NodeList children = node.getChildNodes();
	               for (int iChild = 0; iChild < children.getLength(); iChild++)
	               {
	                  nodeToStream(children.item(iChild),out);
	               }
	               out.flush();
	               break;
	            }

	            // print element with attributes
	         case Node.ELEMENT_NODE:
	            {
	               out.print('<');
	               out.print(node.getNodeName());
	               Attr attrs[] = sortAttributes(node.getAttributes());
	               for (int i = 0; i < attrs.length; i++)
	               {
	                  Attr attr = attrs[i];
	            	  if ((node.getNodeName().equalsIgnoreCase("Worksheet") ||
	            			  node.getNodeName().equalsIgnoreCase("ss:Worksheet")) &&
	            			attr.getName().equalsIgnoreCase("Name") ||
	            			attr.getName().equalsIgnoreCase("ss:Name"))
	            	  {
	            		  workSheetName = normalize(attr.getNodeValue());
	            	  }
	                  out.print(' ');
	                  out.print(attr.getNodeName());
	                  out.print("=\"");
	                  out.print(normalize(attr.getNodeValue()));
	                  out.print('"');
	               }
	               out.print('>');
	               out.flush();
	               NodeList children = node.getChildNodes();
	               if (children != null)
	               {
	                  int len = children.getLength();
	                  for (int i = 0; i < len; i++)
	                  {
	                     nodeToStream(children.item(i),out);
	                  }
	               }
	               break;
	            }

	            // handle entity reference nodes
	         case Node.ENTITY_REFERENCE_NODE:
	            {
	               if (canonical)
	               {
	                  NodeList children = node.getChildNodes();
	                  if (children != null)
	                  {
	                     int len = children.getLength();
	                     for (int i = 0; i < len; i++)
	                     {
	                        nodeToStream(children.item(i),out);
	                     }
	                  }
	               }
	               else
	               {
	                  out.print('&');
	                  out.print(node.getNodeName());
	                  out.print(';');
	               }
	               break;
	            }

	            // print cdata sections
	         case Node.CDATA_SECTION_NODE:
	            {
	               if (canonical)
	               {
	                  out.print(normalize(node.getNodeValue()));
	               }
	               else
	               {
	                  out.print("<![CDATA[");
	                  out.print(node.getNodeValue());
	                  out.print("]]>");
	               }
	               break;
	            }

	            // print text
	         case Node.TEXT_NODE:
	            {
	               out.print(normalize(node.getNodeValue()));
	               break;
	            }

	            // print processing instruction
	         case Node.PROCESSING_INSTRUCTION_NODE:
	            {
	               out.print("<?");
	               out.print(node.getNodeName());
	               String data = node.getNodeValue();
	               if (data != null && data.length() > 0)
	               {
	                  out.print(' ');
	                  out.print(data);
	               }
	               out.print("?>");
	               break;
	            }

	            // print comment
	         case Node.COMMENT_NODE:
	            {
	               out.print("<!--");
	               String data = node.getNodeValue();
	               if (data != null)
	               {
	                  out.print(data);
	               }
	               out.print("-->");
	               break;
	            }
	      }

	      if (type == Node.ELEMENT_NODE)
	      {
	    	  if ((node.getNodeName().equalsIgnoreCase("Worksheet") ||
        			  node.getNodeName().equalsIgnoreCase("ss:Worksheet"))&&
	    			  workSheetName.length()>0)
	    	  {
	    		  out.print(printCOBieSheetDataValidation(workSheetName));
	    	  }
	         out.print("</");
	         out.print(node.getNodeName());
	         out.print('>');
	      }

	      out.flush();

	   } // print(Node)
	   
	   /** Normalizes the given string. */
	   protected String normalize(String s)
	   {
		   boolean canonical = false;
	      StringBuffer str = new StringBuffer();

	      int len = (s != null) ? s.length() : 0;
	      for (int i = 0; i < len; i++)
	      {
	         char ch = s.charAt(i);
	         switch (ch)
	         {
	            case '<':
	               {
	                  str.append("&lt;");
	                  break;
	               }
	            case '>':
	               {
	                  str.append("&gt;");
	                  break;
	               }
	            case '&':
	               {
	                  str.append("&amp;");
	                  break;
	               }
	            case '"':
	               {
	                  str.append("&quot;");
	                  break;
	               }
	            case '\r':
	            case '\n':
	               {
	                  if (canonical)
	                  {
	                     str.append("&#");
	                     str.append(Integer.toString(ch));
	                     str.append(';');
	                     break;
	                  }
	                  // else, default append char
	               }
	            default:
	               {
	                  str.append(ch);
	               }
	         }
	      }

	      return (str.toString());

	   } // normalize(String):String
	   
	   public void populateAllPickListCategoryValues()
	{
		Worksheet pickListSheet = xlWorkbook.getWorksheet(PICK_LIST_SHEET_NAME);
		HashMap<CobieSheetName,String> sheetNamePickListCategoryColName = COBieQuery.getCobieSheetNamesPickListCategory();
		for(CobieSheetName sheetName : sheetNamePickListCategoryColName.keySet())
		{
			try
			{
				ArrayList<String> distinctCategories = distinctCategoryValuesFromSheetName(sheetName);
				populatePickListCategoryValues(sheetNamePickListCategoryColName.get(sheetName),distinctCategories,pickListSheet);
			}
			catch(Exception e)
			{
				
			}
		}
	}


	   //////////////////////////////////////////////////////////////////////////////////
 ////functions pulled from generic sheet tool
	// function is responsible for populating the map that contains all the
	// sheet names and column headings
	private void populateMap() {
		// get the names for each of the sheets in the workbook
		List<String> sNames = xlWorkbook.getSheetNames();

		// for each sheetname, get the column heading and populate the hashmap
		// using those values
		for (String name : sNames) 
		{
			// current WorkSheet name
			Worksheet curSheet = xlWorkbook.getWorksheet(name);
			// 1 is the first row not zero
			Row topRow1 = curSheet.getRowAt(1);
			// all cells in the row
			Collection<Cell> cells = topRow1.getCells();

			// create a string array for adding column headings to the hashmap
			String[] colHead = new String[cells.size()];

			// populate the the column headings into a string array to send to
			// the HashMap
			int i = 0;
			for (Cell j : cells) {
				colHead[i] = j.getData$();
				i++;
			}
			templateMap.put(name, colHead);
		} 		
	}

	
	// end file creation functions

	 public void populatePickListCategoryValues(String pickListColumnName,ArrayList<String> categoryValues,Worksheet pickListSheet)
	{
		ArrayList<String> pickListColumnNames = new ArrayList<String>();
		pickListColumnNames.add(pickListColumnName);
		Map<String,Integer> pickListMap = GetWorksheetColumnDictionary(pickListSheet, pickListColumnNames);
		int pickListColIndex = pickListMap.get(pickListColumnName);
		if (pickListColIndex>-1)
		{
			clearDataAtColumn(pickListSheet,pickListColIndex);
			for(Row row: pickListSheet.getRows())
			{
				int rowIdx = row.getIndex();
				if (rowIdx<=categoryValues.size()+2)
				{
					if(rowIdx !=Worksheet.firstRow)
					{
						row.getCellAt(pickListColIndex).setData(categoryValues.get(rowIdx-2));
					}
				}
			}
		}
	}

	//populate the sheet data stored in the java classes into the newly created template file 
	@SuppressWarnings({
				"rawtypes"
		})
	public void populateSheetData() {
		// sheetData is the data that is stored in the java classes and will be
		// used to populate data
		// into the template file before the new file is created
		WorksheetOptions tmpSheetOptions;
		int sheetRowCount = 0;
		Set templateMapSet = templateMap.entrySet(); // get the Set of data
														// representing the
														// template file,I.E
														// rows columns and any
														// data
		Iterator mapIter = templateMapSet.iterator();// iterate over sheets in
														// the template file
		Map.Entry currentEntry; // current sheet and column information from template
							// file
		Row row; // Row of data in template file
		HashMap curSheetAryList; // current column in the Sheet data being
									// examined
		Iterator curSheetRowIter; // current row in the sheetData being examined
		String[] columnList;// columns in the sheetData
		ArrayList<Map<String, String>> curSheetData; // Array list of Rows for
														// the current sheet in
														// the sheetData
		String curColumnData; // data in the current cell being examined in the
								// SheetData
		Worksheet sheet = null;

		while (mapIter.hasNext()) 
		{
			// get the next Sheet in the map, List is not in order of sheets in
			// the cobie document
			currentEntry = (Map.Entry) mapIter.next();
			// put the list of column headings in a string array for easy access
			// to column names
			columnList = (String[]) currentEntry.getValue();
			if (sheetData != null) 
			{
				// get the data from sheet data to populate the data into file
				// created with the template
				curSheetData = sheetData.get(currentEntry.getKey());

				// if curSheetData is null then no data was found for the
				// current sheet
				if (curSheetData != null) 
				{
					processEntryIntoSheet(currentEntry, columnList,
							curSheetData);
				} 
				else
				{
					sheet = xlWorkbook.getWorksheet((String) currentEntry.getKey());
					String sheetName = sheet.getName();
					if (!COBieUtility.isInformationSheet(sheetName))
						inactiveSheet(sheet);
				}
			}
		}
		this.populateAllPickListCategoryValues();
	}

	protected String printCOBieSheetDataValidation(String sheetName)
	   {
		   String dataValidation = "";
		   if (sheetName.equalsIgnoreCase("contact")) dataValidation = COBieSpreadsheetOptions.contactDataValidationElementText; 
		   else if (sheetName.equalsIgnoreCase("facility")) dataValidation = COBieSpreadsheetOptions.facilityDataValidationElementText; 
		   else if (sheetName.equalsIgnoreCase("floor")) dataValidation = COBieSpreadsheetOptions.floorDataValidationElementText; 
		   else if (sheetName.equalsIgnoreCase("space")) dataValidation = COBieSpreadsheetOptions.spaceDataValidationElementText; 
		   else if (sheetName.equalsIgnoreCase("zone")) dataValidation = COBieSpreadsheetOptions.zoneDataValidationElementText; 
		   else if (sheetName.equalsIgnoreCase("type")) dataValidation = COBieSpreadsheetOptions.typeDataValidationElementText; 
		   else if (sheetName.equalsIgnoreCase("component")) dataValidation = COBieSpreadsheetOptions.componentDataValidationElementText; 
		   else if (sheetName.equalsIgnoreCase("system")) dataValidation = COBieSpreadsheetOptions.systemDataValidationElementText; 
		   else if (sheetName.equalsIgnoreCase("assembly")) dataValidation = COBieSpreadsheetOptions.assemblyDataValidationElementText; 
		   else if (sheetName.equalsIgnoreCase("connection")) dataValidation = COBieSpreadsheetOptions.connectionDataValidationElementText; 
		   else if (sheetName.equalsIgnoreCase("spare")) dataValidation = COBieSpreadsheetOptions.spareDataValidationElementText; 
		   else if (sheetName.equalsIgnoreCase("resource")) dataValidation = COBieSpreadsheetOptions.resourceDataValidationElementText; 
		   else if (sheetName.equalsIgnoreCase("job")) dataValidation = COBieSpreadsheetOptions.jobDataValidationElementText; 
		   else if (sheetName.equalsIgnoreCase("impact")) dataValidation = COBieSpreadsheetOptions.impactDataValidationElementText; 
		   else if (sheetName.equalsIgnoreCase("document")) dataValidation = COBieSpreadsheetOptions.documentDataValidationElementText; 
		   else if (sheetName.equalsIgnoreCase("attribute")) dataValidation = COBieSpreadsheetOptions.attributeDataValidationElementText; 
		   else if (sheetName.equalsIgnoreCase("coordinate")) dataValidation = COBieSpreadsheetOptions.coordinateDataValidationElementText; 
		   else if (sheetName.equalsIgnoreCase("issue")) dataValidation = COBieSpreadsheetOptions.issueDataValidationElementText; 	   
		   return dataValidation;
	   }


	private void processEntryIntoSheet(Map.Entry currentEntry,
			String[] columnList, ArrayList<Map<String, String>> curSheetData)
	{
		WorksheetOptions tmpSheetOptions;
		int sheetRowCount;
		Row row;
		HashMap curSheetAryList;
		Iterator curSheetRowIter;
		String curColumnData;
		Worksheet sheet;
		sheet = xlWorkbook.getWorksheet((String) currentEntry.getKey());
		curSheetRowIter = curSheetData.iterator();
		// rows = new ArrayList();
		sheetRowCount=0;
		while (curSheetRowIter.hasNext() && sheetRowCount<=sheetRowLimit) 
		{
			
			curSheetAryList = (HashMap) curSheetRowIter.next();
			row = new SSRow();
			row.setIndex(sheetRowCount+1);
			for (int i = 0; i < columnList.length; i++) 
			{
				curColumnData = (String) (curSheetAryList
						.get(columnList[i]));
				// If there is data available for the current cell
				// then add it else put default value N/A
				if (curColumnData != null
						&& curColumnData.length() > 0) 
				{
					row.addCell(curColumnData);
				} 
				else 
				{
					// IMPORTANT FOR SCHEMA CHECKING!!!!!!!!!
					// N/A may not be not fit the schema and this
					// value may need to be changed for later
					row.addCell("N/A");
				}
			}
			if (row.size() > 0) 
			{
				// add row
				sheet.addRow(row);
				sheetRowCount++;
			} 
			else 
			{
				sheet.addRow(row);
				sheetRowCount++;
			}
		}
		if (sheetRowCount==0)
		{
			inactiveSheet(sheet);
		}
	}
  
	private long getSheetRowLimit()
	{
	 	long sheetLimit;
	 	if(exportSettings==null)
	 		sheetLimit = DEFAULT_SHEET_ROW_LIMIT;
	 	else
	 		sheetLimit = sheetRowLimitFromExportSettings();
	 	return sheetLimit;
	}

	private long sheetRowLimitFromExportSettings()
	{
		long sheetLimit;
		try
		{
			sheetLimit = exportSettings.getCOBieExportOptions().getSpreadsheetOptions().getRowLimit();
		}
		catch(Exception e)
		{
			sheetLimit = DEFAULT_SHEET_ROW_LIMIT;
		}
		return sheetLimit;
	}

// get the super map responsible for holding all of the data for the sheets
	// this information is used for populating the data in
	public void setCobieDocumentToStringMap(
			Map<String, ArrayList<Map<String, String>>> cobieDocumentToStringMap) {
		sheetData = cobieDocumentToStringMap;
	}

	public void setConfigurationFile(String configFile) {
		XFactory.setConfigurationFileName(configFile);
		
		 try {
			  	init(); 
		  	} 
			catch (IOException e) {
				LOGGER.error("", e);
			} 
	}
	
	// set the fileName for the new COBie File
	 // will default to "cobie.xml"
	public void setFileName(String file) {
		fileName = file;
	}
	
	protected Attr[] sortAttributes(NamedNodeMap attrs)
	   {

	      int len = (attrs != null) ? attrs.getLength() : 0;
	      Attr array[] = new Attr[len];
	      for (int i = 0; i < len; i++)
	      {
	         array[i] = (Attr) attrs.item(i);
	      }
	      for (int i = 0; i < len - 1; i++)
	      {
	         String name = array[i].getNodeName();
	         int index = i;
	         for (int j = i + 1; j < len; j++)
	         {
	            String curName = array[j].getNodeName();
	            if (curName.compareTo(name) < 0)
	            {
	               name = curName;
	               index = j;
	            }
	         }
	         if (index != i)
	         {
	            Attr temp = array[i];
	            array[i] = array[index];
	            array[index] = temp;
	         }
	      }

	      return (array);

	   } // sortAttributes(NamedNodeMap):Attr[]

	private Worksheet worksheetFromCobieSheetName(CobieSheetName sheetName)
	{
		return xlWorkbook.getWorksheet(sheetName.name());
	}
	
	public void writeNodeDeep(Node node, PrintWriter wrt)
	{
		 nodeToStream(node,wrt);
	}
	
	public void writeToOutputStream(PrintWriter wrt) 
	{
		XSerializer xs = new XSerializer(XSerializer.US_ASCII);
		try
		{
			xs.serialize(this.xlWorkbook,wrt); 
		}
		catch(XelemException e)
		{
			LOGGER.error("", e);
		}
	}
	
	public void saveToFile(File targetFile)
	{
		try
		{
			populateSheetData();
			//this.sheetData.clear();
			// output stream for creating the new file
			OutputStream out = new BufferedOutputStream(new FileOutputStream(
					targetFile));
			spreadsheetMLDocument = xlWorkbook.createDocument();
			new XSerializer().serialize(spreadsheetMLDocument, out);
			out.close();
		
	} catch (IOException e) {
		LOGGER.error("", e);
	} catch (ParserConfigurationException e) {
		LOGGER.error("", e);
	} catch (XelemException e) {
		LOGGER.error("", e);
	}
	}
	
	public void writeToOutputStreamB(PrintWriter wrt) 
	{
		try
		{
			
			spreadsheetMLDocument = xlWorkbook.createDocument();
			writeNodeDeep(spreadsheetMLDocument,wrt);
		}
		catch (Exception e) {
			LOGGER.error("", e);
		}
	}
	
	

}


