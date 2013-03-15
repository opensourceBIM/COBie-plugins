package org.erdc.cobie.shared.targetunits.time;

import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;
import org.erdc.cobie.shared.targetunits.IfcUnitSearch;

public class TimeUnitSearch extends IfcUnitSearch
{

    public TimeUnitSearch(String searchString)
    {
        super(searchString, IfcUnitEnum.TIMEUNIT);
    }

    @Override
    protected void addSearchItems()
    {
        add(new DaysTextMatcher(searchString));
        add(new HoursTextMatcher(searchString));
        add(new MinutesTextMatcher(searchString));
        add(new MonthsTextMatcher(searchString));
        add(new SecondsTextMatcher(searchString));
        add(new WeeksTextMatcher(searchString));
        add(new YearsTextMatcher(searchString));
    }

}
