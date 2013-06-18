/*
 * XML Type:  ZoneType
 * Namespace: http://zone.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.zone.ZoneType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.zone;


/**
 * An XML ZoneType(@http://zone.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public interface ZoneType extends org.erdc.cobie.cobielite.core.ZoneType
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ZoneType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s3CB9F4CCC0C9D802814557AAC3F0E7DA").resolveHandle("zonetype4a6dtype");
    
    /**
     * Gets the "ZoneDescription" element
     */
    java.lang.String getZoneDescription();
    
    /**
     * Gets (as xml) the "ZoneDescription" element
     */
    org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType xgetZoneDescription();
    
    /**
     * True if has "ZoneDescription" element
     */
    boolean isSetZoneDescription();
    
    /**
     * Sets the "ZoneDescription" element
     */
    void setZoneDescription(java.lang.String zoneDescription);
    
    /**
     * Sets (as xml) the "ZoneDescription" element
     */
    void xsetZoneDescription(org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType zoneDescription);
    
    /**
     * Unsets the "ZoneDescription" element
     */
    void unsetZoneDescription();
    
    /**
     * Gets the "ZoneAttributes" element
     */
    org.erdc.cobie.cobielite.core.AttributeCollectionType getZoneAttributes();
    
    /**
     * True if has "ZoneAttributes" element
     */
    boolean isSetZoneAttributes();
    
    /**
     * Sets the "ZoneAttributes" element
     */
    void setZoneAttributes(org.erdc.cobie.cobielite.core.AttributeCollectionType zoneAttributes);
    
    /**
     * Appends and returns a new empty "ZoneAttributes" element
     */
    org.erdc.cobie.cobielite.core.AttributeCollectionType addNewZoneAttributes();
    
    /**
     * Unsets the "ZoneAttributes" element
     */
    void unsetZoneAttributes();
    
    /**
     * Gets the "ZoneDocuments" element
     */
    org.erdc.cobie.cobielite.core.DocumentCollectionType getZoneDocuments();
    
    /**
     * True if has "ZoneDocuments" element
     */
    boolean isSetZoneDocuments();
    
    /**
     * Sets the "ZoneDocuments" element
     */
    void setZoneDocuments(org.erdc.cobie.cobielite.core.DocumentCollectionType zoneDocuments);
    
    /**
     * Appends and returns a new empty "ZoneDocuments" element
     */
    org.erdc.cobie.cobielite.core.DocumentCollectionType addNewZoneDocuments();
    
    /**
     * Unsets the "ZoneDocuments" element
     */
    void unsetZoneDocuments();
    
    /**
     * Gets the "ZoneIssues" element
     */
    org.erdc.cobie.cobielite.core.IssueCollectionType getZoneIssues();
    
    /**
     * True if has "ZoneIssues" element
     */
    boolean isSetZoneIssues();
    
    /**
     * Sets the "ZoneIssues" element
     */
    void setZoneIssues(org.erdc.cobie.cobielite.core.IssueCollectionType zoneIssues);
    
    /**
     * Appends and returns a new empty "ZoneIssues" element
     */
    org.erdc.cobie.cobielite.core.IssueCollectionType addNewZoneIssues();
    
    /**
     * Unsets the "ZoneIssues" element
     */
    void unsetZoneIssues();
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static org.erdc.cobie.cobielite.zone.ZoneType newInstance() {
          return (org.erdc.cobie.cobielite.zone.ZoneType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static org.erdc.cobie.cobielite.zone.ZoneType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (org.erdc.cobie.cobielite.zone.ZoneType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static org.erdc.cobie.cobielite.zone.ZoneType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.zone.ZoneType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static org.erdc.cobie.cobielite.zone.ZoneType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.zone.ZoneType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static org.erdc.cobie.cobielite.zone.ZoneType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.zone.ZoneType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static org.erdc.cobie.cobielite.zone.ZoneType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.zone.ZoneType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static org.erdc.cobie.cobielite.zone.ZoneType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.zone.ZoneType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static org.erdc.cobie.cobielite.zone.ZoneType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.zone.ZoneType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static org.erdc.cobie.cobielite.zone.ZoneType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.zone.ZoneType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static org.erdc.cobie.cobielite.zone.ZoneType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.zone.ZoneType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static org.erdc.cobie.cobielite.zone.ZoneType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.zone.ZoneType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static org.erdc.cobie.cobielite.zone.ZoneType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.zone.ZoneType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static org.erdc.cobie.cobielite.zone.ZoneType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.zone.ZoneType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static org.erdc.cobie.cobielite.zone.ZoneType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.zone.ZoneType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static org.erdc.cobie.cobielite.zone.ZoneType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.zone.ZoneType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static org.erdc.cobie.cobielite.zone.ZoneType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.zone.ZoneType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.erdc.cobie.cobielite.zone.ZoneType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.erdc.cobie.cobielite.zone.ZoneType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.erdc.cobie.cobielite.zone.ZoneType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.erdc.cobie.cobielite.zone.ZoneType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
