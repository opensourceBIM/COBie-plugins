package org.bimserver.cobie.shared.utility.ifc;

/******************************************************************************

 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/
import java.util.ArrayList;

import org.bimserver.cobie.shared.utility.COBieUtility;
import org.bimserver.models.ifc2x3tc1.IfcContextDependentUnit;
import org.bimserver.models.ifc2x3tc1.IfcConversionBasedUnit;
import org.bimserver.models.ifc2x3tc1.IfcDerivedUnit;
import org.bimserver.models.ifc2x3tc1.IfcDerivedUnitElement;
import org.bimserver.models.ifc2x3tc1.IfcMonetaryUnit;
import org.bimserver.models.ifc2x3tc1.IfcNamedUnit;
import org.bimserver.models.ifc2x3tc1.IfcSIPrefix;
import org.bimserver.models.ifc2x3tc1.IfcSIUnit;
import org.bimserver.models.ifc2x3tc1.IfcSIUnitName;
import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;

public class IfcUnitToCOBieString
{
    private static final String MULTIPLICATION_SYMBOL = "*";
    private static final String EXPONENT_SYMBOL = "^";

    public static String getAreaUnitString(IfcNamedUnit nUnit)
    {
        String unitString = "";
        if (IfcSIUnit.class.isInstance(nUnit) && (nUnit.getUnitType().getLiteral() == IfcUnitEnum.AREAUNIT.getLiteral()))
        {
            IfcSIUnit siUnit = (IfcSIUnit)nUnit;
            if (siUnit.getName().getLiteral() == IfcSIUnitName.SQUARE_METRE.getLiteral())
            {
                unitString = "square " + getSIPrefix(siUnit.getPrefix()) + "meters";
            } else
            {
                unitString = stringFromNamedUnit(nUnit);
            }
        } else
        {
            unitString = stringFromNamedUnit(nUnit);
        }
        return unitString;
    }

    static protected String getSIPrefix(IfcSIPrefix prefix)
    {
        String prefixString = "";
        if ((prefix != null) && (prefix.getLiteral() != IfcSIPrefix.NULL.getLiteral()))
        {
            prefixString = prefix.getName().toLowerCase();
        }
        return prefixString;
    }

    public static String getVolumeUnitString(IfcNamedUnit nUnit)
    {
        String unitString = "";
        if (IfcSIUnit.class.isInstance(nUnit) && (nUnit.getUnitType().getLiteral() == IfcUnitEnum.VOLUMEUNIT.getLiteral()))
        {
            IfcSIUnit siUnit = (IfcSIUnit)nUnit;
            if (siUnit.getName().getLiteral() == IfcSIUnitName.CUBIC_METRE.getLiteral())
            {
                unitString = "cubic " + getSIPrefix(siUnit.getPrefix()) + "meters";
            } else
            {
                unitString = stringFromNamedUnit(nUnit);
            }
        } else
        {
            unitString = stringFromNamedUnit(nUnit);
        }
        return unitString;
    }

    public static String linearUnitString(IfcNamedUnit nUnit)
    {
        String unitString = "";
        if (IfcSIUnit.class.isInstance(nUnit) && (nUnit.getUnitType().getLiteral() == IfcUnitEnum.LENGTHUNIT.getLiteral()))
        {
            IfcSIUnit siUnit = (IfcSIUnit)nUnit;

            if (siUnit.getName().getLiteral() == IfcSIUnitName.METRE.getLiteral())
            {
                unitString = getSIPrefix(siUnit.getPrefix()) + "meters";
            } else
            {
                unitString = stringFromNamedUnit(nUnit);
            }
        } else
        {
            unitString = stringFromNamedUnit(nUnit);
        }
        return unitString;
    }

    static protected String stringFromDerivedUnit(IfcDerivedUnit unit)
    {
        String positiveUnitString = "";
        String negativeUnitString = "";
        String unitString = "";
        String tmpUnitStr = "";
        ArrayList<String> positiveExponents = new ArrayList<String>();
        ArrayList<String> negativeExponents = new ArrayList<String>();
        int exp = 0;
        for (IfcDerivedUnitElement nUnit : unit.getElements())
        {
            exp = nUnit.getExponent();
            tmpUnitStr = IfcUnitToCOBieString.stringFromUnit(nUnit.getUnit());
            if ((tmpUnitStr != null) && (tmpUnitStr.length() > 0))
            {
                
                if (exp > 0)
                {
                    if(exp > 1)
                        tmpUnitStr = tmpUnitStr + EXPONENT_SYMBOL + String.valueOf(exp);
                    positiveExponents.add(tmpUnitStr);
                } else if (exp < 0)
                {
                    if(exp < -1)
                        tmpUnitStr = tmpUnitStr + EXPONENT_SYMBOL + String.valueOf(exp*-1);
                    negativeExponents.add(tmpUnitStr);
                }
            }
        }

        for (String posStr : positiveExponents)
        {
            positiveUnitString += posStr + MULTIPLICATION_SYMBOL;
        }
        if (positiveUnitString.endsWith(MULTIPLICATION_SYMBOL))
        {
            positiveUnitString = positiveUnitString.substring(0, positiveUnitString.length() - 1);
        }

        for (String negStr : negativeExponents)
        {
            negativeUnitString += negStr + MULTIPLICATION_SYMBOL;
        }
        if (negativeUnitString.endsWith(MULTIPLICATION_SYMBOL))
        {
            negativeUnitString = negativeUnitString.substring(0, negativeUnitString.length() - 1);
        }

        int posUnitLength = positiveUnitString.length();
        int negUnitLength = negativeUnitString.length();
        if ((posUnitLength == 0) && (negUnitLength == 0))
        {
            unitString = "";
        } else if ((posUnitLength == 0) && (negUnitLength > 0))
        {
            unitString = "1/" + negativeUnitString;
        } else if ((posUnitLength > 0) && (negUnitLength == 0))
        {
            unitString = positiveUnitString;
        } else if ((posUnitLength > 0) && (negUnitLength > 0))
        {
            unitString = "(" + positiveUnitString + ")/(" + negativeUnitString + ")";
        }
        return unitString;
    }

    public static String stringFromMonetaryUnit(IfcMonetaryUnit unit)
    {

        String currencyString = "";
        switch (unit.getCurrency())
        {
            case AES:
                currencyString = "Argentine peso (AES)";
                break;
            case AUD:
                currencyString = "Australian dollar (AUD)";
                break;
            case ATS:
                currencyString = "European euro (ATS)";
                break;
            case BSD:
                currencyString = "Bahamian dollar (BSD)";
                break;
            case BHD:
                currencyString = "Bahraini dinar (BHD)";
                break;
            case BBD:
                currencyString = "Barbadian dollar (BBD)";
                break;
            case BEG:
                currencyString = "European euro (BEG)";
                break;
            case BZD:
                currencyString = "Belize dollar (BZD)";
                break;
            case BMD:
                currencyString = "Bermuda (BMD)";
                break;
            case BWP:
                currencyString = "Botswana pula (BWP)";
                break;
            case BRL:
                currencyString = "Brazilian real (BRL)";
                break;
            case BND:
                currencyString = "Brunei dollar (BND)";
                break;
            case BGL:
                currencyString = "Bulgarian lev (BGL)";
                break;
            case CAD:
                currencyString = "Canadian dollar (CAD)";
                break;
            case CBD:
                currencyString = "Carribean (CBD)";
                break;
            case KYD:
                currencyString = "Cayman Islands dollar (KYD)";
                break;
            case CLP:
                currencyString = "Chilean peso (CLP)";
                break;
            case CNY:
                currencyString = "Chinese renminbi (CNY)";
                break;
            case CYS:
                currencyString = "European euro (CYS)";
                break;
            case CZK:
                currencyString = "Czech koruna (CZK)";
                break;
            case DKK:
                currencyString = "Danish krone (DKK)";
                break;
            case DDP:
                currencyString = "Dominican peso (DDP)";
                break;
            case EGL:
                currencyString = "Egyptian pound (EGL)";
                break;
            case XEU:
                currencyString = "Europe (States of the European Union) (XEU)";
                break;
            case EUR:
                currencyString = "Europe currency (EUR)";
                break;
            case FKP:
                currencyString = "Falkland Islands pound (FKP)";
                break;
            case FAK:
                currencyString = "Faroe Islands (FAK)";
                break;
            case FJD:
                currencyString = "Fijian dollar (FJD)";
                break;
            case FIM:
                currencyString = "European euro (FIM)";
                break;
            case FRF:
                currencyString = "European euro (FRF)";
                break;
            case GMD:
                currencyString = "Gambian dalasi (GMD)";
                break;
            case DEM:
                currencyString = "European euro (DEM)";
                break;
            case GIP:
                currencyString = "Gibraltar pound (GIP)";
                break;
            case GRX:
                currencyString = "European euro (GRX)";
                break;
            case HKD:
                currencyString = "Hong Kong dollar (HKD)";
                break;
            case HUF:
                currencyString = "Hungarian forint (HUF)";
                break;
            case ICK:
                currencyString = "Icelandic krona (ICK)";
                break;
            case INR:
                currencyString = "Indian rupee (INR)";
                break;
            case IDR:
                currencyString = "Indonesian rupiah (IDR)";
                break;
            case IRP:
                currencyString = "European euro (IRP)";
                break;
            case ILS:
                currencyString = "Israeli new sheqel (ILS)";
                break;
            case ITL:
                currencyString = "European euro (ITL)";
                break;
            case JMD:
                currencyString = "Jamaican dollar (JMD)";
                break;
            case JPY:
                currencyString = "Japanese yen (JPY)";
                break;
            case JOD:
                currencyString = "Jordanian dinar (JOD)";
                break;
            case KES:
                currencyString = "Kenyan shilling (KES)";
                break;
            case KWD:
                currencyString = "Kuwaiti dinar (KWD)";
                break;
            case LUF:
                currencyString = "European euro (LUF)";
                break;
            case MYR:
                currencyString = "Malaysian ringgit (MYR)";
                break;
            case MTL:
                currencyString = "European Euro (MTL)";
                break;
            case MUR:
                currencyString = "Mauritian rupee (MUR)";
                break;
            case MXN:
                currencyString = "Mexican peso (MXN)";
                break;
            case NLG:
                currencyString = "European euro (NLG)";
                break;
            case NZD:
                currencyString = "New Zealand dollar (NZD)";
                break;
            case NOK:
                currencyString = "Norwegian krone (NOK)";
                break;
            case OMR:
                currencyString = "Omani rial (OMR)";
                break;
            case PKR:
                currencyString = "Pakistani rupee (PKR)";
                break;
            case PGK:
                currencyString = "Papua New Guinean kina (PGK)";
                break;
            case PHP:
                currencyString = "Philipines (PHP)";
                break;
            case PLN:
                currencyString = "Polish zloty (PLN)";
                break;
            case PTN:
                currencyString = "European euro (PTN)";
                break;
            case QAR:
                currencyString = "Qatari riyal (QAR)";
                break;
            case KRW:
                currencyString = "Republic of Korea (KRW)";
                break;
            case RUR:
                currencyString = "Russian ruble (RUR)";
                break;
            case SAR:
                currencyString = "Saudi riyal (SAR)";
                break;
            case SCR:
                currencyString = "Seychellois rupee (SCR)";
                break;
            case SGD:
                currencyString = "Singapore dollar> (SGD)";
                break;
            case ZAR:
                currencyString = "South African rand (ZAR)";
                break;
            case EST:
                currencyString = "European euro (EST)";
                break;
            case LKR:
                currencyString = "Sri Lankan rupee (LKR)";
                break;
            case SKP:
                currencyString = "St.Helena (SKP)";
                break;
            case SEK:
                currencyString = "Swedish krona (SEK)";
                break;
            case CHF:
                currencyString = "Swiss franc (CHF)";
                break;
            case TWD:
                currencyString = "New Taiwan dollar (TWD)";
                break;
            case THB:
                currencyString = "Thai baht (THB)";
                break;
            case TTD:
                currencyString = "Trinidad and Tobago dollar (TTD)";
                break;
            case TRL:
                currencyString = "Turkish new lira (TRL)";
                break;
            case AED:
                currencyString = "UAE dirham (AED)";
                break;
            case GBP:
                currencyString = "British pound (GBP)";
                break;
            case USD:
                currencyString = "United States dollar (USD)";
                break;
            case VEB:
                currencyString = "Venezuelan bolivar (VEB)";
                break;
            case VND:
                currencyString = "Viet-Nam (VND)";
                break;
            case ZWD:
                currencyString = "Zimbabwean dollar (ZWD)";
                break;
            case NULL:
                currencyString = COBieUtility.COBieNA;
                break;
            default:
                currencyString = COBieUtility.COBieNA;
                break;
        }

        if (COBieUtility.isNA(currencyString))
        {
            currencyString = unit.getCurrency().getLiteral();
        }
        return COBieUtility.getCOBieString(currencyString);
    }

    static protected String stringFromNamedUnit(IfcNamedUnit nUnit)
    {
        String unitString = "";
        if (IfcSIUnit.class.isInstance(nUnit))
        {
            IfcSIUnit siUnit = (IfcSIUnit)nUnit;
            unitString = getSIPrefix(siUnit.getPrefix()) + siUnit.getName().getLiteral();

        } else if (IfcConversionBasedUnit.class.isInstance(nUnit))
        {
            IfcConversionBasedUnit convUnit = (IfcConversionBasedUnit)nUnit;
            if (convUnit.getName().length() > 0)
            {
                unitString = convUnit.getName();
            }
        } else if (IfcContextDependentUnit.class.isInstance(nUnit))
        {
            IfcContextDependentUnit cntxtUnit = (IfcContextDependentUnit)nUnit;
            if (cntxtUnit.getName().length() > 0)
            {
                unitString = cntxtUnit.getName();
            }
        }

        return unitString;
    }

    public static String stringFromUnit(IfcUnit unit)
    {
        String unitString = "";
        if (IfcDerivedUnit.class.isInstance(unit))
        {
            unitString = stringFromDerivedUnit((IfcDerivedUnit)unit);
        } else if (IfcNamedUnit.class.isInstance(unit))
        {
            unitString = stringFromNamedUnit((IfcNamedUnit)unit);
        } else if (IfcMonetaryUnit.class.isInstance(unit))
        {
            unitString = stringFromMonetaryUnit((IfcMonetaryUnit)unit);
        }
        return unitString;
    }
}
