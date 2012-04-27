package org.bimserver.cobie.utils.stringwriters;
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

import org.bimserver.models.ifc2x3tc1.IfcPropertySingleValue;


public class IfcSingleValueToCOBieString extends IfcPropertyToCOBieString 
{
	private String unitString;
	public IfcSingleValueToCOBieString() 
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public IfcSingleValueToCOBieString(IfcPropertySingleValue property) 
	{
		super(property);
		this.setPropertyTypeString(IfcPropertySingleValue.class.getSimpleName());
		this.setValueString(property.getNominalValue());
		this.setUnitString(IfcUnitToCOBieString.stringFromUnit(property.getUnit()));
		// TODO Auto-generated constructor stub		
	}

	public String getUnitString() 
	{
		return unitString;
	}

	private void setUnitString(String unitString) 
	{
		this.unitString = unitString;
	}
	
	
	

	
}
