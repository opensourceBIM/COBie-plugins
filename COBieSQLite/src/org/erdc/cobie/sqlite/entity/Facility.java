package org.erdc.cobie.sqlite.entity;

import org.erdc.cobie.sqlite.CobieSQLiteException;
import org.erdc.cobie.sqlite.Column;
import org.erdc.cobie.sqlite.Row;

public final class Facility extends CobieAttributesEntity
{
	public enum ColumnName
	{
		FacilityCategory("FacilityCategory"), 
		FacilityDescription("FacilityDescription"), 
		FacilityDefaultAreaUnit("FacilityDefaultAreaUnit"), 
		FacilityDefaultCurrencyUnit("FacilityDefaultCurrencyUnit"), 
		FacilityDefaultLinearUnit("FacilityDefaultLinearUnit"), 
		FacilityDefaultMeasurementStandard("FacilityDefaultMeasurementStandard"), 
		FacilityDefaultVolumeUnit("FacilityDefaultVolumeUnit"), 
		FacilityDeliverablePhaseName("FacilityDeliverablePhaseName"), 
		FacilityName("FacilityName");

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

	public Facility() throws CobieSQLiteException
	{
		super();
	}
	
	public Facility(Row row) throws CobieSQLiteException
	{
		super(row);
	}
	
	public final String getFacilityCategory() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.FacilityCategory.toString()).getValue();
	}

	public final String getFacilityDefaultAreaUnit() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.FacilityDefaultAreaUnit.toString()).getValue();
	}

	public final String getFacilityDefaultCurrencyUnit() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.FacilityDefaultCurrencyUnit.toString()).getValue();
	}

	public final String getFacilityDefaultLinearUnit() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.FacilityDefaultLinearUnit.toString()).getValue();
	}

	public final String getFacilityDefaultMeasurementStandard() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.FacilityDefaultMeasurementStandard.toString()).getValue();
	}

	public final String getFacilityDefaultVolumeUnit() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.FacilityDefaultVolumeUnit.toString()).getValue();
	}

	public final String getFacilityDeliverablePhaseName() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.FacilityDeliverablePhaseName.toString()).getValue();
	}

	public final String getFacilityDescription() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.FacilityDescription.toString()).getValue();
	}

	public final String getFacilityName() throws CobieSQLiteException
	{
		return (String)getColumn(ColumnName.FacilityName.toString()).getValue();
	}

	@Override
	public String getTableName()
	{
		return "Facility";
	}

	@Override
	protected Row makeRow() throws CobieSQLiteException
	{
    	Row row = new Row(
					new Column<>(String.class, ColumnName.FacilityCategory.toString(), null), 
					new Column<>(String.class, ColumnName.FacilityDescription.toString(), null), 
					new Column<>(String.class, ColumnName.FacilityDefaultAreaUnit.toString(), null), 
					new Column<>(String.class, ColumnName.FacilityDefaultCurrencyUnit.toString(), null), 
					new Column<>(String.class, ColumnName.FacilityDefaultLinearUnit.toString(), null), 
					new Column<>(String.class, ColumnName.FacilityDefaultMeasurementStandard.toString(), null), 
					new Column<>(String.class, ColumnName.FacilityDefaultVolumeUnit.toString(), null), 
					new Column<>(String.class, ColumnName.FacilityDeliverablePhaseName.toString(), null), 
					new Column<>(String.class, ColumnName.FacilityName.toString(), Entity.STRING_NOT_NULL));
    	
    	row.add(super.makeRow().getColumns());
    	
    	return row;
	}
	
	public final void setFacilityCategory(String facilityCategory) throws CobieSQLiteException
	{
		getColumn(ColumnName.FacilityCategory.toString()).update(facilityCategory);
	}

	public final void setFacilityDefaultAreaUnit(String facilityDefaultAreaUnit) throws CobieSQLiteException
	{
		getColumn(ColumnName.FacilityDefaultAreaUnit.toString()).update(facilityDefaultAreaUnit);
	}

	public final void setFacilityDefaultCurrencyUnit(String facilityDefaultCurrencyUnit) throws CobieSQLiteException
	{
		getColumn(ColumnName.FacilityDefaultCurrencyUnit.toString()).update(facilityDefaultCurrencyUnit);
	}

	public final void setFacilityDefaultLinearUnit(String facilityDefaultLinearUnit) throws CobieSQLiteException
	{
		getColumn(ColumnName.FacilityDefaultLinearUnit.toString()).update(facilityDefaultLinearUnit);
	}

	public final void setFacilityDefaultMeasurementStandard(String facilityDefaultMeasurementStandard) throws CobieSQLiteException
	{
		getColumn(ColumnName.FacilityDefaultMeasurementStandard.toString()).update(facilityDefaultMeasurementStandard);
	}

	public final void setFacilityDefaultVolumeUnit(String facilityDefaultVolumeUnit) throws CobieSQLiteException
	{
		getColumn(ColumnName.FacilityDefaultVolumeUnit.toString()).update(facilityDefaultVolumeUnit);
	}

	public final void setFacilityDeliverablePhaseName(String facilityDeliverablePhaseName) throws CobieSQLiteException
	{
		getColumn(ColumnName.FacilityDeliverablePhaseName.toString()).update(facilityDeliverablePhaseName);
	}

	public final void setFacilityDescription(String facilityDescription) throws CobieSQLiteException
	{
		getColumn(ColumnName.FacilityDescription.toString()).update(facilityDescription);
	}

	public final void setFacilityName(String facilityName) throws CobieSQLiteException
	{
		getColumn(ColumnName.FacilityName.toString()).update(facilityName);
	}
}
