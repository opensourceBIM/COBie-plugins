package org.erdc.cobie.shared;

import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import javax.xml.parsers.ParserConfigurationException;

import nl.fountain.xelem.lex.ExcelReader;

import org.apache.xmlbeans.XmlException;
import org.bimserver.interfaces.objects.SDownloadResult;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.erdc.cobie.shared.enums.COBieDeserializerPluginName;
import org.erdc.cobie.shared.enums.COBieSerializerPluginName;
import org.erdc.cobie.sheetxmldata.COBIEDocument;
import org.xml.sax.SAXException;

public class COBieSharedUtilities
{
    public static enum COBIE_FILE_TYPE
    {
        COBieSheetXMLData, COBie, COBieCompliance, COBieSpatialDecompositionReport, COBieRoomDataSheet, COBieZoneReport, COBieSystemReport, COBieCompareReport, Ifc, IfcXML
    };

    public enum Enum_IncomingFileType
    {
        IFC, COBIE, IFCXML, UNKNOWN
    }

    public static final String DEFAULT_IFC_STEP_DESERIALIZER_NAME = "IfcStepDeserializer";
    public static final String DEFAULT_COBIE_DESERIALIZER_NAME = COBieDeserializerPluginName.COBIE_SPREADHSEET.toString();
    public static final String DEFAULT_COBIESHEETXMLDATA_DESERIALIZER_NAME = "";
    private static final String IFC_DESCRIPTION = "STEP";
    private static final String IFC_XML_DESCRIPTION = "IFCXML";
    private static final String COBIE_SHEET_XML_DATA_DESCRIPTION = "XML Data";
    private static final String COBIE_DESCRIPTION = "SpreadsheetXML";
    public static final String IFC_EXTENSION = ".ifc";;
    public static final String COBIE_LITE_SERIALIZER_DEFAULT_NAME = COBieSerializerPluginName.COBIE_SHEET_XMLDATA.toString();
    public static final String COBIE_SERIALIZER_DEFAULT_NAME = COBieSerializerPluginName.COBIE_SPREADSHEET.toString();
    public static final String COBIE_COMPLIANCE_SERIALIZER_DEFAULT_NAME = COBieSerializerPluginName.COBIE_CONSTRUCTIONQC.toString();
    public static final String COBIE_COMPLIANCE_DESIGN_SERIALIZER_DEFAULT_NAME = COBieSerializerPluginName.COBIE_DESIGNQC.toString();
    public static final String COBIE_SPACE_REPORT_SERIALIALIZER_DEFAULT_NAME = COBieSerializerPluginName.COBIE_SPATIAL_DECOMPOSITION_REPORT
            .toString();
    public static final String COBIE_ROOM_DATA_SHEET_SERIALIZER_DEFAULT_NAME = COBieSerializerPluginName.COBIE_ROOM_DATASHEET_REPORT.toString();
    public static final String COBIE_ZONE_SERIALIZER_DEFAULT_NAME = COBieSerializerPluginName.COBIE_ZONE_REPORT.toString();
    public static final String COBIE_SYSTEM_SERIALIZER_DEFAULT_NAME = COBieSerializerPluginName.COBIE_SYSTEM_REPORT.toString();
    public static final String COBIE_FILE_EXTENSION = ".xml";
    public static final String REPORT_FILES_EXTENSION = ".html";
    public static final String IFC_XML_FILE_EXTENSION = ".ifcxml";
    public static final HashMap<COBIE_FILE_TYPE, String> COBIE_FILE_TYPE_TO_FILE_EXTENSIONS = getCobieFileTypeExtensions();
    public static final HashMap<COBIE_FILE_TYPE, String> COBIE_FILE_TYPE_TO_SHORT_DESCRIPTION = getCobieFileTypeDescriptions();
    public static final HashMap<String, String> COBIE_EXPORT_SERIALIZERNAMES_TO_FILE_EXTENSIONS = getCobieSerializerFileExtensions();
    public static final HashMap<String, String> COBIE_EXPORT_SERIALIZERNAMES_TO_FILE_EXTENSIONS_NO_SPREADSHEET = getCobieSerializerFileExtensionsNoSpreadsheet();
    public static final String DEFAULT_IFC_STEP_SERIALIZER_NAME = "Ifc2x3";

    private static HashMap<COBIE_FILE_TYPE, String> getCobieFileTypeDescriptions()
    {
        HashMap<COBIE_FILE_TYPE, String> cobieFileDescriptions = new HashMap<COBIE_FILE_TYPE, String>();
        cobieFileDescriptions.put(COBIE_FILE_TYPE.COBie, COBIE_DESCRIPTION);
        cobieFileDescriptions.put(COBIE_FILE_TYPE.COBieSheetXMLData, COBIE_SHEET_XML_DATA_DESCRIPTION);
        cobieFileDescriptions.put(COBIE_FILE_TYPE.COBieCompareReport, "");
        cobieFileDescriptions.put(COBIE_FILE_TYPE.COBieCompliance, "");
        cobieFileDescriptions.put(COBIE_FILE_TYPE.COBieRoomDataSheet, "");
        cobieFileDescriptions.put(COBIE_FILE_TYPE.COBieSpatialDecompositionReport, "");
        cobieFileDescriptions.put(COBIE_FILE_TYPE.COBieSystemReport, "");
        cobieFileDescriptions.put(COBIE_FILE_TYPE.COBieZoneReport, "");
        cobieFileDescriptions.put(COBIE_FILE_TYPE.Ifc, IFC_DESCRIPTION);
        cobieFileDescriptions.put(COBIE_FILE_TYPE.IfcXML, IFC_XML_DESCRIPTION);
        return cobieFileDescriptions;
    }

    private static HashMap<COBIE_FILE_TYPE, String> getCobieFileTypeExtensions()
    {
        HashMap<COBIE_FILE_TYPE, String> cobieFileExtensions = new HashMap<COBIE_FILE_TYPE, String>();
        cobieFileExtensions.put(COBIE_FILE_TYPE.COBie, COBIE_FILE_EXTENSION);
        cobieFileExtensions.put(COBIE_FILE_TYPE.COBieSheetXMLData, COBIE_FILE_EXTENSION);
        cobieFileExtensions.put(COBIE_FILE_TYPE.COBieCompareReport, REPORT_FILES_EXTENSION);
        cobieFileExtensions.put(COBIE_FILE_TYPE.COBieCompliance, REPORT_FILES_EXTENSION);
        cobieFileExtensions.put(COBIE_FILE_TYPE.COBieRoomDataSheet, REPORT_FILES_EXTENSION);
        cobieFileExtensions.put(COBIE_FILE_TYPE.COBieSpatialDecompositionReport, REPORT_FILES_EXTENSION);
        cobieFileExtensions.put(COBIE_FILE_TYPE.COBieSystemReport, REPORT_FILES_EXTENSION);
        cobieFileExtensions.put(COBIE_FILE_TYPE.COBieZoneReport, REPORT_FILES_EXTENSION);
        cobieFileExtensions.put(COBIE_FILE_TYPE.Ifc, IFC_EXTENSION);
        cobieFileExtensions.put(COBIE_FILE_TYPE.IfcXML, IFC_XML_FILE_EXTENSION);
        return cobieFileExtensions;
    }

    public static COBIEDocument getCOBieFromROID(long roid, ServiceInterface service) throws ServerException, UserException, XmlException,
            IOException
    {
        long serializerOid = service.getSerializerByName(COBIE_LITE_SERIALIZER_DEFAULT_NAME).getOid();
        long actionId = service.download(roid, serializerOid, true, true);
        SDownloadResult downloadResult = service.getDownloadData(actionId);

        COBIEDocument cobieDocument = COBIEDocument.Factory.parse(downloadResult.getFile().getInputStream());
        return cobieDocument;
    }

    private static HashMap<String, String> getCobieSerializerFileExtensions()
    {
        HashMap<String, String> serializerNameList = new HashMap<String, String>();
        serializerNameList.put(COBieSharedUtilities.COBIE_LITE_SERIALIZER_DEFAULT_NAME, COBieSharedUtilities.COBIE_FILE_EXTENSION);
        serializerNameList.put(COBieSharedUtilities.COBIE_SERIALIZER_DEFAULT_NAME, COBieSharedUtilities.COBIE_FILE_EXTENSION);
        serializerNameList.put(COBieSharedUtilities.COBIE_COMPLIANCE_SERIALIZER_DEFAULT_NAME, COBieSharedUtilities.REPORT_FILES_EXTENSION);
        serializerNameList.put(COBieSharedUtilities.COBIE_COMPLIANCE_DESIGN_SERIALIZER_DEFAULT_NAME, COBieSharedUtilities.REPORT_FILES_EXTENSION);
        serializerNameList.put(COBieSharedUtilities.COBIE_ROOM_DATA_SHEET_SERIALIZER_DEFAULT_NAME, COBieSharedUtilities.REPORT_FILES_EXTENSION);
        serializerNameList.put(COBieSharedUtilities.COBIE_SPACE_REPORT_SERIALIALIZER_DEFAULT_NAME, COBieSharedUtilities.REPORT_FILES_EXTENSION);
        serializerNameList.put(COBieSharedUtilities.COBIE_ZONE_SERIALIZER_DEFAULT_NAME, COBieSharedUtilities.REPORT_FILES_EXTENSION);
        serializerNameList.put(COBieSharedUtilities.COBIE_SYSTEM_SERIALIZER_DEFAULT_NAME, COBieSharedUtilities.REPORT_FILES_EXTENSION);
        return serializerNameList;
    }

    private static HashMap<String, String> getCobieSerializerFileExtensionsNoSpreadsheet()
    {
        HashMap<String, String> serializerNameList = new HashMap<String, String>();
        serializerNameList.put(COBieSharedUtilities.COBIE_LITE_SERIALIZER_DEFAULT_NAME, COBieSharedUtilities.COBIE_FILE_EXTENSION);
        serializerNameList.put(COBieSharedUtilities.COBIE_COMPLIANCE_SERIALIZER_DEFAULT_NAME, COBieSharedUtilities.REPORT_FILES_EXTENSION);
        serializerNameList.put(COBieSharedUtilities.COBIE_COMPLIANCE_DESIGN_SERIALIZER_DEFAULT_NAME, COBieSharedUtilities.REPORT_FILES_EXTENSION);
        serializerNameList.put(COBieSharedUtilities.COBIE_ROOM_DATA_SHEET_SERIALIZER_DEFAULT_NAME, COBieSharedUtilities.REPORT_FILES_EXTENSION);
        serializerNameList.put(COBieSharedUtilities.COBIE_SPACE_REPORT_SERIALIALIZER_DEFAULT_NAME, COBieSharedUtilities.REPORT_FILES_EXTENSION);
        serializerNameList.put(COBieSharedUtilities.COBIE_ZONE_SERIALIZER_DEFAULT_NAME, COBieSharedUtilities.REPORT_FILES_EXTENSION);
        serializerNameList.put(COBieSharedUtilities.COBIE_SYSTEM_SERIALIZER_DEFAULT_NAME, COBieSharedUtilities.REPORT_FILES_EXTENSION);
        return serializerNameList;
    }

    public static Calendar getCurrentTimeCalendar()
    {
        Calendar cal = Calendar.getInstance();
        Date StartTime = cal.getTime();
        Calendar calStart = new org.apache.xmlbeans.XmlCalendar(StartTime);
        return calStart;
    }

    public static String hashFromString(String hash) throws NoSuchAlgorithmException
    {
        MessageDigest msgDigest = MessageDigest.getInstance("MD5");
        byte[] msgContents = hash.getBytes();
        byte[] hashedContents = msgDigest.digest(msgContents);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < hashedContents.length; i++)
        {
            sb.append(Integer.toString((hashedContents[i] & 0xff) + 0x100, 16).substring(1));
        }
        hash = sb.toString();
        return hash;
    }

    public static Enum_IncomingFileType incomingFileTypeFromFile(File incomingFile)
    {
        Enum_IncomingFileType incomingFileType = null;
        if (incomingFile.getName().toLowerCase().endsWith(COBIE_FILE_EXTENSION))
        {
            incomingFileType = incomingFileTypeFromXMLFile(incomingFile);
        } else if (incomingFile.getName().toLowerCase().endsWith(IFC_EXTENSION))
        {
            incomingFileType = Enum_IncomingFileType.IFC;
        } else
        {
            incomingFileType = Enum_IncomingFileType.UNKNOWN;
        }
        return incomingFileType;
    }

    public static Enum_IncomingFileType incomingFileTypeFromXMLFile(File incomingFile)
    {
        Enum_IncomingFileType incomingFileType = null;
        try
        {
            incomingFileType = tryFileAsCOBie(incomingFile);
        } catch (Exception ex)
        {

        }
        if (incomingFileType == null)
        {
            incomingFileType = Enum_IncomingFileType.UNKNOWN;
        }

        return incomingFileType;
    }

    private static Enum_IncomingFileType tryFileAsCOBie(File incomingFile) throws ParserConfigurationException, SAXException, IOException
    {
        Enum_IncomingFileType incomingFileType;
        ExcelReader rdr = new ExcelReader();
        rdr.getWorkbook(incomingFile.getAbsolutePath());
        rdr = null;
        incomingFileType = Enum_IncomingFileType.COBIE;
        return incomingFileType;
    }

}
