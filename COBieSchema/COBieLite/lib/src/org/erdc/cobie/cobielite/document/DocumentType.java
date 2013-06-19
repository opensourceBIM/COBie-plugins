/*
 * XML Type:  DocumentType
 * Namespace: http://document.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.document.DocumentType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.document;


/**
 * An XML DocumentType(@http://document.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public interface DocumentType extends org.erdc.cobie.cobielite.core.DocumentType
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(DocumentType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sC7CAE39C2CC479123ADE186B88FEDB2D").resolveHandle("documenttypec7cftype");
    
    /**
     * Gets the "DocumentCategory" element
     */
    java.lang.String getDocumentCategory();
    
    /**
     * Gets (as xml) the "DocumentCategory" element
     */
    org.erdc.cobie.cobielite.core.DocumentCategorySimpleType xgetDocumentCategory();
    
    /**
     * True if has "DocumentCategory" element
     */
    boolean isSetDocumentCategory();
    
    /**
     * Sets the "DocumentCategory" element
     */
    void setDocumentCategory(java.lang.String documentCategory);
    
    /**
     * Sets (as xml) the "DocumentCategory" element
     */
    void xsetDocumentCategory(org.erdc.cobie.cobielite.core.DocumentCategorySimpleType documentCategory);
    
    /**
     * Unsets the "DocumentCategory" element
     */
    void unsetDocumentCategory();
    
    /**
     * Gets the "DocumentDescription" element
     */
    java.lang.String getDocumentDescription();
    
    /**
     * Gets (as xml) the "DocumentDescription" element
     */
    org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType xgetDocumentDescription();
    
    /**
     * True if has "DocumentDescription" element
     */
    boolean isSetDocumentDescription();
    
    /**
     * Sets the "DocumentDescription" element
     */
    void setDocumentDescription(java.lang.String documentDescription);
    
    /**
     * Sets (as xml) the "DocumentDescription" element
     */
    void xsetDocumentDescription(org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType documentDescription);
    
    /**
     * Unsets the "DocumentDescription" element
     */
    void unsetDocumentDescription();
    
    /**
     * Gets the "DocumentURI" element
     */
    java.lang.String getDocumentURI();
    
    /**
     * Gets (as xml) the "DocumentURI" element
     */
    org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetDocumentURI();
    
    /**
     * True if has "DocumentURI" element
     */
    boolean isSetDocumentURI();
    
    /**
     * Sets the "DocumentURI" element
     */
    void setDocumentURI(java.lang.String documentURI);
    
    /**
     * Sets (as xml) the "DocumentURI" element
     */
    void xsetDocumentURI(org.erdc.cobie.cobielite.core.CobieTextSimpleType documentURI);
    
    /**
     * Unsets the "DocumentURI" element
     */
    void unsetDocumentURI();
    
    /**
     * Gets the "DocumentReferenceURI" element
     */
    java.lang.String getDocumentReferenceURI();
    
    /**
     * Gets (as xml) the "DocumentReferenceURI" element
     */
    org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetDocumentReferenceURI();
    
    /**
     * True if has "DocumentReferenceURI" element
     */
    boolean isSetDocumentReferenceURI();
    
    /**
     * Sets the "DocumentReferenceURI" element
     */
    void setDocumentReferenceURI(java.lang.String documentReferenceURI);
    
    /**
     * Sets (as xml) the "DocumentReferenceURI" element
     */
    void xsetDocumentReferenceURI(org.erdc.cobie.cobielite.core.CobieTextSimpleType documentReferenceURI);
    
    /**
     * Unsets the "DocumentReferenceURI" element
     */
    void unsetDocumentReferenceURI();
    
    /**
     * Gets the "DocumentAttributes" element
     */
    org.erdc.cobie.cobielite.core.AttributeCollectionType getDocumentAttributes();
    
    /**
     * True if has "DocumentAttributes" element
     */
    boolean isSetDocumentAttributes();
    
    /**
     * Sets the "DocumentAttributes" element
     */
    void setDocumentAttributes(org.erdc.cobie.cobielite.core.AttributeCollectionType documentAttributes);
    
    /**
     * Appends and returns a new empty "DocumentAttributes" element
     */
    org.erdc.cobie.cobielite.core.AttributeCollectionType addNewDocumentAttributes();
    
    /**
     * Unsets the "DocumentAttributes" element
     */
    void unsetDocumentAttributes();
    
    /**
     * Gets the "DocumentIssues" element
     */
    org.erdc.cobie.cobielite.core.IssueCollectionType getDocumentIssues();
    
    /**
     * True if has "DocumentIssues" element
     */
    boolean isSetDocumentIssues();
    
    /**
     * Sets the "DocumentIssues" element
     */
    void setDocumentIssues(org.erdc.cobie.cobielite.core.IssueCollectionType documentIssues);
    
    /**
     * Appends and returns a new empty "DocumentIssues" element
     */
    org.erdc.cobie.cobielite.core.IssueCollectionType addNewDocumentIssues();
    
    /**
     * Unsets the "DocumentIssues" element
     */
    void unsetDocumentIssues();
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static org.erdc.cobie.cobielite.document.DocumentType newInstance() {
          return (org.erdc.cobie.cobielite.document.DocumentType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static org.erdc.cobie.cobielite.document.DocumentType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (org.erdc.cobie.cobielite.document.DocumentType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static org.erdc.cobie.cobielite.document.DocumentType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.document.DocumentType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static org.erdc.cobie.cobielite.document.DocumentType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.document.DocumentType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static org.erdc.cobie.cobielite.document.DocumentType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.document.DocumentType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static org.erdc.cobie.cobielite.document.DocumentType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.document.DocumentType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static org.erdc.cobie.cobielite.document.DocumentType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.document.DocumentType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static org.erdc.cobie.cobielite.document.DocumentType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.document.DocumentType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static org.erdc.cobie.cobielite.document.DocumentType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.document.DocumentType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static org.erdc.cobie.cobielite.document.DocumentType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.document.DocumentType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static org.erdc.cobie.cobielite.document.DocumentType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.document.DocumentType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static org.erdc.cobie.cobielite.document.DocumentType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.document.DocumentType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static org.erdc.cobie.cobielite.document.DocumentType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.document.DocumentType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static org.erdc.cobie.cobielite.document.DocumentType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.document.DocumentType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static org.erdc.cobie.cobielite.document.DocumentType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.document.DocumentType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static org.erdc.cobie.cobielite.document.DocumentType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.document.DocumentType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.erdc.cobie.cobielite.document.DocumentType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.erdc.cobie.cobielite.document.DocumentType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.erdc.cobie.cobielite.document.DocumentType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.erdc.cobie.cobielite.document.DocumentType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
