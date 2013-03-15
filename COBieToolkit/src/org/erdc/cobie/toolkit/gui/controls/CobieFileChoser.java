package org.erdc.cobie.toolkit.gui.controls;

import java.awt.Component;
import java.awt.HeadlessException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;


import org.erdc.cobie.shared.COBieSharedUtilities.COBIE_FILE_TYPE;
import org.erdc.cobie.toolkit.CobieToolkit;

public class CobieFileChoser extends JFileChooser
{
	private static final long serialVersionUID = 1L;
	//private COBIE_FILE_TYPE fileType;
	private List<COBIE_FILE_TYPE> fileTypes;
	private COBIE_FILE_TYPE chosenFileType;
	public CobieFileChoser()
	{
		super();
	}
	
	public CobieFileChoser(COBIE_FILE_TYPE cobieFileType)
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
		fileTypes = new ArrayList<COBIE_FILE_TYPE>();
	}
	
	public CobieFileChoser(List<COBIE_FILE_TYPE> cobieFileTypes)
	{
		init();
		fileTypes = cobieFileTypes;
		initializeFileFilter();
	}
	


	private void initializeFileFilter()
	{
		for(COBIE_FILE_TYPE fileType:fileTypes)
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

	public COBIE_FILE_TYPE getChosenFileType()
	{
		return chosenFileType;
	}

	private void setChosenFileType(COBIE_FILE_TYPE chosenFile)
	{
		this.chosenFileType = chosenFile;
	}

	
}
