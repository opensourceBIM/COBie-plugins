package org.erdc.cobie.shared.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.poifs.crypt.Decryptor;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class POIUtils
{
	public static Workbook decryptWorkbook(InputStream inputStream) throws FileNotFoundException, IOException, GeneralSecurityException
	{
		return decryptWorkbook(inputStream, Decryptor.DEFAULT_PASSWORD);
	}
	
	public static Workbook decryptWorkbook(InputStream inputStream, String password) throws IOException, GeneralSecurityException
	{
		POIFSFileSystem fs = new POIFSFileSystem(inputStream);
		EncryptionInfo info = new EncryptionInfo(fs);
		Decryptor d = Decryptor.getInstance(info);
		d.verifyPassword(password);
		InputStream dataStream = d.getDataStream(fs);
		XSSFWorkbook workbook = new XSSFWorkbook(dataStream);
		return workbook;
	}
	

	
	public static Workbook getWorkbook(File file)
	{
		Workbook workbook;
		try
		{
			workbook = getUnprotectedWorkbook(new FileInputStream(file));
		}
		catch (Exception e)
		{
			try
			{
				workbook = decryptWorkbook(new FileInputStream(file));
			}
			catch (Exception e1)
			{
				workbook = null;
			}
		}
		return workbook;
	}
	
	public static Workbook getWorkbook(InputStream inputStream)
	{
		Workbook workbook;
		try
		{
			workbook = getUnprotectedWorkbook(inputStream);
		}
		catch (Exception e)
		{
			workbook = null;
		}
		return workbook;
	}
	
	public static Workbook getUnprotectedWorkbook(InputStream inputStream) throws InvalidFormatException, IOException
	{
		return WorkbookFactory.create(inputStream);
	}

}
