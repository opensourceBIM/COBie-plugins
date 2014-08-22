package org.erdc.cobie.shared.bimserver.ifc.serialization.cobietab;

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

import org.bimserver.models.ifc2x3tc1.IfcPropertyEnumeratedValue;
import org.bimserver.models.ifc2x3tc1.IfcPropertyEnumeration;
import org.bimserver.models.ifc2x3tc1.IfcValue;
import org.eclipse.emf.common.util.EList;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.shared.bimserver.utility.ifc.IfcUnitToCOBieString;

public class IfcEnumeratedValueToCOBieString extends IfcPropertyToCOBieString
{
    private String unitString;
    private ArrayList<String> enumeratedValuesStrings;
    private ArrayList<String> enumerationReferenceStrings;

    public IfcEnumeratedValueToCOBieString()
    {
        super();
        enumeratedValuesStrings = new ArrayList<String>();
        enumerationReferenceStrings = new ArrayList<String>();
        // TODO Auto-generated constructor stub
    }

    public IfcEnumeratedValueToCOBieString(IfcPropertyEnumeratedValue property)
    {
        super(property);
        enumeratedValuesStrings = new ArrayList<String>();
        enumerationReferenceStrings = new ArrayList<String>();
        if ((property.getEnumerationReference() != null) && (property.getEnumerationReference().getUnit() != null))
        {
            setUnitString(IfcUnitToCOBieString.stringFromUnit(property.getEnumerationReference().getUnit()));
        } else
        {
            setUnitString(COBieUtility.COBieNA);
        }
        setEnumerationReferenceStrings(property.getEnumerationReference());
        setEnumeratedValuesStrings(property.getEnumerationValues());
        String tmpVal = "";
        for (String valStr : getEnumeratedValuesStrings())
        {
            tmpVal += valStr + ",";
        }
        if (tmpVal.endsWith(","))
        {
            tmpVal = tmpVal.substring(0, tmpVal.length() - 1);
        }
        this.setValueString(tmpVal);
        setPropertyTypeString(IfcPropertyEnumeratedValue.class.getSimpleName());
        // TODO Auto-generated constructor stub
    }

    public ArrayList<String> getEnumeratedValuesStrings()
    {
        return enumeratedValuesStrings;
    }

    public ArrayList<String> getEnumerationReferenceStrings()
    {
        return enumerationReferenceStrings;
    }

    public String getUnitString()
    {
        return unitString;
    }

    private void setEnumeratedValuesStrings(EList<IfcValue> values)
    {
        for (IfcValue val : values)
        {
            enumeratedValuesStrings.add(IfcPropertyToCOBieString.getValueStringFromValue(val));
        }
    }

    private void setEnumerationReferenceStrings(IfcPropertyEnumeration ref)
    {
        if (ref != null)
        {
            for (IfcValue val : ref.getEnumerationValues())
            {

                try
                {
                    String valStr = IfcPropertyToCOBieString.getValueStringFromValue(val);
                    enumerationReferenceStrings.add(valStr);
                } catch (Exception e)
                {

                }
            }
        }
    }

    private void setUnitString(String unitString)
    {
        this.unitString = unitString;
    }

}
