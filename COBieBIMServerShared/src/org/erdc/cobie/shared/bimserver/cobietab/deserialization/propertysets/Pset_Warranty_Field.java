package org.erdc.cobie.shared.bimserver.cobietab.deserialization.propertysets;

public enum Pset_Warranty_Field
{
    /*
     * WarrantyIdentifier   IfcPropertySingleValue  IfcIdentifier   The identifier assigned to a warranty.
WarrantyStartDate   IfcPropertyReferenceValue   IfcCalendarDate The date on which the warranty commences
WarrantyEndDate IfcPropertyReferenceValue   IfcCalendarDate The date on which the warranty expires.
IsExtendedWarranty  IfcPropertySingleValue  IfcBoolean  Indication of whether this is an extended warranty whose duration is greater than that normally assigned to an artefact (=TRUE) or not (= FALSE)
WarrantyPeriod  IfcPropertySingleValue  IfcTimeMeasure / TIMEUNIT   The time duration during which a manufacturer or supplier guarantees or warrants the performance of an artefact.
PointOfContact  IfcPropertyReferenceValue   IfcOrganization The organization that should be contacted for action under the terms of the warranty. Note that the role of the organization (manufacturer, supplier, installer etc.) is determined by the IfcActorRole attribute of IfcOrganization.
WarrantyContent IfcPropertySingleValue  IfcText The content of the warranty
Exclusions  IfcPropertySingleValue  IfcText Items, conditions or actions that may be excluded from the warranty or that may cause the warranty to become void.
     */
    WarrantyIdentifier("WarrantyIdentifier", "The identifier assigned to a warranty.", "IfcPropertySingleValue", "IfcIdentifier"), 
    WarrantyStartDate("WarrantyStartDate","The date on which the warranty commences","IfcPropertyReferenceValue","IfcCalendarDate"),  
    WarrantyEndDate("WarrantyEndDate","IfcCalendarDate The date on which the warranty expires.","IfcPropertyReferenceValue","IfcCalendarDate"), 
    IsExtendedWarranty("IsExtendedWarranty",
            "Indication of whether this is an extended warranty whose duration is greater than that normally assigned to an artefact (=TRUE) or not (= FALSE)","IfcPropertySingleValue","IfcBoolean"),
    WarrantyPeriod("WarrantyPeriod","The time duration during which a manufacturer or supplier guarantees or warrants the performance of an artefact.","IfcPropertySingleValue","IfcTimeMeasure"),  
    PointOfContact("PointOfContact","The organization that should be contacted for action under the terms of the warranty. Note that the role of the organization (manufacturer, supplier, installer etc.) is determined by the IfcActorRole attribute of IfcOrganization.","IfcPropertyReferenceValue","IfcOrganization"), 
    WarrantyContent("WarrantyContent","The content of the warranty","IfcPropertySingleValue","IfcText"), 
    Exclusions("Exclusions",
            "conditions or actions that may be excluded from the warranty or that may cause the warranty to become void.",
            "IfcPropertySingleValue","IfcText");
    
    private String description;
    private String name;
    private String propertyType;
    private String dataType;
    
    private Pset_Warranty_Field(String name, String description, String propertyType, String dataType)
    {
        this.name = name;
        this.description = description;
        this.propertyType = propertyType;
        this.dataType = dataType;
    }

    public String getName()
    {
        return name;
    }

    public String getPropertyType()
    {
        return propertyType;
    }

    public String getDataType()
    {
        return dataType;
    }

    public String getDescription()
    {
        return description;
    }

    public static Pset_Warranty_Field nonCaseSensitiveValueOf(String name) throws IllegalArgumentException, NullPointerException
    {
        Pset_Warranty_Field warrantyField = null;
        if(name!=null)
        {
            for(Pset_Warranty_Field field : Pset_Warranty_Field.values())
            {
                if(field.getName().equalsIgnoreCase(name))
                    warrantyField = field;
            }
            if(warrantyField == null)
                throw new IllegalArgumentException("Unsupported field name");
        }
        else
            throw new NullPointerException("name cannot be null");     
        return warrantyField;
    }
    
}
