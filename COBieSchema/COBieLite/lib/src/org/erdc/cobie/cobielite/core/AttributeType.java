/*
 * XML Type:  AttributeType
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.AttributeType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core;


/**
 * An XML AttributeType(@http://core.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public interface AttributeType extends org.erdc.cobie.cobielite.core.CobieRowType
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(AttributeType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sC7CAE39C2CC479123ADE186B88FEDB2D").resolveHandle("attributetype0b1ctype");
    
    /**
     * Gets the "AttributeName" element
     */
    java.lang.String getAttributeName();
    
    /**
     * Gets (as xml) the "AttributeName" element
     */
    org.erdc.cobie.cobielite.core.CobieNameSimpleType xgetAttributeName();
    
    /**
     * Sets the "AttributeName" element
     */
    void setAttributeName(java.lang.String attributeName);
    
    /**
     * Sets (as xml) the "AttributeName" element
     */
    void xsetAttributeName(org.erdc.cobie.cobielite.core.CobieNameSimpleType attributeName);
    
    /**
     * Gets the "AttributeCategory" element
     */
    java.lang.String getAttributeCategory();
    
    /**
     * Gets (as xml) the "AttributeCategory" element
     */
    org.erdc.cobie.cobielite.core.AttributeCategorySimpleType xgetAttributeCategory();
    
    /**
     * Sets the "AttributeCategory" element
     */
    void setAttributeCategory(java.lang.String attributeCategory);
    
    /**
     * Sets (as xml) the "AttributeCategory" element
     */
    void xsetAttributeCategory(org.erdc.cobie.cobielite.core.AttributeCategorySimpleType attributeCategory);
    
    /**
     * Gets the "propertySetName" attribute
     */
    java.lang.String getPropertySetName();
    
    /**
     * Gets (as xml) the "propertySetName" attribute
     */
    org.erdc.cobie.cobielite.core.PropertySetNameSimpleType xgetPropertySetName();
    
    /**
     * True if has "propertySetName" attribute
     */
    boolean isSetPropertySetName();
    
    /**
     * Sets the "propertySetName" attribute
     */
    void setPropertySetName(java.lang.String propertySetName);
    
    /**
     * Sets (as xml) the "propertySetName" attribute
     */
    void xsetPropertySetName(org.erdc.cobie.cobielite.core.PropertySetNameSimpleType propertySetName);
    
    /**
     * Unsets the "propertySetName" attribute
     */
    void unsetPropertySetName();
    
    /**
     * Gets the "propertySetExternalIdentifier" attribute
     */
    java.lang.String getPropertySetExternalIdentifier();
    
    /**
     * Gets (as xml) the "propertySetExternalIdentifier" attribute
     */
    org.erdc.cobie.cobielite.core.ExternalIdentifierSimpleType xgetPropertySetExternalIdentifier();
    
    /**
     * True if has "propertySetExternalIdentifier" attribute
     */
    boolean isSetPropertySetExternalIdentifier();
    
    /**
     * Sets the "propertySetExternalIdentifier" attribute
     */
    void setPropertySetExternalIdentifier(java.lang.String propertySetExternalIdentifier);
    
    /**
     * Sets (as xml) the "propertySetExternalIdentifier" attribute
     */
    void xsetPropertySetExternalIdentifier(org.erdc.cobie.cobielite.core.ExternalIdentifierSimpleType propertySetExternalIdentifier);
    
    /**
     * Unsets the "propertySetExternalIdentifier" attribute
     */
    void unsetPropertySetExternalIdentifier();
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static org.erdc.cobie.cobielite.core.AttributeType newInstance() {
          return (org.erdc.cobie.cobielite.core.AttributeType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static org.erdc.cobie.cobielite.core.AttributeType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (org.erdc.cobie.cobielite.core.AttributeType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static org.erdc.cobie.cobielite.core.AttributeType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.core.AttributeType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static org.erdc.cobie.cobielite.core.AttributeType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.core.AttributeType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static org.erdc.cobie.cobielite.core.AttributeType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.core.AttributeType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static org.erdc.cobie.cobielite.core.AttributeType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.core.AttributeType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static org.erdc.cobie.cobielite.core.AttributeType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.core.AttributeType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static org.erdc.cobie.cobielite.core.AttributeType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.core.AttributeType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static org.erdc.cobie.cobielite.core.AttributeType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.core.AttributeType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static org.erdc.cobie.cobielite.core.AttributeType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.core.AttributeType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static org.erdc.cobie.cobielite.core.AttributeType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.core.AttributeType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static org.erdc.cobie.cobielite.core.AttributeType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.core.AttributeType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static org.erdc.cobie.cobielite.core.AttributeType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.core.AttributeType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static org.erdc.cobie.cobielite.core.AttributeType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.core.AttributeType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static org.erdc.cobie.cobielite.core.AttributeType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.core.AttributeType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static org.erdc.cobie.cobielite.core.AttributeType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.core.AttributeType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.erdc.cobie.cobielite.core.AttributeType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.erdc.cobie.cobielite.core.AttributeType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.erdc.cobie.cobielite.core.AttributeType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.erdc.cobie.cobielite.core.AttributeType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
