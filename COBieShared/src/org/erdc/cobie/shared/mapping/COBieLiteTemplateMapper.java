package org.erdc.cobie.shared.mapping;

import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.FacilityDocument;
import org.erdc.cobie.shared.utils.POIUtils;
import org.erdc.cobie.shared.utils.StreamUtils;
import org.erdc.cobie.shared.utils.WorkbookCopier;
import org.erdc.cobie.shared.utils.WorkbookCopierOptions;

import com.altova.io.Input;
import com.altova.io.Output;
import com.altova.io.StreamInput;
import com.altova.io.StreamOutput;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

public abstract class COBieLiteTemplateMapper extends Mapper
{

	private Workbook targetWorkbook;
	private WorkbookCopierOptions copierOptions;
	private  FacilityDocument facilityDocument = FacilityDocument.Factory.newInstance();

	
	public COBieLiteTemplateMapper(Workbook templateFile)
	{
		this(templateFile, null);
	}
	
	public COBieLiteTemplateMapper(Workbook templateFile, WorkbookCopierOptions copierOptions)
	{
		setTargetWorkbook(templateFile);
		setCopierOptions(copierOptions);
	}

	public FacilityDocument getFacilityDocument()
	{
		return facilityDocument;
	}

	public void setFacilityDocument(FacilityDocument facilityDocument)
	{
		this.facilityDocument = facilityDocument;
	}
	
	@Override
	public void run() throws Exception
	{
		try
		{
			StreamInput streamInput;
			streamInput = new StreamInput(facilityDocument.newInputStream());
			Output mapForceOutput = new StreamOutput(new ByteOutputStream());
			mapCOBieLiteToWorkbook(streamInput, mapForceOutput);
			streamInput = new StreamInput(StreamUtils.getInputStream((ByteOutputStream)mapForceOutput.getStream()));
//			ByteArrayOutputStream bytes = new ByteArrayOutputStream();
//			IOUtils.copy(streamInput.getStream(), bytes);
			Workbook dataWorkbook = POIUtils.getWorkbook(streamInput.getStream());
			WorkbookCopier copier = new WorkbookCopier(dataWorkbook, getTargetWorkbook(), getCopierOptions());
			setTargetWorkbook(copier.copyWorkbookValues());
		}
		catch (Exception e)
		{
			throw e;
		}
	}
	
	public void write(OutputStream outputStream) throws IOException
	{
		getTargetWorkbook().write(outputStream);
	}
	
	protected abstract void mapCOBieLiteToWorkbook(Input input, Output output) throws Exception;

	public Workbook getTargetWorkbook()
	{
		return targetWorkbook;
	}

	public void setTargetWorkbook(Workbook targetWorkbook)
	{
		this.targetWorkbook = targetWorkbook;
	}

	public WorkbookCopierOptions getCopierOptions()
	{
		return copierOptions;
	}

	public void setCopierOptions(WorkbookCopierOptions copierOptions)
	{
		this.copierOptions = copierOptions;
	}


}
