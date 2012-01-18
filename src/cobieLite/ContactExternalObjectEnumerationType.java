/*
 * XML Type:  ContactExternalObjectEnumerationType
 * Namespace: cobieLite
 * Java type: cobieLite.ContactExternalObjectEnumerationType
 *
 * Automatically generated - do not modify.
 */
package cobieLite;


/**
 * An XML ContactExternalObjectEnumerationType(@cobieLite).
 *
 * This is an atomic type that is a restriction of cobieLite.ContactExternalObjectEnumerationType.
 */
public interface ContactExternalObjectEnumerationType extends org.apache.xmlbeans.XmlString
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ContactExternalObjectEnumerationType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s3A84CE08177E9EC2022DBEA3D9A338ED").resolveHandle("contactexternalobjectenumerationtype3c40type");
    
    org.apache.xmlbeans.StringEnumAbstractBase enumValue();
    void set(org.apache.xmlbeans.StringEnumAbstractBase e);
    
    static final Enum OBJ_CONTACT = Enum.forString("objContact");
    static final Enum IFC_ORGANIZATION = Enum.forString("IfcOrganization");
    static final Enum IFC_PERSON = Enum.forString("IfcPerson");
    static final Enum IFC_PERSON_AND_ORGANIZATION = Enum.forString("IfcPersonAndOrganization");
    
    static final int INT_OBJ_CONTACT = Enum.INT_OBJ_CONTACT;
    static final int INT_IFC_ORGANIZATION = Enum.INT_IFC_ORGANIZATION;
    static final int INT_IFC_PERSON = Enum.INT_IFC_PERSON;
    static final int INT_IFC_PERSON_AND_ORGANIZATION = Enum.INT_IFC_PERSON_AND_ORGANIZATION;
    
    /**
     * Enumeration value class for cobieLite.ContactExternalObjectEnumerationType.
     * These enum values can be used as follows:
     * <pre>
     * enum.toString(); // returns the string value of the enum
     * enum.intValue(); // returns an int value, useful for switches
     * // e.g., case Enum.INT_OBJ_CONTACT
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
        
        static final int INT_OBJ_CONTACT = 1;
        static final int INT_IFC_ORGANIZATION = 2;
        static final int INT_IFC_PERSON = 3;
        static final int INT_IFC_PERSON_AND_ORGANIZATION = 4;
        
        public static final org.apache.xmlbeans.StringEnumAbstractBase.Table table =
            new org.apache.xmlbeans.StringEnumAbstractBase.Table
        (
            new Enum[]
            {
                new Enum("objContact", INT_OBJ_CONTACT),
                new Enum("IfcOrganization", INT_IFC_ORGANIZATION),
                new Enum("IfcPerson", INT_IFC_PERSON),
                new Enum("IfcPersonAndOrganization", INT_IFC_PERSON_AND_ORGANIZATION),
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
        public static cobieLite.ContactExternalObjectEnumerationType newValue(java.lang.Object obj) {
          return (cobieLite.ContactExternalObjectEnumerationType) type.newValue( obj ); }
        
        public static cobieLite.ContactExternalObjectEnumerationType newInstance() {
          return (cobieLite.ContactExternalObjectEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static cobieLite.ContactExternalObjectEnumerationType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (cobieLite.ContactExternalObjectEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static cobieLite.ContactExternalObjectEnumerationType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (cobieLite.ContactExternalObjectEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static cobieLite.ContactExternalObjectEnumerationType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (cobieLite.ContactExternalObjectEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static cobieLite.ContactExternalObjectEnumerationType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cobieLite.ContactExternalObjectEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static cobieLite.ContactExternalObjectEnumerationType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cobieLite.ContactExternalObjectEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static cobieLite.ContactExternalObjectEnumerationType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cobieLite.ContactExternalObjectEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static cobieLite.ContactExternalObjectEnumerationType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cobieLite.ContactExternalObjectEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static cobieLite.ContactExternalObjectEnumerationType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cobieLite.ContactExternalObjectEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static cobieLite.ContactExternalObjectEnumerationType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cobieLite.ContactExternalObjectEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static cobieLite.ContactExternalObjectEnumerationType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cobieLite.ContactExternalObjectEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static cobieLite.ContactExternalObjectEnumerationType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cobieLite.ContactExternalObjectEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static cobieLite.ContactExternalObjectEnumerationType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (cobieLite.ContactExternalObjectEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static cobieLite.ContactExternalObjectEnumerationType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (cobieLite.ContactExternalObjectEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static cobieLite.ContactExternalObjectEnumerationType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (cobieLite.ContactExternalObjectEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static cobieLite.ContactExternalObjectEnumerationType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (cobieLite.ContactExternalObjectEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static cobieLite.ContactExternalObjectEnumerationType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (cobieLite.ContactExternalObjectEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static cobieLite.ContactExternalObjectEnumerationType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (cobieLite.ContactExternalObjectEnumerationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
