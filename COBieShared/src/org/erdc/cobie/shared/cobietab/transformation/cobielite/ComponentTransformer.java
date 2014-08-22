package org.erdc.cobie.shared.cobietab.transformation.cobielite;

import java.util.ArrayList;












import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.AssetInfoType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.AttributeCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.DocumentCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.IssueCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.SpaceAssignmentCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.SystemAssignmentCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.SystemKeyType;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.shared.cobietab.IndexedCOBie;
import org.erdc.cobie.sheetxmldata.ComponentType;
import org.erdc.cobie.sheetxmldata.SystemType;

public class ComponentTransformer extends ParentTransformer<ComponentType, AssetInfoType>
{

    public ComponentTransformer(ComponentType cobieSheetXMLData, AssetInfoType cobieLiteRowData, IndexedCOBie indexedCOBie)
    {
        super(cobieSheetXMLData, cobieLiteRowData, indexedCOBie);
    }

    @SuppressWarnings("rawtypes")
    @Override
    protected ArrayList<COBieLiteParserDispatcher> getChildParsingDispatchers()
    {
        ArrayList<COBieLiteParserDispatcher> parserDispatchers = new ArrayList<COBieLiteParserDispatcher>();
        parserDispatchers
                .add(new AssetAssemblyDispatcher(indexedCOBie.getComponentAssemblies().get(source.getName()), target, indexedCOBie));
        return parserDispatchers;
    }

    @Override
    public AttributeCollectionType getNewAttributes()
    {
        return target.addNewAssetAttributes();
    }

    @Override
    public DocumentCollectionType getNewDocuments()
    {
        return target.addNewAssetDocuments();
    }

    @Override
    public IssueCollectionType getNewIssues()
    {
        return target.addNewAssetIssues();
    }

    private void initializeDateTimeValues()
    {
        try
        {
            target.setAssetInstallationDate(COBieUtility.calendarFromStringWithException(source.getInstallationDate()));
        } catch (Exception ex)
        {

        }
        try
        {
            target.setAssetWarrantyStartDate(COBieUtility.calendarFromStringWithException(source.getWarrantyStartDate()));
        } catch (Exception ex)
        {

        }
    }

    private void initializeSpaceAssignments()
    {
        SpaceAssignmentCollectionType spaceAssignments = target.addNewAssetSpaceAssignments();
        AssignmentHelper.parseSpaceAssignments(spaceAssignments, source.getSpace(), indexedCOBie);

    }

    private void initializeSystemAssignments()
    {
        if ((indexedCOBie.getComponentSystems() != null) && indexedCOBie.getComponentSystems().containsKey(source.getName()))
        {
            ArrayList<SystemType> systems = indexedCOBie.getComponentSystems().get(source.getName());
            if (systems != null)
            {
                SystemAssignmentCollectionType systemAssignmets = target.addNewAssetSystemAssignments();
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
    	if(!COBieUtility.isNA(source.getBarCode()))
    		target.setAssetBarCode(source.getBarCode());
    	if(!COBieUtility.isNA(source.getDescription()))
    		target.setAssetDescription(source.getDescription());
    	if(!COBieUtility.isNA(source.getAssetIdentifier()))
    		target.setAssetIdentifier(source.getAssetIdentifier());
    	if(!COBieUtility.isNA(source.getDescription()))
    		target.setAssetLocationDescription(source.getDescription());
    	if(!COBieUtility.isNA(source.getName()))
    		target.setAssetName(source.getName());
    	if(!COBieUtility.isNA(source.getSerialNumber()))
    		target.setAssetSerialNumber(source.getSerialNumber());
    	if(!COBieUtility.isNA(source.getTagNumber()))
    		target.setAssetTagNumber(source.getTagNumber());
    	if(!COBieUtility.isNA(source.getExtObject()))
    		target.setExternalEntityName(source.getExtObject());
    	if(!COBieUtility.isNA(source.getExtIdentifier()))
    		target.setExternalID(source.getExtIdentifier());
    	if(!COBieUtility.isNA(source.getExtSystem()))
    		target.setExternalSystemName(source.getExtSystem());
        initializeDateTimeValues();

    }

}
