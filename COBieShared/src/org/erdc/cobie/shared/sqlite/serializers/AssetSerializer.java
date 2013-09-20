package org.erdc.cobie.shared.sqlite.serializers;

import java.sql.Connection;

import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.AssetInfoType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.AssetCollectionType;
import org.erdc.cobie.shared.sqlite.serializers.attribute.AssetAttributeSerializer;
import org.erdc.cobie.shared.sqlite.serializers.document.AssetDocumentSerializer;
import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.entities.Asset;
import org.erdc.cobie.sqlite.entities.relationships.AssetAttribute;
import org.erdc.cobie.sqlite.entities.relationships.AssetDocument;
import org.erdc.cobie.sqlite.entities.relationships.AssetTypeAsset;

public final class AssetSerializer extends CobieCollectionSerializer<AssetCollectionType, AssetInfoType, Asset, AssetTypeAsset> 
{
	private static IntegerKey key = new IntegerKey();
	
	private final AssetAttributeSerializer assetAttributeSerializer;
	private final AssetDocumentSerializer assetDocumentSerializer;
	
	public AssetSerializer(Connection connection, 
							Class<Asset> entityClass,
							Class<AssetTypeAsset> relationshipClass) throws CobieSQLiteException 
	{
		super(connection, entityClass, relationshipClass);		
		assetAttributeSerializer = new AssetAttributeSerializer(connection, AssetAttribute.class);
		assetDocumentSerializer = new AssetDocumentSerializer(connection, AssetDocument.class);
	}

	@Override
	public void clear() throws CobieSQLiteException
	{
		super.clear();
		assetAttributeSerializer.clear();
		assetDocumentSerializer.clear();
	}
	
	@Override
	protected IntegerKey getKey() 
	{
		return key;
	}
	
	@Override
	protected void insertEntity(AssetInfoType assetInfoType, Asset asset, int assetTypeID) throws CobieSQLiteException 
	{		
		super.insertEntity(assetInfoType, asset, assetTypeID);
    	
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
    	
    	assetAttributeSerializer.insert(assetInfoType.getAssetAttributes(), getKey().get());
    	assetDocumentSerializer.insert(assetInfoType.getAssetDocuments(), getKey().get());
	}
	
	@Override
    protected void insertRelationship(AssetTypeAsset assetTypeAsset, int assetTypeID) throws CobieSQLiteException
    {
		getExecutor().insertValidKey(assetTypeAsset, AssetTypeAsset.ColumnName.RefAsset.toString(), getKey().get());
		getExecutor().insertValidKey(assetTypeAsset, AssetTypeAsset.ColumnName.RefAssetType.toString(), assetTypeID);
    }
}
