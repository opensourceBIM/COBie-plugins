package org.bimserver.cobie.shared.unit;

import org.buildingsmartalliance.docs.nbims03.cobie.core.AreaUnitSimpleType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.CurrencyUnitSimpleType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.LinearUnitSimpleType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.VolumeUnitSimpleType;

public class CobieLiteUnitMatcher
{

	private final Unit unit;
	
	public CobieLiteUnitMatcher(Unit unit)
	{
		this.unit = unit;
	}
	
	public LinearUnitSimpleType.Enum matchLinearUnit()
	{
		LinearUnitSimpleType.Enum cobieLiteUnit = null;
		if(unit instanceof LinearUnit)
		{
			LinearUnit linearUnit = (LinearUnit)unit;
			switch(linearUnit)
			{
				case CENTIMETERS:
					cobieLiteUnit = LinearUnitSimpleType.CENTIMETERS;
					break;
				case FEET:
					cobieLiteUnit = LinearUnitSimpleType.FEET;
					break;
				case INCHES:
					cobieLiteUnit = LinearUnitSimpleType.INCHES;
					break;
				case KILOMETERS:
					cobieLiteUnit = LinearUnitSimpleType.KILOMETERS;
					break;
				case METERS:
					cobieLiteUnit = LinearUnitSimpleType.METERS;
					break;
				case MILES:
					cobieLiteUnit = LinearUnitSimpleType.MILES;
					break;
				case MILLIMETERS:
					cobieLiteUnit = LinearUnitSimpleType.MILLIMETERS;
					break;
				case YARDS:
					cobieLiteUnit = LinearUnitSimpleType.YARDS;
					break;
				default:
					break;
				
			}
		}
		return cobieLiteUnit;
	}
	
	public VolumeUnitSimpleType.Enum matchVolumeUnit()
	{
		VolumeUnitSimpleType.Enum cobieLiteUnit = null;
		if(unit instanceof VolumeUnit)
		{
			VolumeUnit volumeUnit = (VolumeUnit)unit;
			switch(volumeUnit)
			{
				case CUBIC_CENTIMETERS:
					cobieLiteUnit = VolumeUnitSimpleType.CUBIC_CENTIMETERS;
					break;
				case CUBIC_FEET:
					cobieLiteUnit = VolumeUnitSimpleType.CUBIC_FEET;
					break;
				case CUBIC_INCHES:
					cobieLiteUnit = VolumeUnitSimpleType.CUBIC_INCHES;
					break;
				case CUBIC_METERS:
					cobieLiteUnit = VolumeUnitSimpleType.CUBIC_METERS;
					break;
				case CUBIC_MILLIMETERS:
					cobieLiteUnit = VolumeUnitSimpleType.CUBIC_MILLIMETERS;
					break;
				default:
					break;
				
			}
		}
		return cobieLiteUnit;
	}
	
	public AreaUnitSimpleType.Enum matchAreaUnit()
	{
		AreaUnitSimpleType.Enum cobieLiteUnit = null;
		if(unit instanceof AreaUnit)
		{
			AreaUnit areaUnit = (AreaUnit)unit;
			switch(areaUnit)
			{
				case SQUARE_CENTIMETERS:
					cobieLiteUnit = AreaUnitSimpleType.SQUARE_CENTIMETERS;
					break;
				case SQUARE_FEET:
					cobieLiteUnit = AreaUnitSimpleType.SQUARE_FEET;
					break;
				case SQUARE_INCHES:
					cobieLiteUnit = AreaUnitSimpleType.SQUARE_INCHES;
					break;
				case SQUARE_KILOMETERS:
					cobieLiteUnit = AreaUnitSimpleType.SQUARE_KILOMETERS;
					break;
				case SQUARE_METERS:
					cobieLiteUnit = AreaUnitSimpleType.SQUARE_METERS;
					break;
				case SQUARE_MILLIMETERS:
					cobieLiteUnit = AreaUnitSimpleType.SQUARE_MILLIMETERS;
					break;
				default:
					break;
				
			}
		}
		return cobieLiteUnit;
	}
	
	public CurrencyUnitSimpleType.Enum matchCurrencyUnit()
	{
		CurrencyUnitSimpleType.Enum cobieLiteUnit = null;
		if(unit instanceof CurrencyUnit)
		{
			CurrencyUnit currencyUnit = (CurrencyUnit)unit;
			switch(currencyUnit)
			{
	            case ATS:
	                cobieLiteUnit = CurrencyUnitSimpleType.EUROS;
	                break;
	            case AUD:
	                cobieLiteUnit = CurrencyUnitSimpleType.DOLLARS;
	                break;
	            case BEG:
	                cobieLiteUnit = CurrencyUnitSimpleType.EUROS;
	                break;                
	            case CYS:
	                cobieLiteUnit = CurrencyUnitSimpleType.EUROS;
	                break;	    
	            case DEM:
	                cobieLiteUnit = CurrencyUnitSimpleType.EUROS;
	                break;           
	            case EST:
	                cobieLiteUnit = CurrencyUnitSimpleType.EUROS;
	                break;
	            case EUR:
	                cobieLiteUnit = CurrencyUnitSimpleType.EUROS;
	                break;
	            case FIM:
	                cobieLiteUnit = CurrencyUnitSimpleType.EUROS;
	                break;	          
	            case FRF:
	                cobieLiteUnit = CurrencyUnitSimpleType.EUROS;
	                break;
	            case GBP:
	                cobieLiteUnit = CurrencyUnitSimpleType.BRITISH_POUNDS;
	                break;	          
	            case GRX:
	                cobieLiteUnit = CurrencyUnitSimpleType.EUROS;
	                break;	            
	            case IRP:
	                cobieLiteUnit = CurrencyUnitSimpleType.EUROS;
	                break;
	            case ITL:
	                cobieLiteUnit = CurrencyUnitSimpleType.EUROS;
	                break;	            
	            case LUF:
	                cobieLiteUnit = CurrencyUnitSimpleType.EUROS;
	                break;
	            case MTL:
	                cobieLiteUnit = CurrencyUnitSimpleType.EUROS;
	                break;	           
	            case NLG:
	                cobieLiteUnit = CurrencyUnitSimpleType.EUROS;
	                break;	           
	            case PTN:
	                cobieLiteUnit = CurrencyUnitSimpleType.EUROS;
	                break;	          
	            case USD:
	                cobieLiteUnit = CurrencyUnitSimpleType.DOLLARS;
	                break;          
				default:
					break;
				
			}
			
		}
		return cobieLiteUnit;
	}
}
