package org.erdc.cobie.shared.enums;


public enum COBieSerializerPluginInfo implements PluginInfo
{
    SHEET_XMLDATA("COBie Spreadsheet as Simple XML Document Elements","XML based on a schema derived from the COBie spreadsheet columns.","xml"), 
    SPREADSHEET("COBie SpreadsheetXML (2003)","Construction Operators Building information exchange spreadsheetML format.","xml"), 
    REPORT_QC_DESIGN("COBie QC Report - Design Deliverable",
            "Produces a report of compliance to a COBie ruleset for the Design phase.",
            "html"), 
    REPORT_QC_CONSTRUCTION("COBie QC Report - Construction Deliverable",
            "Produces a report of compliance to a COBie ruleset.","html"), 
    REPORT_ROOM_DATASHEET("COBieRoomDataSheet","Produces a report of coponents by Space and then by type.","html"), 
    REPORT_SPATIAL_DECOMPOSITION("COBieSpatialDecompositionReport","Produces a report of spaces by floors.","html"), 
    REPORT_ZONE("COBieZoneReport","A report listing Zones, Spaces in Zones, and Zone COBie fields.","html"), 
    REPORT_SYSTEM("COBieSystemReport","Produces a report of systems and their corresponding components.","html"), 
    COBIE_LITE("COBieLite RC4","COBie Lite XML Release Candidate 4","xml"),
    DD_1391("DD1391 Form","DD1391 Form","html"),
    DD_1354("DD1354 Form","DD1354 Form","html");
    public String getDescription()
    {
        return description;
    }


    public void setDescription(String description)
    {
        this.description = description;
    }


    public String getFileExtension()
    {
        return fileExtension;
    }


    public void setFileExtension(String fileExtension)
    {
        this.fileExtension = fileExtension;
    }


    private String pluginName;
    private String description;
    private String fileExtension;
    private COBieSerializerPluginInfo(String pluginName, String description, String fileExtension)
    {
        this.pluginName = pluginName;
        this.description = description;
        this.fileExtension = fileExtension;
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
}
