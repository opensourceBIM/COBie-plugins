/*
 * XML Type:  CategoryPickLists
 * Namespace: cobielite.cobie.bimserver.org
 * Java type: org.bimserver.cobie.cobielite.CategoryPickLists
 *
 * Automatically generated - do not modify.
 */
package org.bimserver.cobie.cobielite;


/**
 * An XML CategoryPickLists(@cobielite.cobie.bimserver.org).
 *
 * This is a complex type.
 */
public interface CategoryPickLists extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(CategoryPickLists.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8D4E9650049F3102F3468D9198074B0A").resolveHandle("categorypicklistsed62type");
    
    /**
     * Gets the "Facility" element
     */
    java.lang.String getFacility();
    
    /**
     * Gets (as xml) the "Facility" element
     */
    org.apache.xmlbeans.XmlString xgetFacility();
    
    /**
     * Sets the "Facility" element
     */
    void setFacility(java.lang.String facility);
    
    /**
     * Sets (as xml) the "Facility" element
     */
    void xsetFacility(org.apache.xmlbeans.XmlString facility);
    
    /**
     * Gets the "Floor" element
     */
    java.lang.String getFloor();
    
    /**
     * Gets (as xml) the "Floor" element
     */
    org.apache.xmlbeans.XmlString xgetFloor();
    
    /**
     * Sets the "Floor" element
     */
    void setFloor(java.lang.String floor);
    
    /**
     * Sets (as xml) the "Floor" element
     */
    void xsetFloor(org.apache.xmlbeans.XmlString floor);
    
    /**
     * Gets the "Space" element
     */
    java.lang.String getSpace();
    
    /**
     * Gets (as xml) the "Space" element
     */
    org.apache.xmlbeans.XmlString xgetSpace();
    
    /**
     * Sets the "Space" element
     */
    void setSpace(java.lang.String space);
    
    /**
     * Sets (as xml) the "Space" element
     */
    void xsetSpace(org.apache.xmlbeans.XmlString space);
    
    /**
     * Gets the "Zone" element
     */
    java.lang.String getZone();
    
    /**
     * Gets (as xml) the "Zone" element
     */
    org.apache.xmlbeans.XmlString xgetZone();
    
    /**
     * Sets the "Zone" element
     */
    void setZone(java.lang.String zone);
    
    /**
     * Sets (as xml) the "Zone" element
     */
    void xsetZone(org.apache.xmlbeans.XmlString zone);
    
    /**
     * Gets the "Type" element
     */
    java.lang.String getType();
    
    /**
     * Gets (as xml) the "Type" element
     */
    org.apache.xmlbeans.XmlString xgetType();
    
    /**
     * Sets the "Type" element
     */
    void setType(java.lang.String type);
    
    /**
     * Sets (as xml) the "Type" element
     */
    void xsetType(org.apache.xmlbeans.XmlString type);
    
    /**
     * Gets the "System" element
     */
    java.lang.String getSystem();
    
    /**
     * Gets (as xml) the "System" element
     */
    org.apache.xmlbeans.XmlString xgetSystem();
    
    /**
     * Sets the "System" element
     */
    void setSystem(java.lang.String system);
    
    /**
     * Sets (as xml) the "System" element
     */
    void xsetSystem(org.apache.xmlbeans.XmlString system);
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        /** @deprecated No need to be able to create instances of abstract types */
        public static org.bimserver.cobie.cobielite.CategoryPickLists newInstance() {
          return (org.bimserver.cobie.cobielite.CategoryPickLists) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        /** @deprecated No need to be able to create instances of abstract types */
        public static org.bimserver.cobie.cobielite.CategoryPickLists newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (org.bimserver.cobie.cobielite.CategoryPickLists) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static org.bimserver.cobie.cobielite.CategoryPickLists parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (org.bimserver.cobie.cobielite.CategoryPickLists) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static org.bimserver.cobie.cobielite.CategoryPickLists parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.bimserver.cobie.cobielite.CategoryPickLists) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static org.bimserver.cobie.cobielite.CategoryPickLists parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bimserver.cobie.cobielite.CategoryPickLists) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static org.bimserver.cobie.cobielite.CategoryPickLists parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bimserver.cobie.cobielite.CategoryPickLists) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static org.bimserver.cobie.cobielite.CategoryPickLists parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bimserver.cobie.cobielite.CategoryPickLists) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static org.bimserver.cobie.cobielite.CategoryPickLists parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bimserver.cobie.cobielite.CategoryPickLists) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static org.bimserver.cobie.cobielite.CategoryPickLists parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bimserver.cobie.cobielite.CategoryPickLists) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static org.bimserver.cobie.cobielite.CategoryPickLists parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bimserver.cobie.cobielite.CategoryPickLists) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static org.bimserver.cobie.cobielite.CategoryPickLists parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bimserver.cobie.cobielite.CategoryPickLists) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static org.bimserver.cobie.cobielite.CategoryPickLists parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bimserver.cobie.cobielite.CategoryPickLists) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static org.bimserver.cobie.cobielite.CategoryPickLists parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (org.bimserver.cobie.cobielite.CategoryPickLists) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static org.bimserver.cobie.cobielite.CategoryPickLists parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.bimserver.cobie.cobielite.CategoryPickLists) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static org.bimserver.cobie.cobielite.CategoryPickLists parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (org.bimserver.cobie.cobielite.CategoryPickLists) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static org.bimserver.cobie.cobielite.CategoryPickLists parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.bimserver.cobie.cobielite.CategoryPickLists) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.bimserver.cobie.cobielite.CategoryPickLists parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.bimserver.cobie.cobielite.CategoryPickLists) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.bimserver.cobie.cobielite.CategoryPickLists parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.bimserver.cobie.cobielite.CategoryPickLists) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
