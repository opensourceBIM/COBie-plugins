/*
 * XML Type:  IssueType
 * Namespace: http://issue.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.issue.IssueType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.issue;


/**
 * An XML IssueType(@http://issue.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public interface IssueType extends org.erdc.cobie.cobielite.core.IssueType
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(IssueType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sDB8A4E468FD3CA78BBE0CAC69C637E16").resolveHandle("issuetype95bdtype");
    
    /**
     * Gets the "IssueRiskText" element
     */
    java.lang.String getIssueRiskText();
    
    /**
     * Gets (as xml) the "IssueRiskText" element
     */
    org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetIssueRiskText();
    
    /**
     * True if has "IssueRiskText" element
     */
    boolean isSetIssueRiskText();
    
    /**
     * Sets the "IssueRiskText" element
     */
    void setIssueRiskText(java.lang.String issueRiskText);
    
    /**
     * Sets (as xml) the "IssueRiskText" element
     */
    void xsetIssueRiskText(org.erdc.cobie.cobielite.core.CobieTextSimpleType issueRiskText);
    
    /**
     * Unsets the "IssueRiskText" element
     */
    void unsetIssueRiskText();
    
    /**
     * Gets the "IssueSeverityText" element
     */
    java.lang.String getIssueSeverityText();
    
    /**
     * Gets (as xml) the "IssueSeverityText" element
     */
    org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetIssueSeverityText();
    
    /**
     * True if has "IssueSeverityText" element
     */
    boolean isSetIssueSeverityText();
    
    /**
     * Sets the "IssueSeverityText" element
     */
    void setIssueSeverityText(java.lang.String issueSeverityText);
    
    /**
     * Sets (as xml) the "IssueSeverityText" element
     */
    void xsetIssueSeverityText(org.erdc.cobie.cobielite.core.CobieTextSimpleType issueSeverityText);
    
    /**
     * Unsets the "IssueSeverityText" element
     */
    void unsetIssueSeverityText();
    
    /**
     * Gets the "IssueImpactText" element
     */
    java.lang.String getIssueImpactText();
    
    /**
     * Gets (as xml) the "IssueImpactText" element
     */
    org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetIssueImpactText();
    
    /**
     * True if has "IssueImpactText" element
     */
    boolean isSetIssueImpactText();
    
    /**
     * Sets the "IssueImpactText" element
     */
    void setIssueImpactText(java.lang.String issueImpactText);
    
    /**
     * Sets (as xml) the "IssueImpactText" element
     */
    void xsetIssueImpactText(org.erdc.cobie.cobielite.core.CobieTextSimpleType issueImpactText);
    
    /**
     * Unsets the "IssueImpactText" element
     */
    void unsetIssueImpactText();
    
    /**
     * Gets the "IssueDescription" element
     */
    java.lang.String getIssueDescription();
    
    /**
     * Gets (as xml) the "IssueDescription" element
     */
    org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetIssueDescription();
    
    /**
     * True if has "IssueDescription" element
     */
    boolean isSetIssueDescription();
    
    /**
     * Sets the "IssueDescription" element
     */
    void setIssueDescription(java.lang.String issueDescription);
    
    /**
     * Sets (as xml) the "IssueDescription" element
     */
    void xsetIssueDescription(org.erdc.cobie.cobielite.core.CobieTextSimpleType issueDescription);
    
    /**
     * Unsets the "IssueDescription" element
     */
    void unsetIssueDescription();
    
    /**
     * Gets the "ContactAssignment" element
     */
    org.erdc.cobie.cobielite.core.ContactKeyType getContactAssignment();
    
    /**
     * True if has "ContactAssignment" element
     */
    boolean isSetContactAssignment();
    
    /**
     * Sets the "ContactAssignment" element
     */
    void setContactAssignment(org.erdc.cobie.cobielite.core.ContactKeyType contactAssignment);
    
    /**
     * Appends and returns a new empty "ContactAssignment" element
     */
    org.erdc.cobie.cobielite.core.ContactKeyType addNewContactAssignment();
    
    /**
     * Unsets the "ContactAssignment" element
     */
    void unsetContactAssignment();
    
    /**
     * Gets the "IssueMitigationDescription" element
     */
    java.lang.String getIssueMitigationDescription();
    
    /**
     * Gets (as xml) the "IssueMitigationDescription" element
     */
    org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetIssueMitigationDescription();
    
    /**
     * True if has "IssueMitigationDescription" element
     */
    boolean isSetIssueMitigationDescription();
    
    /**
     * Sets the "IssueMitigationDescription" element
     */
    void setIssueMitigationDescription(java.lang.String issueMitigationDescription);
    
    /**
     * Sets (as xml) the "IssueMitigationDescription" element
     */
    void xsetIssueMitigationDescription(org.erdc.cobie.cobielite.core.CobieTextSimpleType issueMitigationDescription);
    
    /**
     * Unsets the "IssueMitigationDescription" element
     */
    void unsetIssueMitigationDescription();
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static org.erdc.cobie.cobielite.issue.IssueType newInstance() {
          return (org.erdc.cobie.cobielite.issue.IssueType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static org.erdc.cobie.cobielite.issue.IssueType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (org.erdc.cobie.cobielite.issue.IssueType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static org.erdc.cobie.cobielite.issue.IssueType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.issue.IssueType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static org.erdc.cobie.cobielite.issue.IssueType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.issue.IssueType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static org.erdc.cobie.cobielite.issue.IssueType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.issue.IssueType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static org.erdc.cobie.cobielite.issue.IssueType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.issue.IssueType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static org.erdc.cobie.cobielite.issue.IssueType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.issue.IssueType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static org.erdc.cobie.cobielite.issue.IssueType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.issue.IssueType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static org.erdc.cobie.cobielite.issue.IssueType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.issue.IssueType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static org.erdc.cobie.cobielite.issue.IssueType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.issue.IssueType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static org.erdc.cobie.cobielite.issue.IssueType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.issue.IssueType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static org.erdc.cobie.cobielite.issue.IssueType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.issue.IssueType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static org.erdc.cobie.cobielite.issue.IssueType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.issue.IssueType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static org.erdc.cobie.cobielite.issue.IssueType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.issue.IssueType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static org.erdc.cobie.cobielite.issue.IssueType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.issue.IssueType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static org.erdc.cobie.cobielite.issue.IssueType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.issue.IssueType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.erdc.cobie.cobielite.issue.IssueType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.erdc.cobie.cobielite.issue.IssueType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.erdc.cobie.cobielite.issue.IssueType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.erdc.cobie.cobielite.issue.IssueType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
