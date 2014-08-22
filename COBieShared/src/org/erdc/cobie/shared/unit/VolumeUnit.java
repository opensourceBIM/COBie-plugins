package org.erdc.cobie.shared.unit;


public enum VolumeUnit implements Unit
{
	CUBIC_CENTIMETERS(Metric.CUBIC_CENTIMETERS),
	CUBIC_FEET(Imperial.CUBIC_FEET),
	CUBIC_INCHES(Imperial.CUBIC_INCHES),
	CUBIC_METERS(Metric.CUBIC_METERS),
	CUBIC_MILLIMETERS(Metric.CUBIC_MILLIMETERS);
	
	private final Measurable measurable;
	
	private VolumeUnit(Measurable measurable)
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
    	public static Measurable CUBIC_FEET = new Measurable("cubic feet", 
    			"cubicfeet", "cubic feet", "cubed foot", "feet cubed", "cubic ft", "ft3", "ft^3", "cubed feet", "ft cubed", "cubic ft.", "ft. cubed");
    	
    	public static Measurable CUBIC_INCHES = new Measurable("cubic inches", 
    			"cubicinches", "cubic inches", "cubic inch", "inches cubed", "cubic in.", "in3", "in^3", "in. cubed", "cubic in", "in cubed");
    }
    
	private static class Metric
    {
    	public static Measurable CUBIC_CENTIMETERS = new Measurable("cubic centimeters", "cubiccentimeters", "cubic centimeter", "centimeters cubed",
                "cubedcentimeter", "cm3", "cm^3", "cubed centimeters", "cubic cm", "cubed centimeter", "cubed cm", "cm cubed");
    	
    	public static Measurable CUBIC_METERS = new Measurable("cubic meters", "cubicmeters",  "cubic meter", "meters cubed", "cubedmeter", "m3", "m^3", "cubed meters",
                    "cubic m", "cubed meter", "cubed meter", "cubed m", "m cubed");
    	
        public static Measurable CUBIC_MILLIMETERS = new Measurable("cubic millimeters", "cubicmillimeters", "cubic millimeter", "millimeters cubed",
                    "cubedmillimeter", "mm3", "mm^3", "cubed millimeters", "cubic mm", "cubed millimeter", "mm cubed");            
    }
}
