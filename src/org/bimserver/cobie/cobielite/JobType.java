/*
 * XML Type:  JobType
 * Namespace: cobielite.cobie.bimserver.org
 * Java type: org.bimserver.cobie.cobielite.JobType
 *
 * Automatically generated - do not modify.
 */
package org.bimserver.cobie.cobielite;


/**
 * An XML JobType(@cobielite.cobie.bimserver.org).
 *
 * This is a complex type.
 */
public interface JobType extends org.bimserver.cobie.cobielite.COBIEBaseType
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(JobType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8D4E9650049F3102F3468D9198074B0A").resolveHandle("jobtypede63type");
    
    /**
     * Gets the "CreatedBy" element
     */
    java.lang.String getCreatedBy();
    
    /**
     * Gets (as xml) the "CreatedBy" element
     */
    org.bimserver.cobie.cobielite.EmailAddressType xgetCreatedBy();
    
    /**
     * Sets the "CreatedBy" element
     */
    void setCreatedBy(java.lang.String createdBy);
    
    /**
     * Sets (as xml) the "CreatedBy" element
     */
    void xsetCreatedBy(org.bimserver.cobie.cobielite.EmailAddressType createdBy);
    
    /**
     * Gets the "CreatedOn" element
     */
    java.util.Calendar getCreatedOn();
    
    /**
     * Gets (as xml) the "CreatedOn" element
     */
    org.apache.xmlbeans.XmlDateTime xgetCreatedOn();
    
    /**
     * Sets the "CreatedOn" element
     */
    void setCreatedOn(java.util.Calendar createdOn);
    
    /**
     * Sets (as xml) the "CreatedOn" element
     */
    void xsetCreatedOn(org.apache.xmlbeans.XmlDateTime createdOn);
    
    /**
     * Gets the "Category" element
     */
    java.lang.String getCategory();
    
    /**
     * Gets (as xml) the "Category" element
     */
    org.apache.xmlbeans.XmlString xgetCategory();
    
    /**
     * Sets the "Category" element
     */
    void setCategory(java.lang.String category);
    
    /**
     * Sets (as xml) the "Category" element
     */
    void xsetCategory(org.apache.xmlbeans.XmlString category);
    
    /**
     * Gets the "Status" element
     */
    java.lang.String getStatus();
    
    /**
     * Gets (as xml) the "Status" element
     */
    org.apache.xmlbeans.XmlString xgetStatus();
    
    /**
     * Sets the "Status" element
     */
    void setStatus(java.lang.String status);
    
    /**
     * Sets (as xml) the "Status" element
     */
    void xsetStatus(org.apache.xmlbeans.XmlString status);
    
    /**
     * Gets the "TypeName" element
     */
    java.lang.String getTypeName();
    
    /**
     * Gets (as xml) the "TypeName" element
     */
    org.apache.xmlbeans.XmlString xgetTypeName();
    
    /**
     * Sets the "TypeName" element
     */
    void setTypeName(java.lang.String typeName);
    
    /**
     * Sets (as xml) the "TypeName" element
     */
    void xsetTypeName(org.apache.xmlbeans.XmlString typeName);
    
    /**
     * Gets the "Description" element
     */
    java.lang.String getDescription();
    
    /**
     * Gets (as xml) the "Description" element
     */
    org.apache.xmlbeans.XmlString xgetDescription();
    
    /**
     * Sets the "Description" element
     */
    void setDescription(java.lang.String description);
    
    /**
     * Sets (as xml) the "Description" element
     */
    void xsetDescription(org.apache.xmlbeans.XmlString description);
    
    /**
     * Gets the "Duration" element
     */
    java.lang.String getDuration();
    
    /**
     * Gets (as xml) the "Duration" element
     */
    org.apache.xmlbeans.XmlString xgetDuration();
    
    /**
     * Sets the "Duration" element
     */
    void setDuration(java.lang.String duration);
    
    /**
     * Sets (as xml) the "Duration" element
     */
    void xsetDuration(org.apache.xmlbeans.XmlString duration);
    
    /**
     * Gets the "DurationUnit" element
     */
    java.lang.String getDurationUnit();
    
    /**
     * Gets (as xml) the "DurationUnit" element
     */
    org.apache.xmlbeans.XmlString xgetDurationUnit();
    
    /**
     * Sets the "DurationUnit" element
     */
    void setDurationUnit(java.lang.String durationUnit);
    
    /**
     * Sets (as xml) the "DurationUnit" element
     */
    void xsetDurationUnit(org.apache.xmlbeans.XmlString durationUnit);
    
    /**
     * Gets the "Start" element
     */
    java.lang.String getStart();
    
    /**
     * Gets (as xml) the "Start" element
     */
    org.apache.xmlbeans.XmlString xgetStart();
    
    /**
     * Sets the "Start" element
     */
    void setStart(java.lang.String start);
    
    /**
     * Sets (as xml) the "Start" element
     */
    void xsetStart(org.apache.xmlbeans.XmlString start);
    
    /**
     * Gets the "TaskStartUnit" element
     */
    java.lang.String getTaskStartUnit();
    
    /**
     * Gets (as xml) the "TaskStartUnit" element
     */
    org.apache.xmlbeans.XmlString xgetTaskStartUnit();
    
    /**
     * Sets the "TaskStartUnit" element
     */
    void setTaskStartUnit(java.lang.String taskStartUnit);
    
    /**
     * Sets (as xml) the "TaskStartUnit" element
     */
    void xsetTaskStartUnit(org.apache.xmlbeans.XmlString taskStartUnit);
    
    /**
     * Gets the "Frequency" element
     */
    java.lang.String getFrequency();
    
    /**
     * Gets (as xml) the "Frequency" element
     */
    org.apache.xmlbeans.XmlString xgetFrequency();
    
    /**
     * Sets the "Frequency" element
     */
    void setFrequency(java.lang.String frequency);
    
    /**
     * Sets (as xml) the "Frequency" element
     */
    void xsetFrequency(org.apache.xmlbeans.XmlString frequency);
    
    /**
     * Gets the "FrequencyUnit" element
     */
    java.lang.String getFrequencyUnit();
    
    /**
     * Gets (as xml) the "FrequencyUnit" element
     */
    org.apache.xmlbeans.XmlString xgetFrequencyUnit();
    
    /**
     * Sets the "FrequencyUnit" element
     */
    void setFrequencyUnit(java.lang.String frequencyUnit);
    
    /**
     * Sets (as xml) the "FrequencyUnit" element
     */
    void xsetFrequencyUnit(org.apache.xmlbeans.XmlString frequencyUnit);
    
    /**
     * Gets the "ExtSystem" element
     */
    java.lang.String getExtSystem();
    
    /**
     * Gets (as xml) the "ExtSystem" element
     */
    org.apache.xmlbeans.XmlString xgetExtSystem();
    
    /**
     * Sets the "ExtSystem" element
     */
    void setExtSystem(java.lang.String extSystem);
    
    /**
     * Sets (as xml) the "ExtSystem" element
     */
    void xsetExtSystem(org.apache.xmlbeans.XmlString extSystem);
    
    /**
     * Gets the "ExtObject" element
     */
    java.lang.String getExtObject();
    
    /**
     * Gets (as xml) the "ExtObject" element
     */
    org.apache.xmlbeans.XmlString xgetExtObject();
    
    /**
     * Sets the "ExtObject" element
     */
    void setExtObject(java.lang.String extObject);
    
    /**
     * Sets (as xml) the "ExtObject" element
     */
    void xsetExtObject(org.apache.xmlbeans.XmlString extObject);
    
    /**
     * Gets the "ExtIdentifier" element
     */
    java.lang.String getExtIdentifier();
    
    /**
     * Gets (as xml) the "ExtIdentifier" element
     */
    org.apache.xmlbeans.XmlString xgetExtIdentifier();
    
    /**
     * Sets the "ExtIdentifier" element
     */
    void setExtIdentifier(java.lang.String extIdentifier);
    
    /**
     * Sets (as xml) the "ExtIdentifier" element
     */
    void xsetExtIdentifier(org.apache.xmlbeans.XmlString extIdentifier);
    
    /**
     * Gets the "TaskNumber" element
     */
    java.lang.String getTaskNumber();
    
    /**
     * Gets (as xml) the "TaskNumber" element
     */
    org.apache.xmlbeans.XmlString xgetTaskNumber();
    
    /**
     * Sets the "TaskNumber" element
     */
    void setTaskNumber(java.lang.String taskNumber);
    
    /**
     * Sets (as xml) the "TaskNumber" element
     */
    void xsetTaskNumber(org.apache.xmlbeans.XmlString taskNumber);
    
    /**
     * Gets the "Priors" element
     */
    java.lang.String getPriors();
    
    /**
     * Gets (as xml) the "Priors" element
     */
    org.apache.xmlbeans.XmlString xgetPriors();
    
    /**
     * Sets the "Priors" element
     */
    void setPriors(java.lang.String priors);
    
    /**
     * Sets (as xml) the "Priors" element
     */
    void xsetPriors(org.apache.xmlbeans.XmlString priors);
    
    /**
     * Gets the "ResourceNames" element
     */
    java.lang.String getResourceNames();
    
    /**
     * Gets (as xml) the "ResourceNames" element
     */
    org.apache.xmlbeans.XmlString xgetResourceNames();
    
    /**
     * Sets the "ResourceNames" element
     */
    void setResourceNames(java.lang.String resourceNames);
    
    /**
     * Sets (as xml) the "ResourceNames" element
     */
    void xsetResourceNames(org.apache.xmlbeans.XmlString resourceNames);
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static org.bimserver.cobie.cobielite.JobType newInstance() {
          return (org.bimserver.cobie.cobielite.JobType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static org.bimserver.cobie.cobielite.JobType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (org.bimserver.cobie.cobielite.JobType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static org.bimserver.cobie.cobielite.JobType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (org.bimserver.cobie.cobielite.JobType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static org.bimserver.cobie.cobielite.JobType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.bimserver.cobie.cobielite.JobType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static org.bimserver.cobie.cobielite.JobType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bimserver.cobie.cobielite.JobType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static org.bimserver.cobie.cobielite.JobType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bimserver.cobie.cobielite.JobType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static org.bimserver.cobie.cobielite.JobType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bimserver.cobie.cobielite.JobType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static org.bimserver.cobie.cobielite.JobType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bimserver.cobie.cobielite.JobType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static org.bimserver.cobie.cobielite.JobType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bimserver.cobie.cobielite.JobType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static org.bimserver.cobie.cobielite.JobType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bimserver.cobie.cobielite.JobType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static org.bimserver.cobie.cobielite.JobType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bimserver.cobie.cobielite.JobType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static org.bimserver.cobie.cobielite.JobType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bimserver.cobie.cobielite.JobType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static org.bimserver.cobie.cobielite.JobType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (org.bimserver.cobie.cobielite.JobType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static org.bimserver.cobie.cobielite.JobType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.bimserver.cobie.cobielite.JobType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static org.bimserver.cobie.cobielite.JobType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (org.bimserver.cobie.cobielite.JobType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static org.bimserver.cobie.cobielite.JobType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.bimserver.cobie.cobielite.JobType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.bimserver.cobie.cobielite.JobType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.bimserver.cobie.cobielite.JobType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.bimserver.cobie.cobielite.JobType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.bimserver.cobie.cobielite.JobType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
