//COBie spreadsheet creation and data population tools

package org.bimserver.cobie.utils.spreadsheetml;
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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class COBieSpreadSheet {

	private static final Logger LOGGER = LoggerFactory.getLogger(COBieSpreadSheet.class);
	// required class declarations
	// public Contact contact = new Contact();
	// public Facility facility = new Facility();
	// public Floor floor = new Floor();
	// public Space space = new Space();

	// public GenericSheetTool gsTool;// = new GenericSheetTool();

	// put all sheet data into one monster object,
	// data will be modified by the genericsheetTool function
	public Map<String, ArrayList<Map<String, String>>> sheetData;
  
	// map will contain all sheet tab names mapped to string array containing
	// column headings
	public HashMap<String, String[]> templateMap = new HashMap<String, String[]>();

	// filename for the new file to be created
	private String fileName = "cobie.xml";
	private final int SheetRowLimit = 64000;
	// Default path to the xml template file
	private String templateFilePath;

	// asdfasfv
	// private COBIEDocument cobieDoc;

	// create the required tools in order to read the template file
	ExcelReader reader = null;
	Workbook xlWorkbook = null;

	Document myDoc;
	
	  //Begin constructors 
	 //user does not provide new file name or name of template file path to be used
	public COBieSpreadSheet(File configurationFile) { 
		templateFilePath = configurationFile.getAbsolutePath();
		//fileName = "cobie.xls"; 
	  	try {
		  	init(); 
	  	} 
		catch (IOException e) {
			LOGGER.error("", e);
		} 
	  }
	 
	   //User specifies path of template file
	  public COBieSpreadSheet(String templatePath) {
		 // templateFilePath= "lib/COBIEExcelTemplate.xml"; 
		  templateFilePath = templatePath;
		  
		  try {
			  	init(); 
		  	} 
			catch (IOException e) {
				LOGGER.error("", e);
			} 
	  
	  }
	  
	  public void gc()
	  {
		  this.myDoc = null;
		  this.sheetData.clear();
	  }
	  
	   //user specifies name for the file to be created and the Path name of the template file to be used
	  public void COBieSpreadsheet(String newFile, String templateFile) throws IOException { 
		  templateFilePath= templateFile; 
		  fileName = newFile;
		 
		  try {
			  	init(); 
		  	} 
			catch (IOException e) {
				LOGGER.error("", e);
			} 
	  }

	// general initialize function that any of the constructors will call
	public void init() throws IOException {
		XFactory.setConfigurationFileName(templateFilePath);

		try {
			reader = new ExcelReader();
			xlWorkbook = reader.getWorkbook(templateFilePath);
		} catch (ParserConfigurationException e) {
			LOGGER.error("", e);
		} catch (SAXException e) {
			LOGGER.error("", e);
		}

		// get the sheetNames and column headings from the template file and
		// store them in the global map
		populateMap();
	}

	// end constructors

	// Start getters and setters for private functions

	 // Change the default configuration file
	 // will accept the path to the file
	 // exp : "lib/COBIEExcelStyle.xml"
	public void setConfigurationFile(String configFile) {
		XFactory.setConfigurationFileName(configFile);
		
		 try {
			  	init(); 
		  	} 
			catch (IOException e) {
				LOGGER.error("", e);
			} 
	}

	public String getConfigurationFileName() {
		return templateFilePath;
	}

	 // set the fileName for the new COBie File
	 // will default to "cobie.xml"
	public void setFileName(String file) {
		fileName = file;
	}

	 // get the fileName for the new COBie File
	public String getFileName() {
		return fileName;
	}

	// end getters and setters for private functions

	// start file creation functions

	 // create the new COBie file and populate the data for each sheet
	 // if the user does not provide a filename for the new cobie.xml file
	public void createFile() {
		try {
			populateSheetData();
			//this.sheetData.clear();
			// output stream for creating the new file
			OutputStream out = new BufferedOutputStream(new FileOutputStream(
					fileName));
			myDoc = xlWorkbook.createDocument();
			new XSerializer().serialize(myDoc, out);
			out.close();
		} catch (IOException e) {
			LOGGER.error("", e);
		} catch (ParserConfigurationException e) {
			LOGGER.error("", e);
		} catch (XelemException e) {
			LOGGER.error("", e);
		}
	}
	
	public void createFile(String myFileName){ 
		try {
			setFileName(myFileName);
			populateSheetData();
			// output stream for creating the new file
			OutputStream out = new BufferedOutputStream(new FileOutputStream(
					fileName));
			myDoc = xlWorkbook.createDocument();
			new XSerializer().serialize(myDoc, out);
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
			myDoc = xlWorkbook.createDocument();
			new XSerializer().serialize(myDoc, out);
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
	
	//get the XML text for the template file
	public String getXMLText() throws TransformerFactoryConfigurationError, TransformerException
	{
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");

		//initialize StreamResult with File object to save to file		
		String xml = "";
		try
		{
			myDoc = xlWorkbook.createDocument();
			
		}
		catch (ParserConfigurationException e) {
			LOGGER.error("", e);
		} 
		StreamResult result = new StreamResult(new StringWriter());
		DOMSource source = new DOMSource(myDoc);
		transformer.transform(source, result);
		xml = result.getWriter().toString();
		return xml;
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
	
	public void writeToOutputStreamB(PrintWriter wrt) 
	{
		try
		{
			
			myDoc = xlWorkbook.createDocument();
			writeNodeDeep(myDoc,wrt);
		}
		catch (Exception e) {
			LOGGER.error("", e);
		}
	}
	
	public void writeNodeDeep(Node node, PrintWriter wrt)
	{
		 nodeToStream(node,wrt);
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

	
	// end file creation functions

	 //populate the sheet data stored in the java classes into the newly created template file 
	@SuppressWarnings("rawtypes")
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
		Map.Entry myEntry; // current sheet and column information from template
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
			myEntry = (Map.Entry) mapIter.next();
			// put the list of column headings in a string array for easy access
			// to column names
			columnList = (String[]) myEntry.getValue();
			if (sheetData != null) 
			{
				// get the data from sheet data to populate the data into file
				// created with the template
				curSheetData = sheetData.get(myEntry.getKey());

				// if curSheetData is null then no data was found for the
				// current sheet
				if (curSheetData != null) 
				{
					sheet = xlWorkbook.getWorksheet((String) myEntry.getKey());
					curSheetRowIter = curSheetData.iterator();
					// rows = new ArrayList();
					sheetRowCount=0;
					while (curSheetRowIter.hasNext() && sheetRowCount<=SheetRowLimit) 
					{
						
						curSheetAryList = (HashMap) curSheetRowIter.next();
						row = new SSRow();
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
						tmpSheetOptions =
								sheet.getWorksheetOptions();
						tmpSheetOptions.setTabColorIndex(23);
						
						sheet.setWorksheetOptions(tmpSheetOptions);
					}
				} 
				else 
				{
					// TODO:print or store a message for the user telling them
					// which sheet requested
					// did not have a sheet present in the template file
				}
			}
		}
	}


	// get the super map responsible for holding all of the data for the sheets
	// this information is used for populating the data in
	public void setCobieDocumentToStringMap(
			Map<String, ArrayList<Map<String, String>>> cobieDocumentToStringMap) {
		sheetData = cobieDocumentToStringMap;
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
		for (String name : sNames) {
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

			// populate the map with SheetName as key and columns headings as an
			// String array
			templateMap.put(name, colHead);
		} 		
	}


}


