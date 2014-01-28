package org.erdc.cobie.sqlite.service;

import java.sql.Connection;

import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.AssetInfoType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.AssetCollectionType;
import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.entity.Asset;
import org.erdc.cobie.sqlite.entity.relationship.AssetAttribute;
import org.erdc.cobie.sqlite.entity.relationship.AssetDocument;
import org.erdc.cobie.sqlite.entity.relationship.AssetTypeAsset;
import org.erdc.cobie.sqlite.service.attribute.AssetAttributeService;
import org.erdc.cobie.sqlite.service.document.AssetDocumentService;

public final class AssetService extends CobieCollectionService<AssetCollectionType, AssetInfoType, Asset, AssetTypeAsset> 
{	
	private final AssetAttributeService assetAttributeService;
	private final AssetDocumentService assetDocumentService;
	
	public AssetService(Connection connection, 
							Class<Asset> entityClass,
							Class<AssetTypeAsset> relationshipClass) throws CobieSQLiteException 
	{
		super(connection, entityClass, relationshipClass);		
		assetAttributeService = new AssetAttributeService(connection, AssetAttribute.class);
		assetDocumentService = new AssetDocumentService(connection, AssetDocument.class);
	}

	@Override
	public void clear() throws CobieSQLiteException
	{
		super.clear();
		assetAttributeService.clear();
		assetDocumentService.clear();
	}
	
	@Override
	protected void insertEntity(AssetInfoType assetInfoType, Asset asset, DatabaseKey assetTypeKey) throws CobieSQLiteException 
	{		   	    	
		getExecutor().insertValidEntity(asset, Asset.ColumnName.AssetBarCode.toString(), assetInfoType.getAssetBarCode());
		getExecutor().insertValidEntity(asset, Asset.ColumnName.AssetDescription.toString(), assetInfoType.getAssetDescription());
		getExecutor().insertValidEntity(asset, Asset.ColumnName.AssetIdentifier.toString(), assetInfoType.getAssetIdentifier());
		getExecutor().insertValidEntity(asset, Asset.ColumnName.AssetInstallationDate.toString(), assetInfoType.getAssetInstallationDate());
		getExecutor().insertValidEntity(asset, Asset.ColumnName.AssetInstalledModelNumber.toString(), assetInfoType.getAssetInstalledModelNumber());
		getExecutor().insertValidEntity(asset, Asset.ColumnName.AssetLocationDescription.toString(), assetInfoType.getAssetLocationDescription());
		getExecutor().insertValidEntity(asset, Asset.ColumnName.AssetName.toString(), assetInfoType.getAssetName());
		getExecutor().insertValidEntity(asset, Asset.ColumnName.AssetSerialNumber.toString(), assetInfoType.getAssetSerialNumber());
		getExecutor().insertValidEntity(asset, Asset.ColumnName.AssetStartDate.toString(), assetInfoType.getAssetStartDate());
		getExecutor().insertValidEntity(asset, Asset.ColumnName.AssetTagNumber.toString(), assetInfoType.getAssetTagNumber());
		getExecutor().insertValidEntity(asset, Asset.ColumnName.AssetWarrantyStartDate.toString(), assetInfoType.getAssetWarrantyStartDate());
    	
    	super.insertEntity(assetInfoType, asset, assetTypeKey);
    	
    	assetAttributeService.insert(assetInfoType.getAssetAttributes(), getKey());
    	assetDocumentService.insert(assetInfoType.getAssetDocuments(), getKey());
	}
	
	@Override
    protected void insertRelationship(AssetTypeAsset assetTypeAsset, DatabaseKey assetTypeKey) throws CobieSQLiteException
    {
		getExecutor().insertValidKey(assetTypeAsset, AssetTypeAsset.ColumnName.RefAsset.toString(), getKey().get());
		getExecutor().insertValidKey(assetTypeAsset, AssetTypeAsset.ColumnName.RefAssetType.toString(), assetTypeKey.get());
		
		super.insertRelationship(assetTypeAsset, assetTypeKey);
    }
}
