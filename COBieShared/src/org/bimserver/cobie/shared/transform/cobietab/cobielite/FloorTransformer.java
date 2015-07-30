package org.bimserver.cobie.shared.transform.cobietab.cobielite;

import java.util.ArrayList;



















import org.bimserver.cobie.shared.cobietab.FloorSpacesIndex;
import org.bimserver.cobie.shared.cobietab.IndexedCOBie;
import org.bimserver.cobie.shared.cobietab.SpaceZonesIndex;
import org.bimserver.cobie.shared.utility.COBieUtility;
import org.buildingsmartalliance.docs.nbims03.cobie.core.AttributeCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.DocumentCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.IssueCollectionType;
import org.nibs.cobie.tab.FloorType;
import org.nibs.cobie.tab.SpaceType;

public class FloorTransformer extends ParentTransformer<FloorType, org.buildingsmartalliance.docs.nbims03.cobie.cobielite.FloorType>
{

    protected final FloorSpacesIndex floorSpaces;
    protected final SpaceZonesIndex spaceZones;
    protected ArrayList<SpaceType> sheetXMLSpaces;

    public FloorTransformer(FloorType cobieSheetXMLData, org.buildingsmartalliance.docs.nbims03.cobie.cobielite.FloorType cobieLiteRowData, IndexedCOBie indexedCOBie)
    {
        super(cobieSheetXMLData, cobieLiteRowData, indexedCOBie);
        floorSpaces = indexedCOBie.getFloorSpaces();
        spaceZones = indexedCOBie.getSpaceZones();
        initializeSheetXMLSpaces();
    }

    private void assignElevation()
    {
        String sheetXMLDataElevation = source.getElevation();
        if (isValidQuantity(sheetXMLDataElevation))
        {
            ValueHelper.assign(sheetXMLDataElevation, target.addNewFloorElevationValue());
        }
    }

    private void assignHeight()
    {
        String sheetXMLDataHeight = source.getHeight();
        if (isValidQuantity(sheetXMLDataHeight))
        {
            ValueHelper.assign(sheetXMLDataHeight, target.addNewFloorHeightValue());
        }

    }

    @SuppressWarnings("rawtypes")
    @Override
    protected ArrayList<COBieLiteParserDispatcher> getChildParsingDispatchers()
    {
        ArrayList<COBieLiteParserDispatcher> childParsingDispatcher = new ArrayList<COBieLiteParserDispatcher>();
        childParsingDispatcher.add(new FloorSpaceDispatcher(sheetXMLSpaces, target, indexedCOBie));
        return childParsingDispatcher;
    }

    @Override
    public AttributeCollectionType getNewAttributes()
    {
        return target.addNewFloorAttributes();
    }

    @Override
    public DocumentCollectionType getNewDocuments()
    {
        return target.addNewFloorDocuments();
    }

    @Override
    public IssueCollectionType getNewIssues()
    {
        return target.addNewFloorIssues();
    }

    private void initializeSheetXMLSpaces()
    {
        try
        {
            sheetXMLSpaces = floorSpaces.get(source.getName());
        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    private boolean isValidQuantity(String sheetXMLDataHeight)
    {
        return ValueHelper.isDecimalValue(sheetXMLDataHeight);
    }

    @Override
    protected void parseChildLeaves()
    {
        assignElevation();
        assignHeight();
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
    		target.setFloorCategory(source.getCategory());
    	if(!COBieUtility.isNA(source.getDescription()))
    		target.setFloorDescription(source.getDescription());
    	if(!COBieUtility.isNA(source.getName()))
    		target.setFloorName(source.getName());

    }
}
