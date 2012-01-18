/*
 * XML Type:  ImpactTypeImpactStageEnumerationType
 * Namespace: cobieLite
 * Java type: cobieLite.ImpactTypeImpactStageEnumerationType
 *
 * Automatically generated - do not modify.
 */
package cobieLite;


/**
 * An XML ImpactTypeImpactStageEnumerationType(@cobieLite).
 *
 * This is an atomic type that is a restriction of cobieLite.ImpactTypeImpactStageEnumerationType.
 */
public interface ImpactTypeImpactStageEnumerationType extends org.apache.xmlbeans.XmlString
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ImpactTypeImpactStageEnumerationType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s3A84CE08177E9EC2022DBEA3D9A338ED").resolveHandle("impacttypeimpactstageenumerationtype3392type");
    
    org.apache.xmlbeans.StringEnumAbstractBase enumValue();
    void set(org.apache.xmlbeans.StringEnumAbstractBase e);
    
    static final Enum PRODUCTION = Enum.forString("Production");
    static final Enum INSTALLATION = Enum.forString("Installation");
    static final Enum MAINTENANCE = Enum.forString("Maintenance");
    static final Enum REPLACEMENT = Enum.forString("Replacement");
    static final Enum USE = Enum.forString("Use");
    static final Enum REUSE = Enum.forString("Reuse");
    
    static final int INT_PRODUCTION = Enum.INT_PRODUCTION;
    static final int INT_INSTALLATION = Enum.INT_INSTALLATION;
    static final int INT_MAINTENANCE = Enum.INT_MAINTENANCE;
    static final int INT_REPLACEMENT = Enum.INT_REPLACEMENT;
    static final int INT_USE = Enum.INT_USE;
    static final int INT_REUSE = Enum.INT_REUSE;
    
    /**
     * Enumeration value class for cobieLite.ImpactTypeImpactStageEnumerationType.
     * These enum values can be used as follows:
     * <pre>
     * enum.toString(); // returns the string value of the enum
     * enum.intValue(); // returns an int value, useful for switches
     * // e.g., case Enum.INT_PRODUCTION
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
        
        static final int INT_PRODUCTION = 1;
        static final int INT_INSTALLATION = 2;
        static final int INT_MAINTENANCE = 3;
        static final int INT_REPLACEMENT = 4;
        static final int INT_USE = 5;
        static final int INT_REUSE = 6;
        
        public static final org.apache.xmlbeans.StringEnumAbstractBase.Table table =
            new org.apache.xmlbeans.StringEnumAbstractBase.Table
        (
            new Enum[]
            {
                new Enum("Production", INT_PRODUCTION),
                new Enum("Installation", INT_INSTALLATION),
                new Enum("Maintenance", INT_MAINTENANCE),
                new Enum("Replacement", INT_REPLACEMENT),
                new Enum("Use", INT_USE),
                new Enum("Reuse", INT_REUSE),
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
        public static cobieLite.ImpactTypeImpactStageEnumerationType newValue(java.lang.Object obj) {
          return (cobieLite.ImpactTypeImpactStageEnumerationType) type.newValue( obj ); }
        
        public static cobieLite.ImpactTypeImpactStageEnumerationType newInstance() {
          return (cobieLite.ImpactTypeImpactStageEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static cobieLite.ImpactTypeImpactStageEnumerationType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (cobieLite.ImpactTypeImpactStageEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static cobieLite.ImpactTypeImpactStageEnumerationType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (cobieLite.ImpactTypeImpactStageEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static cobieLite.ImpactTypeImpactStageEnumerationType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (cobieLite.ImpactTypeImpactStageEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static cobieLite.ImpactTypeImpactStageEnumerationType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cobieLite.ImpactTypeImpactStageEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static cobieLite.ImpactTypeImpactStageEnumerationType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cobieLite.ImpactTypeImpactStageEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static cobieLite.ImpactTypeImpactStageEnumerationType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cobieLite.ImpactTypeImpactStageEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static cobieLite.ImpactTypeImpactStageEnumerationType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cobieLite.ImpactTypeImpactStageEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static cobieLite.ImpactTypeImpactStageEnumerationType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cobieLite.ImpactTypeImpactStageEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static cobieLite.ImpactTypeImpactStageEnumerationType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cobieLite.ImpactTypeImpactStageEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static cobieLite.ImpactTypeImpactStageEnumerationType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cobieLite.ImpactTypeImpactStageEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static cobieLite.ImpactTypeImpactStageEnumerationType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cobieLite.ImpactTypeImpactStageEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static cobieLite.ImpactTypeImpactStageEnumerationType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (cobieLite.ImpactTypeImpactStageEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static cobieLite.ImpactTypeImpactStageEnumerationType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (cobieLite.ImpactTypeImpactStageEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static cobieLite.ImpactTypeImpactStageEnumerationType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (cobieLite.ImpactTypeImpactStageEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static cobieLite.ImpactTypeImpactStageEnumerationType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (cobieLite.ImpactTypeImpactStageEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static cobieLite.ImpactTypeImpactStageEnumerationType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (cobieLite.ImpactTypeImpactStageEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static cobieLite.ImpactTypeImpactStageEnumerationType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (cobieLite.ImpactTypeImpactStageEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
