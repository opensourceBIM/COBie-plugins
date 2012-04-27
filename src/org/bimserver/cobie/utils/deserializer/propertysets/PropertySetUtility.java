package org.bimserver.cobie.utils.deserializer.propertysets;
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
import org.bimserver.cobie.utils.COBieUtility;
import org.bimserver.cobie.utils.stringwriters.IfcPropertyToCOBieString;
import org.bimserver.models.ifc2x3tc1.IfcPhysicalSimpleQuantity;
import org.bimserver.models.ifc2x3tc1.IfcProperty;
import org.bimserver.models.ifc2x3tc1.IfcPropertyEnumeratedValue;
import org.bimserver.models.ifc2x3tc1.IfcPropertySet;
import org.bimserver.models.ifc2x3tc1.IfcPropertySingleValue;
import org.bimserver.models.ifc2x3tc1.IfcReal;
import org.bimserver.models.ifc2x3tc1.IfcSimpleProperty;
import org.bimserver.models.ifc2x3tc1.IfcValue;

public class PropertySetUtility 
{

	public static String getPropertySetPropertyValueOfName(String propertyName,IfcPropertySet propertySet)
	{
		String value = COBieUtility.COBieNA;
		for(IfcProperty property : propertySet.getHasProperties())
		{
			if (property.getName()==propertyName)
			{
				if (property instanceof IfcSimpleProperty)
				{
					IfcSimpleProperty simpleProp =
							(IfcSimpleProperty) property;
					IfcPropertyToCOBieString cobieString =
							new IfcPropertyToCOBieString(simpleProp);
					value = cobieString.getValueString();
				}

			}

		}
		return value;
	}
	
	public static void setPropertySetPropertyValueOfName(String propertyName,IfcPropertySet propertySet,
			IfcValue value)
	{
		if (PropertyUtility.shouldSetProperty(propertyName,value))
		{
			for(IfcProperty property : propertySet.getHasProperties())
			{
				if (property.getName()==propertyName)
				{
					if (property instanceof IfcSimpleProperty)
					{
						if (property instanceof IfcPropertySingleValue)
						{
							IfcPropertySingleValue singValue =
									(IfcPropertySingleValue) property;
							singValue.setNominalValue(value);
						}
						if (property instanceof IfcPropertyEnumeratedValue)
						{
							IfcPropertyEnumeratedValue enumProp =
									(IfcPropertyEnumeratedValue) property;
							enumProp.getEnumerationValues().add(value);
						}
						
						if (property instanceof IfcPhysicalSimpleQuantity)
						{
							IfcPhysicalSimpleQuantity physProp =
									(IfcPhysicalSimpleQuantity) property;
							if (value instanceof IfcReal)
							{
								IfcReal ifcReal =
										(IfcReal) value;
								PropertyUtility.setIfcPhysicalSimpleQuantityValue(physProp,(float) ifcReal.getWrappedValue());
							}
							
						}
						
					}

				}

			}
		}	
	}


}
