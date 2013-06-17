/*
 * XML Type:  AssetInfoType
 * Namespace: http://asset.cobielite.cobie.erdc.org
 * Java type: org.erdc.cobie.cobielite.asset.AssetInfoType
 *
 * Automatically generated - do not modify.
 */
package org.erdc.cobie.cobielite.asset.impl;
/**
 * An XML AssetInfoType(@http://asset.cobielite.cobie.erdc.org).
 *
 * This is a complex type.
 */
public class AssetInfoTypeImpl extends org.erdc.cobie.cobielite.core.impl.AssetInfoTypeImpl implements org.erdc.cobie.cobielite.asset.AssetInfoType
{
    private static final long serialVersionUID = 1L;
    
    public AssetInfoTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ASSETDESCRIPTION$0 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetDescription");
    private static final javax.xml.namespace.QName ASSETSERIALNUMBER$2 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetSerialNumber");
    private static final javax.xml.namespace.QName ASSETINSTALLATIONDATE$4 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetInstallationDate");
    private static final javax.xml.namespace.QName ASSETINSTALLEDMODELNUMBER$6 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetInstalledModelNumber");
    private static final javax.xml.namespace.QName ASSETWARRANTYSTARTDATE$8 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetWarrantyStartDate");
    private static final javax.xml.namespace.QName ASSETSTARTDATE$10 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetStartDate");
    private static final javax.xml.namespace.QName ASSETTAGNUMBER$12 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetTagNumber");
    private static final javax.xml.namespace.QName ASSETBARCODE$14 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetBarCode");
    private static final javax.xml.namespace.QName ASSETIDENTIFIER$16 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetIdentifier");
    private static final javax.xml.namespace.QName ASSETLOCATIONDESCRIPTION$18 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetLocationDescription");
    private static final javax.xml.namespace.QName ASSETSYSTEMASSIGNMENTS$20 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetSystemAssignments");
    private static final javax.xml.namespace.QName ASSEMBLYASSIGNMENTS$22 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssemblyAssignments");
    private static final javax.xml.namespace.QName ASSETATTRIBUTES$24 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetAttributes");
    private static final javax.xml.namespace.QName ASSETDOCUMENTS$26 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetDocuments");
    private static final javax.xml.namespace.QName ASSETISSUES$28 = 
        new javax.xml.namespace.QName("http://core.cobielite.cobie.erdc.org", "AssetIssues");
    
    
    /**
     * Gets the "AssetDescription" element
     */
    public java.lang.String getAssetDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETDESCRIPTION$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "AssetDescription" element
     */
    public org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType xgetAssetDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(ASSETDESCRIPTION$0, 0);
            return target;
        }
    }
    
    /**
     * True if has "AssetDescription" element
     */
    public boolean isSetAssetDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ASSETDESCRIPTION$0) != 0;
        }
    }
    
    /**
     * Sets the "AssetDescription" element
     */
    public void setAssetDescription(java.lang.String assetDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETDESCRIPTION$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ASSETDESCRIPTION$0);
            }
            target.setStringValue(assetDescription);
        }
    }
    
    /**
     * Sets (as xml) the "AssetDescription" element
     */
    public void xsetAssetDescription(org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType assetDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(ASSETDESCRIPTION$0, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().add_element_user(ASSETDESCRIPTION$0);
            }
            target.set(assetDescription);
        }
    }
    
    /**
     * Unsets the "AssetDescription" element
     */
    public void unsetAssetDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ASSETDESCRIPTION$0, 0);
        }
    }
    
    /**
     * Gets the "AssetSerialNumber" element
     */
    public java.lang.String getAssetSerialNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETSERIALNUMBER$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "AssetSerialNumber" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetAssetSerialNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(ASSETSERIALNUMBER$2, 0);
            return target;
        }
    }
    
    /**
     * True if has "AssetSerialNumber" element
     */
    public boolean isSetAssetSerialNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ASSETSERIALNUMBER$2) != 0;
        }
    }
    
    /**
     * Sets the "AssetSerialNumber" element
     */
    public void setAssetSerialNumber(java.lang.String assetSerialNumber)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETSERIALNUMBER$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ASSETSERIALNUMBER$2);
            }
            target.setStringValue(assetSerialNumber);
        }
    }
    
    /**
     * Sets (as xml) the "AssetSerialNumber" element
     */
    public void xsetAssetSerialNumber(org.erdc.cobie.cobielite.core.CobieTextSimpleType assetSerialNumber)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(ASSETSERIALNUMBER$2, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(ASSETSERIALNUMBER$2);
            }
            target.set(assetSerialNumber);
        }
    }
    
    /**
     * Unsets the "AssetSerialNumber" element
     */
    public void unsetAssetSerialNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ASSETSERIALNUMBER$2, 0);
        }
    }
    
    /**
     * Gets the "AssetInstallationDate" element
     */
    public java.util.Calendar getAssetInstallationDate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETINSTALLATIONDATE$4, 0);
            if (target == null)
            {
                return null;
            }
            return target.getCalendarValue();
        }
    }
    
    /**
     * Gets (as xml) the "AssetInstallationDate" element
     */
    public org.apache.xmlbeans.XmlDate xgetAssetInstallationDate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDate target = null;
            target = (org.apache.xmlbeans.XmlDate)get_store().find_element_user(ASSETINSTALLATIONDATE$4, 0);
            return target;
        }
    }
    
    /**
     * True if has "AssetInstallationDate" element
     */
    public boolean isSetAssetInstallationDate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ASSETINSTALLATIONDATE$4) != 0;
        }
    }
    
    /**
     * Sets the "AssetInstallationDate" element
     */
    public void setAssetInstallationDate(java.util.Calendar assetInstallationDate)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETINSTALLATIONDATE$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ASSETINSTALLATIONDATE$4);
            }
            target.setCalendarValue(assetInstallationDate);
        }
    }
    
    /**
     * Sets (as xml) the "AssetInstallationDate" element
     */
    public void xsetAssetInstallationDate(org.apache.xmlbeans.XmlDate assetInstallationDate)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDate target = null;
            target = (org.apache.xmlbeans.XmlDate)get_store().find_element_user(ASSETINSTALLATIONDATE$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlDate)get_store().add_element_user(ASSETINSTALLATIONDATE$4);
            }
            target.set(assetInstallationDate);
        }
    }
    
    /**
     * Unsets the "AssetInstallationDate" element
     */
    public void unsetAssetInstallationDate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ASSETINSTALLATIONDATE$4, 0);
        }
    }
    
    /**
     * Gets the "AssetInstalledModelNumber" element
     */
    public java.lang.String getAssetInstalledModelNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETINSTALLEDMODELNUMBER$6, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "AssetInstalledModelNumber" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetAssetInstalledModelNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(ASSETINSTALLEDMODELNUMBER$6, 0);
            return target;
        }
    }
    
    /**
     * True if has "AssetInstalledModelNumber" element
     */
    public boolean isSetAssetInstalledModelNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ASSETINSTALLEDMODELNUMBER$6) != 0;
        }
    }
    
    /**
     * Sets the "AssetInstalledModelNumber" element
     */
    public void setAssetInstalledModelNumber(java.lang.String assetInstalledModelNumber)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETINSTALLEDMODELNUMBER$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ASSETINSTALLEDMODELNUMBER$6);
            }
            target.setStringValue(assetInstalledModelNumber);
        }
    }
    
    /**
     * Sets (as xml) the "AssetInstalledModelNumber" element
     */
    public void xsetAssetInstalledModelNumber(org.erdc.cobie.cobielite.core.CobieTextSimpleType assetInstalledModelNumber)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(ASSETINSTALLEDMODELNUMBER$6, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(ASSETINSTALLEDMODELNUMBER$6);
            }
            target.set(assetInstalledModelNumber);
        }
    }
    
    /**
     * Unsets the "AssetInstalledModelNumber" element
     */
    public void unsetAssetInstalledModelNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ASSETINSTALLEDMODELNUMBER$6, 0);
        }
    }
    
    /**
     * Gets the "AssetWarrantyStartDate" element
     */
    public java.util.Calendar getAssetWarrantyStartDate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETWARRANTYSTARTDATE$8, 0);
            if (target == null)
            {
                return null;
            }
            return target.getCalendarValue();
        }
    }
    
    /**
     * Gets (as xml) the "AssetWarrantyStartDate" element
     */
    public org.apache.xmlbeans.XmlDate xgetAssetWarrantyStartDate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDate target = null;
            target = (org.apache.xmlbeans.XmlDate)get_store().find_element_user(ASSETWARRANTYSTARTDATE$8, 0);
            return target;
        }
    }
    
    /**
     * True if has "AssetWarrantyStartDate" element
     */
    public boolean isSetAssetWarrantyStartDate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ASSETWARRANTYSTARTDATE$8) != 0;
        }
    }
    
    /**
     * Sets the "AssetWarrantyStartDate" element
     */
    public void setAssetWarrantyStartDate(java.util.Calendar assetWarrantyStartDate)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETWARRANTYSTARTDATE$8, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ASSETWARRANTYSTARTDATE$8);
            }
            target.setCalendarValue(assetWarrantyStartDate);
        }
    }
    
    /**
     * Sets (as xml) the "AssetWarrantyStartDate" element
     */
    public void xsetAssetWarrantyStartDate(org.apache.xmlbeans.XmlDate assetWarrantyStartDate)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDate target = null;
            target = (org.apache.xmlbeans.XmlDate)get_store().find_element_user(ASSETWARRANTYSTARTDATE$8, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlDate)get_store().add_element_user(ASSETWARRANTYSTARTDATE$8);
            }
            target.set(assetWarrantyStartDate);
        }
    }
    
    /**
     * Unsets the "AssetWarrantyStartDate" element
     */
    public void unsetAssetWarrantyStartDate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ASSETWARRANTYSTARTDATE$8, 0);
        }
    }
    
    /**
     * Gets the "AssetStartDate" element
     */
    public java.lang.String getAssetStartDate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETSTARTDATE$10, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "AssetStartDate" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetAssetStartDate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(ASSETSTARTDATE$10, 0);
            return target;
        }
    }
    
    /**
     * True if has "AssetStartDate" element
     */
    public boolean isSetAssetStartDate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ASSETSTARTDATE$10) != 0;
        }
    }
    
    /**
     * Sets the "AssetStartDate" element
     */
    public void setAssetStartDate(java.lang.String assetStartDate)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETSTARTDATE$10, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ASSETSTARTDATE$10);
            }
            target.setStringValue(assetStartDate);
        }
    }
    
    /**
     * Sets (as xml) the "AssetStartDate" element
     */
    public void xsetAssetStartDate(org.erdc.cobie.cobielite.core.CobieTextSimpleType assetStartDate)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(ASSETSTARTDATE$10, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(ASSETSTARTDATE$10);
            }
            target.set(assetStartDate);
        }
    }
    
    /**
     * Unsets the "AssetStartDate" element
     */
    public void unsetAssetStartDate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ASSETSTARTDATE$10, 0);
        }
    }
    
    /**
     * Gets the "AssetTagNumber" element
     */
    public java.lang.String getAssetTagNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETTAGNUMBER$12, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "AssetTagNumber" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetAssetTagNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(ASSETTAGNUMBER$12, 0);
            return target;
        }
    }
    
    /**
     * True if has "AssetTagNumber" element
     */
    public boolean isSetAssetTagNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ASSETTAGNUMBER$12) != 0;
        }
    }
    
    /**
     * Sets the "AssetTagNumber" element
     */
    public void setAssetTagNumber(java.lang.String assetTagNumber)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETTAGNUMBER$12, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ASSETTAGNUMBER$12);
            }
            target.setStringValue(assetTagNumber);
        }
    }
    
    /**
     * Sets (as xml) the "AssetTagNumber" element
     */
    public void xsetAssetTagNumber(org.erdc.cobie.cobielite.core.CobieTextSimpleType assetTagNumber)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(ASSETTAGNUMBER$12, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(ASSETTAGNUMBER$12);
            }
            target.set(assetTagNumber);
        }
    }
    
    /**
     * Unsets the "AssetTagNumber" element
     */
    public void unsetAssetTagNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ASSETTAGNUMBER$12, 0);
        }
    }
    
    /**
     * Gets the "AssetBarCode" element
     */
    public java.lang.String getAssetBarCode()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETBARCODE$14, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "AssetBarCode" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetAssetBarCode()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(ASSETBARCODE$14, 0);
            return target;
        }
    }
    
    /**
     * True if has "AssetBarCode" element
     */
    public boolean isSetAssetBarCode()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ASSETBARCODE$14) != 0;
        }
    }
    
    /**
     * Sets the "AssetBarCode" element
     */
    public void setAssetBarCode(java.lang.String assetBarCode)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETBARCODE$14, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ASSETBARCODE$14);
            }
            target.setStringValue(assetBarCode);
        }
    }
    
    /**
     * Sets (as xml) the "AssetBarCode" element
     */
    public void xsetAssetBarCode(org.erdc.cobie.cobielite.core.CobieTextSimpleType assetBarCode)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(ASSETBARCODE$14, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(ASSETBARCODE$14);
            }
            target.set(assetBarCode);
        }
    }
    
    /**
     * Unsets the "AssetBarCode" element
     */
    public void unsetAssetBarCode()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ASSETBARCODE$14, 0);
        }
    }
    
    /**
     * Gets the "AssetIdentifier" element
     */
    public java.lang.String getAssetIdentifier()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETIDENTIFIER$16, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "AssetIdentifier" element
     */
    public org.erdc.cobie.cobielite.core.CobieTextSimpleType xgetAssetIdentifier()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(ASSETIDENTIFIER$16, 0);
            return target;
        }
    }
    
    /**
     * True if has "AssetIdentifier" element
     */
    public boolean isSetAssetIdentifier()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ASSETIDENTIFIER$16) != 0;
        }
    }
    
    /**
     * Sets the "AssetIdentifier" element
     */
    public void setAssetIdentifier(java.lang.String assetIdentifier)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETIDENTIFIER$16, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ASSETIDENTIFIER$16);
            }
            target.setStringValue(assetIdentifier);
        }
    }
    
    /**
     * Sets (as xml) the "AssetIdentifier" element
     */
    public void xsetAssetIdentifier(org.erdc.cobie.cobielite.core.CobieTextSimpleType assetIdentifier)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieTextSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().find_element_user(ASSETIDENTIFIER$16, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieTextSimpleType)get_store().add_element_user(ASSETIDENTIFIER$16);
            }
            target.set(assetIdentifier);
        }
    }
    
    /**
     * Unsets the "AssetIdentifier" element
     */
    public void unsetAssetIdentifier()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ASSETIDENTIFIER$16, 0);
        }
    }
    
    /**
     * Gets the "AssetLocationDescription" element
     */
    public java.lang.String getAssetLocationDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETLOCATIONDESCRIPTION$18, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "AssetLocationDescription" element
     */
    public org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType xgetAssetLocationDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(ASSETLOCATIONDESCRIPTION$18, 0);
            return target;
        }
    }
    
    /**
     * True if has "AssetLocationDescription" element
     */
    public boolean isSetAssetLocationDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ASSETLOCATIONDESCRIPTION$18) != 0;
        }
    }
    
    /**
     * Sets the "AssetLocationDescription" element
     */
    public void setAssetLocationDescription(java.lang.String assetLocationDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASSETLOCATIONDESCRIPTION$18, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ASSETLOCATIONDESCRIPTION$18);
            }
            target.setStringValue(assetLocationDescription);
        }
    }
    
    /**
     * Sets (as xml) the "AssetLocationDescription" element
     */
    public void xsetAssetLocationDescription(org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType assetLocationDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType target = null;
            target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().find_element_user(ASSETLOCATIONDESCRIPTION$18, 0);
            if (target == null)
            {
                target = (org.erdc.cobie.cobielite.core.CobieDescriptionSimpleType)get_store().add_element_user(ASSETLOCATIONDESCRIPTION$18);
            }
            target.set(assetLocationDescription);
        }
    }
    
    /**
     * Unsets the "AssetLocationDescription" element
     */
    public void unsetAssetLocationDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ASSETLOCATIONDESCRIPTION$18, 0);
        }
    }
    
    /**
     * Gets the "AssetSystemAssignments" element
     */
    public org.erdc.cobie.cobielite.core.SystemAssignmentCollectionType getAssetSystemAssignments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SystemAssignmentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.SystemAssignmentCollectionType)get_store().find_element_user(ASSETSYSTEMASSIGNMENTS$20, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "AssetSystemAssignments" element
     */
    public boolean isSetAssetSystemAssignments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ASSETSYSTEMASSIGNMENTS$20) != 0;
        }
    }
    
    /**
     * Sets the "AssetSystemAssignments" element
     */
    public void setAssetSystemAssignments(org.erdc.cobie.cobielite.core.SystemAssignmentCollectionType assetSystemAssignments)
    {
        generatedSetterHelperImpl(assetSystemAssignments, ASSETSYSTEMASSIGNMENTS$20, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "AssetSystemAssignments" element
     */
    public org.erdc.cobie.cobielite.core.SystemAssignmentCollectionType addNewAssetSystemAssignments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.SystemAssignmentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.SystemAssignmentCollectionType)get_store().add_element_user(ASSETSYSTEMASSIGNMENTS$20);
            return target;
        }
    }
    
    /**
     * Unsets the "AssetSystemAssignments" element
     */
    public void unsetAssetSystemAssignments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ASSETSYSTEMASSIGNMENTS$20, 0);
        }
    }
    
    /**
     * Gets the "AssemblyAssignments" element
     */
    public org.erdc.cobie.cobielite.core.AssemblyAssignmentCollectionType getAssemblyAssignments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AssemblyAssignmentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.AssemblyAssignmentCollectionType)get_store().find_element_user(ASSEMBLYASSIGNMENTS$22, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "AssemblyAssignments" element
     */
    public boolean isSetAssemblyAssignments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ASSEMBLYASSIGNMENTS$22) != 0;
        }
    }
    
    /**
     * Sets the "AssemblyAssignments" element
     */
    public void setAssemblyAssignments(org.erdc.cobie.cobielite.core.AssemblyAssignmentCollectionType assemblyAssignments)
    {
        generatedSetterHelperImpl(assemblyAssignments, ASSEMBLYASSIGNMENTS$22, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "AssemblyAssignments" element
     */
    public org.erdc.cobie.cobielite.core.AssemblyAssignmentCollectionType addNewAssemblyAssignments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AssemblyAssignmentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.AssemblyAssignmentCollectionType)get_store().add_element_user(ASSEMBLYASSIGNMENTS$22);
            return target;
        }
    }
    
    /**
     * Unsets the "AssemblyAssignments" element
     */
    public void unsetAssemblyAssignments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ASSEMBLYASSIGNMENTS$22, 0);
        }
    }
    
    /**
     * Gets the "AssetAttributes" element
     */
    public org.erdc.cobie.cobielite.core.AttributeCollectionType getAssetAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeCollectionType)get_store().find_element_user(ASSETATTRIBUTES$24, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "AssetAttributes" element
     */
    public boolean isSetAssetAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ASSETATTRIBUTES$24) != 0;
        }
    }
    
    /**
     * Sets the "AssetAttributes" element
     */
    public void setAssetAttributes(org.erdc.cobie.cobielite.core.AttributeCollectionType assetAttributes)
    {
        generatedSetterHelperImpl(assetAttributes, ASSETATTRIBUTES$24, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "AssetAttributes" element
     */
    public org.erdc.cobie.cobielite.core.AttributeCollectionType addNewAssetAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.AttributeCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.AttributeCollectionType)get_store().add_element_user(ASSETATTRIBUTES$24);
            return target;
        }
    }
    
    /**
     * Unsets the "AssetAttributes" element
     */
    public void unsetAssetAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ASSETATTRIBUTES$24, 0);
        }
    }
    
    /**
     * Gets the "AssetDocuments" element
     */
    public org.erdc.cobie.cobielite.core.DocumentCollectionType getAssetDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DocumentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.DocumentCollectionType)get_store().find_element_user(ASSETDOCUMENTS$26, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "AssetDocuments" element
     */
    public boolean isSetAssetDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ASSETDOCUMENTS$26) != 0;
        }
    }
    
    /**
     * Sets the "AssetDocuments" element
     */
    public void setAssetDocuments(org.erdc.cobie.cobielite.core.DocumentCollectionType assetDocuments)
    {
        generatedSetterHelperImpl(assetDocuments, ASSETDOCUMENTS$26, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "AssetDocuments" element
     */
    public org.erdc.cobie.cobielite.core.DocumentCollectionType addNewAssetDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.DocumentCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.DocumentCollectionType)get_store().add_element_user(ASSETDOCUMENTS$26);
            return target;
        }
    }
    
    /**
     * Unsets the "AssetDocuments" element
     */
    public void unsetAssetDocuments()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ASSETDOCUMENTS$26, 0);
        }
    }
    
    /**
     * Gets the "AssetIssues" element
     */
    public org.erdc.cobie.cobielite.core.IssueCollectionType getAssetIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IssueCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.IssueCollectionType)get_store().find_element_user(ASSETISSUES$28, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "AssetIssues" element
     */
    public boolean isSetAssetIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ASSETISSUES$28) != 0;
        }
    }
    
    /**
     * Sets the "AssetIssues" element
     */
    public void setAssetIssues(org.erdc.cobie.cobielite.core.IssueCollectionType assetIssues)
    {
        generatedSetterHelperImpl(assetIssues, ASSETISSUES$28, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "AssetIssues" element
     */
    public org.erdc.cobie.cobielite.core.IssueCollectionType addNewAssetIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.erdc.cobie.cobielite.core.IssueCollectionType target = null;
            target = (org.erdc.cobie.cobielite.core.IssueCollectionType)get_store().add_element_user(ASSETISSUES$28);
            return target;
        }
    }
    
    /**
     * Unsets the "AssetIssues" element
     */
    public void unsetAssetIssues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ASSETISSUES$28, 0);
        }
    }
}
