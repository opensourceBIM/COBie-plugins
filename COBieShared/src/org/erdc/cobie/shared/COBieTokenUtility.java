package org.erdc.cobie.shared;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.erdc.cobie.shared.COBieUtility.CobieSheetName;

public class COBieTokenUtility
{
    public static enum AssemblyColumnNameLiterals
    {
        Name, CreatedBy, CreatedOn, SheetName, ParentName, ChildNames, AssemblyType, ExtSystem, ExtObject, ExtIdentifier, Description
    }

    public static enum AttributeColumnNameLiterals
    {
        Name, CreatedBy, CreatedOn, Category, SheetName, RowName, Value, Unit, ExtSystem, ExtObject, ExtIdentifier, Description, AllowedValues
    };

    public static enum ComponentColumnNameLiterals
    {
        Name, CreatedBy, CreatedOn, TypeName, Space, Description, ExtSystem, ExtObject, ExtIdentifier, SerialNumber, InstallationDate, WarrantyStartDate, TagNumber, BarCode, AssetIdentifier
    }

    public static enum ConnectionColumnNameLiterals
    {
        Name, CreatedBy, CreatedOn, ConnectionType, SheetName, RowName1, RowName2, RealizingElement, PortName1, PortName2, ExtSystem, ExtObject, ExtIdentifier, Description
    };

    public static enum ContactColumnNameLiterals
    {
        Email, CreatedBy, CreatedOn, Category, Company, Phone, ExternalSystem, ExternalObject, ExternalIdentifier, Department, OrganizationCode, GivenName, FamilyName, Street, PostalBox, Town, StateRegion, PostalCode, Country
    };

    public static enum DocumentColumnNameLiterals
    {
        Name, CreatedBy, CreatedOn, Category, ApprovalBy, Stage, SheetName, RowName, Directory, File, ExtSystem, ExtObject, ExtIdentifier, Description, Reference
    }

    public static enum FacilityColumnNameLiterals
    {
        Name, CreatedBy, CreatedOn, Category, ProjectName, SiteName, LinearUnits, AreaUnits, VolumeUnits, CurrencyUnit, AreaMeasurement, ExternalSystem, ExternalProjectObject, ExternalProjectIdentifier, ExternalSiteObject, ExternalSiteIdentifier, ExternalFacilityObject, ExternalFacilityIdentifier, Description, ProjectDescription, SiteDescription, Phase
    }

    public static enum FloorColumnNameLiterals
    {
        Name, CreatedBy, CreatedOn, Category, ExtSystem, ExtObject, ExtIdentifier, Description, Elevation, Height
    };

    public static enum SpaceColumnNameLiterals
    {
        Name, CreatedBy, CreatedOn, Category, FloorName, Description, ExtSystem, ExtObject, ExtIdentifier, RoomTag, UsableHeight, GrossArea, NetArea,
    }

    public static enum SystemColumnNameLiterals
    {
        Name, CreatedBy, CreatedOn, Category, ComponentNames, ExtSystem, ExtObject, ExtIdentifier, Description
    };

    public static enum TypeColumnNameLiterals
    {
        Name, CreatedBy, CreatedOn, Category, Description, AssetType, Manufacturer, ModelNumber, WarrantyGuarantorParts, WarrantyDurationParts, WarrantyGuarantorLabor, WarrantyDurationLabor, WarrantyDurationUnit, ExtSystem, ExtObject, ExtIdentifier, ReplacementCost, ExpectedLife, DurationUnit, WarrantyDescription, NominalLength, NominalWidth, NominalHeight, ModelReference, Shape, Size, Color, Finish, Grade, Material, Constituents, Features, AccessibilityPerformance, CodePerformance, SustainabilityPerformance
    }

    public static enum ZoneColumnNameLiterals
    {
        Name, CreatedBy, CreatedOn, Category, SpaceNames, ExtSystem, ExtObject, ExtIdentifier, Description
    };

    // TODO Move all column name,sheet name enums/lists here
    public static final ArrayList<String> AssemblyColumnNames = new ArrayList<String>(Arrays.asList("Name", "CreatedBy", "CreatedOn", "SheetName",
            "ParentName", "ChildNames", "AssemblyType", "ExtSystem", "ExtObject", "ExtIdentifier", "Description"));

    public static ArrayList<String> AttributeColumnNames = new ArrayList<String>(Arrays.asList("Name", "CreatedBy", "CreatedOn", "Category",
            "SheetName", "RowName", "Value", "Unit", "ExtSystem", "ExtObject", "ExtIdentifier", "Description", "AllowedValues"));
    public static ArrayList<String> ComponentColumnNames = new ArrayList<String>(Arrays.asList("Name", "CreatedBy", "CreatedOn", "TypeName", "Space",
            "Description", "ExtSystem", "ExtObject", "ExtIdentifier", "SerialNumber", "InstallationDate", "WarrantyStartDate", "TagNumber",
            "BarCode", "AssetIdentifier"));

    public static ArrayList<String> ConnectionColumnNames = new ArrayList<String>(Arrays.asList("Name", "CreatedBy", "CreatedOn", "ConnectionType",
            "SheetName", "RowName1", "RowName2", "RealizingElement", "PortName1", "PortName2", "ExtSystem", "ExtObject", "ExtIdentifier",
            "Description"));;
    public static ArrayList<String> ContactColumnNames = new ArrayList<String>(Arrays.asList("Email", "CreatedBy", "CreatedOn", "Category",
            "Company", "Phone", "ExternalSystem", "ExternalObject", "ExternalIdentifier", "Department", "OrganizationCode", "GivenName",
            "FamilyName", "Street", "PostalBox", "Town", "StateRegion", "PostalCode", "Country"));

    public static ArrayList<String> DocumentColumnNames = new ArrayList<String>(
            Arrays.asList("Name", "CreatedBy", "CreatedOn", "Category", "ApprovalBy", "Stage", "SheetName", "RowName", "Directory", "File",
                    "ExtSystem", "ExtObject", "ExtIdentifier", "Description", "Reference"));;

    public static ArrayList<String> FacilityColumnNames = new ArrayList<String>(Arrays.asList("Name", "CreatedBy", "CreatedOn", "Category",
            "ProjectName", "SiteName", "LinearUnits", "AreaUnits", "VolumeUnits", "CurrencyUnit", "AreaMeasurement", "ExternalSystem",
            "ExternalProjectObject", "ExternalProjectIdentifier", "ExternalSiteObject", "ExternalSiteIdentifier", "ExternalFacilityObject",
            "ExternalFacilityIdentifier", "Description", "ProjectDescription", "SiteDescription", "Phase"));
    public static ArrayList<String> FloorColumnNames = new ArrayList<String>(Arrays.asList("Name", "CreatedBy", "CreatedOn", "Category", "ExtSystem",
            "ExtObject", "ExtIdentifier", "Description", "Elevation", "Height"));;
    public static ArrayList<String> SpaceColumnNames = new ArrayList<String>(Arrays.asList("Name", "CreatedBy", "CreatedOn", "Category", "FloorName",
            "Description", "ExtSystem", "ExtObject", "ExtIdentifier", "RoomTag", "UsableHeight", "GrossArea", "NetArea"));;

    public static ArrayList<String> SystemColumnNames = new ArrayList<String>(Arrays.asList("Name", "CreatedBy", "CreatedOn", "Category",
            "ComponentNames", "ExtSystem", "ExtObject", "ExtIdentifier", "Description"));
    public static ArrayList<String> TypeColumnNames = new ArrayList<String>(Arrays.asList("Name", "CreatedBy", "CreatedOn", "Category",
            "Description", "AssetType", "Manufacturer", "ModelNumber", "WarrantyGuarantorParts", "WarrantyDurationParts", "WarrantyGuarantorLabor",
            "WarrantyDurationLabor", "WarrantyDurationUnit", "ExtSystem", "ExtObject", "ExtIdentifier", "ReplacementCost", "ExpectedLife",
            "DurationUnit", "WarrantyDescription", "NominalLength", "NominalWidth", "NominalHeight", "ModelReference", "Shape", "Size", "Color",
            "Finish", "Grade", "Material", "Constituents", "Features", "AccessibilityPerformance", "CodePerformance", "SustainabilityPerformance"));

    public static ArrayList<String> ZoneColumnNames = new ArrayList<String>(Arrays.asList("Name", "CreatedBy", "CreatedOn", "Category", "SpaceNames",
            "ExtSystem", "ExtObject", "ExtIdentifier", "Description"));;

    public static HashMap<CobieSheetName, ArrayList<String>> getCobieSheetNameColumnMappings()
    {
        // TODO complete this with the other sheets
        HashMap<CobieSheetName, ArrayList<String>> columnMappings = new HashMap<CobieSheetName, ArrayList<String>>();
        columnMappings.put(CobieSheetName.Contact, ContactColumnNames);
        columnMappings.put(CobieSheetName.Facility, FacilityColumnNames);
        columnMappings.put(CobieSheetName.Floor, FloorColumnNames);
        columnMappings.put(CobieSheetName.Space, SpaceColumnNames);
        columnMappings.put(CobieSheetName.Zone, ZoneColumnNames);
        columnMappings.put(CobieSheetName.Type, TypeColumnNames);
        columnMappings.put(CobieSheetName.System, SystemColumnNames);
        columnMappings.put(CobieSheetName.Assembly, AssemblyColumnNames);
        columnMappings.put(CobieSheetName.Attribute, AttributeColumnNames);
        columnMappings.put(CobieSheetName.Component, ComponentColumnNames);
        columnMappings.put(CobieSheetName.Connection, ConnectionColumnNames);
        columnMappings.put(CobieSheetName.Document, DocumentColumnNames);
        return columnMappings;
    }

}
