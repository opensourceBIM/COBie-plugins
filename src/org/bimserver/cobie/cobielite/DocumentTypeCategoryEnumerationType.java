/*
 * XML Type:  DocumentTypeCategoryEnumerationType
 * Namespace: cobielite.cobie.bimserver.org
 * Java type: org.bimserver.cobie.cobielite.DocumentTypeCategoryEnumerationType
 *
 * Automatically generated - do not modify.
 */
package org.bimserver.cobie.cobielite;


/**
 * An XML DocumentTypeCategoryEnumerationType(@cobielite.cobie.bimserver.org).
 *
 * This is an atomic type that is a restriction of org.bimserver.cobie.cobielite.DocumentTypeCategoryEnumerationType.
 */
public interface DocumentTypeCategoryEnumerationType extends org.apache.xmlbeans.XmlString
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(DocumentTypeCategoryEnumerationType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9940D605A2AF1A0035EAACACA75B5274").resolveHandle("documenttypecategoryenumerationtype199atype");
    
    org.apache.xmlbeans.StringEnumAbstractBase enumValue();
    void set(org.apache.xmlbeans.StringEnumAbstractBase e);
    
    static final Enum PRECONSTRUCTION_SUBMITTALS = Enum.forString("Preconstruction Submittals");
    static final Enum SHOP_DRAWINGS = Enum.forString("Shop Drawings");
    static final Enum PRODUCT_DATA = Enum.forString("Product Data");
    static final Enum SAMPLES = Enum.forString("Samples");
    static final Enum DESIGN_DATA = Enum.forString("Design Data");
    static final Enum TEST_REPORTS = Enum.forString("Test Reports");
    static final Enum CERTIFICATES = Enum.forString("Certificates");
    static final Enum MANUFACTURER_INSTRUCTIONS = Enum.forString("Manufacturer Instructions");
    static final Enum MANUFACTURER_FIELD_REPORTS = Enum.forString("Manufacturer Field Reports");
    static final Enum OPERATION_AND_MAINTENANCE = Enum.forString("Operation and Maintenance");
    static final Enum CLOSEOUT_SUBMITTALS = Enum.forString("Closeout Submittals");
    static final Enum CONTRACT_DRAWINGS = Enum.forString("Contract Drawings");
    static final Enum DESIGN_REVIEW_COMMENT = Enum.forString("Design Review Comment");
    static final Enum SPECIFICATIONS = Enum.forString("Specifications");
    static final Enum REQUEST_FOR_INFORMATION = Enum.forString("Request for Information");
    static final Enum CLIENT_REQUIREMENTS = Enum.forString("Client Requirements");
    static final Enum CONTRACT_SPECIFICATIONS = Enum.forString("Contract Specifications");
    static final Enum REQUESTS_FOR_INFORMATION = Enum.forString("Requests for Information");
    static final Enum CONTRACT_MODIFICATIONS = Enum.forString("Contract Modifications");
    static final Enum PUNCH_LIST_ITEMS = Enum.forString("Punch List Items");
    
    static final int INT_PRECONSTRUCTION_SUBMITTALS = Enum.INT_PRECONSTRUCTION_SUBMITTALS;
    static final int INT_SHOP_DRAWINGS = Enum.INT_SHOP_DRAWINGS;
    static final int INT_PRODUCT_DATA = Enum.INT_PRODUCT_DATA;
    static final int INT_SAMPLES = Enum.INT_SAMPLES;
    static final int INT_DESIGN_DATA = Enum.INT_DESIGN_DATA;
    static final int INT_TEST_REPORTS = Enum.INT_TEST_REPORTS;
    static final int INT_CERTIFICATES = Enum.INT_CERTIFICATES;
    static final int INT_MANUFACTURER_INSTRUCTIONS = Enum.INT_MANUFACTURER_INSTRUCTIONS;
    static final int INT_MANUFACTURER_FIELD_REPORTS = Enum.INT_MANUFACTURER_FIELD_REPORTS;
    static final int INT_OPERATION_AND_MAINTENANCE = Enum.INT_OPERATION_AND_MAINTENANCE;
    static final int INT_CLOSEOUT_SUBMITTALS = Enum.INT_CLOSEOUT_SUBMITTALS;
    static final int INT_DESIGN_REVIEW_COMMENT = Enum.INT_DESIGN_REVIEW_COMMENT;
    static final int INT_SPECIFICATIONS = Enum.INT_SPECIFICATIONS;
    static final int INT_REQUEST_FOR_INFORMATION = Enum.INT_REQUEST_FOR_INFORMATION;
    static final int INT_CLIENT_REQUIREMENTS = Enum.INT_CLIENT_REQUIREMENTS;
    static final int INT_CONTRACT_SPECIFICATIONS = Enum.INT_CONTRACT_SPECIFICATIONS;
    static final int INT_REQUESTS_FOR_INFORMATION = Enum.INT_REQUESTS_FOR_INFORMATION;
    static final int INT_CONTRACT_MODIFICATIONS = Enum.INT_CONTRACT_MODIFICATIONS;
    static final int INT_PUNCH_LIST_ITEMS = Enum.INT_PUNCH_LIST_ITEMS;
    
    /**
     * Enumeration value class for org.bimserver.cobie.cobielite.DocumentTypeCategoryEnumerationType.
     * These enum values can be used as follows:
     * <pre>
     * enum.toString(); // returns the string value of the enum
     * enum.intValue(); // returns an int value, useful for switches
     * // e.g., case Enum.INT_PRECONSTRUCTION_SUBMITTALS
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
        
        static final int INT_PRECONSTRUCTION_SUBMITTALS = 1;
        static final int INT_SHOP_DRAWINGS = 2;
        static final int INT_PRODUCT_DATA = 3;
        static final int INT_SAMPLES = 4;
        static final int INT_DESIGN_DATA = 5;
        static final int INT_TEST_REPORTS = 6;
        static final int INT_CERTIFICATES = 7;
        static final int INT_MANUFACTURER_INSTRUCTIONS = 8;
        static final int INT_MANUFACTURER_FIELD_REPORTS = 9;
        static final int INT_OPERATION_AND_MAINTENANCE = 10;
        static final int INT_CLOSEOUT_SUBMITTALS = 11;
        static final int INT_CONTRACT_DRAWINGS = 12;
        static final int INT_DESIGN_REVIEW_COMMENT = 13;
        static final int INT_SPECIFICATIONS = 14;
        static final int INT_REQUEST_FOR_INFORMATION = 15;
        static final int INT_CLIENT_REQUIREMENTS = 16;
        static final int INT_CONTRACT_SPECIFICATIONS = 17;
        static final int INT_CONTRACT_DRAWINGS_2 = 18;
        static final int INT_REQUESTS_FOR_INFORMATION = 19;
        static final int INT_CONTRACT_MODIFICATIONS = 20;
        static final int INT_PUNCH_LIST_ITEMS = 21;
        
        public static final org.apache.xmlbeans.StringEnumAbstractBase.Table table =
            new org.apache.xmlbeans.StringEnumAbstractBase.Table
        (
            new Enum[]
            {
                new Enum("Preconstruction Submittals", INT_PRECONSTRUCTION_SUBMITTALS),
                new Enum("Shop Drawings", INT_SHOP_DRAWINGS),
                new Enum("Product Data", INT_PRODUCT_DATA),
                new Enum("Samples", INT_SAMPLES),
                new Enum("Design Data", INT_DESIGN_DATA),
                new Enum("Test Reports", INT_TEST_REPORTS),
                new Enum("Certificates", INT_CERTIFICATES),
                new Enum("Manufacturer Instructions", INT_MANUFACTURER_INSTRUCTIONS),
                new Enum("Manufacturer Field Reports", INT_MANUFACTURER_FIELD_REPORTS),
                new Enum("Operation and Maintenance", INT_OPERATION_AND_MAINTENANCE),
                new Enum("Closeout Submittals", INT_CLOSEOUT_SUBMITTALS),
                new Enum("Contract Drawings", INT_CONTRACT_DRAWINGS),
                new Enum("Design Review Comment", INT_DESIGN_REVIEW_COMMENT),
                new Enum("Specifications", INT_SPECIFICATIONS),
                new Enum("Request for Information", INT_REQUEST_FOR_INFORMATION),
                new Enum("Client Requirements", INT_CLIENT_REQUIREMENTS),
                new Enum("Contract Specifications", INT_CONTRACT_SPECIFICATIONS),
                new Enum("Contract Drawings", INT_CONTRACT_DRAWINGS_2),
                new Enum("Requests for Information", INT_REQUESTS_FOR_INFORMATION),
                new Enum("Contract Modifications", INT_CONTRACT_MODIFICATIONS),
                new Enum("Punch List Items", INT_PUNCH_LIST_ITEMS),
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
        public static org.bimserver.cobie.cobielite.DocumentTypeCategoryEnumerationType newValue(java.lang.Object obj) {
          return (org.bimserver.cobie.cobielite.DocumentTypeCategoryEnumerationType) type.newValue( obj ); }
        
        public static org.bimserver.cobie.cobielite.DocumentTypeCategoryEnumerationType newInstance() {
          return (org.bimserver.cobie.cobielite.DocumentTypeCategoryEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static org.bimserver.cobie.cobielite.DocumentTypeCategoryEnumerationType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (org.bimserver.cobie.cobielite.DocumentTypeCategoryEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static org.bimserver.cobie.cobielite.DocumentTypeCategoryEnumerationType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (org.bimserver.cobie.cobielite.DocumentTypeCategoryEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static org.bimserver.cobie.cobielite.DocumentTypeCategoryEnumerationType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.bimserver.cobie.cobielite.DocumentTypeCategoryEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static org.bimserver.cobie.cobielite.DocumentTypeCategoryEnumerationType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bimserver.cobie.cobielite.DocumentTypeCategoryEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static org.bimserver.cobie.cobielite.DocumentTypeCategoryEnumerationType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bimserver.cobie.cobielite.DocumentTypeCategoryEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static org.bimserver.cobie.cobielite.DocumentTypeCategoryEnumerationType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bimserver.cobie.cobielite.DocumentTypeCategoryEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static org.bimserver.cobie.cobielite.DocumentTypeCategoryEnumerationType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bimserver.cobie.cobielite.DocumentTypeCategoryEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static org.bimserver.cobie.cobielite.DocumentTypeCategoryEnumerationType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bimserver.cobie.cobielite.DocumentTypeCategoryEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static org.bimserver.cobie.cobielite.DocumentTypeCategoryEnumerationType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bimserver.cobie.cobielite.DocumentTypeCategoryEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static org.bimserver.cobie.cobielite.DocumentTypeCategoryEnumerationType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bimserver.cobie.cobielite.DocumentTypeCategoryEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static org.bimserver.cobie.cobielite.DocumentTypeCategoryEnumerationType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bimserver.cobie.cobielite.DocumentTypeCategoryEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static org.bimserver.cobie.cobielite.DocumentTypeCategoryEnumerationType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (org.bimserver.cobie.cobielite.DocumentTypeCategoryEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static org.bimserver.cobie.cobielite.DocumentTypeCategoryEnumerationType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.bimserver.cobie.cobielite.DocumentTypeCategoryEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static org.bimserver.cobie.cobielite.DocumentTypeCategoryEnumerationType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (org.bimserver.cobie.cobielite.DocumentTypeCategoryEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static org.bimserver.cobie.cobielite.DocumentTypeCategoryEnumerationType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.bimserver.cobie.cobielite.DocumentTypeCategoryEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.bimserver.cobie.cobielite.DocumentTypeCategoryEnumerationType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.bimserver.cobie.cobielite.DocumentTypeCategoryEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.bimserver.cobie.cobielite.DocumentTypeCategoryEnumerationType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.bimserver.cobie.cobielite.DocumentTypeCategoryEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
