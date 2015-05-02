package org.bimserver.cobie.shared.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.bimserver.cobie.shared.Common;

public class FileUtils
{
	public static boolean doesFileExist(File file)
	{
		return (file != null) && file.exists();
	}
	
	public static String getFileNameSafely(File file)
	{
		return (file == null) ? Common.NULL.toString() : file.getName();
	}

	public static void copyfile(String fromFilePath, String toFilePath) throws IOException
    {
		File from = new File(fromFilePath);
		File to = new File(toFilePath);
		InputStream in = new FileInputStream(from);	    
		OutputStream out = new FileOutputStream(to);
    
		byte[] buf = new byte[1024];
		int len;
      
		while ((len = in.read(buf)) > 0)
		{
			out.write(buf, 0, len);
		}
      
		in.close();
		out.close();
      
		//System.out.println("File copied.");
    }
}
