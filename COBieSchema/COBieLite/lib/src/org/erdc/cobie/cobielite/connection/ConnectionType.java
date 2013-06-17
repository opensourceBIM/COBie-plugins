/*
 * XML Type:  ConnectionType
 * Namespace: http://connection.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.connection.ConnectionType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.connection;


/**
 * An XML ConnectionType(@http://connection.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public interface ConnectionType extends org.erdc.cobie.cobielite.core.ConnectionType
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ConnectionType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s66652C141B24B73BD4333B57A0EF7E00").resolveHandle("connectiontypec589type");
    
    /**
     * Gets the "ConnectionAsset1Name" element
     */
    java.lang.String getConnectionAsset1Name();
    
    /**
     * Gets (as xml) the "ConnectionAsset1Name" element
     */
    org.erdc.cobie.cobielite.core.CobieNameSimpleType xgetConnectionAsset1Name();
    
    /**
     * True if has "ConnectionAsset1Name" element
     */
    boolean isSetConnectionAsset1Name();
    
    /**
     * Sets the "ConnectionAsset1Name" element
     */
    void setConnectionAsset1Name(java.lang.String connectionAsset1Name);
    
    /**
     * Sets (as xml) the "ConnectionAsset1Name" element
     */
    void xsetConnectionAsset1Name(org.erdc.cobie.cobielite.core.CobieNameSimpleType connectionAsset1Name);
    
    /**
     * Unsets the "ConnectionAsset1Name" element
     */
    void unsetConnectionAsset1Name();
    
    /**
     * Gets the "ConnectionAsset1PortName" element
     */
    java.lang.String getConnectionAsset1PortName();
    
    /**
     * Gets (as xml) the "ConnectionAsset1PortName" element
     */
    org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetConnectionAsset1PortName();
    
    /**
     * True if has "ConnectionAsset1PortName" element
     */
    boolean isSetConnectionAsset1PortName();
    
    /**
     * Sets the "ConnectionAsset1PortName" element
     */
    void setConnectionAsset1PortName(java.lang.String connectionAsset1PortName);
    
    /**
     * Sets (as xml) the "ConnectionAsset1PortName" element
     */
    void xsetConnectionAsset1PortName(org.erdc.cobie.cobielite.core.CobieTextSimpleType connectionAsset1PortName);
    
    /**
     * Unsets the "ConnectionAsset1PortName" element
     */
    void unsetConnectionAsset1PortName();
    
    /**
     * Gets the "ConnectionAsset2Name" element
     */
    java.lang.String getConnectionAsset2Name();
    
    /**
     * Gets (as xml) the "ConnectionAsset2Name" element
     */
    org.erdc.cobie.cobielite.core.CobieNameSimpleType xgetConnectionAsset2Name();
    
    /**
     * True if has "ConnectionAsset2Name" element
     */
    boolean isSetConnectionAsset2Name();
    
    /**
     * Sets the "ConnectionAsset2Name" element
     */
    void setConnectionAsset2Name(java.lang.String connectionAsset2Name);
    
    /**
     * Sets (as xml) the "ConnectionAsset2Name" element
     */
    void xsetConnectionAsset2Name(org.erdc.cobie.cobielite.core.CobieNameSimpleType connectionAsset2Name);
    
    /**
     * Unsets the "ConnectionAsset2Name" element
     */
    void unsetConnectionAsset2Name();
    
    /**
     * Gets the "ConnectionAsset2PortName" element
     */
    java.lang.String getConnectionAsset2PortName();
    
    /**
     * Gets (as xml) the "ConnectionAsset2PortName" element
     */
    org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetConnectionAsset2PortName();
    
    /**
     * True if has "ConnectionAsset2PortName" element
     */
    boolean isSetConnectionAsset2PortName();
    
    /**
     * Sets the "ConnectionAsset2PortName" element
     */
    void setConnectionAsset2PortName(java.lang.String connectionAsset2PortName);
    
    /**
     * Sets (as xml) the "ConnectionAsset2PortName" element
     */
    void xsetConnectionAsset2PortName(org.erdc.cobie.cobielite.core.CobieTextSimpleType connectionAsset2PortName);
    
    /**
     * Unsets the "ConnectionAsset2PortName" element
     */
    void unsetConnectionAsset2PortName();
    
    /**
     * Gets the "ConnectionDescription" element
     */
    java.lang.String getConnectionDescription();
    
    /**
     * Gets (as xml) the "ConnectionDescription" element
     */
    org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType xgetConnectionDescription();
    
    /**
     * True if has "ConnectionDescription" element
     */
    boolean isSetConnectionDescription();
    
    /**
     * Sets the "ConnectionDescription" element
     */
    void setConnectionDescription(java.lang.String connectionDescription);
    
    /**
     * Sets (as xml) the "ConnectionDescription" element
     */
    void xsetConnectionDescription(org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType connectionDescription);
    
    /**
     * Unsets the "ConnectionDescription" element
     */
    void unsetConnectionDescription();
    
    /**
     * Gets the "ConnectionAttributes" element
     */
    org.erdc.cobie.cobielite.core.AttributeCollectionType getConnectionAttributes();
    
    /**
     * True if has "ConnectionAttributes" element
     */
    boolean isSetConnectionAttributes();
    
    /**
     * Sets the "ConnectionAttributes" element
     */
    void setConnectionAttributes(org.erdc.cobie.cobielite.core.AttributeCollectionType connectionAttributes);
    
    /**
     * Appends and returns a new empty "ConnectionAttributes" element
     */
    org.erdc.cobie.cobielite.core.AttributeCollectionType addNewConnectionAttributes();
    
    /**
     * Unsets the "ConnectionAttributes" element
     */
    void unsetConnectionAttributes();
    
    /**
     * Gets the "ConnectionDocuments" element
     */
    org.erdc.cobie.cobielite.core.DocumentCollectionType getConnectionDocuments();
    
    /**
     * True if has "ConnectionDocuments" element
     */
    boolean isSetConnectionDocuments();
    
    /**
     * Sets the "ConnectionDocuments" element
     */
    void setConnectionDocuments(org.erdc.cobie.cobielite.core.DocumentCollectionType connectionDocuments);
    
    /**
     * Appends and returns a new empty "ConnectionDocuments" element
     */
    org.erdc.cobie.cobielite.core.DocumentCollectionType addNewConnectionDocuments();
    
    /**
     * Unsets the "ConnectionDocuments" element
     */
    void unsetConnectionDocuments();
    
    /**
     * Gets the "ConnectionIssues" element
     */
    org.erdc.cobie.cobielite.core.IssueCollectionType getConnectionIssues();
    
    /**
     * True if has "ConnectionIssues" element
     */
    boolean isSetConnectionIssues();
    
    /**
     * Sets the "ConnectionIssues" element
     */
    void setConnectionIssues(org.erdc.cobie.cobielite.core.IssueCollectionType connectionIssues);
    
    /**
     * Appends and returns a new empty "ConnectionIssues" element
     */
    org.erdc.cobie.cobielite.core.IssueCollectionType addNewConnectionIssues();
    
    /**
     * Unsets the "ConnectionIssues" element
     */
    void unsetConnectionIssues();
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static org.erdc.cobie.cobielite.connection.ConnectionType newInstance() {
          return (org.erdc.cobie.cobielite.connection.ConnectionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static org.erdc.cobie.cobielite.connection.ConnectionType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (org.erdc.cobie.cobielite.connection.ConnectionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static org.erdc.cobie.cobielite.connection.ConnectionType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.connection.ConnectionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static org.erdc.cobie.cobielite.connection.ConnectionType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.connection.ConnectionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static org.erdc.cobie.cobielite.connection.ConnectionType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.connection.ConnectionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static org.erdc.cobie.cobielite.connection.ConnectionType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.connection.ConnectionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static org.erdc.cobie.cobielite.connection.ConnectionType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.connection.ConnectionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static org.erdc.cobie.cobielite.connection.ConnectionType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.connection.ConnectionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static org.erdc.cobie.cobielite.connection.ConnectionType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.connection.ConnectionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static org.erdc.cobie.cobielite.connection.ConnectionType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.connection.ConnectionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static org.erdc.cobie.cobielite.connection.ConnectionType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.connection.ConnectionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static org.erdc.cobie.cobielite.connection.ConnectionType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.connection.ConnectionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static org.erdc.cobie.cobielite.connection.ConnectionType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.connection.ConnectionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static org.erdc.cobie.cobielite.connection.ConnectionType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.connection.ConnectionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static org.erdc.cobie.cobielite.connection.ConnectionType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.connection.ConnectionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static org.erdc.cobie.cobielite.connection.ConnectionType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.connection.ConnectionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.erdc.cobie.cobielite.connection.ConnectionType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.erdc.cobie.cobielite.connection.ConnectionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.erdc.cobie.cobielite.connection.ConnectionType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.erdc.cobie.cobielite.connection.ConnectionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
