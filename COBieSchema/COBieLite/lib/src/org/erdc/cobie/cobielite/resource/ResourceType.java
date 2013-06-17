/*
 * XML Type:  ResourceType
 * Namespace: http://resource.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.resource.ResourceType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.resource;


/**
 * An XML ResourceType(@http://resource.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public interface ResourceType extends org.erdc.cobie.cobielite.core.ResourceType
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ResourceType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s66652C141B24B73BD4333B57A0EF7E00").resolveHandle("resourcetypeb829type");
    
    /**
     * Gets the "ResourceCategory" element
     */
    java.lang.String getResourceCategory();
    
    /**
     * Gets (as xml) the "ResourceCategory" element
     */
    org.erdc.cobie.cobielite.core.ResourceCategorySimpleType xgetResourceCategory();
    
    /**
     * True if has "ResourceCategory" element
     */
    boolean isSetResourceCategory();
    
    /**
     * Sets the "ResourceCategory" element
     */
    void setResourceCategory(java.lang.String resourceCategory);
    
    /**
     * Sets (as xml) the "ResourceCategory" element
     */
    void xsetResourceCategory(org.erdc.cobie.cobielite.core.ResourceCategorySimpleType resourceCategory);
    
    /**
     * Unsets the "ResourceCategory" element
     */
    void unsetResourceCategory();
    
    /**
     * Gets the "ResourceDescription" element
     */
    java.lang.String getResourceDescription();
    
    /**
     * Gets (as xml) the "ResourceDescription" element
     */
    org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType xgetResourceDescription();
    
    /**
     * True if has "ResourceDescription" element
     */
    boolean isSetResourceDescription();
    
    /**
     * Sets the "ResourceDescription" element
     */
    void setResourceDescription(java.lang.String resourceDescription);
    
    /**
     * Sets (as xml) the "ResourceDescription" element
     */
    void xsetResourceDescription(org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType resourceDescription);
    
    /**
     * Unsets the "ResourceDescription" element
     */
    void unsetResourceDescription();
    
    /**
     * Gets the "ResourceAttributes" element
     */
    org.erdc.cobie.cobielite.core.AttributeCollectionType getResourceAttributes();
    
    /**
     * True if has "ResourceAttributes" element
     */
    boolean isSetResourceAttributes();
    
    /**
     * Sets the "ResourceAttributes" element
     */
    void setResourceAttributes(org.erdc.cobie.cobielite.core.AttributeCollectionType resourceAttributes);
    
    /**
     * Appends and returns a new empty "ResourceAttributes" element
     */
    org.erdc.cobie.cobielite.core.AttributeCollectionType addNewResourceAttributes();
    
    /**
     * Unsets the "ResourceAttributes" element
     */
    void unsetResourceAttributes();
    
    /**
     * Gets the "ResourceDocuments" element
     */
    org.erdc.cobie.cobielite.core.DocumentCollectionType getResourceDocuments();
    
    /**
     * True if has "ResourceDocuments" element
     */
    boolean isSetResourceDocuments();
    
    /**
     * Sets the "ResourceDocuments" element
     */
    void setResourceDocuments(org.erdc.cobie.cobielite.core.DocumentCollectionType resourceDocuments);
    
    /**
     * Appends and returns a new empty "ResourceDocuments" element
     */
    org.erdc.cobie.cobielite.core.DocumentCollectionType addNewResourceDocuments();
    
    /**
     * Unsets the "ResourceDocuments" element
     */
    void unsetResourceDocuments();
    
    /**
     * Gets the "ResourceIssues" element
     */
    org.erdc.cobie.cobielite.core.IssueCollectionType getResourceIssues();
    
    /**
     * True if has "ResourceIssues" element
     */
    boolean isSetResourceIssues();
    
    /**
     * Sets the "ResourceIssues" element
     */
    void setResourceIssues(org.erdc.cobie.cobielite.core.IssueCollectionType resourceIssues);
    
    /**
     * Appends and returns a new empty "ResourceIssues" element
     */
    org.erdc.cobie.cobielite.core.IssueCollectionType addNewResourceIssues();
    
    /**
     * Unsets the "ResourceIssues" element
     */
    void unsetResourceIssues();
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static org.erdc.cobie.cobielite.resource.ResourceType newInstance() {
          return (org.erdc.cobie.cobielite.resource.ResourceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static org.erdc.cobie.cobielite.resource.ResourceType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (org.erdc.cobie.cobielite.resource.ResourceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static org.erdc.cobie.cobielite.resource.ResourceType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.resource.ResourceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static org.erdc.cobie.cobielite.resource.ResourceType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.resource.ResourceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static org.erdc.cobie.cobielite.resource.ResourceType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.resource.ResourceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static org.erdc.cobie.cobielite.resource.ResourceType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.resource.ResourceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static org.erdc.cobie.cobielite.resource.ResourceType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.resource.ResourceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static org.erdc.cobie.cobielite.resource.ResourceType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.resource.ResourceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static org.erdc.cobie.cobielite.resource.ResourceType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.resource.ResourceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static org.erdc.cobie.cobielite.resource.ResourceType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.resource.ResourceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static org.erdc.cobie.cobielite.resource.ResourceType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.resource.ResourceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static org.erdc.cobie.cobielite.resource.ResourceType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.resource.ResourceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static org.erdc.cobie.cobielite.resource.ResourceType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.resource.ResourceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static org.erdc.cobie.cobielite.resource.ResourceType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.resource.ResourceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static org.erdc.cobie.cobielite.resource.ResourceType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.resource.ResourceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static org.erdc.cobie.cobielite.resource.ResourceType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.resource.ResourceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.erdc.cobie.cobielite.resource.ResourceType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.erdc.cobie.cobielite.resource.ResourceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.erdc.cobie.cobielite.resource.ResourceType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.erdc.cobie.cobielite.resource.ResourceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
