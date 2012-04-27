package org.bimserver.cobie.utils.stringwriters;
/******************************************************************************
 * Copyright (C) 2011  ERDC
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
import org.bimserver.models.ifc2x3tc1.IfcAmountOfSubstanceMeasure;
import org.bimserver.models.ifc2x3tc1.IfcAreaMeasure;
import org.bimserver.models.ifc2x3tc1.IfcBoolean;
import org.bimserver.models.ifc2x3tc1.IfcContextDependentMeasure;
import org.bimserver.models.ifc2x3tc1.IfcCountMeasure;
import org.bimserver.models.ifc2x3tc1.IfcDerivedMeasureValue;
import org.bimserver.models.ifc2x3tc1.IfcDescriptiveMeasure;
import org.bimserver.models.ifc2x3tc1.IfcElectricCurrentMeasure;
import org.bimserver.models.ifc2x3tc1.IfcIdentifier;
import org.bimserver.models.ifc2x3tc1.IfcLabel;
import org.bimserver.models.ifc2x3tc1.IfcLengthMeasure;
import org.bimserver.models.ifc2x3tc1.IfcLogical;
import org.bimserver.models.ifc2x3tc1.IfcLuminousIntensityMeasure;
import org.bimserver.models.ifc2x3tc1.IfcMassMeasure;
import org.bimserver.models.ifc2x3tc1.IfcMeasureValue;
import org.bimserver.models.ifc2x3tc1.IfcNormalisedRatioMeasure;
import org.bimserver.models.ifc2x3tc1.IfcNumericMeasure;
import org.bimserver.models.ifc2x3tc1.IfcParameterValue;
import org.bimserver.models.ifc2x3tc1.IfcPhysicalSimpleQuantity;
import org.bimserver.models.ifc2x3tc1.IfcPlaneAngleMeasure;
import org.bimserver.models.ifc2x3tc1.IfcPositiveLengthMeasure;
import org.bimserver.models.ifc2x3tc1.IfcPositivePlaneAngleMeasure;
import org.bimserver.models.ifc2x3tc1.IfcPositiveRatioMeasure;
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

public  class IfcPropertyToCOBieString 
{
	private String propertySetString;
	private String propertySetGlobalIDString;
	private String valueString;
	private static final String numFormatString = "%.3f";
	private String propertyNameString;
	private String propertyTypeString;
	private IfcSimpleProperty property;
	private IfcPhysicalSimpleQuantity quantity;
	
	
	
	public IfcPropertyToCOBieString()
	{
		super();
		
	}

	public IfcPropertyToCOBieString(IfcSimpleProperty property)
	{
		super();
		setProperty(property);
		setPropertyNameString(property.getName());	
	}
	
	public IfcPropertyToCOBieString(IfcPhysicalSimpleQuantity sQuantity)
	{
		super();
		setQuantity(sQuantity);
		setPropertyNameString(sQuantity.getName());		
		setValueString(sQuantity);
	}
	
	public String getValueString() 
	{
		return valueString;
	}
	protected void setValueString(String valueString) 
	{
		this.valueString = valueString;
	}
	
	protected void setValueString(IfcValue value)
	{
		this.valueString = "";
		if (value instanceof IfcSimpleValue)
			this.valueString = getSimpleValueString((IfcSimpleValue)value);
		else if (value instanceof IfcMeasureValue)
			this.valueString = getMeasureValueString((IfcMeasureValue)value);
		else if (value instanceof IfcDerivedMeasureValue)
			this.valueString = getDerivedMeasureValue((IfcDerivedMeasureValue)value);
		
	}
	
	public static String getValueStringFromValue(IfcValue value)
	{
		String valueString = "";
		if (value instanceof IfcSimpleValue)
			valueString = getSimpleValueString((IfcSimpleValue)value);
		else if (value instanceof IfcMeasureValue)
			valueString = getMeasureValueString((IfcMeasureValue)value);
		else if (value instanceof IfcDerivedMeasureValue)
			valueString = getDerivedMeasureValue((IfcDerivedMeasureValue)value);
		return valueString;
		
	}
	
	protected void setValueString(IfcPhysicalSimpleQuantity quantity)
	{
		this.valueString="";
		float tmpFloat=0;
		if (quantity instanceof IfcQuantityLength)
		{
			IfcQuantityLength qL = (IfcQuantityLength) quantity;
			tmpFloat = (float) qL.getLengthValue();		
			this.valueString = Float.toString(tmpFloat);
		}
		else if (quantity instanceof IfcQuantityArea)
		{
			IfcQuantityArea qA = (IfcQuantityArea) quantity;
			tmpFloat = (float) qA.getAreaValue();
			this.valueString = Float.toString(tmpFloat);
		}
		else if (quantity instanceof IfcQuantityVolume)
		{
			IfcQuantityVolume qV = (IfcQuantityVolume) quantity;
			tmpFloat = (float) qV.getVolumeValue();
			this.valueString = Float.toString(tmpFloat);
		}
		else if (quantity instanceof IfcQuantityCount)
		{
			IfcQuantityCount qC = (IfcQuantityCount) quantity;
			tmpFloat = (float) qC.getCountValue();
			this.valueString = Float.toString(tmpFloat);
		}
		else if (quantity instanceof IfcQuantityWeight)
		{
			IfcQuantityWeight qW = (IfcQuantityWeight) quantity;
			tmpFloat = (float) qW.getWeightValue();
			this.valueString = Float.toString(tmpFloat);
		}
		else if (quantity instanceof IfcQuantityTime)
		{
			IfcQuantityTime qT = (IfcQuantityTime) quantity;
			tmpFloat = (float) qT.getTimeValue();
			this.valueString = Float.toString(tmpFloat);
		}
		if (this.valueString.length()>0)
		{
			this.valueString = String.format(numFormatString, tmpFloat);
		}
		else
			this.valueString = "0";

	}
	
	private static String getDerivedMeasureValue(IfcDerivedMeasureValue value) 
	{
		String valString = "";

		return valString;
	}

	public String getPropertyNameString() 
	{
		return propertyNameString;
	}
	private void setPropertyNameString(String propertyName) 
	{
		this.propertyNameString = propertyName;
	}
	public String getPropertyTypeString() 
	{
		return propertyTypeString;
	}
	
	protected void setPropertyTypeString(String propertyType) 
	{
		this.propertyTypeString = propertyType;
	}
	
	private static String getSimpleValueString(IfcSimpleValue value)
	{
		String valString = "";
		if (value instanceof IfcLabel)
		{
			IfcLabel label = (IfcLabel) value;
			valString = label.getWrappedValue();
		}
		else if (value instanceof IfcReal)
		{
			IfcReal rl = (IfcReal) value;
			valString = String.format(numFormatString, rl.getWrappedValue());
			//valString = rl.getWrappedValueAsString();
		}
		else if (value instanceof IfcBoolean)
		{
			IfcBoolean bl = (IfcBoolean) value;
			valString = bl.getWrappedValue().getLiteral();
		}
		else if (value instanceof IfcIdentifier)
		{
			IfcIdentifier id = (IfcIdentifier) value;
			valString = id.getWrappedValue();
		}
		else if (value instanceof IfcText)
		{
			IfcText txt = (IfcText) value;
			valString = txt.getWrappedValue();
		}
		else if (value instanceof IfcLogical)
		{
			IfcLogical lg = (IfcLogical)  value;
			valString = lg.getWrappedValue().getLiteral();
		}
		return valString;
	}
	
	private static String getMeasureValueString(IfcMeasureValue value)
	{
		String valString = "";
		boolean isText = false;
		float tmpFloat = 0;
		if (value instanceof IfcAmountOfSubstanceMeasure) {
			IfcAmountOfSubstanceMeasure sm = (IfcAmountOfSubstanceMeasure) value;
			tmpFloat = (float) sm.getWrappedValue();
			valString = String.valueOf(tmpFloat);
		}
		if (value instanceof IfcAreaMeasure) {
			IfcAreaMeasure am = (IfcAreaMeasure) value;
			tmpFloat = (float) am.getWrappedValue();
			valString = String.valueOf(tmpFloat);
		}
		if (value instanceof IfcContextDependentMeasure) {
			IfcContextDependentMeasure cm = (IfcContextDependentMeasure) value;
			tmpFloat = (float) cm.getWrappedValue();
			valString = String.valueOf(tmpFloat);
		}
		if (value instanceof IfcCountMeasure) {
			IfcCountMeasure cntm = (IfcCountMeasure) value;
			tmpFloat = (float) cntm.getWrappedValue();
			valString = String.valueOf(tmpFloat);
		}
		if (value instanceof IfcDescriptiveMeasure) {
			IfcDescriptiveMeasure dm = (IfcDescriptiveMeasure) value;
			isText = true;
			//tmpFloat = dm.getWrappedValue();
			valString = dm.getWrappedValue();
		}
		if (value instanceof IfcElectricCurrentMeasure) {
			IfcElectricCurrentMeasure em = (IfcElectricCurrentMeasure) value;
			tmpFloat = (float) em.getWrappedValue();
			valString = String.valueOf(tmpFloat);
		}
		if (value instanceof IfcLengthMeasure) {
			IfcLengthMeasure lm = (IfcLengthMeasure) value;
			tmpFloat = (float) lm.getWrappedValue();
			valString = String.valueOf(tmpFloat);
		}
		if (value instanceof IfcLuminousIntensityMeasure) {
			IfcLuminousIntensityMeasure lum = (IfcLuminousIntensityMeasure) value;
			tmpFloat = (float) lum.getWrappedValue();
			valString = String.valueOf(tmpFloat);
		}
		if (value instanceof IfcMassMeasure) {
			IfcMassMeasure mm = (IfcMassMeasure) value;
			tmpFloat = (float) mm.getWrappedValue();
			valString = String.valueOf(tmpFloat);
		}
		if (value instanceof IfcNormalisedRatioMeasure) {
			IfcNormalisedRatioMeasure nm = (IfcNormalisedRatioMeasure) value;
			tmpFloat = (float) nm.getWrappedValue();
			valString = String.valueOf(tmpFloat);
		}
		if (value instanceof IfcNumericMeasure) {
			IfcNumericMeasure num = (IfcNumericMeasure) value;
			tmpFloat = (float) num.getWrappedValue();
			valString = String.valueOf(tmpFloat);
		}
		if (value instanceof IfcParameterValue) {
			IfcParameterValue pm = (IfcParameterValue) value;
			tmpFloat = (float) pm.getWrappedValue();
			valString = String.valueOf(tmpFloat);
		}
		if (value instanceof IfcPlaneAngleMeasure) {
			IfcPlaneAngleMeasure plm = (IfcPlaneAngleMeasure) value;
			tmpFloat = (float) plm.getWrappedValue();
			valString = String.valueOf(tmpFloat);
		}
		if (value instanceof IfcPositiveLengthMeasure) {
			IfcPositiveLengthMeasure pom = (IfcPositiveLengthMeasure) value;
			tmpFloat = (float) pom.getWrappedValue();
			valString = String.valueOf(tmpFloat);
		}
		if (value instanceof IfcPositivePlaneAngleMeasure) {
			IfcPositivePlaneAngleMeasure poam = (IfcPositivePlaneAngleMeasure) value;
			tmpFloat = (float) poam.getWrappedValue();
			valString = String.valueOf(tmpFloat);
		}
		if (value instanceof IfcPositiveRatioMeasure) {
			IfcPositiveRatioMeasure porm = (IfcPositiveRatioMeasure) value;
			tmpFloat = (float) porm.getWrappedValue();
			valString = String.valueOf(tmpFloat);
		}
		if (value instanceof IfcRatioMeasure) {
			IfcRatioMeasure ram = (IfcRatioMeasure) value;
			tmpFloat = (float) ram.getWrappedValue();
			valString = String.valueOf(tmpFloat);
		}
		if (value instanceof IfcSolidAngleMeasure) {
			IfcSolidAngleMeasure som = (IfcSolidAngleMeasure) value;
			tmpFloat = (float) som.getWrappedValue();
			valString = String.valueOf(tmpFloat);
		}
		if (value instanceof IfcThermodynamicTemperatureMeasure) {
			IfcThermodynamicTemperatureMeasure ttm = (IfcThermodynamicTemperatureMeasure) value;
			tmpFloat = (float) ttm.getWrappedValue();
			valString = String.valueOf(tmpFloat);
		}
		if (value instanceof IfcTimeMeasure) {
			IfcTimeMeasure tim = (IfcTimeMeasure) value;
			tmpFloat = (float) tim.getWrappedValue();
			valString = String.valueOf(tmpFloat);
		}
		if (value instanceof IfcVolumeMeasure) {
			IfcVolumeMeasure vm = (IfcVolumeMeasure) value;
			tmpFloat = (float) vm.getWrappedValue();
			valString = String.valueOf(tmpFloat);
		}
		if (valString.length()>0 && !isText)
		{
			valString = String.format(numFormatString, tmpFloat);
		}
		else if (!isText)
			valString = "0";
		return valString;
	}

	
	public IfcSimpleProperty getProperty() 
	{
		return property;
	}

	public void setProperty(IfcSimpleProperty property) 
	{
		this.property = property;
	}

	public IfcPhysicalSimpleQuantity getQuantity() {
		return quantity;
	}

	public void setQuantity(IfcPhysicalSimpleQuantity quantity) {
		this.quantity = quantity;
	}	
	
	public String getDescriptionString()
	{
		String description = "";
		try
		{
			description = this.property.getDescription();
		}
		catch(Exception ex)
		{
			
		}
		if (description==null || description.length()==0)
			description = this.propertyNameString;
		return description;
	}

	public String getPropertySetString() {
		return propertySetString;
	}

	public void setPropertySetString(String propertySetString) {
		this.propertySetString = propertySetString;
	}

	public String getPropertySetGlobalIDString() {
		return propertySetGlobalIDString;
	}

	public void setPropertySetGlobalIDString(String propertySetGlobalIDString) {
		this.propertySetGlobalIDString = propertySetGlobalIDString;
	}
	
}
