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
import java.util.HashMap;
import java.util.Map;

import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.IfcLabel;
import org.bimserver.models.ifc2x3tc1.IfcProperty;
import org.bimserver.models.ifc2x3tc1.IfcPropertyEnumeratedValue;
import org.bimserver.models.ifc2x3tc1.IfcPropertyEnumeration;
import org.bimserver.models.ifc2x3tc1.IfcPropertySingleValue;
import org.bimserver.models.ifc2x3tc1.IfcReal;
import org.bimserver.models.ifc2x3tc1.IfcText;
import org.bimserver.models.ifc2x3tc1.impl.IfcPropertySetImpl;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.sheetxmldata.TypeType;

public class Pset_EconomicImpactValues extends IfcPropertySetImpl
{
    private static enum CyclePhase
    {
        wholelifecycle, cradletosite, production, growth, acquisition, productiontransport, manufacture, procurement, transport, installation, usage, operation, occupancy, maintenance, refurbishment, replacement, repair, disposal, deconstruction, disposaltransport, recovery, waste
    }

    private static enum EconomicImpactProperty
    {
        MethodOfMeasurement, LifeCyclePhase, Cost
    }

    private static final String ENUMERATION_NAME_PREFIX = "PEnum_";
    public static String psetName = "COBie_Pset_EconomicImpactValues";;

    public String psetDescription = "Properties for economic impact values for Type.";

    private static final Map<EconomicImpactProperty, String> PropertyDescriptions = new HashMap<EconomicImpactProperty, String>()
    {
        /**
				 * 
				 */
        private static final long serialVersionUID = 1L;

        {
            put(EconomicImpactProperty.MethodOfMeasurement, "MethodOfMeasurement");
            put(EconomicImpactProperty.LifeCyclePhase, "Life Cycle Phase as defined in ISO 15978");
            put(EconomicImpactProperty.Cost, "Replacement Cost");
        }
    };

    public Pset_EconomicImpactValues()
    {
        super();
        initializeSingleValueProperties();
        initializeEnumeratedValueProperties();
        setDirectAttributes();
        setMethodOfMeasurement();
        setLifeCyclePhase();

    }

    public Pset_EconomicImpactValues(TypeType cobieType)
    {
        this();
        setCost(cobieType.getReplacementCost());
    }

    public String getEconomicImpactValuesProperty(EconomicImpactProperty property)
    {
        String value = "";
        String propName = property.toString();
        PropertySetUtility.getPropertySetPropertyValueOfName(propName, this);
        return value;
    }

    private String getLifeCyclePhaseEnumerationName()
    {
        return ENUMERATION_NAME_PREFIX + EconomicImpactProperty.LifeCyclePhase.name();
    }

    private void initializeEnumeratedValueProperties()
    {
        IfcPropertyEnumeratedValue lifeCycle = Ifc2x3tc1Factory.eINSTANCE.createIfcPropertyEnumeratedValue();
        lifeCycle.setName(EconomicImpactProperty.LifeCyclePhase.toString());
        lifeCycle.setDescription(PropertyDescriptions.get(EconomicImpactProperty.LifeCyclePhase));
        IfcPropertyEnumeration lifeCycleEnum = Ifc2x3tc1Factory.eINSTANCE.createIfcPropertyEnumeration();
        lifeCycleEnum.setName(getLifeCyclePhaseEnumerationName());
        for (CyclePhase literal : CyclePhase.values())
        {
            IfcLabel lbl = PropertyUtility.initializeLabel(literal.toString());
            lifeCycleEnum.getEnumerationValues().add(lbl);
        }
        lifeCycle.setEnumerationReference(lifeCycleEnum);
        super.getHasProperties().add(lifeCycle);
    }

    private void initializeSingleValueProperties()
    {
        for (EconomicImpactProperty literal : EconomicImpactProperty.values())
        {
            if (literal != EconomicImpactProperty.LifeCyclePhase)
            {
                String pName = literal.toString();
                String pDesc = PropertyDescriptions.get(literal);
                IfcPropertySingleValue val = Ifc2x3tc1Factory.eINSTANCE.createIfcPropertySingleValue();
                val.setName(pName);
                val.setDescription(pDesc);
                super.getHasProperties().add(val);
            }
        }
    }

    private void setCost(String cost)
    {
        IfcReal realCost = PropertyUtility.initializeRealToStringVal(cost);
        if (!COBieUtility.isValueSetAsStringNA(realCost))
        {
            PropertySetUtility.setPropertySetPropertyValueOfName(EconomicImpactProperty.Cost.toString(), this, realCost);
        }
        for (IfcProperty property : getHasProperties())
        {
            if ((property.getName() == EconomicImpactProperty.Cost.toString()) && (property instanceof IfcPropertySingleValue))
            {
            }
        }
    }

    public void setDirectAttributes()
    {
        setName(psetName);
        setDescription(psetDescription);
    }

    private void setLifeCyclePhase()
    {
        IfcLabel replacementPhase = PropertyUtility.initializeLabel(EconomicImpactProperty.LifeCyclePhase.toString());
        for (IfcProperty property : getHasProperties())
        {
            if ((property instanceof IfcPropertyEnumeratedValue) && property.getName().equals(EconomicImpactProperty.LifeCyclePhase.toString()))
            {
                IfcPropertyEnumeratedValue lifeCycle = (IfcPropertyEnumeratedValue)property;
                lifeCycle.getEnumerationValues().add(replacementPhase);

            }
        }
    }

    private void setMethodOfMeasurement()
    {
        IfcText txt = PropertyUtility.initializeText(COBieUtility.COBieNA);
        PropertySetUtility.setPropertySetPropertyValueOfName(EconomicImpactProperty.MethodOfMeasurement.toString(), this, txt);
    }

}
