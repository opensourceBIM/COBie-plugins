package org.erdc.cobie.shared.compare;

import java.util.ArrayList;
import java.util.Calendar;

import org.erdc.cobie.shared.COBIERowDictionary;
import org.erdc.cobie.shared.COBIESheetCollection;
import org.erdc.cobie.shared.COBIESheetDictionary;
import org.erdc.cobie.shared.COBieUtility;

public class COBieCompareItemModify extends COBieCompareItem
{
    private static final int CALENDAR_TOLERANCE = 2000;
    private COBIERowDictionary cobie1Row;
    private COBIERowDictionary cobie2Row;
    private ArrayList<String> modifiedColumns;
    private int cobie1RowNumber, cobie2RowNumber;

    public COBieCompareItemModify(COBIESheetDictionary cobie1, COBIESheetDictionary cobie2, String rowHash, String sheetName)
    {
        super(sheetName, rowHash, cobie1.get(sheetName).getByRowHash(rowHash).getCOBieRowIdString(), cobie1.get(sheetName).getByRowHash(rowHash)
                .getCOBieUniqueIds());
        modifiedColumns = new ArrayList<String>();
        try
        {
            COBIESheetCollection cobie1Sheet = cobie1.get(sheetName);
            COBIESheetCollection cobie2Sheet = cobie2.get(sheetName);
            cobie1Row = cobie1Sheet.getByRowHash(rowHash);
            setCobie1RowNumber(cobie1Row.getCobieDocumentRowNumber());
            cobie2Row = cobie2Sheet.getByRowHash(rowHash);
            setCobie2RowNumber(cobie2Row.getCobieDocumentRowNumber());

            setCOBieKeyValues(cobie1Row.getCOBieUniqueIds());
            initializeModifiedItems();
        } catch (Exception e)
        {

        }
    }

    private boolean calculateEqualityBasedOnDelimmitedList(String cobie1Val, String cobie2Val)
    {
        boolean equal = true;
        ArrayList<String> cobie1Strings = COBieUtility.arrayListFromDelimString(cobie1Val);
        ArrayList<String> cobie2Strings = COBieUtility.arrayListFromDelimString(cobie2Val);
        if (cobie1Strings.size() == cobie2Strings.size())
        {
            for (String cobie1String : cobie1Strings)
            {
                if (!cobie2Strings.contains(cobie1String))
                {
                    equal = false;
                }
            }
        } else
        {
            equal = false;
        }
        return equal;
    }

    private boolean calculateEqualityOfValues(String cobie1Val, String cobie2Val)
    {
        boolean equal = false;
        try
        {
            double valA = Double.parseDouble(cobie1Val);
            double valB = Double.parseDouble(cobie2Val);
            equal = (valA == valB);
        } catch (Exception ex)
        {

        }
        if (!equal)
        {
            try
            {
                Calendar calendar1 = COBieUtility.calendarFromStringWithException(cobie1Val);
                Calendar calendar2 = COBieUtility.calendarFromStringWithException(cobie2Val);
                if (Math.abs(calendar1.getTimeInMillis() - calendar2.getTimeInMillis()) <= CALENDAR_TOLERANCE)
                {
                    equal = true;
                }
            } catch (Exception ex)
            {

            }

        }
        return equal;
    }

    public COBIERowDictionary getCobie1ModifiedValues()
    {
        return cobie1Row;
    }

    public int getCobie1RowNumber()
    {
        return cobie1RowNumber;
    }

    public COBIERowDictionary getCobie2ModifiedValues()
    {
        return cobie2Row;
    }

    public int getCobie2RowNumber()
    {
        return cobie2RowNumber;
    }

    public ArrayList<String> getModifiedColumns()
    {
        return modifiedColumns;
    }

    private void initializeModifiedItems()
    {
        for (String colName : cobie1Row.keySet())
        {
            String cobie1Val = cobie1Row.get(colName);
            String cobie2Val = cobie2Row.get(colName);
            boolean modified = valueIsModified(cobie1Val, cobie2Val);
            if (modified)
            {
                modifiedColumns.add(colName);
            }
        }
    }

    public void setCobie1RowNumber(int cobie1RowNumber)
    {
        this.cobie1RowNumber = cobie1RowNumber;
    }

    public void setCobie2RowNumber(int cobie2RowNumber)
    {
        this.cobie2RowNumber = cobie2RowNumber;
    }

    private boolean valueIsModified(String cobie1Val, String cobie2Val)
    {
        boolean equal = cobie1Val.equalsIgnoreCase(cobie2Val);
        if (!equal && cobie1Val.contains(COBieUtility.getCOBieDelim()) && cobie2Val.contains(COBieUtility.getCOBieDelim()))
        {
            equal = calculateEqualityBasedOnDelimmitedList(cobie1Val, cobie2Val);
        }
        if (!equal)
        {
            equal = calculateEqualityOfValues(cobie1Val, cobie2Val);
        }
        return !(equal);
    }

}
