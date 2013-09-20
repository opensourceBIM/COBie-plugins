package org.erdc.cobie.shared.targetunits;

import java.util.ArrayList;
import java.util.Collections;

import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;
import org.erdc.cobie.shared.deserializer.sheetxmldata.modelhandlers.IfcUnitHandler;

public abstract class IfcUnitSearch extends ArrayList<UnitTextMatcher>
{
    /**
     * 
     */
    private static final long serialVersionUID = 4496742373969133609L;
    private static final double MATCH_THRESHOLD = 0.10;
    private IfcUnit matchedUnit;
    private double matchDistance;
    protected String searchString;
    protected IfcUnitEnum unitType;
    protected UnitTextMatcher bestUnitTextMatcher;
    public UnitTextMatcher getBestUnitTextMatcher()
    {
        return bestUnitTextMatcher;
    }

    public IfcUnitSearch(String searchString, IfcUnitEnum unitType)
    {
        super();
        this.searchString = searchString;
        this.unitType = unitType;
        addSearchItems();
        calculateMatchedUnit();

    }

    protected abstract void addSearchItems();

    protected final void calculateMatchedUnit()
    {
        IfcUnit unit = null;
        if (size() > 0)
        {
            try
            {
                Collections.sort(this);
                bestUnitTextMatcher= get(0);
                unit = bestUnitTextMatcher.getTargetUnit();
                matchDistance = bestUnitTextMatcher.getMatchDistance();
                if (matchDistance <= MATCH_THRESHOLD)
                {
                    matchedUnit = unit;
                } else
                {
                    unit = IfcUnitHandler.getContextDependentUnitFromStringAndUnitType(getSearchString(), unitType);
                    bestUnitTextMatcher = null;
                }
            } catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
        matchedUnit = unit;
    }

    public final double getMatchDistance()
    {
        return matchDistance;
    }

    public final IfcUnit getMatchedUnit()
    {

        return matchedUnit;
    }

    public final String getSearchString()
    {
        return searchString;
    }

    public final void setSearchString(String searchString)
    {
        clear();
        this.searchString = searchString;
        addSearchItems();
        calculateMatchedUnit();
    }
}
