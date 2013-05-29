package org.erdc.cobie.toolkit.gui.controls;

import java.io.File;

import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.bimserver.plugins.serializers.AbstractSerializerPlugin;
import org.bimserver.plugins.serializers.SerializerPlugin;

public class SerializerFileFilter extends FileFilter
{

	private String serializerName;
	private SerializerPlugin serializerPlugin;
	private FileNameExtensionFilter extensionFilter;
	private String extension;
	public SerializerFileFilter(AbstractSerializerPlugin serializerPlugin)
	{
		setSerializerName(serializerPlugin.getDefaultName());
		setSerializerPlugin(serializerPlugin);
		setExtension(serializerPlugin.getDefaultExtension());
		String description = serializerPlugin.getDefaultName()+"("+
		serializerPlugin.getDefaultExtension()+")";
		extensionFilter = new FileNameExtensionFilter(description,extension);
	}
	@Override
	public boolean accept(File f)
	{
		return (f.isDirectory() || extensionFilter.accept(f));
	}

	@Override
	public String getDescription()
	{
		return extensionFilter.getDescription();
	}
	public String getSerializerName()
	{
		return serializerName;
	}
	private void setSerializerName(String serializerName)
	{
		this.serializerName = serializerName;
	}
	public SerializerPlugin getSerializerPlugin()
	{
		return serializerPlugin;
	}
	private void setSerializerPlugin(SerializerPlugin serializerPlugin)
	{
		this.serializerPlugin = serializerPlugin;
	}
	public String getExtension()
	{
		return extension;
	}
	private void setExtension(String extension)
	{
		this.extension = extension;
	}

}
