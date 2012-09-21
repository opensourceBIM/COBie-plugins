package org.bimserver.shared.cobie.compare;

import org.bimserver.shared.cobie.COBIERowDictionary;
import org.bimserver.shared.cobie.COBIESheetCollection;
import org.bimserver.shared.cobie.COBIESheetDictionary;

public class COBieCompareItemDelete extends COBieCompareItem
{

	private int rowNumber;
	public COBieCompareItemDelete(COBIESheetDictionary removedCOBie,String rowHash,
			String sheetName)
	{
		super(sheetName,rowHash, removedCOBie.get(sheetName).getByRowHash(rowHash).getCOBieRowIdString(),
				removedCOBie.get(sheetName).getByRowHash(rowHash).getCOBieUniqueIds());

		try
		{
			COBIESheetCollection cobie1Sheet =
				removedCOBie.get(sheetName);
			COBIERowDictionary cobieRow =
					cobie1Sheet.getByRowHash(rowHash);
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
