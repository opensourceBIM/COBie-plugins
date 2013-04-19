package org.erdc.cobie.toolkit.gui.controls;

import java.io.File;
import java.util.Collection;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileSystemView;

import org.bimserver.plugins.serializers.SerializerPlugin;
import org.erdc.cobie.toolkit.CobieToolkit;

public class SerializerFileChoser extends CobieFileChoser
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8814071073558628854L;
	private CobieToolkit cobieToolkit;
	public SerializerFileChoser(CobieToolkit cobieSatelliteServer)
	{
		super();
		this.cobieToolkit = cobieSatelliteServer;
		initializeFileFilters();
	}
	
	public void initializeFileFilters()
	{
		Collection<SerializerPlugin> serializers=
		cobieToolkit.getPluginManager().getAllSerializerPlugins(true);

		for(SerializerPlugin serializer:serializers)
		{
			boolean isCOBieXMLDataSerializer =
					CobieToolkit.isBaseCOBieXMLPlugin(serializer);
			if(serializer.isInitialized()&&!isCOBieXMLDataSerializer)
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
	
	@Override
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
