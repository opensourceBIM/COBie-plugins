package org.erdc.cobie.cobielite.parsers.sheetxmldata;

import java.util.ArrayList;
import java.util.List;

import org.erdc.cobie.cobielite.AttributeCollectionType;
import org.erdc.cobie.cobielite.DecimalValueType;
import org.erdc.cobie.cobielite.DocumentCollectionType;
import org.erdc.cobie.cobielite.IntegerValueType;
import org.erdc.cobie.cobielite.IssueCollectionType;
import org.erdc.cobie.cobielite.JobType;
import org.erdc.cobie.cobielite.ResourceCollectionType;
import org.erdc.cobie.cobielite.ValueHelper;
import org.erdc.cobie.cobielite.parsers.COBieLiteParserDispatcher;
import org.erdc.cobie.cobielite.parsers.TypicalParserDispatcher;
import org.erdc.cobie.cobielite.parsers.sheetxmldata.dispatchers.JobResourceDispatcher;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.shared.cobiesheetxmldata.indices.IndexedCOBie;

public class JobParser extends DeepParser<org.erdc.cobie.sheetxmldata.JobType, JobType>
{

    public JobParser(org.erdc.cobie.sheetxmldata.JobType cobieSheetXMLData, JobType cobieLiteRowData, IndexedCOBie indexedCOBie)
    {
        super(cobieSheetXMLData, cobieLiteRowData, indexedCOBie);
    }

    @Override
    protected ArrayList<COBieLiteParserDispatcher> getChildParsingDispatchers()
    {
        ArrayList<COBieLiteParserDispatcher> jobResourceDispatchers = new ArrayList<COBieLiteParserDispatcher>();
        List<org.erdc.cobie.sheetxmldata.ResourceType> resources = getResources(targetCOBie.addNewResources(), sourceCOBie.getResourceNames(),
                indexedCOBie);
        jobResourceDispatchers.add(new JobResourceDispatcher(resources, targetCOBie, indexedCOBie));
        return jobResourceDispatchers;
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

    public List<org.erdc.cobie.sheetxmldata.ResourceType> getResources(
            ResourceCollectionType resourceAssignment,
            String resourceNameExpression,
            IndexedCOBie indexedCOBie)
    {
        ArrayList<org.erdc.cobie.sheetxmldata.ResourceType> resources = new ArrayList<org.erdc.cobie.sheetxmldata.ResourceType>();
        List<String> resourceNameExpressions = new ArrayList<String>();
        if (resourceNameExpression.contains(COBieUtility.getCOBieDelim()))
        {
            resourceNameExpressions = COBieUtility.arrayListFromDelimString(resourceNameExpression);

        } else
        {
            resourceNameExpressions.add(resourceNameExpression);
        }

        for (String expression : resourceNameExpressions)
        {
            if (indexedCOBie.getResourceIndex().containsKey(expression))
            {
                resources.add(indexedCOBie.getResourceIndex().get(expression));
            }
        }
        return resources;
    }

    @Override
    protected void parseChildLeaves()
    {
        handleDuration();
        handleFrequency();
        handleStartDate();
    }

    private void handleStartDate()
    {
        try
        {
            targetCOBie.setJobStartDate(COBieUtility.calendarFromString(sourceCOBie.getStart()));
        }
        catch(Exception ex)
        {
            
        }
    }

    private void handleFrequency()
    {
        ValueHelper.assign(sourceCOBie.getFrequency(), targetCOBie.addNewJobFrequencyValue());
        String frequencyUnitName = sourceCOBie.getFrequencyUnit();
        if(targetCOBie.getJobFrequencyValue() != null && !COBieUtility.isNA(frequencyUnitName))
        {
            DecimalValueType jobFrequency = targetCOBie.getJobFrequencyValue();
            jobFrequency.setUnitName(frequencyUnitName);
        }
    }

    private void handleDuration()
    {
        ValueHelper.assign(sourceCOBie.getDuration(), targetCOBie.addNewJobDuration());
        String durationUnitName = sourceCOBie.getDurationUnit();
        if(targetCOBie.getJobDuration()!=null && !COBieUtility.isNA(durationUnitName))
        {
            IntegerValueType jobDuration = targetCOBie.getJobDuration();
            jobDuration.setUnitName(durationUnitName);
        }
    }

    @Override
    protected void parseSimpleElements()
    {
        targetCOBie.setExternalEntityName(sourceCOBie.getExtObject());
        targetCOBie.setExternalID(sourceCOBie.getExtIdentifier());
        targetCOBie.setExternalSystemName(sourceCOBie.getExtSystem());
        targetCOBie.setJobCategory(sourceCOBie.getCategory());
        targetCOBie.setJobDescription(sourceCOBie.getDescription());
        targetCOBie.setJobName(sourceCOBie.getName());
        targetCOBie.setJobStartConditionDescription(sourceCOBie.getTaskStartUnit());       
        targetCOBie.setJobStatus(sourceCOBie.getStatus());
        targetCOBie.setJobTaskID(sourceCOBie.getTaskNumber());

    }

}
