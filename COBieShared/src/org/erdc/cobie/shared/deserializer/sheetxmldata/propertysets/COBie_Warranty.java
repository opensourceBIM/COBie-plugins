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
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.IfcLabel;
import org.bimserver.models.ifc2x3tc1.IfcPropertySingleValue;
import org.bimserver.models.ifc2x3tc1.IfcReal;
import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.bimserver.models.ifc2x3tc1.impl.IfcPropertySetImpl;
import org.erdc.cobie.shared.COBieTokenUtility.TypeColumnNameLiterals;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.shared.targetunits.time.TimeUnitSearch;
import org.erdc.cobie.sheetxmldata.TypeType;

public class COBie_Warranty extends IfcPropertySetImpl
{
    private static final String pSetName = "COBie_Warranty";
    private static final String pSetDescription = "Warranty Information.";
    private static final String pName_WarrantyName = "WarrantyName";
    private static final String pDescribe_WarrantyName = "The name of the warranty";
    private static final String pName_WarrantyDescription = "WarrantyDescription";
    private static final String pDescribe_WarrantyDescription = "Description of the Warranty";
    private static final String pName_WarrantyGuarantorParts = TypeColumnNameLiterals.WarrantyGuarantorParts.toString();
    private static final String pDescribe_WarrantyGuarantorParts = "Organization acting as guarantor of parts warranty";
    private static final String pName_WarrantyDurationParts = TypeColumnNameLiterals.WarrantyDurationParts.toString();
    private static final String pDescribe_WarrantyDurationParts = "Duration of parts warranty (years)";
    private static final String pName_WarrantyGuarantorLabor = TypeColumnNameLiterals.WarrantyGuarantorLabor.toString();
    private static final String pDescribe_WarrantyGuarantorLabor = "Organization acting as guarantor of labor warranty";
    private static final String pName_WarrantyDurationLabor = TypeColumnNameLiterals.WarrantyDurationLabor.toString();
    private static final String pDescribe_WarrantyDurationLabor = "Duration of labor warranty (years)";

    public static String getPDescribe_Warrantyname()
    {
        return pDescribe_WarrantyName;
    }

    public static String getPdescribeWarrantydescription()
    {
        return pDescribe_WarrantyDescription;
    }

    public static String getPdescribeWarrantydurationlabor()
    {
        return pDescribe_WarrantyDurationLabor;
    }

    public static String getPdescribeWarrantydurationparts()
    {
        return pDescribe_WarrantyDurationParts;
    }

    public static String getPdescribeWarrantyguarantorlabor()
    {
        return pDescribe_WarrantyGuarantorLabor;
    }

    public static String getPdescribeWarrantyguarantorparts()
    {
        return pDescribe_WarrantyGuarantorParts;
    }

    public static String getPName_WarrantyDescription()
    {
        return pName_WarrantyDescription;
    }

    public static String getPName_WarrantyName()
    {
        return pName_WarrantyName;
    }

    public static String getPnameWarrantydurationlabor()
    {
        return pName_WarrantyDurationLabor;
    }

    public static String getPnameWarrantydurationparts()
    {
        return pName_WarrantyDurationParts;
    }

    public static String getPnameWarrantyguarantorlabor()
    {
        return pName_WarrantyGuarantorLabor;
    }

    public static String getPnameWarrantyguarantorparts()
    {
        return pName_WarrantyGuarantorParts;
    }

    private static String getPsetDescription()
    {
        return pSetDescription;
    }

    public static String getPsetName()
    {
        return pSetName;
    }

    public COBie_Warranty()
    {
        super();
        initializeSingleValueProperties();
        setDirectAttributes();
    }

    public COBie_Warranty(TypeType cobieType)
    {
        this();
        setWarrantyName(cobieType.getWarrantyDescription());
        setWarrantyDescription(cobieType.getWarrantyDescription());
        setWarrantyGuarantorParts(cobieType.getWarrantyGuarantorParts());
        setWarrantyGuarantorLabor(cobieType.getWarrantyGuarantorLabor());
        setWarrantyDurationParts(cobieType.getWarrantyDurationParts(), cobieType.getWarrantyDurationUnit());
        setWarrantyDurationLabor(cobieType.getWarrantyDurationLabor(), cobieType.getWarrantyDurationUnit());
    }

    private IfcUnit durationUnitsFromString(String durationUnits)
    {
        TimeUnitSearch timeUnits = new TimeUnitSearch(durationUnits);
        return timeUnits.getMatchedUnit();
    }

    public String getWarrantyDurationLabor()
    {
        return PropertySetUtility.getPropertySetPropertyValueOfName(pName_WarrantyDurationLabor, this);
    }

    private void initializeSingleValueProperties()
    {
        IfcPropertySingleValue warrantyName = Ifc2x3tc1Factory.eINSTANCE.createIfcPropertySingleValue();
        warrantyName.setName(getPName_WarrantyName());
        warrantyName.setDescription(getPDescribe_Warrantyname());
        super.getHasProperties().add(warrantyName);

        IfcPropertySingleValue warrantyDescription = Ifc2x3tc1Factory.eINSTANCE.createIfcPropertySingleValue();
        warrantyDescription.setName(getPName_WarrantyDescription());
        warrantyDescription.setDescription(getPdescribeWarrantydescription());
        super.getHasProperties().add(warrantyDescription);

        IfcPropertySingleValue warrantyGParts = Ifc2x3tc1Factory.eINSTANCE.createIfcPropertySingleValue();
        warrantyGParts.setName(getPnameWarrantyguarantorparts());
        warrantyGParts.setDescription(getPdescribeWarrantyguarantorparts());
        super.getHasProperties().add(warrantyGParts);

        IfcPropertySingleValue warrantyDParts = Ifc2x3tc1Factory.eINSTANCE.createIfcPropertySingleValue();
        warrantyDParts.setName(getPnameWarrantydurationparts());
        warrantyDParts.setDescription(getPdescribeWarrantydurationparts());
        super.getHasProperties().add(warrantyDParts);

        IfcPropertySingleValue warrantyGLabor = Ifc2x3tc1Factory.eINSTANCE.createIfcPropertySingleValue();
        warrantyGLabor.setName(getPnameWarrantyguarantorlabor());
        warrantyGLabor.setDescription(getPdescribeWarrantyguarantorlabor());
        super.getHasProperties().add(warrantyGLabor);

        IfcPropertySingleValue warrantyDLabor = Ifc2x3tc1Factory.eINSTANCE.createIfcPropertySingleValue();
        warrantyDLabor.setName(getPnameWarrantydurationlabor());
        warrantyDLabor.setDescription(getPdescribeWarrantydurationlabor());
        super.getHasProperties().add(warrantyDLabor);

    }

    public void setDirectAttributes()
    {
        setName(getPsetName());
        setDescription(getPsetDescription());
    }

    private void setWarrantyDescription(String description)
    {
        IfcLabel descriptionLabel = PropertyUtility.initializeLabel(description);
        PropertySetUtility.setPropertySetPropertyValueOfName(pName_WarrantyDescription, this, descriptionLabel);
    }

    private void setWarrantyDurationLabor(String duration, String durationUnits)
    {
        IfcReal durationReal = PropertyUtility.initializeRealToStringVal(duration);
        IfcUnit durationUnit;
        if (!COBieUtility.isNA(durationUnits))
        {
            durationUnit = durationUnitsFromString(durationUnits);
            PropertySetUtility.setPropertySetPropertyUnitNameOf(pName_WarrantyDurationLabor, this, durationUnit);

        }
        if (!COBieUtility.isValueSetAsStringNA(durationReal))
        {
            PropertySetUtility.setPropertySetPropertyValueOfName(pName_WarrantyDurationLabor, this, durationReal);
        }
    }

    private void setWarrantyDurationParts(String duration, String durationUnits)
    {
        IfcReal durationReal = PropertyUtility.initializeRealToStringVal(duration);
        IfcUnit durationUnit;
        if (!COBieUtility.isNA(durationUnits))
        {
            durationUnit = durationUnitsFromString(durationUnits);
            PropertySetUtility.setPropertySetPropertyUnitNameOf(pName_WarrantyDurationParts, this, durationUnit);

        }
        if (!COBieUtility.isValueSetAsStringNA(durationReal))
        {
            PropertySetUtility.setPropertySetPropertyValueOfName(pName_WarrantyDurationParts, this, durationReal);
        }

    }

    private void setWarrantyGuarantorLabor(String guarantor)
    {
        IfcLabel guarantorLabel = PropertyUtility.initializeLabel(guarantor);
        PropertySetUtility.setPropertySetPropertyValueOfName(pName_WarrantyGuarantorLabor, this, guarantorLabel);
    }

    private void setWarrantyGuarantorParts(String guarantor)
    {
        IfcLabel guarantorLabel = PropertyUtility.initializeLabel(guarantor);
        PropertySetUtility.setPropertySetPropertyValueOfName(pName_WarrantyGuarantorParts, this, guarantorLabel);
    }

    private void setWarrantyName(String name)
    {
        IfcLabel nameLabel = PropertyUtility.initializeLabel(name);
        PropertySetUtility.setPropertySetPropertyValueOfName(pName_WarrantyName, this, nameLabel);
    }

}
