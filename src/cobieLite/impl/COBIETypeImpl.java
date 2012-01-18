/*
 * XML Type:  COBIEType
 * Namespace: cobieLite
 * Java type: cobieLite.COBIEType
 *
 * Automatically generated - do not modify.
 */
package cobieLite.impl;
/**
 * An XML COBIEType(@cobieLite).
 *
 * This is a complex type.
 */
public class COBIETypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cobieLite.COBIEType
{
    private static final long serialVersionUID = 1L;
    
    public COBIETypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CONTACTS$0 = 
        new javax.xml.namespace.QName("", "Contacts");
    private static final javax.xml.namespace.QName FACILITIES$2 = 
        new javax.xml.namespace.QName("", "Facilities");
    private static final javax.xml.namespace.QName FLOORS$4 = 
        new javax.xml.namespace.QName("", "Floors");
    private static final javax.xml.namespace.QName SPACES$6 = 
        new javax.xml.namespace.QName("", "Spaces");
    private static final javax.xml.namespace.QName ZONES$8 = 
        new javax.xml.namespace.QName("", "Zones");
    private static final javax.xml.namespace.QName TYPES$10 = 
        new javax.xml.namespace.QName("", "Types");
    private static final javax.xml.namespace.QName COMPONENTS$12 = 
        new javax.xml.namespace.QName("", "Components");
    private static final javax.xml.namespace.QName SYSTEMS$14 = 
        new javax.xml.namespace.QName("", "Systems");
    private static final javax.xml.namespace.QName ASSEMBLIES$16 = 
        new javax.xml.namespace.QName("", "Assemblies");
    private static final javax.xml.namespace.QName CONNECTIONS$18 = 
        new javax.xml.namespace.QName("", "Connections");
    private static final javax.xml.namespace.QName SPARES$20 = 
        new javax.xml.namespace.QName("", "Spares");
    private static final javax.xml.namespace.QName RESOURCES$22 = 
        new javax.xml.namespace.QName("", "Resources");
    private static final javax.xml.namespace.QName JOBS$24 = 
        new javax.xml.namespace.QName("", "Jobs");
    private static final javax.xml.namespace.QName IMPACTS$26 = 
        new javax.xml.namespace.QName("", "Impacts");
    private static final javax.xml.namespace.QName DOCUMENTS$28 = 
        new javax.xml.namespace.QName("", "Documents");
    private static final javax.xml.namespace.QName ATTRIBUTES$30 = 
        new javax.xml.namespace.QName("", "Attributes");
    private static final javax.xml.namespace.QName COORDINATES$32 = 
        new javax.xml.namespace.QName("", "Coordinates");
    private static final javax.xml.namespace.QName ISSUES$34 = 
        new javax.xml.namespace.QName("", "Issues");
    
    
    /**
     * Gets the "Contacts" element
     */
    public cobieLite.COBIEType.Contacts getContacts()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cobieLite.COBIEType.Contacts target = null;
            target = (cobieLite.COBIEType.Contacts)get_store().find_element_user(CONTACTS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Contacts" element
     */
    public void setContacts(cobieLite.COBIEType.Contacts contacts)
    {
        generatedSetterHelperImpl(contacts, CONTACTS$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Contacts" element
     */
    public cobieLite.COBIEType.Contacts addNewContacts()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cobieLite.COBIEType.Contacts target = null;
            target = (cobieLite.COBIEType.Contacts)get_store().add_element_user(CONTACTS$0);
            return target;
        }
    }
    
    /**
     * Gets the "Facilities" element
     */
    public cobieLite.COBIEType.Facilities getFacilities()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cobieLite.COBIEType.Facilities target = null;
            target = (cobieLite.COBIEType.Facilities)get_store().find_element_user(FACILITIES$2, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Facilities" element
     */
    public void setFacilities(cobieLite.COBIEType.Facilities facilities)
    {
        generatedSetterHelperImpl(facilities, FACILITIES$2, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Facilities" element
     */
    public cobieLite.COBIEType.Facilities addNewFacilities()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cobieLite.COBIEType.Facilities target = null;
            target = (cobieLite.COBIEType.Facilities)get_store().add_element_user(FACILITIES$2);
            return target;
        }
    }
    
    /**
     * Gets the "Floors" element
     */
    public cobieLite.COBIEType.Floors getFloors()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cobieLite.COBIEType.Floors target = null;
            target = (cobieLite.COBIEType.Floors)get_store().find_element_user(FLOORS$4, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Floors" element
     */
    public void setFloors(cobieLite.COBIEType.Floors floors)
    {
        generatedSetterHelperImpl(floors, FLOORS$4, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Floors" element
     */
    public cobieLite.COBIEType.Floors addNewFloors()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cobieLite.COBIEType.Floors target = null;
            target = (cobieLite.COBIEType.Floors)get_store().add_element_user(FLOORS$4);
            return target;
        }
    }
    
    /**
     * Gets the "Spaces" element
     */
    public cobieLite.COBIEType.Spaces getSpaces()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cobieLite.COBIEType.Spaces target = null;
            target = (cobieLite.COBIEType.Spaces)get_store().find_element_user(SPACES$6, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Spaces" element
     */
    public void setSpaces(cobieLite.COBIEType.Spaces spaces)
    {
        generatedSetterHelperImpl(spaces, SPACES$6, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Spaces" element
     */
    public cobieLite.COBIEType.Spaces addNewSpaces()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cobieLite.COBIEType.Spaces target = null;
            target = (cobieLite.COBIEType.Spaces)get_store().add_element_user(SPACES$6);
            return target;
        }
    }
    
    /**
     * Gets the "Zones" element
     */
    public cobieLite.COBIEType.Zones getZones()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cobieLite.COBIEType.Zones target = null;
            target = (cobieLite.COBIEType.Zones)get_store().find_element_user(ZONES$8, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Zones" element
     */
    public void setZones(cobieLite.COBIEType.Zones zones)
    {
        generatedSetterHelperImpl(zones, ZONES$8, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Zones" element
     */
    public cobieLite.COBIEType.Zones addNewZones()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cobieLite.COBIEType.Zones target = null;
            target = (cobieLite.COBIEType.Zones)get_store().add_element_user(ZONES$8);
            return target;
        }
    }
    
    /**
     * Gets the "Types" element
     */
    public cobieLite.COBIEType.Types getTypes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cobieLite.COBIEType.Types target = null;
            target = (cobieLite.COBIEType.Types)get_store().find_element_user(TYPES$10, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Types" element
     */
    public void setTypes(cobieLite.COBIEType.Types types)
    {
        generatedSetterHelperImpl(types, TYPES$10, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Types" element
     */
    public cobieLite.COBIEType.Types addNewTypes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cobieLite.COBIEType.Types target = null;
            target = (cobieLite.COBIEType.Types)get_store().add_element_user(TYPES$10);
            return target;
        }
    }
    
    /**
     * Gets the "Components" element
     */
    public cobieLite.COBIEType.Components getComponents()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cobieLite.COBIEType.Components target = null;
            target = (cobieLite.COBIEType.Components)get_store().find_element_user(COMPONENTS$12, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Components" element
     */
    public void setComponents(cobieLite.COBIEType.Components components)
    {
        generatedSetterHelperImpl(components, COMPONENTS$12, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Components" element
     */
    public cobieLite.COBIEType.Components addNewComponents()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cobieLite.COBIEType.Components target = null;
            target = (cobieLite.COBIEType.Components)get_store().add_element_user(COMPONENTS$12);
            return target;
        }
    }
    
    /**
     * Gets the "Systems" element
     */
    public cobieLite.COBIEType.Systems getSystems()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cobieLite.COBIEType.Systems target = null;
            target = (cobieLite.COBIEType.Systems)get_store().find_element_user(SYSTEMS$14, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Systems" element
     */
    public void setSystems(cobieLite.COBIEType.Systems systems)
    {
        generatedSetterHelperImpl(systems, SYSTEMS$14, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Systems" element
     */
    public cobieLite.COBIEType.Systems addNewSystems()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cobieLite.COBIEType.Systems target = null;
            target = (cobieLite.COBIEType.Systems)get_store().add_element_user(SYSTEMS$14);
            return target;
        }
    }
    
    /**
     * Gets the "Assemblies" element
     */
    public cobieLite.COBIEType.Assemblies getAssemblies()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cobieLite.COBIEType.Assemblies target = null;
            target = (cobieLite.COBIEType.Assemblies)get_store().find_element_user(ASSEMBLIES$16, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Assemblies" element
     */
    public void setAssemblies(cobieLite.COBIEType.Assemblies assemblies)
    {
        generatedSetterHelperImpl(assemblies, ASSEMBLIES$16, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Assemblies" element
     */
    public cobieLite.COBIEType.Assemblies addNewAssemblies()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cobieLite.COBIEType.Assemblies target = null;
            target = (cobieLite.COBIEType.Assemblies)get_store().add_element_user(ASSEMBLIES$16);
            return target;
        }
    }
    
    /**
     * Gets the "Connections" element
     */
    public cobieLite.COBIEType.Connections getConnections()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cobieLite.COBIEType.Connections target = null;
            target = (cobieLite.COBIEType.Connections)get_store().find_element_user(CONNECTIONS$18, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Connections" element
     */
    public void setConnections(cobieLite.COBIEType.Connections connections)
    {
        generatedSetterHelperImpl(connections, CONNECTIONS$18, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Connections" element
     */
    public cobieLite.COBIEType.Connections addNewConnections()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cobieLite.COBIEType.Connections target = null;
            target = (cobieLite.COBIEType.Connections)get_store().add_element_user(CONNECTIONS$18);
            return target;
        }
    }
    
    /**
     * Gets the "Spares" element
     */
    public cobieLite.COBIEType.Spares getSpares()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cobieLite.COBIEType.Spares target = null;
            target = (cobieLite.COBIEType.Spares)get_store().find_element_user(SPARES$20, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Spares" element
     */
    public void setSpares(cobieLite.COBIEType.Spares spares)
    {
        generatedSetterHelperImpl(spares, SPARES$20, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Spares" element
     */
    public cobieLite.COBIEType.Spares addNewSpares()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cobieLite.COBIEType.Spares target = null;
            target = (cobieLite.COBIEType.Spares)get_store().add_element_user(SPARES$20);
            return target;
        }
    }
    
    /**
     * Gets the "Resources" element
     */
    public cobieLite.COBIEType.Resources getResources()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cobieLite.COBIEType.Resources target = null;
            target = (cobieLite.COBIEType.Resources)get_store().find_element_user(RESOURCES$22, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Resources" element
     */
    public void setResources(cobieLite.COBIEType.Resources resources)
    {
        generatedSetterHelperImpl(resources, RESOURCES$22, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Resources" element
     */
    public cobieLite.COBIEType.Resources addNewResources()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cobieLite.COBIEType.Resources target = null;
            target = (cobieLite.COBIEType.Resources)get_store().add_element_user(RESOURCES$22);
            return target;
        }
    }
    
    /**
     * Gets the "Jobs" element
     */
    public cobieLite.COBIEType.Jobs getJobs()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cobieLite.COBIEType.Jobs target = null;
            target = (cobieLite.COBIEType.Jobs)get_store().find_element_user(JOBS$24, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Jobs" element
     */
    public void setJobs(cobieLite.COBIEType.Jobs jobs)
    {
        generatedSetterHelperImpl(jobs, JOBS$24, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Jobs" element
     */
    public cobieLite.COBIEType.Jobs addNewJobs()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cobieLite.COBIEType.Jobs target = null;
            target = (cobieLite.COBIEType.Jobs)get_store().add_element_user(JOBS$24);
            return target;
        }
    }
    
    /**
     * Gets the "Impacts" element
     */
    public cobieLite.COBIEType.Impacts getImpacts()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cobieLite.COBIEType.Impacts target = null;
            target = (cobieLite.COBIEType.Impacts)get_store().find_element_user(IMPACTS$26, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Impacts" element
     */
    public void setImpacts(cobieLite.COBIEType.Impacts impacts)
    {
        generatedSetterHelperImpl(impacts, IMPACTS$26, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Impacts" element
     */
    public cobieLite.COBIEType.Impacts addNewImpacts()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cobieLite.COBIEType.Impacts target = null;
            target = (cobieLite.COBIEType.Impacts)get_store().add_element_user(IMPACTS$26);
            return target;
        }
    }
    
    /**
     * Gets the "Documents" element
     */
    public cobieLite.COBIEType.Documents getDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cobieLite.COBIEType.Documents target = null;
            target = (cobieLite.COBIEType.Documents)get_store().find_element_user(DOCUMENTS$28, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Documents" element
     */
    public void setDocuments(cobieLite.COBIEType.Documents documents)
    {
        generatedSetterHelperImpl(documents, DOCUMENTS$28, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Documents" element
     */
    public cobieLite.COBIEType.Documents addNewDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cobieLite.COBIEType.Documents target = null;
            target = (cobieLite.COBIEType.Documents)get_store().add_element_user(DOCUMENTS$28);
            return target;
        }
    }
    
    /**
     * Gets the "Attributes" element
     */
    public cobieLite.COBIEType.Attributes getAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cobieLite.COBIEType.Attributes target = null;
            target = (cobieLite.COBIEType.Attributes)get_store().find_element_user(ATTRIBUTES$30, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Attributes" element
     */
    public void setAttributes(cobieLite.COBIEType.Attributes attributes)
    {
        generatedSetterHelperImpl(attributes, ATTRIBUTES$30, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Attributes" element
     */
    public cobieLite.COBIEType.Attributes addNewAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cobieLite.COBIEType.Attributes target = null;
            target = (cobieLite.COBIEType.Attributes)get_store().add_element_user(ATTRIBUTES$30);
            return target;
        }
    }
    
    /**
     * Gets the "Coordinates" element
     */
    public cobieLite.COBIEType.Coordinates getCoordinates()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cobieLite.COBIEType.Coordinates target = null;
            target = (cobieLite.COBIEType.Coordinates)get_store().find_element_user(COORDINATES$32, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Coordinates" element
     */
    public void setCoordinates(cobieLite.COBIEType.Coordinates coordinates)
    {
        generatedSetterHelperImpl(coordinates, COORDINATES$32, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Coordinates" element
     */
    public cobieLite.COBIEType.Coordinates addNewCoordinates()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cobieLite.COBIEType.Coordinates target = null;
            target = (cobieLite.COBIEType.Coordinates)get_store().add_element_user(COORDINATES$32);
            return target;
        }
    }
    
    /**
     * Gets the "Issues" element
     */
    public cobieLite.COBIEType.Issues getIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cobieLite.COBIEType.Issues target = null;
            target = (cobieLite.COBIEType.Issues)get_store().find_element_user(ISSUES$34, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Issues" element
     */
    public void setIssues(cobieLite.COBIEType.Issues issues)
    {
        generatedSetterHelperImpl(issues, ISSUES$34, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Issues" element
     */
    public cobieLite.COBIEType.Issues addNewIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cobieLite.COBIEType.Issues target = null;
            target = (cobieLite.COBIEType.Issues)get_store().add_element_user(ISSUES$34);
            return target;
        }
    }
    /**
     * An XML Contacts(@).
     *
     * This is a complex type.
     */
    public static class ContactsImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cobieLite.COBIEType.Contacts
    {
        private static final long serialVersionUID = 1L;
        
        public ContactsImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName CONTACT$0 = 
            new javax.xml.namespace.QName("", "Contact");
        
        
        /**
         * Gets array of all "Contact" elements
         */
        public cobieLite.ContactType[] getContactArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(CONTACT$0, targetList);
                cobieLite.ContactType[] result = new cobieLite.ContactType[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "Contact" element
         */
        public cobieLite.ContactType getContactArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.ContactType target = null;
                target = (cobieLite.ContactType)get_store().find_element_user(CONTACT$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "Contact" element
         */
        public int sizeOfContactArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(CONTACT$0);
            }
        }
        
        /**
         * Sets array of all "Contact" element  WARNING: This method is not atomicaly synchronized.
         */
        public void setContactArray(cobieLite.ContactType[] contactArray)
        {
            check_orphaned();
            arraySetterHelper(contactArray, CONTACT$0);
        }
        
        /**
         * Sets ith "Contact" element
         */
        public void setContactArray(int i, cobieLite.ContactType contact)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.ContactType target = null;
                target = (cobieLite.ContactType)get_store().find_element_user(CONTACT$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(contact);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "Contact" element
         */
        public cobieLite.ContactType insertNewContact(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.ContactType target = null;
                target = (cobieLite.ContactType)get_store().insert_element_user(CONTACT$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Contact" element
         */
        public cobieLite.ContactType addNewContact()
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.ContactType target = null;
                target = (cobieLite.ContactType)get_store().add_element_user(CONTACT$0);
                return target;
            }
        }
        
        /**
         * Removes the ith "Contact" element
         */
        public void removeContact(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(CONTACT$0, i);
            }
        }
    }
    /**
     * An XML Facilities(@).
     *
     * This is a complex type.
     */
    public static class FacilitiesImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cobieLite.COBIEType.Facilities
    {
        private static final long serialVersionUID = 1L;
        
        public FacilitiesImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName FACILITY$0 = 
            new javax.xml.namespace.QName("", "Facility");
        
        
        /**
         * Gets array of all "Facility" elements
         */
        public cobieLite.FacilityType[] getFacilityArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(FACILITY$0, targetList);
                cobieLite.FacilityType[] result = new cobieLite.FacilityType[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "Facility" element
         */
        public cobieLite.FacilityType getFacilityArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.FacilityType target = null;
                target = (cobieLite.FacilityType)get_store().find_element_user(FACILITY$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "Facility" element
         */
        public int sizeOfFacilityArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(FACILITY$0);
            }
        }
        
        /**
         * Sets array of all "Facility" element  WARNING: This method is not atomicaly synchronized.
         */
        public void setFacilityArray(cobieLite.FacilityType[] facilityArray)
        {
            check_orphaned();
            arraySetterHelper(facilityArray, FACILITY$0);
        }
        
        /**
         * Sets ith "Facility" element
         */
        public void setFacilityArray(int i, cobieLite.FacilityType facility)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.FacilityType target = null;
                target = (cobieLite.FacilityType)get_store().find_element_user(FACILITY$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(facility);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "Facility" element
         */
        public cobieLite.FacilityType insertNewFacility(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.FacilityType target = null;
                target = (cobieLite.FacilityType)get_store().insert_element_user(FACILITY$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Facility" element
         */
        public cobieLite.FacilityType addNewFacility()
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.FacilityType target = null;
                target = (cobieLite.FacilityType)get_store().add_element_user(FACILITY$0);
                return target;
            }
        }
        
        /**
         * Removes the ith "Facility" element
         */
        public void removeFacility(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(FACILITY$0, i);
            }
        }
    }
    /**
     * An XML Floors(@).
     *
     * This is a complex type.
     */
    public static class FloorsImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cobieLite.COBIEType.Floors
    {
        private static final long serialVersionUID = 1L;
        
        public FloorsImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName FLOOR$0 = 
            new javax.xml.namespace.QName("", "Floor");
        
        
        /**
         * Gets array of all "Floor" elements
         */
        public cobieLite.FloorType[] getFloorArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(FLOOR$0, targetList);
                cobieLite.FloorType[] result = new cobieLite.FloorType[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "Floor" element
         */
        public cobieLite.FloorType getFloorArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.FloorType target = null;
                target = (cobieLite.FloorType)get_store().find_element_user(FLOOR$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "Floor" element
         */
        public int sizeOfFloorArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(FLOOR$0);
            }
        }
        
        /**
         * Sets array of all "Floor" element  WARNING: This method is not atomicaly synchronized.
         */
        public void setFloorArray(cobieLite.FloorType[] floorArray)
        {
            check_orphaned();
            arraySetterHelper(floorArray, FLOOR$0);
        }
        
        /**
         * Sets ith "Floor" element
         */
        public void setFloorArray(int i, cobieLite.FloorType floor)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.FloorType target = null;
                target = (cobieLite.FloorType)get_store().find_element_user(FLOOR$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(floor);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "Floor" element
         */
        public cobieLite.FloorType insertNewFloor(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.FloorType target = null;
                target = (cobieLite.FloorType)get_store().insert_element_user(FLOOR$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Floor" element
         */
        public cobieLite.FloorType addNewFloor()
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.FloorType target = null;
                target = (cobieLite.FloorType)get_store().add_element_user(FLOOR$0);
                return target;
            }
        }
        
        /**
         * Removes the ith "Floor" element
         */
        public void removeFloor(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(FLOOR$0, i);
            }
        }
    }
    /**
     * An XML Spaces(@).
     *
     * This is a complex type.
     */
    public static class SpacesImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cobieLite.COBIEType.Spaces
    {
        private static final long serialVersionUID = 1L;
        
        public SpacesImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName SPACE$0 = 
            new javax.xml.namespace.QName("", "Space");
        
        
        /**
         * Gets array of all "Space" elements
         */
        public cobieLite.SpaceType[] getSpaceArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(SPACE$0, targetList);
                cobieLite.SpaceType[] result = new cobieLite.SpaceType[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "Space" element
         */
        public cobieLite.SpaceType getSpaceArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.SpaceType target = null;
                target = (cobieLite.SpaceType)get_store().find_element_user(SPACE$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "Space" element
         */
        public int sizeOfSpaceArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(SPACE$0);
            }
        }
        
        /**
         * Sets array of all "Space" element  WARNING: This method is not atomicaly synchronized.
         */
        public void setSpaceArray(cobieLite.SpaceType[] spaceArray)
        {
            check_orphaned();
            arraySetterHelper(spaceArray, SPACE$0);
        }
        
        /**
         * Sets ith "Space" element
         */
        public void setSpaceArray(int i, cobieLite.SpaceType space)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.SpaceType target = null;
                target = (cobieLite.SpaceType)get_store().find_element_user(SPACE$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(space);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "Space" element
         */
        public cobieLite.SpaceType insertNewSpace(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.SpaceType target = null;
                target = (cobieLite.SpaceType)get_store().insert_element_user(SPACE$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Space" element
         */
        public cobieLite.SpaceType addNewSpace()
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.SpaceType target = null;
                target = (cobieLite.SpaceType)get_store().add_element_user(SPACE$0);
                return target;
            }
        }
        
        /**
         * Removes the ith "Space" element
         */
        public void removeSpace(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(SPACE$0, i);
            }
        }
    }
    /**
     * An XML Zones(@).
     *
     * This is a complex type.
     */
    public static class ZonesImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cobieLite.COBIEType.Zones
    {
        private static final long serialVersionUID = 1L;
        
        public ZonesImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName ZONE$0 = 
            new javax.xml.namespace.QName("", "Zone");
        
        
        /**
         * Gets array of all "Zone" elements
         */
        public cobieLite.ZoneType[] getZoneArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(ZONE$0, targetList);
                cobieLite.ZoneType[] result = new cobieLite.ZoneType[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "Zone" element
         */
        public cobieLite.ZoneType getZoneArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.ZoneType target = null;
                target = (cobieLite.ZoneType)get_store().find_element_user(ZONE$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "Zone" element
         */
        public int sizeOfZoneArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(ZONE$0);
            }
        }
        
        /**
         * Sets array of all "Zone" element  WARNING: This method is not atomicaly synchronized.
         */
        public void setZoneArray(cobieLite.ZoneType[] zoneArray)
        {
            check_orphaned();
            arraySetterHelper(zoneArray, ZONE$0);
        }
        
        /**
         * Sets ith "Zone" element
         */
        public void setZoneArray(int i, cobieLite.ZoneType zone)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.ZoneType target = null;
                target = (cobieLite.ZoneType)get_store().find_element_user(ZONE$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(zone);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "Zone" element
         */
        public cobieLite.ZoneType insertNewZone(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.ZoneType target = null;
                target = (cobieLite.ZoneType)get_store().insert_element_user(ZONE$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Zone" element
         */
        public cobieLite.ZoneType addNewZone()
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.ZoneType target = null;
                target = (cobieLite.ZoneType)get_store().add_element_user(ZONE$0);
                return target;
            }
        }
        
        /**
         * Removes the ith "Zone" element
         */
        public void removeZone(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(ZONE$0, i);
            }
        }
    }
    /**
     * An XML Types(@).
     *
     * This is a complex type.
     */
    public static class TypesImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cobieLite.COBIEType.Types
    {
        private static final long serialVersionUID = 1L;
        
        public TypesImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName TYPE$0 = 
            new javax.xml.namespace.QName("", "Type");
        
        
        /**
         * Gets array of all "Type" elements
         */
        public cobieLite.TypeType[] getTypeArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(TYPE$0, targetList);
                cobieLite.TypeType[] result = new cobieLite.TypeType[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "Type" element
         */
        public cobieLite.TypeType getTypeArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.TypeType target = null;
                target = (cobieLite.TypeType)get_store().find_element_user(TYPE$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "Type" element
         */
        public int sizeOfTypeArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(TYPE$0);
            }
        }
        
        /**
         * Sets array of all "Type" element  WARNING: This method is not atomicaly synchronized.
         */
        public void setTypeArray(cobieLite.TypeType[] typeArray)
        {
            check_orphaned();
            arraySetterHelper(typeArray, TYPE$0);
        }
        
        /**
         * Sets ith "Type" element
         */
        public void setTypeArray(int i, cobieLite.TypeType type)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.TypeType target = null;
                target = (cobieLite.TypeType)get_store().find_element_user(TYPE$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(type);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "Type" element
         */
        public cobieLite.TypeType insertNewType(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.TypeType target = null;
                target = (cobieLite.TypeType)get_store().insert_element_user(TYPE$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Type" element
         */
        public cobieLite.TypeType addNewType()
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.TypeType target = null;
                target = (cobieLite.TypeType)get_store().add_element_user(TYPE$0);
                return target;
            }
        }
        
        /**
         * Removes the ith "Type" element
         */
        public void removeType(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(TYPE$0, i);
            }
        }
    }
    /**
     * An XML Components(@).
     *
     * This is a complex type.
     */
    public static class ComponentsImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cobieLite.COBIEType.Components
    {
        private static final long serialVersionUID = 1L;
        
        public ComponentsImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName COMPONENT$0 = 
            new javax.xml.namespace.QName("", "Component");
        
        
        /**
         * Gets array of all "Component" elements
         */
        public cobieLite.ComponentType[] getComponentArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(COMPONENT$0, targetList);
                cobieLite.ComponentType[] result = new cobieLite.ComponentType[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "Component" element
         */
        public cobieLite.ComponentType getComponentArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.ComponentType target = null;
                target = (cobieLite.ComponentType)get_store().find_element_user(COMPONENT$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "Component" element
         */
        public int sizeOfComponentArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(COMPONENT$0);
            }
        }
        
        /**
         * Sets array of all "Component" element  WARNING: This method is not atomicaly synchronized.
         */
        public void setComponentArray(cobieLite.ComponentType[] componentArray)
        {
            check_orphaned();
            arraySetterHelper(componentArray, COMPONENT$0);
        }
        
        /**
         * Sets ith "Component" element
         */
        public void setComponentArray(int i, cobieLite.ComponentType component)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.ComponentType target = null;
                target = (cobieLite.ComponentType)get_store().find_element_user(COMPONENT$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(component);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "Component" element
         */
        public cobieLite.ComponentType insertNewComponent(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.ComponentType target = null;
                target = (cobieLite.ComponentType)get_store().insert_element_user(COMPONENT$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Component" element
         */
        public cobieLite.ComponentType addNewComponent()
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.ComponentType target = null;
                target = (cobieLite.ComponentType)get_store().add_element_user(COMPONENT$0);
                return target;
            }
        }
        
        /**
         * Removes the ith "Component" element
         */
        public void removeComponent(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(COMPONENT$0, i);
            }
        }
    }
    /**
     * An XML Systems(@).
     *
     * This is a complex type.
     */
    public static class SystemsImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cobieLite.COBIEType.Systems
    {
        private static final long serialVersionUID = 1L;
        
        public SystemsImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName SYSTEM$0 = 
            new javax.xml.namespace.QName("", "System");
        
        
        /**
         * Gets array of all "System" elements
         */
        public cobieLite.SystemType[] getSystemArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(SYSTEM$0, targetList);
                cobieLite.SystemType[] result = new cobieLite.SystemType[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "System" element
         */
        public cobieLite.SystemType getSystemArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.SystemType target = null;
                target = (cobieLite.SystemType)get_store().find_element_user(SYSTEM$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "System" element
         */
        public int sizeOfSystemArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(SYSTEM$0);
            }
        }
        
        /**
         * Sets array of all "System" element  WARNING: This method is not atomicaly synchronized.
         */
        public void setSystemArray(cobieLite.SystemType[] systemArray)
        {
            check_orphaned();
            arraySetterHelper(systemArray, SYSTEM$0);
        }
        
        /**
         * Sets ith "System" element
         */
        public void setSystemArray(int i, cobieLite.SystemType system)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.SystemType target = null;
                target = (cobieLite.SystemType)get_store().find_element_user(SYSTEM$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(system);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "System" element
         */
        public cobieLite.SystemType insertNewSystem(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.SystemType target = null;
                target = (cobieLite.SystemType)get_store().insert_element_user(SYSTEM$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "System" element
         */
        public cobieLite.SystemType addNewSystem()
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.SystemType target = null;
                target = (cobieLite.SystemType)get_store().add_element_user(SYSTEM$0);
                return target;
            }
        }
        
        /**
         * Removes the ith "System" element
         */
        public void removeSystem(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(SYSTEM$0, i);
            }
        }
    }
    /**
     * An XML Assemblies(@).
     *
     * This is a complex type.
     */
    public static class AssembliesImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cobieLite.COBIEType.Assemblies
    {
        private static final long serialVersionUID = 1L;
        
        public AssembliesImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName ASSEMBLY$0 = 
            new javax.xml.namespace.QName("", "Assembly");
        
        
        /**
         * Gets array of all "Assembly" elements
         */
        public cobieLite.AssemblyType[] getAssemblyArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(ASSEMBLY$0, targetList);
                cobieLite.AssemblyType[] result = new cobieLite.AssemblyType[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "Assembly" element
         */
        public cobieLite.AssemblyType getAssemblyArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.AssemblyType target = null;
                target = (cobieLite.AssemblyType)get_store().find_element_user(ASSEMBLY$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "Assembly" element
         */
        public int sizeOfAssemblyArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(ASSEMBLY$0);
            }
        }
        
        /**
         * Sets array of all "Assembly" element  WARNING: This method is not atomicaly synchronized.
         */
        public void setAssemblyArray(cobieLite.AssemblyType[] assemblyArray)
        {
            check_orphaned();
            arraySetterHelper(assemblyArray, ASSEMBLY$0);
        }
        
        /**
         * Sets ith "Assembly" element
         */
        public void setAssemblyArray(int i, cobieLite.AssemblyType assembly)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.AssemblyType target = null;
                target = (cobieLite.AssemblyType)get_store().find_element_user(ASSEMBLY$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(assembly);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "Assembly" element
         */
        public cobieLite.AssemblyType insertNewAssembly(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.AssemblyType target = null;
                target = (cobieLite.AssemblyType)get_store().insert_element_user(ASSEMBLY$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Assembly" element
         */
        public cobieLite.AssemblyType addNewAssembly()
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.AssemblyType target = null;
                target = (cobieLite.AssemblyType)get_store().add_element_user(ASSEMBLY$0);
                return target;
            }
        }
        
        /**
         * Removes the ith "Assembly" element
         */
        public void removeAssembly(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(ASSEMBLY$0, i);
            }
        }
    }
    /**
     * An XML Connections(@).
     *
     * This is a complex type.
     */
    public static class ConnectionsImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cobieLite.COBIEType.Connections
    {
        private static final long serialVersionUID = 1L;
        
        public ConnectionsImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName CONNECTION$0 = 
            new javax.xml.namespace.QName("", "Connection");
        
        
        /**
         * Gets array of all "Connection" elements
         */
        public cobieLite.ConnectionType[] getConnectionArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(CONNECTION$0, targetList);
                cobieLite.ConnectionType[] result = new cobieLite.ConnectionType[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "Connection" element
         */
        public cobieLite.ConnectionType getConnectionArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.ConnectionType target = null;
                target = (cobieLite.ConnectionType)get_store().find_element_user(CONNECTION$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "Connection" element
         */
        public int sizeOfConnectionArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(CONNECTION$0);
            }
        }
        
        /**
         * Sets array of all "Connection" element  WARNING: This method is not atomicaly synchronized.
         */
        public void setConnectionArray(cobieLite.ConnectionType[] connectionArray)
        {
            check_orphaned();
            arraySetterHelper(connectionArray, CONNECTION$0);
        }
        
        /**
         * Sets ith "Connection" element
         */
        public void setConnectionArray(int i, cobieLite.ConnectionType connection)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.ConnectionType target = null;
                target = (cobieLite.ConnectionType)get_store().find_element_user(CONNECTION$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(connection);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "Connection" element
         */
        public cobieLite.ConnectionType insertNewConnection(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.ConnectionType target = null;
                target = (cobieLite.ConnectionType)get_store().insert_element_user(CONNECTION$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Connection" element
         */
        public cobieLite.ConnectionType addNewConnection()
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.ConnectionType target = null;
                target = (cobieLite.ConnectionType)get_store().add_element_user(CONNECTION$0);
                return target;
            }
        }
        
        /**
         * Removes the ith "Connection" element
         */
        public void removeConnection(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(CONNECTION$0, i);
            }
        }
    }
    /**
     * An XML Spares(@).
     *
     * This is a complex type.
     */
    public static class SparesImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cobieLite.COBIEType.Spares
    {
        private static final long serialVersionUID = 1L;
        
        public SparesImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName SPARE$0 = 
            new javax.xml.namespace.QName("", "Spare");
        
        
        /**
         * Gets array of all "Spare" elements
         */
        public cobieLite.SpareType[] getSpareArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(SPARE$0, targetList);
                cobieLite.SpareType[] result = new cobieLite.SpareType[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "Spare" element
         */
        public cobieLite.SpareType getSpareArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.SpareType target = null;
                target = (cobieLite.SpareType)get_store().find_element_user(SPARE$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "Spare" element
         */
        public int sizeOfSpareArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(SPARE$0);
            }
        }
        
        /**
         * Sets array of all "Spare" element  WARNING: This method is not atomicaly synchronized.
         */
        public void setSpareArray(cobieLite.SpareType[] spareArray)
        {
            check_orphaned();
            arraySetterHelper(spareArray, SPARE$0);
        }
        
        /**
         * Sets ith "Spare" element
         */
        public void setSpareArray(int i, cobieLite.SpareType spare)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.SpareType target = null;
                target = (cobieLite.SpareType)get_store().find_element_user(SPARE$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(spare);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "Spare" element
         */
        public cobieLite.SpareType insertNewSpare(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.SpareType target = null;
                target = (cobieLite.SpareType)get_store().insert_element_user(SPARE$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Spare" element
         */
        public cobieLite.SpareType addNewSpare()
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.SpareType target = null;
                target = (cobieLite.SpareType)get_store().add_element_user(SPARE$0);
                return target;
            }
        }
        
        /**
         * Removes the ith "Spare" element
         */
        public void removeSpare(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(SPARE$0, i);
            }
        }
    }
    /**
     * An XML Resources(@).
     *
     * This is a complex type.
     */
    public static class ResourcesImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cobieLite.COBIEType.Resources
    {
        private static final long serialVersionUID = 1L;
        
        public ResourcesImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName RESOURCE$0 = 
            new javax.xml.namespace.QName("", "Resource");
        
        
        /**
         * Gets array of all "Resource" elements
         */
        public cobieLite.ResourceType[] getResourceArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(RESOURCE$0, targetList);
                cobieLite.ResourceType[] result = new cobieLite.ResourceType[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "Resource" element
         */
        public cobieLite.ResourceType getResourceArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.ResourceType target = null;
                target = (cobieLite.ResourceType)get_store().find_element_user(RESOURCE$0, i);
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
                return get_store().count_elements(RESOURCE$0);
            }
        }
        
        /**
         * Sets array of all "Resource" element  WARNING: This method is not atomicaly synchronized.
         */
        public void setResourceArray(cobieLite.ResourceType[] resourceArray)
        {
            check_orphaned();
            arraySetterHelper(resourceArray, RESOURCE$0);
        }
        
        /**
         * Sets ith "Resource" element
         */
        public void setResourceArray(int i, cobieLite.ResourceType resource)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.ResourceType target = null;
                target = (cobieLite.ResourceType)get_store().find_element_user(RESOURCE$0, i);
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
        public cobieLite.ResourceType insertNewResource(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.ResourceType target = null;
                target = (cobieLite.ResourceType)get_store().insert_element_user(RESOURCE$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Resource" element
         */
        public cobieLite.ResourceType addNewResource()
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.ResourceType target = null;
                target = (cobieLite.ResourceType)get_store().add_element_user(RESOURCE$0);
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
                get_store().remove_element(RESOURCE$0, i);
            }
        }
    }
    /**
     * An XML Jobs(@).
     *
     * This is a complex type.
     */
    public static class JobsImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cobieLite.COBIEType.Jobs
    {
        private static final long serialVersionUID = 1L;
        
        public JobsImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName JOB$0 = 
            new javax.xml.namespace.QName("", "Job");
        
        
        /**
         * Gets array of all "Job" elements
         */
        public cobieLite.JobType[] getJobArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(JOB$0, targetList);
                cobieLite.JobType[] result = new cobieLite.JobType[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "Job" element
         */
        public cobieLite.JobType getJobArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.JobType target = null;
                target = (cobieLite.JobType)get_store().find_element_user(JOB$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "Job" element
         */
        public int sizeOfJobArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(JOB$0);
            }
        }
        
        /**
         * Sets array of all "Job" element  WARNING: This method is not atomicaly synchronized.
         */
        public void setJobArray(cobieLite.JobType[] jobArray)
        {
            check_orphaned();
            arraySetterHelper(jobArray, JOB$0);
        }
        
        /**
         * Sets ith "Job" element
         */
        public void setJobArray(int i, cobieLite.JobType job)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.JobType target = null;
                target = (cobieLite.JobType)get_store().find_element_user(JOB$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(job);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "Job" element
         */
        public cobieLite.JobType insertNewJob(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.JobType target = null;
                target = (cobieLite.JobType)get_store().insert_element_user(JOB$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Job" element
         */
        public cobieLite.JobType addNewJob()
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.JobType target = null;
                target = (cobieLite.JobType)get_store().add_element_user(JOB$0);
                return target;
            }
        }
        
        /**
         * Removes the ith "Job" element
         */
        public void removeJob(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(JOB$0, i);
            }
        }
    }
    /**
     * An XML Impacts(@).
     *
     * This is a complex type.
     */
    public static class ImpactsImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cobieLite.COBIEType.Impacts
    {
        private static final long serialVersionUID = 1L;
        
        public ImpactsImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName IMPACT$0 = 
            new javax.xml.namespace.QName("", "Impact");
        
        
        /**
         * Gets array of all "Impact" elements
         */
        public cobieLite.ImpactType[] getImpactArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(IMPACT$0, targetList);
                cobieLite.ImpactType[] result = new cobieLite.ImpactType[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "Impact" element
         */
        public cobieLite.ImpactType getImpactArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.ImpactType target = null;
                target = (cobieLite.ImpactType)get_store().find_element_user(IMPACT$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "Impact" element
         */
        public int sizeOfImpactArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(IMPACT$0);
            }
        }
        
        /**
         * Sets array of all "Impact" element  WARNING: This method is not atomicaly synchronized.
         */
        public void setImpactArray(cobieLite.ImpactType[] impactArray)
        {
            check_orphaned();
            arraySetterHelper(impactArray, IMPACT$0);
        }
        
        /**
         * Sets ith "Impact" element
         */
        public void setImpactArray(int i, cobieLite.ImpactType impact)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.ImpactType target = null;
                target = (cobieLite.ImpactType)get_store().find_element_user(IMPACT$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(impact);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "Impact" element
         */
        public cobieLite.ImpactType insertNewImpact(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.ImpactType target = null;
                target = (cobieLite.ImpactType)get_store().insert_element_user(IMPACT$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Impact" element
         */
        public cobieLite.ImpactType addNewImpact()
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.ImpactType target = null;
                target = (cobieLite.ImpactType)get_store().add_element_user(IMPACT$0);
                return target;
            }
        }
        
        /**
         * Removes the ith "Impact" element
         */
        public void removeImpact(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(IMPACT$0, i);
            }
        }
    }
    /**
     * An XML Documents(@).
     *
     * This is a complex type.
     */
    public static class DocumentsImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cobieLite.COBIEType.Documents
    {
        private static final long serialVersionUID = 1L;
        
        public DocumentsImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName DOCUMENT$0 = 
            new javax.xml.namespace.QName("", "Document");
        
        
        /**
         * Gets array of all "Document" elements
         */
        public cobieLite.DocumentType[] getDocumentArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(DOCUMENT$0, targetList);
                cobieLite.DocumentType[] result = new cobieLite.DocumentType[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "Document" element
         */
        public cobieLite.DocumentType getDocumentArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.DocumentType target = null;
                target = (cobieLite.DocumentType)get_store().find_element_user(DOCUMENT$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "Document" element
         */
        public int sizeOfDocumentArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(DOCUMENT$0);
            }
        }
        
        /**
         * Sets array of all "Document" element  WARNING: This method is not atomicaly synchronized.
         */
        public void setDocumentArray(cobieLite.DocumentType[] documentArray)
        {
            check_orphaned();
            arraySetterHelper(documentArray, DOCUMENT$0);
        }
        
        /**
         * Sets ith "Document" element
         */
        public void setDocumentArray(int i, cobieLite.DocumentType document)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.DocumentType target = null;
                target = (cobieLite.DocumentType)get_store().find_element_user(DOCUMENT$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(document);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "Document" element
         */
        public cobieLite.DocumentType insertNewDocument(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.DocumentType target = null;
                target = (cobieLite.DocumentType)get_store().insert_element_user(DOCUMENT$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Document" element
         */
        public cobieLite.DocumentType addNewDocument()
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.DocumentType target = null;
                target = (cobieLite.DocumentType)get_store().add_element_user(DOCUMENT$0);
                return target;
            }
        }
        
        /**
         * Removes the ith "Document" element
         */
        public void removeDocument(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(DOCUMENT$0, i);
            }
        }
    }
    /**
     * An XML Attributes(@).
     *
     * This is a complex type.
     */
    public static class AttributesImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cobieLite.COBIEType.Attributes
    {
        private static final long serialVersionUID = 1L;
        
        public AttributesImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName ATTRIBUTE$0 = 
            new javax.xml.namespace.QName("", "Attribute");
        
        
        /**
         * Gets array of all "Attribute" elements
         */
        public cobieLite.AttributeType[] getAttributeArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(ATTRIBUTE$0, targetList);
                cobieLite.AttributeType[] result = new cobieLite.AttributeType[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "Attribute" element
         */
        public cobieLite.AttributeType getAttributeArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.AttributeType target = null;
                target = (cobieLite.AttributeType)get_store().find_element_user(ATTRIBUTE$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "Attribute" element
         */
        public int sizeOfAttributeArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(ATTRIBUTE$0);
            }
        }
        
        /**
         * Sets array of all "Attribute" element  WARNING: This method is not atomicaly synchronized.
         */
        public void setAttributeArray(cobieLite.AttributeType[] attributeArray)
        {
            check_orphaned();
            arraySetterHelper(attributeArray, ATTRIBUTE$0);
        }
        
        /**
         * Sets ith "Attribute" element
         */
        public void setAttributeArray(int i, cobieLite.AttributeType attribute)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.AttributeType target = null;
                target = (cobieLite.AttributeType)get_store().find_element_user(ATTRIBUTE$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(attribute);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "Attribute" element
         */
        public cobieLite.AttributeType insertNewAttribute(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.AttributeType target = null;
                target = (cobieLite.AttributeType)get_store().insert_element_user(ATTRIBUTE$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Attribute" element
         */
        public cobieLite.AttributeType addNewAttribute()
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.AttributeType target = null;
                target = (cobieLite.AttributeType)get_store().add_element_user(ATTRIBUTE$0);
                return target;
            }
        }
        
        /**
         * Removes the ith "Attribute" element
         */
        public void removeAttribute(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(ATTRIBUTE$0, i);
            }
        }
    }
    /**
     * An XML Coordinates(@).
     *
     * This is a complex type.
     */
    public static class CoordinatesImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cobieLite.COBIEType.Coordinates
    {
        private static final long serialVersionUID = 1L;
        
        public CoordinatesImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName COORDINATE$0 = 
            new javax.xml.namespace.QName("", "Coordinate");
        
        
        /**
         * Gets array of all "Coordinate" elements
         */
        public cobieLite.CoordinateType[] getCoordinateArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(COORDINATE$0, targetList);
                cobieLite.CoordinateType[] result = new cobieLite.CoordinateType[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "Coordinate" element
         */
        public cobieLite.CoordinateType getCoordinateArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.CoordinateType target = null;
                target = (cobieLite.CoordinateType)get_store().find_element_user(COORDINATE$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "Coordinate" element
         */
        public int sizeOfCoordinateArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(COORDINATE$0);
            }
        }
        
        /**
         * Sets array of all "Coordinate" element  WARNING: This method is not atomicaly synchronized.
         */
        public void setCoordinateArray(cobieLite.CoordinateType[] coordinateArray)
        {
            check_orphaned();
            arraySetterHelper(coordinateArray, COORDINATE$0);
        }
        
        /**
         * Sets ith "Coordinate" element
         */
        public void setCoordinateArray(int i, cobieLite.CoordinateType coordinate)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.CoordinateType target = null;
                target = (cobieLite.CoordinateType)get_store().find_element_user(COORDINATE$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(coordinate);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "Coordinate" element
         */
        public cobieLite.CoordinateType insertNewCoordinate(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.CoordinateType target = null;
                target = (cobieLite.CoordinateType)get_store().insert_element_user(COORDINATE$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Coordinate" element
         */
        public cobieLite.CoordinateType addNewCoordinate()
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.CoordinateType target = null;
                target = (cobieLite.CoordinateType)get_store().add_element_user(COORDINATE$0);
                return target;
            }
        }
        
        /**
         * Removes the ith "Coordinate" element
         */
        public void removeCoordinate(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(COORDINATE$0, i);
            }
        }
    }
    /**
     * An XML Issues(@).
     *
     * This is a complex type.
     */
    public static class IssuesImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cobieLite.COBIEType.Issues
    {
        private static final long serialVersionUID = 1L;
        
        public IssuesImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName ISSUE$0 = 
            new javax.xml.namespace.QName("", "Issue");
        
        
        /**
         * Gets array of all "Issue" elements
         */
        public cobieLite.IssueType[] getIssueArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(ISSUE$0, targetList);
                cobieLite.IssueType[] result = new cobieLite.IssueType[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "Issue" element
         */
        public cobieLite.IssueType getIssueArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.IssueType target = null;
                target = (cobieLite.IssueType)get_store().find_element_user(ISSUE$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "Issue" element
         */
        public int sizeOfIssueArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(ISSUE$0);
            }
        }
        
        /**
         * Sets array of all "Issue" element  WARNING: This method is not atomicaly synchronized.
         */
        public void setIssueArray(cobieLite.IssueType[] issueArray)
        {
            check_orphaned();
            arraySetterHelper(issueArray, ISSUE$0);
        }
        
        /**
         * Sets ith "Issue" element
         */
        public void setIssueArray(int i, cobieLite.IssueType issue)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.IssueType target = null;
                target = (cobieLite.IssueType)get_store().find_element_user(ISSUE$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(issue);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "Issue" element
         */
        public cobieLite.IssueType insertNewIssue(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.IssueType target = null;
                target = (cobieLite.IssueType)get_store().insert_element_user(ISSUE$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Issue" element
         */
        public cobieLite.IssueType addNewIssue()
        {
            synchronized (monitor())
            {
                check_orphaned();
                cobieLite.IssueType target = null;
                target = (cobieLite.IssueType)get_store().add_element_user(ISSUE$0);
                return target;
            }
        }
        
        /**
         * Removes the ith "Issue" element
         */
        public void removeIssue(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(ISSUE$0, i);
            }
        }
    }
}
