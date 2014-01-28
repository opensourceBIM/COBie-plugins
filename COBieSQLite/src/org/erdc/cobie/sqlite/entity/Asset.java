package org.erdc.cobie.sqlite.entity;

import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.Column;
import org.erdc.cobie.sqlite.Row;

public final class Asset extends CobieAttributesEntity
{
	public enum ColumnName
	{
		AssetBarCode("AssetBarCode"), 
		AssetDescription("AssetDescription"), 
		AssetIdentifier("AssetIdentifier"), 
		AssetInstallationDate("AssetInstallationDate"), 
		AssetInstalledModelNumber("AssetInstalledModelNumber"), 
		AssetLocationDescription("AssetLocationDescription"), 
		AssetName("AssetName"), 
		AssetSerialNumber("AssetSerialNumber"), 
		AssetStartDate("AssetStartDate"), 
		AssetTagNumber("AssetTagNumber"), 
		AssetWarrantyStartDate("AssetWarrantyStartDate");

		private String columName;

		private ColumnName(final String columnName)
		{
			columName = columnName;
		}

		@Override
		public final String toString()
		{
			return columName;
		}
	}

	public Asset() throws CobieSQLiteException
	{
		super();
	}
	
	public Asset(Row row) throws CobieSQLiteException
	{
		super(row);
	}
	
	public final String getAssetBarCode() throws CobieSQLiteException
	{
		return (String)getColumn(Asset.ColumnName.AssetBarCode.toString()).getValue();
	}

	public final String getAssetDescription() throws CobieSQLiteException
	{
		return (String)getColumn(Asset.ColumnName.AssetDescription.toString()).getValue();
	}

	public final String getAssetIdentifier() throws CobieSQLiteException
	{
		return (String)getColumn(Asset.ColumnName.AssetIdentifier.toString()).getValue();
	}

	public final String getAssetInstallationDate() throws CobieSQLiteException
	{
		return (String)getColumn(Asset.ColumnName.AssetInstallationDate.toString()).getValue();
	}

	public final String getAssetInstalledModelNumber() throws CobieSQLiteException
	{
		return (String)getColumn(Asset.ColumnName.AssetInstalledModelNumber.toString()).getValue();
	}

	public final String getAssetLocationDescription() throws CobieSQLiteException
	{
		return (String)getColumn(Asset.ColumnName.AssetLocationDescription.toString()).getValue();
	}

	public final String getAssetName() throws CobieSQLiteException
	{
		return (String)getColumn(Asset.ColumnName.AssetName.toString()).getValue();
	}

	public final String getAssetSerialNumber() throws CobieSQLiteException
	{
		return (String)getColumn(Asset.ColumnName.AssetSerialNumber.toString()).getValue();
	}

	public final String getAssetStartDate() throws CobieSQLiteException
	{
		return (String)getColumn(Asset.ColumnName.AssetStartDate.toString()).getValue();
	}

	public final String getAssetTagNumber() throws CobieSQLiteException
	{
		return (String)getColumn(Asset.ColumnName.AssetTagNumber.toString()).getValue();
	}

	public final String getAssetWarrantyStartDate() throws CobieSQLiteException
	{
		return (String)getColumn(Asset.ColumnName.AssetWarrantyStartDate.toString()).getValue();
	}
	
	@Override
	public String getTableName()
	{
		return "Asset";
	}

	@Override
	protected Row makeRow() throws CobieSQLiteException
	{
    	Row row = new Row(
					new Column<>(String.class, Asset.ColumnName.AssetBarCode.toString(), null), 
					new Column<>(String.class, Asset.ColumnName.AssetDescription.toString(), null), 
					new Column<>(String.class, Asset.ColumnName.AssetIdentifier.toString(), null), 
					new Column<>(String.class, Asset.ColumnName.AssetInstallationDate.toString(), null), 
					new Column<>(String.class, Asset.ColumnName.AssetInstalledModelNumber.toString(), null), 
					new Column<>(String.class, Asset.ColumnName.AssetLocationDescription.toString(), null), 
					new Column<>(String.class, Asset.ColumnName.AssetName.toString(), Entity.STRING_NOT_NULL), 
					new Column<>(String.class, Asset.ColumnName.AssetSerialNumber.toString(), null), 
					new Column<>(String.class, Asset.ColumnName.AssetStartDate.toString(), null), 
					new Column<>(String.class, Asset.ColumnName.AssetTagNumber.toString(), null), 
					new Column<>(String.class, Asset.ColumnName.AssetWarrantyStartDate.toString(), null));
    	
    	row.add(super.makeRow().getColumns());
    	
    	return row;
	}
	
	public final void setAssetBarCode(String assetBarCode) throws CobieSQLiteException
	{
		getColumn(Asset.ColumnName.AssetBarCode.toString()).update(assetBarCode);
	}

	public final void setAssetDescription(String assetDescription) throws CobieSQLiteException
	{
		getColumn(Asset.ColumnName.AssetDescription.toString()).update(assetDescription);
	}

	public final void setAssetIdentifier(String assetIdentifier) throws CobieSQLiteException
	{
		getColumn(Asset.ColumnName.AssetIdentifier.toString()).update(assetIdentifier);
	}

	public final void setAssetInstallationDate(String assetInstallationDate) throws CobieSQLiteException
	{
		getColumn(Asset.ColumnName.AssetInstallationDate.toString()).update(assetInstallationDate);
	}

	public final void setAssetInstalledModelNumber(String assetInstalledModelNumber) throws CobieSQLiteException
	{
		getColumn(Asset.ColumnName.AssetInstalledModelNumber.toString()).update(assetInstalledModelNumber);
	}

	public final void setAssetLocationDescription(String assetLocationDescription) throws CobieSQLiteException
	{
		getColumn(Asset.ColumnName.AssetLocationDescription.toString()).update(assetLocationDescription);
	}

	public final void setAssetName(String AssetName) throws CobieSQLiteException
	{
		getColumn(Asset.ColumnName.AssetName.toString()).update(AssetName);
	}

	public final void setAssetSerialNumber(String AssetSerialNumber) throws CobieSQLiteException
	{
		getColumn(Asset.ColumnName.AssetSerialNumber.toString()).update(AssetSerialNumber);
	}

	public final void setAssetStartDate(String assetStartDate) throws CobieSQLiteException
	{
		getColumn(Asset.ColumnName.AssetStartDate.toString()).update(assetStartDate);
	}

	public final void setAssetTagNumber(String assetTagNumber) throws CobieSQLiteException
	{
		getColumn(Asset.ColumnName.AssetTagNumber.toString()).update(assetTagNumber);
	}

	public final void setAssetWarrantyStartDate(String assetWarrantyStartDate) throws CobieSQLiteException
	{
		getColumn(Asset.ColumnName.AssetWarrantyStartDate.toString()).update(assetWarrantyStartDate);
	}
}
