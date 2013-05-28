package org.erdc.cobie.toolkit.gui.controls;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

import org.erdc.cobie.shared.PluginUtilities.OutgingFileType;
import org.erdc.cobie.toolkit.CobieToolkit;

public class CobieFileChoser extends JFileChooser
{
	private static final long serialVersionUID = 1L;
	//private COBIE_FILE_TYPE fileType;
	private List<OutgingFileType> fileTypes;
	private OutgingFileType chosenFileType;
	public CobieFileChoser()
	{
		super();
	}
	
	public CobieFileChoser(OutgingFileType cobieFileType)
	{
		init();
		fileTypes.add(cobieFileType);
		initializeFileFilter();
	}
	
	public void initializeCurrentDirectory(CobieToolkit cobieToolkit)
	{
		File lastDirectoryAccessed = cobieToolkit.getLastDirectoryAccessed();
		if(lastDirectoryAccessed!=null && lastDirectoryAccessed.exists())
			this.setCurrentDirectory(lastDirectoryAccessed);
	}
	
	
	private void init()
	{
		fileTypes = new ArrayList<OutgingFileType>();
	}
	
	public CobieFileChoser(List<OutgingFileType> cobieFileTypes)
	{
		init();
		fileTypes = cobieFileTypes;
		initializeFileFilter();
	}
	


	private void initializeFileFilter()
	{
		for(OutgingFileType fileType:fileTypes)
		{
			COBieFileFilter fileFilter =
					new COBieFileFilter(fileType);
			this.addChoosableFileFilter(fileFilter);
		}
		this.setAcceptAllFileFilterUsed(false);
	
	}
	
	public File getSelectedFileWithFilterExtension()
	{
		File selectedFile = super.getSelectedFile();
		String fileName = selectedFile.getName();
		COBieFileFilter cobieFileFilter =
				getCurrentCOBieFileFilter();
		setChosenFileType(cobieFileFilter.getCobieFileType());
		String extensionFilterString = "."+cobieFileFilter.getExtensionString();
		if (!fileName.endsWith(extensionFilterString))
		{
			selectedFile = new File(selectedFile.getAbsolutePath()+extensionFilterString);
		}
		return selectedFile;
		
	}
	
	public COBieFileFilter getCurrentCOBieFileFilter()
	{
		COBieFileFilter cobieFileFilter = null;
		FileFilter currentFileFilter = this.getFileFilter();
		if (currentFileFilter instanceof COBieFileFilter)
			cobieFileFilter = (COBieFileFilter) currentFileFilter;
		return cobieFileFilter;
	}

	public OutgingFileType getChosenFileType()
	{
		return chosenFileType;
	}

	private void setChosenFileType(OutgingFileType chosenFile)
	{
		this.chosenFileType = chosenFile;
	}

	
}
