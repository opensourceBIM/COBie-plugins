package org.erdc.cobie.cobielite;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.erdc.cobie.shared.COBieUtility;

public class ValueHelper
{
    private static final String FALSE = "false";
    private static final String TRUE = "true";

    public static void assign(String from, ValueBaseType to)
    {
        if ((to instanceof DecimalValueType) && isDecimalValue(from))
        {
            assignDecimal(from, (DecimalValueType)to);
        } else if ((to instanceof BooleanValueType) && isBooleanValue(from))
        {
            assignBoolean(from, (BooleanValueType)to);
        } else if ((to instanceof IntegerValueType) && isIntegerValue(from))
        {
            assignInteger(from, (IntegerValueType)to);
        } else if (to instanceof StringValueType)
        {
            assignString(from, (StringValueType)to);
        }
    }

    private static void assignBoolean(String from, BooleanValueType to)
    {
        to.setBooleanValue1(Boolean.valueOf(from.toLowerCase()));

    }

    private static void assignDecimal(String from, DecimalValueType to)
    {
        double elevationAsDouble = Double.valueOf(from);
        to.setDecimalValue(BigDecimal.valueOf(elevationAsDouble));
    }

    private static void assignInteger(String from, IntegerValueType to)
    {
        long longValue = Long.valueOf(from);
        to.setIntegerValue(BigInteger.valueOf(longValue));

    }

    private static void assignString(String from, StringValueType to)
    {
        to.setStringValue1(from);

    }

    public static boolean isBooleanValue(String sheetXMLAttributeValue)
    {

        return sheetXMLAttributeValue.equalsIgnoreCase(TRUE) || sheetXMLAttributeValue.equalsIgnoreCase(FALSE);
    }

    public static boolean isDateTimeValue(String sheetXMLAttributeValue)
    {
        boolean isDateTime = true;
        try
        {
            COBieUtility.calendarFromStringWithException(sheetXMLAttributeValue);
        } catch (Exception e)
        {
            isDateTime = false;
        }
        return isDateTime;
    }

    public static boolean isDateValue(String sheetXMLAttributeValue)
    {
        // TODO Auto-generated method stub
        return false;
    }

    public static boolean isDecimalValue(String sheetXMLAttributeValue)
    {
        boolean isDouble = false;
        try
        {
            Double.parseDouble(sheetXMLAttributeValue);
            isDouble = true;
        } catch (Exception ex)
        {

        }
        return isDouble;
    }

    public static boolean isIntegerValue(String sheetXMLAttributeValue)
    {
        boolean isInteger = false;
        try
        {
            Long.parseLong(sheetXMLAttributeValue);
            isInteger = true;
        } catch (Exception ex)
        {

        }
        return isInteger;
    }

    public static boolean isTimeValue(String sheetXMLAttributeValue)
    {
        // TODO Auto-generated method stub
        return false;
    }
}
