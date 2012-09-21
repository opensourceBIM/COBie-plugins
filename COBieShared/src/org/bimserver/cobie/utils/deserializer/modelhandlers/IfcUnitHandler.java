package org.bimserver.cobie.utils.deserializer.modelhandlers;

import java.util.ArrayList;
import java.util.Arrays;

import org.bimserver.cobie.utils.deserializer.COBieIfcModel;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.IfcContextDependentUnit;
import org.bimserver.models.ifc2x3tc1.IfcDimensionalExponents;
import org.bimserver.models.ifc2x3tc1.IfcSIUnit;
import org.bimserver.models.ifc2x3tc1.IfcSIUnitName;
import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;
import org.bimserver.plugins.serializers.OidProvider;
import org.bimserver.shared.cobie.COBieUtility;

public class IfcUnitHandler
{

	private static final IfcUnitEnum DEFAULT_CONTEXT_DEPENDENT_UNIT_TYPE = IfcUnitEnum.USERDEFINED;
	private OidProvider cobieOidProvider;
	private COBieIfcModel model;
	private IfcGuidHandler cobieGuidHandler;
	private static ArrayList<String> SI_LENGTH_SUFFIXES = new ArrayList<String>
		(Arrays.asList("meter",IfcSIUnitName.METRE.name(),"meters","metre"));

	public IfcUnitHandler(OidProvider oidProvider,COBieIfcModel model,IfcGuidHandler guidHandler)
	{
		this.cobieOidProvider = oidProvider;
		this.model = model;
		this.cobieGuidHandler = guidHandler;
	}
	

	public  static IfcContextDependentUnit getContextDependentUnitFromString(
			String unitString)
	{
		IfcContextDependentUnit unit = Ifc2x3tc1Factory.eINSTANCE.createIfcContextDependentUnit();
		unit.setName(unitString);
		unit.setUnitType(DEFAULT_CONTEXT_DEPENDENT_UNIT_TYPE);
		IfcDimensionalExponents exponents =
				COBieUtility.ifcFactory.createIfcDimensionalExponents();
		setAllExponentsTo(exponents,1);
		unit.setDimensions(exponents);
		return unit;
	}
	
	public  static IfcContextDependentUnit getContextDependentUnitFromStringAndUnitType(
			String unitString,IfcUnitEnum unitType)
	{
		IfcContextDependentUnit unit = Ifc2x3tc1Factory.eINSTANCE.createIfcContextDependentUnit();
		unit.setName(unitString);
		unit.setUnitType(unitType);
		IfcDimensionalExponents exponents =
				COBieUtility.ifcFactory.createIfcDimensionalExponents();
		setAllExponentsTo(exponents,1);
		unit.setDimensions(exponents);
		return unit;
	}
	
	private static void setAllExponentsTo(IfcDimensionalExponents exponents,int exponentVal)
	{
		exponents.setAmountOfSubstanceExponent(exponentVal);
		exponents.setElectricCurrentExponent(exponentVal);
		exponents.setLengthExponent(exponentVal);
		exponents.setLuminousIntensityExponent(exponentVal);
		exponents.setMassExponent(exponentVal);
		exponents.setThermodynamicTemperatureExponent(exponentVal);
		exponents.setTimeExponent(exponentVal);
	}
	
	public  IfcUnit unitFromStringAndUnitType(String unitString,
			IfcUnitEnum unitType)
	{
		IfcUnit unit = null;
		switch(unitType)
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
		if(unit==null)
			unit = getUnitUnknown(unitString);
		return unit;
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

	private IfcUnit getTimeUnitFromString(String unitString)
	{
		// TODO Auto-generated method stub
		return null;
	}

	private IfcUnit getMassUnitFromString(String unitString)
	{
		// TODO Auto-generated method stub
		return null;
	}

	private IfcUnit getLengthUnitFromString(String unitString)
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	private boolean isSIUnit(String unitString, IfcUnitEnum unitType)
	{
		boolean isSI = false;
		switch(unitType)
		{
			case ABSORBEDDOSEUNIT:
				break;
			case AMOUNTOFSUBSTANCEUNIT:
				break;
			case AREAUNIT:
				if (COBieUtility.endsWithOneOf(unitString,SI_LENGTH_SUFFIXES,false)!=null)
					isSI=true;
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
				break;
			case ILLUMINANCEUNIT:
				break;
			case INDUCTANCEUNIT:
				break;
			case LENGTHUNIT:
				if (COBieUtility.endsWithOneOf(unitString,SI_LENGTH_SUFFIXES,false)!=null)
					isSI=true;
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
				break;
			case NULL:
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
				break;
			case USERDEFINED:
				break;
			case VOLUMEUNIT:
				break;
		}
		return isSI;
	}

	private IfcUnit getFrequencyUnitFromString(String unitString)
	{
		// TODO Auto-generated method stub
		return null;
	}

	private static IfcUnit getAreaUnitFromString(String unitString)
	{
		// TODO Auto-generated method stub
		return null;
	}
	
}
