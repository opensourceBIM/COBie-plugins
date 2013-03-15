package org.erdc.cobie.utils.deserializer.propertysets;

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
import org.bimserver.models.ifc2x3tc1.IfcCalendarDate;
import org.bimserver.models.ifc2x3tc1.IfcNamedUnit;
import org.bimserver.models.ifc2x3tc1.IfcPhysicalSimpleQuantity;
import org.bimserver.models.ifc2x3tc1.IfcProperty;
import org.bimserver.models.ifc2x3tc1.IfcPropertyEnumeratedValue;
import org.bimserver.models.ifc2x3tc1.IfcPropertySet;
import org.bimserver.models.ifc2x3tc1.IfcPropertySingleValue;
import org.bimserver.models.ifc2x3tc1.IfcReal;
import org.bimserver.models.ifc2x3tc1.IfcSimpleProperty;
import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.bimserver.models.ifc2x3tc1.IfcValue;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.utils.stringwriters.IfcPropertyToCOBieString;

public class PropertySetUtility
{

    public static String getPropertySetPropertyValueOfName(String propertyName, IfcPropertySet propertySet)
    {
        String value = COBieUtility.COBieNA;
        for (IfcProperty property : propertySet.getHasProperties())
        {
            if (property.getName().equals(propertyName))
            {
                if (property instanceof IfcSimpleProperty)
                {
                    IfcSimpleProperty simpleProp = (IfcSimpleProperty)property;
                    IfcPropertyToCOBieString cobieString = new IfcPropertyToCOBieString(simpleProp);
                    value = cobieString.getValueString();
                }

            }

        }
        return value;
    }

    private static void setEnumProperty(IfcValue value, IfcProperty property)
    {
        IfcPropertyEnumeratedValue enumProp = (IfcPropertyEnumeratedValue)property;
        enumProp.getEnumerationValues().add(value);
        // cannot set units on enum
    }

    private static void setPhysicalProperty(IfcValue value, IfcUnit units, IfcProperty property)
    {
        IfcPhysicalSimpleQuantity physProp = (IfcPhysicalSimpleQuantity)property;
        if (units instanceof IfcNamedUnit)
        {
            physProp.setUnit((IfcNamedUnit)units);
        }
        if (value instanceof IfcReal)
        {
            IfcReal ifcReal = (IfcReal)value;
            PropertyUtility.setIfcPhysicalSimpleQuantityValue(physProp, ifcReal);
        }
    }

    public static void setPropertySetPropertyUnitNameOf(String propertyName, IfcPropertySet propertySet, IfcUnit units)
    {

        for (IfcProperty property : propertySet.getHasProperties())
        {
            if (property.getName().equalsIgnoreCase(propertyName))
            {
                if (property instanceof IfcSimpleProperty)
                {
                    if (property instanceof IfcPropertySingleValue)
                    {
                        ((IfcPropertySingleValue)property).setUnit(units);
                    }
                    if ((property instanceof IfcPhysicalSimpleQuantity) && (units instanceof IfcNamedUnit))
                    {
                        ((IfcPhysicalSimpleQuantity)property).setUnit((IfcNamedUnit)units);

                    }

                }

            }

        }

    }

    public static void setPropertySetPropertyValueOfName(String propertyName, IfcPropertySet propertySet, IfcValue value)
    {
        if (PropertyUtility.shouldSetProperty(propertyName, value))
        {
            for (IfcProperty property : propertySet.getHasProperties())
            {
                if (property.getName().equalsIgnoreCase(propertyName))
                {
                    if (property instanceof IfcSimpleProperty)
                    {
                        if (property instanceof IfcPropertySingleValue)
                        {
                            IfcPropertySingleValue singValue = (IfcPropertySingleValue)property;
                            singValue.setNominalValue(value);
                        }
                        if (property instanceof IfcPropertyEnumeratedValue)
                        {
                            setEnumProperty(value, property);
                        }

                        if (property instanceof IfcPhysicalSimpleQuantity)
                        {
                            IfcPhysicalSimpleQuantity physProp = (IfcPhysicalSimpleQuantity)property;
                            if (value instanceof IfcReal)
                            {
                                IfcReal ifcReal = (IfcReal)value;
                                PropertyUtility.setIfcPhysicalSimpleQuantityValue(physProp, ifcReal);
                            }

                        }

                    }

                }

            }
        }
    }

    public static void setPropertySetPropertyValueOfNameAndUnit(String propertyName, IfcPropertySet propertySet, IfcValue value, IfcUnit units)
    {
        if (PropertyUtility.shouldSetProperty(propertyName, value))
        {
            for (IfcProperty property : propertySet.getHasProperties())
            {
                if (property.getName().equalsIgnoreCase(propertyName))
                {
                    if (property instanceof IfcSimpleProperty)
                    {
                        if (property instanceof IfcPropertySingleValue)
                        {
                            setSingleValueProperty(value, units, property);
                        }
                        if (property instanceof IfcPropertyEnumeratedValue)
                        {
                            setEnumProperty(value, property);
                        }

                        if (property instanceof IfcPhysicalSimpleQuantity)
                        {
                            setPhysicalProperty(value, units, property);

                        }

                    }

                }

            }
        }
    }

    private static void setSingleValueProperty(IfcValue value, IfcUnit units, IfcProperty property)
    {
        IfcPropertySingleValue singValue = (IfcPropertySingleValue)property;
        singValue.setNominalValue(value);
        singValue.setUnit(units);
    }

    public static void setPropertySetPropertyValueOfName(String string, Pset_Component propertySet, IfcCalendarDate date)
    {
       // IfcPropertyReferenceValue referenceValue = Ifc2x3tc1Factory.eINSTANCE.createIfcPropertyReferenceValue();
       // referenceValue.setPropertyReference(date);
        //referenceValue.setName(value)
    }

}
