package org.erdc.cobie.shared.sqlite.serializers;

import java.sql.Connection;

import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.AssetTypeInfoType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.AssetTypeCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.WarrantyType;
import org.erdc.cobie.shared.sqlite.serializers.attribute.AssetTypeAttributeSerializer;
import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.entities.Asset;
import org.erdc.cobie.sqlite.entities.AssetType;
import org.erdc.cobie.sqlite.entities.relationships.AssetTypeAsset;
import org.erdc.cobie.sqlite.entities.relationships.AssetTypeAttribute;
import org.erdc.cobie.sqlite.entities.relationships.FacilityAssetType;

public final class AssetTypeSerializer extends CobieCollectionSerializer<AssetTypeCollectionType, AssetTypeInfoType, AssetType, FacilityAssetType>
{	
	private static IntegerKey key = new IntegerKey();
		
	private final AssetSerializer assetSerializer;
	private final AssetTypeAttributeSerializer assetTypeAttributeSerializer;	
	
	public AssetTypeSerializer(Connection connection, 
								Class<AssetType> assetTypeClass,
								Class<FacilityAssetType> facilityAssetTypeClass) throws CobieSQLiteException 
	{
		super(connection, assetTypeClass, facilityAssetTypeClass);
		
		assetSerializer = new AssetSerializer(connection, Asset.class, AssetTypeAsset.class);
		assetTypeAttributeSerializer = new AssetTypeAttributeSerializer(connection, AssetTypeAttribute.class);
	}
    
	@Override
	public void clear() throws CobieSQLiteException
	{
		super.clear();
		assetSerializer.clear();
		assetTypeAttributeSerializer.clear();
	}
	
	@Override
	protected IntegerKey getKey() 
	{
		return key;
	}
	
	@Deprecated // This method does not deal with Warranties b/c COBieLite warranty does not map to the SQLite schema.
	@Override
	protected void insertEntity(AssetTypeInfoType assetTypeInfoType, AssetType assetType, int facilityID) throws CobieSQLiteException
    {		
		super.insertEntity(assetTypeInfoType, assetType, facilityID);
		
		WarrantyType[] warranties = assetTypeInfoType.getWarranties().getWarrantyArray();
		
		//insertValue(warranties[0].getWarrantyDuration());
		//insertValue(warranties[0].getW)	
		
		getExecutor().insertValidKey(assetType, AssetType.ColumnName.RefExpectedLifeValue.toString(), getExecutor().insertValue(assetTypeInfoType.getAssetTypeExpectedLifeValue()));
		getExecutor().insertValidKey(assetType, AssetType.ColumnName.RefNominalHeightValue.toString(), getExecutor().insertValue(assetTypeInfoType.getAssetTypeNominalHeight()));
		getExecutor().insertValidKey(assetType, AssetType.ColumnName.RefNominalLengthValue.toString(), getExecutor().insertValue(assetTypeInfoType.getAssetTypeNominalLength()));
		getExecutor().insertValidKey(assetType, AssetType.ColumnName.RefNominalWidthValue.toString(), getExecutor().insertValue(assetTypeInfoType.getAssetTypeNominalWidth()));

		getExecutor().insertValidEntity(assetType, AssetType.ColumnName.AssetTypeAccessibilityText.toString(), assetTypeInfoType.getAssetTypeAccessibilityText());
		getExecutor().insertValidEntity(assetType, AssetType.ColumnName.AssetTypeAccountingCategory.toString(), assetTypeInfoType.getAssetTypeAccountingCategory());
		getExecutor().insertValidEntity(assetType, AssetType.ColumnName.AssetTypeCategory.toString(), assetTypeInfoType.getAssetTypeCategory());
		getExecutor().insertValidEntity(assetType, AssetType.ColumnName.AssetTypeCodePerformance.toString(), assetTypeInfoType.getAssetTypeCodePerformance());
		getExecutor().insertValidEntity(assetType, AssetType.ColumnName.AssetTypeColorCode.toString(), assetTypeInfoType.getAssetTypeColorCode());
		getExecutor().insertValidEntity(assetType, AssetType.ColumnName.AssetTypeConstituentsDescription.toString(), assetTypeInfoType.getAssetTypeConstituentsDescription());
		getExecutor().insertValidEntity(assetType, AssetType.ColumnName.AssetTypeDescription.toString(), assetTypeInfoType.getAssetTypeDescription());
		getExecutor().insertValidEntity(assetType, AssetType.ColumnName.AssetTypeFeaturesDescription.toString(), assetTypeInfoType.getAssetTypeFeaturesDescription());
		getExecutor().insertValidEntity(assetType, AssetType.ColumnName.AssetTypeFinishDescription.toString(), assetTypeInfoType.getAssetTypeFinishDescription());
		getExecutor().insertValidEntity(assetType, AssetType.ColumnName.AssetTypeGradeDescription.toString(), assetTypeInfoType.getAssetTypeGradeDescription());
		getExecutor().insertValidEntity(assetType, AssetType.ColumnName.AssetTypeMaterialDescription.toString(), assetTypeInfoType.getAssetTypeMaterialDescription());
		getExecutor().insertValidEntity(assetType, AssetType.ColumnName.AssetTypeModelNumber.toString(), assetTypeInfoType.getAssetTypeModelNumber());
		getExecutor().insertValidEntity(assetType, AssetType.ColumnName.AssetTypeName.toString(), assetTypeInfoType.getAssetTypeName());
		getExecutor().insertValidEntity(assetType, AssetType.ColumnName.AssetTypeShapeDescription.toString(), assetTypeInfoType.getAssetTypeShapeDescription());
		getExecutor().insertValidEntity(assetType, AssetType.ColumnName.AssetTypeSizeDescription.toString(), assetTypeInfoType.getAssetTypeSizeDescription());
		getExecutor().insertValidEntity(assetType, AssetType.ColumnName.AssetTypeSustainabilityPerformanceDescription.toString(), assetTypeInfoType.getAssetTypeSustainabilityPerformanceDescription());
				
		assetSerializer.insert(assetTypeInfoType.getAssets(), getKey().get());
		assetTypeAttributeSerializer.insert(assetTypeInfoType.getAssetTypeAttributes(), getKey().get());
    }

	@Override
	protected void insertRelationship(FacilityAssetType facilityAssetType, int facilityID) throws CobieSQLiteException 
	{   	
		getExecutor().insertValidKey(facilityAssetType, FacilityAssetType.ColumnName.RefAssetType.toString(), getKey().get());
		getExecutor().insertValidKey(facilityAssetType, FacilityAssetType.ColumnName.RefFacility.toString(), facilityID);
	}
}
