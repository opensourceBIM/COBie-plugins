/*
 * XML Type:  ResourceCollectionType
 * Namespace: http://core.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.core.ResourceCollectionType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.core.impl;
/**
 * An XML ResourceCollectionType(@http://core.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class ResourceCollectionTypeImpl extends org.erdc.cobie.cobielite.core.impl.CobieWorksheetTypeImpl implements org.erdc.cobie.cobielite.core.ResourceCollectionType
{
    private static final long serialVersionUID = 1L;
    
    public ResourceCollectionTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName RESOURCE$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Resource");
    private static final org.apache.xmlbeans.QNameSet RESOURCE$1 = org.apache.xmlbeans.QNameSet.forArray( new javax.xml.namespace.QName[] { 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "Resource"),
        new javax.xml.namespace.QName("http://resource.cobielite.cobie.erdc.org", "Resource"),
    });
    
    
    /**
     * Gets array of all "Resource" elements
     */
    public org.erdc.cobie.cobielite.core.ResourceType[] getResourceArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(RESOURCE$1, targetList);
            org.erdc.cobie.cobielite.core.ResourceType[] result = new org.erdc.cobie.cobielite.core.ResourceType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "Resource" element
     */
    public org.erdc.cobie.cobielite.core.ResourceType getResourceArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ResourceType target = null;
            target = (org.erdc.cobie.cobielite.core.ResourceType)get_store().find_element_user(RESOURCE$1, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "Resource" element
     */
    public int sizeOfResourceArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(RESOURCE$1);
        }
    }
    
    /**
     * Sets array of all "Resource" element  WARNING: This method is not atomicaly synchronized.
     */
    public void setResourceArray(org.erdc.cobie.cobielite.core.ResourceType[] resourceArray)
    {
        check_orphaned();
        arraySetterHelper(resourceArray, RESOURCE$0, RESOURCE$1);
    }
    
    /**
     * Sets ith "Resource" element
     */
    public void setResourceArray(int i, org.erdc.cobie.cobielite.core.ResourceType resource)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ResourceType target = null;
            target = (org.erdc.cobie.cobielite.core.ResourceType)get_store().find_element_user(RESOURCE$1, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(resource);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "Resource" element
     */
    public org.erdc.cobie.cobielite.core.ResourceType insertNewResource(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ResourceType target = null;
            target = (org.erdc.cobie.cobielite.core.ResourceType)get_store().insert_element_user(RESOURCE$1, RESOURCE$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "Resource" element
     */
    public org.erdc.cobie.cobielite.core.ResourceType addNewResource()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.ResourceType target = null;
            target = (org.erdc.cobie.cobielite.core.ResourceType)get_store().add_element_user(RESOURCE$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "Resource" element
     */
    public void removeResource(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(RESOURCE$1, i);
        }
    }
}
