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
import java.util.UUID;

import javax.xml.parsers.ParserConfigurationException;

import nl.fountain.xelem.XFactory;
import nl.fountain.xelem.excel.Workbook;

import org.apache.commons.io.IOUtils;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.bimserver.cobie.shared.COBieException;
import org.bimserver.cobie.shared.cobietab.COBieTabProducable;
import org.bimserver.cobie.shared.deserialization.cobietab.COBieIfcModel;
import org.bimserver.cobie.shared.deserialization.cobietab.FromCOBieToIfc;
import org.bimserver.cobie.shared.transform.spreadsheetml.cobietab.SpreadsheetParser;
import org.bimserver.cobie.shared.transform.xslx.spreadsheetml.XLSXToSpreadsheetMLMapper;
import org.bimserver.cobie.shared.utility.COBieStringHandler;
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

import com.prairiesky.transform.template.CobieXLSXToCobieTabTransform;

public class COBieDeserializer extends EmfDeserializer implements
		COBieTabProducable
{
	private static final Logger LOGGER = LoggerFactory
			.getLogger(COBieDeserializer.class);
	private String templateFilePath;
	private Workbook xlWorkbook = null;
	private COBIEDocument cobieDocument;

	public String getTemplateFilePath()
	{
		return templateFilePath;
	}

	public void setTemplateFilePath(String templateFilePath)
	{
		this.templateFilePath = templateFilePath;
	}

	public Workbook getXlWorkbook()
	{
		return xlWorkbook;
	}

	public void setXlWorkbook(Workbook xlWorkbook)
	{
		this.xlWorkbook = xlWorkbook;
	}

	public File getConfigurationFile()
	{
		return configurationFile;
	}

	public COBIEDocument getCobieDocument()
	{
		return cobieDocument;
	}

	public void setCobieDocument(COBIEDocument cobieDocument)
	{
		this.cobieDocument = cobieDocument;
	}

	private final File configurationFile;
	private static final String LOGGER_STATUS_SPREADSHEET_BEGIN_MSG = "Deserializing COBie SpreadsheetML to COBie Sheet XML Data.";
	private static final String LOGGER_STATUS_SPREADSHEET_END_MSG = "COBie SpreadsheetML converted to COBie Sheet XML Data.";

	public COBieDeserializer(File configurationFile, PackageMetaData packageMetadata)
	{
		this.configurationFile = configurationFile;
	}

	private COBIEType GetCobie()
	{
		COBIEType cType;
		if (getCobieDocument().getCOBIE() == null)
		{
			cType = getCobieDocument().addNewCOBIE();
		}
		else
		{
			cType = getCobieDocument().getCOBIE();
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
			cobieWorkBook = spreadsheetMLWorkbookFromInputSource(new InputSource(in));
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
			//	e1.printStackTrace();
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
	private void initCOBie(InputStream in, COBieStringHandler handler) throws DeserializeException
	{

		try
		{
			spreadsheetToCOBie(in, handler);
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
	private void populateCobieDocument(COBieStringHandler handler)
	{
		LOGGER.info(LOGGER_STATUS_SPREADSHEET_BEGIN_MSG);

		SpreadsheetParser parser = new SpreadsheetParser(getXlWorkbook(), GetCobie(), handler);
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
			initCOBie(in, new COBieStringHandler());
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

	private void spreadsheetToCOBie(InputStream in, COBieStringHandler handler)
			throws Exception
	{
		File cachedInput = File.createTempFile(UUID.randomUUID().toString(), "");
		IOUtils.copy(in, new FileOutputStream(cachedInput));	
		InputStream firstStream = new FileInputStream(cachedInput);
		try
		{
			toCOBieSheetXMLData(getWorkBookFromInputStream(firstStream), handler);
		}
		catch(Exception e)
		{
			try
			{
				org.apache.poi.ss.usermodel.Workbook workbook =
						WorkbookFactory.create(cachedInput);
				setCobieDocument(COBIEDocument.Factory.newInstance());
				CobieXLSXToCobieTabTransform transform =
						new CobieXLSXToCobieTabTransform(workbook, getCobieDocument());
				transform.transform();
			}
			catch(Exception e2)
			{
				throw e;
			}
		}
		finally
		{
			cachedInput.deleteOnExit();
		}
		
	}

	@Override
	public COBIEDocument toCOBieSheetXMLData(File incomingFile, COBieStringHandler handler)
			throws Exception
	{
		try
		{
			return toCOBieSheetXMLData(new FileInputStream(incomingFile), handler);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
	
	
	public COBIEDocument toCOBieSheetXMLData(InputStream inputStream, COBieStringHandler handler) throws Exception
	{
		try
		{
			initCOBie(inputStream, handler);
		}
		catch (Exception ex)
		{
			throw ex;
		}
		return getCobieDocument();
	}
	
	public COBIEDocument toCOBieSheetXMLData(Workbook workbook, COBieStringHandler handler) throws Exception
	{
		setCobieDocument(COBIEDocument.Factory.newInstance());
		setTemplateFilePath(getConfigurationFile().getAbsolutePath());
		XFactory.setConfigurationFileName(getTemplateFilePath());
		setXlWorkbook(workbook);
		if ((getXlWorkbook() != null) || getXlWorkbook().hasExcelWorkbook())
		{
			populateCobieDocument(handler);
		}
		else
		{
			throw new DeserializeException(
					"Input stream not a valid spreadsheetml file.");
		}
		return getCobieDocument();
	}

}
