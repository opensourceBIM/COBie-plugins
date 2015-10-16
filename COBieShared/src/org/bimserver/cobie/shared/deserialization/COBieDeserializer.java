package org.bimserver.cobie.shared.deserialization;

/******************************************************************************

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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.UUID;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.IOUtils;
import org.bimserver.cobie.shared.COBieException;
import org.bimserver.cobie.shared.cobietab.COBieTabProducable;
import org.bimserver.cobie.shared.deserialization.cobietab.COBieIfcModel;
import org.bimserver.cobie.shared.deserialization.cobietab.FromCOBieToIfc;
import org.bimserver.cobie.shared.transform.spreadsheetml.cobietab.SpreadsheetParser;
import org.bimserver.cobie.shared.transform.xslx.spreadsheetml.XLSXToSpreadsheetMLMapper;
import org.bimserver.cobie.shared.utility.POIUtils;
import org.bimserver.cobie.shared.utility.StreamUtils;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.plugins.deserializers.ByteProgressReporter;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.EmfDeserializer;
import org.nibs.cobie.tab.COBIEDocument;
import org.nibs.cobie.tab.COBIEType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import nl.fountain.xelem.XFactory;
import nl.fountain.xelem.excel.Workbook;

public class COBieDeserializer extends EmfDeserializer implements
		COBieTabProducable
{
	private static final Logger LOGGER = LoggerFactory
			.getLogger(COBieDeserializer.class);
	private String templateFilePath;
	private Workbook xlWorkbook = null;
	private COBIEDocument COBie;
	private final Path configurationFile;
	private static final String LOGGER_STATUS_SPREADSHEET_BEGIN_MSG = "Deserializing COBie SpreadsheetML to COBie Sheet XML Data.";
	private static final String LOGGER_STATUS_SPREADSHEET_END_MSG = "COBie SpreadsheetML converted to COBie Sheet XML Data.";
	public COBieDeserializer(Path configurationFile, PackageMetaData packageMetadata)
	{
		this.configurationFile = configurationFile;
	}

	private COBIEType GetCobie()
	{
		COBIEType cType;
		if (COBie.getCOBIE() == null)
		{
			cType = COBie.addNewCOBIE();
		}
		else
		{
			cType = COBie.getCOBIE();
		}
		return cType;
	}
	
	

	protected Workbook getWorkBookFromInputStream(InputStream in) throws DeserializeException
	{
		//first try spreadsheetml, then xlsx, then xls, then throw exception
		
		// inSrc.setEncoding("UTF-8");
		// inSrc.setSystemId("");
		File cachedInput = null;
		
		Workbook cobieWorkBook = null;
		try 
		{	
			cachedInput = File.createTempFile(UUID.randomUUID().toString(), "");
			IOUtils.copy(in, new FileOutputStream(cachedInput));	
			InputSource inSrc = new InputSource(new FileInputStream(cachedInput));
			cobieWorkBook = spreadsheetMLWorkbookFromInputSource(inSrc);
		} 
		catch (IOException | SAXException | ParserConfigurationException e) 
		{
			try 
			{
				InputStream alternateInput = new FileInputStream(cachedInput);
				InputStream spreadsheetML = getWorkbookInputStreamFromXLSXInputStream(alternateInput);
				cobieWorkBook = spreadsheetMLWorkbookFromInputSource(new InputSource(spreadsheetML));
			} 
			catch (Exception e1) 
			{
				e1.printStackTrace();
				throw new DeserializeException(e1);
			}
		}
		return cobieWorkBook;
	}

	private Workbook spreadsheetMLWorkbookFromInputSource(InputSource inSrc)
			throws ParserConfigurationException, SAXException, IOException 
	{
		Workbook cobieWorkBook;
		nl.fountain.xelem.lex.ExcelReader rdr = new nl.fountain.xelem.lex.ExcelReader();
		cobieWorkBook = rdr.getWorkbook(inSrc);
		return cobieWorkBook;
	}
	
	private InputStream getWorkbookInputStreamFromXLSXInputStream(InputStream in) throws COBieException, Exception
	{
		XLSXToSpreadsheetMLMapper mapper =
				new XLSXToSpreadsheetMLMapper(POIUtils.getWorkbook(in));
		mapper.run();
		return StreamUtils.getInputStream(mapper.getOutputStream());
	}

	// general initialize function that any of the constructors will call
	private void initCOBie(InputStream in) throws DeserializeException
	{

		try
		{
			spreadsheetToCOBie(in);
		}
		catch (Exception ex)
		{

			throw new DeserializeException(
					"The incoming file is not a valid SpreadsheetXML or COBie SheetXMLData file.",
					ex);

		}

	}

	/*
	 * TODO: 1: Ignore first row in in sheet to avoid re-writing the column
	 * names 2: Check to make sure data is being written to the right column 3:
	 * Parallelize this function
	 */
	private void populateCobieDocument()
	{
		LOGGER.info(LOGGER_STATUS_SPREADSHEET_BEGIN_MSG);

		SpreadsheetParser parser = new SpreadsheetParser(xlWorkbook, GetCobie());
		parser.parse();

		LOGGER.info(LOGGER_STATUS_SPREADSHEET_END_MSG);
	}

	@Override
	public IfcModelInterface read(InputStream in, String filename, long fileSize, ByteProgressReporter progress)
			throws DeserializeException
	{
		COBieIfcModel cobieModel = null;
		try
		{
			initCOBie(in);
			FromCOBieToIfc cobieTransform;
			cobieTransform = new FromCOBieToIfc(GetCobie(), getPackageMetaData());
			cobieModel = cobieTransform.getModelFromCOBie();
		}
		catch (Exception e)
		{
			throw new DeserializeException(e);
		}

		return cobieModel;

	}

	private void spreadsheetToCOBie(InputStream in)
			throws Exception
	{
		toCOBieSheetXMLData(getWorkBookFromInputStream(in));
	}

	@Override
	public COBIEDocument toCOBieSheetXMLData(File incomingFile)
			throws Exception
	{
		try
		{
			return toCOBieSheetXMLData(new FileInputStream(incomingFile));
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
	
	public COBIEDocument toCOBieSheetXMLData(InputStream inputStream) throws Exception
	{
		try
		{
			initCOBie(inputStream);
		}
		catch (Exception ex)
		{
			throw ex;
		}
		return COBie;
	}
	
	public COBIEDocument toCOBieSheetXMLData(Workbook workbook) throws Exception
	{
		COBie = COBIEDocument.Factory.newInstance();
		templateFilePath = configurationFile.toString();
		XFactory.setConfigurationFileName(templateFilePath);
		this.xlWorkbook = workbook;
		if ((xlWorkbook != null) || xlWorkbook.hasExcelWorkbook())
		{
			populateCobieDocument();
		}
		else
		{
			throw new DeserializeException(
					"Input stream not a valid spreadsheetml file.");
		}
		return COBie;
	}

}
