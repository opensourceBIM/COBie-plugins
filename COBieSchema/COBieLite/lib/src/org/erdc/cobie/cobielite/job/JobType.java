/*
 * XML Type:  JobType
 * Namespace: http://job.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.job.JobType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.job;


/**
 * An XML JobType(@http://job.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public interface JobType extends org.erdc.cobie.cobielite.core.JobType
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(JobType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s66652C141B24B73BD4333B57A0EF7E00").resolveHandle("jobtype1afdtype");
    
    /**
     * Gets the "JobCategory" element
     */
    java.lang.String getJobCategory();
    
    /**
     * Gets (as xml) the "JobCategory" element
     */
    org.erdc.cobie.cobielite.core.JobCategorySimpleType xgetJobCategory();
    
    /**
     * True if has "JobCategory" element
     */
    boolean isSetJobCategory();
    
    /**
     * Sets the "JobCategory" element
     */
    void setJobCategory(java.lang.String jobCategory);
    
    /**
     * Sets (as xml) the "JobCategory" element
     */
    void xsetJobCategory(org.erdc.cobie.cobielite.core.JobCategorySimpleType jobCategory);
    
    /**
     * Unsets the "JobCategory" element
     */
    void unsetJobCategory();
    
    /**
     * Gets the "JobStatus" element
     */
    java.lang.String getJobStatus();
    
    /**
     * Gets (as xml) the "JobStatus" element
     */
    org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetJobStatus();
    
    /**
     * True if has "JobStatus" element
     */
    boolean isSetJobStatus();
    
    /**
     * Sets the "JobStatus" element
     */
    void setJobStatus(java.lang.String jobStatus);
    
    /**
     * Sets (as xml) the "JobStatus" element
     */
    void xsetJobStatus(org.erdc.cobie.cobielite.core.CobieTextSimpleType jobStatus);
    
    /**
     * Unsets the "JobStatus" element
     */
    void unsetJobStatus();
    
    /**
     * Gets the "JobDescription" element
     */
    java.lang.String getJobDescription();
    
    /**
     * Gets (as xml) the "JobDescription" element
     */
    org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType xgetJobDescription();
    
    /**
     * True if has "JobDescription" element
     */
    boolean isSetJobDescription();
    
    /**
     * Sets the "JobDescription" element
     */
    void setJobDescription(java.lang.String jobDescription);
    
    /**
     * Sets (as xml) the "JobDescription" element
     */
    void xsetJobDescription(org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType jobDescription);
    
    /**
     * Unsets the "JobDescription" element
     */
    void unsetJobDescription();
    
    /**
     * Gets the "JobDuration" element
     */
    org.erdc.cobie.cobielite.core.IntegerValueType getJobDuration();
    
    /**
     * True if has "JobDuration" element
     */
    boolean isSetJobDuration();
    
    /**
     * Sets the "JobDuration" element
     */
    void setJobDuration(org.erdc.cobie.cobielite.core.IntegerValueType jobDuration);
    
    /**
     * Appends and returns a new empty "JobDuration" element
     */
    org.erdc.cobie.cobielite.core.IntegerValueType addNewJobDuration();
    
    /**
     * Unsets the "JobDuration" element
     */
    void unsetJobDuration();
    
    /**
     * Gets the "JobStartDate" element
     */
    java.util.Calendar getJobStartDate();
    
    /**
     * Gets (as xml) the "JobStartDate" element
     */
    org.apache.xmlbeans.XmlDate xgetJobStartDate();
    
    /**
     * True if has "JobStartDate" element
     */
    boolean isSetJobStartDate();
    
    /**
     * Sets the "JobStartDate" element
     */
    void setJobStartDate(java.util.Calendar jobStartDate);
    
    /**
     * Sets (as xml) the "JobStartDate" element
     */
    void xsetJobStartDate(org.apache.xmlbeans.XmlDate jobStartDate);
    
    /**
     * Unsets the "JobStartDate" element
     */
    void unsetJobStartDate();
    
    /**
     * Gets the "JobStartConditionDescription" element
     */
    java.lang.String getJobStartConditionDescription();
    
    /**
     * Gets (as xml) the "JobStartConditionDescription" element
     */
    org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetJobStartConditionDescription();
    
    /**
     * True if has "JobStartConditionDescription" element
     */
    boolean isSetJobStartConditionDescription();
    
    /**
     * Sets the "JobStartConditionDescription" element
     */
    void setJobStartConditionDescription(java.lang.String jobStartConditionDescription);
    
    /**
     * Sets (as xml) the "JobStartConditionDescription" element
     */
    void xsetJobStartConditionDescription(org.erdc.cobie.cobielite.core.CobieTextSimpleType jobStartConditionDescription);
    
    /**
     * Unsets the "JobStartConditionDescription" element
     */
    void unsetJobStartConditionDescription();
    
    /**
     * Gets the "JobFrequencyValue" element
     */
    org.erdc.cobie.cobielite.core.DecimalValueType getJobFrequencyValue();
    
    /**
     * True if has "JobFrequencyValue" element
     */
    boolean isSetJobFrequencyValue();
    
    /**
     * Sets the "JobFrequencyValue" element
     */
    void setJobFrequencyValue(org.erdc.cobie.cobielite.core.DecimalValueType jobFrequencyValue);
    
    /**
     * Appends and returns a new empty "JobFrequencyValue" element
     */
    org.erdc.cobie.cobielite.core.DecimalValueType addNewJobFrequencyValue();
    
    /**
     * Unsets the "JobFrequencyValue" element
     */
    void unsetJobFrequencyValue();
    
    /**
     * Gets the "JobPriorTaskID" element
     */
    java.lang.String getJobPriorTaskID();
    
    /**
     * Gets (as xml) the "JobPriorTaskID" element
     */
    org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetJobPriorTaskID();
    
    /**
     * True if has "JobPriorTaskID" element
     */
    boolean isSetJobPriorTaskID();
    
    /**
     * Sets the "JobPriorTaskID" element
     */
    void setJobPriorTaskID(java.lang.String jobPriorTaskID);
    
    /**
     * Sets (as xml) the "JobPriorTaskID" element
     */
    void xsetJobPriorTaskID(org.erdc.cobie.cobielite.core.CobieTextSimpleType jobPriorTaskID);
    
    /**
     * Unsets the "JobPriorTaskID" element
     */
    void unsetJobPriorTaskID();
    
    /**
     * Gets the "Resources" element
     */
    org.erdc.cobie.cobielite.core.ResourceCollectionType getResources();
    
    /**
     * True if has "Resources" element
     */
    boolean isSetResources();
    
    /**
     * Sets the "Resources" element
     */
    void setResources(org.erdc.cobie.cobielite.core.ResourceCollectionType resources);
    
    /**
     * Appends and returns a new empty "Resources" element
     */
    org.erdc.cobie.cobielite.core.ResourceCollectionType addNewResources();
    
    /**
     * Unsets the "Resources" element
     */
    void unsetResources();
    
    /**
     * Gets the "JobAttributes" element
     */
    org.erdc.cobie.cobielite.core.AttributeCollectionType getJobAttributes();
    
    /**
     * True if has "JobAttributes" element
     */
    boolean isSetJobAttributes();
    
    /**
     * Sets the "JobAttributes" element
     */
    void setJobAttributes(org.erdc.cobie.cobielite.core.AttributeCollectionType jobAttributes);
    
    /**
     * Appends and returns a new empty "JobAttributes" element
     */
    org.erdc.cobie.cobielite.core.AttributeCollectionType addNewJobAttributes();
    
    /**
     * Unsets the "JobAttributes" element
     */
    void unsetJobAttributes();
    
    /**
     * Gets the "JobDocuments" element
     */
    org.erdc.cobie.cobielite.core.DocumentCollectionType getJobDocuments();
    
    /**
     * True if has "JobDocuments" element
     */
    boolean isSetJobDocuments();
    
    /**
     * Sets the "JobDocuments" element
     */
    void setJobDocuments(org.erdc.cobie.cobielite.core.DocumentCollectionType jobDocuments);
    
    /**
     * Appends and returns a new empty "JobDocuments" element
     */
    org.erdc.cobie.cobielite.core.DocumentCollectionType addNewJobDocuments();
    
    /**
     * Unsets the "JobDocuments" element
     */
    void unsetJobDocuments();
    
    /**
     * Gets the "JobIssues" element
     */
    org.erdc.cobie.cobielite.core.IssueCollectionType getJobIssues();
    
    /**
     * True if has "JobIssues" element
     */
    boolean isSetJobIssues();
    
    /**
     * Sets the "JobIssues" element
     */
    void setJobIssues(org.erdc.cobie.cobielite.core.IssueCollectionType jobIssues);
    
    /**
     * Appends and returns a new empty "JobIssues" element
     */
    org.erdc.cobie.cobielite.core.IssueCollectionType addNewJobIssues();
    
    /**
     * Unsets the "JobIssues" element
     */
    void unsetJobIssues();
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static org.erdc.cobie.cobielite.job.JobType newInstance() {
          return (org.erdc.cobie.cobielite.job.JobType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static org.erdc.cobie.cobielite.job.JobType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (org.erdc.cobie.cobielite.job.JobType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static org.erdc.cobie.cobielite.job.JobType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.job.JobType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static org.erdc.cobie.cobielite.job.JobType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.job.JobType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static org.erdc.cobie.cobielite.job.JobType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.job.JobType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static org.erdc.cobie.cobielite.job.JobType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.job.JobType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static org.erdc.cobie.cobielite.job.JobType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.job.JobType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static org.erdc.cobie.cobielite.job.JobType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.job.JobType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static org.erdc.cobie.cobielite.job.JobType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.job.JobType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static org.erdc.cobie.cobielite.job.JobType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.job.JobType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static org.erdc.cobie.cobielite.job.JobType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.job.JobType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static org.erdc.cobie.cobielite.job.JobType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.job.JobType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static org.erdc.cobie.cobielite.job.JobType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.job.JobType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static org.erdc.cobie.cobielite.job.JobType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.job.JobType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static org.erdc.cobie.cobielite.job.JobType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.job.JobType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static org.erdc.cobie.cobielite.job.JobType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.job.JobType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.erdc.cobie.cobielite.job.JobType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.erdc.cobie.cobielite.job.JobType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.erdc.cobie.cobielite.job.JobType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.erdc.cobie.cobielite.job.JobType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
