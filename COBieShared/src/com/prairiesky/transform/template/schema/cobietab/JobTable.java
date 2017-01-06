package com.prairiesky.transform.template.schema.cobietab;

import java.util.function.Supplier;

import org.nibs.cobie.tab.COBIEDocument;
import org.nibs.cobie.tab.JobType;

import com.prairiesky.transform.template.schema.SpreadsheetTemplateTable;

public class JobTable extends SpreadsheetTemplateTable<JobRow>
{

	@Override
	public Supplier<JobRow> getRowSupplier()
	{
		return JobRow::new;
	}

	@Override
	public void populateFromCobie(COBIEDocument cobieDocument)
	{
		if(cobieDocument != null && cobieDocument.getCOBIE() != null &&
				cobieDocument.getCOBIE().getJobs() != null &&
				cobieDocument.getCOBIE().getJobs().getJobList() != null)
		{
			for(JobType job : cobieDocument.getCOBIE().getJobs().getJobList())
			{
				JobRow newRow = newRow();
				newRow.populateFromCobieJob(job);
				insertRow(newRow);
			}
		}
	}

}
