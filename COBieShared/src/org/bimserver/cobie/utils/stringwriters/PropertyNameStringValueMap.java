package org.bimserver.cobie.utils.stringwriters;

import java.util.HashMap;

import org.bimserver.models.ifc2x3tc1.IfcProperty;

public class PropertyNameStringValueMap extends HashMap<String,String>
{
	private HashMap<String,IfcProperty> propertyMap;
	public PropertyNameStringValueMap()
	{
		super();
		propertyMap = new HashMap<String,IfcProperty>();
	}
	
	public void put(String key,String value,IfcProperty property)
	{
		super.put(key, value);
		propertyMap.put(key, property);
	}
	
	public IfcProperty getAssociatedProperty(String propertyName)
	{
		return propertyMap.get(propertyName);
	}
}
