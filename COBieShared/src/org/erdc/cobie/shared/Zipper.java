package org.erdc.cobie.shared;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;

public class Zipper
{
    private boolean deleteOriginalFile;
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
        this(outputStream, false);
    }
    
    public Zipper(OutputStream outputStream, boolean deleteOriginalFiles)
    {
        this.zip = new ZipOutputStream(outputStream);
        setDeleteOriginalFile(deleteOriginalFiles);
    }
    
    public void addEntry(File file) throws IOException
    {
        ZipEntry entry = new ZipEntry(file.getPath());
        
        this.getZipOutputStream().putNextEntry(entry);              
        this.getZipOutputStream().write(FileUtils.readFileToByteArray(file));
        this.getZipOutputStream().closeEntry();
        
        if (this.getDeleteOriginalFile())
        {
            file.delete();
        }
    }
    
    public boolean getDeleteOriginalFile()
    {
        return this.deleteOriginalFile;
    }
    
    public final ZipOutputStream getZipOutputStream()
    {
        return this.zip;
    }
    
    public void setDeleteOriginalFile(boolean deleteOriginalFile)
    {
        this.deleteOriginalFile = deleteOriginalFile;
    }
    
    public void writeZipArchive() throws IOException
    {
        this.getZipOutputStream().close();
    }
}
