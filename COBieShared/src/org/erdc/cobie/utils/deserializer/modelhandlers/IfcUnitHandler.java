package org.erdc.cobie.utils.deserializer.modelhandlers;

import java.util.ArrayList;
import java.util.Arrays;

import org.bimserver.emf.OidProvider;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.IfcContextDependentUnit;
import org.bimserver.models.ifc2x3tc1.IfcDimensionalExponents;
import org.bimserver.models.ifc2x3tc1.IfcSIUnitName;
import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.utils.deserializer.COBieIfcModel;

public class IfcUnitHandler
{

    private static final IfcUnitEnum DEFAULT_CONTEXT_DEPENDENT_UNIT_TYPE = IfcUnitEnum.USERDEFINED;
    private static ArrayList<String> SI_LENGTH_SUFFIXES = new ArrayList<String>(Arrays.asList("meter", IfcSIUnitName.METRE.name(), "meters", "metre"));

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
        IfcDimensionalExponents exponents = COBieUtility.ifcFactory.createIfcDimensionalExponents();
        setAllExponentsTo(exponents, 1);
        unit.setDimensions(exponents);
        return unit;
    }

    public static IfcContextDependentUnit getContextDependentUnitFromStringAndUnitType(String unitString, IfcUnitEnum unitType)
    {
        IfcContextDependentUnit unit = Ifc2x3tc1Factory.eINSTANCE.createIfcContextDependentUnit();
        unit.setName(unitString);
        unit.setUnitType(unitType);
        IfcDimensionalExponents exponents = COBieUtility.ifcFactory.createIfcDimensionalExponents();
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

    public IfcUnitHandler(OidProvider oidProvider, COBieIfcModel model, IfcGuidHandler guidHandler)
    {
    }

    private IfcUnit getFrequencyUnitFromString(String unitString)
    {
        // TODO Auto-generated method stub
        return null;
    }

    private IfcUnit getLengthUnitFromString(String unitString)
    {
        // TODO Auto-generated method stub
        return null;
    }

    private IfcUnit getMassUnitFromString(String unitString)
    {
        // TODO Auto-generated method stub
        return null;
    }

    private IfcUnit getTimeUnitFromString(String unitString)
    {
        // TODO Auto-generated method stub
        return null;
    }

    private IfcUnit getUnitUnknown(String unitString)
    {
        return getContextDependentUnitFromString(unitString);
    }

    private IfcUnit getVolumeUnitFromString(String unitString)
    {
        // TODO Auto-generated method stub
        return null;
    }

    public IfcUnit unitFromStringAndUnitType(String unitString, IfcUnitEnum unitType)
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
