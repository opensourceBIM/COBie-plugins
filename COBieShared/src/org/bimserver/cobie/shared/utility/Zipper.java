package org.bimserver.cobie.shared.utility;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;

public class Zipper
{
    private final ZipOutputStream zip;
    
    public Zipper(OutputStream outputStream)
    {
        this.zip = new ZipOutputStream(outputStream);
    }
     
    public void addEntry(File file, boolean deleteOriginalFile) throws IOException
    {
        ZipEntry entry = new ZipEntry(file.getPath());
        
        getZipOutputStream().putNextEntry(entry); 
        getZipOutputStream().write(FileUtils.readFileToByteArray(file));
        getZipOutputStream().closeEntry();
        
        if (deleteOriginalFile)
        {
            file.delete();
        }
    }
       
    public void addEntry(File file, String relativePath, boolean deleteOriginalFile) throws IOException
    {
        ZipEntry entry = new ZipEntry(relativePath);
        
        getZipOutputStream().putNextEntry(entry);              
        getZipOutputStream().write(FileUtils.readFileToByteArray(file));
        getZipOutputStream().closeEntry();
        
        if (deleteOriginalFile)
        {
            file.delete();
        }
    }
    
    public void addEntry(byte[] data, String relativePath) throws IOException
    {
        ZipEntry entry = new ZipEntry(relativePath);
        
        getZipOutputStream().putNextEntry(entry);              
        getZipOutputStream().write(data);
        getZipOutputStream().closeEntry();
    }
       
    public void addEntry(File file) throws IOException
    {
        addEntry(file, true);
    }
    
    public void addEntry(File file, String relativePath) throws IOException
    {
        addEntry(file, relativePath, true);
    }

    public final ZipOutputStream getZipOutputStream()
    {
        return zip;
    }
    
    public void writeZipArchive() throws IOException
    {
        getZipOutputStream().close();
    }
}
