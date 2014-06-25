package org.erdc.cobie.shared.enums.string;

public enum FileTypes
{
	XML("xml"),HTML("html"), XLSX("xlsx");
	
	private final String extension;
	private FileTypes(String extension)
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
