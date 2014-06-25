package org.erdc.cobie.cobielite.parsers.sheetxmldata;


import org.buildingsmartalliance.docs.nbims03.cobie.core.AttributeCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.DocumentCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.IssueCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.ZoneAssignmentCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.ZoneKeyType;
import org.erdc.cobie.cobielite.ValueHelper;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.shared.cobiesheetxmldata.indices.IndexedCOBie;
import org.erdc.cobie.shared.cobiesheetxmldata.indices.SpaceZonesIndex;
import org.erdc.cobie.sheetxmldata.SpaceType;
import org.erdc.cobie.sheetxmldata.ZoneType;

public class SpaceParser extends TypicalParser<SpaceType, org.buildingsmartalliance.docs.nbims03.cobie.cobielite.SpaceType>
{
    public SpaceParser(SpaceType cobieSheetXMLData, org.buildingsmartalliance.docs.nbims03.cobie.cobielite.SpaceType cobieLiteRowData, IndexedCOBie indexedCOBie)
    {
        super(cobieSheetXMLData, cobieLiteRowData, indexedCOBie);
    }

    private void assignGrossArea()
    {
        String grossArea = sourceCOBie.getGrossArea();
        if(!COBieUtility.isNA(grossArea))
        	ValueHelper.assign(grossArea, targetCOBie.addNewSpaceGrossAreaValue());
    }

    private void assignNetArea()
    {
        String netArea = sourceCOBie.getNetArea();
        if(!COBieUtility.isNA(netArea))
        	ValueHelper.assign(netArea, targetCOBie.addNewSpaceNetAreaValue());
    }

    private void assignSpacePerimeter()
    {
        // TODO Derive Space Perimeter

    }

    private void assignUsableHeight()
    {
        String sheetUsableHeight = sourceCOBie.getUsableHeight();
        if(!COBieUtility.isNA(sheetUsableHeight))
        	ValueHelper.assign(sheetUsableHeight, targetCOBie.addNewSpaceUsableHeightValue());
    }

    private void assignZones()
    {
        String spaceName = sourceCOBie.getName();
        SpaceZonesIndex spaceZonesIndex = indexedCOBie.getSpaceZones();
        if (spaceZonesIndex.containsKey(spaceName))
        {
            ZoneAssignmentCollectionType zoneAssignments = targetCOBie.addNewSpaceZoneAssignments();
            ;
            for (ZoneType zone : spaceZonesIndex.get(spaceName))
            {
                ZoneKeyType zoneAssignment = zoneAssignments.addNewZoneAssignment();
                zoneAssignment.setZoneName(zone.getName());
                zoneAssignment.setZoneCategory(zone.getCategory());
            }
        }

    }

    @Override
    public AttributeCollectionType getNewAttributes()
    {
        return targetCOBie.addNewSpaceAttributes();
    }

    @Override
    public DocumentCollectionType getNewDocuments()
    {
        return targetCOBie.addNewSpaceDocuments();
    }

    @Override
    public IssueCollectionType getNewIssues()
    {
        return targetCOBie.addNewSpaceIssues();
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
    	if(!COBieUtility.isNA(sourceCOBie.getExtObject()))
    		targetCOBie.setExternalEntityName(sourceCOBie.getExtObject());
    	if(!COBieUtility.isNA(sourceCOBie.getExtIdentifier()))
    		targetCOBie.setExternalID(sourceCOBie.getExtIdentifier());
    	if(!COBieUtility.isNA(sourceCOBie.getExtSystem()))
    		targetCOBie.setExternalSystemName(sourceCOBie.getExtSystem());
    	if(!COBieUtility.isNA(sourceCOBie.getCategory()))
    		targetCOBie.setSpaceCategory(sourceCOBie.getCategory());
    	if(!COBieUtility.isNA(sourceCOBie.getDescription()))
    		targetCOBie.setSpaceDescription(sourceCOBie.getDescription());
    	if(!COBieUtility.isNA(sourceCOBie.getName()))
    		targetCOBie.setSpaceName(sourceCOBie.getName());
    	if(!COBieUtility.isNA(sourceCOBie.getRoomTag()))
    		targetCOBie.setSpaceSignageName(sourceCOBie.getRoomTag());
    }

}
