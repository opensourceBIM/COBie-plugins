package org.erdc.cobie.sqlite.entities;

import org.erdc.cobie.sqlite.Column;
import org.erdc.cobie.sqlite.Columns;

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

	public Facility()
	{
		super();
		
		Columns columns = new Columns(			
			new Column<String>(ColumnName.FacilityCategory.toString(), null),
			new Column<String>(ColumnName.FacilityDescription.toString(), null),				
			new Column<String>(ColumnName.FacilityDefaultAreaUnit.toString(), null),
			new Column<String>(ColumnName.FacilityDefaultCurrencyUnit.toString(), null),
			new Column<String>(ColumnName.FacilityDefaultLinearUnit.toString(), null),
			new Column<String>(ColumnName.FacilityDefaultMeasurementStandard.toString(), null),
			new Column<String>(ColumnName.FacilityDefaultVolumeUnit.toString(), null),
			new Column<String>(ColumnName.FacilityDeliverablePhaseName.toString(), null),
			new Column<String>(ColumnName.FacilityName.toString(), CRUDEntity.STRING_NOT_NULL));
		
		addColumns(columns);
	}

	@Override
	public String getName()
	{
		return (String)getColumn(ColumnName.FacilityName.toString()).getValue();
	}
	
	@Override
	public String getTableName()
	{
		return "Facility";
	}
}
