package org.bimserver.cobie.plugins;
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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.xml.transform.TransformerFactoryConfigurationError;

import org.bimserver.cobie.cobielite.AssemblyType;
import org.bimserver.cobie.cobielite.AttributeType;
import org.bimserver.cobie.cobielite.COBIEType;
import org.bimserver.cobie.cobielite.ComponentType;
import org.bimserver.cobie.cobielite.ConnectionType;
import org.bimserver.cobie.cobielite.ContactType;
import org.bimserver.cobie.cobielite.DocumentType;
import org.bimserver.cobie.cobielite.FacilityType;
import org.bimserver.cobie.cobielite.FloorType;
import org.bimserver.cobie.cobielite.JobType;
import org.bimserver.cobie.cobielite.ResourceType;
import org.bimserver.cobie.cobielite.SpaceType;
import org.bimserver.cobie.cobielite.SpareType;
import org.bimserver.cobie.cobielite.SystemType;
import org.bimserver.cobie.cobielite.TypeType;
import org.bimserver.cobie.cobielite.ZoneType;
import org.bimserver.cobie.utils.COBieUtility;
import org.bimserver.cobie.utils.spreadsheetml.COBieSpreadSheet;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.plugins.serializers.ProjectInfo;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.utils.UTF8PrintWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author chrisbogen
 * This class is a sub-class of COBieLiteSerializer and its purpose is
 * to provide standard COBie SpreadsheetML serialization capabilities.  
 */
public class COBieSerializer extends COBieLiteSerializer {
	private static final String LOGGER_MESSAGE_RESPONSE_DONE_SUFFIX = "Done writing COBie to response stream.";
	private static final String LOGGER_MESSAGE_RESPONSE_BEGIN_SUFFIX = "Begin writing COBie to response stream.";
	private static final String LOGGER_MESSAGE_END_SUFFIX = "End Serializing COBie data to spreadsheetML";
	private static final String LOGGER_MESSAGE_BEGIN_SUFFIX = "Begin Serializing COBie data to spreadsheetML";
	private static final Logger LOGGER = LoggerFactory.getLogger(COBieSerializer.class);
	private COBieSpreadSheet cobieSpreadsheet;
	private PrintWriter printWriter;
	private final File configurationFile;
	
	public COBieSerializer(File configurationFile) {
		this.configurationFile = configurationFile;
	}
	public File getConfigurationFile() {
		return configurationFile;
	}
	protected void reset() {
		super.reset();
	}
	
	@Override
	public void init(IfcModelInterface model, ProjectInfo projectInfo, PluginManager pluginManager) throws SerializerException 
	{
		super.init(model, projectInfo, pluginManager);
		cobieSpreadsheet = new COBieSpreadSheet(getConfigurationFile());
	}

	/**
	 * Reads the IFC model into a COBieLite document and then transforms the COBie data
	 * to SpreadsheetML according to the default template in lib/COBieExcelTemplate.xml.
	 * The corresponding data is written to the output stream.
	 */
	private void writeCOBIE()
	{
		super.modelToCOBie();
		LOGGER.info(getLoggerMessageBegin());
		this.writeCOBieToSpreadsheet();
		LOGGER.info(getLoggerMessageDone());
		super.GetCobie().setNil();
		System.gc();
		Runtime.getRuntime().gc();
		
		try {
			//StreamResult result = this.cobieS.getStreamResult();
			//result.setWriter(this.out);
			this.cobieSpreadsheet.gc();
			this.cobieSpreadsheet.writeToOutputStreamB(this.printWriter);
			//this.out.print(this.cobieS.getXMLText());
		} catch (TransformerFactoryConfigurationError e) {
			// TODO Auto-generated catch block
			LOGGER.error("", e);
		} /*catch (TransformerException e) {
			// TODO Auto-generated catch block
					LOGGER.error("", e);
		}*/
		//this.out.print(COBie.xmlText());
	}
	private String getLoggerMessageDone() {
		return getLoggerPrefix()+LOGGER_MESSAGE_END_SUFFIX;
	}
	private String getLoggerMessageBegin() {
		return getLoggerPrefix()+LOGGER_MESSAGE_BEGIN_SUFFIX;
	}
	/**
	 * @param templatePath the path of the Excel template file (spreadsheetML only, no XLS or XLSX)
	 * 
	 * Reads the IFC model into a COBieLite document and then transforms the COBie data
	 * to SpreadsheetML by writing to a copy of the provided template path. The 
	 * resulting data is written to the output stream.
	 */
	private void writeCOBIE(String templatePath)
	{
		super.modelToCOBie();
		LOGGER.info(getLoggerMessageBegin());
		this.writeCobieToSpreadsheet(templatePath);
		LOGGER.info(getLoggerMessageDone());
		super.GetCobie().setNil();
		System.gc();
		Runtime.getRuntime().gc();
		
		try {
			//StreamResult result = this.cobieS.getStreamResult();
			//result.setWriter(this.out);
			LOGGER.info(getResponseBeginMessage());
			this.cobieSpreadsheet.gc();
			this.cobieSpreadsheet.writeToOutputStreamB(this.printWriter);
			LOGGER.info(getResponseDoneMessage());
			//this.out.print(this.cobieS.getXMLText());
		} catch (TransformerFactoryConfigurationError e) {
			// TODO Auto-generated catch block
			LOGGER.error("", e);
		} /*catch (TransformerException e) {
			// TODO Auto-generated catch block
					LOGGER.error("", e);
		}*/
		//this.out.print(COBie.xmlText());
	}
	private String getResponseDoneMessage() {
		return getLoggerPrefix()+LOGGER_MESSAGE_RESPONSE_DONE_SUFFIX;
	}
	private String getResponseBeginMessage() {
		return getLoggerPrefix()+LOGGER_MESSAGE_RESPONSE_BEGIN_SUFFIX;
	}
	
	
	/**
	 * @return a Map from the name of COBie worksheet names to a corresponding
	 * Arraylist of Column Name, String Value maps (i.e. the rows and their column values).
	 * This data structure is required by the COBieSpreadsheet class when it writes to a spreadsheet template.
	 */

	private Map <String,ArrayList<Map<String,String>>> cobieDocumentToStringMap()
	{
		 //if there is no data available then the try catch will handle the NullPointer exception 
		 //and will return a null value to the caller
		try {
			Map<String, ArrayList<Map<String, String>>> cobieDocMap = 
					new HashMap<String, ArrayList<Map<String, String>>>();
			COBIEType cType = super.GetCobie();
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
			String tempMasterKey = "Contact";
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
				tempMasterKey = "Facility";
				for (FacilityType facility : facilities.getFacilityArray()) {
					tmpElementMap = COBieUtility.elementMapFromXMLObject(facility);
					tmpArray.add(tmpElementMap);
				}
				cobieDocMap.put(tempMasterKey, (ArrayList<Map<String, String>>) tmpArray.clone());
			}

			if (floors != null && !floors.isNil()) {
				tmpArray.clear();
				tempMasterKey = "Floor";
				for (FloorType floor : floors.getFloorArray()) {
					tmpElementMap = COBieUtility.elementMapFromXMLObject(floor);
					tmpArray.add(tmpElementMap);
				}
				cobieDocMap.put(tempMasterKey, (ArrayList<Map<String, String>>) tmpArray.clone());
			}

			if (spaces != null && !spaces.isNil()) {
				tmpArray.clear();
				tempMasterKey = "Space";
				for (SpaceType space : spaces.getSpaceArray()) {
					tmpElementMap = COBieUtility.elementMapFromXMLObject(space);
					tmpArray.add(tmpElementMap);
				}
				cobieDocMap.put(tempMasterKey, (ArrayList<Map<String, String>>) tmpArray.clone());
			}

			if (zones != null && !zones.isNil()) {
				tmpArray.clear();
				tempMasterKey = "Zone";
				for (ZoneType zone : zones.getZoneArray()) {
					tmpElementMap = COBieUtility.elementMapFromXMLObject(zone);
					tmpArray.add(tmpElementMap);
				}
				cobieDocMap.put(tempMasterKey, (ArrayList<Map<String, String>>) tmpArray.clone());
			}

			if (types != null && !types.isNil()) {
				tmpArray.clear();
				tempMasterKey = "Type";
				for (TypeType type : types.getTypeArray()) {
					tmpElementMap = COBieUtility.elementMapFromXMLObject(type);
					tmpArray.add(tmpElementMap);
				}
				cobieDocMap.put(tempMasterKey, (ArrayList<Map<String, String>>) tmpArray.clone());
			}
			
			if (components != null && !components.isNil()) {
				tmpArray.clear();
				tempMasterKey = "Component";
				for (ComponentType component : components.getComponentArray()) {
					tmpElementMap = COBieUtility.elementMapFromXMLObject(component);
					tmpArray.add(tmpElementMap);
				}
				cobieDocMap.put(tempMasterKey, (ArrayList<Map<String, String>>) tmpArray.clone());
			}
			
			if (systems != null && !systems.isNil()) {
				tmpArray.clear();
				tempMasterKey = "System";
				for (SystemType system : systems.getSystemArray()) {
					tmpElementMap = COBieUtility.elementMapFromXMLObject(system);
					tmpArray.add(tmpElementMap);
				}
				cobieDocMap.put(tempMasterKey, (ArrayList<Map<String, String>>) tmpArray.clone());
			}
			if (assemblies !=null && !assemblies.isNil())
			{
				tmpArray.clear();
				tempMasterKey = "Assembly";
				for (AssemblyType assembly : assemblies.getAssemblyArray()) {
					tmpElementMap = COBieUtility.elementMapFromXMLObject(assembly);
					tmpArray.add(tmpElementMap);
				}
				cobieDocMap.put(tempMasterKey, (ArrayList<Map<String, String>>) tmpArray.clone());
				
			}
			
			if (spares !=null && !spares.isNil())
			{
				tmpArray.clear();
				tempMasterKey = "Spare";
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
				tempMasterKey = "Resource";
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
				tempMasterKey = "Job";
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
				tempMasterKey = "Connection";
				for (ConnectionType connection: connections.getConnectionArray()) {
					tmpElementMap = COBieUtility.elementMapFromXMLObject(connection);
					tmpArray.add(tmpElementMap);
				}
				cobieDocMap.put(tempMasterKey, (ArrayList<Map<String, String>>) tmpArray.clone());		
			}
			
			if (documents !=null && !documents.isNil())
			{
				tmpArray.clear();
				tempMasterKey = "Document";
				for (DocumentType document: documents.getDocumentArray()) {
					tmpElementMap = COBieUtility.elementMapFromXMLObject(document);
					tmpArray.add(tmpElementMap);
				}
				cobieDocMap.put(tempMasterKey, (ArrayList<Map<String, String>>) tmpArray.clone());		
			}
			
			if (attributes !=null && !attributes.isNil())
			{
				tmpArray.clear();
				tempMasterKey = "Attribute";
				for (AttributeType attribute: attributes.getAttributeArray()) {
					tmpElementMap = COBieUtility.elementMapFromXMLObject(attribute);
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
	
	
	@Override
	public boolean write(OutputStream outputStream) throws SerializerException {
		if (printWriter == null) 
		{
			this.printWriter = new UTF8PrintWriter(outputStream);
		}
		
		if (getMode() == Mode.BODY) 
		{
			//this.out = new UTFPrintWriter(out);
			try
			{
				writeCOBIE();
				this.printWriter.flush();
				setMode(Mode.FINISHED);
				return true;
			}
			catch (Exception e)
			{
				this.printWriter.flush();
				setMode(Mode.FINISHED);
				LOGGER.error(getLoggerPrefix()+e.getMessage());
				return false;
			}



		} 
		else if (getMode() == Mode.FINISHED) 
		{
			return false;
		}
		return false;
		
	}
	
	public boolean write(OutputStream outputStream,String templatePath) throws SerializerException {
		if (printWriter == null) 
		{
			this.printWriter = new UTF8PrintWriter(outputStream);
		}
		
		if (getMode() == Mode.BODY) 
		{
			//this.out = new UTFPrintWriter(out);
			try
			{
				writeCOBIE(templatePath);
				this.printWriter.flush();
				setMode(Mode.FINISHED);
				return true;
			}
			catch (Exception e)
			{
				this.printWriter.flush();
				setMode(Mode.FINISHED);
				LOGGER.error(getLoggerPrefix()+e.getMessage());
				return false;
			}



		} 
		else if (getMode() == Mode.FINISHED) 
		{
			return false;
		}
		return false;
		
	}
	
	
	/**
	 * Transforms the COBie data into SpreadsheetML by writing to a copy of the
	 *  default template in lib/COBieExcelTemplate.xml.
	 */
	public void writeCOBieToSpreadsheet() {
		 //create the cobieSpreadSheet for access to tools for creating and modifying new cobie documents
		cobieSpreadsheet = new COBieSpreadSheet(getConfigurationFile());
		 //send the data that belongs in the newly created spread sheet to the spreadsheet creation tool
		cobieSpreadsheet.setCobieDocumentToStringMap(cobieDocumentToStringMap());
		 //create the spreadsheet file
		cobieSpreadsheet.populateSheetData();
		
	}
	
	/**
	 * @param templatePath the path of the Excel template file (spreadsheetML only, no XLS or XLSX)
	 * 
	 * Transforms the COBie data into SpreadsheetML by writing to a copy of the
	 * SpreadsheetML template located by templatePath.
	 */
	public void writeCobieToSpreadsheet(String templatePath)
	{
		cobieSpreadsheet = new COBieSpreadSheet(templatePath);
		cobieSpreadsheet.setCobieDocumentToStringMap(cobieDocumentToStringMap());
		 //create the spreadsheet file
		cobieSpreadsheet.populateSheetData();
	}
	
	
	public void write(File file) throws FileNotFoundException, SerializerException {
		write(new FileOutputStream(file));
	}
		
}
