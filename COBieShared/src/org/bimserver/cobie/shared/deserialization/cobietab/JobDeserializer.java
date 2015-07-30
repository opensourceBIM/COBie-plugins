package org.bimserver.cobie.shared.deserialization.cobietab;

import java.util.ArrayList;
import java.util.Arrays;

import org.bimserver.cobie.shared.deserialization.cobietab.modelhandlers.IfcCommonHandler;
import org.bimserver.cobie.shared.deserialization.cobietab.modelhandlers.PropertySetHandler;
import org.bimserver.cobie.shared.deserialization.cobietab.propertysets.PropertyUtility;
import org.bimserver.cobie.shared.unit.time.TimeUnitSearch;
import org.bimserver.cobie.shared.utility.COBieUtility;
import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.IfcConstructionEquipmentResource;
import org.bimserver.models.ifc2x3tc1.IfcObjectTypeEnum;
import org.bimserver.models.ifc2x3tc1.IfcProperty;
import org.bimserver.models.ifc2x3tc1.IfcPropertySet;
import org.bimserver.models.ifc2x3tc1.IfcRelAssignsToProcess;
import org.bimserver.models.ifc2x3tc1.IfcRelSequence;
import org.bimserver.models.ifc2x3tc1.IfcSequenceEnum;
import org.bimserver.models.ifc2x3tc1.IfcTask;
import org.bimserver.models.ifc2x3tc1.IfcTypeObject;
import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;
import org.nibs.cobie.tab.COBIEType;
import org.nibs.cobie.tab.COBIEType.Jobs;
import org.nibs.cobie.tab.JobType;


/**
 * JobDeserializer parses through each JobType object in COBIEType.Jobs and adds
 * IfcTask entities and related properties and relationships to the model Job
 * elements or attributes are mapped to Ifc entities as follows: Name:
 * IfcTask.Name CreatedBy: IfcOwnerHistory attached to IfcTask CreatedOn:
 * IfcOwnerHistory attached to IfcTask Category: IfcTask.ObjectType Status:
 * IfcTask.Status TypeName: IfcRelAssignsToProcess where IfcTask is relating
 * process and IfcType is in relatedObjects Description: IfcTask.Description
 * Duration: IfcProperty with name "TaskDuration" in property set
 * "pset_COBie_Job" DurationUnit: IfcUnit attached to Duration Start:
 * IfcProperty with name "TaskStartDate" in property set "pset_COBie_Job"
 * TaskStartUnit: ? Frequency: IfcProperty with name "TaskInterval" in property
 * set "pset_COBie_Job" FrequencyUnit: IfcUnit related to Frequency ExtSystem:
 * IfcOwnerHistory attached to IfcTask ExtObject: n/a ExtIdentifier:
 * IfcTask.GlobalId TaskNumber: IfcTask.TaskId Priors:
 * IfcTask.IsSuccsessorFrom.RelatingProcess with matching name,type, and TaskId
 * ResourceNames: IfcRelAssignsToProcess.RelatedObjects (ResourceNames is a
 * comma delimitted list of matching Resources)
 */
public class JobDeserializer extends ComplexDeserializer<COBIEType.Jobs, JobType, IfcTask>
{
    private static final IfcObjectTypeEnum DEFAULT_RELASSIGNSTOPROCESS_RELATEDOBJECTTYPE = IfcObjectTypeEnum.PRODUCT;
    private final String ASSIGNS_TO_PROCESS_FORMAT_STRING = "Relationship from Task %s %s to a Type and Resources";
    private final String SEQUENCE_RELATION_FORMAT_STRING = "Temporal relationship between Task %s %s and Task %s %s for Type %s";
    private final String DURATION_PROPERTY_NAME = "TaskDuration";
    private final String START_PROPERTY_NAME = "TaskStartDate";
    private final String FREQUENCY_PROPERTY_NAME = "TaskInterval";
    private final String JOB_PROPERTY_SET_NAME = String.format(PropertySetHandler.fs_COBiePropertySetName, COBieUtility.CobieSheetName.Job.name());

    /**
     * Instantiates a new job deserializer.
     * 
     * @param model
     *            the model
     * @param ifcCommonHandler
     *            the ifc common handler for guids, oids, property sets, and
     *            classification references
     * @param jobs
     *            COBie jobs
     */
    public JobDeserializer(COBieIfcModel model, IfcCommonHandler ifcCommonHandler, COBIEType.Jobs jobs)
    {
        super(ifcCommonHandler, model, jobs);
    }

    private void addAssignsToProcessRelationships(IfcTask task, JobType job) throws Exception
    {
        IfcTypeObject matchedType = getMatchedType(job.getTypeName());
        ArrayList<IfcConstructionEquipmentResource> resources = getMatchedResources(job.getResourceNames());
        if ((matchedType != null) || (resources.size() > 0))
        {

            IfcRelAssignsToProcess relAssignsToProcess = initializeRelAssignsToProcess(task, job);
            if (matchedType != null)
            {
                relAssignsToProcess.getRelatedObjects().add(matchedType);
            }
            for (IfcConstructionEquipmentResource resource : resources)
            {
                relAssignsToProcess.getRelatedObjects().add(resource);
            }
            getModel().add(relAssignsToProcess, getIfcCommonHandler().getOidProvider());

        }

    }

    private void addPredecessorRelation(IfcTask task, IfcTypeObject matchingType, IfcTask priorTask) throws IfcModelInterfaceException
    {

        IfcRelSequence predecessorRelation = Ifc2x3tc1Factory.eINSTANCE.createIfcRelSequence();
        predecessorRelation.setSequenceType(IfcSequenceEnum.FINISH_START);
        predecessorRelation.setTimeLag(0);
        predecessorRelation.setRelatedProcess(task);
        predecessorRelation.setRelatingProcess(priorTask);
        predecessorRelation.setName(getRelatesSequenceName(priorTask, task, matchingType));
        predecessorRelation.setGlobalId(getIfcCommonHandler().getGuidHandler().newGuid().getWrappedValue());
        predecessorRelation.setOwnerHistory(task.getOwnerHistory());
        getModel().add(predecessorRelation, getIfcCommonHandler().getOidProvider());
    }

    private void addTaskSequenceRelation(IfcTask task, JobType job) throws Exception
    {
        String priorJobId = job.getPriors();
        if (!job.getTaskNumber().equals(priorJobId) && getModel().containsType(job.getTypeName()))
        {

            IfcTypeObject matchingType = (IfcTypeObject)getModel().get(getModel().getTypeOid(job.getTypeName()));
            IfcTask priorTask = getPriorTask(job, priorJobId);
            if (priorTask != null)
            {
                addPredecessorRelation(task, matchingType, priorTask);
            }
        }
    }

    @Override
    protected boolean cobieSheetXMLDataElementIsInModel(JobType cobieSheetXMLDataElement)
    {
        return getModel().containsJob(cobieSheetXMLDataElement);
    }

    @SuppressWarnings("deprecation")
	@Override
    protected Iterable<JobType> cobieSheetXMLDataSectionIterableFromCOBieSheetXMLDataSection(Jobs cobieSheetXMLDataSection)
    {
        return new ArrayList<JobType>(Arrays.asList(cobieSheetXMLDataSection.getJobArray()));
    }

    private IfcProperty durationPropertyFromTask(JobType cobieSheetXMLDataElement)
    {
        IfcProperty durationProperty = PropertyUtility.propertyFromCOBieString(cobieSheetXMLDataElement.getDuration(), DURATION_PROPERTY_NAME,
                DURATION_PROPERTY_NAME);
        if (!COBieUtility.isNA(cobieSheetXMLDataElement.getDurationUnit()))
        {
            TimeUnitSearch timeUnitSearch = new TimeUnitSearch(cobieSheetXMLDataElement.getDurationUnit());
            IfcUnit timeUnit = timeUnitSearch.getMatchedUnit();
            PropertyUtility.attachUnitToProperty(durationProperty, timeUnit);
        }
        return durationProperty;
    }

    private IfcProperty frequencyPropertyFromClass(JobType cobieSheetXMLDataElement)
    {
        IfcProperty frequencyProperty = PropertyUtility.propertyFromCOBieStringAndUnit(cobieSheetXMLDataElement.getFrequency(),
                FREQUENCY_PROPERTY_NAME, FREQUENCY_PROPERTY_NAME, cobieSheetXMLDataElement.getFrequencyUnit(), IfcUnitEnum.TIMEUNIT);

        return frequencyProperty;
    }

    private ArrayList<IfcConstructionEquipmentResource> getMatchedResources(String resourceString)
    {
        ArrayList<IfcConstructionEquipmentResource> resources = new ArrayList<IfcConstructionEquipmentResource>();
        if (resourceString.contains(COBieUtility.getCOBieDelim()))
        {
            ArrayList<String> resourceSplitStrings = COBieUtility.arrayListFromDelimString(resourceString);
            for (String resourceName : resourceSplitStrings)
            {
                try
                {
                    long resourceOid = getModel().getResourceOid(resourceName);
                    IfcConstructionEquipmentResource constructionEquipmentResource = (IfcConstructionEquipmentResource)getModel().get(resourceOid);
                    resources.add(constructionEquipmentResource);
                } catch (Exception ex)
                {

                }
            }
        } else
        {
            if (getModel().containsResource(resourceString))
            {
                try
                {
                    long resourceOid = getModel().getResourceOid(resourceString);
                    IfcConstructionEquipmentResource constructionEquipmentResource = (IfcConstructionEquipmentResource)getModel().get(resourceOid);
                    resources.add(constructionEquipmentResource);
                } catch (Exception ex)
                {

                }

            }
        }
        return resources;
    }

    private IfcTypeObject getMatchedType(String typeName)
    {
        IfcTypeObject matchedType = null;
        if (getModel().containsType(typeName))
        {
            matchedType = (IfcTypeObject)getModel().get(getModel().getTypeOid(typeName));
        }
        return matchedType;
    }

    private IfcTask getPriorTask(JobType job, String priorJobId)
    {
        JobType clonedJob = (JobType)job.copy();
        IfcTask priorTask = null;
        clonedJob.setTaskNumber(priorJobId);
        if (getModel().containsJob(clonedJob))
        {
            long taskOid = getModel().getJobOid(clonedJob);
            priorTask = (IfcTask)getModel().get(taskOid);
        }
        return priorTask;
    }

    private String getRelAssignsToProcessName(IfcTask ifcObject)
    {
        return String.format(ASSIGNS_TO_PROCESS_FORMAT_STRING, ifcObject.getName(), ifcObject.getTaskId());
    }

    private String getRelatesSequenceName(IfcTask task1, IfcTask task2, IfcTypeObject typeObject)
    {
        return String.format(SEQUENCE_RELATION_FORMAT_STRING, task1.getName(), task1.getTaskId(), task2.getName(), task2.getTaskId(),
                typeObject.getName());
    }

    @Override
    protected IfcTask initializeIfcFromCOBieSheetXMLData(JobType cobieElement) throws DeserializerException
    {
        try
        {
            JobType job = cobieElement;
            IfcTask task = Ifc2x3tc1Factory.eINSTANCE.createIfcTask();
            task.setName(job.getName());
            task.setDescription(job.getDescription());
            task.setGlobalId(getIfcCommonHandler().getGuidHandler().guidFromExternalIdentifier(job.getExtIdentifier()).getWrappedValue());
            task.setOwnerHistory(getIfcCommonHandler().getOwnerHistoryHandler().ownerHistoryFromEmailTimestampAndApplication(job.getCreatedBy(),
                    job.getCreatedOn(), cobieElement.getExtSystem()));
            task.setObjectType(job.getCategory());
            task.setStatus(job.getStatus());
            task.setTaskId(job.getTaskNumber());
            return task;
        } catch (Exception ex)
        {
            throw new DeserializerException(ex);
        }
    }

    private IfcRelAssignsToProcess initializeRelAssignsToProcess(IfcTask ifcObject, JobType job) throws Exception
    {
        IfcRelAssignsToProcess relAssignsToProcess = null;
        try
        {
            relAssignsToProcess = Ifc2x3tc1Factory.eINSTANCE.createIfcRelAssignsToProcess();
            String relationshipName = getRelAssignsToProcessName(ifcObject);
            relAssignsToProcess.setName(relationshipName);
            relAssignsToProcess.setDescription(relationshipName);
            relAssignsToProcess.setGlobalId(getIfcCommonHandler().getGuidHandler().newGuid().getWrappedValue());
            relAssignsToProcess.setOwnerHistory(ifcObject.getOwnerHistory());
            relAssignsToProcess.setRelatingProcess(ifcObject);
            relAssignsToProcess.setRelatedObjectsType(DEFAULT_RELASSIGNSTOPROCESS_RELATEDOBJECTTYPE);

        } catch (Exception ex)
        {
            ex.printStackTrace();
            throw ex;
        }
        return relAssignsToProcess;

    }

    private IfcProperty startPropertyFromTask(JobType cobieSheetXMLDataElement)
    {
        IfcProperty taskStartProperty = PropertyUtility.propertyFromCOBieStringAndUnit(cobieSheetXMLDataElement.getStart(), START_PROPERTY_NAME,
                START_PROPERTY_NAME, cobieSheetXMLDataElement.getTaskStartUnit(), IfcUnitEnum.TIMEUNIT);
        return taskStartProperty;
    }

    @Override
    protected void writeClassifications(IfcTask ifcObject, JobType cobieSheetXMLDataElement)
    {
        // Do nothing, no classification objects are attached according to COBie
    }

    @Override
    protected long writeIfcObject(IfcTask ifcObject, JobType cobieSheetXMLDataElement) throws IfcModelInterfaceException
    {
        return getModel().addJob(ifcObject, cobieSheetXMLDataElement, getIfcCommonHandler());
    }

    @Override
    protected void writePropertySets(IfcTask ifcObject, JobType cobieSheetXMLDataElement) throws DeserializerException
    {
        try
        {
            IfcPropertySet jobProperties = Ifc2x3tc1Factory.eINSTANCE.createIfcPropertySet();
            jobProperties.setName(JOB_PROPERTY_SET_NAME);
            jobProperties.setDescription(JOB_PROPERTY_SET_NAME);
            jobProperties.setGlobalId(getIfcCommonHandler().getGuidHandler().newGuid().getWrappedValue());
            jobProperties.setOwnerHistory(getIfcCommonHandler().getOwnerHistoryHandler().ownerHistoryFromEmailTimestampAndApplication(
                    cobieSheetXMLDataElement.getCreatedBy(), cobieSheetXMLDataElement.getCreatedOn(), cobieSheetXMLDataElement.getExtSystem()));
            IfcProperty durationProperty = durationPropertyFromTask(cobieSheetXMLDataElement);
            IfcProperty frequencyProperty = frequencyPropertyFromClass(cobieSheetXMLDataElement);
            IfcProperty taskStartProperty = startPropertyFromTask(cobieSheetXMLDataElement);
            jobProperties.getHasProperties().add(durationProperty);
            jobProperties.getHasProperties().add(frequencyProperty);
            jobProperties.getHasProperties().add(taskStartProperty);
            getIfcCommonHandler().getPropertySetHandler().addPropertiesAndPropertySetToObject(ifcObject, jobProperties, true);
        } catch (Exception e)
        {
            throw new DeserializerException(e);
        }

    }

    @Override
    protected void writeRelationships(IfcTask ifcObject, JobType cobieSheetXMLDataElement) throws DeserializerException
    {
        try
        {
            addAssignsToProcessRelationships(ifcObject, cobieSheetXMLDataElement);
            addTaskSequenceRelation(ifcObject, cobieSheetXMLDataElement);
        } catch (Exception e)
        {
            throw new DeserializerException(e);
        }

    }
}
