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
import org.bimserver.cobie.cobielite.TypeType;
import org.bimserver.cobie.utils.spreadsheetml.SpreadsheetToTypes;
import org.bimserver.models.ifc2x3.Ifc2x3Factory;
import org.bimserver.models.ifc2x3.IfcLabel;
import org.bimserver.models.ifc2x3.IfcPropertySingleValue;
import org.bimserver.models.ifc2x3.IfcReal;
import org.bimserver.models.ifc2x3.impl.IfcPropertySetImpl;


public class Pset_Warranty extends IfcPropertySetImpl
{
	private static final String pSetName = "Pset_Warranty";
	private static final String pSetDescription = 
			"Warranty Information.";
	private static final String pName_WarrantyName = "WarrantyName";
	private static final String pDescribe_WarrantyName = "The name of the warranty";
	private static final String pName_WarrantyDescription = "WarrantyDescription";
	private static final String pDescribe_WarrantyDescription = "Description of the Warranty";
	private static final String pName_WarrantyGuarantorParts = 
			SpreadsheetToTypes.TypeColumnNameLiterals.WarrantyGuarantorParts.toString();
	private static final String pDescribe_WarrantyGuarantorParts =
			"Organization acting as guarantor of parts warranty";
	private static final String pName_WarrantyDurationParts =
			SpreadsheetToTypes.TypeColumnNameLiterals.WarrantyDurationParts.toString();
	private static final String pDescribe_WarrantyDurationParts =
			"Duration of parts warranty (years)";
	private static final String pName_WarrantyGuarantorLabor =
			SpreadsheetToTypes.TypeColumnNameLiterals.WarrantyGuarantorLabor.toString();
	private static final String pDescribe_WarrantyGuarantorLabor =
			"Organization acting as guarantor of labor warranty";
	private static final String pName_WarrantyDurationLabor =
			SpreadsheetToTypes.TypeColumnNameLiterals.WarrantyDurationLabor.toString();
	private static final String pDescribe_WarrantyDurationLabor=
			"Duration of labor warranty (years)";
	public Pset_Warranty()
	{
		super();
		initializeSingleValueProperties();
		setDirectAttributes();
	}

	public Pset_Warranty(TypeType cobieType)
	{
		this();	
		setWarrantyName(cobieType.getWarrantyDescription());
		setWarrantyDescription(cobieType.getWarrantyDescription());
		setWarrantyGuarantorParts(cobieType.getWarrantyGuarantorParts());
		setWarrantyGuarantorLabor(cobieType.getWarrantyGuarantorLabor());
		setWarrantyDurationParts(cobieType.getWarrantyDurationParts());
		setWarrantyDurationLabor(cobieType.getWarrantyDurationLabor());
	}
	private void initializeSingleValueProperties()
	{
		IfcPropertySingleValue warrantyName =
				Ifc2x3Factory.eINSTANCE.createIfcPropertySingleValue();
		warrantyName.setName(getPName_WarrantyName());
		warrantyName.setDescription(getPDescribe_Warrantyname());
		super.getHasProperties().add(warrantyName);
		
		IfcPropertySingleValue warrantyDescription =
				Ifc2x3Factory.eINSTANCE.createIfcPropertySingleValue();
		warrantyDescription.setName(getPName_WarrantyDescription());
		warrantyDescription.setDescription(getPdescribeWarrantydescription());
		super.getHasProperties().add(warrantyDescription);
		
		IfcPropertySingleValue warrantyGParts =
				Ifc2x3Factory.eINSTANCE.createIfcPropertySingleValue();
		warrantyGParts.setName(getPnameWarrantyguarantorparts());
		warrantyGParts.setDescription(getPdescribeWarrantyguarantorparts());
		super.getHasProperties().add(warrantyGParts);
		
		IfcPropertySingleValue warrantyDParts =
				Ifc2x3Factory.eINSTANCE.createIfcPropertySingleValue();
		warrantyDParts.setName(getPnameWarrantydurationparts());
		warrantyDParts.setDescription(getPdescribeWarrantydurationparts());
		super.getHasProperties().add(warrantyDParts);
		
		IfcPropertySingleValue warrantyGLabor =
				Ifc2x3Factory.eINSTANCE.createIfcPropertySingleValue();
		warrantyGLabor.setName(getPnameWarrantyguarantorlabor());
		warrantyGLabor.setDescription(getPdescribeWarrantyguarantorlabor());
		super.getHasProperties().add(warrantyGLabor);
		
		IfcPropertySingleValue warrantyDLabor =
				Ifc2x3Factory.eINSTANCE.createIfcPropertySingleValue();
		warrantyDLabor.setName(getPnameWarrantydurationlabor());
		warrantyDLabor.setDescription(getPdescribeWarrantydurationlabor());
		super.getHasProperties().add(warrantyDLabor);
		
	}
	
	private void setWarrantyName(String name)
	{
		IfcLabel nameLabel =
				PropertyUtility.initializeLabel(name);
		PropertySetUtility.
		setPropertySetPropertyValueOfName(pName_WarrantyName, 
				this,nameLabel);
	}
	private void setWarrantyDescription(String description)
	{
		IfcLabel descriptionLabel =
				PropertyUtility.initializeLabel(description);
		PropertySetUtility.
		setPropertySetPropertyValueOfName(pName_WarrantyDescription, 
				this,descriptionLabel);
	}
	private void setWarrantyGuarantorParts(String guarantor)
	{
		IfcLabel guarantorLabel =
				PropertyUtility.initializeLabel(guarantor);
		PropertySetUtility.
		setPropertySetPropertyValueOfName(pName_WarrantyGuarantorParts, 
				this,guarantorLabel);
	}
	private void setWarrantyGuarantorLabor(String guarantor)
	{
		IfcLabel guarantorLabel =
				PropertyUtility.initializeLabel(guarantor);
		PropertySetUtility.
		setPropertySetPropertyValueOfName(pName_WarrantyGuarantorLabor, 
				this,guarantorLabel);
	}
	private void setWarrantyDurationParts(String duration)
	{
		IfcReal durationReal =
				PropertyUtility.initializeRealToStringVal(duration);
		PropertySetUtility.
		setPropertySetPropertyValueOfName(pName_WarrantyDurationParts, 
				this,durationReal);
	}
	private void setWarrantyDurationLabor(String duration)
	{
		IfcReal durationReal =
				PropertyUtility.initializeRealToStringVal(duration);
		PropertySetUtility.
		setPropertySetPropertyValueOfName(pName_WarrantyDurationLabor, 
				this,durationReal);
	}
	public String getWarrantyDurationLabor()
	{
		return PropertySetUtility.
				getPropertySetPropertyValueOfName(pName_WarrantyDurationLabor,this);
	}
	
	public void setDirectAttributes()
	{
		this.setName(getPsetName());
		this.setDescription(getPsetDescription());
	}
	

	
	public static String getPsetName() {
		return pSetName;
	}
	
	
	private static String getPsetDescription() {
		return pSetDescription;
	}

	public static String getPName_WarrantyName()
	{
		return pName_WarrantyName;
	}

	public static String getPDescribe_Warrantyname()
	{
		return pDescribe_WarrantyName;
	}

	public static String getPName_WarrantyDescription()
	{
		return pName_WarrantyDescription;
	}

	public static String getPnameWarrantyguarantorparts()
	{
		return pName_WarrantyGuarantorParts;
	}

	public static String getPdescribeWarrantydescription()
	{
		return pDescribe_WarrantyDescription;
	}

	public static String getPdescribeWarrantyguarantorparts()
	{
		return pDescribe_WarrantyGuarantorParts;
	}

	public static String getPnameWarrantydurationparts()
	{
		return pName_WarrantyDurationParts;
	}

	public static String getPdescribeWarrantydurationparts()
	{
		return pDescribe_WarrantyDurationParts;
	}

	public static String getPnameWarrantyguarantorlabor()
	{
		return pName_WarrantyGuarantorLabor;
	}

	public static String getPdescribeWarrantyguarantorlabor()
	{
		return pDescribe_WarrantyGuarantorLabor;
	}

	public static String getPnameWarrantydurationlabor()
	{
		return pName_WarrantyDurationLabor;
	}

	public static String getPdescribeWarrantydurationlabor()
	{
		return pDescribe_WarrantyDurationLabor;
	}
	
}
