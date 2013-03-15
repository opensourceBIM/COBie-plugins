package org.erdc.cobie.shared.targetunits;
import org.erdc.cobie.cobielite.AreaUnitSimpleType;
import org.erdc.cobie.cobielite.CurrencyUnitSimpleType;
import org.erdc.cobie.cobielite.LinearUnitSimpleType;
import org.erdc.cobie.cobielite.VolumeUnitSimpleType;
import org.erdc.cobie.shared.targetunits.area.*;
import org.bimserver.models.ifc2x3tc1.IfcCurrencyEnum;
import org.bimserver.models.ifc2x3tc1.IfcMonetaryUnit;
import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;
import org.erdc.cobie.shared.targetunits.length.CentimeterTextMatcher;
import org.erdc.cobie.shared.targetunits.length.FeetTextMatcher;
import org.erdc.cobie.shared.targetunits.length.InchesTextMatcher;
import org.erdc.cobie.shared.targetunits.length.KilometerTextMatcher;
import org.erdc.cobie.shared.targetunits.length.LengthUnitSearch;
import org.erdc.cobie.shared.targetunits.length.MetersTextMatcher;
import org.erdc.cobie.shared.targetunits.length.MilesTextMatcher;
import org.erdc.cobie.shared.targetunits.length.MillimeterTextMatcher;
import org.erdc.cobie.shared.targetunits.length.YardTextMatcher;
import org.erdc.cobie.shared.targetunits.volume.CubicCentimetersTextMatcher;
import org.erdc.cobie.shared.targetunits.volume.CubicFeetTextMatcher;
import org.erdc.cobie.shared.targetunits.volume.CubicInchesTextMatcher;
import org.erdc.cobie.shared.targetunits.volume.CubicKilometersTextMatcher;
import org.erdc.cobie.shared.targetunits.volume.CubicMetersTextMatcher;
import org.erdc.cobie.shared.targetunits.volume.CubicMillimetersTextMatcher;
import org.erdc.cobie.shared.targetunits.volume.VolumeUnitSearch;


public class UnitSearchToCOBieLiteUnits
{


    public static AreaUnitSimpleType.Enum getAreaUnit(AreaUnitSearch areaUnitSearch)
    {
        AreaUnitSimpleType.Enum unit = null;
        UnitTextMatcher textMatcher = areaUnitSearch.getBestUnitTextMatcher();
        if(textMatcher instanceof SquareCentimetersTextMatcher)
        {
            //unit = AreaUnitSimpleType.
        }
        else if (textMatcher instanceof SquareFeetTextMatcher)
        {
            unit = AreaUnitSimpleType.SQUARE_FEET;
        }
        else if (textMatcher instanceof SquareInchesTextMatcher)
        {
           //
        }
        else if (textMatcher instanceof SquareKilometersTextMatcher)
            unit = AreaUnitSimpleType.SQUARE_KILOMETERS;
        else if (textMatcher instanceof SquareMetersTextMatcher)
            unit = AreaUnitSimpleType.SQUARE_METERS;
        return unit;
    }

    public static LinearUnitSimpleType.Enum getLengthUnit(LengthUnitSearch unitSearch)
    {
        LinearUnitSimpleType.Enum unit = null;
        UnitTextMatcher textMatcher = unitSearch.getBestUnitTextMatcher();
        if(textMatcher instanceof CentimeterTextMatcher)
        {
           // unit = FacilityLinearUnitsEnumerationType.
           // unit = LinearUnitSimpleType.
        }
        else if (textMatcher instanceof FeetTextMatcher)
        {
            unit = LinearUnitSimpleType.FEET;
        }
        else if (textMatcher instanceof InchesTextMatcher)
        {
            unit = LinearUnitSimpleType.INCHES;
        }
        else if (textMatcher instanceof KilometerTextMatcher)
        {
            unit = LinearUnitSimpleType.KILOMETERS;
        }
        else if (textMatcher instanceof MetersTextMatcher)
        {
            unit = LinearUnitSimpleType.METERS;
        }
        else if (textMatcher instanceof MilesTextMatcher)
        {
            unit = LinearUnitSimpleType.MILES;
        }
        else if (textMatcher instanceof MillimeterTextMatcher)
        {
            unit = LinearUnitSimpleType.MILLIMETERS;
        }
        else if (textMatcher instanceof YardTextMatcher)
        {
            //unit = LinearUnitSimpleType.
        }
        return unit;
    }
    
    public static VolumeUnitSimpleType.Enum getVolumeUnit(VolumeUnitSearch volumeUnitSearch)
    {
        VolumeUnitSimpleType.Enum unit = null;
        UnitTextMatcher textMatcher = volumeUnitSearch.getBestUnitTextMatcher();
        //if(textMatcher instanceof CubicCentimetersTextMatcher)
           // unit = VolumeUnitSimpleType.
        if (textMatcher instanceof CubicFeetTextMatcher)
            unit = VolumeUnitSimpleType.CUBIC_FEET;
      //  else if (textMatcher instanceof CubicInchesTextMatcher)
           // unit = VolumeUnitSimpleType.
      //  else if (textMatcher instanceof CubicKilometersTextMatcher)
           // unit = VolumeUnitSimpleType.
        else if (textMatcher instanceof CubicMetersTextMatcher)
            unit = VolumeUnitSimpleType.CUBIC_METERS;
        //else if (textMatcher instanceof CubicMillimetersTextMatcher)
         //   unit = VolumeUnitSimpleType.
        return unit;
    }
    
    public static CurrencyUnitSimpleType.Enum getCurrencyUnit(IfcCurrencyEnum currency)
    {
        CurrencyUnitSimpleType.Enum unit = null;
        switch(currency)
        {
            case AED:
                break;
            case AES:
                break;
            case ATS:
                unit = CurrencyUnitSimpleType.EUROS;
                break;
            case AUD:
                unit = CurrencyUnitSimpleType.DOLLARS;
                break;
            case BBD:
                break;
            case BEG:
                unit = CurrencyUnitSimpleType.EUROS;
                break;                
            case BGL:
                break;
            case BHD:
                break;
            case BMD:
                break;
            case BND:
                break;
            case BRL:
                break;
            case BSD:
                break;
            case BWP:
                break;
            case BZD:
                break;
            case CAD:
                break;
            case CBD:
                break;
            case CHF:
                break;
            case CLP:
                break;
            case CNY:
                break;
            case CYS:
                unit = CurrencyUnitSimpleType.EUROS;
                break;
            case CZK:
                break;
            case DDP:
                break;
            case DEM:
                unit = CurrencyUnitSimpleType.EUROS;
                break;
            case DKK:
                break;
            case EGL:
                break;
            case EST:
                unit = CurrencyUnitSimpleType.EUROS;
                break;
            case EUR:
                unit = CurrencyUnitSimpleType.EUROS;
                break;
            case FAK:
                break;
            case FIM:
                unit = CurrencyUnitSimpleType.EUROS;
                break;
            case FJD:
                break;
            case FKP:
                break;
            case FRF:
                unit = CurrencyUnitSimpleType.EUROS;
                break;
            case GBP:
                unit = CurrencyUnitSimpleType.BRITISH_POUNDS;
                break;
            case GIP:
                break;
            case GMD:
                break;
            case GRX:
                unit = CurrencyUnitSimpleType.EUROS;
                break;
            case HKD:
                break;
            case HUF:
                break;
            case ICK:
                break;
            case IDR:
                break;
            case ILS:
                break;
            case INR:
                break;
            case IRP:
                unit = CurrencyUnitSimpleType.EUROS;
                break;
            case ITL:
                unit = CurrencyUnitSimpleType.EUROS;
                break;
            case JMD:
                break;
            case JOD:
                break;
            case JPY:
                break;
            case KES:
                break;
            case KRW:
                break;
            case KWD:
                break;
            case KYD:
                break;
            case LKR:
                break;
            case LUF:
                unit = CurrencyUnitSimpleType.EUROS;
                break;
            case MTL:
                unit = CurrencyUnitSimpleType.EUROS;
                break;
            case MUR:
                break;
            case MXN:
                break;
            case MYR:
                break;
            case NLG:
                unit = CurrencyUnitSimpleType.EUROS;
                break;
            case NOK:
                break;
            case NULL:
                break;
            case NZD:
                break;
            case OMR:
                break;
            case PGK:
                break;
            case PHP:
                break;
            case PKR:
                break;
            case PLN:
                break;
            case PTN:
                unit = CurrencyUnitSimpleType.EUROS;
                break;
            case QAR:
                break;
            case RUR:
                break;
            case SAR:
                break;
            case SCR:
                break;
            case SEK:
                break;
            case SGD:
                break;
            case SKP:
                break;
            case THB:
                break;
            case TRL:
                break;
            case TTD:
                break;
            case TWD:
                break;
            case USD:
                unit = CurrencyUnitSimpleType.DOLLARS;
                break;
            case VEB:
                break;
            case VND:
                break;
            case XEU:
                break;
            case ZAR:
                break;
            case ZWD:
                break;
            
        }
        return unit;
    }
}
