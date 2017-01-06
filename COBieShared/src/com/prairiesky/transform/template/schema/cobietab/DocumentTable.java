package com.prairiesky.transform.template.schema.cobietab;

import java.util.function.Supplier;

import org.nibs.cobie.tab.COBIEDocument;
import org.nibs.cobie.tab.DocumentType;

import com.prairiesky.transform.template.schema.SpreadsheetTemplateTable;

public class DocumentTable extends SpreadsheetTemplateTable<DocumentRow>
{

	@Override
	public Supplier<DocumentRow> getRowSupplier()
	{
		return DocumentRow::new;
	}

	@Override
	public void populateFromCobie(COBIEDocument cobie)
	{
		if(cobie != null && cobie.getCOBIE() != null &&
				cobie.getCOBIE().getDocuments() != null &&
				cobie.getCOBIE().getDocuments().getDocumentList() != null)
		{
			for(DocumentType document : cobie.getCOBIE().getDocuments().getDocumentList())
			{
				DocumentRow newRow = newRow();
				newRow.populateFromCobieDocument(document);
				insertRow(newRow);
			}
		}
		
	}

}
