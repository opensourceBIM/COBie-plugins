package org.bimserver.cobie.shared.transform.cobietab.cobielite;


import org.bimserver.cobie.shared.cobietab.IndexedCOBie;
import org.bimserver.cobie.shared.utility.COBieUtility;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.SystemType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.AttributeCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.DocumentCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.IssueCollectionType;

public class SystemTransformer extends ChildTransformer<org.nibs.cobie.tab.SystemType, SystemType>
{

    public SystemTransformer(org.nibs.cobie.tab.SystemType cobieSheetXMLData, SystemType cobieLiteRowData, IndexedCOBie indexedCOBie)
    {
        super(cobieSheetXMLData, cobieLiteRowData, indexedCOBie);
    }

    @Override
    public AttributeCollectionType getNewAttributes()
    {
        return target.addNewSystemAttributes();
    }

    @Override
    public DocumentCollectionType getNewDocuments()
    {
        return target.addNewSystemDocuments();
    }

    @Override
    public IssueCollectionType getNewIssues()
    {
        return target.addNewSystemIssues();
    }

    @Override
    protected void parseComplexElements()
    {
        // Nothing to do

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
    		target.setSystemCategory(source.getCategory());
    	if(!COBieUtility.isNA(source.getDescription()))
    		target.setSystemDescription(source.getDescription());
    	if(!COBieUtility.isNA(source.getName()))
    		target.setSystemName(source.getName());

    }

}
