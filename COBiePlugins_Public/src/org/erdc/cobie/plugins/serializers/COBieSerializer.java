package org.erdc.cobie.plugins.serializers;
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

import javax.xml.transform.TransformerFactoryConfigurationError;

import org.erdc.cobie.plugins.utils.spreadsheetml.COBieSpreadSheet;
import org.erdc.cobie.shared.COBieSheetXMLDataTransformable;
import org.erdc.cobie.sheetxmldata.COBIEDocument;
import org.bimserver.cobie.cobieserializersettings.COBieExportOptionsDocument;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.ifcengine.IfcEnginePlugin;
import org.bimserver.plugins.serializers.ProjectInfo;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.utils.UTF8PrintWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author chrisbogen
 * This class is a sub-class of COBieSheetXMLDataTransformable and its purpose is
 * to provide standard COBie SpreadsheetML serialization capabilities.  
 */
public class COBieSerializer extends COBieSheetXMLDataSerializer implements COBieSheetXMLDataTransformable {
	private static final String LOGGER_MESSAGE_RESPONSE_DONE_SUFFIX = "Done writing COBie to response stream.";
	private static final String LOGGER_MESSAGE_RESPONSE_BEGIN_SUFFIX = "Begin writing COBie to response stream.";
	private static final String LOGGER_MESSAGE_END_SUFFIX = "End Serializing COBie data to spreadsheetML";
	private static final String LOGGER_MESSAGE_BEGIN_SUFFIX = "Begin Serializing COBie data to spreadsheetML";
	private static final Logger LOGGER = LoggerFactory.getLogger(COBieSerializer.class);
	private COBieSpreadSheet cobieSpreadsheet;
	private COBieExportOptionsDocument exportOptions;
	private PrintWriter printWriter;
	private final File configurationFile;
	
	public COBieSerializer(File configurationFile, File exportSettingsFile) 
	{
		this.configurationFile = configurationFile;
		try
		{
			exportOptions = COBieExportOptionsDocument.Factory.parse(exportSettingsFile);
		}
		catch(Exception ex)
		{
			exportOptions = null;
		}
	}
	public File getConfigurationFile() {
		return configurationFile;
	}
	public void reset() {
		super.reset();
	}
	
	@Override
	public void init(IfcModelInterface model, ProjectInfo projectInfo, PluginManager pluginManager) throws SerializerException 
	{
		super.init(model, projectInfo, pluginManager);
		cobieSpreadsheet = new COBieSpreadSheet(getConfigurationFile(),exportOptions);
	}

	@Override
	public void init(PluginManager pluginManager, COBIEDocument cobie)
			throws SerializerException
	{
		super.init(pluginManager, cobie);
		cobieSpreadsheet = new COBieSpreadSheet(getConfigurationFile(),exportOptions);
	}
	@Override
	public void init(IfcModelInterface model, ProjectInfo projectInfo,
			PluginManager pluginManager, IfcEnginePlugin ifcEnginePlugin,
			boolean normalizeOids) throws SerializerException
	{
		super.init(model, projectInfo, pluginManager, ifcEnginePlugin, normalizeOids);
		cobieSpreadsheet = new COBieSpreadSheet(getConfigurationFile(),exportOptions);
	}
	/**
	 * Reads the IFC model into a COBieSheetXMLData document and then transforms the COBie data
	 * to SpreadsheetML according to the default template in lib/COBieExcelTemplate.xml.
	 * The corresponding data is written to the output stream.
	 */
	private void writeCOBIE()
	{
		super.modelToCOBie();
		LOGGER.info(getLoggerMessageBegin());
		this.writeCOBieToSpreadsheet();
		LOGGER.info(getLoggerMessageDone());
		//super.GetCobie().setNil();
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
	 * Reads the IFC model into a COBieSheetXMLData document and then transforms the COBie data
	 * to SpreadsheetML by writing to a copy of the provided template path. The 
	 * resulting data is written to the output stream.
	 */
	private void writeCOBIE(String templatePath)
	{
		super.modelToCOBie();
		LOGGER.info(getLoggerMessageBegin());
		this.writeCobieToSpreadsheet(templatePath);
		LOGGER.info(getLoggerMessageDone());
		//super.GetCobie().setNil();
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
				e.printStackTrace();
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
		cobieSpreadsheet = new COBieSpreadSheet(getConfigurationFile(),exportOptions);
		 //send the data that belongs in the newly created spread sheet to the spreadsheet creation tool
		//cobieSpreadsheet.setCobieDocumentToStringMap(cobieDocumentToStringMap());
		 //create the spreadsheet file
		//cobieSpreadsheet.populateSheetData();
		cobieSpreadsheet.loadCOBie(getCOBieDocument());
		
	}
	
	/**
	 * @param templatePath the path of the Excel template file (spreadsheetML only, no XLS or XLSX)
	 * 
	 * Transforms the COBie data into SpreadsheetML by writing to a copy of the
	 * SpreadsheetML template located by templatePath.
	 */
	public void writeCobieToSpreadsheet(String templatePath)
	{
		cobieSpreadsheet = new COBieSpreadSheet(templatePath,exportOptions);
		/*cobieSpreadsheet.setCobieDocumentToStringMap(cobieDocumentToStringMap());
		 //create the spreadsheet file
		cobieSpreadsheet.populateSheetData();*/
		cobieSpreadsheet.loadCOBie(super.getCOBieDocument());
	}
	
	
	public void write(File file) throws FileNotFoundException, SerializerException 
	{
		write(new FileOutputStream(file));
	}
	
	@Override
	public void transformCOBieSheetXMLData(COBIEDocument cobieDocument,File targetSaveFile)
			throws Exception
	{
		cobieSpreadsheet = new COBieSpreadSheet(getConfigurationFile(),exportOptions);
		cobieSpreadsheet.loadCOBie(cobieDocument);
		cobieSpreadsheet.saveToFile(targetSaveFile);

	}
		
}
