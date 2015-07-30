package org.bimserver.cobie.shared.serialization.util;

/******************************************************************************

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
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.bimserver.cobie.shared.utility.COBieUtility;
import org.bimserver.cobie.shared.utility.ifc.IfcRelationshipsToCOBie;
import org.bimserver.models.ifc2x3tc1.IfcAmountOfSubstanceMeasure;
import org.bimserver.models.ifc2x3tc1.IfcAreaMeasure;
import org.bimserver.models.ifc2x3tc1.IfcBoolean;
import org.bimserver.models.ifc2x3tc1.IfcCalendarDate;
import org.bimserver.models.ifc2x3tc1.IfcComplexProperty;
import org.bimserver.models.ifc2x3tc1.IfcContextDependentMeasure;
import org.bimserver.models.ifc2x3tc1.IfcCountMeasure;
import org.bimserver.models.ifc2x3tc1.IfcDerivedMeasureValue;
import org.bimserver.models.ifc2x3tc1.IfcDescriptiveMeasure;
import org.bimserver.models.ifc2x3tc1.IfcElectricCurrentMeasure;
import org.bimserver.models.ifc2x3tc1.IfcIdentifier;
import org.bimserver.models.ifc2x3tc1.IfcInteger;
import org.bimserver.models.ifc2x3tc1.IfcLabel;
import org.bimserver.models.ifc2x3tc1.IfcLengthMeasure;
import org.bimserver.models.ifc2x3tc1.IfcLogical;
import org.bimserver.models.ifc2x3tc1.IfcLuminousIntensityMeasure;
import org.bimserver.models.ifc2x3tc1.IfcMassMeasure;
import org.bimserver.models.ifc2x3tc1.IfcMeasureValue;
import org.bimserver.models.ifc2x3tc1.IfcNormalisedRatioMeasure;
import org.bimserver.models.ifc2x3tc1.IfcNumericMeasure;
import org.bimserver.models.ifc2x3tc1.IfcOwnerHistory;
import org.bimserver.models.ifc2x3tc1.IfcParameterValue;
import org.bimserver.models.ifc2x3tc1.IfcPhysicalComplexQuantity;
import org.bimserver.models.ifc2x3tc1.IfcPhysicalQuantity;
import org.bimserver.models.ifc2x3tc1.IfcPhysicalSimpleQuantity;
import org.bimserver.models.ifc2x3tc1.IfcPlaneAngleMeasure;
import org.bimserver.models.ifc2x3tc1.IfcPositiveLengthMeasure;
import org.bimserver.models.ifc2x3tc1.IfcPositivePlaneAngleMeasure;
import org.bimserver.models.ifc2x3tc1.IfcPositiveRatioMeasure;
import org.bimserver.models.ifc2x3tc1.IfcProperty;
import org.bimserver.models.ifc2x3tc1.IfcPropertyEnumeratedValue;
import org.bimserver.models.ifc2x3tc1.IfcPropertyReferenceValue;
import org.bimserver.models.ifc2x3tc1.IfcPropertySet;
import org.bimserver.models.ifc2x3tc1.IfcPropertySingleValue;
import org.bimserver.models.ifc2x3tc1.IfcQuantityArea;
import org.bimserver.models.ifc2x3tc1.IfcQuantityCount;
import org.bimserver.models.ifc2x3tc1.IfcQuantityLength;
import org.bimserver.models.ifc2x3tc1.IfcQuantityTime;
import org.bimserver.models.ifc2x3tc1.IfcQuantityVolume;
import org.bimserver.models.ifc2x3tc1.IfcQuantityWeight;
import org.bimserver.models.ifc2x3tc1.IfcRatioMeasure;
import org.bimserver.models.ifc2x3tc1.IfcReal;
import org.bimserver.models.ifc2x3tc1.IfcSimpleProperty;
import org.bimserver.models.ifc2x3tc1.IfcSimpleValue;
import org.bimserver.models.ifc2x3tc1.IfcSolidAngleMeasure;
import org.bimserver.models.ifc2x3tc1.IfcText;
import org.bimserver.models.ifc2x3tc1.IfcThermodynamicTemperatureMeasure;
import org.bimserver.models.ifc2x3tc1.IfcTimeMeasure;
import org.bimserver.models.ifc2x3tc1.IfcValue;
import org.bimserver.models.ifc2x3tc1.IfcVolumeMeasure;

public class IfcPropertyToCOBieString
{
    private static final String DECIMAL_STRING_FORMAT = "0.000";
    private static final String COBIE_NA_NUMERICAL = COBieUtility.COBieNA;
    private static final String DECIMAL = ".";
    private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";

    private static String getCOBieFloatString(double d)
    {
        String floatString = getDecimalFormattedString(d);
        floatString = removeTrailingDecimalZerosFromString(floatString);
        return floatString;
    }

    private static String getDecimalFormattedString(double d)
    {
        DecimalFormat df = new DecimalFormat(DECIMAL_STRING_FORMAT, DecimalFormatSymbols.getInstance(COBieUtility.LOCALE));
        return df.format(d);
    }

    private static String getDerivedMeasureValue(IfcDerivedMeasureValue value)
    {

        String valString = "";

        return valString;
    }

    private static String getMeasureValueString(IfcMeasureValue value)
    {
        String valString = "";
        String valueAsString = null;
        boolean isText = false;
        float tmpFloat = 0;
        if (value instanceof IfcAmountOfSubstanceMeasure)
        {
            IfcAmountOfSubstanceMeasure sm = (IfcAmountOfSubstanceMeasure)value;
            tmpFloat = (float)sm.getWrappedValue();
            valueAsString = sm.getWrappedValueAsString();
            valString = String.valueOf(tmpFloat);
        }
        if (value instanceof IfcAreaMeasure)
        {
            IfcAreaMeasure am = (IfcAreaMeasure)value;
            tmpFloat = (float)am.getWrappedValue();
            valueAsString = am.getWrappedValueAsString();
            valString = String.valueOf(tmpFloat);
        }
        if (value instanceof IfcContextDependentMeasure)
        {
            IfcContextDependentMeasure cm = (IfcContextDependentMeasure)value;
            tmpFloat = (float)cm.getWrappedValue();
            valueAsString = cm.getWrappedValueAsString();
            valString = String.valueOf(tmpFloat);
        }
        if (value instanceof IfcCountMeasure)
        {
            IfcCountMeasure cntm = (IfcCountMeasure)value;
            tmpFloat = (float)cntm.getWrappedValue();
            valString = String.valueOf(tmpFloat);
            valueAsString = cntm.getWrappedValueAsString();
        }
        if (value instanceof IfcDescriptiveMeasure)
        {
            IfcDescriptiveMeasure dm = (IfcDescriptiveMeasure)value;
            isText = true;
            // tmpFloat = dm.getWrappedValue();
            valString = dm.getWrappedValue();

        }
        if (value instanceof IfcElectricCurrentMeasure)
        {
            IfcElectricCurrentMeasure em = (IfcElectricCurrentMeasure)value;
            tmpFloat = (float)em.getWrappedValue();
            valString = String.valueOf(tmpFloat);
            valueAsString = em.getWrappedValueAsString();
        }
        if (value instanceof IfcLengthMeasure)
        {
            IfcLengthMeasure lm = (IfcLengthMeasure)value;
            tmpFloat = (float)lm.getWrappedValue();
            valString = String.valueOf(tmpFloat);
            valueAsString = lm.getWrappedValueAsString();
        }
        if (value instanceof IfcLuminousIntensityMeasure)
        {
            IfcLuminousIntensityMeasure lum = (IfcLuminousIntensityMeasure)value;
            tmpFloat = (float)lum.getWrappedValue();
            valString = String.valueOf(tmpFloat);
            valueAsString = lum.getWrappedValueAsString();
        }
        if (value instanceof IfcMassMeasure)
        {
            IfcMassMeasure mm = (IfcMassMeasure)value;
            tmpFloat = (float)mm.getWrappedValue();
            valString = String.valueOf(tmpFloat);
            valueAsString = mm.getWrappedValueAsString();
        }
        if (value instanceof IfcNormalisedRatioMeasure)
        {
            IfcNormalisedRatioMeasure nm = (IfcNormalisedRatioMeasure)value;
            tmpFloat = (float)nm.getWrappedValue();
            valString = String.valueOf(tmpFloat);
            valueAsString = nm.getWrappedValueAsString();
        }
        if (value instanceof IfcNumericMeasure)
        {
            IfcNumericMeasure num = (IfcNumericMeasure)value;
            tmpFloat = (float)num.getWrappedValue();
            valString = String.valueOf(tmpFloat);
            valueAsString = num.getWrappedValueAsString();
        }
        if (value instanceof IfcParameterValue)
        {
            IfcParameterValue pm = (IfcParameterValue)value;
            tmpFloat = (float)pm.getWrappedValue();
            valString = String.valueOf(tmpFloat);
            valueAsString = pm.getWrappedValueAsString();
        }
        if (value instanceof IfcPlaneAngleMeasure)
        {
            IfcPlaneAngleMeasure plm = (IfcPlaneAngleMeasure)value;
            tmpFloat = (float)plm.getWrappedValue();
            valString = String.valueOf(tmpFloat);
            valueAsString = plm.getWrappedValueAsString();
        }
        if (value instanceof IfcPositiveLengthMeasure)
        {
            IfcPositiveLengthMeasure pom = (IfcPositiveLengthMeasure)value;
            tmpFloat = (float)pom.getWrappedValue();
            valString = String.valueOf(tmpFloat);
            valueAsString = pom.getWrappedValueAsString();
        }
        if (value instanceof IfcPositivePlaneAngleMeasure)
        {
            IfcPositivePlaneAngleMeasure poam = (IfcPositivePlaneAngleMeasure)value;
            tmpFloat = (float)poam.getWrappedValue();
            valString = String.valueOf(tmpFloat);
            valueAsString = poam.getWrappedValueAsString();
        }
        if (value instanceof IfcPositiveRatioMeasure)
        {
            IfcPositiveRatioMeasure porm = (IfcPositiveRatioMeasure)value;
            tmpFloat = (float)porm.getWrappedValue();
            valString = String.valueOf(tmpFloat);
            valueAsString = porm.getWrappedValueAsString();
        }
        if (value instanceof IfcRatioMeasure)
        {
            IfcRatioMeasure ram = (IfcRatioMeasure)value;
            tmpFloat = (float)ram.getWrappedValue();
            valString = String.valueOf(tmpFloat);
            valueAsString = ram.getWrappedValueAsString();
        }
        if (value instanceof IfcSolidAngleMeasure)
        {
            IfcSolidAngleMeasure som = (IfcSolidAngleMeasure)value;
            tmpFloat = (float)som.getWrappedValue();
            valString = String.valueOf(tmpFloat);
            valueAsString = som.getWrappedValueAsString();
        }
        if (value instanceof IfcThermodynamicTemperatureMeasure)
        {
            IfcThermodynamicTemperatureMeasure ttm = (IfcThermodynamicTemperatureMeasure)value;
            tmpFloat = (float)ttm.getWrappedValue();
            valString = String.valueOf(tmpFloat);
            valueAsString = ttm.getWrappedValueAsString();
        }
        if (value instanceof IfcTimeMeasure)
        {
            IfcTimeMeasure tim = (IfcTimeMeasure)value;
            tmpFloat = (float)tim.getWrappedValue();
            valString = String.valueOf(tmpFloat);
            valueAsString = tim.getWrappedValueAsString();
        }
        if (value instanceof IfcVolumeMeasure)
        {
            IfcVolumeMeasure vm = (IfcVolumeMeasure)value;
            tmpFloat = (float)vm.getWrappedValue();
            valString = String.valueOf(tmpFloat);
            valueAsString = vm.getWrappedValueAsString();
        }
        if ((valueAsString != null) && valueAsString.equals(COBIE_NA_NUMERICAL))
        {
            valString = COBIE_NA_NUMERICAL;
        } else if ((valString.length() > 0) && !isText)
        {
            valString = getCOBieFloatString(tmpFloat);
        } else if (!isText)
        {
            valString = COBIE_NA_NUMERICAL;
        }
        return valString;
    }

    public static String getSimpleValueString(IfcSimpleValue value)
    {
        String valString = "";
        String valueAsString;
        if (value instanceof IfcLabel)
        {
            IfcLabel label = (IfcLabel)value;
            valString = label.getWrappedValue();
        } 

        else if (value instanceof IfcReal)
        {
            IfcReal rl = (IfcReal)value;
            valString = getCOBieFloatString(rl.getWrappedValue());
            valueAsString = ((IfcReal)value).getWrappedValueAsString();
            if ((valueAsString != null) && valueAsString.equals(COBIE_NA_NUMERICAL))
            {
                valString = COBIE_NA_NUMERICAL;
                // valString = rl.getWrappedValueAsString();
            }
        } else if (value instanceof IfcInteger)
        {
            IfcInteger integer = (IfcInteger)value;
            try
            {

                valString = String.valueOf(integer.getWrappedValue());
            } catch (Exception ex)
            {

            }
        } else if (value instanceof IfcBoolean)
        {
            IfcBoolean bl = (IfcBoolean)value;
            valString = bl.getWrappedValue().getLiteral();
        } else if (value instanceof IfcIdentifier)
        {
            IfcIdentifier id = (IfcIdentifier)value;
            valString = id.getWrappedValue();
        } else if (value instanceof IfcText)
        {
            IfcText txt = (IfcText)value;
            valString = txt.getWrappedValue();
        } else if (value instanceof IfcLogical)
        {
            IfcLogical lg = (IfcLogical)value;
            valString = lg.getWrappedValue().getLiteral();
        }
        return valString;
    }

    public static String getValueStringFromValue(IfcValue value)
    {
        String valueString = "";
        if (value instanceof IfcSimpleValue)
        {
            valueString = getSimpleValueString((IfcSimpleValue)value);
        } else if (value instanceof IfcMeasureValue)
        {
            valueString = getMeasureValueString((IfcMeasureValue)value);
        } else if (value instanceof IfcDerivedMeasureValue)
        {
            valueString = getDerivedMeasureValue((IfcDerivedMeasureValue)value);
        }
        return COBieUtility.getCOBieString(valueString);

    }

    static protected boolean isPropertySearchStringAHit(String searchString, String compareString)
    {
        boolean hit = false;
        String searchStringLower = searchString.toLowerCase().trim();
        String compareStringLower = compareString.toLowerCase();
        IfcRelationshipsToCOBie.ComparisonType compareType = IfcRelationshipsToCOBie.getComparisonTypeFromPropertySearchString(searchString);
        switch (compareType)
        {
            case StartsWith:
                if (compareStringLower.startsWith(searchStringLower))
                {
                    hit = true;
                }
                break;
            case EndsWith:
                if (compareStringLower.endsWith(searchStringLower))
                {
                    hit = true;
                }
                break;
            case Contains:
                if (compareStringLower.contains(searchStringLower))
                {
                    hit = true;
                }
                break;
            case Equals:
                if (compareStringLower.equalsIgnoreCase(searchStringLower))
                {
                    hit = true;
                }
                break;
            default:
                hit = false;
                break;
        }
        return hit;
    }

    static public Map<String, String> mergePropertyStrings(Map<String, String> tmpPropertyMap, Map<String, String> propertyMap)
    {
        Map<String, String> clonePMap = IfcRelationshipsToCOBie.clonePropertyMap(propertyMap);
        String tmpVal1 = "";
        String tmpVal2 = "";
        if (!tmpPropertyMap.isEmpty())
        {
            for (String key : tmpPropertyMap.keySet())
            {
                tmpVal1 = tmpPropertyMap.get(key);
                if ((tmpVal1 != null) && !tmpVal1.isEmpty())
                {
                    if (clonePMap.keySet().contains(key))
                    {
                        tmpVal2 = clonePMap.get(key);
                        if (!tmpVal2.equalsIgnoreCase(tmpVal1))
                        {
                            clonePMap.put(key, tmpVal2 + "," + tmpVal1);
                        }
                    } else
                    {
                        clonePMap.put(key, tmpVal1);
                    }
                }
            }
        }
        return clonePMap;
    }

    static public Map<String, String> propertyStringsFromPhysicalQuantity(IfcPhysicalQuantity quantity, ArrayList<String> propertyNames)
    {
        Map<String, String> propertyVals = new HashMap<String, String>();
        @SuppressWarnings("unchecked")
        ArrayList<String> copyPropertyNames = (ArrayList<String>)propertyNames.clone();
        IfcPhysicalSimpleQuantity psq;
        IfcPhysicalComplexQuantity pcq;
        if (quantity instanceof IfcPhysicalComplexQuantity)
        {
            pcq = (IfcPhysicalComplexQuantity)quantity;
            for (IfcPhysicalQuantity pq : pcq.getHasQuantities())
            {
                propertyVals = propertyStringsFromPhysicalQuantity(pq, propertyNames);
            }
        } else if (quantity instanceof IfcPhysicalSimpleQuantity)
        {
            psq = (IfcPhysicalSimpleQuantity)quantity;
            psq.getClass();
            String spName = psq.getName();
            String keyMatchStr = "";
            ArrayList<String> keyMatchStrings = new ArrayList<String>();
            String valStr = "";
            for (String searchP : copyPropertyNames)
            {
                if (spName.toLowerCase().contains(searchP.toLowerCase()))
                {
                    keyMatchStr = searchP;
                    keyMatchStrings.add(keyMatchStr);
                }
            }

            for (String ki : keyMatchStrings)
            {
                valStr = IfcPropertyToCOBieString.stringFromIfcPhysicalSimpleQuantity(psq);
                propertyVals.put(ki, valStr);
                copyPropertyNames.remove(ki);
            }

        }
        return propertyVals;
    }

    @SuppressWarnings("unchecked")
    static public Map<String, String> propertyStringsFromPhysicalQuantity(
            IfcPhysicalQuantity quantity,
            ArrayList<String> propertyNames,
            boolean exclusive)
    {
        boolean testProperty = false;
        Map<String, String> propertyVals = new HashMap<String, String>();
        ArrayList<String> copyPropertyNames = (ArrayList<String>)propertyNames.clone();
        IfcPhysicalSimpleQuantity psq;
        IfcPhysicalComplexQuantity pcq;
        if (quantity instanceof IfcPhysicalComplexQuantity)
        {
            pcq = (IfcPhysicalComplexQuantity)quantity;
            for (IfcPhysicalQuantity pq : pcq.getHasQuantities())
            {
                propertyVals = propertyStringsFromPhysicalQuantity(pq, propertyNames, exclusive);
            }
        } else if (quantity instanceof IfcPhysicalSimpleQuantity)
        {
            psq = (IfcPhysicalSimpleQuantity)quantity;
            psq.getClass();
            String spName = psq.getName();
            String keyMatchStr = "";
            ArrayList<String> keyMatchStrings = new ArrayList<String>();
            String valStr = "";
            if (exclusive)
            {
                testProperty = true;
                for (String searchP : copyPropertyNames)
                {
                    if (spName.toLowerCase().contains(searchP.toLowerCase()))
                    {
                        testProperty = false;
                    }
                }
                if (testProperty)
                {
                    keyMatchStrings.add(spName);
                }
            } else
            {
                for (String searchP : copyPropertyNames)
                {

                    testProperty = spName.toLowerCase().contains(searchP.toLowerCase());
                    keyMatchStr = searchP;
                    if (testProperty)
                    {
                        keyMatchStrings.add(keyMatchStr);
                    }
                }
            }

            for (String ki : keyMatchStrings)
            {
                valStr = IfcPropertyToCOBieString.stringFromIfcPhysicalSimpleQuantity(psq);
                propertyVals.put(ki, valStr);
                copyPropertyNames.remove(ki);
            }

        }
        return propertyVals;
    }

    @SuppressWarnings("unchecked")
	public
    static Map<String, String> propertyStringsFromProperty(IfcProperty property, ArrayList<String> propertyNames)
    {
        Map<String, String> propertyVals = new PropertyNameStringValueMap();
        ArrayList<String> copyPropertyNames = (ArrayList<String>)propertyNames.clone();
        IfcComplexProperty cProperty;
        IfcSimpleProperty simpleProperty;
        if (IfcComplexProperty.class.isInstance(property))
        {
            cProperty = (IfcComplexProperty)property;
            for (IfcProperty cProp : cProperty.getHasProperties())
            {
                propertyVals = propertyStringsFromProperty(cProp, propertyNames);
            }
        } else if (IfcSimpleProperty.class.isInstance(property))
        {
            simpleProperty = (IfcSimpleProperty)property;
            simpleProperty.getClass();
            String simplePropertyName = simpleProperty.getName();
            String tmpKeyMatch = "";
            ArrayList<String> keyMatches = new ArrayList<String>();
            String valStr = "";
            for (String searchPropertyName : copyPropertyNames)
            {
                // if (spName.toLowerCase().contains(searchP.toLowerCase()))
                if (isPropertySearchStringAHit(searchPropertyName, simplePropertyName))
                {
                    tmpKeyMatch = searchPropertyName;
                    keyMatches.add(tmpKeyMatch);
                }
            }

            for (String keyMatch : keyMatches)
            {
                if (simpleProperty instanceof IfcPropertySingleValue)
                {
                    valStr = stringFromPropertySingleValue((IfcPropertySingleValue)simpleProperty);
                    ((PropertyNameStringValueMap)propertyVals).put(keyMatch, valStr, simpleProperty);
                    copyPropertyNames.remove(keyMatch);
                }
                if (simpleProperty instanceof IfcPropertyEnumeratedValue)
                {
                    valStr = IfcPropertyToCOBieString.stringFromPropertyEnumeratedValue((IfcPropertyEnumeratedValue)simpleProperty);
                    ((PropertyNameStringValueMap)propertyVals).put(keyMatch, valStr, simpleProperty);
                    copyPropertyNames.remove(keyMatch);

                }
                if (simpleProperty instanceof IfcPropertyReferenceValue)
                {
                   valStr = IfcPropertyToCOBieString.stringFromReferenceValue((IfcPropertyReferenceValue) simpleProperty);
                   ((PropertyNameStringValueMap)propertyVals).put(keyMatch, valStr, simpleProperty);
                   copyPropertyNames.remove(keyMatch);
                }
            }

        }
        return propertyVals;
    }

    private static String stringFromReferenceValue(IfcPropertyReferenceValue referenceValue)
    {
        String referenceValueLiteral = "";
        if(referenceValue.getPropertyReference() instanceof IfcCalendarDate)
        {
            IfcCalendarDate calendarDate =
                    (IfcCalendarDate) referenceValue.getPropertyReference();
            int month = calendarDate.getMonthComponent();
            //Java Calendar month is zero based, and in IFC it is 1 based so must subtract month value by one
            month--;
            int day = calendarDate.getDayComponent();
            int year = calendarDate.getYearComponent();
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.MONTH, month);
            calendar.set(Calendar.DAY_OF_MONTH, day);
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.HOUR, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            SimpleDateFormat formatter =
                    new SimpleDateFormat(DATE_FORMAT);
            referenceValueLiteral =
                    formatter.format(calendar.getTime());
            
        }
        return referenceValueLiteral;
    }

    @SuppressWarnings("unchecked")
	public
    static Map<String, String> propertyStringsFromProperty(IfcProperty property, ArrayList<String> propertyNames, boolean exclusive)
    {
        boolean testProperty = false;
        Map<String, String> propertyVals = new HashMap<String, String>();
        ArrayList<String> copyPropertyNames = (ArrayList<String>)propertyNames.clone();
        IfcComplexProperty cProperty;
        IfcSimpleProperty sProperty;
        if (IfcComplexProperty.class.isInstance(property))
        {
            cProperty = (IfcComplexProperty)property;
            for (IfcProperty cProp : cProperty.getHasProperties())
            {
                propertyVals = propertyStringsFromProperty(cProp, propertyNames, exclusive);
            }
        } else if (IfcSimpleProperty.class.isInstance(property))
        {
            sProperty = (IfcSimpleProperty)property;
            sProperty.getClass();
            String spName = sProperty.getName();
            String keyMatchStr = "";
            ArrayList<String> keyMatchStrings = new ArrayList<String>();
            String valStr = "";
            if (exclusive)
            {
                testProperty = true;
                for (String searchP : copyPropertyNames)
                {
                    // if(spName.toLowerCase().contains(searchP.toLowerCase()))
                    if (isPropertySearchStringAHit(searchP, spName))
                    {
                        testProperty = false;
                    }
                }
                if (testProperty)
                {
                    keyMatchStrings.add(spName);
                }
            } else
            {
                for (String searchP : copyPropertyNames)
                {

                    // testProperty =
                    // spName.toLowerCase().contains(searchP.toLowerCase());
                    testProperty = isPropertySearchStringAHit(searchP, spName);
                    keyMatchStr = searchP;
                    if (testProperty)
                    {
                        keyMatchStrings.add(keyMatchStr);
                    }
                }
            }

            for (String ki : keyMatchStrings)
            {
                if (IfcPropertySingleValue.class.isInstance(sProperty))
                {
                    valStr = stringFromPropertySingleValue((IfcPropertySingleValue)sProperty);
                    propertyVals.put(ki, valStr);
                    copyPropertyNames.remove(ki);
                }
                if (sProperty instanceof IfcPropertyEnumeratedValue)
                {
                    valStr = IfcPropertyToCOBieString.stringFromPropertyEnumeratedValue((IfcPropertyEnumeratedValue)sProperty);
                    propertyVals.put(ki, valStr);
                    copyPropertyNames.remove(ki);
                }
            }

        }
        return propertyVals;
    }

    static IfcEnumeratedValueToCOBieString psetEnumeratedValueStringFromEnumeratedValue(IfcPropertyEnumeratedValue enumVal)
    {
        IfcEnumeratedValueToCOBieString enumStr = new IfcEnumeratedValueToCOBieString(enumVal);
        return enumStr;
    }

    static IfcSingleValueToCOBieString psetSingleValueStringFromPropertySingleValue(IfcPropertySingleValue singleValue)
    {
        IfcSingleValueToCOBieString sValStr = new IfcSingleValueToCOBieString(singleValue);
        return sValStr;
    }

    @SuppressWarnings("unchecked")
    static public Map<String, IfcPropertyToCOBieString> psetStringsFromPhysicalQuantity(
            IfcPhysicalQuantity quantity,
            ArrayList<String> propertyNames,
            boolean exclusive)
    {
        boolean testProperty = false;
        Map<String, IfcPropertyToCOBieString> propertyVals = new HashMap<String, IfcPropertyToCOBieString>();
        ArrayList<String> copyPropertyNames = (ArrayList<String>)propertyNames.clone();
        IfcPhysicalSimpleQuantity psq;
        IfcPhysicalComplexQuantity pcq;
        if (quantity instanceof IfcPhysicalComplexQuantity)
        {
            pcq = (IfcPhysicalComplexQuantity)quantity;
            for (IfcPhysicalQuantity pq : pcq.getHasQuantities())
            {
                propertyVals = psetStringsFromPhysicalQuantity(pq, propertyNames, exclusive);
            }
        } else if (quantity instanceof IfcPhysicalSimpleQuantity)
        {
            psq = (IfcPhysicalSimpleQuantity)quantity;
            psq.getClass();
            String spName = psq.getName();
            String keyMatchStr = "";
            ArrayList<String> keyMatchStrings = new ArrayList<String>();
            IfcPhysicalQuantityToCOBieString valStr;
            if (exclusive)
            {
                testProperty = true;
                for (String searchP : copyPropertyNames)
                {
                    // if(spName.toLowerCase().contains(searchP.toLowerCase()))
                    if (isPropertySearchStringAHit(searchP, spName))
                    {
                        testProperty = false;
                    }
                }
                if (testProperty)
                {
                    keyMatchStrings.add(spName);
                }
            } else
            {
                for (String searchP : copyPropertyNames)
                {

                    // testProperty =
                    // spName.toLowerCase().contains(searchP.toLowerCase());
                    testProperty = isPropertySearchStringAHit(searchP, spName);
                    keyMatchStr = searchP;
                    if (testProperty)
                    {
                        keyMatchStrings.add(keyMatchStr);
                    }
                }
            }

            for (String ki : keyMatchStrings)
            {
                valStr = new IfcPhysicalQuantityToCOBieString(psq);
                propertyVals.put(ki, valStr);
                copyPropertyNames.remove(ki);
            }

        }
        return propertyVals;
    }

    @SuppressWarnings("unchecked")
	public
    static Map<String, IfcPropertyToCOBieString> psetStringsFromProperty(IfcProperty property, ArrayList<String> propertyNames, boolean exclusive)
    {
        boolean testProperty = false;
        Map<String, IfcPropertyToCOBieString> propertyVals = new HashMap<String, IfcPropertyToCOBieString>();
        ArrayList<String> copyPropertyNames = (ArrayList<String>)propertyNames.clone();
        IfcComplexProperty cProperty;
        IfcSimpleProperty sProperty;
        if (IfcComplexProperty.class.isInstance(property))
        {
            cProperty = (IfcComplexProperty)property;
            for (IfcProperty cProp : cProperty.getHasProperties())
            {
                propertyVals = psetStringsFromProperty(cProp, propertyNames, exclusive);
            }
        } else if (IfcSimpleProperty.class.isInstance(property))
        {
            sProperty = (IfcSimpleProperty)property;
            sProperty.getClass();
            String spName = sProperty.getName();
            String keyMatchStr = "";
            ArrayList<String> keyMatchStrings = new ArrayList<String>();
            if (exclusive)
            {
                testProperty = true;
                for (String searchP : copyPropertyNames)
                {
                    // if(spName.toLowerCase().contains(searchP.toLowerCase()))
                    if (isPropertySearchStringAHit(searchP, spName))
                    {
                        testProperty = false;
                    }
                }
                if (testProperty)
                {
                    keyMatchStrings.add(spName);
                }
            } else
            {
                for (String searchP : copyPropertyNames)
                {

                    // testProperty =
                    // spName.toLowerCase().contains(searchP.toLowerCase());
                    testProperty = isPropertySearchStringAHit(searchP, spName);
                    keyMatchStr = searchP;
                    if (testProperty)
                    {
                        keyMatchStrings.add(keyMatchStr);
                    }
                }
            }

            for (String ki : keyMatchStrings)
            {
                if (IfcPropertySingleValue.class.isInstance(sProperty))
                {
                    IfcSingleValueToCOBieString svStr = IfcPropertyToCOBieString
                            .psetSingleValueStringFromPropertySingleValue((IfcPropertySingleValue)sProperty);
                    propertyVals.put(ki, svStr);
                    copyPropertyNames.remove(ki);
                }
                if (sProperty instanceof IfcPropertyEnumeratedValue)
                {
                    IfcEnumeratedValueToCOBieString enStr = IfcPropertyToCOBieString
                            .psetEnumeratedValueStringFromEnumeratedValue((IfcPropertyEnumeratedValue)sProperty);

                    propertyVals.put(ki, enStr);
                    copyPropertyNames.remove(ki);
                } else
                {
                    // TODO: Handle other cases
                }
            }

        }
        return propertyVals;
    }

    private static String removeTrailingDecimalZerosFromString(String floatString)
    {
        String nonTrailingZeroString = floatString;
        if (floatString.contains(DECIMAL))
        {
            String[] splitString = floatString.split("\\" + DECIMAL);
            String leftString = splitString[0];
            String rightString = splitString[1];
            while ((rightString.length() > 1) && rightString.endsWith("0"))
            {
                rightString = rightString.substring(0, rightString.length() - 1);
            }
            nonTrailingZeroString = leftString + DECIMAL + rightString;
        }
        return nonTrailingZeroString;
    }

    public static String stringFromIfcPhysicalSimpleQuantity(IfcPhysicalSimpleQuantity simpleQ)
    {
        IfcPhysicalQuantityToCOBieString pStr = new IfcPhysicalQuantityToCOBieString(simpleQ);
        return pStr.getValueString();
    }

    static private String stringFromPropertyEnumeratedValue(IfcPropertyEnumeratedValue enumVal)
    {
        IfcEnumeratedValueToCOBieString enumStr = IfcPropertyToCOBieString.psetEnumeratedValueStringFromEnumeratedValue(enumVal);
        return enumStr.getValueString();
    }

    static public String stringFromPropertySingleValue(IfcPropertySingleValue singleValue)
    {
        IfcSingleValueToCOBieString sValStr = new IfcSingleValueToCOBieString(singleValue);
        return sValStr.getValueString();
    }

    private IfcOwnerHistory attachedOwnerHistory;

    private IfcSimpleProperty property;

    private String propertyNameString;
    private String propertySetGlobalIDString;
    private String propertySetString;
    private IfcPropertySet propertySet;
    private String propertyTypeString;

    private IfcPhysicalSimpleQuantity quantity;

    private String valueString;

    public IfcPropertyToCOBieString()
    {
        super();

    }

    public IfcPropertyToCOBieString(IfcPhysicalSimpleQuantity sQuantity)
    {
        super();
        setQuantity(sQuantity);
        setPropertyNameString(sQuantity.getName());
        setValueString(sQuantity);
    }

    public IfcPropertyToCOBieString(IfcSimpleProperty property)
    {
        super();
        setProperty(property);
        setPropertyNameString(property.getName());
    }

    public IfcOwnerHistory getAttachedOwnerHistory()
    {
        return attachedOwnerHistory;
    }

    public String getDescriptionString()
    {
        String description = "";
        try
        {
            description = property.getDescription();
        } catch (Exception ex)
        {

        }
        if ((description == null) || (description.length() == 0))
        {
            description = propertyNameString;
        }
        return description;
    }

    public IfcSimpleProperty getProperty()
    {
        return property;
    }

    public String getPropertyNameString()
    {
        return propertyNameString;
    }

    public IfcPropertySet getPropertySet()
    {
        return propertySet;
    }

    public String getPropertySetGlobalIDString()
    {
        return propertySetGlobalIDString;
    }

    public String getPropertySetString()
    {
        return propertySetString;
    }

    public String getPropertyTypeString()
    {
        return propertyTypeString;
    }

    public IfcPhysicalSimpleQuantity getQuantity()
    {
        return quantity;
    }

    public String getValueString()
    {
        return valueString;
    }

    public void setAttachedOwnerHistory(IfcOwnerHistory attachedOwnerHistory)
    {
        this.attachedOwnerHistory = attachedOwnerHistory;
    }

    public void setProperty(IfcSimpleProperty property)
    {
        this.property = property;
    }

    private void setPropertyNameString(String propertyName)
    {
        propertyNameString = propertyName;
    }

    public void setPropertySet(IfcPropertySet propertySet)
    {
        this.propertySet = propertySet;
    }

    public void setPropertySetGlobalIDString(String propertySetGlobalIDString)
    {
        this.propertySetGlobalIDString = propertySetGlobalIDString;
    }

    public void setPropertySetString(String propertySetString)
    {
        this.propertySetString = propertySetString;
    }

    protected void setPropertyTypeString(String propertyType)
    {
        propertyTypeString = propertyType;
    }

    public void setQuantity(IfcPhysicalSimpleQuantity quantity)
    {
        this.quantity = quantity;
    }

    protected void setValueString(IfcPhysicalSimpleQuantity quantity)
    {
        valueString = "";
        float tmpFloat = 0;
        String quantityAsString = null;
        if (quantity instanceof IfcQuantityLength)
        {
            IfcQuantityLength qL = (IfcQuantityLength)quantity;
            quantityAsString = qL.getLengthValueAsString();
            tmpFloat = (float)qL.getLengthValue();
            valueString = Float.toString(tmpFloat);
        } else if (quantity instanceof IfcQuantityArea)
        {
            IfcQuantityArea qA = (IfcQuantityArea)quantity;
            tmpFloat = (float)qA.getAreaValue();
            quantityAsString = qA.getAreaValueAsString();
            valueString = Float.toString(tmpFloat);
        } else if (quantity instanceof IfcQuantityVolume)
        {
            IfcQuantityVolume qV = (IfcQuantityVolume)quantity;
            tmpFloat = (float)qV.getVolumeValue();
            quantityAsString = qV.getVolumeValueAsString();
            valueString = Float.toString(tmpFloat);
        } else if (quantity instanceof IfcQuantityCount)
        {
            IfcQuantityCount qC = (IfcQuantityCount)quantity;
            tmpFloat = (float)qC.getCountValue();
            quantityAsString = qC.getCountValueAsString();
            valueString = Float.toString(tmpFloat);
        } else if (quantity instanceof IfcQuantityWeight)
        {
            IfcQuantityWeight qW = (IfcQuantityWeight)quantity;
            tmpFloat = (float)qW.getWeightValue();
            quantityAsString = qW.getWeightValueAsString();
            valueString = Float.toString(tmpFloat);
        } else if (quantity instanceof IfcQuantityTime)
        {
            IfcQuantityTime qT = (IfcQuantityTime)quantity;
            tmpFloat = (float)qT.getTimeValue();
            quantityAsString = qT.getTimeValueAsString();
            valueString = Float.toString(tmpFloat);
        }
        if ((valueString.length() > 0) && ((quantityAsString == null) || !quantityAsString.equals(COBIE_NA_NUMERICAL)))
        {
            valueString = getCOBieFloatString(tmpFloat);
        } else
        {
            valueString = COBIE_NA_NUMERICAL;
        }

    }

    protected void setValueString(IfcValue value)
    {
        valueString = "";
        if (value instanceof IfcSimpleValue)
        {
            valueString = getSimpleValueString((IfcSimpleValue)value);
        } else if (value instanceof IfcMeasureValue)
        {
            valueString = getMeasureValueString((IfcMeasureValue)value);
        } else if (value instanceof IfcDerivedMeasureValue)
        {
            valueString = getDerivedMeasureValue((IfcDerivedMeasureValue)value);
        }
        valueString = COBieUtility.getCOBieString(valueString);
    }

    protected void setValueString(String valueString)
    {
        this.valueString = valueString;
    }

}
