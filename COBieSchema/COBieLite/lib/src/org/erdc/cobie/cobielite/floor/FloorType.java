/*
 * XML Type:  FloorType
 * Namespace: http://floor.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.floor.FloorType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.floor;


/**
 * An XML FloorType(@http://floor.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public interface FloorType extends org.erdc.cobie.cobielite.core.FloorType
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(FloorType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sC7CAE39C2CC479123ADE186B88FEDB2D").resolveHandle("floortyped55dtype");
    
    /**
     * Gets the "FloorCategory" element
     */
    java.lang.String getFloorCategory();
    
    /**
     * Gets (as xml) the "FloorCategory" element
     */
    org.erdc.cobie.cobielite.core.FloorCategorySimpleType xgetFloorCategory();
    
    /**
     * True if has "FloorCategory" element
     */
    boolean isSetFloorCategory();
    
    /**
     * Sets the "FloorCategory" element
     */
    void setFloorCategory(java.lang.String floorCategory);
    
    /**
     * Sets (as xml) the "FloorCategory" element
     */
    void xsetFloorCategory(org.erdc.cobie.cobielite.core.FloorCategorySimpleType floorCategory);
    
    /**
     * Unsets the "FloorCategory" element
     */
    void unsetFloorCategory();
    
    /**
     * Gets the "FloorDescription" element
     */
    java.lang.String getFloorDescription();
    
    /**
     * Gets (as xml) the "FloorDescription" element
     */
    org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType xgetFloorDescription();
    
    /**
     * True if has "FloorDescription" element
     */
    boolean isSetFloorDescription();
    
    /**
     * Sets the "FloorDescription" element
     */
    void setFloorDescription(java.lang.String floorDescription);
    
    /**
     * Sets (as xml) the "FloorDescription" element
     */
    void xsetFloorDescription(org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType floorDescription);
    
    /**
     * Unsets the "FloorDescription" element
     */
    void unsetFloorDescription();
    
    /**
     * Gets the "FloorElevationValue" element
     */
    org.erdc.cobie.cobielite.core.DecimalValueType getFloorElevationValue();
    
    /**
     * True if has "FloorElevationValue" element
     */
    boolean isSetFloorElevationValue();
    
    /**
     * Sets the "FloorElevationValue" element
     */
    void setFloorElevationValue(org.erdc.cobie.cobielite.core.DecimalValueType floorElevationValue);
    
    /**
     * Appends and returns a new empty "FloorElevationValue" element
     */
    org.erdc.cobie.cobielite.core.DecimalValueType addNewFloorElevationValue();
    
    /**
     * Unsets the "FloorElevationValue" element
     */
    void unsetFloorElevationValue();
    
    /**
     * Gets the "FloorHeightValue" element
     */
    org.erdc.cobie.cobielite.core.DecimalValueType getFloorHeightValue();
    
    /**
     * True if has "FloorHeightValue" element
     */
    boolean isSetFloorHeightValue();
    
    /**
     * Sets the "FloorHeightValue" element
     */
    void setFloorHeightValue(org.erdc.cobie.cobielite.core.DecimalValueType floorHeightValue);
    
    /**
     * Appends and returns a new empty "FloorHeightValue" element
     */
    org.erdc.cobie.cobielite.core.DecimalValueType addNewFloorHeightValue();
    
    /**
     * Unsets the "FloorHeightValue" element
     */
    void unsetFloorHeightValue();
    
    /**
     * Gets the "Spaces" element
     */
    org.erdc.cobie.cobielite.core.SpaceCollectionType getSpaces();
    
    /**
     * True if has "Spaces" element
     */
    boolean isSetSpaces();
    
    /**
     * Sets the "Spaces" element
     */
    void setSpaces(org.erdc.cobie.cobielite.core.SpaceCollectionType spaces);
    
    /**
     * Appends and returns a new empty "Spaces" element
     */
    org.erdc.cobie.cobielite.core.SpaceCollectionType addNewSpaces();
    
    /**
     * Unsets the "Spaces" element
     */
    void unsetSpaces();
    
    /**
     * Gets the "FloorAttributes" element
     */
    org.erdc.cobie.cobielite.core.AttributeCollectionType getFloorAttributes();
    
    /**
     * True if has "FloorAttributes" element
     */
    boolean isSetFloorAttributes();
    
    /**
     * Sets the "FloorAttributes" element
     */
    void setFloorAttributes(org.erdc.cobie.cobielite.core.AttributeCollectionType floorAttributes);
    
    /**
     * Appends and returns a new empty "FloorAttributes" element
     */
    org.erdc.cobie.cobielite.core.AttributeCollectionType addNewFloorAttributes();
    
    /**
     * Unsets the "FloorAttributes" element
     */
    void unsetFloorAttributes();
    
    /**
     * Gets the "FloorDocuments" element
     */
    org.erdc.cobie.cobielite.core.DocumentCollectionType getFloorDocuments();
    
    /**
     * True if has "FloorDocuments" element
     */
    boolean isSetFloorDocuments();
    
    /**
     * Sets the "FloorDocuments" element
     */
    void setFloorDocuments(org.erdc.cobie.cobielite.core.DocumentCollectionType floorDocuments);
    
    /**
     * Appends and returns a new empty "FloorDocuments" element
     */
    org.erdc.cobie.cobielite.core.DocumentCollectionType addNewFloorDocuments();
    
    /**
     * Unsets the "FloorDocuments" element
     */
    void unsetFloorDocuments();
    
    /**
     * Gets the "FloorIssues" element
     */
    org.erdc.cobie.cobielite.core.IssueCollectionType getFloorIssues();
    
    /**
     * True if has "FloorIssues" element
     */
    boolean isSetFloorIssues();
    
    /**
     * Sets the "FloorIssues" element
     */
    void setFloorIssues(org.erdc.cobie.cobielite.core.IssueCollectionType floorIssues);
    
    /**
     * Appends and returns a new empty "FloorIssues" element
     */
    org.erdc.cobie.cobielite.core.IssueCollectionType addNewFloorIssues();
    
    /**
     * Unsets the "FloorIssues" element
     */
    void unsetFloorIssues();
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static org.erdc.cobie.cobielite.floor.FloorType newInstance() {
          return (org.erdc.cobie.cobielite.floor.FloorType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static org.erdc.cobie.cobielite.floor.FloorType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (org.erdc.cobie.cobielite.floor.FloorType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static org.erdc.cobie.cobielite.floor.FloorType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.floor.FloorType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static org.erdc.cobie.cobielite.floor.FloorType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.floor.FloorType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static org.erdc.cobie.cobielite.floor.FloorType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.floor.FloorType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static org.erdc.cobie.cobielite.floor.FloorType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.floor.FloorType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static org.erdc.cobie.cobielite.floor.FloorType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.floor.FloorType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static org.erdc.cobie.cobielite.floor.FloorType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.floor.FloorType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static org.erdc.cobie.cobielite.floor.FloorType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.floor.FloorType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static org.erdc.cobie.cobielite.floor.FloorType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.floor.FloorType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static org.erdc.cobie.cobielite.floor.FloorType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.floor.FloorType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static org.erdc.cobie.cobielite.floor.FloorType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.erdc.cobie.cobielite.floor.FloorType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static org.erdc.cobie.cobielite.floor.FloorType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.floor.FloorType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static org.erdc.cobie.cobielite.floor.FloorType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.floor.FloorType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static org.erdc.cobie.cobielite.floor.FloorType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.floor.FloorType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static org.erdc.cobie.cobielite.floor.FloorType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.erdc.cobie.cobielite.floor.FloorType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.erdc.cobie.cobielite.floor.FloorType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.erdc.cobie.cobielite.floor.FloorType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.erdc.cobie.cobielite.floor.FloorType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.erdc.cobie.cobielite.floor.FloorType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
