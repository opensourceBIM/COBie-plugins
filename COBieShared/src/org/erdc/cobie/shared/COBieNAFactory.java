package org.erdc.cobie.shared;

import org.apache.xmlbeans.XmlObject;
import org.erdc.cobie.shared.COBieUtility.CobieSheetName;
import org.erdc.cobie.sheetxmldata.AssemblyType;
import org.erdc.cobie.sheetxmldata.AttributeType;
import org.erdc.cobie.sheetxmldata.COBIEType;
import org.erdc.cobie.sheetxmldata.ComponentType;
import org.erdc.cobie.sheetxmldata.ConnectionType;
import org.erdc.cobie.sheetxmldata.ContactType;
import org.erdc.cobie.sheetxmldata.CoordinateType;
import org.erdc.cobie.sheetxmldata.DocumentType;
import org.erdc.cobie.sheetxmldata.FacilityType;
import org.erdc.cobie.sheetxmldata.FloorType;
import org.erdc.cobie.sheetxmldata.ImpactType;
import org.erdc.cobie.sheetxmldata.IssueType;
import org.erdc.cobie.sheetxmldata.JobType;
import org.erdc.cobie.sheetxmldata.ResourceType;
import org.erdc.cobie.sheetxmldata.SpaceType;
import org.erdc.cobie.sheetxmldata.SpareType;
import org.erdc.cobie.sheetxmldata.SystemType;
import org.erdc.cobie.sheetxmldata.TypeType;
import org.erdc.cobie.sheetxmldata.ZoneType;

public class COBieNAFactory
{
    private static XmlObject getEmptyXmlObjectFromSheetName(XmlObject pluralCobieObject, CobieSheetName sheetName)
    {
        XmlObject newObject = null;
        switch (sheetName)
        {
            case Assembly:
                newObject = ((COBIEType.Assemblies)pluralCobieObject).addNewAssembly();
                break;
            case Attribute:
                newObject = ((COBIEType.Attributes)pluralCobieObject).addNewAttribute();
                break;
            case Component:
                newObject = ((COBIEType.Components)pluralCobieObject).addNewComponent();
                break;
            case Connection:
                newObject = ((COBIEType.Connections)pluralCobieObject).addNewConnection();
                break;
            case Contact:
                newObject = ((COBIEType.Contacts)pluralCobieObject).addNewContact();
                break;
            case Coordinate:
                newObject = ((COBIEType.Coordinates)pluralCobieObject).addNewCoordinate();
                break;
            case Document:
                newObject = ((COBIEType.Documents)pluralCobieObject).addNewDocument();
                break;
            case Facility:
                newObject = ((COBIEType.Facilities)pluralCobieObject).addNewFacility();
                break;
            case Floor:
                newObject = ((COBIEType.Floors)pluralCobieObject).addNewFloor();
                break;
            case Impact:
                newObject = ((COBIEType.Impacts)pluralCobieObject).addNewImpact();
                break;
            case Issue:
                newObject = ((COBIEType.Issues)pluralCobieObject).addNewIssue();
                break;
            case Job:
                newObject = ((COBIEType.Jobs)pluralCobieObject).addNewJob();
                break;
            case Resource:
                newObject = ((COBIEType.Resources)pluralCobieObject).addNewResource();
                break;
            case Space:
                newObject = ((COBIEType.Spaces)pluralCobieObject).addNewSpace();
                break;
            case Spare:
                newObject = ((COBIEType.Spares)pluralCobieObject).addNewSpare();
                break;
            case System:
                newObject = ((COBIEType.Systems)pluralCobieObject).addNewSystem();
                break;
            case Type:
                newObject = ((COBIEType.Types)pluralCobieObject).addNewType();
                break;
            case Zone:
                newObject = ((COBIEType.Zones)pluralCobieObject).addNewZone();
                break;
        }
        return newObject;
    }

    public static XmlObject initializeCOBieElementToNA(XmlObject pluralCobieObject) throws Exception
    {
        String nodeName = pluralCobieObject.getDomNode().getNodeName();
        CobieSheetName sheetName = COBieUtility.CobiePluralNameToCobieSheetName.get(nodeName);
        XmlObject newObject = null;
        if (sheetName != null)
        {
            newObject = getEmptyXmlObjectFromSheetName(pluralCobieObject, sheetName);
            setXmlObjectToNA(newObject);
        }
        return newObject;
    }

    public static void setAssemblyNA(AssemblyType assembly)
    {

        assembly.setName(COBieUtility.COBieNA);
        assembly.setCreatedBy(COBieUtility.COBieNA);
        assembly.setCreatedOn(COBieUtility.getDefaultCalendar());
        assembly.setSheetName(COBieUtility.COBieNA);
        assembly.setParentName(COBieUtility.COBieNA);
        assembly.setChildNames(COBieUtility.COBieNA);
        assembly.setAssemblyType(COBieUtility.COBieNA);
        assembly.setExtSystem(COBieUtility.COBieNA);
        assembly.setExtObject(COBieUtility.COBieNA);
        assembly.setExtIdentifier(COBieUtility.COBieNA);
        assembly.setDescription(COBieUtility.COBieNA);
    }

    public static void setAttributeNA(AttributeType attribute)
    {

        attribute.setName(COBieUtility.COBieNA);
        attribute.setCreatedBy(COBieUtility.COBieNA);
        attribute.setCreatedOn(COBieUtility.getDefaultCalendar());
        attribute.setCategory(COBieUtility.COBieNA);
        attribute.setSheetName(COBieUtility.COBieNA);
        attribute.setRowName(COBieUtility.COBieNA);
        attribute.setValue(COBieUtility.COBieNA);
        attribute.setUnit(COBieUtility.COBieNA);
        attribute.setExtSystem(COBieUtility.COBieNA);
        attribute.setExtObject(COBieUtility.COBieNA);
        attribute.setExtIdentifier(COBieUtility.COBieNA);
        attribute.setDescription(COBieUtility.COBieNA);
        attribute.setAllowedValues(COBieUtility.COBieNA);
    }

    public static void setComponentNA(ComponentType component)
    {

        component.setName(COBieUtility.COBieNA);
        component.setCreatedBy(COBieUtility.COBieNA);
        component.setCreatedOn(COBieUtility.getDefaultCalendar());
        component.setTypeName(COBieUtility.COBieNA);
        component.setSpace(COBieUtility.COBieNA);
        component.setDescription(COBieUtility.COBieNA);
        component.setExtSystem(COBieUtility.COBieNA);
        component.setExtObject(COBieUtility.COBieNA);
        component.setExtIdentifier(COBieUtility.COBieNA);
        component.setSerialNumber(COBieUtility.COBieNA);
        component.setInstallationDate(COBieUtility.COBieNA);
        component.setWarrantyStartDate(COBieUtility.COBieNA);
        component.setTagNumber(COBieUtility.COBieNA);
        component.setBarCode(COBieUtility.COBieNA);
        component.setAssetIdentifier(COBieUtility.COBieNA);
    }

    public static void setConnectionNA(ConnectionType connection)
    {

        connection.setName(COBieUtility.COBieNA);
        connection.setCreatedBy(COBieUtility.COBieNA);
        connection.setCreatedOn(COBieUtility.getDefaultCalendar());
        connection.setConnectionType(COBieUtility.COBieNA);
        connection.setSheetName(COBieUtility.COBieNA);
        connection.setRowName1(COBieUtility.COBieNA);
        connection.setRowName2(COBieUtility.COBieNA);
        connection.setRealizingElement(COBieUtility.COBieNA);
        connection.setPortName1(COBieUtility.COBieNA);
        connection.setPortName2(COBieUtility.COBieNA);
        connection.setExtSystem(COBieUtility.COBieNA);
        connection.setExtObject(COBieUtility.COBieNA);
        connection.setExtIdentifier(COBieUtility.COBieNA);
        connection.setDescription(COBieUtility.COBieNA);
    }

    public static void setContactNA(ContactType contact)
    {
        contact.setEmail(COBieUtility.COBieNA);
        contact.setCreatedBy(COBieUtility.COBieNA);
        contact.setCreatedOn(COBieUtility.getDefaultCalendar());
        contact.setCategory(COBieUtility.COBieNA);
        contact.setCompany(COBieUtility.COBieNA);
        contact.setPhone(COBieUtility.COBieNA);
        contact.setExternalSystem(COBieUtility.COBieNA);
        contact.setExternalObject(COBieUtility.COBieNA);
        contact.setExternalIdentifier(COBieUtility.COBieNA);
        contact.setDepartment(COBieUtility.COBieNA);
        contact.setOrganizationCode(COBieUtility.COBieNA);
        contact.setGivenName(COBieUtility.COBieNA);
        contact.setFamilyName(COBieUtility.COBieNA);
        contact.setStreet(COBieUtility.COBieNA);
        contact.setPostalBox(COBieUtility.COBieNA);
        contact.setTown(COBieUtility.COBieNA);
        contact.setStateRegion(COBieUtility.COBieNA);
        contact.setPostalCode(COBieUtility.COBieNA);
        contact.setCountry(COBieUtility.COBieNA);
    }

    public static void setCoordinateNA(CoordinateType coordinate)
    {

        coordinate.setName(COBieUtility.COBieNA);
        coordinate.setCreatedBy(COBieUtility.COBieNA);
        coordinate.setCreatedOn(COBieUtility.getDefaultCalendar());
        coordinate.setCategory(COBieUtility.COBieNA);
        coordinate.setSheetName(COBieUtility.COBieNA);
        coordinate.setRowName(COBieUtility.COBieNA);
        coordinate.setCoordinateXAxis(COBieUtility.COBieNA);
        coordinate.setCoordinateYAxis(COBieUtility.COBieNA);
        coordinate.setCoordinateZAxis(COBieUtility.COBieNA);
        coordinate.setExtSystem(COBieUtility.COBieNA);
        coordinate.setExtObject(COBieUtility.COBieNA);
        coordinate.setExtIdentifier(COBieUtility.COBieNA);
        coordinate.setClockwiseRotation(COBieUtility.COBieNA);
        coordinate.setElevationalRotation(COBieUtility.COBieNA);
        coordinate.setYawRotation(COBieUtility.COBieNA);
    }

    public static void setDocumentNA(DocumentType document)
    {

        document.setName(COBieUtility.COBieNA);
        document.setCreatedBy(COBieUtility.COBieNA);
        document.setCreatedOn(COBieUtility.getDefaultCalendar());
        document.setCategory(COBieUtility.COBieNA);
        document.setApprovalBy(COBieUtility.COBieNA);
        document.setStage(COBieUtility.COBieNA);
        document.setSheetName(COBieUtility.COBieNA);
        document.setRowName(COBieUtility.COBieNA);
        document.setDirectory(COBieUtility.COBieNA);
        document.setFile(COBieUtility.COBieNA);
        document.setExtSystem(COBieUtility.COBieNA);
        document.setExtObject(COBieUtility.COBieNA);
        document.setExtIdentifier(COBieUtility.COBieNA);
        document.setDescription(COBieUtility.COBieNA);
        document.setReference(COBieUtility.COBieNA);
    }

    public static void setFacilityNA(FacilityType facility)
    {

        facility.setName(COBieUtility.COBieNA);
        facility.setCreatedBy(COBieUtility.COBieNA);
        facility.setCreatedOn(COBieUtility.getDefaultCalendar());
        facility.setCategory(COBieUtility.COBieNA);
        facility.setProjectName(COBieUtility.COBieNA);
        facility.setSiteName(COBieUtility.COBieNA);
        facility.setLinearUnits(COBieUtility.COBieNA);
        facility.setAreaUnits(COBieUtility.COBieNA);
        facility.setVolumeUnits(COBieUtility.COBieNA);
        facility.setCurrencyUnit(COBieUtility.COBieNA);
        facility.setAreaMeasurement(COBieUtility.COBieNA);
        facility.setExternalSystem(COBieUtility.COBieNA);
        facility.setExternalProjectObject(COBieUtility.COBieNA);
        facility.setExternalProjectIdentifier(COBieUtility.COBieNA);
        facility.setExternalSiteObject(COBieUtility.COBieNA);
        facility.setExternalSiteIdentifier(COBieUtility.COBieNA);
        facility.setExternalFacilityObject(COBieUtility.COBieNA);
        facility.setExternalFacilityIdentifier(COBieUtility.COBieNA);
        facility.setDescription(COBieUtility.COBieNA);
        facility.setProjectDescription(COBieUtility.COBieNA);
        facility.setSiteDescription(COBieUtility.COBieNA);
        facility.setPhase(COBieUtility.COBieNA);
    }

    public static void setFloorNA(FloorType floor)
    {

        floor.setName(COBieUtility.COBieNA);
        floor.setCreatedBy(COBieUtility.COBieNA);
        floor.setCreatedOn(COBieUtility.getDefaultCalendar());
        floor.setCategory(COBieUtility.COBieNA);
        floor.setExtSystem(COBieUtility.COBieNA);
        floor.setExtObject(COBieUtility.COBieNA);
        floor.setExtIdentifier(COBieUtility.COBieNA);
        floor.setDescription(COBieUtility.COBieNA);
        floor.setElevation(COBieUtility.COBieNA);
        floor.setHeight(COBieUtility.COBieNA);

    }

    public static void setImpactNA(ImpactType impact)
    {

        impact.setName(COBieUtility.COBieNA);
        impact.setCreatedBy(COBieUtility.COBieNA);
        impact.setCreatedOn(COBieUtility.getDefaultCalendar());
        impact.setImpactType(COBieUtility.COBieNA);
        impact.setImpactStage(COBieUtility.COBieNA);
        impact.setSheetName(COBieUtility.COBieNA);
        impact.setRowName(COBieUtility.COBieNA);
        impact.setValue(COBieUtility.COBieNA);
        impact.setImpactUnit(COBieUtility.COBieNA);
        impact.setLeadInTime(COBieUtility.COBieNA);
        impact.setDuration(COBieUtility.COBieNA);
        impact.setLeadOutTime(COBieUtility.COBieNA);
        impact.setExtSystem(COBieUtility.COBieNA);
        impact.setExtObject(COBieUtility.COBieNA);
        impact.setExtIdentifier(COBieUtility.COBieNA);
        impact.setDescription(COBieUtility.COBieNA);
    }

    public static void setIssueNA(IssueType issue)
    {

        issue.setName(COBieUtility.COBieNA);
        issue.setCreatedBy(COBieUtility.COBieNA);
        issue.setCreatedOn(COBieUtility.getDefaultCalendar());
        issue.setType(COBieUtility.COBieNA);
        issue.setRisk(COBieUtility.COBieNA);
        issue.setChance(COBieUtility.COBieNA);
        issue.setImpact(COBieUtility.COBieNA);
        issue.setSheetName1(COBieUtility.COBieNA);
        issue.setRowName1(COBieUtility.COBieNA);
        issue.setSheetName2(COBieUtility.COBieNA);
        issue.setRowName2(COBieUtility.COBieNA);
        issue.setDescription(COBieUtility.COBieNA);
        issue.setOwner(COBieUtility.COBieNA);
        issue.setMitigation(COBieUtility.COBieNA);
        issue.setExtSystem(COBieUtility.COBieNA);
        issue.setExtObject(COBieUtility.COBieNA);
        issue.setExtIdentifier(COBieUtility.COBieNA);
    }

    public static void setJobNA(JobType job)
    {

        job.setName(COBieUtility.COBieNA);
        job.setCreatedBy(COBieUtility.COBieNA);
        job.setCreatedOn(COBieUtility.getDefaultCalendar());
        job.setCategory(COBieUtility.COBieNA);
        job.setStatus(COBieUtility.COBieNA);
        job.setTypeName(COBieUtility.COBieNA);
        job.setDescription(COBieUtility.COBieNA);
        job.setDuration(COBieUtility.COBieNA);
        job.setDurationUnit(COBieUtility.COBieNA);
        job.setStart(COBieUtility.COBieNA);
        job.setTaskStartUnit(COBieUtility.COBieNA);
        job.setFrequency(COBieUtility.COBieNA);
        job.setFrequencyUnit(COBieUtility.COBieNA);
        job.setExtSystem(COBieUtility.COBieNA);
        job.setExtObject(COBieUtility.COBieNA);
        job.setExtIdentifier(COBieUtility.COBieNA);
        job.setTaskNumber(COBieUtility.COBieNA);
        job.setPriors(COBieUtility.COBieNA);
        job.setResourceNames(COBieUtility.COBieNA);
    }

    public static void setResourceNA(ResourceType resource)
    {

        resource.setName(COBieUtility.COBieNA);
        resource.setCreatedBy(COBieUtility.COBieNA);
        resource.setCreatedOn(COBieUtility.getDefaultCalendar());
        resource.setCategory(COBieUtility.COBieNA);
        resource.setExtSystem(COBieUtility.COBieNA);
        resource.setExtObject(COBieUtility.COBieNA);
        resource.setExtIdentifier(COBieUtility.COBieNA);
        resource.setDescription(COBieUtility.COBieNA);
    }

    public static void setSpaceNA(SpaceType space)
    {

        space.setName(COBieUtility.COBieNA);
        space.setCreatedBy(COBieUtility.COBieNA);
        space.setCreatedOn(COBieUtility.getDefaultCalendar());
        space.setCategory(COBieUtility.COBieNA);
        space.setFloorName(COBieUtility.COBieNA);
        space.setDescription(COBieUtility.COBieNA);
        space.setExtSystem(COBieUtility.COBieNA);
        space.setExtObject(COBieUtility.COBieNA);
        space.setExtIdentifier(COBieUtility.COBieNA);
        space.setRoomTag(COBieUtility.COBieNA);
        space.setUsableHeight(COBieUtility.COBieNA);
        space.setGrossArea(COBieUtility.COBieNA);
        space.setNetArea(COBieUtility.COBieNA);
    }

    public static void setSpareNA(SpareType spare)
    {

        spare.setName(COBieUtility.COBieNA);
        spare.setCreatedBy(COBieUtility.COBieNA);
        spare.setCreatedOn(COBieUtility.getDefaultCalendar());
        spare.setCategory(COBieUtility.COBieNA);
        spare.setTypeName(COBieUtility.COBieNA);
        spare.setSuppliers(COBieUtility.COBieNA);
        spare.setExtSystem(COBieUtility.COBieNA);
        spare.setExtObject(COBieUtility.COBieNA);
        spare.setExtIdentifier(COBieUtility.COBieNA);
        spare.setDescription(COBieUtility.COBieNA);
        spare.setSetNumber(COBieUtility.COBieNA);
        spare.setPartNumber(COBieUtility.COBieNA);
    }

    public static void setSystemNA(SystemType system)
    {

        system.setName(COBieUtility.COBieNA);
        system.setCreatedBy(COBieUtility.COBieNA);
        system.setCreatedOn(COBieUtility.getDefaultCalendar());
        system.setCategory(COBieUtility.COBieNA);
        system.setComponentNames(COBieUtility.COBieNA);
        system.setExtSystem(COBieUtility.COBieNA);
        system.setExtObject(COBieUtility.COBieNA);
        system.setExtIdentifier(COBieUtility.COBieNA);
        system.setDescription(COBieUtility.COBieNA);
    }

    public static void setTypeNA(TypeType type)
    {

        type.setName(COBieUtility.COBieNA);
        type.setCreatedBy(COBieUtility.COBieNA);
        type.setCreatedOn(COBieUtility.getDefaultCalendar());
        type.setCategory(COBieUtility.COBieNA);
        type.setDescription(COBieUtility.COBieNA);
        type.setAssetType(COBieUtility.COBieNA);
        type.setManufacturer(COBieUtility.COBieNA);
        type.setModelNumber(COBieUtility.COBieNA);
        type.setWarrantyGuarantorParts(COBieUtility.COBieNA);
        type.setWarrantyDurationParts(COBieUtility.COBieNA);
        type.setWarrantyGuarantorLabor(COBieUtility.COBieNA);
        type.setWarrantyDurationLabor(COBieUtility.COBieNA);
        type.setWarrantyDurationUnit(COBieUtility.COBieNA);
        type.setExtSystem(COBieUtility.COBieNA);
        type.setExtObject(COBieUtility.COBieNA);
        type.setExtIdentifier(COBieUtility.COBieNA);
        type.setReplacementCost(COBieUtility.COBieNA);
        type.setExpectedLife(COBieUtility.COBieNA);
        type.setDurationUnit(COBieUtility.COBieNA);
        type.setWarrantyDescription(COBieUtility.COBieNA);
        type.setNominalLength(COBieUtility.COBieNA);
        type.setNominalWidth(COBieUtility.COBieNA);
        type.setNominalHeight(COBieUtility.COBieNA);
        type.setModelReference(COBieUtility.COBieNA);
        type.setShape(COBieUtility.COBieNA);
        type.setSize(COBieUtility.COBieNA);
        type.setColor(COBieUtility.COBieNA);
        type.setFinish(COBieUtility.COBieNA);
        type.setGrade(COBieUtility.COBieNA);
        type.setMaterial(COBieUtility.COBieNA);
        type.setConstituents(COBieUtility.COBieNA);
        type.setFeatures(COBieUtility.COBieNA);
        type.setAccessibilityPerformance(COBieUtility.COBieNA);
        type.setCodePerformance(COBieUtility.COBieNA);
        type.setSustainabilityPerformance(COBieUtility.COBieNA);
    }

    public static void setXmlObjectToNA(XmlObject xmlObject)
    {
        if (xmlObject instanceof AssemblyType)
        {
            setAssemblyNA((AssemblyType)xmlObject);
        } else if (xmlObject instanceof AttributeType)
        {
            setAttributeNA((AttributeType)xmlObject);
        } else if (xmlObject instanceof ComponentType)
        {
            setComponentNA((ComponentType)xmlObject);
        } else if (xmlObject instanceof ConnectionType)
        {
            setConnectionNA((ConnectionType)xmlObject);
        } else if (xmlObject instanceof ContactType)
        {
            setContactNA((ContactType)xmlObject);
        } else if (xmlObject instanceof CoordinateType)
        {
            setCoordinateNA((CoordinateType)xmlObject);
        } else if (xmlObject instanceof DocumentType)
        {
            setDocumentNA((DocumentType)xmlObject);
        } else if (xmlObject instanceof FacilityType)
        {
            setFacilityNA((FacilityType)xmlObject);
        } else if (xmlObject instanceof FloorType)
        {
            setFloorNA((FloorType)xmlObject);
        } else if (xmlObject instanceof ImpactType)
        {
            setImpactNA((ImpactType)xmlObject);
        } else if (xmlObject instanceof IssueType)
        {
            setIssueNA((IssueType)xmlObject);
        } else if (xmlObject instanceof JobType)
        {
            setJobNA((JobType)xmlObject);
        } else if (xmlObject instanceof ResourceType)
        {
            setResourceNA((ResourceType)xmlObject);
        } else if (xmlObject instanceof SpaceType)
        {
            setSpaceNA((SpaceType)xmlObject);
        } else if (xmlObject instanceof SpareType)
        {
            setSpareNA((SpareType)xmlObject);
        } else if (xmlObject instanceof SystemType)
        {
            setSystemNA((SystemType)xmlObject);
        } else if (xmlObject instanceof TypeType)
        {
            setTypeNA((TypeType)xmlObject);
        } else if (xmlObject instanceof ZoneType)
        {
            setZoneNA((ZoneType)xmlObject);
        }
    }

    public static void setZoneNA(ZoneType zone)
    {

        zone.setName(COBieUtility.COBieNA);
        zone.setCreatedBy(COBieUtility.COBieNA);
        zone.setCreatedOn(COBieUtility.getDefaultCalendar());
        zone.setCategory(COBieUtility.COBieNA);
        zone.setSpaceNames(COBieUtility.COBieNA);
        zone.setExtSystem(COBieUtility.COBieNA);
        zone.setExtObject(COBieUtility.COBieNA);
        zone.setExtIdentifier(COBieUtility.COBieNA);
        zone.setDescription(COBieUtility.COBieNA);
    }

}
