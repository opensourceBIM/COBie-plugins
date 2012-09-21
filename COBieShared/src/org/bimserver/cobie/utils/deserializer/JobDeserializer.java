package org.bimserver.cobie.utils.deserializer;

import java.util.ArrayList;
import java.util.Arrays;

import org.bimserver.cobie.cobielite.COBIEType;
import org.bimserver.cobie.cobielite.COBIEType.Jobs;
import org.bimserver.cobie.cobielite.JobType;
import org.bimserver.cobie.utils.deserializer.modelhandlers.IfcCommonHandler;
import org.bimserver.cobie.utils.deserializer.modelhandlers.PropertySetHandler;
import org.bimserver.cobie.utils.deserializer.propertysets.PropertyUtility;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.IfcConstructionEquipmentResource;
import org.bimserver.models.ifc2x3tc1.IfcObjectTypeEnum;
import org.bimserver.models.ifc2x3tc1.IfcProperty;
import org.bimserver.models.ifc2x3tc1.IfcPropertySet;
import org.bimserver.models.ifc2x3tc1.IfcPropertySingleValue;
import org.bimserver.models.ifc2x3tc1.IfcRelAssignsToProcess;
import org.bimserver.models.ifc2x3tc1.IfcRelSequence;
import org.bimserver.models.ifc2x3tc1.IfcSequenceEnum;
import org.bimserver.models.ifc2x3tc1.IfcTask;
import org.bimserver.models.ifc2x3tc1.IfcTypeObject;
import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;
import org.bimserver.shared.cobie.COBieUtility;
import org.bimserver.shared.cobie.targetunits.time.TimeUnitSearch;

// TODO: Auto-generated Javadoc
/**
 * JobDeserializer parses through each JobType object in COBIEType.Jobs and adds IfcTask entities and related properties and relationships to the model
 * Job elements or attributes are mapped to Ifc entities as follows:
 * 	Name:  IfcTask.Name
 *	CreatedBy:  IfcOwnerHistory attached to IfcTask
 *  CreatedOn:  IfcOwnerHistory attached to IfcTask
 *	Category:  	IfcTask.ObjectType
 *	Status:   	IfcTask.Status
 * 	TypeName:	IfcRelAssignsToProcess where IfcTask is relating process and IfcType is in relatedObjects
 *	Description:  IfcTask.Description
 *	Duration:	IfcProperty with name "TaskDuration" in property set "pset_COBie_Job"
 *	DurationUnit:  IfcUnit attached to Duration
 *	Start:    IfcProperty with name "TaskStartDate" in property set "pset_COBie_Job"
 *	TaskStartUnit:  ?
 *	Frequency:  IfcProperty with name "TaskInterval" in property set "pset_COBie_Job"
 *	FrequencyUnit:  IfcUnit related to Frequency
 *	ExtSystem:  IfcOwnerHistory attached to IfcTask
 *	ExtObject:  n/a
 *	ExtIdentifier:  IfcTask.GlobalId
 *	TaskNumber:  IfcTask.TaskId
 *	Priors:  IfcTask.IsSuccsessorFrom.RelatingProcess with matching name,type, and TaskId
 *	ResourceNames:  IfcRelAssignsToProcess.RelatedObjects (ResourceNames is a comma delimitted list of matching Resources)
 */
public class JobDeserializer extends COBieLiteSectionDeserializer<COBIEType.Jobs,JobType,IfcTask>
{
	private static final IfcObjectTypeEnum DEFAULT_RELASSIGNSTOPROCESS_RELATEDOBJECTTYPE = IfcObjectTypeEnum.PRODUCT;
	private final String ASSIGNS_TO_PROCESS_FORMAT_STRING = 
			"Relationship from Task %s %s to a Type and Resources";
	private final String SEQUENCE_RELATION_FORMAT_STRING ="Temporal relationship between Task %s %s and Task %s %s for Type %s";
	private final String DURATION_PROPERTY_NAME="TaskDuration";
	private final String START_PROPERTY_NAME="TaskStartDate";
	private final String FREQUENCY_PROPERTY_NAME ="TaskInterval";
	private final String JOB_PROPERTY_SET_NAME=
			String.format(PropertySetHandler.fs_COBiePropertySetName, COBieUtility.CobieSheetName.Job.name());

	
	
	/**
	 * Instantiates a new job deserializer.
	 *
	 * @param model the model
	 * @param ifcCommonHandler the ifc common handler for guids, oids, property sets, and classification references
	 * @param jobs COBie jobs
	 */
	public JobDeserializer(COBieIfcModel model,IfcCommonHandler ifcCommonHandler,COBIEType.Jobs jobs)
	{
		super(ifcCommonHandler,model,jobs);	
	}
	
	


	@SuppressWarnings("unchecked")
	@Override
	protected Iterable cobieLiteSectionIterableFromCOBieLiteSection(
			Jobs cobieLiteSection)
	{
		return new ArrayList(Arrays.asList(cobieLiteSection.getJobArray()));
	}

	@Override
	protected IfcTask initializeIfcFromCOBieLite(JobType cobieElement)
			throws Exception
	{
		JobType job = cobieElement;
		IfcTask task =
				Ifc2x3tc1Factory.eINSTANCE.createIfcTask();
		task.setName(job.getName());
		task.setDescription( job.getDescription());
		task.setGlobalId(ifcCommonHandler.getGuidHandler().guidFromExternalIdentifier(job.getExtIdentifier()));
		task.setOwnerHistory(ifcCommonHandler.getOwnerHistoryHandler().ownerHistoryFromEmailTimestampAndApplication(job.getCreatedBy(),
				job.getCreatedOn(), cobieElement.getExtSystem()));
		task.setObjectType(job.getCategory());
		task.setStatus(job.getStatus());
		task.setTaskId(job.getTaskNumber());
		return task;
	}

	@Override
	protected void initializeAndAddClassificationsToModel(IfcTask ifcObject,
			JobType cobieLiteElement) throws Exception
	{
		// Do nothing, no classification objects are attached according to COBie spec
	}

	@Override
	protected void initializeAndAddPropertySetsToModel(IfcTask ifcObject,
			JobType cobieLiteElement) throws Exception
	{
		IfcPropertySet jobProperties =
				Ifc2x3tc1Factory.eINSTANCE.createIfcPropertySet();
		jobProperties.setName(JOB_PROPERTY_SET_NAME);
		jobProperties.setDescription(JOB_PROPERTY_SET_NAME);
		jobProperties.setGlobalId(ifcCommonHandler.getGuidHandler().newGuid());
		jobProperties.setOwnerHistory
			(ifcCommonHandler.getOwnerHistoryHandler().
					ownerHistoryFromEmailTimestampAndApplication(cobieLiteElement.getCreatedBy(),
				cobieLiteElement.getCreatedOn(), cobieLiteElement.getExtSystem()));
		IfcProperty durationProperty = durationPropertyFromTask(cobieLiteElement);
		IfcProperty frequencyProperty = frequencyPropertyFromClass(cobieLiteElement);
		IfcProperty taskStartProperty = startPropertyFromTask(cobieLiteElement);
		jobProperties.getHasProperties().add(durationProperty);
		jobProperties.getHasProperties().add(frequencyProperty);
		jobProperties.getHasProperties().add(taskStartProperty);
		ifcCommonHandler.getPropertySetHandler().addPropertiesAndPropertySetToObject(ifcObject, jobProperties, true);
		
	}




	private IfcProperty startPropertyFromTask(JobType cobieLiteElement)
	{
		IfcProperty taskStartProperty =
				PropertyUtility.propertyFromCOBieStringAndUnit(cobieLiteElement.getStart(),
						START_PROPERTY_NAME, START_PROPERTY_NAME,cobieLiteElement.getTaskStartUnit(),IfcUnitEnum.TIMEUNIT);
		return taskStartProperty;
	}




	private IfcProperty frequencyPropertyFromClass(JobType cobieLiteElement)
	{
		IfcProperty frequencyProperty =
				PropertyUtility.propertyFromCOBieStringAndUnit(cobieLiteElement.getFrequency(),
						FREQUENCY_PROPERTY_NAME, FREQUENCY_PROPERTY_NAME,cobieLiteElement.getFrequencyUnit(),
						IfcUnitEnum.TIMEUNIT);
		
		return frequencyProperty;
	}




	private IfcProperty durationPropertyFromTask(JobType cobieLiteElement)
	{
		IfcProperty durationProperty =
				PropertyUtility.propertyFromCOBieString(cobieLiteElement.getDuration(),
						DURATION_PROPERTY_NAME, DURATION_PROPERTY_NAME);
		if(!COBieUtility.isNA(cobieLiteElement.getDurationUnit()))
		{
			TimeUnitSearch timeUnitSearch =
					new TimeUnitSearch(cobieLiteElement.getDurationUnit());
			IfcUnit timeUnit = timeUnitSearch.getMatchedUnit();
			PropertyUtility.attachUnitToProperty(durationProperty, timeUnit);
		}
		return durationProperty;
	}

	@Override
	protected void intializeAndAddRelationshipsToModel(IfcTask ifcObject,
			JobType cobieLiteElement) throws Exception
	{
		addAssignsToProcessRelationships(ifcObject,cobieLiteElement);
		addTaskSequenceRelation(ifcObject,cobieLiteElement);
		
	}
	
	private void addAssignsToProcessRelationships(IfcTask task, JobType job)
	{
		IfcTypeObject matchedType =
				getMatchedType(job.getTypeName());
		ArrayList<IfcConstructionEquipmentResource> resources =
				getMatchedResources(job.getResourceNames());
		if (matchedType!=null || resources.size()>0)
		{
			try
			{
				IfcRelAssignsToProcess relAssignsToProcess = 
						initializeRelAssignsToProcess(task, job);
				if(matchedType!=null)
					relAssignsToProcess.getRelatedObjects().add(matchedType);
				for(IfcConstructionEquipmentResource resource:resources)
					relAssignsToProcess.getRelatedObjects().add(resource);
				model.add(relAssignsToProcess,ifcCommonHandler.getOidProvider());
			}
			catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	private IfcTypeObject getMatchedType(String typeName)
	{
		IfcTypeObject matchedType = null;
		if (model.containsType(typeName))
			matchedType = (IfcTypeObject) model.get(model.getTypeOid(typeName));
		return matchedType;
	}
	
	private ArrayList<IfcConstructionEquipmentResource> getMatchedResources(String resourceString)
	{
		ArrayList<IfcConstructionEquipmentResource> resources =
				new ArrayList<IfcConstructionEquipmentResource>();
		if(resourceString.contains(COBieUtility.getCOBieDelim()))
		{
			ArrayList<String> resourceSplitStrings = 
					COBieUtility.arrayListFromDelimString(resourceString);
			for(String resourceName:resourceSplitStrings)
			{
				try
				{
					long resourceOid =
							model.getResourceOid(resourceName);
						IfcConstructionEquipmentResource constructionEquipmentResource =
								(IfcConstructionEquipmentResource) model.get(resourceOid);
						resources.add(constructionEquipmentResource);
				}
				catch(Exception ex)
				{
					
				}
			}
		}
		else
		{
			if(model.containsResource(resourceString))
			{
				try
				{
					long resourceOid =
						model.getResourceOid(resourceString);
					IfcConstructionEquipmentResource constructionEquipmentResource =
							(IfcConstructionEquipmentResource) model.get(resourceOid);
					resources.add(constructionEquipmentResource);
				}
				catch(Exception ex)
				{
					
				}
				
			}
		}
		return resources;
	}
	
	
	private IfcRelAssignsToProcess initializeRelAssignsToProcess(IfcTask ifcObject,JobType job) throws Exception
	{
		IfcRelAssignsToProcess relAssignsToProcess = null;
		try
		{
				relAssignsToProcess =
						Ifc2x3tc1Factory.eINSTANCE.createIfcRelAssignsToProcess();
				String relationshipName = getRelAssignsToProcessName(ifcObject);
				relAssignsToProcess.setName(relationshipName);
				relAssignsToProcess.setDescription(relationshipName);
				relAssignsToProcess.setGlobalId(ifcCommonHandler.getGuidHandler().newGuid());
				relAssignsToProcess.setOwnerHistory(ifcObject.getOwnerHistory());
				relAssignsToProcess.setRelatingProcess(ifcObject);
				relAssignsToProcess.setRelatedObjectsType(DEFAULT_RELASSIGNSTOPROCESS_RELATEDOBJECTTYPE);
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw ex;
		}
		return relAssignsToProcess;
		
	}
	
	private void addTaskSequenceRelation(IfcTask task,JobType job) throws Exception
	{
		String priorJobId = job.getPriors();
		if (!job.getTaskNumber().equals(priorJobId) && model.containsType(job.getTypeName()))
		{

			IfcTypeObject matchingType = (IfcTypeObject) model.get(model.getTypeOid(job.getTypeName()));
			IfcTask priorTask = getPriorTask(job, priorJobId);
			if (priorTask!=null)
				addPredecessorRelation(task, matchingType, priorTask);
		}
	}


	private void addPredecessorRelation(IfcTask task,
			IfcTypeObject matchingType, IfcTask priorTask)
	{
		
		IfcRelSequence predecessorRelation =
				Ifc2x3tc1Factory.eINSTANCE.createIfcRelSequence();
		predecessorRelation.setSequenceType(IfcSequenceEnum.FINISH_START);
		predecessorRelation.setTimeLag(0);
		predecessorRelation.setRelatedProcess(task);
		predecessorRelation.setRelatingProcess(priorTask);
		predecessorRelation.setName(getRelatesSequenceName(priorTask,task,matchingType));
		predecessorRelation.setGlobalId(ifcCommonHandler.getGuidHandler().newGuid());
		predecessorRelation.setOwnerHistory(task.getOwnerHistory());
		model.add(predecessorRelation,ifcCommonHandler.getOidProvider());
	}
	


	private IfcTask getPriorTask(JobType job, String priorJobId)
	{
		JobType clonedJob =
				(JobType) job.copy();
		IfcTask priorTask = null;
		clonedJob.setTaskNumber(priorJobId);
		if(model.containsJob(clonedJob))
		{
			long taskOid =
					model.getJobOid(clonedJob);
			 priorTask =
					(IfcTask) model.get(taskOid);
		}
		return priorTask;
	}

	@Override
	protected boolean cobieLiteElementIsInModel(JobType cobieLiteElement)
	{
		// TODO Auto-generated method stub
		return model.containsJob(cobieLiteElement);
	}


	@Override
	protected long addObjectToModel(IfcTask ifcObject,JobType cobieLiteElement)
	{
		// TODO Auto-generated method stub
		return model.addJob(ifcObject, cobieLiteElement, ifcCommonHandler);
	}
	
	private String getRelAssignsToProcessName(IfcTask ifcObject)
	{
		return String.format(ASSIGNS_TO_PROCESS_FORMAT_STRING, ifcObject.getName(),ifcObject.getTaskId());
	}
	
	private String getRelatesSequenceName(IfcTask task1,IfcTask task2,IfcTypeObject typeObject)
	{
		return String.format(SEQUENCE_RELATION_FORMAT_STRING, task1.getName(),task1.getTaskId(),task2.getName(),task2.getTaskId(),typeObject.getName());
	}
}
