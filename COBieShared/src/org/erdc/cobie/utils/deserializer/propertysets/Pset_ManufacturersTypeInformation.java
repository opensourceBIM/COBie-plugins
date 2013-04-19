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
import org.bimserver.models.ifc2x3tc1.IfcLabel;
import org.bimserver.models.ifc2x3tc1.IfcPropertySingleValue;
import org.bimserver.models.ifc2x3tc1.impl.IfcPropertySetImpl;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.sheetxmldata.TypeType;

public class Pset_ManufacturersTypeInformation extends IfcPropertySetImpl
{
    private static final String pSetName = "COBie_Pset_ManufacturersTypeInformation";
    private static final String pSetDescription = "Defines characteristics of manufactured products that "
            + "may be given by the manufacturer. Note that the term may " + "also be used to refer to products that are supplied and "
            + "identified by the supplier or that are assembled off site " + "by a third party provider.";
    private static final String manufacturerPropertyName = "Manufacturer";
    private static final String modelReferencePropertyName = "ModelReference";
    private static final String modelLabelPropertyName = "ModelLabel";

    public static String getPsetdescription()
    {
        return pSetDescription;
    }

    public static String getPsetname()
    {
        return pSetName;
    }

    public Pset_ManufacturersTypeInformation()
    {
        super();
        setDirectAttributes();
        initializeSingleValueProperties();

    }

    public Pset_ManufacturersTypeInformation(TypeType cobieType)
    {

        this();
        String manufacturer = cobieType.getManufacturer();
        if (!COBieUtility.isNA(manufacturer) /*
                                              * && !
                                              * manufacturer.equalsIgnoreCase
                                              * (manufacturerPropertyName)
                                              */)
        {
            setManufacturer(cobieType.getManufacturer());
        }
        setModelLabel(cobieType.getModelNumber());
        setModelReference(cobieType.getModelReference());
    }

    public String getManufacturer()
    {
        return PropertySetUtility.getPropertySetPropertyValueOfName(manufacturerPropertyName, this);
    }

    public String getModelLabel()
    {
        return PropertySetUtility.getPropertySetPropertyValueOfName(modelLabelPropertyName, this);
    }

    public String getModelReference()
    {
        return PropertySetUtility.getPropertySetPropertyValueOfName(modelReferencePropertyName, this);
    }

    public void initializeSingleValueProperties()
    {
        IfcPropertySingleValue manufacturerProperty = Ifc2x3tc1Factory.eINSTANCE.createIfcPropertySingleValue();
        manufacturerProperty.setName(manufacturerPropertyName);
        IfcPropertySingleValue modelReferenceProperty = Ifc2x3tc1Factory.eINSTANCE.createIfcPropertySingleValue();
        modelReferenceProperty.setName(modelLabelPropertyName);
        IfcPropertySingleValue modelLabelProperty = Ifc2x3tc1Factory.eINSTANCE.createIfcPropertySingleValue();
        modelLabelProperty.setName(modelLabelPropertyName);
        super.getHasProperties().add(manufacturerProperty);
        super.getHasProperties().add(modelReferenceProperty);
        super.getHasProperties().add(modelLabelProperty);

    }

    public void setDirectAttributes()
    {
        setName(getPsetname());
        setDescription(getPsetdescription());
    }

    public void setManufacturer(String manufacturer)
    {
        IfcLabel manufacturerLbl = Ifc2x3tc1Factory.eINSTANCE.createIfcLabel();
        manufacturerLbl.setWrappedValue(manufacturer);
        PropertySetUtility.setPropertySetPropertyValueOfName(manufacturerPropertyName, this, manufacturerLbl);
    }

    public void setModelLabel(String modelLabel)
    {
        IfcLabel lblModelLabel = Ifc2x3tc1Factory.eINSTANCE.createIfcLabel();
        lblModelLabel.setWrappedValue(modelLabel);
        PropertySetUtility.setPropertySetPropertyValueOfName(modelLabelPropertyName, this, lblModelLabel);
    }

    public void setModelReference(String modelReference)
    {
        IfcLabel referenceLabel = Ifc2x3tc1Factory.eINSTANCE.createIfcLabel();
        referenceLabel.setWrappedValue(modelReference);
        PropertySetUtility.setPropertySetPropertyValueOfName(modelReferencePropertyName, this, referenceLabel);
    }
}
