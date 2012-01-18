package org.bimserver.cobie.utils.StringWriters;
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
import java.util.ArrayList;

import org.bimserver.models.ifc2x3.IfcContextDependentUnit;
import org.bimserver.models.ifc2x3.IfcConversionBasedUnit;
import org.bimserver.models.ifc2x3.IfcDerivedUnit;
import org.bimserver.models.ifc2x3.IfcDerivedUnitElement;
import org.bimserver.models.ifc2x3.IfcMonetaryUnit;
import org.bimserver.models.ifc2x3.IfcNamedUnit;
import org.bimserver.models.ifc2x3.IfcSIPrefix;
import org.bimserver.models.ifc2x3.IfcSIUnit;
import org.bimserver.models.ifc2x3.IfcSIUnitName;
import org.bimserver.models.ifc2x3.IfcUnit;
import org.bimserver.models.ifc2x3.IfcUnitEnum;

public class IfcUnitToCOBieString 
{
	public static String stringFromUnit(IfcUnit unit)
	{
		String unitString = "";
		if (IfcDerivedUnit.class.isInstance(unit))
			unitString = stringFromDerivedUnit((IfcDerivedUnit)unit);
		else if (IfcNamedUnit.class.isInstance(unit))
			unitString = stringFromNamedUnit((IfcNamedUnit)unit);
		else if  (IfcMonetaryUnit.class.isInstance(unit))
			unitString = stringFromMonetaryUnit((IfcMonetaryUnit) unit);
		return unitString;
	}
	
	static protected String stringFromDerivedUnit(IfcDerivedUnit unit)
	{
		String posUnitStr = "";
		String negUnitStr = "";
		String unitString = "";
		String tmpUnitStr = "";
		ArrayList<String> posEx = new ArrayList<String>();
		ArrayList<String> negEx = new ArrayList<String> ();
		int exp = 0;
		for(IfcDerivedUnitElement nUnit : unit.getElements())
		{	
			exp = nUnit.getExponent();
			tmpUnitStr = IfcUnitToCOBieString.stringFromUnit(nUnit.getUnit());
			if (tmpUnitStr!=null && tmpUnitStr.length()>0)
			{	
				tmpUnitStr = tmpUnitStr + "^" + String.valueOf(exp*-1);
				if (exp > 0) 
					posEx.add(tmpUnitStr);
				else if (exp < 0) 
					negEx.add(tmpUnitStr);				
			}
		}
		
		for (String posStr : posEx)
		{
			posUnitStr += posEx + "*";
		}
		if (posUnitStr.endsWith("*"))
			posUnitStr = posUnitStr.substring(0,posUnitStr.length()-1);

		for (String negStr : negEx)
		{
			negUnitStr += negEx + "*";
		}
		if (negUnitStr.endsWith("*"))
			negUnitStr = negUnitStr.substring(0,negUnitStr.length()-1);

		int posUnitLength = posUnitStr.length();
		int negUnitLength = negUnitStr.length();
		if (posUnitLength==0 && negUnitLength==0)
		{
			unitString = "";
		}
		else if (posUnitLength==0 && negUnitLength>0)
		{
			unitString = "1/"+negUnitStr;
		}
		else if (posUnitLength>0 && negUnitLength==0)
			unitString = posUnitStr;
		else if (posUnitLength>0 && negUnitLength>0)
			unitString = "("+posUnitStr+")/("+negUnitStr+")";		
		return unitString;
	}
		
	static protected String stringFromNamedUnit(IfcNamedUnit nUnit)
	{
		String unitString = "";
		if (IfcSIUnit.class.isInstance(nUnit))
		{
			IfcSIUnit siUnit = (IfcSIUnit) nUnit;
			unitString = getSIPrefix(siUnit.getPrefix()) +
						siUnit.getName().getLiteral();

		}
		else if (IfcConversionBasedUnit.class.isInstance(nUnit))
		{
			IfcConversionBasedUnit convUnit = (IfcConversionBasedUnit) nUnit;
			if (convUnit.getName().length()>0)
				unitString = convUnit.getName();	
		}
		else if (IfcContextDependentUnit.class.isInstance(nUnit))
		{
			IfcContextDependentUnit cntxtUnit = (IfcContextDependentUnit) nUnit;
			if (cntxtUnit.getName().length()>0)
				unitString = cntxtUnit.getName();
		}
				
		return unitString;
	}

	public static String getVolumeUnitString(IfcNamedUnit nUnit) 
	{
		String unitString = "";
		if (IfcSIUnit.class.isInstance(nUnit)&&
				nUnit.getUnitType().getLiteral()==IfcUnitEnum.VOLUMEUNIT.getLiteral())
		{
			IfcSIUnit siUnit = (IfcSIUnit) nUnit;
			if (siUnit.getName().getLiteral()==IfcSIUnitName.CUBIC_METRE.getLiteral())
			{
				unitString = "cubic" + getSIPrefix(siUnit.getPrefix()) + "meters";
			}
			else
				unitString = stringFromNamedUnit(nUnit);
		}
		else
			unitString = stringFromNamedUnit(nUnit);
		return unitString;
	}

	public static String linearUnitString(IfcNamedUnit nUnit)
	{
		String unitString = "";
		if (IfcSIUnit.class.isInstance(nUnit)&&
				nUnit.getUnitType().getLiteral()==IfcUnitEnum.LENGTHUNIT.getLiteral())
		{
			IfcSIUnit siUnit = (IfcSIUnit) nUnit;
			
			if (siUnit.getName().getLiteral()==IfcSIUnitName.METRE.getLiteral())
			{
				unitString = getSIPrefix(siUnit.getPrefix()) + "meters";
			}
			else
				unitString = stringFromNamedUnit(nUnit);
		}
		else
			unitString = stringFromNamedUnit(nUnit);
		return unitString;
	}
	
	static protected String getSIPrefix(IfcSIPrefix prefix) 
	{
		String prefixString = "";
		if (prefix != null
				&& prefix.getLiteral() != IfcSIPrefix.NULL.getLiteral()) {
			prefixString =  prefix.getName().toLowerCase();
		}
		return prefixString;
	}

	public static String getAreaUnitString(IfcNamedUnit nUnit) 
	{
		String unitString = "";
		if (IfcSIUnit.class.isInstance(nUnit)&&
				nUnit.getUnitType().getLiteral()==IfcUnitEnum.AREAUNIT.getLiteral())
		{
			IfcSIUnit siUnit = (IfcSIUnit) nUnit;
			if (siUnit.getName().getLiteral()==IfcSIUnitName.SQUARE_METRE.getLiteral())
			{
				unitString = "square" + getSIPrefix(siUnit.getPrefix()) + "meters";
			}
			else
				unitString = stringFromNamedUnit(nUnit);
		}
		else
			unitString = stringFromNamedUnit(nUnit);
		return unitString;
	}
			
	public static String stringFromMonetaryUnit(IfcMonetaryUnit unit)
	{
		String unitString = "";
		unitString = unit.getCurrency().getLiteral();
		return unitString;
	}
}
