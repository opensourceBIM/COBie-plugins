package org.erdc.cobie.cobielite.parsers.sheetxmldata;


import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.SystemType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.AttributeCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.DocumentCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.IssueCollectionType;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.shared.cobiesheetxmldata.indices.IndexedCOBie;

public class SystemParser extends TypicalParser<org.erdc.cobie.sheetxmldata.SystemType, SystemType>
{

    public SystemParser(org.erdc.cobie.sheetxmldata.SystemType cobieSheetXMLData, SystemType cobieLiteRowData, IndexedCOBie indexedCOBie)
    {
        super(cobieSheetXMLData, cobieLiteRowData, indexedCOBie);
    }

    @Override
    public AttributeCollectionType getNewAttributes()
    {
        return targetCOBie.addNewSystemAttributes();
    }

    @Override
    public DocumentCollectionType getNewDocuments()
    {
        return targetCOBie.addNewSystemDocuments();
    }

    @Override
    public IssueCollectionType getNewIssues()
    {
        return targetCOBie.addNewSystemIssues();
    }

    @Override
    protected void parseComplexElements()
    {
        // Nothing to do

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
    		targetCOBie.setSystemCategory(sourceCOBie.getCategory());
    	if(!COBieUtility.isNA(sourceCOBie.getDescription()))
    		targetCOBie.setSystemDescription(sourceCOBie.getDescription());
    	if(!COBieUtility.isNA(sourceCOBie.getName()))
    		targetCOBie.setSystemName(sourceCOBie.getName());

    }

}
