package org.erdc.cobie.cobielite.parsers.sheetxmldata;

import java.util.ArrayList;
import java.util.List;


import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.JobType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.AttributeCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.DecimalValueType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.DocumentCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.IntegerValueType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.IssueCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.ResourceCollectionType;
import org.erdc.cobie.cobielite.ValueHelper;
import org.erdc.cobie.cobielite.parsers.COBieLiteParserDispatcher;
import org.erdc.cobie.cobielite.parsers.sheetxmldata.dispatchers.JobResourceDispatcher;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.shared.cobiesheetxmldata.indices.IndexedCOBie;

public class JobParser extends DeepParser<org.erdc.cobie.sheetxmldata.JobType, JobType>
{

    public JobParser(org.erdc.cobie.sheetxmldata.JobType cobieSheetXMLData, JobType cobieLiteRowData, IndexedCOBie indexedCOBie)
    {
        super(cobieSheetXMLData, cobieLiteRowData, indexedCOBie);
    }

    @SuppressWarnings("rawtypes")
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
        return targetCOBie.addNewJobAttributes();
    }

    @Override
    public DocumentCollectionType getNewDocuments()
    {
        return targetCOBie.addNewJobDocuments();
    }

    @Override
    public IssueCollectionType getNewIssues()
    {
        return targetCOBie.addNewJobIssues();
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
    	if(!COBieUtility.isNA(sourceCOBie.getFrequency()))
    	{
    		 ValueHelper.assign(sourceCOBie.getFrequency(), targetCOBie.addNewJobFrequencyValue());
    		 String frequencyUnitName = sourceCOBie.getFrequencyUnit();
	        if(targetCOBie.getJobFrequencyValue() != null && !COBieUtility.isNA(frequencyUnitName))
	        {
	            DecimalValueType jobFrequency = targetCOBie.getJobFrequencyValue();
	            jobFrequency.addNewUnitName().setStringValue(frequencyUnitName);
	        }
    	}
       
    }

    private void handleDuration()
    {
    	if(!COBieUtility.isNA(sourceCOBie.getDuration()))
    	{
    		ValueHelper.assign(sourceCOBie.getDuration(), targetCOBie.addNewJobDuration());
            String durationUnitName = sourceCOBie.getDurationUnit();
            if(targetCOBie.getJobDuration()!=null && !COBieUtility.isNA(durationUnitName))
            {
                IntegerValueType jobDuration = targetCOBie.getJobDuration();
                jobDuration.addNewUnitName().setStringValue(durationUnitName);
            }
    	}
        
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
    		targetCOBie.setJobCategory(sourceCOBie.getCategory());
    	if(!COBieUtility.isNA(sourceCOBie.getDescription()))
    		targetCOBie.setJobDescription(sourceCOBie.getDescription());
    	if(!COBieUtility.isNA(sourceCOBie.getName()))
    		targetCOBie.setJobName(sourceCOBie.getName());
    	if(!COBieUtility.isNA(sourceCOBie.getTaskStartUnit()))
    		targetCOBie.setJobStartConditionDescription(sourceCOBie.getTaskStartUnit());       
    	if(!COBieUtility.isNA(sourceCOBie.getStatus()))
    		targetCOBie.setJobStatus(sourceCOBie.getStatus());
    	if(!COBieUtility.isNA(sourceCOBie.getTaskNumber()))
    		targetCOBie.setJobTaskID(sourceCOBie.getTaskNumber());

    }

}
