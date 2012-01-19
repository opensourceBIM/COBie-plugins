package org.bimserver.cobie.utils;
/******************************************************************************
 * Copyright (C) 2011  ERDC
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
import java.util.ArrayList;

import org.bimserver.cobie.cobielite.COBIEType;
import org.bimserver.cobie.cobielite.ComponentType;
import org.bimserver.cobie.cobielite.DocumentType;
import org.bimserver.models.ifc2x3.IfcProduct;


public class COBieQuery
{
	public static ArrayList<DocumentType> documentsForCOBieRow
	(COBIEType.Documents documents,COBieUtility.CobieSheetName sheet, String rowKey)
	{
		ArrayList<DocumentType> matchingDocuments =
				new ArrayList<DocumentType>();
		String sheetName = sheet.toString();
		for(DocumentType document : documents.getDocumentArray())
		{
			if (document.getSheetName().equalsIgnoreCase(sheetName) &&
					document.getRowName().equalsIgnoreCase(rowKey))
				matchingDocuments.add(document);
		}
		return matchingDocuments;
	}
	
	public static boolean isComponentInCOBie(IfcProduct product, COBIEType cobie)
	{
		boolean isInCOBie = false;
		String componentName = product.getName();
		String guid="";
		try
		{
			guid = product.getGlobalId().getWrappedValue();
		}
		catch(Exception e)
		{
			
		}
		for(ComponentType component : cobie.getComponents().getComponentArray())
		{
			if (component.getName().equals(componentName) && component.getExtIdentifier().equals(guid))
				isInCOBie = true;
		}
		return isInCOBie;
	}
}
