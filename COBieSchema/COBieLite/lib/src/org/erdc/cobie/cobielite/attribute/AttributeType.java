/*
 * XML Type:  AttributeType
 * Namespace: http://attribute.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.attribute.AttributeType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.attribute;


/**
 * An XML AttributeType(@http://attribute.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public interface AttributeType extends org.erdc.cobie.cobielite.core.AttributeType
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(AttributeType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s66652C141B24B73BD4333B57A0EF7E00").resolveHandle("attributetypeb85dtype");
    
    /**
     * Gets the "AttributeDescription" element
     */
    java.lang.String getAttributeDescription();
    
    /**
     * Gets (as xml) the "AttributeDescription" element
     */
    org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType xgetAttributeDescription();
    
    /**
     * True if has "AttributeDescription" element
     */
    boolean isSetAttributeDescription();
    
    /**
     * Sets the "AttributeDescription" element
     */
    void setAttributeDescription(java.lang.String attributeDescription);
    
    /**
     * Sets (as xml) the "AttributeDescription" element
     */
    void xsetAttributeDescription(org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType attributeDescription);
    
    /**
     * Unsets the "AttributeDescription" element
     */
    void unsetAttributeDescription();
    
    /**
     * Gets the "AttributeValue" element
     */
    org.erdc.cobie.cobielite.core.AttributeValueType getAttributeValue();
    
    /**
     * True if has "AttributeValue" element
     */
    boolean isSetAttributeValue();
    
    /**
     * Sets the "AttributeValue" element
     */
    void setAttributeValue(org.erdc.cobie.cobielite.core.AttributeValueType attributeValue);
    
    /**
     * Appends and returns a new empty "AttributeValue" element
     */
    org.erdc.cobie.cobielite.core.AttributeValueType addNewAttributeValue();
    
    /**
     * Unsets the "AttributeValue" element
     */
    void unsetAttributeValue();
    
    /**
     * Gets the "AttributeIssues" element
     */
    org.erdc.cobie.cobielite.core.IssueCollectionType getAttributeIssues();
    
    /**
     * True if has "AttributeIssues" element
     */
    boolean isSetAttributeIssues();
    
    /**
     * Sets the "AttributeIssues" element
     */
    void setAttributeIssues(org.erdc.cobie.cobielite.core.IssueCollectionType attributeIssues);
    
    /**
     * Appends and returns a new empty "AttributeIssues" element
     */
    org.erdc.cobie.cobielite.core.IssueCollectionType addNewAttributeIssues();
    
    /**
     * Unsets the "AttributeIssues" element
     */
    void unsetAttributeIssues();
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static org.erdc.cobie.cobielite.attribute.AttributeType newInstance() {
          return (org.erdc.cobie.cobielite.attribute.AttributeType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static org.erdc.cobie.cobielite.attribute.AttributeType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (org.erdc.cobie.cobielite.attribute.AttributeType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static org.erdc.cobie.cobielite.attribute.AttributeType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.attribute.AttributeType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static org.erdc.cobie.cobielite.attribute.AttributeType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.attribute.AttributeType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static org.erdc.cobie.cobielite.attribute.AttributeType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.attribute.AttributeType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static org.erdc.cobie.cobielite.attribute.AttributeType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.attribute.AttributeType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static org.erdc.cobie.cobielite.attribute.AttributeType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.attribute.AttributeType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static org.erdc.cobie.cobielite.attribute.AttributeType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.attribute.AttributeType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static org.erdc.cobie.cobielite.attribute.AttributeType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.attribute.AttributeType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static org.erdc.cobie.cobielite.attribute.AttributeType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.attribute.AttributeType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static org.erdc.cobie.cobielite.attribute.AttributeType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.attribute.AttributeType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static org.erdc.cobie.cobielite.attribute.AttributeType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.attribute.AttributeType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static org.erdc.cobie.cobielite.attribute.AttributeType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.attribute.AttributeType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static org.erdc.cobie.cobielite.attribute.AttributeType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.attribute.AttributeType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static org.erdc.cobie.cobielite.attribute.AttributeType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.attribute.AttributeType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static org.erdc.cobie.cobielite.attribute.AttributeType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.attribute.AttributeType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.erdc.cobie.cobielite.attribute.AttributeType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.erdc.cobie.cobielite.attribute.AttributeType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.erdc.cobie.cobielite.attribute.AttributeType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.erdc.cobie.cobielite.attribute.AttributeType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
