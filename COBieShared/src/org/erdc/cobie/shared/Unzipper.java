package org.erdc.cobie.shared;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.apache.commons.io.IOUtils;

public class Unzipper
{

	private final ZipFile zipFile;
	public Unzipper(ZipFile zipFile)
	{

		this.zipFile = zipFile;
	}
	
	public InputStream getEntry(String path) throws IOException
	{
		ZipEntry zipEntry;
		InputStream result = null;
		Enumeration<? extends ZipEntry> entries = getZipFile().entries();
		while (entries.hasMoreElements())
		{
			zipEntry = entries.nextElement();
			URI pathURI = URI.create(path);
			URI zipEntryURI = URI.create(zipEntry.getName().replace("\\", "/"));
			if(pathURI.equals(zipEntryURI))
			{
				result = zipFile.getInputStream(zipEntry);
				break;
			}
		}
		return result;
	}
	
	public void unzipTo(String destination) throws IOException
	{
		ZipEntry zipEntry;
		Enumeration<? extends ZipEntry> entries = getZipFile().entries();
		while (entries.hasMoreElements())
		{
			zipEntry = entries.nextElement();
			if(zipEntry.isDirectory())
			{
				File directory = new File(zipEntry.getName());
				if(!directory.exists())
				{
					directory.mkdirs();
				}
			}
			else
			{
				InputStream inputStream = zipFile.getInputStream(zipEntry);
				File destinationFile = new File(zipEntry.getName());
				createNewFileAndDirectories(destinationFile);
				FileOutputStream destinationStream = new FileOutputStream(destinationFile);
				IOUtils.copy(inputStream, destinationStream);
			}

		}
	}

	/**
	 * @param destinationFile
	 * @throws IOException
	 */
	public void createNewFileAndDirectories(File destinationFile) throws IOException
	{
		if(!destinationFile.exists())
		{
			if(destinationFile.getParentFile() != null)
			{
				destinationFile.getParentFile().mkdirs();
			}
			destinationFile.createNewFile();
		}
	}
	
	public File getEntry(String entryPath, String destinationPath) throws IOException
	{
		File entryFile = null;
		InputStream inputStream = getEntry(entryPath);
		entryFile = new File(destinationPath);
		IOUtils.copy(inputStream, new FileOutputStream(new File(destinationPath)));
		return entryFile;
		
	}
	
	private ZipFile getZipFile()
	{
		return zipFile;
	}

}
