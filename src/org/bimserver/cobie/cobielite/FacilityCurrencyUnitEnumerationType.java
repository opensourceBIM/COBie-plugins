/*
 * XML Type:  FacilityCurrencyUnitEnumerationType
 * Namespace: cobielite.cobie.bimserver.org
 * Java type: org.bimserver.cobie.cobielite.FacilityCurrencyUnitEnumerationType
 *
 * Automatically generated - do not modify.
 */
package org.bimserver.cobie.cobielite;


/**
 * An XML FacilityCurrencyUnitEnumerationType(@cobielite.cobie.bimserver.org).
 *
 * This is an atomic type that is a restriction of org.bimserver.cobie.cobielite.FacilityCurrencyUnitEnumerationType.
 */
public interface FacilityCurrencyUnitEnumerationType extends org.apache.xmlbeans.XmlString
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(FacilityCurrencyUnitEnumerationType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9940D605A2AF1A0035EAACACA75B5274").resolveHandle("facilitycurrencyunitenumerationtype7155type");
    
    org.apache.xmlbeans.StringEnumAbstractBase enumValue();
    void set(org.apache.xmlbeans.StringEnumAbstractBase e);
    
    static final Enum DOLLARS = Enum.forString("Dollars");
    static final Enum EUROS = Enum.forString("Euros");
    
    static final int INT_DOLLARS = Enum.INT_DOLLARS;
    static final int INT_EUROS = Enum.INT_EUROS;
    
    /**
     * Enumeration value class for org.bimserver.cobie.cobielite.FacilityCurrencyUnitEnumerationType.
     * These enum values can be used as follows:
     * <pre>
     * enum.toString(); // returns the string value of the enum
     * enum.intValue(); // returns an int value, useful for switches
     * // e.g., case Enum.INT_DOLLARS
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
        
        static final int INT_DOLLARS = 1;
        static final int INT_EUROS = 2;
        
        public static final org.apache.xmlbeans.StringEnumAbstractBase.Table table =
            new org.apache.xmlbeans.StringEnumAbstractBase.Table
        (
            new Enum[]
            {
                new Enum("Dollars", INT_DOLLARS),
                new Enum("Euros", INT_EUROS),
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
        public static org.bimserver.cobie.cobielite.FacilityCurrencyUnitEnumerationType newValue(java.lang.Object obj) {
          return (org.bimserver.cobie.cobielite.FacilityCurrencyUnitEnumerationType) type.newValue( obj ); }
        
        public static org.bimserver.cobie.cobielite.FacilityCurrencyUnitEnumerationType newInstance() {
          return (org.bimserver.cobie.cobielite.FacilityCurrencyUnitEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static org.bimserver.cobie.cobielite.FacilityCurrencyUnitEnumerationType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (org.bimserver.cobie.cobielite.FacilityCurrencyUnitEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static org.bimserver.cobie.cobielite.FacilityCurrencyUnitEnumerationType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (org.bimserver.cobie.cobielite.FacilityCurrencyUnitEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static org.bimserver.cobie.cobielite.FacilityCurrencyUnitEnumerationType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.bimserver.cobie.cobielite.FacilityCurrencyUnitEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static org.bimserver.cobie.cobielite.FacilityCurrencyUnitEnumerationType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bimserver.cobie.cobielite.FacilityCurrencyUnitEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static org.bimserver.cobie.cobielite.FacilityCurrencyUnitEnumerationType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bimserver.cobie.cobielite.FacilityCurrencyUnitEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static org.bimserver.cobie.cobielite.FacilityCurrencyUnitEnumerationType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bimserver.cobie.cobielite.FacilityCurrencyUnitEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static org.bimserver.cobie.cobielite.FacilityCurrencyUnitEnumerationType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bimserver.cobie.cobielite.FacilityCurrencyUnitEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static org.bimserver.cobie.cobielite.FacilityCurrencyUnitEnumerationType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bimserver.cobie.cobielite.FacilityCurrencyUnitEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static org.bimserver.cobie.cobielite.FacilityCurrencyUnitEnumerationType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bimserver.cobie.cobielite.FacilityCurrencyUnitEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static org.bimserver.cobie.cobielite.FacilityCurrencyUnitEnumerationType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bimserver.cobie.cobielite.FacilityCurrencyUnitEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static org.bimserver.cobie.cobielite.FacilityCurrencyUnitEnumerationType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bimserver.cobie.cobielite.FacilityCurrencyUnitEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static org.bimserver.cobie.cobielite.FacilityCurrencyUnitEnumerationType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (org.bimserver.cobie.cobielite.FacilityCurrencyUnitEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static org.bimserver.cobie.cobielite.FacilityCurrencyUnitEnumerationType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.bimserver.cobie.cobielite.FacilityCurrencyUnitEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static org.bimserver.cobie.cobielite.FacilityCurrencyUnitEnumerationType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (org.bimserver.cobie.cobielite.FacilityCurrencyUnitEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static org.bimserver.cobie.cobielite.FacilityCurrencyUnitEnumerationType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.bimserver.cobie.cobielite.FacilityCurrencyUnitEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.bimserver.cobie.cobielite.FacilityCurrencyUnitEnumerationType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.bimserver.cobie.cobielite.FacilityCurrencyUnitEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.bimserver.cobie.cobielite.FacilityCurrencyUnitEnumerationType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.bimserver.cobie.cobielite.FacilityCurrencyUnitEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
