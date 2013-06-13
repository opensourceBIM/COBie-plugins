/*
 * XML Type:  SpareType
 * Namespace: http://spare.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.spare.SpareType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.spare;


/**
 * An XML SpareType(@http://spare.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public interface SpareType extends org.erdc.cobie.cobielite.core.SpareType
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(SpareType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sDB8A4E468FD3CA78BBE0CAC69C637E16").resolveHandle("sparetyped1fdtype");
    
    /**
     * Gets the "SpareDescription" element
     */
    java.lang.String getSpareDescription();
    
    /**
     * Gets (as xml) the "SpareDescription" element
     */
    org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType xgetSpareDescription();
    
    /**
     * True if has "SpareDescription" element
     */
    boolean isSetSpareDescription();
    
    /**
     * Sets the "SpareDescription" element
     */
    void setSpareDescription(java.lang.String spareDescription);
    
    /**
     * Sets (as xml) the "SpareDescription" element
     */
    void xsetSpareDescription(org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType spareDescription);
    
    /**
     * Unsets the "SpareDescription" element
     */
    void unsetSpareDescription();
    
    /**
     * Gets the "SpareSetNumber" element
     */
    java.lang.String getSpareSetNumber();
    
    /**
     * Gets (as xml) the "SpareSetNumber" element
     */
    org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetSpareSetNumber();
    
    /**
     * True if has "SpareSetNumber" element
     */
    boolean isSetSpareSetNumber();
    
    /**
     * Sets the "SpareSetNumber" element
     */
    void setSpareSetNumber(java.lang.String spareSetNumber);
    
    /**
     * Sets (as xml) the "SpareSetNumber" element
     */
    void xsetSpareSetNumber(org.erdc.cobie.cobielite.core.CobieTextSimpleType spareSetNumber);
    
    /**
     * Unsets the "SpareSetNumber" element
     */
    void unsetSpareSetNumber();
    
    /**
     * Gets the "SparePartNumber" element
     */
    java.lang.String getSparePartNumber();
    
    /**
     * Gets (as xml) the "SparePartNumber" element
     */
    org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetSparePartNumber();
    
    /**
     * True if has "SparePartNumber" element
     */
    boolean isSetSparePartNumber();
    
    /**
     * Sets the "SparePartNumber" element
     */
    void setSparePartNumber(java.lang.String sparePartNumber);
    
    /**
     * Sets (as xml) the "SparePartNumber" element
     */
    void xsetSparePartNumber(org.erdc.cobie.cobielite.core.CobieTextSimpleType sparePartNumber);
    
    /**
     * Unsets the "SparePartNumber" element
     */
    void unsetSparePartNumber();
    
    /**
     * Gets the "SpareContactAssignments" element
     */
    org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType getSpareContactAssignments();
    
    /**
     * True if has "SpareContactAssignments" element
     */
    boolean isSetSpareContactAssignments();
    
    /**
     * Sets the "SpareContactAssignments" element
     */
    void setSpareContactAssignments(org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType spareContactAssignments);
    
    /**
     * Appends and returns a new empty "SpareContactAssignments" element
     */
    org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType addNewSpareContactAssignments();
    
    /**
     * Unsets the "SpareContactAssignments" element
     */
    void unsetSpareContactAssignments();
    
    /**
     * Gets the "SpareAttributes" element
     */
    org.erdc.cobie.cobielite.core.AttributeCollectionType getSpareAttributes();
    
    /**
     * True if has "SpareAttributes" element
     */
    boolean isSetSpareAttributes();
    
    /**
     * Sets the "SpareAttributes" element
     */
    void setSpareAttributes(org.erdc.cobie.cobielite.core.AttributeCollectionType spareAttributes);
    
    /**
     * Appends and returns a new empty "SpareAttributes" element
     */
    org.erdc.cobie.cobielite.core.AttributeCollectionType addNewSpareAttributes();
    
    /**
     * Unsets the "SpareAttributes" element
     */
    void unsetSpareAttributes();
    
    /**
     * Gets the "SpareDocuments" element
     */
    org.erdc.cobie.cobielite.core.DocumentCollectionType getSpareDocuments();
    
    /**
     * True if has "SpareDocuments" element
     */
    boolean isSetSpareDocuments();
    
    /**
     * Sets the "SpareDocuments" element
     */
    void setSpareDocuments(org.erdc.cobie.cobielite.core.DocumentCollectionType spareDocuments);
    
    /**
     * Appends and returns a new empty "SpareDocuments" element
     */
    org.erdc.cobie.cobielite.core.DocumentCollectionType addNewSpareDocuments();
    
    /**
     * Unsets the "SpareDocuments" element
     */
    void unsetSpareDocuments();
    
    /**
     * Gets the "SpareIssues" element
     */
    org.erdc.cobie.cobielite.core.IssueCollectionType getSpareIssues();
    
    /**
     * True if has "SpareIssues" element
     */
    boolean isSetSpareIssues();
    
    /**
     * Sets the "SpareIssues" element
     */
    void setSpareIssues(org.erdc.cobie.cobielite.core.IssueCollectionType spareIssues);
    
    /**
     * Appends and returns a new empty "SpareIssues" element
     */
    org.erdc.cobie.cobielite.core.IssueCollectionType addNewSpareIssues();
    
    /**
     * Unsets the "SpareIssues" element
     */
    void unsetSpareIssues();
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static org.erdc.cobie.cobielite.spare.SpareType newInstance() {
          return (org.erdc.cobie.cobielite.spare.SpareType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static org.erdc.cobie.cobielite.spare.SpareType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (org.erdc.cobie.cobielite.spare.SpareType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static org.erdc.cobie.cobielite.spare.SpareType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.spare.SpareType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static org.erdc.cobie.cobielite.spare.SpareType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.spare.SpareType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static org.erdc.cobie.cobielite.spare.SpareType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.spare.SpareType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static org.erdc.cobie.cobielite.spare.SpareType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.spare.SpareType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static org.erdc.cobie.cobielite.spare.SpareType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.spare.SpareType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static org.erdc.cobie.cobielite.spare.SpareType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.spare.SpareType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static org.erdc.cobie.cobielite.spare.SpareType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.spare.SpareType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static org.erdc.cobie.cobielite.spare.SpareType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.spare.SpareType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static org.erdc.cobie.cobielite.spare.SpareType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.spare.SpareType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static org.erdc.cobie.cobielite.spare.SpareType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.spare.SpareType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static org.erdc.cobie.cobielite.spare.SpareType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.spare.SpareType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static org.erdc.cobie.cobielite.spare.SpareType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.spare.SpareType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static org.erdc.cobie.cobielite.spare.SpareType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.spare.SpareType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static org.erdc.cobie.cobielite.spare.SpareType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.spare.SpareType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.erdc.cobie.cobielite.spare.SpareType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.erdc.cobie.cobielite.spare.SpareType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.erdc.cobie.cobielite.spare.SpareType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.erdc.cobie.cobielite.spare.SpareType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
