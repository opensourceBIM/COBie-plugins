package org.bimserver.cobie.shared.transform.cobietab.cobielite;

import java.util.ArrayList;
import java.util.List;


















import org.bimserver.cobie.shared.cobietab.IndexedCOBie;
import org.bimserver.cobie.shared.utility.COBieUtility;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.JobType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.AttributeCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.DecimalValueType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.DocumentCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.IntegerValueType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.IssueCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.ResourceCollectionType;

public class JobTransformer extends ParentTransformer<org.nibs.cobie.tab.JobType, JobType>
{

    public JobTransformer(org.nibs.cobie.tab.JobType cobieSheetXMLData, JobType cobieLiteRowData, IndexedCOBie indexedCOBie)
    {
        super(cobieSheetXMLData, cobieLiteRowData, indexedCOBie);
    }

    @SuppressWarnings("rawtypes")
    @Override
    protected ArrayList<COBieLiteParserDispatcher> getChildParsingDispatchers()
    {
        ArrayList<COBieLiteParserDispatcher> jobResourceDispatchers = new ArrayList<COBieLiteParserDispatcher>();
        List<org.nibs.cobie.tab.ResourceType> resources = getResources(target.addNewResources(), source.getResourceNames(),
                indexedCOBie);
        jobResourceDispatchers.add(new JobResourceDispatcher(resources, target, indexedCOBie));
        return jobResourceDispatchers;
    }

    @Override
    public AttributeCollectionType getNewAttributes()
    {
        return target.addNewJobAttributes();
    }

    @Override
    public DocumentCollectionType getNewDocuments()
    {
        return target.addNewJobDocuments();
    }

    @Override
    public IssueCollectionType getNewIssues()
    {
        return target.addNewJobIssues();
    }

    public List<org.nibs.cobie.tab.ResourceType> getResources(
            ResourceCollectionType resourceAssignment,
            String resourceNameExpression,
            IndexedCOBie indexedCOBie)
    {
        ArrayList<org.nibs.cobie.tab.ResourceType> resources = new ArrayList<org.nibs.cobie.tab.ResourceType>();
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
            target.setJobStartDate(COBieUtility.calendarFromString(source.getStart()));
        }
        catch(Exception ex)
        {
            
        }
    }

    private void handleFrequency()
    {
    	if(!COBieUtility.isNA(source.getFrequency()))
    	{
    		 ValueHelper.assign(source.getFrequency(), target.addNewJobFrequencyValue());
    		 String frequencyUnitName = source.getFrequencyUnit();
	        if(target.getJobFrequencyValue() != null && !COBieUtility.isNA(frequencyUnitName))
	        {
	            DecimalValueType jobFrequency = target.getJobFrequencyValue();
	            jobFrequency.addNewUnitName().setStringValue(frequencyUnitName);
	        }
    	}
       
    }

    private void handleDuration()
    {
    	if(!COBieUtility.isNA(source.getDuration()))
    	{
    		ValueHelper.assign(source.getDuration(), target.addNewJobDuration());
            String durationUnitName = source.getDurationUnit();
            if(target.getJobDuration()!=null && !COBieUtility.isNA(durationUnitName))
            {
                IntegerValueType jobDuration = target.getJobDuration();
                jobDuration.addNewUnitName().setStringValue(durationUnitName);
            }
    	}
        
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
    		target.setJobCategory(source.getCategory());
    	if(!COBieUtility.isNA(source.getDescription()))
    		target.setJobDescription(source.getDescription());
    	if(!COBieUtility.isNA(source.getName()))
    		target.setJobName(source.getName());
    	if(!COBieUtility.isNA(source.getTaskStartUnit()))
    		target.setJobStartConditionDescription(source.getTaskStartUnit());       
    	if(!COBieUtility.isNA(source.getStatus()))
    		target.setJobStatus(source.getStatus());
    	if(!COBieUtility.isNA(source.getTaskNumber()))
    		target.setJobTaskID(source.getTaskNumber());

    }

}
