/*
 * XML Type:  ZoneTypeCategoryEnumerationType
 * Namespace: cobieLite
 * Java type: cobieLite.ZoneTypeCategoryEnumerationType
 *
 * Automatically generated - do not modify.
 */
package cobieLite;


/**
 * An XML ZoneTypeCategoryEnumerationType(@cobieLite).
 *
 * This is an atomic type that is a restriction of cobieLite.ZoneTypeCategoryEnumerationType.
 */
public interface ZoneTypeCategoryEnumerationType extends org.apache.xmlbeans.XmlString
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ZoneTypeCategoryEnumerationType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s3A84CE08177E9EC2022DBEA3D9A338ED").resolveHandle("zonetypecategoryenumerationtypebd54type");
    
    org.apache.xmlbeans.StringEnumAbstractBase enumValue();
    void set(org.apache.xmlbeans.StringEnumAbstractBase e);
    
    static final Enum CIRCULATION_ZONE = Enum.forString("Circulation Zone");
    static final Enum LIGHTING_ZONE = Enum.forString("Lighting Zone");
    static final Enum FIRE_ALARM_ZONE = Enum.forString("Fire Alarm Zone");
    static final Enum HISTORICAL_PRESERVATION_ZONE = Enum.forString("Historical Preservation Zone");
    static final Enum OCCUPANCY_ZONE = Enum.forString("Occupancy Zone");
    static final Enum VENTILATION_ZONE = Enum.forString("Ventilation Zone");
    
    static final int INT_CIRCULATION_ZONE = Enum.INT_CIRCULATION_ZONE;
    static final int INT_LIGHTING_ZONE = Enum.INT_LIGHTING_ZONE;
    static final int INT_FIRE_ALARM_ZONE = Enum.INT_FIRE_ALARM_ZONE;
    static final int INT_HISTORICAL_PRESERVATION_ZONE = Enum.INT_HISTORICAL_PRESERVATION_ZONE;
    static final int INT_OCCUPANCY_ZONE = Enum.INT_OCCUPANCY_ZONE;
    static final int INT_VENTILATION_ZONE = Enum.INT_VENTILATION_ZONE;
    
    /**
     * Enumeration value class for cobieLite.ZoneTypeCategoryEnumerationType.
     * These enum values can be used as follows:
     * <pre>
     * enum.toString(); // returns the string value of the enum
     * enum.intValue(); // returns an int value, useful for switches
     * // e.g., case Enum.INT_CIRCULATION_ZONE
     * Enum.forString(s); // returns the enum value for a string
     * Enum.forInt(i); // returns the enum value for an int
     * </pre>
     * Enumeration objects are immutable singleton objects that
     * can be compared using == object equality. They have no
     * public constructor. See the constants defined within this
     * class for all the valid values.
     */
    static final class Enum extends org.apache.xmlbeans.StringEnumAbstractBase
    {
        /**
         * Returns the enum value for a string, or null if none.
         */
        public static Enum forString(java.lang.String s)
            { return (Enum)table.forString(s); }
        /**
         * Returns the enum value corresponding to an int, or null if none.
         */
        public static Enum forInt(int i)
            { return (Enum)table.forInt(i); }
        
        private Enum(java.lang.String s, int i)
            { super(s, i); }
        
        static final int INT_CIRCULATION_ZONE = 1;
        static final int INT_LIGHTING_ZONE = 2;
        static final int INT_FIRE_ALARM_ZONE = 3;
        static final int INT_HISTORICAL_PRESERVATION_ZONE = 4;
        static final int INT_OCCUPANCY_ZONE = 5;
        static final int INT_VENTILATION_ZONE = 6;
        
        public static final org.apache.xmlbeans.StringEnumAbstractBase.Table table =
            new org.apache.xmlbeans.StringEnumAbstractBase.Table
        (
            new Enum[]
            {
                new Enum("Circulation Zone", INT_CIRCULATION_ZONE),
                new Enum("Lighting Zone", INT_LIGHTING_ZONE),
                new Enum("Fire Alarm Zone", INT_FIRE_ALARM_ZONE),
                new Enum("Historical Preservation Zone", INT_HISTORICAL_PRESERVATION_ZONE),
                new Enum("Occupancy Zone", INT_OCCUPANCY_ZONE),
                new Enum("Ventilation Zone", INT_VENTILATION_ZONE),
            }
        );
        private static final long serialVersionUID = 1L;
        private java.lang.Object readResolve() { return forInt(intValue()); } 
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static cobieLite.ZoneTypeCategoryEnumerationType newValue(java.lang.Object obj) {
          return (cobieLite.ZoneTypeCategoryEnumerationType) type.newValue( obj ); }
        
        public static cobieLite.ZoneTypeCategoryEnumerationType newInstance() {
          return (cobieLite.ZoneTypeCategoryEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static cobieLite.ZoneTypeCategoryEnumerationType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (cobieLite.ZoneTypeCategoryEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static cobieLite.ZoneTypeCategoryEnumerationType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (cobieLite.ZoneTypeCategoryEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static cobieLite.ZoneTypeCategoryEnumerationType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (cobieLite.ZoneTypeCategoryEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static cobieLite.ZoneTypeCategoryEnumerationType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cobieLite.ZoneTypeCategoryEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static cobieLite.ZoneTypeCategoryEnumerationType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cobieLite.ZoneTypeCategoryEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static cobieLite.ZoneTypeCategoryEnumerationType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cobieLite.ZoneTypeCategoryEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static cobieLite.ZoneTypeCategoryEnumerationType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cobieLite.ZoneTypeCategoryEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static cobieLite.ZoneTypeCategoryEnumerationType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cobieLite.ZoneTypeCategoryEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static cobieLite.ZoneTypeCategoryEnumerationType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cobieLite.ZoneTypeCategoryEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static cobieLite.ZoneTypeCategoryEnumerationType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cobieLite.ZoneTypeCategoryEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static cobieLite.ZoneTypeCategoryEnumerationType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cobieLite.ZoneTypeCategoryEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static cobieLite.ZoneTypeCategoryEnumerationType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (cobieLite.ZoneTypeCategoryEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static cobieLite.ZoneTypeCategoryEnumerationType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (cobieLite.ZoneTypeCategoryEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static cobieLite.ZoneTypeCategoryEnumerationType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (cobieLite.ZoneTypeCategoryEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static cobieLite.ZoneTypeCategoryEnumerationType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (cobieLite.ZoneTypeCategoryEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static cobieLite.ZoneTypeCategoryEnumerationType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (cobieLite.ZoneTypeCategoryEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static cobieLite.ZoneTypeCategoryEnumerationType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (cobieLite.ZoneTypeCategoryEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
