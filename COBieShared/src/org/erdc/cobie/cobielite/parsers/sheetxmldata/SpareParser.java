package org.erdc.cobie.cobielite.parsers.sheetxmldata;

import org.erdc.cobie.cobielite.AttributeCollectionType;
import org.erdc.cobie.cobielite.DocumentCollectionType;
import org.erdc.cobie.cobielite.IssueCollectionType;
import org.erdc.cobie.cobielite.SpareType;
import org.erdc.cobie.cobielite.parsers.sheetxmldata.dispatchers.AssignmentHelper;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.shared.cobiesheetxmldata.indices.IndexedCOBie;

public class SpareParser extends TypicalParser<org.erdc.cobie.sheetxmldata.SpareType, SpareType>
{

    public SpareParser(org.erdc.cobie.sheetxmldata.SpareType cobieSheetXMLData, SpareType cobieLiteRowData, IndexedCOBie indexedCOBie)
    {
        super(cobieSheetXMLData, cobieLiteRowData, indexedCOBie);
    }

    @Override
    public AttributeCollectionType getNewAttributes()
    {
        return targetCOBie.addNewAttributes();
    }

    @Override
    public DocumentCollectionType getNewDocuments()
    {
        return targetCOBie.addNewDocuments();
    }

    @Override
    public IssueCollectionType getNewIssues()
    {
        return targetCOBie.addNewIssues();
    }

    @Override
    protected void parseComplexElements()
    {
        String suppliers = sourceCOBie.getSuppliers();
        if (!COBieUtility.isNA(suppliers))
        {
            AssignmentHelper.parseContactAssignments(targetCOBie.addNewContactAssignments(), suppliers);
        }

    }

    @Override
    protected void parseSimpleElements()
    {
        targetCOBie.setExternalEntityName(sourceCOBie.getExtObject());
        targetCOBie.setExternalID(sourceCOBie.getExtIdentifier());
        targetCOBie.setExternalSystemName(sourceCOBie.getExtSystem());
        targetCOBie.setSpareCategory(sourceCOBie.getCategory());
        targetCOBie.setSpareDescription(sourceCOBie.getDescription());
        targetCOBie.setSpareName(sourceCOBie.getName());
        targetCOBie.setSparePartNumber(sourceCOBie.getPartNumber());
        targetCOBie.setSpareSetNumber(sourceCOBie.getSetNumber());
    }

}
