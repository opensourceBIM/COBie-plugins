package org.bimserver.cobie.shared.unit;

public enum LinearUnit implements Unit
{
	CENTIMETERS(Metric.CENTIMETERS),
	FEET(Imperial.FEET),
	INCHES(Imperial.INCHES),
	KILOMETERS(Metric.KILOMETERS),
	METERS(Metric.METERS),
	MILES(Imperial.MILES),
	MILLIMETERS(Metric.MILLIMETERS),
	YARDS(Imperial.YARDS);
	
	private static class Imperial
	{		
		public static Measurable FEET = new Measurable("feet", "foot", "ft", "feet", "'");
		public static Measurable INCHES = new Measurable("inches", "inch", "inches", "in", "\"");
		public static Measurable MILES = new Measurable("mile", "miles", "mile", "mi");
		public static Measurable YARDS = new Measurable("yards", "yards", "yard", "yd");
	}
	
	private static class Metric
	{		
		public static Measurable CENTIMETERS = new Measurable("centimeters", "cm", "centimeter", "centimeters", "centimetre", "centimetres");
		public static Measurable KILOMETERS = new Measurable("kilometers", "kilometers", "kilometer", "km", "kilometre", "kilometres");
		public static Measurable METERS = new Measurable("meters", "meters", "m", "metre", "metres");
		public static Measurable MILLIMETERS = new Measurable("millimeters", "mm", "millimeters", "millimeter", "millimetre", "millimetres");
	}
	
	private final Measurable measurable;
	
	private LinearUnit(Measurable measurable)
	{
		this.measurable = measurable;
	}
	
	@Override
	public final Measurable getMeasurable()
	{
		return measurable;
	}

	
}
