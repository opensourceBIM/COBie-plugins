package org.erdc.cobie.shared.bimserver.cobietab.deserialization.propertysets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.IfcIdentifier;
import org.bimserver.models.ifc2x3tc1.IfcInteger;
import org.bimserver.models.ifc2x3tc1.IfcLabel;
import org.bimserver.models.ifc2x3tc1.IfcNamedUnit;
import org.bimserver.models.ifc2x3tc1.IfcPhysicalSimpleQuantity;
import org.bimserver.models.ifc2x3tc1.IfcProperty;
import org.bimserver.models.ifc2x3tc1.IfcPropertyBoundedValue;
import org.bimserver.models.ifc2x3tc1.IfcPropertyEnumeratedValue;
import org.bimserver.models.ifc2x3tc1.IfcPropertyEnumeration;
import org.bimserver.models.ifc2x3tc1.IfcPropertySingleValue;
import org.bimserver.models.ifc2x3tc1.IfcQuantityArea;
import org.bimserver.models.ifc2x3tc1.IfcQuantityCount;
import org.bimserver.models.ifc2x3tc1.IfcQuantityLength;
import org.bimserver.models.ifc2x3tc1.IfcQuantityTime;
import org.bimserver.models.ifc2x3tc1.IfcQuantityVolume;
import org.bimserver.models.ifc2x3tc1.IfcQuantityWeight;
import org.bimserver.models.ifc2x3tc1.IfcReal;
import org.bimserver.models.ifc2x3tc1.IfcText;
import org.bimserver.models.ifc2x3tc1.IfcTimeMeasure;
import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;
import org.bimserver.models.ifc2x3tc1.IfcValue;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.shared.bimserver.CaseInsensitiveStringList;
import org.erdc.cobie.shared.bimserver.unit.IfcUnitSearchDispatcher;

public class PropertyUtility
{
    private static final int ALLOWED_VALUES_COUNT_LOWER_BOUND = 1;
    private static final int BOUNDED_VALUES_STRING_SPLIT_LOWER_BOUND = 2;
    protected static final int BoundedValueLowerBoundIdx = 0;
    protected static final int BoundedValueUpperBoundIdx = 1;
    private static final String ALLOWED_VALUE_EXCEPTION_MESSAGE = "Invalid allowed values";
    private static final String ENUMERATION_NAME_SUFFIX = " Enumeration";
    protected static final String INVALID_VALUE_EXCEPTION_MSG = "Invalid value:  value is not in list of allowed values";

    public static boolean allStringsAreNumbers(List<String> stringArray)
    {
        boolean allNumbers = true;
        for (String tmpString : stringArray)
        {
            try
            {
                Double.parseDouble(tmpString);
            } catch (Exception e)
            {
                allNumbers = false;
            }
        }
        return allNumbers;
    }

    public static void attachUnitToProperty(IfcProperty property, IfcUnit ifcUnit)
    {
        if (property instanceof IfcPropertySingleValue)
        {
            ((IfcPropertySingleValue)property).setUnit(ifcUnit);
        } else if (property instanceof IfcPropertyBoundedValue)
        {
            ((IfcPropertyBoundedValue)property).setUnit(ifcUnit);
        }

    }

    public static ArrayList<String> delimStringToArrayList(String allowedValues)
    {
        ArrayList<String> allowedValsList = new ArrayList<String>(Arrays.asList(allowedValues.split(COBieUtility.getCOBieDelim())));
        ArrayList<String> trimmedAllowedValsList = new ArrayList<String>();
        for (String allowedValue : allowedValsList)
        {
            trimmedAllowedValsList.add(allowedValue.trim());
        }
        return trimmedAllowedValsList;
    }

    public static String getAllowedValueExceptionMessage()
    {
        return ALLOWED_VALUE_EXCEPTION_MESSAGE;
    }

    public static int getAllowedValuesCountLowerBound()
    {
        return ALLOWED_VALUES_COUNT_LOWER_BOUND;
    }

    public static int getBoundedValuesStringSplitLowerBound()
    {
        return BOUNDED_VALUES_STRING_SPLIT_LOWER_BOUND;
    }

    public static String getEnumerationNameSuffix()
    {
        return ENUMERATION_NAME_SUFFIX;
    }

    public static String getInvalidValueExceptionMsg()
    {
        return INVALID_VALUE_EXCEPTION_MSG;
    }

    public static IfcInteger initializeIntToStringVal(String valString)
    {
        IfcInteger ifcValInteger = Ifc2x3tc1Factory.eINSTANCE.createIfcInteger();
        int valInt = 0;
        String valueAsString = null;
        try
        {
            valInt = Integer.parseInt(valString);
        } catch (Exception ex)
        {
            valueAsString = COBieUtility.COBieNA;
        }
        if (valueAsString == null)
        {
            ifcValInteger.setWrappedValue(valInt);
        }
        return ifcValInteger;
    }

    public static IfcLabel initializeLabel(String text)
    {
        IfcLabel newLabel = Ifc2x3tc1Factory.eINSTANCE.createIfcLabel();
        newLabel.setWrappedValue(text);
        return newLabel;
    }
    
    public static IfcIdentifier initializeIdentifier(String text)
    {
        IfcIdentifier newIdentifier = Ifc2x3tc1Factory.eINSTANCE.createIfcIdentifier();
        newIdentifier.setWrappedValue(text);
        return newIdentifier;
    }

    public static IfcReal initializeRealToStringVal(String valString)
    {
        IfcReal valReal = Ifc2x3tc1Factory.eINSTANCE.createIfcReal();
        float valFloat = 0;
        String valueAsString = null;
        try
        {
            valFloat = Float.parseFloat(valString);
        } catch (Exception ex)
        {
            valueAsString = COBieUtility.COBieNA;
        }
        if (valueAsString == null)
        {
            valReal.setWrappedValue(valFloat);
        } else
        {
            valReal.setWrappedValueAsString(valueAsString);
        }
        return valReal;
    }

    public static IfcText initializeText(String text)
    {
        IfcText newText = Ifc2x3tc1Factory.eINSTANCE.createIfcText();
        newText.setWrappedValue(text);
        return newText;
    }

    public static IfcTimeMeasure initializeTimeMeasureFromString(String valString)
    {
        IfcTimeMeasure valReal = Ifc2x3tc1Factory.eINSTANCE.createIfcTimeMeasure();
        float valFloat = 0;
        String valueAsString = null;
        try
        {
            valFloat = Float.parseFloat(valString);
        } catch (Exception ex)
        {
            valueAsString = COBieUtility.COBieNA;
        }
        if (valueAsString == null)
        {
            valReal.setWrappedValue(valFloat);
        } else
        {
            valReal.setWrappedValueAsString(valueAsString);
        }
        return valReal;
    }

    public static boolean isCandidateEnumeration(String valueString, String allowedValString)
    {
        String[] allowedValsSplit = allowedValString.split(COBieUtility.getCOBieDelim());
        boolean allowedValuesValid = ((allowedValsSplit != null) && (allowedValsSplit.length > getAllowedValuesCountLowerBound()));
        boolean isCandidateEnum = false;
        isCandidateEnum = allowedValuesValid;
        /***
         * commented out 8/3/2012..need to allow enums regardless of value if
         * (allowedValuesValid) { ArrayList<String> allowedValsList =
         * allowedValuesDelimittedToArrayList(allowedValString);
         * CaseInsensitiveStringList caseAgnosticList = new
         * CaseInsensitiveStringList(allowedValsList);
         * 
         * String[] valueSplit =
         * valueString.split(COBieUtility.getCOBieDelim()); valueStringInEnum =
         * caseAgnosticList.contains(valueString); if (valueStringInEnum)
         * isCandidateEnum = true; else if (valueSplit!=null &&
         * valueSplit.length>1) { valueStringInEnum = true; for(String tmpStr :
         * valueSplit) { if (!(caseAgnosticList.contains(tmpStr)))
         * valueStringInEnum = false; } } isCandidateEnum = valueStringInEnum; }
         * else isCandidateEnum = false;
         */
        return isCandidateEnum;

    }

    public static void popoulateEnumerationValues(IfcPropertyEnumeratedValue enumValue, String valueString, ArrayList<String> allowedValues)
            throws Exception
    {
        CaseInsensitiveStringList allowedValuesCaseAgnostic = new CaseInsensitiveStringList(allowedValues);
        String[] splitVals = valueString.split(COBieUtility.getCOBieDelim());
        Exception valException = new Exception(PropertyUtility.INVALID_VALUE_EXCEPTION_MSG);
        if (allowedValuesCaseAgnostic.contains(valueString))
        {
            String caseSensitiveValue = allowedValuesCaseAgnostic.getOriginalCaseSensitiveValue(valueString);
            enumValue.getEnumerationValues().add(valueFromString(caseSensitiveValue));
        } else
        {
            if ((splitVals != null) && (splitVals.length > 1))
            {
                ArrayList<String> valList = new ArrayList<String>(Arrays.asList(splitVals));
                if (allowedValuesCaseAgnostic.containsAll(valList))
                {
                    for (String splitStr : splitVals)
                    {
                        String caseSensitiveValue = allowedValuesCaseAgnostic.getOriginalCaseSensitiveValue(splitStr);
                        enumValue.getEnumerationValues().add(valueFromString(caseSensitiveValue));
                    }
                } else
                {
                    throw valException;
                }
            } else
            {
                throw valException;
            }
        }
    }

    public static void populateEnumeration(IfcPropertyEnumeration enumeration, List<String> valueStrings) throws Exception
    {
        if ((valueStrings != null) && (valueStrings.size() > getAllowedValuesCountLowerBound()))
        {
            if (allStringsAreNumbers(valueStrings))
            {
                for (String valString : valueStrings)
                {
                    enumeration.getEnumerationValues().add(initializeRealToStringVal(valString));
                }
            } else
            {
                for (String valString : valueStrings)
                {
                    enumeration.getEnumerationValues().add(initializeText(valString));
                }
            }
        } else
        {
            throw new Exception(PropertyUtility.getAllowedValueExceptionMessage());
        }
    }

    public static IfcProperty propertyFromCOBieString(String cobieString, String propertyName, String propertyDescription)
    {
        IfcProperty property = null;
        String delim = COBieUtility.getCOBieDelim();
        String[] splitStrings = cobieString.split(delim);
        boolean candidateSplitString = ((splitStrings != null) && (splitStrings.length == getBoundedValuesStringSplitLowerBound()));

        if (property == null)
        {
            try
            {
                Double.parseDouble(cobieString);
                IfcPropertySingleValue singVal = Ifc2x3tc1Factory.eINSTANCE.createIfcPropertySingleValue();
                singVal.setName(propertyName);
                singVal.setDescription(propertyDescription);
                singVal.setNominalValue(initializeRealToStringVal(cobieString));
                property = singVal;
            } catch (Exception e)
            {

            }
        }

        if ((property == null) && candidateSplitString)
        {
            boolean isBoundedVal = true;
            for (String splitStr : splitStrings)
            {
                IfcProperty tmpProp = propertyFromCOBieString(splitStr, propertyName, propertyDescription);
                if (tmpProp instanceof IfcPropertySingleValue)
                {
                    IfcPropertySingleValue tmpSingleVal = (IfcPropertySingleValue)tmpProp;
                    if (!(tmpSingleVal.getNominalValue() instanceof IfcReal))
                    {
                        isBoundedVal = false;
                    }
                }
            }
            if (isBoundedVal)
            {
                IfcPropertyBoundedValue boundVal = Ifc2x3tc1Factory.eINSTANCE.createIfcPropertyBoundedValue();
                boundVal.setName(propertyName);
                boundVal.setDescription(propertyDescription);
                boundVal.setLowerBoundValue(initializeRealToStringVal(splitStrings[BoundedValueLowerBoundIdx]));
                boundVal.setUpperBoundValue(initializeRealToStringVal(splitStrings[BoundedValueUpperBoundIdx]));
                property = boundVal;
            }

        }
        if (property == null)
        {
            IfcPropertySingleValue singValTxt = Ifc2x3tc1Factory.eINSTANCE.createIfcPropertySingleValue();
            singValTxt.setName(propertyName);
            singValTxt.setDescription(propertyDescription);
            singValTxt.setNominalValue(initializeText(cobieString));
            property = singValTxt;
        }
        return property;
    }

    public static IfcProperty propertyFromCOBieStringAndUnit(
            String propertyValue,
            String propertyName,
            String description,
            String unit,
            IfcUnitEnum unitType)
    {
        IfcProperty property = propertyFromCOBieString(propertyValue, propertyName, description);
        if (!COBieUtility.isNA(unit))
        {
            IfcUnitSearchDispatcher unitSearchDispatcher = new IfcUnitSearchDispatcher(unitType, unit);
            IfcUnit ifcUnit = unitSearchDispatcher.getMatchedUnit();
            PropertyUtility.attachUnitToProperty(property, ifcUnit);

        }
        return property;
    }

    protected static void setIfcPhysicalSimpleQuantityValue(IfcPhysicalSimpleQuantity quantity, IfcReal ifcReal)
    {
        boolean setAsString = ((ifcReal.getWrappedValueAsString() != null) && ifcReal.getWrappedValueAsString().equals(COBieUtility.COBieNA));
        String valueAsString = COBieUtility.COBieNA;
        double value = ifcReal.getWrappedValue();
        if (quantity instanceof IfcQuantityLength)
        {
            IfcQuantityLength qL = (IfcQuantityLength)quantity;
            if (setAsString)
            {
                qL.setLengthValueAsString(valueAsString);
            } else
            {
                qL.setLengthValue(value);
            }

        } else if (quantity instanceof IfcQuantityArea)
        {
            IfcQuantityArea qA = (IfcQuantityArea)quantity;
            if (setAsString)
            {
                qA.setAreaValueAsString(valueAsString);
            } else
            {
                qA.setAreaValue(value);
            }

        } else if (quantity instanceof IfcQuantityVolume)
        {
            IfcQuantityVolume qV = (IfcQuantityVolume)quantity;
            if (setAsString)
            {
                qV.setVolumeValueAsString(valueAsString);
            } else
            {
                qV.setVolumeValue(value);
            }
        } else if (quantity instanceof IfcQuantityCount)
        {
            IfcQuantityCount qC = (IfcQuantityCount)quantity;
            if (setAsString)
            {
                qC.setCountValueAsString(valueAsString);
            } else
            {
                qC.setCountValue(value);
            }
        } else if (quantity instanceof IfcQuantityWeight)
        {
            IfcQuantityWeight qW = (IfcQuantityWeight)quantity;
            if (setAsString)
            {
                qW.setWeightValueAsString(valueAsString);
            } else
            {
                qW.setWeightValue(value);
            }
        } else if (quantity instanceof IfcQuantityTime)
        {
            IfcQuantityTime qT = (IfcQuantityTime)quantity;
            if (setAsString)
            {
                qT.setTimeValueAsString(valueAsString);
            } else
            {
                qT.setTimeValue(value);
            }
        }

    }

    protected static void setIfcPhysicalSimpleQuantityValueAndUnit(IfcPhysicalSimpleQuantity quantity, IfcReal ifcReal, IfcNamedUnit unit)
    {
        boolean setAsString = ((ifcReal.getWrappedValueAsString() != null) && ifcReal.getWrappedValueAsString().equals(COBieUtility.COBieNA));
        String valueAsString = COBieUtility.COBieNA;
        double value = ifcReal.getWrappedValue();
        quantity.setUnit(unit);
        if (quantity instanceof IfcQuantityLength)
        {
            IfcQuantityLength qL = (IfcQuantityLength)quantity;
            if (setAsString)
            {
                qL.setLengthValueAsString(valueAsString);
            } else
            {
                qL.setLengthValue(value);
            }

        } else if (quantity instanceof IfcQuantityArea)
        {
            IfcQuantityArea qA = (IfcQuantityArea)quantity;
            if (setAsString)
            {
                qA.setAreaValueAsString(valueAsString);
            } else
            {
                qA.setAreaValue(value);
            }

        } else if (quantity instanceof IfcQuantityVolume)
        {
            IfcQuantityVolume qV = (IfcQuantityVolume)quantity;
            if (setAsString)
            {
                qV.setVolumeValueAsString(valueAsString);
            } else
            {
                qV.setVolumeValue(value);
            }
        } else if (quantity instanceof IfcQuantityCount)
        {
            IfcQuantityCount qC = (IfcQuantityCount)quantity;
            if (setAsString)
            {
                qC.setCountValueAsString(valueAsString);
            } else
            {
                qC.setCountValue(value);
            }
        } else if (quantity instanceof IfcQuantityWeight)
        {
            IfcQuantityWeight qW = (IfcQuantityWeight)quantity;
            if (setAsString)
            {
                qW.setWeightValueAsString(valueAsString);
            } else
            {
                qW.setWeightValue(value);
            }
        } else if (quantity instanceof IfcQuantityTime)
        {
            IfcQuantityTime qT = (IfcQuantityTime)quantity;
            if (setAsString)
            {
                qT.setTimeValueAsString(valueAsString);
            } else
            {
                qT.setTimeValue(value);
            }
        }

    }

    public static boolean shouldSetProperty(String propertyName, IfcValue value)
    {
        boolean shouldSet = true;
        if (value instanceof IfcLabel)
        {
            IfcLabel lbl = (IfcLabel)value;
            String strLbl = lbl.getWrappedValue();
            shouldSet = shouldSetProperty(propertyName, strLbl);
        } else if (value instanceof IfcText)
        {
            IfcText lbl = (IfcText)value;
            String strTxt = lbl.getWrappedValue();
            shouldSet = shouldSetProperty(propertyName, strTxt);
        }
        return shouldSet;
    }

    public static boolean shouldSetProperty(String name, String value)
    {
        boolean shouldSet = true;
        if (COBieUtility.isNA(value) /* || value.equals(name) */)
        {
            shouldSet = false;
        }
        return shouldSet;
    }

    protected static IfcValue valueFromString(String valueString)
    {
        try
        {
            Double.parseDouble(valueString);
            IfcReal realVal = initializeRealToStringVal(valueString);
            return realVal;
        } catch (Exception e)
        {
            IfcText txtVal = initializeText(valueString);
            return txtVal;
        }
    }
}
