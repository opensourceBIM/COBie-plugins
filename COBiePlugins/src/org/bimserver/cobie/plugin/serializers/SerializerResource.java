package org.bimserver.cobie.plugin.serializers;

public enum SerializerResource 
{
	LOCAL_IFC_COBIE_TRANSFORM_CONFIG("lib/IfcToCobieConfig.xml"), 
	RUNTIME_IFC_COBIE_TRANSFORM_CONFIG("CobiePlugins/config/IfcToCobieConfig.xml");
	private final String resourcePath;
	
	private SerializerResource(String resourcePath)
	{
		this.resourcePath = resourcePath;
	}
	
	@Override
	public String toString()
	{
		return resourcePath;
	}
	
}
