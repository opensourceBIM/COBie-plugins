package org.bimserver.cobie.shared.serialization;

import org.bimserver.cobie.shared.Common;

public enum SerializableFileType
{
	
	HTML("html", Common.FILE_EXTENSION_PREFIX.postfix("html")), 
	SPREADSHEETML("xml","application/vnd.ms-excel"),
	XLSX("xlsx",Common.FILE_EXTENSION_PREFIX.postfix("xlsx")), 
	XML("xml",Common.FILE_EXTENSION_PREFIX.postfix("xml"));
	
	private final String extension;
	private final String contentType;
	private SerializableFileType(String extension, String contentType)
	{
		this.extension = extension;
		this.contentType = contentType;
	}
	
	public String getExtension()
	{
		return extension;
	}
	
	public String getContentType()
	{
		return contentType;
		//return Common.FILE_EXTENSION_PREFIX.postfix(extension);
	}
}
