package org.erdc.cobie.shared.deserializer.sheetxmldata.propertysets;

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
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.IfcCalendarDate;
import org.bimserver.models.ifc2x3tc1.IfcLabel;
import org.bimserver.models.ifc2x3tc1.IfcPropertyReferenceValue;
import org.bimserver.models.ifc2x3tc1.IfcPropertySingleValue;
import org.bimserver.models.ifc2x3tc1.impl.IfcPropertySetImpl;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.sheetxmldata.ComponentType;

public class Pset_Component extends IfcPropertySetImpl
{
    public static enum ComponentField
    {
        InstallationDate, WarrantyStartDate, TagNumber, AssetIdentifier
    }

    public static final String pSetName = "COBie_Component";
    public static final String pSetDescription = "Properties for Component found in COBie";
    private static final Map<ComponentField, String> PropertyDescriptions = new HashMap<ComponentField, String>()
    {
        /**
				 * 
				 */
        private static final long serialVersionUID = 1L;

        {
           // put(ComponentField.SerialNumber, "The manufacturers unique component identifier");
            put(ComponentField.InstallationDate, "Date of installation");
            put(ComponentField.WarrantyStartDate, "Date of warranty start");
            put(ComponentField.TagNumber, "Occupiers unique tag");
            //put(ComponentField.BarCode, "Identifying barcode or rfid");
            put(ComponentField.AssetIdentifier, "Asset identification label");

        }
    };

    public Pset_Component()
    {
        super();
        setDirectAttributes();
        initializeSingleValueAttributes();
    }

    public Pset_Component(ComponentType component)
    {
        this();
       // setSerialNumber(component);
        setInstallationDate(component);
        setWarrantyStartDate(component);
        setTagNumber(component);
      //  setBarCode(component);
        setAssetIdentifier(component);
    }

    public void initializeSingleValueAttributes()
    {
        for (ComponentField field : ComponentField.values())
        {
            if(field!=ComponentField.WarrantyStartDate && field!=ComponentField.InstallationDate)
            {
                IfcPropertySingleValue sVal = Ifc2x3tc1Factory.eINSTANCE.createIfcPropertySingleValue();
                sVal.setName(field.toString());
                sVal.setDescription(PropertyDescriptions.get(field));
                getHasProperties().add(sVal);
            }
           
        }
    }

    private void setAssetIdentifier(ComponentType component)
    {
        IfcLabel assetidentifierLbl = PropertyUtility.initializeLabel(component.getAssetIdentifier());
        PropertySetUtility.setPropertySetPropertyValueOfName(ComponentField.AssetIdentifier.toString(), this, assetidentifierLbl);
    }



    public void setDirectAttributes()
    {
        setName(pSetName);
        setDescription(pSetDescription);
    }

    private void setInstallationDate(ComponentType component)
    {
        setDateFieldAsDateOrText(component.getInstallationDate(), ComponentField.InstallationDate);
    }



    private void setTagNumber(ComponentType component)
    {
        IfcLabel tagNumberLbl = PropertyUtility.initializeLabel(component.getTagNumber());
        PropertySetUtility.setPropertySetPropertyValueOfName(ComponentField.TagNumber.toString(), this, tagNumberLbl);
    }

    private void setWarrantyStartDate(ComponentType component)
    {
        setDateFieldAsDateOrText(component.getWarrantyStartDate(), ComponentField.WarrantyStartDate);
        
    }

    private void setDateFieldAsDateOrText(String cobieDate, ComponentField field)
    {
        try
        {
            setDateAsIfcCalendarDate(cobieDate, field);
        }
        catch(Exception ex)
        {
            setDateFieldAsLabel(cobieDate, field);
        }
    }
    
    private void setDateFieldAsLabel(String date, ComponentField componentField)
    {
        IfcLabel warrantyStart = PropertyUtility.initializeLabel(date);
        IfcPropertySingleValue warrantyStartDateSingleValue =
                Ifc2x3tc1Factory.eINSTANCE.createIfcPropertySingleValue();
        warrantyStartDateSingleValue.setName(componentField.toString());
        warrantyStartDateSingleValue.setDescription(PropertyDescriptions.get(componentField));
        warrantyStartDateSingleValue.setNominalValue(warrantyStart);
        this.getHasProperties().add(warrantyStartDateSingleValue);     
    }

    private void setDateAsIfcCalendarDate(String cobieDate, ComponentField field) throws Exception
    {
        IfcCalendarDate date =
                Ifc2x3tc1Factory.eINSTANCE.createIfcCalendarDate();
        Calendar calendar =
                COBieUtility.calendarFromStringWithException(cobieDate);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        date.setDayComponent(day);
        date.setMonthComponent(month);
        date.setYearComponent(year);
        IfcPropertyReferenceValue referenceValue =
                Ifc2x3tc1Factory.eINSTANCE.createIfcPropertyReferenceValue();
        referenceValue.setName(field.toString());
        referenceValue.setDescription(PropertyDescriptions.get(field));
        referenceValue.setPropertyReference(date);
        referenceValue.setUsageName(field.toString());        
        this.getHasProperties().add(referenceValue);
        
    }
}
