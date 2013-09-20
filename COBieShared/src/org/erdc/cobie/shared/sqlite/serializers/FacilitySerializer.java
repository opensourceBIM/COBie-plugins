package org.erdc.cobie.shared.sqlite.serializers;

import java.sql.Connection;

import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.FacilityType;
import org.erdc.cobie.shared.sqlite.serializers.attribute.FacilityAttributeSerializer;
import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.entities.AssetType;
import org.erdc.cobie.sqlite.entities.Contact;
import org.erdc.cobie.sqlite.entities.Facility;
import org.erdc.cobie.sqlite.entities.Floor;
import org.erdc.cobie.sqlite.entities.Zone;
import org.erdc.cobie.sqlite.entities.relationships.FacilityAssetType;
import org.erdc.cobie.sqlite.entities.relationships.FacilityAttribute;
import org.erdc.cobie.sqlite.entities.relationships.FacilityContact;
import org.erdc.cobie.sqlite.entities.relationships.FacilityFloor;
import org.erdc.cobie.sqlite.entities.relationships.FacilityZone;
import org.erdc.cobie.sqlite.entities.relationships.NoRelationship;

public final class FacilitySerializer extends CobieEntitySerializer<FacilityType, Facility, NoRelationship> 
{
	private static IntegerKey key = new IntegerKey();
	
	private final AssetTypeSerializer assetTypeSerializer;
	private final ContactSerializer contactSerializer;
	private final FacilityAttributeSerializer facilityAttributeSerializer;	
	private final FloorSerializer floorSerializer;
	private final ZoneSerializer zoneSerializer;
		
	public FacilitySerializer(Connection connection) throws CobieSQLiteException 
	{
		super(connection, Facility.class, NoRelationship.class);
		
		assetTypeSerializer = new AssetTypeSerializer(connection, AssetType.class, FacilityAssetType.class);
		contactSerializer = new ContactSerializer(connection, Contact.class, FacilityContact.class);
		facilityAttributeSerializer = new FacilityAttributeSerializer(connection, FacilityAttribute.class);
		floorSerializer = new FloorSerializer(connection, Floor.class, FacilityFloor.class);
		zoneSerializer = new ZoneSerializer(connection, Zone.class, FacilityZone.class);
	}	
    
	@Override
	public void clear() throws CobieSQLiteException
	{
		super.clear();
		
		assetTypeSerializer.clear();
		contactSerializer.clear();
		facilityAttributeSerializer.clear();
		floorSerializer.clear();
		zoneSerializer.clear();
	}
	
	@Override
	protected IntegerKey getKey() 
	{
		return key;
	}
	
	@Override
    protected void insertEntity(FacilityType facilityType, Facility facility, int parentID) throws CobieSQLiteException
    {          	
		super.insertEntity(facilityType, facility, parentID);
		
		getExecutor().insertValidEntity(facility, Facility.ColumnName.FacilityCategory.toString(), facilityType.getFacilityCategory());
		getExecutor().insertValidEntity(facility, Facility.ColumnName.FacilityDefaultAreaUnit.toString(), facilityType.getFacilityDefaultAreaUnit());
		getExecutor().insertValidEntity(facility, Facility.ColumnName.FacilityDefaultCurrencyUnit.toString(), facilityType.getFacilityDefaultCurrencyUnit());
		getExecutor().insertValidEntity(facility, Facility.ColumnName.FacilityDefaultLinearUnit.toString(), facilityType.getFacilityDefaultLinearUnit());
		getExecutor().insertValidEntity(facility, Facility.ColumnName.FacilityDefaultMeasurementStandard.toString(), facilityType.getFacilityDefaultMeasurementStandard());
		getExecutor().insertValidEntity(facility, Facility.ColumnName.FacilityDefaultVolumeUnit.toString(), facilityType.getFacilityDefaultVolumeUnit());
		getExecutor().insertValidEntity(facility, Facility.ColumnName.FacilityDeliverablePhaseName.toString(), facilityType.getFacilityDeliverablePhaseName());
		getExecutor().insertValidEntity(facility, Facility.ColumnName.FacilityDescription.toString(), facilityType.getFacilityDescription());
		getExecutor().insertValidEntity(facility, Facility.ColumnName.FacilityName.toString(), facilityType.getFacilityName());        
        
        assetTypeSerializer.insert(facilityType.getAssetTypes(), getKey().get());
        contactSerializer.insert(facilityType.getContacts(), getKey().get());
        facilityAttributeSerializer.insert(facilityType.getFacilityAttributes(), getKey().get());
        floorSerializer.insert(facilityType.getFloors(), getKey().get());
        zoneSerializer.insert(facilityType.getZones(), getKey().get());
    }
}
