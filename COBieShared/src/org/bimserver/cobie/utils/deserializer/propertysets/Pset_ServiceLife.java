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
import java.util.HashMap;
import java.util.Map;

import org.bimserver.cobie.cobielite.TypeType;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.IfcLabel;
import org.bimserver.models.ifc2x3tc1.IfcProperty;
import org.bimserver.models.ifc2x3tc1.IfcPropertyEnumeratedValue;
import org.bimserver.models.ifc2x3tc1.IfcPropertyEnumeration;
import org.bimserver.models.ifc2x3tc1.IfcPropertySingleValue;
import org.bimserver.models.ifc2x3tc1.IfcReal;
import org.bimserver.models.ifc2x3tc1.IfcValue;
import org.bimserver.models.ifc2x3tc1.impl.IfcPropertySetImpl;
import org.bimserver.shared.cobie.COBieUtility;
import org.bimserver.shared.cobie.targetunits.time.TimeUnitSearch;


public class Pset_ServiceLife extends IfcPropertySetImpl
{
	private static final String ENUMERATION_NAME_PREFIX = "PEnum_";
	public static final String pSetName="Pset_ServiceLife";
	public static final String pSetDescription ="A typical service life that is quoted for an artifact under reference operating conditions.";
	public enum ServiceLifeProperty
	{
		ServiceLifeType,ServiceLifeDuration
	};
	
	public enum ServiceLifeType
	{
		actualservicelife,
		expectedservicelife,
		optimisticreferenceservicelife,
		pessimisticreferenceservicelife,
		referenceservicelife,
		productiontransport,
		other,
		notknown,
		unset
	}
	
	private static final Map<ServiceLifeProperty,String> PropertyDescriptions =
			new HashMap<ServiceLifeProperty,String>()
			{/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

			{
				put(ServiceLifeProperty.ServiceLifeDuration,"The length or duration of a service life.");
				put(ServiceLifeProperty.ServiceLifeType,pSetDescription);
			}};
	public Pset_ServiceLife()
	{
		super();
		setDirectAttributes();
		initializeProperties();
	}
	
	public Pset_ServiceLife(TypeType cobieType)
	{
		this();
		setServiceLifeType();
		setServiceLifeDurationAndUnit(cobieType.getExpectedLife(),cobieType.getDurationUnit());
	}
	
	public void setServiceLifeDuration(String duration)
	{
		IfcReal durationReal =
				PropertyUtility.initializeRealToStringVal(duration);
		if (!COBieUtility.isValueSetAsStringNA(durationReal))
			PropertySetUtility.setPropertySetPropertyValueOfName
			(ServiceLifeProperty.ServiceLifeDuration.toString(),this,durationReal);
	}
	
	public void setServiceLifeDurationAndUnit(String duration,String unit)
	{
		IfcReal durationReal =
				PropertyUtility.initializeRealToStringVal(duration);
		if(!COBieUtility.isNA(unit))
		{
			TimeUnitSearch durationUnits= new TimeUnitSearch(unit);
			PropertySetUtility.setPropertySetPropertyUnitNameOf
			(ServiceLifeProperty.ServiceLifeDuration.toString(),
					this,durationUnits.getMatchedUnit());
		}
		
		 if (!COBieUtility.isValueSetAsStringNA(durationReal))
			PropertySetUtility.setPropertySetPropertyValueOfName
			(ServiceLifeProperty.ServiceLifeDuration.toString(),this,durationReal);
	}
	
	public void setServiceLifeType()
	{
		for(IfcProperty property : this.getHasProperties())
		{
			if (property.getName().equals(ServiceLifeProperty.ServiceLifeType.toString())&&
					property instanceof IfcPropertyEnumeratedValue)
			{
				IfcPropertyEnumeratedValue svcLifeType =
						(IfcPropertyEnumeratedValue) property;
				for(IfcValue val : svcLifeType.getEnumerationReference().getEnumerationValues())
				{
					if (val instanceof IfcLabel)
					{
						IfcLabel lbl = (IfcLabel) val;
						if (lbl.getWrappedValue().equals(ServiceLifeType.expectedservicelife.name()))
							svcLifeType.getEnumerationValues().add(lbl);
					}
				}
			}
		}
	}
	
	private void initializeProperties()
	{
		IfcPropertySingleValue serviceLifeDuration =
				Ifc2x3tc1Factory.eINSTANCE.createIfcPropertySingleValue();
		serviceLifeDuration.setName(ServiceLifeProperty.ServiceLifeDuration.toString());
		serviceLifeDuration.setDescription(PropertyDescriptions.get(ServiceLifeProperty.ServiceLifeDuration));
		this.getHasProperties().add(serviceLifeDuration);
		
		IfcPropertyEnumeratedValue serviceLifeType =
				Ifc2x3tc1Factory.eINSTANCE.createIfcPropertyEnumeratedValue();
		serviceLifeType.setName(ServiceLifeProperty.ServiceLifeType.toString());
		serviceLifeType.setDescription(PropertyDescriptions.get(ServiceLifeProperty.ServiceLifeType));
		IfcPropertyEnumeration svcEnum =
				Ifc2x3tc1Factory.eINSTANCE.createIfcPropertyEnumeration();
		svcEnum.setName(getServiceLifeEnumerationName());
		for(ServiceLifeType svcType : ServiceLifeType.values())
		{
			IfcLabel lbl =
					PropertyUtility.initializeLabel(svcType.toString());
			svcEnum.getEnumerationValues().add(lbl);
		}
		serviceLifeType.setEnumerationReference(svcEnum);
		this.getHasProperties().add(serviceLifeType);
		
	}

	private String getServiceLifeEnumerationName()
	{
		return ENUMERATION_NAME_PREFIX+ServiceLifeProperty.ServiceLifeType.toString();
	}
	
	public void setDirectAttributes()
	{
		this.setName(pSetName);
		this.setDescription(pSetDescription);
	}
}
