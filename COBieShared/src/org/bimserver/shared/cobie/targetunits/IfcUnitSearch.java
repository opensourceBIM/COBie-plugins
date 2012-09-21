package org.bimserver.shared.cobie.targetunits;

import java.util.ArrayList;
import java.util.Collections;

import org.bimserver.cobie.utils.deserializer.modelhandlers.IfcUnitHandler;
import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;

public abstract class IfcUnitSearch 
		extends ArrayList<UnitTextMatcher>
{
	private static final double MATCH_THRESHOLD = 0.10;
	private IfcUnit matchedUnit;
	private double matchDistance;
	protected String searchString;
	protected IfcUnitEnum unitType;
	public final String  getSearchString()
	{
		return searchString;
	}
	
	protected abstract void addSearchItems();


	public final void  setSearchString(String searchString)
	{
		clear();
		this.searchString = searchString;
		addSearchItems();
		calculateMatchedUnit();
	}


	public IfcUnitSearch(String searchString,IfcUnitEnum unitType)
	{
		super();
		this.searchString = searchString;
		this.unitType = unitType;
		addSearchItems();
		calculateMatchedUnit();
		
	}

	
	
	public final  double getMatchDistance()
	{
		return matchDistance;
	}

	public final IfcUnit getMatchedUnit()
	{

		return matchedUnit;
	}

	protected final void calculateMatchedUnit()
	{
		IfcUnit unit = null;
		if(size()>0)
		{
			try
			{
				Collections.sort(this);
				unit = get(0).getTargetUnit();
				matchDistance = get(0).getMatchDistance();
				if(matchDistance<=MATCH_THRESHOLD)
				{
					this.matchedUnit = unit;
				}
				else
				{
					unit = IfcUnitHandler.getContextDependentUnitFromStringAndUnitType(getSearchString(),unitType);
				}
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		this.matchedUnit = unit;
	}
}
