package org.erdc.cobie.sqlite.entity;

import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.Column;
import org.erdc.cobie.sqlite.Row;

public final class AssetType extends CobieAttributesEntity
{
	public enum ColumnName
	{
		AssetTypeAccessibilityText("AssetTypeAccessibilityText"), 
		AssetTypeAccountingCategory("AssetTypeAccountingCategory"), 
		AssetTypeCategory("AssetTypeCategory"), 
		AssetTypeCodePerformance("AssetTypeCodePerformance"), 
		AssetTypeColorCode("AssetTypeColorCode"), 
		AssetTypeConstituentsDescription("AssetTypeConstituentsDescription"), 
		AssetTypeDescription("AssetTypeDescription"), 
		AssetTypeFeaturesDescription("AssetTypeFeaturesDescription"), 
		AssetTypeFinishDescription("AssetTypeFinishDescription"), 
		AssetTypeGradeDescription("AssetTypeGradeDescription"), 
		AssetTypeMaterialDescription("AssetTypeMaterialDescription"), 
		AssetTypeModelNumber("AssetTypeModelNumber"), 
		AssetTypeName("AssetTypeName"), 
		AssetTypeShapeDescription("AssetTypeShapeDescription"), 
		AssetTypeSizeDescription("AssetTypeSizeDescription"), 
		AssetTypeSustainabilityPerformanceDescription("AssetTypeSustainabilityPerformanceDescription"), 
		RefExpectedLifeValue("RefExpectedLifeValue"), 
		RefNominalHeightValue("RefNominalHeightValue"), 
		RefNominalLengthValue("RefNominalLengthValue"), 
		RefNominalWidthValue("RefNominalWidthValue"), 
		RefReplacementCostValue("RefReplacementCostValue"), 
		RefWarrantyDurationLaborValue("RefWarrantyDurationLaborValue"), 
		RefWarrantyDurationPartsValue("RefWarrantyDurationPartsValue");

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

	public AssetType() throws CobieSQLiteException
	{
		super();
	}
	
	public AssetType(Row row) throws CobieSQLiteException
	{
		super(row);
	}
	
	public final String getAssetTypeAccessibilityText() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.AssetTypeAccessibilityText.toString()).getValue();
	}

	public final String getAssetTypeAccountingCategory() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.AssetTypeAccountingCategory.toString()).getValue();
	}

	public final String getAssetTypeCategory() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.AssetTypeCategory.toString()).getValue();
	}

	public final String getAssetTypeCodePerformance() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.AssetTypeCodePerformance.toString()).getValue();
	}

	public final String getAssetTypeColorCode() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.AssetTypeColorCode.toString()).getValue();
	}

	public final String getAssetTypeConstituentsDescription() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.AssetTypeConstituentsDescription.toString()).getValue();
	}

	public final String getAssetTypeDescription() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.AssetTypeDescription.toString()).getValue();
	}

	public final String getAssetTypeFeaturesDescription() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.AssetTypeFeaturesDescription.toString()).getValue();
	}

	public final String getAssetTypeFinishDescription() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.AssetTypeFinishDescription.toString()).getValue();
	}

	public final String getAssetTypeGradeDescription() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.AssetTypeGradeDescription.toString()).getValue();
	}

	public final String getAssetTypeMaterialDescription() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.AssetTypeMaterialDescription.toString()).getValue();
	}

	public final String getAssetTypeModelNumber() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.AssetTypeModelNumber.toString()).getValue();
	}

	public final String getAssetTypeName() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.AssetTypeName.toString()).getValue();
	}

	public final String getAssetTypeShapeDescription() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.AssetTypeShapeDescription.toString()).getValue();
	}

	public final String getAssetTypeSizeDescription() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.AssetTypeSizeDescription.toString()).getValue();
	}

	public final String getAssetTypeSustainabilityPerformanceDescription() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.AssetTypeSustainabilityPerformanceDescription.toString()).getValue();
	}

	@SuppressWarnings("boxing")
	public final int getRefExpectedLifeValue() throws CobieSQLiteException
	{
		return (Integer)getColumn(ColumnName.RefExpectedLifeValue.toString()).getValue();
	}

	@SuppressWarnings("boxing")
	public final int getRefNominalHeightValue() throws CobieSQLiteException
	{
		return (Integer)getColumn(ColumnName.RefNominalHeightValue.toString()).getValue();
	}

	@SuppressWarnings("boxing")
	public final int getRefNominalLengthValue() throws CobieSQLiteException
	{
		return (Integer)getColumn(ColumnName.RefNominalLengthValue.toString()).getValue();
	}

	@SuppressWarnings("boxing")
	public final int getRefNominalWidthValue() throws CobieSQLiteException
	{
		return (Integer)getColumn(ColumnName.RefNominalWidthValue.toString()).getValue();
	}

	@SuppressWarnings("boxing")
	public final int getRefReplacementCostValue() throws CobieSQLiteException
	{
		return (Integer)getColumn(ColumnName.RefReplacementCostValue.toString()).getValue();
	}

	@SuppressWarnings("boxing")
	public final int getRefWarrantyDurationLaborValue() throws CobieSQLiteException
	{
		return (Integer)getColumn(ColumnName.RefWarrantyDurationLaborValue.toString()).getValue();
	}

	@SuppressWarnings("boxing")
	public final int getRefWarrantyDurationPartsValue() throws CobieSQLiteException
	{
		return (Integer)getColumn(ColumnName.RefWarrantyDurationPartsValue.toString()).getValue();
	}

	@Override
	public String getTableName()
	{
		return "AssetType";
	}

	@Override
	protected Row makeRow() throws CobieSQLiteException
	{
    	Row row = new Row(
					new Column<>(String.class, AssetType.ColumnName.AssetTypeAccessibilityText.toString(), null), 
					new Column<>(String.class, AssetType.ColumnName.AssetTypeAccountingCategory.toString(), null), 
					new Column<>(String.class, AssetType.ColumnName.AssetTypeCategory.toString(), null), 
					new Column<>(String.class, AssetType.ColumnName.AssetTypeCodePerformance.toString(), null), 
					new Column<>(String.class, AssetType.ColumnName.AssetTypeColorCode.toString(), null), 
					new Column<>(String.class, AssetType.ColumnName.AssetTypeConstituentsDescription.toString(), null), 
					new Column<>(String.class, AssetType.ColumnName.AssetTypeDescription.toString(), null), 
					new Column<>(String.class, AssetType.ColumnName.AssetTypeFeaturesDescription.toString(), null), 
					new Column<>(String.class, AssetType.ColumnName.AssetTypeFinishDescription.toString(), null), 
					new Column<>(String.class, AssetType.ColumnName.AssetTypeGradeDescription.toString(), null), 
					new Column<>(String.class, AssetType.ColumnName.AssetTypeMaterialDescription.toString(), null), 
					new Column<>(String.class, AssetType.ColumnName.AssetTypeModelNumber.toString(), null), 
					new Column<>(String.class, AssetType.ColumnName.AssetTypeName.toString(), null), 
					new Column<>(String.class, AssetType.ColumnName.AssetTypeShapeDescription.toString(), null), 
					new Column<>(String.class, AssetType.ColumnName.AssetTypeSizeDescription.toString(), null), 
					new Column<>(String.class, AssetType.ColumnName.AssetTypeSustainabilityPerformanceDescription.toString(), null), 
					new Column<>(Integer.class, AssetType.ColumnName.RefExpectedLifeValue.toString(), null), 
					new Column<>(Integer.class, AssetType.ColumnName.RefNominalHeightValue.toString(), null), 
					new Column<>(Integer.class, AssetType.ColumnName.RefNominalLengthValue.toString(), null), 
					new Column<>(Integer.class, AssetType.ColumnName.RefNominalWidthValue.toString(), null), 
					new Column<>(Integer.class, AssetType.ColumnName.RefReplacementCostValue.toString(), null), 
					new Column<>(Integer.class, AssetType.ColumnName.RefWarrantyDurationLaborValue.toString(), null), 
					new Column<>(Integer.class, AssetType.ColumnName.RefWarrantyDurationPartsValue.toString(), null));
    	
    	row.add(super.makeRow().getColumns());
    	
    	return row;
	}
	
	public final void setAssetTypeAccessibilityText(String assetTypeAccessibilityText) throws CobieSQLiteException
	{
		getColumn(ColumnName.AssetTypeAccessibilityText.toString()).update(assetTypeAccessibilityText);
	}

	public final void setAssetTypeAccountingCategory(String assetTypeAccountingCategory) throws CobieSQLiteException
	{
		getColumn(ColumnName.AssetTypeAccountingCategory.toString()).update(assetTypeAccountingCategory);
	}

	public final void setAssetTypeCategory(String assetTypeCategory) throws CobieSQLiteException
	{
		getColumn(ColumnName.AssetTypeCategory.toString()).update(assetTypeCategory);
	}

	public final void setAssetTypeCodePerformance(String assetTypeCodePerformance) throws CobieSQLiteException
	{
		getColumn(ColumnName.AssetTypeCodePerformance.toString()).update(assetTypeCodePerformance);
	}

	public final void setAssetTypeColorCode(String assetTypeColorCode) throws CobieSQLiteException
	{
		getColumn(ColumnName.AssetTypeColorCode.toString()).update(assetTypeColorCode);
	}

	public final void setAssetTypeConstituentsDescription(String assetTypeConstituentsDescription) throws CobieSQLiteException
	{
		getColumn(ColumnName.AssetTypeConstituentsDescription.toString()).update(assetTypeConstituentsDescription);
	}

	public final void setAssetTypeDescription(String assetTypeDescription) throws CobieSQLiteException
	{
		getColumn(ColumnName.AssetTypeDescription.toString()).update(assetTypeDescription);
	}

	public final void setAssetTypeFeaturesDescription(String assetTypeFeaturesDescription) throws CobieSQLiteException
	{
		getColumn(ColumnName.AssetTypeFeaturesDescription.toString()).update(assetTypeFeaturesDescription);
	}

	public final void setAssetTypeFinishDescription(String assetTypeFinishDescription) throws CobieSQLiteException
	{
		getColumn(ColumnName.AssetTypeFinishDescription.toString()).update(assetTypeFinishDescription);
	}

	public final void setAssetTypeGradeDescription(String assetTypeGradeDescription) throws CobieSQLiteException
	{
		getColumn(ColumnName.AssetTypeGradeDescription.toString()).update(assetTypeGradeDescription);
	}

	public final void setAssetTypeMaterialDescription(String assetTypeMaterialDescription) throws CobieSQLiteException
	{
		getColumn(ColumnName.AssetTypeMaterialDescription.toString()).update(assetTypeMaterialDescription);
	}

	public final void setAssetTypeModelNumber(String assetTypeModelNumber) throws CobieSQLiteException
	{
		getColumn(ColumnName.AssetTypeModelNumber.toString()).update(assetTypeModelNumber);
	}

	public final void setAssetTypeName(String assetTypeName) throws CobieSQLiteException
	{
		getColumn(ColumnName.AssetTypeName.toString()).update(assetTypeName);
	}

	public final void setAssetTypeShapeDescription(String assetTypeShapeDescription) throws CobieSQLiteException
	{
		getColumn(ColumnName.AssetTypeShapeDescription.toString()).update(assetTypeShapeDescription);
	}

	public final void setAssetTypeSizeDescription(String assetTypeSizeDescription) throws CobieSQLiteException
	{
		getColumn(ColumnName.AssetTypeSizeDescription.toString()).update(assetTypeSizeDescription);
	}

	public final void setAssetTypeSustainabilityPerformanceDescription(String assetTypeSustainabilityPerformanceDescription) throws CobieSQLiteException
	{
		getColumn(ColumnName.AssetTypeSustainabilityPerformanceDescription.toString()).update(assetTypeSustainabilityPerformanceDescription);
	}

	@SuppressWarnings("boxing")
	public final void setRefExpectedLifeValue(int refExpectedLifeValue) throws CobieSQLiteException
	{
		getColumn(ColumnName.RefExpectedLifeValue.toString()).update(refExpectedLifeValue);
	}

	@SuppressWarnings("boxing")
	public final void setRefNominalHeightValue(int refNominalHeightValue) throws CobieSQLiteException
	{
		getColumn(ColumnName.RefNominalHeightValue.toString()).update(refNominalHeightValue);
	}

	@SuppressWarnings("boxing")
	public final void setRefNominalLengthValue(int refNominalLengthValue) throws CobieSQLiteException
	{
		getColumn(ColumnName.RefNominalLengthValue.toString()).update(refNominalLengthValue);
	}

	@SuppressWarnings("boxing")
	public final void setRefNominalWidthValue(int refNominalWidthValue) throws CobieSQLiteException
	{
		getColumn(ColumnName.RefNominalWidthValue.toString()).update(refNominalWidthValue);
	}

	@SuppressWarnings("boxing")
	public final void setRefReplacementCostValue(int refReplacementCostValue) throws CobieSQLiteException
	{
		getColumn(ColumnName.RefReplacementCostValue.toString()).update(refReplacementCostValue);
	}

	@SuppressWarnings("boxing")
	public final void setRefWarrantyDurationLaborValue(int refWarrantyDurationLaborValue) throws CobieSQLiteException
	{
		getColumn(ColumnName.RefWarrantyDurationLaborValue.toString()).update(refWarrantyDurationLaborValue);
	}

	@SuppressWarnings("boxing")
	public final void setRefWarrantyDurationPartsValue(int RefWarrantyDurationPartsValue) throws CobieSQLiteException
	{
		getColumn(ColumnName.RefWarrantyDurationPartsValue.toString()).update(RefWarrantyDurationPartsValue);
	}
}
