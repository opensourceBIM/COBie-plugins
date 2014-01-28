package org.erdc.cobie.sqlite.service;

import java.sql.Connection;

import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.AssetTypeInfoType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.AssetTypeCollectionType;
import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.entity.Asset;
import org.erdc.cobie.sqlite.entity.AssetType;
import org.erdc.cobie.sqlite.entity.relationship.AssetTypeAsset;
import org.erdc.cobie.sqlite.entity.relationship.AssetTypeAttribute;
import org.erdc.cobie.sqlite.entity.relationship.FacilityAssetType;
import org.erdc.cobie.sqlite.service.attribute.AssetTypeAttributeService;

public final class AssetTypeService extends CobieCollectionService<AssetTypeCollectionType, 
																	AssetTypeInfoType, 
																	AssetType, 
																	FacilityAssetType>
{			
	private final AssetService assetService;
	private final AssetTypeAttributeService assetTypeAttributeService;	
	
	public AssetTypeService(Connection connection, 
								Class<AssetType> assetTypeClass,
								Class<FacilityAssetType> facilityAssetTypeClass) throws CobieSQLiteException 
	{
		super(connection, assetTypeClass, facilityAssetTypeClass);
		
		assetService = new AssetService(connection, Asset.class, AssetTypeAsset.class);
		assetTypeAttributeService = new AssetTypeAttributeService(connection, AssetTypeAttribute.class);
	}
    
	@Override
	public void clear() throws CobieSQLiteException
	{
		super.clear();
		assetService.clear();
		assetTypeAttributeService.clear();
	}
	
	@Deprecated // This method does not deal with Warranties b/c COBieLite warranty does not map to the SQLite schema.
	@Override
	protected void insertEntity(AssetTypeInfoType assetTypeInfoType, AssetType assetType, DatabaseKey facilityKey) throws CobieSQLiteException
    {				
		//WarrantyType[] warranties = assetTypeInfoType.getWarranties().getWarrantyArray();
		
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
				
		super.insertEntity(assetTypeInfoType, assetType, facilityKey);
		
		assetService.insert(assetTypeInfoType.getAssets(), getKey());
		assetTypeAttributeService.insert(assetTypeInfoType.getAssetTypeAttributes(), getKey());
    }

	@Override
	protected void insertRelationship(FacilityAssetType facilityAssetType, DatabaseKey facilityKey) throws CobieSQLiteException 
	{   	
		getExecutor().insertValidKey(facilityAssetType, FacilityAssetType.ColumnName.RefAssetType.toString(), getKey().get());
		getExecutor().insertValidKey(facilityAssetType, FacilityAssetType.ColumnName.RefFacility.toString(), facilityKey.get());
		
		super.insertRelationship(facilityAssetType, facilityKey);
	}
}
