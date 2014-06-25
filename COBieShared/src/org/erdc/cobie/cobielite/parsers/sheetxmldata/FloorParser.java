package org.erdc.cobie.cobielite.parsers.sheetxmldata;

import java.util.ArrayList;



import org.buildingsmartalliance.docs.nbims03.cobie.core.AttributeCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.DocumentCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.IssueCollectionType;
import org.erdc.cobie.cobielite.ValueHelper;
import org.erdc.cobie.cobielite.parsers.COBieLiteParserDispatcher;
import org.erdc.cobie.cobielite.parsers.sheetxmldata.dispatchers.FloorSpaceDispatcher;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.shared.cobiesheetxmldata.indices.FloorSpacesIndex;
import org.erdc.cobie.shared.cobiesheetxmldata.indices.IndexedCOBie;
import org.erdc.cobie.shared.cobiesheetxmldata.indices.SpaceZonesIndex;
import org.erdc.cobie.sheetxmldata.FloorType;
import org.erdc.cobie.sheetxmldata.SpaceType;

public class FloorParser extends DeepParser<FloorType, org.buildingsmartalliance.docs.nbims03.cobie.cobielite.FloorType>
{

    protected final FloorSpacesIndex floorSpaces;
    protected final SpaceZonesIndex spaceZones;
    protected ArrayList<SpaceType> sheetXMLSpaces;

    public FloorParser(FloorType cobieSheetXMLData, org.buildingsmartalliance.docs.nbims03.cobie.cobielite.FloorType cobieLiteRowData, IndexedCOBie indexedCOBie)
    {
        super(cobieSheetXMLData, cobieLiteRowData, indexedCOBie);
        floorSpaces = indexedCOBie.getFloorSpaces();
        spaceZones = indexedCOBie.getSpaceZones();
        initializeSheetXMLSpaces();
    }

    private void assignElevation()
    {
        String sheetXMLDataElevation = sourceCOBie.getElevation();
        if (isValidQuantity(sheetXMLDataElevation))
        {
            ValueHelper.assign(sheetXMLDataElevation, targetCOBie.addNewFloorElevationValue());
        }
    }

    private void assignHeight()
    {
        String sheetXMLDataHeight = sourceCOBie.getHeight();
        if (isValidQuantity(sheetXMLDataHeight))
        {
            ValueHelper.assign(sheetXMLDataHeight, targetCOBie.addNewFloorHeightValue());
        }

    }

    @SuppressWarnings("rawtypes")
    @Override
    protected ArrayList<COBieLiteParserDispatcher> getChildParsingDispatchers()
    {
        ArrayList<COBieLiteParserDispatcher> childParsingDispatcher = new ArrayList<COBieLiteParserDispatcher>();
        childParsingDispatcher.add(new FloorSpaceDispatcher(sheetXMLSpaces, targetCOBie, indexedCOBie));
        return childParsingDispatcher;
    }

    @Override
    public AttributeCollectionType getNewAttributes()
    {
        return targetCOBie.addNewFloorAttributes();
    }

    @Override
    public DocumentCollectionType getNewDocuments()
    {
        return targetCOBie.addNewFloorDocuments();
    }

    @Override
    public IssueCollectionType getNewIssues()
    {
        return targetCOBie.addNewFloorIssues();
    }

    private void initializeSheetXMLSpaces()
    {
        try
        {
            sheetXMLSpaces = floorSpaces.get(sourceCOBie.getName());
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
    	if(!COBieUtility.isNA(sourceCOBie.getExtObject()))
    		targetCOBie.setExternalEntityName(sourceCOBie.getExtObject());
    	if(!COBieUtility.isNA(sourceCOBie.getExtIdentifier()))
    		targetCOBie.setExternalID(sourceCOBie.getExtIdentifier());
    	if(!COBieUtility.isNA(sourceCOBie.getExtSystem()))
    		targetCOBie.setExternalSystemName(sourceCOBie.getExtSystem());
    	if(!COBieUtility.isNA(sourceCOBie.getCategory()))
    		targetCOBie.setFloorCategory(sourceCOBie.getCategory());
    	if(!COBieUtility.isNA(sourceCOBie.getDescription()))
    		targetCOBie.setFloorDescription(sourceCOBie.getDescription());
    	if(!COBieUtility.isNA(sourceCOBie.getName()))
    		targetCOBie.setFloorName(sourceCOBie.getName());

    }
}
