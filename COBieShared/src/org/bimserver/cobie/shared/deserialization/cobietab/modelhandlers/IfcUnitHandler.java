package org.bimserver.cobie.shared.deserialization.cobietab.modelhandlers;

import org.bimserver.cobie.shared.utility.COBieIfcUtility;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.IfcContextDependentUnit;
import org.bimserver.models.ifc2x3tc1.IfcDimensionalExponents;
import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;

public class IfcUnitHandler
{

    private static final IfcUnitEnum DEFAULT_CONTEXT_DEPENDENT_UNIT_TYPE = IfcUnitEnum.USERDEFINED;
  
    private static IfcUnit getAreaUnitFromString(String unitString)
    {
        // TODO Auto-generated method stub
        return null;
    }

    public static IfcContextDependentUnit getContextDependentUnitFromString(String unitString)
    {
        IfcContextDependentUnit unit = Ifc2x3tc1Factory.eINSTANCE.createIfcContextDependentUnit();
        unit.setName(unitString);
        unit.setUnitType(DEFAULT_CONTEXT_DEPENDENT_UNIT_TYPE);
        IfcDimensionalExponents exponents = COBieIfcUtility.ifcFactory.createIfcDimensionalExponents();
        setAllExponentsTo(exponents, 1);
        unit.setDimensions(exponents);
        return unit;
    }

    public static IfcContextDependentUnit getContextDependentUnitFromStringAndUnitType(String unitString, IfcUnitEnum unitType)
    {
        IfcContextDependentUnit unit = Ifc2x3tc1Factory.eINSTANCE.createIfcContextDependentUnit();
        unit.setName(unitString);
        unit.setUnitType(unitType);
        IfcDimensionalExponents exponents = COBieIfcUtility.ifcFactory.createIfcDimensionalExponents();
        setAllExponentsTo(exponents, 1);
        unit.setDimensions(exponents);
        return unit;
    }

    private static void setAllExponentsTo(IfcDimensionalExponents exponents, int exponentVal)
    {
        exponents.setAmountOfSubstanceExponent(exponentVal);
        exponents.setElectricCurrentExponent(exponentVal);
        exponents.setLengthExponent(exponentVal);
        exponents.setLuminousIntensityExponent(exponentVal);
        exponents.setMassExponent(exponentVal);
        exponents.setThermodynamicTemperatureExponent(exponentVal);
        exponents.setTimeExponent(exponentVal);
    }


    private static IfcUnit getFrequencyUnitFromString(String unitString)
    {
        // TODO Auto-generated method stub
        return null;
    }

    private static IfcUnit getLengthUnitFromString(String unitString)
    {
        // TODO Auto-generated method stub
        return null;
    }

    private static IfcUnit getMassUnitFromString(String unitString)
    {
        // TODO Auto-generated method stub
        return null;
    }

    private static IfcUnit getTimeUnitFromString(String unitString)
    {
        // TODO Auto-generated method stub
        return null;
    }

    private static IfcUnit getUnitUnknown(String unitString)
    {
        return getContextDependentUnitFromString(unitString);
    }

    private static IfcUnit getVolumeUnitFromString(String unitString)
    {
        // TODO Auto-generated method stub
        return null;
    }

    public static IfcUnit unitFromStringAndUnitType(String unitString, IfcUnitEnum unitType)
    {
        IfcUnit unit = null;
        switch (unitType)
        {
            case ABSORBEDDOSEUNIT:
                break;
            case AMOUNTOFSUBSTANCEUNIT:
                break;
            case AREAUNIT:
                unit = getAreaUnitFromString(unitString);
                break;
            case DOSEEQUIVALENTUNIT:
                break;
            case ELECTRICCAPACITANCEUNIT:
                break;
            case ELECTRICCHARGEUNIT:
                break;
            case ELECTRICCONDUCTANCEUNIT:
                break;
            case ELECTRICCURRENTUNIT:
                break;
            case ELECTRICRESISTANCEUNIT:
                break;
            case ELECTRICVOLTAGEUNIT:
                break;
            case ENERGYUNIT:
                break;
            case FORCEUNIT:
                break;
            case FREQUENCYUNIT:
                unit = getFrequencyUnitFromString(unitString);
                break;
            case ILLUMINANCEUNIT:
                break;
            case INDUCTANCEUNIT:
                break;
            case LENGTHUNIT:
                unit = getLengthUnitFromString(unitString);
                break;
            case LUMINOUSFLUXUNIT:
                break;
            case LUMINOUSINTENSITYUNIT:
                break;
            case MAGNETICFLUXDENSITYUNIT:
                break;
            case MAGNETICFLUXUNIT:
                break;
            case MASSUNIT:
                unit = getMassUnitFromString(unitString);
                break;
            case NULL:
                unit = getUnitUnknown(unitString);
                break;
            case PLANEANGLEUNIT:
                break;
            case POWERUNIT:
                break;
            case PRESSUREUNIT:
                break;
            case RADIOACTIVITYUNIT:
                break;
            case SOLIDANGLEUNIT:
                break;
            case THERMODYNAMICTEMPERATUREUNIT:
                break;
            case TIMEUNIT:
                unit = getTimeUnitFromString(unitString);
                break;
            case USERDEFINED:
                unit = getUnitUnknown(unitString);
                break;
            case VOLUMEUNIT:
                unit = getVolumeUnitFromString(unitString);
                break;
        }
        if (unit == null)
        {
            unit = getUnitUnknown(unitString);
        }
        return unit;
    }

}
