package org.erdc.cobie.cobielite.parsers.sheetxmldata;

import java.util.ArrayList;


import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.AssetInfoType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.AttributeCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.DocumentCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.IssueCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.SpaceAssignmentCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.SystemAssignmentCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.SystemKeyType;
import org.erdc.cobie.cobielite.parsers.COBieLiteParserDispatcher;
import org.erdc.cobie.cobielite.parsers.sheetxmldata.dispatchers.AssetAssemblyDispatcher;
import org.erdc.cobie.cobielite.parsers.sheetxmldata.dispatchers.AssignmentHelper;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.shared.cobiesheetxmldata.indices.IndexedCOBie;
import org.erdc.cobie.sheetxmldata.ComponentType;
import org.erdc.cobie.sheetxmldata.SystemType;

public class AssetParser extends DeepParser<ComponentType, AssetInfoType>
{

    public AssetParser(ComponentType cobieSheetXMLData, AssetInfoType cobieLiteRowData, IndexedCOBie indexedCOBie)
    {
        super(cobieSheetXMLData, cobieLiteRowData, indexedCOBie);
    }

    @SuppressWarnings("rawtypes")
    @Override
    protected ArrayList<COBieLiteParserDispatcher> getChildParsingDispatchers()
    {
        ArrayList<COBieLiteParserDispatcher> parserDispatchers = new ArrayList<COBieLiteParserDispatcher>();
        parserDispatchers
                .add(new AssetAssemblyDispatcher(indexedCOBie.getComponentAssemblies().get(sourceCOBie.getName()), targetCOBie, indexedCOBie));
        return parserDispatchers;
    }

    @Override
    public AttributeCollectionType getNewAttributes()
    {
        return targetCOBie.addNewAssetAttributes();
    }

    @Override
    public DocumentCollectionType getNewDocuments()
    {
        return targetCOBie.addNewAssetDocuments();
    }

    @Override
    public IssueCollectionType getNewIssues()
    {
        return targetCOBie.addNewAssetIssues();
    }

    private void initializeDateTimeValues()
    {
        try
        {
            targetCOBie.setAssetInstallationDate(COBieUtility.calendarFromStringWithException(sourceCOBie.getInstallationDate()));
        } catch (Exception ex)
        {

        }
        try
        {
            targetCOBie.setAssetWarrantyStartDate(COBieUtility.calendarFromStringWithException(sourceCOBie.getWarrantyStartDate()));
        } catch (Exception ex)
        {

        }
    }

    private void initializeSpaceAssignments()
    {
        SpaceAssignmentCollectionType spaceAssignments = targetCOBie.addNewAssetSpaceAssignments();
        AssignmentHelper.parseSpaceAssignments(spaceAssignments, sourceCOBie.getSpace(), indexedCOBie);

    }

    private void initializeSystemAssignments()
    {
        if ((indexedCOBie.getComponentSystems() != null) && indexedCOBie.getComponentSystems().containsKey(sourceCOBie.getName()))
        {
            ArrayList<SystemType> systems = indexedCOBie.getComponentSystems().get(sourceCOBie.getName());
            if (systems != null)
            {
                SystemAssignmentCollectionType systemAssignmets = targetCOBie.addNewAssetSystemAssignments();
                for (SystemType system : systems)
                {
                    SystemKeyType systemKey = systemAssignmets.addNewSystemAssignment();
                    systemKey.setSystemCategory(system.getCategory());
                    systemKey.setSystemName(system.getName());
                }
            }
        }
    }

    @Override
    protected void parseChildLeaves()
    {
        try
        {
            initializeSpaceAssignments();
        } catch (Exception ex)
        {

        }

        try
        {
            initializeSystemAssignments();
        } catch (Exception ex)
        {

        }

    }

    @Override
    protected void parseSimpleElements()
    {
        targetCOBie.setAssetBarCode(sourceCOBie.getBarCode());
        targetCOBie.setAssetDescription(sourceCOBie.getDescription());
        targetCOBie.setAssetIdentifier(sourceCOBie.getAssetIdentifier());
        targetCOBie.setAssetLocationDescription(sourceCOBie.getDescription());
        targetCOBie.setAssetName(sourceCOBie.getName());
        targetCOBie.setAssetSerialNumber(sourceCOBie.getSerialNumber());
        targetCOBie.setAssetTagNumber(sourceCOBie.getTagNumber());
        targetCOBie.setExternalEntityName(sourceCOBie.getExtObject());
        targetCOBie.setExternalID(sourceCOBie.getExtIdentifier());
        targetCOBie.setExternalSystemName(sourceCOBie.getExtSystem());
        initializeDateTimeValues();

    }

}
