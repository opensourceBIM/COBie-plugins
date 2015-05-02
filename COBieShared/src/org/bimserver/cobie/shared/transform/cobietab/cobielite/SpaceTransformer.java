package org.bimserver.cobie.shared.transform.cobietab.cobielite;


import org.bimserver.cobie.shared.cobietab.IndexedCOBie;
import org.bimserver.cobie.shared.cobietab.SpaceZonesIndex;
import org.bimserver.cobie.shared.utility.COBieUtility;
import org.buildingsmartalliance.docs.nbims03.cobie.core.AttributeCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.DocumentCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.IssueCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.ZoneAssignmentCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.ZoneKeyType;
import org.nibs.cobie.tab.SpaceType;
import org.nibs.cobie.tab.ZoneType;

public class SpaceTransformer extends ChildTransformer<SpaceType, org.buildingsmartalliance.docs.nbims03.cobie.cobielite.SpaceType>
{
    public SpaceTransformer(SpaceType cobieSheetXMLData, org.buildingsmartalliance.docs.nbims03.cobie.cobielite.SpaceType cobieLiteRowData, IndexedCOBie indexedCOBie)
    {
        super(cobieSheetXMLData, cobieLiteRowData, indexedCOBie);
    }

    private void assignGrossArea()
    {
        String grossArea = source.getGrossArea();
        if(!COBieUtility.isNA(grossArea))
        	ValueHelper.assign(grossArea, target.addNewSpaceGrossAreaValue());
    }

    private void assignNetArea()
    {
        String netArea = source.getNetArea();
        if(!COBieUtility.isNA(netArea))
        	ValueHelper.assign(netArea, target.addNewSpaceNetAreaValue());
    }

    private void assignSpacePerimeter()
    {
        // TODO Derive Space Perimeter

    }

    private void assignUsableHeight()
    {
        String sheetUsableHeight = source.getUsableHeight();
        if(!COBieUtility.isNA(sheetUsableHeight))
        	ValueHelper.assign(sheetUsableHeight, target.addNewSpaceUsableHeightValue());
    }

    private void assignZones()
    {
        String spaceName = source.getName();
        SpaceZonesIndex spaceZonesIndex = indexedCOBie.getSpaceZones();
        if (spaceZonesIndex.containsKey(spaceName))
        {
            ZoneAssignmentCollectionType zoneAssignments = target.addNewSpaceZoneAssignments();
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
        return target.addNewSpaceAttributes();
    }

    @Override
    public DocumentCollectionType getNewDocuments()
    {
        return target.addNewSpaceDocuments();
    }

    @Override
    public IssueCollectionType getNewIssues()
    {
        return target.addNewSpaceIssues();
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
    	if(!COBieUtility.isNA(source.getExtObject()))
    		target.setExternalEntityName(source.getExtObject());
    	if(!COBieUtility.isNA(source.getExtIdentifier()))
    		target.setExternalID(source.getExtIdentifier());
    	if(!COBieUtility.isNA(source.getExtSystem()))
    		target.setExternalSystemName(source.getExtSystem());
    	if(!COBieUtility.isNA(source.getCategory()))
    		target.setSpaceCategory(source.getCategory());
    	if(!COBieUtility.isNA(source.getDescription()))
    		target.setSpaceDescription(source.getDescription());
    	if(!COBieUtility.isNA(source.getName()))
    		target.setSpaceName(source.getName());
    	if(!COBieUtility.isNA(source.getRoomTag()))
    		target.setSpaceSignageName(source.getRoomTag());
    }

}
