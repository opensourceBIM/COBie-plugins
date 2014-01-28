package org.erdc.cobie.sqlite.service;

import java.sql.Connection;

import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.FacilityType;
import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.entity.AssetType;
import org.erdc.cobie.sqlite.entity.Contact;
import org.erdc.cobie.sqlite.entity.Facility;
import org.erdc.cobie.sqlite.entity.Floor;
import org.erdc.cobie.sqlite.entity.Zone;
import org.erdc.cobie.sqlite.entity.relationship.FacilityAssetType;
import org.erdc.cobie.sqlite.entity.relationship.FacilityAttribute;
import org.erdc.cobie.sqlite.entity.relationship.FacilityContact;
import org.erdc.cobie.sqlite.entity.relationship.FacilityFloor;
import org.erdc.cobie.sqlite.entity.relationship.FacilityZone;
import org.erdc.cobie.sqlite.entity.relationship.NoRelationship;
import org.erdc.cobie.sqlite.service.attribute.FacilityAttributeService;

public final class FacilityService extends CobieEntityService<FacilityType, Facility, NoRelationship> 
{	
	private final AssetTypeService assetTypeService;
	private final ContactService contactService;
	private final FacilityAttributeService facilityAttributeService;	
	private final FloorService floorService;
	private final ZoneService zoneService;
		
	public FacilityService(Connection connection) throws CobieSQLiteException 
	{
		super(connection, Facility.class, NoRelationship.class);
		
		assetTypeService = new AssetTypeService(connection, AssetType.class, FacilityAssetType.class);
		contactService = new ContactService(connection, Contact.class, FacilityContact.class);
		facilityAttributeService = new FacilityAttributeService(connection, FacilityAttribute.class);
		floorService = new FloorService(connection, Floor.class, FacilityFloor.class);
		zoneService = new ZoneService(connection, Zone.class, FacilityZone.class);
	}	
    
	@Override
	public void clear() throws CobieSQLiteException
	{
		super.clear();
		
		assetTypeService.clear();
		contactService.clear();
		facilityAttributeService.clear();
		floorService.clear();
		zoneService.clear();
	}
	
	@Override
    protected void insertEntity(FacilityType facilityType, Facility facility, DatabaseKey parentKey) throws CobieSQLiteException
    {          			
		getExecutor().insertValidEntity(facility, Facility.ColumnName.FacilityCategory.toString(), facilityType.getFacilityCategory());
		getExecutor().insertValidEntity(facility, Facility.ColumnName.FacilityDefaultAreaUnit.toString(), facilityType.getFacilityDefaultAreaUnit());
		getExecutor().insertValidEntity(facility, Facility.ColumnName.FacilityDefaultCurrencyUnit.toString(), facilityType.getFacilityDefaultCurrencyUnit());
		getExecutor().insertValidEntity(facility, Facility.ColumnName.FacilityDefaultLinearUnit.toString(), facilityType.getFacilityDefaultLinearUnit());
		getExecutor().insertValidEntity(facility, Facility.ColumnName.FacilityDefaultMeasurementStandard.toString(), facilityType.getFacilityDefaultMeasurementStandard());
		getExecutor().insertValidEntity(facility, Facility.ColumnName.FacilityDefaultVolumeUnit.toString(), facilityType.getFacilityDefaultVolumeUnit());
		getExecutor().insertValidEntity(facility, Facility.ColumnName.FacilityDeliverablePhaseName.toString(), facilityType.getFacilityDeliverablePhaseName());
		getExecutor().insertValidEntity(facility, Facility.ColumnName.FacilityDescription.toString(), facilityType.getFacilityDescription());
		getExecutor().insertValidEntity(facility, Facility.ColumnName.FacilityName.toString(), facilityType.getFacilityName());        
        
		super.insertEntity(facilityType, facility, parentKey);
		
        assetTypeService.insert(facilityType.getAssetTypes(), getKey());
        contactService.insert(facilityType.getContacts(), getKey());
        facilityAttributeService.insert(facilityType.getFacilityAttributes(), getKey());
        floorService.insert(facilityType.getFloors(), getKey());
        zoneService.insert(facilityType.getZones(), getKey());
    }
}
