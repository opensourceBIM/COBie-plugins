package org.bimserver.cobie.satellite.gui.controls;

import java.io.File;
import java.util.Collection;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileSystemView;

import org.bimserver.cobie.satellite.CobieSatelliteServer;
import org.bimserver.plugins.serializers.SerializerPlugin;

public class SerializerFileChoser extends JFileChooser
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8814071073558628854L;
	private CobieSatelliteServer cobieSatelliteServer;
	public SerializerFileChoser(CobieSatelliteServer cobieSatelliteServer)
	{
		super();
		this.cobieSatelliteServer = cobieSatelliteServer;
		initializeFileFilters();
	}
	
	public void initializeFileFilters()
	{
		Collection<SerializerPlugin> serializers=
		cobieSatelliteServer.getPluginManager().getAllSerializerPlugins(true);
		for(SerializerPlugin serializer:serializers)
		{
			if(serializer.isInitialized())
				this.addChoosableFileFilter(new SerializerFileFilter(serializer));
		}
		
	}
	
	public SerializerFileFilter getCurrentSerializerFileFilter()
	{
		SerializerFileFilter serializerFileFilter = null;
		FileFilter currentFileFilter = this.getFileFilter();
		if (currentFileFilter instanceof SerializerFileFilter)
			serializerFileFilter = (SerializerFileFilter) currentFileFilter;
		return serializerFileFilter;
	}
	
	public File getSelectedFileWithFilterExtension()
	{
		File selectedFile = super.getSelectedFile();
		String fileName = selectedFile.getName();
		SerializerFileFilter cobieFileFilter =
				getCurrentSerializerFileFilter();
		String extensionFilterString = "."+cobieFileFilter.getExtension();
		if (!fileName.endsWith(extensionFilterString))
		{
			selectedFile = new File(selectedFile.getAbsolutePath()+extensionFilterString);
		}
		return selectedFile;
		
	}

}
