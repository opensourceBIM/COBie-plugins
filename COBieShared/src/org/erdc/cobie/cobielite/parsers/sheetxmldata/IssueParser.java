package org.erdc.cobie.cobielite.parsers.sheetxmldata;

import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.shared.cobiesheetxmldata.indices.IndexedCOBie;
import org.erdc.cobie.sheetxmldata.IssueType;

public class IssueParser extends COBieLiteCOBIEBaseTypeParser<IssueType, org.buildingsmartalliance.docs.nbims03.cobie.cobielite.IssueType>
{

    public IssueParser(IssueType cobieSheetXMLData, org.buildingsmartalliance.docs.nbims03.cobie.cobielite.IssueType cobieLiteRowData, IndexedCOBie indexedCOBie)
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
        handleIssueContactAssignments(sourceCOBie, targetCOBie);
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
        targetCOBie.setExternalEntityName(sourceCOBie.getExtObject());
        targetCOBie.setExternalID(sourceCOBie.getExtIdentifier());
        targetCOBie.setExternalSystemName(sourceCOBie.getExtSystem());
        targetCOBie.setIssueCategory(sourceCOBie.getType());
        targetCOBie.setIssueDescription(sourceCOBie.getDescription());
        targetCOBie.setIssueImpactText(sourceCOBie.getImpact());
        targetCOBie.setIssueMitigationDescription(sourceCOBie.getMitigation());
        targetCOBie.setIssueName(sourceCOBie.getName());
        targetCOBie.setIssueRiskText(sourceCOBie.getChance());
        targetCOBie.setIssueSeverityText(sourceCOBie.getRisk());

    }

}
