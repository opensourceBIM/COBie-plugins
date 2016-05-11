package com.prairiesky.transform.template;

import java.util.Arrays;
import java.util.Optional;

import org.apache.poi.ss.usermodel.Workbook;
import org.bimserver.cobie.shared.transform.Transformer;
import org.nibs.cobie.tab.AssemblyType;
import org.nibs.cobie.tab.AttributeType;
import org.nibs.cobie.tab.COBIEDocument;
import org.nibs.cobie.tab.COBIEType;
import org.nibs.cobie.tab.ComponentType;
import org.nibs.cobie.tab.ConnectionType;
import org.nibs.cobie.tab.ContactType;
import org.nibs.cobie.tab.CoordinateType;
import org.nibs.cobie.tab.DocumentType;
import org.nibs.cobie.tab.FacilityType;
import org.nibs.cobie.tab.FloorType;
import org.nibs.cobie.tab.ImpactType;
import org.nibs.cobie.tab.IssueType;
import org.nibs.cobie.tab.JobType;
import org.nibs.cobie.tab.ResourceType;
import org.nibs.cobie.tab.SpaceType;
import org.nibs.cobie.tab.SpareType;
import org.nibs.cobie.tab.SystemType;
import org.nibs.cobie.tab.TypeType;
import org.nibs.cobie.tab.ZoneType;

import com.prairiesky.transform.template.schema.SpreadsheetTemplateTable;
import com.prairiesky.transform.template.schema.cobietab.AssemblyRow;
import com.prairiesky.transform.template.schema.cobietab.AssemblyTable;
import com.prairiesky.transform.template.schema.cobietab.AttributeRow;
import com.prairiesky.transform.template.schema.cobietab.AttributeTable;
import com.prairiesky.transform.template.schema.cobietab.ComponentRow;
import com.prairiesky.transform.template.schema.cobietab.ComponentTable;
import com.prairiesky.transform.template.schema.cobietab.ConnectionRow;
import com.prairiesky.transform.template.schema.cobietab.ConnectionTable;
import com.prairiesky.transform.template.schema.cobietab.ContactRow;
import com.prairiesky.transform.template.schema.cobietab.ContactTable;
import com.prairiesky.transform.template.schema.cobietab.CoordinateRow;
import com.prairiesky.transform.template.schema.cobietab.CoordinateTable;
import com.prairiesky.transform.template.schema.cobietab.DocumentRow;
import com.prairiesky.transform.template.schema.cobietab.DocumentTable;
import com.prairiesky.transform.template.schema.cobietab.FacilityRow;
import com.prairiesky.transform.template.schema.cobietab.FacilityTable;
import com.prairiesky.transform.template.schema.cobietab.FloorRow;
import com.prairiesky.transform.template.schema.cobietab.FloorTable;
import com.prairiesky.transform.template.schema.cobietab.ImpactRow;
import com.prairiesky.transform.template.schema.cobietab.ImpactTable;
import com.prairiesky.transform.template.schema.cobietab.IssueRow;
import com.prairiesky.transform.template.schema.cobietab.IssueTable;
import com.prairiesky.transform.template.schema.cobietab.JobRow;
import com.prairiesky.transform.template.schema.cobietab.JobTable;
import com.prairiesky.transform.template.schema.cobietab.ResourceRow;
import com.prairiesky.transform.template.schema.cobietab.ResourceTable;
import com.prairiesky.transform.template.schema.cobietab.SpaceRow;
import com.prairiesky.transform.template.schema.cobietab.SpaceTable;
import com.prairiesky.transform.template.schema.cobietab.SpareRow;
import com.prairiesky.transform.template.schema.cobietab.SpareTable;
import com.prairiesky.transform.template.schema.cobietab.SystemRow;
import com.prairiesky.transform.template.schema.cobietab.SystemTable;
import com.prairiesky.transform.template.schema.cobietab.TypeRow;
import com.prairiesky.transform.template.schema.cobietab.TypeTable;
import com.prairiesky.transform.template.schema.cobietab.ZoneRow;
import com.prairiesky.transform.template.schema.cobietab.ZoneTable;
import com.prairiesky.transform.template.schema.productinstallation.TableCollection;

public class CobieXLSXToCobieTabTransform extends Transformer<Workbook, COBIEDocument>
{

	public CobieXLSXToCobieTabTransform(Workbook source, COBIEDocument target)
	{
		super(source, target);
	}

	@Override
	public COBIEDocument transform()
	{
		TableCollection collection = initializeTables();
		if(getTarget() == null)
		{
			setTarget(COBIEDocument.Factory.newInstance());
			getTarget().addNewCOBIE();
		}
		else
		{
			
			Optional.ofNullable(getTarget().getCOBIE())
					.orElse(getTarget().addNewCOBIE());
		}
		
		for(SpreadsheetTemplateTable table : collection.getTables())
		{
			if(table instanceof ContactTable)
			{
				populateContacts((ContactTable)table);
			}
			else if (table instanceof FacilityTable)
			{
				populateFacilities((FacilityTable)table);
			}
			else if (table instanceof FloorTable)
			{
				populateFloors((FloorTable)table);
			}
			else if (table instanceof SpaceTable)
			{
				populateSpaces((SpaceTable)table);
			}
			else if (table instanceof ZoneTable)
			{
				populateZones((ZoneTable)table);
			}
			else if (table instanceof TypeTable)
			{
				populateTypes((TypeTable)table);
			}
			else if (table instanceof ComponentTable)
			{
				populateComponents((ComponentTable)table);
			}
			else if (table instanceof SystemTable)
			{
				populateSystems((SystemTable)table);
			}
			else if (table instanceof AssemblyTable)
			{
				populateAssemblies((AssemblyTable)table);
			}
			else if (table instanceof ConnectionTable)
			{
				populateConnections((ConnectionTable)table);
			}
			else if (table instanceof ResourceTable)
			{
				populateResources((ResourceTable)table);
			}
			else if (table instanceof SpareTable)
			{
				populateSpares((SpareTable)table);
			}
			else if (table instanceof JobTable)
			{
				populateJobs((JobTable)table);
			}
			else if (table instanceof ImpactTable)
			{
				populateImpacts((ImpactTable)table);
			}
			else if (table instanceof DocumentTable)
			{
				populateDocuments((DocumentTable)table);
			}
			else if (table instanceof AttributeTable)
			{
				populateAttributes((AttributeTable)table);
			}
			else if (table instanceof CoordinateTable)
			{
				populateCoordinates((CoordinateTable)table);
			}
			else if (table instanceof IssueTable)
			{
				populateIssues((IssueTable)table);
			}
		}
		return getTarget();
	}

	private void populateIssues(IssueTable table)
	{
		COBIEType.Issues issues =
				Optional.ofNullable(getTarget().getCOBIE().getIssues())
				.orElse(getTarget().getCOBIE().addNewIssues());
		for(IssueRow row : table.getRows())
		{
			IssueType issue = issues.addNewIssue();
			issue.setName(row.Name().get());
			issue.setCreatedBy(row.CreatedBy().get());
			issue.setCreatedOn(row.CreatedOn().get());
			issue.setType(row.Type().get());
			issue.setRisk(row.Risk().get());
			issue.setChance(row.Chance().get());
			issue.setImpact(row.Impact().get());
			issue.setSheetName1(row.SheetName1().get());
			issue.setRowName1(row.RowName1().get());
			issue.setSheetName2(row.SheetName2().get());
			issue.setRowName2(row.RowName2().get());
			issue.setDescription(row.Description().get());
			issue.setOwner(row.Owner().get());
			issue.setMitigation(row.Mitigation().get());
			issue.setExtSystem(row.ExtSystem().get());
			issue.setExtObject(row.ExtObject().get());
			issue.setExtIdentifier(row.ExtIdentifier().get());

		}
		
	}

	private void populateCoordinates(CoordinateTable table)
	{
		COBIEType.Coordinates coordinates =
				Optional.ofNullable(getTarget().getCOBIE().getCoordinates())
				.orElse(getTarget().getCOBIE().addNewCoordinates());
		for(CoordinateRow row : table.getRows())
		{
			CoordinateType coordinate = coordinates.addNewCoordinate();
			coordinate.setName(row.Name().get());
			coordinate.setCreatedBy(row.CreatedBy().get());
			coordinate.setCreatedOn(row.CreatedOn().get());
			coordinate.setCategory(row.Category().get());
			coordinate.setSheetName(row.SheetName().get());
			coordinate.setRowName(row.RowName().get());
			coordinate.setCoordinateXAxis(row.CoordinateXAxis().get());
			coordinate.setCoordinateYAxis(row.CoordinateYAxis().get());
			coordinate.setCoordinateZAxis(row.CoordinateZAxis().get());
			coordinate.setExtSystem(row.ExtSystem().get());
			coordinate.setExtObject(row.ExtObject().get());
			coordinate.setExtIdentifier(row.ExtIdentifier().get());
			coordinate.setClockwiseRotation(row.ClockwiseRotation().get());
			coordinate.setElevationalRotation(row.ElevationalRotation().get());
			coordinate.setYawRotation(row.YawRotation().get());

		}
		
	}

	private void populateAttributes(AttributeTable table)
	{
		COBIEType.Attributes attributes =
				Optional.ofNullable(getTarget().getCOBIE().getAttributes())
				.orElse(getTarget().getCOBIE().addNewAttributes());
		for(AttributeRow row : table.getRows())
		{
			AttributeType attribute = attributes.addNewAttribute();
			attribute.setName(row.Name().get());
			attribute.setCreatedBy(row.CreatedBy().get());
			attribute.setCreatedOn(row.CreatedOn().get());
			attribute.setCategory(row.Category().get());
			attribute.setSheetName(row.SheetName().get());
			attribute.setRowName(row.RowName().get());
			attribute.setValue(row.Value().get());
			attribute.setUnit(row.Unit().get());
			attribute.setExtSystem(row.ExtSystem().get());
			attribute.setExtObject(row.ExtObject().get());
			attribute.setExtIdentifier(row.ExtIdentifier().get());
			attribute.setDescription(row.Description().get());
			attribute.setAllowedValues(row.AllowedValues().get());

		}
		
	}

	private void populateDocuments(DocumentTable table)
	{
		COBIEType.Documents documents =
				Optional.ofNullable(getTarget().getCOBIE().getDocuments())
				.orElse(getTarget().getCOBIE().addNewDocuments());
		for(DocumentRow row : table.getRows())
		{
			DocumentType document = documents.addNewDocument();
			document.setName(row.Name().get());
			document.setCreatedBy(row.CreatedBy().get());
			document.setCreatedOn(row.CreatedOn().get());
			document.setCategory(row.Category().get());
			document.setApprovalBy(row.ApprovalBy().get());
			document.setStage(row.Stage().get());
			document.setSheetName(row.SheetName().get());
			document.setRowName(row.RowName().get());
			document.setDirectory(row.Directory().get());
			document.setFile(row.File().get());
			document.setExtSystem(row.ExtSystem().get());
			document.setExtObject(row.ExtObject().get());
			document.setExtIdentifier(row.ExtIdentifier().get());
			document.setDescription(row.Description().get());
			document.setReference(row.Reference().get());

		}
		
	}

	private void populateImpacts(ImpactTable table)
	{
		COBIEType.Impacts impacts =
				Optional.ofNullable(getTarget().getCOBIE().getImpacts())
				.orElse(getTarget().getCOBIE().addNewImpacts());
		for(ImpactRow row : table.getRows())
		{
			ImpactType impact = impacts.addNewImpact();
			impact.setName(row.Name().get());
			impact.setCreatedBy(row.CreatedBy().get());
			impact.setCreatedOn(row.CreatedOn().get());
			impact.setImpactType(row.ImpactType().get());
			impact.setImpactStage(row.ImpactStage().get());
			impact.setSheetName(row.SheetName().get());
			impact.setRowName(row.RowName().get());
			impact.setValue(row.Value().get());
			impact.setImpactUnit(row.ImpactUnit().get());
			impact.setLeadInTime(row.LeadInTime().get());
			impact.setDuration(row.Duration().get());
			impact.setLeadOutTime(row.LeadOutTime().get());
			impact.setExtSystem(row.ExtSystem().get());
			impact.setExtObject(row.ExtObject().get());
			impact.setExtIdentifier(row.ExtIdentifier().get());
			impact.setDescription(row.Description().get());

		}
		
	}

	private void populateJobs(JobTable table)
	{
		COBIEType.Jobs jobs =
				Optional.ofNullable(getTarget().getCOBIE().getJobs())
				.orElse(getTarget().getCOBIE().addNewJobs());
		for(JobRow row : table.getRows())
		{
			JobType job = jobs.addNewJob();
			job.setName(row.Name().get());
			job.setCreatedBy(row.CreatedBy().get());
			job.setCreatedOn(row.CreatedOn().get());
			job.setCategory(row.Category().get());
			job.setStatus(row.Status().get());
			job.setTypeName(row.TypeName().get());
			job.setDescription(row.Description().get());
			job.setDuration(row.Duration().get());
			job.setDurationUnit(row.DurationUnit().get());
			job.setStart(row.Start().get());
			job.setTaskStartUnit(row.TaskStartUnit().get());
			job.setFrequency(row.Frequency().get());
			job.setFrequencyUnit(row.FrequencyUnit().get());
			job.setExtSystem(row.ExtSystem().get());
			job.setExtObject(row.ExtObject().get());
			job.setExtIdentifier(row.ExtIdentifier().get());
			job.setTaskNumber(row.TaskNumber().get());
			job.setPriors(row.Priors().get());
			job.setResourceNames(row.ResourceNames().get());

		}
		
	}

	private void populateSpares(SpareTable table)
	{
		COBIEType.Spares spares =
				Optional.ofNullable(getTarget().getCOBIE().getSpares())
				.orElse(getTarget().getCOBIE().addNewSpares());
		for(SpareRow row : table.getRows())
		{
			SpareType spare = spares.addNewSpare();
			spare.setName(row.Name().get());
			spare.setCreatedBy(row.CreatedBy().get());
			spare.setCreatedOn(row.CreatedOn().get());
			spare.setCategory(row.Category().get());
			spare.setTypeName(row.TypeName().get());
			spare.setSuppliers(row.Suppliers().get());
			spare.setExtSystem(row.ExtSystem().get());
			spare.setExtObject(row.ExtObject().get());
			spare.setExtIdentifier(row.ExtIdentifier().get());
			spare.setDescription(row.Description().get());
			spare.setSetNumber(row.SetNumber().get());
			spare.setPartNumber(row.PartNumber().get());

		}
		
	}

	private void populateResources(ResourceTable table)
	{
		COBIEType.Resources resources =
				Optional.ofNullable(getTarget().getCOBIE().getResources())
				.orElse(getTarget().getCOBIE().addNewResources());
		for(ResourceRow row : table.getRows())
		{
			ResourceType resource = resources.addNewResource();
			resource.setName(row.Name().get());
			resource.setCreatedBy(row.CreatedBy().get());
			resource.setCreatedOn(row.CreatedOn().get());
			resource.setCategory(row.Category().get());
			resource.setExtSystem(row.ExtSystem().get());
			resource.setExtObject(row.ExtObject().get());
			resource.setExtIdentifier(row.ExtIdentifier().get());
			resource.setDescription(row.Description().get());
		}
		
	}

	private void populateConnections(ConnectionTable table)
	{
		COBIEType.Connections connections =
				Optional.ofNullable(getTarget().getCOBIE().getConnections())
				.orElse(getTarget().getCOBIE().addNewConnections());
		for(ConnectionRow row : table.getRows())
		{
			ConnectionType connection = connections.addNewConnection();
			connection.setName(row.Name().get());
			connection.setCreatedBy(row.CreatedBy().get());
			connection.setCreatedOn(row.CreatedOn().get());
			connection.setConnectionType(row.ConnectionType().get());
			connection.setSheetName(row.SheetName().get());
			connection.setRowName1(row.RowName1().get());
			connection.setRowName2(row.RowName2().get());
			connection.setRealizingElement(row.RealizingElement().get());
			connection.setPortName1(row.PortName1().get());
			connection.setPortName2(row.PortName2().get());
			connection.setExtSystem(row.ExtSystem().get());
			connection.setExtObject(row.ExtObject().get());
			connection.setExtIdentifier(row.ExtIdentifier().get());
			connection.setDescription(row.Description().get());

		}
		
	}

	private void populateAssemblies(AssemblyTable table)
	{
		COBIEType.Assemblies assemblies =
				Optional.ofNullable(getTarget().getCOBIE().getAssemblies())
				.orElse(getTarget().getCOBIE().addNewAssemblies());
		for(AssemblyRow row : table.getRows())
		{
			AssemblyType assembly = assemblies.addNewAssembly();
			assembly.setName(row.Name().get());
			assembly.setCreatedBy(row.CreatedBy().get());
			assembly.setCreatedOn(row.CreatedOn().get());
			assembly.setSheetName(row.SheetName().get());
			assembly.setParentName(row.ParentName().get());
			assembly.setChildNames(row.ChildNames().get());
			assembly.setAssemblyType(row.AssemblyType().get());
			assembly.setExtSystem(row.ExtSystem().get());
			assembly.setExtObject(row.ExtObject().get());
			assembly.setExtIdentifier(row.ExtIdentifier().get());
			assembly.setDescription(row.Description().get());

		}
		
	}

	private void populateSystems(SystemTable table)
	{
		COBIEType.Systems systems =
				Optional.ofNullable(getTarget().getCOBIE().getSystems())
				.orElse(getTarget().getCOBIE().addNewSystems());
		for(SystemRow row : table.getRows())
		{
			SystemType system = systems.addNewSystem();
			system.setName(row.Name().get());
			system.setCreatedBy(row.CreatedBy().get());
			system.setCreatedOn(row.CreatedOn().get());
			system.setCategory(row.Category().get());
			system.setComponentNames(row.ComponentNames().get());
			system.setExtSystem(row.ExtSystem().get());
			system.setExtObject(row.ExtObject().get());
			system.setExtIdentifier(row.ExtIdentifier().get());
			system.setDescription(row.Description().get());

		}
		
	}

	private void populateComponents(ComponentTable table)
	{
		COBIEType.Components components =
				Optional.ofNullable(getTarget().getCOBIE().getComponents())
				.orElse(getTarget().getCOBIE().addNewComponents());
		for(ComponentRow row : table.getRows())
		{
			ComponentType component = components.addNewComponent();
			component.setName(row.Name().get());
			component.setCreatedBy(row.CreatedBy().get());
			component.setCreatedOn(row.CreatedOn().get());
			component.setTypeName(row.TypeName().get());
			component.setSpace(row.Space().get());
			component.setDescription(row.Description().get());
			component.setExtSystem(row.ExtSystem().get());
			component.setExtObject(row.ExtObject().get());
			component.setExtIdentifier(row.ExtIdentifier().get());
			component.setSerialNumber(row.SerialNumber().get());
			component.setInstallationDate(row.InstallationDate().get());
			component.setWarrantyStartDate(row.WarrantyStartDate().get());
			component.setTagNumber(row.TagNumber().get());
			component.setBarCode(row.BarCode().get());
			component.setAssetIdentifier(row.AssetIdentifier().get());

		}
		
	}

	private void populateTypes(TypeTable table)
	{
		COBIEType.Types types =
				Optional.ofNullable(getTarget().getCOBIE().getTypes())
				.orElse(getTarget().getCOBIE().addNewTypes());
		for(TypeRow row : table.getRows())
		{
			TypeType type = types.addNewType();
			type.setName(row.Name().get());
			type.setCreatedBy(row.CreatedBy().get());
			type.setCreatedOn(row.CreatedOn().get());
			type.setCategory(row.Category().get());
			type.setDescription(row.Description().get());
			type.setAssetType(row.AssetType().get());
			type.setManufacturer(row.Manufacturer().get());
			type.setModelNumber(row.ModelNumber().get());
			type.setWarrantyGuarantorParts(row.WarrantyGuarantorParts().get());
			type.setWarrantyDurationParts(row.WarrantyDurationParts().get());
			type.setWarrantyGuarantorLabor(row.WarrantyGuarantorLabor().get());
			type.setWarrantyDurationLabor(row.WarrantyDurationLabor().get());
			type.setWarrantyDurationUnit(row.WarrantyDurationUnit().get());
			type.setExtSystem(row.ExtSystem().get());
			type.setExtObject(row.ExtObject().get());
			type.setExtIdentifier(row.ExtIdentifier().get());
			type.setReplacementCost(row.ReplacementCost().get());
			type.setExpectedLife(row.ExpectedLife().get());
			type.setDurationUnit(row.DurationUnit().get());
			type.setWarrantyDescription(row.WarrantyDescription().get());
			type.setNominalLength(row.NominalLength().get());
			type.setNominalWidth(row.NominalWidth().get());
			type.setNominalHeight(row.NominalHeight().get());
			type.setModelReference(row.ModelReference().get());
			type.setShape(row.Shape().get());
			type.setSize(row.Size().get());
			type.setColor(row.Color().get());
			type.setFinish(row.Finish().get());
			type.setGrade(row.Grade().get());
			type.setMaterial(row.Material().get());
			type.setConstituents(row.Constituents().get());
			type.setFeatures(row.Features().get());
			type.setAccessibilityPerformance(row.AccessibilityPerformance().get());
			type.setCodePerformance(row.CodePerformance().get());
			type.setSustainabilityPerformance(row.SustainabilityPerformance().get());

		}
		
	}

	private void populateZones(ZoneTable table)
	{
		COBIEType.Zones zones =
				Optional.ofNullable(getTarget().getCOBIE().getZones())
				.orElse(getTarget().getCOBIE().addNewZones());
		for(ZoneRow row : table.getRows())
		{
			ZoneType zone = zones.addNewZone();
			zone.setName(row.Name().get());
			zone.setCreatedBy(row.CreatedBy().get());
			zone.setCreatedOn(row.CreatedOn().get());
			zone.setCategory(row.Category().get());
			zone.setSpaceNames(row.SpaceNames().get());
			zone.setExtSystem(row.ExtSystem().get());
			zone.setExtObject(row.ExtObject().get());
			zone.setExtIdentifier(row.ExtIdentifier().get());
			zone.setDescription(row.Description().get());

		}
		
	}

	private void populateSpaces(SpaceTable table)
	{
		COBIEType.Spaces spaces =
				Optional.ofNullable(getTarget().getCOBIE().getSpaces())
				.orElse(getTarget().getCOBIE().addNewSpaces());
		for(SpaceRow row : table.getRows())
		{
			SpaceType space = spaces.addNewSpace();
			space.setName(row.Name().get());
			space.setCreatedBy(row.CreatedBy().get());
			space.setCreatedOn(row.CreatedOn().get());
			space.setCategory(row.Category().get());
			space.setFloorName(row.FloorName().get());
			space.setDescription(row.Description().get());
			space.setExtSystem(row.ExtSystem().get());
			space.setExtObject(row.ExtObject().get());
			space.setExtIdentifier(row.ExtIdentifier().get());
			space.setRoomTag(row.RoomTag().get());
			space.setUsableHeight(row.UsableHeight().get());
			space.setGrossArea(row.GrossArea().get());
			space.setNetArea(row.NetArea().get());

		}
		
	}

	private void populateFloors(FloorTable table)
	{
		COBIEType.Floors floors =
				Optional.ofNullable(getTarget().getCOBIE().getFloors())
				.orElse(getTarget().getCOBIE().addNewFloors());
		for(FloorRow row : table.getRows())
		{
			FloorType floor = floors.addNewFloor();
			floor.setName(row.Name().get());
			floor.setCreatedBy(row.CreatedBy().get());
			floor.setCreatedOn(row.CreatedOn().get());
			floor.setCategory(row.Category().get());
			floor.setExtSystem(row.ExtSystem().get());
			floor.setExtObject(row.ExtObject().get());
			floor.setExtIdentifier(row.ExtIdentifier().get());
			floor.setDescription(row.Description().get());
			floor.setElevation(row.Elevation().get());
			floor.setHeight(row.Height().get());

		}
		
	}

	private void populateFacilities(FacilityTable table)
	{
		COBIEType.Facilities facilities =
				Optional.ofNullable(getTarget().getCOBIE().getFacilities())
				.orElse(getTarget().getCOBIE().addNewFacilities());
		for(FacilityRow row : table.getRows())
		{
			FacilityType facility = facilities.addNewFacility();
			facility.setName(row.Name().get());
			facility.setCreatedBy(row.CreatedBy().get());
			facility.setCreatedOn(row.CreatedOn().get());
			facility.setCategory(row.Category().get());
			facility.setProjectName(row.ProjectName().get());
			facility.setSiteName(row.SiteName().get());
			facility.setLinearUnits(row.LinearUnits().get());
			facility.setAreaUnits(row.AreaUnits().get());
			facility.setVolumeUnits(row.VolumeUnits().get());
			facility.setCurrencyUnit(row.CurrencyUnit().get());
			facility.setAreaMeasurement(row.AreaMeasurement().get());
			facility.setExternalSystem(row.ExternalSystem().get());
			facility.setExternalProjectObject(row.ExternalProjectObject().get());
			facility.setExternalProjectIdentifier(row.ExternalProjectIdentifier().get());
			facility.setExternalSiteObject(row.ExternalSiteObject().get());
			facility.setExternalSiteIdentifier(row.ExternalSiteIdentifier().get());
			facility.setExternalFacilityObject(row.ExternalFacilityObject().get());
			facility.setExternalFacilityIdentifier(row.ExternalFacilityIdentifier().get());
			facility.setDescription(row.Description().get());
			facility.setProjectDescription(row.ProjectDescription().get());
			facility.setSiteDescription(row.SiteDescription().get());
			facility.setPhase(row.Phase().get());

		}
		
	}

	private void populateContacts(ContactTable table)
	{
		COBIEType.Contacts contacts =
				Optional.ofNullable(getTarget().getCOBIE().getContacts()).orElse(getTarget().getCOBIE().addNewContacts());
		for(ContactRow row : table.getRows())
		{
			ContactType contact = contacts.addNewContact();
			contact.setEmail(row.Email().get());
			contact.setCreatedBy(row.CreatedBy().get());
			contact.setCreatedOn(row.CreatedOn().get());
			contact.setCategory(row.Category().get());
			contact.setCompany(row.Company().get());
			contact.setPhone(row.Phone().get());
			contact.setExternalSystem(row.ExternalSystem().get());
			contact.setExternalObject(row.ExternalObject().get());
			contact.setExternalIdentifier(row.ExternalIdentifier().get());
			contact.setDepartment(row.Department().get());
			contact.setOrganizationCode(row.OrganizationCode().get());
			contact.setGivenName(row.GivenName().get());
			contact.setFamilyName(row.FamilyName().get());
			contact.setStreet(row.Street().get());
			contact.setPostalBox(row.PostalBox().get());
			contact.setTown(row.Town().get());
			contact.setStateRegion(row.StateRegion().get());
			contact.setPostalCode(row.PostalCode().get());
			contact.setCountry(row.Country().get());

		}
		
	}

	private TableCollection initializeTables()
	{
		TableCollection tables = new TableCollection(Arrays.asList(
				new ContactTable(),
				new FacilityTable(),
				new FloorTable(),
				new SpaceTable(),
				new ZoneTable(),
				new TypeTable(),
				new ComponentTable(),
				new SystemTable(),
				new AssemblyTable(),
				new ConnectionTable(),
				new SpareTable(),
				new ResourceTable(),
				new JobTable(),
				new ImpactTable(),
				new DocumentTable(),
				new AttributeTable(),
				new CoordinateTable(),
				new IssueTable()));
		WorkbookTableTransform transformer =
				new WorkbookTableTransform(getSource(), tables);
		return transformer.transform();
		
	}
}
