package org.bimserver.cobie.shared.compare;

import org.bimserver.cobie.shared.cobietab.COBIERowDictionary;
import org.bimserver.cobie.shared.cobietab.COBIESheetCollection;
import org.bimserver.cobie.shared.cobietab.COBIESheetDictionary;

public class COBieCompareItemDelete extends COBieCompareItem
{

    private int rowNumber;

    public COBieCompareItemDelete(COBIESheetDictionary removedCOBie, String rowHash, String sheetName)
    {
        super(sheetName, rowHash, removedCOBie.get(sheetName).getByRowHash(rowHash).getCOBieRowIdString(), removedCOBie.get(sheetName)
                .getByRowHash(rowHash).getCOBieUniqueIds());

        try
        {
            COBIESheetCollection cobie1Sheet = removedCOBie.get(sheetName);
            COBIERowDictionary cobieRow = cobie1Sheet.getByRowHash(rowHash);
            setRowNumber(cobieRow.getCobieDocumentRowNumber());
            setCOBieKeyValues(cobieRow.getCOBieUniqueIds());
        } catch (Exception e)
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
