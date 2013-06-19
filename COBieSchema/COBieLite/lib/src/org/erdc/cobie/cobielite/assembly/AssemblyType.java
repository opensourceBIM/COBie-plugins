/*
 * XML Type:  AssemblyType
 * Namespace: http://assembly.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.assembly.AssemblyType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.assembly;


/**
 * An XML AssemblyType(@http://assembly.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public interface AssemblyType extends org.erdc.cobie.cobielite.core.AssemblyType
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(AssemblyType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sC7CAE39C2CC479123ADE186B88FEDB2D").resolveHandle("assemblytype2679type");
    
    /**
     * Gets the "AssemblyCategory" element
     */
    java.lang.String getAssemblyCategory();
    
    /**
     * Gets (as xml) the "AssemblyCategory" element
     */
    org.erdc.cobie.cobielite.core.AssemblyCategorySimpleType xgetAssemblyCategory();
    
    /**
     * True if has "AssemblyCategory" element
     */
    boolean isSetAssemblyCategory();
    
    /**
     * Sets the "AssemblyCategory" element
     */
    void setAssemblyCategory(java.lang.String assemblyCategory);
    
    /**
     * Sets (as xml) the "AssemblyCategory" element
     */
    void xsetAssemblyCategory(org.erdc.cobie.cobielite.core.AssemblyCategorySimpleType assemblyCategory);
    
    /**
     * Unsets the "AssemblyCategory" element
     */
    void unsetAssemblyCategory();
    
    /**
     * Gets the "AssemblyDescription" element
     */
    java.lang.String getAssemblyDescription();
    
    /**
     * Gets (as xml) the "AssemblyDescription" element
     */
    org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType xgetAssemblyDescription();
    
    /**
     * True if has "AssemblyDescription" element
     */
    boolean isSetAssemblyDescription();
    
    /**
     * Sets the "AssemblyDescription" element
     */
    void setAssemblyDescription(java.lang.String assemblyDescription);
    
    /**
     * Sets (as xml) the "AssemblyDescription" element
     */
    void xsetAssemblyDescription(org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType assemblyDescription);
    
    /**
     * Unsets the "AssemblyDescription" element
     */
    void unsetAssemblyDescription();
    
    /**
     * Gets the "AssemblyAttributes" element
     */
    org.erdc.cobie.cobielite.core.AttributeCollectionType getAssemblyAttributes();
    
    /**
     * True if has "AssemblyAttributes" element
     */
    boolean isSetAssemblyAttributes();
    
    /**
     * Sets the "AssemblyAttributes" element
     */
    void setAssemblyAttributes(org.erdc.cobie.cobielite.core.AttributeCollectionType assemblyAttributes);
    
    /**
     * Appends and returns a new empty "AssemblyAttributes" element
     */
    org.erdc.cobie.cobielite.core.AttributeCollectionType addNewAssemblyAttributes();
    
    /**
     * Unsets the "AssemblyAttributes" element
     */
    void unsetAssemblyAttributes();
    
    /**
     * Gets the "AssemblyDocuments" element
     */
    org.erdc.cobie.cobielite.core.DocumentCollectionType getAssemblyDocuments();
    
    /**
     * True if has "AssemblyDocuments" element
     */
    boolean isSetAssemblyDocuments();
    
    /**
     * Sets the "AssemblyDocuments" element
     */
    void setAssemblyDocuments(org.erdc.cobie.cobielite.core.DocumentCollectionType assemblyDocuments);
    
    /**
     * Appends and returns a new empty "AssemblyDocuments" element
     */
    org.erdc.cobie.cobielite.core.DocumentCollectionType addNewAssemblyDocuments();
    
    /**
     * Unsets the "AssemblyDocuments" element
     */
    void unsetAssemblyDocuments();
    
    /**
     * Gets the "AssemblyIssues" element
     */
    org.erdc.cobie.cobielite.core.IssueCollectionType getAssemblyIssues();
    
    /**
     * True if has "AssemblyIssues" element
     */
    boolean isSetAssemblyIssues();
    
    /**
     * Sets the "AssemblyIssues" element
     */
    void setAssemblyIssues(org.erdc.cobie.cobielite.core.IssueCollectionType assemblyIssues);
    
    /**
     * Appends and returns a new empty "AssemblyIssues" element
     */
    org.erdc.cobie.cobielite.core.IssueCollectionType addNewAssemblyIssues();
    
    /**
     * Unsets the "AssemblyIssues" element
     */
    void unsetAssemblyIssues();
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static org.erdc.cobie.cobielite.assembly.AssemblyType newInstance() {
          return (org.erdc.cobie.cobielite.assembly.AssemblyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static org.erdc.cobie.cobielite.assembly.AssemblyType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (org.erdc.cobie.cobielite.assembly.AssemblyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static org.erdc.cobie.cobielite.assembly.AssemblyType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.assembly.AssemblyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static org.erdc.cobie.cobielite.assembly.AssemblyType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.assembly.AssemblyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static org.erdc.cobie.cobielite.assembly.AssemblyType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.assembly.AssemblyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static org.erdc.cobie.cobielite.assembly.AssemblyType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.assembly.AssemblyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static org.erdc.cobie.cobielite.assembly.AssemblyType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.assembly.AssemblyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static org.erdc.cobie.cobielite.assembly.AssemblyType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.assembly.AssemblyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static org.erdc.cobie.cobielite.assembly.AssemblyType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.assembly.AssemblyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static org.erdc.cobie.cobielite.assembly.AssemblyType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.assembly.AssemblyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static org.erdc.cobie.cobielite.assembly.AssemblyType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.assembly.AssemblyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static org.erdc.cobie.cobielite.assembly.AssemblyType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.assembly.AssemblyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static org.erdc.cobie.cobielite.assembly.AssemblyType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.assembly.AssemblyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static org.erdc.cobie.cobielite.assembly.AssemblyType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.assembly.AssemblyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static org.erdc.cobie.cobielite.assembly.AssemblyType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.assembly.AssemblyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static org.erdc.cobie.cobielite.assembly.AssemblyType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.assembly.AssemblyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.erdc.cobie.cobielite.assembly.AssemblyType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.erdc.cobie.cobielite.assembly.AssemblyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.erdc.cobie.cobielite.assembly.AssemblyType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.erdc.cobie.cobielite.assembly.AssemblyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
