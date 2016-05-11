package com.prairiesky.transform.template;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.apache.poi.ss.usermodel.Workbook;
import org.bimserver.cobie.shared.cobietab.AttributesDocumentsIssues;
import org.bimserver.cobie.shared.cobietab.IndexedCOBie;
import org.bimserver.cobie.shared.cobietab.key.KeyedDocumentType;
import org.bimserver.cobie.shared.transform.Transformer;
import org.bimserver.cobie.shared.utility.COBieNASetter;
import org.bimserver.cobie.shared.utility.COBieStringHandler;
import org.bimserver.cobie.shared.utility.COBieUtility;
import org.bimserver.cobie.shared.utility.COBieUtility.CobieSheetName;
import org.nibs.cobie.tab.AttributeType;
import org.nibs.cobie.tab.COBIEDocument;
import org.nibs.cobie.tab.COBIEType;
import org.nibs.cobie.tab.COBIEType.Attributes;
import org.nibs.cobie.tab.COBIEType.Components;
import org.nibs.cobie.tab.COBIEType.Contacts;
import org.nibs.cobie.tab.COBIEType.Facilities;
import org.nibs.cobie.tab.COBIEType.Floors;
import org.nibs.cobie.tab.ComponentType;
import org.nibs.cobie.tab.ContactType;
import org.nibs.cobie.tab.FacilityType;
import org.nibs.cobie.tab.FloorType;
import org.nibs.cobie.tab.SpaceType;
import org.nibs.cobie.tab.COBIEType.Spaces;
import org.nibs.cobie.tab.COBIEType.Types;
import org.nibs.cobie.tab.TypeType;

import com.prairiesky.transform.template.meta.AttributeName;
import com.prairiesky.transform.template.meta.ImportMode;
import com.prairiesky.transform.template.meta.StringTable;
import com.prairiesky.transform.template.schema.SpreadsheetTemplateTable;
import com.prairiesky.transform.template.schema.productinstallation.ContactLookupRow;
import com.prairiesky.transform.template.schema.productinstallation.ContactLookupTable;
import com.prairiesky.transform.template.schema.productinstallation.GeneralInstalledProduct;
import com.prairiesky.transform.template.schema.productinstallation.GeneralInstalledProductTable;
import com.prairiesky.transform.template.schema.productinstallation.SpaceLookupRow;
import com.prairiesky.transform.template.schema.productinstallation.SpaceLookupTable;
import com.prairiesky.transform.template.schema.productinstallation.TableCollection;
import com.prairiesky.transform.template.schema.productinstallation.TypeLookupRow;
import com.prairiesky.transform.template.schema.productinstallation.TypeLookupTable;

public class GeneralProductXLSXToCobieTransform extends
		Transformer<Workbook, COBIEDocument>
{
	private final ImportMode importMode;
	private Optional<IndexedCOBie> indexedTarget = Optional.empty();
	public GeneralProductXLSXToCobieTransform(Workbook source,
			COBIEDocument target, ImportMode importMode)
	{
		super(source, target);
		this.importMode = importMode;
	}

	@Override
	public COBIEDocument transform()
	{
		
		TableCollection tables = initializeTables();
		if (getTarget() == null)
		{
			target = COBIEDocument.Factory.newInstance();
		}
		COBIEType cobie;
		if(getTarget().getCOBIE() == null)
		{
			cobie = getTarget().addNewCOBIE();
		}
		else
		{
			cobie = getTarget().getCOBIE();
			setIndexedTarget(Optional.ofNullable(new IndexedCOBie(cobie)));
		}
		if(getImportMode().equals(ImportMode.NEW))
		{
			initializeFacility();
		}
		for(SpreadsheetTemplateTable table : tables.getTables())
		{
			if(table instanceof GeneralInstalledProductTable)
			{
				populateComponents((GeneralInstalledProductTable)table);
			}
			else if(table instanceof ContactLookupTable)
			{
				populateContacts((ContactLookupTable) table);
			}
			else if (table instanceof SpaceLookupTable && getImportMode().equals(ImportMode.NEW))
			{
				populateSpacesAndFloors((SpaceLookupTable) table);
			}
			else if (table instanceof TypeLookupTable && getImportMode().equals(importMode.NEW))
			{
				populateType((TypeLookupTable)table);
			}
		}
		return getTarget();
	}

	private void initializeFacility()
	{
		Facilities facilities = getTarget().getCOBIE().getFacilities();
		if(facilities == null)
		{
			facilities = getTarget().getCOBIE().addNewFacilities();
		}
		if(facilities.getFacilityList().isEmpty())
		{
			FacilityType facility = facilities.addNewFacility();
			COBieNASetter.setFacilityNA(facility);
			facility.setName(StringTable.DEFAULT_FACILITY_NAME.toString());
		}
	}

	private void populateType(TypeLookupTable table)
	{
		Types types = getTarget().getCOBIE().getTypes();
		if(types == null)
		{
			types = getTarget().getCOBIE().addNewTypes();
		}
		for(TypeLookupRow row: table.getRows())
		{
			TypeType type = types.addNewType();
			COBieNASetter.setTypeNA(type);
			type.setName(COBieUtility.getCOBieString(row.TypeName().get()));
		
		}
		
	}

	private void populateSpacesAndFloors(SpaceLookupTable table)
	{
		Spaces spaces = getTarget().getCOBIE().getSpaces();
		if(spaces == null)
		{
			spaces = getTarget().getCOBIE().addNewSpaces();
		}
		Floors floors = getTarget().getCOBIE().getFloors();
		if(floors == null)
		{
			floors = getTarget().getCOBIE().addNewFloors();
		}
		List<String> floorNames = new ArrayList<>();
		for(SpaceLookupRow row : table.getRows())
		{
			SpaceType space = spaces.addNewSpace();
			COBieNASetter.setSpaceNA(space);
			space.setName(COBieUtility.getCOBieString(row.RoomNumber().get()));
			space.setFloorName(COBieUtility.getCOBieString(row.FloorName().get()));
			if(!floorNames.contains(row.FloorName().get()))
			{
				floorNames.add(COBieUtility.getCOBieString(row.FloorName().get()));
			}
		}
		for(String floorName : floorNames)
		{
			if(!COBieUtility.isNA(floorName))
			{
				FloorType floor = floors.addNewFloor();
				COBieNASetter.setFloorNA(floor);
				floor.setName(floorName);
			}

		}
		
	}

	private void populateContacts(ContactLookupTable table)
	{
		Contacts contacts = getTarget().getCOBIE().getContacts();
		if(contacts == null)
		{
			contacts = getTarget().getCOBIE().addNewContacts();
		}
		for(ContactLookupRow row : table.getRows())
		{
			ContactType contact;
			Optional<String> email = Optional.ofNullable(COBieUtility.getCOBieString(row.Email().get()));
			switch(getImportMode())
			{
				case NEW:
					contact = contacts.addNewContact();
					COBieNASetter.setContactNA(contact);
					contact.setEmail(email.orElse(COBieUtility.COBieNA));
					break;
				case UPDATE:
					Optional<ContactType> contactQuery = 
							contacts.getContactList().stream().filter(c -> email.orElse(COBieUtility.COBieNA)
									.equalsIgnoreCase(c.getEmail())).findFirst();
					if(contactQuery.isPresent())
					{
						contact = contactQuery.get();
						contact.setEmail(email.orElse(COBieUtility.COBieNA));
					}
					else
					{
						contact = contacts.addNewContact();
						COBieNASetter.setContactNA(contact);
					}
					break;
				default:
					contact = contacts.addNewContact();
					COBieNASetter.setContactNA(contact);
					contact.setEmail(email.orElse(COBieUtility.COBieNA));
					break;
				
			}
			
			contact.setCategory(COBieUtility.getCOBieString(row.Category().get()));
			contact.setCompany(COBieUtility.getCOBieString(row.Company().get()));
			contact.setCountry(COBieUtility.getCOBieString(row.Country().get()));
			contact.setDepartment(COBieUtility.getCOBieString(row.Department().get()));
			contact.setFamilyName(COBieUtility.getCOBieString(row.FamilyName().get()));
			contact.setGivenName(COBieUtility.getCOBieString(row.GivenName().get()));
			contact.setOrganizationCode(COBieUtility.getCOBieString(row.OrganizationCode().get()));
			contact.setPhone(COBieUtility.getCOBieString(row.Phone().get()));
			contact.setPostalBox(COBieUtility.getCOBieString(row.PostalBox().get()));
			contact.setPostalCode(COBieUtility.getCOBieString(row.PostalCode().get()));
			contact.setStateRegion(COBieUtility.getCOBieString(row.StateRegion().get()));
			contact.setStreet(COBieUtility.getCOBieString(row.Street().get()));
			contact.setTown(COBieUtility.getCOBieString(row.Town().get()));
		}
	}

	private void populateComponents(GeneralInstalledProductTable table)
	{
		Components components = getTarget().getCOBIE().getComponents();
		if(components == null)
		{
			components = getTarget().getCOBIE().addNewComponents();
		}
		for(GeneralInstalledProduct row : table.getRows())
		{
			
			ComponentType component;
			switch(getImportMode())
			{
				case NEW:
					component = components.addNewComponent();
					COBieNASetter.setComponentNA(component);
					component.setName(COBieUtility.getCOBieString(row.Product().get()));
					component.setTypeName(COBieUtility.getCOBieString(row.ProductType().get()));
					break;
				case UPDATE:
					Optional<ComponentType> componentQuery =
					components.getComponentList().stream().
					filter(c -> Optional.ofNullable(row.Product().get()).orElse(COBieUtility.COBieNA).
							equalsIgnoreCase(c.getName())).findFirst();
					if(componentQuery.isPresent())
					{
						component = componentQuery.get();
					}
					else
					{
						component = components.addNewComponent();
						COBieNASetter.setComponentNA(component);
						component.setName(COBieUtility.getCOBieString(row.Product().get()));
						component.setTypeName(COBieUtility.getCOBieString(row.ProductType().get()));
					}
					break;
				default:
					component = components.addNewComponent();
					COBieNASetter.setComponentNA(component);
					component.setName(COBieUtility.getCOBieString(row.Product().get()));
					component.setTypeName(COBieUtility.getCOBieString(row.ProductType().get()));
					break;
				
			}
		
			if(!Optional.ofNullable(component.getSerialNumber()).isPresent() || component.getSerialNumber().isEmpty())
			{
				component.setSerialNumber(COBieUtility.getCOBieString(row.InstalledSerialNumber().get()));
			}
			component.setTagNumber(COBieUtility.getCOBieString(row.TagNumber().get()));
			component.setInstallationDate(COBieUtility.StringFromCalendar(row.InstalledOn().get()));
			component.setWarrantyStartDate(COBieUtility.StringFromCalendar(row.StartedOn().get()));
			setComponentAttributes(row, component);
		}
		
	}

	private void setComponentAttributes(GeneralInstalledProduct row,
			ComponentType component)
	{
		Attributes attributes = getTarget().getCOBIE().getAttributes();
		if(attributes == null)
		{
			attributes = getTarget().getCOBIE().addNewAttributes();
		}
		initComponentAttribute(component, attributes, AttributeName.CRITICAL, row.Critical().get());
		initComponentAttribute(component, attributes, AttributeName.INSTALLED_MODEL_NUMBER, row.InstalledModelNumber().get());
		initComponentAttribute(component, attributes, AttributeName.INSTALLED_SERIAL_NUMBER, row.InstalledSerialNumber().get());
		initComponentAttribute(component, attributes, AttributeName.SUPPLIER, row.Supplier().get());
		
		
	}

	private void initComponentAttribute(ComponentType component, 
			Attributes attributes, 
			AttributeName attributeName, 
			String value)
	{
		AttributeType attribute = null;
		if(getImportMode().equals(ImportMode.UPDATE) && getIndexedTarget().isPresent())
		{
			AttributesDocumentsIssues descriptiveElements = getIndexedTarget().get().getDescriptiveElementIndex().getDescriptiveDataBySheetNameRowName(CobieSheetName.Component, 
					component.getName());
			Optional<AttributeType> attributeQuery =
					descriptiveElements.getAttributes().stream().filter(a -> Optional.ofNullable(a.getName()).orElse("").equalsIgnoreCase(attributeName.toString())).findFirst();
			if(attributeQuery.isPresent())
			{
				attribute = attributeQuery.get();
			}

		}
		if(attribute == null)
		{
			attribute = attributes.addNewAttribute();
			COBieNASetter.setAttributeNA(attribute);
			attribute.setName(COBieUtility.getCOBieString(attributeName.toString()));
			attribute.setRowName(COBieUtility.getCOBieString(component.getName()));
			attribute.setSheetName(CobieSheetName.Component.toString());
		}
		attribute.setValue(COBieUtility.getCOBieString(value));
	}
	
	

	private TableCollection initializeTables()
	{
		TableCollection tables =
				new TableCollection(Arrays.asList(
						new GeneralInstalledProductTable(),
						new ContactLookupTable(),
						new SpaceLookupTable(),
						new TypeLookupTable()));
		WorkbookTableTransform transformer =
				new WorkbookTableTransform(getSource(), tables);
		return transformer.transform();
	}

	public ImportMode getImportMode()
	{
		return importMode;
	}

	public Optional<IndexedCOBie> getIndexedTarget()
	{
		return indexedTarget;
	}

	public void setIndexedTarget(Optional<IndexedCOBie> indexedTarget)
	{
		this.indexedTarget = indexedTarget;
	}

}
