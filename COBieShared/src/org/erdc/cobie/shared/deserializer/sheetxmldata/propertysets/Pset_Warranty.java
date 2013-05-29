package org.erdc.cobie.shared.deserializer.sheetxmldata.propertysets;

import java.util.HashMap;

import org.bimserver.models.ifc2x3tc1.IfcProperty;
import org.bimserver.models.ifc2x3tc1.IfcPropertyReferenceValue;
import org.bimserver.models.ifc2x3tc1.IfcPropertySet;
import org.bimserver.models.ifc2x3tc1.IfcPropertySingleValue;
import org.bimserver.models.ifc2x3tc1.impl.IfcPropertySetImpl;
import org.erdc.cobie.shared.collections.NonCaseSensitiveHashMap;
import org.erdc.cobie.shared.enums.Pset_Warranty_Field;

public class Pset_Warranty extends IfcPropertySetImpl
{
    public IfcPropertySingleValue getWarrantyIdentifier()
    {
        return WarrantyIdentifier;
    }

    public void setWarrantyIdentifier(IfcPropertySingleValue warrantyIdentifier)
    {
        WarrantyIdentifier = warrantyIdentifier;
    }

    public IfcPropertyReferenceValue getWarrantyStartDate()
    {
        return WarrantyStartDate;
    }

    public void setWarrantyStartDate(IfcPropertyReferenceValue warrantyStartDate)
    {
        WarrantyStartDate = warrantyStartDate;
    }

    public IfcPropertyReferenceValue getWarrantyEndDate()
    {
        return WarrantyEndDate;
    }

    public void setWarrantyEndDate(IfcPropertyReferenceValue warrantyEndDate)
    {
        WarrantyEndDate = warrantyEndDate;
    }

    public IfcPropertySingleValue getIsExtendedWarranty()
    {
        return IsExtendedWarranty;
    }

    public void setIsExtendedWarranty(IfcPropertySingleValue isExtendedWarranty)
    {
        IsExtendedWarranty = isExtendedWarranty;
    }

    public IfcPropertySingleValue getWarrantyPeriod()
    {
        return WarrantyPeriod;
    }

    public void setWarrantyPeriod(IfcPropertySingleValue warrantyPeriod)
    {
        WarrantyPeriod = warrantyPeriod;
    }

    public IfcPropertyReferenceValue getPointOfContact()
    {
        return PointOfContact;
    }

    public void setPointOfContact(IfcPropertyReferenceValue pointOfContact)
    {
        PointOfContact = pointOfContact;
    }

    public IfcPropertySingleValue getWarrantyContent()
    {
        return WarrantyContent;
    }

    public void setWarrantyContent(IfcPropertySingleValue warrantyContent)
    {
        WarrantyContent = warrantyContent;
    }

    public IfcPropertySingleValue getExclusions()
    {
        return Exclusions;
    }

    public void setExclusions(IfcPropertySingleValue exclusions)
    {
        Exclusions = exclusions;
    }

    /*WarrantyIdentifier  IfcPropertySingleValue  IfcIdentifier   The identifier assigned to a warranty.
    WarrantyStartDate   IfcPropertyReferenceValue   IfcCalendarDate The date on which the warranty commences
    WarrantyEndDate IfcPropertyReferenceValue   IfcCalendarDate The date on which the warranty expires.
    IsExtendedWarranty  IfcPropertySingleValue  IfcBoolean  Indication of whether this is an extended warranty whose duration is greater than that normally assigned to an artefact (=TRUE) or not (= FALSE)
    WarrantyPeriod  IfcPropertySingleValue  IfcTimeMeasure / TIMEUNIT   The time duration during which a manufacturer or supplier guarantees or warrants the performance of an artefact.
    PointOfContact  IfcPropertyReferenceValue   IfcOrganization The organization that should be contacted for action under the terms of the warranty. Note that the role of the organization (manufacturer, supplier, installer etc.) is determined by the IfcActorRole attribute of IfcOrganization.
    WarrantyContent IfcPropertySingleValue  IfcText The content of the warranty
    Exclusions IfcPropertySingleValue   IfcText Items, conditions or actions that may be excluded from the warranty or that may cause the warranty to become void.*/
    private IfcPropertySingleValue  WarrantyIdentifier;
    private IfcPropertyReferenceValue  WarrantyStartDate;
    private IfcPropertyReferenceValue  WarrantyEndDate;
    private IfcPropertySingleValue  IsExtendedWarranty;
    private IfcPropertySingleValue  WarrantyPeriod;
    private IfcPropertyReferenceValue  PointOfContact;
    private IfcPropertySingleValue  WarrantyContent;
    private IfcPropertySingleValue  Exclusions;
    public static String PROPERTY_SET_NAME = "Pset_Warranty";
    public static String PROPERTY_SET_DESCRIPTION = "Definition from IAI: An assurance given by the seller or provider of an artefact that the artefact is without defects and will operate as described for a defined period of time without failure and that if a defect does arise during that time, that it will be corrected by the seller or provider.";
    public Pset_Warranty(IfcPropertySet propertySet) throws UnsupportedOperationException
    {
             
        if(isInstanceOfPsetWarranty(propertySet))
        {
            this.setName(PROPERTY_SET_NAME);
            initializeProperties(propertySet);
        }
        else
            throw new UnsupportedOperationException("propertySet is not an instanceof Pset_Warranty");
       
    }

    private boolean isInstanceOfPsetWarranty(IfcPropertySet propertySet)
    {
        boolean nameMatches = propertySet.getName().equalsIgnoreCase(PROPERTY_SET_NAME);
        boolean noUnsupportedFields = hasUnsupportedFields(propertySet);
        return nameMatches && noUnsupportedFields;
    }

    private boolean hasUnsupportedFields(IfcPropertySet propertySet)
    {
        boolean allFieldsSupported = true;
        for(IfcProperty property : propertySet.getHasProperties())
        {
            try
            {
                 Pset_Warranty_Field.nonCaseSensitiveValueOf(property.getName());
            }
            catch(Exception ex)
            {
                allFieldsSupported = false;
            }
        }
        return allFieldsSupported;
    }

    private void initializeProperties(IfcPropertySet propertySet)
    {
        HashMap<String, IfcProperty> indexedProperties = indexPropertySetByName(propertySet);       
        for(Pset_Warranty_Field psetWarrantyField : Pset_Warranty_Field.values())
        {
            try
            {
                handleField(psetWarrantyField, indexedProperties);
            }
            catch(Exception ex)
            {
                
            }
        }
    }

    private void handleField(Pset_Warranty_Field psetWarrantyField, HashMap<String, IfcProperty> indexedProperties)
    {
        IfcProperty property = indexedProperties.get(psetWarrantyField.name());
        switch(psetWarrantyField)
        {
            case Exclusions:
                this.Exclusions = (IfcPropertySingleValue)property;
                break;
            case IsExtendedWarranty:
                this.IsExtendedWarranty = (IfcPropertySingleValue)property;
                break;
            case PointOfContact:
                this.PointOfContact = (IfcPropertyReferenceValue)property;
                break;
            case WarrantyContent:
                this.WarrantyContent = (IfcPropertySingleValue)property;
                break;
            case WarrantyEndDate:
                this.WarrantyEndDate = (IfcPropertyReferenceValue) property;
                break;
            case WarrantyIdentifier:
                this.WarrantyIdentifier = (IfcPropertySingleValue)property;
                break;
            case WarrantyPeriod:
                this.WarrantyPeriod = (IfcPropertySingleValue)property;
                break;
            case WarrantyStartDate:
                this.WarrantyStartDate = (IfcPropertyReferenceValue)property;
                break;
            default:
                break;           
        }
    }

    private HashMap<String, IfcProperty>  indexPropertySetByName(IfcPropertySet propertySet)
    {
        NonCaseSensitiveHashMap<IfcProperty> propertyNameProperty = new NonCaseSensitiveHashMap<IfcProperty>();
        for(IfcProperty property : propertySet.getHasProperties())
        {
            propertyNameProperty.put(property.getName(), property);
        }
        return propertyNameProperty;
    }

}
