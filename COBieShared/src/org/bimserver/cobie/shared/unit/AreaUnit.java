package org.bimserver.cobie.shared.unit;


public enum AreaUnit implements Unit
{
	SQUARE_FEET(Imperial.SQUARE_FEET),
	SQUARE_INCHES(Imperial.SQUARE_INCHES),
	SQUARE_KILOMETERS(Metric.SQUARE_KILOMETERS),
	SQUARE_METERS(Metric.SQUARE_METERS),
	SQUARE_CENTIMETERS(Metric.SQUARE_CENTIMETERS),
	SQUARE_MILLIMETERS(Metric.SQUARE_MILLIMETERS);
	
	private final Measurable measurable;
	
	private AreaUnit(Measurable measurable)
	{
		this.measurable = measurable;
	}
	
	@Override
	public final Measurable getMeasurable()
	{
		return measurable;
	}
	
	private static class Imperial
	{
		public static Measurable SQUARE_FEET = new Measurable("square foot",  "squarefeet", "square feet", "square foot", "feet squared", "squarefoot", "ft2", "ft^2", "sq. feet", "sq. foot", "sq feet",
                "sq foot");
		
		public static Measurable SQUARE_INCHES = new Measurable("square inch", "squareinches", "square inches", "square inch", "inches squared", "squareinch", "in2", "in^2", "sq. inches", "sq. inch",
                "sq inches", "sq inch");
	}
	
	private static class Metric
	{
		public static Measurable SQUARE_CENTIMETERS = new Measurable("square centimeters", "squarecentimeters", "square centimeter", "centimeters squared",
                "squarecentimeter", "cm2", "cm^2", "sq centimeters", "sq centimeter", "sq. centimeter", "sq.centimeters");

		public static Measurable SQUARE_KILOMETERS = new Measurable("square kilometers", "squarekilometers", "square kilometer", "kilometers squared",
                "squarekilometer", "km2", "km^2", "sq kilometers", "sq kilometer", "sq. kilometer", "sq.kilometers");
		
		public static Measurable SQUARE_METERS = new Measurable("square meters", "squaremeters", "square meter", "meters squared", "squaremeter", "m2", "m^2", "sq meters",
                "sq meter", "sq. meter", "sq.meters");
		
		public static Measurable SQUARE_MILLIMETERS = new Measurable("square millimeters", "squaremillimeters", "square millimeter", "millimeters squared",
                "squaremillimeter", "mm2", "mm^2", "sq millimeters", "sq millimeter", "sq. millimeter", "sq.millimeters");
	}
}
