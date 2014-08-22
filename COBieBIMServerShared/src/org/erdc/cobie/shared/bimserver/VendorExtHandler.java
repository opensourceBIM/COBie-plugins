package org.erdc.cobie.shared.bimserver;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bimserver.models.ifc2x3tc1.IfcDoor;
import org.bimserver.models.ifc2x3tc1.IfcDoorStyle;
import org.bimserver.models.ifc2x3tc1.IfcWindow;
import org.bimserver.models.ifc2x3tc1.IfcWindowStyle;
import org.erdc.cobie.shared.COBieUtility.CobieSheetName;

public class VendorExtHandler
{
    public enum Vendor
    {
        AUTODESK, GRAPHISOFT, BENTLEY, ONUMA, VECTORWORKS
    }

    private static final String IFC_DOOR_CLASSNAME = IfcDoor.class.getSimpleName();
    private static final String IFC_WINDOW_CLASSNAME = IfcWindow.class.getSimpleName();
    private static final String IFC_DOORSTYLE_CLASSNAME = IfcDoorStyle.class.getSimpleName();
    private static final String IFC_WINDOWSTYLE_CLASSNAME = IfcWindowStyle.class.getSimpleName();
    private static final List<String> AUTODESK_EXTSYSTEM_CONTAINS = Arrays.asList(new String[]
    {
            "autodesk", "revit"
    });;

    private static void addAutoDeskComponentLookupItems(Map<Vendor, Map<String, String>> vendorToExtObjectComponentLookup)
    {
        Map<String, String> autoDeskComponentLookup = new HashMap<String, String>();
        for (String doorObjectName : AUTODESK_DOOR_EXTOBJECTS)
        {
            autoDeskComponentLookup.put(doorObjectName, IFC_DOOR_CLASSNAME);
        }
        for (String windowObjectName : AUTODESK_WINDOW_EXTOBJECTS)
        {
            autoDeskComponentLookup.put(windowObjectName, IFC_WINDOW_CLASSNAME);
        }
        vendorToExtObjectComponentLookup.put(Vendor.AUTODESK, autoDeskComponentLookup);
    }

    private static void addAutoDeskTypeLookupItems(Map<Vendor, Map<String, String>> vendorToExtObjectTypeLookup)
    {
        Map<String, String> autoDeskTypeLookup = new HashMap<String, String>();
        for (String doorObjectName : AUTODESK_DOORSYMBOL_EXTOBJECTS)
        {
            autoDeskTypeLookup.put(doorObjectName, IFC_DOORSTYLE_CLASSNAME);
        }
        for (String windowObjectName : AUTODESK_WINDOWSYMBOL_EXTOBJECTS)
        {
            autoDeskTypeLookup.put(windowObjectName, IFC_WINDOWSTYLE_CLASSNAME);
        }
        vendorToExtObjectTypeLookup.put(Vendor.AUTODESK, autoDeskTypeLookup);

    }

    private static Map<Vendor, Map<String, String>> getVendorExtObjectComponentLookup()
    {
        Map<Vendor, Map<String, String>> vendorToExtObjectComponentLookup = new HashMap<Vendor, Map<String, String>>();
        for (Vendor vendor : Vendor.values())
        {
            switch (vendor)
            {
                case AUTODESK:
                    addAutoDeskComponentLookupItems(vendorToExtObjectComponentLookup);
                    break;
                case BENTLEY:
                    break;
                case GRAPHISOFT:
                    break;
                case ONUMA:
                    break;
                case VECTORWORKS:
                    break;

            }
        }
        return vendorToExtObjectComponentLookup;
    }

    private static Map<Vendor, Map<String, String>> getVendorExtObjectTypeLookup()
    {
        Map<Vendor, Map<String, String>> vendorToExtObjectTypeLookup = new HashMap<Vendor, Map<String, String>>();
        for (Vendor vendor : Vendor.values())
        {
            switch (vendor)
            {
                case AUTODESK:
                    addAutoDeskTypeLookupItems(vendorToExtObjectTypeLookup);
                    break;
                case BENTLEY:
                    break;
                case GRAPHISOFT:
                    break;
                case ONUMA:
                    break;
                case VECTORWORKS:
                    break;

            }
        }
        return vendorToExtObjectTypeLookup;
    }

    private static Map<Vendor, List<String>> getVendorToExtSystemKeywords()
    {
        Map<Vendor, List<String>> vendorDictionary = new HashMap<Vendor, List<String>>();
        for (Vendor vendor : Vendor.values())
        {
            switch (vendor)
            {
                case AUTODESK:
                    vendorDictionary.put(vendor, AUTODESK_EXTSYSTEM_CONTAINS);
                    break;
                case BENTLEY:
                    break;
                case GRAPHISOFT:
                    break;
                case ONUMA:
                    break;
                case VECTORWORKS:
                    break;

            }
        }
        return vendorDictionary;
    }

    private Vendor vendor;
    private static final List<String> AUTODESK_DOOR_EXTOBJECTS = Arrays.asList(new String[]
    {
        "Autodesk.Revit.DB.FamilyInstance:OST_Doors"
    });
    private static final List<String> AUTODESK_WINDOW_EXTOBJECTS = Arrays.asList(new String[]
    {
        "Autodesk.Revit.DB.FamilyInstance:OST_Windows"
    });

    private static final List<String> AUTODESK_DOORSYMBOL_EXTOBJECTS = Arrays.asList(new String[]
    {
        "Autodesk.Revit.DB.FamilySymbol:OST_Doors"
    });
    private static final List<String> AUTODESK_WINDOWSYMBOL_EXTOBJECTS = Arrays.asList(new String[]
    {
        "Autodesk.Revit.DB.FamilySymbol:OST_Windows"
    });
    private static final Map<Vendor, Map<String, String>> VENDOR_TO_EXTOBJECT_TYPE_LOOKUP = getVendorExtObjectTypeLookup();
    private static final Map<Vendor, Map<String, String>> VENDOR_TO_EXTOBJECT_COMPONENT_LOOKUP = getVendorExtObjectComponentLookup();
    private static final Map<Vendor, List<String>> VENDOR_TO_EXTSYSTEM_KEYWORDS = getVendorToExtSystemKeywords();

    private String extSystem, extObject, extIdentifier;
    private String ifcExtObject, ifcExtIdentifier;
    private CobieSheetName cobieSheetName;

    public VendorExtHandler(String extSystem, String extObject, String extIdentifier, CobieSheetName cobieSheetName)
    {
        setCobieSheetName(cobieSheetName);
        setExtSystem(extSystem);
        setExtIdentifier(extIdentifier);
        setExtObject(extObject);
        setVendor();
        setIfcExtObject();

    }

    public CobieSheetName getCobieSheetName()
    {
        return cobieSheetName;
    }

    public String getExtIdentifier()
    {
        return extIdentifier;
    }

    public String getExtObject()
    {
        return extObject;
    }

    public String getExtSystem()
    {
        return extSystem;
    }

    public String getIfcExtIdentifier()
    {
        return ifcExtIdentifier;
    }

    public String getIfcExtObject()
    {
        return ifcExtObject;
    }

    public Vendor getVendor()
    {
        return vendor;
    }

    public void setCobieSheetName(CobieSheetName cobieSheetName)
    {
        this.cobieSheetName = cobieSheetName;
    }

    public void setExtIdentifier(String extIdentifier)
    {
        this.extIdentifier = extIdentifier;
    }

    public void setExtObject(String extObject)
    {
        this.extObject = extObject;
    }

    public void setExtSystem(String extSystem)
    {
        this.extSystem = extSystem;
    }

    public void setIfcExtIdentifier(String ifcExtIdentifier)
    {
        this.ifcExtIdentifier = ifcExtIdentifier;
    }

    public void setIfcExtObject()
    {
        String ifcObjectName = "";
        switch (cobieSheetName)
        {
            case Assembly:
                break;
            case Attribute:
                break;
            case Component:
                if ((vendor != null) && VENDOR_TO_EXTOBJECT_COMPONENT_LOOKUP.containsKey(vendor))
                {
                    Map<String, String> vendorStrings = VENDOR_TO_EXTOBJECT_COMPONENT_LOOKUP.get(vendor);
                    if ((vendorStrings != null) && vendorStrings.containsKey(extObject))
                    {
                        ifcObjectName = vendorStrings.get(extObject);
                    }
                }
                break;
            case Connection:
                break;
            case Contact:
                break;
            case Coordinate:
                break;
            case Document:
                break;
            case Facility:
                break;
            case Floor:
                break;
            case Impact:
                break;
            case Issue:
                break;
            case Job:
                break;
            case Resource:
                break;
            case Space:
                break;
            case Spare:
                break;
            case System:
                break;
            case Type:
                if ((vendor != null) && VENDOR_TO_EXTOBJECT_TYPE_LOOKUP.containsKey(vendor))
                {
                    Map<String, String> vendorStrings = VENDOR_TO_EXTOBJECT_TYPE_LOOKUP.get(vendor);
                    if ((vendorStrings != null) && vendorStrings.containsKey(extObject))
                    {
                        ifcObjectName = vendorStrings.get(extObject);
                    }
                }
                break;
            case Zone:
                break;

        }
        if (ifcObjectName.length() > 0)
        {
            ifcExtObject = ifcObjectName;
        }
    }

    private void setVendor()
    {
        for (Vendor vendor : Vendor.values())
        {
            if (VENDOR_TO_EXTSYSTEM_KEYWORDS.containsKey(vendor))
            {
                List<String> vendorStrings = VENDOR_TO_EXTSYSTEM_KEYWORDS.get(vendor);
                for (String vendorString : vendorStrings)
                {
                    if (extSystem.toLowerCase().contains(vendorString.toLowerCase()))
                    {
                        this.vendor = vendor;
                    }
                }
            }
        }
    }

}
