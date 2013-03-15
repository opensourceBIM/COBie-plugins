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
import org.erdc.cobie.sheetxmldata.TypeType;

public class Pset_Asset extends IfcPropertySetImpl
{
    private static final String CAMEL_CASE_NONFIXED_ASSET = "NonFixed";
    private static final String CAMEL_CASE_FIXED_ASSET = "Fixed";
    private static final String LOWER_CASE_FIXED_ASSET = "fixed";
    private static final String pSetName = "COBie_Pset_Asset";
    private static final String pSetDescription = "An asset is a uniquely identifiable element which has a financial "
            + "value and against which maintenance actions are recorded.";

    private static final String assetAccountingTypePropertyName = "AssetAccountingType";
    private static final String assetAccountingTypePropertyDescription = "Identifies the predefined types of asset from "
            + "which the type required may be set.";

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

    public Pset_Asset()
    {
        super();
        initializeSingleValueProperties();
        setDirectAttributes();
    }

    public Pset_Asset(TypeType cobieType)
    {
        this();
        String assetType = cobieType.getAssetType();
        setAssetAccountingType(assetType);
    }

    public String getAssetAccountingType()
    {
        return PropertySetUtility.getPropertySetPropertyValueOfName(getAssetAccountingTypePropertyName(), this);
    }

    private void initializeSingleValueProperties()
    {
        IfcPropertySingleValue assetProperty = Ifc2x3tc1Factory.eINSTANCE.createIfcPropertySingleValue();
        assetProperty.setName(getAssetAccountingTypePropertyName());
        assetProperty.setDescription(getAssetAccountingTypePropertyDescription());
        super.getHasProperties().add(assetProperty);

    }

    private void setAssetAccountingType(String assetAccountingType)
    {
        String assetAccountingTypeDerived = assetAccountingType;
        if (assetAccountingTypeDerived.equalsIgnoreCase(LOWER_CASE_FIXED_ASSET))
        {
            assetAccountingTypeDerived = CAMEL_CASE_FIXED_ASSET;
        } else
        {
            assetAccountingTypeDerived = CAMEL_CASE_NONFIXED_ASSET;
        }
        IfcLabel assetType = Ifc2x3tc1Factory.eINSTANCE.createIfcLabel();
        assetType.setWrappedValue(assetAccountingTypeDerived);
        PropertySetUtility.setPropertySetPropertyValueOfName(getAssetAccountingTypePropertyName(), this, assetType);
    }

    public void setDirectAttributes()
    {
        setName(getPsetName());
        setDescription(getPsetDescription());
    }
}
