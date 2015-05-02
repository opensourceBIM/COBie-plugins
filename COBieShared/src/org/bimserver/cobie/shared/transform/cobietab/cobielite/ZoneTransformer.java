package org.bimserver.cobie.shared.transform.cobietab.cobielite;


import org.bimserver.cobie.shared.cobietab.IndexedCOBie;
import org.bimserver.cobie.shared.utility.COBieUtility;
import org.buildingsmartalliance.docs.nbims03.cobie.core.AttributeCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.DocumentCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.IssueCollectionType;
import org.nibs.cobie.tab.ZoneType;

public class ZoneTransformer extends ChildTransformer<ZoneType, org.buildingsmartalliance.docs.nbims03.cobie.cobielite.ZoneType>
{

    public ZoneTransformer(ZoneType cobieSheetXMLData, org.buildingsmartalliance.docs.nbims03.cobie.cobielite.ZoneType cobieLiteRowData, IndexedCOBie indexedCOBie)
    {
        super(cobieSheetXMLData, cobieLiteRowData, indexedCOBie);
    }

    @Override
    public AttributeCollectionType getNewAttributes()
    {
        return target.addNewZoneAttributes();
    }

    @Override
    public DocumentCollectionType getNewDocuments()
    {
        return target.addNewZoneDocuments();
    }

    @Override
    public IssueCollectionType getNewIssues()
    {
        return target.addNewZoneIssues();
    }

    @Override
    protected void parseComplexElements()
    {
        // No complex elements to parse
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
    		target.setZoneCategory(source.getCategory());
        if(!COBieUtility.isNA(source.getDescription()))
        	target.setZoneDescription(source.getDescription());
        if(!COBieUtility.isNA(source.getName()))
        	target.setZoneName(source.getName());

    }

}
