package org.bimserver.cobie.utils.IFCWriters.PropertySets;
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

import org.bimserver.models.ifc2x3.Ifc2x3Factory;
import org.bimserver.models.ifc2x3.IfcLabel;
import org.bimserver.models.ifc2x3.IfcProperty;
import org.bimserver.models.ifc2x3.IfcPropertyEnumeratedValue;
import org.bimserver.models.ifc2x3.IfcPropertyEnumeration;
import org.bimserver.models.ifc2x3.IfcPropertySingleValue;
import org.bimserver.models.ifc2x3.IfcReal;
import org.bimserver.models.ifc2x3.IfcValue;
import org.bimserver.models.ifc2x3.impl.IfcPropertySetImpl;

import cobieLite.TypeType;

public class Pset_ServiceLife extends IfcPropertySetImpl
{
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
			{{
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
		setServiceLifeDuration(cobieType.getExpectedLife());
	}
	
	public void setServiceLifeDuration(String duration)
	{
		IfcReal durationReal =
				PropertyUtility.initializeRealToStringVal(duration);
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
						if (lbl.getWrappedValue().equals(ServiceLifeType.expectedservicelife))
							svcLifeType.getEnumerationValues().add(lbl);
					}
				}
			}
		}
	}
	
	private void initializeProperties()
	{
		IfcPropertySingleValue serviceLifeDuration =
				Ifc2x3Factory.eINSTANCE.createIfcPropertySingleValue();
		serviceLifeDuration.setName(ServiceLifeProperty.ServiceLifeDuration.toString());
		serviceLifeDuration.setDescription(PropertyDescriptions.get(ServiceLifeProperty.ServiceLifeDuration));
		this.getHasProperties().add(serviceLifeDuration);
		
		IfcPropertyEnumeratedValue serviceLifeType =
				Ifc2x3Factory.eINSTANCE.createIfcPropertyEnumeratedValue();
		serviceLifeType.setName(ServiceLifeProperty.ServiceLifeType.toString());
		serviceLifeType.setDescription(PropertyDescriptions.get(ServiceLifeProperty.ServiceLifeType));
		IfcPropertyEnumeration svcEnum =
				Ifc2x3Factory.eINSTANCE.createIfcPropertyEnumeration();
		for(ServiceLifeType svcType : ServiceLifeType.values())
		{
			IfcLabel lbl =
					PropertyUtility.initializeLabel(svcType.toString());
			svcEnum.getEnumerationValues().add(lbl);
		}
		serviceLifeType.setEnumerationReference(svcEnum);
		this.getHasProperties().add(serviceLifeType);
		
	}
	
	public void setDirectAttributes()
	{
		this.setName(pSetName);
		this.setDescription(pSetDescription);
	}
}
