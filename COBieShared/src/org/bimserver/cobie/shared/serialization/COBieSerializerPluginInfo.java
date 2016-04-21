package org.bimserver.cobie.shared.serialization;

import org.bimserver.cobie.shared.plugininfo.PluginInfo;



public enum COBieSerializerPluginInfo implements PluginInfo
{
	GENERAL_PRODUCT_TEMPLATE("COBie Template - General Product","An XLSX file tailored for entry of installed equipment data",SerializableFileType.XLSX, "org.bimserver.cobie.shared.bimserver.plugins.serializers.GeneralProductsTemplatePlugin"),
    COBieTabXML("COBie Spreadsheet as Simple XML Document Elements","XML based on a schema derived from the COBie spreadsheet columns.", SerializableFileType.XML,"org.bimserver.cobie.plugin.serializers.COBieSheetXMLDataSerializerPlugin"), 
    SPREADSHEET("COBie SpreadsheetXML (2003)","Construction Operators Building information exchange spreadsheetML format.", SerializableFileType.SPREADSHEETML,"org.bimserver.cobie.shared.bimserver.plugins.serializers.COBieSerializerPlugin"), 
    SPREADSHEET_XLSX("COBie Spreadsheet (XLSX)","Construction Operators Building information exchange spreadsheetML format.", SerializableFileType.XLSX,"org.bimserver.cobie.shared.bimserver.plugins.serializers.COBieXLSXSerializerPlugin"),
    REPORT_QC_DESIGN("COBie QC Report - Design Deliverable",
            "Produces a report of compliance to a COBie ruleset for the Design phase.",
            SerializableFileType.HTML,""), 
    REPORT_QC_CONSTRUCTION("COBie QC Report - Construction Deliverable",
            "Produces a report of compliance to a COBie ruleset.", SerializableFileType.HTML,""), 
    REPORT_ROOM_DATASHEET("COBieRoomDataSheet","Produces a report of coponents by Space and then by type.", SerializableFileType.HTML,""), 
    REPORT_SPATIAL_DECOMPOSITION("COBieSpatialDecompositionReport","Produces a report of spaces by floors.", SerializableFileType.HTML,""), 
    REPORT_ZONE("COBieZoneReport","A report listing Zones, Spaces in Zones, and Zone COBie fields.", SerializableFileType.HTML,""), 
    REPORT_SYSTEM("COBieSystemReport","Produces a report of systems and their corresponding components.", SerializableFileType.HTML,""), 
    COBIE_LITE("COBieLite RC4","COBie Lite XML Release Candidate 4", SerializableFileType.XML,""),
    AS_INSTALLED_EQUIPMENT("As Installed Equipment Template","A COBie formatted spreadsheet for submittal of as installed equipment.", SerializableFileType.XLSX,""),
    DD_1391("DD1391 Form","DD1391 Form", SerializableFileType.HTML,""),
    DD_1354("DD1354 Form","DD1354 Form", SerializableFileType.HTML,""),
    PRODUCT_TYPE_WARRANTY("Product Type Warranty Template","A COBie formatted spreadsheet for submittal of product type warrant information", SerializableFileType.XLSX,"");
    public String getDescription()
    {
        return description;
    }



    public String getFileExtension()
    {
        return fileExtension;
    }




    private final String pluginName;
    private final String description;
    private final String fileExtension;
    private final String contentType;
    private final String implementationClassname
    ;
    private COBieSerializerPluginInfo(String pluginName, String description, SerializableFileType fileType, String implementationClassName)
    {
        this.pluginName = pluginName;
        this.description = description;
        this.fileExtension = fileType.getExtension();
        this.contentType = fileType.getContentType();
        this.implementationClassname = implementationClassName;
    }
    

    @Override
    public String toString()
    {
        return pluginName;
    }


    @Override
    public String getPluginName()
    {
        return pluginName;
    }


	@Override
	public String getContentType()
	{
		return contentType;
	}
	
	public String getImplementationClassname()
	{
		return implementationClassname;
	}
    
    
}
