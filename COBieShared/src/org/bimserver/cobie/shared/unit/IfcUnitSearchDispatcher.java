package org.bimserver.cobie.shared.unit;

import org.bimserver.cobie.shared.unit.area.AreaUnitSearch;
import org.bimserver.cobie.shared.unit.length.LengthUnitSearch;
import org.bimserver.cobie.shared.unit.time.TimeUnitSearch;
import org.bimserver.cobie.shared.unit.volume.VolumeUnitSearch;
import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;

public class IfcUnitSearchDispatcher
{
    private IfcUnitSearch unitSearch;

    public IfcUnitSearchDispatcher(IfcUnitEnum unitType, String searchString)
    {
        setUnitSearch(null);
        switch (unitType)
        {
            case ABSORBEDDOSEUNIT:
                break;
            case AMOUNTOFSUBSTANCEUNIT:
                break;
            case AREAUNIT:
                setUnitSearch(new AreaUnitSearch(searchString));
                break;
            case DOSEEQUIVALENTUNIT:
                break;
            case ELECTRICCAPACITANCEUNIT:
                break;
            case ELECTRICCHARGEUNIT:
                break;
            case ELECTRICCONDUCTANCEUNIT:
                break;
            case ELECTRICCURRENTUNIT:
                break;
            case ELECTRICRESISTANCEUNIT:
                break;
            case ELECTRICVOLTAGEUNIT:
                break;
            case ENERGYUNIT:
                break;
            case FORCEUNIT:
                break;
            case FREQUENCYUNIT:
                break;
            case ILLUMINANCEUNIT:
                break;
            case INDUCTANCEUNIT:
                break;
            case LENGTHUNIT:
                setUnitSearch(new LengthUnitSearch(searchString));
                break;
            case LUMINOUSFLUXUNIT:
                break;
            case LUMINOUSINTENSITYUNIT:
                break;
            case MAGNETICFLUXDENSITYUNIT:
                break;
            case MAGNETICFLUXUNIT:
                break;
            case MASSUNIT:
                break;
            case NULL:
                break;
            case PLANEANGLEUNIT:
                break;
            case POWERUNIT:
                break;
            case PRESSUREUNIT:
                break;
            case RADIOACTIVITYUNIT:
                break;
            case SOLIDANGLEUNIT:
                break;
            case THERMODYNAMICTEMPERATUREUNIT:
                break;
            case TIMEUNIT:
                setUnitSearch(new TimeUnitSearch(searchString));
                break;
            case USERDEFINED:
                break;
            case VOLUMEUNIT:
                setUnitSearch(new VolumeUnitSearch(searchString));
                break;

        }
    }

    public final IfcUnit getMatchedUnit()
    {
        return unitSearch.getMatchedUnit();
    }

    public IfcUnitSearch getUnitSearch()
    {
        return unitSearch;
    }

    private void setUnitSearch(IfcUnitSearch unitSearch)
    {
        this.unitSearch = unitSearch;
    }
}
