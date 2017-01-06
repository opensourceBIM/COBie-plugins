package com.prairiesky.transform.template.schema.cobietab;

import java.util.function.Supplier;

import org.nibs.cobie.tab.COBIEDocument;
import org.nibs.cobie.tab.ConnectionType;

import com.prairiesky.transform.template.schema.SpreadsheetTemplateTable;

public class ConnectionTable extends SpreadsheetTemplateTable<ConnectionRow>
{

	@Override
	public Supplier<ConnectionRow> getRowSupplier()
	{
		return ConnectionRow::new;
	}

	@Override
	public void populateFromCobie(COBIEDocument cobieDocument)
	{
		if(cobieDocument != null && cobieDocument.getCOBIE() != null &&
				cobieDocument.getCOBIE().getConnections() != null &&
				cobieDocument.getCOBIE().getConnections().getConnectionList() != null)
		{
			for(ConnectionType connection : cobieDocument.getCOBIE().getConnections().getConnectionList())
			{
				ConnectionRow newRow = newRow();
				newRow.populateFromCobieConnection(connection);
				insertRow(newRow);
			}
		}
		
	}

}
