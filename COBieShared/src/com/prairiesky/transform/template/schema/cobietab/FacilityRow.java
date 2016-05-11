package com.prairiesky.transform.template.schema.cobietab;

import java.util.Calendar;

import org.nibs.cobie.tab.FacilityType;

import com.prairiesky.lang.Property;
import com.prairiesky.transform.template.meta.ExcelReference;
import com.prairiesky.transform.template.meta.ExcelReference.ColumnAddress;
import com.prairiesky.transform.template.schema.SpreadsheetTemplateRow;

@ExcelReference(spreadsheetName="Facility")
public class FacilityRow extends SpreadsheetTemplateRow
{
	private final Property<String> name = new Property<>(String.class);
	private final Property<String> createdBy = new Property<>(String.class);
	private final Property<Calendar> createdOn = new Property<>(Calendar.class);
	private final Property<String> category = new Property<>(String.class);
	private final Property<String> projectName = new Property<>(String.class);
	private final Property<String> siteName = new Property<>(String.class);
	private final Property<String> linearUnits = new Property<>(String.class);
	private final Property<String> areaUnits = new Property<>(String.class);
	private final Property<String> volumeUnits = new Property<>(String.class);
	private final Property<String> currencyUnit = new Property<>(String.class);
	private final Property<String> areaMeasurement = new Property<>(
			String.class);
	private final Property<String> externalSystem = new Property<>(String.class);
	private final Property<String> externalProjectObject = new Property<>(
			String.class);
	private final Property<String> externalProjectIdentifier = new Property<>(
			String.class);
	private final Property<String> externalSiteObject = new Property<>(
			String.class);
	private final Property<String> externalSiteIdentifier = new Property<>(
			String.class);
	private final Property<String> externalFacilityObject = new Property<>(
			String.class);
	private final Property<String> externalFacilityIdentifier = new Property<>(
			String.class);
	private final Property<String> description = new Property<>(String.class);
	private final Property<String> projectDescription = new Property<>(
			String.class);
	private final Property<String> siteDescription = new Property<>(
			String.class);
	private final Property<String> phase = new Property<>(String.class);

	@ExcelReference(columnAddress = ColumnAddress.A, columnName = "Name", isPrimaryKey = true)
	public final Property<String> Name()
	{
		return name;
	}

	@ExcelReference(columnAddress = ColumnAddress.B, columnName = "CreatedBy", isPrimaryKey = false)
	public final Property<String> CreatedBy()
	{
		return createdBy;
	}

	@ExcelReference(columnAddress = ColumnAddress.C, columnName = "CreatedOn", isPrimaryKey = false)
	public final Property<Calendar> CreatedOn()
	{
		return createdOn;
	}

	@ExcelReference(columnAddress = ColumnAddress.D, columnName = "Category", isPrimaryKey = false)
	public final Property<String> Category()
	{
		return category;
	}

	@ExcelReference(columnAddress = ColumnAddress.E, columnName = "ProjectName", isPrimaryKey = false)
	public final Property<String> ProjectName()
	{
		return projectName;
	}

	@ExcelReference(columnAddress = ColumnAddress.F, columnName = "SiteName", isPrimaryKey = false)
	public final Property<String> SiteName()
	{
		return siteName;
	}

	@ExcelReference(columnAddress = ColumnAddress.G, columnName = "LinearUnits", isPrimaryKey = false)
	public final Property<String> LinearUnits()
	{
		return linearUnits;
	}

	@ExcelReference(columnAddress = ColumnAddress.H, columnName = "AreaUnits", isPrimaryKey = false)
	public final Property<String> AreaUnits()
	{
		return areaUnits;
	}

	@ExcelReference(columnAddress = ColumnAddress.I, columnName = "VolumeUnits", isPrimaryKey = false)
	public final Property<String> VolumeUnits()
	{
		return volumeUnits;
	}

	@ExcelReference(columnAddress = ColumnAddress.J, columnName = "CurrencyUnit", isPrimaryKey = false)
	public final Property<String> CurrencyUnit()
	{
		return currencyUnit;
	}

	@ExcelReference(columnAddress = ColumnAddress.K, columnName = "AreaMeasurement", isPrimaryKey = false)
	public final Property<String> AreaMeasurement()
	{
		return areaMeasurement;
	}

	@ExcelReference(columnAddress = ColumnAddress.L, columnName = "ExternalSystem", isPrimaryKey = false)
	public final Property<String> ExternalSystem()
	{
		return externalSystem;
	}

	@ExcelReference(columnAddress = ColumnAddress.M, columnName = "ExternalProjectObject", isPrimaryKey = false)
	public final Property<String> ExternalProjectObject()
	{
		return externalProjectObject;
	}

	@ExcelReference(columnAddress = ColumnAddress.N, columnName = "ExternalProjectIdentifier", isPrimaryKey = false)
	public final Property<String> ExternalProjectIdentifier()
	{
		return externalProjectIdentifier;
	}

	@ExcelReference(columnAddress = ColumnAddress.O, columnName = "ExternalSiteObject", isPrimaryKey = false)
	public final Property<String> ExternalSiteObject()
	{
		return externalSiteObject;
	}

	@ExcelReference(columnAddress = ColumnAddress.P, columnName = "ExternalSiteIdentifier", isPrimaryKey = false)
	public final Property<String> ExternalSiteIdentifier()
	{
		return externalSiteIdentifier;
	}

	@ExcelReference(columnAddress = ColumnAddress.Q, columnName = "ExternalFacilityObject", isPrimaryKey = false)
	public final Property<String> ExternalFacilityObject()
	{
		return externalFacilityObject;
	}

	@ExcelReference(columnAddress = ColumnAddress.R, columnName = "ExternalFacilityIdentifier", isPrimaryKey = false)
	public final Property<String> ExternalFacilityIdentifier()
	{
		return externalFacilityIdentifier;
	}

	@ExcelReference(columnAddress = ColumnAddress.S, columnName = "Description", isPrimaryKey = false)
	public final Property<String> Description()
	{
		return description;
	}

	@ExcelReference(columnAddress = ColumnAddress.T, columnName = "ProjectDescription", isPrimaryKey = false)
	public final Property<String> ProjectDescription()
	{
		return projectDescription;
	}

	@ExcelReference(columnAddress = ColumnAddress.U, columnName = "SiteDescription", isPrimaryKey = false)
	public final Property<String> SiteDescription()
	{
		return siteDescription;
	}

	@ExcelReference(columnAddress = ColumnAddress.V, columnName = "Phase", isPrimaryKey = false)
	public final Property<String> Phase()
	{
		return phase;
	}
	
	public void populateFromCobieFacility(FacilityType facility)
	{
		AreaMeasurement().set(facility.getAreaMeasurement());
		AreaUnits().set(facility.getAreaUnits());
		Category().set(facility.getCategory());
		CreatedBy().set(facility.getCategory());
		CreatedOn().set(facility.getCreatedOn());
		CurrencyUnit().set(facility.getCurrencyUnit());
		Description().set(facility.getDescription());
		ExternalFacilityIdentifier().set(facility.getExternalFacilityIdentifier());
		ExternalFacilityObject().set(facility.getExternalFacilityObject());
		ExternalProjectIdentifier().set(facility.getExternalProjectIdentifier());
		ExternalProjectObject().set(facility.getExternalProjectObject());
		ExternalSiteIdentifier().set(facility.getExternalSiteIdentifier());
		ExternalSystem().set(facility.getExternalSystem());
		ExternalSiteObject().set(facility.getExternalSiteObject());
		LinearUnits().set(facility.getLinearUnits());
		Name().set(facility.getName());
		Phase().set(facility.getPhase());
		ProjectDescription().set(facility.getProjectDescription());
		ProjectName().set(facility.getProjectName());
		SiteDescription().set(facility.getSiteDescription());
		SiteName().set(facility.getSiteName());
		VolumeUnits().set(facility.getVolumeUnits());
	}

}
