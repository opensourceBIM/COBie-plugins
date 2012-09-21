package org.bimserver.shared.cobie;

import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import javax.xml.parsers.ParserConfigurationException;

import nl.fountain.xelem.excel.Workbook;
import nl.fountain.xelem.lex.ExcelReader;

import org.apache.xmlbeans.XmlCalendar;
import org.apache.xmlbeans.XmlException;
import org.bimserver.cobie.cobielite.COBIEDocument;
import org.bimserver.cobie.cobielite.COBIEDocument.Factory;
import org.bimserver.interfaces.objects.SDownloadResult;
import org.bimserver.shared.ServiceInterface;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.xml.sax.SAXException;


public class COBieSharedUtilities
{
	public enum Enum_IncomingFileType {IFC,COBIE,UNKNOWN};
	public static final String DEFAULT_IFC_STEP_DESERIALIZER_NAME = "IfcStepDeserializer";
	public static final String DEFAULT_COBIE_DESERIALIZER_NAME = "COBieDeserializer";
	public static final String DEFAULT_COBIELITE_DESERIALIZER_NAME = "";
	private static final String IFC_DESCRIPTION = "STEP";
	private static final String COBIELITE_DESCRIPTION = "XML Data";
	private static final String COBIE_DESCRIPTION = "SpreadsheetXML";
	public static final String IFC_EXTENSION = ".ifc";
	public static final String COBIE_LITE_SERIALIZER_DEFAULT_NAME = "COBieLite(xml)";
	public static final String COBIE_SERIALIZER_DEFAULT_NAME = "COBie";
	public static final String COBIE_COMPLIANCE_SERIALIZER_DEFAULT_NAME = "COBie QC Report - Construction Deliverable";
	public static final String COBIE_COMPLIANCE_DESIGN_SERIALIZER_DEFAULT_NAME = "COBie QC Report - Design Deliverable";
	public static final String COBIE_SPACE_REPORT_SERIALIALIZER_DEFAULT_NAME = "COBieSpatialDecompositionReport";
	public static final String COBIE_ROOM_DATA_SHEET_SERIALIZER_DEFAULT_NAME = "COBieRoomDataSheet";
	public static final String COBIE_ZONE_SERIALIZER_DEFAULT_NAME ="COBieZoneReport";
	public static final String COBIE_SYSTEM_SERIALIZER_DEFAULT_NAME ="COBieSystemReport";
	public static final String COBIE_FILE_EXTENSION = ".xml";
	public static final String REPORT_FILES_EXTENSION = ".html";
	public static  enum COBIE_FILE_TYPE {COBieLite,COBie,COBieCompliance,COBieSpatialDecompositionReport,
			COBieRoomDataSheet,COBieZoneReport,COBieSystemReport,COBieCompareReport,Ifc};
	public static final HashMap<COBIE_FILE_TYPE,String> COBIE_FILE_TYPE_TO_FILE_EXTENSIONS = getCobieFileTypeExtensions();
	public static final HashMap<COBIE_FILE_TYPE,String> COBIE_FILE_TYPE_TO_SHORT_DESCRIPTION = getCobieFileTypeDescriptions();
	public static final HashMap<String,String> COBIE_EXPORT_SERIALIZERNAMES_TO_FILE_EXTENSIONS = getCobieSerializerFileExtensions();
	public static final HashMap<String,String> COBIE_EXPORT_SERIALIZERNAMES_TO_FILE_EXTENSIONS_NO_SPREADSHEET = getCobieSerializerFileExtensionsNoSpreadsheet();
	public static final String DEFAULT_IFC_STEP_SERIALIZER_NAME = "Ifc2x3";

	public static String hashFromString(String hash)
			throws NoSuchAlgorithmException
	{
		MessageDigest msgDigest = MessageDigest.getInstance("MD5");
		byte[] msgContents = hash.getBytes();
		byte[] hashedContents = msgDigest.digest(msgContents);
		String hashedString = "";
		   StringBuffer sb = new StringBuffer();
		    for (int i = 0; i < hashedContents.length; i++) {
		      sb.append(Integer.toString((hashedContents[i] & 0xff) + 0x100, 16).substring(1));
		    }
		hash = sb.toString();
		return hash;
	}

	private static HashMap<String, String> getCobieSerializerFileExtensionsNoSpreadsheet()
	{
		HashMap<String,String> serializerNameList = new HashMap<String,String>();
		serializerNameList.put(COBieSharedUtilities.COBIE_LITE_SERIALIZER_DEFAULT_NAME,COBieSharedUtilities.COBIE_FILE_EXTENSION);
		serializerNameList.put(COBieSharedUtilities.COBIE_COMPLIANCE_SERIALIZER_DEFAULT_NAME,COBieSharedUtilities.REPORT_FILES_EXTENSION);
		serializerNameList.put(COBieSharedUtilities.COBIE_COMPLIANCE_DESIGN_SERIALIZER_DEFAULT_NAME, COBieSharedUtilities.REPORT_FILES_EXTENSION);
		serializerNameList.put(COBieSharedUtilities.COBIE_ROOM_DATA_SHEET_SERIALIZER_DEFAULT_NAME,COBieSharedUtilities.REPORT_FILES_EXTENSION);
		serializerNameList.put(COBieSharedUtilities.COBIE_SPACE_REPORT_SERIALIALIZER_DEFAULT_NAME,COBieSharedUtilities.REPORT_FILES_EXTENSION);
		serializerNameList.put(COBieSharedUtilities.COBIE_ZONE_SERIALIZER_DEFAULT_NAME,COBieSharedUtilities.REPORT_FILES_EXTENSION);
		serializerNameList.put(COBieSharedUtilities.COBIE_SYSTEM_SERIALIZER_DEFAULT_NAME, COBieSharedUtilities.REPORT_FILES_EXTENSION);
		return serializerNameList;
	}

	private static HashMap<COBIE_FILE_TYPE, String> getCobieFileTypeDescriptions()
	{
		HashMap<COBIE_FILE_TYPE,String> cobieFileDescriptions =
				new HashMap<COBIE_FILE_TYPE,String>();
		cobieFileDescriptions.put(COBIE_FILE_TYPE.COBie,COBIE_DESCRIPTION);
		cobieFileDescriptions.put(COBIE_FILE_TYPE.COBieLite, COBIELITE_DESCRIPTION);
		cobieFileDescriptions.put(COBIE_FILE_TYPE.COBieCompareReport,"");
		cobieFileDescriptions.put(COBIE_FILE_TYPE.COBieCompliance,"");
		cobieFileDescriptions.put(COBIE_FILE_TYPE.COBieRoomDataSheet,"");
		cobieFileDescriptions.put(COBIE_FILE_TYPE.COBieSpatialDecompositionReport,"");
		cobieFileDescriptions.put(COBIE_FILE_TYPE.COBieSystemReport, "");
		cobieFileDescriptions.put(COBIE_FILE_TYPE.COBieZoneReport,"");
		cobieFileDescriptions.put(COBIE_FILE_TYPE.Ifc, IFC_DESCRIPTION);
		return cobieFileDescriptions;
	}

	private static HashMap<COBIE_FILE_TYPE, String> getCobieFileTypeExtensions()
	{
		HashMap<COBIE_FILE_TYPE,String> cobieFileExtensions =
				new HashMap<COBIE_FILE_TYPE,String>();
		cobieFileExtensions.put(COBIE_FILE_TYPE.COBie,COBIE_FILE_EXTENSION);
		cobieFileExtensions.put(COBIE_FILE_TYPE.COBieLite, COBIE_FILE_EXTENSION);
		cobieFileExtensions.put(COBIE_FILE_TYPE.COBieCompareReport,REPORT_FILES_EXTENSION);
		cobieFileExtensions.put(COBIE_FILE_TYPE.COBieCompliance,REPORT_FILES_EXTENSION);
		cobieFileExtensions.put(COBIE_FILE_TYPE.COBieRoomDataSheet,REPORT_FILES_EXTENSION);
		cobieFileExtensions.put(COBIE_FILE_TYPE.COBieSpatialDecompositionReport, REPORT_FILES_EXTENSION);
		cobieFileExtensions.put(COBIE_FILE_TYPE.COBieSystemReport, REPORT_FILES_EXTENSION);
		cobieFileExtensions.put(COBIE_FILE_TYPE.COBieZoneReport, REPORT_FILES_EXTENSION);
		cobieFileExtensions.put(COBIE_FILE_TYPE.Ifc, IFC_EXTENSION);
		return cobieFileExtensions;
	}

	public static COBIEDocument getCOBieFromROID(long roid, ServiceInterface service) throws ServerException, UserException, XmlException, IOException
	{
		int actionId = service.download(roid, COBieSharedUtilities.COBIE_LITE_SERIALIZER_DEFAULT_NAME, true, true);
		SDownloadResult downloadResult = service.getDownloadData(actionId);
		
		COBIEDocument cobieDocument =
				COBIEDocument.Factory.parse(downloadResult.getFile().getInputStream());
		return cobieDocument;
	}
	

	public static Calendar getCurrentTimeCalendar()
	{
		Calendar cal = Calendar.getInstance();
		Date StartTime = cal.getTime();
		Date co = StartTime;
		Calendar calStart = new org.apache.xmlbeans.XmlCalendar(StartTime);
		return calStart;
	}
	private static HashMap<String,String> getCobieSerializerFileExtensions()
	{
		HashMap<String,String> serializerNameList = new HashMap<String,String>();
		serializerNameList.put(COBieSharedUtilities.COBIE_LITE_SERIALIZER_DEFAULT_NAME,COBieSharedUtilities.COBIE_FILE_EXTENSION);
		serializerNameList.put(COBieSharedUtilities.COBIE_SERIALIZER_DEFAULT_NAME,COBieSharedUtilities.COBIE_FILE_EXTENSION);
		serializerNameList.put(COBieSharedUtilities.COBIE_COMPLIANCE_SERIALIZER_DEFAULT_NAME,COBieSharedUtilities.REPORT_FILES_EXTENSION);
		serializerNameList.put(COBieSharedUtilities.COBIE_COMPLIANCE_DESIGN_SERIALIZER_DEFAULT_NAME, COBieSharedUtilities.REPORT_FILES_EXTENSION);
		serializerNameList.put(COBieSharedUtilities.COBIE_ROOM_DATA_SHEET_SERIALIZER_DEFAULT_NAME,COBieSharedUtilities.REPORT_FILES_EXTENSION);
		serializerNameList.put(COBieSharedUtilities.COBIE_SPACE_REPORT_SERIALIALIZER_DEFAULT_NAME,COBieSharedUtilities.REPORT_FILES_EXTENSION);
		serializerNameList.put(COBieSharedUtilities.COBIE_ZONE_SERIALIZER_DEFAULT_NAME,COBieSharedUtilities.REPORT_FILES_EXTENSION);
		serializerNameList.put(COBieSharedUtilities.COBIE_SYSTEM_SERIALIZER_DEFAULT_NAME, COBieSharedUtilities.REPORT_FILES_EXTENSION);
		return serializerNameList;
	}
	
	private static HashMap<String,String> getCobieSerializerFileExtensionsForIncomingCOBie()
	{
		HashMap<String,String> serializerNameList = new HashMap<String,String>();
		serializerNameList.put(COBieSharedUtilities.COBIE_LITE_SERIALIZER_DEFAULT_NAME,COBieSharedUtilities.COBIE_FILE_EXTENSION);
		serializerNameList.put(COBieSharedUtilities.COBIE_SERIALIZER_DEFAULT_NAME,COBieSharedUtilities.COBIE_FILE_EXTENSION);
		serializerNameList.put(COBieSharedUtilities.COBIE_COMPLIANCE_SERIALIZER_DEFAULT_NAME,COBieSharedUtilities.REPORT_FILES_EXTENSION);
		serializerNameList.put(COBieSharedUtilities.COBIE_COMPLIANCE_DESIGN_SERIALIZER_DEFAULT_NAME, COBieSharedUtilities.REPORT_FILES_EXTENSION);
		serializerNameList.put(COBieSharedUtilities.COBIE_ROOM_DATA_SHEET_SERIALIZER_DEFAULT_NAME,COBieSharedUtilities.REPORT_FILES_EXTENSION);
		serializerNameList.put(COBieSharedUtilities.COBIE_SPACE_REPORT_SERIALIALIZER_DEFAULT_NAME,COBieSharedUtilities.REPORT_FILES_EXTENSION);
		serializerNameList.put(COBieSharedUtilities.COBIE_ZONE_SERIALIZER_DEFAULT_NAME,COBieSharedUtilities.REPORT_FILES_EXTENSION);
		serializerNameList.put(COBieSharedUtilities.COBIE_SYSTEM_SERIALIZER_DEFAULT_NAME, COBieSharedUtilities.REPORT_FILES_EXTENSION);
		return serializerNameList;
	}
	
	public static Enum_IncomingFileType incomingFileTypeFromFile(File incomingFile)
	{
		Enum_IncomingFileType incomingFileType = null;
		if(incomingFile.getName().toLowerCase().endsWith(COBIE_FILE_EXTENSION))
			incomingFileType = incomingFileTypeFromXMLFile(incomingFile);
		else if (incomingFile.getName().toLowerCase().endsWith(IFC_EXTENSION))
			incomingFileType = Enum_IncomingFileType.IFC;
		else
			incomingFileType = Enum_IncomingFileType.UNKNOWN;
		return incomingFileType;
	}
	
	public static Enum_IncomingFileType incomingFileTypeFromXMLFile(File incomingFile)
	{
		Enum_IncomingFileType incomingFileType = null;
		try
		{
			incomingFileType = tryFileAsCOBie(incomingFile);
		}
		catch(Exception ex)
		{
			
		}
		if(incomingFileType ==null)
			incomingFileType = Enum_IncomingFileType.UNKNOWN;
		
		return incomingFileType;
	}



	private static Enum_IncomingFileType tryFileAsCOBie(File incomingFile)
			throws ParserConfigurationException, SAXException, IOException
	{
		Enum_IncomingFileType incomingFileType;
		ExcelReader rdr = new ExcelReader();
		Workbook bk = rdr.getWorkbook(incomingFile.getAbsolutePath());
		bk = null;
		rdr = null;
		incomingFileType = Enum_IncomingFileType.COBIE;
		return incomingFileType;
	}
	

}
