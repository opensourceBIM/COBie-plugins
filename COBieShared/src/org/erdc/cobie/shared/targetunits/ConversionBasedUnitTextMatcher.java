package org.erdc.cobie.shared.targetunits;

import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.IfcConversionBasedUnit;
import org.bimserver.models.ifc2x3tc1.IfcDimensionalExponents;
import org.bimserver.models.ifc2x3tc1.IfcMeasureWithUnit;
import org.bimserver.models.ifc2x3tc1.IfcReal;
import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.shared.utils.exceptions.NotImplementedException;

public abstract class ConversionBasedUnitTextMatcher extends UnitTextMatcher
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

    protected abstract IfcUnit getConversionFactorUnit();

    protected abstract IfcReal getConversionFactorValue();

    private IfcDimensionalExponents getDimensionalExponents()
    {
        IfcDimensionalExponents exponents = COBieUtility.ifcFactory.createIfcDimensionalExponents();
        setAllExponentsTo(exponents, DIMENSION_EXPONENTS_DEFAULT);
        switch (getUnitType())
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
            case ABSORBEDDOSEUNIT:    
                throw new NotImplementedException();
            case AMOUNTOFSUBSTANCEUNIT:
                throw new NotImplementedException();
            case DOSEEQUIVALENTUNIT:
                throw new NotImplementedException();
            case ELECTRICCAPACITANCEUNIT:
                throw new NotImplementedException();
            case ELECTRICCHARGEUNIT:
                throw new NotImplementedException();
            case ELECTRICCONDUCTANCEUNIT:
                throw new NotImplementedException();
            case ELECTRICCURRENTUNIT:
                throw new NotImplementedException();
            case ELECTRICRESISTANCEUNIT:
                throw new NotImplementedException();
            case ELECTRICVOLTAGEUNIT:
                throw new NotImplementedException();
            case ENERGYUNIT:
                throw new NotImplementedException();
            case FORCEUNIT:
                throw new NotImplementedException();
            case FREQUENCYUNIT:
                throw new NotImplementedException();
            case ILLUMINANCEUNIT:
                throw new NotImplementedException();
            case INDUCTANCEUNIT:
                throw new NotImplementedException();
            case LUMINOUSFLUXUNIT:
                throw new NotImplementedException();
            case LUMINOUSINTENSITYUNIT:
                throw new NotImplementedException();
            case MAGNETICFLUXDENSITYUNIT:
                throw new NotImplementedException();
            case MAGNETICFLUXUNIT:
                throw new NotImplementedException();
            case NULL:
                throw new NotImplementedException();
            case PLANEANGLEUNIT:
                throw new NotImplementedException();
            case POWERUNIT:
                throw new NotImplementedException();
            case PRESSUREUNIT:
                throw new NotImplementedException();
            case RADIOACTIVITYUNIT:
                throw new NotImplementedException();
            case SOLIDANGLEUNIT:
                throw new NotImplementedException();
            case THERMODYNAMICTEMPERATUREUNIT:
                throw new NotImplementedException();
            case USERDEFINED:
                throw new NotImplementedException();
            default:
                throw new NotImplementedException();

        }
        return exponents;

    }

    @Override
    protected abstract String[] getTargetStringArray();

    @Override
    public final IfcUnit getTargetUnit()
    {
        IfcConversionBasedUnit convUnit = Ifc2x3tc1Factory.eINSTANCE.createIfcConversionBasedUnit();
        IfcDimensionalExponents exponents = getDimensionalExponents();
        convUnit.setDimensions(exponents);
        convUnit.setName(getUnitName());
        convUnit.setUnitType(getUnitType());
        IfcUnit conversionFactorUnit = getConversionFactorUnit();
        IfcMeasureWithUnit measureWithUnit = COBieUtility.ifcFactory.createIfcMeasureWithUnit();
        measureWithUnit.setUnitComponent(conversionFactorUnit);
        measureWithUnit.setValueComponent(getConversionFactorValue());
        convUnit.setConversionFactor(measureWithUnit);
        return convUnit;
    }

    protected abstract String getUnitName();

    protected abstract IfcUnitEnum getUnitType();

    private void setAllExponentsTo(IfcDimensionalExponents exponents, int exponentVal)
    {
        exponents.setAmountOfSubstanceExponent(exponentVal);
        exponents.setElectricCurrentExponent(exponentVal);
        exponents.setLengthExponent(exponentVal);
        exponents.setLuminousIntensityExponent(exponentVal);
        exponents.setMassExponent(exponentVal);
        exponents.setThermodynamicTemperatureExponent(exponentVal);
        exponents.setTimeExponent(exponentVal);
    }

}
