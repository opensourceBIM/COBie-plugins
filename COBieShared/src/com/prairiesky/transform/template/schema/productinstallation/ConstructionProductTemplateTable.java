package com.prairiesky.transform.template.schema.productinstallation;

import java.util.Optional;

import org.apache.poi.ss.usermodel.Workbook;
import org.bimserver.cobie.shared.cobietab.IndexedCOBie;
import org.nibs.cobie.tab.COBIEDocument;
import org.nibs.cobie.tab.ComponentType;
import org.nibs.cobie.tab.TypeType;

import com.prairiesky.transform.template.schema.SpreadsheetTemplateTable;

public abstract class ConstructionProductTemplateTable<T_ROW extends ConstructionTemplateProductRow> extends
		SpreadsheetTemplateTable<T_ROW>
{

	@Override
	public void populateFromCobie(COBIEDocument cobieDocument)
	{
		if(cobieDocument.getCOBIE() != null && cobieDocument.getCOBIE().getComponents() != null &&
				cobieDocument.getCOBIE().getComponents().getComponentList() != null)
		{
			IndexedCOBie indexedCobie = new IndexedCOBie(cobieDocument.getCOBIE());
			for(ComponentType component : cobieDocument.getCOBIE().getComponents().getComponentList())
			{
				String typeName = component.getTypeName();
				if (cobieDocument.getCOBIE().getTypes() != null && cobieDocument.getCOBIE().getTypes().getTypeList() != null)
				{
					Optional<TypeType> typeResult =
							cobieDocument.getCOBIE().getTypes().getTypeList().stream().filter
							(t -> typeName.equalsIgnoreCase(t.getName())).findFirst();
					TypeType matchingType = typeResult.orElse(null);
					T_ROW newRow = newRow();
					newRow.populateFromCOBie(component, matchingType, indexedCobie);
					insertRow(newRow);
				}
				
			}
		}
	}
	
}
