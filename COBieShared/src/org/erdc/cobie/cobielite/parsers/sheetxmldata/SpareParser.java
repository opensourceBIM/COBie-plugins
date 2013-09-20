package org.erdc.cobie.cobielite.parsers.sheetxmldata;


import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.SpareType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.AttributeCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.DocumentCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.IssueCollectionType;
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
        return targetCOBie.addNewSpareAttributes();
    }

    @Override
    public DocumentCollectionType getNewDocuments()
    {
        return targetCOBie.addNewSpareDocuments();
    }

    @Override
    public IssueCollectionType getNewIssues()
    {
        return targetCOBie.addNewSpareIssues();
    }

    @Override
    protected void parseComplexElements()
    {
        String suppliers = sourceCOBie.getSuppliers();
        if (!COBieUtility.isNA(suppliers))
        {
            AssignmentHelper.parseContactAssignments(targetCOBie.addNewSpareSupplierContactAssignments(), suppliers);
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
