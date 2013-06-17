/*
 * XML Type:  FloorType
 * Namespace: http://floor.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.floor.FloorType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.floor.impl;
/**
 * An XML FloorType(@http://floor.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class FloorTypeImpl extends org.erdc.cobie.cobielite.core.impl.FloorTypeImpl implements org.erdc.cobie.cobielite.floor.FloorType
{
    private static final long serialVersionUID = 1L;
    
    public FloorTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FLOORCATEGORY$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "FloorCategory");
    private static final javax.xml.namespace.QName FLOORDESCRIPTION$2 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "FloorDescription");
    private static final javax.xml.namespace.QName FLOORELEVATIONVALUE$4 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "FloorElevationValue");
    private static final javax.xml.namespace.QName FLOORHEIGHTVALUE$6 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "FloorHeightValue");
    private static final javax.xml.namespace.QName SPACES$8 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Spaces");
    private static final javax.xml.namespace.QName FLOORATTRIBUTES$10 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "FloorAttributes");
    private static final javax.xml.namespace.QName FLOORDOCUMENTS$12 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "FloorDocuments");
    private static final javax.xml.namespace.QName FLOORISSUES$14 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "FloorIssues");
    
    
    /**
     * Gets the "FloorCategory" element
     */
    public java.lang.String getFloorCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FLOORCATEGORY$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "FloorCategory" element
     */
    public org.erdc.cobie.cobielite.core.FloorCategorySimpleType xgetFloorCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.FloorCategorySimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.FloorCategorySimpleType)get_store().find_element_user(FLOORCATEGORY$0, 0);
            return target;
        }
    }
    
    /**
     * True if has "FloorCategory" element
     */
    public boolean isSetFloorCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(FLOORCATEGORY$0) != 0;
        }
    }
    
    /**
     * Sets the "FloorCategory" element
     */
    public void setFloorCategory(java.lang.String floorCategory)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FLOORCATEGORY$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FLOORCATEGORY$0);
            }
            target.setStringValue(floorCategory);
        }
    }
    
    /**
     * Sets (as xml) the "FloorCategory" element
     */
    public void xsetFloorCategory(org.erdc.cobie.cobielite.core.FloorCategorySimpleType floorCategory)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.FloorCategorySimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.FloorCategorySimpleType)get_store().find_element_user(FLOORCATEGORY$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.FloorCategorySimpleType)get_store().add_element_user(FLOORCATEGORY$0);
            }
            target.set(floorCategory);
        }
    }
    
    /**
     * Unsets the "FloorCategory" element
     */
    public void unsetFloorCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(FLOORCATEGORY$0, 0);
        }
    }
    
    /**
     * Gets the "FloorDescription" element
     */
    public java.lang.String getFloorDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FLOORDESCRIPTION$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "FloorDescription" element
     */
    public org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType xgetFloorDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(FLOORDESCRIPTION$2, 0);
            return target;
        }
    }
    
    /**
     * True if has "FloorDescription" element
     */
    public boolean isSetFloorDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(FLOORDESCRIPTION$2) != 0;
        }
    }
    
    /**
     * Sets the "FloorDescription" element
     */
    public void setFloorDescription(java.lang.String floorDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FLOORDESCRIPTION$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FLOORDESCRIPTION$2);
            }
            target.setStringValue(floorDescription);
        }
    }
    
    /**
     * Sets (as xml) the "FloorDescription" element
     */
    public void xsetFloorDescription(org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType floorDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(FLOORDESCRIPTION$2, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().add_element_user(FLOORDESCRIPTION$2);
            }
            target.set(floorDescription);
        }
    }
    
    /**
     * Unsets the "FloorDescription" element
     */
    public void unsetFloorDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(FLOORDESCRIPTION$2, 0);
        }
    }
    
    /**
     * Gets the "FloorElevationValue" element
     */
    public org.erdc.cobie.cobielite.core.DecimalValueType getFloorElevationValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DecimalValueType target = null;
            target = (org.erdc.cobie.cobielite.core.DecimalValueType)get_store().find_element_user(FLOORELEVATIONVALUE$4, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "FloorElevationValue" element
     */
    public boolean isSetFloorElevationValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(FLOORELEVATIONVALUE$4) != 0;
        }
    }
    
    /**
     * Sets the "FloorElevationValue" element
     */
    public void setFloorElevationValue(org.erdc.cobie.cobielite.core.DecimalValueType floorElevationValue)
    {
        generatedSetterHelperImpl(floorElevationValue, FLOORELEVATIONVALUE$4, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "FloorElevationValue" element
     */
    public org.erdc.cobie.cobielite.core.DecimalValueType addNewFloorElevationValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DecimalValueType target = null;
            target = (org.erdc.cobie.cobielite.core.DecimalValueType)get_store().add_element_user(FLOORELEVATIONVALUE$4);
            return target;
        }
    }
    
    /**
     * Unsets the "FloorElevationValue" element
     */
    public void unsetFloorElevationValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(FLOORELEVATIONVALUE$4, 0);
        }
    }
    
    /**
     * Gets the "FloorHeightValue" element
     */
    public org.erdc.cobie.cobielite.core.DecimalValueType getFloorHeightValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DecimalValueType target = null;
            target = (org.erdc.cobie.cobielite.core.DecimalValueType)get_store().find_element_user(FLOORHEIGHTVALUE$6, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "FloorHeightValue" element
     */
    public boolean isSetFloorHeightValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(FLOORHEIGHTVALUE$6) != 0;
        }
    }
    
    /**
     * Sets the "FloorHeightValue" element
     */
    public void setFloorHeightValue(org.erdc.cobie.cobielite.core.DecimalValueType floorHeightValue)
    {
        generatedSetterHelperImpl(floorHeightValue, FLOORHEIGHTVALUE$6, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "FloorHeightValue" element
     */
    public org.erdc.cobie.cobielite.core.DecimalValueType addNewFloorHeightValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DecimalValueType target = null;
            target = (org.erdc.cobie.cobielite.core.DecimalValueType)get_store().add_element_user(FLOORHEIGHTVALUE$6);
            return target;
        }
    }
    
    /**
     * Unsets the "FloorHeightValue" element
     */
    public void unsetFloorHeightValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(FLOORHEIGHTVALUE$6, 0);
        }
    }
    
    /**
     * Gets the "Spaces" element
     */
    public org.erdc.cobie.cobielite.core.SpaceCollectionType getSpaces()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SpaceCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.SpaceCollectionType)get_store().find_element_user(SPACES$8, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "Spaces" element
     */
    public boolean isSetSpaces()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(SPACES$8) != 0;
        }
    }
    
    /**
     * Sets the "Spaces" element
     */
    public void setSpaces(org.erdc.cobie.cobielite.core.SpaceCollectionType spaces)
    {
        generatedSetterHelperImpl(spaces, SPACES$8, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Spaces" element
     */
    public org.erdc.cobie.cobielite.core.SpaceCollectionType addNewSpaces()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SpaceCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.SpaceCollectionType)get_store().add_element_user(SPACES$8);
            return target;
        }
    }
    
    /**
     * Unsets the "Spaces" element
     */
    public void unsetSpaces()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(SPACES$8, 0);
        }
    }
    
    /**
     * Gets the "FloorAttributes" element
     */
    public org.erdc.cobie.cobielite.core.AttributeCollectionType getFloorAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeCollectionType)get_store().find_element_user(FLOORATTRIBUTES$10, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "FloorAttributes" element
     */
    public boolean isSetFloorAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(FLOORATTRIBUTES$10) != 0;
        }
    }
    
    /**
     * Sets the "FloorAttributes" element
     */
    public void setFloorAttributes(org.erdc.cobie.cobielite.core.AttributeCollectionType floorAttributes)
    {
        generatedSetterHelperImpl(floorAttributes, FLOORATTRIBUTES$10, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "FloorAttributes" element
     */
    public org.erdc.cobie.cobielite.core.AttributeCollectionType addNewFloorAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeCollectionType)get_store().add_element_user(FLOORATTRIBUTES$10);
            return target;
        }
    }
    
    /**
     * Unsets the "FloorAttributes" element
     */
    public void unsetFloorAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(FLOORATTRIBUTES$10, 0);
        }
    }
    
    /**
     * Gets the "FloorDocuments" element
     */
    public org.erdc.cobie.cobielite.core.DocumentCollectionType getFloorDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DocumentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.DocumentCollectionType)get_store().find_element_user(FLOORDOCUMENTS$12, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "FloorDocuments" element
     */
    public boolean isSetFloorDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(FLOORDOCUMENTS$12) != 0;
        }
    }
    
    /**
     * Sets the "FloorDocuments" element
     */
    public void setFloorDocuments(org.erdc.cobie.cobielite.core.DocumentCollectionType floorDocuments)
    {
        generatedSetterHelperImpl(floorDocuments, FLOORDOCUMENTS$12, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "FloorDocuments" element
     */
    public org.erdc.cobie.cobielite.core.DocumentCollectionType addNewFloorDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DocumentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.DocumentCollectionType)get_store().add_element_user(FLOORDOCUMENTS$12);
            return target;
        }
    }
    
    /**
     * Unsets the "FloorDocuments" element
     */
    public void unsetFloorDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(FLOORDOCUMENTS$12, 0);
        }
    }
    
    /**
     * Gets the "FloorIssues" element
     */
    public org.erdc.cobie.cobielite.core.IssueCollectionType getFloorIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IssueCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.IssueCollectionType)get_store().find_element_user(FLOORISSUES$14, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "FloorIssues" element
     */
    public boolean isSetFloorIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(FLOORISSUES$14) != 0;
        }
    }
    
    /**
     * Sets the "FloorIssues" element
     */
    public void setFloorIssues(org.erdc.cobie.cobielite.core.IssueCollectionType floorIssues)
    {
        generatedSetterHelperImpl(floorIssues, FLOORISSUES$14, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "FloorIssues" element
     */
    public org.erdc.cobie.cobielite.core.IssueCollectionType addNewFloorIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IssueCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.IssueCollectionType)get_store().add_element_user(FLOORISSUES$14);
            return target;
        }
    }
    
    /**
     * Unsets the "FloorIssues" element
     */
    public void unsetFloorIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(FLOORISSUES$14, 0);
        }
    }
}
