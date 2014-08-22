package org.erdc.cobie.shared.altova.mapping;

import org.apache.poi.ss.usermodel.Workbook;
import org.erdc.cobie.shared.utility.WorkbookCopierOptions;

import com.altova.io.Input;
import com.altova.io.Output;

public abstract class WorkbookMapper
{
	private Workbook targetWorkbook;
	private WorkbookCopierOptions copierOptions;
	public WorkbookMapper(Workbook targetWorkbook)
	{
		this(targetWorkbook, new WorkbookCopierOptions());
	}
	
	public WorkbookMapper(Workbook targetWorkbook, WorkbookCopierOptions copierOptions)
	{
		setTargetWorkbook(targetWorkbook);
		setCopierOptions(copierOptions);
	}
	public WorkbookCopierOptions getCopierOptions()
	{
		return copierOptions;
	}
	public void setCopierOptions(WorkbookCopierOptions copierOptions)
	{
		this.copierOptions = copierOptions;
	}
	public Workbook getTargetWorkbook()
	{
		return targetWorkbook;
	}
	public void setTargetWorkbook(Workbook targetWorkbook)
	{
		this.targetWorkbook = targetWorkbook;
	}
	
	protected abstract void mapCOBieLiteToWorkbook(Input input, Output output);

}
