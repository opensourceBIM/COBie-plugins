package org.bimserver.cobie.shared.transform.spreadsheetml.xlsx;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import nl.fountain.xelem.XSerializer;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


import org.bimserver.cobie.shared.transform.Mapper;
import org.bimserver.cobie.shared.transform.MappingException;
import org.bimserver.cobie.shared.transform.spreadsheetml.cobietab.COBieSpreadSheet;
import org.bimserver.cobie.shared.utility.StreamUtils;
import org.bimserver.cobie.shared.utility.WorkbookCopier;

import com.altova.io.Input;
import com.altova.io.Output;
import com.altova.io.StreamInput;
import com.altova.io.StreamOutput;

public class SpreadsheetMLToXLSXMapper extends Mapper
{

	private Output output;
	private final Workbook formattedWorkbook;
	private final COBieSpreadSheet inputWorkbook;
	private Workbook workbookOutput;
	
	public SpreadsheetMLToXLSXMapper(COBieSpreadSheet input, Workbook formattedWorkbook, OutputStream outputStream)
	{
		this.formattedWorkbook = formattedWorkbook;
		this.inputWorkbook = input;
		output = new StreamOutput(outputStream);
	}
	
	public SpreadsheetMLToXLSXMapper(COBieSpreadSheet input, Workbook formattedWorkbook)
	{
		this(input, formattedWorkbook, new ByteArrayOutputStream());
	}

	public final Workbook getOutput()
	{
		return workbookOutput;
	}


	@Override
	public void run() throws MappingException
	{
		SpreadsheetMLMapToXLSX map = new SpreadsheetMLMapToXLSX();
		//map.registerTraceTarget(this);
		ByteArrayOutputStream workbookStream = new ByteArrayOutputStream();
		XSerializer serializer = new XSerializer();
		
		try
		{
			serializer.serialize(inputWorkbook.getXlWorkbook(), workbookStream);
			Input mapInput = new StreamInput(StreamUtils.getInputStream(workbookStream));
			map.run(mapInput, output);
			InputStream xlsxInputStream = StreamUtils.getInputStream((ByteArrayOutputStream) output.getStream());
			org.apache.poi.ss.usermodel.Workbook dataWorkbook =
					WorkbookFactory.create(xlsxInputStream);
			WorkbookCopier copier = new WorkbookCopier(dataWorkbook, formattedWorkbook);
			dataWorkbook = copier.copyWorkbookValues();
			workbookOutput = dataWorkbook;
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
			throw new MappingException();
		}
		
		finally
		{
			map.unregisterTraceTarget();
		}
		
	}

}
