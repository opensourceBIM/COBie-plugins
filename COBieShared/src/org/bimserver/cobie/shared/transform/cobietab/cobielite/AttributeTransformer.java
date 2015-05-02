package org.bimserver.cobie.shared.transform.cobietab.cobielite;

import java.math.BigInteger;
import java.util.ArrayList;


















import org.bimserver.cobie.shared.cobietab.IndexedCOBie;
import org.bimserver.cobie.shared.utility.COBieUtility;
import org.buildingsmartalliance.docs.nbims03.cobie.core.AllowedValueCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.AttributeDecimalValueType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.AttributeIntegerValueType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.AttributeStringValueType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.AttributeValueType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.BooleanValueType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.IssueCollectionType;
import org.nibs.cobie.tab.AttributeType;

public class AttributeTransformer extends COBieBaseTypeTransformer<AttributeType, org.buildingsmartalliance.docs.nbims03.cobie.cobielite.AttributeType>
{

    public AttributeTransformer(AttributeType cobieSheetXMLData, org.buildingsmartalliance.docs.nbims03.cobie.cobielite.AttributeType cobieLiteRowData, IndexedCOBie indexedCOBie)
    {
        super(cobieSheetXMLData, cobieLiteRowData, indexedCOBie);
    }

    private boolean allAllowedValuesAreDecimals(ArrayList<String> allowedValueStrings)
    {
        boolean allDecimals = true;
        for (String allowedValueString : allowedValueStrings)
        {
            try
            {
                Double.parseDouble(allowedValueString);
            } catch (Exception ex)
            {
                allDecimals = false;
            }
        }
        return allDecimals;
    }

    private boolean allAllowedValuesAreLongs(ArrayList<String> allowedValueStrings)
    {
        boolean allLongs = true;
        for (String allowedValueString : allowedValueStrings)
        {
            try
            {
                Long.parseLong(allowedValueString);
            } catch (Exception ex)
            {
                allLongs = false;
            }
        }
        return allLongs;
    }

    private void determineAttributeValueTypeAndSetValues(
            AttributeValueType cobieLiteAttributeValue,
            String sheetXMLAttributeValue,
            String sheetXMLAttributeAllowedValues,
            String sheetXMLAttributeUnits)
    {
        if (ValueHelper.isBooleanValue(sheetXMLAttributeValue))
        {
            handleBooleanValue(cobieLiteAttributeValue, sheetXMLAttributeValue);
        } else if (ValueHelper.isDecimalValue(sheetXMLAttributeValue))
        {
            handleDecimalValue(cobieLiteAttributeValue, sheetXMLAttributeValue, sheetXMLAttributeAllowedValues, sheetXMLAttributeUnits);
        } else if (ValueHelper.isIntegerValue(sheetXMLAttributeValue))
        {
            handleIntegerValue(cobieLiteAttributeValue, sheetXMLAttributeValue, sheetXMLAttributeAllowedValues, sheetXMLAttributeUnits);
        } else if (ValueHelper.isDateTimeValue(sheetXMLAttributeValue))
        {
            // TODO: handle date time value
        } else if (ValueHelper.isDateValue(sheetXMLAttributeValue))
        {
            // TODO: handle date attribute values;
        } else if (ValueHelper.isTimeValue(sheetXMLAttributeValue))
        {
            // TODO: handle time attribute values;
        } else
        {
            handleStringValue(cobieLiteAttributeValue, sheetXMLAttributeValue, sheetXMLAttributeAllowedValues, sheetXMLAttributeUnits);
        }
    }

    private void handleBooleanValue(AttributeValueType cobieLiteAttributeValue, String sheetXMLAttributeValue)
    {
        BooleanValueType booleanValue = cobieLiteAttributeValue.addNewAttributeBooleanValue();
        ValueHelper.assign(sheetXMLAttributeValue, booleanValue);
    }

    private void handleDecimalValue(
            AttributeValueType cobieLiteAttributeValue,
            String sheetXMLAttributeValue,
            String sheetXMLAttributeAllowedValues,
            String sheetXMLAttributeUnits)
    {
        AttributeDecimalValueType decimalValue = cobieLiteAttributeValue.addNewAttributeDecimalValue();
        ValueHelper.assign(sheetXMLAttributeValue, decimalValue);
        if (!COBieUtility.isNA(sheetXMLAttributeUnits))
        {
            decimalValue.addNewUnitName().setStringValue(sheetXMLAttributeUnits);
        }
        handleDecimalValueBounds(decimalValue, sheetXMLAttributeAllowedValues);
    }

    private void handleDecimalValueBounds(AttributeDecimalValueType decimalValue, String sheetXMLAttributeAllowedValues)
    {
        ArrayList<String> allowedValueStrings = COBieUtility.arrayListFromDelimString(sheetXMLAttributeAllowedValues);
        if (!allowedValueStrings.isEmpty() && ((allowedValueStrings.size() == 2) || (allowedValueStrings.size() == 3))
                && allAllowedValuesAreDecimals(allowedValueStrings))
        {
            double minValue = Double.MAX_VALUE;
            double maxValue = Double.MIN_VALUE;
            for (String allowedValueString : allowedValueStrings)
            {
                double value = Double.valueOf(allowedValueString);
                if (value < minValue)
                {
                    minValue = value;
                }
                if (value > maxValue)
                {
                    maxValue = value;
                }
            }
            decimalValue.setMinValueDecimal(Double.valueOf(minValue));
            decimalValue.setMaxValueDecimal(Double.valueOf(maxValue));
        }

    }

    private void handleIntegerValue(
            AttributeValueType cobieLiteAttributeValue,
            String sheetXMLAttributeValue,
            String sheetXMLAttributeAllowedValues,
            String sheetXMLAttributeUnits)
    {
        AttributeIntegerValueType integerValue = cobieLiteAttributeValue.addNewAttributeIntegerValue();
        ValueHelper.assign(sheetXMLAttributeValue, integerValue);
        if (!COBieUtility.isNA(sheetXMLAttributeUnits))
        {
            integerValue.addNewUnitName().setStringValue(sheetXMLAttributeUnits);
        }
        handleIntegerValueBounds(integerValue, sheetXMLAttributeAllowedValues);
    }

    private void handleIntegerValueBounds(AttributeIntegerValueType integerValue, String sheetXMLAttributeAllowedValues)
    {
        ArrayList<String> allowedValueStrings = COBieUtility.arrayListFromDelimString(sheetXMLAttributeAllowedValues);
        if (!allowedValueStrings.isEmpty() && ((allowedValueStrings.size() == 2) || (allowedValueStrings.size() == 3))
                && allAllowedValuesAreLongs(allowedValueStrings))
        {
            long minValue = Long.MAX_VALUE;
            long maxValue = Long.MIN_VALUE;
            for (String allowedValueString : allowedValueStrings)
            {
                long value = Long.valueOf(allowedValueString);
                if (value < minValue)
                {
                    minValue = value;
                }
                if (value > maxValue)
                {
                    maxValue = value;
                }
            }
            integerValue.setMinValueInteger(BigInteger.valueOf(minValue));
            integerValue.setMaxValueInteger(BigInteger.valueOf(maxValue));
        }
    }

    private void handleStringAllowedValues(AttributeStringValueType stringValue, String sheetXMLAttributeAllowedValues)
    {
        if (!COBieUtility.isNA(sheetXMLAttributeAllowedValues))
        {
            ArrayList<String> allowedValueStrings = COBieUtility.arrayListFromDelimString(sheetXMLAttributeAllowedValues);
            if (!allowedValueStrings.isEmpty())
            {
                AllowedValueCollectionType allowedValuesCollection = stringValue.addNewAllowedValues();
                for (String allowedValueString : allowedValueStrings)
                {
                    allowedValuesCollection.addAttributeAllowedValue(allowedValueString);
                }
            }
        }

    }

    private void handleStringValue(
            AttributeValueType cobieLiteAttributeValue,
            String sheetXMLAttributeValue,
            String sheetXMLAttributeAllowedValues,
            String sheetXMLAttributeUnits)
    {
        AttributeStringValueType stringValue = cobieLiteAttributeValue.addNewAttributeStringValue();
        ValueHelper.assign(sheetXMLAttributeValue, stringValue);
        if (!COBieUtility.isNA(sheetXMLAttributeUnits))
        {
            stringValue.addNewUnitName().setStringValue(sheetXMLAttributeUnits);
        }
        handleStringAllowedValues(stringValue, sheetXMLAttributeAllowedValues);
    }

    private void initializeCobieLiteAttributeValue(AttributeValueType cobieLiteAttributeValue)
    {
        String sheetXMLAttributeValue = source.getValue();
        String sheetXMLAttributeAllowedValues = source.getAllowedValues();
        String sheetXMLAttributeUnits = source.getUnit();
        determineAttributeValueTypeAndSetValues(cobieLiteAttributeValue, sheetXMLAttributeValue, sheetXMLAttributeAllowedValues,
                sheetXMLAttributeUnits);
    }

    @Override
    protected void parseAttributes() throws Exception
    {
        //throw new NonExistingDescriptiveElementException();
    }

    @Override
    protected void parseComplexElements()
    {
    	String sheetXMLAttributeValue = source.getValue();
    	if(!COBieUtility.isNA(sheetXMLAttributeValue))
    	{
    		        AttributeValueType cobieLiteAttributeValue = target.addNewAttributeValue();
    		        initializeCobieLiteAttributeValue(cobieLiteAttributeValue);
    	}
    }

    @Override
    protected void parseDocuments() throws Exception
    {
      //  throw new NonExistingDescriptiveElementException();

    }

    @Override
    protected void parseIssues() throws Exception
    {
    	IssueCollectionType issues = target.addNewAttributeIssues();
        AttributeDocumentIssueHelper.parseIssues(issues, descriptiveData, indexedCOBie);
        if(issues == null || issues.isNil() || issues.sizeOfIssueArray() == 0)
        {
        	target.getDomNode().removeChild(issues.getDomNode());
        }
    }

    @Override
    protected void parseSimpleElements()
    {
    	if(!COBieUtility.isNA(source.getCategory()))
    		target.setAttributeCategory(source.getCategory());
    	if(!COBieUtility.isNA(source.getDescription()))
    		target.setAttributeDescription(source.getDescription());
    	if(!COBieUtility.isNA(source.getName()))
    		target.setAttributeName(source.getName());
        setExtElements();
    }
    
    private void setExtElements()
    {
        String extSystem = source.getExtSystem();
        if(extSystem.equalsIgnoreCase("AEC3_BimServices"))
        {
            target.setPropertySetName(source.getExtIdentifier());
        }
        else
        {
            target.setPropertySetName(source.getExtObject());
        }
        if(!COBieUtility.isNA(source.getExtObject()))
        	target.setExternalEntityName(source.getExtObject());
        if(!COBieUtility.isNA(source.getExtIdentifier()))
        	target.setExternalID(source.getExtIdentifier());
        if(!COBieUtility.isNA(source.getExtSystem()))
        	target.setExternalSystemName(source.getExtSystem());
      //  target.setPropertySetExternalIdentifier(COBieUtility.COBieNA);
    }

}
