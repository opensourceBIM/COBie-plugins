package org.erdc.cobie.cobielite.parsers.sheetxmldata;

import org.erdc.cobie.cobielite.AttributeCollectionType;
import org.erdc.cobie.cobielite.DocumentCollectionType;
import org.erdc.cobie.cobielite.IssueCollectionType;
import org.erdc.cobie.cobielite.ValueHelper;
import org.erdc.cobie.cobielite.ZoneAssignmentCollectionType;
import org.erdc.cobie.cobielite.ZoneKeyType;
import org.erdc.cobie.shared.cobiesheetxmldata.indices.IndexedCOBie;
import org.erdc.cobie.shared.cobiesheetxmldata.indices.SpaceZonesIndex;
import org.erdc.cobie.sheetxmldata.SpaceType;
import org.erdc.cobie.sheetxmldata.ZoneType;

public class SpaceParser extends TypicalParser<SpaceType, org.erdc.cobie.cobielite.SpaceType>
{
    public SpaceParser(SpaceType cobieSheetXMLData, org.erdc.cobie.cobielite.SpaceType cobieLiteRowData, IndexedCOBie indexedCOBie)
    {
        super(cobieSheetXMLData, cobieLiteRowData, indexedCOBie);
    }

    private void assignGrossArea()
    {
        String grossArea = sourceCOBie.getGrossArea();
        ValueHelper.assign(grossArea, targetCOBie.addNewSpaceGrossAreaValue());

    }

    private void assignNetArea()
    {
        String netArea = sourceCOBie.getNetArea();
        ValueHelper.assign(netArea, targetCOBie.addNewSpaceNetAreaValue());
    }

    private void assignSpacePerimeter()
    {
        // TODO Derive Space Perimeter

    }

    private void assignUsableHeight()
    {
        String sheetUsableHeight = sourceCOBie.getUsableHeight();
        ValueHelper.assign(sheetUsableHeight, targetCOBie.addNewSpaceUsableHeightValue());
    }

    private void assignZones()
    {
        String spaceName = sourceCOBie.getName();
        SpaceZonesIndex spaceZonesIndex = indexedCOBie.getSpaceZones();
        if (spaceZonesIndex.containsKey(spaceName))
        {
            ZoneAssignmentCollectionType zoneAssignments = targetCOBie.addNewZoneAssignments();
            ;
            for (ZoneType zone : spaceZonesIndex.get(spaceName))
            {
                ZoneKeyType zoneAssignment = zoneAssignments.addNewZoneAssignment();
                zoneAssignment.setZoneName(zone.getName());
            }
        }

    }

    @Override
    public AttributeCollectionType getNewAttributes()
    {
        return targetCOBie.addNewAttributes();
    }

    @Override
    public DocumentCollectionType getNewDocuments()
    {
        return targetCOBie.addNewDocuments();
    }

    @Override
    public IssueCollectionType getNewIssues()
    {
        return targetCOBie.addNewIssues();
    }

    @Override
    protected void parseComplexElements()
    {
        // TODO: Handle exceptions
        try
        {
            assignGrossArea();
        } catch (Exception ex)
        {

        }
        try
        {
            assignNetArea();
        } catch (Exception ex)
        {

        }
        try
        {
            assignUsableHeight();
        } catch (Exception ex)
        {

        }
        try
        {
            assignZones();
        } catch (Exception ex)
        {

        }
        try
        {
            assignSpacePerimeter();
        } catch (Exception ex)
        {

        }
    }

    @Override
    protected void parseSimpleElements()
    {
        targetCOBie.setExternalEntityName(sourceCOBie.getExtObject());
        targetCOBie.setExternalID(sourceCOBie.getExtIdentifier());
        targetCOBie.setExternalSystemName(sourceCOBie.getExtSystem());
        targetCOBie.setSpaceCategory(sourceCOBie.getCategory());
        targetCOBie.setSpaceDescription(sourceCOBie.getDescription());
        targetCOBie.setSpaceName(sourceCOBie.getName());
        targetCOBie.setSpaceSignageName(sourceCOBie.getRoomTag());
    }

}
