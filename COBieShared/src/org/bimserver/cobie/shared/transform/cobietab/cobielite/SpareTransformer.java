package org.bimserver.cobie.shared.transform.cobietab.cobielite;


import org.bimserver.cobie.shared.cobietab.IndexedCOBie;
import org.bimserver.cobie.shared.utility.COBieUtility;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.SpareType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.AttributeCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.DocumentCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.IssueCollectionType;

public class SpareTransformer extends ChildTransformer<org.nibs.cobie.tab.SpareType, SpareType>
{

    public SpareTransformer(org.nibs.cobie.tab.SpareType cobieSheetXMLData, SpareType cobieLiteRowData, IndexedCOBie indexedCOBie)
    {
        super(cobieSheetXMLData, cobieLiteRowData, indexedCOBie);
    }

    @Override
    public AttributeCollectionType getNewAttributes()
    {
        return target.addNewSpareAttributes();
    }

    @Override
    public DocumentCollectionType getNewDocuments()
    {
        return target.addNewSpareDocuments();
    }

    @Override
    public IssueCollectionType getNewIssues()
    {
        return target.addNewSpareIssues();
    }

    @Override
    protected void parseComplexElements()
    {
        String suppliers = source.getSuppliers();
        if (!COBieUtility.isNA(suppliers))
        {
            AssignmentHelper.parseContactAssignments(target.addNewSpareSupplierContactAssignments(), suppliers);
        }

    }

    @Override
    protected void parseSimpleElements()
    {
        target.setExternalEntityName(source.getExtObject());
        target.setExternalID(source.getExtIdentifier());
        target.setExternalSystemName(source.getExtSystem());
        target.setSpareCategory(source.getCategory());
        target.setSpareDescription(source.getDescription());
        target.setSpareName(source.getName());
        target.setSparePartNumber(source.getPartNumber());
        target.setSpareSetNumber(source.getSetNumber());
    }

}
