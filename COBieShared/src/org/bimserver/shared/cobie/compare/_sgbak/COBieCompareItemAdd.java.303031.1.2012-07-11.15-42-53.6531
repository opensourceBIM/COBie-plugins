package org.bimserver.shared.cobie.compare;

import org.bimserver.shared.cobie.COBIERowDictionary;
import org.bimserver.shared.cobie.COBIESheetCollection;
import org.bimserver.shared.cobie.COBIESheetDictionary;

public class COBieCompareItemAdd extends COBieCompareItem
{
	private int rowNumber;
	
	public COBieCompareItemAdd(COBIESheetDictionary newCOBie,String rowHash,
			String sheetName)
	{

		super(sheetName,rowHash, newCOBie.get(sheetName).getByRowHash(rowHash).getCOBieRowIdString(),newCOBie.get(sheetName).getByRowHash(rowHash).getCOBieUniqueIds());

		try
		{
			COBIESheetCollection cobie2Sheet =
				newCOBie.get(sheetName);
			COBIERowDictionary cobieRow =
					cobie2Sheet.getByRowHash(rowHash);
			setRowNumber(cobieRow.getCobieDocumentRowNumber());
			setCOBieKeyValues(
					cobieRow.getCOBieUniqueIds());
			
		}
		catch(Exception e)
		{
			
		}
	}

	public int getRowNumber()
	{
		return rowNumber;
	}

	public void setRowNumber(int rowNumber)
	{
		this.rowNumber = rowNumber;
	}
	

	

	
}
