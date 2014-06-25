package org.erdc.cobie.cobielite.parsers.sheetxmldata;

import java.math.BigInteger;
import java.util.ArrayList;



import org.buildingsmartalliance.docs.nbims03.cobie.core.AllowedValueCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.AttributeDecimalValueType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.AttributeIntegerValueType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.AttributeStringValueType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.AttributeValueType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.BooleanValueType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.IssueCollectionType;
import org.erdc.cobie.cobielite.ValueHelper;
import org.erdc.cobie.cobielite.parsers.sheetxmldata.dispatchers.AttributeDocumentIssueHelper;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.shared.cobiesheetxmldata.indices.IndexedCOBie;
import org.erdc.cobie.sheetxmldata.AttributeType;

public class AttributeParser extends COBieLiteCOBIEBaseTypeParser<AttributeType, org.buildingsmartalliance.docs.nbims03.cobie.cobielite.AttributeType>
{

    public AttributeParser(AttributeType cobieSheetXMLData, org.buildingsmartalliance.docs.nbims03.cobie.cobielite.AttributeType cobieLiteRowData, IndexedCOBie indexedCOBie)
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
        String sheetXMLAttributeValue = sourceCOBie.getValue();
        String sheetXMLAttributeAllowedValues = sourceCOBie.getAllowedValues();
        String sheetXMLAttributeUnits = sourceCOBie.getUnit();
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
    	String sheetXMLAttributeValue = sourceCOBie.getValue();
    	if(!COBieUtility.isNA(sheetXMLAttributeValue))
    	{
    		        AttributeValueType cobieLiteAttributeValue = targetCOBie.addNewAttributeValue();
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
    	IssueCollectionType issues = targetCOBie.addNewAttributeIssues();
        AttributeDocumentIssueHelper.parseIssues(issues, descriptiveData, indexedCOBie);
        if(issues == null || issues.isNil() || issues.sizeOfIssueArray() == 0)
        {
        	targetCOBie.getDomNode().removeChild(issues.getDomNode());
        }
    }

    @Override
    protected void parseSimpleElements()
    {
    	if(!COBieUtility.isNA(sourceCOBie.getCategory()))
    		targetCOBie.setAttributeCategory(sourceCOBie.getCategory());
    	if(!COBieUtility.isNA(sourceCOBie.getDescription()))
    		targetCOBie.setAttributeDescription(sourceCOBie.getDescription());
    	if(!COBieUtility.isNA(sourceCOBie.getName()))
    		targetCOBie.setAttributeName(sourceCOBie.getName());
        setExtElements();
    }
    
    private void setExtElements()
    {
        String extSystem = sourceCOBie.getExtSystem();
        if(extSystem.equalsIgnoreCase("AEC3_BimServices"))
        {
            targetCOBie.setPropertySetName(sourceCOBie.getExtIdentifier());
        }
        else
        {
            targetCOBie.setPropertySetName(sourceCOBie.getExtObject());
        }
        if(!COBieUtility.isNA(sourceCOBie.getExtObject()))
        	targetCOBie.setExternalEntityName(sourceCOBie.getExtObject());
        if(!COBieUtility.isNA(sourceCOBie.getExtIdentifier()))
        	targetCOBie.setExternalID(sourceCOBie.getExtIdentifier());
        if(!COBieUtility.isNA(sourceCOBie.getExtSystem()))
        	targetCOBie.setExternalSystemName(sourceCOBie.getExtSystem());
      //  targetCOBie.setPropertySetExternalIdentifier(COBieUtility.COBieNA);
    }

}
