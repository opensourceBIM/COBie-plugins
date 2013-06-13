/*
 * XML Type:  SpaceType
 * Namespace: http://space.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.space.SpaceType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.space.impl;
/**
 * An XML SpaceType(@http://space.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class SpaceTypeImpl extends org.erdc.cobie.cobielite.core.impl.SpaceTypeImpl implements org.erdc.cobie.cobielite.space.SpaceType
{
    private static final long serialVersionUID = 1L;
    
    public SpaceTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SPACECATEGORY$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "SpaceCategory");
    private static final javax.xml.namespace.QName SPACEDESCRIPTION$2 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "SpaceDescription");
    private static final javax.xml.namespace.QName SPACESIGNAGENAME$4 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "SpaceSignageName");
    private static final javax.xml.namespace.QName SPACEUSABLEHEIGHTVALUE$6 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "SpaceUsableHeightValue");
    private static final javax.xml.namespace.QName SPACEGROSSAREAVALUE$8 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "SpaceGrossAreaValue");
    private static final javax.xml.namespace.QName SPACENETAREAVALUE$10 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "SpaceNetAreaValue");
    private static final javax.xml.namespace.QName SPACE2DSHAPE$12 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Space2DShape");
    private static final javax.xml.namespace.QName SPACEZONEASSIGNMENTS$14 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "SpaceZoneAssignments");
    private static final javax.xml.namespace.QName SPACEATTRIBUTES$16 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "SpaceAttributes");
    private static final javax.xml.namespace.QName SPACEDOCUMENTS$18 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "SpaceDocuments");
    private static final javax.xml.namespace.QName SPACEISSUES$20 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "SpaceIssues");
    
    
    /**
     * Gets the "SpaceCategory" element
     */
    public java.lang.String getSpaceCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SPACECATEGORY$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "SpaceCategory" element
     */
    public org.erdc.cobie.cobielite.core.SpaceCategorySimpleType xgetSpaceCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SpaceCategorySimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.SpaceCategorySimpleType)get_store().find_element_user(SPACECATEGORY$0, 0);
            return target;
        }
    }
    
    /**
     * True if has "SpaceCategory" element
     */
    public boolean isSetSpaceCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(SPACECATEGORY$0) != 0;
        }
    }
    
    /**
     * Sets the "SpaceCategory" element
     */
    public void setSpaceCategory(java.lang.String spaceCategory)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SPACECATEGORY$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SPACECATEGORY$0);
            }
            target.setStringValue(spaceCategory);
        }
    }
    
    /**
     * Sets (as xml) the "SpaceCategory" element
     */
    public void xsetSpaceCategory(org.erdc.cobie.cobielite.core.SpaceCategorySimpleType spaceCategory)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SpaceCategorySimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.SpaceCategorySimpleType)get_store().find_element_user(SPACECATEGORY$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.SpaceCategorySimpleType)get_store().add_element_user(SPACECATEGORY$0);
            }
            target.set(spaceCategory);
        }
    }
    
    /**
     * Unsets the "SpaceCategory" element
     */
    public void unsetSpaceCategory()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(SPACECATEGORY$0, 0);
        }
    }
    
    /**
     * Gets the "SpaceDescription" element
     */
    public java.lang.String getSpaceDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SPACEDESCRIPTION$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "SpaceDescription" element
     */
    public org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType xgetSpaceDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(SPACEDESCRIPTION$2, 0);
            return target;
        }
    }
    
    /**
     * True if has "SpaceDescription" element
     */
    public boolean isSetSpaceDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(SPACEDESCRIPTION$2) != 0;
        }
    }
    
    /**
     * Sets the "SpaceDescription" element
     */
    public void setSpaceDescription(java.lang.String spaceDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SPACEDESCRIPTION$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SPACEDESCRIPTION$2);
            }
            target.setStringValue(spaceDescription);
        }
    }
    
    /**
     * Sets (as xml) the "SpaceDescription" element
     */
    public void xsetSpaceDescription(org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType spaceDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(SPACEDESCRIPTION$2, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().add_element_user(SPACEDESCRIPTION$2);
            }
            target.set(spaceDescription);
        }
    }
    
    /**
     * Unsets the "SpaceDescription" element
     */
    public void unsetSpaceDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(SPACEDESCRIPTION$2, 0);
        }
    }
    
    /**
     * Gets the "SpaceSignageName" element
     */
    public java.lang.String getSpaceSignageName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SPACESIGNAGENAME$4, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "SpaceSignageName" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetSpaceSignageName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(SPACESIGNAGENAME$4, 0);
            return target;
        }
    }
    
    /**
     * True if has "SpaceSignageName" element
     */
    public boolean isSetSpaceSignageName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(SPACESIGNAGENAME$4) != 0;
        }
    }
    
    /**
     * Sets the "SpaceSignageName" element
     */
    public void setSpaceSignageName(java.lang.String spaceSignageName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SPACESIGNAGENAME$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SPACESIGNAGENAME$4);
            }
            target.setStringValue(spaceSignageName);
        }
    }
    
    /**
     * Sets (as xml) the "SpaceSignageName" element
     */
    public void xsetSpaceSignageName(org.erdc.cobie.cobielite.core.CobieTextSimpleType spaceSignageName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(SPACESIGNAGENAME$4, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(SPACESIGNAGENAME$4);
            }
            target.set(spaceSignageName);
        }
    }
    
    /**
     * Unsets the "SpaceSignageName" element
     */
    public void unsetSpaceSignageName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(SPACESIGNAGENAME$4, 0);
        }
    }
    
    /**
     * Gets the "SpaceUsableHeightValue" element
     */
    public org.erdc.cobie.cobielite.core.DecimalValueType getSpaceUsableHeightValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DecimalValueType target = null;
            target = (org.erdc.cobie.cobielite.core.DecimalValueType)get_store().find_element_user(SPACEUSABLEHEIGHTVALUE$6, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "SpaceUsableHeightValue" element
     */
    public boolean isSetSpaceUsableHeightValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(SPACEUSABLEHEIGHTVALUE$6) != 0;
        }
    }
    
    /**
     * Sets the "SpaceUsableHeightValue" element
     */
    public void setSpaceUsableHeightValue(org.erdc.cobie.cobielite.core.DecimalValueType spaceUsableHeightValue)
    {
        generatedSetterHelperImpl(spaceUsableHeightValue, SPACEUSABLEHEIGHTVALUE$6, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "SpaceUsableHeightValue" element
     */
    public org.erdc.cobie.cobielite.core.DecimalValueType addNewSpaceUsableHeightValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DecimalValueType target = null;
            target = (org.erdc.cobie.cobielite.core.DecimalValueType)get_store().add_element_user(SPACEUSABLEHEIGHTVALUE$6);
            return target;
        }
    }
    
    /**
     * Unsets the "SpaceUsableHeightValue" element
     */
    public void unsetSpaceUsableHeightValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(SPACEUSABLEHEIGHTVALUE$6, 0);
        }
    }
    
    /**
     * Gets the "SpaceGrossAreaValue" element
     */
    public org.erdc.cobie.cobielite.core.DecimalValueType getSpaceGrossAreaValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DecimalValueType target = null;
            target = (org.erdc.cobie.cobielite.core.DecimalValueType)get_store().find_element_user(SPACEGROSSAREAVALUE$8, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "SpaceGrossAreaValue" element
     */
    public boolean isSetSpaceGrossAreaValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(SPACEGROSSAREAVALUE$8) != 0;
        }
    }
    
    /**
     * Sets the "SpaceGrossAreaValue" element
     */
    public void setSpaceGrossAreaValue(org.erdc.cobie.cobielite.core.DecimalValueType spaceGrossAreaValue)
    {
        generatedSetterHelperImpl(spaceGrossAreaValue, SPACEGROSSAREAVALUE$8, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "SpaceGrossAreaValue" element
     */
    public org.erdc.cobie.cobielite.core.DecimalValueType addNewSpaceGrossAreaValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DecimalValueType target = null;
            target = (org.erdc.cobie.cobielite.core.DecimalValueType)get_store().add_element_user(SPACEGROSSAREAVALUE$8);
            return target;
        }
    }
    
    /**
     * Unsets the "SpaceGrossAreaValue" element
     */
    public void unsetSpaceGrossAreaValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(SPACEGROSSAREAVALUE$8, 0);
        }
    }
    
    /**
     * Gets the "SpaceNetAreaValue" element
     */
    public org.erdc.cobie.cobielite.core.DecimalValueType getSpaceNetAreaValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DecimalValueType target = null;
            target = (org.erdc.cobie.cobielite.core.DecimalValueType)get_store().find_element_user(SPACENETAREAVALUE$10, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "SpaceNetAreaValue" element
     */
    public boolean isSetSpaceNetAreaValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(SPACENETAREAVALUE$10) != 0;
        }
    }
    
    /**
     * Sets the "SpaceNetAreaValue" element
     */
    public void setSpaceNetAreaValue(org.erdc.cobie.cobielite.core.DecimalValueType spaceNetAreaValue)
    {
        generatedSetterHelperImpl(spaceNetAreaValue, SPACENETAREAVALUE$10, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "SpaceNetAreaValue" element
     */
    public org.erdc.cobie.cobielite.core.DecimalValueType addNewSpaceNetAreaValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DecimalValueType target = null;
            target = (org.erdc.cobie.cobielite.core.DecimalValueType)get_store().add_element_user(SPACENETAREAVALUE$10);
            return target;
        }
    }
    
    /**
     * Unsets the "SpaceNetAreaValue" element
     */
    public void unsetSpaceNetAreaValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(SPACENETAREAVALUE$10, 0);
        }
    }
    
    /**
     * Gets the "Space2DShape" element
     */
    public org.erdc.cobie.cobielite.core.PolygonCollectionType getSpace2DShape()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.PolygonCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.PolygonCollectionType)get_store().find_element_user(SPACE2DSHAPE$12, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "Space2DShape" element
     */
    public boolean isSetSpace2DShape()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(SPACE2DSHAPE$12) != 0;
        }
    }
    
    /**
     * Sets the "Space2DShape" element
     */
    public void setSpace2DShape(org.erdc.cobie.cobielite.core.PolygonCollectionType space2DShape)
    {
        generatedSetterHelperImpl(space2DShape, SPACE2DSHAPE$12, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Space2DShape" element
     */
    public org.erdc.cobie.cobielite.core.PolygonCollectionType addNewSpace2DShape()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.PolygonCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.PolygonCollectionType)get_store().add_element_user(SPACE2DSHAPE$12);
            return target;
        }
    }
    
    /**
     * Unsets the "Space2DShape" element
     */
    public void unsetSpace2DShape()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(SPACE2DSHAPE$12, 0);
        }
    }
    
    /**
     * Gets the "SpaceZoneAssignments" element
     */
    public org.erdc.cobie.cobielite.core.ZoneAssignmentCollectionType getSpaceZoneAssignments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ZoneAssignmentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.ZoneAssignmentCollectionType)get_store().find_element_user(SPACEZONEASSIGNMENTS$14, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "SpaceZoneAssignments" element
     */
    public boolean isSetSpaceZoneAssignments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(SPACEZONEASSIGNMENTS$14) != 0;
        }
    }
    
    /**
     * Sets the "SpaceZoneAssignments" element
     */
    public void setSpaceZoneAssignments(org.erdc.cobie.cobielite.core.ZoneAssignmentCollectionType spaceZoneAssignments)
    {
        generatedSetterHelperImpl(spaceZoneAssignments, SPACEZONEASSIGNMENTS$14, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "SpaceZoneAssignments" element
     */
    public org.erdc.cobie.cobielite.core.ZoneAssignmentCollectionType addNewSpaceZoneAssignments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ZoneAssignmentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.ZoneAssignmentCollectionType)get_store().add_element_user(SPACEZONEASSIGNMENTS$14);
            return target;
        }
    }
    
    /**
     * Unsets the "SpaceZoneAssignments" element
     */
    public void unsetSpaceZoneAssignments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(SPACEZONEASSIGNMENTS$14, 0);
        }
    }
    
    /**
     * Gets the "SpaceAttributes" element
     */
    public org.erdc.cobie.cobielite.core.AttributeCollectionType getSpaceAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeCollectionType)get_store().find_element_user(SPACEATTRIBUTES$16, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "SpaceAttributes" element
     */
    public boolean isSetSpaceAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(SPACEATTRIBUTES$16) != 0;
        }
    }
    
    /**
     * Sets the "SpaceAttributes" element
     */
    public void setSpaceAttributes(org.erdc.cobie.cobielite.core.AttributeCollectionType spaceAttributes)
    {
        generatedSetterHelperImpl(spaceAttributes, SPACEATTRIBUTES$16, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "SpaceAttributes" element
     */
    public org.erdc.cobie.cobielite.core.AttributeCollectionType addNewSpaceAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeCollectionType)get_store().add_element_user(SPACEATTRIBUTES$16);
            return target;
        }
    }
    
    /**
     * Unsets the "SpaceAttributes" element
     */
    public void unsetSpaceAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(SPACEATTRIBUTES$16, 0);
        }
    }
    
    /**
     * Gets the "SpaceDocuments" element
     */
    public org.erdc.cobie.cobielite.core.DocumentCollectionType getSpaceDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DocumentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.DocumentCollectionType)get_store().find_element_user(SPACEDOCUMENTS$18, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "SpaceDocuments" element
     */
    public boolean isSetSpaceDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(SPACEDOCUMENTS$18) != 0;
        }
    }
    
    /**
     * Sets the "SpaceDocuments" element
     */
    public void setSpaceDocuments(org.erdc.cobie.cobielite.core.DocumentCollectionType spaceDocuments)
    {
        generatedSetterHelperImpl(spaceDocuments, SPACEDOCUMENTS$18, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "SpaceDocuments" element
     */
    public org.erdc.cobie.cobielite.core.DocumentCollectionType addNewSpaceDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DocumentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.DocumentCollectionType)get_store().add_element_user(SPACEDOCUMENTS$18);
            return target;
        }
    }
    
    /**
     * Unsets the "SpaceDocuments" element
     */
    public void unsetSpaceDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(SPACEDOCUMENTS$18, 0);
        }
    }
    
    /**
     * Gets the "SpaceIssues" element
     */
    public org.erdc.cobie.cobielite.core.IssueCollectionType getSpaceIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IssueCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.IssueCollectionType)get_store().find_element_user(SPACEISSUES$20, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "SpaceIssues" element
     */
    public boolean isSetSpaceIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(SPACEISSUES$20) != 0;
        }
    }
    
    /**
     * Sets the "SpaceIssues" element
     */
    public void setSpaceIssues(org.erdc.cobie.cobielite.core.IssueCollectionType spaceIssues)
    {
        generatedSetterHelperImpl(spaceIssues, SPACEISSUES$20, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "SpaceIssues" element
     */
    public org.erdc.cobie.cobielite.core.IssueCollectionType addNewSpaceIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IssueCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.IssueCollectionType)get_store().add_element_user(SPACEISSUES$20);
            return target;
        }
    }
    
    /**
     * Unsets the "SpaceIssues" element
     */
    public void unsetSpaceIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(SPACEISSUES$20, 0);
        }
    }
}
