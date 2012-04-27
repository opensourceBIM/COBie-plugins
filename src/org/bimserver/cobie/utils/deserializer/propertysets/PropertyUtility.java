package org.bimserver.cobie.utils.deserializer.propertysets;

import java.util.ArrayList;
import java.util.Arrays;

import org.bimserver.cobie.utils.COBieUtility;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.IfcLabel;
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
import org.bimserver.models.ifc2x3tc1.IfcValue;

public class PropertyUtility 
{
	private static final int ALLOWED_VALUES_COUNT_LOWER_BOUND = 1;
	private static final int BOUNDED_VALUES_STRING_SPLIT_LOWER_BOUND = 2;
	protected static final int BoundedValueLowerBoundIdx = 0;
	protected static final int BoundedValueUpperBoundIdx = 1;
	private static final String ALLOWED_VALUE_EXCEPTION_MESSAGE = "Invalid allowed values";
	private static final String ENUMERATION_NAME_SUFFIX = " Enumeration";
	protected static final String INVALID_VALUE_EXCEPTION_MSG = "Invalid value:  value is not in list of allowed values";
	
	public static String getInvalidValueExceptionMsg()
	{
		return INVALID_VALUE_EXCEPTION_MSG;
	}
	
	public static IfcProperty propertyFromCOBieString(String cobieString,String propertyName,String propertyDescription)
	{
		String delim = COBieUtility.getCOBieDelim();
		String[] splitStrings = cobieString.split(delim);
		boolean candidateSplitString = (splitStrings!=null && splitStrings.length==getBoundedValuesStringSplitLowerBound());
		try
		{
			Double.parseDouble(cobieString);
			IfcPropertySingleValue singVal =Ifc2x3tc1Factory.eINSTANCE.createIfcPropertySingleValue();
			singVal.setName(propertyName);
			singVal.setDescription(propertyDescription);
			singVal.setNominalValue(initializeRealToStringVal(cobieString));
			return singVal;
		}
		catch(Exception e)
		{
			
		}
		
		if (candidateSplitString)
		{
			boolean isBoundedVal = true;
			for(String splitStr : splitStrings)
			{
				IfcProperty tmpProp = propertyFromCOBieString(splitStr,propertyName,propertyDescription);
				if (tmpProp instanceof IfcPropertySingleValue)
				{
					IfcPropertySingleValue tmpSingleVal = (IfcPropertySingleValue) tmpProp;
					if (!(tmpSingleVal.getNominalValue() instanceof IfcReal))
						isBoundedVal = false;						
				}
			}
			if (isBoundedVal)
			{
				IfcPropertyBoundedValue boundVal = Ifc2x3tc1Factory.eINSTANCE.createIfcPropertyBoundedValue();
				boundVal.setName(propertyName);
				boundVal.setDescription(propertyDescription);
				boundVal.setLowerBoundValue(initializeRealToStringVal(splitStrings[BoundedValueLowerBoundIdx]));
				boundVal.setUpperBoundValue(initializeRealToStringVal(splitStrings[BoundedValueUpperBoundIdx]));
				return boundVal;
			}

		}
		IfcPropertySingleValue singValTxt = Ifc2x3tc1Factory.eINSTANCE.createIfcPropertySingleValue();
		singValTxt.setName(propertyName);
		singValTxt.setDescription(propertyDescription);
		singValTxt.setNominalValue(initializeText(cobieString));
		return singValTxt;		
	}
	
	public static IfcReal initializeRealToStringVal(String valString)
	{
		IfcReal valReal =
				Ifc2x3tc1Factory.eINSTANCE.createIfcReal();
		float valFloat = 0;
		try
		{
			valFloat = Float.parseFloat(valString);
		}
		catch(Exception ex)
		{
			valFloat = 0;
		}
		valReal.setWrappedValue(valFloat);
		valReal.setWrappedValueAsString(Float.toString(valFloat));
		return valReal;
	}

	public static IfcLabel initializeLabel(String text)
	{
		IfcLabel newLabel =
				Ifc2x3tc1Factory.eINSTANCE.createIfcLabel();
		newLabel.setWrappedValue(text);
		return newLabel;
	}

	public static boolean shouldSetProperty(String name, String value)
	{
		boolean shouldSet = true;
		if (COBieUtility.isNA(value) || value.equals(name))
			shouldSet = false;
		return shouldSet;
	}

	public static boolean shouldSetProperty(String propertyName, IfcValue value)
	{
		boolean shouldSet = true;
		if (value instanceof IfcLabel)
		{
			IfcLabel lbl = (IfcLabel) value;
			String strLbl = lbl.getWrappedValue();
			shouldSet = shouldSetProperty(propertyName,strLbl);
		}
		else if (value instanceof IfcText)
		{
			IfcText lbl = (IfcText) value;
			String strTxt= lbl.getWrappedValue();
			shouldSet = shouldSetProperty(propertyName,strTxt);
		}
		return shouldSet;
	}

	public static IfcPropertyEnumeratedValue enumeratedValueFromString(String cobieValueString, String cobieAllowedValsString,
			String propertyName,String propertyDescription) throws Exception
	{
		String exceptionMsg = getAllowedValueExceptionMessage();
		Exception exception = new Exception(exceptionMsg);
		IfcPropertyEnumeratedValue enumeratedValue = Ifc2x3tc1Factory.eINSTANCE.createIfcPropertyEnumeratedValue();
		IfcPropertyEnumeration enumeration = Ifc2x3tc1Factory.eINSTANCE.createIfcPropertyEnumeration();
		enumeratedValue.setName(propertyName);
		enumeratedValue.setDescription(propertyDescription);
		enumeration.setName(propertyName + getEnumerationNameSuffix());
		if (COBieUtility.isNA(cobieAllowedValsString))
			throw exception;
		String[] splitAllowedVals = cobieAllowedValsString.split(COBieUtility.getCOBieDelim());
		ArrayList<String> allowedValsList = new ArrayList<String>(Arrays.asList(splitAllowedVals));
		try
		{
			populateEnumeration(enumeration,splitAllowedVals);
			popoulateEnumerationValues(enumeratedValue,cobieValueString,allowedValsList);	
		}
		catch(Exception e)
		{
			throw e;
		}
		return enumeratedValue;
	}
	
	private static void popoulateEnumerationValues(IfcPropertyEnumeratedValue enumValue, 
			String valueString,ArrayList<String> allowedValues) throws Exception
	{
		String[] splitVals = valueString.split(COBieUtility.getCOBieDelim());
		Exception valException =
				new Exception(PropertyUtility.INVALID_VALUE_EXCEPTION_MSG);
		if (allowedValues.contains(valueString))
		{
			enumValue.getEnumerationValues().add(valueFromString(valueString));
		}
		else
		{
			if (splitVals!=null && splitVals.length>1)
			{
				ArrayList<String> valList = 
						new ArrayList<String>(Arrays.asList(splitVals));
				if (allowedValues.containsAll(valList))
				{
					for(String splitStr : splitVals)
					{
						enumValue.getEnumerationValues().add(valueFromString(splitStr));
					}
				}
				else
					throw valException;
			}
			else
				throw valException;
		}
	}
	
	protected static IfcValue valueFromString(String valueString)
	{
		try
		{
			Double.parseDouble(valueString);
			IfcReal realVal = initializeRealToStringVal(valueString);
			return realVal;
		}
		catch(Exception e)
		{
			IfcText txtVal = initializeText(valueString);
			return txtVal;
		}
	}
	
	public static void populateEnumeration(IfcPropertyEnumeration enumeration, String[] valueStrings) throws Exception
	{
		if (valueStrings!=null && valueStrings.length > getAllowedValuesCountLowerBound())
		{
			if (allStringsAreNumbers(valueStrings))
			{
				for(String valString : valueStrings)
				{
					enumeration.getEnumerationValues().add(initializeRealToStringVal(valString));
				}
			}
			else
			{
				for(String valString : valueStrings)
				{
					enumeration.getEnumerationValues().add(initializeText(valString));
				}
			}
		}
		else
			throw new Exception(PropertyUtility.getAllowedValueExceptionMessage());
	}
	
	public static boolean isCandidateEnumeration(String valueString,String allowedValString)
	{
		String[] allowedValsSplit = allowedValString.split(COBieUtility.getCOBieDelim());
		boolean allowedValuesValid = 
				(allowedValsSplit!=null && allowedValsSplit.length > 
				getAllowedValuesCountLowerBound());
		boolean isCandidateEnum = false;
		boolean valueStringInEnum;
		if (allowedValuesValid)
		{
			ArrayList<String> allowedValsList =  new ArrayList<String>(Arrays.asList(allowedValsSplit));
			String[] valueSplit = valueString.split(COBieUtility.getCOBieDelim());
			valueStringInEnum = allowedValsList.contains(valueString);
			if (valueStringInEnum)
				isCandidateEnum = true;
			else if (valueSplit!=null && valueSplit.length>1)
			{
				valueStringInEnum = true;
				for(String tmpStr : valueSplit)
				{
					if (!(allowedValsList.contains(tmpStr)))
							valueStringInEnum = false;
				}
			}
			isCandidateEnum = valueStringInEnum;
		}
		else
			isCandidateEnum = false;
		return isCandidateEnum;
		
	}
	
	public static boolean allStringsAreNumbers(String[] stringArray)
	{
		boolean allNumbers = true;
		for(String tmpString : stringArray)
		{
			try
			{
				Double.parseDouble(tmpString);
			}
			catch(Exception e)
			{
				allNumbers = false;
			}
		}
		return allNumbers;
	}
	
	public static IfcText initializeText(String text)
	{
		IfcText newText =
				Ifc2x3tc1Factory.eINSTANCE.createIfcText();
		newText.setWrappedValue(text);
		return newText;
	}

	protected static void setIfcPhysicalSimpleQuantityValue(IfcPhysicalSimpleQuantity quantity,
			float value)
	{
	
		if (quantity instanceof IfcQuantityLength)
		{
			IfcQuantityLength qL = (IfcQuantityLength) quantity;
			qL.setLengthValue(value);
		}
		else if (quantity instanceof IfcQuantityArea)
		{
			IfcQuantityArea qA = (IfcQuantityArea) quantity;
			qA.setAreaValue(value);
	
		}
		else if (quantity instanceof IfcQuantityVolume)
		{
			IfcQuantityVolume qV = (IfcQuantityVolume) quantity;
			qV.setVolumeValue(value);
		}
		else if (quantity instanceof IfcQuantityCount)
		{
			IfcQuantityCount qC = (IfcQuantityCount) quantity;
			qC.setCountValue(value);
		}
		else if (quantity instanceof IfcQuantityWeight)
		{
			IfcQuantityWeight qW = (IfcQuantityWeight) quantity;
			qW.setWeightValue(value);
		}
		else if (quantity instanceof IfcQuantityTime)
		{
			IfcQuantityTime qT = (IfcQuantityTime) quantity;
			qT.setTimeValue(value);
		}
	
	}

	public static String getAllowedValueExceptionMessage()
	{
		return ALLOWED_VALUE_EXCEPTION_MESSAGE;
	}

	public static String getEnumerationNameSuffix()
	{
		return ENUMERATION_NAME_SUFFIX;
	}

	public static int getBoundedValuesStringSplitLowerBound()
	{
		return BOUNDED_VALUES_STRING_SPLIT_LOWER_BOUND;
	}

	public static int getAllowedValuesCountLowerBound()
	{
		return ALLOWED_VALUES_COUNT_LOWER_BOUND;
	}
}
