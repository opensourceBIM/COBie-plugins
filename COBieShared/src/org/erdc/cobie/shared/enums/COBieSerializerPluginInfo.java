package org.erdc.cobie.shared.enums;

import org.erdc.cobie.shared.enums.string.FileTypes;


public enum COBieSerializerPluginInfo implements PluginInfo
{
    SHEET_XMLDATA("COBie Spreadsheet as Simple XML Document Elements","XML based on a schema derived from the COBie spreadsheet columns.", FileTypes.XML,"org.erdc.cobie.plugins.serializers.COBieSheetXMLDataSerializerPlugin"), 
    SPREADSHEET("COBie SpreadsheetXML (2003)","Construction Operators Building information exchange spreadsheetML format.", FileTypes.XML,"org.erdc.cobie.plugins.serializers.COBieSerializerPlugin"), 
    REPORT_QC_DESIGN("COBie QC Report - Design Deliverable",
            "Produces a report of compliance to a COBie ruleset for the Design phase.",
            FileTypes.HTML,""), 
    REPORT_QC_CONSTRUCTION("COBie QC Report - Construction Deliverable",
            "Produces a report of compliance to a COBie ruleset.", FileTypes.HTML,""), 
    REPORT_ROOM_DATASHEET("COBieRoomDataSheet","Produces a report of coponents by Space and then by type.", FileTypes.HTML,""), 
    REPORT_SPATIAL_DECOMPOSITION("COBieSpatialDecompositionReport","Produces a report of spaces by floors.", FileTypes.HTML,""), 
    REPORT_ZONE("COBieZoneReport","A report listing Zones, Spaces in Zones, and Zone COBie fields.", FileTypes.HTML,""), 
    REPORT_SYSTEM("COBieSystemReport","Produces a report of systems and their corresponding components.", FileTypes.HTML,""), 
    COBIE_LITE("COBieLite RC4","COBie Lite XML Release Candidate 4", FileTypes.XML,""),
    AS_INSTALLED_EQUIPMENT("As Installed Equipment Template","A COBie formatted spreadsheet for submittal of as installed equipment.", FileTypes.XLSX,""),
    DD_1391("DD1391 Form","DD1391 Form", FileTypes.HTML,""),
    DD_1354("DD1354 Form","DD1354 Form", FileTypes.HTML,""),
    PRODUCT_TYPE_WARRANTY("Product Type Warranty Template","A COBie formatted spreadsheet for submittal of product type warrant information", FileTypes.XLSX,"");
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
    private COBieSerializerPluginInfo(String pluginName, String description, FileTypes fileType, String implementationClassName)
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
