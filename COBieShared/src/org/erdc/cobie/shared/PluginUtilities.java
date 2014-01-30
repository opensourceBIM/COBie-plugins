package org.erdc.cobie.shared;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.xml.parsers.ParserConfigurationException;

import nl.fountain.xelem.lex.ExcelReader;

import org.apache.xmlbeans.XmlException;
import org.bimserver.interfaces.objects.SDownloadResult;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.PluginInterface;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1ServiceInterface;
import org.erdc.cobie.shared.enums.COBieDeserializerPluginName;
import org.erdc.cobie.shared.enums.COBieSerializerPluginInfo;
import org.erdc.cobie.sheetxmldata.COBIEDocument;
import org.xml.sax.SAXException;

public class PluginUtilities
{
    public enum IncomingFileType
    {
        IFC, COBIE, IFCXML, UNKNOWN
    };

    // TODO: This class duplicates the reponsibilities of
    // org.erdc.cobie.shared.enums classes and needs to be refactored.
    public static enum OutgingFileType
    {
        COBieSheetXMLData, COBie, COBieCompliance, COBieSpatialDecompositionReport, COBieRoomDataSheet, COBieZoneReport, COBieSystemReport, COBieCompareReport, Ifc, IfcXML

    }

    public static final String DEFAULT_IFC_STEP_DESERIALIZER_NAME = "IfcStepDeserializer";
    public static final String DEFAULT_COBIE_DESERIALIZER_NAME = COBieDeserializerPluginName.COBIE_SPREADHSEET.toString();
    public static final String DEFAULT_COBIESHEETXMLDATA_DESERIALIZER_NAME = COBieDeserializerPluginName.COBIE_SHEETXMLDATA.toString();
    private static final String IFC_DESCRIPTION = "STEP";
    private static final String IFC_XML_DESCRIPTION = "IFCXML";
    public static final String IFC_EXTENSION = ".ifc";;
    public static final String COBIE_SHEETXMLDATA_SERIALIZER_DEFAULT_NAME = COBieSerializerPluginInfo.SHEET_XMLDATA.toString();
    public static final String COBIE_SERIALIZER_DEFAULT_NAME = COBieSerializerPluginInfo.SPREADSHEET.toString();
    public static final String COBIE_COMPLIANCE_SERIALIZER_DEFAULT_NAME = COBieSerializerPluginInfo.REPORT_QC_CONSTRUCTION.toString();
    public static final String COBIE_COMPLIANCE_DESIGN_SERIALIZER_DEFAULT_NAME = COBieSerializerPluginInfo.REPORT_QC_DESIGN.toString();
    public static final String COBIE_SPACE_REPORT_SERIALIALIZER_DEFAULT_NAME = COBieSerializerPluginInfo.REPORT_SPATIAL_DECOMPOSITION.toString();
    public static final String COBIE_ROOM_DATA_SHEET_SERIALIZER_DEFAULT_NAME = COBieSerializerPluginInfo.REPORT_ROOM_DATASHEET.toString();
    public static final String COBIE_ZONE_SERIALIZER_DEFAULT_NAME = COBieSerializerPluginInfo.REPORT_ZONE.toString();
    public static final String COBIE_SYSTEM_SERIALIZER_DEFAULT_NAME = COBieSerializerPluginInfo.REPORT_SYSTEM.toString();
    public static final String COBIE_FILE_EXTENSION = ".xml";
    public static final String REPORT_FILES_EXTENSION = ".html";
    public static final String IFC_XML_FILE_EXTENSION = ".ifcxml";
    public static final HashMap<OutgingFileType, String> COBIE_FILE_TYPE_TO_FILE_EXTENSIONS = getCobieFileTypeExtensions();
    public static final HashMap<OutgingFileType, String> COBIE_FILE_TYPE_TO_SHORT_DESCRIPTION = getCobieFileTypeDescriptions();
    public static final HashMap<String, String> COBIE_EXPORT_SERIALIZERNAMES_TO_FILE_EXTENSIONS = getCobieSerializerFileExtensions();
    public static final HashMap<String, String> COBIE_EXPORT_SERIALIZERNAMES_TO_FILE_EXTENSIONS_NO_SPREADSHEET = getCobieSerializerFileExtensionsNoSpreadsheet();
    public static final HashMap<String, String> COBIE_EXPORT_SERIALIZERNAMES_TO_FILE_EXTENSIONS_NO_SHEETXMLDATA = getCobieSerializerFileExtensionsNoSheetXMLData();
    public static final String DEFAULT_IFC_STEP_SERIALIZER_NAME = "Ifc2x3";

    private static HashMap<OutgingFileType, String> getCobieFileTypeDescriptions()
    {
        HashMap<OutgingFileType, String> cobieFileDescriptions = new HashMap<OutgingFileType, String>();
        cobieFileDescriptions.put(OutgingFileType.COBie, COBieSerializerPluginInfo.SPREADSHEET.getDescription());
        cobieFileDescriptions.put(OutgingFileType.COBieSheetXMLData, COBieSerializerPluginInfo.SHEET_XMLDATA.getDescription());
        cobieFileDescriptions.put(OutgingFileType.COBieCompareReport, "");
        cobieFileDescriptions.put(OutgingFileType.COBieCompliance, "");
        cobieFileDescriptions.put(OutgingFileType.COBieRoomDataSheet, COBieSerializerPluginInfo.REPORT_ROOM_DATASHEET.getDescription());
        cobieFileDescriptions.put(OutgingFileType.COBieSpatialDecompositionReport,
                COBieSerializerPluginInfo.REPORT_SPATIAL_DECOMPOSITION.getDescription());
        cobieFileDescriptions.put(OutgingFileType.COBieSystemReport, COBieSerializerPluginInfo.REPORT_SYSTEM.getDescription());
        cobieFileDescriptions.put(OutgingFileType.COBieZoneReport, COBieSerializerPluginInfo.REPORT_ZONE.getDescription());
        cobieFileDescriptions.put(OutgingFileType.Ifc, IFC_DESCRIPTION);
        cobieFileDescriptions.put(OutgingFileType.IfcXML, IFC_XML_DESCRIPTION);
        return cobieFileDescriptions;
    }

    private static HashMap<OutgingFileType, String> getCobieFileTypeExtensions()
    {
        HashMap<OutgingFileType, String> cobieFileExtensions = new HashMap<OutgingFileType, String>();
        cobieFileExtensions.put(OutgingFileType.COBie, COBieSerializerPluginInfo.SPREADSHEET.getFileExtension());
        cobieFileExtensions.put(OutgingFileType.COBieSheetXMLData, COBieSerializerPluginInfo.SHEET_XMLDATA.getFileExtension());
        cobieFileExtensions.put(OutgingFileType.COBieCompareReport, REPORT_FILES_EXTENSION);
        cobieFileExtensions.put(OutgingFileType.COBieCompliance, REPORT_FILES_EXTENSION);
        cobieFileExtensions.put(OutgingFileType.COBieRoomDataSheet, COBieSerializerPluginInfo.REPORT_ROOM_DATASHEET.getFileExtension());
        cobieFileExtensions.put(OutgingFileType.COBieSpatialDecompositionReport,
                COBieSerializerPluginInfo.REPORT_SPATIAL_DECOMPOSITION.getFileExtension());
        cobieFileExtensions.put(OutgingFileType.COBieSystemReport, COBieSerializerPluginInfo.REPORT_SYSTEM.getFileExtension());
        cobieFileExtensions.put(OutgingFileType.COBieZoneReport, COBieSerializerPluginInfo.REPORT_ZONE.getFileExtension());
        cobieFileExtensions.put(OutgingFileType.Ifc, IFC_EXTENSION);
        cobieFileExtensions.put(OutgingFileType.IfcXML, IFC_XML_FILE_EXTENSION);
        return cobieFileExtensions;
    }

    public static COBIEDocument getCOBieFromROID(long roid, PluginInterface pluginInterface, Bimsie1ServiceInterface serviceInterface)
            throws ServerException, UserException, XmlException, IOException
    {
        long serializerOid = pluginInterface.getSerializerByPluginClassName("org.erdc.cobie.plugins.serializers.COBieSheetXMLDataSerializerPlugin").getOid();
        long actionId = serviceInterface.download(roid, serializerOid, true, true);
        SDownloadResult downloadResult = serviceInterface.getDownloadData(actionId);

        COBIEDocument cobieDocument = COBIEDocument.Factory.parse(downloadResult.getFile().getInputStream());
        return cobieDocument;
    }

    private static HashMap<String, String> getCobieSerializerFileExtensions()
    {
        HashMap<String, String> serializerNameList = new HashMap<String, String>();
        serializerNameList.put(COBieSerializerPluginInfo.COBIE_LITE.getPluginName(), COBieSerializerPluginInfo.COBIE_LITE.getFileExtension());
        serializerNameList.put(PluginUtilities.COBIE_SHEETXMLDATA_SERIALIZER_DEFAULT_NAME, PluginUtilities.COBIE_FILE_EXTENSION);
        serializerNameList.put(PluginUtilities.COBIE_SERIALIZER_DEFAULT_NAME, PluginUtilities.COBIE_FILE_EXTENSION);
        serializerNameList.put(PluginUtilities.COBIE_COMPLIANCE_SERIALIZER_DEFAULT_NAME, PluginUtilities.REPORT_FILES_EXTENSION);
        serializerNameList.put(PluginUtilities.COBIE_COMPLIANCE_DESIGN_SERIALIZER_DEFAULT_NAME, PluginUtilities.REPORT_FILES_EXTENSION);
        serializerNameList.put(PluginUtilities.COBIE_ROOM_DATA_SHEET_SERIALIZER_DEFAULT_NAME, PluginUtilities.REPORT_FILES_EXTENSION);
        serializerNameList.put(PluginUtilities.COBIE_SPACE_REPORT_SERIALIALIZER_DEFAULT_NAME, PluginUtilities.REPORT_FILES_EXTENSION);
        serializerNameList.put(PluginUtilities.COBIE_ZONE_SERIALIZER_DEFAULT_NAME, PluginUtilities.REPORT_FILES_EXTENSION);
        serializerNameList.put(PluginUtilities.COBIE_SYSTEM_SERIALIZER_DEFAULT_NAME, PluginUtilities.REPORT_FILES_EXTENSION);
        return serializerNameList;
    }

    private static HashMap<String, String> getCobieSerializerFileExtensionsNoSpreadsheet()
    {
        HashMap<String, String> serializerNameList = new HashMap<String, String>();
        serializerNameList.put(COBieSerializerPluginInfo.COBIE_LITE.getPluginName(), COBieSerializerPluginInfo.COBIE_LITE.getFileExtension());
        serializerNameList.put(PluginUtilities.COBIE_SHEETXMLDATA_SERIALIZER_DEFAULT_NAME, PluginUtilities.COBIE_FILE_EXTENSION);
        serializerNameList.put(PluginUtilities.COBIE_COMPLIANCE_SERIALIZER_DEFAULT_NAME, PluginUtilities.REPORT_FILES_EXTENSION);
        serializerNameList.put(PluginUtilities.COBIE_COMPLIANCE_DESIGN_SERIALIZER_DEFAULT_NAME, PluginUtilities.REPORT_FILES_EXTENSION);
        serializerNameList.put(PluginUtilities.COBIE_ROOM_DATA_SHEET_SERIALIZER_DEFAULT_NAME, PluginUtilities.REPORT_FILES_EXTENSION);
        serializerNameList.put(PluginUtilities.COBIE_SPACE_REPORT_SERIALIALIZER_DEFAULT_NAME, PluginUtilities.REPORT_FILES_EXTENSION);
        serializerNameList.put(PluginUtilities.COBIE_ZONE_SERIALIZER_DEFAULT_NAME, PluginUtilities.REPORT_FILES_EXTENSION);
        serializerNameList.put(PluginUtilities.COBIE_SYSTEM_SERIALIZER_DEFAULT_NAME, PluginUtilities.REPORT_FILES_EXTENSION);
        return serializerNameList;
    }
    
    private static HashMap<String, String> getCobieSerializerFileExtensionsNoSheetXMLData()
    {
        HashMap<String, String> serializerNameList = new HashMap<String, String>();
        serializerNameList.put(COBieSerializerPluginInfo.COBIE_LITE.getPluginName(), COBieSerializerPluginInfo.COBIE_LITE.getFileExtension());
        serializerNameList.put(PluginUtilities.COBIE_SERIALIZER_DEFAULT_NAME, PluginUtilities.COBIE_FILE_EXTENSION);
        serializerNameList.put(PluginUtilities.COBIE_COMPLIANCE_SERIALIZER_DEFAULT_NAME, PluginUtilities.REPORT_FILES_EXTENSION);
        serializerNameList.put(PluginUtilities.COBIE_COMPLIANCE_DESIGN_SERIALIZER_DEFAULT_NAME, PluginUtilities.REPORT_FILES_EXTENSION);
        serializerNameList.put(PluginUtilities.COBIE_ROOM_DATA_SHEET_SERIALIZER_DEFAULT_NAME, PluginUtilities.REPORT_FILES_EXTENSION);
        serializerNameList.put(PluginUtilities.COBIE_SPACE_REPORT_SERIALIALIZER_DEFAULT_NAME, PluginUtilities.REPORT_FILES_EXTENSION);
        serializerNameList.put(PluginUtilities.COBIE_ZONE_SERIALIZER_DEFAULT_NAME, PluginUtilities.REPORT_FILES_EXTENSION);
        serializerNameList.put(PluginUtilities.COBIE_SYSTEM_SERIALIZER_DEFAULT_NAME, PluginUtilities.REPORT_FILES_EXTENSION);
        return serializerNameList;
    }

    public static IncomingFileType incomingFileTypeFromFile(File incomingFile)
    {
        IncomingFileType incomingFileType = null;
        if (incomingFile.getName().toLowerCase().endsWith(COBIE_FILE_EXTENSION))
        {
            incomingFileType = incomingFileTypeFromXMLFile(incomingFile);
        } else if (incomingFile.getName().toLowerCase().endsWith(IFC_EXTENSION))
        {
            incomingFileType = IncomingFileType.IFC;
        } else
        {
            incomingFileType = IncomingFileType.UNKNOWN;
        }
        return incomingFileType;
    }

    public static IncomingFileType incomingFileTypeFromXMLFile(File incomingFile)
    {
        IncomingFileType incomingFileType = null;
        try
        {
            incomingFileType = tryFileAsCOBie(incomingFile);
        } catch (Exception ex)
        {

        }
        if (incomingFileType == null)
        {
            incomingFileType = IncomingFileType.UNKNOWN;
        }

        return incomingFileType;
    }

    private static IncomingFileType tryFileAsCOBie(File incomingFile) throws ParserConfigurationException, SAXException, IOException
    {
        IncomingFileType incomingFileType;
        ExcelReader rdr = new ExcelReader();
        rdr.getWorkbook(incomingFile.getAbsolutePath());
        rdr = null;
        incomingFileType = IncomingFileType.COBIE;
        return incomingFileType;
    }

}
