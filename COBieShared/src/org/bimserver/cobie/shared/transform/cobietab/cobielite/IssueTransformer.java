package org.bimserver.cobie.shared.transform.cobietab.cobielite;

import org.bimserver.cobie.shared.cobietab.IndexedCOBie;
import org.bimserver.cobie.shared.utility.COBieUtility;
import org.nibs.cobie.tab.IssueType;

public class IssueTransformer extends COBieBaseTypeTransformer<IssueType, org.buildingsmartalliance.docs.nbims03.cobie.cobielite.IssueType>
{

    public IssueTransformer(IssueType cobieSheetXMLData, org.buildingsmartalliance.docs.nbims03.cobie.cobielite.IssueType cobieLiteRowData, IndexedCOBie indexedCOBie)
    {
        super(cobieSheetXMLData, cobieLiteRowData, indexedCOBie);
    }

    protected void handleIssueContactAssignments(IssueType sheetXMLDataIssue, org.buildingsmartalliance.docs.nbims03.cobie.cobielite.IssueType cobieLiteIssue)
    {
        String owner = sheetXMLDataIssue.getOwner();
        String createdBy = sheetXMLDataIssue.getChance();
        if (!COBieUtility.isNA(owner))
        {
            cobieLiteIssue.addNewContactAssignment().setContactEmailReference(owner);
            if (!COBieUtility.isNA(createdBy) && !owner.equals(createdBy))
            {
                cobieLiteIssue.addNewContactAssignment().setContactEmailReference(createdBy);
            }

        } else if (!COBieUtility.isNA(createdBy))
        {
            cobieLiteIssue.addNewContactAssignment().setContactEmailReference(createdBy);
        }
    }

    @Override
    protected void parseAttributes()
    {
        // TODO Auto-generated method stub

    }

    @Override
    protected void parseComplexElements()
    {
        handleIssueContactAssignments(source, target);
    }

    @Override
    protected void parseDocuments()
    {
        // TODO Auto-generated method stub

    }

    @Override
    protected void parseIssues()
    {
        // TODO Auto-generated method stub

    }

    @Override
    protected void parseSimpleElements()
    {
        target.setExternalEntityName(source.getExtObject());
        target.setExternalID(source.getExtIdentifier());
        target.setExternalSystemName(source.getExtSystem());
        target.setIssueCategory(source.getType());
        target.setIssueDescription(source.getDescription());
        target.setIssueImpactText(source.getImpact());
        target.setIssueMitigationDescription(source.getMitigation());
        target.setIssueName(source.getName());
        target.setIssueRiskText(source.getChance());
        target.setIssueSeverityText(source.getRisk());

    }

}
