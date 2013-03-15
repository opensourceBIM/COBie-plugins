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
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.IfcPropertySingleValue;
import org.bimserver.models.ifc2x3tc1.impl.IfcPropertySetImpl;
import org.erdc.cobie.sheetxmldata.TypeType;

public class Pset_Specification extends IfcPropertySetImpl
{
    public static enum SpecificationTypeField
    {
        NominalLength, NominalWidth, NominalHeight, ModelReference, Shape, Size, Color, Finish, Grade, Material, Constituents, Features, AccessibilityPerformance, CodePerformance, SustainabilityPerformance
    }

    public static final String pSetName = "COBie_Pset_Specification";
    public static final String pSetDescriptionPrefix = "Properties for ";
    public static final String propertyDescriptionPrefix = "Value for ";

    public Pset_Specification()
    {
        super();
        setDirectAttributes();
        initializeSingleValueAttributes();
    }

    public Pset_Specification(TypeType type)
    {
        this();
        setDescription(pSetDescriptionPrefix + type.getExtObject());
        PropertySetUtility.setPropertySetPropertyValueOfName(SpecificationTypeField.NominalLength.toString(), this,
                PropertyUtility.initializeLabel(type.getNominalLength()));
        PropertySetUtility.setPropertySetPropertyValueOfName(SpecificationTypeField.NominalWidth.toString(), this,
                PropertyUtility.initializeLabel(type.getNominalWidth()));
        PropertySetUtility.setPropertySetPropertyValueOfName(SpecificationTypeField.NominalHeight.toString(), this,
                PropertyUtility.initializeLabel(type.getNominalHeight()));
        PropertySetUtility.setPropertySetPropertyValueOfName(SpecificationTypeField.ModelReference.toString(), this,
                PropertyUtility.initializeLabel(type.getModelReference()));
        PropertySetUtility.setPropertySetPropertyValueOfName(SpecificationTypeField.Shape.toString(), this,
                PropertyUtility.initializeLabel(type.getShape()));
        PropertySetUtility.setPropertySetPropertyValueOfName(SpecificationTypeField.Size.toString(), this,
                PropertyUtility.initializeLabel(type.getSize()));
        PropertySetUtility.setPropertySetPropertyValueOfName(SpecificationTypeField.Color.toString(), this,
                PropertyUtility.initializeLabel(type.getColor()));
        PropertySetUtility.setPropertySetPropertyValueOfName(SpecificationTypeField.Finish.toString(), this,
                PropertyUtility.initializeLabel(type.getFinish()));
        PropertySetUtility.setPropertySetPropertyValueOfName(SpecificationTypeField.Grade.toString(), this,
                PropertyUtility.initializeLabel(type.getGrade()));
        PropertySetUtility.setPropertySetPropertyValueOfName(SpecificationTypeField.Material.toString(), this,
                PropertyUtility.initializeLabel(type.getMaterial()));
        PropertySetUtility.setPropertySetPropertyValueOfName(SpecificationTypeField.Constituents.toString(), this,
                PropertyUtility.initializeLabel(type.getConstituents()));
        PropertySetUtility.setPropertySetPropertyValueOfName(SpecificationTypeField.Features.toString(), this,
                PropertyUtility.initializeLabel(type.getFeatures()));
        PropertySetUtility.setPropertySetPropertyValueOfName(SpecificationTypeField.AccessibilityPerformance.toString(), this,
                PropertyUtility.initializeLabel(type.getAccessibilityPerformance()));
        PropertySetUtility.setPropertySetPropertyValueOfName(SpecificationTypeField.CodePerformance.toString(), this,
                PropertyUtility.initializeLabel(type.getCodePerformance()));
        PropertySetUtility.setPropertySetPropertyValueOfName(SpecificationTypeField.SustainabilityPerformance.toString(), this,
                PropertyUtility.initializeLabel(type.getSustainabilityPerformance()));

    }

    public void initializeSingleValueAttributes()
    {
        for (SpecificationTypeField field : SpecificationTypeField.values())
        {
            IfcPropertySingleValue sVal = Ifc2x3tc1Factory.eINSTANCE.createIfcPropertySingleValue();
            sVal.setName(field.toString());
            sVal.setDescription(propertyDescriptionPrefix + sVal.getName());
            getHasProperties().add(sVal);
        }
    }

    public void setDirectAttributes()
    {
        setName(pSetName);
        setDescription(pSetDescriptionPrefix);
    }

}
