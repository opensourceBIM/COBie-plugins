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
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;

import nl.fountain.xelem.XFactory;
import nl.fountain.xelem.excel.Workbook;
import nl.fountain.xelem.lex.ExcelReader;

import org.bimserver.cobie.utils.Deserializer.FromCOBieToIfc;
import org.bimserver.cobie.utils.spreadsheetml.SpreadSheetToComponents;
import org.bimserver.cobie.utils.spreadsheetml.SpreadsheetToAttributes;
import org.bimserver.cobie.utils.spreadsheetml.SpreadsheetToContacts;
import org.bimserver.cobie.utils.spreadsheetml.SpreadsheetToDocuments;
import org.bimserver.cobie.utils.spreadsheetml.SpreadsheetToFacilities;
import org.bimserver.cobie.utils.spreadsheetml.SpreadsheetToFloors;
import org.bimserver.cobie.utils.spreadsheetml.SpreadsheetToSpaces;
import org.bimserver.cobie.utils.spreadsheetml.SpreadsheetToTypes;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.EmfDeserializer;
import org.bimserver.plugins.schema.SchemaDefinition;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import cobieLite.COBIEDocument;
import cobieLite.COBIEType;

public class COBieDeserializer extends EmfDeserializer 
{	
	private static final Logger LOGGER = LoggerFactory.getLogger(COBieDeserializer.class);
	private String templateFilePath;
	private ExcelReader reader = null;
	private Workbook xlWorkbook = null;
	private COBIEDocument COBie;
	private final File configurationFile;
	
	public COBieDeserializer(File configurationFile) 
	{
		this.configurationFile = configurationFile;
	}
	
	// general initialize function that any of the constructors will call
	public void init(InputStream in, String filename2) throws IOException 
	{
		this.COBie = COBIEDocument.Factory.newInstance();
		templateFilePath = configurationFile.getAbsolutePath(); 

		try 
		{
			XFactory.setConfigurationFileName(templateFilePath);
			try 
			{
				reader = new ExcelReader();
				xlWorkbook = reader.getWorkbook(templateFilePath);
			} 
			catch (ParserConfigurationException e) 
			{
				LOGGER.error("", e);
			} catch (SAXException e) 
			{
				LOGGER.error("", e);
			}
			xlWorkbook = getWorkBookFromInputStream(in);		
			populateCobieDocument();
			
		} 
		catch (IOException e) 
		{
			LOGGER.error("", e);
		}
	}

	private Workbook getWorkBookFromInputStream(InputStream in)
	{
		Workbook cobieWorkBook = null;
		try 
		{
			InputSource inSrc = new InputSource(in);
			//inSrc.setEncoding("UTF-8");
			//inSrc.setSystemId("");
			nl.fountain.xelem.lex.ExcelReader rdr =
					new nl.fountain.xelem.lex.ExcelReader();
			cobieWorkBook = rdr.getWorkbook(inSrc);
		} 
		catch (ParserConfigurationException e) 
		{
			LOGGER.error("", e);
		} 
		catch (SAXException e) 
		{
			LOGGER.error("", e);
		} catch (IOException e) {
			LOGGER.error("", e);
		}
		return cobieWorkBook;
		
	}
	
	/* TODO: 1: Ignore first row in in sheet to avoid re-writing the column names
	 * 		 2: Check to make sure data is being written to the right column
	 * 		 3:	Parallelize this function
	 */
	private void populateCobieDocument() {
		 	SpreadsheetToContacts.writeContactsToCOBie(this.GetCobie(), this.xlWorkbook);
		 	SpreadsheetToFacilities.writeFacilitiesToCOBie(this.GetCobie(),this.xlWorkbook);
		 	SpreadsheetToFloors.writeFloorsToCOBie(this.GetCobie(),this.xlWorkbook);
		 	SpreadsheetToSpaces.writeSpacesToCOBie(this.GetCobie(),this.xlWorkbook);
		 	SpreadsheetToTypes.writeTypesToCOBie(this.GetCobie(), this.xlWorkbook);
		 	SpreadSheetToComponents.writeComponentsToCOBie
		 		(this.GetCobie(), this.xlWorkbook);
		 	SpreadsheetToDocuments.writeDocumentsToCOBie(this.GetCobie(), this.xlWorkbook);
		 	SpreadsheetToAttributes.writeAttributesToCOBie(this.GetCobie(), this.xlWorkbook);
	}
	
	

	private COBIEType GetCobie()
	{
		COBIEType cType;
		if (this.COBie.getCOBIE()==null)
			cType = this.COBie.addNewCOBIE();
		else
			cType = this.COBie.getCOBIE();
		return cType;
	}

	@Override
	public void init(SchemaDefinition schema) {
	
	}


	@Override
	public IfcModelInterface read(File file, boolean setOids)
			throws DeserializeException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public IfcModelInterface read(InputStream in, String filename,
			boolean setOids, long fileSize) throws DeserializeException {
		try
		{
			init(in,filename);
		} 
		catch (IOException e) 
		{
			LOGGER.error("", e);
		} 
	
		FromCOBieToIfc cobieTransform =
				new FromCOBieToIfc(this.GetCobie());
		COBieIfcModel cobieModel = cobieTransform.getModelFromCOBie();
		return cobieModel;
	}
	
	
}
