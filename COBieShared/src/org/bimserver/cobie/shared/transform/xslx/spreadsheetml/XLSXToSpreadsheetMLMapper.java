package org.bimserver.cobie.shared.transform.xslx.spreadsheetml;

import java.io.ByteArrayOutputStream;

import org.apache.poi.ss.usermodel.Workbook;


import org.bimserver.cobie.shared.transform.Mapper;
import org.bimserver.cobie.shared.transform.MappingException;
import org.bimserver.cobie.shared.utility.StreamUtils;

import com.altova.io.Input;
import com.altova.io.Output;
import com.altova.io.StreamInput;
import com.altova.io.StreamOutput;

public class XLSXToSpreadsheetMLMapper extends Mapper
{
	private Output output = new StreamOutput(new ByteArrayOutputStream());
	private final Workbook workbook;

	public XLSXToSpreadsheetMLMapper(Workbook workbook)
	{
		this.workbook = workbook;
	}

	protected final Output getOutput()
	{
		return output;
	}
	
	public final ByteArrayOutputStream getOutputStream() throws Exception
	{
		return (ByteArrayOutputStream) getOutput().getStream();
	}

	public final Workbook getWorkbook()
	{
		return workbook;
	}

	@Override
	public void run() throws MappingException
	{
		XLSXMapToSpreadsheetML map = new XLSXMapToSpreadsheetML();
		//map.registerTraceTarget(this);
		ByteArrayOutputStream workbookStream = new ByteArrayOutputStream();
		
		try
		{
			getWorkbook().write(workbookStream);
			Input mapInput = new StreamInput(StreamUtils.getInputStream(workbookStream));
			map.run(mapInput, output);
		}
		
		catch (Exception e)
		{
			throw new MappingException();
		}
		
		map.unregisterTraceTarget();
	}
}
