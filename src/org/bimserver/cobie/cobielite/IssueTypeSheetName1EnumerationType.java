/*
 * XML Type:  IssueTypeSheetName1EnumerationType
 * Namespace: cobielite.cobie.bimserver.org
 * Java type: org.bimserver.cobie.cobielite.IssueTypeSheetName1EnumerationType
 *
 * Automatically generated - do not modify.
 */
package org.bimserver.cobie.cobielite;


/**
 * An XML IssueTypeSheetName1EnumerationType(@cobielite.cobie.bimserver.org).
 *
 * This is an atomic type that is a restriction of org.bimserver.cobie.cobielite.IssueTypeSheetName1EnumerationType.
 */
public interface IssueTypeSheetName1EnumerationType extends org.apache.xmlbeans.XmlString
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(IssueTypeSheetName1EnumerationType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9940D605A2AF1A0035EAACACA75B5274").resolveHandle("issuetypesheetname1enumerationtypeaf05type");
    
    org.apache.xmlbeans.StringEnumAbstractBase enumValue();
    void set(org.apache.xmlbeans.StringEnumAbstractBase e);
    
    static final Enum ATTRIBUTE = Enum.forString("Attribute");
    static final Enum COMPONENT = Enum.forString("Component");
    static final Enum CONNECTION = Enum.forString("Connection");
    static final Enum COORDINATE = Enum.forString("Coordinate");
    static final Enum DOCUMENT = Enum.forString("Document");
    static final Enum FACILITY = Enum.forString("Facility");
    static final Enum FLOOR = Enum.forString("Floor");
    static final Enum ISSUE = Enum.forString("Issue");
    static final Enum JOB = Enum.forString("Job");
    static final Enum RESOURCE = Enum.forString("Resource");
    static final Enum SPACE = Enum.forString("Space");
    static final Enum SPARE = Enum.forString("Spare");
    static final Enum SYSTEM = Enum.forString("System");
    static final Enum TYPE = Enum.forString("Type");
    static final Enum ZONE = Enum.forString("Zone");
    
    static final int INT_ATTRIBUTE = Enum.INT_ATTRIBUTE;
    static final int INT_COMPONENT = Enum.INT_COMPONENT;
    static final int INT_CONNECTION = Enum.INT_CONNECTION;
    static final int INT_COORDINATE = Enum.INT_COORDINATE;
    static final int INT_DOCUMENT = Enum.INT_DOCUMENT;
    static final int INT_FACILITY = Enum.INT_FACILITY;
    static final int INT_FLOOR = Enum.INT_FLOOR;
    static final int INT_ISSUE = Enum.INT_ISSUE;
    static final int INT_JOB = Enum.INT_JOB;
    static final int INT_RESOURCE = Enum.INT_RESOURCE;
    static final int INT_SPACE = Enum.INT_SPACE;
    static final int INT_SPARE = Enum.INT_SPARE;
    static final int INT_SYSTEM = Enum.INT_SYSTEM;
    static final int INT_TYPE = Enum.INT_TYPE;
    static final int INT_ZONE = Enum.INT_ZONE;
    
    /**
     * Enumeration value class for org.bimserver.cobie.cobielite.IssueTypeSheetName1EnumerationType.
     * These enum values can be used as follows:
     * <pre>
     * enum.toString(); // returns the string value of the enum
     * enum.intValue(); // returns an int value, useful for switches
     * // e.g., case Enum.INT_ATTRIBUTE
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
        
        static final int INT_ATTRIBUTE = 1;
        static final int INT_COMPONENT = 2;
        static final int INT_CONNECTION = 3;
        static final int INT_COORDINATE = 4;
        static final int INT_DOCUMENT = 5;
        static final int INT_FACILITY = 6;
        static final int INT_FLOOR = 7;
        static final int INT_ISSUE = 8;
        static final int INT_JOB = 9;
        static final int INT_RESOURCE = 10;
        static final int INT_SPACE = 11;
        static final int INT_SPARE = 12;
        static final int INT_SYSTEM = 13;
        static final int INT_TYPE = 14;
        static final int INT_ZONE = 15;
        
        public static final org.apache.xmlbeans.StringEnumAbstractBase.Table table =
            new org.apache.xmlbeans.StringEnumAbstractBase.Table
        (
            new Enum[]
            {
                new Enum("Attribute", INT_ATTRIBUTE),
                new Enum("Component", INT_COMPONENT),
                new Enum("Connection", INT_CONNECTION),
                new Enum("Coordinate", INT_COORDINATE),
                new Enum("Document", INT_DOCUMENT),
                new Enum("Facility", INT_FACILITY),
                new Enum("Floor", INT_FLOOR),
                new Enum("Issue", INT_ISSUE),
                new Enum("Job", INT_JOB),
                new Enum("Resource", INT_RESOURCE),
                new Enum("Space", INT_SPACE),
                new Enum("Spare", INT_SPARE),
                new Enum("System", INT_SYSTEM),
                new Enum("Type", INT_TYPE),
                new Enum("Zone", INT_ZONE),
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
        public static org.bimserver.cobie.cobielite.IssueTypeSheetName1EnumerationType newValue(java.lang.Object obj) {
          return (org.bimserver.cobie.cobielite.IssueTypeSheetName1EnumerationType) type.newValue( obj ); }
        
        public static org.bimserver.cobie.cobielite.IssueTypeSheetName1EnumerationType newInstance() {
          return (org.bimserver.cobie.cobielite.IssueTypeSheetName1EnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static org.bimserver.cobie.cobielite.IssueTypeSheetName1EnumerationType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (org.bimserver.cobie.cobielite.IssueTypeSheetName1EnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static org.bimserver.cobie.cobielite.IssueTypeSheetName1EnumerationType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (org.bimserver.cobie.cobielite.IssueTypeSheetName1EnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static org.bimserver.cobie.cobielite.IssueTypeSheetName1EnumerationType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.bimserver.cobie.cobielite.IssueTypeSheetName1EnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static org.bimserver.cobie.cobielite.IssueTypeSheetName1EnumerationType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bimserver.cobie.cobielite.IssueTypeSheetName1EnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static org.bimserver.cobie.cobielite.IssueTypeSheetName1EnumerationType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bimserver.cobie.cobielite.IssueTypeSheetName1EnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static org.bimserver.cobie.cobielite.IssueTypeSheetName1EnumerationType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bimserver.cobie.cobielite.IssueTypeSheetName1EnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static org.bimserver.cobie.cobielite.IssueTypeSheetName1EnumerationType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bimserver.cobie.cobielite.IssueTypeSheetName1EnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static org.bimserver.cobie.cobielite.IssueTypeSheetName1EnumerationType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bimserver.cobie.cobielite.IssueTypeSheetName1EnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static org.bimserver.cobie.cobielite.IssueTypeSheetName1EnumerationType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bimserver.cobie.cobielite.IssueTypeSheetName1EnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static org.bimserver.cobie.cobielite.IssueTypeSheetName1EnumerationType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bimserver.cobie.cobielite.IssueTypeSheetName1EnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static org.bimserver.cobie.cobielite.IssueTypeSheetName1EnumerationType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bimserver.cobie.cobielite.IssueTypeSheetName1EnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static org.bimserver.cobie.cobielite.IssueTypeSheetName1EnumerationType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (org.bimserver.cobie.cobielite.IssueTypeSheetName1EnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static org.bimserver.cobie.cobielite.IssueTypeSheetName1EnumerationType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.bimserver.cobie.cobielite.IssueTypeSheetName1EnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static org.bimserver.cobie.cobielite.IssueTypeSheetName1EnumerationType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (org.bimserver.cobie.cobielite.IssueTypeSheetName1EnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static org.bimserver.cobie.cobielite.IssueTypeSheetName1EnumerationType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.bimserver.cobie.cobielite.IssueTypeSheetName1EnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.bimserver.cobie.cobielite.IssueTypeSheetName1EnumerationType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.bimserver.cobie.cobielite.IssueTypeSheetName1EnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.bimserver.cobie.cobielite.IssueTypeSheetName1EnumerationType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.bimserver.cobie.cobielite.IssueTypeSheetName1EnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
