package com.prairiesky.transform.template.schema.cobietab;

import java.util.function.Supplier;

import org.nibs.cobie.tab.COBIEDocument;
import org.nibs.cobie.tab.IssueType;

import com.prairiesky.transform.template.schema.SpreadsheetTemplateTable;

public class IssueTable extends SpreadsheetTemplateTable<IssueRow>
{

	@Override
	public Supplier<IssueRow> getRowSupplier()
	{
		return IssueRow::new;
	}

	@Override
	public void populateFromCobie(COBIEDocument cobie)
	{
		if(cobie != null && cobie.getCOBIE() != null &&
				cobie.getCOBIE().getIssues() != null &&
				cobie.getCOBIE().getIssues().getIssueList() != null)
		{
			for(IssueType issue : cobie.getCOBIE().getIssues().getIssueList())
			{
				IssueRow row = newRow();
				row.populateFromCobieIssue(issue);
				insertRow(row);
			}
		}
	}

}
