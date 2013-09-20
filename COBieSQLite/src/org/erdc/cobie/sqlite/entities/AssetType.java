package org.erdc.cobie.sqlite.entities;

import org.erdc.cobie.sqlite.Column;
import org.erdc.cobie.sqlite.Columns;

public class AssetType extends CobieAttributesEntity 
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
	
	public AssetType()
	{
		super();
		
		Columns columns = new Columns(
				new Column<String>(AssetType.ColumnName.AssetTypeAccessibilityText.toString(), null),
				new Column<String>(AssetType.ColumnName.AssetTypeAccountingCategory.toString(), null),
				new Column<String>(AssetType.ColumnName.AssetTypeCategory.toString(), null),
				new Column<String>(AssetType.ColumnName.AssetTypeCodePerformance.toString(), null),
				new Column<String>(AssetType.ColumnName.AssetTypeColorCode.toString(), null),
				new Column<String>(AssetType.ColumnName.AssetTypeConstituentsDescription.toString(), null),
				new Column<String>(AssetType.ColumnName.AssetTypeDescription.toString(), null),
				new Column<String>(AssetType.ColumnName.AssetTypeFeaturesDescription.toString(), null),
				new Column<String>(AssetType.ColumnName.AssetTypeFinishDescription.toString(), null),
				new Column<String>(AssetType.ColumnName.AssetTypeGradeDescription.toString(), null),
				new Column<String>(AssetType.ColumnName.AssetTypeMaterialDescription.toString(), null),
				new Column<String>(AssetType.ColumnName.AssetTypeModelNumber.toString(), null),
				new Column<String>(AssetType.ColumnName.AssetTypeName.toString(), null),
				new Column<String>(AssetType.ColumnName.AssetTypeShapeDescription.toString(), null),
				new Column<String>(AssetType.ColumnName.AssetTypeSizeDescription.toString(), null),
				new Column<String>(AssetType.ColumnName.AssetTypeSustainabilityPerformanceDescription.toString(), null),
				new Column<Integer>(AssetType.ColumnName.RefExpectedLifeValue.toString(), null),
				new Column<Integer>(AssetType.ColumnName.RefNominalHeightValue.toString(), null),
				new Column<Integer>(AssetType.ColumnName.RefNominalLengthValue.toString(), null),
				new Column<Integer>(AssetType.ColumnName.RefNominalWidthValue.toString(), null),
				new Column<Integer>(AssetType.ColumnName.RefReplacementCostValue.toString(), null),
				new Column<Integer>(AssetType.ColumnName.RefWarrantyDurationLaborValue.toString(), null),
				new Column<Integer>(AssetType.ColumnName.RefWarrantyDurationPartsValue.toString(), null));
		
		addColumns(columns);
	}
	
	@Override
	public String getName()
	{
		return (String)getColumn(ColumnName.AssetTypeName.toString()).getValue();
	}
	
	@Override
	public String getTableName()
	{
		return "AssetType";
	}
}
