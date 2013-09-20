package org.erdc.cobie.sqlite.entities;

import org.erdc.cobie.sqlite.Column;
import org.erdc.cobie.sqlite.Columns;

public class Asset extends CobieAttributesEntity 
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
	
	public Asset()
	{
		super();
		
		Columns columns = new Columns(
				new Column<String>(Asset.ColumnName.AssetBarCode.toString(), null),
				new Column<String>(Asset.ColumnName.AssetDescription.toString(), null),
				new Column<String>(Asset.ColumnName.AssetIdentifier.toString(), null),
				new Column<String>(Asset.ColumnName.AssetInstallationDate.toString(), null),
				new Column<String>(Asset.ColumnName.AssetInstalledModelNumber.toString(), null),
				new Column<String>(Asset.ColumnName.AssetLocationDescription.toString(), null),
				new Column<String>(Asset.ColumnName.AssetName.toString(), CobieEntity.STRING_NOT_NULL),
				new Column<String>(Asset.ColumnName.AssetSerialNumber.toString(), null),
				new Column<String>(Asset.ColumnName.AssetStartDate.toString(), null),
				new Column<String>(Asset.ColumnName.AssetTagNumber.toString(), null),
				new Column<String>(Asset.ColumnName.AssetWarrantyStartDate.toString(), null));
		
		addColumns(columns);
	}
	
	@Override
	public String getName()
	{
		return (String)getColumn(ColumnName.AssetName.toString()).getValue();
	}
	
	@Override
	public String getTableName() 
	{
		return "Asset";
	}
}
