/*
 * XML Type:  FacilityType
 * Namespace: http://facility.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.facility.FacilityType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.facility;


/**
 * An XML FacilityType(@http://facility.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public interface FacilityType extends org.erdc.cobie.cobielite.core.FacilityType
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(FacilityType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s3CB9F4CCC0C9D802814557AAC3F0E7DA").resolveHandle("facilitytypeb2bftype");
    
    /**
     * Gets the "FacilityCategory" element
     */
    java.lang.String getFacilityCategory();
    
    /**
     * Gets (as xml) the "FacilityCategory" element
     */
    org.erdc.cobie.cobielite.core.FacilityCategorySimpleType xgetFacilityCategory();
    
    /**
     * True if has "FacilityCategory" element
     */
    boolean isSetFacilityCategory();
    
    /**
     * Sets the "FacilityCategory" element
     */
    void setFacilityCategory(java.lang.String facilityCategory);
    
    /**
     * Sets (as xml) the "FacilityCategory" element
     */
    void xsetFacilityCategory(org.erdc.cobie.cobielite.core.FacilityCategorySimpleType facilityCategory);
    
    /**
     * Unsets the "FacilityCategory" element
     */
    void unsetFacilityCategory();
    
    /**
     * Gets the "ProjectAssignment" element
     */
    org.erdc.cobie.cobielite.core.ProjectType getProjectAssignment();
    
    /**
     * True if has "ProjectAssignment" element
     */
    boolean isSetProjectAssignment();
    
    /**
     * Sets the "ProjectAssignment" element
     */
    void setProjectAssignment(org.erdc.cobie.cobielite.core.ProjectType projectAssignment);
    
    /**
     * Appends and returns a new empty "ProjectAssignment" element
     */
    org.erdc.cobie.cobielite.core.ProjectType addNewProjectAssignment();
    
    /**
     * Unsets the "ProjectAssignment" element
     */
    void unsetProjectAssignment();
    
    /**
     * Gets the "SiteAssignment" element
     */
    org.erdc.cobie.cobielite.core.SiteType getSiteAssignment();
    
    /**
     * True if has "SiteAssignment" element
     */
    boolean isSetSiteAssignment();
    
    /**
     * Sets the "SiteAssignment" element
     */
    void setSiteAssignment(org.erdc.cobie.cobielite.core.SiteType siteAssignment);
    
    /**
     * Appends and returns a new empty "SiteAssignment" element
     */
    org.erdc.cobie.cobielite.core.SiteType addNewSiteAssignment();
    
    /**
     * Unsets the "SiteAssignment" element
     */
    void unsetSiteAssignment();
    
    /**
     * Gets the "FacilityDefaultLinearUnit" element
     */
    org.erdc.cobie.cobielite.core.LinearUnitSimpleType.Enum getFacilityDefaultLinearUnit();
    
    /**
     * Gets (as xml) the "FacilityDefaultLinearUnit" element
     */
    org.erdc.cobie.cobielite.core.LinearUnitSimpleType xgetFacilityDefaultLinearUnit();
    
    /**
     * True if has "FacilityDefaultLinearUnit" element
     */
    boolean isSetFacilityDefaultLinearUnit();
    
    /**
     * Sets the "FacilityDefaultLinearUnit" element
     */
    void setFacilityDefaultLinearUnit(org.erdc.cobie.cobielite.core.LinearUnitSimpleType.Enum facilityDefaultLinearUnit);
    
    /**
     * Sets (as xml) the "FacilityDefaultLinearUnit" element
     */
    void xsetFacilityDefaultLinearUnit(org.erdc.cobie.cobielite.core.LinearUnitSimpleType facilityDefaultLinearUnit);
    
    /**
     * Unsets the "FacilityDefaultLinearUnit" element
     */
    void unsetFacilityDefaultLinearUnit();
    
    /**
     * Gets the "FacilityDefaultAreaUnit" element
     */
    org.erdc.cobie.cobielite.core.AreaUnitSimpleType.Enum getFacilityDefaultAreaUnit();
    
    /**
     * Gets (as xml) the "FacilityDefaultAreaUnit" element
     */
    org.erdc.cobie.cobielite.core.AreaUnitSimpleType xgetFacilityDefaultAreaUnit();
    
    /**
     * True if has "FacilityDefaultAreaUnit" element
     */
    boolean isSetFacilityDefaultAreaUnit();
    
    /**
     * Sets the "FacilityDefaultAreaUnit" element
     */
    void setFacilityDefaultAreaUnit(org.erdc.cobie.cobielite.core.AreaUnitSimpleType.Enum facilityDefaultAreaUnit);
    
    /**
     * Sets (as xml) the "FacilityDefaultAreaUnit" element
     */
    void xsetFacilityDefaultAreaUnit(org.erdc.cobie.cobielite.core.AreaUnitSimpleType facilityDefaultAreaUnit);
    
    /**
     * Unsets the "FacilityDefaultAreaUnit" element
     */
    void unsetFacilityDefaultAreaUnit();
    
    /**
     * Gets the "FacilityDefaultVolumeUnit" element
     */
    org.erdc.cobie.cobielite.core.VolumeUnitSimpleType.Enum getFacilityDefaultVolumeUnit();
    
    /**
     * Gets (as xml) the "FacilityDefaultVolumeUnit" element
     */
    org.erdc.cobie.cobielite.core.VolumeUnitSimpleType xgetFacilityDefaultVolumeUnit();
    
    /**
     * True if has "FacilityDefaultVolumeUnit" element
     */
    boolean isSetFacilityDefaultVolumeUnit();
    
    /**
     * Sets the "FacilityDefaultVolumeUnit" element
     */
    void setFacilityDefaultVolumeUnit(org.erdc.cobie.cobielite.core.VolumeUnitSimpleType.Enum facilityDefaultVolumeUnit);
    
    /**
     * Sets (as xml) the "FacilityDefaultVolumeUnit" element
     */
    void xsetFacilityDefaultVolumeUnit(org.erdc.cobie.cobielite.core.VolumeUnitSimpleType facilityDefaultVolumeUnit);
    
    /**
     * Unsets the "FacilityDefaultVolumeUnit" element
     */
    void unsetFacilityDefaultVolumeUnit();
    
    /**
     * Gets the "FacilityDefaultCurrencyUnit" element
     */
    org.erdc.cobie.cobielite.core.CurrencyUnitSimpleType.Enum getFacilityDefaultCurrencyUnit();
    
    /**
     * Gets (as xml) the "FacilityDefaultCurrencyUnit" element
     */
    org.erdc.cobie.cobielite.core.CurrencyUnitSimpleType xgetFacilityDefaultCurrencyUnit();
    
    /**
     * True if has "FacilityDefaultCurrencyUnit" element
     */
    boolean isSetFacilityDefaultCurrencyUnit();
    
    /**
     * Sets the "FacilityDefaultCurrencyUnit" element
     */
    void setFacilityDefaultCurrencyUnit(org.erdc.cobie.cobielite.core.CurrencyUnitSimpleType.Enum facilityDefaultCurrencyUnit);
    
    /**
     * Sets (as xml) the "FacilityDefaultCurrencyUnit" element
     */
    void xsetFacilityDefaultCurrencyUnit(org.erdc.cobie.cobielite.core.CurrencyUnitSimpleType facilityDefaultCurrencyUnit);
    
    /**
     * Unsets the "FacilityDefaultCurrencyUnit" element
     */
    void unsetFacilityDefaultCurrencyUnit();
    
    /**
     * Gets the "FacilityDefaultMeasurementStandard" element
     */
    java.lang.String getFacilityDefaultMeasurementStandard();
    
    /**
     * Gets (as xml) the "FacilityDefaultMeasurementStandard" element
     */
    org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetFacilityDefaultMeasurementStandard();
    
    /**
     * True if has "FacilityDefaultMeasurementStandard" element
     */
    boolean isSetFacilityDefaultMeasurementStandard();
    
    /**
     * Sets the "FacilityDefaultMeasurementStandard" element
     */
    void setFacilityDefaultMeasurementStandard(java.lang.String facilityDefaultMeasurementStandard);
    
    /**
     * Sets (as xml) the "FacilityDefaultMeasurementStandard" element
     */
    void xsetFacilityDefaultMeasurementStandard(org.erdc.cobie.cobielite.core.CobieTextSimpleType facilityDefaultMeasurementStandard);
    
    /**
     * Unsets the "FacilityDefaultMeasurementStandard" element
     */
    void unsetFacilityDefaultMeasurementStandard();
    
    /**
     * Gets the "FacilityDescription" element
     */
    java.lang.String getFacilityDescription();
    
    /**
     * Gets (as xml) the "FacilityDescription" element
     */
    org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType xgetFacilityDescription();
    
    /**
     * True if has "FacilityDescription" element
     */
    boolean isSetFacilityDescription();
    
    /**
     * Sets the "FacilityDescription" element
     */
    void setFacilityDescription(java.lang.String facilityDescription);
    
    /**
     * Sets (as xml) the "FacilityDescription" element
     */
    void xsetFacilityDescription(org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType facilityDescription);
    
    /**
     * Unsets the "FacilityDescription" element
     */
    void unsetFacilityDescription();
    
    /**
     * Gets the "FacilityDeliverablePhaseName" element
     */
    java.lang.String getFacilityDeliverablePhaseName();
    
    /**
     * Gets (as xml) the "FacilityDeliverablePhaseName" element
     */
    org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetFacilityDeliverablePhaseName();
    
    /**
     * True if has "FacilityDeliverablePhaseName" element
     */
    boolean isSetFacilityDeliverablePhaseName();
    
    /**
     * Sets the "FacilityDeliverablePhaseName" element
     */
    void setFacilityDeliverablePhaseName(java.lang.String facilityDeliverablePhaseName);
    
    /**
     * Sets (as xml) the "FacilityDeliverablePhaseName" element
     */
    void xsetFacilityDeliverablePhaseName(org.erdc.cobie.cobielite.core.CobieTextSimpleType facilityDeliverablePhaseName);
    
    /**
     * Unsets the "FacilityDeliverablePhaseName" element
     */
    void unsetFacilityDeliverablePhaseName();
    
    /**
     * Gets the "Floors" element
     */
    org.erdc.cobie.cobielite.core.FloorCollectionType getFloors();
    
    /**
     * True if has "Floors" element
     */
    boolean isSetFloors();
    
    /**
     * Sets the "Floors" element
     */
    void setFloors(org.erdc.cobie.cobielite.core.FloorCollectionType floors);
    
    /**
     * Appends and returns a new empty "Floors" element
     */
    org.erdc.cobie.cobielite.core.FloorCollectionType addNewFloors();
    
    /**
     * Unsets the "Floors" element
     */
    void unsetFloors();
    
    /**
     * Gets the "Zones" element
     */
    org.erdc.cobie.cobielite.core.ZoneCollectionType getZones();
    
    /**
     * True if has "Zones" element
     */
    boolean isSetZones();
    
    /**
     * Sets the "Zones" element
     */
    void setZones(org.erdc.cobie.cobielite.core.ZoneCollectionType zones);
    
    /**
     * Appends and returns a new empty "Zones" element
     */
    org.erdc.cobie.cobielite.core.ZoneCollectionType addNewZones();
    
    /**
     * Unsets the "Zones" element
     */
    void unsetZones();
    
    /**
     * Gets the "AssetTypes" element
     */
    org.erdc.cobie.cobielite.core.AssetTypeCollectionType getAssetTypes();
    
    /**
     * True if has "AssetTypes" element
     */
    boolean isSetAssetTypes();
    
    /**
     * Sets the "AssetTypes" element
     */
    void setAssetTypes(org.erdc.cobie.cobielite.core.AssetTypeCollectionType assetTypes);
    
    /**
     * Appends and returns a new empty "AssetTypes" element
     */
    org.erdc.cobie.cobielite.core.AssetTypeCollectionType addNewAssetTypes();
    
    /**
     * Unsets the "AssetTypes" element
     */
    void unsetAssetTypes();
    
    /**
     * Gets the "Systems" element
     */
    org.erdc.cobie.cobielite.core.SystemCollectionType getSystems();
    
    /**
     * True if has "Systems" element
     */
    boolean isSetSystems();
    
    /**
     * Sets the "Systems" element
     */
    void setSystems(org.erdc.cobie.cobielite.core.SystemCollectionType systems);
    
    /**
     * Appends and returns a new empty "Systems" element
     */
    org.erdc.cobie.cobielite.core.SystemCollectionType addNewSystems();
    
    /**
     * Unsets the "Systems" element
     */
    void unsetSystems();
    
    /**
     * Gets the "Connections" element
     */
    org.erdc.cobie.cobielite.core.ConnectionCollectionType getConnections();
    
    /**
     * True if has "Connections" element
     */
    boolean isSetConnections();
    
    /**
     * Sets the "Connections" element
     */
    void setConnections(org.erdc.cobie.cobielite.core.ConnectionCollectionType connections);
    
    /**
     * Appends and returns a new empty "Connections" element
     */
    org.erdc.cobie.cobielite.core.ConnectionCollectionType addNewConnections();
    
    /**
     * Unsets the "Connections" element
     */
    void unsetConnections();
    
    /**
     * Gets the "Contacts" element
     */
    org.erdc.cobie.cobielite.core.ContactCollectionType getContacts();
    
    /**
     * True if has "Contacts" element
     */
    boolean isSetContacts();
    
    /**
     * Sets the "Contacts" element
     */
    void setContacts(org.erdc.cobie.cobielite.core.ContactCollectionType contacts);
    
    /**
     * Appends and returns a new empty "Contacts" element
     */
    org.erdc.cobie.cobielite.core.ContactCollectionType addNewContacts();
    
    /**
     * Unsets the "Contacts" element
     */
    void unsetContacts();
    
    /**
     * Gets the "FacilityAttributes" element
     */
    org.erdc.cobie.cobielite.core.AttributeCollectionType getFacilityAttributes();
    
    /**
     * True if has "FacilityAttributes" element
     */
    boolean isSetFacilityAttributes();
    
    /**
     * Sets the "FacilityAttributes" element
     */
    void setFacilityAttributes(org.erdc.cobie.cobielite.core.AttributeCollectionType facilityAttributes);
    
    /**
     * Appends and returns a new empty "FacilityAttributes" element
     */
    org.erdc.cobie.cobielite.core.AttributeCollectionType addNewFacilityAttributes();
    
    /**
     * Unsets the "FacilityAttributes" element
     */
    void unsetFacilityAttributes();
    
    /**
     * Gets the "FacilityDocuments" element
     */
    org.erdc.cobie.cobielite.core.DocumentCollectionType getFacilityDocuments();
    
    /**
     * True if has "FacilityDocuments" element
     */
    boolean isSetFacilityDocuments();
    
    /**
     * Sets the "FacilityDocuments" element
     */
    void setFacilityDocuments(org.erdc.cobie.cobielite.core.DocumentCollectionType facilityDocuments);
    
    /**
     * Appends and returns a new empty "FacilityDocuments" element
     */
    org.erdc.cobie.cobielite.core.DocumentCollectionType addNewFacilityDocuments();
    
    /**
     * Unsets the "FacilityDocuments" element
     */
    void unsetFacilityDocuments();
    
    /**
     * Gets the "FacilityIssues" element
     */
    org.erdc.cobie.cobielite.core.IssueCollectionType getFacilityIssues();
    
    /**
     * True if has "FacilityIssues" element
     */
    boolean isSetFacilityIssues();
    
    /**
     * Sets the "FacilityIssues" element
     */
    void setFacilityIssues(org.erdc.cobie.cobielite.core.IssueCollectionType facilityIssues);
    
    /**
     * Appends and returns a new empty "FacilityIssues" element
     */
    org.erdc.cobie.cobielite.core.IssueCollectionType addNewFacilityIssues();
    
    /**
     * Unsets the "FacilityIssues" element
     */
    void unsetFacilityIssues();
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static org.erdc.cobie.cobielite.facility.FacilityType newInstance() {
          return (org.erdc.cobie.cobielite.facility.FacilityType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static org.erdc.cobie.cobielite.facility.FacilityType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (org.erdc.cobie.cobielite.facility.FacilityType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static org.erdc.cobie.cobielite.facility.FacilityType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.facility.FacilityType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static org.erdc.cobie.cobielite.facility.FacilityType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.facility.FacilityType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static org.erdc.cobie.cobielite.facility.FacilityType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.facility.FacilityType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static org.erdc.cobie.cobielite.facility.FacilityType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.facility.FacilityType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static org.erdc.cobie.cobielite.facility.FacilityType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.facility.FacilityType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static org.erdc.cobie.cobielite.facility.FacilityType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.facility.FacilityType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static org.erdc.cobie.cobielite.facility.FacilityType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.facility.FacilityType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static org.erdc.cobie.cobielite.facility.FacilityType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.facility.FacilityType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static org.erdc.cobie.cobielite.facility.FacilityType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.facility.FacilityType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static org.erdc.cobie.cobielite.facility.FacilityType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.facility.FacilityType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static org.erdc.cobie.cobielite.facility.FacilityType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.facility.FacilityType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static org.erdc.cobie.cobielite.facility.FacilityType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.facility.FacilityType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static org.erdc.cobie.cobielite.facility.FacilityType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.facility.FacilityType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static org.erdc.cobie.cobielite.facility.FacilityType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.facility.FacilityType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.erdc.cobie.cobielite.facility.FacilityType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.erdc.cobie.cobielite.facility.FacilityType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.erdc.cobie.cobielite.facility.FacilityType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.erdc.cobie.cobielite.facility.FacilityType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
