package org.bimserver.shared.cobie.targetunits;

import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.IfcConversionBasedUnit;
import org.bimserver.models.ifc2x3tc1.IfcDimensionalExponents;
import org.bimserver.models.ifc2x3tc1.IfcMeasureWithUnit;
import org.bimserver.models.ifc2x3tc1.IfcReal;
import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;
import org.bimserver.shared.cobie.COBieUtility;

public abstract class ConversionBasedUnitTextMatcher extends
		UnitTextMatcher
{


	private static final int TIME_UNIT_EXPONENT = 1;
	private static final int VOLUME_UNIT_EXPONENT = 3;
	private static final int MASS_UNIT_EXPONENT = 1;
	private static final int LENGTH_UNIT_EXPONENT = 1;
	private static final int AREA_UNIT_EXPONENT = 2;
	private static final int DIMENSION_EXPONENTS_DEFAULT = 1;
	public ConversionBasedUnitTextMatcher(String searchString)
	{
		super(searchString);
	}
	
	protected abstract  IfcReal getConversionFactorValue();
	
	protected abstract  String getUnitName();
	
	protected abstract  IfcUnit getConversionFactorUnit();
	
	protected  abstract IfcUnitEnum getUnitType();

	@Override
	public final IfcUnit getTargetUnit()
	{
		IfcConversionBasedUnit convUnit =
				Ifc2x3tc1Factory.eINSTANCE.createIfcConversionBasedUnit();
		IfcDimensionalExponents exponents =
				getDimensionalExponents();
		convUnit.setDimensions(exponents);
		convUnit.setName(getUnitName());
		convUnit.setUnitType(getUnitType());
		IfcUnit conversionFactorUnit =
				getConversionFactorUnit();
		IfcMeasureWithUnit measureWithUnit =
				COBieUtility.ifcFactory.createIfcMeasureWithUnit();
		measureWithUnit.setUnitComponent(conversionFactorUnit);
		measureWithUnit.setValueComponent(getConversionFactorValue());
		convUnit.setConversionFactor(measureWithUnit);
		return convUnit;
	}

	private void setAllExponentsTo(IfcDimensionalExponents exponents,int exponentVal)
	{
		exponents.setAmountOfSubstanceExponent(exponentVal);
		exponents.setElectricCurrentExponent(exponentVal);
		exponents.setLengthExponent(exponentVal);
		exponents.setLuminousIntensityExponent(exponentVal);
		exponents.setMassExponent(exponentVal);
		exponents.setThermodynamicTemperatureExponent(exponentVal);
		exponents.setTimeExponent(exponentVal);
	}
	private IfcDimensionalExponents getDimensionalExponents()
	{
		IfcDimensionalExponents exponents =
				COBieUtility.ifcFactory.createIfcDimensionalExponents();
		setAllExponentsTo(exponents,DIMENSION_EXPONENTS_DEFAULT);
		switch(getUnitType())
		{
		case AREAUNIT:
			exponents.setLengthExponent(AREA_UNIT_EXPONENT);
			break;

		case LENGTHUNIT:
			exponents.setLengthExponent(LENGTH_UNIT_EXPONENT);
			break;
	
		case MASSUNIT:
			exponents.setMassExponent(MASS_UNIT_EXPONENT);
			break;
		
		case TIMEUNIT:
			exponents.setTimeExponent(TIME_UNIT_EXPONENT);
			break;

		case VOLUMEUNIT:
			exponents.setLengthExponent(VOLUME_UNIT_EXPONENT);
			break;
		
		}
		return exponents;
		
	}


	@Override
	protected abstract String[] getTargetStringArray();

}
