package org.erdc.cobie.toolkit.gui.controls;

import java.io.File;

import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.erdc.cobie.shared.PluginUtilities;
import org.erdc.cobie.shared.PluginUtilities.OutgingFileType;

public class COBieFileFilter extends FileFilter
{
	private static final String FILE_FILTER_FORMAT_STRING = "%s (%s) %s";
	private OutgingFileType cobieFileType;
	private String extensionString;
	public String getExtensionString()
	{
		return extensionString;
	}
	private FileNameExtensionFilter extensionFilter;
	
	protected String getFileMenuDisplayString(OutgingFileType cobieFileType,String fileExtension,String shortDescription)
	{
		return String.format(FILE_FILTER_FORMAT_STRING, cobieFileType.name(),fileExtension,shortDescription);
	}
	public COBieFileFilter(OutgingFileType cobieFileType)
	{
		super();
		this.cobieFileType = cobieFileType;
		extensionString = PluginUtilities.COBIE_FILE_TYPE_TO_FILE_EXTENSIONS.get(cobieFileType);
		if (extensionString.startsWith("."))
			extensionString = extensionString.substring(1);
		String description =getFileMenuDisplayString
				(cobieFileType,extensionString,
						PluginUtilities.COBIE_FILE_TYPE_TO_SHORT_DESCRIPTION.get(cobieFileType));
		extensionFilter = new FileNameExtensionFilter(description, extensionString);
	}
	
	

	@Override
	public boolean accept(File f)
	{
		/*boolean acceptFile = false;
		if (f.getName().endsWith(extensionString) || f.isDirectory())
			acceptFile = true;
		// TODO Auto-generated method stub
		return acceptFile;*/
		return (f.isDirectory() || extensionFilter.accept(f));
	}

	@Override
	public String getDescription()
	{
		return extensionFilter.getDescription();
	}

	public OutgingFileType getCobieFileType()
	{
		return cobieFileType;
	}


}
