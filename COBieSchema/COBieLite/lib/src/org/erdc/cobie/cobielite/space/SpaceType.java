/*
 * XML Type:  SpaceType
 * Namespace: http://space.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.space.SpaceType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.space;


/**
 * An XML SpaceType(@http://space.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public interface SpaceType extends org.erdc.cobie.cobielite.core.SpaceType
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(SpaceType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sC7CAE39C2CC479123ADE186B88FEDB2D").resolveHandle("spacetypeaa1dtype");
    
    /**
     * Gets the "SpaceCategory" element
     */
    java.lang.String getSpaceCategory();
    
    /**
     * Gets (as xml) the "SpaceCategory" element
     */
    org.erdc.cobie.cobielite.core.SpaceCategorySimpleType xgetSpaceCategory();
    
    /**
     * True if has "SpaceCategory" element
     */
    boolean isSetSpaceCategory();
    
    /**
     * Sets the "SpaceCategory" element
     */
    void setSpaceCategory(java.lang.String spaceCategory);
    
    /**
     * Sets (as xml) the "SpaceCategory" element
     */
    void xsetSpaceCategory(org.erdc.cobie.cobielite.core.SpaceCategorySimpleType spaceCategory);
    
    /**
     * Unsets the "SpaceCategory" element
     */
    void unsetSpaceCategory();
    
    /**
     * Gets the "SpaceDescription" element
     */
    java.lang.String getSpaceDescription();
    
    /**
     * Gets (as xml) the "SpaceDescription" element
     */
    org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType xgetSpaceDescription();
    
    /**
     * True if has "SpaceDescription" element
     */
    boolean isSetSpaceDescription();
    
    /**
     * Sets the "SpaceDescription" element
     */
    void setSpaceDescription(java.lang.String spaceDescription);
    
    /**
     * Sets (as xml) the "SpaceDescription" element
     */
    void xsetSpaceDescription(org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType spaceDescription);
    
    /**
     * Unsets the "SpaceDescription" element
     */
    void unsetSpaceDescription();
    
    /**
     * Gets the "SpaceSignageName" element
     */
    java.lang.String getSpaceSignageName();
    
    /**
     * Gets (as xml) the "SpaceSignageName" element
     */
    org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetSpaceSignageName();
    
    /**
     * True if has "SpaceSignageName" element
     */
    boolean isSetSpaceSignageName();
    
    /**
     * Sets the "SpaceSignageName" element
     */
    void setSpaceSignageName(java.lang.String spaceSignageName);
    
    /**
     * Sets (as xml) the "SpaceSignageName" element
     */
    void xsetSpaceSignageName(org.erdc.cobie.cobielite.core.CobieTextSimpleType spaceSignageName);
    
    /**
     * Unsets the "SpaceSignageName" element
     */
    void unsetSpaceSignageName();
    
    /**
     * Gets the "SpaceUsableHeightValue" element
     */
    org.erdc.cobie.cobielite.core.DecimalValueType getSpaceUsableHeightValue();
    
    /**
     * True if has "SpaceUsableHeightValue" element
     */
    boolean isSetSpaceUsableHeightValue();
    
    /**
     * Sets the "SpaceUsableHeightValue" element
     */
    void setSpaceUsableHeightValue(org.erdc.cobie.cobielite.core.DecimalValueType spaceUsableHeightValue);
    
    /**
     * Appends and returns a new empty "SpaceUsableHeightValue" element
     */
    org.erdc.cobie.cobielite.core.DecimalValueType addNewSpaceUsableHeightValue();
    
    /**
     * Unsets the "SpaceUsableHeightValue" element
     */
    void unsetSpaceUsableHeightValue();
    
    /**
     * Gets the "SpaceGrossAreaValue" element
     */
    org.erdc.cobie.cobielite.core.DecimalValueType getSpaceGrossAreaValue();
    
    /**
     * True if has "SpaceGrossAreaValue" element
     */
    boolean isSetSpaceGrossAreaValue();
    
    /**
     * Sets the "SpaceGrossAreaValue" element
     */
    void setSpaceGrossAreaValue(org.erdc.cobie.cobielite.core.DecimalValueType spaceGrossAreaValue);
    
    /**
     * Appends and returns a new empty "SpaceGrossAreaValue" element
     */
    org.erdc.cobie.cobielite.core.DecimalValueType addNewSpaceGrossAreaValue();
    
    /**
     * Unsets the "SpaceGrossAreaValue" element
     */
    void unsetSpaceGrossAreaValue();
    
    /**
     * Gets the "SpaceNetAreaValue" element
     */
    org.erdc.cobie.cobielite.core.DecimalValueType getSpaceNetAreaValue();
    
    /**
     * True if has "SpaceNetAreaValue" element
     */
    boolean isSetSpaceNetAreaValue();
    
    /**
     * Sets the "SpaceNetAreaValue" element
     */
    void setSpaceNetAreaValue(org.erdc.cobie.cobielite.core.DecimalValueType spaceNetAreaValue);
    
    /**
     * Appends and returns a new empty "SpaceNetAreaValue" element
     */
    org.erdc.cobie.cobielite.core.DecimalValueType addNewSpaceNetAreaValue();
    
    /**
     * Unsets the "SpaceNetAreaValue" element
     */
    void unsetSpaceNetAreaValue();
    
    /**
     * Gets the "Space2DShape" element
     */
    org.erdc.cobie.cobielite.core.PolygonCollectionType getSpace2DShape();
    
    /**
     * True if has "Space2DShape" element
     */
    boolean isSetSpace2DShape();
    
    /**
     * Sets the "Space2DShape" element
     */
    void setSpace2DShape(org.erdc.cobie.cobielite.core.PolygonCollectionType space2DShape);
    
    /**
     * Appends and returns a new empty "Space2DShape" element
     */
    org.erdc.cobie.cobielite.core.PolygonCollectionType addNewSpace2DShape();
    
    /**
     * Unsets the "Space2DShape" element
     */
    void unsetSpace2DShape();
    
    /**
     * Gets the "SpaceZoneAssignments" element
     */
    org.erdc.cobie.cobielite.core.ZoneAssignmentCollectionType getSpaceZoneAssignments();
    
    /**
     * True if has "SpaceZoneAssignments" element
     */
    boolean isSetSpaceZoneAssignments();
    
    /**
     * Sets the "SpaceZoneAssignments" element
     */
    void setSpaceZoneAssignments(org.erdc.cobie.cobielite.core.ZoneAssignmentCollectionType spaceZoneAssignments);
    
    /**
     * Appends and returns a new empty "SpaceZoneAssignments" element
     */
    org.erdc.cobie.cobielite.core.ZoneAssignmentCollectionType addNewSpaceZoneAssignments();
    
    /**
     * Unsets the "SpaceZoneAssignments" element
     */
    void unsetSpaceZoneAssignments();
    
    /**
     * Gets the "SpaceAttributes" element
     */
    org.erdc.cobie.cobielite.core.AttributeCollectionType getSpaceAttributes();
    
    /**
     * True if has "SpaceAttributes" element
     */
    boolean isSetSpaceAttributes();
    
    /**
     * Sets the "SpaceAttributes" element
     */
    void setSpaceAttributes(org.erdc.cobie.cobielite.core.AttributeCollectionType spaceAttributes);
    
    /**
     * Appends and returns a new empty "SpaceAttributes" element
     */
    org.erdc.cobie.cobielite.core.AttributeCollectionType addNewSpaceAttributes();
    
    /**
     * Unsets the "SpaceAttributes" element
     */
    void unsetSpaceAttributes();
    
    /**
     * Gets the "SpaceDocuments" element
     */
    org.erdc.cobie.cobielite.core.DocumentCollectionType getSpaceDocuments();
    
    /**
     * True if has "SpaceDocuments" element
     */
    boolean isSetSpaceDocuments();
    
    /**
     * Sets the "SpaceDocuments" element
     */
    void setSpaceDocuments(org.erdc.cobie.cobielite.core.DocumentCollectionType spaceDocuments);
    
    /**
     * Appends and returns a new empty "SpaceDocuments" element
     */
    org.erdc.cobie.cobielite.core.DocumentCollectionType addNewSpaceDocuments();
    
    /**
     * Unsets the "SpaceDocuments" element
     */
    void unsetSpaceDocuments();
    
    /**
     * Gets the "SpaceIssues" element
     */
    org.erdc.cobie.cobielite.core.IssueCollectionType getSpaceIssues();
    
    /**
     * True if has "SpaceIssues" element
     */
    boolean isSetSpaceIssues();
    
    /**
     * Sets the "SpaceIssues" element
     */
    void setSpaceIssues(org.erdc.cobie.cobielite.core.IssueCollectionType spaceIssues);
    
    /**
     * Appends and returns a new empty "SpaceIssues" element
     */
    org.erdc.cobie.cobielite.core.IssueCollectionType addNewSpaceIssues();
    
    /**
     * Unsets the "SpaceIssues" element
     */
    void unsetSpaceIssues();
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static org.erdc.cobie.cobielite.space.SpaceType newInstance() {
          return (org.erdc.cobie.cobielite.space.SpaceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static org.erdc.cobie.cobielite.space.SpaceType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (org.erdc.cobie.cobielite.space.SpaceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static org.erdc.cobie.cobielite.space.SpaceType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.space.SpaceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static org.erdc.cobie.cobielite.space.SpaceType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.space.SpaceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static org.erdc.cobie.cobielite.space.SpaceType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.space.SpaceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static org.erdc.cobie.cobielite.space.SpaceType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.space.SpaceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static org.erdc.cobie.cobielite.space.SpaceType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.space.SpaceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static org.erdc.cobie.cobielite.space.SpaceType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.space.SpaceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static org.erdc.cobie.cobielite.space.SpaceType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.space.SpaceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static org.erdc.cobie.cobielite.space.SpaceType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.space.SpaceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static org.erdc.cobie.cobielite.space.SpaceType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.space.SpaceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static org.erdc.cobie.cobielite.space.SpaceType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.space.SpaceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static org.erdc.cobie.cobielite.space.SpaceType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.space.SpaceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static org.erdc.cobie.cobielite.space.SpaceType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.space.SpaceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static org.erdc.cobie.cobielite.space.SpaceType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.space.SpaceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static org.erdc.cobie.cobielite.space.SpaceType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.space.SpaceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.erdc.cobie.cobielite.space.SpaceType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.erdc.cobie.cobielite.space.SpaceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.erdc.cobie.cobielite.space.SpaceType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.erdc.cobie.cobielite.space.SpaceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
