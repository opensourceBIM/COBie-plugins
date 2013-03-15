package org.erdc.cobie.shared.enums;


public enum COBieSerializerPluginName
{
    COBIE_SHEET_XMLDATA("COBie Spreadsheet as Simple XML Document Elements"), 
    COBIE_SPREADSHEET("COBie SpreadsheetXML (2003)"), 
    COBIE_DESIGNQC("COBie QC Report - Design Deliverable"), 
    COBIE_CONSTRUCTIONQC("COBie QC Report - Construction Deliverable"), 
    COBIE_ROOM_DATASHEET_REPORT("COBieRoomDataSheet"), 
    COBIE_SPATIAL_DECOMPOSITION_REPORT("COBieSpatialDecompositionReport"), 
    COBIE_ZONE_REPORT("COBieZoneReport"), 
    COBIE_SYSTEM_REPORT("COBieSystemReport"), 
    COBIE_LITE("COBieLite RC2");
    
    private String pluginName;

    private COBieSerializerPluginName(String pluginName)
    {
        this.pluginName = pluginName;
    }

    @Override
    public String toString()
    {
        return pluginName;
    }
}
