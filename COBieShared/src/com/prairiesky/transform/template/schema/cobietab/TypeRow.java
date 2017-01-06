package com.prairiesky.transform.template.schema.cobietab;

import java.util.Calendar;

import org.nibs.cobie.tab.TypeType;

import com.prairiesky.lang.Property;
import com.prairiesky.transform.template.meta.ExcelReference;
import com.prairiesky.transform.template.meta.ExcelReference.ColumnAddress;
import com.prairiesky.transform.template.schema.SpreadsheetTemplateRow;

@ExcelReference(spreadsheetName="Type")
public class TypeRow extends SpreadsheetTemplateRow
{
	private final Property<String> name = new Property<>(String.class);
	private final Property<String> createdBy = new Property<>(String.class);
	private final Property<Calendar> createdOn = new Property<>(Calendar.class);
	private final Property<String> category = new Property<>(String.class);
	private final Property<String> description = new Property<>(String.class);
	private final Property<String> assetType = new Property<>(String.class);
	private final Property<String> manufacturer = new Property<>(String.class);
	private final Property<String> modelNumber = new Property<>(String.class);
	private final Property<String> warrantyGuarantorParts = new Property<>(
			String.class);
	private final Property<String> warrantyDurationParts = new Property<>(
			String.class);
	private final Property<String> warrantyGuarantorLabor = new Property<>(
			String.class);
	private final Property<String> warrantyDurationLabor = new Property<>(
			String.class);
	private final Property<String> warrantyDurationUnit = new Property<>(
			String.class);
	private final Property<String> extSystem = new Property<>(String.class);
	private final Property<String> extObject = new Property<>(String.class);
	private final Property<String> extIdentifier = new Property<>(String.class);
	private final Property<String> replacementCost = new Property<>(
			String.class);
	private final Property<String> expectedLife = new Property<>(String.class);
	private final Property<String> durationUnit = new Property<>(String.class);
	private final Property<String> warrantyDescription = new Property<>(
			String.class);
	private final Property<String> nominalLength = new Property<>(String.class);
	private final Property<String> nominalWidth = new Property<>(String.class);
	private final Property<String> nominalHeight = new Property<>(String.class);
	private final Property<String> modelReference = new Property<>(String.class);
	private final Property<String> shape = new Property<>(String.class);
	private final Property<String> size = new Property<>(String.class);
	private final Property<String> color = new Property<>(String.class);
	private final Property<String> finish = new Property<>(String.class);
	private final Property<String> grade = new Property<>(String.class);
	private final Property<String> material = new Property<>(String.class);
	private final Property<String> constituents = new Property<>(String.class);
	private final Property<String> features = new Property<>(String.class);
	private final Property<String> accessibilityPerformance = new Property<>(
			String.class);
	private final Property<String> codePerformance = new Property<>(
			String.class);
	private final Property<String> sustainabilityPerformance = new Property<>(
			String.class);

	@ExcelReference(columnAddress = ColumnAddress.A, columnName = "Name", isPrimaryKey = true)
	public final Property<String> Name()
	{
		return name;
	}

	@ExcelReference(columnAddress = ColumnAddress.B, columnName = "CreatedBy", isPrimaryKey = false)
	public final Property<String> CreatedBy()
	{
		return createdBy;
	}

	@ExcelReference(columnAddress = ColumnAddress.C, columnName = "CreatedOn", isPrimaryKey = false)
	public final Property<Calendar> CreatedOn()
	{
		return createdOn;
	}

	@ExcelReference(columnAddress = ColumnAddress.D, columnName = "Category", isPrimaryKey = false)
	public final Property<String> Category()
	{
		return category;
	}

	@ExcelReference(columnAddress = ColumnAddress.E, columnName = "Description", isPrimaryKey = false)
	public final Property<String> Description()
	{
		return description;
	}

	@ExcelReference(columnAddress = ColumnAddress.F, columnName = "AssetType", isPrimaryKey = false)
	public final Property<String> AssetType()
	{
		return assetType;
	}

	@ExcelReference(columnAddress = ColumnAddress.G, columnName = "Manufacturer", isPrimaryKey = false)
	public final Property<String> Manufacturer()
	{
		return manufacturer;
	}

	@ExcelReference(columnAddress = ColumnAddress.H, columnName = "ModelNumber", isPrimaryKey = false)
	public final Property<String> ModelNumber()
	{
		return modelNumber;
	}

	@ExcelReference(columnAddress = ColumnAddress.I, columnName = "WarrantyGuarantorParts", isPrimaryKey = false)
	public final Property<String> WarrantyGuarantorParts()
	{
		return warrantyGuarantorParts;
	}

	@ExcelReference(columnAddress = ColumnAddress.J, columnName = "WarrantyDurationParts", isPrimaryKey = false)
	public final Property<String> WarrantyDurationParts()
	{
		return warrantyDurationParts;
	}

	@ExcelReference(columnAddress = ColumnAddress.K, columnName = "WarrantyGuarantorLabor", isPrimaryKey = false)
	public final Property<String> WarrantyGuarantorLabor()
	{
		return warrantyGuarantorLabor;
	}

	@ExcelReference(columnAddress = ColumnAddress.L, columnName = "WarrantyDurationLabor", isPrimaryKey = false)
	public final Property<String> WarrantyDurationLabor()
	{
		return warrantyDurationLabor;
	}

	@ExcelReference(columnAddress = ColumnAddress.M, columnName = "WarrantyDurationUnit", isPrimaryKey = false)
	public final Property<String> WarrantyDurationUnit()
	{
		return warrantyDurationUnit;
	}

	@ExcelReference(columnAddress = ColumnAddress.N, columnName = "ExtSystem", isPrimaryKey = false)
	public final Property<String> ExtSystem()
	{
		return extSystem;
	}

	@ExcelReference(columnAddress = ColumnAddress.O, columnName = "ExtObject", isPrimaryKey = false)
	public final Property<String> ExtObject()
	{
		return extObject;
	}

	@ExcelReference(columnAddress = ColumnAddress.P, columnName = "ExtIdentifier", isPrimaryKey = false)
	public final Property<String> ExtIdentifier()
	{
		return extIdentifier;
	}

	@ExcelReference(columnAddress = ColumnAddress.Q, columnName = "ReplacementCost", isPrimaryKey = false)
	public final Property<String> ReplacementCost()
	{
		return replacementCost;
	}

	@ExcelReference(columnAddress = ColumnAddress.R, columnName = "ExpectedLife", isPrimaryKey = false)
	public final Property<String> ExpectedLife()
	{
		return expectedLife;
	}

	@ExcelReference(columnAddress = ColumnAddress.S, columnName = "DurationUnit", isPrimaryKey = false)
	public final Property<String> DurationUnit()
	{
		return durationUnit;
	}

	@ExcelReference(columnAddress = ColumnAddress.T, columnName = "WarrantyDescription", isPrimaryKey = false)
	public final Property<String> WarrantyDescription()
	{
		return warrantyDescription;
	}

	@ExcelReference(columnAddress = ColumnAddress.U, columnName = "NominalLength", isPrimaryKey = false)
	public final Property<String> NominalLength()
	{
		return nominalLength;
	}

	@ExcelReference(columnAddress = ColumnAddress.V, columnName = "NominalWidth", isPrimaryKey = false)
	public final Property<String> NominalWidth()
	{
		return nominalWidth;
	}

	@ExcelReference(columnAddress = ColumnAddress.W, columnName = "NominalHeight", isPrimaryKey = false)
	public final Property<String> NominalHeight()
	{
		return nominalHeight;
	}

	@ExcelReference(columnAddress = ColumnAddress.X, columnName = "ModelReference", isPrimaryKey = false)
	public final Property<String> ModelReference()
	{
		return modelReference;
	}

	@ExcelReference(columnAddress = ColumnAddress.Y, columnName = "Shape", isPrimaryKey = false)
	public final Property<String> Shape()
	{
		return shape;
	}

	@ExcelReference(columnAddress = ColumnAddress.Z, columnName = "Size", isPrimaryKey = false)
	public final Property<String> Size()
	{
		return size;
	}

	@ExcelReference(columnAddress = ColumnAddress.AA, columnName = "Color", isPrimaryKey = false)
	public final Property<String> Color()
	{
		return color;
	}

	@ExcelReference(columnAddress = ColumnAddress.AB, columnName = "Finish", isPrimaryKey = false)
	public final Property<String> Finish()
	{
		return finish;
	}

	@ExcelReference(columnAddress = ColumnAddress.AC, columnName = "Grade", isPrimaryKey = false)
	public final Property<String> Grade()
	{
		return grade;
	}

	@ExcelReference(columnAddress = ColumnAddress.AD, columnName = "Material", isPrimaryKey = false)
	public final Property<String> Material()
	{
		return material;
	}

	@ExcelReference(columnAddress = ColumnAddress.AE, columnName = "Constituents", isPrimaryKey = false)
	public final Property<String> Constituents()
	{
		return constituents;
	}

	@ExcelReference(columnAddress = ColumnAddress.AF, columnName = "Features", isPrimaryKey = false)
	public final Property<String> Features()
	{
		return features;
	}

	@ExcelReference(columnAddress = ColumnAddress.AG, columnName = "AccessibilityPerformance", isPrimaryKey = false)
	public final Property<String> AccessibilityPerformance()
	{
		return accessibilityPerformance;
	}

	@ExcelReference(columnAddress = ColumnAddress.AH, columnName = "CodePerformance", isPrimaryKey = false)
	public final Property<String> CodePerformance()
	{
		return codePerformance;
	}

	@ExcelReference(columnAddress = ColumnAddress.AI, columnName = "SustainabilityPerformance", isPrimaryKey = false)
	public final Property<String> SustainabilityPerformance()
	{
		return sustainabilityPerformance;
	}

	public void populateFromTypeRow(TypeType type)
	{
		Name().set(type.getName());
		CreatedBy().set(type.getCreatedBy());
		CreatedOn().set(type.getCreatedOn());
		Category().set(type.getCategory());
		Description().set(type.getDescription());
		AssetType().set(type.getAssetType());
		Manufacturer().set(type.getManufacturer());
		ModelNumber().set(type.getModelNumber());
		WarrantyGuarantorParts().set(type.getWarrantyGuarantorParts());
		WarrantyDurationParts().set(type.getWarrantyDurationParts());
		WarrantyGuarantorLabor().set(type.getWarrantyGuarantorLabor());
		WarrantyDurationLabor().set(type.getWarrantyDurationLabor());
		WarrantyDurationUnit().set(type.getWarrantyDurationUnit());
		ExtSystem().set(type.getExtSystem());
		ExtObject().set(type.getExtObject());
		ExtIdentifier().set(type.getExtIdentifier());
		ReplacementCost().set(type.getReplacementCost());
		ExpectedLife().set(type.getExpectedLife());
		DurationUnit().set(type.getDurationUnit());
		WarrantyDescription().set(type.getWarrantyDescription());
		NominalLength().set(type.getNominalLength());
		NominalWidth().set(type.getNominalWidth());
		NominalHeight().set(type.getNominalHeight());
		ModelReference().set(type.getModelReference());
		Shape().set(type.getShape());
		Size().set(type.getSize());
		Color().set(type.getColor());
		Finish().set(type.getFinish());
		Grade().set(type.getGrade());
		Material().set(type.getMaterial());
		Constituents().set(type.getConstituents());
		Features().set(type.getFeatures());
		AccessibilityPerformance().set(type.getAccessibilityPerformance());
		CodePerformance().set(type.getCodePerformance());
		SustainabilityPerformance().set(type.getSustainabilityPerformance());

	}
	
}
