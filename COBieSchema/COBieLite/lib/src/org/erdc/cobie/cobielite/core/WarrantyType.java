/*
 * XML Type:  WarrantyType
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.WarrantyType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core;


/**
 * An XML WarrantyType(@http://core.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public interface WarrantyType extends org.erdc.cobie.cobielite.core.CobieBaseType
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(WarrantyType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sDB8A4E468FD3CA78BBE0CAC69C637E16").resolveHandle("warrantytype7f0atype");
    
    /**
     * Gets the "WarrantyName" element
     */
    java.lang.String getWarrantyName();
    
    /**
     * Gets (as xml) the "WarrantyName" element
     */
    org.erdc.cobie.cobielite.core.CobieNameSimpleType xgetWarrantyName();
    
    /**
     * Sets the "WarrantyName" element
     */
    void setWarrantyName(java.lang.String warrantyName);
    
    /**
     * Sets (as xml) the "WarrantyName" element
     */
    void xsetWarrantyName(org.erdc.cobie.cobielite.core.CobieNameSimpleType warrantyName);
    
    /**
     * Gets the "WarrantyCategory" element
     */
    java.lang.String getWarrantyCategory();
    
    /**
     * Gets (as xml) the "WarrantyCategory" element
     */
    org.erdc.cobie.cobielite.core.WarrantyCategorySimpleType xgetWarrantyCategory();
    
    /**
     * Sets the "WarrantyCategory" element
     */
    void setWarrantyCategory(java.lang.String warrantyCategory);
    
    /**
     * Sets (as xml) the "WarrantyCategory" element
     */
    void xsetWarrantyCategory(org.erdc.cobie.cobielite.core.WarrantyCategorySimpleType warrantyCategory);
    
    /**
     * Gets the "WarrantyDuration" element
     */
    org.erdc.cobie.cobielite.core.IntegerValueType getWarrantyDuration();
    
    /**
     * True if has "WarrantyDuration" element
     */
    boolean isSetWarrantyDuration();
    
    /**
     * Sets the "WarrantyDuration" element
     */
    void setWarrantyDuration(org.erdc.cobie.cobielite.core.IntegerValueType warrantyDuration);
    
    /**
     * Appends and returns a new empty "WarrantyDuration" element
     */
    org.erdc.cobie.cobielite.core.IntegerValueType addNewWarrantyDuration();
    
    /**
     * Unsets the "WarrantyDuration" element
     */
    void unsetWarrantyDuration();
    
    /**
     * Gets the "WarrantyGaurantorContactAssignments" element
     */
    org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType getWarrantyGaurantorContactAssignments();
    
    /**
     * True if has "WarrantyGaurantorContactAssignments" element
     */
    boolean isSetWarrantyGaurantorContactAssignments();
    
    /**
     * Sets the "WarrantyGaurantorContactAssignments" element
     */
    void setWarrantyGaurantorContactAssignments(org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType WarrantyGaurantorContactAssignments);
    
    /**
     * Appends and returns a new empty "WarrantyGaurantorContactAssignments" element
     */
    org.erdc.cobie.cobielite.core.ContactAssignmentCollectionType addNewWarrantyGaurantorContactAssignments();
    
    /**
     * Unsets the "WarrantyGaurantorContactAssignments" element
     */
    void unsetWarrantyGaurantorContactAssignments();
    
    /**
     * Gets the "WarrantyAttributes" element
     */
    org.erdc.cobie.cobielite.core.AttributeCollectionType getWarrantyAttributes();
    
    /**
     * True if has "WarrantyAttributes" element
     */
    boolean isSetWarrantyAttributes();
    
    /**
     * Sets the "WarrantyAttributes" element
     */
    void setWarrantyAttributes(org.erdc.cobie.cobielite.core.AttributeCollectionType warrantyAttributes);
    
    /**
     * Appends and returns a new empty "WarrantyAttributes" element
     */
    org.erdc.cobie.cobielite.core.AttributeCollectionType addNewWarrantyAttributes();
    
    /**
     * Unsets the "WarrantyAttributes" element
     */
    void unsetWarrantyAttributes();
    
    /**
     * Gets the "WarrantyDocuments" element
     */
    org.erdc.cobie.cobielite.core.DocumentCollectionType getWarrantyDocuments();
    
    /**
     * True if has "WarrantyDocuments" element
     */
    boolean isSetWarrantyDocuments();
    
    /**
     * Sets the "WarrantyDocuments" element
     */
    void setWarrantyDocuments(org.erdc.cobie.cobielite.core.DocumentCollectionType warrantyDocuments);
    
    /**
     * Appends and returns a new empty "WarrantyDocuments" element
     */
    org.erdc.cobie.cobielite.core.DocumentCollectionType addNewWarrantyDocuments();
    
    /**
     * Unsets the "WarrantyDocuments" element
     */
    void unsetWarrantyDocuments();
    
    /**
     * Gets the "WarrantyIssues" element
     */
    org.erdc.cobie.cobielite.core.IssueCollectionType getWarrantyIssues();
    
    /**
     * True if has "WarrantyIssues" element
     */
    boolean isSetWarrantyIssues();
    
    /**
     * Sets the "WarrantyIssues" element
     */
    void setWarrantyIssues(org.erdc.cobie.cobielite.core.IssueCollectionType warrantyIssues);
    
    /**
     * Appends and returns a new empty "WarrantyIssues" element
     */
    org.erdc.cobie.cobielite.core.IssueCollectionType addNewWarrantyIssues();
    
    /**
     * Unsets the "WarrantyIssues" element
     */
    void unsetWarrantyIssues();
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static org.erdc.cobie.cobielite.core.WarrantyType newInstance() {
          return (org.erdc.cobie.cobielite.core.WarrantyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static org.erdc.cobie.cobielite.core.WarrantyType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (org.erdc.cobie.cobielite.core.WarrantyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static org.erdc.cobie.cobielite.core.WarrantyType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.core.WarrantyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static org.erdc.cobie.cobielite.core.WarrantyType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.core.WarrantyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static org.erdc.cobie.cobielite.core.WarrantyType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.core.WarrantyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static org.erdc.cobie.cobielite.core.WarrantyType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.core.WarrantyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static org.erdc.cobie.cobielite.core.WarrantyType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.core.WarrantyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static org.erdc.cobie.cobielite.core.WarrantyType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.core.WarrantyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static org.erdc.cobie.cobielite.core.WarrantyType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.core.WarrantyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static org.erdc.cobie.cobielite.core.WarrantyType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.core.WarrantyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static org.erdc.cobie.cobielite.core.WarrantyType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.core.WarrantyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static org.erdc.cobie.cobielite.core.WarrantyType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.core.WarrantyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static org.erdc.cobie.cobielite.core.WarrantyType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.core.WarrantyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static org.erdc.cobie.cobielite.core.WarrantyType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.core.WarrantyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static org.erdc.cobie.cobielite.core.WarrantyType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.core.WarrantyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static org.erdc.cobie.cobielite.core.WarrantyType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.core.WarrantyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.erdc.cobie.cobielite.core.WarrantyType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.erdc.cobie.cobielite.core.WarrantyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.erdc.cobie.cobielite.core.WarrantyType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.erdc.cobie.cobielite.core.WarrantyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
