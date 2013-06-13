/*
 * XML Type:  SystemType
 * Namespace: http://system.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.system.SystemType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.system;


/**
 * An XML SystemType(@http://system.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public interface SystemType extends org.erdc.cobie.cobielite.core.SystemType
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(SystemType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sDB8A4E468FD3CA78BBE0CAC69C637E16").resolveHandle("systemtype5567type");
    
    /**
     * Gets the "SystemDescription" element
     */
    java.lang.String getSystemDescription();
    
    /**
     * Gets (as xml) the "SystemDescription" element
     */
    org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType xgetSystemDescription();
    
    /**
     * True if has "SystemDescription" element
     */
    boolean isSetSystemDescription();
    
    /**
     * Sets the "SystemDescription" element
     */
    void setSystemDescription(java.lang.String systemDescription);
    
    /**
     * Sets (as xml) the "SystemDescription" element
     */
    void xsetSystemDescription(org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType systemDescription);
    
    /**
     * Unsets the "SystemDescription" element
     */
    void unsetSystemDescription();
    
    /**
     * Gets the "SystemAttributes" element
     */
    org.erdc.cobie.cobielite.core.AttributeCollectionType getSystemAttributes();
    
    /**
     * True if has "SystemAttributes" element
     */
    boolean isSetSystemAttributes();
    
    /**
     * Sets the "SystemAttributes" element
     */
    void setSystemAttributes(org.erdc.cobie.cobielite.core.AttributeCollectionType systemAttributes);
    
    /**
     * Appends and returns a new empty "SystemAttributes" element
     */
    org.erdc.cobie.cobielite.core.AttributeCollectionType addNewSystemAttributes();
    
    /**
     * Unsets the "SystemAttributes" element
     */
    void unsetSystemAttributes();
    
    /**
     * Gets the "SystemDocuments" element
     */
    org.erdc.cobie.cobielite.core.DocumentCollectionType getSystemDocuments();
    
    /**
     * True if has "SystemDocuments" element
     */
    boolean isSetSystemDocuments();
    
    /**
     * Sets the "SystemDocuments" element
     */
    void setSystemDocuments(org.erdc.cobie.cobielite.core.DocumentCollectionType systemDocuments);
    
    /**
     * Appends and returns a new empty "SystemDocuments" element
     */
    org.erdc.cobie.cobielite.core.DocumentCollectionType addNewSystemDocuments();
    
    /**
     * Unsets the "SystemDocuments" element
     */
    void unsetSystemDocuments();
    
    /**
     * Gets the "SystemIssues" element
     */
    org.erdc.cobie.cobielite.core.IssueCollectionType getSystemIssues();
    
    /**
     * True if has "SystemIssues" element
     */
    boolean isSetSystemIssues();
    
    /**
     * Sets the "SystemIssues" element
     */
    void setSystemIssues(org.erdc.cobie.cobielite.core.IssueCollectionType systemIssues);
    
    /**
     * Appends and returns a new empty "SystemIssues" element
     */
    org.erdc.cobie.cobielite.core.IssueCollectionType addNewSystemIssues();
    
    /**
     * Unsets the "SystemIssues" element
     */
    void unsetSystemIssues();
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static org.erdc.cobie.cobielite.system.SystemType newInstance() {
          return (org.erdc.cobie.cobielite.system.SystemType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static org.erdc.cobie.cobielite.system.SystemType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (org.erdc.cobie.cobielite.system.SystemType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static org.erdc.cobie.cobielite.system.SystemType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.system.SystemType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static org.erdc.cobie.cobielite.system.SystemType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.system.SystemType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static org.erdc.cobie.cobielite.system.SystemType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.system.SystemType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static org.erdc.cobie.cobielite.system.SystemType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.system.SystemType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static org.erdc.cobie.cobielite.system.SystemType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.system.SystemType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static org.erdc.cobie.cobielite.system.SystemType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.system.SystemType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static org.erdc.cobie.cobielite.system.SystemType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.system.SystemType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static org.erdc.cobie.cobielite.system.SystemType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.system.SystemType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static org.erdc.cobie.cobielite.system.SystemType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.system.SystemType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static org.erdc.cobie.cobielite.system.SystemType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.system.SystemType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static org.erdc.cobie.cobielite.system.SystemType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.system.SystemType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static org.erdc.cobie.cobielite.system.SystemType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.system.SystemType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static org.erdc.cobie.cobielite.system.SystemType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.system.SystemType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static org.erdc.cobie.cobielite.system.SystemType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.system.SystemType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.erdc.cobie.cobielite.system.SystemType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.erdc.cobie.cobielite.system.SystemType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.erdc.cobie.cobielite.system.SystemType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.erdc.cobie.cobielite.system.SystemType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
