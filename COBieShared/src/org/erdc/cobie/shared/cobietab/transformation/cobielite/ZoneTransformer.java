package org.erdc.cobie.shared.cobietab.transformation.cobielite;


import org.buildingsmartalliance.docs.nbims03.cobie.core.AttributeCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.DocumentCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.IssueCollectionType;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.shared.cobietab.IndexedCOBie;
import org.erdc.cobie.sheetxmldata.ZoneType;

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
