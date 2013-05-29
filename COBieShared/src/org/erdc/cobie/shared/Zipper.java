package org.erdc.cobie.shared;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;

public class Zipper
{
    private ZipOutputStream zip;
    
//    public Zipper(String archiveName) throws FileNotFoundException
//    {
//        this(archiveName, false);
//    }
//    
//    public Zipper(String archiveName, boolean deleteOriginalFiles) throws FileNotFoundException
//    {
//        this(new FileOutputStream(archiveName), deleteOriginalFiles);
//    }
    
    public Zipper(OutputStream outputStream)
    {
        this.zip = new ZipOutputStream(outputStream);
    }
     
    public void addEntry(File file, boolean deleteOriginalFile) throws IOException
    {
        ZipEntry entry = new ZipEntry(file.getPath());
        
        this.getZipOutputStream().putNextEntry(entry);              
        this.getZipOutputStream().write(FileUtils.readFileToByteArray(file));
        this.getZipOutputStream().closeEntry();
        
        if (deleteOriginalFile)
        {
            file.delete();
        }
    }
       
    public void addEntry(File file, String relativePath, boolean deleteOriginalFile) throws IOException
    {
        ZipEntry entry = new ZipEntry(relativePath);
        
        this.getZipOutputStream().putNextEntry(entry);              
        this.getZipOutputStream().write(FileUtils.readFileToByteArray(file));
        this.getZipOutputStream().closeEntry();
        
        if (deleteOriginalFile)
        {
            file.delete();
        }
    }
    
    public void addEntry(byte[] data, String relativePath) throws IOException
    {
        ZipEntry entry = new ZipEntry(relativePath);
        
        this.getZipOutputStream().putNextEntry(entry);              
        this.getZipOutputStream().write(data);
        this.getZipOutputStream().closeEntry();

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
        return this.zip;
    }
    
    public void writeZipArchive() throws IOException
    {
        this.getZipOutputStream().close();
    }
}
