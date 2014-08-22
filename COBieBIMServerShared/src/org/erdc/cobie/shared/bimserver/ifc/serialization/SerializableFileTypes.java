package org.erdc.cobie.shared.bimserver.ifc.serialization;

import org.erdc.cobie.shared.Common;

public enum SerializableFileTypes
{
	XML("xml"),HTML("html"), XLSX("xlsx");
	
	private final String extension;
	private SerializableFileTypes(String extension)
	{
		this.extension = extension;
	}
	
	public String getExtension()
	{
		return extension;
	}
	
	public String getContentType()
	{
		return Common.FILE_EXTENSION_PREFIX.postfix(extension);
	}
}
