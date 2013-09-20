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
import java.util.List;

import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.IfcLabel;
import org.bimserver.models.ifc2x3tc1.IfcPropertyEnumeratedValue;
import org.bimserver.models.ifc2x3tc1.IfcPropertyEnumeration;
import org.bimserver.models.ifc2x3tc1.impl.IfcPropertySetImpl;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.sheetxmldata.TypeType;

public class Pset_Asset extends IfcPropertySetImpl
{
    private static final String PENUM_ASSET_ACCOUNTING_TYPE_ALLOWEDVALUES = "Fixed,Moveable";
    private static final String P_ENUM_ASSET_ACCOUNTING_TYPE = "COBie_Enum_AssetType";
    private static final String pSetName = "COBie_Asset";
    private static final String pSetDescription = "Definition from IAI:  An asset is a uniquely identifiable element which has a financial value and against which maintenance actions are recorded.";

    private static final String assetAccountingTypePropertyName = "AssetType";
    private static final String assetAccountingTypePropertyDescription = "Identifies the predefined types of asset from "
            + "which the type required may be set.";

    public static String getAssetAccountingTypeAllowedValues()
    {
        return PENUM_ASSET_ACCOUNTING_TYPE_ALLOWEDVALUES;
    }

    public static String getAssetAccountingTypeEnumName()
    {
        return P_ENUM_ASSET_ACCOUNTING_TYPE;
    }

    private static String getAssetAccountingTypePropertyDescription()
    {
        return assetAccountingTypePropertyDescription;
    }

    private static String getAssetAccountingTypePropertyName()
    {
        return assetAccountingTypePropertyName;
    }

    private static String getPsetDescription()
    {
        return pSetDescription;
    }

    public static String getPsetName()
    {
        return pSetName;
    }

    private IfcPropertyEnumeration assetTypeEnumeration;

    private IfcPropertyEnumeratedValue assetTypeEnumerationValue;

    public Pset_Asset()
    {
        super();
        setDirectAttributes();
        assetTypeEnumeration = null;

    }

    public Pset_Asset(TypeType cobieType, IfcPropertyEnumeration assetTypeEnumeration)
    {
        this();
        this.assetTypeEnumeration = assetTypeEnumeration;
        initializeEnumeratedValueProperties();
        String assetType = cobieType.getAssetType();
        setAssetAccountingType(assetType);
        
    }

    public String getAssetAccountingType()
    {
        return PropertySetUtility.getPropertySetPropertyValueOfName(getAssetAccountingTypePropertyName(), this);
    }

    private void initializeEnumeratedValueProperties()
    {
        IfcPropertyEnumeratedValue enumeratedValue = Ifc2x3tc1Factory.eINSTANCE.createIfcPropertyEnumeratedValue();
        enumeratedValue.setName(getAssetAccountingTypePropertyName());
        enumeratedValue.setDescription(getAssetAccountingTypePropertyDescription());
        enumeratedValue.setEnumerationReference(assetTypeEnumeration);
        assetTypeEnumerationValue = enumeratedValue;
        super.getHasProperties().add(enumeratedValue);
    }

    private void setAssetAccountingType(String assetAccountingType)
    {
        String assetAccountingTypeDerived = assetAccountingType;
        List<String> allowedValues = COBieUtility.arrayListFromDelimString(getAssetAccountingTypeAllowedValues());
        allowedValueLoop: for (String allowedValue : allowedValues)
        {
            if (allowedValue.equalsIgnoreCase(assetAccountingType))
            {
                assetAccountingTypeDerived = allowedValue;
                break allowedValueLoop;
            }
        }

        IfcLabel assetType = Ifc2x3tc1Factory.eINSTANCE.createIfcLabel();

        assetType.setWrappedValue(assetAccountingTypeDerived);
        PropertySetUtility.setPropertySetPropertyValueOfName(getAssetAccountingTypePropertyName(), this, assetType);
        assetTypeEnumerationValue.getEnumerationValues().add(assetType);
    }

    public void setDirectAttributes()
    {
        setName(getPsetName());
        setDescription(getPsetDescription());
    }
}
