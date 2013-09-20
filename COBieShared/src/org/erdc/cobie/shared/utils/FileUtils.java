package org.erdc.cobie.shared.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtils
{

    public static void copyfile(String fromFilePath, String toFilePath) throws IOException{
      try{
      File from = new File(fromFilePath);
      File to = new File(toFilePath);
      InputStream in = new FileInputStream(from);
    
      OutputStream out = new FileOutputStream(to);
    
      byte[] buf = new byte[1024];
      int len;
      while ((len = in.read(buf)) > 0){
      out.write(buf, 0, len);
      }
      in.close();
      out.close();
      System.out.println("File copied.");
      }
      catch(FileNotFoundException ex){
    	  throw ex;
      }
      catch(IOException e){
       throw e;  
      }
      }
}
